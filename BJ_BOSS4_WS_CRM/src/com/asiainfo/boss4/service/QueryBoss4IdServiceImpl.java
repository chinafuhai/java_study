package com.asiainfo.boss4.service;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.QueryBoss4IdDao;
import com.asiainfo.boss4.domain.CrmBossIdtypeMap;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
/**
 * 查询Boss映射Id服务实现
 * 
 * @author caohui
 *
 */
public class QueryBoss4IdServiceImpl implements BusinessService {
	private static Log logger = LogFactory.getLog(QueryBoss4IdServiceImpl.class);

	private QueryBoss4IdDao queryBoss4IdDao;

	public void setQueryBoss4IdDao(QueryBoss4IdDao queryBoss4IdDao) {
		this.queryBoss4IdDao = queryBoss4IdDao;
	}

	public String process(LazyDynaMap vo, Map requestStatus) {
		//取crm操作员id
		String operatorId = (String) vo.get("operatorId");
		//取crm营业厅id
		String orgId = (String) vo.get("orgId");
		
		if (operatorId == null && orgId == null) {
			logger.error("未传入操作员id或营业厅id");
			throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR);
		}
		
		Map crmIds = new LinkedHashMap();
		crmIds.put("operatorId", operatorId);
		crmIds.put("orgId", orgId);
		
		StringBuffer result = new StringBuffer();
		
		for (Iterator iterator = crmIds.entrySet().iterator(); iterator.hasNext();) {
			Entry type = (Entry) iterator.next();
			
			String idType = (String) type.getKey();
			String crmId = (String) type.getValue();
			
			if (crmId != null) {
				//查询id映射
				CrmBossIdtypeMap idMapping = queryBoss4IdDao.query(idType, crmId.trim().toUpperCase());
				
				// 没有查到映射记录则增加一条映射
				if (idMapping == null) {
//					idMapping = queryBoss4IdDao.add(idType, crmId.trim().toUpperCase());
					throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR, "The operatorId/orgId does not exist.");
				}
				
				result.append(",").append(idMapping.getBossId().toString());
			} else {
				result.append(",");
			}
			
		}
		
		return result.substring(1).toString();
	}

}
