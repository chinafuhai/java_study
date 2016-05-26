package com.asiainfo.boss4.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.QueryCrmIdDao;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.FileCache;
import com.asiainfo.boss4.support.XmlHelper;

public class QueryCrmIdServiceImpl implements QueryCrmIdService {
	private static Log logger = LogFactory.getLog(QueryCrmIdServiceImpl.class);
	
	private QueryCrmIdDao queryCrmIdDao;
	
	public void setQueryCrmIdDao(QueryCrmIdDao queryCrmIdDao) {
		this.queryCrmIdDao = queryCrmIdDao;
	}

	public String query(Map<String, String[]> crmId) {
		String[] orgIds = crmId.get("orgId");
		StringBuffer orgBossIds = new StringBuffer();
		if (orgIds != null) {
			for (String id : orgIds) {
				if (id.equals("")) { continue; }
				String orgBossId = queryCrmIdDao.queryOrgId(Long.valueOf(id.trim()));
				orgBossIds.append(orgBossId == null ? "" : orgBossId);
				orgBossIds.append(",");
			}
			if (orgBossIds.length() > 0) {
				orgBossIds.delete(orgBossIds.length()-1, orgBossIds.length());
			}
		}
		
		String[] operatorIds = crmId.get("operatorId");
		StringBuffer operBossIds = new StringBuffer();
		if (operatorIds != null) {
			for (String id : operatorIds) {
				if (id.equals("")) { continue; }
				String operBossId = queryCrmIdDao.queryOperatorId(Long.valueOf(id.trim()));
				operBossIds.append(operBossId == null ? "" : operBossId);
				operBossIds.append(",");
			}
			if (operBossIds.length() > 0) {
				operBossIds.delete(operBossIds.length()-1, operBossIds.length());
			}
		}
		
		String responseTemplate = FileCache.getXMLFile("query_crm_id");
		
		Map<String, Object> responseMap = new LinkedHashMap<String, Object>();
		responseMap.put("ORG_ID", orgBossIds.toString());
		responseMap.put("OPERATOR_ID", operBossIds.toString());
		
		return XmlHelper.buildQueryOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), 
				responseTemplate, responseMap);
	}


}
