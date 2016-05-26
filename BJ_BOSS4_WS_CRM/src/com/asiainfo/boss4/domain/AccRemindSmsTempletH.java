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
import org.apache.commons.lang.builder.ToStringBuilder;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;

@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate = true)
@Table(name = "ACC_REMIND_SMS_TEMPLET_H", schema = "INTER")
@IdClass(AccRemindSmsTempletH.AccRemindSmsTempletHId.class)
public class AccRemindSmsTempletH extends BaseEntity implements java.io.Serializable {

	// Fields
	private Long templetId;
	private Long segmentSeq;
	private String expression;
	private String smsContent;
	private String remark;
	private String allowModify;
	private String modifyDesc;
	private Integer priority;
	private Date validDate;
	private Date expireDate;
	private Long opId;
	private Date opTime;
	
	// Constructors
	/** default constructor */
	public AccRemindSmsTempletH() {
	}

	public AccRemindSmsTempletH(Long templetId, Long segmentSeq,
			String expression, String smsContent, String remark,
			String allowModify, String modifyDesc, Integer priority,
			Date validDate, Date expireDate, Long opId, Date opTime) {
		this.templetId = templetId;
		this.segmentSeq = segmentSeq;
		this.expression = expression;
		this.smsContent = smsContent;
		this.remark = remark;
		this.allowModify = allowModify;
		this.modifyDesc = modifyDesc;
		this.priority = priority;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.opId = opId;
		this.opTime = opTime;
	}

	// Property accessors
	@Id
	public Long getTempletId() {
		return templetId;
	}

	public void setTempletId(Long templetId) {
		this.templetId = templetId;
	}

	@Id
	public Long getSegmentSeq() {
		return segmentSeq;
	}

	public void setSegmentSeq(Long segmentSeq) {
		this.segmentSeq = segmentSeq;
	}

	@Column(name = "EXPRESSION", length = 512)
	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	@Column(name = "SMS_CONTENT")
	public String getSmsContent() {
		return smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "ALLOW_MODIFY")
	public String getAllowModify() {
		return allowModify;
	}

	public void setAllowModify(String allowModify) {
		this.allowModify = allowModify;
	}

	@Column(name = "MODIFY_DESC")
	public String getModifyDesc() {
		return modifyDesc;
	}

	public void setModifyDesc(String modifyDesc) {
		this.modifyDesc = modifyDesc;
	}

	@Id
	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@Id
	public Date getValidDate() {
		return validDate;
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

	@Column(name = "OP_ID")
	public Long getOpId() {
		return opId;
	}

	public void setOpId(Long opId) {
		this.opId = opId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "OP_TIME", nullable = false, length = 7)
	public Date getOpTime() {
		return this.opTime;
	}

	public void setOpTime(Date opTime) {
		this.opTime = opTime;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("templetId", getTempletId())
				.append("segmentSeq", getSegmentSeq())
				.append("expression",getExpression())
				.append("smsContent", getSmsContent())
				.append("remark", getRemark())
				.append("allowModify",getAllowModify())
				.append("modifyDesc", getModifyDesc())
				.append("priority", getPriority())
				.append("validDate",getValidDate())
				.append("expireDate", getExpireDate())
				.append("opId", getOpId())
				.append("opTime", getOpTime())
				.toString();
	}

	public static class AccRemindSmsTempletHId implements java.io.Serializable {

		private Long templetId;
		private Long segmentSeq;
		private Integer priority;
		private Date validDate;

		// Constructors

		/** default constructor */
		public AccRemindSmsTempletHId() {
		}

		/** full constructor */
		public AccRemindSmsTempletHId(Long templetId, Long segmentSeq,Integer priority, Date validDate) {
			this.templetId = templetId;
			this.segmentSeq = segmentSeq;
			this.priority = priority;
			this.validDate = validDate;
		}

		@Column(name = "TEMPLET_ID", nullable = false, precision = 8, scale = 0)
		public Long getTempletId() {
			return templetId;
		}

		public void setTempletId(Long templetId) {
			this.templetId = templetId;
		}

		@Column(name = "SEGMENT_SEQ", nullable = false, precision = 8, scale = 0)
		public Long getSegmentSeq() {
			return segmentSeq;
		}

		public void setSegmentSeq(Long segmentSeq) {
			this.segmentSeq = segmentSeq;
		}
		
		@Column(name = "PRIORITY", nullable = false, precision = 4, scale = 0)
		public Integer getPriority() {
			return priority;
		}

		public void setPriority(Integer priority) {
			this.priority = priority;
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
			if (!(other instanceof AccRemindSmsTempletHId))
				return false;
			AccRemindSmsTempletHId castOther = (AccRemindSmsTempletHId) other;
			return new EqualsBuilder().append(this.getTempletId(),
					castOther.getTempletId())
					.append(this.getSegmentSeq(), castOther.getSegmentSeq())
					.append(this.getPriority(), castOther.getPriority())
					.append(this.getValidDate(), castOther.getValidDate())
					.isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder().append(getTempletId())
			        .append(getSegmentSeq()).append(getPriority()).append(getValidDate()).toHashCode();
		}
	}
}