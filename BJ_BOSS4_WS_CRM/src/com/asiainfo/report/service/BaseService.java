package com.asiainfo.report.service;

import org.apache.commons.beanutils.LazyDynaMap;
/**
 * 业务操作(service)类接口
 */
public interface BaseService {
	/**
	 * 调用具体业务逻辑
	 * @param vo 请求的参数值
	 * @return
	 */
	String process(LazyDynaMap vo);
}
