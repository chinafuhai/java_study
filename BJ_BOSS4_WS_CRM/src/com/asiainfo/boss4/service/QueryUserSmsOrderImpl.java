package com.asiainfo.boss4.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.QueryBusinessDao;
import com.asiainfo.boss4.domain.CrmUser;
import com.asiainfo.boss4.domain.IUserSmsOrder;
import com.asiainfo.boss4.domain.SmsJfMap;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.FileCache;
import com.asiainfo.boss4.support.OrderType;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.XmlHelper;

public class QueryUserSmsOrderImpl implements QueryBusinessService {
	private static Log logger = LogFactory.getLog(QueryUserSmsOrderImpl.class);
	
	private QueryBusinessDao queryBusinessDao;
	
	public void setQueryBusinessDao(QueryBusinessDao queryBusinessDao) {
		this.queryBusinessDao = queryBusinessDao;
	}
	public String process(LazyDynaMap vo) {
		// TODO Auto-generated method stub
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
			IUserSmsOrder userSmsOrder = (IUserSmsOrder)BeanCopyHelper.newInstance(
					"com.asiainfo.boss4.domain.IUserSmsOrder");
			userSmsOrder.setServId(user.getServId());
			List userSmsOrderlist = queryBusinessDao.getEntityList(userSmsOrder, new String[]{"servId","expireDate"});
			
			if (userSmsOrderlist == null || userSmsOrderlist.size() == 0)
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR, "用户"+msisdn+"不存在个性化定制短信");
			
			//List<SmsJfMap> smsJfMapList =  queryBusinessDao.getSmsJfMap(null);
			//List<Integer> orderList = OrderType.needNoticeOrderTypeList();
			
			for (int i=userSmsOrderlist.size()-1;i>=0;i--)
			{
				userSmsOrder = (IUserSmsOrder)userSmsOrderlist.get(i);
				if (userSmsOrder.getSmsOrderType() == null)
				{
					userSmsOrderlist.remove(userSmsOrder);
					continue;
				}
				boolean isFound = false;
//				for (int j=0;j<smsJfMapList.size();j++)
//				{
//					SmsJfMap smsJfMap = smsJfMapList.get(j);
//					if (smsJfMap.getSmsOrderType() != null && userSmsOrder.getSmsOrderType().shortValue() == smsJfMap.getSmsOrderType().shortValue())
//					{
////						userSmsOrderlist.remove(userSmsOrder);
//						isFound = true;
//						break;
//					}
//				}
				
//				for (int j=0;j<orderList.size();j++){
//					if (userSmsOrder.getSmsOrderType().shortValue() == orderList.get(j).shortValue()){
//						isFound = true;
//						break;
//					}
//				}
				
				isFound=OrderType.isOrderType(userSmsOrder.getSmsOrderType().shortValue());
				
				if (isFound)
				{
					Map<String, Object> map = new HashMap<String, Object>(3);
					map.put("servId", userSmsOrder.getServId().toString());
					map.put("smsOrderType", userSmsOrder.getSmsOrderType().toString());
					map.put("phoneId", userSmsOrder.getPhoneId());
					if (userSmsOrder.getSoDate()!=null)
						map.put("soDate", DateHelper.Date2String(userSmsOrder.getSoDate(), "yyyyMMdd"));
					else
						map.put("soDate", "");
					if (userSmsOrder.getValidDate()!=null)
						map.put("validDate", DateHelper.Date2String(userSmsOrder.getValidDate(), "yyyyMMdd"));
					else
						map.put("validDate", "");
					if (userSmsOrder.getExpireDate()!=null)
						map.put("expireDate", DateHelper.Date2String(userSmsOrder.getExpireDate(), "yyyyMMdd"));
					else
						map.put("expireDate", "");
					if (userSmsOrder.getSendDate()!=null)
						map.put("sendDate", DateHelper.Date2String(userSmsOrder.getSendDate(), "yyyyMMdd"));
					else
						map.put("sendDate", "");
					if (userSmsOrder.getSendCount()!=null)
						map.put("sendCount", userSmsOrder.getSendCount().toString());
					else
						map.put("sendCount", "");
					if (userSmsOrder.getRemark()!=null)
						map.put("remark", userSmsOrder.getRemark());
					else
						map.put("remark","");
					result.put(String.valueOf(i), map); 
				}
				else
					userSmsOrderlist.remove(userSmsOrder);
				
			}
			
			if (userSmsOrderlist == null || userSmsOrderlist.size() == 0)
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR, "用户"+msisdn+"不存在个性化定制短信");
			
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
