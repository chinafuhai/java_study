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


@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "HIGH_FEE_NO_PRESS_STOP_HIS", schema = "INTER")
@IdClass(HighFeeNoPressStopHis.HighFeeNoPressStopHisId.class)
public class HighFeeNoPressStopHis {
	private String phoneId;
	private Date validDate;
	private Long recId;
	private String operId;
	private String hallId;
	private Date operDate;
	private Date expireDate;
	
	public HighFeeNoPressStopHis() {
		
	}
	
	public HighFeeNoPressStopHis(String phoneId, Date validDate, Long recId,
			String operId, String hallId, Date operDate, Date expireDate) {
		this.phoneId = phoneId;
		this.validDate = validDate;
		this.recId = recId;
		this.operId = operId;
		this.hallId = hallId;
		this.operDate = operDate;
		this.expireDate = expireDate;
	}
	@Id
	public String getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(String phoneId) {
		this.phoneId = phoneId;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VALID_DATE", nullable = false, length = 7)
	public Date getValidDate() {
		return validDate;
	}
	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}
	
	@Id
	public Long getRecId() {
		return recId;
	}
	public void setRecId(Long recId) {
		this.recId = recId;
	}
	
	@Column(name = "OPER_ID", length = 32)
	public String getOperId() {
		return operId;
	}
	public void setOperId(String operId) {
		this.operId = operId;
	}
	
	@Column(name = "HALL_ID", length = 32)
	public String getHallId() {
		return hallId;
	}
	public void setHallId(String hallId) {
		this.hallId = hallId;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "OPER_DATE", length = 7)
	public Date getOperDate() {
		return operDate;
	}
	public void setOperDate(Date operDate) {
		this.operDate = operDate;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRE_DATE", length = 7)
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	
	public static class HighFeeNoPressStopHisId implements java.io.Serializable {

		// Fields

		private String phoneId;
		private Long recId;

		// Constructors

		/** default constructor */
		public HighFeeNoPressStopHisId() {
		}

		/** full constructor */
		public HighFeeNoPressStopHisId(String phoneId, Long recId) {
			this.phoneId = phoneId;
			this.recId = recId;
		}

		// Property accessors

		@Column(name = "PHONE_ID", nullable = false, length = 15)
		public String getPhoneId() {
			return this.phoneId;
		}

		public void setPhoneId(String phoneId) {
			this.phoneId = phoneId;
		}

		@Column(name = "REC_ID", nullable = false, precision = 15, scale = 0)
		public Long getRecId() {
			return recId;
		}
		public void setRecId(Long recId) {
			this.recId = recId;
		}

		public boolean equals(Object other) {
			if (!(other instanceof HighFeeNoPressStopHisId))
				return false;
			HighFeeNoPressStopHisId castOther = (HighFeeNoPressStopHisId) other;
			return new EqualsBuilder().append(this.getPhoneId(),
					castOther.getPhoneId()).append(this.getRecId(),
					castOther.getRecId()).isEquals();
		}

		@Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getPhoneId())
	            .append(getRecId())
	            .toHashCode();
	    }

	}
}
