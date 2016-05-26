package com.asiainfo.boss4.dao;

import java.util.Map;

import com.asiainfo.boss4.exception.BossException;

public interface ChargeNoticeDao extends BusinessDao {
	/**
	 * 根据产品ID（即QUOTA_ID）查询OWE_MONITOR_QUOTA_MAP是否有定义,并取出监控类型Monitor_Class(必须大于0，否则配置错误，无法订购)
	 * @param quotaId
	 * @return
	 */
	void validatedMonitorClassByProdId(Long quotaId) throws BossException;
	/**
	 * 从OWE_MONITOR_SPEC_QUOTA查询是否已经有该产品未生效订购
	 * @param acctId
	 * @param servId
	 * @param quotaId
	 * @return
	 */
	boolean existedOweMonitorSpecQuota(Long acctId, Long servId, Long quotaId);
	/**
	 * 构造数据"信控计划_实例级对象CC_PLAN_INSTANCE_RELATION"的部分数据
	 * t1.MONITOR_PLAN as CC_PLAN_ID, t2.MONITOR_LEVEL as INSTANCE_TYPE, t2.PRIORITY as PRIORITY
	 * @param quotaId
	 * @param quotaValue
	 * @return
	 */
	Map<String, Object> buildDataForCcPlanInstanceRelation(Long quotaId, Long quotaValue);
	
	/**
	 * 将现有订购从OWE_MONITOR_SPEC_QUOTA挪入历史表  OWE_MONITOR_SPEC_QUOTA_H
	 * @param acctId
	 * @param servId
	 * @param quotaId
	 */
	void moveToOweMonitorSpecQuotaH(Long acctId, Long servId, Long quotaId);
	/**
	 * 将现有订购从OWE_MONITOR_SPEC_QUOTA挪入历史表  OWE_MONITOR_SPEC_QUOTA_H
	 * @param acctId
	 * @param servId
	 */
	void moveToOweMonitorSpecQuotaH(Long acctId, Long servId);
	/**
	 * 删除CcPlanInstanceRelation
	 * @param acctId
	 * @param ccPlanId
	 */
	void removeCcPlanInstanceRelationByAcctIdAndCcPlanId(Long acctId, Integer ccPlanId);
	/**
	 * 删除CcPlanInstanceRelation
	 * @param acctId
	 */
	void removeCcPlanInstanceRelationByAcctId(Long acctId);
	
	public void removeOweMonitorSpecQuotaH(Long acctId, Long servId,Long quotaId);
}
