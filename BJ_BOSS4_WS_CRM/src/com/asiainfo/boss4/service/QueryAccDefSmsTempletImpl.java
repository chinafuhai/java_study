package com.asiainfo.boss4.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.QueryBusinessDao;
import com.asiainfo.boss4.domain.AccDefSmsTemplet;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.FileCache;
import com.asiainfo.boss4.support.TranCode;

public class QueryAccDefSmsTempletImpl  implements QueryBusinessService{
	private static Log logger = LogFactory.getLog(QueryAccDefSmsTempletImpl.class);
	
	private QueryBusinessDao queryBusinessDao;
	
	public void setQueryBusinessDao(QueryBusinessDao queryBusinessDao) {
		this.queryBusinessDao = queryBusinessDao;
	}

	public String process(LazyDynaMap vo) {
		TranCode tranCode = TranCode.getInstance((String) vo.get("tranCode"));
		String responseTemplate = FileCache.getXMLFile(tranCode.getTranCode());
		Map<String, Map<String,Object>> result = new HashMap();
		try{
			Long smsTempletId = Long.valueOf((String) vo.get("templetId"));
			
			AccDefSmsTemplet accDefSmsTemplet = new AccDefSmsTemplet();
			accDefSmsTemplet.setSmsTempletId(smsTempletId);
			List smsTempletIdList = queryBusinessDao.getEntityList(accDefSmsTemplet, new String[]{"smsTempletId", "expireDate"});
			StringBuffer retXml = new StringBuffer();
			retXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
					.append("<boss4Result>")
					.append("<item>")
					.append("<tranCode>").append(vo.get("tranCode")).append("</tranCode>")
					.append("<SID>").append(vo.get("soNbr")).append("</SID>")
					.append("<retCode>").append(StatusCode.SUCCESS.getCode()).append("</retCode>")
					.append("<retInfo>").append(StatusCode.SUCCESS.getDescription()).append("</retInfo>");
			if (smsTempletIdList.size() == 0)
			{
				retXml.append("<AccDefSmsTemplet>")
				.append("<smsTempletIdSeq/>")
				.append("<smsTempletId/>")
				.append("<smsName/>")
				.append("<smsTemplet/>")
				.append("<validDate/>")
				.append("<expireDate/>")
				.append("</AccDefSmsTemplet>");
			}
			for (int i=0;i<smsTempletIdList.size();i++)
			{
				accDefSmsTemplet = (AccDefSmsTemplet)smsTempletIdList.get(i);
				String strSmsTemplet = accDefSmsTemplet.getSmsTemplet().replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;");
				retXml.append("<AccDefSmsTemplet>")
				.append("<smsTempletIdSeq>").append(accDefSmsTemplet.getSmsTempletIdSeq()).append("</smsTempletIdSeq>")
				.append("<smsTempletId>").append(accDefSmsTemplet.getSmsTempletId()).append("</smsTempletId>")
				.append("<smsName>").append(accDefSmsTemplet.getSmsName()).append("</smsName>")
				.append("<smsTemplet>").append(strSmsTemplet).append("</smsTemplet>")
				.append("<validDate>").append(accDefSmsTemplet.getValidDate()).append("</validDate>")
				.append("<expireDate>").append(accDefSmsTemplet.getExpireDate()).append("</expireDate>")
				.append("</AccDefSmsTemplet>");
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
