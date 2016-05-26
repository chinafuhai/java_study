package com.asiainfo.boss4.service;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.QueryBusinessDao;
import com.asiainfo.boss4.domain.AccBatchDeductOrder;
import com.asiainfo.boss4.domain.AccBatchDeductOrderHis;
import com.asiainfo.boss4.domain.AccSmsTempletDef;
import com.asiainfo.boss4.domain.CrmAccount;
import com.asiainfo.boss4.domain.IUser;
import com.asiainfo.boss4.domain.IUserMonitor;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.Constance;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.FileCache;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.XmlHelper;

public class QueryUserInfoServiceImpl implements QueryBusinessService {
	private static Log logger = LogFactory.getLog(QueryUserInfoServiceImpl.class);
	
	private QueryBusinessDao queryBusinessDao;
	
	public void setQueryBusinessDao(QueryBusinessDao queryBusinessDao) {
		this.queryBusinessDao = queryBusinessDao;
	}

	public String process(LazyDynaMap vo) {
		String phoneNumber = (String) vo.get("msisdn");
		//String sonbr = (String) vo.get("sonbr");
		String order = (String) vo.get("order");
		String ph = (String) vo.get("PHONENUM");
		String st = (String) vo.get("STARTDATE");
		String ed = (String) vo.get("ENDDATE");
		String ty = (String) vo.get("TYPE");
		String templetId = (String) vo.get("templetId");
		String idType = (String) vo.get("idType");
		String idValue = (String) vo.get("idValue");
		String soId = (String) vo.get("soId");
		String servId = (String) vo.get("servId");
		boolean inputError = false;
		if ((phoneNumber == null && ph==null && order==null )&&(templetId == null)
				&&idType == null && idValue == null &&soId == null && servId == null ) {
			logger.error("信息不全");
			if (phoneNumber == null && ph==null && order==null )
				throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR);
			else if (templetId == null)
			{
				StringBuffer retXml = new StringBuffer();
				retXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
						.append("<boss4Result>")
						.append("<item>")
						.append("<tranCode>").append(vo.get("tranCode")).append("</tranCode>")
						.append("<SID>").append(vo.get("soNbr")).append("</SID>")
						.append("<retCode>").append(StatusCode.NO_INPUT_PROPERTITY_ERROR.getCode()).append("</retCode>")
						.append("<retInfo>").append("没有输入templetId").append("</retInfo>")
						.append("<AccSmsTempletDef>")
						.append("<templetId></templetId>")
						.append("<SysCont>")
						.append("<originalSms></originalSms>")
						.append("</SysCont>")
						.append("</AccSmsTempletDef>")
						.append("</item>")
						.append("</boss4Result>");

				return retXml.toString();
			}
			else
				inputError = true;
		}
		TranCode tranCode = TranCode.getInstance((String) vo.get("tranCode"));
		String responseTemplate = FileCache.getXMLFile(tranCode.getTranCode());
		if (inputError)
		{
			return buildQueryOutputXML(StatusCode.NO_INPUT_PROPERTITY_ERROR.getCode(),StatusCode.NO_INPUT_PROPERTITY_ERROR.getDescription(),responseTemplate);
		}
		else if (TranCode.QUERY_SUBSCRIBER_CREDIT.equals(tranCode)) {
			Map<String, Object> result = new HashMap<String, Object>(1);
			result.put("_MSISDN", phoneNumber);
			return XmlHelper.buildQueryOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, result);
		}
		else if (TranCode.QUERY_IS_EXIST_FUTURE_EFFECTIVE_OFFER.equals(tranCode)) {
			return XmlHelper.buildQueryOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, 
					queryBusinessDao.queryIsExistFutureEffectiveOffer(phoneNumber));
		}
		else if (TranCode.QUERY_SMS_SIEBEL.equals(tranCode)){
			return XmlHelper.buildQueryOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, 
					queryBusinessDao.querySmssiebel(ph,ty,st,ed));
		}
		else if (TranCode.QUERY_ORDER.equals(tranCode)){
			return XmlHelper.buildQueryOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, 
					queryBusinessDao.querySonbr(order));
		}
		else if (TranCode.QUERY_MAKEFEE.equals(tranCode)){
			return XmlHelper.buildQueryOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, 
					queryBusinessDao.queryFeetx(phoneNumber));
		}
		else if (TranCode.QUERY_VIPFEE.equals(tranCode)){
			return XmlHelper.buildQueryOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, 
					queryBusinessDao.queryVIP(phoneNumber));
		}
		else if (TranCode.QUERY_IUSERMONITOR.equals(tranCode)){
			List errorResultList = new ArrayList();
			Map<String, Object> errorResult = new HashMap<String, Object>(1);
			errorResult.put("BILLTYPE", null);
			errorResult.put("MONITORFLAG", null);
			errorResult.put("VALIDDATE", null);
			errorResult.put("EXPIREDATE", null);
			errorResult.put("REMARK", null);
			errorResultList.add(errorResult);
			IUser iuser  = queryBusinessDao.queryIUserAllByPhoneNumber(phoneNumber);
			if (iuser == null)
				return XmlHelper.buildBusiOutputXml("Output","RunResult","List",StatusCode.NOT_EXIST_USER_ERROR.getCode(), StatusCode.NOT_EXIST_USER_ERROR.getDescription(), errorResultList);
			BeanCopyHelper.setProperty(vo, "servId", iuser.getServId());
			
			// 根据值对象构造所需的实体对象
			List resultList = new ArrayList();
			try{
				Object entity = BeanCopyHelper.copyToEntity(vo, IUserMonitor.class);
				try{
					String optDate = (String) vo.get("optdate");
					BeanCopyHelper.setProperty(entity, "validDate", DateHelper.String2Date(optDate));
				}catch (Exception e) {
					String optDate = (String) vo.get("optDate");
					BeanCopyHelper.setProperty(entity, "validDate", DateHelper.String2Date(optDate));
				}
				try{
					String remark = (String) vo.get("remark");
					BeanCopyHelper.setProperty(entity, "expireDate", DateHelper.String2Date(remark));
				}catch (Exception e) {
					BeanCopyHelper.setProperty(entity, "expireDate", DateHelper.String2Date(Constance.DEFAULTEXPIREDATE));
				}
				
				BeanCopyHelper.setProperty(entity, "servId", iuser.getServId());
				
				//查询该用户欠费风险记录列表
				List list = queryBusinessDao.queryIUserMonitorEntity(entity);
				StringBuffer validDate = new StringBuffer();
				StringBuffer expireDate = new StringBuffer();
				StringBuffer remark = new StringBuffer();
				if (list.size()==0) {//欠费风险记录不存在
					return XmlHelper.buildBusiOutputXml("Output","RunResult","List",StatusCode.NOT_EXIST_IUSER_MONITOR_ERROR.getCode(), StatusCode.NOT_EXIST_IUSER_MONITOR_ERROR.getDescription(), errorResultList);	
					
				}
				else {//存在多条数据
					for (int i=0;i<list.size();i++)
					{
						Map<String, Object> result = new HashMap<String, Object>(1);
						IUserMonitor iUserMonitor = (IUserMonitor) list.get(i);
						
						result.put("BILLTYPE", iUserMonitor.getBillType().toString());
						result.put("MONITORFLAG", iUserMonitor.getMonitorFlag().toString());
						result.put("VALIDDATE", DateHelper.Date2String(iUserMonitor.getValidDate(),"yyyyMMddHHmmss"));
						result.put("EXPIREDATE", DateHelper.Date2String(iUserMonitor.getExpireDate(),"yyyyMMddHHmmss"));
						result.put("REMARK", iUserMonitor.getRemark());
						resultList.add(result);
					}
				}
			}catch (BossException e){
				return XmlHelper.buildBusiOutputXml("Output","RunResult","List",e.getStatusCode(), e.getMessage(), errorResultList);
			}catch (Exception e){
				return XmlHelper.buildBusiOutputXml("Output","RunResult","List",StatusCode.DB_OPERATION_ERROR.getCode(), StatusCode.DB_OPERATION_ERROR.getDescription(), errorResultList);
			}
			return XmlHelper.buildBusiOutputXml("Output","RunResult","List",StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), resultList);	
		}
		else if (TranCode.QUERY_ACC_BATCH_DEDUCT_ORDER.equals(tranCode))
		{
			short signStatus = 1;			//0：已与手机支付签约；1：未签约；2：已经与其他缴费渠道办理了签约；9：手机号码不存在

			IUser iuser  = queryBusinessDao.queryIUserAllByPhoneNumber(phoneNumber);
			if (iuser == null)
				return XmlHelper.buildBusiOutputXml("Output","RunResult","List",StatusCode.NOT_EXIST_USER_ERROR.getCode(), StatusCode.NOT_EXIST_USER_ERROR.getDescription(), null);
			BeanCopyHelper.setProperty(vo, "servId", iuser.getServId());
			
			// 根据值对象构造所需的实体对象
			Object entity = BeanCopyHelper.copyToEntity(vo, AccBatchDeductOrder.class);
			Object entityHis = BeanCopyHelper.copyToEntity(vo, AccBatchDeductOrderHis.class);
			try{
				String startDate = (String) vo.get("startDate");
				if (startDate!=null )
				{
					if (startDate.length() == 8)
					{
						BeanCopyHelper.setProperty(entity, "effDate", DateHelper.String2Date(startDate, "yyyyMMdd"));
						BeanCopyHelper.setProperty(entityHis, "effDate", DateHelper.String2Date(startDate, "yyyyMMdd"));
					}
					else
					{
						BeanCopyHelper.setProperty(entity, "effDate", DateHelper.String2Date(startDate, "yyyyMMddHHmmss"));
						BeanCopyHelper.setProperty(entityHis, "effDate", DateHelper.String2Date(startDate, "yyyyMMddHHmmss"));
					}
				}
				
			}catch (Exception e) {
				logger.debug("从实体取startDate赋值失败");
				return XmlHelper.buildBusiOutputXml("Output","RunResult","List",StatusCode.ENTITY_PARSE_ERROR.getCode(), "从实体取startDate赋值失败", null);
			}
			try{
				String endDate = (String) vo.get("endDate");
				if (endDate != null)
				{
					if (endDate.length() == 8)
					{
						BeanCopyHelper.setProperty(entity, "expDate", DateHelper.String2Date(endDate, "yyyyMMdd"));
						BeanCopyHelper.setProperty(entityHis, "expDate", DateHelper.String2Date(endDate, "yyyyMMdd"));
					}
					else
					{
						BeanCopyHelper.setProperty(entity, "expDate", DateHelper.String2Date(endDate, "yyyyMMddHHmmss"));
						BeanCopyHelper.setProperty(entityHis, "expDate", DateHelper.String2Date(endDate, "yyyyMMddHHmmss"));
					}
				}
			}catch (Exception e) {
				logger.debug("从实体取optdate赋值失败");
				return XmlHelper.buildBusiOutputXml("Output","RunResult","List",StatusCode.ENTITY_PARSE_ERROR.getCode(), "从实体取endDate赋值失败", null);
			}
			//查询用户签约记录列表
			List signList = queryBusinessDao.queryAccBatchDeductOrderEntity(entity);
//			List unsignList = queryBusinessDao.queryAccBatchDeductOrderEntity(entityHis);
			
			CrmAccount crmAccount = queryBusinessDao.queryCrmAccount(iuser.getAcctId());
			if (crmAccount != null && (crmAccount.getPayType()!= null 
					&&(crmAccount.getPayType().shortValue() == 21
							||crmAccount.getPayType().shortValue() == 22
							||crmAccount.getPayType().shortValue() == 23)))
			{
				signStatus = 2;
			}
			List resultList = new ArrayList();
			for (int i=0;i<signList.size();i++)
			{
				Map<String, Object> result = new HashMap<String, Object>(1);
				AccBatchDeductOrder accBatchDeductOrder = (AccBatchDeductOrder) signList.get(i);
				
				result.put("deductAmount", accBatchDeductOrder.getDeductAmount());
				if (accBatchDeductOrder.getSignBankName().toUpperCase().equals("MPAY"))
				{
					result.put("opId", queryBusinessDao.BossToCrmConvert(accBatchDeductOrder.getOpId(), "2"));
					signStatus = 0;
				}
				else
				{
					result.put("opId",accBatchDeductOrder.getOpId());
					if (signStatus != 0)
						signStatus = 2;
				}
				result.put("remark",accBatchDeductOrder.getRemark());
				result.put("signStatus", signStatus);
				result.put("optDate", DateHelper.Date2String(accBatchDeductOrder.getCreateDate(),"yyyyMMdd"));
				result.put("effDate", DateHelper.Date2String(accBatchDeductOrder.getEffDate(),"yyyyMMdd"));
				result.put("expDate", DateHelper.Date2String(accBatchDeductOrder.getExpDate(),"yyyyMMdd"));
				result.put("signBankName", accBatchDeductOrder.getSignBankName());
				
				resultList.add(result);
			}
			
			
//			for (int i=0;i<unsignList.size();i++)
//			{
//				Map<String, Object> result = new HashMap<String, Object>(1);
//				AccBatchDeductOrderHis accBatchDeductOrder = (AccBatchDeductOrderHis) unsignList.get(i);
//				
//				result.put("effDate", DateHelper.Date2String(accBatchDeductOrder.getEffDate(),"yyyyMMdd"));
//				result.put("expDate", DateHelper.Date2String(accBatchDeductOrder.getExpDate(),"yyyyMMdd"));
//				result.put("signBankName", accBatchDeductOrder.getSignBankName());
//				if (accBatchDeductOrder.getSignStatus() == 0)
//					result.put("signStatus", "解约");
//				else
//					result.put("signStatus", "修改签约金额");
//				result.put("remark",accBatchDeductOrder.getRemark());
//				if (accBatchDeductOrder.getSignBankName().toUpperCase().equals("MPAY"))
//					result.put("opId", queryBusinessDao.BossToCrmConvert(accBatchDeductOrder.getOpId(), "2"));
//				else
//					result.put("opId",accBatchDeductOrder.getOpId());
//				result.put("optDate", DateHelper.Date2String(accBatchDeductOrder.getCreateDate(),"yyyyMMdd"));
//				if (accBatchDeductOrder.getDeductAmount() != null)
//					result.put("deductAmount", accBatchDeductOrder.getDeductAmount());
//				resultList.add(result);
//			}	

			if (resultList.size()==0)
			{
				Map<String, Object> result = new HashMap<String, Object>(1);
				result.put("deductAmount", null);
				result.put("opId", null);
				result.put("remark",null);
				result.put("signStatus", signStatus);
				result.put("optDate", null);
				result.put("effDate", null);
				result.put("expDate", null);
				result.put("signBankName", null);
				
				resultList.add(result);
			}
			return XmlHelper.buildBusiOutputXmlExtr("Output","RunResult","List",StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), resultList);	
			
		}
		else if (TranCode.QUERY_ACCSMSTEMPLETDEF.equals(tranCode))
		{
			StringBuffer retXml = new StringBuffer();
			AccSmsTempletDef accSms = new AccSmsTempletDef();
			accSms.setTempletId(templetId);
			AccSmsTempletDef accSmsTempletDef =(AccSmsTempletDef) queryBusinessDao.getEntity(accSms, accSms.getFieldOfSelectConditionsOnCommonDaoAnnotation());
			
			retXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
					.append("<boss4Result>")
					.append("<item>")
					.append("<tranCode>").append(tranCode.getTranCode()).append("</tranCode>")
					.append("<SID>").append(vo.get("soNbr")).append("</SID>")
					.append("<retCode>").append(StatusCode.SUCCESS.getCode()).append("</retCode>")
					.append("<retInfo>").append(StatusCode.SUCCESS.getDescription()).append("</retInfo>")
					.append("<AccSmsTempletDef>")
					.append("<templetId>").append(templetId).append("</templetId>");
			if (accSmsTempletDef != null)
			{
				String[] templetList = accSmsTempletDef.getSmsTemplet().replaceAll("local strSmsInfo", "").split("strSmsInfo =");
				if (templetList.length <= 1)
					templetList = accSmsTempletDef.getSmsTemplet().replaceAll("local strSmsInfo", "").split("strSmsInfo=");
				for (int i=1;i<templetList.length;i++)
				{
					if (templetList[i].indexOf("\";")>0)
						retXml.append("<SysCont>")
							.append("<originalSms>")
							.append(templetList[i].substring(0,templetList[i].indexOf("\";")))
							.append("\"")
							.append("</originalSms>")
							.append("</SysCont>");
					else if (templetList[i].indexOf(";")>0)
						retXml.append("<SysCont>")
						.append("<originalSms>")
						.append(templetList[i].substring(0,templetList[i].indexOf(";")).trim())
						.append("</originalSms>")
						.append("</SysCont>");
					else
						retXml.append("<SysCont>")
						.append("<originalSms>")
						.append(templetList[i].trim())
						.append("\"")
						.append("</originalSms>")
						.append("</SysCont>");
				}
				if (templetList.length <= 1)
				{
					retXml.append("<SysCont>")
					.append("<originalSms></originalSms>")
					.append("</SysCont>");
				}
			}
			else
			{
				retXml.append("<SysCont>")
				.append("<originalSms></originalSms>")
				.append("</SysCont>");
			}
					
			retXml.append("</AccSmsTempletDef>")
					.append("</item>")
					.append("</boss4Result>");

			return retXml.toString();
		}
		else 
		{
			if ((TranCode.QUERY_IUSER.equals(tranCode)
					|| TranCode.QUERY_ICUSTOMER.equals(tranCode)
					|| TranCode.QUERY_IACCOUNT.equals(tranCode)
					|| TranCode.QUERY_PRODUCT.equals(tranCode)
					|| TranCode.QUERY_USERLIST.equals(tranCode)
					|| TranCode.QUERY_ACCOUNTLIST.equals(tranCode)
					|| TranCode.QUERY_USERPAYRELATIONLIST.equals(tranCode)
					|| TranCode.QUERY_CPC.equals(tranCode)
					|| TranCode.QUERY_BOOKSCHEME.equals(tranCode)
					|| TranCode.QUERY_SPROM.equals(tranCode)
					|| TranCode.QUERY_GROUP.equals(tranCode)) 
				&& (idType == null || idValue == null))
				return buildQueryOutputXML(StatusCode.NO_INPUT_PROPERTITY_ERROR.getCode(),StatusCode.NO_INPUT_PROPERTITY_ERROR.getDescription(),responseTemplate);
			else if ((TranCode.QUERY_SPROMPARAM.equals(tranCode)
					|| TranCode.QUERY_CELL.equals(tranCode)
					|| TranCode.QUERY_USERLATION.equals(tranCode)) 
				&& (soId == null || servId == null))
				return buildQueryOutputXML(StatusCode.NO_INPUT_PROPERTITY_ERROR.getCode(),StatusCode.NO_INPUT_PROPERTITY_ERROR.getDescription(),responseTemplate);
			
			if (TranCode.QUERY_IUSER.equals(tranCode))
			{
				try{
					Map<String, Object> result = queryBusinessDao.queryIUser(idType, idValue);
					if (result == null || result.size() == 0)
						return buildQueryOutputXML(StatusCode.QUERY_ENTITY_NONE_ERROR.getCode(), StatusCode.QUERY_ENTITY_NONE_ERROR.getDescription(), responseTemplate);
					else
						return XmlHelper.buildQueryOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, result);
				}catch (Exception e)
				{
					e.printStackTrace();
					if (e instanceof BossException)
						return buildQueryOutputXML(((BossException)e).getStatusCode(), ((BossException)e).getMessage(), responseTemplate);
					else
						return buildQueryOutputXML(StatusCode.INSIDE_ERROR.getCode(), StatusCode.INSIDE_ERROR.getDescription(), responseTemplate);
				}
			}
			else if (TranCode.QUERY_ICUSTOMER.equals(tranCode))
			{
				try{
					Map<String, Object> result = queryBusinessDao.queryICustomer(idType, idValue);
					if (result == null || result.size() == 0)
						return buildQueryOutputXML(StatusCode.QUERY_ENTITY_NONE_ERROR.getCode(), StatusCode.QUERY_ENTITY_NONE_ERROR.getDescription(), responseTemplate);
					else
						return XmlHelper.buildQueryOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, result);
				}catch (Exception e)
				{
					if (e instanceof BossException)
						return buildQueryOutputXML(((BossException)e).getStatusCode(), ((BossException)e).getMessage(), responseTemplate);
					else
						return buildQueryOutputXML(StatusCode.INSIDE_ERROR.getCode(), StatusCode.INSIDE_ERROR.getDescription(), responseTemplate);
				}
			}
			else if (TranCode.QUERY_USERLIST.equals(tranCode))
			{
				try{
					Map<String, Map<String,Object>> result = queryBusinessDao.queryUserList(idType, idValue);
					if (result == null || result.size() == 0)
						return buildQueryOutputXML(StatusCode.QUERY_ENTITY_NONE_ERROR.getCode(), StatusCode.QUERY_ENTITY_NONE_ERROR.getDescription(), responseTemplate);
					else
						return XmlHelper.buildQueryListOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, result,"IUser");
				}catch (Exception e)
				{
					if (e instanceof BossException)
						return buildQueryOutputXML(((BossException)e).getStatusCode(), ((BossException)e).getMessage(), responseTemplate);
					else
						return buildQueryOutputXML(StatusCode.INSIDE_ERROR.getCode(), StatusCode.INSIDE_ERROR.getDescription(), responseTemplate);
				}
			}
			else if (TranCode.QUERY_ACCOUNTLIST.equals(tranCode))
			{
				try{
					Map<String, Map<String,Object>> result = queryBusinessDao.queryAccountList(idType, idValue);
					if (result == null || result.size() == 0)
						return buildQueryOutputXML(StatusCode.QUERY_ENTITY_NONE_ERROR.getCode(), StatusCode.QUERY_ENTITY_NONE_ERROR.getDescription(), responseTemplate);
					else
						return XmlHelper.buildQueryListOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, result,"IAccount");
				}catch (Exception e)
				{
					if (e instanceof BossException)
						return buildQueryOutputXML(((BossException)e).getStatusCode(), ((BossException)e).getMessage(), responseTemplate);
					else
						return buildQueryOutputXML(StatusCode.INSIDE_ERROR.getCode(), StatusCode.INSIDE_ERROR.getDescription(), responseTemplate);
				}
			}
			else if (TranCode.QUERY_IACCOUNT.equals(tranCode))
			{
				try{
					Map<String, Object> result = queryBusinessDao.queryIAccount(idType, idValue);
					if (result == null || result.size() == 0)
						return buildQueryOutputXML(StatusCode.QUERY_ENTITY_NONE_ERROR.getCode(), StatusCode.QUERY_ENTITY_NONE_ERROR.getDescription(), responseTemplate);
					else
						return XmlHelper.buildQueryOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, result);
				}catch (Exception e)
				{
					if (e instanceof BossException)
						return buildQueryOutputXML(((BossException)e).getStatusCode(), ((BossException)e).getMessage(), responseTemplate);
					else
						return buildQueryOutputXML(StatusCode.INSIDE_ERROR.getCode(), StatusCode.INSIDE_ERROR.getDescription(), responseTemplate);
				}
			}
			else if (TranCode.QUERY_USERPAYRELATIONLIST.equals(tranCode))
			{
				try{
					Map<String, Map<String,Object>> result = queryBusinessDao.queryPayrelationList(idType, idValue);
					if (result == null || result.size() == 0)
						return buildQueryOutputXML(StatusCode.QUERY_ENTITY_NONE_ERROR.getCode(), StatusCode.QUERY_ENTITY_NONE_ERROR.getDescription(), responseTemplate);
					else
						return XmlHelper.buildQueryListOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, result,"IUser");
				}catch (Exception e)
				{
					if (e instanceof BossException)
						return buildQueryOutputXML(((BossException)e).getStatusCode(), ((BossException)e).getMessage(), responseTemplate);
					else
						return buildQueryOutputXML(StatusCode.INSIDE_ERROR.getCode(), StatusCode.INSIDE_ERROR.getDescription(), responseTemplate);
				}
			}
			else if (TranCode.QUERY_CPC.equals(tranCode))
			{
				try{
					Map<String, Map<String,Object>> result = queryBusinessDao.queryIUserOrderList(idType, idValue);
					if (result == null || result.size() == 0)
						return buildQueryOutputXML(StatusCode.QUERY_ENTITY_NONE_ERROR.getCode(), StatusCode.QUERY_ENTITY_NONE_ERROR.getDescription(), responseTemplate);
					else
						return XmlHelper.buildQueryListOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, result,"Cpc");
				}catch (Exception e)
				{
					if (e instanceof BossException)
						return buildQueryOutputXML(((BossException)e).getStatusCode(), ((BossException)e).getMessage(), responseTemplate);
					else
						return buildQueryOutputXML(StatusCode.INSIDE_ERROR.getCode(), StatusCode.INSIDE_ERROR.getDescription(), responseTemplate);
				}
			}
			else if (TranCode.QUERY_BOOKSCHEME.equals(tranCode))
			{
				try{
					Map<String, Map<String,Object>> result = queryBusinessDao.queryBookSchemeList(idType, idValue);
					if (result == null || result.size() == 0)
						return buildQueryOutputXML(StatusCode.QUERY_ENTITY_NONE_ERROR.getCode(), StatusCode.QUERY_ENTITY_NONE_ERROR.getDescription(), responseTemplate);
					else
						return XmlHelper.buildQueryListOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, result,"BookScheme");
				}catch (Exception e)
				{
					if (e instanceof BossException)
						return buildQueryOutputXML(((BossException)e).getStatusCode(), ((BossException)e).getMessage(), responseTemplate);
					else
						return buildQueryOutputXML(StatusCode.INSIDE_ERROR.getCode(), StatusCode.INSIDE_ERROR.getDescription(), responseTemplate);
				}
			}
			else if (TranCode.QUERY_SPROM.equals(tranCode))
			{
				try{
					Map<String, Map<String,Object>> result = queryBusinessDao.querySpromList(idType, idValue);
					if (result == null || result.size() == 0)
						return buildQueryOutputXML(StatusCode.QUERY_ENTITY_NONE_ERROR.getCode(), StatusCode.QUERY_ENTITY_NONE_ERROR.getDescription(), responseTemplate);
					else
						return XmlHelper.buildQueryListOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, result,"UserSprom");
				}catch (Exception e)
				{
					if (e instanceof BossException)
						return buildQueryOutputXML(((BossException)e).getStatusCode(), ((BossException)e).getMessage(), responseTemplate);
					else
						return buildQueryOutputXML(StatusCode.INSIDE_ERROR.getCode(), StatusCode.INSIDE_ERROR.getDescription(), responseTemplate);
				}
			}
			else if (TranCode.QUERY_SPROMPARAM.equals(tranCode))
			{
				try{
					Map<String, Map<String,Object>> result = queryBusinessDao.querySpromParamList(soId, servId);
					if (result == null || result.size() == 0)
						return buildQueryOutputXML(StatusCode.QUERY_ENTITY_NONE_ERROR.getCode(), StatusCode.QUERY_ENTITY_NONE_ERROR.getDescription(), responseTemplate);
					else
						return XmlHelper.buildQueryListOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, result,"SpromParam");
				}catch (Exception e)
				{
					if (e instanceof BossException)
						return buildQueryOutputXML(((BossException)e).getStatusCode(), ((BossException)e).getMessage(), responseTemplate);
					else
						return buildQueryOutputXML(StatusCode.INSIDE_ERROR.getCode(), StatusCode.INSIDE_ERROR.getDescription(), responseTemplate);
				}
			}
			else if (TranCode.QUERY_CELL.equals(tranCode))
			{
				try{
					Map<String, Map<String,Object>> result = queryBusinessDao.queryCellList(soId, servId);
					if (result == null || result.size() == 0)
						return buildQueryOutputXML(StatusCode.QUERY_ENTITY_NONE_ERROR.getCode(), StatusCode.QUERY_ENTITY_NONE_ERROR.getDescription(), responseTemplate);
					else
						return XmlHelper.buildQueryListOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, result,"Cell");
				}catch (Exception e)
				{
					if (e instanceof BossException)
						return buildQueryOutputXML(((BossException)e).getStatusCode(), ((BossException)e).getMessage(), responseTemplate);
					else
						return buildQueryOutputXML(StatusCode.INSIDE_ERROR.getCode(), StatusCode.INSIDE_ERROR.getDescription(), responseTemplate);
				}
			}
			else if (TranCode.QUERY_GROUP.equals(tranCode))
			{
				try{
					Map<String, Map<String,Object>> result = queryBusinessDao.queryGroupList(idType, idValue);
					if (result == null || result.size() == 0)
						return buildQueryOutputXML(StatusCode.QUERY_ENTITY_NONE_ERROR.getCode(), StatusCode.QUERY_ENTITY_NONE_ERROR.getDescription(), responseTemplate);
					else
						return XmlHelper.buildQueryListOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, result,"Group");
				}catch (Exception e)
				{
					if (e instanceof BossException)
						return buildQueryOutputXML(((BossException)e).getStatusCode(), ((BossException)e).getMessage(), responseTemplate);
					else
						return buildQueryOutputXML(StatusCode.INSIDE_ERROR.getCode(), StatusCode.INSIDE_ERROR.getDescription(), responseTemplate);
				}
			}
			else if (TranCode.QUERY_USERLATION.equals(tranCode))
			{
				try{
					Map<String, Map<String,Object>> result = queryBusinessDao.queryUserRelationList(soId, servId);
					if (result == null || result.size() == 0)
						return buildQueryOutputXML(StatusCode.QUERY_ENTITY_NONE_ERROR.getCode(), StatusCode.QUERY_ENTITY_NONE_ERROR.getDescription(), responseTemplate);
					else
						return XmlHelper.buildQueryListOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, result,"UserRelation");
				}catch (Exception e)
				{
					if (e instanceof BossException)
						return buildQueryOutputXML(((BossException)e).getStatusCode(), ((BossException)e).getMessage(), responseTemplate);
					else
						return buildQueryOutputXML(StatusCode.INSIDE_ERROR.getCode(), StatusCode.INSIDE_ERROR.getDescription(), responseTemplate);
				}
			}
			else if (TranCode.QUERY_PRODUCT.equals(tranCode))
			{
				try{
					Map<String, Object> result = queryBusinessDao.queryProduct(idType, idValue);
					if (result == null || result.size() == 0)
						return buildQueryOutputXML(StatusCode.QUERY_ENTITY_NONE_ERROR.getCode(), StatusCode.QUERY_ENTITY_NONE_ERROR.getDescription(), responseTemplate);
					else
						return XmlHelper.buildQueryOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, result);
				}catch (Exception e)
				{
					if (e instanceof BossException)
						return buildQueryOutputXML(((BossException)e).getStatusCode(), ((BossException)e).getMessage(), responseTemplate);
					else
						return buildQueryOutputXML(StatusCode.INSIDE_ERROR.getCode(), StatusCode.INSIDE_ERROR.getDescription(), responseTemplate);
				}
			}
		}
		
		return XmlHelper.buildQueryOutputXML(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDescription(), responseTemplate, 
					queryBusinessDao.queryCrmUser(phoneNumber));
	}
	
	private String buildQueryOutputXML(String code, String desc, String responseTemplate) {
		String outputXML = responseTemplate.replaceAll("\\$\\{_CODE\\}", code).replaceAll("\\$\\{_DESC\\}", desc);
		return outputXML.replaceAll("\\$\\{\\w*\\}", "");
	}
}
