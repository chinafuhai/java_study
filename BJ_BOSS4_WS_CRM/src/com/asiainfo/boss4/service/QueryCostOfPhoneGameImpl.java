package com.asiainfo.boss4.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.JfBusinessDao;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.DataValiditionHelper;
import com.asiainfo.boss4.support.FileCache;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.XmlHelper;

public class QueryCostOfPhoneGameImpl implements QueryBusinessService {
	private static Log logger = LogFactory.getLog(QueryCostOfPhoneGameImpl.class);
	
	private JfBusinessDao jfBusinessDao;
	
	public void setjfBusinessDao(JfBusinessDao jfBusinessDao) {
		this.jfBusinessDao = jfBusinessDao;
	}

	public String process(LazyDynaMap vo) {
		try {
			DataValiditionHelper.checkInputVo(vo, new String[]{"msisdn", "yyyymmdd"});
			String msisdn = (String) vo.get("msisdn");
			String currentDate = (String) vo.get("yyyymmdd");
			
			Long amountOfDay = jfBusinessDao.queryCostOfPhoneGameSP(msisdn, currentDate);
			Long amountOfMonth = amountOfDay.longValue();
			amountOfMonth += jfBusinessDao.queryMonthlyCostOfPhoneGameSP(msisdn, currentDate.substring(0, 6));
				
			String responseTemplate = FileCache.getXMLFile(TranCode.QUERY_COST_OF_PHONE_GAME.getTranCode());
			
			Map<String, Object> result = new HashMap<String, Object>(3);
			result.put("msisdn", msisdn);
			result.put("amountOfDay", amountOfDay);
			result.put("amountOfMonth", amountOfMonth);
			
			return XmlHelper.buildQueryOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, result);
		} catch (BossException e) {
			HashMap<String, Object> queryResult = new HashMap<String, Object>(3);
			queryResult.put("msisdn", (String) vo.get("msisdn"));
			queryResult.put("amountOfDay", -1);
			queryResult.put("amountOfMonth", -1);
			e.setQueryResult(queryResult);
			
			throw e;
		}
		
	}

}
