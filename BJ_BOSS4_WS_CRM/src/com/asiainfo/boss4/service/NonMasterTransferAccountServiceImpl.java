package com.asiainfo.boss4.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.domain.ISaleOper;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.BusinessHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.OperateType;
import com.asiainfo.boss4.support.StringHelper;
import com.asiainfo.boss4.support.UpFieldUtil;
import com.asiainfo.boss4.support.annotation.AddOnly;

public class NonMasterTransferAccountServiceImpl implements BusinessService {
	private Log logger = LogFactory.getLog(NonMasterTransferAccountServiceImpl.class);

	private BusinessDao businessDao;

	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}
	
	public String process(LazyDynaMap vo, Map requestStatus) {
		// 取交易代码
		String tranCode = (String) vo.get("tranCode");
		
//		// 取业务操作类型（新增，取消，变更）
//		String operType = (String) vo.get("operType");
//		if (operType == null) {
//			logger.error("未指定交易的操作类型");
//			throw new BossException(StatusCode.NO_INPUT_OPERTYPE_ERROR);
//		}
		
//		if (!OperateType.ADD.getTypeCode().equals(operType) && !OperateType.KEEP.getTypeCode().equals(operType)) {
//			throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
//		}
//		tranCode = tranCode+"#"+operType;
//		vo.set("tranCode", tranCode);
		
		// 取此交易需要操作的实体类
		OneOpreateConfig config = OperateConfiguration.getConfigByTranCode(tranCode);
		
		// 更新UP_FIELD标志串
		UpFieldUtil.setUpField(vo);
		
		// 设置消息编号，一个交易(item)拥有同一个消息编号
		Object sid = businessDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		
		Date currentDate = businessDao.queryCurrentDate();
		// 计算工单编号 so_nbr
		Long crmSoNbr = BusinessHelper.generateCrmSoNbr(vo, currentDate);
		
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses());
		
		
		for (int i = 0; i < entityList.size(); i++) {
			Object entity = entityList.get(i);
			
			Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
			
			// 处理非CRM表
			if (!StringHelper.isClassWithCrmPrefix(entityClass)) {
				if (entityClass.isAnnotationPresent(AddOnly.class)) {
					businessDao.add(entity);
					continue;
				}
				
				String[] conditions = config.getConditionCols(entityClass.getName());
				String[] updateFieldNames = config.getUpdateFields(entityClass.getName());
				
				if (OperateType.MODIFY.getTypeCode().equals(config.getOperateType(entityClass.getName()))) {
					businessDao.changeWithMerge(entity, conditions, updateFieldNames, currentDate);
					continue;
				}
				
				Object pEntity = businessDao.getEntity(entity, conditions);
				if (pEntity != null && updateFieldNames == null) {// 存在记录，但没有配置需要更新的字段
					businessDao.changeWithMerge(entity, conditions, currentDate);
				} else if (pEntity != null && updateFieldNames != null) {// 存在记录，且配置了需要更新的字段
					businessDao.changeWithMerge(entity, conditions, updateFieldNames, currentDate);
				} else {
					businessDao.add(entity);
				}
			}
			
			// 处理CRM表
			if (StringHelper.isClassWithCrmPrefix(entityClass)) {
				// 为crm三户表插入计算后的工单编号(soNbr)
				BusinessHelper.setSoNbrForCrmEntity(entity, crmSoNbr);
				
				String[] conditions = config.getConditionCols(entityClass.getName());
				String[] updateFieldNames = config.getUpdateFields(entityClass.getName());
				
				if (OperateType.MODIFY.getTypeCode().equals(config.getOperateType(entityClass.getName()))) {
					businessDao.backupCrm(entity,conditions);
					businessDao.changeCrm(entity, conditions, updateFieldNames);
					continue;
				}
				
				Object pEntity = businessDao.getEntity(entity, conditions);
				if (pEntity != null && updateFieldNames == null) {// 存在记录，但没有配置需要更新的字段
					businessDao.changeWithMergeCrm(entity, conditions, currentDate);
				} else if (pEntity != null && updateFieldNames != null) {// 存在记录，且配置了需要更新的字段
					businessDao.backupCrm(entity,conditions);
					businessDao.changeCrm(entity, conditions, updateFieldNames);
				} else {
					businessDao.add(entity);
				}
				
			}
		}
		
		return null;
	}

}
