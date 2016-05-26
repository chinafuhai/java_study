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

import com.asiainfo.boss4.domain.ICustomer;

/**
 * ICustomer0102 entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_CUSTOMER_0102", schema = "ZG")
@IdClass(ICustomer0102.ICustomer0102Id.class)
public class ICustomer0102 extends ICustomer implements java.io.Serializable {

	// Fields

	private Long custId;
	private Long sid;
	private Long soNbr;
	private String custName;
	private Byte custType;
	private Byte vipFlag;
	private Short custClass;
	private Integer credit;
	private Integer custValue;
	private Short regionCode;
	private Short countyCode;
	private Date beginDate;
	private Date validDate;
	private Date expireDate;
	private String remark;
	private String custCode;

	// Constructors

	/** default constructor */
	public ICustomer0102() {
	}

	/** minimal constructor */
	public ICustomer0102(Long custId, Long sid, Long soNbr, String custName, Byte custType,
			Byte vipFlag, Short custClass, Short regionCode,
			Short countyCode, Date beginDate, Date validDate, Date expireDate) {
		this.custId = custId;
		this.sid = sid;
		this.soNbr = soNbr;
		this.custName = custName;
		this.custType = custType;
		this.vipFlag = vipFlag;
		this.custClass = custClass;
		this.regionCode = regionCode;
		this.countyCode = countyCode;
		this.beginDate = beginDate;
		this.validDate = validDate;
		this.expireDate = expireDate;
	}

	/** full constructor */
	public ICustomer0102(Long custId, Long sid, Long soNbr, String custName, Byte custType,
			Byte vipFlag, Short custClass, Integer credit,
			Integer custValue, Short regionCode, Short countyCode,
			Date beginDate, Date validDate, Date expireDate, String remark,
			String custCode) {
		this.custId = custId;
		this.sid = sid;
		this.soNbr = soNbr;
		this.custName = custName;
		this.custType = custType;
		this.vipFlag = vipFlag;
		this.custClass = custClass;
		this.credit = credit;
		this.custValue = custValue;
		this.regionCode = regionCode;
		this.countyCode = countyCode;
		this.beginDate = beginDate;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.remark = remark;
		this.custCode = custCode;
	}

	// Property accessors
	@Id
	public Long getCustId() {
		return this.custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	@Id
	public Long getSid() {
		return this.sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	@Id
	public Long getSoNbr() {
		return this.soNbr;
	}

	public void setSoNbr(Long soNbr) {
		this.soNbr = soNbr;
	}

	@Column(name = "CUST_NAME", nullable = false, length = 200)
	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	@Column(name = "CUST_TYPE", nullable = false, precision = 2, scale = 0)
	public Byte getCustType() {
		return this.custType;
	}

	public void setCustType(Byte custType) {
		this.custType = custType;
	}

	@Column(name = "VIP_FLAG", nullable = false, precision = 1, scale = 0)
	public Byte getVipFlag() {
		return this.vipFlag;
	}

	public void setVipFlag(Byte vipFlag) {
		this.vipFlag = vipFlag;
	}

	@Column(name = "CUST_CLASS", nullable = false, precision = 4, scale = 0)
	public Short getCustClass() {
		return this.custClass;
	}

	public void setCustClass(Short custClass) {
		this.custClass = custClass;
	}

	@Column(name = "CREDIT", precision = 9, scale = 0)
	public Integer getCredit() {
		return this.credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	@Column(name = "CUST_VALUE", precision = 9, scale = 0)
	public Integer getCustValue() {
		return this.custValue;
	}

	public void setCustValue(Integer custValue) {
		this.custValue = custValue;
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

	@Column(name = "CUST_CODE", length = 32)
	public String getCustCode() {
		return this.custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	
	@Override
	public String toString() {
        return new ToStringBuilder(this)
            .append("custId", getCustId())
            .append("sid", getSid())
            .append("soNbr", getSoNbr())
            .append("custName",getCustName())
            .append("custType",getCustType())
            .append("vipFlag",getVipFlag())
            .append("custClass",getCustClass())
            .append("credit",getCredit())
            .append("custValue",getCustValue())
            .append("regionCode",getRegionCode())
            .append("countyCode",getCountyCode())
            .append("beginDate",getBeginDate())
            .append("validDate",getValidDate())
            .append("expireDate",getExpireDate())
            .append("remark",getRemark())
            .append("custCode",getCustCode())
            .toString();
    }
	
	public static class ICustomer0102Id implements java.io.Serializable {

		// Fields

		private Long custId;
		private Long sid;
		private Long soNbr;

		// Constructors

		/** default constructor */
		public ICustomer0102Id() {
		}

		/** full constructor */
		public ICustomer0102Id(Long custId, Long sid, Long soNbr) {
			this.custId = custId;
			this.sid = sid;
			this.soNbr = soNbr;
		}

		// Property accessors

		@Column(name = "CUST_ID", nullable = false, precision = 14, scale = 0)
		public Long getCustId() {
			return this.custId;
		}

		public void setCustId(Long custId) {
			this.custId = custId;
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
	        if ( !(other instanceof ICustomer0102Id) ) return false;
	        ICustomer0102Id castOther = (ICustomer0102Id) other;
	        return new EqualsBuilder()
	            .append(this.getCustId(), castOther.getCustId())
	            .append(this.getSid(), castOther.getSid())
	            .append(this.getSoNbr(), castOther.getSoNbr())
	            .isEquals();
	    }

		@Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getCustId())
	            .append(getSid())
	            .append(getSoNbr())
	            .toHashCode();
	    }
	}

}