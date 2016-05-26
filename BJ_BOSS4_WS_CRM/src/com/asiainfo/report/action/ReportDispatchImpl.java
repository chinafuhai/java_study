package com.asiainfo.report.action;

import java.util.List;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.asiainfo.report.exception.ReportException;
import com.asiainfo.report.exception.ReportStatusCode;
import com.asiainfo.report.service.BaseService;
import com.asiainfo.report.service.DailyBalanceLoadImpl;
import com.asiainfo.report.support.XmlParseUtil;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;

public class ReportDispatchImpl implements ReportDispatch,ApplicationContextAware{

	private static Log logger = LogFactory.getLog(ReportDispatchImpl.class);
	private ApplicationContext applicationContext;
	private String response = "";

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	public String dispatch(String inputXml) {
		if (inputXml.equals(null) || inputXml.trim().length()==0) {
			logger.error("传入XML为空");
			throw new BossException(StatusCode.INPUT_IS_NULL_ERROR);
		}
		// 对XML进行解析
		List voList =XmlParseUtil.parseReportXml(inputXml);

		for (int i = 0; i < voList.size(); i++) {
			LazyDynaMap vo = (LazyDynaMap) voList.get(i);
			
			// 取交易代码
			String tranCode = (String) vo.get("tranCode");
			if (tranCode == null) {
				logger.error("未指定交易代码");
				throw new BossException(StatusCode.NO_INPUT_TRANCODE_ERROR);
			}
			
			BaseService baseService;
			try {
				baseService = (BaseService) applicationContext
						.getBean("service_"+tranCode);
			} catch (ReportException e) {
				logger.error("指定的服务不存在");
				throw new BossException(StatusCode.NOT_EXIST_TRANCODE_ERROR, e);
			}
			// 调用业务处理流程
			try {
				response = baseService.process(vo);
				if (response == null || response.trim().length()==0) {
					logger.error("返回XML错误");
					throw new ReportException(ReportStatusCode.RETURE_XML_ERROR);
				}
			} catch (ReportException e) {// 捕获手动抛出的异常
				throw new ReportException(e, (String) vo.get("tranCode"));
			} catch (Exception e) {// 捕获系统自身抛出的内部异常
				throw new ReportException(ReportStatusCode.INSIDE_ERROR, e,
						(String) vo.get("tranCode"));
			}
		}
		if (!"".equals(response)) {
			return response.toString();
		} else {
			return null;
		}
	}

}
