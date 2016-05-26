package com.asiainfo.boss4.aspect;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.hibernate.Query;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.asiainfo.boss4.dao.BaseDao;
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.service.CpcOrderServiceImpl;
import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.StringHelper;
import com.asiainfo.boss4.support.TranCode;

public class LoggingAdvice {
	private Log logger = LogFactory.getLog(LoggingAdvice.class);
	
	private PlatformTransactionManager transactionManager;
	private BaseDao baseDao;

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
    }
	
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	public Object loggingOnAction(ProceedingJoinPoint pjp) throws Throwable {
		logger.debug("分发请求中的交易，开始进行处理");
		Object retVal = pjp.proceed();
		logger.debug("请求中的所有交易处理完成");
	    return retVal;
	}
	
	public Object loggingOnService(ProceedingJoinPoint pjp) throws Throwable {
		String strTranCode = "";
		String strSoNbr = "";
		
		//新CRM接口是通过ServiceContext保存业务数据，老接口是将业务数据保存在Map中。
		if (!(pjp.getArgs()[0] instanceof com.asiainfo.boss4.support.ServiceContext))
		{
			//老接口
			LazyDynaMap vo = (LazyDynaMap) pjp.getArgs()[0];
			strTranCode = vo.get("tranCode").toString();
			//strSoNbr = vo.get("soNbr").toString();
		}
		else{
			//新CRM接口
			ServiceContext serviceContext = serviceContext = (ServiceContext) pjp.getArgs()[0];
			if (serviceContext != null)
			{
				// 取交易代码
				TranCode tranCode = serviceContext.getTranCode();
				Long soNbr = serviceContext.getSoNbr();
				
				if (tranCode != null)
				{
					strTranCode = tranCode.getTranCode();
					strSoNbr = soNbr.toString();
				}
			}
		}	
		logger.info("sql start <soNbr>" + strSoNbr +"</soNbr>");
		logger.debug("代码为 " + strTranCode + " 的交易处理开始");
		Object retVal = pjp.proceed();
		logger.info("sql end <soNbr>" + strSoNbr +"</soNbr>");
		logger.debug("代码为 " + strTranCode + " 的交易处理完成");
	    return retVal;
	}
	
	private final static DateFormat DATE_FORMAT_YYYYMM = new SimpleDateFormat("yyyyMM");
	
	/**
	 * 记录CPC订购日志，写入数据库表INTER.CPC_ORDER_LOG中
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	public Object loggingToDatabaseOnCpcOrderService(ProceedingJoinPoint pjp) throws Throwable {
		Throwable throwable = null;
		char tranResult = '1'; //成功标志
		
		Object retVal = null;
		try {
			//执行交易
			retVal = pjp.proceed();

		} catch (Throwable e) {//更新结果标志，捕获异常暂不抛出，待日志记录至数据库完毕再抛出异常
			tranResult = '2'; //失败标志
			throwable = e;
		}

		try {
			
			
			StringBuffer sql = new StringBuffer();
			sql.append("insert into INTER.CPC_ORDER_LOG_").append(DATE_FORMAT_YYYYMM.format(new Date()));
			sql.append(" (CRT_T, PKG_SEQ, UD_SUM, OPR_NUMB, IDVA, IDVB, OPR, CHG_FLG, SOURCE, EFFT_T, CREATE_DATE, RESULT, ERROR_INFO, SP_ID, SP_BIZ_CODE) values ");
			sql.append(" (:CrtT, :PkgSeq, :UDSum, :OprNumb, :IDVA, :IDVB, :Opr, :ChgFlg, :Source, :EfftT, sysdate, :result, :errorInfo, :SPID, :SPBizCode)");

			LazyDynaMap vo = (LazyDynaMap) pjp.getArgs()[0];
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("CrtT", vo.get("CrtT"));
			params.put("PkgSeq", vo.get("PkgSeq"));
			params.put("UDSum", vo.get("UDSum"));
			params.put("OprNumb", vo.get("OprNumb"));
			params.put("IDVA", vo.get("IDVA"));
			params.put("IDVB", vo.get("IDVB"));
			params.put("Opr", vo.get("Opr"));
			params.put("ChgFlg", vo.get("ChgFlg"));
			params.put("Source", vo.get("Source"));
			params.put("EfftT", vo.get("EfftT"));
			params.put("result", tranResult);
			if (throwable != null && throwable instanceof BossException) {
				String errorInfo = throwable.toString();
				params.put("errorInfo", StringHelper.leftByByteLength(errorInfo, 200));
			} else {
				params.put("errorInfo", "");
			}
			params.put("SPID", vo.get("SPID"));
			params.put("SPBizCode", vo.get("SPBizCode"));
			// 输出日志至数据库，如果交易存在异常，则在新开启的独立事务中执行SQL
			if (throwable != null) {
				DefaultTransactionDefinition def = new DefaultTransactionDefinition();
				def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
				TransactionStatus status = transactionManager.getTransaction(def);
				
				try {
					Query query = baseDao.createSQLQuery(sql.toString());
					for (Map.Entry<String, Object> param : params.entrySet()) {
						query.setParameter(param.getKey(), param.getValue());
					}
					query.executeUpdate();
					
					transactionManager.commit(status);
				} catch (Throwable e) {
					transactionManager.rollback(status);
					logger.error(e);
				}
				} else {
					Query query = baseDao.createSQLQuery(sql.toString());
					for (Map.Entry<String, Object> param : params.entrySet()) {
						query.setParameter(param.getKey(), param.getValue());
					}
					query.executeUpdate();
				} 
			baseDao.getSess().flush();
			
		} catch (Throwable e) {
			logger.error(e);
			e.printStackTrace();
		}
		
		// 抛出交易执行中捕获的异常
		if (throwable != null) {
			throw throwable;
		}
		
		return retVal;
	}
	
	/**
	 * 记录交易日志，写入数据库表INTER.IN_BUSI_LOG_YYYYMM中
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	public Object loggingToDatabaseOnService(ProceedingJoinPoint pjp) throws Throwable {
		if (pjp.getTarget().getClass().equals(CpcOrderServiceImpl.class)) {
			return this.loggingToDatabaseOnCpcOrderService(pjp);
		}
		String strHostName = "";
		String strHostAddr = "";
		String partitionInstanceRoot = "";
		try {
			com.borland.enterprise.management.partition.PartitionInfo pi=new com.borland.enterprise.management.partition.PartitionInfo();
			strHostName = pi.getHostname();
			strHostAddr = pi.getHostaddress();
			partitionInstanceRoot = System.getProperty("partition.root", ".");
		} catch (Throwable e) {
			logger.warn("Can't get the information of partition.");
		}
	    
		//新CRM接口是通过ServiceContext保存业务数据，老接口是将业务数据保存在Map中。
		if (pjp.getArgs()[0] instanceof com.asiainfo.boss4.support.ServiceContext)
		{
			//新CRM接口
			return loggingToDatabaseOnServiceCrm(pjp);
		}

		//老接口
		LazyDynaMap vo = (LazyDynaMap) pjp.getArgs()[0];
		String tranCode = vo.get("tranCode").toString();
		
		
		Map requestStatus = null;
		// 查询服务没有requestStatus
		if(pjp.getArgs().length >= 2) requestStatus = (Map) pjp.getArgs()[1];
		// 检查请求状态变量，判断是否记录service日志至数据库
		if ( null != requestStatus 
				&& (null == requestStatus.get(AppConstant.REQUEST_STATUS_MAP_IS_LOGGING_TO_DB)
					|| ! (Boolean) requestStatus.get(AppConstant.REQUEST_STATUS_MAP_IS_LOGGING_TO_DB) ) ) {
			return pjp.proceed();
		}
		
		// updateSoId为系统内部交易，不记录交易日志到数据库
		if ("updateSoId".equals(tranCode)) {
			return pjp.proceed();
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Throwable throwable = null;
		char tranResult = '1'; //成功标志
		
		Date sDate = new Date();
		String startDate = dateFormat.format(sDate); //交易开始时间
		Object retVal = null;
		try {
			//执行交易
			retVal = pjp.proceed();

		} catch (Throwable e) {//更新结果标志，捕获异常暂不抛出，待日志记录至数据库完毕再抛出异常
			tranResult = '2'; //失败标志
			throwable = e;
		}
		Date eDate = new Date();
		String endDate = dateFormat.format(eDate); //交易结束时间
		
		try{	

			//拼装SQL串，TRAN_CODE, CREATE_DATE, BEGIN_DATE, END_DATE, TRAN_RESULT为必填字段
			StringBuffer sqlColumns = new StringBuffer("insert into INTER.IN_BUSI_LOG_")
			.append(startDate.substring(0, 6)).append(" (TRAN_CODE, CREATE_DATE, BEGIN_DATE, END_DATE, TRAN_RESULT");
	
			StringBuffer sqlValues = new StringBuffer(") values (:tranCode, sysdate, :startDate, :endDate, :tranResult");
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("tranCode", tranCode);
			params.put("startDate", sDate);
			params.put("endDate", eDate);
			params.put("tranResult", tranResult);
			
			//SERV_ID
			String servId = (String) vo.get("servId");
			if (servId != null) {
				sqlColumns.append(", SERV_ID");
				sqlValues.append(", :servId");
				params.put("servId", Long.valueOf(servId));
			}
			//MSISDN
			String msisdn = (String) vo.get("msisdn");
			if (msisdn != null) {
				sqlColumns.append(", MSISDN");
				sqlValues.append(", :msisdn");
				params.put("msisdn", msisdn);
			}
			//OPER_TYPE
			String operType = (String) vo.get("operType");
			if (operType != null) {
				sqlColumns.append(", OPER_TYPE");
				sqlValues.append(", :operType");
				params.put("operType", operType);
			}
			//SO_NBR
			String soNbr = (String) vo.get("soNbr");
			if (soNbr != null) {
				sqlColumns.append(", SO_NBR");
				sqlValues.append(", :soNbr");
				params.put("soNbr", Long.valueOf(soNbr));
			}
			//TRAN_INFO
			if (throwable != null && throwable instanceof BossException) {
				sqlColumns.append(", TRAN_INFO");
				sqlValues.append(", :tranInfo");
				String tranInfo = throwable.toString();
				params.put("tranInfo", StringHelper.leftByByteLength(tranInfo, 200));
			}
			//EAI_TRADE_ID
			String eaiTradeId = (String) vo.get("eaiTradeId");
			if (eaiTradeId != null) {
				sqlColumns.append(", EAI_TRADE_ID");
				sqlValues.append(", :eaiTradeId");
				params.put("eaiTradeId", Long.valueOf(eaiTradeId));
			}
			//EAI_ORDER_ID
			String eaiOrderId = (String) vo.get("eaiOrderId");
			if (eaiOrderId != null) {
				sqlColumns.append(", EAI_ORDER_ID");
				sqlValues.append(", :eaiOrderId");
				params.put("eaiOrderId", eaiOrderId);
			}
			
			//BRAND
			String brand = (String) vo.get("brand");
			if (brand != null) {
				sqlColumns.append(", BRAND");
				sqlValues.append(", :brand");
				params.put("brand", Long.valueOf(brand));
			}
			
			//PLAN_ID
			String planId = (String) vo.get("planId");
			if (planId != null) {
				sqlColumns.append(", PLAN_ID");
				sqlValues.append(", :planId");
				params.put("planId", Long.valueOf(planId));
			}
			String strErrorData = "";
			//ERR_XML
			if ('2' == tranResult)
				strErrorData = vo.get("inputXml").toString();
			if (!"".equals(strErrorData))
			{
				sqlColumns.append(", ERROR_XML");
				sqlValues.append(", :errorXml");
				params.put("errorXml", strErrorData);
			}

			//REMARK
			{
				sqlColumns.append(", REMARK");
				sqlValues.append(", :remark");
				if (TranCode.TRAN_TRANSFER_ACCOUNT.equalByTranCode(tranCode)) {
					//10009转户时填入oldServId
					String oldServId = (String) vo.get("oldServId");
					if (oldServId != null && !"".equals(oldServId)) {
						params.put("remark", " at "+strHostAddr+" "+strHostName+" "+partitionInstanceRoot+"\t"+oldServId);
					}
				}
				else {
					StringBuffer remark = new StringBuffer("");
					//spromId非空时填入spromId
					String spromId = (String) vo.get("spromId");
					if (spromId != null && !"".equals(spromId) && !"0".equals(spromId)) {
						remark.append("|spromId:").append(spromId);
					}
					String oldBrand = (String) vo.get("oldBrand");
					if (oldBrand != null && !"".equals(oldBrand)) {
						remark.append("|oldBrand:").append(oldBrand);
					}
					String oldPlanId = (String) vo.get("oldPlanId");
					if (oldPlanId != null && !"".equals(oldPlanId)) {
						remark.append("|oldPlanId:").append(oldPlanId);
					}
					params.put("remark", !"".equals(remark.toString()) ? " at "+strHostAddr+" "+strHostName+" "+partitionInstanceRoot+"\t"+remark.substring(1) : " at "+strHostAddr+" "+strHostName+" "+partitionInstanceRoot+"\t");
				}
			}
			
			String sql = sqlColumns.append(sqlValues).append(")").toString();
			
			logger.debug("记录代码为 " + tranCode + " 的交易的日志至数据库");
			// 输出日志至数据库，如果交易存在异常，则在新开启的独立事务中执行SQL
			if (throwable != null) {
				DefaultTransactionDefinition def = new DefaultTransactionDefinition();
				def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
				TransactionStatus status = transactionManager.getTransaction(def);
				
				try {
					Query query = baseDao.createSQLQuery(sql);
					for (Map.Entry<String, Object> param : params.entrySet()) {
						query.setParameter(param.getKey(), param.getValue());
					}
					query.executeUpdate();
					
					transactionManager.commit(status);
				} catch (Throwable e) {
					transactionManager.rollback(status);
					logger.error(e);
				}
//				executeSQLInNewTransaction(query);
			} else {
				Query query = baseDao.createSQLQuery(sql);
				for (Map.Entry<String, Object> param : params.entrySet()) {
					query.setParameter(param.getKey(), param.getValue());
				}
				query.executeUpdate();
//				baseDao.createSQLQuery(sql).executeUpdate();
			}
			baseDao.getSess().flush();
		} catch (Throwable e) {
			logger.error(e);
			e.printStackTrace();
		}
		
		// 抛出交易执行中捕获的异常
		if (throwable != null) {
			throw throwable;
		}
		
	    return retVal;
	}
	
	/**
	 * 开启的新的独立事务，执行SQL
	 * @param sql
	 */
	public void executeSQLInNewTransaction(String sql) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);

		TransactionStatus status = transactionManager.getTransaction(def);
		
		try {
			baseDao.createSQLQuery(sql).executeUpdate();
			transactionManager.commit(status);
		} catch (Throwable e) {
			transactionManager.rollback(status);
			logger.error(e);
		}
	}
	
	/**
	 * 新CRM接口记录交易日志，写入数据库表INTER.IN_BUSI_LOG_YYYYMM中
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	public Object loggingToDatabaseOnServiceCrm(ProceedingJoinPoint pjp) throws Throwable {
		String strHostName = "";
		String strHostAddr = "";
		String partitionInstanceRoot = "";
		try {
			com.borland.enterprise.management.partition.PartitionInfo pi=new com.borland.enterprise.management.partition.PartitionInfo();
			strHostName = pi.getHostname();
			strHostAddr = pi.getHostaddress();
			partitionInstanceRoot = System.getProperty("partition.root", ".");
		} catch (Throwable e) {
			logger.warn("Can't get the information of partition.");
		}

		String strTranCode = "";
		ServiceContext serviceContext = (ServiceContext) pjp.getArgs()[0];
		
		if (serviceContext != null)
		{
			// 取交易代码
			TranCode tranCode = serviceContext.getTranCode();	
			if (tranCode != null)
			{
				strTranCode = tranCode.getTranCode();
			}
		}
		else
			throw new Exception("没有可处理的数据");
		
		// updateSoId为系统内部交易，不记录交易日志到数据库
		if ("updateSoId".equals(strTranCode)) {
			return pjp.proceed();
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Throwable throwable = null;
		char tranResult = '1'; //成功标志
		
		Date sDate = new Date();
		String startDate = dateFormat.format(sDate); //交易开始时间
		Object retVal = null;
		
		//SID
		String strSIDSql = "select zg.SID.NEXTVAL from dual";
		String sid = (String) (baseDao.queryForObject(strSIDSql)).toString();
		if (sid != null){
			//覆盖CRM传来的sid
			serviceContext.setSid(Long.valueOf(sid));
			for (int i = 0; i < serviceContext.getEntities().size(); i++)
			{
				BaseEntity vo = (BaseEntity) serviceContext.getEntities().get(i);	
				BeanUtils.copyProperty(vo, "sid", Long.valueOf(sid));
			}
		}
		
		try {
			//执行交易
			retVal = pjp.proceed();

		} catch (Throwable e) {//更新结果标志，捕获异常暂不抛出，待日志记录至数据库完毕再抛出异常
			tranResult = '2'; //失败标志
			throwable = e;
		}

		Date eDate = new Date();
		String endDate = dateFormat.format(eDate); //交易结束时间
		
		//拼装SQL串，TRAN_CODE, CREATE_DATE, BEGIN_DATE, END_DATE, TRAN_RESULT为必填字段
		StringBuffer sqlColumns = new StringBuffer("insert into INTER.IN_BUSI_LOG_")
				.append(startDate.substring(0, 6)).append(" (TRAN_CODE, CREATE_DATE, BEGIN_DATE, END_DATE, TRAN_RESULT");
		
		StringBuffer sqlValues = new StringBuffer(") values (:tranCode, sysdate, :startDate, :endDate, :tranResult");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tranCode", strTranCode);
		params.put("startDate", sDate);
		params.put("endDate", eDate);
		params.put("tranResult", tranResult);
		try {
			
			
					
			String strSoNbr = serviceContext.getSoNbr().toString();
			String strServId = "";
			String strMsisdn = "";
			String strBrand = "";
			String strPlanId = "";
			for (int i = 0; i < serviceContext.getEntities().size(); i++)
			{
				BaseEntity vo = (BaseEntity) serviceContext.getEntities().get(i);	
				try{
					if ("".equals(strSoNbr)&&!"".equals(PropertyUtils.getProperty(vo, "soNbr")))
						strSoNbr = PropertyUtils.getProperty(vo, "soNbr").toString();
				}catch (Exception e){
						
				}
				try{
					if ("".equals(strServId)&&!"".equals(PropertyUtils.getProperty(vo, "servId")))
						strServId = PropertyUtils.getProperty(vo, "servId").toString();
				}catch (Exception e){
						
				}
				try{
					if ("".equals(strMsisdn)&&!"".equals(PropertyUtils.getProperty(vo, "msisdn")))
						strMsisdn = PropertyUtils.getProperty(vo, "msisdn").toString();
				}catch (Exception e){
						
				}
				try{
					if ("".equals(strBrand)&&!"".equals(PropertyUtils.getProperty(vo, "brand")))
						strBrand = PropertyUtils.getProperty(vo, "brand").toString();
				}catch (Exception e){
						
				}
				try{
					if ("".equals(strPlanId)&&!"".equals(PropertyUtils.getProperty(vo, "planId")))
						strPlanId = PropertyUtils.getProperty(vo, "planId").toString();
				}catch (Exception e){
						
				}
				
			}
			
			if ("".equals(strMsisdn) && serviceContext.getCpcList() != null && serviceContext.getCpcList().size()>0)
			{
				for (int i=0;i<serviceContext.getCpcList().size();i++)
				{
					LazyDynaMap vo = (LazyDynaMap)serviceContext.getCpcList().get(i);
					try{
						if ("".equals(strMsisdn)&&!"".equals(PropertyUtils.getProperty(vo, "IDVA")))
							strMsisdn = PropertyUtils.getProperty(vo, "IDVA").toString();
					}catch (Exception e){
							
					}
				}
			}
				
			
			if (!"".equals(strSoNbr))
			{
				sqlColumns.append(", SO_NBR");
				sqlValues.append(", :soNbr");
				params.put("soNbr", Long.valueOf(strSoNbr));
			}
			if (!"".equals(strMsisdn))
			{
				sqlColumns.append(", MSISDN");
				sqlValues.append(", :msisdn");
				params.put("msisdn", strMsisdn);
			}
			if (!"".equals(strServId))
			{
				sqlColumns.append(", SERV_ID");
				sqlValues.append(", :servId");
				params.put("servId", Long.valueOf(strServId));
			}
			if (!"".equals(strBrand))
			{
				sqlColumns.append(", BRAND");
				sqlValues.append(", :brand");
				params.put("brand", Long.valueOf(strBrand));
			}
			if (!"".equals(strPlanId))
			{
				sqlColumns.append(", PLAN_ID");
				sqlValues.append(", :planId");
				params.put("planId", Long.valueOf(strPlanId));
			}

			String strErrorData="";
			if (serviceContext!=null)
			{
				// 取出错节点
				com.asiainfo.boss4.support.VoErrorData errorData = serviceContext.getErrorData();
				if (errorData!=null){
					strErrorData = "<root><Item><tranCode>"+strTranCode+"</tranCode>";
					if (!"".equals(strSoNbr))
						strErrorData = strErrorData+"<soNbr>"+strSoNbr+"</soNbr>";
					int j=0;
					for (;j<errorData.getErrorValue().size();j++)
					{
							if ('2' != tranResult)
							{
								String strError = errorData.getErrorValue().get(j);
								strErrorData = strErrorData+strError;
							}
							else
							{
								break;
							}
								 
					}
					if (j>=errorData.getErrorValue().size())
						strErrorData = strErrorData+"</Item></root>";	
					if ('2' == tranResult)
						strErrorData = errorData.getStrOriginalXml();
					else if (errorData.getStrOriginalXml().length()>150)
						strErrorData = errorData.getStrOriginalXml().substring(0, 150);
					else if (errorData.getStrOriginalXml().length()<=150)
						strErrorData = errorData.getStrOriginalXml();
				}
			}
			if (!"".equals(strErrorData))
			{
				sqlColumns.append(", ERROR_XML");
				sqlValues.append(", :errorXml");
				params.put("errorXml", strErrorData);
			}
			
//			if (retVal != null && !"".equals(retVal) && tranResult != '2')
//			{
				sqlColumns.append(", REMARK");
				sqlValues.append(", :remark");
				params.put("remark", " at "+strHostAddr+" "+strHostName+" "+partitionInstanceRoot);
//			}
			
			//TRAN_INFO
			if (throwable != null && throwable instanceof BossException) {
				sqlColumns.append(", TRAN_INFO");
				sqlValues.append(", :tranInfo");
				String tranInfo = ((BossException)throwable).getMessage()+((BossException)throwable).getEntityName();
				params.put("tranInfo", StringHelper.leftByByteLength(tranInfo, 200));
			}
			
			String sql = sqlColumns.append(sqlValues).append(")").toString();
			
			logger.debug("记录代码为 " + strTranCode + " 的交易的日志至数据库");
			

			// 输出日志至数据库，如果交易存在异常，则在新开启的独立事务中执行SQL
			if (throwable != null) {
				DefaultTransactionDefinition def = new DefaultTransactionDefinition();
				def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
				TransactionStatus status = transactionManager.getTransaction(def);
				
				try {
					Query query = baseDao.createSQLQuery(sql);
					for (Map.Entry<String, Object> param : params.entrySet()) {
						query.setParameter(param.getKey(), param.getValue());
					}
					query.executeUpdate();
					
					transactionManager.commit(status);
				} catch (Throwable e) {
					transactionManager.rollback(status);
					logger.error(e);
				}
//				executeSQLInNewTransaction(query);
			} else {
				Query query = baseDao.createSQLQuery(sql);
				for (Map.Entry<String, Object> param : params.entrySet()) {
					query.setParameter(param.getKey(), param.getValue());
				}
				query.executeUpdate();
//				baseDao.createSQLQuery(sql).executeUpdate();
			}
			baseDao.getSess().flush();
		} catch (Throwable e) {
			logger.error(e);
			e.printStackTrace();
		}
		
		// 抛出交易执行中捕获的异常
		if (throwable != null) {
			throw throwable;
		}
		
	    return retVal;
	}
}
