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

import com.asiainfo.boss4.domain.IAccount;

/**
 * IAccount0103 entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_ACCOUNT_0103", schema = "ZG")
@IdClass(IAccount0103.IAccount0103Id.class)
public class IAccount0103 extends IAccount implements java.io.Serializable {

	// Fields

	private Long acctId;
	private Long sid;
	private Long soNbr;
	private String acctName;
	private Byte acctType;
	private Short creditClass;
	private Integer credit;
	private Integer acctValue;
	private Long custId;
	private Integer orgId;
	private Short regionCode;
	private Short countyCode;
	private Date beginDate;
	private Date validDate;
	private Date expireDate;
	private String remark;
	private Long mainServId;
	private Short payType;

	// Constructors

	/** default constructor */
	public IAccount0103() {
	}

	/** minimal constructor */
	public IAccount0103(Long acctId, Long sid, Long soNbr, String acctName, Byte acctType,
			Short creditClass, Integer credit, Integer acctValue, Long custId,
			Integer orgId, Short regionCode, Short countyCode, Date beginDate,
			Date validDate, Date expireDate) {
		this.acctId = acctId;
		this.sid = sid;
		this.soNbr = soNbr;
		this.acctName = acctName;
		this.acctType = acctType;
		this.creditClass = creditClass;
		this.credit = credit;
		this.acctValue = acctValue;
		this.custId = custId;
		this.orgId = orgId;
		this.regionCode = regionCode;
		this.countyCode = countyCode;
		this.beginDate = beginDate;
		this.validDate = validDate;
		this.expireDate = expireDate;
	}

	/** full constructor */
	public IAccount0103(Long acctId, Long sid, Long soNbr, String acctName, Byte acctType,
			Short creditClass, Integer credit, Integer acctValue, Long custId,
			Integer orgId, Short regionCode, Short countyCode, Date beginDate,
			Date validDate, Date expireDate, String remark, Long mainServId,
			Short payType) {
		this.acctId = acctId;
		this.sid = sid;
		this.soNbr = soNbr;
		this.acctName = acctName;
		this.acctType = acctType;
		this.creditClass = creditClass;
		this.credit = credit;
		this.acctValue = acctValue;
		this.custId = custId;
		this.orgId = orgId;
		this.regionCode = regionCode;
		this.countyCode = countyCode;
		this.beginDate = beginDate;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.remark = remark;
		this.mainServId = mainServId;
		this.payType = payType;
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

	@Column(name = "ACCT_NAME", nullable = false, length = 64)
	public String getAcctName() {
		return this.acctName;
	}

	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}

	@Column(name = "ACCT_TYPE", nullable = false, precision = 2, scale = 0)
	public Byte getAcctType() {
		return this.acctType;
	}

	public void setAcctType(Byte acctType) {
		this.acctType = acctType;
	}

	@Column(name = "CREDIT_CLASS", nullable = false, precision = 4, scale = 0)
	public Short getCreditClass() {
		return this.creditClass;
	}

	public void setCreditClass(Short creditClass) {
		this.creditClass = creditClass;
	}

	@Column(name = "CREDIT", nullable = false, precision = 9, scale = 0)
	public Integer getCredit() {
		return this.credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	@Column(name = "ACCT_VALUE", nullable = false, precision = 9, scale = 0)
	public Integer getAcctValue() {
		return this.acctValue;
	}

	public void setAcctValue(Integer acctValue) {
		this.acctValue = acctValue;
	}

	@Column(name = "CUST_ID", nullable = false, precision = 14, scale = 0)
	public Long getCustId() {
		return this.custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	@Column(name = "ORG_ID", nullable = false, precision = 8, scale = 0)
	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
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

	@Column(name = "MAIN_SERV_ID", precision = 12, scale = 0)
	public Long getMainServId() {
		return this.mainServId;
	}

	public void setMainServId(Long mainServId) {
		this.mainServId = mainServId;
	}

	@Column(name = "PAY_TYPE", precision = 4, scale = 0)
	public Short getPayType() {
		return this.payType;
	}

	public void setPayType(Short payType) {
		this.payType = payType;
	}

	@Override
	public String toString() {
        return new ToStringBuilder(this)
            .append("acctId", getAcctId())
            .append("sid", getSid())
            .append("soNbr", getSoNbr())
            .append("acctName",getAcctName())
            .append("acctType",getAcctType())
            .append("creditClass",getCreditClass())
            .append("credit",getCredit())
            .append("acctValue",getAcctValue())
            .append("custId",getCustId())
            .append("orgId",getOrgId())
            .append("regionCode",getRegionCode())
            .append("countyCode",getCountyCode())
            .append("beginDate",getBeginDate())
            .append("validDate",getValidDate())
            .append("expireDate",getExpireDate())
            .append("remark",getRemark())
            .append("mainServId",getMainServId())
            .append("payType",getPayType())
            .toString();
    }
	
	public static class IAccount0103Id implements java.io.Serializable {

		// Fields

		private Long acctId;
		private Long sid;
		private Long soNbr;

		// Constructors

		/** default constructor */
		public IAccount0103Id() {
		}

		/** full constructor */
		public IAccount0103Id(Long acctId, Long sid, Long soNbr) {
			this.acctId = acctId;
			this.sid = sid;
			this.soNbr = soNbr;
		}

		// Property accessors

		@Column(name = "ACCT_ID", nullable = false, precision = 14, scale = 0)
		public Long getAcctId() {
			return this.acctId;
		}

		public void setAcctId(Long acctId) {
			this.acctId = acctId;
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
	        if ( !(other instanceof IAccount0103Id) ) return false;
	        IAccount0103Id castOther = (IAccount0103Id) other;
	        return new EqualsBuilder()
	            .append(this.getAcctId(), castOther.getAcctId())
	            .append(this.getSid(), castOther.getSid())
	            .append(this.getSoNbr(), castOther.getSoNbr())
	            .isEquals();
	    }

		@Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getAcctId())
	            .append(getSid())
	            .append(getSoNbr())
	            .toHashCode();
	    }

	}
}