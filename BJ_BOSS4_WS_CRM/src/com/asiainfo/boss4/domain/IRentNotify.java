package com.asiainfo.boss4.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.annotation.AddOnly;

/**
 * IRentNotify entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_RENT_NOTIFY", schema = "ZG")
@AddOnly
public class IRentNotify extends BaseEntity implements java.io.Serializable {
	// Fields

	private Short srcType;
	private Short changeFlag;
	private Short regionCode;
	private Long servId;
	private Long acctId;
	private Long soNbr;
	private Date validDate;
	private Date createDate;

	private Short crmDelayLimit;
	// Constructors

	/** default constructor */
	public IRentNotify() {
	}

	/** full constructor */
	public IRentNotify(Short srcType, Short changeFlag, Long soNbr,
			Short regionCode, Long servId,
			Long acctId, Date validDate, Date createDate) {
		this.srcType = srcType;
		this.soNbr = soNbr;
		this.changeFlag = changeFlag;
		this.regionCode = regionCode;
		this.servId = servId;
		this.acctId = acctId;
		this.validDate = validDate;
		this.createDate = createDate;
	}

	// Property accessors
	@Id
	@Column(name = "SO_NBR", nullable = false, precision = 15, scale = 0)
	public Long getSoNbr() {
		return this.soNbr;
	}

	public void setSoNbr(Long soNbr) {
		this.soNbr = soNbr;
	}

	@Column(name = "SRC_TYPE", nullable = false, precision = 2, scale = 0)
	public Short getSrcType() {
		return this.srcType;
	}

	public void setSrcType(Short srcType) {
		this.srcType = srcType;
	}

	@Column(name = "REGION_CODE", nullable = false, precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "CHANGE_FLAG", nullable = false, precision = 2, scale = 0)
	public Short getChangeFlag() {
		return this.changeFlag;
	}

	public void setChangeFlag(Short changeFlag) {
		this.changeFlag = changeFlag;
	}

	@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
	public Long getServId() {
		return this.servId;
	}

	public void setServId(Long servId) {
		this.servId = servId;
	}


	@Column(name = "ACCT_ID", precision = 14, scale = 0)
	public Long getAcctId() {
		return this.acctId;
	}

	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VALID_DATE", nullable = false, length = 7)
	public Date getValidDate() {
		return this.validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", length = 7)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Transient
    public Short getCrmDelayLimit() {
		return crmDelayLimit;
	}

	public void setCrmDelayLimit(Short crmDelayLimit) {
		this.crmDelayLimit = crmDelayLimit;
	}
	
	@Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("srcType", getSrcType())
            .append("soNbr",getSoNbr())
            .append("changeFlag",getChangeFlag())
            .append("regionCode",getRegionCode())
            .append("servId",getServId())
            .append("acctId",getAcctId())
            .append("validDate",getValidDate())
            .append("createDate",getCreateDate())
            .toString();
    }

    @Override
    public boolean equals(Object other) {
        if ( !(other instanceof IRentNotify) ) return false;
        IRentNotify castOther = (IRentNotify) other;
        return new EqualsBuilder()
            .append(this.getSoNbr(), castOther.getSoNbr())
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSoNbr())
            .toHashCode();
    }

}