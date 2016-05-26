package com.asiainfo.boss4.service;

import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.DataValiditionHelper;
import com.asiainfo.boss4.support.TranCode;

public class GroupChangeProductServiceImpl implements BusinessService {
	private Log logger = LogFactory.getLog(GroupChangeProductServiceImpl.class);
	
	private BusinessService changeComboService;
	private BusinessService groupChangeBusinessService;

	public void setChangeComboService(BusinessService changeComboService) {
		this.changeComboService = changeComboService;
	}

	public void setGroupChangeBusinessService(BusinessService groupChangeBusinessService) {
		this.groupChangeBusinessService = groupChangeBusinessService;
	}


	public String process(LazyDynaMap vo, Map requestStatus) {
		// 关闭service数据库日志
		requestStatus.put(AppConstant.REQUEST_STATUS_MAP_IS_LOGGING_TO_DB, false);
		
		DataValiditionHelper.checkInputVo(vo, "tranCode");
		DataValiditionHelper.checkInputVo(vo, "groupKind");
		
		
		// 处理个人终端产品变更
		if (vo.get("spromId") != null && !"".equals(vo.get("spromId"))) { // 判断spromId节点，非空则分解出套餐订购
			vo.set("tranCode", TranCode.CHANGE_COMBO.getTranCode());
			changeComboService.process(vo, requestStatus);
		}
		
		// 处理集团业务变更
		vo.set("tranCode", TranCode.__CHANGE_GROUP_BUSINESS.getTranCode());
		groupChangeBusinessService.process(vo, requestStatus);
		
		
		// 打开service数据库日志
		requestStatus.put(AppConstant.REQUEST_STATUS_MAP_IS_LOGGING_TO_DB, true);
		return null;
	}

}
