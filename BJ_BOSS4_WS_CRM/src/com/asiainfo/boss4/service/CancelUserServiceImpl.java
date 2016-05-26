package com.asiainfo.boss4.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.aspect.ReadjustInputValueAdvice;
import com.asiainfo.boss4.dao.BaseDao;
import com.asiainfo.boss4.dao.CancelUserDao;
import com.asiainfo.boss4.dao.IAccBusiCreditDao;
import com.asiainfo.boss4.domain.AccCcNoPressStop;
import com.asiainfo.boss4.domain.CrmAccount;
import com.asiainfo.boss4.domain.CrmUser;
import com.asiainfo.boss4.domain.IAccBusiCredit;
import com.asiainfo.boss4.domain.IAcctBillCycle;
import com.asiainfo.boss4.domain.ISpromParam;
import com.asiainfo.boss4.domain.IUser;
import com.asiainfo.boss4.domain.IUserBillCycle;
import com.asiainfo.boss4.domain.IUserCell;
import com.asiainfo.boss4.domain.IUserMsc;
import com.asiainfo.boss4.domain.IUserSmsOrder;
import com.asiainfo.boss4.domain.IUserSprom;
import com.asiainfo.boss4.domain.OweNoPressStop;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.BrandType;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.OperateType;
import com.asiainfo.boss4.support.StringHelper;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.UpFieldUtil;
import com.asiainfo.boss4.support.annotation.AddOnly;
/**
 * 销户服务实现类
 * @author caohui
 *
 */
public class CancelUserServiceImpl implements BusinessService{
	
	private static Log logger = LogFactory.getLog(CancelUserServiceImpl.class);
	
	private BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	private CancelUserDao cancelUserDao;

	public void setCancelUserDao(CancelUserDao cancelUserDao) {
		this.cancelUserDao = cancelUserDao;
	}
	
	private IAccBusiCreditDao iAccBusiCreditDao;

	public void setiAccBusiCreditDao(IAccBusiCreditDao iAccBusiCreditDao) {
		this.iAccBusiCreditDao = iAccBusiCreditDao;
	}
	
	private BusinessService chargeNoticeService;

	public void setChargeNoticeService(BusinessService chargeNoticeService) {
		this.chargeNoticeService = chargeNoticeService;
	}

	/**
	 * 查询用户是否有免催免停。
	 * 如果有免催免停，且失效时间在本月6日以后，则忽略，否则延长至6日零时；
	 * 如没有免催免停，则插入免催免停记录。
	 * @param vo
	 * @param requestStatus
	 */
	private void checkOweNoPress(LazyDynaMap vo, Map requestStatus) {
		AccCcNoPressStop entity = (AccCcNoPressStop) BeanCopyHelper.copyToEntity(vo, AccCcNoPressStop.class);
		entity.setExpDate(DateHelper.getCurrentMonthSixthDay());
		entity.setRemark("GOTONE_TO_PAY_AFTER");
		
		AccCcNoPressStop existedEntity = cancelUserDao.queryAccCcNoPressStop(entity);
		if (existedEntity != null && existedEntity.getExpDate().before(entity.getExpDate())) {
			existedEntity.setExpDate(entity.getExpDate());
			existedEntity.setSoNbr(entity.getSoNbr());
			existedEntity.setRemark(entity.getRemark());
			logger.debug("延长免催免停ACC_CC_NO_PRESS_STOP有效期至本月6日");
			return;
		} else if (existedEntity != null) {
			logger.debug("已经存在免催免停ACC_CC_NO_PRESS_STOP，忽略");
			return;
		} else if (existedEntity == null) {
			entity.setServiceId(0);
			entity.setServFlag((byte) 0);
			entity.setCcBusinessTypeId(0);
			entity.setDunmodeId((short) 0);
			entity.setEffDate(DateHelper.getCurrentMonthFirstDay());
			entity.setSpecialFlag((byte) 0);
			entity.setRegionId((short) 100);
			entity.setStaffId(0);
			entity.setOpType((short) 0);
			entity.setOwefeeMax(0L);
			cancelUserDao.add(entity);
			logger.debug("插入免催免停ACC_CC_NO_PRESS_STOP，有效期至本月6日");
		}
	}
	
