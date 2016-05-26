package com.asiainfo.boss4.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.QueryBusinessDao;
import com.asiainfo.boss4.domain.CrmUser;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.FileCache;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.XmlHelper;

public class QueryUserCompensatingTypeServiceImpl implements QueryBusinessService {
	private static Log logger = LogFactory.getLog(QueryUserCompensatingTypeServiceImpl.class);
	
	private QueryBusinessDao queryBusinessDao;
	
	public void setQueryBusinessDao(QueryBusinessDao queryBusinessDao) {
		this.queryBusinessDao = queryBusinessDao;
	}
	public String process(LazyDynaMap vo) {
		TranCode tranCode = TranCode.getInstance((String) vo.get("tranCode"));
		String responseTemplate = FileCache.getXMLFile(tranCode.getTranCode());

		try {
			
			String msisdn = (String) vo.get("msisdn");
			if (msisdn == null || "".equals(msisdn)) {
				throw new BossException(StatusCode.ILLEGAL_INPUT_PROPERTY_ERROR, "msisdn不能为空");
			}
			String yearMonthDay = (String) vo.get("yearMonthDay");
			if (yearMonthDay == null || "".equals(yearMonthDay)) {
				throw new BossException(StatusCode.ILLEGAL_INPUT_PROPERTY_ERROR, "yearMonthDay不能为空");
			}
			if (yearMonthDay.length()!=8)
				throw new BossException(StatusCode.ILLEGAL_INPUT_PROPERTY_ERROR, "yearMonthDay的格式为4位年2位月2位日!请检查yearMonthDay是否符合要求.");
			Map<String, Map<String,Object>> result = new HashMap();
		
			CrmUser user = queryBusinessDao.queryCrmUserByPhoneNumber(msisdn);
			
			if (user == null)
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR, "用户"+msisdn+"不存在");
			Short regionCode = Short.valueOf(Long.valueOf(101+user.getServId().longValue()%10).toString());
			List userProductlist = queryBusinessDao.queryUserCompensatingType(user.getServId(), regionCode,Integer.valueOf(yearMonthDay));
			if (userProductlist == null || userProductlist.size() == 0)
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR, "用户"+msisdn+"不存在年承诺or月承诺");
			
			for (int i=0;i<userProductlist.size();i++)
			{
				Object[] userProduct = (Object[])userProductlist.get(i);
				String compensatingType = "月承诺";
				if (userProduct[0].toString().startsWith("8715"))
					compensatingType = "年承诺";
				
				Map<String, Object> map = new HashMap<String, Object>(3);
				map.put("productId", userProduct[0].toString());
				map.put("productName", userProduct[1].toString());
				map.put("promFee", userProduct[2].toString());
				map.put("compensatingType", compensatingType);
				map.put("priority", userProduct[3].toString());
				map.put("itemName", userProduct[4].toString());
				result.put(String.valueOf(i), map);
				
				
			}
			
			return XmlHelper.buildQueryListOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, result,"List");
		} catch (BossException e) {
			e.printStackTrace();
			return buildQueryOutputXML(e.getStatusCode(), e.getMessage(), responseTemplate);
		}catch (Exception e) {
			e.printStackTrace();
			return buildQueryOutputXML(StatusCode.INSIDE_ERROR.getCode(), StatusCode.INSIDE_ERROR.getDescription(), responseTemplate);
		}
		
	}

	private String buildQueryOutputXML(String code, String desc, String responseTemplate) {
		String outputXML = responseTemplate.replaceAll("\\$\\{_CODE\\}", code).replaceAll("\\$\\{_DESC\\}", desc);
		return outputXML.replaceAll("\\$\\{\\w*\\}", "");
	}
}
