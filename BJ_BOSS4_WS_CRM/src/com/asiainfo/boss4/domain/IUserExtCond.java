package com.asiainfo.boss4.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.OperateType;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.UpFieldUtil;
import com.asiainfo.boss4.support.annotation.AllowUpdateMultiRow;
import com.asiainfo.boss4.support.annotation.AllowUpdateZeroRow;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;

/**
 * IUserEnterprise entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_EXT_COND", schema = "ZG")
@IdClass(IUserExtCond.IUserExtCondId.class)
@Backup.CopyToSuffix(suffixes = {Backup.CopyToSuffix.HIS})
@AllowUpdateZeroRow
@AllowUpdateMultiRow
@CommonDao(fieldOfSelectConditions = {"servId","condType","billMonth"},fieldOfDBSelectConditions={"serv_id","cond_type","bill_month"}, isOverwriteWhenAdd = true, dataStoreMode = DataStoreMode.DIRECT_UPDATE)
public class IUserExtCond extends BaseEntity implements java.io.Serializable {

	// Fields

	private Short regionCode;
	private Short condType;
	private Integer billMonth;
	private Long servId;
	private Long condValue1;
	private String condValue2;
	private Date createDate;
	private Date validDate;
	private Date expireDate;
	
	private Byte operType = Byte.valueOf(OperateType.ADD.getTypeCode());
	// Constructors

	/** default constructor */
	public IUserExtCond() {
	}

	/** minimal constructor */
	public IUserExtCond(Short regionCode, Short condType, Integer billMonth,
			Long servId, Date createDate, Date validDate, Date expireDate) {
		this.servId = servId;
		this.condType = condType;
		this.billMonth = billMonth;
		this.createDate = createDate;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.regionCode = regionCode;

	}

	/** full constructor */
	public IUserExtCond(Short regionCode, Short condType, Integer billMonth,
			Long servId, Long condValue1, String condValue2, Date createDate, Date validDate, Date expireDate) {
		this.servId = servId;
		this.condType = condType;
		this.billMonth = billMonth;
		this.createDate = createDate;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.regionCode = regionCode;
		this.condValue1 = condValue1;
		this.condValue2 = condValue2;
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
	public Short getCondType() {
		return condType;
	}

	public void setCondType(Short condType) {
		this.condType = condType;
	}

	@Id
	public Integer getBillMonth() {
		return billMonth;
	}

	public void setBillMonth(Integer billMonth) {
		this.billMonth = billMonth;
	}

	@Id
	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
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
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Create_DATE", nullable = false, length = 7)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "Cond_Value1", precision = 14, scale = 0)
	public Long getCondValue1() {
		return this.condValue1;
	}

	public void setCondValue1(Long condValue1) {
		this.condValue1 = condValue1;
	}

	@Column(name = "Cond_Value2", length = 78)
	public String getCondValue2() {
		return this.condValue2;
	}

	public void setCondValue2(String condValue2) {
		this.condValue2 = condValue2;
	}
	
	@Transient
	public OperateType getTheOperateType() {
		return OperateType.ADD;
	}

	@Transient
	public Byte getOperType() {
		return operType;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("condType",getCondType())
			.append("regionCode",getRegionCode())
			.append("billMonth",getBillMonth())
			.append("servId",getServId())
			.append("expireDate",getExpireDate())
			.append("validDate",getValidDate())
			.append("condValue1",getCondValue1())
			.append("condValue2",getCondValue2())
			.append("creaateDate",getCreateDate())
			.toString();
	}

	public static class IUserExtCondId implements java.io.Serializable {

		// Fields

		private Long servId;
		private Short condType;
		private Integer billMonth;
		private Date validDate;
		
		// Constructors

		/** default constructor */
		public IUserExtCondId() {
		}

		/** full constructor */
		public IUserExtCondId(Long servId, Short condType,
				Integer billMonth, Date validDate) {
			this.servId = servId;
			this.condType = condType;
			this.billMonth = billMonth;
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

		@Column(name = "COND_TYPE", nullable = false, precision = 4, scale = 0)
		public Short getCondType() {
			return condType;
		}

		public void setCondType(Short condType) {
			this.condType = condType;
		}

		@Column(name = "BILL_MONTH", nullable = false, precision = 6, scale = 0)
		public Integer getBillMonth() {
			return billMonth;
		}

		public void setBillMonth(Integer billMonth) {
			this.billMonth = billMonth;
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
			if ( !(other instanceof IUserExtCondId) ) return false;
			IUserExtCondId castOther = (IUserExtCondId) other;
			return new EqualsBuilder()
				.append(this.getValidDate(), castOther.getValidDate())
				.append(this.getCondType(), castOther.getCondType())
				.append(this.getBillMonth(), castOther.getBillMonth())
				.append(this.getServId(), castOther.getServId())
				.isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder()
			.append(getValidDate())
			.append(getCondType())
			.append(getServId())
			.append(getBillMonth())
			.toHashCode();
		}

	}
	
	@Override
	public BaseEntity add(ServiceContext context) {
		BusinessDao dao = (BusinessDao)context.getBeanFactory().getBean("businessDao");
		ISaleOper saleOper = (ISaleOper) BeanCopyHelper.newInstance(
				"com.asiainfo.boss4.domain.partition.ISaleOper0"+this.getRegionCode().toString());
		BeanCopyHelper.copyBeanNotNullProperty(saleOper, this);
		saleOper.setSid(context.getSid());
		saleOper.setBusiCode(0);
		saleOper.setCommitDate(context.getSoDate());
		saleOper.setCountyCode((short)1000);
		saleOper.setOrgId(0);
		saleOper.setGroupId(0l);
		saleOper.setUpField(UpFieldUtil.getUpField(this, UpFieldUtil.EMPTY_UPFIELD));
		saleOper.setSoNbr(context.getSoNbr());
		dao.add(saleOper);
		return super.add(context);
	}
}