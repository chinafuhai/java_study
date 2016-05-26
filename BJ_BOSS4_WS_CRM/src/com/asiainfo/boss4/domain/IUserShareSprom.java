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
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable;

/**
 * IUserShareSprom0105 entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
//@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_SHARE_SPROM", schema = "ZG")
@IdClass(IUserShareSprom.IUserShareSpromId.class)
@PartitionNameForTable
@PartitionNameForTable.RegionCode
@Backup.CopyToSuffix(isIgnore = true)
@CommonDao(fieldOfSelectConditions = { "servId", "groupId", "spromId", "soId", "serviceId", "expireDate" }, fieldOfDBSelectConditions={"serv_id","group_id", "sprom_id", "so_id", "service_id", "expire_date"}, isAlertWhenExist=true)
public class IUserShareSprom extends BaseEntity implements java.io.Serializable {

	// Fields
	private Long servId;
	private Long groupId;
	private Integer spromId;
	private Long soId;
	private Short regionCode;
	private Integer serviceId;
	private Date validDate;
	private Date expireDate;
	private Long soNbr;
	private Long crmProdId;

	// Constructors

	/** default constructor */
	public IUserShareSprom() {
	}

	/** minimal constructor */
	public IUserShareSprom(Long servId, Long groupId, Integer spromId,
			Long soId, Integer serviceId,
			Date validDate, Date expireDate, Long soNbr, Long crmProdId) {
		this.servId = servId;
		this.groupId = groupId;
		this.spromId = spromId;
		this.soId = soId;
		this.serviceId = serviceId;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.soNbr = soNbr;
		this.crmProdId = crmProdId;
	}

	/** full constructor */
	public IUserShareSprom(Long servId, Long groupId, Integer spromId,
			Long soId, Short regionCode,
			Integer serviceId, Date validDate, Date expireDate, Long soNbr, Long crmProdId) {
		this.servId = servId;
		this.groupId = groupId;
		this.spromId = spromId;
		this.soId = soId;
		this.regionCode = regionCode;
		this.serviceId = serviceId;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.soNbr = soNbr;
		this.crmProdId = crmProdId;
	}

	// Property accessors
	
	@Id
	public Long getServId() {
		return this.servId;
	}

	public void setServId(Long servId) {
		this.servId = servId;
	}

	@Id
	public Long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	@Id
	public Integer getSpromId() {
		return this.spromId;
	}

	public void setSpromId(Integer spromId) {
		this.spromId = spromId;
	}

	@Id
	public Long getSoId() {
		return this.soId;
	}

	public void setSoId(Long soId) {
		this.soId = soId;
	}

	@Column(name = "REGION_CODE", precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Id
	public Integer getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
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
	
	@Column(name = "SO_NBR", nullable = false, precision = 15, scale = 0)
	public Long getSoNbr() {
		return this.soNbr;
	}

	public void setSoNbr(Long soNbr) {
		this.soNbr = soNbr;
	}
	
	@Column(name = "CRM_PROD_ID", nullable = false, precision = 12, scale = 0)
	public Long getCrmProdId() {
		return crmProdId;
	}

	public void setCrmProdId(Long crmProdId) {
		this.crmProdId = crmProdId;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("validDate",getValidDate())
			.append("servId",getServId())
			.append("groupId",getGroupId())
			.append("spromId",getSpromId())
			.append("serviceId",getServiceId())
			.append("expireDate",getExpireDate())
			.append("soId",getSoId())
			.append("regionCode",getRegionCode())
			.append("soNbr",getSoNbr())
			.append("crmProdId",getCrmProdId())
			.toString();
	}

	public static class IUserShareSpromId implements java.io.Serializable {

		// Fields

		private Long servId;
		private Long groupId;
		private Integer spromId;
		private Long soId;
		private Integer serviceId;

		// Constructors

		/** default constructor */
		public IUserShareSpromId() {
		}

		/** full constructor */
		public IUserShareSpromId(Long servId, Long groupId, Integer spromId,
				Long soId, Integer serviceId) {
			this.servId = servId;
			this.groupId = groupId;
			this.spromId = spromId;
			this.soId = soId;
			this.serviceId = serviceId;
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

		@Column(name = "SPROM_ID", nullable = false, precision = 8, scale = 0)
		public Integer getSpromId() {
			return this.spromId;
		}

		public void setSpromId(Integer spromId) {
			this.spromId = spromId;
		}

		@Column(name = "SO_ID", nullable = false, precision = 15, scale = 0)
		public Long getSoId() {
			return this.soId;
		}

		public void setSoId(Long soId) {
			this.soId = soId;
		}
		
		@Column(name = "SERVICE_ID", nullable = false, precision = 8, scale = 0)
		public Integer getServiceId() {
			return this.serviceId;
		}
		
		public void setServiceId(Integer serviceId) {
			this.serviceId = serviceId;
		}

		public boolean equals(Object other) {
			if ( !(other instanceof IUserShareSpromId) ) return false;
			IUserShareSpromId castOther = (IUserShareSpromId) other;
			return new EqualsBuilder()
				.append(this.getServId(), castOther.getServId())
				.append(this.getGroupId(), castOther.getGroupId())
				.append(this.getSpromId(), castOther.getSpromId())
				.append(this.getSoId(), castOther.getSoId())
				.append(this.getServiceId(), castOther.getServiceId())
				.isEquals();
		}

		public int hashCode() {
			return new HashCodeBuilder()
				.append(getServId())
				.append(getGroupId())
				.append(getSpromId())
				.append(getSoId())
				.append(getServiceId())
				.toHashCode();
		}

	}
	
	@Override
	public BaseEntity modifyExpireDate(ServiceContext context) {
		Object iUserShareSprom = context.getBusinessDao().getEntity(this, this.getFieldOfSelectConditionsOnCommonDaoAnnotation());
		//家庭群组业务停机可取消业务,停机状态下,能取消群主IGroupMember
		if (iUserShareSprom == null)  {
			return this;
		}
		return super.modifyExpireDate(context);
	}

}