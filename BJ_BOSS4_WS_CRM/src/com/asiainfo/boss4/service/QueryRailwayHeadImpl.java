package com.asiainfo.boss4.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;

import com.asiainfo.boss4.domain.RailwayHead;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.XmlHelper;

public class QueryRailwayHeadImpl implements QueryBusinessService {

	public String process(LazyDynaMap vo) {
		try {
			List<RailwayHead> list = RailwayHead.queryAll(ServiceContext.getInstanceFromCurrentThread());
			Map<String, Object> root = new HashMap<String, Object>();
			root.put("items", list);
			
			return XmlHelper.buildQueryOutputXMLByTemplate(TranCode.QUERY_RAILWAY_HEAD.getTranCode(), root);
		} catch (BossException e) {
			Map<String, String> root = new HashMap<String, String>();
			root.put(XmlHelper._CODE, e.getStatus().getCode());
			root.put(XmlHelper._DESC, e.buildResponseDescription());
			return XmlHelper.buildQueryOutputXMLByTemplate(TranCode.QUERY_RAILWAY_HEAD.getTranCode(), root);
		}
	}

}
