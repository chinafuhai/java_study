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

import com.asiainfo.boss4.domain.IUser;

/**
 * IUser0109 entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_0109", schema = "ZG")
@IdClass(IUser0109.IUser0109Id.class)
public class IUser0109 extends IUser implements java.io.Serializable {
	
	// Fields

	private Long servId;
	private Date validDate;
	private Long sid;
	private Long soNbr;
	private String msisdn;
	private String imsi;
	private Long acctId;
	private Long custId;
	private Byte userSts;
	private Short userType;
	private Integer brand;
	private Byte prodFlag;
	private Byte billType;
	private Byte subStatus;
	private Short acctRegionCode;
	private Short regionCode;
	private Short countyCode;
	private Date createDate;
	private Date beginDate;
	private Date expireDate;
	private Byte operType;
	private String remark;
	private Short userProperty;
	private Integer specFlag;
	private Byte billCycle;
	private Byte aocFlag;
	private Long ctrlFunc;
	private Short cycleDay;
	private Short nextCycleDay;
	private Date firstUseTime;
	private Long mainServId;

	// Constructors

	/** default constructor */
	public IUser0109() {
	}

	/** minimal constructor */
	public IUser0109(Long servId, Date validDate, Long sid, Long soNbr, String msisdn, String imsi, Long acctId,
			Long custId, Byte userSts, Short userType, Short acctRegionCode,
			Short regionCode, Short countyCode, Date createDate,
			Date beginDate, Date expireDate, Byte operType, Byte billCycle,
			Byte aocFlag, Long ctrlFunc) {
		this.servId = servId;
		this.validDate = validDate;
		this.sid = sid;
		this.soNbr = soNbr;
		this.msisdn = msisdn;
		this.imsi = imsi;
		this.acctId = acctId;
		this.custId = custId;
		this.userSts = userSts;
		this.userType = userType;
		this.acctRegionCode = acctRegionCode;
		this.regionCode = regionCode;
		this.countyCode = countyCode;
		this.createDate = createDate;
		this.beginDate = beginDate;
		this.expireDate = expireDate;
		this.operType = operType;
		this.billCycle = billCycle;
		this.aocFlag = aocFlag;
		this.ctrlFunc = ctrlFunc;
	}

	/** full constructor */
	public IUser0109(Long servId, Date validDate, Long sid, Long soNbr, String msisdn, String imsi, Long acctId,
			Long custId, Byte userSts, Short userType, Integer brand,
			Byte prodFlag, Byte billType, Byte subStatus,
			Short acctRegionCode, Short regionCode, Short countyCode,
			Date createDate, Date beginDate, Date expireDate, Byte operType,
			String remark, Short userProperty, Integer specFlag,
			Byte billCycle, Byte aocFlag, Long ctrlFunc, Short cycleDay,
			Short nextCycleDay, Date firstUseTime, Long mainServId) {
		this.servId = servId;
		this.validDate = validDate;
		this.sid = sid;
		this.soNbr = soNbr;
		this.msisdn = msisdn;
		this.imsi = imsi;
		this.acctId = acctId;
		this.custId = custId;
		this.userSts = userSts;
		this.userType = userType;
		this.brand = brand;
		this.prodFlag = prodFlag;
		this.billType = billType;
		this.subStatus = subStatus;
		this.acctRegionCode = acctRegionCode;
		this.regionCode = regionCode;
		this.countyCode = countyCode;
		this.createDate = createDate;
		this.beginDate = beginDate;
		this.expireDate = expireDate;
		this.operType = operType;
		this.remark = remark;
		this.userProperty = userProperty;
		this.specFlag = specFlag;
		this.billCycle = billCycle;
		this.aocFlag = aocFlag;
		this.ctrlFunc = ctrlFunc;
		this.cycleDay = cycleDay;
		this.nextCycleDay = nextCycleDay;
		this.firstUseTime = firstUseTime;
		this.mainServId = mainServId;
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
	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}
	
	@Id
	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	@Id
	public Long getSoNbr() {
		return soNbr;
	}

	public void setSoNbr(Long soNbr) {
		this.soNbr = soNbr;
	}	

	@Column(name = "MSISDN", nullable = false, length = 15)
	public String getMsisdn() {
		return this.msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	@Column(name = "IMSI", nullable = false, length = 20)
	public String getImsi() {
		return this.imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	@Column(name = "ACCT_ID", nullable = false, precision = 14, scale = 0)
	public Long getAcctId() {
		return this.acctId;
	}

	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}

	@Column(name = "CUST_ID", nullable = false, precision = 14, scale = 0)
	public Long getCustId() {
		return this.custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	@Column(name = "USER_STS", nullable = false, precision = 2, scale = 0)
	public Byte getUserSts() {
		return this.userSts;
	}

	public void setUserSts(Byte userSts) {
		this.userSts = userSts;
	}

	@Column(name = "USER_TYPE", nullable = false, precision = 4, scale = 0)
	public Short getUserType() {
		return this.userType;
	}

	public void setUserType(Short userType) {
		this.userType = userType;
	}

	@Column(name = "BRAND", precision = 6, scale = 0)
	public Integer getBrand() {
		return this.brand;
	}

	public void setBrand(Integer brand) {
		this.brand = brand;
	}

	@Column(name = "PROD_FLAG", precision = 1, scale = 0)
	public Byte getProdFlag() {
		return this.prodFlag;
	}

	public void setProdFlag(Byte prodFlag) {
		this.prodFlag = prodFlag;
	}

	@Column(name = "BILL_TYPE", precision = 2, scale = 0)
	public Byte getBillType() {
		return this.billType;
	}

	public void setBillType(Byte billType) {
		this.billType = billType;
	}

	@Column(name = "SUB_STATUS", precision = 1, scale = 0)
	public Byte getSubStatus() {
		return this.subStatus;
	}

	public void setSubStatus(Byte subStatus) {
		this.subStatus = subStatus;
	}

	@Column(name = "ACCT_REGION_CODE", nullable = false, precision = 4, scale = 0)
	public Short getAcctRegionCode() {
		return this.acctRegionCode;
	}

	public void setAcctRegionCode(Short acctRegionCode) {
		this.acctRegionCode = acctRegionCode;
	}

	@Column(name = "REGION_CODE", nullable = false, precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "COUNTY_CODE", nullable = false, precision = 4, scale = 0)
	public Short getCountyCode() {
		return this.countyCode;
	}

	public void setCountyCode(Short countyCode) {
		this.countyCode = countyCode;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", nullable = false, length = 7)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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

	@Column(name = "OPER_TYPE", nullable = false, precision = 2, scale = 0)
	public Byte getOperType() {
		return this.operType;
	}

	public void setOperType(Byte operType) {
		this.operType = operType;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "USER_PROPERTY", precision = 4, scale = 0)
	public Short getUserProperty() {
		return this.userProperty;
	}

	public void setUserProperty(Short userProperty) {
		this.userProperty = userProperty;
	}

	@Column(name = "SPEC_FLAG", precision = 8, scale = 0)
	public Integer getSpecFlag() {
		return this.specFlag;
	}

	public void setSpecFlag(Integer specFlag) {
		this.specFlag = specFlag;
	}

	@Column(name = "BILL_CYCLE", nullable = false, precision = 2, scale = 0)
	public Byte getBillCycle() {
		return this.billCycle;
	}

	public void setBillCycle(Byte billCycle) {
		this.billCycle = billCycle;
	}

	@Column(name = "AOC_FLAG", nullable = false, precision = 2, scale = 0)
	public Byte getAocFlag() {
		return this.aocFlag;
	}

	public void setAocFlag(Byte aocFlag) {
		this.aocFlag = aocFlag;
	}

	@Column(name = "CTRL_FUNC", nullable = false, precision = 12, scale = 0)
	public Long getCtrlFunc() {
		return this.ctrlFunc;
	}

	public void setCtrlFunc(Long ctrlFunc) {
		this.ctrlFunc = ctrlFunc;
	}

	@Column(name = "CYCLE_DAY", precision = 4, scale = 0)
	public Short getCycleDay() {
		return this.cycleDay;
	}

	public void setCycleDay(Short cycleDay) {
		this.cycleDay = cycleDay;
	}

	@Column(name = "NEXT_CYCLE_DAY", precision = 4, scale = 0)
	public Short getNextCycleDay() {
		return this.nextCycleDay;
	}

	public void setNextCycleDay(Short nextCycleDay) {
		this.nextCycleDay = nextCycleDay;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FIRST_USE_TIME", length = 7)
	public Date getFirstUseTime() {
		return this.firstUseTime;
	}

	public void setFirstUseTime(Date firstUseTime) {
		this.firstUseTime = firstUseTime;
	}

	@Column(name = "MAIN_SERV_ID", precision = 12, scale = 0)
	public Long getMainServId() {
		return this.mainServId;
	}

	public void setMainServId(Long mainServId) {
		this.mainServId = mainServId;
	}

	@Override
	public String toString() {
        return new ToStringBuilder(this)
            .append("servId", getServId())
            .append("validDate", getValidDate())
            .append("sid", getSid())
            .append("soNbr", getSoNbr())
            .append("msisdn",getMsisdn())
            .append("imsi",getImsi())
            .append("acctId",getAcctId())
            .append("custId",getCustId())
            .append("userSts",getUserSts())
            .append("userType",getUserType())
            .append("brand",getBrand())
            .append("prodFlag",getProdFlag())
            .append("billType",getBillType())
            .append("subStatus",getSubStatus())
            .append("acctRegionCode",getAcctRegionCode())
            .append("regionCode",getRegionCode())
            .append("countyCode",getCountyCode())
            .append("createDate",getCreateDate())
            .append("beginDate",getBeginDate())
            .append("expireDate",getExpireDate())
            .append("operType",getOperType())
            .append("remark",getRemark())
            .append("userProperty",getUserProperty())
            .append("specFlag",getSpecFlag())
            .append("billCycle",getBillCycle())
            .append("aocFlag",getAocFlag())
            .append("ctrlFunc",getCtrlFunc())
            .append("cycleDay",getCycleDay())
            .append("nextCycleDay",getNextCycleDay())
            .append("firstUseTime",getFirstUseTime())
            .append("mainServId",getMainServId())
            .toString();
    }
	
	public static class IUser0109Id implements java.io.Serializable {
		// Fields

		private Long servId;
		private Date validDate;
		private Long sid;
		private Long soNbr;

		// Constructors

		/** default constructor */
		public IUser0109Id() {
		}

		/** full constructor */
		public IUser0109Id(Long servId, Date validDate, Long sid, Long soNbr) {
			this.servId = servId;
			this.validDate = validDate;
			this.sid = sid;
			this.soNbr = soNbr;
		}

		// Property accessors

		@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
		public Long getServId() {
			return this.servId;
		}

		public void setServId(Long servId) {
			this.servId = servId;
		}

		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "VALID_DATE", nullable = false, length = 7)
		public Date getValidDate() {
			return this.validDate;
		}

		public void setValidDate(Date validDate) {
			this.validDate = validDate;
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

		@Override
		public boolean equals(Object other) {
			if (!(other instanceof IUser0109Id))
				return false;
			IUser0109Id castOther = (IUser0109Id) other;
			return new EqualsBuilder().append(this.getServId(),
					castOther.getServId()).append(this.getValidDate(),
					castOther.getValidDate()).append(this.getSid(),
					castOther.getSid()).append(this.getSoNbr(),
					castOther.getSoNbr()).isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder().append(getServId()).append(getValidDate())
					.append(getSid()).append(getSoNbr()).toHashCode();
		}
	}
}