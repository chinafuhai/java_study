package com.asiainfo.boss4.action;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.asiainfo.boss4.dao.BusinessDao;

import com.asiainfo.boss4.domain.IRentNotify;
import com.asiainfo.boss4.domain.IRentNotifyHis;
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.service.crm.CrmCommonService;
import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.VoErrorData;
import com.asiainfo.boss4.support.VoTranCode;
/**
 * 业务动作(action)类具体实现
 * 将一个业务请求的多个业务操作(对应多个item)分发给业务操作类(service)
 * @author caohui
 *
 */
public class BusinessCrmActionImpl implements BusinessCrmAction, ApplicationContextAware {
	private static Log logger = LogFactory.getLog(BusinessCrmActionImpl.class);
	
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
	
	public String dispatch(List voList, Map<String, Object> requestStatus) {
		StringBuffer responsesXml = new StringBuffer();
		String strTranCode = "";
		VoErrorData errorData = null;
		List<LazyDynaMap> cpcList = null;
		Long soNbr = null;
		Date soDate = null;
		Long rollBackSoNbr = null;
		if (requestStatus != null)
		{
			List<com.asiainfo.boss4.support.VoErrorData> errorList = (List<com.asiainfo.boss4.support.VoErrorData>)requestStatus.get(AppConstant.ERRORNODENAME);
			List<com.asiainfo.boss4.support.VoTranCode> tranCodeList =  (List<com.asiainfo.boss4.support.VoTranCode>)requestStatus.get(AppConstant.TRANCODE);
			// 取CPC业务数据
			cpcList = (List<LazyDynaMap>)requestStatus.get(AppConstant.CPCNODENAME);
			List soNbrList = (List)requestStatus.get(AppConstant.SONBR);
			List rollBackSoNbrList = (List)requestStatus.get(AppConstant.ROLLBACKSONBR);
			for (int i=0;i<voList.size();i++)
			{
				// 取交易代码
				VoTranCode tranCode = (VoTranCode)tranCodeList.get(i);	
				if (tranCode != null)
				{
					strTranCode = tranCode.getTranCode();
				}
				
				errorData = (VoErrorData)errorList.get(i);
							
				soNbr = (Long)soNbrList.get(i);
				soDate = (Date)requestStatus.get(AppConstant.SODATE);
				rollBackSoNbr = (Long)rollBackSoNbrList.get(i);
				if (strTranCode == null||"".equals(strTranCode)) {
					logger.error("未指定交易代码");
					throw new BossException(StatusCode.NO_INPUT_TRANCODE_ERROR);
				}
					
				CrmCommonService crmService;
				try {
					crmService = (CrmCommonService) applicationContext.getBean("service_"+strTranCode);
				} catch (BeansException e) {
					logger.error("指定的交易代码不存在");
					throw new BossException(StatusCode.NOT_EXIST_TRANCODE_ERROR, e);
				}
				
				ServiceContext serviceContext = new ServiceContext((List<BaseEntity>)voList.get(i),applicationContext);
				serviceContext.setTranCode(TranCode.getInstance(strTranCode));
				serviceContext.setErrorData(errorData);
				if (i == (voList.size()-1) )
					serviceContext.setCpcList(cpcList);
				serviceContext.setSoNbr(soNbr);
				serviceContext.setRollBackSoNbr(rollBackSoNbr);
				serviceContext.setSoDate(soDate);
				serviceContext.setBusinessDao(businessDao);
				
				// 调用业务处理流程
				try {
					String response = crmService.process(serviceContext);
					if (response != null) { // 如果接口服务有响应信息，则追加
						responsesXml.append(response);
					}
				} catch (BossException e) {// 捕获手动抛出的异常
					BossException bossException = new BossException(e, strTranCode, null);
					bossException.setEntityName(e.getEntityName());
					throw bossException;
				} catch (Exception e) {// 捕获系统自身抛出的内部异常
						throw new BossException(StatusCode.INSIDE_ERROR, e, strTranCode, null);
				}

			}
					
		}
		
		if (!"".equals(responsesXml.toString())) {
			return responsesXml.toString();
		} else {
			return null;
		}
	}
	
	public String updateCrmUserSts(com.asiainfo.boss4.domain.CrmUser entity){
		try{
			businessDao.update(entity);
		}catch (Exception e){
			return e.toString();
		}
		return null;
	}

	public String queryIRentNotify(IRentNotify rentNotify) {
		// TODO Auto-generated method stub
		//出账已完成则返回0，正在出账则返回1，其他表示出账失败
		if (rentNotify != null)
		{
			IRentNotifyHis rentNotifyHis = new IRentNotifyHis();
			BeanCopyHelper.copyBeanNotNullProperty(rentNotifyHis, rentNotify);
			List irentNotifyHisList = businessDao.getEntityList(rentNotifyHis, new String[]{"servId", "validDate" });
			businessDao.getSess().flush();
			if (irentNotifyHisList != null && irentNotifyHisList.size()>0)
			{
				for (int i=0;i<irentNotifyHisList.size();i++)
				{
					rentNotifyHis = (IRentNotifyHis)irentNotifyHisList.get(i);
					if (rentNotifyHis.getDealSts()!= null && rentNotifyHis.getDealSts().intValue() == 0)
						return rentNotifyHis.getDealSts().toString()+",出账已完成";
				}
			}
			List irentNotifyList = businessDao.getEntityList(rentNotify, new String[]{"servId", "validDate" });
			businessDao.getSess().flush();
			if (irentNotifyList != null && irentNotifyList.size()>0)
				return "1,正在出账";
			
		}
		return "-1,出账失败需要重新出账";
	}
	
}
