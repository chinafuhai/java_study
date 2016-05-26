package com.asiainfo.report.webservice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.report.exception.ReportStatusCode;
import com.asiainfo.report.exception.ReportException;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.report.action.ReportDispatch;

public class OnReportServiceImpl implements OnReportService {

	private static Log logger = LogFactory.getLog(OnReportServiceImpl.class);

	private ReportDispatch reportDispatch;
	
	public void setReportDispatch(ReportDispatch reportDispatch) {
		this.reportDispatch = reportDispatch;
	}



	public String OnBoss4Report(String inputXml) {
		logger.info("传入XML=>"+inputXml);
		if (inputXml == null || "".equals(inputXml)) {
			logger.error("传入XML为空");
			throw new BossException(StatusCode.INPUT_IS_NULL_ERROR);
		}
		String outputXml = null;
		try {
			outputXml = reportDispatch.dispatch(inputXml);
		} catch (ReportException e) {// 捕获手动抛出的异常
			logger.error("捕获到系统自定义异常", e);
			StringBuffer errorMessage = new StringBuffer(e.getMessage());
			if (e.getTraceMessage() != null) {
				errorMessage.append(". 详细异常信息：").append(e.getTraceMessage());
			}
			outputXml = buildErrorXML(e.getStatusCode(),
					errorMessage.toString());
		} catch (Throwable e) {// 捕获系统自身抛出的内部异常
			logger.error("捕获到严重的不可恢复异常", e);
			outputXml = buildErrorXML(ReportStatusCode.INSIDE_ERROR.getCode(),
							ReportStatusCode.INSIDE_ERROR.getDescription());
		} finally {
			logger.info("响应XML=> " + outputXml);
			logger.info("WebService请求处理完成");
			return outputXml;
		}
	}
	
	private String buildErrorXML(String errorCode,String description){
		
		StringBuffer outXml = new StringBuffer();
		outXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		outXml.append("<AccountReply>\n");
		outXml.append("<item>\n");
		
		outXml.append("<eaiOrderId></eaiOrderId>\n");
		outXml.append("<eaiTradeId></eaiTradeId>\n");
		outXml.append("<eaiOperator></eaiOperator>\n");
		outXml.append("<eaiPassword></eaiPassword>\n");
		
		outXml.append("<returnCode>"+errorCode+"</returnCode>\n");
		outXml.append("<codeDesc>"+description+"</codeDesc>\n");
		outXml.append("</item>\n");
		outXml.append("</AccountReply>\n");
		return outXml.toString();
	}

}
