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

import com.asiainfo.boss4.domain.ISaleOper;

/**
 * ISaleOper0106 entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_SALE_OPER_0106", schema = "ZG")
public class ISaleOper0106 extends ISaleOper implements java.io.Serializable {

	// Fields

	private Long sid;
	private Long soNbr;
	private Integer busiCode;
	private Short regionCode;
	private Short countyCode;
	private Integer orgId;
	private Long servId;
	private Long custId;
	private Long acctId;
	private Long groupId;
	private Date commitDate;
	private String upField;
	private String remark;
	private Date upDate;

	// Constructors

	/** default constructor */
	public ISaleOper0106() {
	}

	/** minimal constructor */
	public ISaleOper0106(Long sid, Long soNbr, Integer busiCode,
			Short regionCode, Short countyCode, Integer orgId, Long servId,
			Date commitDate, String upField) {
		this.sid = sid;
		this.soNbr = soNbr;
		this.busiCode = busiCode;
		this.regionCode = regionCode;
		this.countyCode = countyCode;
		this.orgId = orgId;
		this.servId = servId;
		this.commitDate = commitDate;
		this.upField = upField;
	}

	/** full constructor */
	public ISaleOper0106(Long sid, Long soNbr, Integer busiCode,
			Short regionCode, Short countyCode, Integer orgId, Long servId,
			Long custId, Long acctId, Long groupId, Date commitDate,
			String upField, String remark, Date upDate) {
		this.sid = sid;
		this.soNbr = soNbr;
		this.busiCode = busiCode;
		this.regionCode = regionCode;
		this.countyCode = countyCode;
		this.orgId = orgId;
		this.servId = servId;
		this.custId = custId;
		this.acctId = acctId;
		this.groupId = groupId;
		this.commitDate = commitDate;
		this.upField = upField;
		this.remark = remark;
		this.upDate = upDate;
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

	@Column(name = "SO_NBR", nullable = false, precision = 15, scale = 0)
	public Long getSoNbr() {
		return this.soNbr;
	}

	public void setSoNbr(Long soNbr) {
		this.soNbr = soNbr;
	}

	@Column(name = "BUSI_CODE", nullable = false, precision = 6, scale = 0)
	public Integer getBusiCode() {
		return this.busiCode;
	}

	public void setBusiCode(Integer busiCode) {
		this.busiCode = busiCode;
	}

	@Column(name = "REGION_CODE", nullable = false, precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "COUNTY_CODE", nullable = false, precision = 4, scale = 0)
	public Short getCountyCode() {
		return this.countyCode;
	}

	public void setCountyCode(Short countyCode) {
		this.countyCode = countyCode;
	}

	@Column(name = "ORG_ID", nullable = false, precision = 8, scale = 0)
	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
	public Long getServId() {
		return this.servId;
	}

	public void setServId(Long servId) {
		this.servId = servId;
	}

	@Column(name = "CUST_ID", precision = 14, scale = 0)
	public Long getCustId() {
		return this.custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	@Column(name = "ACCT_ID", precision = 14, scale = 0)
	public Long getAcctId() {
		return this.acctId;
	}

	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}

	@Column(name = "GROUP_ID", precision = 12, scale = 0)
	public Long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "COMMIT_DATE", nullable = false, length = 7)
	public Date getCommitDate() {
		return this.commitDate;
	}

	public void setCommitDate(Date commitDate) {
		this.commitDate = commitDate;
	}

	@Column(name = "UP_FIELD", nullable = false, length = 64)
	public String getUpField() {
		return this.upField;
	}

	public void setUpField(String upField) {
		this.upField = upField;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UP_DATE", length = 7)
	public Date getUpDate() {
		return this.upDate;
	}

	public void setUpDate(Date upDate) {
		this.upDate = upDate;
	}
	
    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("sid", getSid())
            .append("soNbr",getSoNbr())
            .append("busiCode",getBusiCode())
            .append("regionCode",getRegionCode())
            .append("countyCode",getCountyCode())
            .append("orgId",getOrgId())
            .append("servId",getServId())
            .append("custId",getCustId())
            .append("acctId",getAcctId())
            .append("groupId",getGroupId())
            .append("commitDate",getCommitDate())
            .append("upField",getUpField())
            .append("remark",getRemark())
            .append("upDate",getUpDate())
            .toString();
    }

    @Override
    public boolean equals(Object other) {
        if ( !(other instanceof ISaleOper0106) ) return false;
        ISaleOper0106 castOther = (ISaleOper0106) other;
        return new EqualsBuilder()
            .append(this.getSid(), castOther.getSid())
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSid())
            .toHashCode();
    }

}