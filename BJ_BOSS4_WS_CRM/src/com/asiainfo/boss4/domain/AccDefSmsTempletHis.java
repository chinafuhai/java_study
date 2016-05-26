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

import com.asiainfo.boss4.domain.base.BaseEntity;

@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "ACC_DEF_SMS_TEMPLET_HIS", schema = "ZG")
@IdClass(AccDefSmsTempletHis.AccDefSmsTempletHisId.class)
public class AccDefSmsTempletHis  extends BaseEntity implements java.io.Serializable {
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

	private String optId;
	private Date optDate;
	
	public AccDefSmsTempletHis() {

	}

	public AccDefSmsTempletHis(Short sts, Integer busiTypeCode,
		Integer regionCode, Integer smsType, Integer smsSort,
		Integer smsClass, Integer smsTempletIdSeq, Long smsTempletId,
		String smsName, String smsTemplet, String remarks,
		Date validDate, Date expireDate, String optId, Date optDate) {
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
		this.optId = optId;
		this.optDate = optDate;
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
	
	@Column(name = "OPT_ID",  length = 20)
	public String getOptId() {
		return optId;
	}

	public void setOptId(String optId) {
		this.optId = optId;
	}

	@Id
	public Date getOptDate() {
		return optDate;
	}

	public void setOptDate(Date optDate) {
		this.optDate = optDate;
	}

	public static class AccDefSmsTempletHisId implements java.io.Serializable {

		// Fields

		private Integer smsTempletIdSeq;
		private Long smsTempletId;
		private Date optDate;

		// Constructors

		/** default constructor */
		public AccDefSmsTempletHisId() {
		}

		/** full constructor */
		public AccDefSmsTempletHisId(Long smsTempletId, Integer smsTempletIdSeq, Date optDate) {
			this.smsTempletId = smsTempletId;
			this.smsTempletIdSeq = smsTempletIdSeq;
			this.optDate = optDate;
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

		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "OPT_DATE", length = 7)
		public Date getOptDate() {
			return optDate;
		}

		public void setOptDate(Date optDate) {
			this.optDate = optDate;
		}
		
		@Override
		public boolean equals(Object other) {
	        if ( !(other instanceof AccDefSmsTempletHisId) ) return false;
	        AccDefSmsTempletHisId castOther = (AccDefSmsTempletHisId) other;
	        return new EqualsBuilder()
	            .append(this.getSmsTempletId(), castOther.getSmsTempletId())
	            .append(this.getSmsTempletIdSeq(), castOther.getSmsTempletIdSeq())
	            .append(this.getOptDate(), castOther.getOptDate())
	            .isEquals();
	    }

		@Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getSmsTempletId())
	            .append(getSmsTempletIdSeq())
	            .append(getOptDate())
	            .toHashCode();
	    }

	}

}
