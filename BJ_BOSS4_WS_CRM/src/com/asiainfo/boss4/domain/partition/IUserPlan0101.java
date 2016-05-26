package com.asiainfo.boss4.domain.partition;

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

import com.asiainfo.boss4.domain.IUserPlan;

/**
 * IUserPlan01010 entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_PLAN_0101", schema = "ZG")
@IdClass(IUserPlan0101.IUserPlan0101Id.class)
public class IUserPlan0101 extends IUserPlan implements java.io.Serializable {

	// Fields

	private Long servId;
	private Date validDate;
	private Long sid;
	private Long soNbr;
	private Integer planId;
	private Short regionCode;
	private Date expireDate;
	private String remark;

	// Constructors

	/** default constructor */
	public IUserPlan0101() {
	}

	/** minimal constructor */
	public IUserPlan0101(Long servId, Date validDate, Long sid, Long soNbr, Integer planId, Short regionCode,
			Date expireDate) {
		this.servId = servId;
		this.validDate = validDate;
		this.sid = sid;
		this.soNbr = soNbr;
		this.planId = planId;
		this.regionCode = regionCode;
		this.expireDate = expireDate;
	}

	/** full constructor */
	public IUserPlan0101(Long servId, Date validDate, Long sid, Long soNbr, Integer planId, Short regionCode,
			Date expireDate, String remark) {
		this.servId = servId;
		this.validDate = validDate;
		this.sid = sid;
		this.soNbr = soNbr;
		this.planId = planId;
		this.regionCode = regionCode;
		this.expireDate = expireDate;
		this.remark = remark;
	}

	// Property accessors
	@Id
	public Long getServId() {
		return servId;
	}

	public void setServId(Long servId) {
		this.servId = servId;
	}
	
	@Id
	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Id
	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	@Id
	public Long getSoNbr() {
		return soNbr;
	}

	public void setSoNbr(Long soNbr) {
		this.soNbr = soNbr;
	}

	@Column(name = "PLAN_ID", nullable = false, precision = 8, scale = 0)
	public Integer getPlanId() {
		return this.planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	@Column(name = "REGION_CODE", nullable = false, precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRE_DATE", nullable = false, length = 7)
	public Date getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
        return new ToStringBuilder(this)
            .append("servId", getServId())
            .append("planId", getPlanId())
            .append("regionCode", getRegionCode())
            .append("validDate", getValidDate())
            .append("expireDate", getExpireDate())
            .append("sid", getSid())
            .append("soNbr", getSoNbr())
            .append("remark", getRemark())
            .toString();
    }
	
	public static class IUserPlan0101Id implements java.io.Serializable {

		// Fields

		private Long servId;
		private Date validDate;
		private Long sid;
		private Long soNbr;

		// Constructors

		/** default constructor */
		public IUserPlan0101Id() {
		}

		/** full constructor */
		public IUserPlan0101Id(Long servId, Date validDate, Long sid, Long soNbr) {
			this.servId = servId;
			this.validDate = validDate;
			this.sid = sid;
			this.soNbr = soNbr;
		}

		// Property accessors

		@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
		public Long getServId() {
			return this.servId;
		}

		public void setServId(Long servId) {
			this.servId = servId;
		}

		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "VALID_DATE", nullable = false, length = 7)
		public Date getValidDate() {
			return this.validDate;
		}

		public void setValidDate(Date validDate) {
			this.validDate = validDate;
		}

		@Column(name = "SID", nullable = false, precision = 12, scale = 0)
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

		@Override
		public boolean equals(Object other) {
			if ( !(other instanceof IUserPlan0101Id) ) return false;
			IUserPlan0101Id castOther = (IUserPlan0101Id) other;
	        return new EqualsBuilder()
	            .append(this.getServId(), castOther.getServId())
	            .append(this.getValidDate(), castOther.getValidDate())
	            .append(this.getSid(), castOther.getSid())
	            .append(this.getSoNbr(), castOther.getSoNbr())
	            .isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder()
	            .append(getServId())
	            .append(getValidDate())
	            .append(getSid())
	            .append(getSoNbr())
	            .toHashCode();
		}
	}
}