	public String process(LazyDynaMap vo, Map requestStatus) {
		// 取交易代码
		String tranCode = (String) vo.get("tranCode");
		
		String voServId = (String) vo.get("servId");
		Long userAcctId = null;
		// 如果传入servId为空，则通过手机号码反查servId，并置入vo
		if (voServId == null) {
			String phoneNumber = (String) vo.get("msisdn");
			if (phoneNumber == null) {
				logger.error("未指定手机号码");
				throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR);
			}
			
			IUser user = cancelUserDao.queryIUserByPhoneNumber(phoneNumber);
			if (user == null && TranCode.CHANGE_BRAND_CANCEL_USER.getTranCode().equals(tranCode)) {
				logger.debug("用户不存在，直接返回成功");
				requestStatus.put(AppConstant.REQUEST_STATUS_MAP_IS_BREAK, true);
				return null;
			}
			if (user == null) {
				logger.error("用户不存在");
				throw new BossException(StatusCode.NOT_EXIST_USER_ERROR);
			}
			vo.set("servId", user.getServId().toString());
			if (vo.get("custId") == null) vo.set("custId", user.getCustId().toString());
			if (vo.get("acctId") == null) vo.set("acctId", user.getAcctId().toString());
		} else {
			IUser user = cancelUserDao.existedIUser(voServId, (String) vo.get("userType"));
			if (user == null && TranCode.CHANGE_BRAND_CANCEL_USER.getTranCode().equals(tranCode)) {
				logger.debug("用户不存在，直接返回成功");
				requestStatus.put(AppConstant.REQUEST_STATUS_MAP_IS_BREAK, true);
				return null;
			}
			if (user != null) {
				vo.set("acctId", user.getAcctId().toString());
				vo.set("custId", user.getCustId().toString());
			}
		}
		
		// 取数据库当前时间
		Date currentDate = cancelUserDao.queryCurrentDate();
		
		// 判断tran_code为转品牌销户
		if (TranCode.isChangeBrandCancleUserTranCodes(tranCode)) {
			// 重置 I_SALE_OPER.COMMIT_DATE 为当前时间，防止上发积压误报
			vo.set("iSaleOperCommitDate", DateHelper.Date2String(currentDate));
			
			// 内部互转判断
			if (ReadjustInputValueAdvice.isInnerChangeBrandTranCode(vo)) {
				Integer newBrandType = Integer.valueOf((String) vo.get("brand"));
				IUser user = cancelUserDao.queryIUserByServId(new Long((String) vo.get("servId")));
				if (user.getBrand().equals(newBrandType)) {// 判断是否重复调用
					logger.debug("用户存在，且品牌为目标品牌，直接返回成功");
					requestStatus.put(AppConstant.REQUEST_STATUS_MAP_IS_BREAK, true);
					return null;
				}
				tranCode = TranCode.CHANGE_BRAND_INNER.getTranCode();// 内部互转，tranCode重置为11102
				vo.set("tranCode", tranCode); // 重置vo的tranCode，方便数据库日志记录
				
				//取crm_user.os_sts
				CrmUser crmUser = cancelUserDao.queryCrmUserByServId(Long.valueOf(voServId));
				if (crmUser == null) {
					logger.error("crm_user表中不存在servId为"+voServId+"的用户");
					throw new BossException(StatusCode.NOT_EXIST_USER_ERROR);
				}
				StringBuffer osSts = new StringBuffer(crmUser.getOsSts());
				//需要重置的欠停和生命周期类状态位
				final int[] stopSts = {15,16,21,17,24,16,18,19,20,22,23};
				for (int i : stopSts) {
					osSts.replace(i-1, i, "0");
					logger.debug("0 => crm_user.os_sts["+i+"]");
				}
				//重置欠停和生命周期类状态
				vo.set("crmUserOsSts", osSts.toString());
				vo.set("iUserStatusUserSts", "1");
				logger.debug("1 => i_user_status.user_sts");
				vo.set("iUserStatusAcctSts", "0");
				logger.debug("0 => i_user_status.acct_sts");
				
				//重置账户类型acct_type，后付费1，预付费0
				if (BrandType.isAfterPayBrand(newBrandType)) {
					vo.set("crmAccountAcctType", "1");
					vo.set("iAccountAcctType", "1");
					logger.debug("1 => crm_account.acct_type");
					logger.debug("1 => i_account.acct_type");
				} else {
					vo.set("crmAccountAcctType", "0");
					vo.set("iAccountAcctType", "0");
					logger.debug("0 => crm_account.acct_type");
					logger.debug("0 => i_account.acct_type");
				}
				//重置付费类型pay_type，后付费转预付费重置为1（预付费只有1） 
				vo.set("crmAccountPayType", "1");
				vo.set("iAccountPayType", "1");
				logger.debug("1 => crm_account.pay_type");
				logger.debug("1 => i_account.pay_type");
				
			}

		}
		
