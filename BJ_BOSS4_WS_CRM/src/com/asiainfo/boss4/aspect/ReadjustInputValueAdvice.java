package com.asiainfo.boss4.aspect;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.LazyDynaBean;
import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

import com.asiainfo.boss4.domain.AccBookChgNotify;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.BrandType;
import com.asiainfo.boss4.support.DataValiditionHelper;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.StringHelper;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.UserType;

/**
 * 调整EAI传入VO设置的切面
 * 
 * @author caohui
 * 
 */
public class ReadjustInputValueAdvice {
	private static Log logger = LogFactory.getLog(ReadjustInputValueAdvice.class);

	/**
	 * 预开户(直接激活)需要插入免催免停表记录
	 * 设置zg.owe_no_press_stop表的字段值
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	public Object openAccountWithOweNoPressStop(ProceedingJoinPoint pjp) throws Throwable {

		LazyDynaMap vo = (LazyDynaMap) pjp.getArgs()[0];
		String tranCode = vo.get("tranCode").toString();

		if (TranCode.PRE_OPEN_ACCOUNT_WITH_DIRECT_ACTIVATE.getTranCode().equals(tranCode)) {
			logger.debug("seting acc_cc_no_press_stop's value");
			
			vo.set("accCcNoPressStopServiceId", "0");
			vo.set("accCcNoPressStopServFlag", "1");
			vo.set("accCcNoPressStopCcBusinessTypeId", "0");
			vo.set("accCcNoPressStopDunmodeId", "0");
			vo.set("accCcNoPressStopEffDate", vo.get("validDate"));
			vo.set("accCcNoPressStopExpDate", vo.get("expireDate"));
			vo.set("accCcNoPressStopSpecialFlag", "0");
			vo.set("accCcNoPressStopRegionId", "100");
			vo.set("accCcNoPressStopStaffId", "99999999");
			vo.set("accCcNoPressStopOpDate", vo.get("commitDate"));
			vo.set("accCcNoPressStopIdentityType", "1");
			vo.set("accCcNoPressStopOpType", "1");
			vo.set("accCcNoPressStopOwefeeMax", "0");
			vo.set("accCcNoPressStopOtherSoNbr", "0");
		}

		return pjp.proceed();
	}

	/**
	 * 动感地带退网 设置crm_account的状态字段sts的值
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	public Object changeCrmAccountStsWhenCloseAccount(ProceedingJoinPoint pjp) throws Throwable {

		LazyDynaMap vo = (LazyDynaMap) pjp.getArgs()[0];
		String tranCode = vo.get("tranCode").toString();

		if (TranCode.CANCEL_USER_OF_M_ZONE.getTranCode().equals(tranCode) || TranCode.CANCEL_USER_OF_GROUP.getTranCode().equals(tranCode)) {
			logger.debug("seting crm_account.sts value");

			vo.set("crmAccountSts", "0");
		}

		return pjp.proceed();
	}

	/**
	 * 预开户(直接激活)需要插入免催免停周期表记录
	 * 设置zg.acc_intellnet_user_cycle表的字段值
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	public Object openAccountWithAccIntellnetUserCycle(ProceedingJoinPoint pjp) throws Throwable {
		LazyDynaMap vo = (LazyDynaMap) pjp.getArgs()[0];
		String tranCode = vo.get("tranCode").toString();
		
		if (TranCode.PRE_OPEN_ACCOUNT_WITH_DIRECT_ACTIVATE.getTranCode().equals(tranCode)) {
			logger.debug("seting acc_intellnet_user_cycle's value");
			
			vo.set("accIntellnetUserCycleExpireDate", "2030-1-1 00:00:00");
			vo.set("accIntellnetUserCycleValidDate", vo.get("validDate"));
			vo.set("accIntellnetUserCycleSts", "0");
		}
		
		return pjp.proceed();
	}
	
	/**
	 * 短信订购提醒 指定发送的手机号码
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	public Object smsOrderSendToSpecifiedPhoneNumber(ProceedingJoinPoint pjp) throws Throwable {
		LazyDynaMap vo = (LazyDynaMap) pjp.getArgs()[0];
		String tranCode = vo.get("tranCode").toString();
		
		if (TranCode.COMBO_MESSENGER.getTranCode().equals(tranCode)) {
			logger.debug("如报文中sendPhoneId（发送到不同的手机号码）的值不为空，则取sendPhoneId的值赋给phoneId");
			
			if (vo.get("sendPhoneId") != null) {
				vo.set("phoneId", vo.get("sendPhoneId"));
			}
		}
		
		return pjp.proceed();
	}
	
	/**
	 * 客户资料变更业务重置cust_code
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	public Object updateCustomerOperNotice(ProceedingJoinPoint pjp) throws Throwable {
		LazyDynaMap vo = (LazyDynaMap) pjp.getArgs()[0];
		String tranCode = vo.get("tranCode").toString();
		String custCode = null;
		if (tranCode.equals(TranCode.CHANGE_CUSTOMER.getTranCode())) {
			custCode = (String) vo.get("remark");
		} else {
			custCode = (String) vo.get("iCustomerRemark");
		}
		if (custCode != null) {
			vo.set("iMsisdnVsCustCustCode", custCode);
		}
		return pjp.proceed();
	}
	
	/**
	 * 开户或内部互转业务时更新creditClass、creditLevel字段
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	public Object updateCreditClass(ProceedingJoinPoint pjp) throws Throwable {
		LazyDynaMap vo = (LazyDynaMap) pjp.getArgs()[0];
		String tranCode = vo.get("tranCode").toString();
		if (TranCode.isCreateUserTranCodes(tranCode)) { //开户类业务
			//重置credit
			resetCredit(vo);
		}
		if (TranCode.CHANGE_BRAND_CANCEL_USER.equalByTranCode(tranCode)
				&& this.isInnerChangeBrandTranCode(vo)) { //内部互转

			//重置credit
			resetCredit(vo);
		}
		return pjp.proceed();
	}
	
	/**
	 * 重置creditLevel和creditClass
	 * 根据brand和planId的节点值
	 * @param vo EAI传入参数
	 */
	private void resetCredit(LazyDynaBean vo) {
		
		// 检查brand和planId是否有传入值
		Set<String> paramNames = new HashSet<String>(2);
		paramNames.add("brand");
		paramNames.add("planId");
		DataValiditionHelper.checkInputVo(vo, paramNames);
		
		//取brand和planId
		Integer brand =  Integer.valueOf((String) vo.get("brand"));
		Long planId = Long.valueOf((String) vo.get("planId"));
		
		if (BrandType.EASYOWN_BOSS.equalByBrandAndPlan(brand, planId)) { //预付费-神B信控
			vo.set("creditLevel", "20");
			vo.set("creditClass", brand.toString());
		} else if (BrandType.M_ZONE.equalByBrandAndPlan(brand, planId)) { //预付费-动感地带信控
			vo.set("creditLevel", "21");
			vo.set("creditClass", brand.toString());
		} else if (BrandType.EASYOWN_CT_CARD3.equalByBrand(brand)) { //预付费-畅听卡信控
			vo.set("creditLevel", "22");
			vo.set("creditClass", brand.toString());
		} else if (BrandType.EASYOWN_DZ_CARD.equalByBrand(brand)) { //预付费-家园卡信控
			vo.set("creditLevel", "23");
			vo.set("creditClass", brand.toString());
		} else if (BrandType.TD_XF_CARD.equalByBrand(brand)) { //预付费-TD先锋卡信控
			vo.set("creditLevel", "25");
			vo.set("creditClass", brand.toString());
		} else if (BrandType.TD_SJ_CARD.equalByBrand(brand)) { //预付费-TD数据卡信控
			vo.set("creditLevel", "26");
			vo.set("creditClass", brand.toString());
		} else if (BrandType.G3_XXJ_CARD.equalByBrand(brand)) { //预付费-G3信息机信控
			vo.set("creditLevel", "27");
			vo.set("creditClass", brand.toString());
		} else if (BrandType.G3_YFF_CARD.equalByBrand(brand)) { //预付费-G3预付费卡信控
			vo.set("creditLevel", "28");
			vo.set("creditClass", brand.toString());
		} else if (BrandType.EASYOWN_CT_CARD9.equalByBrand(brand)) { //神州行5元卡（brand=13）
			vo.set("creditLevel", "30");
			vo.set("creditClass", brand.toString());
		} else if (BrandType.ENTERPRISE_GROUP_BEFORE.equalByBrandAndPlan(brand, planId)) { //预付费-集团预付费信控
			vo.set("creditLevel", "29");
			vo.set("creditClass", "201");
		} else if (BrandType.ENTERPRISE_GROUP_AFTER.equalByBrandAndPlan(brand, planId)) { //后付费-集团信控计划
			vo.set("creditLevel", "200");
			vo.set("creditClass", "200");
		} else if (BrandType.GOTONE.equalByBrandAndPlan(brand, planId) || BrandType.E_NET.equalByBrandAndPlan(brand, planId)) { //后付费-个人信控计划 
			vo.set("creditLevel", "100");
			vo.set("creditClass", "100");
		}
	}

	
	/**
	 * 调整VIP级别并级联更新停机级别
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	public Object updateVipLevelAndStopLevel(ProceedingJoinPoint pjp) throws Throwable {
		LazyDynaMap vo = (LazyDynaMap) pjp.getArgs()[0];
		String tranCode = vo.get("tranCode").toString();
		
		String reserved2 = (String) vo.get("crmUserReserved2");
		if (reserved2 == null) {
			reserved2 = (String) vo.get("reserved2");
		}
		
		if (TranCode.CHANGE_VIP_LEVEL.equalByTranCode(tranCode)) { //修改VIP级别业务
			if (reserved2 == null) {
				throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR, "VIP级别reserved2或crmUserReserved2节点不能为空");
			}
			resetStopLevelByVipLevel(vo, reserved2);
		}
		
		if (TranCode.isCreateUserTranCodes(tranCode)) { //开户类业务
			DataValiditionHelper.checkInputVo(vo, "brand");
			if (reserved2 == null || "".equals(reserved2) 
					|| !BrandType.isAfterPayBrand(Integer.valueOf((String) vo.get("brand")))) {//reserved2为空或预付费用户，设置默认值
				vo.set("crmUserReserved2", "0");//未定义枚举值
				vo.set("stopLevel", "0");//未定义枚举值
			} else {
				resetStopLevelByVipLevel(vo, reserved2);
			}
		}
		
		if (TranCode.CHANGE_BRAND_CANCEL_USER.equalByTranCode(tranCode)
				&& this.isInnerChangeBrandTranCode(vo)) { //内部互转业务
			
			//如果为个人后付费品牌，更新VIP级别为“个人普通”（7），并更新对应的停机级别
			if (BrandType.isIndividualAfterPayBrand(Integer.valueOf((String) vo.get("brand")))) {
				vo.set("crmUserReserved2", "7");//个人普通
				vo.set("stopLevel", "1");//普通停机
				resetStopLevelByVipLevel(vo, "7");
			} else {
				vo.set("crmUserReserved2", "0");//未定义枚举值
				vo.set("stopLevel", "0");//未定义枚举值
			}
		}
		
		return pjp.proceed();
	}
	
	/**
	 * 根据"VIP级别"节点值更新"停机级别"节点值
	 * @param vo
	 * @param reserved2
	 */
	public static void resetStopLevelByVipLevel(DynaBean vo, String reserved2) {
		if ("7".equals(reserved2) || "8".equals(reserved2)) {//VIP级别为“个人普通”或“集团普通”
			vo.set("stopLevel", "1");//停机级别调整为“普通停机”
		} else if ("3".equals(reserved2) || "6".equals(reserved2)) {//VIP级别为“个人银卡”或“集团银卡”
			vo.set("stopLevel", "3");//停机级别调整为“延日停机”
		} else if ("1".equals(reserved2) || "2".equals(reserved2) || "4".equals(reserved2) || "5".equals(reserved2)) {//VIP级别为“个人钻卡”，“个人金卡”，“集团钻卡”，或“集团金卡”
			vo.set("stopLevel", "5");//停机级别调整为“延月停机”
		} else if(!"".equals(reserved2)) {//VIP级别为其他非空值
			vo.set("stopLevel", "7");//停机级别调整为“永不停机”
		}
	}
	
