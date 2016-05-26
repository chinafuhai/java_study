package com.asiainfo.boss4.support;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AppConfig {
	
	private static Log logger = LogFactory.getLog(AppConfig.class);
	
	public AppConfig() {
//		PropertyUtil.init("");
		OperateConfiguration.loadConfiguration();
	}
	
	/**
	 * 从system.properties属性文件中获取日期转换格式
	 * @param dateString
	 * @return
	 */
	public static String getDateFormat(){
		return AppConstant.DATE_FORMAT;
	}
	/**
	 * 从system.properties属性文件中获取CPC日期转换格式
	 * @return
	 */
	public static String getCpcDateFormat(){
		return AppConstant.CPC_DATE_FORMAT;
	}
	
//	/**
//	 * 是否对请求的xml进行校验
//	 * @return
//	 */
//	public static boolean isValidateXmlWithXsd(){
//		String validateXmlWithXsd = PropertyUtil.getPropertyToString("SYSTEM", "validateXmlWithXsd");
//		if (validateXmlWithXsd == null) {
//			logger.error("validateXmlWithXsd属性值为null");
//			throw new BossException(StatusCode.PROPERTITY_READ_ERROR);
//		}
//		return "true".equalsIgnoreCase(validateXmlWithXsd);
//	}
	
	/**
	 * 根据交易代码获取该代码对应的配置
	 * @param tranCode
	 * @return
	 */
	public static OneOpreateConfig getOneOpreateConfig(String tranCode){
		return OperateConfiguration.getConfigByTranCode(tranCode);
	}
	
//	/**
//	 * 以文件名获取xsd文件的内容
//	 * @param xsdName
//	 * @return
//	 */
//	public static String getXsdString(String xsdName){
//		String path = PropertyUtil.getPropertyToString("SYSTEM", xsdName);
//		String xsdString = null;
//		try {
//			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
//			xsdString = IOUtils.toString(in);
//		} catch (Exception e) {
//			logger.error("读xsd文件"+xsdName+"出错");
//			throw new BossException(StatusCode.READ_XSD_FILE_ERROR, e);
//		}
//		return xsdString;
//	}
}
