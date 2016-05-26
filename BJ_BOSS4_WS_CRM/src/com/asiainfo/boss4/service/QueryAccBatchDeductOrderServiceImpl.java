package com.asiainfo.boss4.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.QueryBusinessDao;
import com.asiainfo.boss4.domain.CrmAccount;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.FileCache;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.XmlHelper;

public class QueryAccBatchDeductOrderServiceImpl implements QueryBusinessService {
	private static Log logger = LogFactory.getLog(QueryAccBatchDeductOrderServiceImpl.class);
	
	private QueryBusinessDao queryBusinessDao;
	
	public void setQueryBusinessDao(QueryBusinessDao queryBusinessDao) {
		this.queryBusinessDao = queryBusinessDao;
	}
	public String process(LazyDynaMap vo) {
		TranCode tranCode = TranCode.getInstance((String) vo.get("tranCode"));
		String responseTemplate = FileCache.getXMLFile(tranCode.getTranCode());
		short signStatus = 1;			//0：已签约；1：未签约；9：账户不存在

		try {
			
			String acctId = (String) vo.get("acctId");
			if (acctId == null || "".equals(acctId)) {
				return XmlHelper.buildBusiOutputXml("Output","RunResult","List",StatusCode.ENTITY_PARSE_ERROR.getCode(), "从实体取acctId赋值失败", new ArrayList());
			}
			
			//查询用户签约记录列表
			List signList = queryBusinessDao.queryAccBatchDeductOrderList(Long.valueOf(acctId));
			if (signList.size()>0)
				signStatus = 0;
			
			signList = queryBusinessDao.queryAccUserPaymentList(Long.valueOf(acctId));
			if (signList.size()>0)
				signStatus = 0;
			
			CrmAccount crmAccount = queryBusinessDao.queryCrmAccount(Long.valueOf(acctId));
			//判断是否和个人缴费通互斥 (根据zg.crm_account 表中t.pay_type（21为托收，22为个人缴费通，集团充值助理23）)
			if (crmAccount != null && (crmAccount.getPayType()!= null 
					&&(crmAccount.getPayType().shortValue() == 21
							||crmAccount.getPayType().shortValue() == 22
							||crmAccount.getPayType().shortValue() == 23
							)))
			{
				signStatus = 0;
			}
			else if (signStatus == 1 && crmAccount == null)
			{
				signStatus = 9;
			}
			

			List resultList = new ArrayList();
			Map<String, Object> result = new HashMap<String, Object>(1);
			result.put("signStatus", signStatus);
			resultList.add(result);
			return XmlHelper.buildBusiOutputXmlExtr("Output","RunResult","List",StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), resultList);
		} catch (BossException e) {
			e.printStackTrace();
			return XmlHelper.buildBusiOutputXml("Output","RunResult","List",e.getStatusCode(), e.getMessage(), new ArrayList());
		}catch (Exception e) {
			e.printStackTrace();
			return XmlHelper.buildBusiOutputXml("Output","RunResult","List",StatusCode.INSIDE_ERROR.getCode(), StatusCode.INSIDE_ERROR.getDescription(), new ArrayList());
		}
		
	}
}