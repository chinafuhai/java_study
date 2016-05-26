package com.asiainfo.boss4.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;

import com.asiainfo.boss4.domain.IAccountAll;
import com.asiainfo.boss4.domain.ICustomerAll;
import com.asiainfo.boss4.domain.IUserAll;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.support.DataValiditionHelper;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.TimeRange;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.XmlHelper;

/**
 * 三户历史信息查询服务类
 * @author caohui
 *
 */
public class QueryAcctCustHisImpl implements QueryBusinessService {

	public String process(LazyDynaMap vo) {
		TranCode tranCode = TranCode.getInstance((String) vo.get("tranCode"));
		try {
			DataValiditionHelper.checkInputVo(vo, new String[]{"servId", "validDate", "expireDate"});
			
			Long servId = new Long((String)vo.get("servId"));
			String validDate = (String) vo.get("validDate");
			String expireDate = (String) vo.get("expireDate");
			TimeRange range = new TimeRange(DateHelper.String2Date(validDate), DateHelper.String2Date(expireDate));
			
			ServiceContext context = ServiceContext.getInstanceFromCurrentThread();
			
			
			Object items = null;
			if (tranCode == TranCode.QUERY_ACCT_HIS) {
				
				List<Long> acctIds = IUserAll.queryAcctIdInTimeRange(context, servId, range);
				items = IAccountAll.queryInTimeRange(context, acctIds.toArray(new Long[acctIds.size()]), range);
			} else {
				List<Long> custIds = IUserAll.queryCustIdInTimeRange(context, servId, range);
				items = ICustomerAll.queryInTimeRange(context, custIds.toArray(new Long[custIds.size()]), range);
			}
			Map<String, Object> root = new HashMap<String, Object>();
			root.put("items", items);
			
			return XmlHelper.buildQueryOutputXMLByTemplate(tranCode.getTranCode(), root);
		} catch (BossException e) {
			Map<String, String> root = new HashMap<String, String>();
			root.put(XmlHelper._CODE, e.getStatus().getCode());
			root.put(XmlHelper._DESC, e.buildResponseDescription());
			return XmlHelper.buildQueryOutputXMLByTemplate(tranCode.getTranCode(), root);
		}
	}

}