	/**
	 * 判断是否为转品牌内部互转服务
	 * 根据oldBrand和newBrand传入节点值判断，如果为内部互转会更新brand和planId节点
	 * @param vo
	 * @return
	 */
	public static boolean isInnerChangeBrandTranCode(LazyDynaBean vo) {
		boolean flag = false;
		
		// 检查brand和planId是否有传入值
		Set<String> paramNames = new HashSet<String>(2);
		paramNames.add("oldBrand");
		paramNames.add("newBrand");
		DataValiditionHelper.checkInputVo(vo, paramNames);
		
		Integer newBrandType = new Integer((String) vo.get("newBrand"));
		Integer oldBrandType = new Integer((String) vo.get("oldBrand"));
		if (BrandType.isBoss4UserBrand(newBrandType) && BrandType.isBoss4UserBrand(oldBrandType)) {// 判断系统是否支持目标品牌
			logger.debug("此业务为内部互转");
			// 设置brand和planId节点
			vo.set("brand", vo.get("newBrand"));
			vo.set("planId", vo.get("newPlanId"));
			flag = true;
		}
			
		return flag;
	}
	
	/**
	 * 开户时更新i_user.user_sts字段为0
	 * 反向批量预开户【预付费集团产品10004】 帐管未激活12，计费未激活11
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	public Object updateUserSts(ProceedingJoinPoint pjp) throws Throwable {
		LazyDynaMap vo = (LazyDynaMap) pjp.getArgs()[0];
		String tranCode = vo.get("tranCode").toString();
		if (TranCode.isCreateUserTranCodes(tranCode)) {
			vo.set("iUserUserSts", "0");
			logger.debug("0 => iUserUserSts");
		}
		if (TranCode.PRE_OPEN_ACCOUNT_11_12.getTranCode().equals(tranCode)) {
			vo.set("crmUserUserSts", "12");
			logger.debug("12 => crmUserUserSts");
			vo.set("iUserStatusUserSts", "11");
			logger.debug("11 => iUserStatusUserSts");
		}
		return pjp.proceed();
	}
	/**
	 * 全球通预开户，携号转品牌转为全球通时，更新CRM_USER.RESERVED4字段的值为Y
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	public Object updateReserved(ProceedingJoinPoint pjp) throws Throwable {
		LazyDynaMap vo = (LazyDynaMap) pjp.getArgs()[0];
		String tranCode = vo.get("tranCode").toString();
		
		//判断开户和内部互转业务
		if (TranCode.isCreateUserTranCodes(tranCode)
				|| (TranCode.CHANGE_BRAND_CANCEL_USER.equalByTranCode(tranCode) && this.isInnerChangeBrandTranCode(vo)) ) {
			
			DataValiditionHelper.checkInputVo(vo, "brand");
			DataValiditionHelper.checkInputVo(vo, "planId");
			
			//判断是否为全球通用户
			if (BrandType.GOTONE.equalByBrandAndPlan((String) vo.get("brand"), (String) vo.get("planId"))) {
				
				vo.set("crmUserReserved4", "Y");
				logger.debug("Y => crm_user.reserved4");
			}
		}
		
		return pjp.proceed();
	}
	
	/**
	 * 更新I_USER.USER_TYPE字段的值
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	public Object updateUserType(ProceedingJoinPoint pjp) throws Throwable {
		LazyDynaMap vo = (LazyDynaMap) pjp.getArgs()[0];
		String tranCode = vo.get("tranCode").toString();
		
		if (TranCode.G3_E_NET_ADD_SPROM.equalByTranCode(tranCode) 
				|| TranCode.ACTIVATE_USER.equalByTranCode(tranCode)
				|| TranCode.PRE_OPEN_ACCOUNT_11_12.equalByTranCode(tranCode)) {
			//10607前台传入userType，不再指定为200
//			vo.set("userType", UserType.G3_E_NET.getCode());
//			logger.debug(UserType.G3_E_NET.getCode() + " => userType");
		} else if (TranCode.isGroupTranCodes(tranCode)) {
			vo.set("userType", UserType.GROUP.getCode());
			logger.debug(UserType.GROUP.getCode() + " => userType");
		} else {
			vo.set("userType", UserType.GENERAL.getCode());
			logger.debug(UserType.GENERAL.getCode() + " => userType");
		}
		
		return pjp.proceed();
	}
	
	/**
	 * 信用度上发数据
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	public Object uploadAccBookChgNotify(ProceedingJoinPoint pjp) throws Throwable {
		LazyDynaMap vo = (LazyDynaMap) pjp.getArgs()[0];
		String tranCode = vo.get("tranCode").toString();
		
		// 如果为复合服务（即多个service组成的tran_code）或只读服务，则忽略，仅针对独立的service中处理vo
		if (TranCode.isComplexTranCodes(tranCode) || TranCode.isReadOlnyTranCode(tranCode)) {
			return pjp.proceed();
		}
		
		// 取此交易需要操作的实体类
		Class[] entityClasses;
		try {
			entityClasses = OperateConfiguration.getConfigByTranCode(tranCode).getClasses();
			// 仅处理包含AccBookChgNotify实体的业务
			if (ArrayUtils.contains(entityClasses, AccBookChgNotify.class)) {
				Date sysdate = new Date();
				vo.set("accBookChgNotifyCreateDate", new SimpleDateFormat(AppConstant.DATE_FORMAT).format(sysdate));
				if (TranCode.CHARGE_NOTICE.equalByTranCode(tranCode)) {
					vo.set("accBookChgNotifyChangeFlag", "12");
				} else {
					vo.set("accBookChgNotifyChangeFlag", "11");
				}
				vo.set("accBookChgNotifySts", "1");
				vo.set("accBookChgNotifySoRegionCode", vo.get("regionCode"));
				vo.set("accBookChgNotifySoMonth", new SimpleDateFormat("yyyyMM").format(sysdate));
				vo.set("accBookChgNotifyMonitType", "0");
				vo.set("accBookChgNotifyMonitSource", "0");
				vo.set("accBookChgNotifyChangeType", "0");
				vo.set("accBookChgNotifyPriority", "0");
				vo.set("accBookChgNotifyServId", "0");
				vo.set("accBookChgNotifySrcDoneCode", "0");
			}
		} catch (Exception e) {
			logger.warn("AOP#uploadAccBookChgNotify: 指定的tran_code在配置文件OperateConfiguration.xml中不存在");
		}
		
		return pjp.proceed();
	}
	
	public Object renameVoPropertys(ProceedingJoinPoint pjp) throws Throwable {
		LazyDynaMap vo = (LazyDynaMap) pjp.getArgs()[0];
		String tranCode = vo.get("tranCode").toString();
		if (TranCode.CHARGE_NOTICE.equalByTranCode(tranCode)) {
			//检查传入参数是否为空
			Set<String> paramNames = new HashSet<String>();
			paramNames.add("servId");
			paramNames.add("validDate");
			paramNames.add("expireDate");
			DataValiditionHelper.checkInputVo(vo, paramNames);
			
			vo.set("instanceId", vo.get("servId"));
			vo.set("effDate", vo.get("validDate"));
			vo.set("expDate", vo.get("expireDate"));
			String createDate = (String) vo.get("createDate");
			if (createDate == null) {
				createDate = (String) vo.get("accBookChgNotifyCreateDate");
			}
			vo.set("optDate", createDate);
			
		}
		if (TranCode.PAY_RELATION.equalByTranCode(tranCode) 
				|| TranCode.PAY_RELATION_CRM_GROUP_MEMBER_ONLY.equalByTranCode(tranCode)) {
			vo.set("doneCode", vo.get("soNbr"));
			vo.set("productId", vo.get("prodId"));
			vo.set("subServId", vo.get("servId"));
			if (vo.get("crmGroupMemberAcctId") == null) {
				vo.set("crmGroupMemberAcctId", vo.get(AppConstant.PAY_RELATION_FLAG_NOTENAME));
			}
			vo.set("stsDate", vo.get("commitDate")==null ? vo.get("beginDate") : vo.get("commitDate"));
		}
		return pjp.proceed();
	}
	
	/**
	 * 当某些字段值的长度超过64个字节时，进行截断处理
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	public Object validateFieldLength(ProceedingJoinPoint pjp) throws Throwable {
		LazyDynaMap vo = (LazyDynaMap) pjp.getArgs()[0];
		List<String> fields = new ArrayList<String>();
		fields.add("iAccount.acctName");
		fields.add("crmAccount.acctName");
		fields.add("crmAccount.postAddr");
		fields.add("crmCustomer.linker");
		final int maxLength = 64;
		
		for (String string : fields) {
			// 实体名
			String entityName = string.substring(0,string.indexOf('.'));
			// 字段名
			String fieldName = string.substring(string.indexOf('.')+1);
			// 实体名+字段名
			String fieldLongName = entityName + StringUtils.capitalize(fieldName);
			// 多实体共用的字段值
			String field = (String) vo.get(fieldName);
			// 指定实体的字段值
			String fieldByLongName = (String) vo.get(fieldLongName);
			
			if (field != null && field.getBytes().length > maxLength) {
				if (fieldByLongName == null || "".equals(fieldByLongName.trim())) {
					vo.set(fieldLongName, StringHelper.leftByByteLength(field, maxLength));
					continue;
				}
			}
			
			if (fieldByLongName != null && fieldByLongName.getBytes().length > maxLength) {
				vo.set(fieldLongName, StringHelper.leftByByteLength(field, maxLength));
				continue;
			}
		}
		
		return pjp.proceed();
	}
	
	/**
	 * 重置所有vo，用于组合service，避免前执行的vo影响到后执行的vo
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	public Object resetAllVOs(ProceedingJoinPoint pjp) throws Throwable {
		LazyDynaMap vo = (LazyDynaMap) pjp.getArgs()[0];
		String tranCode = vo.get("tranCode").toString();
		
		if (!TranCode.isComplexTranCodes(tranCode)) {//不重置组合service本身的VO
			//备份VO
			Map backup = new HashMap(vo.getMap());
			logger.debug(">>backup all VOs...");
			
			//执行service
			Object result = pjp.proceed();
			
			//恢复VO
			vo.setMap(backup);
			logger.debug(">>recover all VOs...");

			return result;
		} else {
			return pjp.proceed();
		}
	}
	
	/**
	 * 用户积分计划
	 * 设置zg.Crm_User_Coin_Order表的字段值
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	public Object updateUserCoin(ProceedingJoinPoint pjp) throws Throwable {

		LazyDynaMap vo = (LazyDynaMap) pjp.getArgs()[0];
		String tranCode = vo.get("tranCode").toString();

		if (TranCode.CRM_USER_COIN_ORDER.getTranCode().equals(tranCode)) {
			logger.debug("seting Crm_User_Coin_Order's value");
			
			vo.set("crmUserCoinOrderCoinOrderType", "1");
			vo.set("crmUserCoinOrderSendDate", vo.get("soDate"));
		}

		return pjp.proceed();
	}
}
