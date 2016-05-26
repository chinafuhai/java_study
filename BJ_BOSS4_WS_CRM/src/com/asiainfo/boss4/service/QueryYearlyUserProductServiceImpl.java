package com.asiainfo.boss4.service;

import java.math.BigDecimal;
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

public class QueryYearlyUserProductServiceImpl implements QueryBusinessService {
	private static Log logger = LogFactory.getLog(QueryYearlyUserProductServiceImpl.class);
	
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
			
			
			Map<String, Map<String,Object>> result = new HashMap();
		
			CrmUser user = queryBusinessDao.queryCrmUserByPhoneNumber(msisdn);
			
			if (user == null)
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR, "用户"+msisdn+"不存在");
			Short regionCode = Short.valueOf(Long.valueOf(101+user.getServId().longValue()%10).toString());
			List userProductlist = queryBusinessDao.queryPersonalizedYearlyUserProduct(user.getServId(), regionCode);
			if (userProductlist == null || userProductlist.size() == 0)
				userProductlist = queryBusinessDao.queryFixedYearlyUserProduct(user.getServId(), regionCode);
			
			if (userProductlist == null || userProductlist.size() == 0)
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR, "用户"+msisdn+"不存在年承诺消费");
			
			for (int i=0;i<userProductlist.size();i++)
			{
				Object[] userProduct = (Object[])userProductlist.get(i);
				
				if (userProduct[0].toString().startsWith("8713")){
					Integer productId = Integer.valueOf("8715")*10000+((BigDecimal)userProduct[0]).intValue()%10000;
					String uptoLastMonthAmount = queryBusinessDao.queryUptoLastMonthAmount(user.getServId(), productId);
					if (uptoLastMonthAmount == null || "".equals(uptoLastMonthAmount))
						uptoLastMonthAmount = "0";
					productId = Integer.valueOf("8713")*10000+((BigDecimal)userProduct[0]).intValue()%10000;
					Map<String, Object> map = new HashMap<String, Object>(3);
					map.put("productId", productId.toString());
					map.put("commitmentAmount", userProduct[1].toString());
					map.put("uptoLastMonthAmount", uptoLastMonthAmount);
					map.put("leftAmount", Long.valueOf(Long.valueOf(userProduct[1].toString()).longValue()-Long.valueOf(uptoLastMonthAmount).longValue()).toString());
					map.put("validDate", userProduct[2].toString());
					map.put("expireDate", userProduct[3].toString());
					result.put(String.valueOf(i), map);
				}
				
			}
			
			return XmlHelper.buildQueryListOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, result,"List");
		} catch (BossException e) {
			e.printStackTrace();
			return buildQueryOutputXML(e.getStatusCode(), e.getMessage(), responseTemplate);
		}
	}

	private String buildQueryOutputXML(String code, String desc, String responseTemplate) {
		String outputXML = responseTemplate.replaceAll("\\$\\{_CODE\\}", code).replaceAll("\\$\\{_DESC\\}", desc);
		return outputXML.replaceAll("\\$\\{\\w*\\}", "");
	}
}
