package com.asiainfo.boss4.domain.partition;

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

import com.asiainfo.boss4.domain.IUserStatus;

/**
 * IUserStatus0104 entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_STATUS_0104", schema = "ZG")
@IdClass(IUserStatus0104.IUserStatus0104Id.class)
public class IUserStatus0104 extends IUserStatus implements java.io.Serializable {

	// Fields

	private Long servId;
	private Long sid;
	private Long soNbr;
	private Byte userSts;
	private Byte operSts;
	private Byte acctSts;
	private Byte mgntSts;
	private Short userType;
	private Short brand;
	private Integer planId;
	private Short regionCode;
	private Short countyCode;
	private String countyCodeBak;
	private Integer orgId;
	private Date beginDate;
	private Date validDate;
	private Date expireDate;
	private String remark;

	// Constructors

	/** default constructor */
	public IUserStatus0104() {
	}

	/** minimal constructor */
	public IUserStatus0104(Long servId, Long sid, Long soNbr, Byte userSts, Short userType,
			Short brand, Integer planId, Short regionCode, Short countyCode,
			Integer orgId, Date beginDate, Date validDate, Date expireDate) {
		this.servId = servId;
		this.sid = sid;
		this.soNbr = soNbr;
		this.userSts = userSts;
		this.userType = userType;
		this.brand = brand;
		this.planId = planId;
		this.regionCode = regionCode;
		this.countyCode = countyCode;
		this.orgId = orgId;
		this.beginDate = beginDate;
		this.validDate = validDate;
		this.expireDate = expireDate;
	}

	/** full constructor */
	public IUserStatus0104(Long servId, Long sid, Long soNbr, Byte userSts, Byte operSts,
			Byte acctSts, Byte mgntSts, Short userType, Short brand,
			Integer planId, Short regionCode, Short countyCode,
			String countyCodeBak, Integer orgId, Date beginDate,
			Date validDate, Date expireDate, String remark) {
		this.servId = servId;
		this.sid = sid;
		this.soNbr = soNbr;
		this.userSts = userSts;
		this.operSts = operSts;
		this.acctSts = acctSts;
		this.mgntSts = mgntSts;
		this.userType = userType;
		this.brand = brand;
		this.planId = planId;
		this.regionCode = regionCode;
		this.countyCode = countyCode;
		this.countyCodeBak = countyCodeBak;
		this.orgId = orgId;
		this.beginDate = beginDate;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.remark = remark;
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
	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	@Id
	public Long getSoNbr() {
		return soNbr;
	}

	public void setSoNbr(Long soNbr) {
		this.soNbr = soNbr;
	}

	@Column(name = "USER_STS", nullable = false, precision = 2, scale = 0)
	public Byte getUserSts() {
		return this.userSts;
	}

	public void setUserSts(Byte userSts) {
		this.userSts = userSts;
	}

	@Column(name = "OPER_STS", precision = 2, scale = 0)
	public Byte getOperSts() {
		return this.operSts;
	}

	public void setOperSts(Byte operSts) {
		this.operSts = operSts;
	}

	@Column(name = "ACCT_STS", precision = 2, scale = 0)
	public Byte getAcctSts() {
		return this.acctSts;
	}

	public void setAcctSts(Byte acctSts) {
		this.acctSts = acctSts;
	}

	@Column(name = "MGNT_STS", precision = 2, scale = 0)
	public Byte getMgntSts() {
		return this.mgntSts;
	}

	public void setMgntSts(Byte mgntSts) {
		this.mgntSts = mgntSts;
	}

	@Column(name = "USER_TYPE", nullable = false, precision = 4, scale = 0)
	public Short getUserType() {
		return this.userType;
	}

	public void setUserType(Short userType) {
		this.userType = userType;
	}

	@Column(name = "BRAND", nullable = false, precision = 4, scale = 0)
	public Short getBrand() {
		return this.brand;
	}

	public void setBrand(Short brand) {
		this.brand = brand;
	}

	@Column(name = "PLAN_ID", nullable = false, precision = 8, scale = 0)
	public Integer getPlanId() {
		return this.planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	@Column(name = "REGION_CODE", nullable = false, precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "COUNTY_CODE", nullable = false, precision = 4, scale = 0)
	public Short getCountyCode() {
		return this.countyCode;
	}

	public void setCountyCode(Short countyCode) {
		this.countyCode = countyCode;
	}

	@Column(name = "COUNTY_CODE_BAK", length = 8)
	public String getCountyCodeBak() {
		return this.countyCodeBak;
	}

	public void setCountyCodeBak(String countyCodeBak) {
		this.countyCodeBak = countyCodeBak;
	}

	@Column(name = "ORG_ID", nullable = false, precision = 8, scale = 0)
	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BEGIN_DATE", nullable = false, length = 7)
	public Date getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VALID_DATE", nullable = false, length = 7)
	public Date getValidDate() {
		return this.validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRE_DATE", nullable = false, length = 7)
	public Date getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
        return new ToStringBuilder(this)
            .append("servId", getServId())
            .append("sid", getSid())
            .append("soNbr", getSoNbr())
            .append("userSts",getUserSts())
            .append("operSts",getOperSts())
            .append("acctSts",getAcctSts())
            .append("mgntSts",getMgntSts())
            .append("userType",getUserType())
            .append("brand",getBrand())
            .append("planId",getPlanId())
            .append("regionCode",getRegionCode())
            .append("countyCode",getCountyCode())
            .append("countyCodeBak",getCountyCodeBak())
            .append("orgId",getOrgId())
            .append("beginDate",getBeginDate())
            .append("validDate",getValidDate())
            .append("expireDate",getExpireDate())
            .append("remark",getRemark())
            .toString();
    }
	
	public static class IUserStatus0104Id implements java.io.Serializable {

		// Fields

		private Long servId;
		private Long sid;
		private Long soNbr;

		// Constructors

		/** default constructor */
		public IUserStatus0104Id() {
		}

		/** full constructor */
		public IUserStatus0104Id(Long servId, Long sid, Long soNbr) {
			this.servId = servId;
			this.sid = sid;
			this.soNbr = soNbr;
		}

		// Property accessors

		@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
		public Long getServId() {
			return this.servId;
		}

		public void setServId(Long servId) {
			this.servId = servId;
		}

		@Column(name = "SID", nullable = false, precision = 12, scale = 0)
		public Long getSid() {
			return this.sid;
		}

		public void setSid(Long sid) {
			this.sid = sid;
		}

		@Column(name = "SO_NBR", nullable = false, precision = 15, scale = 0)
		public Long getSoNbr() {
			return this.soNbr;
		}

		public void setSoNbr(Long soNbr) {
			this.soNbr = soNbr;
		}

		@Override
		public boolean equals(Object other) {
			if ( !(other instanceof IUserStatus0104Id) ) return false;
			IUserStatus0104Id castOther = (IUserStatus0104Id) other;
	        return new EqualsBuilder()
	            .append(this.getServId(), castOther.getServId())
	            .append(this.getSid(), castOther.getSid())
	            .append(this.getSoNbr(), castOther.getSoNbr())
	            .isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder()
	        .append(getServId())
	        .append(getSid())
	        .append(getSoNbr())
	        .toHashCode();
		}

	}
}