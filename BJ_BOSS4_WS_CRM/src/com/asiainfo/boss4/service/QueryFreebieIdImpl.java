package com.asiainfo.boss4.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.QueryBusinessDao;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.service.QueryBusinessService;
import com.asiainfo.boss4.support.FileCache;
import com.asiainfo.boss4.support.FreebieId;
import com.asiainfo.boss4.support.TranCode;

public class QueryFreebieIdImpl implements QueryBusinessService {
	private static Log logger = LogFactory.getLog(QueryThresholdImpl.class);

	private QueryBusinessDao queryBusinessDao;

	public void setQueryBusinessDao(QueryBusinessDao queryBusinessDao) {
		this.queryBusinessDao = queryBusinessDao;
	}

	public String process(LazyDynaMap vo) {
		TranCode tranCode = TranCode.getInstance((String) vo.get("tranCode"));
		String responseTemplate = FileCache.getXMLFile(tranCode.getTranCode());
		Map<Integer, String> result = new HashMap();

		try {

			StringBuffer retXml = new StringBuffer();
			retXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
			      .append("<boss4Result>")
			      .append("<item>")
			      .append("<tranCode>").append(vo.get("tranCode")).append("</tranCode>")
			      .append("<SID>").append(vo.get("soNbr")).append("</SID>")
				  .append("<retCode>").append(StatusCode.SUCCESS.getCode()).append("</retCode>")
				  .append("<retInfo>").append(StatusCode.SUCCESS.getDescription()).append("</retInfo>");

			// 获取
			for (Map.Entry<Integer, String> m : FreebieId.needNoticeFreebieIdMap().entrySet()) {
				retXml.append("<FreebieId>")
				      .append("<freebieTempletId>").append(m.getKey()).append("</freebieTempletId>")
				      .append("<freebieDesc>").append(m.getValue()).append("</freebieDesc>")
				      .append("</FreebieId>");
			}
			retXml.append("</item>").append("</boss4Result>");
			return retXml.toString();
		} catch (BossException e) {
			e.printStackTrace();
			return buildQueryOutputXML(e.getStatusCode(), e.getMessage(),responseTemplate);
		} catch (Exception e) {
			e.printStackTrace();
			return buildQueryOutputXML(StatusCode.INSIDE_ERROR.getCode(), e.getMessage(), responseTemplate);
		}
	}

	private String buildQueryOutputXML(String code, String desc,
			String responseTemplate) {
		String outputXML = responseTemplate.replaceAll("\\$\\{_CODE\\}", code).replaceAll("\\$\\{_DESC\\}", desc);
		return outputXML.replaceAll("\\$\\{\\w*\\}", "");
	}
}