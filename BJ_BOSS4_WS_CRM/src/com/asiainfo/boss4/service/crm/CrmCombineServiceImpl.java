package com.asiainfo.boss4.service.crm;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.support.ServiceContext;

public class CrmCombineServiceImpl implements CrmCommonService{
	private static Log logger = LogFactory.getLog(CrmCombineServiceImpl.class);
	private CrmCommonService crmCommonService;
	private CrmCommonService crmCpcOrderService;
	public CrmCommonService getCrmCommonService() {
		return crmCommonService;
	}
	public void setCrmCommonService(CrmCommonService crmCommonService) {
		this.crmCommonService = crmCommonService;
	}
	public CrmCommonService getCrmCpcOrderService() {
		return crmCpcOrderService;
	}
	public void setCrmCpcOrderService(CrmCommonService crmCpcOrderService) {
		this.crmCpcOrderService = crmCpcOrderService;
	}
	public String process(ServiceContext context) {
		crmCommonService.process(context);
		
		if (context.getCpcList()!= null && context.getCpcList().size()>0)
			crmCpcOrderService.process(context);

		return null;
	}
}
