package com.asiainfo.boss4.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.service.BusinessService;
import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.BeanCopyHelper;

public class CpcOrderActionImpl implements BusinessAction {
	private static Log logger = LogFactory.getLog(CpcOrderActionImpl.class);

	private BusinessService cpcOrderService;

	public void setCpcOrderService(BusinessService cpcOrderService) {
		this.cpcOrderService = cpcOrderService;
	}

	public String dispatch(List<LazyDynaMap> voList,
			Map<String, Object> requestStatus) {
		StringBuffer responsesXml = new StringBuffer();

		long errorAmount = 0;
		for (int i = 0; i < voList.size(); i++) {
			if ((Boolean) requestStatus.get(AppConstant.REQUEST_STATUS_MAP_IS_BREAK)) {
				logger.debug("中断后续交易");
				break;
			}

			LazyDynaMap vo = (LazyDynaMap) voList.get(i);
			vo.set("tranCode", "40000");
			
			BeanCopyHelper.renameVo(vo, "IDVA", "msisdn");
			BeanCopyHelper.renameVo(vo, "ChgFlg", "servType");
			BeanCopyHelper.renameVo(vo, "SPID", "spCode");
			BeanCopyHelper.renameVo(vo, "SPBizCode", "operatorCode");
			BeanCopyHelper.renameVo(vo, "IDVB", "thirdMsisdn");
			BeanCopyHelper.renameVo(vo, "Opr", "orderSts");
			BeanCopyHelper.renameVo(vo, "EfftT", "validDate");
			BeanCopyHelper.renameVo(vo, "EndT", "expireDate");
			BeanCopyHelper.renameVo(vo, "Source", "srcType");
			vo.set("extendFlag", "64".equals(vo.get("Source")) ? "1" : "0");
			BeanCopyHelper.renameVo(vo, "OprNumb", "remark");

			// 调用业务处理流程
			try {
				cpcOrderService.process(vo, requestStatus);
				
			} catch (Exception e) {
				logger.error(e);
				e.printStackTrace();
				errorAmount++;
			}
		}

		if (errorAmount > 0) {
			throw new BossException(StatusCode.SOME_BUSI_OF_BATCH_ERROR, errorAmount+" operation(s) failed to be processed.");
		}
		
		return null;
	}
	
}
