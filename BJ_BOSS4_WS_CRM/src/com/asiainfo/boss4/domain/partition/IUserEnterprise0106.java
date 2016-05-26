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

import com.asiainfo.boss4.domain.IUserEnterprise;

/**
 * IUserEnterprise0106 entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_ENTERPRISE_0106", schema = "ZG")
@IdClass(IUserEnterprise0106.IUserEnterprise0106Id.class)
public class IUserEnterprise0106 extends IUserEnterprise implements java.io.Serializable {

	// Fields

	private Long servId;
	private String spCode;
	private String serviceCode;
	private String operatorCode;
	private Date validDate;
	private Long soNbr;
	private Short regionCode;
	private Short busiType;
	private String property;
	private Byte unbalancedFlag;
	private Byte replaceFlag;
	private Date expireDate;
	private String remark;
	private Long sid;

	// Constructors

	/** default constructor */
	public IUserEnterprise0106() {
	}

	/** minimal constructor */
	public IUserEnterprise0106(Long servId, String spCode, String serviceCode,
			String operatorCode, Date validDate, Long soNbr, Short regionCode,
			String property, Byte replaceFlag) {
		this.servId = servId;
		this.spCode = spCode;
		this.serviceCode = serviceCode;
		this.operatorCode = operatorCode;
		this.validDate = validDate;
		this.soNbr = soNbr;
		this.regionCode = regionCode;
		this.property = property;
		this.replaceFlag = replaceFlag;
	}

	/** full constructor */
	public IUserEnterprise0106(Long servId, String spCode, String serviceCode,
			String operatorCode, Date validDate, Long soNbr, Short regionCode,
			Short busiType, String property, Byte unbalancedFlag,
			Byte replaceFlag, Date expireDate, String remark, Long sid) {
		this.servId = servId;
		this.spCode = spCode;
		this.serviceCode = serviceCode;
		this.operatorCode = operatorCode;
		this.validDate = validDate;
		this.soNbr = soNbr;
		this.regionCode = regionCode;
		this.busiType = busiType;
		this.property = property;
		this.unbalancedFlag = unbalancedFlag;
		this.replaceFlag = replaceFlag;
		this.expireDate = expireDate;
		this.remark = remark;
		this.sid = sid;
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
	public String getSpCode() {
		return spCode;
	}

	public void setSpCode(String spCode) {
		this.spCode = spCode;
	}

	@Id
	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	@Id
	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	@Id
	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Id
	public Long getSoNbr() {
		return soNbr;
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

	@Column(name = "BUSI_TYPE", precision = 4, scale = 0)
	public Short getBusiType() {
		return this.busiType;
	}

	public void setBusiType(Short busiType) {
		this.busiType = busiType;
	}

	@Column(name = "PROPERTY", nullable = false, length = 20)
	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	@Column(name = "UNBALANCED_FLAG", precision = 2, scale = 0)
	public Byte getUnbalancedFlag() {
		return this.unbalancedFlag;
	}

	public void setUnbalancedFlag(Byte unbalancedFlag) {
		this.unbalancedFlag = unbalancedFlag;
	}

	@Column(name = "REPLACE_FLAG", nullable = false, precision = 2, scale = 0)
	public Byte getReplaceFlag() {
		return this.replaceFlag;
	}

	public void setReplaceFlag(Byte replaceFlag) {
		this.replaceFlag = replaceFlag;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRE_DATE", length = 7)
	public Date getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "SID", precision = 12, scale = 0)
	public Long getSid() {
		return this.sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("servId",getServId())
			.append("operatorCode",getOperatorCode())
			.append("unbalancedFlag",getUnbalancedFlag())
			.append("property",getProperty())
			.append("soNbr",getSoNbr())
			.append("expireDate",getExpireDate())
			.append("remark",getRemark())
			.append("replaceFlag",getReplaceFlag())
			.append("validDate",getValidDate())
			.append("spCode",getSpCode())
			.append("serviceCode",getServiceCode())
			.append("busiType",getBusiType())
			.append("regionCode",getRegionCode())
			.append("sid",getSid())
			.toString();
	}

	public static class IUserEnterprise0106Id implements java.io.Serializable {

		// Fields

		private Long servId;
		private String spCode;
		private String serviceCode;
		private String operatorCode;
		private Date validDate;
		private Long soNbr;

		// Constructors

		/** default constructor */
		public IUserEnterprise0106Id() {
		}

		/** full constructor */
		public IUserEnterprise0106Id(Long servId, String spCode, String serviceCode,
				String operatorCode, Date validDate, Long doneCode) {
			this.servId = servId;
			this.spCode = spCode;
			this.serviceCode = serviceCode;
			this.operatorCode = operatorCode;
			this.validDate = validDate;
			this.soNbr = doneCode;
		}

		// Property accessors

		@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
		public Long getServId() {
			return this.servId;
		}

		public void setServId(Long servId) {
			this.servId = servId;
		}

		@Column(name = "SP_CODE", nullable = false, length = 32)
		public String getSpCode() {
			return this.spCode;
		}

		public void setSpCode(String spCode) {
			this.spCode = spCode;
		}

		@Column(name = "SERVICE_CODE", nullable = false, length = 32)
		public String getServiceCode() {
			return this.serviceCode;
		}

		public void setServiceCode(String serviceCode) {
			this.serviceCode = serviceCode;
		}

		@Column(name = "OPERATOR_CODE", nullable = false, length = 32)
		public String getOperatorCode() {
			return this.operatorCode;
		}

		public void setOperatorCode(String operatorCode) {
			this.operatorCode = operatorCode;
		}

		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "VALID_DATE", nullable = false, length = 7)
		public Date getValidDate() {
			return this.validDate;
		}

		public void setValidDate(Date validDate) {
			this.validDate = validDate;
		}

		@Column(name = "SO_NBR", nullable = false, precision = 15, scale = 0)
		public Long getSoNbr() {
			return soNbr;
		}
	
		public void setSoNbr(Long soNbr) {
			this.soNbr = soNbr;
		}

		@Override
		public boolean equals(Object other) {
			if ( !(other instanceof IUserEnterprise0106Id) ) return false;
			IUserEnterprise0106Id castOther = (IUserEnterprise0106Id) other;
			return new EqualsBuilder()
				.append(this.getValidDate(), castOther.getValidDate())
				.append(this.getSpCode(), castOther.getSpCode())
				.append(this.getServId(), castOther.getServId())
				.append(this.getOperatorCode(), castOther.getOperatorCode())
				.append(this.getSoNbr(), castOther.getSoNbr())
				.append(this.getServiceCode(), castOther.getServiceCode())
				.isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder()
			.append(getValidDate())
			.append(getSpCode())
			.append(getServId())
			.append(getOperatorCode())
			.append(getSoNbr())
			.append(getServiceCode())
			.toHashCode();
		}

	}
}