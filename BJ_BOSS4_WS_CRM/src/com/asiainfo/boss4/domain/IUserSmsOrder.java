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

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;

/**
 * IUserSmsOrder entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=false)
@Table(name = "I_USER_SMS_ORDER", schema = "ZG")
@IdClass(IUserSmsOrder.IUserSmsOrderId.class)
@Backup.CopyToSuffix(suffixes = {Backup.CopyToSuffix.HIS})
@CommonDao(fieldOfSelectConditions = { "servId","smsOrderType","expireDate" },fieldOfDBSelectConditions={"serv_id","sms_order_type","expire_date"}, isOverwriteWhenAdd = true, dataStoreMode = DataStoreMode.DIRECT_UPDATE)
public class IUserSmsOrder extends BaseEntity implements java.io.Serializable {	
	// Fields

	private Long servId;
	private Long smsOrderType;
	private String operType;
	private String phoneId;
	private Date soDate;
	private Date validDate;
	private Date expireDate;
	private Date sendDate;
	private Long sendCount;
	private String remark;

	// Constructors

	/** default constructor */
	public IUserSmsOrder() {
	}

	/** minimal constructor */
	public IUserSmsOrder(Long servId, Long smsOrderType, String operType, String phoneId,
			Date validDate, Date expireDate) {
		this.servId = servId;
		this.smsOrderType = smsOrderType;
		this.operType = operType;
		this.phoneId = phoneId;
		this.validDate = validDate;
		this.expireDate = expireDate;
	}

	/** full constructor */
	public IUserSmsOrder(Long servId, Long smsOrderType, String operType, String phoneId,
			Date soDate, Date validDate, Date expireDate, Date sendDate,
			Long sendCount, String remark) {
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
	@Id
	public Long getServId() {
		return servId;
	}

	public void setServId(Long servId) {
		this.servId = servId;
	}

	@Id
	public Long getSmsOrderType() {
		return smsOrderType;
	}

	public void setSmsOrderType(Long smsOrderType) {
		this.smsOrderType = smsOrderType;
	}
	@Column(name = "OPER_TYPE", nullable = false, precision=1,scale=0)
	public String getOperType() {
		return this.operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
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
	@Id
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
	@Column(name = "SEND_COUNT", precision=1)
	public Long getSendCount() {
		return this.sendCount;
	}

	public void setSendCount(Long sendCount) {
		this.sendCount = sendCount;
	}
	@Column(name = "REMARK", precision=512)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public boolean equals(Object other) {
		if ( !(other instanceof IUserSmsOrder) ) return false;
		IUserSmsOrder castOther = (IUserSmsOrder) other;
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
	
	@Override
	public BaseEntity cancel(ServiceContext context) {
		BusinessDao  businessDao = context.getBusinessDao();
		businessDao.backup(this,new String[]{ "servId","smsOrderType" }  , "his");
		businessDao.remove(this,new String[]{ "servId","smsOrderType" });
		return this;
	}
	
	public static class IUserSmsOrderId implements java.io.Serializable {

		// Fields

		private Long servId;
		private Long smsOrderType;
		private Date validDate;
		
		// Constructors

		/** default constructor */
		public IUserSmsOrderId() {
		}

		/** full constructor */
		public IUserSmsOrderId(Long servId, Long smsOrderType, Date validDate) {
			this.servId = servId;
			this.smsOrderType = smsOrderType;
			this.validDate = validDate;
		}

		// Property accessors

		@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
		public Long getServId() {
			return this.servId;
		}

		public void setServId(Long servId) {
			this.servId = servId;
		}

		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "VALID_DATE", nullable = false, length = 7)
		public Date getValidDate() {
			return this.validDate;
		}

		public void setValidDate(Date validDate) {
			this.validDate = validDate;
		}

		@Column(name = "SMS_ORDER_TYPE", precision=2)
		public Long getSmsOrderType() {
			return smsOrderType;
		}

		public void setSmsOrderType(Long smsOrderType) {
			this.smsOrderType = smsOrderType;
		}

		@Override
		public boolean equals(Object other) {
	        if ( !(other instanceof IUserSmsOrderId) ) return false;
	        IUserSmsOrderId castOther = (IUserSmsOrderId) other;
	        return new EqualsBuilder()
	            .append(this.getServId(), castOther.getServId())
	            .append(this.getSmsOrderType(), castOther.getSmsOrderType())
	            .append(this.getValidDate(), castOther.getValidDate())
	            .isEquals();
	    }
		
		@Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getServId())
	            .append(getSmsOrderType())
	            .append(getValidDate())
	            .toHashCode();
	    }

	}
}