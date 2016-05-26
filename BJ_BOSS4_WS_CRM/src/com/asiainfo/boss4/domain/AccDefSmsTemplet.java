package com.asiainfo.boss4.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.OperateType;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;

@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "ACC_DEF_SMS_TEMPLET", schema = "ZG")
@IdClass(AccDefSmsTemplet.AccDefSmsTempletId.class)
@CommonDao(fieldOfSelectConditions = { "smsTempletId", "smsTempletIdSeq", "expireDate"},fieldOfDBSelectConditions={"sms_Templet_Id", "sms_Templet_Id_Seq", "expire_date"}, dataStoreMode = DataStoreMode.DIRECT_UPDATE)
public class AccDefSmsTemplet  extends BaseEntity implements java.io.Serializable {
	private Short sts;
	private Integer busiTypeCode;
	private Integer regionCode;
	private Integer smsType;
	private Integer smsSort;
	private Integer smsClass;
	private Integer smsTempletIdSeq;
	private Long smsTempletId;
	private String smsName;
	private String smsTemplet;
	private String remarks;
	private Date validDate;
	private Date expireDate;
	private Byte operType = Byte.valueOf(OperateType.MODIFY.getTypeCode());

	private String optId;
	public AccDefSmsTemplet() {

	}

	public AccDefSmsTemplet(Short sts, Integer busiTypeCode,
		Integer regionCode, Integer smsType, Integer smsSort,
		Integer smsClass, Integer smsTempletIdSeq, Long smsTempletId,
		String smsName, String smsTemplet, String remarks,
		Date validDate, Date expireDate) {
		this.sts = sts;
		this.busiTypeCode = busiTypeCode;
		this.regionCode = regionCode;
		this.smsType = smsType;
		this.smsSort = smsSort;
		this.smsClass = smsClass;
		this.smsTempletIdSeq = smsTempletIdSeq;
		this.smsTempletId = smsTempletId;
		this.smsName = smsName;
		this.smsTemplet = smsTemplet;
		this.remarks = remarks;
		this.validDate = validDate;
		this.expireDate = expireDate;
	}

	@Column(name = "STS", nullable = false, precision = 2, scale = 0)
	public Short getSts() {
		return sts;
	}

	public void setSts(Short sts) {
		this.sts = sts;
	}

	@Column(name = "BUSI_TYPE_CODE", nullable = false, precision = 4, scale = 0)
	public Integer getBusiTypeCode() {
		return busiTypeCode;
	}

	public void setBusiTypeCode(Integer busiTypeCode) {
		this.busiTypeCode = busiTypeCode;
	}

	@Column(name = "REGION_CODE", nullable = false, precision = 4, scale = 0)
	public Integer getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(Integer regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "SMS_TYPE", nullable = false, precision = 4, scale = 0)
	public Integer getSmsType() {
		return smsType;
	}

	public void setSmsType(Integer smsType) {
		this.smsType = smsType;
	}

	@Column(name = "SMS_SORT", nullable = false, precision = 4, scale = 0)
	public Integer getSmsSort() {
		return smsSort;
	}

	public void setSmsSort(Integer smsSort) {
		this.smsSort = smsSort;
	}

	@Column(name = "SMS_CLASS", nullable = false, precision = 8, scale = 0)
	public Integer getSmsClass() {
		return smsClass;
	}

	public void setSmsClass(Integer smsClass) {
		this.smsClass = smsClass;
	}

	@Id
	public Integer getSmsTempletIdSeq() {
		return smsTempletIdSeq;
	}

	public void setSmsTempletIdSeq(Integer smsTempletIdSeq) {
		this.smsTempletIdSeq = smsTempletIdSeq;
	}

	@Id
	public Long getSmsTempletId() {
		return smsTempletId;
	}

	public void setSmsTempletId(Long smsTempletId) {
		this.smsTempletId = smsTempletId;
	}

	@Column(name = "SMS_NAME", nullable = false, length = 64)
	public String getSmsName() {
		return smsName;
	}

	public void setSmsName(String smsName) {
		this.smsName = smsName;
	}

	@Column(name = "SMS_TEMPLET", nullable = false, length = 2048)
	public String getSmsTemplet() {
		return smsTemplet;
	}

	public void setSmsTemplet(String smsTemplet) {
		this.smsTemplet = smsTemplet;
	}

	@Column(name = "REMARKS",  length = 128)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VALID_DATE", length = 7)
	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
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
	public OperateType getTheOperateType() {
		return OperateType.MODIFY;
	}

	@Transient
	public Byte getOperType() {
		return operType;
	}
	
	@Transient
	public String getOptId() {
		return optId;
	}

	public void setOptId(String optId) {
		this.optId = optId;
	}

	public static class AccDefSmsTempletId implements java.io.Serializable {

		// Fields

		private Integer smsTempletIdSeq;
		private Long smsTempletId;

		// Constructors

		/** default constructor */
		public AccDefSmsTempletId() {
		}

		/** full constructor */
		public AccDefSmsTempletId(Long smsTempletId, Integer smsTempletIdSeq) {
			this.smsTempletId = smsTempletId;
			this.smsTempletIdSeq = smsTempletIdSeq;
		}

		// Property accessors

		@Column(name = "SMS_TEMPLET_ID_SEQ", nullable = false, precision = 4, scale = 0)
		public Integer getSmsTempletIdSeq() {
			return smsTempletIdSeq;
		}

		public void setSmsTempletIdSeq(Integer smsTempletIdSeq) {
			this.smsTempletIdSeq = smsTempletIdSeq;
		}

		@Column(name = "SMS_TEMPLET_ID", nullable = false, precision = 9, scale = 0)
		public Long getSmsTempletId() {
			return smsTempletId;
		}

		public void setSmsTempletId(Long smsTempletId) {
			this.smsTempletId = smsTempletId;
		}

		@Override
		public boolean equals(Object other) {
	        if ( !(other instanceof AccDefSmsTempletId) ) return false;
	        AccDefSmsTempletId castOther = (AccDefSmsTempletId) other;
	        return new EqualsBuilder()
	            .append(this.getSmsTempletId(), castOther.getSmsTempletId())
	            .append(this.getSmsTempletIdSeq(), castOther.getSmsTempletIdSeq())
	            .isEquals();
	    }

		@Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getSmsTempletId())
	            .append(getSmsTempletIdSeq())
	            .toHashCode();
	    }

	}

	@Override
	public BaseEntity add(ServiceContext context) {
		throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
	}
	
	@Override
	public BaseEntity cancel(ServiceContext context) {
		throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
	}
	
	@Override
	public BaseEntity modify(ServiceContext context) {
		BusinessDao dao = (BusinessDao)context.getBeanFactory().getBean("businessDao");
		AccDefSmsTemplet accSms = (AccDefSmsTemplet)dao.getEntity(this, this.getFieldOfSelectConditionsOnCommonDaoAnnotation());
		if (accSms != null)
		{
			AccDefSmsTempletHis smsTempletHis = new AccDefSmsTempletHis();
			BeanCopyHelper.copyBeanNotNullProperty(smsTempletHis, accSms);
			smsTempletHis.setOptId(this.getOptId());
			smsTempletHis.setOptDate(context.getSoDate());
			dao.add(smsTempletHis);
			
			BeanCopyHelper.copyBeanNotNullPropertyCrm(accSms, this);
			dao.update(accSms);
		}
		else
			throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
		return this;
	}
}
