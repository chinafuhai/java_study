package com.asiainfo.boss4.service;

import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.LazyDynaMap;

import com.asiainfo.boss4.aspect.ReadjustInputValueAdvice;
import com.asiainfo.boss4.domain.CrmUser;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.DataValiditionHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
/**
 * 重置停机级别
 * 根据用户当前的VIP级别重置停机级别
 * @author caohui
 *
 */
public class ResetStopLevelByVipLevelServiceImpl extends BusinessServiceImpl
		implements BusinessService {
	
	private void resetStopLevel(DynaBean vo) {
		DataValiditionHelper.checkInputVo(vo, "servId");
		String servId = vo.get("servId").toString();
		CrmUser user = businessDao.queryCrmUserByServId(Long.valueOf(servId));
		if (user == null) {
			throw new BossException(StatusCode.NOT_EXIST_USER_ERROR, "There is not a CRM_USER's row which SERV_ID equals "+servId+" .");
		}
		String vipLevel = user.getReserved2();
		if (null == vipLevel || "".equalsIgnoreCase(vipLevel.trim()) || "0".equalsIgnoreCase(vipLevel.trim())) {
			vo.set("stopLevel", "1");//停机级别调整为“普通停机”
			return;
		}
		ReadjustInputValueAdvice.resetStopLevelByVipLevel((LazyDynaMap) vo, vipLevel.trim());
	}

	@Override
	public String process(LazyDynaMap vo, Map requestStatus) {
		if (!"4".equals(vo.get("operType"))) {
			throw new BossException(StatusCode.NO_INPUT_OPERTYPE_ERROR, "The element value of 'operType' must be '4'.");
		}
		this.resetStopLevel(vo);
		return super.process(vo, requestStatus);
	}
	
	
	
}
