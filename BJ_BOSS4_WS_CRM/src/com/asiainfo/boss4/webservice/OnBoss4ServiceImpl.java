package com.asiainfo.boss4.webservice;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.asiainfo.boss4.action.BusinessAction;
import com.asiainfo.boss4.action.BusinessCrmAction;
import com.asiainfo.boss4.domain.IRentNotify;
import com.asiainfo.boss4.domain.InBusiBatch;
import com.asiainfo.boss4.domain.InvoicePayFeeIn;
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.service.InBusiBatchService;
import com.asiainfo.boss4.service.QueryCrmIdService;
import com.asiainfo.boss4.support.AppConfig;
import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.Constance;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.FileCache;
import com.asiainfo.boss4.support.OperateType;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.XmlHelper;
import com.asiainfo.obd.AccPrtInv.CORBASystemException;
import com.asiainfo.obd.AccPrtInv.MObdCommonSOBSessionProperty;
import com.asiainfo.obd.AccPrtInv.ObIdl_MAccPrtInvDefSInvcQryIn;
import com.asiainfo.obd.AccPrtInv.holders.MObdCommonSCbsErrorMsgHolder;
import com.asiainfo.obd.AccPrtInv.holders.ObIdl_MAccCommonSAccInvcRecInfoListHolder;

/**
 * Web Service 实现类
 * 
 * @author caohui
 * 
 */
public class OnBoss4ServiceImpl implements OnBoss4Service {
	private static Log logger = LogFactory.getLog(OnBoss4ServiceImpl.class);

	private BusinessAction businessAction;
	private BusinessAction queryAction;
	private BusinessAction cpcOrderAction;
	private BusinessCrmAction businessCrmAction;
	private InBusiBatchService inBusiBatchService;
	private QueryCrmIdService queryCrmIdService;

	public void setBusinessAction(BusinessAction businessAction) {
		this.businessAction = businessAction;
	}
	
	public void setQueryAction(BusinessAction queryAction) {
		this.queryAction = queryAction;
	}

	public void setCpcOrderAction(BusinessAction cpcOrderAction) {
		this.cpcOrderAction = cpcOrderAction;
	}

	public BusinessCrmAction getBusinessCrmAction() {
		return businessCrmAction;
	}

	public void setBusinessCrmAction(BusinessCrmAction businessCrmAction) {
		this.businessCrmAction = businessCrmAction;
	}

	public void setInBusiBatchService(InBusiBatchService inBusiBatchService) {
		this.inBusiBatchService = inBusiBatchService;
	}

	public void setQueryCrmIdService(QueryCrmIdService queryCrmIdService) {
		this.queryCrmIdService = queryCrmIdService;
	}

	@SuppressWarnings("finally")
	public String onBoss4(String inputXml) {
		logger.debug("开始处理Web Service请求");
		logger.info("请求XML=> " + inputXml);

		String outputXml = null;
		try {
			outputXml = this.dispatch(inputXml);

//			if (responses != null) {// 查询boss id时，将操作员ID和营业厅ID写到返回信息描述中，应EAI要求，临时添加
//				outputXml = XmlHelper.buildOutputXml(StatusCode.SUCCESS.getCode(),
//						responses);
//			} else {
//				outputXml = XmlHelper.buildOutputXml(StatusCode.SUCCESS.getCode(),StatusCode.SUCCESS.getDescription());
//			}
			
		} catch (BossException e) {// 捕获手动抛出的异常
			logger.error("捕获到系统自定义异常", e);
			StringBuffer errorMessage = new StringBuffer(e.getMessage());
			if (e.getTraceMessage() != null) {
				errorMessage.append(". 详细异常信息：").append(e.getTraceMessage());
			}
			outputXml = XmlHelper.buildOutputXml(e.getStatusCode(),
					errorMessage.toString(), e.getTranCode(), e.getSid());
		} catch (Throwable e) {// 捕获系统自身抛出的内部异常
			logger.error("捕获到严重的不可恢复异常", e);
			outputXml = XmlHelper.buildOutputXml(StatusCode.INSIDE_ERROR
					.getCode(), StatusCode.INSIDE_ERROR.getDescription());
		} finally {
			logger.info("响应XML=> " + outputXml);
			logger.debug("Web Service请求处理完成");
			return outputXml;
		}

	}
	
	public String dispatch(String inputXml) {
		
		if (inputXml == null || "".equals(inputXml)) {
			logger.error("传入XML为空");
			throw new BossException(StatusCode.INPUT_IS_NULL_ERROR);
		}
		
//		if (AppConfig.isValidateXmlWithXsd()) {
//			// 从配置中取xsd定义，校验输入xml数据的正确性
//			String xsd = AppConfig.getXsdString(XmlHelper.parseRootElementName(inputXml));
//			InputStream xmlStream = IOUtils.toInputStream(inputXml);
//			InputStream xsdStream = IOUtils.toInputStream(xsd);
//			XmlHelper.validate(xmlStream, xsdStream);
//		}
		
		// 解析xml，转换为值对象列表，一个交易（即一个item节点）对应一个值对象
		List<LazyDynaMap> voList = XmlHelper.parseToVoList(inputXml);

		// 检查是否包含item节点，每个item节点代表一个业务调用
		if (voList.size() == 0) {
			throw new BossException(StatusCode.XML_PARSE_ERROR);
		}
		
		// 检查是否包含查询接口，查询接口只能单独请求
		boolean isQueryAction = false;
		for (LazyDynaMap vo : voList) {
			String tranCode = (String) vo.get("tranCode");
			if (TranCode.isQueryTranCode(tranCode)) {
				if (voList.size() != 1 && !TranCode.QUERY_PROD_OUT_SP.getTranCode().equals(tranCode)) {
					throw new BossException(StatusCode.QUERY_MANY_TRANCODE_ERROR);
				}
				isQueryAction = true;
			}
		}
		
		voList.get(0).set("inputXml", inputXml);
		String outputXml = null;
		Map requestStatus = new HashMap();
		requestStatus.put(AppConstant.REQUEST_STATUS_MAP_IS_BREAK, false);
		// 初始化变量，默认每个service记录日志
		requestStatus.put(AppConstant.REQUEST_STATUS_MAP_IS_LOGGING_TO_DB, true);
		
		if (isQueryAction) {
			String responseTemplate = FileCache.getXMLFile((String) voList.get(0).get("tranCode"));
			try {
				return queryAction.dispatch(voList, requestStatus);
			} catch (BossException e) {// 捕获手动抛出的异常
				logger.error("捕获到系统自定义异常", e);
				StringBuffer errorMessage = new StringBuffer(e.getMessage());
				if (e.getTraceMessage() != null) {
					errorMessage.append(". 详细异常信息：").append(e.getTraceMessage());
				}
//				outputXml = XmlHelper.buildQueryOutputXML(e.getStatusCode(), errorMessage.toString(), responseTemplate, null);
				outputXml = XmlHelper.buildQueryOutputXMLWithTranCode((String) voList.get(0).get("tranCode"),(String) voList.get(0).get("soNbr"),e.getStatusCode(), errorMessage.toString(), responseTemplate, null);
			} catch (Throwable e) {// 捕获系统自身抛出的内部异常
				logger.error("捕获到严重的不可恢复异常", e);
//				outputXml = XmlHelper.buildQueryOutputXML(StatusCode.INSIDE_ERROR.getCode(), StatusCode.INSIDE_ERROR.getDescription(), responseTemplate, null);
				outputXml = XmlHelper.buildQueryOutputXMLWithTranCode((String) voList.get(0).get("tranCode"),(String) voList.get(0).get("soNbr"),StatusCode.INSIDE_ERROR.getCode(), e.getMessage(), responseTemplate, null);
			}
		} else{
			try {
				String responses = businessAction.dispatch(voList, requestStatus);

				if (responses != null) {// 查询boss id时，将操作员ID和营业厅ID写到返回信息描述中，应EAI要求，临时添加
					outputXml = XmlHelper.buildOutputXml(StatusCode.SUCCESS.getCode(),
							responses);
				} else {
					outputXml = XmlHelper.buildOutputXml(StatusCode.SUCCESS.getCode(),StatusCode.SUCCESS.getDescription());
				}
				
			} catch (BossException e) {// 捕获手动抛出的异常
				logger.error("捕获到系统自定义异常", e);
				StringBuffer errorMessage = new StringBuffer(e.getMessage());
				if (e.getTraceMessage() != null) {
					errorMessage.append(". 详细异常信息：").append(e.getTraceMessage());
				}
				outputXml = XmlHelper.buildOutputXml(e.getStatusCode(),
						errorMessage.toString(), e.getTranCode(), e.getSid());
			} catch (Throwable e) {// 捕获系统自身抛出的内部异常
				logger.error("捕获到严重的不可恢复异常", e);
				outputXml = XmlHelper.buildOutputXml(StatusCode.INSIDE_ERROR
						.getCode(), StatusCode.INSIDE_ERROR.getDescription());
			}
		}
		
		return outputXml;
		
	}
	
	public String onBoss4BatchKt(String inputXml) {
		return this.batchBusi(inputXml, "1");
	}
	
	public String onBoss4Batch(String inputXml) {
		return this.batchBusi(inputXml, "2");
	}
	
