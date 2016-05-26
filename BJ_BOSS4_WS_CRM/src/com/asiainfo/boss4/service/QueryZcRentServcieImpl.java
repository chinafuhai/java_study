package com.asiainfo.boss4.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.QueryBusinessDao;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.FileCache;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.XmlHelper;

public class QueryZcRentServcieImpl  implements QueryBusinessService{
	private static Log logger = LogFactory.getLog(QueryZcRentServcieImpl.class);
	
	private QueryBusinessDao queryBusinessDao;
	
	public void setQueryBusinessDao(QueryBusinessDao queryBusinessDao) {
		this.queryBusinessDao = queryBusinessDao;
	}

	public String process(LazyDynaMap vo) {
		TranCode tranCode = TranCode.getInstance((String) vo.get("tranCode"));
		String responseTemplate = FileCache.getXMLFile(tranCode.getTranCode());
		
		Map<String,Object> result = new HashMap();
		
		try{
			Long prodId = Long.valueOf((String) vo.get("prodId"));
			result=queryBusinessDao.queryCoinPrice(prodId);
			return XmlHelper.buildQueryOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, result);	
		}
		catch (BossException e){
			e.printStackTrace();
			return buildQueryOutputXML(e.getStatusCode(), e.getMessage(), responseTemplate);
		}
		catch (Exception e){
			e.printStackTrace();
			//return buildQueryOutputXML(StatusCode.INSIDE_ERROR.getCode(), e.getMessage(), responseTemplate);
			return buildQueryOutputXML(StatusCode.INSIDE_ERROR.getCode(),StatusCode.INSIDE_ERROR.getDescription(), responseTemplate);
		}


	}

	private String buildQueryOutputXML(String code, String desc, String responseTemplate) {
		String outputXML = responseTemplate.replaceAll("\\$\\{_CODE\\}", code).replaceAll("\\$\\{_DESC\\}", desc);
		return outputXML.replaceAll("\\$\\{\\w*\\}", "");
	}
}
