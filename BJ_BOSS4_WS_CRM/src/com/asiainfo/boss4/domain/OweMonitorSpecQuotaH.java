package com.asiainfo.boss4.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * OweMonitorSpecQuota entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "OWE_MONITOR_SPEC_QUOTA_H", schema = "ZG")
@IdClass(OweMonitorSpecQuotaH.OweMonitorSpecQuotaId.class)
public class OweMonitorSpecQuotaH implements java.io.Serializable {

	// Fields

	private Long acctId;
	private Long servId;
	private Long quotaId;
	private Date effDate;
	private Long quotaValue;
	private Date expDate;
	private Date createDate;
	private Date optDate;
	private Integer optId;

	// Constructors

	/** default constructor */
	public OweMonitorSpecQuotaH() {
	}

	/** minimal constructor */
	public OweMonitorSpecQuotaH(Long acctId, Long servId, Long quotaId,
			Date effDate) {
		this.acctId = acctId;
		this.servId = servId;
		this.quotaId = quotaId;
		this.effDate = effDate;
	}

	/** full constructor */
	public OweMonitorSpecQuotaH(Long acctId, Long servId, Long quotaId,
			Date effDate, Long quotaValue, Date expDate, Date createDate,
			Date optDate, Integer optId) {
		this.acctId = acctId;
		this.servId = servId;
		this.quotaId = quotaId;
		this.effDate = effDate;
		this.quotaValue = quotaValue;
		this.expDate = expDate;
		this.createDate = createDate;
		this.optDate = optDate;
		this.optId = optId;
	}

	// Property accessors
	@Id
	public Long getAcctId() {
		return acctId;
	}

	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}

	@Id
	public Long getServId() {
		return servId;
	}

	public void setServId(Long servId) {
		this.servId = servId;
	}

	@Id
	public Long getQuotaId() {
		return quotaId;
	}

	public void setQuotaId(Long quotaId) {
		this.quotaId = quotaId;
	}

	@Id
	public Date getEffDate() {
		return effDate;
	}

	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	@Column(name = "QUOTA_VALUE", precision = 12, scale = 0)
	public Long getQuotaValue() {
		return this.quotaValue;
	}

	public void setQuotaValue(Long quotaValue) {
		this.quotaValue = quotaValue;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXP_DATE", length = 7)
	public Date getExpDate() {
		return this.expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", length = 7)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "OPT_DATE", length = 7)
	public Date getOptDate() {
		return this.optDate;
	}

	public void setOptDate(Date optDate) {
		this.optDate = optDate;
	}

	@Column(name = "OPT_ID", precision = 8, scale = 0)
	public Integer getOptId() {
		return this.optId;
	}

	public void setOptId(Integer optId) {
		this.optId = optId;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
		.append("servId",getServId())
		.append("quotaValue",getQuotaValue())
		.append("optDate",getOptDate())
		.append("effDate",getEffDate())
		.append("quotaId",getQuotaId())
		.append("acctId",getAcctId())
		.append("optId",getOptId())
		.append("expDate",getExpDate())
		.append("createDate",getCreateDate())
		.toString();
	}

	public static class OweMonitorSpecQuotaId implements java.io.Serializable {

		// Fields

		private Long acctId;
		private Long servId;
		private Long quotaId;
		private Date effDate;

		// Constructors

		/** default constructor */
		public OweMonitorSpecQuotaId() {
		}

		/** full constructor */
		public OweMonitorSpecQuotaId(Long acctId, Long servId, Long quotaId,
				Date effDate) {
			this.acctId = acctId;
			this.servId = servId;
			this.quotaId = quotaId;
			this.effDate = effDate;
		}

		// Property accessors

		@Column(name = "ACCT_ID", nullable = false, precision = 14, scale = 0)
		public Long getAcctId() {
			return this.acctId;
		}

		public void setAcctId(Long acctId) {
			this.acctId = acctId;
		}

		@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
		public Long getServId() {
			return this.servId;
		}

		public void setServId(Long servId) {
			this.servId = servId;
		}

		@Column(name = "QUOTA_ID", nullable = false, precision = 12, scale = 0)
		public Long getQuotaId() {
			return this.quotaId;
		}

		public void setQuotaId(Long quotaId) {
			this.quotaId = quotaId;
		}

		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "EFF_DATE", nullable = false, length = 7)
		public Date getEffDate() {
			return this.effDate;
		}

		public void setEffDate(Date effDate) {
			this.effDate = effDate;
		}

		@Override
		public boolean equals(Object other) {
			if ( !(other instanceof OweMonitorSpecQuotaId) ) return false;
			OweMonitorSpecQuotaId castOther = (OweMonitorSpecQuotaId) other;
			return new EqualsBuilder()
				.append(this.getServId(), castOther.getServId())
				.append(this.getEffDate(), castOther.getEffDate())
				.append(this.getQuotaId(), castOther.getQuotaId())
				.append(this.getAcctId(), castOther.getAcctId())
				.isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder()
			.append(getServId())
			.append(getEffDate())
			.append(getQuotaId())
			.append(getAcctId())
			.toHashCode();
		}

	}
}