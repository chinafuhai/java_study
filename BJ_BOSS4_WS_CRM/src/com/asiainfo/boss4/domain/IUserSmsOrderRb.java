package com.asiainfo.boss4.domain;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * IUserSmsOrder entity. @author MyEclipse Persistence Tools
 */

public class IUserSmsOrderRb implements java.io.Serializable {
	
	private static final long serialVersionUID = -3626418677836697328L;

	// Fields

	private Long servId;
	private Byte smsOrderType;
	private String operType;
	private String phoneId;
	private Date soDate;
	private Date validDate;
	private Date expireDate;
	private Date sendDate;
	private Byte sendCount;
	private String remark;
	private Long rollbackSoNbr;

	// Constructors

	/** default constructor */
	public IUserSmsOrderRb() {
	}

	/** minimal constructor */
	public IUserSmsOrderRb(Long servId, Byte smsOrderType, String operType, String phoneId,
			Date validDate, Date expireDate) {
		this.servId = servId;
		this.smsOrderType = smsOrderType;
		this.operType = operType;
		this.phoneId = phoneId;
		this.validDate = validDate;
		this.expireDate = expireDate;
	}

	/** full constructor */
	public IUserSmsOrderRb(Long servId, Byte smsOrderType, String operType, String phoneId,
			Date soDate, Date validDate, Date expireDate, Date sendDate,
			Byte sendCount, String remark) {
		this.servId = servId;
		this.smsOrderType = smsOrderType;
		this.operType = operType;
		this.phoneId = phoneId;
		this.soDate = soDate;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.sendDate = sendDate;
		this.sendCount = sendCount;
		this.remark = remark;
	}

	// Property accessors
	
	public Long getServId() {
		return servId;
	}

	public void setServId(Long servId) {
		this.servId = servId;
	}

	public Byte getSmsOrderType() {
		return smsOrderType;
	}

	public void setSmsOrderType(Byte smsOrderType) {
		this.smsOrderType = smsOrderType;
	}

	public String getOperType() {
		return this.operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}

	public String getPhoneId() {
		return this.phoneId;
	}

	public void setPhoneId(String phoneId) {
		this.phoneId = phoneId;
	}

	public Date getSoDate() {
		return this.soDate;
	}

	public void setSoDate(Date soDate) {
		this.soDate = soDate;
	}

	public Date getValidDate() {
		return this.validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	public Date getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public Date getSendDate() {
		return this.sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public Byte getSendCount() {
		return this.sendCount;
	}

	public void setSendCount(Byte sendCount) {
		this.sendCount = sendCount;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public boolean equals(Object other) {
		if ( !(other instanceof IUserSmsOrderRb) ) return false;
		IUserSmsOrderRb castOther = (IUserSmsOrderRb) other;
        return new EqualsBuilder()
            .append(this.getServId(), castOther.getServId())
            .append(this.getSmsOrderType(), castOther.getSmsOrderType())
            .isEquals();
	}

	@Override
	public int hashCode() {
		 return new HashCodeBuilder()
	         .append(getServId())
	         .append(getSmsOrderType())
	         .toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("validDate",getValidDate())
			.append("servId",getServId())
			.append("operType",getOperType())
			.append("smsOrderType",getSmsOrderType())
			.append("sendCount",getSendCount())
			.append("expireDate",getExpireDate())
			.append("remark",getRemark())
			.append("sendDate",getSendDate())
			.append("soDate",getSoDate())
			.append("phoneId",getPhoneId())
			.toString();
	}

	public Long getRollbackSoNbr() {
		return rollbackSoNbr;
	}

	public void setRollbackSoNbr(Long rollbackSoNbr) {
		this.rollbackSoNbr = rollbackSoNbr;
	}
	
}