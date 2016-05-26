package com.asiainfo.boss4.support;

import java.util.EnumSet;

import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;

/**
 * 交易代码枚举类
 * @author caohui
 *
 */
public enum TranCode {
	//激活（更改用户状态，发开通）
	ACTIVATE_USER("10301"),
	//激活（更改CRM_USER用户状态，发开通，类型：111）
	ACTIVATE_USER_111("10305"),
	//批量预开户(客户端调用)
	//BATCH_OPEN_ACCOUNT("20001"),
	// 预开户
	PRE_OPEN_ACCOUNT("10001"),
	// 预开户(直接激活)
	PRE_OPEN_ACCOUNT_WITH_DIRECT_ACTIVATE("10002"),
	// 非户主转户
	NON_MASTER_TRANSFER_ACCOUNT("10003"),
	//预开户 帐管未激活12，计费未激活11
	PRE_OPEN_ACCOUNT_11_12("10005"),
	//空选空写
	PRE_OPEN_ACCOUNT_EMPTY("10004"),
	// 集团开户
	OPEN_USER_OF_GROUP("11600"),
	// 补换卡
	CHANGE_SIM("10700"),
	// 神B停开机
	OUT_OR_IN_SERVICE("10303"),
	// 神州行G 预开户
	PRE_OPEN_ACCOUNT_OF_EASYOWN_G("10006"),
	// 神州行G 预开户 补套餐
	OPEN_ACCOUNT_SUBSCRIBE_COMBO_OF_EASYOWN_G("10007"),
	// 修改帐户信息
	CHANGE_ACCOUNT("10900"),
	// 修改帐户联系人信息
	CHANGE_ACCOUNT_CONTACT("10905"),
	// 修改用户信息
	CHANGE_USER("10901"),
	// 修改客户信息
	CHANGE_CUSTOMER("10902"),
	// 延日/月停机
	DELAY_STOP_SERVICE("10903"),
	// 品牌转出 月初销户（神B）
	CHANGE_BRAND_CANCEL_USER("11100"),
	// 品牌转出 月初销户（神G）
//	CHANGE_BRAND_CANCEL_USER_OF_EASYOWN_G("11101"),
	// 品牌转出 内部互转
	CHANGE_BRAND_INNER("11102"),
	// 神州行G 批量销户
	BATCH_CANCEL_USER_OF_EASYOWN_G("10801"),
	// 套餐变更
	CHANGE_COMBO("10600"),
	// 手写免费资源
	CHANGE_COMBO_PARAM("10604"),
	// 附加套餐订购
	CHANGE_COMBO_APPEND("10605"),
	// 附加套餐订购（撤单）
	CHANGE_COMBO_APPEND_REPEAL("106051"),
	// 变更参数
	CHANGE_COMBO_PARAM_ONLY("10606"),
	// 信息服务收费提醒
	SMS_CHARGE_REMIND("10403"),
	// 套餐信使
	COMBO_MESSENGER("10408"),
	// 动感地带 退网
	CANCEL_USER_OF_M_ZONE("10800"),
	// 【内部分解】转户-销户操作（保留信用度）
	__CANCEL_USER_OF_TRANSFER("10802"),
	// 集团销户
	CANCEL_USER_OF_GROUP("11610"),
	// 停机记录查询
	QUERY_SUSPEND_RECORD_INFO("30001"),
	// 查询用户信用
	QUERY_SUBSCRIBER_CREDIT("30002"),
	// 查询用户明细信息
	GET_SUBSCRIBER_INFO_DTL("30003"),
	// 查询是否有未来生效的OFFER
	QUERY_IS_EXIST_FUTURE_EFFECTIVE_OFFER("30004"),
	// 提醒短信查询
	QUERY_SMS_SIEBEL("30005"),
	// 提醒短信查询
	QUERY_ORDER("30006"),
	//缴费提醒查询
	QUERY_MAKEFEE("30007"),
	//vip套餐查询
	QUERY_VIPFEE("30008"),
	//欠费风险控制查询
	QUERY_IUSERMONITOR("30011"),
	//用户签约查询
	QUERY_ACC_BATCH_DEDUCT_ORDER("30012"),
	//查询手机游戏充值金额
	QUERY_COST_OF_PHONE_GAME("30013"),
	//查询固移通号段
	QUERY_RAILWAY_HEAD("30014"),
	//查询短信模板内容
	QUERY_ACCSMSTEMPLETDEF("30015"),
	
