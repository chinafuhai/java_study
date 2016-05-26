package com.asiainfo.boss4.service.crm;

import com.asiainfo.boss4.support.ServiceContext;

public interface CrmCommonService {
	/**
	 * 调用具体业务逻辑
	 * @param context 用来在整个请求中共享订单相关信息，如tranCode, entities
	 * @return
	 */
	String process(ServiceContext context);
}
