package com.asiainfo.boss4.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.dao.ChangeSimDao;
import com.asiainfo.boss4.domain.CrmUser;
import com.asiainfo.boss4.domain.IUserSmsOrder;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.BusinessHelper;
import com.asiainfo.boss4.support.DataValiditionHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.OperateType;
import com.asiainfo.boss4.support.StringHelper;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.UpFieldUtil;
import com.asiainfo.boss4.support.annotation.AddOnly;
/**
 * 业务操作类具体实现
 * 用于处理一个业务请求中的单笔交易(item)
 * @author caohui
 *
 */
public class BusinessServiceImpl implements BusinessService {
	private static Log logger = LogFactory.getLog(BusinessServiceImpl.class);
	protected BusinessDao businessDao;
	private ChangeSimDao changeSimDao;
	
	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}

	public void setChangeSimDao(ChangeSimDao changeSimDao) {
		this.changeSimDao = changeSimDao;
	}

	private void crmProcessOfChangeSim(DynaBean vo, Object entity, OneOpreateConfig config) {
		Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
		if (CrmUser.class.equals(entityClass)) {
			CrmUser crmUser = (CrmUser)entity;
			String imsi = (String) vo.get("imsi");
			if (imsi == null) {
				logger.error("传入imsi为空");
				throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR);
			}
			crmUser.setSphoneId(imsi);
			
			String[] conditions = config.getConditionCols(entityClass.getName());
			businessDao.backupCrm(entity,conditions);
			
			changeSimDao.updateCrmUser(crmUser);
		}
	}
	
	/**
	 * 处理上发表
	 * @param vo
	 * @param entity
	 * @param entityClass
	 */
	protected void processEntityWithUpfield(DynaBean vo, Object entity) {
		Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
		if (EntityPartitionHelper.existField(entityClass, "upField")) {
			// 获取配置生成的upfield
			String upField = (String) BeanCopyHelper.getProperty(entity, "upField");
			// 根据实际的表操作生成最终的upfield
			String finallyUpfield = (String) UpFieldUtil.getFinallyUpField(vo, upField);
			if (UpFieldUtil.EMPTY_UPFIELD.equals(finallyUpfield)) {// 最终upfied全空则直接返回，无需上发
				logger.debug("UPFIELD is empty, skip uploading data.");
				return;
			}
			// 更新upfield
			BeanCopyHelper.setProperty(entity, "upField", UpFieldUtil.getFinallyUpField(vo, upField));
		}
		businessDao.add(entity);
	}
	
	/**
	 * 增加实体
	 * @param entity
	 * @param vo
	 * @param config
	 * @param crmSoNbr
	 * @param tranCode
	 */
	protected void addEntitys(Object entity, DynaBean vo, OneOpreateConfig config) {
		Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
		
		// 处理上发表
		if (entityClass.isAnnotationPresent(AddOnly.class)) {
			processEntityWithUpfield(vo, entity);
			return;
		}
		
		// 处理非CRM表
		if (!StringHelper.isClassWithCrmPrefix(entityClass)) {
			businessDao.add(entity);
		}
		
		// 处理CRM表
		if (StringHelper.isClassWithCrmPrefix(entityClass)) {
			BusinessHelper.setSoNbrForCrmEntity(entity, vo);
			String tranCode = (String) vo.get("tranCode");
			if (TranCode.CHANGE_SIM.getTranCode().equals(tranCode)) {
				this.crmProcessOfChangeSim(vo, entity, config);
				return;
			}
			businessDao.add(entity);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void repealAddEntitys(Object entity, DynaBean vo, OneOpreateConfig config) {
		Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
		
		// 处理上发表
		if (entityClass.isAnnotationPresent(AddOnly.class)) {
			processEntityWithUpfield(vo, entity);
			return;
		}

		BusinessHelper.setSoNbrForCrmEntity(entity, vo);
		
		int deleteAmount = businessDao.remove(entity, new String[]{"soNbr"});
		if (deleteAmount == 0) {//如果更新了0条记录，则需要更新upfield，不上发该实体
			UpFieldUtil.setLiveCanceledUpfield(vo, entityClass);
		}
	}
	
	/**
	 * 取消实体
	 * @param entity
	 * @param vo
	 * @param config
	 * @param crmSoNbr
	 * @param tranCode
	 */
	protected void cancelEntitys(Object entity, DynaBean vo, OneOpreateConfig config) {
		Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
		
		// 处理上发表
		if (entityClass.isAnnotationPresent(AddOnly.class)) {
			processEntityWithUpfield(vo, entity);
			return;
		}
		
		// 处理非CRM表
		if (!StringHelper.isClassWithCrmPrefix(entityClass)) {
			String[] conditions = config.getConditionCols(entityClass.getName());
			if (OperateType.REMOVE.getTypeCode().equals(config.getOperateType(entityClass.getName()))) {
				businessDao.remove(entity, conditions);
			} else if (OperateType.MOVE.getTypeCode().equals(config.getOperateType(entityClass.getName())) ) {
				String suffix = "rb";
				if (IUserSmsOrder.class.equals(entityClass)) {
					suffix = "his";
				}
				businessDao.backup(entity, conditions, suffix);
				businessDao.remove(entity, conditions);
			} else {
				if (config.isBackup()) {
					//取消前备份数据
					businessDao.backup(entity, conditions);
				}
				
				businessDao.cancel(entity, conditions);
			}
		}
		
		// 处理CRM表
		if (StringHelper.isClassWithCrmPrefix(entityClass)) {
			BusinessHelper.setSoNbrForCrmEntity(entity, vo);
			// 对于CRM表的取消操作，仅在配置“直接删除”(operate_type=16)时进行处理，除此之外均忽略
			String[] conditions = config.getConditionCols(entityClass.getName());
			if (OperateType.REMOVE.getTypeCode().equals(config.getOperateType(entityClass.getName()))) {
				businessDao.remove(entity, conditions);
			} else if (OperateType.MOVE.getTypeCode().equals(config.getOperateType(entityClass.getName()))) {
				businessDao.backupAutoSuffix(entity, conditions);
				businessDao.remove(entity, conditions);
			} else {
				return;
			}
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void repealCancelEntitys(Object entity, DynaBean vo, OneOpreateConfig config) {
		Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);

		// 处理上发表
		if (entityClass.isAnnotationPresent(AddOnly.class)) {
			processEntityWithUpfield(vo, entity);
			return;
		}
		
		BusinessHelper.setSoNbrForCrmEntity(entity, vo);

		if (OperateType.REMOVE.getTypeCode().equals(config.getOperateType(entityClass.getName()))) {
			UpFieldUtil.setLiveCanceledUpfield(vo, entity);
		} else if (OperateType.MOVE.getTypeCode().equals(config.getOperateType(entityClass.getName()))) {
			List<Object> rows = businessDao.rollbackCancel(entity, false);
			if (rows == null || rows.size() == 0) {
				UpFieldUtil.setLiveCanceledUpfield(vo, entity);
			}
		} else {
			List<Object> rows = businessDao.rollbackCancel(entity, true);
			if (rows == null || rows.size() == 0) {
				UpFieldUtil.setLiveCanceledUpfield(vo, entity);
			}
		}

	}
	
	/**
	 * 修改实体
	 * @param entity
	 * @param vo
	 * @param config
	 * @param crmSoNbr
	 * @param tranCode
	 * @param currentDate
	 */
	@SuppressWarnings("unchecked")
	protected void modifyEntitys(Object entity, DynaBean vo, OneOpreateConfig config, Date currentDate) {
		Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
		
		// 处理上发表
		if (entityClass.isAnnotationPresent(AddOnly.class)) {
			processEntityWithUpfield(vo, entity);
			return;
		}
		
		// 取配置的查询条件
		String[] conditions = config.getConditionCols(entityClass.getName());
		// 取配置的更新字段
		String[] updateFields = config.getUpdateFields(entityClass.getName());
		
		// 处理非CRM表
		if (!StringHelper.isClassWithCrmPrefix(entityClass)) {
			// 如果为上发表，则直接插入实体
			if (entityClass.isAnnotationPresent(AddOnly.class)) {
				businessDao.add(entity);
				return;
			}
			
			if (config.isBackup()) {
				//变更前备份数据
				businessDao.backup(entity, conditions);
			}
			
			if (updateFields == null) {// 更新变更字段
				businessDao.changeWithMerge(entity, conditions, currentDate);
			} else {// 更新指定字段
				businessDao.changeWithMerge(entity, conditions, updateFields, currentDate);
			}
			
		}
		
		// 处理CRM表
		if (StringHelper.isClassWithCrmPrefix(entityClass)) {
			BusinessHelper.setSoNbrForCrmEntity(entity, vo);
			
			String tranCode = (String) vo.get("tranCode");
			if (TranCode.CHANGE_SIM.getTranCode().equals(tranCode)) {
				this.crmProcessOfChangeSim(vo, entity, config);
				return;
			}
			
			
			if (updateFields == null) {// 更新变更字段
				businessDao.changeWithMergeCrm(entity, conditions, currentDate);
			} else {// 更新指定字段
				businessDao.backupCrm(entity, conditions);
				businessDao.changeCrm(entity, conditions, updateFields, true, null);
			}
		}
	}
	
	public String process(LazyDynaMap vo, Map requestStatus) {
		// 取交易代码
		String tranCode = (String) vo.get("tranCode");
		boolean isRepealCode = false;
		String code = TranCode.getTranCodeByRepealCode(tranCode);
		if (code != null) {
			isRepealCode = true;
			//将撤单code重置为正常订单的tranCode，以便加载配置
			vo.set("tranCode", code);
			tranCode = code;
		}
		
		// 取业务操作类型（新增，取消，变更）
		DataValiditionHelper.checkInputVo(vo, "operType");
		String operType = (String) vo.get("operType");
		
		// 取此交易需要操作的实体类
		OneOpreateConfig config = OperateConfiguration.getConfigByTranCode(tranCode);
		//设置UpField标志串
		UpFieldUtil.setUpField(vo);
		// 设置消息编号，一个交易(item)拥有同一个消息编号
		Object sid = businessDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		// 取数据库当前时间
		Date currentDate = businessDao.queryCurrentDate();
		vo.set(AppConstant.CURRENT_DATE_IN_VO, currentDate);
		
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses(vo));
		
		
		// 根据业务操作类型进行相应的数据库操作
		if (OperateType.ADD.getTypeCode().equals(operType) && !isRepealCode) {// 新增
			
			for (int i = 0; i < entityList.size(); i++) {
				Object entity = entityList.get(i);
				addEntitys(entity, vo, config);

			}
		} else if (OperateType.ADD.getTypeCode().equals(operType) && isRepealCode) {// 新增撤单
			
			for (int i = 0; i < entityList.size(); i++) {
				Object entity = entityList.get(i);
				repealAddEntitys(entity, vo, config);

			}
		} else if (OperateType.CANCEL.getTypeCode().equals(operType) && !isRepealCode) {// 取消
			
			for (int i = 0; i < entityList.size(); i++) {
				Object entity = entityList.get(i);
				cancelEntitys(entity, vo, config);

			}
		} else if (OperateType.CANCEL.getTypeCode().equals(operType) && isRepealCode) {// 取消撤单
			
			for (int i = 0; i < entityList.size(); i++) {
				Object entity = entityList.get(i);
				repealCancelEntitys(entity, vo, config);

			}
		} else if (OperateType.MODIFY.getTypeCode().equals(operType)) {// 变更
			
			for (int i = 0; i < entityList.size(); i++) {
				Object entity = entityList.get(i);
				modifyEntitys(entity, vo, config, currentDate);

			}
		} else {
			logger.error("没有匹配的操作类型");
			throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
		}
		
		return null;
	}

}