	private String batchBusi(String inputXml, String batchType) {
		logger.info("请求XML=> " + inputXml);
		String outputXml = null;
		Map map = null;
		try {
			map = XmlHelper.parseToInBusiBatch(inputXml, batchType);
			inBusiBatchService.saveBatchData(map);
			outputXml = XmlHelper.buildBatchBusiOutputXml(((InBusiBatch)map.get("inBusiBatch")).getBatchid(), map.get("busiType").toString(), "0",StatusCode.SUCCESS.getDescription());
			logger.info(outputXml);
		} catch (BossException e) {// 捕获手动抛出的异常
			logger.error("捕获到系统自定义异常", e);
			StringBuffer errorMessage = new StringBuffer(e.getMessage());
			if (e.getTraceMessage() != null) {
				errorMessage.append(". 详细异常信息：").append(e.getTraceMessage());
			}
			outputXml = XmlHelper.buildBatchBusiOutputXml(((InBusiBatch)map.get("inBusiBatch")).getBatchid(), map.get("busiType").toString(), e.getStatusCode(),	errorMessage.toString());
		} catch (Throwable e) {// 捕获系统自身抛出的内部异常
			logger.error("捕获到严重的不可恢复异常", e);
			outputXml = XmlHelper.buildBatchBusiOutputXml(((InBusiBatch)map.get("inBusiBatch")).getBatchid(), map.get("busiType").toString(), StatusCode.INSIDE_ERROR.getCode(), StatusCode.INSIDE_ERROR.getDescription());
		}
		return outputXml;
	}

	@SuppressWarnings({ "finally", "rawtypes", "unchecked" })
	public String onCpcOrder(String inputXml) {
		logger.debug("开始处理Web Service请求");
		logger.info("请求XML=> " + inputXml);

		String outputXml = null;
		try {
			// 解析xml，转换为值对象列表，一个交易（即一个item节点）对应一个值对象
			List<LazyDynaMap> voList = XmlHelper.parseCpcXmlToVoList(inputXml);
		
			Map requestStatus = new HashMap();
			requestStatus.put(AppConstant.REQUEST_STATUS_MAP_IS_BREAK, false);
			// 初始化变量，默认每个service记录日志
			requestStatus.put(AppConstant.REQUEST_STATUS_MAP_IS_LOGGING_TO_DB, true);
		
			cpcOrderAction.dispatch(voList,requestStatus);
			outputXml = XmlHelper.buildOutputXml(StatusCode.SUCCESS.getCpcRspCode(), "成功");
			//outputXml = XmlHelper.buildCpcOutputXml(inputXml, "0", StatusCode.SUCCESS.getCpcRspCode(), "成功");
		} catch (BossException e) {// 捕获手动抛出的异常
			logger.error("捕获到系统自定义异常", e);
			StringBuffer errorMessage = new StringBuffer(e.getMessage());
			if (e.getTraceMessage() != null) {
				errorMessage.append(". 详细异常信息：").append(e.getTraceMessage());
			}
			outputXml = XmlHelper.buildOutputXml(e.getStatus().getCpcRspCode(), errorMessage.toString());
			//outputXml = XmlHelper.buildCpcOutputXml(inputXml, "1", e.getStatus().getCpcRspCode(), errorMessage.toString());
		} catch (Throwable e) {// 捕获系统自身抛出的内部异常
			logger.error("捕获到严重的不可恢复异常", e);
			outputXml = XmlHelper.buildOutputXml(StatusCode.INSIDE_ERROR.getCpcRspCode(), StatusCode.INSIDE_ERROR.getDescription());
			//outputXml = XmlHelper.buildCpcOutputXml(inputXml, "1", StatusCode.INSIDE_ERROR.getCpcRspCode(), StatusCode.INSIDE_ERROR.getDescription());
		} finally {
			logger.info("响应XML=> " + outputXml);
			logger.debug("Web Service请求处理完成");
			return outputXml;
		}
	}
	
