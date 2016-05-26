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

/**
 * AccBusiSms entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "ACC_BUSI_SMS", schema = "ZG")
@IdClass(AccBusiSms.AccBusiSmsId.class)
@Backup.CopyToSuffix(isIgnore = true)
public class AccBusiSms implements java.io.Serializable {

	// Fields

	private Long soNbr;
	private Byte smsType;
	private String phoneId;
	private Long servId;
	private Integer busiType;
	private String smsContent;
	private Date createDate;
	private Date sendDate;
	private Byte sts;
	private Date stsDate;
	private String rsltDesc;
	private String notes;
	private Integer smsClass = 0;
	private Integer promSmsClass;

	// Constructors

	/** default constructor */
	public AccBusiSms() {
	}

	/** minimal constructor */
	public AccBusiSms(Long soNbr, Byte smsType, String phoneId, Long servId, Integer busiType,
			String smsContent, Date createDate, Date sendDate, Byte sts,
			Date stsDate, Integer smsClass) {
		this.soNbr = soNbr;
		this.smsType = smsType;
		this.phoneId = phoneId;
		this.servId = servId;
		this.busiType = busiType;
		this.smsContent = smsContent;
		this.createDate = createDate;
		this.sendDate = sendDate;
		this.sts = sts;
		this.stsDate = stsDate;
		this.smsClass = smsClass;
	}

	/** full constructor */
	public AccBusiSms(Long soNbr, Byte smsType, String phoneId, Long servId, Integer busiType,
			String smsContent, Date createDate, Date sendDate, Byte sts,
			Date stsDate, String rsltDesc, String notes, Integer smsClass,
			Integer promSmsClass) {
		this.soNbr = soNbr;
		this.smsType = smsType;
		this.phoneId = phoneId;
		this.servId = servId;
		this.busiType = busiType;
		this.smsContent = smsContent;
		this.createDate = createDate;
		this.sendDate = sendDate;
		this.sts = sts;
		this.stsDate = stsDate;
		this.rsltDesc = rsltDesc;
		this.notes = notes;
		this.smsClass = smsClass;
		this.promSmsClass = promSmsClass;
	}

	// Property accessors
	
	@Id
	public Long getSoNbr() {
		return this.soNbr;
	}

	public void setSoNbr(Long soNbr) {
		this.soNbr = soNbr;
	}

	@Id
	public Byte getSmsType() {
		return this.smsType;
	}

	public void setSmsType(Byte smsType) {
		this.smsType = smsType;
	}

	@Id
	public String getPhoneId() {
		return this.phoneId;
	}

	public void setPhoneId(String phoneId) {
		this.phoneId = phoneId;
	}

	@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
	public Long getServId() {
		return this.servId;
	}

	public void setServId(Long servId) {
		this.servId = servId;
	}

	@Column(name = "BUSI_TYPE", nullable = false, precision = 8, scale = 0)
	public Integer getBusiType() {
		return this.busiType;
	}

	public void setBusiType(Integer busiType) {
		this.busiType = busiType;
	}

	@Column(name = "SMS_CONTENT", nullable = false, length = 500)
	public String getSmsContent() {
		return this.smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", nullable = false, length = 7)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SEND_DATE", nullable = false, length = 7)
	public Date getSendDate() {
		return this.sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	@Column(name = "STS", nullable = false, precision = 2, scale = 0)
	public Byte getSts() {
		return this.sts;
	}

	public void setSts(Byte sts) {
		this.sts = sts;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STS_DATE", nullable = false, length = 7)
	public Date getStsDate() {
		return this.stsDate;
	}

	public void setStsDate(Date stsDate) {
		this.stsDate = stsDate;
	}

	@Column(name = "RSLT_DESC")
	public String getRsltDesc() {
		return this.rsltDesc;
	}

	public void setRsltDesc(String rsltDesc) {
		this.rsltDesc = rsltDesc;
	}

	@Column(name = "NOTES", length = 500)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Column(name = "SMS_CLASS", nullable = true, precision = 8, scale = 0)
	public Integer getSmsClass() {
		return this.smsClass;
	}

	public void setSmsClass(Integer smsClass) {
		this.smsClass = smsClass;
	}

	@Column(name = "PROM_SMS_CLASS", precision = 8, scale = 0)
	public Integer getPromSmsClass() {
		return this.promSmsClass;
	}

	public void setPromSmsClass(Integer promSmsClass) {
		this.promSmsClass = promSmsClass;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("servId",getServId())
			.append("notes",getNotes())
			.append("soNbr",getSoNbr())
			.append("smsClass",getSmsClass())
			.append("rsltDesc",getRsltDesc())
			.append("phoneId",getPhoneId())
			.append("promSmsClass",getPromSmsClass())
			.append("sts",getSts())
			.append("smsType",getSmsType())
			.append("stsDate",getStsDate())
			.append("createDate",getCreateDate())
			.append("busiType",getBusiType())
			.append("sendDate",getSendDate())
			.append("smsContent",getSmsContent())
			.toString();

	}

	public static class AccBusiSmsId implements java.io.Serializable {

		// Fields

		private Long soNbr;
		private Byte smsType;
		private String phoneId;

		// Constructors

		/** default constructor */
		public AccBusiSmsId() {
		}

		/** full constructor */
		public AccBusiSmsId(Long soNbr, Byte smsType, String phoneId) {
			this.soNbr = soNbr;
			this.smsType = smsType;
			this.phoneId = phoneId;
		}

		// Property accessors

		@Column(name = "SO_NBR", nullable = false, precision = 15, scale = 0)
		public Long getSoNbr() {
			return this.soNbr;
		}

		public void setSoNbr(Long soNbr) {
			this.soNbr = soNbr;
		}

		@Column(name = "SMS_TYPE", nullable = false, precision = 2, scale = 0)
		public Byte getSmsType() {
			return this.smsType;
		}

		public void setSmsType(Byte smsType) {
			this.smsType = smsType;
		}

		@Column(name = "PHONE_ID", nullable = false, length = 15)
		public String getPhoneId() {
			return this.phoneId;
		}

		public void setPhoneId(String phoneId) {
			this.phoneId = phoneId;
		}

		@Override
		public boolean equals(Object other) {
			if ( !(other instanceof AccBusiSmsId) ) return false;
			AccBusiSmsId castOther = (AccBusiSmsId) other;
			return new EqualsBuilder()
				.append(this.getSmsType(), castOther.getSmsType())
				.append(this.getSoNbr(), castOther.getSoNbr())
				.append(this.getPhoneId(), castOther.getPhoneId())
				.isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder()
				.append(getSmsType())
				.append(getSoNbr())
				.append(getPhoneId())
				.toHashCode();
		}
	}
}