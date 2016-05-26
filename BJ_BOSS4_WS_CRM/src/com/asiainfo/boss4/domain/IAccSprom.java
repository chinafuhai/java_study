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
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable.OperatedField;

@SuppressWarnings("serial")
//@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_ACC_SPROM", schema = "ZG")
@IdClass(IAccSprom.IAccSpromId.class)
@PartitionNameForTable(operatedField=OperatedField.ACCT_ID)
@PartitionNameForTable.RegionCode(operatedField = OperatedField.ACCT_ID)
@Backup.CopyToSuffix(isIgnore = true)
@CommonDao(fieldOfSelectConditions = { "acctId", "spromId", "soId","expireDate" },fieldOfDBSelectConditions={"acct_id","sprom_id","so_id","expire_date"},isAlertWhenExist = true,isAlertWhenNotExist = true)
public class IAccSprom extends BaseEntity implements java.io.Serializable {
	// Fields

	private Long acctId;
	private Short regionCode;
	private Integer spromType;
	private Integer spromId;
	private Integer serviceId;
	private Integer busiType;
	private Byte spromPrior;
	private String spromPara;
	private Byte payMode;
	private String property;
	private Byte operType;
	private Date validDate;
	private Date expireDate;
	private Long sid;
	private Long soNbr;
	private Long soId;
	private Date beginDate;
	private String remark;
	/**
	 * 不映射到表字段，仅用于保存报文中的提交时间
	 */
	
	// Constructors

	/** default constructor */
	public IAccSprom() {
	}

	/** minimal constructor */
	public IAccSprom(Long acctId, Integer spromId, Integer serviceId, Byte operType,
			Date validDate, Long soId,  Integer busiType,
			Byte spromPrior, Date beginDate, Date expireDate, Long sid,
			Long soNbr) {
		this.acctId = acctId;
		this.spromId = spromId;
		this.serviceId = serviceId;
		this.operType = operType;
		this.validDate = validDate;
		this.soId = soId;
		this.busiType = busiType;
		this.spromPrior = spromPrior;
		this.beginDate = beginDate;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
	}

	/** full constructor */
	public IAccSprom(Long acctId, Integer spromId, Integer serviceId, Byte operType,
			Date validDate, Long soId, Short regionCode,
			Integer spromType, Integer busiType, Byte spromPrior,
			String spromPara, Byte payMode, String property, Date beginDate,
			Date expireDate, Long sid, Long soNbr, 
			String remark ) {
		this.acctId = acctId;
		this.spromId = spromId;
		this.serviceId = serviceId;
		this.operType = operType;
		this.validDate = validDate;
		this.soId = soId;
		this.regionCode = regionCode;
		this.spromType = spromType;
		this.busiType = busiType;
		this.spromPrior = spromPrior;
		this.spromPara = spromPara;
		this.payMode = payMode;
		this.property = property;
		this.beginDate = beginDate;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
		this.remark = remark;
	}

	// Property accessors
	
