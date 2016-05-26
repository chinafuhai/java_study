package com.asiainfo.boss4.domain.partition;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.asiainfo.boss4.domain.IOrderOper;

/**
 * IOrderOper0107 entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_ORDER_OPER_0107", schema = "ZG")
public class IOrderOper0107 extends IOrderOper implements java.io.Serializable {

	// Fields

	private Long sid;
	private Long ownerId;
	private String upField;
	private Short regionCode;
	private Integer busiType;
	private Date commitDate;
	private Date upDate;
	private Byte procSts;
	private Date delayDate;
	private String remark;
	private Long soNbr;

	// Constructors

	/** default constructor */
	public IOrderOper0107() {
	}

	/** minimal constructor */
	public IOrderOper0107(Long sid, Long ownerId, String upField,
			Short regionCode, Integer busiType, Date commitDate, Byte procSts) {
		this.sid = sid;
		this.ownerId = ownerId;
		this.upField = upField;
		this.regionCode = regionCode;
		this.busiType = busiType;
		this.commitDate = commitDate;
		this.procSts = procSts;
	}

	/** full constructor */
	public IOrderOper0107(Long sid, Long ownerId, String upField,
			Short regionCode, Integer busiType, Date commitDate, Date upDate,
			Byte procSts, Date delayDate, String remark, Long soNbr) {
		this.sid = sid;
		this.ownerId = ownerId;
		this.upField = upField;
		this.regionCode = regionCode;
		this.busiType = busiType;
		this.commitDate = commitDate;
		this.upDate = upDate;
		this.procSts = procSts;
		this.delayDate = delayDate;
		this.remark = remark;
		this.soNbr = soNbr;
	}

	// Property accessors
	@Id
	@Column(name = "SID", unique = true, nullable = false, precision = 12, scale = 0)
	public Long getSid() {
		return this.sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	@Column(name = "OWNER_ID", nullable = false, precision = 14, scale = 0)
	public Long getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	@Column(name = "UP_FIELD", nullable = false, length = 64)
	public String getUpField() {
		return this.upField;
	}

	public void setUpField(String upField) {
		this.upField = upField;
	}

	@Column(name = "REGION_CODE", nullable = false, precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "BUSI_TYPE", nullable = false, precision = 6, scale = 0)
	public Integer getBusiType() {
		return this.busiType;
	}

	public void setBusiType(Integer busiType) {
		this.busiType = busiType;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "COMMIT_DATE", nullable = false, length = 7)
	public Date getCommitDate() {
		return this.commitDate;
	}

	public void setCommitDate(Date commitDate) {
		this.commitDate = commitDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UP_DATE", length = 7)
	public Date getUpDate() {
		return this.upDate;
	}

	public void setUpDate(Date upDate) {
		this.upDate = upDate;
	}

	@Column(name = "PROC_STS", nullable = false, precision = 2, scale = 0)
	public Byte getProcSts() {
		return this.procSts;
	}

	public void setProcSts(Byte procSts) {
		this.procSts = procSts;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DELAY_DATE", length = 7)
	public Date getDelayDate() {
		return this.delayDate;
	}

	public void setDelayDate(Date delayDate) {
		this.delayDate = delayDate;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "SO_NBR", precision = 15, scale = 0)
	public Long getSoNbr() {
		return this.soNbr;
	}

	public void setSoNbr(Long soNbr) {
		this.soNbr = soNbr;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
		.append("sid",getSid())
		.append("commitDate",getCommitDate())
		.append("upDate",getUpDate())
		.append("soNbr",getSoNbr())
		.append("delayDate",getDelayDate())
		.append("ownerId",getOwnerId())
		.append("remark",getRemark())
		.append("busiType",getBusiType())
		.append("upField",getUpField())
		.append("procSts",getProcSts())
		.append("regionCode",getRegionCode())
		.toString();
	}
	
}