	//当前用户信息查询接口
	QUERY_IUSER("30016"),
	//当前客户信息查询
	QUERY_ICUSTOMER("30017"),
	//根据custId查询用户
	QUERY_USERLIST("30027"),
	//根据custId查询账户
	QUERY_ACCOUNTLIST("30028"),
	// 当前帐户信息查询
	QUERY_IACCOUNT("30018"),
	//根据acctId查询支付用户
	QUERY_USERPAYRELATIONLIST("30029"),
	//内容计费订购查询
	QUERY_CPC("30019"),
	//营销案订购查询
	QUERY_BOOKSCHEME("30020"),
	// 产品订购
	QUERY_SPROM("30021"),
	//个性化参数查询
	QUERY_SPROMPARAM("30023"),
	//小区优惠查询
	QUERY_CELL("30024"),
	//群组查询
	QUERY_GROUP("30025"),
	//user_relation查询
	QUERY_USERLATION("30026"),
	//当前产品查询
	QUERY_PRODUCT("30022"),
	//用户历史信息查询
	QUERY_USER_HIS("30030"),
	//查询用户订购的年承诺消费
	QUERY_USER_YEAR_PRODUCT("30031"),
	//查询帐处短信模板表
	QUERY_ACCP_SMS_ALARM_MSG("30032"),
	//账户历史信息查询
	QUERY_ACCT_HIS("30033"),
	//客户历史信息查询
	QUERY_CUST_HIS("30034"),
	//数据流量提醒个性化
	QUERY_SMS_JF_MAP("30035"),
	//补差金额查询
	QUERY_USER_COMPENSATINE_TYPE("30036"),
	//银联签约查询
	QUERY_ACC_BATCH_DEDUCT_ORDER_UNIPAY("30037"),
	//家庭网查询
	QUERY_HOME_GROUP("30038"),
	//用户个性化短信查询
	QUERY_USER_SMS_ORDER("30039"),
	//空中充值 和充值卡充值 短信查询
	QUERY_ACC_DEF_SMS_TEMPLET("30040"),
	//0000统一查询和退订功能优化
	QUERY_PROD_OUT_SP("30041"),
	//通知BOSS开始出账
	I_USER_EXTEND("30042"),
	//实现日出账结果的返回
	I_RENT_NOTIFY("30043"),
	//查询高额参数配置
	QUERY_HIGH_FEE_PROC_PARAM("30044"),
	//查询累计高额监控白名单 
	QUERY_HIGH_FEE_NO_PRESS_STOP("30045"),
	//查询 BOSS的商户编号
	QUERY_ACC_POS_HALL_RELATION("30046"),
	//积分业务标价查询
	QUERY_ZCGJ_RENT_T("30047"),
	//流量提醒短信发送量查询
	QUERY_ACC_REMIND_SMS_STAT("30048"),
	//用户群标签查询
	QUERY_ACC_REMIND_USER_LABEL("30049"),
    //通用流量提醒档位查询
    QUERY_THRESHOLD("30050"),
    //查询通用流量某个档位的短信模板配置
    QUERY_ACC_REMIND_SMS_TEMPLET("30051"),
    //专属流量提醒模板查询
    QUERY_FREEBIEID("30052"),
    //最低消费金额查询
    QUERY_MIN_CON_AMOUNT("30053"),
    
