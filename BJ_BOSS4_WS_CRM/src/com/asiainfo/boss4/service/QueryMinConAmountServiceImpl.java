package com.asiainfo.boss4.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.dao.MinConAmountDao;
import com.asiainfo.boss4.domain.CrmUser;
import com.asiainfo.boss4.domain.MinConAmount;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.DataValiditionHelper;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.XmlHelper;

/**
 * 查询最低消费金额
 * crm输入报文样式
 * <root>
 *	<item>
 *		<tranCode>30053</tranCode>
 *		<soNbr>201610181234610</soNbr>
 *		<msisdn>18210872828</msisdn>
 *	</item>
 *</root>
 * @author Administrator
 *
 */
public class QueryMinConAmountServiceImpl implements QueryBusinessService {
	
	protected BusinessDao businessDao;
	protected MinConAmountDao minConAmountDao;
	
	
	
	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}



	public void setMinConAmountDao(MinConAmountDao minConAmountDao) {
		this.minConAmountDao = minConAmountDao;
	}



	public String process(LazyDynaMap vo) {
		try {
			//判断传递的手机号码是否为NULL
			DataValiditionHelper.checkInputVo(vo, "msisdn");
			ServiceContext context = ServiceContext.getInstanceFromCurrentThread();
			
			//获取手机号码，根据手机号码从crm_user表中获取相应的对应，取得serv_id;
			String msisdn = (String) vo.get("msisdn");
			CrmUser crmUser = businessDao.queryCrmUserByPhoneNumber(msisdn);
			if (crmUser == null)
				throw new BossException(StatusCode.NOT_EXIST_USER_ERROR);
			
			//最低消费金额列表，并组装成对象
			List<Object[]> minConAmountlist = minConAmountDao.queryMinConAmount(crmUser.getServId());
			List<MinConAmount> list = new ArrayList<MinConAmount>();
			 for(Object obj[] :minConAmountlist){
				MinConAmount entity = new  MinConAmount();
				entity.setSoId(obj[2].toString());
				entity.setMinAmount(((BigDecimal)obj[3]).longValue());
				entity.setValidDate((Timestamp) obj[0]);
				entity.setExpireDate((Timestamp) obj[1]);
				entity.setPromType(obj[4].toString());
				list.add(entity);
			} 
			
			//将组装对象放到map中
			Map<String, Object> root = new HashMap<String, Object>();
			root.put("items", list);
			
			
			return XmlHelper.buildQueryOutputXMLByTemplate(TranCode.QUERY_MIN_CON_AMOUNT.getTranCode(), root);
		} catch (BossException e) {
			Map<String, String> root = new HashMap<String, String>();
			root.put(XmlHelper._CODE, e.getStatus().getCode());
			root.put(XmlHelper._DESC, e.buildResponseDescription());
			return XmlHelper.buildQueryOutputXMLByTemplate(TranCode.QUERY_MIN_CON_AMOUNT.getTranCode(), root);
		}
	}

}

