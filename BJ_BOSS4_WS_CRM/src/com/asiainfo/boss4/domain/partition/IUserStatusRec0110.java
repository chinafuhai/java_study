package com.asiainfo.boss4.domain.partition;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.asiainfo.boss4.domain.IUserStatusRec;

/**
 * IUserStatusRec0110 entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_STATUS_REC_0110", schema = "ZG")
public class IUserStatusRec0110 extends IUserStatusRec implements java.io.Serializable {

	// Fields

	private Long servId;
	private Byte mgntSts;
	private String remark;
	private Date commitDate;

	// Constructors

	/** default constructor */
	public IUserStatusRec0110() {
	}

	/** minimal constructor */
	public IUserStatusRec0110(Long servId, Date commitDate) {
		this.servId = servId;
		this.commitDate = commitDate;
	}

	/** full constructor */
	public IUserStatusRec0110(Long servId, Byte mgntSts, String remark, Date commitDate) {
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
	public boolean equals(Object other) {
		if ( !(other instanceof IUserStatusRec0110) ) return false;
		IUserStatusRec0110 castOther = (IUserStatusRec0110) other;
		return new EqualsBuilder()
			.append(this.getServId(), castOther.getServId())
			.append(this.getMgntSts(), castOther.getMgntSts())
			.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getServId())
			.append(getMgntSts())
			.toHashCode();
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