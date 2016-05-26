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

import com.asiainfo.boss4.domain.IGroupMember;

/**
 * IGroupMember0101 entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_GROUP_MEMBER_0101", schema = "ZG")
@IdClass(IGroupMember0101.IGroupMember0101Id.class)
public class IGroupMember0101 extends IGroupMember implements java.io.Serializable {

	// Fields

	private Long servId;
	private Long groupId;
	private Date validDate;
	private Byte groupType;
	private String property;
	private Short regionCode;
	private Date beginDate;
	private Date expireDate;
	private Long sid;
	private Long soNbr;
	private String remark;
	private Short priority;

	// Constructors

	/** default constructor */
	public IGroupMember0101() {
	}

	/** minimal constructor */
	public IGroupMember0101(Long servId, Long groupId, Date validDate, Byte groupType, Short regionCode,
			Date beginDate, Date expireDate, Long sid, Long soNbr) {
		this.servId = servId;
		this.groupId = groupId;
		this.validDate = validDate;
		this.groupType = groupType;
		this.regionCode = regionCode;
		this.beginDate = beginDate;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
	}

	/** full constructor */
	public IGroupMember0101(Long servId, Long groupId, Date validDate, Byte groupType, String property,
			Short regionCode, Date beginDate, Date expireDate, Long sid,
			Long soNbr, String remark, Short priority) {
		this.servId = servId;
		this.groupId = groupId;
		this.validDate = validDate;
		this.groupType = groupType;
		this.property = property;
		this.regionCode = regionCode;
		this.beginDate = beginDate;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
		this.remark = remark;
		this.priority = priority;
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
	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	@Id
	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Column(name = "GROUP_TYPE", nullable = false, precision = 2, scale = 0)
	public Byte getGroupType() {
		return this.groupType;
	}

	public void setGroupType(Byte groupType) {
		this.groupType = groupType;
	}

	@Column(name = "PROPERTY", length = 20)
	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
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

	@Column(name = "PRIORITY", precision = 4, scale = 0)
	public Short getPriority() {
		return this.priority;
	}

	public void setPriority(Short priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("servId",getServId())
			.append("beginDate",getBeginDate())
			.append("sid",getSid())
			.append("property",getProperty())
			.append("soNbr",getSoNbr())
			.append("expireDate",getExpireDate())
			.append("remark",getRemark())
			.append("validDate",getValidDate())
			.append("groupId",getGroupId())
			.append("groupType",getGroupType())
			.append("priority",getPriority())
			.append("regionCode",getRegionCode())
			.toString();
	}

	public static class IGroupMember0101Id implements java.io.Serializable {

		// Fields

		private Long servId;
		private Long groupId;
		private Date validDate;

		// Constructors

		/** default constructor */
		public IGroupMember0101Id() {
		}

		/** full constructor */
		public IGroupMember0101Id(Long servId, Long groupId, Date validDate) {
			this.servId = servId;
			this.groupId = groupId;
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

		@Column(name = "GROUP_ID", nullable = false, precision = 14, scale = 0)
		public Long getGroupId() {
			return this.groupId;
		}

		public void setGroupId(Long groupId) {
			this.groupId = groupId;
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
			if ( !(other instanceof IGroupMember0101Id) ) return false;
			IGroupMember0101Id castOther = (IGroupMember0101Id) other;
			return new EqualsBuilder()
				.append(this.getValidDate(), castOther.getValidDate())
				.append(this.getServId(), castOther.getServId())
				.append(this.getGroupId(), castOther.getGroupId())
				.isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder()
				.append(getValidDate())
				.append(getServId())
				.append(getGroupId())
				.toHashCode();
		}
	}
}