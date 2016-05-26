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
 * OweNoPressStopRb entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "OWE_NO_PRESS_STOP_RB", schema = "INTER")
@IdClass(OweNoPressStopRb.OweNoPressStopRbId.class)
public class OweNoPressStopRb implements java.io.Serializable {

	// Fields

	private Long servId;
	private Integer subbusiId;
	private Long custId;
	private Byte acctFlag;
	private Long acctId;
	private Byte servFlag;
	private Short sortTypeCode;
	
	private Byte sortFlag;
	private Date validDate;
	private Date expireDate;
	private Byte specialFlag;
	private String remarks;
	private Short regionCode;
	private Integer countyCode;
	private Integer orgId;
	private Integer staffId;
	private Date opDate;
	private Short identityType;
	private Short opType;
	private Long owefeeMax;
	private Long rollbackSoNbr;

	// Constructors

	/** default constructor */
	public OweNoPressStopRb() {
	}

	/** minimal constructor */
	public OweNoPressStopRb(Long servId, Integer subbusiId, Long custId,
			Byte acctFlag, Long acctId, Byte servFlag, Short sortTypeCode, Byte sortFlag,
			Integer countyCode, Long rollbackSoNbr) {
		this.servId = servId;
		this.subbusiId = subbusiId;
		this.custId = custId;
		this.acctFlag = acctFlag;
		this.acctId = acctId;
		this.servFlag = servFlag;
		this.sortTypeCode = sortTypeCode;
		this.sortFlag = sortFlag;
		this.countyCode = countyCode;
		this.rollbackSoNbr = rollbackSoNbr;
	}

	/** full constructor */
	public OweNoPressStopRb(Long servId, Integer subbusiId, Long custId,
			Byte acctFlag, Long acctId, Byte servFlag, Short sortTypeCode, Byte sortFlag,
			Date validDate, Date expireDate, Byte specialFlag,
			String remarks, Short regionCode, Integer countyCode,
			Integer orgId, Integer staffId, Date opDate, Short identityType,
			Short opType, Long owefeeMax, Long rollbackSoNbr) {
		this.servId = servId;
		this.subbusiId = subbusiId;
		this.custId = custId;
		this.acctFlag = acctFlag;
		this.acctId = acctId;
		this.servFlag = servFlag;
		this.sortTypeCode = sortTypeCode;
		this.sortFlag = sortFlag;
		this.countyCode = countyCode;
		this.sortFlag = sortFlag;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.specialFlag = specialFlag;
		this.remarks = remarks;
		this.regionCode = regionCode;
		this.countyCode = countyCode;
		this.orgId = orgId;
		this.staffId = staffId;
		this.opDate = opDate;
		this.identityType = identityType;
		this.opType = opType;
		this.owefeeMax = owefeeMax;
		this.rollbackSoNbr = rollbackSoNbr;
	}

	// Property accessors
	@Id
	public Long getServId() {
		return servId;
	}

	public void setServId(Long servId) {
		this.servId = servId;
	}
	
	@Id
	public Integer getSubbusiId() {
		return subbusiId;
	}

	public void setSubbusiId(Integer subbusiId) {
		this.subbusiId = subbusiId;
	}

	@Id
	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	@Id
	public Byte getAcctFlag() {
		return acctFlag;
	}

	public void setAcctFlag(Byte acctFlag) {
		this.acctFlag = acctFlag;
	}

