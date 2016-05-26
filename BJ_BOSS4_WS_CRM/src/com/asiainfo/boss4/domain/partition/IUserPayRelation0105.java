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

import com.asiainfo.boss4.domain.IUserPayRelation;

/**
 * IUserPayRelation0105 entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_PAY_RELATION_0105", schema = "ZG")
@IdClass(IUserPayRelation0105.IUserPayRelation0105Id.class)
public class IUserPayRelation0105 extends IUserPayRelation implements java.io.Serializable {

	// Fields

	private Long servId;
	private Long acctId;
	private Short useMode;
	private Integer payIndex;
	private Date validDate;
	private Short regionCode;
	private Long mainServId;
	private Short priority;
	private String property;
	private Integer partPara;
	private Date beginDate;
	private Date expireDate;
	private Long sid;
	private Long soNbr;
	private String remark;
	private Long totalFee;
	private Short controlCycle;
	private Long payMaxLim;
	private Short payPercent;
	private Byte payType;
	private Integer payItem;
	private Byte paySts;
	private Date stsDate;

	// Constructors

	/** default constructor */
	public IUserPayRelation0105() {
	}

	/** minimal constructor */
	public IUserPayRelation0105(Long servId, Long acctId, Short useMode,
			Integer payIndex, Date validDate, Short regionCode,
			Long mainServId, Short priority, Date beginDate, Date expireDate,
			Long sid, Long soNbr, Byte paySts, Date stsDate) {
		this.servId = servId;
		this.acctId = acctId;
		this.useMode = useMode;
		this.payIndex = payIndex;
		this.validDate = validDate;
		this.regionCode = regionCode;
		this.mainServId = mainServId;
		this.priority = priority;
		this.beginDate = beginDate;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
		this.paySts = paySts;
		this.stsDate = stsDate;
	}

	/** full constructor */
	public IUserPayRelation0105(Long servId, Long acctId, Short useMode,
			Integer payIndex, Date validDate, Short regionCode,
			Long mainServId, Short priority, String property, Integer partPara,
			Date beginDate, Date expireDate, Long sid, Long soNbr,
			String remark, Long totalFee, Short controlCycle, Long payMaxLim,
			Short payPercent, Byte payType, Integer payItem, Byte paySts, Date stsDate) {
		this.servId = servId;
		this.acctId = acctId;
		this.useMode = useMode;
		this.payIndex = payIndex;
		this.validDate = validDate;
		this.regionCode = regionCode;
		this.mainServId = mainServId;
		this.priority = priority;
		this.property = property;
		this.partPara = partPara;
		this.beginDate = beginDate;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
		this.remark = remark;
		this.totalFee = totalFee;
		this.controlCycle = controlCycle;
		this.payMaxLim = payMaxLim;
		this.payPercent = payPercent;
		this.payType = payType;
		this.payItem = payItem;
		this.paySts = paySts;
		this.stsDate = stsDate;
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
	public Long getAcctId() {
		return acctId;
	}

	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}

	@Id
	public Short getUseMode() {
		return useMode;
	}

	public void setUseMode(Short useMode) {
		this.useMode = useMode;
	}

	@Id
	public Integer getPayIndex() {
		return payIndex;
	}

	public void setPayIndex(Integer payIndex) {
		this.payIndex = payIndex;
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

	@Column(name = "MAIN_SERV_ID", nullable = false, precision = 12, scale = 0)
	public Long getMainServId() {
		return this.mainServId;
	}

	public void setMainServId(Long mainServId) {
		this.mainServId = mainServId;
	}

	@Column(name = "PRIORITY", nullable = false, precision = 4, scale = 0)
	public Short getPriority() {
		return this.priority;
	}

	public void setPriority(Short priority) {
		this.priority = priority;
	}

	@Column(name = "PROPERTY", length = 20)
	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	@Column(name = "PART_PARA", precision = 8, scale = 0)
	public Integer getPartPara() {
		return this.partPara;
	}

	public void setPartPara(Integer partPara) {
		this.partPara = partPara;
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

	@Column(name = "TOTAL_FEE", precision = 12, scale = 0)
	public Long getTotalFee() {
		return this.totalFee;
	}

	public void setTotalFee(Long totalFee) {
		this.totalFee = totalFee;
	}

	@Column(name = "CONTROL_CYCLE", precision = 4, scale = 0)
	public Short getControlCycle() {
		return this.controlCycle;
	}

	public void setControlCycle(Short controlCycle) {
		this.controlCycle = controlCycle;
	}

	@Column(name = "PAY_MAX_LIM", precision = 12, scale = 0)
	public Long getPayMaxLim() {
		return this.payMaxLim;
	}

	public void setPayMaxLim(Long payMaxLim) {
		this.payMaxLim = payMaxLim;
	}

	@Column(name = "PAY_PERCENT", precision = 4, scale = 0)
	public Short getPayPercent() {
		return this.payPercent;
	}

	public void setPayPercent(Short payPercent) {
		this.payPercent = payPercent;
	}

	@Column(name = "PAY_TYPE", precision = 1, scale = 0)
	public Byte getPayType() {
		return this.payType;
	}

	public void setPayType(Byte payType) {
		this.payType = payType;
	}

	@Column(name = "PAY_ITEM", precision = 8, scale = 0)
	public Integer getPayItem() {
		return this.payItem;
	}

	public void setPayItem(Integer payItem) {
		this.payItem = payItem;
	}

	@Column(name = "PAY_STS", precision = 1, scale = 0)
	public Byte getPaySts() {
		return paySts;
	}

	public void setPaySts(Byte paySts) {
		this.paySts = paySts;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STS_DATE", nullable = false, length = 7)
	public Date getStsDate() {
		return stsDate;
	}

	public void setStsDate(Date stsDate) {
		this.stsDate = stsDate;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("servId",getServId())
			.append("payItem",getPayItem())
			.append("sid",getSid())
			.append("beginDate",getBeginDate())
			.append("mainServId",getMainServId())
			.append("payMaxLim",getPayMaxLim())
			.append("useMode",getUseMode())
			.append("acctId",getAcctId())
			.append("soNbr",getSoNbr())
			.append("property",getProperty())
			.append("payPercent",getPayPercent())
			.append("controlCycle",getControlCycle())
			.append("expireDate",getExpireDate())
			.append("totalFee",getTotalFee())
			.append("remark",getRemark())
			.append("payType",getPayType())
			.append("validDate",getValidDate())
			.append("payIndex",getPayIndex())
			.append("partPara",getPartPara())
			.append("priority",getPriority())
			.append("regionCode",getRegionCode())
			.append("paySts",getPaySts())
			.append("stsDate",getStsDate())
			.toString();
	}

	public static class IUserPayRelation0105Id implements java.io.Serializable {

		// Fields

		private Long servId;
		private Long acctId;
		private Short useMode;
		private Integer payIndex;
		private Date validDate;

		// Constructors

		/** default constructor */
		public IUserPayRelation0105Id() {
		}

		/** full constructor */
		public IUserPayRelation0105Id(Long servId, Long acctId, Short useMode,
				Integer payIndex, Date validDate) {
			this.servId = servId;
			this.acctId = acctId;
			this.useMode = useMode;
			this.payIndex = payIndex;
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

		@Column(name = "ACCT_ID", nullable = false, precision = 14, scale = 0)
		public Long getAcctId() {
			return this.acctId;
		}

		public void setAcctId(Long acctId) {
			this.acctId = acctId;
		}

		@Column(name = "USE_MODE", nullable = false, precision = 4, scale = 0)
		public Short getUseMode() {
			return this.useMode;
		}

		public void setUseMode(Short useMode) {
			this.useMode = useMode;
		}

		@Column(name = "PAY_INDEX", nullable = false, precision = 8, scale = 0)
		public Integer getPayIndex() {
			return this.payIndex;
		}

		public void setPayIndex(Integer payIndex) {
			this.payIndex = payIndex;
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
			if ( !(other instanceof IUserPayRelation0105Id) ) return false;
			IUserPayRelation0105Id castOther = (IUserPayRelation0105Id) other;
			return new EqualsBuilder()
				.append(this.getValidDate(), castOther.getValidDate())
				.append(this.getServId(), castOther.getServId())
				.append(this.getPayIndex(), castOther.getPayIndex())
				.append(this.getUseMode(), castOther.getUseMode())
				.append(this.getAcctId(), castOther.getAcctId())
				.isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder()
				.append(getValidDate())
				.append(getServId())
				.append(getPayIndex())
				.append(getUseMode())
				.append(getAcctId())
				.toHashCode();
		}
	}
}