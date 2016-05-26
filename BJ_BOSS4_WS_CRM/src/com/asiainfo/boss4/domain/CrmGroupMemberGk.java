package com.asiainfo.boss4.domain;

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

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;



/**
 * CrmGroupMember entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "CRM_GROUP_MEMBER_GK", schema = "ZG")
@IdClass(CrmGroupMemberGk.CrmGroupMemberId.class)
@Backup.CopyToSuffix(isIgnore = true)
@CommonDao(isOverwriteWhenAdd = true, fieldOfSelectConditions = {"servId", "acctId", "subServId", "subType", "productId", "expireDate"},fieldOfDBSelectConditions={"serv_id","acct_id", "sub_serv_id", "sub_Type", "product_id", "expire_date"}, dataStoreMode = DataStoreMode.DIRECT_UPDATE)
public class CrmGroupMemberGk extends BaseEntity implements java.io.Serializable {

	// Fields

	private Long subServId;
	private Byte subType;
	private Long soId;
	private Long groupId;
	private Long acctId;
	private Long servId;
	private Long soNbr;
	private Long productId;
	private String phoneId;
	private Byte userSts;
	private Byte memberType;
	private Byte recStatus;
	private Date doneDate;
	private Date validDate;
	private Date expireDate;
	private Integer opId;
	private Integer orgId;

	// Constructors

	/** default constructor */
	public CrmGroupMemberGk() {
	}

	/** minimal constructor */
	public CrmGroupMemberGk(Long subServId, Byte subType, Long soId, Long acctId, Long servId,
			Date expireDate, Long soNbr, Long productId, String phoneId, Byte userSts,
			Byte memberType, Byte recStatus) {
		this.subServId = subServId;
		this.subType = subType;
		this.soId = soId;
		this.acctId = acctId;
		this.servId = servId;
		this.expireDate = expireDate;
		this.soNbr = soNbr;
		this.phoneId = phoneId;
		this.userSts = userSts;
		this.memberType = memberType;
		this.recStatus = recStatus;
		this.productId = productId;
	}

	/** full constructor */
	public CrmGroupMemberGk(Long subServId, Byte subType, Long soId, Long groupId, Long acctId,
			Long servId, Date expireDate, Long soNbr, String phoneId,
			Byte userSts, Byte memberType, Byte recStatus, Date doneDate,
			Date validDate, Integer opId, Integer orgId, Long productId) {
		this.subServId = subServId;
		this.subType = subType;
		this.soId = soId;
		this.groupId = groupId;
		this.acctId = acctId;
		this.servId = servId;
		this.expireDate = expireDate;
		this.soNbr = soNbr;
		this.phoneId = phoneId;
		this.userSts = userSts;
		this.memberType = memberType;
		this.recStatus = recStatus;
		this.doneDate = doneDate;
		this.validDate = validDate;
		this.opId = opId;
		this.orgId = orgId;
		this.productId = productId;
	}

	// Property accessors
	@Id
	public Long getSubServId() {
		return this.subServId;
	}

	public void setSubServId(Long subServId) {
		this.subServId = subServId;
	}

	@Id
	public Byte getSubType() {
		return this.subType;
	}

	public void setSubType(Byte subType) {
		this.subType = subType;
	}

	@Id
	public Long getSoId() {
		return this.soId;
	}

	public void setSoId(Long soId) {
		this.soId = soId;
	}

	@Column(name = "GROUP_ID", precision = 10, scale = 0)
	public Long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	@Column(name = "ACCT_ID", nullable = false, precision = 14, scale = 0)
	public Long getAcctId() {
		return this.acctId;
	}

	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}

	@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
	public Long getServId() {
		return this.servId;
	}

	public void setServId(Long servId) {
		this.servId = servId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRE_DATE", length = 7)
	public Date getExpireDate() {
		return expireDate;
	}
	
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Column(name = "SO_NBR", nullable = false, precision = 15, scale = 0)
	public Long getSoNbr() {
		return this.soNbr;
	}

	public void setSoNbr(Long soNbr) {
		this.soNbr = soNbr;
	}

	@Column(name = "PHONE_ID", nullable = false, length = 50)
	public String getPhoneId() {
		return this.phoneId;
	}

	public void setPhoneId(String phoneId) {
		this.phoneId = phoneId;
	}

	@Column(name = "USER_STS", nullable = false, precision = 2, scale = 0)
	public Byte getUserSts() {
		return this.userSts;
	}

	public void setUserSts(Byte userSts) {
		this.userSts = userSts;
	}

	@Column(name = "MEMBER_TYPE", nullable = false, precision = 2, scale = 0)
	public Byte getMemberType() {
		return this.memberType;
	}

	public void setMemberType(Byte memberType) {
		this.memberType = memberType;
	}

	@Column(name = "REC_STATUS", nullable = false, precision = 2, scale = 0)
	public Byte getRecStatus() {
		return this.recStatus;
	}

	public void setRecStatus(Byte recStatus) {
		this.recStatus = recStatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DONE_DATE", length = 7)
	public Date getDoneDate() {
		return this.doneDate;
	}

	public void setDoneDate(Date doneDate) {
		this.doneDate = doneDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VALID_DATE", length = 7)
	public Date getValidDate() {
		return this.validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Column(name = "OP_ID", precision = 8, scale = 0)
	public Integer getOpId() {
		return this.opId;
	}

	public void setOpId(Integer opId) {
		this.opId = opId;
	}

	@Column(name = "ORG_ID", precision = 8, scale = 0)
	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	
	@Column(name = "PRODUCT_ID", nullable = false, precision = 15, scale = 0)
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
		.append("servId",getServId())
		.append("subType",getSubType())
		.append("acctId",getAcctId())
		.append("phoneId",getPhoneId())
		.append("subServId",getSubServId())
		.append("validDate",getValidDate())
		.append("expireDate",getExpireDate())
		.append("memberType",getMemberType())
		.append("soNbr",getSoNbr())
		.append("groupId",getGroupId())
		.append("orgId",getOrgId())
		.append("userSts",getUserSts())
		.append("recStatus",getRecStatus())
		.append("doneDate",getDoneDate())
		.append("soId",getSoId())
		.append("opId",getOpId())
		.toString();
	}

	public static class CrmGroupMemberId implements java.io.Serializable {

		// Fields

		private Long subServId;
		private Byte subType;
		private Long soId;

		// Constructors

		/** default constructor */
		public CrmGroupMemberId() {
		}

		/** full constructor */
		public CrmGroupMemberId(Long subServId, Byte subType, Long soId) {
			this.subServId = subServId;
			this.subType = subType;
			this.soId = soId;
		}

		// Property accessors

		@Column(name = "SUB_SERV_ID", nullable = false, precision = 12, scale = 0)
		public Long getSubServId() {
			return this.subServId;
		}

		public void setSubServId(Long subServId) {
			this.subServId = subServId;
		}

		@Column(name = "SUB_TYPE", nullable = false, precision = 2, scale = 0)
		public Byte getSubType() {
			return this.subType;
		}

		public void setSubType(Byte subType) {
			this.subType = subType;
		}

		@Column(name = "SO_ID", nullable = false, precision = 15, scale = 0)
		public Long getSoId() {
			return this.soId;
		}

		public void setSoId(Long soId) {
			this.soId = soId;
		}

		@Override
		public boolean equals(Object other) {
			if ( !(other instanceof CrmGroupMemberId) ) return false;
			CrmGroupMemberId castOther = (CrmGroupMemberId) other;
			return new EqualsBuilder()
				.append(this.getSubType(), castOther.getSubType())
				.append(this.getSoId(), castOther.getSoId())
				.append(this.getSubServId(), castOther.getSubServId())
				.isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder()
			.append(getSubType())
			.append(getSoId())
			.append(getSubServId())
			.toHashCode();
		}
	}
}