	@Id
	public Long getAcctId() {
		return acctId;
	}

	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}

	@Id
	public Byte getServFlag() {
		return servFlag;
	}

	public void setServFlag(Byte servFlag) {
		this.servFlag = servFlag;
	}

	@Id
	public Short getSortTypeCode() {
		return sortTypeCode;
	}

	public void setSortTypeCode(Short sortTypeCode) {
		this.sortTypeCode = sortTypeCode;
	}
	
	@Column(name = "SORT_FLAG", nullable = false, precision = 1, scale = 0)
	public Byte getSortFlag() {
		return this.sortFlag;
	}

	public void setSortFlag(Byte sortFlag) {
		this.sortFlag = sortFlag;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VALID_DATE", length = 7)
	public Date getValidDate() {
		return this.validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRE_DATE", length = 7)
	public Date getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Column(name = "SPECIAL_FLAG", precision = 1, scale = 0)
	public Byte getSpecialFlag() {
		return this.specialFlag;
	}

	public void setSpecialFlag(Byte specialFlag) {
		this.specialFlag = specialFlag;
	}

	@Column(name = "REMARKS", length = 1024)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "REGION_CODE", precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "COUNTY_CODE", nullable = false, precision = 8, scale = 0)
	public Integer getCountyCode() {
		return this.countyCode;
	}

	public void setCountyCode(Integer countyCode) {
		this.countyCode = countyCode;
	}

	@Column(name = "ORG_ID", precision = 8, scale = 0)
	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	@Column(name = "STAFF_ID", precision = 8, scale = 0)
	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "OP_DATE", length = 7)
	public Date getOpDate() {
		return this.opDate;
	}

	public void setOpDate(Date opDate) {
		this.opDate = opDate;
	}

	@Column(name = "IDENTITY_TYPE", precision = 4, scale = 0)
	public Short getIdentityType() {
		return this.identityType;
	}

	public void setIdentityType(Short identityType) {
		this.identityType = identityType;
	}

	@Column(name = "OP_TYPE", precision = 4, scale = 0)
	public Short getOpType() {
		return this.opType;
	}

	public void setOpType(Short opType) {
		this.opType = opType;
	}

	@Column(name = "OWEFEE_MAX", precision = 12, scale = 0)
	public Long getOwefeeMax() {
		return this.owefeeMax;
	}

	public void setOwefeeMax(Long owefeeMax) {
		this.owefeeMax = owefeeMax;
	}
	
	@Column(name = "ROLLBACK_SO_NBR", nullable = false, precision = 15, scale = 0)
	public Long getRollbackSoNbr() {
		return rollbackSoNbr;
	}
	
	public void setRollbackSoNbr(Long rollbackSoNbr) {
		this.rollbackSoNbr = rollbackSoNbr;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("servId",getServId())
			.append("opDate",getOpDate())
			.append("identityType",getIdentityType())
			.append("specialFlag",getSpecialFlag())
			.append("opType",getOpType())
			.append("acctId",getAcctId())
			.append("subbusiId",getSubbusiId())
			.append("sortFlag",getSortFlag())
			.append("remarks",getRemarks())
			.append("sortTypeCode",getSortTypeCode())
			.append("custId",getCustId())
			.append("expireDate",getExpireDate())
			.append("servFlag",getServFlag())
			.append("acctFlag",getAcctFlag())
			.append("validDate",getValidDate())
			.append("orgId",getOrgId())
			.append("staffId",getStaffId())
			.append("countyCode",getCountyCode())
			.append("owefeeMax",getOwefeeMax())
			.append("regionCode",getRegionCode())
			.toString();
	}

	public static class OweNoPressStopRbId implements java.io.Serializable {

		// Fields

		private Long servId;
		private Integer subbusiId;
		private Long custId;
		private Byte acctFlag;
		private Long acctId;
		private Byte servFlag;
		private Short sortTypeCode;

		// Constructors

		/** default constructor */
		public OweNoPressStopRbId() {
		}

		/** full constructor */
		public OweNoPressStopRbId(Long servId, Integer subbusiId, Long custId,
				Byte acctFlag, Long acctId, Byte servFlag, Short sortTypeCode) {
			this.servId = servId;
			this.subbusiId = subbusiId;
			this.custId = custId;
			this.acctFlag = acctFlag;
			this.acctId = acctId;
			this.servFlag = servFlag;
			this.sortTypeCode = sortTypeCode;
		}

		// Property accessors

		@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
		public Long getServId() {
			return this.servId;
		}

		public void setServId(Long servId) {
			this.servId = servId;
		}

		@Column(name = "SUBBUSI_ID", nullable = false, precision = 8, scale = 0)
		public Integer getSubbusiId() {
			return this.subbusiId;
		}

		public void setSubbusiId(Integer subbusiId) {
			this.subbusiId = subbusiId;
		}

		@Column(name = "CUST_ID", nullable = false, precision = 14, scale = 0)
		public Long getCustId() {
			return this.custId;
		}

		public void setCustId(Long custId) {
			this.custId = custId;
		}

		@Column(name = "ACCT_FLAG", nullable = false, precision = 1, scale = 0)
		public Byte getAcctFlag() {
			return this.acctFlag;
		}

		public void setAcctFlag(Byte acctFlag) {
			this.acctFlag = acctFlag;
		}

		@Column(name = "ACCT_ID", nullable = false, precision = 14, scale = 0)
		public Long getAcctId() {
			return this.acctId;
		}

		public void setAcctId(Long acctId) {
			this.acctId = acctId;
		}

		@Column(name = "SERV_FLAG", nullable = false, precision = 1, scale = 0)
		public Byte getServFlag() {
			return this.servFlag;
		}

		public void setServFlag(Byte servFlag) {
			this.servFlag = servFlag;
		}

		@Column(name = "SORT_TYPE_CODE", nullable = false, precision = 4, scale = 0)
		public Short getSortTypeCode() {
			return this.sortTypeCode;
		}

		public void setSortTypeCode(Short sortTypeCode) {
			this.sortTypeCode = sortTypeCode;
		}

		@Override
		public boolean equals(Object other) {
			if ( !(other instanceof OweNoPressStopRbId) ) return false;
			OweNoPressStopRbId castOther = (OweNoPressStopRbId) other;
			return new EqualsBuilder()
				.append(this.getServId(), castOther.getServId())
				.append(this.getSubbusiId(), castOther.getSubbusiId())
				.append(this.getCustId(), castOther.getCustId())
				.append(this.getAcctFlag(), castOther.getAcctFlag())
				.append(this.getAcctId(), castOther.getAcctId())
				.append(this.getServFlag(), castOther.getServFlag())
				.append(this.getSortTypeCode(), castOther.getSortTypeCode())
				.isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder()
				.append(getServId())
				.append(getSubbusiId())
				.append(getCustId())
				.append(getAcctFlag())
				.append(getAcctId())
				.append(getServFlag())
				.append(getSortTypeCode())
				.toHashCode();
		}
		
	}
}