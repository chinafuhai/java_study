package com.asiainfo.boss4.domain;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.NonUniqueResultException;

import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable.OperatedField;

/**
 * CcPlanInstanceRelation entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
//@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "CC_PLAN_INSTANCE_RELATION", schema = "ZG")
@PartitionNameForTable(operatedField=OperatedField.ACCT_ID)
public class CcPlanInstanceRelation implements java.io.Serializable {

	// Fields

	private Long relationId;
	private Integer ccPlanId;
	private Byte instanceType;
	private Long instanceId;
	private Long acctId;
	private Integer priority;
	private Date effDate;
	private Date expDate;

	// Constructors

	/** default constructor */
	public CcPlanInstanceRelation() {
	}

	/** full constructor */
	public CcPlanInstanceRelation(Long relationId, Integer ccPlanId,
			Byte instanceType, Long instanceId, Long acctId, Integer priority,
			Date effDate, Date expDate) {
		this.relationId = relationId;
		this.ccPlanId = ccPlanId;
		this.instanceType = instanceType;
		this.instanceId = instanceId;
		this.acctId = acctId;
		this.priority = priority;
		this.effDate = effDate;
		this.expDate = expDate;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_PLAN_RELATION")     
	@SequenceGenerator(name="SEQ_PLAN_RELATION",allocationSize=1,initialValue=1, sequenceName="SEQ_PLAN_RELATION")  
	@Column(name = "RELATION_ID", nullable = false, precision = 12, scale = 0)
	public Long getRelationId() {
		return this.relationId;
	}

	public void setRelationId(Long relationId) {
		this.relationId = relationId;
	}

	@Column(name = "CC_PLAN_ID", nullable = false, precision = 9, scale = 0)
	public Integer getCcPlanId() {
		return this.ccPlanId;
	}

	public void setCcPlanId(Integer ccPlanId) {
		this.ccPlanId = ccPlanId;
	}

	@Column(name = "INSTANCE_TYPE", nullable = false, precision = 2, scale = 0)
	public Byte getInstanceType() {
		return this.instanceType;
	}

	public void setInstanceType(Byte instanceType) {
		this.instanceType = instanceType;
	}

	@Column(name = "INSTANCE_ID", nullable = false, precision = 12, scale = 0)
	public Long getInstanceId() {
		return this.instanceId;
	}

	public void setInstanceId(Long instanceId) {
		this.instanceId = instanceId;
	}

	@Column(name = "ACCT_ID", nullable = false, precision = 14, scale = 0)
	public Long getAcctId() {
		return this.acctId;
	}

	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}

	@Column(name = "PRIORITY", nullable = false, precision = 9, scale = 0)
	public Integer getPriority() {
		return this.priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EFF_DATE", nullable = false, length = 7)
	public Date getEffDate() {
		return this.effDate;
	}

	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXP_DATE", nullable = false, length = 7)
	public Date getExpDate() {
		return this.expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
		.append("instanceType",getInstanceType())
		.append("relationId",getRelationId())
		.append("effDate",getEffDate())
		.append("acctId",getAcctId())
		.append("expDate",getExpDate())
		.append("ccPlanId",getCcPlanId())
		.append("priority",getPriority())
		.append("instanceId",getInstanceId())
		.toString();

	}
	
	private static Map<String, Object> buildData(ServiceContext context, Long quotaId, Long quotaValue) {
		StringBuffer sql = new StringBuffer();
		sql.append("select t1.MONITOR_PLAN as ccPlanId, t2.MONITOR_LEVEL as instanceType, t2.PRIORITY as PRIORITY ")
			.append("from ZG.OWE_MONITOR_PLAN_MAP t1, ZG.ACCP_MONITOR_CLASS_DEF t2, ZG.OWE_MONITOR_QUOTA_MAP t3 ")
			.append("where t1.QUOTA_VALUE = :quotaValue and t3.QUOTA_ID = :quotaId ")
			.append("and t1.monitor_class = t2.monitor_class and t1.monitor_class = t3.monitor_class");
		
		try {
			@SuppressWarnings("unchecked")
			Map<String, Object> result = (Map<String, Object>) context.getBusinessDao().getSess().createSQLQuery(sql.toString())
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
	
	public static CcPlanInstanceRelation getInstance(ServiceContext context, OweMonitorSpecQuota quota) {
		Map<String, Object> data = buildData(context, quota.getQuotaId(), quota.getQuotaValue());
		
		@SuppressWarnings("unchecked")
		Class<CcPlanInstanceRelation> entityClass = EntityPartitionHelper.getClassForPartition(CcPlanInstanceRelation.class, quota.getAcctId());
		CcPlanInstanceRelation instance = BeanCopyHelper.newInstance(entityClass);
		
		instance.setCcPlanId((Integer) data.get("ccPlanId".toUpperCase()));
		instance.setInstanceType((Byte) data.get("instanceType".toUpperCase()));
		instance.setPriority((Integer) data.get("priority".toUpperCase()));
		instance.setInstanceId(quota.getServId());
		instance.setAcctId(quota.getAcctId());
		instance.setEffDate(quota.getEffDate());
		instance.setExpDate(quota.getExpDate());
		
		return instance;
	}
	
	/**
	 * 直接新增实体
	 * @param context
	 */
	public void add(ServiceContext context) {
		context.getBusinessDao().add(this);
	}

	/**
	 * 根据 this 中的acctId, instanceId, ccPlanId 删除实体
	 * @param context
	 * @return
	 */
	public boolean cancel(ServiceContext context) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from ").append(EntityPartitionHelper.getTableName(this)).append(" t ");
		sql.append("where t.acct_id = :acctId and t.cc_plan_id = :ccPlanId and t.instance_id = :instanceId and t.eff_date = :effDate");
		
		try {
			int updated = context.getBusinessDao().getSess().createSQLQuery(sql.toString())
					.setLong("acctId", this.getAcctId())
					.setInteger("ccPlanId", this.getCcPlanId())
					.setLong("instanceId", this.getInstanceId())
					.setTimestamp("effDate", this.getEffDate())
					.executeUpdate();
			return updated > 0;
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	
}