	public String onBoss4Crm(String inputXml) {
		logger.debug("开始处理Web Service请求");
		logger.info("请求XML=> " + inputXml);
		
		String outputXml = null;
		try {
			
			outputXml = this.dispatchCrm(inputXml);
			
		} catch (BossException e) {// 捕获手动抛出的异常
			logger.error("捕获到系统自定义异常", e);
			StringBuffer errorMessage = new StringBuffer(e.getMessage());
			if (e.getTraceMessage() != null) {
				errorMessage.append(". 详细异常信息：").append(e.getTraceMessage());
			}
			outputXml = XmlHelper.buildOutputXml(e.getStatusCode(),
					errorMessage.toString(), e.getTranCode(), e.getSid());
		} catch (Throwable e) {// 捕获系统自身抛出的内部异常
			logger.error("捕获到严重的不可恢复异常", e);
			outputXml = XmlHelper.buildOutputXml(StatusCode.INSIDE_ERROR
					.getCode(), StatusCode.INSIDE_ERROR.getDescription());
		} finally {
			logger.info("响应XML=> " + outputXml);
			logger.debug("Web Service请求处理完成");
			return outputXml;
		}

	}
	public String dispatchCrm(String inputXml) {
		
		if (inputXml == null || "".equals(inputXml)) {
			logger.error("传入XML为空");
			throw new BossException(StatusCode.INPUT_IS_NULL_ERROR);
		}
		
//		if (AppConfig.isValidateXmlWithXsd()) {
//			// 从配置中取xsd定义，校验输入xml数据的正确性
//			String xsd = AppConfig.getXsdString(XmlHelper.parseRootElementName(inputXml));
//			InputStream xmlStream = IOUtils.toInputStream(inputXml);
//			InputStream xsdStream = IOUtils.toInputStream(xsd);
//			XmlHelper.validate(xmlStream, xsdStream);
//		}
		
		// 解析xml，转换为值对象列表，一个交易（即一个item节点）对应一个值对象
		String outputXml = null;
		String strSoNbr = "";
		String strRollBackSoNbr = "";
		String strTranCode = "";
		try{
			List<Object> voList = XmlHelper.parseToCrmList(inputXml);

			// 检查是否包含item节点，每个item节点代表一个业务调用
			if (voList.size() == 0) {
				throw new BossException(StatusCode.XML_PARSE_ERROR);
			}
			
				
			Map requestStatus = new HashMap();
			requestStatus.put(AppConstant.REQUEST_STATUS_MAP_IS_BREAK, false);
			// 初始化变量，默认每个service记录日志
			requestStatus.put(AppConstant.REQUEST_STATUS_MAP_IS_LOGGING_TO_DB, true);		
			List entityAllList = new ArrayList();
			List<com.asiainfo.boss4.support.VoErrorData> errorList = new ArrayList();
			List<com.asiainfo.boss4.support.VoTranCode> tranCodeList =  new ArrayList();
			List<InvoicePayFeeIn> invoicePayFeeInList = new ArrayList();
			List<com.asiainfo.boss4.domain.ext.OneTimePayment> oneTimePaymentList = new ArrayList();
			List<LazyDynaMap> cpcList = new ArrayList();
			List<BaseEntity> crmUserList = new ArrayList();
			List<BaseEntity> allCrmUserList = new ArrayList();
			List<BaseEntity> happyProductList = new ArrayList();
			List<com.asiainfo.boss4.domain.TranBill> tranBillList = new ArrayList();
			List<com.asiainfo.boss4.domain.PreTran> preTranBillList = new ArrayList();
			IRentNotify rentNotify = new IRentNotify(); 
			List soNbrList = new ArrayList();
			List rollBackSoNbrList = new ArrayList();
			for (int i = 0; i < voList.size(); i++) {
				List list = (List)voList.get(i);
				//将异常节点、tran_code数据放到requestStatus中
				List<BaseEntity> entityList = new ArrayList();
				List<BaseEntity> cancelList = new ArrayList();
				List<BaseEntity> modifyList = new ArrayList();
				List<BaseEntity> addList = new ArrayList();
				List<BaseEntity> accBookChgNotifyList = new ArrayList();
				List<BaseEntity> isaleOperList = new ArrayList();
				List<BaseEntity> centrexList = new ArrayList();
				List<BaseEntity> addSpromList = new ArrayList();
				List<BaseEntity> modifySpromList = new ArrayList();
				List<BaseEntity> cancelSpromList = new ArrayList();
				List<BaseEntity> addParamList = new ArrayList();
				List<BaseEntity> modifyParamList = new ArrayList();
				List<BaseEntity> cancelParamList = new ArrayList();
				boolean foundVoError = false;
				boolean foundVoTranCode = false;
				boolean foundSoNbr = false;
				boolean foundRollBackSoNbr = false;

				for (int j=0;j<list.size();j++){
					Object vo = (Object) list.get(j);
					if (vo instanceof com.asiainfo.boss4.support.VoErrorData)
					{
						//requestStatus.put(AppConstant.ERRORNODENAME, vo);
						errorList.add((com.asiainfo.boss4.support.VoErrorData)vo);
						foundVoError = true;
						continue;
					}
					else if (vo instanceof com.asiainfo.boss4.support.VoTranCode)
					{
						//requestStatus.put(AppConstant.TRANCODE, vo);
						tranCodeList.add((com.asiainfo.boss4.support.VoTranCode)vo);
						foundVoTranCode = true;
						strTranCode = ((com.asiainfo.boss4.support.VoTranCode)vo).getTranCode();
						continue;
					}
					else if (vo instanceof java.lang.String)
					{
						strSoNbr = vo.toString();
						//requestStatus.put(AppConstant.SONBR, Long.decode(strSoNbr));
						soNbrList.add(Long.decode(strSoNbr));
						foundSoNbr = true;
						requestStatus.put(AppConstant.SODATE, new Date());
						continue;
					}
					else if (vo instanceof InvoicePayFeeIn)
					{
						//requestStatus.put(AppConstant.INVOICEPAYFEEIN, vo);
						invoicePayFeeInList.add((InvoicePayFeeIn)vo);
						continue;
					}
					else if (vo instanceof com.asiainfo.boss4.domain.ext.OneTimePayment)
					{
						//requestStatus.put(AppConstant.ONETIMEPAYMENTIN, vo);
						oneTimePaymentList.add((com.asiainfo.boss4.domain.ext.OneTimePayment)vo);
						continue;
					}
					else if (vo instanceof com.asiainfo.boss4.domain.TranBill)
					{
						tranBillList.add((com.asiainfo.boss4.domain.TranBill)vo);
						continue;
					}
					else if (vo instanceof com.asiainfo.boss4.domain.PreTran)
					{
						preTranBillList.add((com.asiainfo.boss4.domain.PreTran)vo);
						continue;
					}
					else if (vo instanceof java.lang.Long)
					{
						strRollBackSoNbr = vo.toString();
						rollBackSoNbrList.add(Long.decode(strRollBackSoNbr));
						foundRollBackSoNbr = true;
						continue;
					}
					else if (vo instanceof IRentNotify)
						rentNotify = (IRentNotify)vo;
					
					// 如果传入的失效时间为本月底，则重置成下月初
					PropertyDescriptor origDescriptors[] = PropertyUtils.getPropertyDescriptors(vo);
					for (int k = 0; k < origDescriptors.length; k++) {
						String name = origDescriptors[k].getName();
						if (name.equals("expireDate") || name.endsWith("ExpireDate") || name.equals("expDate")) {
							if (BeanCopyHelper.existField(vo.getClass(), name) && BeanCopyHelper.getProperty(vo, name) != null)
							{
								String value = DateHelper.Date2String((Date)BeanCopyHelper.getProperty(vo, name));
								
								java.util.Date expireDate = DateHelper.String2Date(value);
								// 计算出下月初日期(第一天零时)
								java.util.Date nextMonthFirstDay = DateHelper.getNextMonthFirstDay(expireDate);
								// 计算出本月末日期(最后一秒)
								String currentMonthLastSecond = new SimpleDateFormat(AppConfig.getDateFormat()).format(nextMonthFirstDay.getTime()-1);
//								// 计算出本月末日期(最后一天零时)
//								String currentMonthLastDay = new SimpleDateFormat(AppConfig.getDateFormat()).format(DateHelper.getCurrentMonthLastDay());
								
								/*
								 * 两种情况需要重置expireDate为下月初（第一天零时）
								 * 1. 传入的日期为本月末最后一秒
								 * 2. 传入的日期为传入月份的最后一天零时
								 */
								if (value.equals(currentMonthLastSecond) || DateHelper.isLastDayInMonth(expireDate)) {
									BeanCopyHelper.setProperty(vo,name ,nextMonthFirstDay);
								}
							}
						}
					}
					
					if (strTranCode.equals(TranCode.CRM_HAPPY_PRODUCT.getTranCode()) 
							&& vo instanceof com.asiainfo.boss4.domain.IUserSprom
							&& ((com.asiainfo.boss4.domain.IUserSprom)vo).getSpromId().intValue() == Integer.decode(Constance.CRMHAPPYPRODUCT).intValue()
							&& ((com.asiainfo.boss4.domain.IUserSprom)vo).getOperType().intValue() != 1)
					{
						happyProductList.add((BaseEntity)vo);
						continue;
					}
					
					if (vo instanceof com.asiainfo.boss4.domain.CrmUser)
					{
//						if (((com.asiainfo.boss4.domain.CrmUser)vo).getUserSts().intValue() == Integer.decode(Constance.UNUSEDUSERSTS).intValue())
						crmUserList.clear();
						crmUserList.add((BaseEntity)vo);
						allCrmUserList.add((BaseEntity)vo);
						continue;

					}
					if (vo instanceof com.asiainfo.boss4.domain.AccBookChgNotify)
					{
						accBookChgNotifyList.add((BaseEntity)vo);
						continue;
					}
					else if (vo instanceof com.asiainfo.boss4.domain.ISaleOper)
					{
						isaleOperList.add((BaseEntity)vo);
						continue;
					}
					else if (vo instanceof com.asiainfo.boss4.domain.IUser)
					{
						if (((com.asiainfo.boss4.domain.IUser)vo).getUserType().shortValue() == Constance.CENTREXUSERTYPE)
						{
							centrexList.add((BaseEntity)vo);
							continue;
						}
					}
					//先做取消/删除，再做更新失效时间/变更，最后做新增
					try{
						OperateType operType = (OperateType)BeanCopyHelper.getProperty(vo, "theOperateType");
						if (operType != null &&(OperateType.CANCEL.compareTo(operType) == 0
								||OperateType.REMOVE.compareTo(operType) == 0))
						{
							if (vo instanceof com.asiainfo.boss4.domain.IUserSprom)
								cancelSpromList.add((BaseEntity)vo);
							else if (vo instanceof com.asiainfo.boss4.domain.ISpromParam)
								cancelParamList.add((BaseEntity)vo);
							else
								cancelList.add((BaseEntity)vo);
						}
						else if (operType != null &&(OperateType.EXTEND.compareTo(operType) == 0
								||OperateType.MODIFY.compareTo(operType) == 0))
						{
							if (vo instanceof com.asiainfo.boss4.domain.IUserSprom)
								modifySpromList.add((BaseEntity)vo);
							else if (vo instanceof com.asiainfo.boss4.domain.ISpromParam)
								modifyParamList.add((BaseEntity)vo);
							else
								modifyList.add((BaseEntity)vo);
						}
						else
						{
							if (vo instanceof com.asiainfo.boss4.domain.IUserSprom)
								addSpromList.add((BaseEntity)vo);
							else if (vo instanceof com.asiainfo.boss4.domain.ISpromParam)
								addParamList.add((BaseEntity)vo);
							else
								addList.add((BaseEntity)vo);				
						}
					}catch (Exception e){
						;
					}
				}
				if (!foundVoError) 
					//errorList.add(new com.asiainfo.boss4.support.VoErrorData());
					errorList.add(null);
				if (!foundVoTranCode) throw new BossException(StatusCode.NO_INPUT_TRANCODE_ERROR);
				if (!foundSoNbr) throw new BossException(StatusCode.ILLEGAL_INPUT_PROPERTY_ERROR);
				if (!foundRollBackSoNbr) rollBackSoNbrList.add(Long.decode("0"));
				
				if (centrexList.size()>0){
					for(int k=0;k<centrexList.size();k++)
					{
						com.asiainfo.boss4.domain.IUser vo = (com.asiainfo.boss4.domain.IUser)centrexList.get(k);
						OperateType operType = (OperateType)BeanCopyHelper.getProperty(vo, "theOperateType");
						if (operType != null &&(OperateType.CANCEL.compareTo(operType) == 0
								||OperateType.REMOVE.compareTo(operType) == 0))
							cancelList.add((BaseEntity)vo);
						else if (operType != null &&(OperateType.EXTEND.compareTo(operType) == 0
								||OperateType.MODIFY.compareTo(operType) == 0))
							modifyList.add((BaseEntity)vo);
						else
							entityList.add((BaseEntity)vo);	
					}
				}
				//为了品牌转换时设置套餐的planId为真实的planId，需要将CrmUser放到最前面
				entityList.addAll(crmUserList);
				entityList.addAll(cancelList);
				entityList.addAll(cancelParamList);
				entityList.addAll(cancelSpromList);
				entityList.addAll(modifyList);
				entityList.addAll(modifyParamList);
				entityList.addAll(modifySpromList);
				entityList.addAll(addList);
				entityList.addAll(addSpromList);
				entityList.addAll(addParamList);
				
				//ISaleOper要放在后面，便于销户程序重置upfield
				entityList.addAll(isaleOperList);
				if (happyProductList != null && happyProductList.size()>0)
					entityList.addAll(happyProductList);
				//AccBookChgNotify必须放到 最后 
				entityList.addAll(accBookChgNotifyList);

				entityList = EntityPartitionHelper.replaceToPartitionList(entityList, true);
				entityAllList.add(entityList);
	
			}
			//增加报文类型判断，包含UDR的是CPC业务，需要调CPC接口
			if (XmlHelper.parseBusiType(inputXml) == 1)
			{
				cpcList = XmlHelper.parseCpcXmlToVoList(inputXml);
				//requestStatus.put(AppConstant.CPCNODENAME, cpcList);
			}

			//先查询日出账是否完成
			boolean needDeal = true;
			boolean notifySuccess = false;
			if (strTranCode.equals(TranCode.I_RENT_NOTIFY.getTranCode()))
			{
				String rentNotifyResp = businessCrmAction.queryIRentNotify(rentNotify);
				if (rentNotifyResp != null)
				{
					String[] notifyResp = rentNotifyResp.split(",");
					if (notifyResp.length>=2)
					{
						if ("0".equals(notifyResp[0]) || "1".equals(notifyResp[0]))
							needDeal = false;
						if ("0".equals(notifyResp[0]))
							notifySuccess = true;
					}
				}
			}
			int process_flag = 0;//0-资料接口，1-只有充值接口，2-只有营销方案接口，3-充值接口和营销方案接口都有
			String responses = null;
			if (needDeal)
			{
				requestStatus.put(AppConstant.CPCNODENAME, cpcList);
				requestStatus.put(AppConstant.SONBR, soNbrList);
				requestStatus.put(AppConstant.ROLLBACKSONBR, rollBackSoNbrList);
				requestStatus.put(AppConstant.TRANCODE, tranCodeList);
				requestStatus.put(AppConstant.ERRORNODENAME, errorList);
				voList = null;
				
				responses = businessCrmAction.dispatch(entityAllList, requestStatus);
			}
			//日出账未完成需要轮训到超时前
			if (!notifySuccess && strTranCode.equals(TranCode.I_RENT_NOTIFY.getTranCode()))
			{
				Date currentDate = new Date();
				Date beginDate = (Date)requestStatus.get(AppConstant.SODATE);
				if (rentNotify.getCrmDelayLimit() == null)
					throw new BossException(StatusCode.CRMDELAYLIMITISNULL);
				if (currentDate.getTime() - beginDate.getTime() < (rentNotify.getCrmDelayLimit()-1)*1000)
				{
					boolean isContinue = true;
					while (isContinue)
					{
						Thread.sleep((rentNotify.getCrmDelayLimit()-1)*1000);
						String rentNotifyResp = businessCrmAction.queryIRentNotify(rentNotify);
						if (rentNotifyResp != null)
						{
							String[] notifyResp = rentNotifyResp.split(",");
							if (notifyResp.length>=2)
							{
								if ("0".equals(notifyResp[0]))
								{
									notifySuccess = true;
									isContinue = false;
								}
							}
						}
						currentDate = new Date();
						if (currentDate.getTime() - beginDate.getTime() >= (rentNotify.getCrmDelayLimit()-1)*1000)
							isContinue = false;
					}
				}
				if (!notifySuccess)
					throw new BossException(StatusCode.IRENTNOTIFYFAIL);
					
			}
			//取出预存
			for (int i=0;i<invoicePayFeeInList.size();i++){
				InvoicePayFeeIn invoicePayFeeIn = (InvoicePayFeeIn)invoicePayFeeInList.get(i);
				if (invoicePayFeeIn!=null)
				{
					process_flag = 1;
					//调用账管预存接口
					String response = accPayFee(invoicePayFeeIn);
					if (response != null && !"".equals(response)) { 
						throw new BossException(StatusCode.SUCCESSBUTNOTPAYMENT,  response);
					}
					
					//判断CrmUser的UserSts是否为12，需要在充值后将UserSts修改为11
					if (allCrmUserList!= null && allCrmUserList.size()>0)
					{
						for (int j=0;j<allCrmUserList.size();j++)
						{
							com.asiainfo.boss4.domain.CrmUser crmUser = (com.asiainfo.boss4.domain.CrmUser)allCrmUserList.get(j);
							if (invoicePayFeeIn.getChargeId().equals(crmUser.getPhoneId()) 
									&& crmUser.getUserSts().intValue() == Integer.decode(Constance.UNUSEDUSERSTS).intValue())
							{
								crmUser.setUserSts(Byte.decode(Constance.PREACTIVEUSERSTS));
								response = businessCrmAction.updateCrmUserSts(crmUser);
								if (response != null && !"".equals(response)) { 
									logger.info(response);
									throw new BossException(StatusCode.SUCCESSBUTNOTACTIVEUSER,  StatusCode.SUCCESSBUTNOTACTIVEUSER.getDescription());
								}
							}
						}
					}
				}
			}
			//取出营销方案
			for (int i=0;i<oneTimePaymentList.size();i++){
				if ((com.asiainfo.boss4.domain.ext.OneTimePayment)oneTimePaymentList.get(i)!=null)
				{
					if (1 == process_flag)
						process_flag = 3;
					else
						process_flag = 2;
					
					//调用账管营销方案接口
					String response = bookScheme((com.asiainfo.boss4.domain.ext.OneTimePayment)oneTimePaymentList.get(i));
					//String response = bookScheme(null);
					if (response != null && !"".equals(response)) { 
						if (2 == process_flag)
							throw new BossException(StatusCode.SUCCESSBUTNOTONETIMEPAYMENT,  response);
						else
							throw new BossException(StatusCode.SUCCESSPAYMENTBUTNOTONETIMEPAYMENT,  response);
					}
				}
			}

			//做资金转移，后付费
			for (int i=0;i<tranBillList.size();i++){
				com.asiainfo.boss4.domain.TranBill tranBillIn = (com.asiainfo.boss4.domain.TranBill)tranBillList.get(i);
				//调用账管资金转移接口
				String response = tranBill(tranBillIn);
				if (response != null && !"".equals(response)) { 
					throw new BossException(StatusCode.SUCCESSBUTNOTTRANBILL,  response);
				}
			}
			
			//做资金转移，预付费
			for (int i=0;i<preTranBillList.size();i++){
				com.asiainfo.boss4.domain.PreTran preTranBillIn = (com.asiainfo.boss4.domain.PreTran)preTranBillList.get(i);
				//调用账管资金转移接口
				String response = preTranBill(preTranBillIn);
				if (response != null && !"".equals(response)) { 
					throw new BossException(StatusCode.SUCCESSBUTNOTTRANBILL,  response);
				}
			}
			
			if (responses != null) {// 查询boss id时，将操作员ID和营业厅ID写到返回信息描述中，应EAI要求，临时添加
				outputXml = XmlHelper.buildOutputXml(StatusCode.SUCCESS.getCode(),responses,strTranCode,strSoNbr);
			} else {
				outputXml = XmlHelper.buildOutputXml(StatusCode.SUCCESS.getCode(),StatusCode.SUCCESS.getDescription(),strTranCode,strSoNbr);
			}
			
		} catch (BossException e) {// 捕获手动抛出的异常
			logger.error("捕获到系统自定义异常", e);
			StringBuffer errorMessage = new StringBuffer(e.getMessage());
			if (e.getTraceMessage() != null) {
				errorMessage.append(". 详细异常信息：").append(e.getTraceMessage());
			}
			if (e.getEntityName() != null)
				errorMessage.append(e.getEntityName());
			if (e.getSid()!= null && !e.getSid().equals(""))
				outputXml = XmlHelper.buildOutputXml(e.getStatusCode(),
					errorMessage.toString(), e.getTranCode(), e.getSid());
			else
				outputXml = XmlHelper.buildOutputXml(e.getStatusCode(),
						errorMessage.toString(), e.getTranCode(), strSoNbr);
		} catch (Throwable e) {// 捕获系统自身抛出的内部异常
			logger.error("捕获到严重的不可恢复异常", e);
			if (e instanceof org.hibernate.exception.GenericJDBCException || e instanceof org.springframework.transaction.CannotCreateTransactionException)
				outputXml = XmlHelper.buildOutputXml(StatusCode.DB_OPERATION_ERROR
						.getCode(), e.getMessage(),strTranCode,strSoNbr);
			else
				outputXml = XmlHelper.buildOutputXml(StatusCode.INSIDE_ERROR
					.getCode(), StatusCode.INSIDE_ERROR.getDescription(),strTranCode,strSoNbr);
		}

		return outputXml;		
	}

