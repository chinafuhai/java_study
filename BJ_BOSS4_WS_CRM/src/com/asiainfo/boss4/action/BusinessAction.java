package com.asiainfo.boss4.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;


/**
 * 业务动作(action)类接口
 * 将一个业务请求的多个业务操作(对应多个item)分发给业务操作类(service)
 * @author caohui
 *
 */
public interface BusinessAction {
//	String queryAction(List<LazyDynaMap> voList);
//	String updateAction(List<LazyDynaMap> voList, Map<String, Object> requestStatus);
	String dispatch(List<LazyDynaMap> voList, Map<String, Object> requestStatus);
}
