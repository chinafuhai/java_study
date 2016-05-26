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

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.annotation.AddOnly;

/**
 * AccKtInfo entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "ACC_KT_INFO", schema = "ZG")
@IdClass(AccKtInfo.AccKtInfoId.class)
@AddOnly
public class AccKtInfo extends BaseEntity implements java.io.Serializable {

	// Fields

	private Long doneCode;
	private Long userId;
	private Long acctId;
	private String phoneId;
	private Integer subbusiId;
	private Integer processType;
	private Integer dunmodeId;
	private Date planDoneDate;
	private Date doneDate;
	private Date createDate;
	private String notes;
	private Long backSeq;
	private Byte finishStatus;
	private Date finishDate;
	private Integer brand;
	private Long batchId;
	private Byte sourceFlag;
	private String dealInfo;

	// Constructors

	/** default constructor */
	public AccKtInfo() {
	}

	/** minimal constructor */
	public AccKtInfo(Long doneCode, Long userId, Long acctId) {
		this.doneCode = doneCode;
		this.userId = userId;
		this.acctId = acctId;
	}

	/** full constructor */
	public AccKtInfo(Long doneCode, Long userId, Long acctId, String phoneId,
			Integer subbusiId, Integer processType, Integer dunmodeId,
			Date planDoneDate, Date doneDate, Date createDate, String notes,
			Long backSeq, Byte finishStatus, Date finishDate, Integer brand,
			Long batchId, Byte sourceFlag, String dealInfo) {
		this.doneCode = doneCode;
		this.userId = userId;
		this.acctId = acctId;
		this.phoneId = phoneId;
		this.subbusiId = subbusiId;
		this.processType = processType;
		this.dunmodeId = dunmodeId;
		this.planDoneDate = planDoneDate;
		this.doneDate = doneDate;
		this.createDate = createDate;
		this.notes = notes;
		this.backSeq = backSeq;
		this.finishStatus = finishStatus;
		this.finishDate = finishDate;
		this.brand = brand;
		this.batchId = batchId;
		this.sourceFlag = sourceFlag;
		this.dealInfo = dealInfo;
	}

	// Property accessors
	@Id
	public Long getDoneCode() {
		return doneCode;
	}

	public void setDoneCode(Long doneCode) {
		this.doneCode = doneCode;
	}

	@Id
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	@Column(name = "ACCT_ID", nullable = false, precision = 14, scale = 0)
	public Long getAcctId() {
		return this.acctId;
	}

	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}

	@Column(name = "PHONE_ID", length = 15)
	public String getPhoneId() {
		return this.phoneId;
	}

	public void setPhoneId(String phoneId) {
		this.phoneId = phoneId;
	}

	@Column(name = "SUBBUSI_ID", precision = 8, scale = 0)
	public Integer getSubbusiId() {
		return this.subbusiId;
	}

	public void setSubbusiId(Integer subbusiId) {
		this.subbusiId = subbusiId;
	}

	@Column(name = "PROCESS_TYPE", precision = 6, scale = 0)
	public Integer getProcessType() {
		return this.processType;
	}

	public void setProcessType(Integer processType) {
		this.processType = processType;
	}

	@Column(name = "DUNMODE_ID", precision = 8, scale = 0)
	public Integer getDunmodeId() {
		return this.dunmodeId;
	}

	public void setDunmodeId(Integer dunmodeId) {
		this.dunmodeId = dunmodeId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PLAN_DONE_DATE", length = 7)
	public Date getPlanDoneDate() {
		return this.planDoneDate;
	}

	public void setPlanDoneDate(Date planDoneDate) {
		this.planDoneDate = planDoneDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DONE_DATE", length = 7)
	public Date getDoneDate() {
		return this.doneDate;
	}

	public void setDoneDate(Date doneDate) {
		this.doneDate = doneDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", length = 7)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "NOTES", length = 500)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Column(name = "BACK_SEQ", precision = 15, scale = 0)
	public Long getBackSeq() {
		return this.backSeq;
	}

	public void setBackSeq(Long backSeq) {
		this.backSeq = backSeq;
	}

	@Column(name = "FINISH_STATUS", precision = 2, scale = 0)
	public Byte getFinishStatus() {
		return this.finishStatus;
	}

	public void setFinishStatus(Byte finishStatus) {
		this.finishStatus = finishStatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FINISH_DATE", length = 7)
	public Date getFinishDate() {
		return this.finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	@Column(name = "BRAND", precision = 8, scale = 0)
	public Integer getBrand() {
		return this.brand;
	}

	public void setBrand(Integer brand) {
		this.brand = brand;
	}

	@Column(name = "BATCH_ID", precision = 15, scale = 0)
	public Long getBatchId() {
		return this.batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	@Column(name = "SOURCE_FLAG", precision = 2, scale = 0)
	public Byte getSourceFlag() {
		return this.sourceFlag;
	}

	public void setSourceFlag(Byte sourceFlag) {
		this.sourceFlag = sourceFlag;
	}

	@Column(name = "DEAL_INFO", length = 500)
	public String getDealInfo() {
		return this.dealInfo;
	}

	public void setDealInfo(String dealInfo) {
		this.dealInfo = dealInfo;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
		.append("planDoneDate",getPlanDoneDate())
		.append("batchId",getBatchId())
		.append("userId",getUserId())
		.append("acctId",getAcctId())
		.append("subbusiId",getSubbusiId())
		.append("finishDate",getFinishDate())
		.append("notes",getNotes())
		.append("finishStatus",getFinishStatus())
		.append("phoneId",getPhoneId())
		.append("brand",getBrand())
		.append("doneCode",getDoneCode())
		.append("backSeq",getBackSeq())
		.append("dealInfo",getDealInfo())
		.append("sourceFlag",getSourceFlag())
		.append("createDate",getCreateDate())
		.append("doneDate",getDoneDate())
		.append("dunmodeId",getDunmodeId())
		.append("processType",getProcessType())
		.toString();
	}

	public static class AccKtInfoId implements java.io.Serializable {

		// Fields

		private Long doneCode;
		private Long userId;

		// Constructors

		/** default constructor */
		public AccKtInfoId() {
		}

		/** full constructor */
		public AccKtInfoId(Long doneCode, Long userId) {
			this.doneCode = doneCode;
			this.userId = userId;
		}

		// Property accessors

		@Column(name = "DONE_CODE", nullable = false, precision = 15, scale = 0)
		public Long getDoneCode() {
			return this.doneCode;
		}

		public void setDoneCode(Long doneCode) {
			this.doneCode = doneCode;
		}

		@Column(name = "USER_ID", nullable = false, precision = 14, scale = 0)
		public Long getUserId() {
			return this.userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		@Override
		public boolean equals(Object other) {
			if ( !(other instanceof AccKtInfoId) ) return false;
			AccKtInfoId castOther = (AccKtInfoId) other;
			return new EqualsBuilder()
				.append(this.getDoneCode(), castOther.getDoneCode())
				.append(this.getUserId(), castOther.getUserId())
				.isEquals();
		}
		
		@Override
		public int hashCode() {
			return new HashCodeBuilder()
			.append(getDoneCode())
			.append(getUserId())
			.toHashCode();
		}

	}
	
}