	// 查询BOSS4ID
	QUERY_BOSS4_ID("10910"),
	// 查询用户套餐
	QUERY_USER_PRODUCT("10911"),
//	// 【组合服务】集团分账（包含套餐变更）
//	CHANGE_COMBO_AND_PAY_RELATION("11603"),
	// 集团分账
	PAY_RELATION("11603", true),
	// 集团分账(帐管分账)
	PAY_RELATION_CRM_GROUP_MEMBER_ONLY("11613"),
	// 集团入网
	ADD_GROUP_USER("11604"),
	// 取消集团入网
	REMOVE_GROUP_USER("11605"),
	// 【组合服务】增加取消集团业务
	CHANGE_GROUP_BUSI("11602"),
	// 增加取消集团成员
	CHANGE_GROUP_MEMBER("11612"),
	// 【内部分解】增加取消集团业务
	__CHANGE_GROUP_BUSINESS("11602#BUSI"),
	// G3随行卡加套餐（以及撤单）
	G3_E_NET_ADD_SPROM("10607", true),
	// G3随行卡加套餐-撤单
//	G3_E_NET_ADD_SPROM_ROLLBACK("106071"),
	// 【组合服务】全球通、随e行普通转户以及非户主转户
	TRAN_TRANSFER_ACCOUNT("10009"),
	// 业务延续型转户
	BUSI_KEEP_TRAN_TRANSFER_ACCOUNT("10010"),
	// 修改VIP级别
	CHANGE_VIP_LEVEL("10906"),
	// 重置停机级别
	RESET_STOP_LEVEL_BY_VIP_LEVEL("10907"),
	// 全球通费用提醒
	CHARGE_NOTICE("10608"),
	// 【组合服务】修改账户信息并订购话费提醒
	CHANGE_ACCOUNT_INFO_AND_SUBSCRIBE_NOTICE("10904"),
	//用户积分计划
	CRM_USER_COIN_ORDER("11702"),
	CHANGE_SIGN_CONTRACT("11703"),
	SIGN_CONTRACT("11700"),
	UNSIGN_CONTRACT("11701"),
	//新CRM通用交易
	CRM_GENIRAL_ORDER("00000"),
	//新CRM销户
	CRM_GENIRAL_CANCEL_USER("00001"),
	//新CRM过户
	CRM_TRANSFER_ACCOUNT("00002"),
	//统一CENTREX
	CRM_CENTREX("00003"),
	//幸福套餐
	CRM_HAPPY_PRODUCT("00004"),
	//融合V网终端统付产品
	CRM_V_PAYMENT("00005"),
	//流量畅想计划
	CRM_GENIRAL_CANCEL_VUSER("00006"),
	//家庭计划停开机
	CRM_HOME_STOP_RESUME("00007"),
	// 固移通bug需求
	CRM_FIXED_BUG("00008"),
	// 家庭网修复
	REPAIR_HOME_GROUP("00009"),
	// 家庭网拆网取消主卡计费套餐的特殊处理（已经销户导致套餐不存在不会报错）
	DISMISS_HOME_GROUP_CANCEL_SPROM_SPECIAL_HANDLE("00010")
	,
	//批量开户
	BATCH_OPEN_ACCOUNT("00011")
	,
	//统一号显业务成员终端套餐
	CRM_CENTREX_REFERENCE("00012");
	private String tranCode;
	private String repealCode;

	/**
	 * 默认没有对应的repealCode
	 * @param tranCode
	 */
	private TranCode(String tranCode) {
		init(tranCode, false, null);
	}
	
	/**
	 * canRepeal为true，则有repealCode，值为tranCode+"1"；
	 * canRepeal为false，没有repealCode
	 * @param tranCode
	 * @param canRepeal
	 */
	private TranCode(String tranCode, boolean canRepeal) {
		init(tranCode, canRepeal, null);
	}
	
	/**
	 * 当有repealCode，且repealCode值特殊时用此构造方法
	 * 通过入参指定具体的repealCode
	 * @param tranCode
	 * @param repealCode
	 */
	private TranCode(String tranCode, String repealCode) {
		init(tranCode, true, repealCode);
	}
	
