package com.asiainfo.boss4.action;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.service.BusinessService;
import com.asiainfo.boss4.service.crm.CrmCommonService;
import com.asiainfo.boss4.support.AppConfig;
import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.OperateType;
/**
 * 业务动作(action)类具体实现
 * 将一个业务请求的多个业务操作(对应多个item)分发给业务操作类(service)
 * @author caohui
 *
 */
public class BusinessActionImpl implements BusinessAction, ApplicationContextAware {
	private static Log logger = LogFactory.getLog(BusinessActionImpl.class);
	
	private ApplicationContext applicationContext;
	
	private BusinessDao businessDao;

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;

	}
	
	public BusinessDao getBusinessDao() {
		return businessDao;
	}
	
	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}
	
	public String dispatch(List<LazyDynaMap> voList, Map<String, Object> requestStatus) {
		StringBuffer responsesXml = new StringBuffer();
		
		for (int i = 0; i < voList.size(); i++) {
			if ((Boolean)requestStatus.get(AppConstant.REQUEST_STATUS_MAP_IS_BREAK)) {
				logger.debug("中断后续交易");
				break;
			}
			
			LazyDynaMap vo = (LazyDynaMap) voList.get(i);
			
			// 取交易代码
			String tranCode = (String) vo.get("tranCode");
			if (tranCode == null) {
				logger.error("未指定交易代码");
				throw new BossException(StatusCode.NO_INPUT_TRANCODE_ERROR);
			}
			
			BusinessService businessService;
			try {
				businessService = (BusinessService) applicationContext.getBean("service_"+tranCode);
			} catch (BeansException e) {
				logger.error("指定的交易代码不存在");
				throw new BossException(StatusCode.NOT_EXIST_TRANCODE_ERROR, e);
			}
			
			// 如果传入的失效时间为本月底，则重置成下月初
			for (Iterator iterator = vo.getMap().entrySet().iterator(); iterator.hasNext();) {
				Map.Entry entry = (Map.Entry) iterator.next();
				String key = (String) entry.getKey();
				if (key.equals("expireDate") || key.endsWith("ExpireDate")) {
					String value = (String) entry.getValue();
					
					java.util.Date expireDate = DateHelper.String2Date(value);
					// 计算出下月初日期(第一天零时)
					java.util.Date nextMonthFirstDay = DateHelper.getNextMonthFirstDay(expireDate);
					// 计算出本月末日期(最后一秒)
					String currentMonthLastSecond = new SimpleDateFormat(AppConfig.getDateFormat()).format(nextMonthFirstDay.getTime()-1);
//					// 计算出本月末日期(最后一天零时)
//					String currentMonthLastDay = new SimpleDateFormat(AppConfig.getDateFormat()).format(DateHelper.getCurrentMonthLastDay());
					
					/*
					 * 两种情况需要重置expireDate为下月初（第一天零时）
					 * 1. 传入的日期为本月末最后一秒
					 * 2. 传入的日期为传入月份的最后一天零时
					 */
					if (value.equals(currentMonthLastSecond) || DateHelper.isLastDayInMonth(expireDate)) {
						vo.set(key, new SimpleDateFormat(AppConfig.getDateFormat()).format(nextMonthFirstDay));
					}
				}
			}
			
			//新增操作重置soId
			String operType = (String) vo.get("operType");
			if (OperateType.ADD.getTypeCode().equals(operType)) {
				Long soidSeq = businessDao.getSoidSequence();
				
				String soId = (String) vo.get("soId");
				
				String iUserRelationSoId = (String) vo.get("iUserRelationSoId");
				String iUserSpromSoId = (String) vo.get("iUserSpromSoId");
				String iUserMscSoId = (String) vo.get("iUserMscSoId");
				
				if (soId != null) {
					vo.set("soId", soidSeq*10000+Long.valueOf(soId));
				}
				if (iUserRelationSoId != null) {
					vo.set("iUserRelationSoId", soidSeq*10000+Long.valueOf(iUserRelationSoId));
				}
				if (iUserSpromSoId != null) {
					vo.set("iUserSpromSoId", soidSeq*10000+Long.valueOf(iUserSpromSoId));
					//手写免费资源10600(10604)未传入iSpromParamSoId
					vo.set("iSpromParamSoId", soidSeq*10000+Long.valueOf(iUserSpromSoId));
				}
				if (iUserMscSoId != null) {
					vo.set("iUserMscSoId", soidSeq*10000+Long.valueOf(iUserMscSoId));
				}
			}
			
			// 调用业务处理流程
			try {
				String response = businessService.process(vo, requestStatus);
				if (response != null) { // 如果接口服务有响应信息，则追加
					responsesXml.append(response);
				}
			} catch (BossException e) {// 捕获手动抛出的异常
				throw new BossException(e, (String)vo.get("tranCode"), vo.get("sid") != null ? vo.get("sid").toString() : null);
			} catch (Exception e) {// 捕获系统自身抛出的内部异常
				throw new BossException(StatusCode.INSIDE_ERROR, e, (String)vo.get("tranCode"), vo.get("sid") != null ? vo.get("sid").toString() : null);
			}
		}
		
		
		// 修复SO_ID
		Set updateSoIdSQL = (Set) requestStatus.get(AppConstant.REQUEST_STATUS_MAP_UPDATE_SOID);
		if (updateSoIdSQL != null && updateSoIdSQL.size() != 0) {
			BusinessService updateSoIdService;
			try {
				updateSoIdService = (BusinessService) applicationContext.getBean("service_update_soid");
			} catch (BeansException e) {
				logger.error("指定的交易代码不存在");
				throw new BossException(StatusCode.NOT_EXIST_TRANCODE_ERROR, e);
			}
			try {
				LazyDynaMap vo = new LazyDynaMap();
				vo.set("tranCode", "updateSoId");
				updateSoIdService.process(vo, requestStatus);
			} catch (BossException e) {// 捕获手动抛出的异常
				throw e;
			} catch (Exception e) {// 捕获系统自身抛出的内部异常
				throw new BossException(StatusCode.INSIDE_ERROR, e);
			}
		}
		
		if (!"".equals(responsesXml.toString())) {
			return responsesXml.toString();
		} else {
			return null;
		}
	}

}