		// 取此交易需要操作的实体类
		OneOpreateConfig config =  OperateConfiguration.getConfigByTranCode(tranCode);
		//更新标志串  UP_FIELD 
		vo.set("spromType", AppConstant.ALL_SPROM_TYPE);// 上发全部sprom_type
		UpFieldUtil.setUpField(vo);
		// 设置消息编号，一个交易(item)拥有同一个消息编号
		Object sid = cancelUserDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		
		// 如为神G批量销户业务，则取传入的expireDate字段更新记录的失效时间
		if (TranCode.BATCH_CANCEL_USER_OF_EASYOWN_G.getTranCode().equals(tranCode)) {
			String voExpireDate = (String) vo.get("expireDate");
			if (voExpireDate == null) {
				logger.error("EAI传入expireDate为空");
				throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR);
			}
			currentDate = DateHelper.String2Date(voExpireDate);
		}
		
		// 如果为神G批量销户业务，且EAI传入acctId为空，则主动反查acctId，用来删除IAccBusiCredit
//		if (TranCode.BATCH_CANCEL_USER_OF_EASYOWN_G.getTranCode().equals(tranCode) && vo.get("acctId") == null) {
//			IUser user = cancelUserDao.queryUserByServId((String) vo.get("servId"));
//			if (user == null) {
//				logger.error("用户不存在");
//				throw new BossException(StatusCode.NOT_EXIST_USER_ERROR);
//			}
//			vo.set("acctId", user.getAcctId().toString());
//		}
		
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses());
		
		for (int i = 0; i < entityList.size(); i++) {
			Object entity = entityList.get(i);
			Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
			
			if (entityClass.isAnnotationPresent(AddOnly.class)) {
				cancelUserDao.add(entity);
				continue;
			}
			
			String[] conditions = config.getConditionCols(entityClass.getName());
			
			// 内部互转不同于销户，会配置MODIFY
			if (OperateType.MODIFY.getTypeCode().equals(config.getOperateType(entityClass.getName()))) {
				String[] updateFields = config.getUpdateFields(entityClass.getName());
				if (updateFields ==  null) {
					throw new BossException(StatusCode.INSIDE_ERROR, entityClass.getSimpleName()+"表没有配置updateFields元素");
				}
				
				if (IAccBusiCredit.class.equals(entityClass)) {// i_acc_busi_credit 全球通可能出现多条数据，转出时需要调整为一条，并修改credit_level
					iAccBusiCreditDao.mergeToOneIAccBusiCredit((IAccBusiCredit) entity, false);
				} else if (!StringHelper.isClassWithCrmPrefix(entityClass)) {// 非CRM表
//					// 更新旧数据指定字段，用当月1号零时的时间失效旧数据， 复制并插入一条新数据，新数据生效时间为当月1号零时
//					Date date = DateHelper.getCurrentMonthFirstDay(currentDate);
					cancelUserDao.changeWithMerge(entity, conditions, updateFields, currentDate);
				} else {// CRM表
//					// 更新CrmAccount.creditClass字段
//					if (CrmAccount.class.equals(entityClass)) {
//						CrmAccount account = (CrmAccount) entity;
//						String newBrand = (String) vo.get("newBrand");
//						account.setCreditClass(Short.valueOf(newBrand));
//					}
					// 备份数据
					cancelUserDao.backupCrm(entity, conditions);
					// 更新数据的指定字段
					cancelUserDao.changeCrm(entity, conditions, updateFields);
				}
				continue;
			}
			
			if (CrmUser.class.equals(entityClass)) {// CrmUser表
				// 备份到历史表
				CrmUser originalEntity = (CrmUser) cancelUserDao.backupCrm(entity, conditions);
				// 备份到Other表
//				cancelUserDao.backup(entity, conditions, "Other");
				originalEntity.setUserSts((byte) 0);
				cancelUserDao.addToSuffix(originalEntity, "other", null);
				// 删除数据entity
				cancelUserDao.remove(entity, conditions);
			} else if (CrmAccount.class.equals(entityClass)) {// CrmAccount表
				String[] updateFields = config.getUpdateFields(entityClass.getName());
				// 备份数据
				cancelUserDao.backupCrm(entity, conditions);
				// 更新数据的指定字段
				cancelUserDao.changeCrm(entity, conditions, updateFields);
			} else if (IUserSprom.class.equals(entityClass)
					|| IUserMsc.class.equals(entityClass)
					|| ISpromParam.class.equals(entityClass)
					|| IUserCell.class.equals(entityClass)) {// IUserSprom、IUserMsc和ISpromParam表
				// 备份多条数据
				if (config.isBackup()) cancelUserDao.backupMuti(entity, conditions);
				// 对于IUserSprom、IUserMsc和ISpromParam表，cancelUserDao重写的cancel方法会失效多条数据
				cancelUserDao.cancel(entity, conditions, true, currentDate);
			} else if (IUserBillCycle.class.equals(entityClass) || IAcctBillCycle.class.equals(entityClass)) {// 多账期表
				// 备份历史数据
				if (config.isBackup()) cancelUserDao.backupAutoSuffix(entity, conditions);
				//多账期表下月初失效
				cancelUserDao.cancel(entity, conditions, true, DateHelper.getNextMonthFirstDay(currentDate));
			} else {// 其它表
				// 备份历史数据
				if (config.isBackup()) cancelUserDao.backupAutoSuffix(entity, conditions);
				// 复制一条数据
				if (OperateType.CANCEL_WITH_COPY.getTypeCode().equals(
						config.getOperateType(entityClass.getName()))) {
					cancelUserDao.cancelWithCopyNewData(entity, conditions, currentDate);
				} else if (OperateType.REMOVE.getTypeCode().equals(
						config.getOperateType(entityClass.getName()))) {
					cancelUserDao.remove(entity, conditions);
				} else {
					// 立即失效，用数据库当前时间更新记录
					cancelUserDao.cancel(entity, conditions, true, currentDate);
				}
			}
			cancelUserDao.flush();
		}
		
		if (TranCode.CHANGE_BRAND_INNER.equalByTranCode(tranCode)) {
			//如果为全球通转预付费，需写入免催免停（至当月6号）
			if (BrandType.GOTONE.equals(BrandType.getOldBrandType(vo)) && !BrandType.getNewBrandType(vo).isAfterPayBrand()) {
				checkOweNoPress(vo, requestStatus);
			}
		}
		
		if (!TranCode.CHANGE_BRAND_INNER.equalByTranCode(tranCode)) {
			// 清除短信提醒记录
			logger.debug("clearing IUserSmsOrder.");
			// 查出指定serv_id下的所有短信提醒记录
			Map<String, Object> params = new HashMap<String, Object>(1);
			params.put("servId", new Long((String) vo.get("servId")));
			List<IUserSmsOrder> smsList = cancelUserDao.queryEntitysToList(IUserSmsOrder.class, params);
			
			String[] constraints = new String[] { "servId", "smsOrderType", "operType" };
			for (IUserSmsOrder entity : smsList) {
				if (config.isBackup()) {
					Long soNbr = Long.valueOf((String) vo.get("soNbr"));
					cancelUserDao.backupDeletedRecord(entity, constraints, soNbr);
				}
				cancelUserDao.backup(entity, constraints, "his"); // 备份记录至HIS表
				cancelUserDao.remove(entity, constraints); // 删除记录
			}
		}

		if (!TranCode.CHANGE_BRAND_CANCEL_USER.equalByTranCode(tranCode) && !TranCode.CHANGE_BRAND_INNER.equalByTranCode(tranCode)) {
			// 清除免催免停记录
			logger.debug("clearing OweNoPressStop.");
			// 查出指定serv_id下的免催免停记录
			Map<String, Object> params = new HashMap<String, Object>(1);
			params.put("servId", new Long((String) vo.get("servId")));
			List<OweNoPressStop> oweList = cancelUserDao.queryEntitysToList(OweNoPressStop.class, params);
			
			String[] constraints = new String[] { "servId", "subbusiId", "custId", "acctFlag", "acctId", "servFlag", "sortTypeCode" };
			for (OweNoPressStop entity : oweList) {
				if (config.isBackup()) {
					Long soNbr = Long.valueOf((String) vo.get("soNbr"));
					cancelUserDao.backupDeletedRecord(entity, constraints, soNbr);
				}
				cancelUserDao.backup(entity, constraints, "His"); // 备份记录至HIS表
				cancelUserDao.remove(entity, constraints); // 删除记录
			}
		}

		// 清除全球通话费提醒
		if (TranCode.CHANGE_BRAND_CANCEL_USER.equalByTranCode(tranCode) || TranCode.CHANGE_BRAND_INNER.equalByTranCode(tranCode)) {
			String oldBrand = (String) vo.get("oldBrand");
			String oldPlanId = (String) vo.get("oldPlanId");
			if (oldBrand == null) {
				oldBrand = (String) vo.get("brand");
			}
			if (oldPlanId == null) {
				oldPlanId = (String) vo.get("planId");
			}
			Integer oldBrandType = Integer.valueOf(oldBrand);
			Long oldPlanIdType = Long.valueOf(oldPlanId);
			if (BrandType.GOTONE.equalByBrandAndPlan(oldBrandType, oldPlanIdType)) {
				// 关闭service数据库日志
				requestStatus.put(AppConstant.REQUEST_STATUS_MAP_IS_LOGGING_TO_DB, false);
				// 停止上发ACC_BOOK_CHG_NOTIFY表，后台上发信用度的同时读取CcPlanInstanceRelation
				requestStatus.put(AppConstant.UPLOAD_ACC_BOOK_CHG_NOTIFY, false);
				
				vo.set("tranCode", TranCode.CHARGE_NOTICE.getTranCode());
				Object operType = vo.get("operType");
				vo.set("operType", OperateType.REMOVE.getTypeCode());
				
				chargeNoticeService.process(vo, requestStatus);
				
				// 打开service数据库日志
				requestStatus.put(AppConstant.REQUEST_STATUS_MAP_IS_LOGGING_TO_DB, true);
				// 恢复上发ACC_BOOK_CHG_NOTIFY表，后台上发信用度的同时读取CcPlanInstanceRelation
				requestStatus.put(AppConstant.UPLOAD_ACC_BOOK_CHG_NOTIFY, true);
				//重置为之前的operType值，日志入库
				vo.set("operType", operType);
			}
			
		}
		
		return null;
	}

}
