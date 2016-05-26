package com.asiainfo.boss4.service;

import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.DataValiditionHelper;
import com.asiainfo.boss4.support.TranCode;

/**
 * 修改三户信息并订购话费提醒
 * 
 * @author caohui
 * 
 */
public class ChangeAccountInfoAndSubscribeNoticeServiceImpl implements BusinessService {
	private static Log logger = LogFactory.getLog(ChangeAccountInfoAndSubscribeNoticeServiceImpl.class);
	
	private BusinessService changeAccountCustomerUserService;
	private BusinessService chargeNoticeService;
	
	public void setChangeAccountCustomerUserService(
			BusinessService changeAccountCustomerUserService) {
		this.changeAccountCustomerUserService = changeAccountCustomerUserService;
	}

	public void setChargeNoticeService(BusinessService chargeNoticeService) {
		this.chargeNoticeService = chargeNoticeService;
	}

	public String process(LazyDynaMap vo, Map requestStatus) {
		// 关闭service数据库日志
		requestStatus.put(AppConstant.REQUEST_STATUS_MAP_IS_LOGGING_TO_DB, false);
		
		// 修改账户信息
		vo.set("tranCode", TranCode.CHANGE_ACCOUNT.getTranCode());
		changeAccountCustomerUserService.process(vo, requestStatus);
		
		// 订购话费提醒
		vo.set("tranCode", TranCode.CHARGE_NOTICE.getTranCode());
		// 检查提醒标志
		DataValiditionHelper.checkInputVo(vo, "reserved5");
		String flag = (String) vo.get("reserved5");
			
		//缴费提醒
		vo.set("quotaId", "99009010");
		vo.set("quotaValue", "0");
		if ("1".equals(flag.substring(0, 1))) {
			vo.set("operType", "1");
		}
		if ("0".equals(flag.substring(0, 1))) {
			vo.set("operType", "3");
		}
		chargeNoticeService.process(vo, requestStatus);
		
		//停机提醒
		vo.set("quotaId", "99009004");
		vo.set("quotaValue", "0");
		if ("1".equals(flag.substring(1, 2))) {
			vo.set("operType", "1");
		}
		if ("0".equals(flag.substring(1, 2))) {
			vo.set("operType", "3");
		}
		chargeNoticeService.process(vo, requestStatus);
		
		// 打开service数据库日志
		requestStatus.put(AppConstant.REQUEST_STATUS_MAP_IS_LOGGING_TO_DB, true);
		return null;
	}

}
