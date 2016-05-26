package com.asiainfo.boss4.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable.OperatedField;

/**
 * IGroupMemberExterior entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
//@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_GROUP_MEMBER_EXTERIOR", schema = "ZG")
@PartitionNameForTable(operatedField=OperatedField.PHONE_NUMBER)
@PartitionNameForTable.RegionCode(operatedField = OperatedField.PHONE_NUMBER)
@Backup.CopyToSuffix(isIgnore = true)
@CommonDao(fieldOfSelectConditions = { "phoneNumber", "groupId","validDate" },fieldOfDBSelectConditions={"phone_number","group_id","valid_date"})
public class IGroupMemberExterior extends BaseEntity implements java.io.Serializable {

	// Fields

	private String phoneNumber;
	private Byte groupType;
	private Long groupId;
	private String property;
	private Date validDate;
	private Date expireDate;
	private Long sid;
	private Long soNbr;
	private String remark;
	private Short regionCode;

	// Constructors

	/** default constructor */
	public IGroupMemberExterior() {
	}

	/** minimal constructor */
	public IGroupMemberExterior(String phoneNumber, Long groupId,
			Date validDate, Date expireDate, Long sid, Long soNbr,
			Short regionCode) {
		this.phoneNumber = phoneNumber;
		this.groupId = groupId;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
		this.regionCode = regionCode;
	}

	/** full constructor */
	public IGroupMemberExterior(String phoneNumber, Byte groupType,
			Long groupId, String property, Date validDate, Date expireDate,
			Long sid, Long soNbr, String remark, Short regionCode) {
		this.phoneNumber = phoneNumber;
		this.groupType = groupType;
		this.groupId = groupId;
		this.property = property;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
		this.remark = remark;
		this.regionCode = regionCode;
	}

	// Property accessors

	@Column(name = "PHONE_NUMBER", nullable = false, length = 15)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "GROUP_TYPE", precision = 2, scale = 0)
	public Byte getGroupType() {
		return this.groupType;
	}

	public void setGroupType(Byte groupType) {
		this.groupType = groupType;
	}

	@Column(name = "GROUP_ID", nullable = false, precision = 12, scale = 0)
	public Long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	@Column(name = "PROPERTY", length = 20)
	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
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

	// TODO 此表无主键，待确认，此处标记ID是为了防止hibernate报错
	@Id
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

	@Column(name = "REGION_CODE", nullable = false, precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Override
	public boolean equals(Object other) {
		if ( !(other instanceof IGroupMemberExterior) ) return false;
		IGroupMemberExterior castOther = (IGroupMemberExterior) other;
		return new EqualsBuilder()
			.append(this.getValidDate(), castOther.getValidDate())
			.append(this.getGroupId(), castOther.getGroupId())
			.append(this.getSid(), castOther.getSid())
			.append(this.getSoNbr(), castOther.getSoNbr())
			.append(this.getProperty(), castOther.getProperty())
			.append(this.getPhoneNumber(), castOther.getPhoneNumber())
			.append(this.getExpireDate(), castOther.getExpireDate())
			.append(this.getRemark(), castOther.getRemark())
			.append(this.getGroupType(), castOther.getGroupType())
			.append(this.getRegionCode(), castOther.getRegionCode())
			.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getValidDate())
			.append(getGroupId())
			.append(getSid())
			.append(getSoNbr())
			.append(getProperty())
			.append(getPhoneNumber())
			.append(getExpireDate())
			.append(getRemark())
			.append(getGroupType())
			.append(getRegionCode())
			.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("validDate",getValidDate())
			.append("groupId",getGroupId())
			.append("sid",getSid())
			.append("soNbr",getSoNbr())
			.append("property",getProperty())
			.append("phoneNumber",getPhoneNumber())
			.append("expireDate",getExpireDate())
			.append("remark",getRemark())
			.append("groupType",getGroupType())
			.append("regionCode",getRegionCode())
			.toString();
	}
	
	@Override
	public BaseEntity add(ServiceContext context) {
		IGroupMemberExterior groupMemberExterior = (IGroupMemberExterior)context.getBusinessDao().getEntity(this, new String[]{"phoneNumber", "groupId","validDate"});
		if (groupMemberExterior == null)
			return super.add(context);
		else if (groupMemberExterior.getExpireDate().compareTo(this.getValidDate()) == 0
				||groupMemberExterior.getValidDate().compareTo(this.getValidDate()) == 0)
		{
			BeanCopyHelper.copyBeanNotNullPropertyCrm(groupMemberExterior, this);
			groupMemberExterior.setExpireDate(this.getExpireDate());
			context.getBusinessDao().update(groupMemberExterior);
		}
		else
			return super.add(context);
		return groupMemberExterior;
	}
}