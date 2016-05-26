package com.asiainfo.boss4.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;

import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.DateHelper;

public class JfBusinessDao {
private static Log logger = LogFactory.getLog(JfBusinessDao.class);
	
	private BaseDao baseDaoJf;

	public void setBaseDaoJf(BaseDao baseDaoJf) {
		this.baseDaoJf = baseDaoJf;
	}
	
	/**
	 * 查询手机游戏日累积充值
	 * @param msisdn
	 * @param spCode
	 * @param operatorCode
	 * @param currentDate
	 * @return
	 */
	public Long queryCostOfPhoneGameSP(String msisdn, String currentDate) {
		Long result = null;
		
		//校验currentDate是否为yyyyMMdd
		DateHelper.String2Date(currentDate, "yyyyMMdd");
		
		StringBuffer sql = new StringBuffer();
		sql.append("select /*+ index(t JF.DR_ISMP_100_").append(currentDate).append("_IDX1) */ ");
		sql.append("sum(t.charge4)/1000 as AMOUNT from JF.DR_ISMP_100_").append(currentDate)
			.append(" t where t.user_number = :msisdn and t.sp_code = :spCode and t.dr_type= :drType and t.bill_flag = :billFlag and t.sub_type = :subType");
		
		try {
			result = (Long) baseDaoJf.createSQLQuery(sql.toString()).addScalar("AMOUNT", Hibernate.LONG)
						.setString("msisdn", msisdn)
						.setString("spCode", "701001")
						.setLong("drType", 90703L)
						.setInteger("billFlag", 2)
						.setString("subType", "01").setTimeout(10).uniqueResult();
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
		return result == null ? 0L : result;
	}
	
	/**
	 * 查询手机游戏月累积充值
	 * @param msisdn
	 * @param yyyyMM
	 * @return
	 */
	public Long queryMonthlyCostOfPhoneGameSP(String msisdn, String yyyyMM) {
		Long result = null;
		
		//校验currentDate是否为yyyyMM
		DateHelper.String2Date(yyyyMM, "yyyyMM");
		
		String sql = "select sum(t.charge4)/1000 as AMOUNT from jf.dr_ismp_100 t where t.user_number = :msisdn and substr(t.bill_month,0,6) = :yyyyMM";
		
		try {
			result = (Long) baseDaoJf.createSQLQuery(sql).addScalar("AMOUNT", Hibernate.LONG)
						.setString("msisdn", msisdn).setString("yyyyMM", yyyyMM)
						.uniqueResult();
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
		return result == null ? 0L : result;
	}
}
