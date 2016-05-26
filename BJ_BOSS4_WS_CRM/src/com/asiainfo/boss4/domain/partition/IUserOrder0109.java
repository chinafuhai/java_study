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

import com.asiainfo.boss4.domain.IUserOrder;

/**
 * IUserOrder0109 entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_ORDER_0109", schema = "ZG")
@IdClass(IUserOrder0109.IUserOrder0109Id.class)
public class IUserOrder0109 extends IUserOrder implements java.io.Serializable {

	// Fields

	private Long sid;
	private Long servId;
	private Integer busiType;
	private String msisdn;
	private Integer servType;
	private String spCode;
	private String operatorCode;
	private String thirdMsisdn;
	private String property;
	private Short regionCode;
	private Byte orderSts;
	private Date hisFirstOrderTime;
	private Date changeTime;
	private Date firstOrderTime;
	private Date lastOrderTime;
	private Date validDate;
	private Date expireDate;
	private String remark;
	private Long soNbr;
	private Integer extendFlag;
	private Byte isNew;
	private String srcType;

	// Constructors

	/** default constructor */
	public IUserOrder0109() {
	}

	/** minimal constructor */
	public IUserOrder0109(Long sid, Long servId, Integer busiType,
			String msisdn, Integer servType, String spCode,
			String operatorCode, String thirdMsisdn, Short regionCode,
			Byte orderSts, Date changeTime, Date firstOrderTime,
			Date lastOrderTime, Date validDate, Date expireDate, String srcType) {
		this.sid = sid;
		this.servId = servId;
		this.busiType = busiType;
		this.msisdn = msisdn;
		this.servType = servType;
		this.spCode = spCode;
		this.operatorCode = operatorCode;
		this.thirdMsisdn = thirdMsisdn;
		this.regionCode = regionCode;
		this.orderSts = orderSts;
		this.changeTime = changeTime;
		this.firstOrderTime = firstOrderTime;
		this.lastOrderTime = lastOrderTime;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.srcType = srcType;
	}

	/** full constructor */
	public IUserOrder0109(Long sid, Long servId, Integer busiType,
			String msisdn, Integer servType, String spCode,
			String operatorCode, String thirdMsisdn, String property,
			Short regionCode, Byte orderSts, Date hisFirstOrderTime,
			Date changeTime, Date firstOrderTime, Date lastOrderTime,
			Date validDate, Date expireDate, String remark, Long soNbr,
			Integer extendFlag, Byte isNew, String srcType) {
		this.sid = sid;
		this.servId = servId;
		this.busiType = busiType;
		this.msisdn = msisdn;
		this.servType = servType;
		this.spCode = spCode;
		this.operatorCode = operatorCode;
		this.thirdMsisdn = thirdMsisdn;
		this.property = property;
		this.regionCode = regionCode;
		this.orderSts = orderSts;
		this.hisFirstOrderTime = hisFirstOrderTime;
		this.changeTime = changeTime;
		this.firstOrderTime = firstOrderTime;
		this.lastOrderTime = lastOrderTime;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.remark = remark;
		this.soNbr = soNbr;
		this.extendFlag = extendFlag;
		this.isNew = isNew;
		this.srcType = srcType;
	}

	// Property accessors
	@Id
	public Long getSid() {
		return this.sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	@Id
	public Long getServId() {
		return this.servId;
	}

	public void setServId(Long servId) {
		this.servId = servId;
	}

	@Column(name = "BUSI_TYPE", nullable = false, precision = 6, scale = 0)
	public Integer getBusiType() {
		return this.busiType;
	}

	public void setBusiType(Integer busiType) {
		this.busiType = busiType;
	}

	@Column(name = "MSISDN", nullable = false, length = 50)
	public String getMsisdn() {
		return this.msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	@Id
	public Integer getServType() {
		return this.servType;
	}

	public void setServType(Integer servType) {
		this.servType = servType;
	}

	@Id
	public String getSpCode() {
		return this.spCode;
	}

	public void setSpCode(String spCode) {
		this.spCode = spCode;
	}

	@Id
	public String getOperatorCode() {
		return this.operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	@Id
	public String getThirdMsisdn() {
		return this.thirdMsisdn;
	}

	public void setThirdMsisdn(String thirdMsisdn) {
		this.thirdMsisdn = thirdMsisdn;
	}

	@Column(name = "PROPERTY", length = 20)
	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	@Column(name = "REGION_CODE", nullable = false, precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "ORDER_STS", nullable = false, precision = 2, scale = 0)
	public Byte getOrderSts() {
		return this.orderSts;
	}

	public void setOrderSts(Byte orderSts) {
		this.orderSts = orderSts;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "HIS_FIRST_ORDER_TIME", length = 7)
	public Date getHisFirstOrderTime() {
		return this.hisFirstOrderTime;
	}

	public void setHisFirstOrderTime(Date hisFirstOrderTime) {
		this.hisFirstOrderTime = hisFirstOrderTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CHANGE_TIME", nullable = false, length = 7)
	public Date getChangeTime() {
		return this.changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FIRST_ORDER_TIME", nullable = false, length = 7)
	public Date getFirstOrderTime() {
		return this.firstOrderTime;
	}

	public void setFirstOrderTime(Date firstOrderTime) {
		this.firstOrderTime = firstOrderTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_ORDER_TIME", nullable = false, length = 7)
	public Date getLastOrderTime() {
		return this.lastOrderTime;
	}

	public void setLastOrderTime(Date lastOrderTime) {
		this.lastOrderTime = lastOrderTime;
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

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "SO_NBR", precision = 15, scale = 0)
	public Long getSoNbr() {
		return this.soNbr;
	}

	public void setSoNbr(Long soNbr) {
		this.soNbr = soNbr;
	}

	@Column(name = "EXTEND_FLAG", precision = 8, scale = 0)
	public Integer getExtendFlag() {
		return this.extendFlag;
	}

	public void setExtendFlag(Integer extendFlag) {
		this.extendFlag = extendFlag;
	}

	@Column(name = "IS_NEW", precision = 1, scale = 0)
	public Byte getIsNew() {
		return this.isNew;
	}

	public void setIsNew(Byte isNew) {
		this.isNew = isNew;
	}

	@Column(name = "SRC_TYPE", nullable = false, length = 64)
	public String getSrcType() {
		return this.srcType;
	}

	public void setSrcType(String srcType) {
		this.srcType = srcType;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("servId",getServId())
			.append("operatorCode",getOperatorCode())
			.append("sid",getSid())
			.append("thirdMsisdn",getThirdMsisdn())
			.append("changeTime",getChangeTime())
			.append("soNbr",getSoNbr())
			.append("property",getProperty())
			.append("isNew",getIsNew())
			.append("expireDate",getExpireDate())
			.append("remark",getRemark())
			.append("validDate",getValidDate())
			.append("spCode",getSpCode())
			.append("servType",getServType())
			.append("extendFlag",getExtendFlag())
			.append("msisdn",getMsisdn())
			.append("srcType",getSrcType())
			.append("firstOrderTime",getFirstOrderTime())
			.append("lastOrderTime",getLastOrderTime())
			.append("hisFirstOrderTime",getHisFirstOrderTime())
			.append("busiType",getBusiType())
			.append("orderSts",getOrderSts())
			.append("regionCode",getRegionCode())
			.toString();
	}
	
	public static class IUserOrder0109Id implements java.io.Serializable {
		// Fields

		private Long sid;
		private Long servId;
		private Integer servType;
		private String spCode;
		private String operatorCode;
		private String thirdMsisdn;

		// Constructors

		/** default constructor */
		public IUserOrder0109Id() {
		}

		/** full constructor */
		public IUserOrder0109Id(Long sid, Long servId, Integer servType, String spCode, String operatorCode, String thirdMsisdn) {
			this.sid = sid;
			this.servId = servId;
			this.servType = servType;
			this.spCode = spCode;
			this.operatorCode = operatorCode;
			this.thirdMsisdn = thirdMsisdn;
		}

		// Property accessors
		
		@Column(name = "SID", unique = true, nullable = false, precision = 12, scale = 0)
		public Long getSid() {
			return this.sid;
		}

		public void setSid(Long sid) {
			this.sid = sid;
		}
		
		@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
		public Long getServId() {
			return this.servId;
		}

		public void setServId(Long servId) {
			this.servId = servId;
		}
		
		@Column(name = "SERV_TYPE", nullable = false, precision = 8, scale = 0)
		public Integer getServType() {
			return this.servType;
		}

		public void setServType(Integer servType) {
			this.servType = servType;
		}

		@Column(name = "SP_CODE", nullable = false, length = 32)
		public String getSpCode() {
			return this.spCode;
		}

		public void setSpCode(String spCode) {
			this.spCode = spCode;
		}

		@Column(name = "OPERATOR_CODE", nullable = false, length = 32)
		public String getOperatorCode() {
			return this.operatorCode;
		}

		public void setOperatorCode(String operatorCode) {
			this.operatorCode = operatorCode;
		}
		
		@Column(name = "THIRD_MSISDN", nullable = false, length = 50)
		public String getThirdMsisdn() {
			return this.thirdMsisdn;
		}

		public void setThirdMsisdn(String thirdMsisdn) {
			this.thirdMsisdn = thirdMsisdn;
		}

		@Override
		public boolean equals(Object other) {
			if (!(other instanceof IUserOrder0109Id))
				return false;
			IUserOrder0109Id castOther = (IUserOrder0109Id) other;
			return new EqualsBuilder()
					.append(this.getSid(), castOther.getSid())
					.append(this.getServId(), castOther.getServId())
					.append(this.getServType(), castOther.getServType())
					.append(this.getSpCode(), castOther.getSpCode())
					.append(this.getOperatorCode(), castOther.getOperatorCode())
					.append(this.getThirdMsisdn(), castOther.getThirdMsisdn()).isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder()
					.append(getSid())
					.append(getServId())
					.append(getServType())
					.append(getSpCode())
					.append(getOperatorCode())
					.append(getThirdMsisdn())
					.toHashCode();
		}
	}
}