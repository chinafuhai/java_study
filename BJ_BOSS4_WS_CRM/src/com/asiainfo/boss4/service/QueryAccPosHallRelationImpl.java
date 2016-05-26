package com.asiainfo.boss4.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.domain.AccPosHallRelation;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.FileCache;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.XmlHelper;

public class QueryAccPosHallRelationImpl implements QueryBusinessService{
	private static Log logger = LogFactory.getLog(QueryHighFeeNoPressStopImpl.class);
	private BusinessDao businessDao;
	
	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}

	public String process(LazyDynaMap vo) {
		// TODO Auto-generated method stub
		TranCode tranCode = TranCode.getInstance((String) vo.get("tranCode"));
		String responseTemplate = FileCache.getXMLFile(tranCode.getTranCode());

		try {
			
			String hallNo = (String) vo.get("hallNo");
			String posNo = (String) vo.get("posNo");
			if ((hallNo == null || "".equals(hallNo))&&(posNo == null || "".equals(posNo))) {
				throw new BossException(StatusCode.ILLEGAL_INPUT_PROPERTY_ERROR, "hallNo和posNo不能均为空");
			}		
			
			Map<String, List> result = new HashMap();
			
			AccPosHallRelation accPosHall = new AccPosHallRelation();
			String[] queryCondition = null;
			if (hallNo != null && !"".equals(hallNo)) 
			{
				accPosHall.setHallNo(hallNo);
				queryCondition = new String[]{"hallNo"};
			}
			if (posNo != null && !"".equals(posNo))
			{
				accPosHall.setPosNo(posNo);
				if (queryCondition == null || queryCondition.length == 0)
					queryCondition = new String[]{"posNo"};
				else
					queryCondition = new String[]{"hallNo","posNo"};
			}
			
			List accPosHallList = businessDao.getEntityList(accPosHall, queryCondition);
			
			if (accPosHallList == null || accPosHallList.size() == 0)
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR, "没有POS商户数据");
			for (int i=accPosHallList.size()-1;i>=0;i--)
			{
				accPosHall = (AccPosHallRelation)accPosHallList.get(i);
				List list = new ArrayList();
				list.add("bankCode="+ accPosHall.getBankCode());
				list.add("hallNo="+ accPosHall.getHallNo());
				list.add("posNo="+ accPosHall.getPosNo());
				
				result.put(String.valueOf(i), list);
			}
			
			
			return XmlHelper.buildQueryListOutputXMLExt(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, result,"AccPosHallRelation");
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
