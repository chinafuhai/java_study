package com.asiainfo.boss4.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.BusinessDaoImpl;
import com.asiainfo.boss4.dao.ChangeComboDao;
import com.asiainfo.boss4.dao.ChangeRelationUserDao;
import com.asiainfo.boss4.domain.ISaleOper;
import com.asiainfo.boss4.domain.IUserRelation;
import com.asiainfo.boss4.domain.IUserSprom;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.OperateType;
import com.asiainfo.boss4.support.UpFieldUtil;

public class ChangeRelationUserServiceImpl implements BusinessService {
	private static Log logger = LogFactory.getLog(ChangeRelationUserServiceImpl.class);
	
	private ChangeRelationUserDao changeRelationUserDao;
	private ChangeComboDao changeComboDao;

	public String process(LazyDynaMap vo, Map requestStatus) {
		// 取交易代码
		String tranCode = (String) vo.get("tranCode");
		
		// 取业务操作类型（新增，取消）
		String operType = (String) vo.get("operType");
		if (operType == null) {
			logger.error("未指定交易的操作类型");
			throw new BossException(StatusCode.NO_INPUT_OPERTYPE_ERROR);
		}
		
		// 取此交易需要操作的实体类
		OneOpreateConfig config = OperateConfiguration.getConfigByTranCode(tranCode);
		//设置UpField标志串
		UpFieldUtil.setUpField(vo);
		// 设置消息编号，一个交易(item)拥有同一个消息编号
		Object sid = changeRelationUserDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses());
		
		
		// 根据业务操作类型进行相应的数据库操作
		if (OperateType.ADD.getTypeCode().equals(operType)) {// 新增
			for (int i = 0; i < entityList.size(); i++) {
				Object entity = entityList.get(i);
				if (ISaleOper.class.equals(EntityPartitionHelper.getOriginalClassForPartition(entity))) {
					changeRelationUserDao.add(entity);
					continue;
				}
				else if (IUserRelation.class.equals(EntityPartitionHelper.getOriginalClassForPartition(entity))) {
					IUserRelation iUserRelation = (IUserRelation) entity;
					
//					iUserRelation.setSoId(this.querySpromSoid(vo));
					
//					Long soidSeq = changeRelationUserDao.getSoidSequence();
//					Long soId = (Long) BeanCopyHelper.getProperty(entity, "soId");
//					BeanCopyHelper.setProperty(entity, "soId", soidSeq*10000+soId);
					changeRelationUserDao.add(iUserRelation);
					continue;
				}
			}
			
		} else if (OperateType.CANCEL.getTypeCode().equals(operType)) {// 取消
			for (int i = 0; i < entityList.size(); i++) {
				Object entity = entityList.get(i);
				if (ISaleOper.class.equals(EntityPartitionHelper.getOriginalClassForPartition(entity))) {
					changeRelationUserDao.add(entity);
					continue;
				}
				else if (IUserRelation.class.equals(EntityPartitionHelper.getOriginalClassForPartition(entity))) {
					
					
					IUserRelation queryIUserRelation = (IUserRelation) entity;
					IUserRelation iUserRelation = changeRelationUserDao.queryRelationUser(queryIUserRelation);
					
					String[] conditions = config.getConditionCols(EntityPartitionHelper.getOriginalClassForPartition(entity).getName());
					
					//取消前备份数据（使用查询到的soId）
					queryIUserRelation.setSoId(iUserRelation.getSoId());
					changeRelationUserDao.backup(queryIUserRelation, conditions);
					
					iUserRelation.setSoNbr(queryIUserRelation.getSoNbr());
					iUserRelation.setExpireDate(queryIUserRelation.getExpireDate());
					this.changeComboDao.update(iUserRelation);
					continue;
				}
			}
			
		} else {
			logger.error("没有匹配的操作类型");
			throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
		}
		
//		changeRelationUserDao.flush();

		return null;
	}
	
	/**
	 * 查询号码对应套餐的soId
	 * @param vo 
	 * @return
	 */
	private Long querySpromSoid(LazyDynaMap vo){
		
		IUserSprom queryIUserSprom = (IUserSprom) BeanCopyHelper.copyToEntity(vo, IUserSprom.class);
		
		List spromList = changeComboDao.querySpromEntityList(queryIUserSprom);
		
		if (spromList.size()==0) {//套餐不存在
			logger.error("号码对应的套餐不存在");
			throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
		}
		else if (spromList.size()>1) {//存在多条数据
			logger.error("存在多条号码对应的套餐");
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR);
		}
		return ((IUserSprom)spromList.get(0)).getSoId();
	}

	public ChangeRelationUserDao getChangeRelationUserDao() {
		return changeRelationUserDao;
	}

	public void setChangeRelationUserDao(ChangeRelationUserDao changeRelationUserDao) {
		this.changeRelationUserDao = changeRelationUserDao;
	}
	
	public ChangeComboDao getChangeComboDao() {
		return changeComboDao;
	}
	
	public void setChangeComboDao(ChangeComboDao changeComboDao) {
		this.changeComboDao = changeComboDao;
	}
}
