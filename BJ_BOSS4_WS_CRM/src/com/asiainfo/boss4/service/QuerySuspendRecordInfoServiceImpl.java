package com.asiainfo.boss4.service;

import java.io.StringWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.dao.QueryBusinessDao;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BrandType;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.FileCache;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.XmlHelper;

public class QuerySuspendRecordInfoServiceImpl implements QueryBusinessService {
	private static Log logger = LogFactory.getLog(QuerySuspendRecordInfoServiceImpl.class);
	
	private BusinessDao businessDao;
	
	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}
	
	private QueryBusinessDao queryBusinessDao;
	
	public void setQueryBusinessDao(QueryBusinessDao queryBusinessDao) {
		this.queryBusinessDao = queryBusinessDao;
	}

	public String process(LazyDynaMap vo) {
		String phoneNumber = (String) vo.get("msisdn");
		if (phoneNumber == null) {
			logger.error("没有输入msisdn");
			throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR);
		}
		
		// 取半年以内的状态记录
		Calendar startDate = Calendar.getInstance();
		startDate.setTime(new Date());
		startDate.add(Calendar.MONTH, -6);
		
		// 停开机状态
		List<Map<String, Object>> status = queryBusinessDao.queryUserStatus(phoneNumber, startDate.getTime());
		for (Map<String, Object> s : status) {
			Integer code = Integer.valueOf(s.get("BRAND").toString()) ;
			Long planId = Long.valueOf(s.get("PLAN_ID").toString()) ;
			s.put("_BRAND_DESC", BrandType.getBrandType(code, planId).description());
			Long userSts = Long.valueOf(s.get("USER_STS").toString());
			Long operSts = Long.valueOf(s.get("OPER_STS").toString());
			Long acctSts = Long.valueOf(s.get("ACCT_STS").toString());
			Long mgntSts = Long.valueOf(s.get("MGNT_STS").toString());
			if (userSts.equals(1L) && operSts.equals(0L) && acctSts.equals(0L) && mgntSts.equals(0L)) {
				s.put("_STS", "A");// 正常状态
			}
			if (userSts.equals(11L)) {
				s.put("_STS", "R");// 待激活状态
			}
			if (!operSts.equals(0L) || !acctSts.equals(0L) || !mgntSts.equals(0L)) {
				s.put("_STS", "S");// 停机状态
			}
		}
		
		// 销户状态
		List<Map<String, Object>> cancelUserlogs = queryBusinessDao.queryBusiLog(phoneNumber, TranCode.CANCEL_USER_OF_M_ZONE
				.getTranCode(), startDate.getTime(), new Date());
		for (Map<String, Object> log : cancelUserlogs) {
			log.put("_BRAND_DESC", BrandType.M_ZONE.description());
			log.put("_STS", "C");
			log.put("VALID_DATE", log.get("CREATE_DATE"));
			log.put("EXPIRE_DATE", log.get("CREATE_DATE"));
		}
		
		// 过户状态
		List<Map<String, Object>> transferUserlogs = queryBusinessDao.queryBusiLog(phoneNumber, TranCode.NON_MASTER_TRANSFER_ACCOUNT
				.getTranCode(), startDate.getTime(), new Date());
		for (Map<String, Object> log : transferUserlogs) {
			Object brand = log.get("BRAND");
			Object planId = log.get("PLAN_ID");
			if (brand == null || planId == null) {
				log.put("_BRAND_DESC", "未知品牌");
			} else {
				log.put("_BRAND_DESC", BrandType.getBrandType(Integer.valueOf(brand.toString()), Long.valueOf(planId.toString())).description());
			}
			log.put("_STS", "T");
			log.put("VALID_DATE", log.get("CREATE_DATE"));
			log.put("EXPIRE_DATE", log.get("CREATE_DATE"));
		}
		
		// 合并所有状态列表
		status.addAll(cancelUserlogs);
		status.addAll(transferUserlogs);

		String xmlFile = FileCache.getXMLFile(TranCode.QUERY_SUSPEND_RECORD_INFO.getTranCode());
		try {
			Document document = DocumentHelper.parseText(xmlFile);
			Element root = document.getRootElement();
			// 取需要重复的节点
			Element subscriberInfo = (Element)root.selectNodes("./subscriberInfo").get(0);
			for (Map<String, Object> s : status) {
				Element sElement = (Element) subscriberInfo.createCopy();
				for (Element ele : (List<Element>)sElement.elements()) {
					String key = ele.getText();
					if (key.matches("\\$\\{\\w*\\}")) {// 如果节点的值匹配${***}的话，用数据记录对应的字段值替换
						Object value = s.get( key.substring(2, key.indexOf("}")) );
						if (value == null) {
							continue;
						}
						ele.setText( value instanceof java.util.Date ? DateHelper.Date2String((Date) value): value.toString() );
					}
				}
				root.add(sElement);
			}
			root.remove(subscriberInfo);
			
			// 格式化输出xml
			StringWriter writer = new StringWriter();
			new XMLWriter(writer, OutputFormat.createPrettyPrint()).write(document);
			
			Map<String, Object> responseMap = new LinkedHashMap<String, Object>();
			responseMap.put("PHONE_ID", phoneNumber);
			return XmlHelper.buildQueryOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), 
					writer.toString(), responseMap);
		} catch (Exception e) {
			logger.error("构造XML响应报文失败");
			throw new BossException(StatusCode.XML_PARSE_ERROR, e);
		}
		
	}

}
