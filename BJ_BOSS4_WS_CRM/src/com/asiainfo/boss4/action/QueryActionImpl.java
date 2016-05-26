package com.asiainfo.boss4.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.service.QueryBusinessService;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.TranCode;
/**
 * 业务动作(action)类具体实现
 * 将一个业务请求的多个业务操作(对应多个item)分发给业务操作类(service)
 * @author caohui
 *
 */
public class QueryActionImpl implements BusinessAction, ApplicationContextAware {
	private static Log logger = LogFactory.getLog(QueryActionImpl.class);
	
	private ApplicationContext applicationContext;
	
	private BusinessDao businessDao;

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;

	}
	
	public BusinessDao getBusinessDao() {
		return businessDao;
	}
	
	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}
	
	public String dispatch(List<LazyDynaMap> voList, Map<String, Object> requestStatus) {
		//查询类业务仅支持一个item节点
		LazyDynaMap vo = (LazyDynaMap) voList.get(0);
		
		// 取交易代码
		String tranCode = (String) vo.get("tranCode");
		if (tranCode == null) throw new BossException(StatusCode.NO_INPUT_TRANCODE_ERROR);
		if (TranCode.QUERY_PROD_OUT_SP.getTranCode().equals(tranCode))
		{
			
			StringBuffer retXml = new StringBuffer();
			retXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
				.append("<boss4Result>");
			for (int i=0;i<voList.size();i++)
			{
				vo = (LazyDynaMap) voList.get(i);
				try {
					ServiceContext.initInstanceToCurrentThread(applicationContext);
					
					QueryBusinessService businessService = (QueryBusinessService) applicationContext.getBean("service_"+tranCode);
					retXml.append(businessService.process(vo));
					
				} catch (BeansException e) {
					throw new BossException(StatusCode.NOT_EXIST_TRANCODE_ERROR, e, "指定的交易代码在配置文件中不存在");
				} catch (Exception e)
				{
					e.printStackTrace();
					if (e instanceof BossException)
					{
						retXml.append("<item>")
						.append("<tranCode>").append(vo.get("tranCode")).append("</tranCode>")
						.append("<SID>").append(vo.get("soNbr")).append("</SID>");
						retXml.append("<retCode>").append(((BossException)e).getStatusCode()).append("</retCode>")
						.append("<retInfo>").append(e.getMessage()).append("</retInfo>");
						retXml.append("<servId>").append(vo.get("servId")).append("</servId>")
						.append("<spCode>").append(vo.get("spCode")).append("</spCode>")
						.append("<operCode>").append(vo.get("operCode")).append("</operCode>")
						.append("<rate/>")
						.append("<msisdn>").append(vo.get("msisdn")).append("</msisdn>")
						.append("</item>");
					}
					else
					{
						retXml.append("<item>")
						.append("<tranCode>").append(vo.get("tranCode")).append("</tranCode>")
						.append("<SID>").append(vo.get("soNbr")).append("</SID>");
						retXml.append("<retCode>").append(StatusCode.INSIDE_ERROR.getCode()).append("</retCode>")
						.append("<retInfo>").append(e.getMessage()).append("</retInfo>");
						retXml.append("<servId>").append(vo.get("servId")).append("</servId>")
						.append("<spCode>").append(vo.get("spCode")).append("</spCode>")
						.append("<operCode>").append(vo.get("operCode")).append("</operCode>")
						.append("<rate/>")
						.append("<msisdn>").append(vo.get("msisdn")).append("</msisdn>")
						.append("</item>");
					}
				}
				finally {
					ServiceContext.cleanInstanceInCurrentThread();
				}
			}
			retXml.append("</boss4Result>");
			return retXml.toString();
			
		}
		else
		{
			try {
				ServiceContext.initInstanceToCurrentThread(applicationContext);
				
				QueryBusinessService businessService = (QueryBusinessService) applicationContext.getBean("service_"+tranCode);
				return  businessService.process(vo);
				
			} catch (BeansException e) {
				throw new BossException(StatusCode.NOT_EXIST_TRANCODE_ERROR, e, "指定的交易代码在配置文件中不存在");
			} finally {
				ServiceContext.cleanInstanceInCurrentThread();
			}
		}
		
	}

}
