package com.asiainfo.boss4.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * InBusiBatch entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "IN_BUSI_BATCH", schema = "INTER")
public class InBusiBatch implements java.io.Serializable {

	// Fields

	private String batchid;
	private String batchnum;
	private String state;
	private Date createDate;

	// Constructors

	/** default constructor */
	public InBusiBatch() {
	}

	/** minimal constructor */
	public InBusiBatch(Date createDate) {
		this.createDate = createDate;
	}

	/** full constructor */
	public InBusiBatch(String batchid, String batchnum, String state,
			Date createDate) {
		this.batchid = batchid;
		this.batchnum = batchnum;
		this.state = state;
		this.createDate = createDate;
	}

	// Property accessors

	@Id
	@Column(name = "BATCHID", unique = true, length = 100)
	public String getBatchid() {
		return this.batchid;
	}

	public void setBatchid(String batchid) {
		this.batchid = batchid;
	}

	@Column(name = "BATCHNUM", length = 100)
	public String getBatchnum() {
		return this.batchnum;
	}

	public void setBatchnum(String batchnum) {
		this.batchnum = batchnum;
	}

	@Column(name = "STATE", length = 100)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATE", nullable = false, length = 7)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof InBusiBatch))
			return false;
		InBusiBatch castOther = (InBusiBatch) other;

		return ((this.getBatchid() == castOther.getBatchid()) || (this
				.getBatchid() != null
				&& castOther.getBatchid() != null && this.getBatchid().equals(
				castOther.getBatchid())))
				&& ((this.getBatchnum() == castOther.getBatchnum()) || (this
						.getBatchnum() != null
						&& castOther.getBatchnum() != null && this
						.getBatchnum().equals(castOther.getBatchnum())))
				&& ((this.getState() == castOther.getState()) || (this
						.getState() != null
						&& castOther.getState() != null && this.getState()
						.equals(castOther.getState())))
				&& ((this.getCreateDate() == castOther.getCreateDate()) || (this
						.getCreateDate() != null
						&& castOther.getCreateDate() != null && this
						.getCreateDate().equals(castOther.getCreateDate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getBatchid() == null ? 0 : this.getBatchid().hashCode());
		result = 37 * result
				+ (getBatchnum() == null ? 0 : this.getBatchnum().hashCode());
		result = 37 * result
				+ (getState() == null ? 0 : this.getState().hashCode());
		result = 37
				* result
				+ (getCreateDate() == null ? 0 : this.getCreateDate()
						.hashCode());
		return result;
	}

}