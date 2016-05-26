package com.asiainfo.openPlatform.exception;


public class OpenPlatStatusCode {
	public final static OpenPlatStatusCode SUCCESS = new OpenPlatStatusCode(
			"00000", "成功");
	public final static OpenPlatStatusCode INPUT_XML_ERROR = new OpenPlatStatusCode(
			"99990", "传入XML为空");
	
	public final static OpenPlatStatusCode PARSE_CRM_XML_ERROR = new OpenPlatStatusCode(
			"99994","解析CRM报文错误");
	public final static OpenPlatStatusCode DB_OPERATION_ERROR = new OpenPlatStatusCode(
			"99995", "数据库错误");
	public final static OpenPlatStatusCode CONNECT_KT_ERROR = new OpenPlatStatusCode(
			"99996", "连接开通平台错误");
	public final static OpenPlatStatusCode RETURE_XML_ERROR = new OpenPlatStatusCode(
			"99997", "返回XML错误");
	public static final OpenPlatStatusCode INSIDE_ERROR = new OpenPlatStatusCode(
			"99999", "系统内部错误");
	private String code;
	private String description;

	private OpenPlatStatusCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return this.code;
	}

	public String getDescription() {
		return this.description;
	}
}
