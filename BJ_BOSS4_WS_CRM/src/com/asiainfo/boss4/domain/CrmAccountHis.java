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

import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable;

/**
 * CrmAccountHis entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "CRM_ACCOUNT_HIS", schema = "ZG")
@IdClass(CrmAccountHis.CrmAccountHisId.class)
@PartitionNameForTable.RegionCode
@Backup(processedField = Backup.ProcessedField.P_SONBR)
public class CrmAccountHis implements java.io.Serializable {

	// Fields

	private Long acctId;
	private Long soNbr;
	private String acctName;
	private Byte acctClass;
	private Byte acctType;
	private Long custId;
	private String mainPhoneId;
	private Byte sts;
	private Date stsDate;
	private Date createDate;
	private Short payType;
	private Integer bankId;
	private String bankAcct;
	private Byte bankAcctType;
	private Long bankValue;
	private Integer limitFee;
	private Short creditClass;
	private Integer credit;
	private Integer acctValue;
	private Short postType;
	private Integer postCode;
	private String postAddr;
	private Integer orgId;
	private Short regionCode;
	private Short countyCode;
	private String acctExtFlag;
	private Long psoNbr;
	private String remark;
	private String trustAcctId;
	private String bankAcctName;
	private Integer monitorFlag;
	private String contact;
	private String reserved1;
	private String reserved2;
	private String reserved3;
	private String reserved4;
	private String reserved5;

	// Constructors

	/** default constructor */
	public CrmAccountHis() {
	}

	/** minimal constructor */
	public CrmAccountHis(Long acctId, Long soNbr) {
		this.acctId = acctId;
		this.soNbr = soNbr;
	}

	/** full constructor */
	public CrmAccountHis(Long acctId, Long soNbr, String acctName, Byte acctClass,
			Byte acctType, Long custId, String mainPhoneId, Byte sts,
			Date stsDate, Date createDate, Short payType, Integer bankId,
			String bankAcct, Byte bankAcctType, Long bankValue,
			Integer limitFee, Short creditClass, Integer credit,
			Integer acctValue, Short postType, Integer postCode,
			String postAddr, Integer orgId, Short regionCode, Short countyCode,
			String acctExtFlag, Long psoNbr, String remark, String trustAcctId,
			String bankAcctName, Integer monitorFlag, String contact, String reserved1, String reserved2,
			String reserved3, String reserved4, String reserved5) {
		this.acctId = acctId;
		this.soNbr = soNbr;
		this.acctName = acctName;
		this.acctClass = acctClass;
		this.acctType = acctType;
		this.custId = custId;
		this.mainPhoneId = mainPhoneId;
		this.sts = sts;
		this.stsDate = stsDate;
		this.createDate = createDate;
		this.payType = payType;
		this.bankId = bankId;
		this.bankAcct = bankAcct;
		this.bankAcctType = bankAcctType;
		this.bankValue = bankValue;
		this.limitFee = limitFee;
		this.creditClass = creditClass;
		this.credit = credit;
		this.acctValue = acctValue;
		this.postType = postType;
		this.postCode = postCode;
		this.postAddr = postAddr;
		this.orgId = orgId;
		this.regionCode = regionCode;
		this.countyCode = countyCode;
		this.acctExtFlag = acctExtFlag;
		this.psoNbr = psoNbr;
		this.remark = remark;
		this.trustAcctId = trustAcctId;
		this.bankAcctName = bankAcctName;
		this.monitorFlag = monitorFlag;
		this.contact = contact;
		this.reserved1 = reserved1;
		this.reserved2 = reserved2;
		this.reserved3 = reserved3;
		this.reserved4 = reserved4;
		this.reserved5 = reserved5;
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
	public Long getSoNbr() {
		return soNbr;
	}

	public void setSoNbr(Long soNbr) {
		this.soNbr = soNbr;
	}

	@Column(name = "ACCT_NAME", length = 64)
	public String getAcctName() {
		return this.acctName;
	}

	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}

	@Column(name = "ACCT_CLASS", precision = 2, scale = 0)
	public Byte getAcctClass() {
		return this.acctClass;
	}

	public void setAcctClass(Byte acctClass) {
		this.acctClass = acctClass;
	}

	@Column(name = "ACCT_TYPE", precision = 2, scale = 0)
	public Byte getAcctType() {
		return this.acctType;
	}

	public void setAcctType(Byte acctType) {
		this.acctType = acctType;
	}

	@Column(name = "CUST_ID", precision = 14, scale = 0)
	public Long getCustId() {
		return this.custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	@Column(name = "MAIN_PHONE_ID", length = 15)
	public String getMainPhoneId() {
		return this.mainPhoneId;
	}

	public void setMainPhoneId(String mainPhoneId) {
		this.mainPhoneId = mainPhoneId;
	}

	@Column(name = "STS", precision = 2, scale = 0)
	public Byte getSts() {
		return this.sts;
	}

	public void setSts(Byte sts) {
		this.sts = sts;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STS_DATE", length = 7)
	public Date getStsDate() {
		return this.stsDate;
	}

	public void setStsDate(Date stsDate) {
		this.stsDate = stsDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", length = 7)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "PAY_TYPE", precision = 4, scale = 0)
	public Short getPayType() {
		return this.payType;
	}

	public void setPayType(Short payType) {
		this.payType = payType;
	}

	@Column(name = "BANK_ID", precision = 8, scale = 0)
	public Integer getBankId() {
		return this.bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	@Column(name = "BANK_ACCT", length = 36)
	public String getBankAcct() {
		return this.bankAcct;
	}

	public void setBankAcct(String bankAcct) {
		this.bankAcct = bankAcct;
	}

	@Column(name = "BANK_ACCT_TYPE", precision = 2, scale = 0)
	public Byte getBankAcctType() {
		return this.bankAcctType;
	}

	public void setBankAcctType(Byte bankAcctType) {
		this.bankAcctType = bankAcctType;
	}

	@Column(name = "BANK_VALUE", precision = 12, scale = 0)
	public Long getBankValue() {
		return this.bankValue;
	}

	public void setBankValue(Long bankValue) {
		this.bankValue = bankValue;
	}

	@Column(name = "LIMIT_FEE", precision = 9, scale = 0)
	public Integer getLimitFee() {
		return this.limitFee;
	}

	public void setLimitFee(Integer limitFee) {
		this.limitFee = limitFee;
	}

	@Column(name = "CREDIT_CLASS", precision = 4, scale = 0)
	public Short getCreditClass() {
		return this.creditClass;
	}

	public void setCreditClass(Short creditClass) {
		this.creditClass = creditClass;
	}

	@Column(name = "CREDIT", precision = 9, scale = 0)
	public Integer getCredit() {
		return this.credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	@Column(name = "ACCT_VALUE", precision = 9, scale = 0)
	public Integer getAcctValue() {
		return this.acctValue;
	}

	public void setAcctValue(Integer acctValue) {
		this.acctValue = acctValue;
	}

	@Column(name = "POST_TYPE", precision = 4, scale = 0)
	public Short getPostType() {
		return this.postType;
	}

	public void setPostType(Short postType) {
		this.postType = postType;
	}

	@Column(name = "POST_CODE", precision = 6, scale = 0)
	public Integer getPostCode() {
		return this.postCode;
	}

	public void setPostCode(Integer postCode) {
		this.postCode = postCode;
	}

	@Column(name = "POST_ADDR", length = 64)
	public String getPostAddr() {
		return this.postAddr;
	}

	public void setPostAddr(String postAddr) {
		this.postAddr = postAddr;
	}

	@Column(name = "ORG_ID", precision = 8, scale = 0)
	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	@Column(name = "REGION_CODE", precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "COUNTY_CODE", precision = 4, scale = 0)
	public Short getCountyCode() {
		return this.countyCode;
	}

	public void setCountyCode(Short countyCode) {
		this.countyCode = countyCode;
	}

	@Column(name = "ACCT_EXT_FLAG", length = 20)
	public String getAcctExtFlag() {
		return this.acctExtFlag;
	}

	public void setAcctExtFlag(String acctExtFlag) {
		this.acctExtFlag = acctExtFlag;
	}

	@Column(name = "PSO_NBR", precision = 15, scale = 0)
	public Long getPsoNbr() {
		return this.psoNbr;
	}

	public void setPsoNbr(Long psoNbr) {
		this.psoNbr = psoNbr;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "TRUST_ACCT_ID", length = 20)
	public String getTrustAcctId() {
		return this.trustAcctId;
	}

	public void setTrustAcctId(String trustAcctId) {
		this.trustAcctId = trustAcctId;
	}

	@Column(name = "BANK_ACCT_NAME", length = 64)
	public String getBankAcctName() {
		return this.bankAcctName;
	}

	public void setBankAcctName(String bankAcctName) {
		this.bankAcctName = bankAcctName;
	}

	@Column(name = "MONITOR_FLAG", precision = 9, scale = 0)
	public Integer getMonitorFlag() {
		return monitorFlag;
	}

	public void setMonitorFlag(Integer monitorFlag) {
		this.monitorFlag = monitorFlag;
	}

	@Column(name = "CONTACT")
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(name = "RESERVED1")
	public String getReserved1() {
		return this.reserved1;
	}

	public void setReserved1(String reserved1) {
		this.reserved1 = reserved1;
	}

	@Column(name = "RESERVED2")
	public String getReserved2() {
		return this.reserved2;
	}

	public void setReserved2(String reserved2) {
		this.reserved2 = reserved2;
	}

	@Column(name = "RESERVED3")
	public String getReserved3() {
		return this.reserved3;
	}

	public void setReserved3(String reserved3) {
		this.reserved3 = reserved3;
	}

	@Column(name = "RESERVED4")
	public String getReserved4() {
		return this.reserved4;
	}

	public void setReserved4(String reserved4) {
		this.reserved4 = reserved4;
	}

	@Column(name = "RESERVED5")
	public String getReserved5() {
		return reserved5;
	}

	public void setReserved5(String reserved5) {
		this.reserved5 = reserved5;
	}

	@Override
	public String toString(){
		return  new ToStringBuilder(this)
		.append("acctId",getAcctId())
		.append("acctName",getAcctName())
		.append("acctClass",getAcctClass())
		.append("acctType",getAcctType())
		.append("custId",getCustId())
		.append("mainPhoneId",getMainPhoneId())
		.append("sts",getSts())
		.append("stsDate",getStsDate())
		.append("createDate",getCreateDate())
		.append("payType",getPayType())
		.append("bankId",getBankId())
		.append("bankAcct",getBankAcct())
		.append("bankAcctType",getBankAcctType())
		.append("bankValue",getBankValue())
		.append("limitFee",getLimitFee())
		.append("creditClass",getCreditClass())
		.append("credit",getCredit())
		.append("acctValue",getAcctValue())
		.append("postType",getPostType())
		.append("postCode",getPostCode())
		.append("postAddr",getPostAddr())
		.append("orgId",getOrgId())
		.append("regionCode",getRegionCode())
		.append("countyCode",getCountyCode())
		.append("acctExtFlag",getAcctExtFlag())
		.append("soNbr",getSoNbr())
		.append("remark",getRemark())
		.append("trustAcctId",getTrustAcctId())
		.append("bankAcctName",getBankAcctName())
		.append("psoNbr",getPsoNbr())
		.append("monitorFlag",getMonitorFlag())
		.append("contact",getContact())
		.append("reserved1",getReserved1())
        .append("reserved2",getReserved2())
        .append("reserved3",getReserved3())
        .append("reserved4",getReserved4())
        .append("reserved5",getReserved5())
		.toString();
	 }
	
	public static class CrmAccountHisId implements java.io.Serializable {

		// Fields

		private Long acctId;
		private Long soNbr;

		// Constructors

		/** default constructor */
		public CrmAccountHisId() {
		}

		/** full constructor */
		public CrmAccountHisId(Long acctId, Long soNbr) {
			this.acctId = acctId;
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

		@Column(name = "SO_NBR", nullable = false, precision = 15, scale = 0)
		public Long getSoNbr() {
			return this.soNbr;
		}

		public void setSoNbr(Long soNbr) {
			this.soNbr = soNbr;
		}

		@Override
		public boolean equals(Object other) {
	        if ( !(other instanceof CrmAccountHisId) ) return false;
	        CrmAccountHisId castOther = (CrmAccountHisId) other;
	        return new EqualsBuilder()
	            .append(this.getAcctId(), castOther.getAcctId())
	            .append(this.getSoNbr(), castOther.getSoNbr())
	            .isEquals();
	    }

		@Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getAcctId())
	            .append(getSoNbr())
	            .toHashCode();
	    }

	}
}