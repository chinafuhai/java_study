package com.asiainfo.boss4.exception;


/**
 * 系统异常状态枚举类
 * 
 * @author caohui
 *
 */
public enum StatusCode {

	SUCCESS("000000", "成功"),
	SUCCESSBUTNOTPAYMENT("111111", "资料成功，但是充值失败"),
	SUCCESSBUTNOTACTIVEUSER("111112", "资料成功，充值成功，但是激活用户失败"),
	SUCCESSBUTNOTONETIMEPAYMENT("222222", "资料成功，但是营销方案失败"),
	SUCCESSPAYMENTBUTNOTONETIMEPAYMENT("333333", "资料、充值 成功，但是营销方案失败"),
	SUCCESSBUTNOTTRANBILL("444444", "资料成功，但是资金转移失败"),
	ROLLBACK_ENTITY_NONE("100006","没有需要回滚的数据"),
	ROLLBACK_ENTITY_ERROR("10007","业务不支持回滚"),
	MSISDN_IS_USING("10008","计费号码已经被使用!"),
	IRENTNOTIFYFAIL("10009", "用户出账失败，请重试。"),
	CRMDELAYLIMITISNULL("10010", "crm超时参数为空，请检查报文crmDelayLimit"),
	MODIFY_ENTITY_ERROR("10011","业务不支持更新"),
	INSIDE_ERROR("999999","系统内部错误"),
	NOT_EXIST_ANNOTATION_ERROR("900001","指定的注释配置不存在"),
	NOT_EXIST_CLASS_ERROR("900002","指定的类不存在"),
	LOADING_CONFIG_ERROR("900003","加载配置出错"),
	CONFIG_NOT_FIND_ERROR("900004","无法找到配置信息"),
	ILLEGAL_ENUMERATION_ERROR("900005","非法的枚举错误"),
	SOME_BUSI_OF_BATCH_ERROR("900006","批量业务处理中的一笔或多笔业务失败"),
	PM_SP_OPERATOR_CODE_ERROR("900007","CP.PM_SP_OPERATOR_CODE中无配置数据"),
	MODIFY_ENTITY_SMS_TEMPLET_ERROR("900008","指定生效期内存在priority相同的记录"),

	DB_OPERATION_ERROR("100000","数据库操作错误"),
	QUERY_ENTITY_ERROR("100001","无法从数据库加载指定的实体，符合条件的数据可能不存在或多于一条，请检查约束条件"),
	QUERY_ENTITY_NONE_ERROR("100002","符合条件的数据库记录不存在"),
	QUERY_ENTITY_MANY_ERROR("100003","符合条件的数据库记录多于一条"),
	QUERY_ENTITY_VALUE_ERROR("100004","查询出的数据与期待值不符"),
	QUERY_ENTITY_EXISTED_ERROR("100005","期望插入的数据在表中已经存在"),
	
	CALL_OBD_SERVICE_ERROR("100104", "调用OBD Service时出错"),
	
	/******************************** CPC 异常状态码 ********************************/
	CPC_REQUEST_ILLEGAL_ERROR("200001","CPC请求方式不符合业务逻辑"),
	QUERY_CPC_ENTITY_NONE_ERROR("200002","不存在与CRM输入相匹配的IUserOrder记录"),
	QUERY_CPC_ENTITY_MANY_ERROR("200003","存在多条IUserOrder记录"),
	/******************************** CPC 异常状态码 ********************************/

	INPUT_IS_NULL_ERROR("000100","传入XML为空，请检查"),
	XML_PARSE_ERROR("000101","XML解析过程中出现异常，建议检查XML格式或XML解析器相关配置"),
	CLASS_CAST_ERROR("000102","类型转换出错，建议检查xml中数据类型"),
	READ_XSD_FILE_ERROR("000103","读xsd文件出错"),
	XML_VALIDATION_ERROR("000104","XML校验失败"),
	PROPERTITY_READ_ERROR("000105","读propertity文件出错"),
	INPUT_AUTH_IS_EMPTY_ERROR("000106","传入XML中的用户验证信息不完整"),
	DATE_FORMAT_ERROR("000107","日期格式错误"),

