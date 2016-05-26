package com.asiainfo.boss4.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.ChangeComboDao;
import com.asiainfo.boss4.dao.ChangeRelationSpromDao;
import com.asiainfo.boss4.dao.ChangeRelationUserDao;
import com.asiainfo.boss4.domain.ISaleOper;
import com.asiainfo.boss4.domain.IUserRelation;
import com.asiainfo.boss4.domain.IUserSprom;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.OperateType;
import com.asiainfo.boss4.support.UpFieldUtil;

public class ChangeRelationSpromServiceImpl implements BusinessService{

	private static Log logger = LogFactory.getLog(ChangeRelationSpromServiceImpl.class);
	
	private ChangeRelationSpromDao changeRelationSpromDao;
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
		Object sid = changeRelationSpromDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses());
		
		int j = 0;
		if (OperateType.ADD.getTypeCode().equals(operType)) {
			for (int i = 0; i < entityList.size(); i++) {
				Object entity = entityList.get(i);
				if (ISaleOper.class.equals(EntityPartitionHelper.getOriginalClassForPartition(entity))) {
					continue;
				}
				else if (IUserSprom.class.equals(EntityPartitionHelper.getOriginalClassForPartition(entity))) {
					IUserSprom iUserSprom = (IUserSprom) entity;
					
					String rservId = null;
					if (AppConstant.SUPER_RELATION_SPROM_ID.equals(iUserSprom.getSpromId())
							||AppConstant.GENERAL_RELATION_SPROM_ID.equals(iUserSprom.getSpromId())){
						//如果是超级或普通亲情号码，取rservId用于更新号码的soId
						rservId = (String) vo.get("iUserRelationRservId");
						if (rservId==null||rservId.equals("")) {
							logger.error("未传入rservId字段值");
							throw new BossException(StatusCode.TABLE_CONFIG_ERROR);
						}
					}
					j = changeRelationSpromDao.insertRelationSprom(iUserSprom, rservId);
				}
			}
		}
		else if(OperateType.CANCEL.getTypeCode().equals(operType)){
			for (int i = 0; i < entityList.size(); i++) {
				Object entity = entityList.get(i);
				if (ISaleOper.class.equals(EntityPartitionHelper.getOriginalClassForPartition(entity))) {
					continue;
				}
				else if (IUserSprom.class.equals(EntityPartitionHelper.getOriginalClassForPartition(entity))) {
					IUserSprom queryIUserSprom = (IUserSprom) entity;
					Integer spromId = queryIUserSprom.getSpromId();
					if (AppConstant.GENERAL_RELATION_SPROM_ID.equals(spromId)) {//普通亲情号码的促销数据
						changeRelationSpromDao.modifyRelationSprom(entity, spromId, null);
						j = 3;
						
					}
					else {//其它亲情号码的促销数据
						
						List queryList = changeComboDao.querySpromEntityList(entity);
						
						if (queryList.size() == 0) {// 该套餐不存在
							throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
						} else if (queryList.size() > 1) {// 存在多条数据
							throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR);
						}
						IUserSprom iUserSprom = (IUserSprom) queryList.get(0);
						
						String[] conditions = config.getConditionCols(EntityPartitionHelper.getOriginalClassForPartition(entity).getName());
						
						queryIUserSprom.setSoId(iUserSprom.getSoId());
						changeRelationSpromDao.backup(queryIUserSprom, conditions);
						
						//设置报文中的soNbr，用于撤单
						iUserSprom.setSoNbr(queryIUserSprom.getSoNbr());
						iUserSprom.setExpireDate(queryIUserSprom.getExpireDate());
						changeComboDao.update(iUserSprom);
						j = 3;
					}
				}
			}
		}
		else {
			logger.error("没有匹配的操作类型");
			throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
		}
		if (j>0) {//写入或更新了促销数据
			for (int i = 0; i < entityList.size(); i++) {
				Object entity = entityList.get(i);
				if (ISaleOper.class.equals(EntityPartitionHelper.getOriginalClassForPartition(entity))) {
					ISaleOper iSaleOper = (ISaleOper) entity;
					if (j==1) {
						//加入IUserRelation的上发位
						iSaleOper.setUpField(UpFieldUtil.modifyUpFieldByClass(iSaleOper.getUpField(), IUserRelation.class));
					}
					changeRelationSpromDao.add(iSaleOper);
				}
			}
		}
		
		return null;
	}
	
	/**
	 * 查询套餐对应号码的soId
	 * @param vo 
	 * @return
	 */
	private Long queryRelationSoid(LazyDynaMap vo){
		
		IUserRelation queryIUserRelation = (IUserRelation) BeanCopyHelper.copyToEntity(vo, IUserRelation.class);
		
		IUserRelation iUserRelation = changeRelationUserDao.queryRelationUser(queryIUserRelation);
		
		return iUserRelation.getSoId();
	}
	
	public ChangeComboDao getChangeComboDao() {
		return changeComboDao;
	}

	public void setChangeComboDao(ChangeComboDao changeComboDao) {
		this.changeComboDao = changeComboDao;
	}

	public ChangeRelationSpromDao getChangeRelationSpromDao() {
		return changeRelationSpromDao;
	}

	public void setChangeRelationSpromDao(
			ChangeRelationSpromDao changeRelationSpromDao) {
		this.changeRelationSpromDao = changeRelationSpromDao;
	}

	public ChangeRelationUserDao getChangeRelationUserDao() {
		return changeRelationUserDao;
	}

	public void setChangeRelationUserDao(ChangeRelationUserDao changeRelationUserDao) {
		this.changeRelationUserDao = changeRelationUserDao;
	}

}