	@SuppressWarnings("finally")
	public String queryCrmId(String inputXml) {
		logger.debug("开始处理Web Service请求");
		logger.info("请求XML=> " + inputXml);
		
		if (inputXml == null || "".equals(inputXml)) {
			throw new BossException(StatusCode.INPUT_IS_NULL_ERROR);
		}
		
		String responseTemplate = FileCache.getXMLFile("query_crm_id");
		String outputXml = null;
		try {
			outputXml = queryCrmIdService.query(XmlHelper.parseBossIdToMap(inputXml));
		} catch (BossException e) {// 捕获手动抛出的异常
			logger.error("捕获到系统自定义异常", e);
			StringBuffer errorMessage = new StringBuffer(e.getMessage());
			if (e.getTraceMessage() != null) {
				errorMessage.append(". 详细异常信息：").append(e.getTraceMessage());
			}
			outputXml = XmlHelper.buildQueryOutputXML(e.getStatusCode(), errorMessage.toString(), responseTemplate, null);
		} catch (Throwable e) {// 捕获系统自身抛出的内部异常
			logger.error("捕获到严重的不可恢复异常", e);
			outputXml = XmlHelper.buildQueryOutputXML(StatusCode.INSIDE_ERROR.getCode(), StatusCode.INSIDE_ERROR.getDescription(), responseTemplate, null);
		} finally {
			logger.info("响应XML=> " + outputXml);
			logger.debug("Web Service请求处理完成");
			return outputXml;
		}
	}
	
