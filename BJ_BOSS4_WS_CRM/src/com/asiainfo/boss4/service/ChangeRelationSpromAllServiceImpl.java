package com.asiainfo.boss4.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.BusinessDao;
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

/**
 * 亲情号码类业务服务实现类
 * 统一操作IUserSprom、IUserRelationo数据
 * @author xiaopeng
 */
public class ChangeRelationSpromAllServiceImpl implements BusinessService{

	private static Log logger = LogFactory.getLog(ChangeRelationSpromAllServiceImpl.class);
	
	private BusinessDao businessDao;
	private ChangeComboDao changeComboDao;
	private ChangeRelationUserDao changeRelationUserDao;

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
		OneOpreateConfig config =  OperateConfiguration.getConfigByTranCode(tranCode);
		//更新标志串  UP_FIELD 
		UpFieldUtil.setUpField(vo);
		// 设置消息编号，一个交易(item)拥有同一个消息编号
		Object sid = businessDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses());
		
		int j = 0;
		if (OperateType.ADD.getTypeCode().equals(operType)) {
			Long soidSeq = businessDao.getSoidSequence();
			for (int i = 0; i < entityList.size(); i++) {
				Object entity = entityList.get(i);
				businessDao.add(entity);
			}
		}
		else if(OperateType.CANCEL.getTypeCode().equals(operType)){
			for (int i = 0; i < entityList.size(); i++) {
				Object entity = entityList.get(i);
				Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
				// 取配置的查询条件
				String[] conditions = config.getConditionCols(entityClass.getName());
				
				if (ISaleOper.class.equals(EntityPartitionHelper.getOriginalClassForPartition(entity))) {
					businessDao.add(entity);
				}
				else if (IUserSprom.class.equals(EntityPartitionHelper.getOriginalClassForPartition(entity))) {
					IUserSprom queryIUserSprom = (IUserSprom) entity;
					List queryList = changeComboDao.querySpromEntityList(entity);
					
					if (queryList.size() == 0) {// 该套餐不存在
						throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
					} else if (queryList.size() > 1) {// 存在多条数据
						throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR);
					}
					IUserSprom iUserSprom = (IUserSprom) queryList.get(0);
					
					queryIUserSprom.setSoId(iUserSprom.getSoId());
					businessDao.backup(queryIUserSprom, conditions);
					
					//设置报文中的soNbr，用于撤单
					iUserSprom.setSoNbr(queryIUserSprom.getSoNbr());
					iUserSprom.setExpireDate(queryIUserSprom.getExpireDate());
					changeComboDao.update(iUserSprom);
				}
				else if (IUserRelation.class.equals(EntityPartitionHelper.getOriginalClassForPartition(entity))) {
					IUserRelation queryIUserRelation = (IUserRelation) entity;
					IUserRelation iUserRelation = changeRelationUserDao.queryRelationUser(queryIUserRelation);
					
					//取消前备份数据（使用查询到的soId）
					queryIUserRelation.setSoId(iUserRelation.getSoId());
					changeRelationUserDao.backup(queryIUserRelation, conditions);
					
					iUserRelation.setSoNbr(queryIUserRelation.getSoNbr());
					iUserRelation.setExpireDate(queryIUserRelation.getExpireDate());
					this.changeComboDao.update(iUserRelation);
				}
			}
		}
		else {
			logger.error("没有匹配的操作类型");
			throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
		}
		return null;
	}

	public BusinessDao getBusinessDao() {
		return businessDao;
	}

	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}

	public ChangeComboDao getChangeComboDao() {
		return changeComboDao;
	}

	public void setChangeComboDao(ChangeComboDao changeComboDao) {
		this.changeComboDao = changeComboDao;
	}

	public ChangeRelationUserDao getChangeRelationUserDao() {
		return changeRelationUserDao;
	}

	public void setChangeRelationUserDao(ChangeRelationUserDao changeRelationUserDao) {
		this.changeRelationUserDao = changeRelationUserDao;
	}
}
