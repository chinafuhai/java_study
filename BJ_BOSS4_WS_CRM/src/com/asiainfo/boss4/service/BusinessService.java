package com.asiainfo.boss4.service;

import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;

/**
 * 业务操作(service)类接口
 * 用于处理一个业务请求中的单笔交易(item)
 * @author caohui
 *
 */
public interface BusinessService {
	/**
	 * 调用具体业务逻辑
	 * @param vo 请求的参数值
	 * @param requestStatus 维护一个请求的状态
	 * @return
	 */
	String process(LazyDynaMap vo, Map requestStatus);
}