	NOT_EXIST_TRANCODE_ERROR("000110","无法找到匹配的交易代码"),
	NOT_EXIST_OPERTYPE_ERROR("000111","无法找到匹配的交易操作类型"),
	NO_OPER_TABLE_ERROR("000112","交易代码无对应的操作表"),
	NOT_EXIST_BRAND_TYPE_ERROR("000113","无法找到匹配的用户品牌类型"),
	QUERY_MANY_TRANCODE_ERROR("000114","请求包含了一个要求独立处理的查询接口，请单独对此查询接口进行请求"),
	NOT_EXIST_USER_TYPE_ERROR("000115","系统不支持的目标用户类型"),
	INPUT_PROPERTY_NOT_MATCH_ERROR("000116","输入XML报文中的属性相互不匹配"),
	ILLEGAL_INPUT_PROPERTY_ERROR("000117","输入XML报文中的属性违反系统规则"),
	
	NO_INPUT_TRANCODE_ERROR("000120","未指定交易代码"),
	NO_INPUT_OPERTYPE_ERROR("000121","未指定交易的操作类型"),
	NO_INPUT_PROPERTITY_ERROR("000122","未指定交易需要所有属性，请检查输入"),

	NO_UPDATE_CONSTRAINT_ERROR("000130","未配置实体更新的约束条件"),
	NO_UPDATE_DESTINATION_ERROR("000131","未配置实体更新的目标字段"),

	ENTITY_BUILD_ERROR("000200","实体对象创建失败"),
	ENTITY_PARSE_ERROR("000201","无法获取实体的指定属性"),
	TABLE_CONFIG_ERROR("000202","无法获取获取表更改需要的条件字段"),

	AUTH_FAIL_ERROR("000500","用户认证失败"),
	NOT_EXIST_USER_ERROR("000300","指定用户在系统中不存在"),
	UNSUPPORTED_BRAND_ERROR("000301","不支持的用户品牌"),

	MUTEX_SPROM_EXIST_ERROR("000400","存在互斥套餐"),
	INTERLEAVE_SPROM_EXIST_ERROR("000401","存在生效时间重叠的套餐"),
	INTERLEAVE_MSC_EXIST_ERROR("000402","存在生效时间重叠的程控"),

	SPROM_CONFIG_NOT_EXIST_ERROR("000405","无法找到指定套餐的配置信息"),
	MAXDAY_ERROR("000410","查询跨度超过30天"),
	NOT_EXIST_IUSER_MONITOR_ERROR("000420","此时间段内非欠控用户"),
	IUSER_ISNULL_ERROR("000421","用户在BOSS不存在"),
	SIGN_CONTRACT_EXIST_ERROR("000422","用户已经签约"),
	SIGN_CONTRACT_NOT_EXIST_ERROR("000423","用户没有签约"),
	DEDUCT_AMOUNT_ISNULL_ERROR("000424","预付用户deductAmount为空"),
	CRMACCOUNT_ISNULL_ERROR("000425","账户在BOSS不存在"),
	GET_ACTUAL_FEE_ERROR("000426","计算实际年承诺消费出错"),
	ACCTID_NOT_MATCH_ERROR("000427","用户资料里的acctId和报文中的acctId不一致");
	
	private String code;
	private String cpcRspCode;
	private String description;

	private StatusCode(String code, String description) {
		this.code = code;
		this.cpcRspCode = code.substring(0, 1).concat(code.substring(3));
		this.description = description;
	}

	public String getCode() {
		return this.code;
	}
	
	public String getCpcRspCode() {
		return this.cpcRspCode;
	}

	public String getDescription() {
		return this.description;
	}
	
}
