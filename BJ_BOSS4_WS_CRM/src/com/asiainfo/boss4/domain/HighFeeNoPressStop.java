package com.asiainfo.boss4.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;

@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "HIGH_FEE_NO_PRESS_STOP", schema = "INTER")
@Backup.CopyToSuffix(suffixes = {Backup.CopyToSuffix.HIS})
@CommonDao(fieldOfSelectConditions = { "phoneId", "expireDate" }, isOverwriteWhenAdd = true, dataStoreMode = DataStoreMode.DIRECT_UPDATE)
@SequenceGenerator(name="generator",sequenceName="inter.high_fee_seq",allocationSize=1)  
public class HighFeeNoPressStop extends BaseEntity implements java.io.Serializable{
	private String phoneId;
	private Date validDate;
	private Long recId;
	private String operId;
	private String hallId;
	private Date operDate;
	private Date expireDate;
	
	private Byte operType;
	
	public HighFeeNoPressStop() {
		
	}
	
	public HighFeeNoPressStop(String phoneId, Date validDate, Long recId,
			String operId, String hallId, Date operDate, Date expireDate) {
		this.phoneId = phoneId;
		this.validDate = validDate;
		this.recId = recId;
		this.operId = operId;
		this.hallId = hallId;
		this.operDate = operDate;
		this.expireDate = expireDate;
	}
	@Column(name = "PHONE_ID", nullable = false, length = 15)
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
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="generator")   
	@Column(name = "REC_ID", nullable = false, precision = 15, scale = 0)
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
	
	@Transient
	public Byte getOperType() {
		return this.operType;
	}

	public void setOperType(Byte operType) {
		this.operType = operType;
	}
	
	public static class HighFeeNoPressStopId implements java.io.Serializable {

		// Fields

		private String phoneId;
		private Date validDate;

		// Constructors

		/** default constructor */
		public HighFeeNoPressStopId() {
		}

		/** full constructor */
		public HighFeeNoPressStopId(String phoneId, Date validDate) {
			this.phoneId = phoneId;
			this.validDate = validDate;
		}

		// Property accessors

		@Column(name = "PHONE_ID", nullable = false, length = 15)
		public String getPhoneId() {
			return this.phoneId;
		}

		public void setPhoneId(String phoneId) {
			this.phoneId = phoneId;
		}

		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "VALID_DATE", nullable = false, length = 7)
		public Date getValidDate() {
			return this.validDate;
		}

		public void setValidDate(Date validDate) {
			this.validDate = validDate;
		}

		@Override
		public boolean equals(Object other) {
			if (!(other instanceof HighFeeNoPressStopId))
				return false;
			HighFeeNoPressStopId castOther = (HighFeeNoPressStopId) other;
			return new EqualsBuilder().append(this.getPhoneId(),
					castOther.getPhoneId()).append(this.getValidDate(),
					castOther.getValidDate()).isEquals();
		}

		@Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getPhoneId())
	            .append(getValidDate())
	            .toHashCode();
	    }

	}
	
	@Override
	public BaseEntity modify(ServiceContext context) {
		//如果修改了生效时间，则需要将修改操作调整为先删后增
		HighFeeNoPressStop highFee = new HighFeeNoPressStop();
		BeanCopyHelper.copyBeanNotNullProperty(highFee, this);
		highFee = (HighFeeNoPressStop)context.getBusinessDao().getEntity(highFee, new String[]{"phoneId","validDate"});
		
		if (highFee != null)
		{
			this.setRecId(highFee.getRecId());
			return super.modify(context);
		}
		/*highFee = new HighFeeNoPressStop();
		BeanCopyHelper.copyBeanNotNullProperty(highFee, this);
		highFee = (HighFeeNoPressStop)context.getBusinessDao().getEntity(highFee, new String[]{"phoneId","expireDate"});
		
		if (highFee != null)
		{
			highFee.setOperDate(context.getSoDate());
			context.getBusinessDao().backup(highFee, new String[]{"phoneId","expireDate"}, "HIS");
			context.getBusinessDao().remove(highFee, new String[]{"phoneId","expireDate"});
			return super.add(context);
		}*/
		else
			throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR, "servId="+this.getPhoneId()+",validDate="+DateHelper.Date2String(this.getValidDate())+" don't exist in HIGH_FEE_NO_PRESS_STOP");
	}
}
