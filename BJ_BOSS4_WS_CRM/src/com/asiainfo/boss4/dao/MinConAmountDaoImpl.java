package com.asiainfo.boss4.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MinConAmountDaoImpl implements MinConAmountDao{
	private static Log logger = LogFactory.getLog(MinConAmountDaoImpl.class);
	protected BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	

	public List<Object[]> queryMinConAmount(Long servId) {
		//根据servId获取相应的分区编号
		String suffix = String.valueOf(servId%10+101);
		suffix="0"+suffix;
		
		StringBuffer strSql = new StringBuffer();
		strSql.append("SELECT  ta.valid_date,ta.expire_date,ta.so_id, case tc.key_id when 790001 then tc.sprom_para / 1000 when 790002 then ta.NUMERATOR * tc.sprom_para / 100 / 100 else ta.numerator/100 end money,CASE TA.PROM_TYPE WHEN 7 THEN 1 ELSE 0 END PROM_TYPE FROM (SELECT Ta.SO_ID,ta.serv_id, Ta.VALID_DATE,Ta.EXPIRE_DATE,tb.NUMERATOR,TB.PROM_TYPE　FROM ZG.I_USER_SPROM_").append(suffix).append(" Ta, CP.ZCGJ_PROM_T tb WHERE ta.SERV_ID ='").append(servId).append("' AND ta.EXPIRE_DATE > SYSDATE AND TA.EXPIRE_DATE > TA.VALID_DATE AND ta.SPROM_ID = tb.PROD_ID AND tb.PROM_TYPE IN(11,7)) ta left join (SELECT * FROM ZG.I_sprom_param_").append(suffix).append(" t WHERE t.key_id in (790001, 790002)) tc  on ta.serv_id = tc.serv_id  and ta.so_id = tc.so_id"); 
		
		List<Object[]> list = baseDao.createSQLQuery(strSql.toString()).list();
		return list;
	}
}

