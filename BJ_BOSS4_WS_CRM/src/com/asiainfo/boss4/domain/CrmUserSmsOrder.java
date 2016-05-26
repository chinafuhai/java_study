package com.asiainfo.boss4.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;

/**
 * CrmUserSmsOrder entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "CRM_USER_SMS_ORDER", schema = "ZG")
@Backup.CopyToSuffix(isIgnore = true)
@CommonDao(fieldOfSelectConditions = { "servId", "smsOrderType" },fieldOfDBSelectConditions={"serv_id","sms_order_type"}, isOverwriteWhenAdd = true,dataStoreMode = DataStoreMode.DIRECT_UPDATE)
public class CrmUserSmsOrder extends BaseEntity implements java.io.Serializable {	
	// Fields
	private Long servId;
	private Long smsOrderType;
	private String phoneId;
	private Date soDate;
	private Date validDate;
	private Date expireDate;
	private Date sendDate;

	// Constructors

	/** default constructor */
	public CrmUserSmsOrder() {
	}

	/** minimal constructor */
	public CrmUserSmsOrder(Long servId, Long smsOrderType, String phoneId,
			Date validDate, Date expireDate) {
		this.servId = servId;
		this.smsOrderType = smsOrderType;
		this.phoneId = phoneId;
		this.validDate = validDate;
		this.expireDate = expireDate;
	}

	/** full constructor */
	public CrmUserSmsOrder(Long servId, Long smsOrderType, String phoneId,
			Date soDate, Date validDate, Date expireDate, Date sendDate) {
		this.servId = servId;
		this.smsOrderType = smsOrderType;
		this.phoneId = phoneId;
		this.soDate = soDate;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.sendDate = sendDate;
	}

	// Property accessors
	@Id
	@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
	public Long getServId() {
		return servId;
	}

	public void setServId(Long servId) {
		this.servId = servId;
	}

	@Column(name = "SMS_ORDER_TYPE", precision=2)
	public Long getSmsOrderType() {
		return smsOrderType;
	}

	public void setSmsOrderType(Long smsOrderType) {
		this.smsOrderType = smsOrderType;
	}
	
	@Column(name = "PHONE_ID", nullable = false, precision=15,scale=0)
	public String getPhoneId() {
		return this.phoneId;
	}

	public void setPhoneId(String phoneId) {
		this.phoneId = phoneId;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SO_DATE", precision=7)
	public Date getSoDate() {
		return this.soDate;
	}

	public void setSoDate(Date soDate) {
		this.soDate = soDate;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VALID_DATE", precision=7)
	public Date getValidDate() {
		return this.validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRE_DATE", precision=7)
	public Date getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SEND_DATE", precision=7)
	public Date getSendDate() {
		return this.sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	
	@Override
	public boolean equals(Object other) {
        if ( !(other instanceof CrmUserSmsOrder) ) return false;
        CrmUserSmsOrder castOther = (CrmUserSmsOrder) other;
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
			.append("smsOrderType",getSmsOrderType())
			.append("expireDate",getExpireDate())
			.append("sendDate",getSendDate())
			.append("soDate",getSoDate())
			.append("phoneId",getPhoneId())
			.toString();
	}

}