	@SuppressWarnings("finally")
	public String queryCrm(String inputXml) {
		logger.debug("开始处理Web Service请求");
		logger.info("请求XML=> " + inputXml);
		
		List<LazyDynaMap> voList = null;
		String outputXml = null;
		try {
			if (inputXml == null || "".equals(inputXml)) throw new BossException(StatusCode.INPUT_IS_NULL_ERROR);
			
			// 解析xml，转换为值对象列表，一个交易（即一个item节点）对应一个值对象
			voList = XmlHelper.parseToVoList(inputXml);
			
			// 检查是否包含item节点，每个item节点代表一个业务调用，查询类业务仅支持一个item节点
			if (voList.size() == 0) throw new BossException(StatusCode.XML_PARSE_ERROR);
			if (voList.size() != 1) throw new BossException(StatusCode.QUERY_MANY_TRANCODE_ERROR);
			
			outputXml = queryAction.dispatch(voList, null);
			
		} catch (Throwable e) {
			logger.error("捕获到系统异常", e);
			outputXml = XmlHelper.buildQueryOutputXMLByTemplateWithException((String) voList.get(0).get("tranCode"), e);
			
		} finally {
			logger.info("响应XML=> " + outputXml);
			logger.debug("Web Service请求处理完成");
			
			return outputXml;
		}
	}
	
