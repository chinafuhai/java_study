package com.asiainfo.boss4.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;

import com.asiainfo.boss4.domain.CrmCustomer;
import com.asiainfo.boss4.domain.IUserAll;
import com.asiainfo.boss4.domain.IUserAll.ServIdExt;
import com.asiainfo.boss4.domain.IUserStatusAll;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.DataValiditionHelper;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.XmlHelper;

/**
 * 用户历史信息查询服务类
 * @author caohui
 *
 */
public class QueryUserHisImpl implements QueryBusinessService {

	public String process(LazyDynaMap vo) {
		try {
			DataValiditionHelper.isOnlyOneNonNullKey(vo, new String[]{"msisdn", "ca"});
			
			ServiceContext context = ServiceContext.getInstanceFromCurrentThread();
			
			ServIdExt servIds = null;
			
			String ca = (String) vo.get("ca");
			if (ca != null) {
				CrmCustomer cust = CrmCustomer.queryByCa(context, ca);
				if (cust == null) throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR, "CA编号在BOSS侧不存在");
				
				servIds = IUserAll.queryServIdOfIUserHisByCustId(context, cust.getCustId());
			}
			
			String msisdn = (String) vo.get("msisdn");
			if (msisdn != null) {
				servIds = IUserAll.queryServIdOfIUserHisByMsisdn(context, msisdn);
			}
			
			List<IUserStatusAll> users = IUserStatusAll.queryHis(context, servIds);
			
			Map<String, Object> root = new HashMap<String, Object>();
			root.put("items", users);
			
			return XmlHelper.buildQueryOutputXMLByTemplate(TranCode.QUERY_USER_HIS.getTranCode(), root);
		} catch (BossException e) {
			Map<String, String> root = new HashMap<String, String>();
			root.put(XmlHelper._CODE, e.getStatus().getCode());
			root.put(XmlHelper._DESC, e.buildResponseDescription());
			return XmlHelper.buildQueryOutputXMLByTemplate(TranCode.QUERY_USER_HIS.getTranCode(), root);
		}
	}

}
