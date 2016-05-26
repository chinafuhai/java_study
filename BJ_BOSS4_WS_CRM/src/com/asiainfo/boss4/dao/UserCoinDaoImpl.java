package com.asiainfo.boss4.dao;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.domain.CrmUserCoinOrder;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;

public class UserCoinDaoImpl extends BusinessDaoImpl implements  UserCoinDao{
	private static Log logger = LogFactory.getLog(UserCoinDaoImpl.class);
	public CrmUserCoinOrder queryCrmUserCoinOrderEntity(Object entity){
		String msisdn = null;
		try {
			msisdn = (String) PropertyUtils.getProperty(entity, "phoneId");
		}
		catch (Exception e) {
			logger.debug("从实体取phoneId赋值失败");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select * from zg.crm_user_coin_order").append(" where phone_id=:phoneId and expire_Date>sysdate and valid_Date<=sysdate  ");
		
		return (CrmUserCoinOrder)this.baseDao.createSQLQuery(sqlBuffer.toString()).addEntity(CrmUserCoinOrder.class).setString("phoneId", msisdn).uniqueResult();

	}
}
