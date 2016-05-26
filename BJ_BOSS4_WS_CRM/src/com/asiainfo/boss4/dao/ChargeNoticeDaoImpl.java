package com.asiainfo.boss4.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.NonUniqueResultException;

import com.asiainfo.boss4.domain.CcPlanInstanceRelation;
import com.asiainfo.boss4.domain.OweMonitorSpecQuota;
import com.asiainfo.boss4.domain.OweMonitorSpecQuotaH;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;

@SuppressWarnings("unchecked")
public class ChargeNoticeDaoImpl extends BusinessDaoImpl implements
		ChargeNoticeDao {

	public void validatedMonitorClassByProdId(Long quotaId) {
		StringBuffer sql = new StringBuffer("select t.MONITOR_CLASS from ZG.OWE_MONITOR_QUOTA_MAP t where t.QUOTA_ID = :quotaId");
		try {
			List<Integer> monitorClassList = (List<Integer>) baseDao
					.createSQLQuery(sql.toString())
					.addScalar("MONITOR_CLASS", Hibernate.INTEGER)
					.setLong("quotaId", quotaId).list();
			if (monitorClassList.size() > 1) {
				throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, "查询ZG.OWE_MONITOR_QUOTA_MAP表返回的监控类型MonitorClass多于一条");
			}
			
			if (monitorClassList.size() == 0) {
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR, "查询ZG.OWE_MONITOR_QUOTA_MAP表不存在数据");
			}
			
			//必须大于0，否则配置错误，无法订购
			if (monitorClassList.get(0) <= 0 ) {
				throw new BossException(StatusCode.QUERY_ENTITY_VALUE_ERROR, "监控类型MonitorClass必须大于0，否则配置错误，无法订购");
			}
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

	public boolean existedOweMonitorSpecQuota(Long acctId, Long servId,
			Long quotaId) {
		StringBuffer sql = new StringBuffer("from OweMonitorSpecQuota ")
			.append("where  expDate>effDate ")
			.append("and expDate>sysdate and acctId = :acctId ")
//			.append("and t.serv_id = :servId ")
			.append("and quotaId = :quotaId");
		try {
			List<Object> result = (List<Object>) baseDao.createQuery(sql.toString())
					.setLong("acctId", acctId).setLong("quotaId", quotaId).list();
			if (result.size() > 0) {
				return true;
			}
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
		return false;
	}

	public Map<String, Object> buildDataForCcPlanInstanceRelation(Long quotaId,
			Long quotaValue) {
		StringBuffer sql = new StringBuffer();
		sql.append("select t1.MONITOR_PLAN as ccPlanId, t2.MONITOR_LEVEL as instanceType, t2.PRIORITY as PRIORITY ")
			.append("from ZG.OWE_MONITOR_PLAN_MAP t1, ZG.ACCP_MONITOR_CLASS_DEF t2, ZG.OWE_MONITOR_QUOTA_MAP t3 ")
			.append("where t1.QUOTA_VALUE = :quotaValue and t3.QUOTA_ID = :quotaId ")
			.append("and t1.monitor_class = t2.monitor_class and t1.monitor_class = t3.monitor_class");
		
		try {
			Map<String, Object> result = (Map<String, Object>) baseDao.createSQLQuery(sql.toString())
				.addScalar("CCPLANID", Hibernate.INTEGER)
				.addScalar("INSTANCETYPE", Hibernate.BYTE)
				.addScalar("PRIORITY", Hibernate.INTEGER)
				.setLong("quotaValue", quotaValue)
				.setLong("quotaId", quotaId)
				.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP)
				.uniqueResult();
			
			if (result == null) {
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR, "Can't build entity of CcPlanInstanceRelation from config");
			}
			
			return result;
		} catch (BossException e) {
			throw e;
		}  catch (NonUniqueResultException e) {
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e);
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

	public void moveToOweMonitorSpecQuotaH(Long acctId, Long servId,
			Long quotaId) {
		StringBuffer hql = new StringBuffer("from OweMonitorSpecQuota t ")
			.append("where  expDate>effDate ")
			.append("and expDate>sysdate and acctId = :acctId ")
//			.append("and t.servId = :servId ")
			.append("and t.quotaId = :quotaId");
		List<OweMonitorSpecQuota> list = (List<OweMonitorSpecQuota>) baseDao
				.createQuery(hql.toString()).setLong("acctId", acctId)
				.setLong("quotaId", quotaId).list();
		for (OweMonitorSpecQuota oweMonitorSpecQuota : list) {
			OweMonitorSpecQuotaH his = new OweMonitorSpecQuotaH();
			BeanCopyHelper.copyBeanNotNullProperty(his, oweMonitorSpecQuota);
			try {
				baseDao.insert(his);
				baseDao.delete(oweMonitorSpecQuota);
			} catch (Exception e) {
				throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
			}
		}
	}
	
	public void moveToOweMonitorSpecQuotaH(Long acctId, Long servId) {
		StringBuffer hql = new StringBuffer("from OweMonitorSpecQuota t ")
			.append("where t.expDate > sysdate ")
			.append("and t.acctId = :acctId");
//			.append("and t.servId = :servId");
		List<OweMonitorSpecQuota> list = (List<OweMonitorSpecQuota>) baseDao
				.createQuery(hql.toString()).setLong("acctId", acctId)
				.list();
		for (OweMonitorSpecQuota oweMonitorSpecQuota : list) {
			OweMonitorSpecQuotaH his = new OweMonitorSpecQuotaH();
			BeanCopyHelper.copyBeanNotNullProperty(his, oweMonitorSpecQuota);
			try {
				baseDao.insert(his);
				baseDao.delete(oweMonitorSpecQuota);
			} catch (Exception e) {
				throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
			}
		}
	}

	public void removeCcPlanInstanceRelationByAcctIdAndCcPlanId(Long acctId,
			Integer ccPlanId) {
		StringBuffer sql = new StringBuffer();
		CcPlanInstanceRelation entity = new CcPlanInstanceRelation();
		entity.setAcctId(acctId);
		sql.append("delete from ").append(EntityPartitionHelper.getTableName(entity)).append(" t ");
		sql.append("where t.acct_id = :acctId and t.cc_plan_id = :ccPlanId");
		
		try {
			baseDao.createSQLQuery(sql.toString()).setLong("acctId", acctId).setInteger("ccPlanId", ccPlanId).executeUpdate();
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

	public void removeCcPlanInstanceRelationByAcctId(Long acctId) {
		StringBuffer sql = new StringBuffer();
		CcPlanInstanceRelation entity = new CcPlanInstanceRelation();
		entity.setAcctId(acctId);
		sql.append("delete from ").append(EntityPartitionHelper.getTableName(entity)).append(" t ");
		sql.append("where t.acct_id = :acctId");
		
		try {
			baseDao.createSQLQuery(sql.toString()).setLong("acctId", acctId).executeUpdate();
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	public void removeOweMonitorSpecQuotaH(Long acctId, Long servId,
			Long quotaId) {
		StringBuffer sql = new StringBuffer("delete from zg.Owe_Monitor_Spec_Quota_H ")
			.append("where  exp_Date>eff_Date ")
			.append("and exp_Date>sysdate and acct_Id = :acctId ")
			.append("and serv_id = :servId ")
			.append("and quota_Id = :quotaId");
		try {
			baseDao.createSQLQuery(sql.toString())
					.setLong("acctId", acctId)
					.setLong("servId", servId)
					.setLong("quotaId", quotaId).executeUpdate();			
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}

	}
}
