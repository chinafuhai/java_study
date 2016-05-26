package com.asiainfo.boss4.action;

import java.util.List;
import java.util.Map;

import com.asiainfo.boss4.domain.IRentNotify;



/**
 * 业务动作(action)类接口
 * 将一个业务请求的多个业务操作(对应多个item)分发给业务操作类(service)
 * @author weihf
 *
 */
public interface BusinessCrmAction {
	String dispatch(List voList, Map<String, Object> requestStatus);
	String updateCrmUserSts(com.asiainfo.boss4.domain.CrmUser entity);
	String queryIRentNotify(IRentNotify rentNotify);
}