	private String accPayFee(InvoicePayFeeIn invoicePayFeeIn){
		com.asiainfo.obd.accpayfee.ObIdl_MAccCommonSInvoicePayFeeIn sPayFeeIn = new com.asiainfo.obd.accpayfee.ObIdl_MAccCommonSInvoicePayFeeIn(); 
		com.asiainfo.obd.accpayfee.holders.ObIdl_MAccCommonSInvoicePayFeeOutHolder sPayFeeOut = new com.asiainfo.obd.accpayfee.holders.ObIdl_MAccCommonSInvoicePayFeeOutHolder();
		com.asiainfo.obd.accpayfee.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg = new com.asiainfo.obd.accpayfee.holders.MObdCommonSCbsErrorMsgHolder();
		String obdAddress = loadConfiguration();
		if (obdAddress == null || obdAddress.equals(""))
		{
			logger.info("OBD ADDRESS IS NULL");
			return "OBD ADDRESS IS NULL";
		}
		logger.info("OBD ADDRESS:"+obdAddress);
		com.asiainfo.obd.accpayfee.ObIdl_MAccPayFee_IAccPayFeeService apfs= new com.asiainfo.obd.accpayfee.ObIdl_MAccPayFee_IAccPayFeeServiceLocator(obdAddress);
		int ret = 0;
		String result = "";
		try {
			sPayFeeIn.setM_dtmTradeDate(DateHelper.Date2String(invoicePayFeeIn.getTradeDate()));
			sPayFeeIn.setM_iOpId(invoicePayFeeIn.getOpId());
			sPayFeeIn.setM_iSoOrgId(invoicePayFeeIn.getSoOrgId());
			sPayFeeIn.setM_llPaidAmount(invoicePayFeeIn.getPaidAmount());
			sPayFeeIn.setM_nBusiType(invoicePayFeeIn.getBusiType());
			sPayFeeIn.setM_nCalcLateFee(invoicePayFeeIn.getCalcLateFee());
			sPayFeeIn.setM_nIdType(invoicePayFeeIn.getIdType());
			sPayFeeIn.setM_nInvoiceMode(invoicePayFeeIn.getInvoiceMode());
			sPayFeeIn.setM_nSmsFlag(invoicePayFeeIn.getSmsFlag());
			sPayFeeIn.setM_strChargeId(invoicePayFeeIn.getChargeId());
			sPayFeeIn.setM_strMonList(invoicePayFeeIn.getMonList());
			sPayFeeIn.setM_strPhoneId(invoicePayFeeIn.getPhoneId());
			sPayFeeIn.setM_strRemarks(invoicePayFeeIn.getRemarks());
			sPayFeeIn.setM_nProcessMode(invoicePayFeeIn.getProcessMode());
			sPayFeeIn.setM_strOtherNbr(invoicePayFeeIn.getOtherNbr());
			sPayFeeIn.setM_strPaymentMethod(invoicePayFeeIn.getPaymentMethod());
			sPayFeeIn.setM_iBillFormatId(invoicePayFeeIn.getBillFormatId());
			sPayFeeIn.setM_nPayMode(invoicePayFeeIn.getPayMode());
			sPayFeeIn.setM_strCardNbr("");
			
			com.asiainfo.obd.accpayfee.ObIdl_MAccPayFee_IAccPayFee apf = apfs.getObIdl_MAccPayFeeIAccPayFeePort();
			com.asiainfo.obd.accpayfee.MObdCommonSOBSessionProperty[] sSession =new  com.asiainfo.obd.accpayfee.MObdCommonSOBSessionProperty[1];
			sSession[0] = new com.asiainfo.obd.accpayfee.MObdCommonSOBSessionProperty();
			sSession[0].setM_strName("0");
			sSession[0].setM_strValue("0");
			
			ret = apf.do_payFeeInvoice(sSession, sPayFeeIn, sPayFeeOut, sErrorMsg);
	        logger.info("llPaySoNbr:" + sPayFeeOut.value.getM_llPaySoNbr()+"\t"+"llBalance:" + sPayFeeOut.value.getM_llBalance());
	        
	        logger.info("CODE:" + sErrorMsg.value.getM_iErrorCode());
	  	    logger.info("MSG:" + sErrorMsg.value.getM_strErrorMsg());
	  	    if (sErrorMsg.value.getM_iErrorCode() != null && !sErrorMsg.value.getM_iErrorCode().toString().equals("0"))
	  	    	result = sErrorMsg.value.getM_strErrorMsg();
		} catch (ServiceException e) {
			e.printStackTrace();
			result = e.getMessage();
		} catch (com.asiainfo.obd.accpayfee.CORBASystemException e) {
			e.printStackTrace();
			result = e.dumpToString();	
		} catch (RemoteException e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		return result;
	}
	
	private String bookScheme(com.asiainfo.boss4.domain.ext.OneTimePayment oneTimePayment)
	{
		com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSegmentFund sSegmentIn = new com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSegmentFund();
		com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBusinessReceipt sReceiptIn = new com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBusinessReceipt();
		com.asiainfo.obd.bookscheme.holders.ObIdl_MAccCommonSAccInvcRecInfoListHolder listReceipt = new com.asiainfo.obd.bookscheme.holders.ObIdl_MAccCommonSAccInvcRecInfoListHolder();
		String obdAddress = loadConfiguration();
		if (obdAddress == null || obdAddress.equals(""))
		{
			logger.info("OBD ADDRESS IS NULL");
			return "OBD ADDRESS IS NULL";
		}
		logger.info("OBD ADDRESS:"+obdAddress);
		com.asiainfo.obd.bookscheme.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg = new com.asiainfo.obd.bookscheme.holders.MObdCommonSCbsErrorMsgHolder();
		com.asiainfo.obd.bookscheme.ObIdl_MBookScheme_IBkScheService bss= new com.asiainfo.obd.bookscheme.ObIdl_MBookScheme_IBkScheServiceLocator(obdAddress);
		
		String strBrand = oneTimePayment.getBrand();
		Integer iOpId = Integer.decode(oneTimePayment.getOpId());
		Integer iOrgId = Integer.decode(oneTimePayment.getOrgId());
		javax.xml.rpc.holders.LongHolder llPaymentNbr = new javax.xml.rpc.holders.LongHolder();
		javax.xml.rpc.holders.LongHolder llRetReceiptNbr = new javax.xml.rpc.holders.LongHolder();
		int ret = 0;
		String result = "";
		try {
			
			sSegmentIn.setM_llAcctId(oneTimePayment.getSegmentFund().getAcctId());
			sSegmentIn.setM_strExtCustomerId(oneTimePayment.getSegmentFund().getExtCustomerId());
			sSegmentIn.setM_strResourceNumber(oneTimePayment.getSegmentFund().getResourceNumber());
			com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem[] m_listListPayment = new com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem[oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getPaymentList().getPayment().size()];
			for (int i=0;i<oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getPaymentList().getPayment().size();i++){
				sSegmentIn.setM_strPaymentTransactionId(oneTimePayment.getSegmentFund().getPaymentTransactionId()+oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getPaymentList().getPayment().get(i).getPaymentType());
					m_listListPayment[i] 
			    = new com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem(
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getPaymentList().getPayment().get(i).getPaymentType(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getPaymentList().getPayment().get(i).getPaymentFlag(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getPaymentList().getPayment().get(i).getMonth(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getPaymentList().getPayment().get(i).getAmount(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getPaymentList().getPayment().get(i).getBeginDate(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getPaymentList().getPayment().get(i).getEndDate(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getPaymentList().getPayment().get(i).getBankCode(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getPaymentList().getPayment().get(i).getBankCardNbr(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getPaymentList().getPayment().get(i).getBankCardName(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getPaymentList().getPayment().get(i).getMemo(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getPaymentList().getPayment().get(i).getCrmFeeId(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getPaymentList().getPayment().get(i).getCrmSapInstanceId());
			}
			sSegmentIn.setM_listListPayment(m_listListPayment);
			
			com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem[] m_listListRefund = new com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem[oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getRefundList().getPayment().size()];
			for (int i=0;i<oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getRefundList().getPayment().size();i++){
				m_listListRefund[i]
				= new com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem(
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getRefundList().getPayment().get(i).getPaymentType(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getRefundList().getPayment().get(i).getPaymentFlag(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getRefundList().getPayment().get(i).getMonth(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getRefundList().getPayment().get(i).getAmount(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getRefundList().getPayment().get(i).getBeginDate(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getRefundList().getPayment().get(i).getEndDate(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getRefundList().getPayment().get(i).getBankCode(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getRefundList().getPayment().get(i).getBankCardNbr(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getRefundList().getPayment().get(i).getBankCardName(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getRefundList().getPayment().get(i).getMemo(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getRefundList().getPayment().get(i).getCrmFeeId(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getRefundList().getPayment().get(i).getCrmSapInstanceId());
			}
			sSegmentIn.setM_listListRefund(m_listListRefund);
			
			com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem[] m_listListUpdate = new com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem[oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getUpdateList().getPayment().size()];
			for (int i=0;i<oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getUpdateList().getPayment().size();i++){
				m_listListUpdate[i]
				= new com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem(
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getUpdateList().getPayment().get(i).getPaymentType(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getUpdateList().getPayment().get(i).getPaymentFlag(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getUpdateList().getPayment().get(i).getMonth(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getUpdateList().getPayment().get(i).getAmount(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getUpdateList().getPayment().get(i).getBeginDate(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getUpdateList().getPayment().get(i).getEndDate(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getUpdateList().getPayment().get(i).getBankCode(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getUpdateList().getPayment().get(i).getBankCardNbr(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getUpdateList().getPayment().get(i).getBankCardName(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getUpdateList().getPayment().get(i).getMemo(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getUpdateList().getPayment().get(i).getCrmFeeId(),
						oneTimePayment.getSegmentFund().getOneTimePaymentItemList().getUpdateList().getPayment().get(i).getCrmSapInstanceId());
			}
			sSegmentIn.setM_listListUpdate(m_listListUpdate);
			
			
			sReceiptIn.setM_llAccountId(oneTimePayment.getBusinessReceipt().getAccountId());
			sReceiptIn.setM_strExtCustomerId(oneTimePayment.getBusinessReceipt().getExtCustomerId());
			sReceiptIn.setM_strMemo(oneTimePayment.getBusinessReceipt().getMemo());
			sReceiptIn.setM_strPayChannel(oneTimePayment.getBusinessReceipt().getPayChannel());
			sReceiptIn.setM_strReceiptTransactionId(oneTimePayment.getBusinessReceipt().getReceiptTransactionId());
			sReceiptIn.setM_strResourceNumber(oneTimePayment.getBusinessReceipt().getResourceNumber());
			
			com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimeReceiptItem[] m_listListReceiptItem = new com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimeReceiptItem[oneTimePayment.getBusinessReceipt().getReceiptItemList().getReceiptItem().size()];
			for (int i=0;i<oneTimePayment.getBusinessReceipt().getReceiptItemList().getReceiptItem().size();i++){
				com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimeReceiptItem item
				= new com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimeReceiptItem(
						oneTimePayment.getBusinessReceipt().getReceiptItemList().getReceiptItem().get(i).getCode(),
						oneTimePayment.getBusinessReceipt().getReceiptItemList().getReceiptItem().get(i).getName(),
						oneTimePayment.getBusinessReceipt().getReceiptItemList().getReceiptItem().get(i).getAmount(),
						oneTimePayment.getBusinessReceipt().getReceiptItemList().getReceiptItem().get(i).getPrice(),
						oneTimePayment.getBusinessReceipt().getReceiptItemList().getReceiptItem().get(i).getQuantity(),
						oneTimePayment.getBusinessReceipt().getReceiptItemList().getReceiptItem().get(i).getItemMemo());
				m_listListReceiptItem[i] = item;
			}
			sReceiptIn.setM_listListReceiptItem(m_listListReceiptItem);
			
			com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSegmentPayMethod m_sPaymentMethod 
				= new com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSegmentPayMethod(
						oneTimePayment.getBusinessReceipt().getSegmentPayMethod().getPaymentMethod(),
						oneTimePayment.getBusinessReceipt().getSegmentPayMethod().getCheckNo());
			sReceiptIn.setM_sPaymentMethod(m_sPaymentMethod);
			
			com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSReceiptServInfo m_sReceiptServInfo 
				= new com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSReceiptServInfo(
						oneTimePayment.getBusinessReceipt().getReceiptServInfo().getDevNumber(),
						oneTimePayment.getBusinessReceipt().getReceiptServInfo().getExtCustomerId(),
						oneTimePayment.getBusinessReceipt().getReceiptServInfo().getCustomerName());
			sReceiptIn.setM_sReceiptServInfo(m_sReceiptServInfo);
			
			com.asiainfo.obd.bookscheme.ObIdl_MBookScheme_IBkSche bs = bss.getObIdl_MBookSchemeIBkSchePort();
			com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[] sSession =new  com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[1];
			sSession[0] = new com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty();
			sSession[0].setM_strName("0");
			sSession[0].setM_strValue("0");
			
			
			/*String strBrand = "GT";
			Integer iOpId = Integer.decode("10835755");
			Integer iOrgId = Integer.decode("10000112");
			
			sSegmentIn.setM_llAcctId(Long.decode("60540144"));
			sSegmentIn.setM_strExtCustomerId("SC00WDOC");
			sSegmentIn.setM_strPaymentTransactionId("CRM20120414141144546XUXIN_FEE");
			sSegmentIn.setM_strResourceNumber("13911278369");
			
			com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem[] m_listListPayment = new com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem[1];
			m_listListPayment[0] 
			    = new com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem(
						"SAP196",
						Short.decode("1"),
						Integer.decode("12"),
						Long.decode("36000"),
						"2012-05-01",
						"2013-04-30",
						"",
						"",
						"",
						"",
						"856",
						"1-14LQGF6L");

			sSegmentIn.setM_listListPayment(m_listListPayment);
			
			com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem[] m_listListRefund = new com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem[1];
			m_listListRefund[0] 
				= new com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem(
						"",
						Short.decode("0"),
						Integer.decode("0"),
						Long.decode("0"),
						"",
						"",
						"",
						"",
						"",
						"",
						"",
						"");
			sSegmentIn.setM_listListRefund(m_listListRefund);
			
			com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem[] m_listListUpdate = new com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem[1];
			m_listListUpdate[0] 
				= new com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem(
						"",
						Short.decode("0"),
						Integer.decode("0"),
						Long.decode("0"),
						"",
						"",
						"",
						"",
						"",
						"",
						"",
						"");
			sSegmentIn.setM_listListUpdate(m_listListUpdate);
			
			sReceiptIn.setM_llAccountId(Long.decode("0"));
			sReceiptIn.setM_strExtCustomerId("");
			sReceiptIn.setM_strMemo("");
			sReceiptIn.setM_strPayChannel("");
			sReceiptIn.setM_strReceiptTransactionId("");
			sReceiptIn.setM_strResourceNumber("");
			
			com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimeReceiptItem[] m_listListReceiptItem = new com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimeReceiptItem[1];
			com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimeReceiptItem item 
				= new com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimeReceiptItem(
						"",
						"",
						Long.decode("0"),
						Long.decode("0"),
						Long.decode("0"),
						"");
			m_listListReceiptItem[0] = item;
			sReceiptIn.setM_listListReceiptItem(m_listListReceiptItem);
			
			com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSegmentPayMethod m_sPaymentMethod 
				= new com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSegmentPayMethod(
						"",
						"");
			sReceiptIn.setM_sPaymentMethod(m_sPaymentMethod);
			
			com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSReceiptServInfo m_sReceiptServInfo 
				= new com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSReceiptServInfo(
						"",
						"",
						"");
			sReceiptIn.setM_sReceiptServInfo(m_sReceiptServInfo);*/
			ret = bs.deal_oneTimePayment(sSession, strBrand, sSegmentIn, sReceiptIn, iOpId, iOrgId, listReceipt, llPaymentNbr, llRetReceiptNbr, sErrorMsg);
				
	        logger.info("llPaymentNbr:" + llPaymentNbr.value+"\t"+"llRetReceiptNbr:" + llRetReceiptNbr.value);
	        
	        logger.info("CODE:" + sErrorMsg.value.getM_iErrorCode());
	  	    logger.info("MSG:" + sErrorMsg.value.getM_strErrorMsg());
	  	    if (sErrorMsg.value.getM_iErrorCode() != null && !sErrorMsg.value.getM_iErrorCode().toString().equals("0"))
	  	    	result = sErrorMsg.value.getM_strErrorMsg();
		} catch (ServiceException e) {
			e.printStackTrace();
			result = e.getMessage();
		} catch (com.asiainfo.obd.accpayfee.CORBASystemException e) {
			e.printStackTrace();
			result = e.dumpToString();	
		} catch (RemoteException e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		return result;
	}
	
	public String tranBill(com.asiainfo.boss4.domain.TranBill tranBill)
	{
		int ret = 0;
		String result = "";
		long invcFee = 0; //转户金额
		
		try {
			//获取服务地址
			String obdAddress = loadConfiguration();
			if (obdAddress == null || obdAddress.equals(""))
			{
				logger.info("OBD ADDRESS IS NULL");
				return "OBD ADDRESS IS NULL";
			}
			logger.info("OBD ADDRESS:"+obdAddress);
			
			//获取余额转移帐本
			Integer bookItemId = tranBill.getBookItemId();
			
			//查询实时话费发票
			if(bookItemId.toString().equals(AppConstant.TRANBILLREALTIMEFEE)){
				com.asiainfo.obd.AccPrtInv.ObIdl_MAccPrtInvDefSInvcQryIn invcQryIn = new com.asiainfo.obd.AccPrtInv.ObIdl_MAccPrtInvDefSInvcQryIn();  
				com.asiainfo.obd.AccPrtInv.holders.ObIdl_MAccCommonSAccInvcRecInfoListHolder sPayFeeOut = new com.asiainfo.obd.AccPrtInv.holders.ObIdl_MAccCommonSAccInvcRecInfoListHolder();
				com.asiainfo.obd.AccPrtInv.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg = new com.asiainfo.obd.AccPrtInv.holders.MObdCommonSCbsErrorMsgHolder();
				com.asiainfo.obd.AccPrtInv.ObIdl_MAccPrtInv_IAccPrtInvService apfs= new com.asiainfo.obd.AccPrtInv.ObIdl_MAccPrtInv_IAccPrtInvServiceLocator(obdAddress);
				
				invcQryIn.setM_dtmBeginDate(DateHelper.Date2String(DateHelper.getCurrentMonthFirstDay()));
				invcQryIn.setM_dtmEndDate(DateHelper.Date2String(DateHelper.getCurrentMonthLastSecond(new Date())));
				invcQryIn.setM_iPrintCount(Integer.decode("-1"));
				invcQryIn.setM_nInvcType(tranBill.getInvcType());
				invcQryIn.setM_nSts(Short.decode("0"));
				invcQryIn.setM_strPhoneId(tranBill.getPhoneId());
				invcQryIn.setM_llAcctId(Long.decode("0"));
				
				com.asiainfo.obd.AccPrtInv.ObIdl_MAccPrtInv_IAccPrtInv apf = apfs.getObIdl_MAccPrtInvIAccPrtInvPort();
				com.asiainfo.obd.AccPrtInv.MObdCommonSOBSessionProperty[] sSession =new  com.asiainfo.obd.AccPrtInv.MObdCommonSOBSessionProperty[1];
				sSession[0] = new com.asiainfo.obd.AccPrtInv.MObdCommonSOBSessionProperty();
				sSession[0].setM_strName("0");
				sSession[0].setM_strValue("0");
				
				ret = apf.query_receipt(sSession, invcQryIn, sPayFeeOut, sErrorMsg);
		        logger.info("receipt size:" + sPayFeeOut.value.length);
		        
		        logger.info("QRY INVC CODE:" + sErrorMsg.value.getM_iErrorCode());
		  	    logger.info("QRY INVC MSG:" + sErrorMsg.value.getM_strErrorMsg());
		  	    
		  	    if (sErrorMsg.value.getM_iErrorCode() != null && !sErrorMsg.value.getM_iErrorCode().toString().equals("0")){
		  	    	result = sErrorMsg.value.getM_strErrorMsg();
		  	    }
		  	   
		  	    //获取实时话费金额
		  	    if (sPayFeeOut.value.length < 1){
		  	    	logger.info("The invoice of "+tranBill.getPhoneId()+" is not exist! ");
		  	    	return "";
		  	    }
		  	    
		  	    for (int i=0;i<sPayFeeOut.value.length;i++){
		  	    	com.asiainfo.obd.AccPrtInv.ObIdl_MAccCommonSAccInvcRecInfo acctInvcRecInfo = sPayFeeOut.value[i];
		  	    	invcFee += acctInvcRecInfo.getM_llInvcFee().longValue();
		  	    }
		  	    
		  	    logger.info("TRAN BILL FEE:" + invcFee);
			}else if(bookItemId.toString().equals(AppConstant.TRANBILLBOOKITEMFEE)){
				//设置Service服务
				com.asiainfo.obd.AccQuickQryFee.ObIdl_MAccQuickQryFeeIAccQuickQryFeeService aqqfs= new com.asiainfo.obd.AccQuickQryFee.ObIdl_MAccQuickQryFeeIAccQuickQryFeeServiceLocator(obdAddress);
				//设置AccQuickQryFee入参和出参[参考ObIdl_MAccQuickQryFeeIAccQuickQryFee中方法调用参数]
				//设置入参
				long llAcctId = tranBill.getOldAcctId(); 
				String strQryFlag ="RP"; 
				String strResourceNumber=""; 
				String strStartDate="";
				String strEndDate="";
				String strPaymentType=""; 
				String strStatus=""; 
				//设置出参
				com.asiainfo.obd.AccQuickQryFee.holders.ObIdl_MAccQuickQryFeeSQryRegularBookOutListHolder slistRegularBookOut = new com.asiainfo.obd.AccQuickQryFee.holders.ObIdl_MAccQuickQryFeeSQryRegularBookOutListHolder();
				com.asiainfo.obd.AccQuickQryFee.holders.ObIdl_MAccQuickQryFeeSQrySchemeBookOutListHolder slistSchemeBookOut = new com.asiainfo.obd.AccQuickQryFee.holders.ObIdl_MAccQuickQryFeeSQrySchemeBookOutListHolder();
				com.asiainfo.obd.AccQuickQryFee.holders.ObIdl_MAccQuickQryFeeSQryDepositBookOutListHolder slistDepositBookOut = new com.asiainfo.obd.AccQuickQryFee.holders.ObIdl_MAccQuickQryFeeSQryDepositBookOutListHolder();
				com.asiainfo.obd.AccQuickQryFee.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg = new com.asiainfo.obd.AccQuickQryFee.holders.MObdCommonSCbsErrorMsgHolder();
				//调用Service服务
				com.asiainfo.obd.AccQuickQryFee.ObIdl_MAccQuickQryFeeIAccQuickQryFee aqqf = aqqfs.getObIdl_MAccQuickQryFeeIAccQuickQryFeePort();
				//设置Session
				com.asiainfo.obd.AccQuickQryFee.MObdCommonSOBSessionProperty[] sSession =new  com.asiainfo.obd.AccQuickQryFee.MObdCommonSOBSessionProperty[1];
				sSession[0] = new com.asiainfo.obd.AccQuickQryFee.MObdCommonSOBSessionProperty();
				sSession[0].setM_strName("0");
				sSession[0].setM_strValue("0");
				
				//调用OBD方法
				ret = aqqf.query_advancedAndDepositPayment(sSession, llAcctId, strQryFlag, strResourceNumber, strStartDate, strEndDate, strPaymentType, strStatus, slistRegularBookOut, slistSchemeBookOut, slistDepositBookOut, sErrorMsg);
		        logger.info("RegularBookOut size:" + slistRegularBookOut.value.length);
		        logger.info("QRY RegularBook CODE:" + sErrorMsg.value.getM_iErrorCode());
		  	    logger.info("QRY RegularBook MSG:" + sErrorMsg.value.getM_strErrorMsg());
				
		  	    if (sErrorMsg.value.getM_iErrorCode() != null && !sErrorMsg.value.getM_iErrorCode().toString().equals("0")){
		  	    	result = sErrorMsg.value.getM_strErrorMsg();
		  	    }
		  	    
		  	    //获取帐本金额
		  	    if (slistRegularBookOut.value.length < 1){
		  	    	logger.info("The bookitem of "+tranBill.getPhoneId()+" is not exist! ");
		  	    	return "";
		  	    }
		  	    for (int i=0;i<slistRegularBookOut.value.length;i++){
		  	    	com.asiainfo.obd.AccQuickQryFee.ObIdl_MAccQuickQryFeeSQryRegularBookOut regularBookOut = slistRegularBookOut.value[i];
		  	    	if(regularBookOut.getM_iBookItemId().intValue()==Integer.decode(AppConstant.TRANBILLBOOKITEMFEE).intValue()){
		  	    		invcFee += regularBookOut.getM_llAmount().longValue();
		  	    	}
		  	    }
		  	    
		  	    logger.info("TRAN BOOKITEM FEE:" + invcFee);
		  	    if(invcFee==0){
		  	    	return "";
		  	    }
			}else{
				return "";
			}
			
			
	  	    //余额转移
	  	    com.asiainfo.obd.AccTranBil.ObIdl_MAccTranBilSAccTranBilIn tranBillIn = new com.asiainfo.obd.AccTranBil.ObIdl_MAccTranBilSAccTranBilIn();
	  	    com.asiainfo.obd.AccTranBil.holders.MObdCommonSCbsErrorMsgHolder sErrorMsgBill = new com.asiainfo.obd.AccTranBil.holders.MObdCommonSCbsErrorMsgHolder();
	  	    com.asiainfo.obd.AccTranBil.ObIdl_MAccTranBil_ITraPpyService tps = new com.asiainfo.obd.AccTranBil.ObIdl_MAccTranBil_ITraPpyServiceLocator(obdAddress);
	  	    
	  	    com.asiainfo.obd.AccTranBil.ObIdl_MAccTranBilSAccTranBookDtl[] outBook = new com.asiainfo.obd.AccTranBil.ObIdl_MAccTranBilSAccTranBookDtl[1];
	  	    outBook[0] = new com.asiainfo.obd.AccTranBil.ObIdl_MAccTranBilSAccTranBookDtl();
	  	    outBook[0].setM_iBookItemId(tranBill.getBookItemId());
	  	    outBook[0].setM_llAmount(Long.decode("-"+String.valueOf(invcFee)));
	  	    outBook[0].setM_llBookId(Long.decode("0"));
	  	    
	  	    com.asiainfo.obd.AccTranBil.ObIdl_MAccTranBilSAccTranBookDtl[] inBook = new com.asiainfo.obd.AccTranBil.ObIdl_MAccTranBilSAccTranBookDtl[1];
	  	    inBook[0] = new com.asiainfo.obd.AccTranBil.ObIdl_MAccTranBilSAccTranBookDtl();
	  	    inBook[0].setM_iBookItemId(tranBill.getBookItemId());
	  	    inBook[0].setM_llAmount(Long.valueOf(invcFee));
	  	    inBook[0].setM_llBookId(Long.decode("0"));
	  	    
	  	    com.asiainfo.obd.AccTranBil.ObIdl_MAccTranBilSAccTranAcct[] acctList = new com.asiainfo.obd.AccTranBil.ObIdl_MAccTranBilSAccTranAcct[2];
	  	    acctList[0] = new com.asiainfo.obd.AccTranBil.ObIdl_MAccTranBilSAccTranAcct();
	  	    acctList[0].setM_iIsReal(tranBill.getIsReal());
	  	    acctList[0].setM_iRegionCode(tranBill.getOldAcctRegionCode());
	  	    acctList[0].setM_llAcctId(tranBill.getOldAcctId());
	  	    acctList[0].setM_strPhoneId(tranBill.getPhoneId());
	  	    acctList[0].setM_listAdjBookDtlList(outBook);
	  	    
	  	    acctList[1] =  new com.asiainfo.obd.AccTranBil.ObIdl_MAccTranBilSAccTranAcct();
	  	    acctList[1].setM_iIsReal(tranBill.getIsReal());
	  	    acctList[1].setM_iRegionCode(tranBill.getNewAcctRegionCode());
	  	    acctList[1].setM_llAcctId(tranBill.getNewAcctId());
	  	    acctList[1].setM_strPhoneId(tranBill.getPhoneId());
	  	    acctList[1].setM_listAdjBookDtlList(inBook);
	  	    
	  	    if (tranBill.getOpId() == null)
	  	    	tranBillIn.setM_iOpId(Integer.decode("99999999"));
	  	    else
	  	    	tranBillIn.setM_iOpId(tranBill.getOpId());
	  	    if (tranBill.getOrgId() == null)
	  	    	tranBillIn.setM_iSoOrgId(Integer.decode("99999999"));
	  	    else
	  	    	tranBillIn.setM_iSoOrgId(tranBill.getOrgId());
	  	    tranBillIn.setM_llSoNbr(tranBill.getSoNbr());
	  	    tranBillIn.setM_nBusiType(tranBill.getBusiType());
	  	    tranBillIn.setM_strOutSoNbr("TRAN_BILL_"+tranBill.getSoNbr().toString());
	  	    tranBillIn.setM_strRemark("TRAN BILL FEE:"+invcFee);
	  	    tranBillIn.setM_listTranAcctList(acctList);
	  	      
	  	    com.asiainfo.obd.AccTranBil.ObIdl_MAccTranBil_ITraPpy tp = tps.getObIdl_MAccTranBilITraPpyPort();
	  	    com.asiainfo.obd.AccTranBil.MObdCommonSOBSessionProperty[] sSessionBill =new  com.asiainfo.obd.AccTranBil.MObdCommonSOBSessionProperty[1];
	  	    sSessionBill[0] = new com.asiainfo.obd.AccTranBil.MObdCommonSOBSessionProperty();
	  	    sSessionBill[0].setM_strName("0");
	  	    sSessionBill[0].setM_strValue("0");
	  	    javax.xml.rpc.holders.LongHolder llRetSoNbr = new javax.xml.rpc.holders.LongHolder();
	  	  
	  	    ret = tp.do_exec(sSessionBill, tranBillIn, llRetSoNbr, sErrorMsgBill);
	  	    logger.info("TRAN BILL llRetSoNbr:" + llRetSoNbr.value);
	  	    
	  	    logger.info("TRAN BILL CODE:" + sErrorMsgBill.value.getM_iErrorCode());
	  	    logger.info("TRAN BILL MSG:" + sErrorMsgBill.value.getM_strErrorMsg());
	  	    if (sErrorMsgBill.value.getM_iErrorCode() != null && !sErrorMsgBill.value.getM_iErrorCode().toString().equals("0"))
	  	    	result = sErrorMsgBill.value.getM_strErrorMsg();
	  	    
		} catch (ServiceException e) {
			e.printStackTrace();
			result = e.getMessage();
		} catch (com.asiainfo.obd.accpayfee.CORBASystemException e) {
			e.printStackTrace();
			result = e.dumpToString();			
		} catch (com.asiainfo.obd.AccQuickQryFee.CORBASystemException e) {
			e.printStackTrace();
			result = e.dumpToString();	
		} catch (RemoteException e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		return result;
	}
	
	public String preTranBill(com.asiainfo.boss4.domain.PreTran preTranBill)
	{
		int ret = 0;
		String result = "";
		try{
			com.asiainfo.obd.AccTranBil.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg = new com.asiainfo.obd.AccTranBil.holders.MObdCommonSCbsErrorMsgHolder();
			String obdAddress = loadConfiguration();
			if (obdAddress == null || obdAddress.equals(""))
			{
				logger.info("OBD ADDRESS IS NULL");
				return "OBD ADDRESS IS NULL";
			}
			logger.info("OBD ADDRESS:"+obdAddress);
			com.asiainfo.obd.AccTranBil.ObIdl_MAccTranBil_ITraPpyService tps = new com.asiainfo.obd.AccTranBil.ObIdl_MAccTranBil_ITraPpyServiceLocator(obdAddress);
			com.asiainfo.obd.AccTranBil.ObIdl_MAccTranBil_ITraPpy tp = tps.getObIdl_MAccTranBilITraPpyPort();
			Integer iBusiType = Integer.decode(preTranBill.getBusiType().toString());
			Long llOldAcctId = preTranBill.getOldAcctId();
			Long llNewAcctId = preTranBill.getNewAcctId();
			Integer iOpId = Integer.decode("99999999");
			if (preTranBill.getOpId() != null)
				iOpId = preTranBill.getOpId();
			Integer iSoOrgId = Integer.decode("99999999");
			if (preTranBill.getOrgId() != null)
				iSoOrgId = preTranBill.getOrgId();
			String strOtherSoNbr = preTranBill.getSoNbr().toString();
			String strRemark = preTranBill.getPhoneId();
	  	    com.asiainfo.obd.AccTranBil.MObdCommonSOBSessionProperty[] sSession =new  com.asiainfo.obd.AccTranBil.MObdCommonSOBSessionProperty[1];
	  	    sSession[0] = new com.asiainfo.obd.AccTranBil.MObdCommonSOBSessionProperty();
	  	    sSession[0].setM_strName("0");
	  	    sSession[0].setM_strValue("0");
	  	    javax.xml.rpc.holders.LongHolder llRetSoNbr = new javax.xml.rpc.holders.LongHolder();
	  	  
	  	    ret = tp.do_transferSubscriber(sSession, iBusiType, llOldAcctId.longValue(), llNewAcctId.longValue(), iOpId.intValue(), iSoOrgId.intValue(), strRemark, strOtherSoNbr, llRetSoNbr, sErrorMsg);
	  	    logger.info("TRAN BILL llRetSoNbr:" + llRetSoNbr.value);
	  	    logger.info("TRAN BILL CODE:" + sErrorMsg.value.getM_iErrorCode());
	  	    logger.info("TRAN BILL MSG:" + sErrorMsg.value.getM_strErrorMsg());
	  	    if (sErrorMsg.value.getM_iErrorCode() != null && !sErrorMsg.value.getM_iErrorCode().toString().equals("0"))
	  	    	result = sErrorMsg.value.getM_strErrorMsg();
			
		} catch (ServiceException e) {
			e.printStackTrace();
			result = e.getMessage();
		} catch (com.asiainfo.obd.accpayfee.CORBASystemException e) {
			e.printStackTrace();
			result = e.dumpToString();	
		} catch (RemoteException e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		return result;
	}

	private String loadConfiguration() {
		String obdAddress = null;
		Document document = null;
		String classPath = this.getClass().getResource("/").getPath();
		File f = new File(classPath);
		File[] files = f.listFiles();
		for (File file : files) {
			if (!"obdAddress.xml".equals(file.getName())) {
				continue;
			}
			String fileContent = null;
			try {
				fileContent = com.asiainfo.boss4.support.FileUtil.loadFileToString(file);
			} catch (IOException e1) {
				logger.error("读取配置文件失败");
			}
			try {
				document = DocumentHelper.parseText(fileContent);
			} catch (DocumentException e) {
				logger.error("xml解析失败");
			}
			
			Element root = document.getRootElement();
			
			for (Iterator i = root.elementIterator(); i.hasNext(); ) {
				Element obd = (Element) i.next();
				if (obd.getName().equalsIgnoreCase("OBD"))
				{
					for (Iterator it = obd.elementIterator(); it.hasNext(); ) {
						Element element = (Element) it.next();
						if (element.getName().equalsIgnoreCase("ADDRESS") 
								&& element.getData() != null)
							obdAddress = element.getData().toString();
					}
				}
			}
		}
		return obdAddress;
	}
}
