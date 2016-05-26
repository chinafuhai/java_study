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

import com.asiainfo.boss4.domain.IUserMsc;

/**
 * IUserMsc0102 entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_MSC_0102", schema = "ZG")
@IdClass(IUserMsc0102.IUserMsc0102Id.class)
public class IUserMsc0102 extends IUserMsc implements java.io.Serializable {

	// Fields

	private Long servId;
	private Integer prodId;
	private Integer busiType;
	private Date validDate;
	private Long soId;
	private Short regionCode;
	private Short funcType;
	private Integer serviceId;
	private Byte operType;
	private String funcParam;
	private String property;
	private Date beginDate;
	private Date expireDate;
	private Long sid;
	private Long soNbr;
	private Integer planId;
	private String remark;

	// Constructors

	/** default constructor */
	public IUserMsc0102() {
	}

	/** minimal constructor */
	public IUserMsc0102(Long servId, Integer prodId, Integer busiType,
			Date validDate, Long soId, Short regionCode, Short funcType,
			Integer serviceId, Byte operType, Date beginDate, Date expireDate,
			Long sid, Long soNbr) {
		this.servId = servId;
		this.prodId = prodId;
		this.busiType = busiType;
		this.validDate = validDate;
		this.soId = soId;
		this.regionCode = regionCode;
		this.funcType = funcType;
		this.serviceId = serviceId;
		this.operType = operType;
		this.beginDate = beginDate;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
	}

	/** full constructor */
	public IUserMsc0102(Long servId, Integer prodId, Integer busiType,
			Date validDate, Long soId, Short regionCode, Short funcType,
			Integer serviceId, Byte operType, String funcParam,
			String property, Date beginDate, Date expireDate, Long sid,
			Long soNbr, Integer planId, String remark) {
		this.servId = servId;
		this.prodId = prodId;
		this.busiType = busiType;
		this.validDate = validDate;
		this.soId = soId;
		this.regionCode = regionCode;
		this.funcType = funcType;
		this.serviceId = serviceId;
		this.operType = operType;
		this.funcParam = funcParam;
		this.property = property;
		this.beginDate = beginDate;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
		this.planId = planId;
		this.remark = remark;
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
	public Integer getProdId() {
		return this.prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	@Id
	public Integer getBusiType() {
		return this.busiType;
	}

	public void setBusiType(Integer busiType) {
		this.busiType = busiType;
	}

	@Id
	public Date getValidDate() {
		return this.validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Id
	public Long getSoId() {
		return this.soId;
	}

	public void setSoId(Long soId) {
		this.soId = soId;
	}

	@Column(name = "REGION_CODE", nullable = false, precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "FUNC_TYPE", nullable = false, precision = 4, scale = 0)
	public Short getFuncType() {
		return this.funcType;
	}

	public void setFuncType(Short funcType) {
		this.funcType = funcType;
	}

	@Column(name = "SERVICE_ID", nullable = false, precision = 8, scale = 0)
	public Integer getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	@Column(name = "OPER_TYPE", nullable = false, precision = 2, scale = 0)
	public Byte getOperType() {
		return this.operType;
	}

	public void setOperType(Byte operType) {
		this.operType = operType;
	}

	@Column(name = "FUNC_PARAM", length = 32)
	public String getFuncParam() {
		return this.funcParam;
	}

	public void setFuncParam(String funcParam) {
		this.funcParam = funcParam;
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

	@Column(name = "PLAN_ID", precision = 8, scale = 0)
	public Integer getPlanId() {
		return this.planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
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
            .append("servId", getServId())
            .append("prodId", getProdId())
            .append("busiType", getBusiType())
            .append("validDate", getValidDate())
            .append("regionCode",getRegionCode())
            .append("funcType",getFuncType())
            .append("serviceId",getServiceId())
            .append("operType",getOperType())
            .append("funcParam",getFuncParam())
            .append("property",getProperty())
            .append("beginDate",getBeginDate())
            .append("expireDate",getExpireDate())
            .append("sid",getSid())
            .append("soNbr",getSoNbr())
            .append("planId",getPlanId())
            .append("remark",getRemark())
            .append("soId",getSoId())
            .toString();
    }
	
	public static class IUserMsc0102Id implements java.io.Serializable {

		// Fields

		private Long servId;
		private Integer prodId;
		private Integer busiType;
		private Date validDate;
		private Long soId;

		// Constructors

		/** default constructor */
		public IUserMsc0102Id() {
		}

		/** full constructor */
		public IUserMsc0102Id(Long servId, Integer prodId, Integer busiType,
				Date validDate, Long soId) {
			this.servId = servId;
			this.prodId = prodId;
			this.busiType = busiType;
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

		@Column(name = "PROD_ID", nullable = false, precision = 8, scale = 0)
		public Integer getProdId() {
			return this.prodId;
		}

		public void setProdId(Integer prodId) {
			this.prodId = prodId;
		}

		@Column(name = "BUSI_TYPE", nullable = false, precision = 6, scale = 0)
		public Integer getBusiType() {
			return this.busiType;
		}

		public void setBusiType(Integer busiType) {
			this.busiType = busiType;
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
	        if ( !(other instanceof IUserMsc0102Id) ) return false;
	        IUserMsc0102Id castOther = (IUserMsc0102Id) other;
	        return new EqualsBuilder()
	            .append(this.getServId(), castOther.getServId())
	            .append(this.getProdId(), castOther.getProdId())
	            .append(this.getBusiType(), castOther.getBusiType())
	            .append(this.getValidDate(), castOther.getValidDate())
	            .isEquals();
	    }

		@Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getServId())
	            .append(getProdId())
	            .append(getBusiType())
	            .append(getValidDate())
	            .toHashCode();
	    }
	}

}