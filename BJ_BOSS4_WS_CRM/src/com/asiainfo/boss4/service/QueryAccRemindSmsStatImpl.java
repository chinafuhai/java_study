package com.asiainfo.boss4.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.QueryBusinessDao;
import com.asiainfo.boss4.domain.AccRemindSmsStat;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.FileCache;
import com.asiainfo.boss4.support.TranCode;

public class QueryAccRemindSmsStatImpl  implements QueryBusinessService{
	private static Log logger = LogFactory.getLog(QueryZcRentServcieImpl.class);
	
	private QueryBusinessDao queryBusinessDao;
	
	public void setQueryBusinessDao(QueryBusinessDao queryBusinessDao) {
		this.queryBusinessDao = queryBusinessDao;
	}

	public String process(LazyDynaMap vo) {
		TranCode tranCode = TranCode.getInstance((String) vo.get("tranCode"));
		String responseTemplate = FileCache.getXMLFile(tranCode.getTranCode());
		Map<String, Map<String,Object>> result = new HashMap();
		
		try{
			String beginDate = (String) vo.get("beginDate");
			String endDate = (String) vo.get("endDate");
			if ((beginDate == null || "".equals(beginDate))&&(endDate == null || "".equals(endDate))) {
				throw new BossException(StatusCode.ILLEGAL_INPUT_PROPERTY_ERROR, "beginDate和endDate不能均为空");
			}
			
			AccRemindSmsStat smsStat=new AccRemindSmsStat();
			List<AccRemindSmsStat> resultlist=queryBusinessDao.queryAccRemindSmsStat(beginDate,endDate);
			
			StringBuffer retXml = new StringBuffer();
			retXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
					.append("<boss4Result>")
					.append("<item>")
					.append("<tranCode>").append(vo.get("tranCode")).append("</tranCode>")
					.append("<SID>").append(vo.get("soNbr")).append("</SID>")
					.append("<retCode>").append(StatusCode.SUCCESS.getCode()).append("</retCode>")
					.append("<retInfo>").append(StatusCode.SUCCESS.getDescription()).append("</retInfo>");
			
			if (resultlist.size() == 0){
				retXml.append("<AccRemindSmsStat>")
				.append("<sendDay/>")
				.append("<smsCount/>")
				.append("</AccRemindSmsStat>");
			}
			for (int i=0;i<resultlist.size();i++){
				smsStat = (AccRemindSmsStat)resultlist.get(i);
				retXml.append("<AccRemindSmsStat>")
				.append("<sendDay>").append(smsStat.getSendDay()).append("</sendDay>")
				.append("<smsCount>").append(smsStat.getSmsCount()).append("</smsCount>")
				.append("</AccRemindSmsStat>");
			}		
			retXml.append("</item>")
			.append("</boss4Result>");
			return retXml.toString();
			
		}
		catch (BossException e)
		{
			e.printStackTrace();
			return buildQueryOutputXML(e.getStatusCode(), e.getMessage(), responseTemplate);

		}
		catch (Exception e)
		{
			e.printStackTrace();
			return buildQueryOutputXML(StatusCode.INSIDE_ERROR.getCode(), e.getMessage(), responseTemplate);

		}
	}

	private String buildQueryOutputXML(String code, String desc, String responseTemplate) {
		String outputXML = responseTemplate.replaceAll("\\$\\{_CODE\\}", code).replaceAll("\\$\\{_DESC\\}", desc);
		return outputXML.replaceAll("\\$\\{\\w*\\}", "");
	}
}