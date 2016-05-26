package com.asiainfo.boss4.service;

import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.TranCode;

public class TransferAccountServiceImpl implements BusinessService {
	private Log logger = LogFactory.getLog(TransferAccountServiceImpl.class);
	
	private BusinessService cancelUserService;
	private BusinessService openAccountService;
	
	public void setCancelUserService(BusinessService cancelUserService) {
		this.cancelUserService = cancelUserService;
	}

	public void setOpenAccountService(BusinessService openAccountService) {
		this.openAccountService = openAccountService;
	}

	public String process(LazyDynaMap vo, Map requestStatus) {
		// 关闭service数据库日志
		requestStatus.put(AppConstant.REQUEST_STATUS_MAP_IS_LOGGING_TO_DB, false);
		
		vo.set("newServId", vo.get("servId"));
		vo.set("servId", vo.get("oldServId"));
		vo.set("tranCode", TranCode.__CANCEL_USER_OF_TRANSFER.getTranCode());
		cancelUserService.process(vo, requestStatus);
		vo.set("servId", vo.get("newServId"));
		vo.set("tranCode", TranCode.PRE_OPEN_ACCOUNT.getTranCode());
		openAccountService.process(vo, requestStatus);
		
		// 打开service数据库日志
		requestStatus.put(AppConstant.REQUEST_STATUS_MAP_IS_LOGGING_TO_DB, true);
		return null;
	}

}
