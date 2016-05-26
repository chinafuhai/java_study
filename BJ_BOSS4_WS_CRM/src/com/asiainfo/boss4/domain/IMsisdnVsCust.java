package com.asiainfo.boss4.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.asiainfo.boss4.support.annotation.AllowUpdateZeroRow;
import com.asiainfo.boss4.support.annotation.Backup;

/**
 * IMsisdnVsCust entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_MSISDN_VS_CUST", schema = "ZG")
@AllowUpdateZeroRow
@Backup.CopyToSuffix
public class IMsisdnVsCust implements java.io.Serializable {

	// Fields

	private String msisdn;
	private Long custId;
	private String custCode;
	private Short regionCode;
	private Date validDate;
	private Date expireDate;
	private Long sid;
	private Long soNbr;
	private String remark;

	// Constructors

	/** default constructor */
	public IMsisdnVsCust() {
	}

	/** minimal constructor */
	public IMsisdnVsCust(String msisdn, String custCode, Date validDate,
			Date expireDate, Long sid, Long soNbr) {
		this.msisdn = msisdn;
		this.custCode = custCode;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
	}

	/** full constructor */
	public IMsisdnVsCust(String msisdn, Long custId, String custCode,
			Short regionCode, Date validDate, Date expireDate, Long sid,
			Long soNbr, String remark) {
		this.msisdn = msisdn;
		this.custId = custId;
		this.custCode = custCode;
		this.regionCode = regionCode;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@Column(name = "MSISDN", nullable = false, length = 50)
	public String getMsisdn() {
		return this.msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	@Column(name = "CUST_ID", precision = 14, scale = 0)
	public Long getCustId() {
		return this.custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	@Column(name = "CUST_CODE", nullable = false, length = 32)
	public String getCustCode() {
		return this.custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	@Column(name = "REGION_CODE", precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
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
			.append("validDate",getValidDate())
			.append("sid",getSid())
			.append("msisdn",getMsisdn())
			.append("custCode",getCustCode())
			.append("soNbr",getSoNbr())
			.append("custId",getCustId())
			.append("expireDate",getExpireDate())
			.append("remark",getRemark())
			.append("regionCode",getRegionCode())
			.toString();
	}
	
}