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

import com.asiainfo.boss4.domain.IUserRoamRent;

/**
 * IUserRoamRent0105 entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_ROAM_RENT_0105", schema = "ZG")
@IdClass(IUserRoamRent0105.IUserRoamRent0105Id.class)
public class IUserRoamRent0105 extends IUserRoamRent implements java.io.Serializable {

	// Fields

	private Long servId;
	private String roamMsisdn;
	private Date validDate;
	private String msisdn;
	private Integer rentId;
	private Short regionCode;
	private Date beginDate;
	private Date expireDate;
	private Long sid;
	private Long soNbr;
	private String remark;

	// Constructors

	/** default constructor */
	public IUserRoamRent0105() {
	}

	/** minimal constructor */
	public IUserRoamRent0105(Long servId, String roamMsisdn, Date validDate, String msisdn, Integer rentId,
			Short regionCode, Date beginDate, Date expireDate, Long sid,
			Long soNbr) {
		this.servId = servId;
		this.roamMsisdn = roamMsisdn;
		this.validDate = validDate;
		this.msisdn = msisdn;
		this.rentId = rentId;
		this.regionCode = regionCode;
		this.beginDate = beginDate;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
	}

	/** full constructor */
	public IUserRoamRent0105(Long servId, String roamMsisdn, Date validDate, String msisdn, Integer rentId,
			Short regionCode, Date beginDate, Date expireDate, Long sid,
			Long soNbr, String remark) {
		this.servId = servId;
		this.roamMsisdn = roamMsisdn;
		this.validDate = validDate;
		this.msisdn = msisdn;
		this.rentId = rentId;
		this.regionCode = regionCode;
		this.beginDate = beginDate;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
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
	public String getRoamMsisdn() {
		return roamMsisdn;
	}

	public void setRoamMsisdn(String roamMsisdn) {
		this.roamMsisdn = roamMsisdn;
	}

	@Id
	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Column(name = "MSISDN", nullable = false, length = 15)
	public String getMsisdn() {
		return this.msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	@Column(name = "RENT_ID", nullable = false, precision = 8, scale = 0)
	public Integer getRentId() {
		return this.rentId;
	}

	public void setRentId(Integer rentId) {
		this.rentId = rentId;
	}

	@Column(name = "REGION_CODE", nullable = false, precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BEGIN_DATE", nullable = false, length = 7)
	public Date getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRE_DATE", nullable = false, length = 7)
	public Date getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
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
			.append("validDate",getValidDate())
			.append("servId",getServId())
			.append("sid",getSid())
			.append("msisdn",getMsisdn())
			.append("beginDate",getBeginDate())
			.append("rentId",getRentId())
			.append("soNbr",getSoNbr())
			.append("roamMsisdn",getRoamMsisdn())
			.append("expireDate",getExpireDate())
			.append("remark",getRemark())
			.append("regionCode",getRegionCode())
			.toString();
	}

	public static class IUserRoamRent0105Id implements java.io.Serializable {

		// Fields

		private Long servId;
		private String roamMsisdn;
		private Date validDate;

		// Constructors

		/** default constructor */
		public IUserRoamRent0105Id() {
		}

		/** full constructor */
		public IUserRoamRent0105Id(Long servId, String roamMsisdn, Date validDate) {
			this.servId = servId;
			this.roamMsisdn = roamMsisdn;
			this.validDate = validDate;
		}

		// Property accessors

		@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
		public Long getServId() {
			return this.servId;
		}

		public void setServId(Long servId) {
			this.servId = servId;
		}

		@Column(name = "ROAM_MSISDN", nullable = false, length = 15)
		public String getRoamMsisdn() {
			return this.roamMsisdn;
		}

		public void setRoamMsisdn(String roamMsisdn) {
			this.roamMsisdn = roamMsisdn;
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
			if ( !(other instanceof IUserRoamRent0105Id) ) return false;
			IUserRoamRent0105Id castOther = (IUserRoamRent0105Id) other;
			return new EqualsBuilder()
				.append(this.getValidDate(), castOther.getValidDate())
				.append(this.getServId(), castOther.getServId())
				.append(this.getRoamMsisdn(), castOther.getRoamMsisdn())
				.isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder()
				.append(getValidDate())
				.append(getServId())
				.append(getRoamMsisdn())
				.toHashCode();
		}

	}
}