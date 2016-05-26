package com.asiainfo.boss4.dao;


import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.domain.AccBatchDeductOrder;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;


/**
 * 查询用户签约Dao实现类
 * @author weihf
 */
public class SignContractDaoImpl extends BusinessDaoImpl implements SignContractDao{
	private static Log logger = LogFactory.getLog(SignContractDaoImpl.class);
	public AccBatchDeductOrder queryAccBatchDeductOrderEntity(Object entity)
	{
		String msisdn = null;
		//String signBankName = null;
		try {
			msisdn = (String) PropertyUtils.getProperty(entity, "msisdn");
			//signBankName = (String) PropertyUtils.getProperty(entity, "signBankName");
		}
		catch (Exception e) {
			logger.debug("从实体取msisdn、signBankName赋值失败");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select * from Acc_Batch_Deduct_Order").append(" where msisdn=:msisdn  and exp_Date>sysdate and eff_Date<=sysdate ");
		
		return (AccBatchDeductOrder)this.baseDao.createSQLQuery(sqlBuffer.toString()).addEntity(AccBatchDeductOrder.class).setString("msisdn", msisdn).uniqueResult();
	}
}