	@Id
	public Long getAcctId() {
		return acctId;
	}

	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}

	@Id
	public Integer getSpromId() {
		return spromId;
	}

	public void setSpromId(Integer spromId) {
		this.spromId = spromId;
	}

	@Id
	public Byte getOperType() {
		return operType;
	}

	public void setOperType(Byte operType) {
		this.operType = operType;
	}

	@Id
	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Id
	public Long getSoId() {
		return soId;
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

	@Column(name = "SPROM_TYPE", precision = 6, scale = 0)
	public Integer getSpromType() {
		return this.spromType;
	}

	public void setSpromType(Integer spromType) {
		this.spromType = spromType;
	}

	@Column(name = "BUSI_TYPE", nullable = false, precision = 6, scale = 0)
	public Integer getBusiType() {
		return this.busiType;
	}

	public void setBusiType(Integer busiType) {
		this.busiType = busiType;
	}

	@Column(name = "SPROM_PRIOR", nullable = false, precision = 2, scale = 0)
	public Byte getSpromPrior() {
		return this.spromPrior;
	}

	public void setSpromPrior(Byte spromPrior) {
		this.spromPrior = spromPrior;
	}

	@Column(name = "SPROM_PARA", length = 32)
	public String getSpromPara() {
		return this.spromPara;
	}

	public void setSpromPara(String spromPara) {
		this.spromPara = spromPara;
	}

	@Column(name = "PAY_MODE", precision = 1, scale = 0)
	public Byte getPayMode() {
		return this.payMode;
	}

	public void setPayMode(Byte payMode) {
		this.payMode = payMode;
	}

	@Column(name = "PROPERTY", length = 20)
	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
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

	@Column(name = "SERVICE_ID", nullable = false, precision = 8, scale = 0)
	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	@Override
	public BaseEntity rollBack(ServiceContext context) {
		throw new BossException(StatusCode.ROLLBACK_ENTITY_ERROR, StatusCode.ROLLBACK_ENTITY_ERROR.getDescription());
	}
	
	@Override
	public String toString() {
        return new ToStringBuilder(this)
            .append("acctId", getAcctId())
            .append("spromId", getSpromId())
            .append("serviceId",getServiceId())
            .append("validDate", getValidDate())
            .append("operType", getOperType())
            .append("regionCode",getRegionCode())
            .append("spromType",getSpromType())
            .append("busiType",getBusiType())
            .append("spromPrior",getSpromPrior())
            .append("spromPara",getSpromPara())
            .append("payMode",getPayMode())
            .append("property",getProperty())
            .append("beginDate",getBeginDate())
            .append("expireDate",getExpireDate())
            .append("sid",getSid())
            .append("soNbr",getSoNbr())
            .append("remark",getRemark())
            .append("soId",getSoId())
            .toString();
    }
	
	public static class IAccSpromId implements java.io.Serializable {

		// Fields

		private Long acctId;
		private Integer spromId;
		private Byte operType;
		private Date validDate;
		private Long soId;

		// Constructors

		/** default constructor */
		public IAccSpromId() {
		}

		/** full constructor */
		public IAccSpromId(Long acctId, Integer spromId, Byte operType,
				Date validDate, Long soId) {
			this.acctId = acctId;
			this.spromId = spromId;
			this.operType = operType;
			this.validDate = validDate;
			this.soId = soId;
		}

		// Property accessors

		@Column(name = "ACCT_ID", nullable = false, precision = 14, scale = 0)
		public Long getAcctId() {
			return this.acctId;
		}

		public void setAcctId(Long acctId) {
			this.acctId = acctId;
		}

		@Column(name = "SPROM_ID", nullable = false, precision = 8, scale = 0)
		public Integer getSpromId() {
			return this.spromId;
		}

		public void setSpromId(Integer spromId) {
			this.spromId = spromId;
		}

		@Column(name = "OPER_TYPE", nullable = false, precision = 2, scale = 0)
		public Byte getOperType() {
			return this.operType;
		}

		public void setOperType(Byte operType) {
			this.operType = operType;
		}

		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "VALID_DATE", nullable = false, length = 7)
		public Date getValidDate() {
			return this.validDate;
		}

		public void setValidDate(Date validDate) {
			this.validDate = validDate;
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
	        if ( !(other instanceof IAccSpromId) ) return false;
	        IAccSpromId castOther = (IAccSpromId) other;
	        return new EqualsBuilder()
	            .append(this.getAcctId(), castOther.getAcctId())
	            .append(this.getSpromId(), castOther.getSpromId())
	            .append(this.getValidDate(), castOther.getValidDate())
	            .append(this.getOperType(), castOther.getOperType())
	            .isEquals();
	    }
		
		@Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getAcctId())
	            .append(getSpromId())
	            .append(getValidDate())
	            .append(getOperType())
	            .toHashCode();
	    }

	}
	
	@Override
	public BaseEntity modify(ServiceContext context) {
		BusinessDao dao = (BusinessDao) context.getBeanFactory().getBean("businessDao");
		IAccSprom accSprom = (IAccSprom)context.getBusinessDao().getEntity(this, new String[]{"acctId", "spromId", "soId","expireDate"});
		if (accSprom == null)
			throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
		else
		{
			BeanCopyHelper.copyBeanNotNullPropertyCrm(accSprom, this);
			dao.update(accSprom);
		}
		return accSprom;
	}
}
