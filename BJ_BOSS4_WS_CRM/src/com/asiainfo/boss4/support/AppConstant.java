package com.asiainfo.boss4.support;

public interface AppConstant {
	// 报文中的日期格式
	static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// CPC报文中的日期格式
	static final String CPC_DATE_FORMAT = "yyyyMMddHHmmss";
	// 延长有效期最多可延长的天数（与当前时间相比）
	static final int MAX_EXTEND_EXPIREDATE_AMOUNT = 720;
	/**
	 * 工单号生成算法：SO_NBR = (SO_NBR_MONTH_BASE * 10000 + YYYY % 100 * 100 + MM) *
	 * 10000000000 + SEQ_SO_NBR.NEXTVAL，对应工单表月份为YYYYMM，SO_NBR_MONTH_BASE
	 * 帐管内部生成目前配置为3，接口层调用配置为2
	 */
	static final String SO_NBR_MONTH_BASE = "2";
	// 普通亲情号码的促销id
	static final Integer GENERAL_RELATION_SPROM_ID = 50001011;
	
	// 超级亲情号码的促销id
	static final Integer SUPER_RELATION_SPROM_ID = 50001010;

	//国际漫游的产品Id
	static final Integer GLOBAL_ROAMING_PROD_ID = 60507200;
	
	//标准套餐产品Id定义前缀
	static final String STANDARD_COMBO_PREFIX = "100000";
	
	// 上发MDB时用来标识上发所有sprom_type
	static final String ALL_SPROM_TYPE = "99";
	
	static final String REQUEST_STATUS_MAP_IS_BREAK = "is_break";
	static final String REQUEST_STATUS_MAP_UPDATE_SOID = "update_soid";
	static final String REQUEST_STATUS_MAP_IS_LOGGING_TO_DB = "is_logging_to_db";
	
	static final String UPLOAD_ACC_BOOK_CHG_NOTIFY = "is_upload_acc_book_chg_notify";
	
	static final String PAY_RELATION_FLAG_NOTENAME = "iUserPayRelationAcctId";

	static final String LIVE_CANCELED_UPFIELD = "live_candled_upfield";
	
	static final String CURRENT_DATE_IN_VO = "__current_date_in_vo";
	
	//套餐信使
	static final String I_USER_SMS_ORDER_TYPE_COMBO_MESSENGER = "1";
	//定时余量提醒
	static final String I_USER_SMS_ORDER_TYPE_TIMING_MARGIN_WARN = "2";
	//阀值余量提醒
	static final String I_USER_SMS_ORDER_TYPE_THRESHOLD_MARGIN_WARN = "3";
	//XML模板中“Y或N”变量的KEY名称
	static final String TEMPLATE_VARIABLE_KEY_Y_OR_N = "_Y_OR_N";
	static final String IN_BUSI_LOG_START_DATE = "2009-10-01 00:00:00";
	
	static final String ERRORNODENAME = "errorValue";
	static final String TRANCODE = "tranCode";
	static final String OPERATETYPE = "theOperateType";
	static final String OPERTYPE = "operType";
	static final String CPCNODENAME = "cpcValue";
	static final String SONBR = "soNbr";
	static final String ROLLBACKSONBR = "rollBackSoNbr";
	static final String SODATE = "soDate";
	static final String CONTEXT = "context";
	static final String INVOICEPAYFEEIN = "invoicePayFeeIn";
	static final String ONETIMEPAYMENTIN = "oneTimePaymentIn";
	
	static final Byte LOAD_PAY_RELATION_ITSELF = new Byte((byte) 99);
	
	//后付费转品牌帐本
	static final String TRANBILLREALTIMEFEE = "82018";
	static final String TRANBILLBOOKITEMFEE = "80803";
	
}
