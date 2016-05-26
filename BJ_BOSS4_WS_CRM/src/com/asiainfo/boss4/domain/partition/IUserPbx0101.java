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

import com.asiainfo.boss4.domain.IUserPbx;
import com.asiainfo.boss4.domain.IUserPbx.IUserPbxId;

/**
 * IUserPbx0101 entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_PBX_0101", schema = "ZG")
@IdClass(IUserPbx0101.IUserPbx0101Id.class)
public class IUserPbx0101 extends IUserPbx implements java.io.Serializable {

	// Fields

	private Long servId;
	private Long mscId;
	private Date validDate;
	private Long soNbr;
	private Short regionCode;
	private Short areaCode;
	private String inTrunk;
	private String outTrunk;
	private String accessNumber;
	private Byte matchingAccessNumber;
	private Date expireDate;
	private String remark;
	private Long sid;

	// Constructors

	/** default constructor */
	public IUserPbx0101() {
	}

	/** minimal constructor */
	public IUserPbx0101(Long servId, Long mscId, Date validDate, Long soNbr, Short regionCode, String inTrunk,
			String outTrunk, String accessNumber, Byte matchingAccessNumber,
			Date expireDate) {
		this.servId = servId;
		this.mscId = mscId;
		this.validDate = validDate;
		this.soNbr = soNbr;
		this.regionCode = regionCode;
		this.inTrunk = inTrunk;
		this.outTrunk = outTrunk;
		this.accessNumber = accessNumber;
		this.matchingAccessNumber = matchingAccessNumber;
		this.expireDate = expireDate;
	}

	/** full constructor */
	public IUserPbx0101(Long servId, Long mscId, Date validDate, Long soNbr, Short regionCode, Short areaCode,
			String inTrunk, String outTrunk, String accessNumber,
			Byte matchingAccessNumber, Date expireDate, String remark,
			Long sid) {
		this.servId = servId;
		this.mscId = mscId;
		this.validDate = validDate;
		this.soNbr = soNbr;
		this.regionCode = regionCode;
		this.areaCode = areaCode;
		this.inTrunk = inTrunk;
		this.outTrunk = outTrunk;
		this.accessNumber = accessNumber;
		this.matchingAccessNumber = matchingAccessNumber;
		this.expireDate = expireDate;
		this.remark = remark;
		this.sid = sid;
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
	public Long getMscId() {
		return mscId;
	}

	public void setMscId(Long mscId) {
		this.mscId = mscId;
	}

	@Id
	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Id
	public Long getSoNbr() {
		return soNbr;
	}

	public void setSoNbr(Long soNbr) {
		this.soNbr = soNbr;
	}

	@Column(name = "REGION_CODE", nullable = false, precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "AREA_CODE", precision = 4, scale = 0)
	public Short getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(Short areaCode) {
		this.areaCode = areaCode;
	}

	@Column(name = "IN_TRUNK", nullable = false, length = 16)
	public String getInTrunk() {
		return this.inTrunk;
	}

	public void setInTrunk(String inTrunk) {
		this.inTrunk = inTrunk;
	}

	@Column(name = "OUT_TRUNK", nullable = false, length = 16)
	public String getOutTrunk() {
		return this.outTrunk;
	}

	public void setOutTrunk(String outTrunk) {
		this.outTrunk = outTrunk;
	}

	@Column(name = "ACCESS_NUMBER", nullable = false, length = 32)
	public String getAccessNumber() {
		return this.accessNumber;
	}

	public void setAccessNumber(String accessNumber) {
		this.accessNumber = accessNumber;
	}

	@Column(name = "MATCHING_ACCESS_NUMBER", nullable = false, precision = 2, scale = 0)
	public Byte getMatchingAccessNumber() {
		return this.matchingAccessNumber;
	}

	public void setMatchingAccessNumber(Byte matchingAccessNumber) {
		this.matchingAccessNumber = matchingAccessNumber;
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

	@Column(name = "SID", precision = 12, scale = 0)
	public Long getSid() {
		return this.sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("servId",getServId())
			.append("areaCode",getAreaCode())
			.append("accessNumber",getAccessNumber())
			.append("soNbr",getSoNbr())
			.append("expireDate",getExpireDate())
			.append("matchingAccessNumber",getMatchingAccessNumber())
			.append("mscId",getMscId())
			.append("remark",getRemark())
			.append("outTrunk",getOutTrunk())
			.append("validDate",getValidDate())
			.append("inTrunk",getInTrunk())
			.append("regionCode",getRegionCode())
			.append("sid",getSid())
			.toString();
	}

	public static class IUserPbx0101Id implements java.io.Serializable {
		private Long servId;
		private Long mscId;
		private Date validDate;
		private Long soNbr;
		private String inTrunk;
		// Constructors

		/** default constructor */
		public IUserPbx0101Id() {
		}

		/** full constructor */
		public IUserPbx0101Id(Long servId, Long mscId, Date validDate, Long soNbr,String inTrunk) {
			this.servId = servId;
			this.mscId = mscId;
			this.validDate = validDate;
			this.soNbr = soNbr;
			this.inTrunk = inTrunk;
		}

		// Property accessors

		@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
		public Long getServId() {
			return this.servId;
		}

		public void setServId(Long servId) {
			this.servId = servId;
		}

		@Column(name = "MSC_ID", nullable = false, precision = 14, scale = 0)
		public Long getMscId() {
			return this.mscId;
		}

		public void setMscId(Long mscId) {
			this.mscId = mscId;
		}

		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "VALID_DATE", nullable = false, length = 7)
		public Date getValidDate() {
			return this.validDate;
		}

		public void setValidDate(Date validDate) {
			this.validDate = validDate;
		}

		@Column(name = "SO_NBR", nullable = false, precision = 15, scale = 0)
		public Long getSoNbr() {
			return soNbr;
		}
	
		public void setSoNbr(Long soNbr) {
			this.soNbr = soNbr;
		}

		@Column(name = "IN_TRUNK", nullable = false, length = 16)
		public String getInTrunk() {
			return this.inTrunk;
		}

		public void setInTrunk(String inTrunk) {
			this.inTrunk = inTrunk;
		}
		@Override
		public boolean equals(Object other) {
			if ( !(other instanceof IUserPbx0101Id) ) return false;
			IUserPbx0101Id castOther = (IUserPbx0101Id) other;
			return new EqualsBuilder()
				.append(this.getValidDate(), castOther.getValidDate())
				.append(this.getServId(), castOther.getServId())
				.append(this.getSoNbr(), castOther.getSoNbr())
				.append(this.getMscId(), castOther.getMscId())
				.append(this.getInTrunk(), castOther.getInTrunk())
				.isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder()
				.append(getValidDate())
				.append(getServId())
				.append(getSoNbr())
				.append(getMscId())
				.append(getInTrunk())
				.toHashCode();
		}
	}

}