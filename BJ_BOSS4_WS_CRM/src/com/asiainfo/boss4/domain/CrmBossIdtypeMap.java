package com.asiainfo.boss4.domain;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * CrmBossIdtypeMap entity. @author MyEclipse Persistence Tools
 */

public class CrmBossIdtypeMap implements java.io.Serializable {

	private static final long serialVersionUID = -9038249964564231397L;

	// Fields

	private String idType;
	private String crmId;
	private Integer bossId;
	private Date validDate;
	private Date expireDate;
	private String remark;

	// Constructors

	/** default constructor */
	public CrmBossIdtypeMap() {
	}

	/** minimal constructor */
	public CrmBossIdtypeMap(String idType, String crmId, Integer bossId) {
		this.idType = idType;
		this.crmId = crmId;
		this.bossId = bossId;
	}

	/** full constructor */
	public CrmBossIdtypeMap(String idType, String crmId, Integer bossId,
			Date validDate, Date expireDate, String remark) {
		this.idType = idType;
		this.crmId = crmId;
		this.bossId = bossId;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.remark = remark;
	}

	// Property accessors

	public String getIdType() {
		return this.idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getCrmId() {
		return this.crmId;
	}

	public void setCrmId(String crmId) {
		this.crmId = crmId;
	}

	public Integer getBossId() {
		return this.bossId;
	}

	public void setBossId(Integer bossId) {
		this.bossId = bossId;
	}

	public Date getValidDate() {
		return this.validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	public Date getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Override
	public boolean equals(Object other) {
        if ( !(other instanceof CrmBossIdtypeMap) ) return false;
        CrmBossIdtypeMap castOther = (CrmBossIdtypeMap) other;
        return new EqualsBuilder()
            .append(this.getIdType(), castOther.getIdType())
            .append(this.getCrmId(), castOther.getCrmId())
            .append(this.getBossId(), castOther.getBossId())
            .isEquals();
    }

	@Override
    public int hashCode() {
        return new HashCodeBuilder()
            .append(getIdType())
            .append(getCrmId())
            .append(getBossId())
            .toHashCode();
    }

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("validDate",getValidDate())
			.append("crmId",getCrmId())
			.append("bossId",getBossId())
			.append("expireDate",getExpireDate())
			.append("remark",getRemark())
			.append("idType",getIdType())
			.toString();
	}

}