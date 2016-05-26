package com.asiainfo.boss4.service;

import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.TranCode;

/**
 * 订购套餐并添加分账
 * @author caohui
 * @deprecated
 */
public class ChangeComboAndPayRelationServiceImpl implements BusinessService {
	private Log logger = LogFactory.getLog(ChangeComboAndPayRelationServiceImpl.class);
	
	private BusinessService payRelationService;
	private BusinessService changeComboService;

	public void setChangeComboService(BusinessService changeComboService) {
		this.changeComboService = changeComboService;
	}

	public void setPayRelationService(BusinessService payRelationService) {
		this.payRelationService = payRelationService;
	}

	public String process(LazyDynaMap vo, Map requestStatus) {
		// 关闭service数据库日志
		requestStatus.put(AppConstant.REQUEST_STATUS_MAP_IS_LOGGING_TO_DB, false);
		
		vo.set("tranCode", TranCode.CHANGE_COMBO.getTranCode());
		changeComboService.process(vo, requestStatus);
		// 通过报文节点来判断是否进行分账
		if(null != vo.get(AppConstant.PAY_RELATION_FLAG_NOTENAME)) {
			vo.set("tranCode", TranCode.PAY_RELATION.getTranCode());
			// 记录套餐的so_id至remark字段，以区分重复变更的情况
			vo.set("iUserPayRelationRemark", vo.get("iUserSpromSoId"));
			vo.set("crmGroupMemberRemark", vo.get("iUserSpromSoId"));
			payRelationService.process(vo, requestStatus);
		}
		
		// 打开service数据库日志
		requestStatus.put(AppConstant.REQUEST_STATUS_MAP_IS_LOGGING_TO_DB, true);
		return null;
	}

}
