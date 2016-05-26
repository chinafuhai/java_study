package com.asiainfo.boss4.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.BaseDao;
import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.dao.IAccBusiCreditDao;
import com.asiainfo.boss4.domain.AccBalance;
import com.asiainfo.boss4.domain.CrmAccount;
import com.asiainfo.boss4.domain.CrmCustomer;
import com.asiainfo.boss4.domain.CrmUser;
import com.asiainfo.boss4.domain.CrmUserOther;
import com.asiainfo.boss4.domain.IAccBusiCredit;
import com.asiainfo.boss4.domain.IAccount;
import com.asiainfo.boss4.domain.ICustomer;
import com.asiainfo.boss4.domain.IMsisdnVsCust;
import com.asiainfo.boss4.domain.IUser;
import com.asiainfo.boss4.domain.IUserStatus;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.BrandType;
import com.asiainfo.boss4.support.BusinessHelper;
import com.asiainfo.boss4.support.DataValiditionHelper;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.StringHelper;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.UpFieldUtil;
import com.asiainfo.boss4.support.annotation.AddOnly;
/**
 * 开户服务实现
 * 
 * @author caohui
 *
 */
public class OpenAccountServiceImpl implements BusinessService {
	private Log logger = LogFactory.getLog(OpenAccountServiceImpl.class);

