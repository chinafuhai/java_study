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

import com.asiainfo.boss4.domain.IUserSprom;

/**
 * IUserSprom0108 entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_SPROM_0108", schema = "ZG")
@IdClass(IUserSprom0108.IUserSprom0108Id.class)
public class IUserSprom0108 extends IUserSprom implements java.io.Serializable {

	// Fields

	private Long servId;
	private Integer spromId;
	private Byte operType;
	private Date validDate;
	private Long soId;
	private Integer serviceId;
	private Short regionCode;
	private Integer spromType;
	private Integer busiType;
	private Byte spromPrior;
	private String spromPara;
	private Byte payMode;
	private String property;
	private Date beginDate;
	private Date expireDate;
	private Long sid;
	private Long soNbr;
	private Integer maxProm;
	private String remark;
	private Integer planId;
	private String referenceObject;
	private String resultObject;

	// Constructors

	/** default constructor */
	public IUserSprom0108() {
	}

	/** minimal constructor */
	public IUserSprom0108(Long servId, Integer spromId, Byte operType,
			Date validDate, Long soId, Integer serviceId, Integer busiType,
			Byte spromPrior, Date beginDate, Date expireDate, Long sid,
			Long soNbr) {
		this.servId = servId;
		this.spromId = spromId;
		this.operType = operType;
		this.validDate = validDate;
		this.soId = soId;
		this.serviceId = serviceId;
		this.busiType = busiType;
		this.spromPrior = spromPrior;
		this.beginDate = beginDate;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
	}

	/** full constructor */
	public IUserSprom0108(Long servId, Integer spromId, Byte operType,
			Date validDate, Long soId, Integer serviceId, Short regionCode,
			Integer spromType, Integer busiType, Byte spromPrior,
			String spromPara, Byte payMode, String property, Date beginDate,
			Date expireDate, Long sid, Long soNbr, Integer maxProm,
			String remark, Integer planId, String referenceObject,
			String resultObject) {
		this.servId = servId;
		this.spromId = spromId;
		this.operType = operType;
		this.validDate = validDate;
		this.soId = soId;
		this.serviceId = serviceId;
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
		this.maxProm = maxProm;
		this.remark = remark;
		this.planId = planId;
		this.referenceObject = referenceObject;
		this.resultObject = resultObject;
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

	@Column(name = "SERVICE_ID", nullable = false, precision = 8, scale = 0)
	public Integer getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
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

	@Column(name = "MAX_PROM", precision = 8, scale = 0)
	public Integer getMaxProm() {
		return this.maxProm;
	}

	public void setMaxProm(Integer maxProm) {
		this.maxProm = maxProm;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "PLAN_ID", precision = 8, scale = 0)
	public Integer getPlanId() {
		return this.planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	@Column(name = "REFERENCE_OBJECT")
	public String getReferenceObject() {
		return this.referenceObject;
	}

	public void setReferenceObject(String referenceObject) {
		this.referenceObject = referenceObject;
	}

	@Column(name = "RESULT_OBJECT")
	public String getResultObject() {
		return this.resultObject;
	}

	public void setResultObject(String resultObject) {
		this.resultObject = resultObject;
	}

	@Override
	public String toString() {
        return new ToStringBuilder(this)
            .append("servId", getServId())
            .append("spromId", getSpromId())
            .append("validDate", getValidDate())
            .append("operType", getOperType())
            .append("serviceId",getServiceId())
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
            .append("maxProm",getMaxProm())
            .append("remark",getRemark())
            .append("planId",getPlanId())
            .append("referenceObject",getReferenceObject())
            .append("resultObject",getResultObject())
            .append("soId",getSoId())
            .toString();
    }
	
	public static class IUserSprom0108Id implements java.io.Serializable {

		// Fields

		private Long servId;
		private Integer spromId;
		private Byte operType;
		private Date validDate;
		private Long soId;

		// Constructors

		/** default constructor */
		public IUserSprom0108Id() {
		}

		/** full constructor */
		public IUserSprom0108Id(Long servId, Integer spromId, Byte operType,
				Date validDate, Long soId) {
			this.servId = servId;
			this.spromId = spromId;
			this.operType = operType;
			this.validDate = validDate;
			this.soId = soId;
		}

		// Property accessors

		@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
		public Long getServId() {
			return this.servId;
		}

		public void setServId(Long servId) {
			this.servId = servId;
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
	        if ( !(other instanceof IUserSprom0108Id) ) return false;
	        IUserSprom0108Id castOther = (IUserSprom0108Id) other;
	        return new EqualsBuilder()
	            .append(this.getServId(), castOther.getServId())
	            .append(this.getSpromId(), castOther.getSpromId())
	            .append(this.getValidDate(), castOther.getValidDate())
	            .append(this.getOperType(), castOther.getOperType())
	            .isEquals();
	    }
		
		@Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getServId())
	            .append(getSpromId())
	            .append(getValidDate())
	            .append(getOperType())
	            .toHashCode();
	    }

	}
}