	private void init(String tranCode, boolean canRepeal, String repealCode) {
		this.tranCode = tranCode;
		if (canRepeal) {
			if (repealCode == null || "".equals(repealCode) || "1".equals(repealCode)) {
				this.repealCode = tranCode + "1";
			} else {
				this.repealCode = repealCode;
			}
		} else {
			this.repealCode = "";
		}
	}

	public String getTranCode() {
		return tranCode;
	}

	public String getRepealCode() {
		return repealCode;
	}

	/**
	 * 根据tranCode返回TranCode实例
	 * @param tranCode
	 * @return
	 */
	public static TranCode getInstance(String tranCode) {
		EnumSet<TranCode> trans = EnumSet.allOf(TranCode.class);
		for (TranCode tran : trans) {
			if (tran.tranCode.equals(tranCode)) {
				return tran;
			}
		}
		throw new BossException(StatusCode.NO_INPUT_TRANCODE_ERROR);
	}
	
	/**
	 * 根据repealCode查找tranCode，找不到则返回null
	 * @param repealCode
	 * @return
	 */
	public static String getTranCodeByRepealCode(String repealCode) {
		EnumSet<TranCode> trans = EnumSet.allOf(TranCode.class);
		for (TranCode tran : trans) {
			if (tran.repealCode.equals(repealCode)) {
				return tran.getTranCode();
			}
		}
		return null;
	}
	
	//查询类服务（此类业务根据不同模板返回报文）
	private static EnumSet<TranCode> queryTranCodes = null;
	public static EnumSet<TranCode> getQueryTranCodes() {
		if (null == queryTranCodes) {
			queryTranCodes = EnumSet.of(
					// 停机记录查询
					QUERY_SUSPEND_RECORD_INFO,
					// 查询用户信用
					QUERY_SUBSCRIBER_CREDIT,
					// 查询用户明细信息
					GET_SUBSCRIBER_INFO_DTL,
					// 查询是否有未来生效的OFFER
					QUERY_IS_EXIST_FUTURE_EFFECTIVE_OFFER,
					// 提醒短信查询
					QUERY_SMS_SIEBEL,
					// 提醒短信查询
					QUERY_ORDER,
					QUERY_MAKEFEE,
					QUERY_VIPFEE,
					//欠费风险控制查询
					QUERY_IUSERMONITOR,
					////用户签约查询
					QUERY_ACC_BATCH_DEDUCT_ORDER,
					//查询短信模板内容
					QUERY_ACCSMSTEMPLETDEF,
					
					//当前用户信息查询接口
					QUERY_IUSER,
					//当前客户信息查询
					QUERY_ICUSTOMER,
					//根据custId查询用户
					QUERY_USERLIST,
					//根据custId查询账户
					QUERY_ACCOUNTLIST,
					// 当前帐户信息查询
					QUERY_IACCOUNT,
					//根据acctId查询支付用户
					QUERY_USERPAYRELATIONLIST,
					//内容计费订购查询
					QUERY_CPC,
					//营销案订购查询
					QUERY_BOOKSCHEME,
					// 产品订购
					QUERY_SPROM,
					//个性化参数查询
					QUERY_SPROMPARAM,
					//小区优惠查询
					QUERY_CELL,
					//群组查询
					QUERY_GROUP,
					//user_relation查询
					QUERY_USERLATION,
					//当前产品查询
					QUERY_PRODUCT,
					//查询用户订购的年承诺消费
					QUERY_USER_YEAR_PRODUCT,
					//查询帐处短信模板表
					QUERY_ACCP_SMS_ALARM_MSG,
					//数据流量提醒个性化
					QUERY_SMS_JF_MAP,
					//补差金额查询
					QUERY_USER_COMPENSATINE_TYPE,
					//银联签约查询 
					QUERY_ACC_BATCH_DEDUCT_ORDER_UNIPAY,
					//用户个性化短信查询
					QUERY_USER_SMS_ORDER,
					//空中充值 和充值卡充值 短信查询
					QUERY_ACC_DEF_SMS_TEMPLET,
					//0000统一查询和退订功能优化
					QUERY_PROD_OUT_SP,
					//查询高额参数配置
					QUERY_HIGH_FEE_PROC_PARAM,
					//查询累计高额监控白名单 
					QUERY_HIGH_FEE_NO_PRESS_STOP,
					//查询 BOSS的商户编号
					QUERY_ACC_POS_HALL_RELATION
					
			);
		}
		return queryTranCodes;
	}
	