	private BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	private BusinessDao businessDao;

	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}
	
	private IAccBusiCreditDao iAccBusiCreditDao;

	public void setiAccBusiCreditDao(IAccBusiCreditDao iAccBusiCreditDao) {
		this.iAccBusiCreditDao = iAccBusiCreditDao;
	}

	public String process(LazyDynaMap vo, Map requestStatus) {
		String tranCode = vo.get("tranCode").toString();
		
		//设置多账期属性值
		vo.set("cycleProperty", 0);
		vo.set("cycleType", 5);
		vo.set("cycleLength", 1);
		vo.set("cycleEndday", 1);
		vo.set("modifyDate", vo.get("validDate"));
		//设置平衡表账处月起始字段
		Date firstDay = DateHelper.getCurrentMonthFirstDay();
		Date lastDay = DateHelper.getCurrentMonthLastDay();
		vo.set("minBeginDate", firstDay);
		vo.set("cycleEndDate", lastDay);

		// 检查传入数据
		Set<String> paramNames = new HashSet<String>();
		paramNames.add("custId");
		paramNames.add("acctId");
		paramNames.add("msisdn");
		DataValiditionHelper.checkInputVo(vo, paramNames);
		
		// 如果存在相同的手机号，但serv_id不同，终止开户，防止出现同时生效的两个手机号码
		IUser u = businessDao.queryIUserAllByPhoneNumber((String) vo.get("msisdn"));
		if (u != null && !u.getServId().toString().equals((String) vo.get("servId"))) {
			throw new BossException(StatusCode.NOT_EXIST_USER_ERROR, "手机号 "+vo.get("msisdn").toString()+" 在系统中已经存在，且serv_id与转入值不同");
		}
		
		// 取此交易需要操作的实体类
		OneOpreateConfig config =  OperateConfiguration.getConfigByTranCode(tranCode);
		
		// 更新UP_FIELD标志串
		UpFieldUtil.setUpField(vo);
		
		// 设置消息编号，一个交易(item)拥有同一个消息编号
		Object sid = businessDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);

		// 取当前数据库时间
		Date currentDate = businessDao.queryCurrentDate();

		// 映射imsi字段值至sphoneId字段
		String imsi = (String) vo.get("imsi");
		if (imsi == null) {
			logger.warn("传入imsi为空");
//			throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR);
		} else {
			vo.set("sphoneId", imsi);
			logger.debug("映射imsi字段值[" + imsi + "]至sphoneId字段");
		}
		
		// 计算工单编号 so_nbr
		Long crmSoNbr = BusinessHelper.generateCrmSoNbr(vo, currentDate);
		
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses());
		
		//是否更新cust
		boolean updateCust = false;
		boolean existedAccount = false;
		for (int i = 0; i < entityList.size(); i++) {
			Object entity = entityList.get(i);
			
			String[] constraints = config.getConditionCols(EntityPartitionHelper.getOriginalClassForPartition(entity).getName());
			
			// 处理CRM表
			if (StringHelper.isClassWithCrmPrefix(entity.getClass())) {
				
				// 为crm三户表插入计算后的工单编号(soNbr)
				BusinessHelper.setSoNbrForCrmEntity(entity, crmSoNbr);
				
				// 处理用户
				if (CrmUser.class.equals(entity.getClass())) {
					DataValiditionHelper.checkInputVo(vo, "servId");
					CrmUser user = businessDao.queryCrmUserByServId( ((CrmUser)entity).getServId() );
					CrmUserOther userOther = businessDao.queryCrmUserOtherByServId( ((CrmUser)entity).getServId() );
					
					// 业务延续型转户用户必须存在
					if (user == null && TranCode.BUSI_KEEP_TRAN_TRANSFER_ACCOUNT.getTranCode().equals(tranCode)) {
						throw new BossException(StatusCode.NOT_EXIST_USER_ERROR, "指定的用户不存在，业务延续型转户不允许新建用户");
					}
					
					if (user != null && vo.get("acctId").equals(user.getAcctId().toString())
							&& vo.get("custId").equals(user.getCustId().toString()) ) {// 用户已经存在，则跳过
						logger.debug("用户(crm_user)已经存在");
						continue;
					} else if (user != null) {// 用户已经存在，但acct_id和cust_id与传入的不同，则更新
						logger.debug("用户(crm_user)已经存在，需要更新acct_id和cust_id");
						businessDao.changeWithMergeCrm(entity, constraints, currentDate);
						continue;
					} else if (user == null && userOther != null) {// crm_user不存在，但crm_user_other存在，则move至crm_user表，更新cust_id和acct_id
						logger.debug("用户(crm_user)不存在，但crm_user_other表存在数据，将此数据移回crm_user");
						businessDao.backup(userOther, constraints, "Other", false);
						businessDao.remove(userOther, constraints);
						businessDao.changeWithMergeCrm(entity, constraints, currentDate);
						continue;
					}
				}
				
				// 客户已经存在则跳过
				if (CrmCustomer.class.equals(entity.getClass()) 
						&& businessDao.queryCrmCustomerByCustId( ((CrmCustomer)entity).getCustId() ) != null) {
					logger.debug("用户(crm_customer)已经存在");
					continue;
				}
				
				// 账户已经存在则更新状态
				if (CrmAccount.class.equals(entity.getClass())) {
					CrmAccount acct = businessDao.queryCrmAccountByAcctId( ((CrmAccount)entity).getAcctId() );
					if (acct != null && acct.getSts().equals( ((CrmAccount)entity).getSts() )) {// 状态一致则忽略
						logger.debug("账户(crm_account)已经存在");
						existedAccount = true;
						continue;
					} else if (acct != null) {// 更新状态
						logger.debug("账户(crm_account)已经存在，需要更新状态");
						businessDao.changeWithMergeCrm(entity, constraints, currentDate);
						existedAccount = true;
						continue;
					}
				}
				
				businessDao.add(entity);
			}
			
			// 处理非CRM表
			if (!StringHelper.isClassWithCrmPrefix(entity.getClass())) {
				
				Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
				
				// 处理用户
				if (IUser.class.equals(entityClass)) {
					
					IUser user = (IUser) businessDao.getEntity(entity, constraints);
					
					// 业务延续型转户用户必须存在
					if (user == null && TranCode.BUSI_KEEP_TRAN_TRANSFER_ACCOUNT.getTranCode().equals(tranCode)) {
						throw new BossException(StatusCode.NOT_EXIST_USER_ERROR, "指定的用户不存在，业务延续型转户不允许新建用户");
					}
					
					if (user != null && vo.get("acctId").equals(user.getAcctId().toString())
							&& vo.get("custId").equals(user.getCustId().toString()) ) {// 用户已经存在，则跳过
						logger.debug("用户(i_user)已经存在");
						continue;
					} else if (user != null) {// 用户已经存在，但acct_id和cust_id与传入的不同，则更新
						logger.debug("用户(i_user)已经存在，需要更新acct_id和cust_id");
						businessDao.backup(entity, constraints);
						businessDao.changeWithMerge(entity, constraints, currentDate);
						updateCust = true;
						continue;
					} else {
						businessDao.add(entity);
						continue;
					}
					
				}
				
				// 客户\账户已经存在则跳过
				if ( ( ICustomer.class.equals(entityClass) 
							|| IAccount.class.equals(entityClass) )
							&& businessDao.getEntity(entity, constraints) != null ) {
					
					if (logger.isDebugEnabled() && ICustomer.class.equals(entityClass) ) {
						logger.debug("客户(i_customer)已经存在");
					}
					
					if (logger.isDebugEnabled() && IAccount.class.equals(entityClass) ) {
						logger.debug("账户(i_account)已经存在");
					}
					
					if (IAccount.class.equals(entityClass)) {
						existedAccount = true;
					}
					
					continue;
					
				} else if (ICustomer.class.equals(entityClass) 
							|| IAccount.class.equals(entityClass)) {
					
					businessDao.add(entity);
					continue;
				}

				// 账务平衡表记录
				if ( AccBalance.class.equals(entityClass) 
						&& businessDao.getEntity(entity, constraints) != null) {
					
					/*
					 * 如果账户不存在，则更新账务平衡表
					 * 因为之前存在的账户平衡表记录很可能是垃圾记录
					 */
					if (!existedAccount) {
						businessDao.change(entity, constraints);
						logger.debug("账户不存在，更新已存在的acc_balance");
					} else {
						logger.debug("账户已存在，忽略已存在的acc_balance");
					}
					continue;
					
				} else if ( AccBalance.class.equals(entityClass) ) {
					
					businessDao.add(entity);
					continue;
				}
				
				// 信用度表记录存在，需要删除再新建
				if ( IAccBusiCredit.class.equals(entityClass) ) {
//					List credit = businessDao.queryEntityList(entity, constraints);
//					
//					if (credit != null && credit.size() != 0) {
//						
//						businessDao.backupAutoSuffix(entity, constraints);
//						businessDao.remove(entity, constraints);
//						businessDao.flush();
//						businessDao.add(entity);
//						continue;
//					} else {
//						
//						businessDao.add(entity);
//						continue;
//					}
					businessDao.backupAutoSuffix(entity, constraints);
					//用户为个人后付费品牌，且该账户下拥有多个用户，需要分解信用度由100为101,102
					if (BrandType.getBrandType(vo).isIndividualAfterPayBrand() 
							&& iAccBusiCreditDao.existedIUserByAcctId( ((IAccBusiCredit) entity).getAcctId() ) > 1) {
						iAccBusiCreditDao.detachToMultiIAccBusiCredit((IAccBusiCredit) entity);
					} else {
						iAccBusiCreditDao.mergeToOneIAccBusiCredit((IAccBusiCredit) entity);
					}
					continue;
				}

				// 用户状态表记录已经存在，先备份旧数据，然后失效旧数据，插入新数据
				if ( IUserStatus.class.equals(entityClass)
						&& businessDao.getEntity(entity, constraints) != null) {
					
					businessDao.backup(entity, constraints);
					businessDao.changeWithMerge(entity, constraints, currentDate);
					continue;
				
				} else if ( IUserStatus.class.equals(entityClass) ) {
					
					businessDao.add(entity);
					continue;
				}

				//IMsisdnVsCust表先不处理
				if (IMsisdnVsCust.class.equals(entityClass)) continue;

				// 除上发表以外的其他表记录已经存在，则忽略
				if ( !entityClass.isAnnotationPresent(AddOnly.class)
							&& businessDao.getEntity(entity, constraints) != null) {
					
					continue;
					
				}
				
				businessDao.add(entity);
			}
			
		}
		
		/*
		 * 最后操作IMsisdnVsCust表，entityList从OneOpreateConfig从取出的classes无序，
		 * 这里确保在判断IUser表是否更新custId之后再处理IMsisdnVsCust表
		 */
		for (int i = 0; i < entityList.size(); i++) {
			Object entity = entityList.get(i);

			// 如果IMsisdnVsCust表记录存在，并且IUser表更新了custId，则更新记录
			if (IMsisdnVsCust.class.equals(entity.getClass())) {
				String[] constraints = config.getConditionCols(EntityPartitionHelper.getOriginalClassForPartition(
						entity).getName());
				Object o = businessDao.getEntity(entity, constraints);
				if (o != null) {
					if (updateCust) {
						BeanCopyHelper.copyProperties(o, entity);
						baseDao.update(o);
					}
				} else {
					businessDao.add(entity);
				}
				break;
			}
		}
		
		return null;
	}

}
