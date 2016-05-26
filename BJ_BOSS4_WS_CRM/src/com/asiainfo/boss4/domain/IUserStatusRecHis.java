package com.asiainfo.boss4.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * IUserStatusRecHis entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_STATUS_REC_HIS", schema = "ZG")
public class IUserStatusRecHis implements java.io.Serializable {

	// Fields

	private Long servId;
	private Byte mgntSts;
	private String remark;
	private Date commitDate;

	// Constructors

	/** default constructor */
	public IUserStatusRecHis() {
	}

	/** minimal constructor */
	public IUserStatusRecHis(Long servId, Date commitDate) {
		this.servId = servId;
		this.commitDate = commitDate;
	}

	/** full constructor */
	public IUserStatusRecHis(Long servId, Byte mgntSts, String remark,
			Date commitDate) {
		this.servId = servId;
		this.mgntSts = mgntSts;
		this.remark = remark;
		this.commitDate = commitDate;
	}

	// Property accessors
	@Id
	@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
	public Long getServId() {
		return this.servId;
	}

	public void setServId(Long servId) {
		this.servId = servId;
	}

	@Column(name = "MGNT_STS", precision = 2, scale = 0)
	public Byte getMgntSts() {
		return this.mgntSts;
	}

	public void setMgntSts(Byte mgntSts) {
		this.mgntSts = mgntSts;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "COMMIT_DATE", nullable = false, length = 7)
	public Date getCommitDate() {
		return this.commitDate;
	}

	public void setCommitDate(Date commitDate) {
		this.commitDate = commitDate;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("servId",getServId())
			.append("mgntSts",getMgntSts())
			.append("commitDate",getCommitDate())
			.append("remark",getRemark())
			.toString();
	}
}