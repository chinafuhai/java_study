package com.asiainfo.boss4.dao;

import org.hibernate.Hibernate;
import org.hibernate.NonUniqueResultException;

import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;

@SuppressWarnings("unchecked")
public class QueryCrmIdDaoImpl extends BusinessDaoImpl implements QueryCrmIdDao {

	public String queryOrgId(Long bossId) {
		return queryCrmId("orgId", bossId);
	}

	public String queryOperatorId(Long bossId) {
		return queryCrmId("operatorId", bossId);
	}
	
	public String queryCrmId(String idType, Long bossId) {
		String sql = "select t.CRM_ID from INTER.CRM_BOSS_IDTYPE_MAP t where t.ID_TYPE = :idType and t.BOSS_ID = :bossId";
		try {
			return (String) baseDao.getSess().createSQLQuery(sql)
					.addScalar("CRM_ID", Hibernate.STRING)
					.setString("idType", idType)
					.setLong("bossId", bossId).uniqueResult();
		} catch (NonUniqueResultException e) {
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e, 
					"Row of INTER.CRM_BOSS_IDTYPE_MAP is not unique.(by ID_TYPE:"+idType+", BOSS_ID:"+bossId+")");
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

}
