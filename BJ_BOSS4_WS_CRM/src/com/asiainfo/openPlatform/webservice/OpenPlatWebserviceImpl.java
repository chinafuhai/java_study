package com.asiainfo.openPlatform.webservice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.openPlatform.domain.BwoIntf;
import com.asiainfo.openPlatform.exception.OpenPlatException;
import com.asiainfo.openPlatform.exception.OpenPlatStatusCode;
import com.asiainfo.openPlatform.service.openPlatService;
import com.asiainfo.openPlatform.support.OpenPlatConstant;
import com.asiainfo.openPlatform.support.openPlatformUtil;
import com.asiainfo.report.exception.ReportStatusCode;

/**
 * 开通接口适配层 Webservice服务入口 由EAI调用
 * AsynKt = 异步开通接口
 * SynKt  = 同步开通接口
 * @author zhangql
 *
 */
public class OpenPlatWebserviceImpl implements OpenPlatWebservice {
	private static Log logger = LogFactory.getLog(OpenPlatWebserviceImpl.class);

	private openPlatService openPlatService;
	/**
	 * 异步开通接口
	 */
	@SuppressWarnings("finally")
	public String openPlatAsynRequest(String inputxml) {
		logger.info("AsynKt(YB) INPUT XML = "+inputxml);
		if(inputxml==null||"".equals(inputxml)){
			logger.error("INPUT XML IS NULL");
			throw new OpenPlatException(OpenPlatStatusCode.INPUT_XML_ERROR);
		}
		
		String outputXml = null;
		Map map = openPlatformUtil.AsynRequestParse(inputxml,null);
		String taskNo = (String)map.get("taskNo");
		Date execStartTime = new Date();
		
		try {
			
			BwoIntf bwoIntf = openPlatService.openPlatAsynService(map);
			String orderId = (String)map.get("orderId");
			if(bwoIntf==null){
				bwoIntf = new BwoIntf();
				bwoIntf.setTradeId(Long.parseLong(taskNo));
			}
		    outputXml = openPlatService.AsynExecReturn(bwoIntf,taskNo, orderId, false);
			
		} catch (OpenPlatException e) {
			logger.error("捕获到系统自定义异常", e);
			StringBuffer errorMessage = new StringBuffer(e.getMessage());
			if (e.getTraceMessage() != null) {
				errorMessage.append(". 详细异常信息：").append(e.getTraceMessage());
			}
			outputXml = buildErrorXML(taskNo,e.getStatusCode(),
					errorMessage.toString());
		} catch (Throwable e) {
			logger.error("捕获到严重的不可恢复异常", e);
			outputXml = buildErrorXML(taskNo,ReportStatusCode.INSIDE_ERROR.getCode(),
							ReportStatusCode.INSIDE_ERROR.getDescription());
		} finally {
			
			//日志
			Map<String,String> logMap = new HashMap<String, String>();
			logMap.put("EAI_TRADE_ID", taskNo);
			logMap.put("EAI_ORDER_ID", (String)map.get("orderId"));
			logMap.put("IMSI", (String)map.get("IMSI"));
			logMap.put("MSISDN", (String)map.get("MSISDN"));
			logMap.put("INTERFACE_TYPE", OpenPlatConstant.KT_LogInterType_Asyn);
			
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			logMap.put("CREATE_DATE", (String)map.get("ReqTime"));
			logMap.put("BEGIN_DATE", format.format(execStartTime));
			logMap.put("END_DATE", format.format(new Date()));
			
			String inXml = (String)map.get("inputXML");
			if(inXml.length()<1024){
				logMap.put("REQ_XML_INFO", inXml);
			}else{
				logMap.put("REQ_XML_INFO", inXml.substring(0, 1023));
			}
			if(outputXml.length()<1024){
				logMap.put("RES_XML_INFO", outputXml.toString());
			}else{
				logMap.put("RES_XML_INFO", outputXml.toString().substring(0,1023));
			}
			
			try {
				openPlatService.inKtBusiLogRecode(logMap);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			logger.info("RESPONSE XML=> " + outputXml);
			logger.info("WebService REQUEST EXECUTE SUCCESS");
			return outputXml;
		}
	}
    
	/**
	 * 同步开通接口  
	 */
	@SuppressWarnings("finally")
	public String openPlatSynRequest(String inputxml) {
		logger.info("SynKt(TB) INPUT XML = "+inputxml);
		if(inputxml==null||"".equals(inputxml)){
			logger.error("INPUT XML IS NULL");
			throw new OpenPlatException(OpenPlatStatusCode.INPUT_XML_ERROR);
		}
		
		String outputXml = null;
		
		//根据传入xml初步判断同步接口是查询还是业务办理
		String flag = openPlatformUtil.isQuery(inputxml);
		
		String loggerType = flag.equals(OpenPlatConstant.KT_Synchronize_Busi)?"BUSI OPERATOR":"QUERY OPERATOR";
		logger.info("SynKt(TB) OperationType code is "+flag+" TYPE="+loggerType);
		
		String taskNo =null;
		Date startTime = new Date();
		Map map = null;
		try {
			if(OpenPlatConstant.KT_Synchronize_Query.equals(flag)){
				map = openPlatformUtil.SynRequestParse(inputxml);
				taskNo = (String)map.get("taskNo");
				outputXml = openPlatService.openPlatSynService(map);
			}else{
				map = openPlatformUtil.AsynRequestParse(inputxml,OpenPlatConstant.KT_Synchronize_Busi);
				taskNo = (String)map.get("taskNo");
				String orderId = (String)map.get("orderId");
				BwoIntf bwoIntf = openPlatService.openPlatAsynService(map);
				outputXml = openPlatService.AsynExecReturn(bwoIntf, taskNo,orderId, true);
			    
			}
		} catch (OpenPlatException e) {
			logger.error("捕获到系统自定义异常", e);
			StringBuffer errorMessage = new StringBuffer(e.getMessage());
			if (e.getTraceMessage() != null) {
				errorMessage.append(". 详细异常信息：").append(e.getTraceMessage());
			}
			outputXml = buildErrorXML(taskNo,e.getStatusCode(),
					errorMessage.toString());
		} catch (Throwable e) {
			logger.error("捕获到严重的不可恢复异常", e);
			outputXml = buildErrorXML(taskNo,ReportStatusCode.INSIDE_ERROR.getCode(),
							ReportStatusCode.INSIDE_ERROR.getDescription());
		} finally {
			
			//日志
			Map<String,String> logMap = new HashMap<String, String>();
			
			String socketMessage = (String)map.get("reqString");
			if(socketMessage==null){
				socketMessage = (String)map.get("inputXML");
			}
			
			logMap.put("EAI_TRADE_ID", (String)map.get("taskNo"));
			logMap.put("EAI_ORDER_ID", (String)map.get("OrderId"));
			logMap.put("IMSI", (String)map.get("IMSI"));
			logMap.put("MSISDN", (String)map.get("MSISDN"));
			logMap.put("INTERFACE_TYPE", OpenPlatConstant.KT_LogInterType_Syn);
			
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			logMap.put("CREATE_DATE", (String)map.get("ReqTime"));
			logMap.put("BEGIN_DATE", format.format(startTime));
			logMap.put("END_DATE", format.format(new Date()));
			
			
			if(socketMessage.length()<1024){
				logMap.put("REQ_XML_INFO", socketMessage);
			}else{
				logMap.put("REQ_XML_INFO", socketMessage.substring(0, 800));
			}
			if(outputXml.length()<1024){
				logMap.put("RES_XML_INFO", outputXml.toString());
			}else{
				logMap.put("RES_XML_INFO", outputXml.toString().substring(0,800));
			}
			
			try {
				openPlatService.inKtBusiLogRecode(logMap);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//end 日志
			
			logger.info("RESPONSE XML=> " + outputXml);
			logger.info("WebService REQUEST EXECUTE SUCCESS");
			return outputXml;
		}
	}
	
	
	private String buildErrorXML(String TaskNo,String errorCode,String description){
		
		StringBuffer outXml = new StringBuffer();
		outXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		outXml.append("<Response>\n");
		outXml.append("<TaskNo>"+TaskNo+"</TaskNo>\n");
		outXml.append("<ErrorCode>"+errorCode+"</ErrorCode>\n");
		outXml.append("<ErrorMsg>"+description+"</ErrorMsg>\n");
		outXml.append("</Response>\n");
		return outXml.toString();
	}
	
	public openPlatService getOpenPlatService() {
		return openPlatService;
	}

	public void setOpenPlatService(openPlatService openPlatService) {
		this.openPlatService = openPlatService;
	}

}
