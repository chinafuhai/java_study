package com.asiainfo.boss4.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.QueryBusinessDao;
import com.asiainfo.boss4.domain.SmsJfMap;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.FileCache;
import com.asiainfo.boss4.support.OperateType;
import com.asiainfo.boss4.support.TranCode;

public class QuerySmsJfMapImpl implements QueryBusinessService {
	private static Log logger = LogFactory.getLog(QuerySmsJfMapImpl.class);
	
	private QueryBusinessDao queryBusinessDao;
	
	public void setQueryBusinessDao(QueryBusinessDao queryBusinessDao) {
		this.queryBusinessDao = queryBusinessDao;
	}
	public String process(LazyDynaMap vo) {
		// TODO Auto-generated method stub

		TranCode tranCode = TranCode.getInstance((String) vo.get("tranCode"));
		String responseTemplate = FileCache.getXMLFile(tranCode.getTranCode());
		Map<String, Map<String,Object>> result = new HashMap();
		try{
			List<SmsJfMap> smsJfMapList = queryBusinessDao.getSmsJfMap(null);
			StringBuffer retXml = new StringBuffer();
			retXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
					.append("<boss4Result>")
					.append("<item>")
					.append("<tranCode>").append(vo.get("tranCode")).append("</tranCode>")
					.append("<SID>").append(vo.get("soNbr")).append("</SID>")
					.append("<retCode>").append(StatusCode.SUCCESS.getCode()).append("</retCode>")
					.append("<retInfo>").append(StatusCode.SUCCESS.getDescription()).append("</retInfo>");
			if (smsJfMapList.size() == 0)
			{
				retXml.append("<SmsJfMap>")
				.append("<remindType/>")
				.append("<denominator/>")
				.append("<numerator/>")
				.append("<remindFlow/>")
				.append("<regionCode/>")
				.append("<freebieId/>")
				.append("<prodId/>")
				.append("<alarmId/>")
				.append("<remindResCount/>")
				.append("<validDate/>")
				.append("<expireDate/>")
				.append("<remindContent/>")
				.append("<prodName/>")
				.append("<remindEnd/>")
				.append("<operType/>")
				.append("<templetId/>")
				.append("<templeName/>")
				.append("</SmsJfMap>");
			}
			for (int i=0;i<smsJfMapList.size();i++)
			{
				SmsJfMap smsJfMap = (SmsJfMap)smsJfMapList.get(i);

				retXml.append("<SmsJfMap>")
				.append("<remindType/>")
				.append("<denominator/>")
				.append("<numerator/>")
				.append("<remindFlow/>")
				.append("<regionCode/>")
				.append("<freebieId/>")
				.append("<prodId/>")
				.append("<alarmId/>")
				.append("<remindResCount/>")
				.append("<validDate/>")
				.append("<expireDate/>")
				.append("<remindContent>").append(smsJfMap.getRemindContent()).append("</remindContent>")
				.append("<prodName>").append(smsJfMap.getProdName()).append("</prodName>")
				.append("<remindEnd>").append(smsJfMap.getRemindEnd()).append("</remindEnd>")
				.append("<operType>").append(OperateType.QUERY.getTypeCode()).append("</operType>")
				.append("<templetId>").append(smsJfMap.getTempletId()).append("</templetId>")
				.append("<templeName>").append(smsJfMap.getTempleName()).append("</templeName>")
				.append("</SmsJfMap>");
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
