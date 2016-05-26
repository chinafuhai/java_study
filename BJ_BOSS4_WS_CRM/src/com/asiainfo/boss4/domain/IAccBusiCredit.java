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

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.dao.IAccBusiCreditDao;
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.BrandType;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.annotation.AllowUpdateMultiRow;
import com.asiainfo.boss4.support.annotation.AllowUpdateZeroRow;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.Change;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable.OperatedField;

/**
 * IAccBusiCredit entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
//@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_ACC_BUSI_CREDIT", schema = "ZG")
@IdClass(IAccBusiCredit.IAccBusiCreditId.class)
@PartitionNameForTable(operatedField=OperatedField.ACCT_ID)
@PartitionNameForTable.RegionCode(operatedField = OperatedField.ACCT_ID)
@AllowUpdateZeroRow
@AllowUpdateMultiRow
@Change(type = Change.Type.UPDATE)
@Backup.CopyToSuffix
@CommonDao(fieldOfSelectConditions = {"acctId", "servId"},fieldOfDBSelectConditions={"acct_id","serv_id"}, dataStoreMode = DataStoreMode.DIRECT_UPDATE)
public class IAccBusiCredit extends BaseEntity implements java.io.Serializable {

	// Fields

	private Long acctId;
	private Integer serviceId;
	private Long busiCredit;
	private Long sid;
	private Long soNbr;
	private String remark;
	private Integer creditLevel;
	private Short regionCode;
	private Date validDate;
	private Date expireDate;
	private Long servId;

	// Constructors

	/** default constructor */
	public IAccBusiCredit() {
	}

	/** minimal constructor */
	public IAccBusiCredit(Long acctId, Integer serviceId, Long busiCredit, Long sid, Long soNbr,
			Integer creditLevel, Short regionCode) {
		this.acctId = acctId;
		this.serviceId = serviceId;
		this.busiCredit = busiCredit;
		this.sid = sid;
		this.soNbr = soNbr;
		this.creditLevel = creditLevel;
		this.regionCode = regionCode;
	}

	/** full constructor */
	public IAccBusiCredit(Long acctId, Integer serviceId, Long busiCredit, Long sid, Long soNbr,
			String remark, Integer creditLevel, Short regionCode, Date validDate, Date expireDate, Long servId) {
		this.acctId = acctId;
		this.serviceId = serviceId;
		this.busiCredit = busiCredit;
		this.sid = sid;
		this.soNbr = soNbr;
		this.remark = remark;
		this.creditLevel = creditLevel;
		this.regionCode = regionCode;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.servId = servId;
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
	public Integer getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	@Id
	public Integer getCreditLevel() {
		return this.creditLevel;
	}

	public void setCreditLevel(Integer creditLevel) {
		this.creditLevel = creditLevel;
	}
	
	@Id
	public Long getServId() {
		return servId;
	}

	public void setServId(Long servId) {
		this.servId = servId;
	}

	@Column(name = "BUSI_CREDIT", nullable = false, precision = 10, scale = 0)
	public Long getBusiCredit() {
		return this.busiCredit;
	}

	public void setBusiCredit(Long busiCredit) {
		this.busiCredit = busiCredit;
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

	@Column(name = "REGION_CODE", nullable = false, precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VALID_DATE", length = 7)
	public Date getValidDate() {
		return validDate;
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
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("busiCredit",getBusiCredit())
			.append("sid",getSid())
			.append("serviceId",getServiceId())
			.append("creditLevel",getCreditLevel())
			.append("acctId",getAcctId())
			.append("soNbr",getSoNbr())
			.append("remark",getRemark())
			.append("regionCode",getRegionCode())
			.toString();
	}
	
	public static class IAccBusiCreditId implements java.io.Serializable {

		// Fields

		private Long acctId;
		private Integer serviceId;
		private Integer creditLevel;
		private Long servId;

		// Constructors

		/** default constructor */
		public IAccBusiCreditId() {
		}

		/** full constructor */
		public IAccBusiCreditId(Long acctId, Integer serviceId, Integer creditLevel, Long servId) {
			this.acctId = acctId;
			this.serviceId = serviceId;
			this.creditLevel = creditLevel;
			this.servId = servId;
		}

		// Property accessors

		@Column(name = "ACCT_ID", nullable = false, precision = 14, scale = 0)
		public Long getAcctId() {
			return this.acctId;
		}

		public void setAcctId(Long acctId) {
			this.acctId = acctId;
		}

		@Column(name = "SERVICE_ID", nullable = false, precision = 8, scale = 0)
		public Integer getServiceId() {
			return this.serviceId;
		}

		public void setServiceId(Integer serviceId) {
			this.serviceId = serviceId;
		}

		@Column(name = "CREDIT_LEVEL", nullable = false, precision = 8, scale = 0)
		public Integer getCreditLevel() {
			return this.creditLevel;
		}

		public void setCreditLevel(Integer creditLevel) {
			this.creditLevel = creditLevel;
		}
		
		@Column(name = "SERV_ID", precision = 14, scale = 0)
		public Long getServId() {
			return servId;
		}

		public void setServId(Long servId) {
			this.servId = servId;
		}

		@Override
		public boolean equals(Object other) {
	        if ( !(other instanceof IAccBusiCreditId) ) return false;
	        IAccBusiCreditId castOther = (IAccBusiCreditId) other;
	        return new EqualsBuilder()
	            .append(this.getAcctId(), castOther.getAcctId())
	            .append(this.getServiceId(), castOther.getServiceId())
	            .append(this.getCreditLevel(), castOther.getCreditLevel())
	            .append(this.getServId(), castOther.getServId())
	            .isEquals();
	    }

		@Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getAcctId())
	            .append(getServiceId())
	            .append(getCreditLevel())
	            .append(getServId())
	            .toHashCode();
	    }
	}

	@Override
	public BaseEntity add(ServiceContext context) {
		super.add(context);
		//更新AccBookChgNotify.changeFlag
		context.needToReadjustChangeFlagOfAccBookChgNotify((byte)11);

		//尝试将账户下所有creditLevel=100的一条记录分解为creditLevel=101,102的两条记录
		this.getDao(context).detachToMultiIAccBusiCredit(this, context);
		
		return this;
	}

	@Override
	public BaseEntity cancel(ServiceContext context) {
		super.cancel(context);
		//更新AccBookChgNotify.changeFlag
		context.needToReadjustChangeFlagOfAccBookChgNotify((byte)16);

		//如果账户下仅存一对(其他用户的)creditLevel=101,102的记录，尝试合并为creditLevel=100的一条记录
		this.getDao(context).mergeToOneIAccBusiCredit(this, context);
		
		return this;
	}

	@Override
	public BaseEntity modify(ServiceContext context) {
		if (context.getBrandType().isIndividualAfterPayBrand()) {//如果目标品牌为个人后付费
			//将本用户的信用度记录creditLevel置为100(100为CRM传入)
			this.getDao(context).changeCreditLevelOfIAccBusiCredit(this);
			//尝试将账户下所有creditLevel=100的一条记录分解为creditLevel=101,102的两条记录
			this.getDao(context).detachToMultiIAccBusiCredit(this, context);
		} else {
			//将本用户的信用度记录creditLevel置为CRM传入值，如果是一对creditLevel=101,102的记录，先合并，再修改creditLevel
			this.getDao(context).mergeTwoToOne(this);
			//如果账户下仅存一对(其他用户的)creditLevel=101,102的记录，尝试合并为creditLevel=100的一条记录
			this.getDao(context).mergeToOneIAccBusiCredit(this, context);
		}
		
		//更新AccBookChgNotify.changeFlag
		context.needToReadjustChangeFlagOfAccBookChgNotify((byte)11);
		return this;
	}

	@Override
	public IAccBusiCreditDao getDao(ServiceContext context) {
		return (IAccBusiCreditDao) context.getBeanFactory().getBean("iAccBusiCreditDao");
	}
	
	
}