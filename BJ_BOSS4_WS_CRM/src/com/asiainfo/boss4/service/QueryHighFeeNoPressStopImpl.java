package com.asiainfo.boss4.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.dao.QueryBusinessDao;
import com.asiainfo.boss4.domain.HighFeeNoPressStop;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.FileCache;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.XmlHelper;

public class QueryHighFeeNoPressStopImpl implements QueryBusinessService{
	private static Log logger = LogFactory.getLog(QueryHighFeeNoPressStopImpl.class);
	private BusinessDao businessDao;
	private QueryBusinessDao queryBusinessDao;
	
	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}
	public void setQueryBusinessDao(QueryBusinessDao queryBusinessDao) {
		this.queryBusinessDao = queryBusinessDao;
	}

	public String process(LazyDynaMap vo) {
		// TODO Auto-generated method stub
		TranCode tranCode = TranCode.getInstance((String) vo.get("tranCode"));
		String responseTemplate = FileCache.getXMLFile(tranCode.getTranCode());

		try {
			
			String msisdn = (String) vo.get("msisdn");
			Map<String, List> result = new HashMap();
			HighFeeNoPressStop highFee = new HighFeeNoPressStop();
			List highFeeNoPressStopList = new ArrayList();
			
			if (msisdn == null || "".equals(msisdn)) {
				//throw new BossException(StatusCode.ILLEGAL_INPUT_PROPERTY_ERROR, "msisdn不能为空");
				highFeeNoPressStopList = queryBusinessDao.queryHighFeeNoPressStop();
				//highFeeNoPressStopList = businessDao.getEntityList(highFee, new String[]{"expireDate"});
			}else{
				highFee.setPhoneId(msisdn);
				highFeeNoPressStopList = businessDao.getEntityList(highFee, new String[]{"phoneId", "expireDate"});
			}		
			
			if (highFeeNoPressStopList == null || highFeeNoPressStopList.size() == 0)
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR, "用户"+msisdn+"不在白名单中");
			//for (int i=highFeeNoPressStopList.size()-1;i>=0;i--) {
			for (int i=0;i<highFeeNoPressStopList.size();i++) {
				highFee = (HighFeeNoPressStop)highFeeNoPressStopList.get(i);
				List list = new ArrayList();
				list.add("phoneId="+ highFee.getPhoneId());
				list.add("validDate="+ DateHelper.Date2String(highFee.getValidDate(), AppConstant.DATE_FORMAT));
				list.add("expireDate="+ DateHelper.Date2String(highFee.getExpireDate(), AppConstant.DATE_FORMAT));
				list.add("operDate="+ DateHelper.Date2String(highFee.getOperDate(), AppConstant.DATE_FORMAT));
				if (highFee.getOperId() != null)
					list.add("operId="+ highFee.getOperId());
				else
					list.add("operId= ");
				if (highFee.getHallId() != null)
					list.add("hallId="+ highFee.getHallId());	
				else
					list.add("hallId= ");
				list.add("recId="+ highFee.getRecId().toString());	
				
				result.put(String.valueOf(i), list);
			}
			
			return XmlHelper.buildQueryListOutputXMLExt(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, result,"HighFeeNoPressStop");
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
