package com.asiainfo.boss4.domain.partition;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.asiainfo.boss4.domain.CcPlanInstanceRelation;

/**
 * CcPlanInstanceRelation0109 entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "CC_PLAN_INSTANCE_RELATION_0109", schema = "ZG")
public class CcPlanInstanceRelation0109 extends CcPlanInstanceRelation implements java.io.Serializable {

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
	public CcPlanInstanceRelation0109() {
	}

	/** full constructor */
	public CcPlanInstanceRelation0109(Long relationId, Integer ccPlanId,
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
}