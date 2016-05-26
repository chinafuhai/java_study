package com.asiainfo.boss4.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.OpenAccountRepealDao;
import com.asiainfo.boss4.domain.AccBalance;
import com.asiainfo.boss4.domain.CrmAccount;
import com.asiainfo.boss4.domain.CrmCustomer;
import com.asiainfo.boss4.domain.CrmUser;
import com.asiainfo.boss4.domain.CrmUserHis;
import com.asiainfo.boss4.domain.IAccBusiCredit;
import com.asiainfo.boss4.domain.IAccount;
import com.asiainfo.boss4.domain.IUser;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.BusinessHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.StringHelper;
import com.asiainfo.boss4.support.UpFieldUtil;
import com.asiainfo.boss4.support.annotation.AddOnly;

/**
 * 开户撤单服务类
 * @author xiaopeng
 */
public class OpenAccountRepealServiceImpl implements BusinessService{
	
	private static Log logger = LogFactory.getLog(RepealChangeBrandServiceImpl.class);
	
	private OpenAccountRepealDao openAccountRepealDao;

	public String process(LazyDynaMap vo, Map requestStatus) {
		// 取交易代码
		String tranCode = (String) vo.get("tranCode");
		
		// 取此交易需要操作的实体类
		OneOpreateConfig config =  OperateConfiguration.getConfigByTranCode(tranCode);
		//更新标志串  UP_FIELD 
		UpFieldUtil.setUpField(vo);
		// 设置消息编号，一个交易(item)拥有同一个消息编号
		Object sid = openAccountRepealDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		
		// 取当前数据库时间
		Date currentDate = openAccountRepealDao.queryCurrentDate();
		
		// 计算工单编号 so_nbr
		Long crmSoNbr = BusinessHelper.generateCrmSoNbr(vo, currentDate);
		
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses());
		
		//取此次撤单操作的servId
		Long servId = Long.valueOf(vo.get("servId").toString());
		
		for (int i = 0; i < entityList.size(); i++) {
			Object entity = entityList.get(i);
			
			// 处理非CRM表
			if (!StringHelper.isClassWithCrmPrefix(entity.getClass())) {
				Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
				if (entityClass.isAnnotationPresent(AddOnly.class)) {//上发通知表
					openAccountRepealDao.add(entity);
				}
				else if (IUser.class.equals(EntityPartitionHelper.getOriginalClassForPartition(entity))) {//I_USER表
					//查询要撤单的数据是否存在
					List list = openAccountRepealDao.queryBySoNbr(entity);
					if (list.size()<1) {
						continue;
					}
					//新增或（失效旧数据，新增新数据）的撤单
					openAccountRepealDao.rollback(entity);
				}
				else if (IAccount.class.equals(EntityPartitionHelper.getOriginalClassForPartition(entity))) {//I_ACCOUNT表
					//查询要撤单的数据是否存在
					List list = openAccountRepealDao.queryBySoNbr(entity);
					if (list.size()<1) {
						continue;
					}
					else if (!openAccountRepealDao.checkOtherUser(servId, list.get(0))) {//如果没有其他用户使用该账户
						//新增的撤单
						openAccountRepealDao.rollback(entity);
					}
				}
				else if (AccBalance.class.equals(EntityPartitionHelper.getOriginalClassForPartition(entity)) ){
					//AccBalance未备份历史；
					continue;
				}
				else if (IAccBusiCredit.class.equals(EntityPartitionHelper.getOriginalClassForPartition(entity))){
					openAccountRepealDao.rollbackCancel(entity, true, new String[]{"servId","acctId"});
					continue;
				}
				else {//其它表，开户时有数据则跳过，无数据做新增操作
					//查询要撤单的数据是否存在
					List list = openAccountRepealDao.queryBySoNbr(entity);
					if (list.size()<1) {
						continue;
					}
					else {
//						//新增的撤单
						openAccountRepealDao.rollback(entity);
					} 
				}
			}
			// 处理CRM表(CRM没有分表，不对entity作类判断)
			else {
				// 为crm三户表插入计算后的工单编号(soNbr)
				BusinessHelper.setSoNbrForCrmEntity(entity, crmSoNbr);
				
				if (CrmUser.class.equals(entity.getClass())) {//CRM_USER表
					CrmUserHis crmUserHis = openAccountRepealDao.queryCrmUserHisByPsoNbr(((CrmUser)entity).getSoNbr());
					if (crmUserHis != null) {
						//从历史表回滚到CrmUserOther表
						openAccountRepealDao.rollbackToOther(crmUserHis);
					}
					//从CrmUser表中删除新增的数据
					openAccountRepealDao.removeBySoNbr(entity);
				}
				else if (CrmAccount.class.equals(entity.getClass())) {//CRM_ACCOUNT表
					//查询要撤单的数据是否存在
					List list = openAccountRepealDao.queryBySoNbr(entity);
					if (list.size() == 0) {
						//开户时未写CRM_ACCOUNT数据
						continue;
					}
					else if (list.size() > 1) {
						logger.error("根据撤单soNbr查询到多条CRM_ACCOUNT数据");
						throw new BossException(StatusCode.QUERY_ENTITY_ERROR);
					}
					if (!openAccountRepealDao.checkOtherUser(servId, entity)) {//如果没有其他用户使用该账户
						//新增或变更状态的撤单
						openAccountRepealDao.rollbackCrmAccount(entity);
					}
				}
				else if (CrmCustomer.class.equals(entity.getClass())) {//CRM_CUSTOMER表
					//新增的撤单
//					openAccountRepealDao.removeBySoNbr(entity);
					continue;
				}
			}
		}
		
		return null;
	}

	public OpenAccountRepealDao getOpenAccountRepealDao() {
		return openAccountRepealDao;
	}

	public void setOpenAccountRepealDao(OpenAccountRepealDao openAccountRepealDao) {
		this.openAccountRepealDao = openAccountRepealDao;
	}

}