	/**
	 * 是否为查询类服务（此类业务根据不同模板返回报文）
	 * @return
	 * @deprecated
	 */
	public boolean isQueryTranCode() {
	    return getQueryTranCodes().contains(this);
	}
	
	/**
	 * 是否为查询类服务（此类业务根据不同模板返回报文）
	 * @param tranCode
	 * @return
	 */
	public static boolean isQueryTranCode(String tranCode) {
		for (TranCode code : getQueryTranCodes()) {
			if (code.getTranCode().equals(tranCode)) {
				return true;
			}
		}
	    return false;
	}
	
	//只读类服务（包含查询类服务）
	private static EnumSet<TranCode> readOlnyTranCodes = null;
	public static EnumSet<TranCode> getReadOlnyTranCodes() {
		if (null == readOlnyTranCodes) {
			readOlnyTranCodes = EnumSet.of(
					// 停机记录查询
					QUERY_SUSPEND_RECORD_INFO,
					// 查询用户信用
					QUERY_SUBSCRIBER_CREDIT,
					// 查询用户明细信息
					GET_SUBSCRIBER_INFO_DTL,
					// 查询是否有未来生效的OFFER
					QUERY_IS_EXIST_FUTURE_EFFECTIVE_OFFER,
					// 提醒短信查询
					QUERY_SMS_SIEBEL,
					// 提醒短信查询
					QUERY_ORDER,
					// 查询BOSS4ID
					QUERY_BOSS4_ID,
					// 查询用户套餐
					QUERY_USER_PRODUCT);
		}
		return readOlnyTranCodes;
	}
	
	/**
	 * 是否为只读类服务（包含查询类服务）
	 * @param tranCode
	 * @return
	 */
	public static boolean isReadOlnyTranCode(String tranCode) {
		for (TranCode code : getReadOlnyTranCodes()) {
			if (code.getTranCode().equals(tranCode)) {
				return true;
			}
		}
	    return false;
	}
	
	//转品牌类服务（不包含开户）
	private static EnumSet<TranCode> changeBrandCancleUserTranCodes = null;
	public static EnumSet<TranCode> getChangeBrandCancleUserTranCodes() {
		if (null == changeBrandCancleUserTranCodes) {
			changeBrandCancleUserTranCodes = EnumSet.of(CHANGE_BRAND_CANCEL_USER, 
//					CHANGE_BRAND_CANCEL_USER_OF_EASYOWN_G, 
					CHANGE_BRAND_INNER);
		}
		return changeBrandCancleUserTranCodes;
	}
	
	/**
	 * 是否为转品牌类服务（不包含开户）
	 * @param tranCode
	 * @return
	 */
	public static boolean isChangeBrandCancleUserTranCodes(String tranCode) {
		for (TranCode code : getChangeBrandCancleUserTranCodes()) {
			if (code.getTranCode().equals(tranCode)) {
				return true;
			}
		}
	    return false;
	}
	
