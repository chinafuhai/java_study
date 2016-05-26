package com.asiainfo.boss4.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.asiainfo.boss4.support.annotation.PartitionNameForTable;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable.OperatedField;

/**
 * IGroup entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
//@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_GROUP", schema = "ZG")
@IdClass(IGroup.IGroupId.class)
@PartitionNameForTable(operatedField=OperatedField.GROUP_ID)
@PartitionNameForTable.RegionCode(operatedField = OperatedField.GROUP_ID)
public class IGroup implements java.io.Serializable {

	// Fields

	private Long groupId;
	private Long sid;
	private Long soNbr;
	private Byte groupType;
	private Integer spromId;
	private String property;
	private Byte sts;
	private Short regionCode;
	private Date beginDate;
	private Date validDate;
	private Date expireDate;
	private String remark;

	// Constructors

	/** default constructor */
	public IGroup() {
	}

	/** minimal constructor */
	public IGroup(Long groupId, Long sid, Long soNbr, Byte groupType, Integer spromId, Byte sts,
			Short regionCode, Date beginDate, Date validDate, Date expireDate) {
		this.groupId = groupId;
		this.sid = sid;
		this.soNbr = soNbr;
		this.groupType = groupType;
		this.spromId = spromId;
		this.sts = sts;
		this.regionCode = regionCode;
		this.beginDate = beginDate;
		this.validDate = validDate;
		this.expireDate = expireDate;
	}

	/** full constructor */
	public IGroup(Long groupId, Long sid, Long soNbr, Byte groupType, Integer spromId,
			String property, Byte sts, Short regionCode, Date beginDate,
			Date validDate, Date expireDate, String remark) {
		this.groupId = groupId;
		this.sid = sid;
		this.soNbr = soNbr;
		this.groupType = groupType;
		this.spromId = spromId;
		this.property = property;
		this.sts = sts;
		this.regionCode = regionCode;
		this.beginDate = beginDate;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.remark = remark;
	}

	// Property accessors
	@Id
	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
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

	@Column(name = "GROUP_TYPE", nullable = false, precision = 2, scale = 0)
	public Byte getGroupType() {
		return this.groupType;
	}

	public void setGroupType(Byte groupType) {
		this.groupType = groupType;
	}

	@Column(name = "SPROM_ID", nullable = false, precision = 8, scale = 0)
	public Integer getSpromId() {
		return this.spromId;
	}

	public void setSpromId(Integer spromId) {
		this.spromId = spromId;
	}

	@Column(name = "PROPERTY", length = 20)
	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	@Column(name = "STS", nullable = false, precision = 2, scale = 0)
	public Byte getSts() {
		return this.sts;
	}

	public void setSts(Byte sts) {
		this.sts = sts;
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
	@Column(name = "VALID_DATE", nullable = false, length = 7)
	public Date getValidDate() {
		return this.validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
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
			.append("beginDate",getBeginDate())
			.append("sid",getSid())
			.append("spromId",getSpromId())
			.append("property",getProperty())
			.append("soNbr",getSoNbr())
			.append("expireDate",getExpireDate())
			.append("remark",getRemark())
			.append("validDate",getValidDate())
			.append("groupId",getGroupId())
			.append("sts",getSts())
			.append("groupType",getGroupType())
			.append("regionCode",getRegionCode())
			.toString();
	}

	public static class IGroupId implements java.io.Serializable {

		// Fields

		private Long groupId;
		private Long sid;
		private Long soNbr;

		// Constructors

		/** default constructor */
		public IGroupId() {
		}

		/** full constructor */
		public IGroupId(Long groupId, Long sid, Long soNbr) {
			this.groupId = groupId;
			this.sid = sid;
			this.soNbr = soNbr;
		}

		// Property accessors

		@Column(name = "GROUP_ID", nullable = false, precision = 12, scale = 0)
		public Long getGroupId() {
			return this.groupId;
		}

		public void setGroupId(Long groupId) {
			this.groupId = groupId;
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
	        if ( !(other instanceof IGroupId) ) return false;
	        IGroupId castOther = (IGroupId) other;
	        return new EqualsBuilder()
	            .append(this.getGroupId(), castOther.getGroupId())
	            .append(this.getSid(), castOther.getSid())
	            .append(this.getSoNbr(), castOther.getSoNbr())
	            .isEquals();
	    }

		@Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getGroupId())
	            .append(getSid())
	            .append(getSoNbr())
	            .toHashCode();
	    }

	}
	
}