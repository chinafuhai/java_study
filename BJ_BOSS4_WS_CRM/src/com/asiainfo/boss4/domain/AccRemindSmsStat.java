package com.asiainfo.boss4.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;

@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "ACC_REMIND_SMS_STAT", schema = "INTER")
@CommonDao(fieldOfSelectConditions = { "sendDay"},fieldOfDBSelectConditions={"send_Day"}, dataStoreMode = DataStoreMode.DIRECT_UPDATE)
public class AccRemindSmsStat extends BaseEntity implements java.io.Serializable {

	// Fields
	private String sendDay;
	private Long smsCount;
	private String remark;

	// Constructors
	/** default constructor */
	public AccRemindSmsStat() {
	}

	public AccRemindSmsStat(String sendDay, Long smsCount, String remark) {
		this.sendDay = sendDay;
		this.smsCount = smsCount;
		this.remark = remark;
	}
	
	// Property accessors
	@Id
	@Column(name = "SEND_DAY")
	public String getSendDay() {
		return sendDay;
	}

	public void setSendDay(String sendDay) {
		this.sendDay = sendDay;
	}
	
	@Column(name = "SMS_COUNT", nullable = false)
	public Long getSmsCount() {
		return smsCount;
	}

	public void setSmsCount(Long smsCount) {
		this.smsCount = smsCount;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Override
	public boolean equals(Object other) {
		if ( !(other instanceof AccRemindSmsStat) ) return false;
		AccRemindSmsStat smsStat = (AccRemindSmsStat) other;
        return new EqualsBuilder()
            .append(this.getSendDay(), smsStat.getSendDay())
            .isEquals();
	}

	@Override
	public int hashCode() {
		 return new HashCodeBuilder()
	         .append(getSendDay())
	         .toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("sendDay",getSendDay())
			.append("smsCount",getSmsCount())
			.append("remark",getRemark())
			.toString();
	}
}