	//开户类服务
	private static EnumSet<TranCode> createUserTranCodes = null;
	public static EnumSet<TranCode> getCreateUserTranCodes() {
		if (null == createUserTranCodes) {
			createUserTranCodes = EnumSet.of(
					//批量预开户(客户端调用)
					BATCH_OPEN_ACCOUNT,
					//预开户
					PRE_OPEN_ACCOUNT,
					//预开户(直接激活)
					PRE_OPEN_ACCOUNT_WITH_DIRECT_ACTIVATE,
					//非户主转户
//					NON_MASTER_TRANSFER_ACCOUNT,
					//预开户 帐管未激活12，计费未激活11
					PRE_OPEN_ACCOUNT_11_12,
					//空选空写开户
					PRE_OPEN_ACCOUNT_EMPTY,
					//集团开户
					OPEN_USER_OF_GROUP,
					//神州行G 预开户
					PRE_OPEN_ACCOUNT_OF_EASYOWN_G,
					//品牌转出 月初销户（神B）
//					CHANGE_BRAND_CANCEL_USER,
					//全球通、随e行普通转户以及非户主转户
//					TRAN_TRANSFER_ACCOUNT,
					//业务延续型转户
					BUSI_KEEP_TRAN_TRANSFER_ACCOUNT);
		}
		return createUserTranCodes;
	}
	
	/**
	 * 是否为开户类服务
	 * @param tranCode
	 * @return
	 */
	public static boolean isCreateUserTranCodes(String tranCode) {
		for (TranCode code : getCreateUserTranCodes()) {
			if (code.getTranCode().equals(tranCode)) {
				return true;
			}
		}
	    return false;
	}
	
	//集团类服务
	private static EnumSet<TranCode> groupTranCodes = null;
	public static EnumSet<TranCode> getGroupTranCodes() {
		if (null == groupTranCodes) {
			groupTranCodes = EnumSet.of(
					//集团开户
					OPEN_USER_OF_GROUP,
					//集团销户
					CANCEL_USER_OF_GROUP,
					//集团入网
					ADD_GROUP_USER,
					//取消集团入网
					REMOVE_GROUP_USER,
					//增加取消集团业务
					CHANGE_GROUP_BUSI,
					// 增加取消集团成员
					CHANGE_GROUP_MEMBER,
					// 集团分账
					PAY_RELATION,
					// 集团分账(帐管分账)
					PAY_RELATION_CRM_GROUP_MEMBER_ONLY);
		}
		return groupTranCodes;
	}
	
	/**
	 * 集团类服务
	 * @param tranCode
	 * @return
	 */
	public static boolean isGroupTranCodes(String tranCode) {
		for (TranCode code : getGroupTranCodes()) {
			if (code.getTranCode().equals(tranCode)) {
				return true;
			}
		}
	    return false;
	}
	
	//组合类服务
	private static EnumSet<TranCode> complexTranCodes = null;
	public static EnumSet<TranCode> getComplexTranCodes() {
		if (null == complexTranCodes) {
			complexTranCodes = EnumSet.of(
					// 【组合服务】增加取消集团业务
					CHANGE_GROUP_BUSI,
//					// 【组合服务】增加取消集团成员
//					CHANGE_GROUP_MEMBER,
//					// 【组合服务】集团分账（包含套餐变更）
//					CHANGE_COMBO_AND_PAY_RELATION,
					// 【组合服务】全球通、随e行普通转户以及非户主转户
					TRAN_TRANSFER_ACCOUNT,
					// 【组合服务】修改账户信息并订购话费提醒
					CHANGE_ACCOUNT_INFO_AND_SUBSCRIBE_NOTICE);
		}
		return complexTranCodes;
	}
	
	/**
	 * 是否为组合类服务
	 * @param tranCode
	 * @return
	 */
	public static boolean isComplexTranCodes(String tranCode) {
		for (TranCode code : getComplexTranCodes()) {
			if (code.getTranCode().equals(tranCode)) {
				return true;
			}
		}
	    return false;
	}
	
	/**
	 * 判断TranCode是否相等
	 * @param tranCode
	 * @return
	 */
	public boolean equalByTranCode(String tranCode) {
		if (this.tranCode.equals(tranCode) || this.repealCode.equals(tranCode)) {
			return true;
		}
		return false;
	}
}
