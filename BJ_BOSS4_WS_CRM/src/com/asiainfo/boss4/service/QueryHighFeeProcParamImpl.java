package com.asiainfo.boss4.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.collections.map.LinkedMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.domain.HighFeeProcParam;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.FileCache;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.XmlHelper;

public class QueryHighFeeProcParamImpl implements QueryBusinessService{
	private static Log logger = LogFactory.getLog(QueryHighFeeProcParamImpl.class);
	private BusinessDao businessDao;
	
	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}

	public String process(LazyDynaMap vo) {
		// TODO Auto-generated method stub
		TranCode tranCode = TranCode.getInstance((String) vo.get("tranCode"));
		String responseTemplate = FileCache.getXMLFile(tranCode.getTranCode());

		try {
			
			String paramName = (String) vo.get("paramName");
			
			Map<String, List> result = new HashMap();
			HighFeeProcParam highFee = new HighFeeProcParam();
			List highFeeList;
			if (paramName != null && !"".equals(paramName))
			{
				highFee.setParamName(paramName);
				highFeeList = businessDao.getEntityList(highFee, new String[]{"paramName"});
			}
			else
				highFeeList = businessDao.getEntityListExt(highFee, new String[]{});
			
			
			if (highFeeList == null)
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR, "没有参数");
			for (int i=highFeeList.size()-1;i>=0;i--)
			{
				highFee = (HighFeeProcParam)highFeeList.get(i);
				List list = new ArrayList();
				list.add("paramName="+highFee.getParamName());
				list.add("paramValue="+ highFee.getParamValue());
				if (highFee.getParamDesc()!=null)
					list.add("paramDesc="+highFee.getParamDesc());
				else
					list.add("paramDesc= ");
				list.add("operDate="+ DateHelper.Date2String(highFee.getOperDate(), AppConstant.DATE_FORMAT));
				if (highFee.getOperId() != null)
					list.add("operId="+ highFee.getOperId());
				else
					list.add("operId= ");
				if (highFee.getHallId() != null)
					list.add("hallId="+ highFee.getHallId());	
				else
					list.add("hallId= ");
				
				result.put(String.valueOf(i), list);
			}
			return XmlHelper.buildQueryListOutputXMLExt(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, result,"HighFeeProcParam");
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
