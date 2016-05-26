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

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable.OperatedField;

/**
 * IAcctBillCycle entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
//@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_ACCT_BILL_CYCLE", schema = "ZG")
@IdClass(IAcctBillCycle.IAcctBillCycleId.class)
@PartitionNameForTable(operatedField=OperatedField.ACCT_ID)
@PartitionNameForTable.RegionCode(operatedField = OperatedField.ACCT_ID)
@Backup.CopyToSuffix
@CommonDao(fieldOfSelectConditions = { "acctId", "expireDate"},fieldOfDBSelectConditions={"acct_id","expire_date"}, isOverwriteWhenAdd = true, dataStoreMode = DataStoreMode.DIRECT_UPDATE)
public class IAcctBillCycle extends BaseEntity implements java.io.Serializable {

	// Fields

	private Long acctId;
	private Long soNbr;
	private Short regionCode;
	private Byte cycleType;
	private Byte cycleEndday;
	private Date modifyDate;
	private Date validDate;
	private Date expireDate;
	private Long sid;
	private String remark;
	private Integer cycleLength;
	private Byte cycleProperty;

	// Constructors

	/** default constructor */
	public IAcctBillCycle() {
	}

	/** minimal constructor */
	public IAcctBillCycle(Long acctId, Long soNbr, Short regionCode,
			Byte cycleType, Byte cycleEndday, Date modifyDate, Long sid,
			Integer cycleLength, Byte cycleProperty) {
		this.acctId = acctId;
		this.soNbr = soNbr;
		this.regionCode = regionCode;
		this.cycleType = cycleType;
		this.cycleEndday = cycleEndday;
		this.modifyDate = modifyDate;
		this.sid = sid;
		this.cycleLength = cycleLength;
		this.cycleProperty = cycleProperty;
	}

	/** full constructor */
	public IAcctBillCycle(Long acctId, Long soNbr, Short regionCode,
			Byte cycleType, Byte cycleEndday, Date modifyDate, Date validDate,
			Date expireDate, Long sid, String remark, Integer cycleLength,
			Byte cycleProperty) {
		this.acctId = acctId;
		this.soNbr = soNbr;
		this.regionCode = regionCode;
		this.cycleType = cycleType;
		this.cycleEndday = cycleEndday;
		this.modifyDate = modifyDate;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.sid = sid;
		this.remark = remark;
		this.cycleLength = cycleLength;
		this.cycleProperty = cycleProperty;
	}

	// Property accessors
	@Id
	public Long getAcctId() {
		return this.acctId;
	}

	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}

	@Id
	public Long getSoNbr() {
		return this.soNbr;
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

	@Column(name = "CYCLE_TYPE", nullable = false, precision = 2, scale = 0)
	public Byte getCycleType() {
		return this.cycleType;
	}

	public void setCycleType(Byte cycleType) {
		this.cycleType = cycleType;
	}

	@Column(name = "CYCLE_ENDDAY", nullable = false, precision = 2, scale = 0)
	public Byte getCycleEndday() {
		return this.cycleEndday;
	}

	public void setCycleEndday(Byte cycleEndday) {
		this.cycleEndday = cycleEndday;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFY_DATE", nullable = false, length = 7)
	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VALID_DATE", length = 7)
	public Date getValidDate() {
		return this.validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRE_DATE", length = 7)
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

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "CYCLE_LENGTH", nullable = false, precision = 6, scale = 0)
	public Integer getCycleLength() {
		return this.cycleLength;
	}

	public void setCycleLength(Integer cycleLength) {
		this.cycleLength = cycleLength;
	}

	@Column(name = "CYCLE_PROPERTY", nullable = false, precision = 2, scale = 0)
	public Byte getCycleProperty() {
		return this.cycleProperty;
	}

	public void setCycleProperty(Byte cycleProperty) {
		this.cycleProperty = cycleProperty;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
		.append("sid",getSid())
		.append("acctId",getAcctId())
		.append("soNbr",getSoNbr())
		.append("cycleEndday",getCycleEndday())
		.append("cycleType",getCycleType())
		.append("expireDate",getExpireDate())
		.append("remark",getRemark())
		.append("cycleProperty",getCycleProperty())
		.append("validDate",getValidDate())
		.append("cycleLength",getCycleLength())
		.append("modifyDate",getModifyDate())
		.append("regionCode",getRegionCode())
		.toString();
	}

	public static class IAcctBillCycleId implements java.io.Serializable {

		// Fields

		private Long acctId;
		private Long soNbr;

		// Constructors

		/** default constructor */
		public IAcctBillCycleId() {
		}

		/** full constructor */
		public IAcctBillCycleId(Long acctId, Long soNbr) {
			this.acctId = acctId;
			this.soNbr = soNbr;
		}

		// Property accessors

		@Column(name = "ACCT_ID", nullable = false, precision = 14, scale = 0)
		public Long getAcctId() {
			return this.acctId;
		}

		public void setAcctId(Long acctId) {
			this.acctId = acctId;
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
			if ( !(other instanceof IAcctBillCycleId) ) return false;
			IAcctBillCycleId castOther = (IAcctBillCycleId) other;
			return new EqualsBuilder()
				.append(this.getAcctId(), castOther.getAcctId())
				.append(this.getSoNbr(), castOther.getSoNbr())
				.isEquals();
		}
		
		@Override
		public int hashCode() {
			return new HashCodeBuilder()
			.append(getAcctId())
			.append(getSoNbr())
			.toHashCode();
		}

	}
}