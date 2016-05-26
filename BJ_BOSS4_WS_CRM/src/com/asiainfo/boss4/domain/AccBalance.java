package com.asiainfo.boss4.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable;

/**
 * AccBalance entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
//@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "ACC_BALANCE", schema = "ZG")
@PartitionNameForTable(operatedField = PartitionNameForTable.OperatedField.ACCT_ID, baseNumber = PartitionNameForTable.BaseNumber.FROM_0101)
@CommonDao(fieldOfSelectConditions = { "acctId"}, isOverwriteWhenAdd = true, dataStoreMode = DataStoreMode.DIRECT_UPDATE)
@Backup.CopyToSuffix(isIgnore = true)
public class AccBalance extends BaseEntity implements java.io.Serializable {

	// Fields

	private Long acctId;
	private Long custId;
	private String billCycle;
	private String firstUnpayMon;
	private Long credit;
	private Long point;
	private Short countyCode;
	private Date createTime;
	private Long delayLateFee;
	private Long discountFee;
	private Long deratedFee;
	private Long adjustedFee;
	private Long refusedFee;
	private Long suspendFee;
	private Long ppyFee;
	private Long primalFee;
	private Long unpayFee;
	private Long freezePpy;
	private Long prepayAvailable;
	private Byte sts;
	private Date stsDate;
	private Long payFee;
	private Integer orgId;
	private String firstPrintMon;
	private Date minBeginDate;
	private Date cycleEndDate;

	// Constructors

	/** default constructor */
	public AccBalance() {
	}

	/** minimal constructor */
	public AccBalance(Long acctId, Long custId, String billCycle,
			String firstUnpayMon, Long credit, Long point, Short countyCode,
			Date createTime, Long delayLateFee, Long discountFee,
			Long deratedFee, Long adjustedFee, Long refusedFee,
			Long suspendFee, Long ppyFee, Long primalFee, Long unpayFee,
			Long freezePpy, Long prepayAvailable, Byte sts, Long payFee,
			String firstPrintMon) {
		this.acctId = acctId;
		this.custId = custId;
		this.billCycle = billCycle;
		this.firstUnpayMon = firstUnpayMon;
		this.credit = credit;
		this.point = point;
		this.countyCode = countyCode;
		this.createTime = createTime;
		this.delayLateFee = delayLateFee;
		this.discountFee = discountFee;
		this.deratedFee = deratedFee;
		this.adjustedFee = adjustedFee;
		this.refusedFee = refusedFee;
		this.suspendFee = suspendFee;
		this.ppyFee = ppyFee;
		this.primalFee = primalFee;
		this.unpayFee = unpayFee;
		this.freezePpy = freezePpy;
		this.prepayAvailable = prepayAvailable;
		this.sts = sts;
		this.payFee = payFee;
		this.firstPrintMon = firstPrintMon;
	}

	/** full constructor */
	public AccBalance(Long acctId, Long custId, String billCycle,
			String firstUnpayMon, Long credit, Long point, Short countyCode,
			Date createTime, Long delayLateFee, Long discountFee,
			Long deratedFee, Long adjustedFee, Long refusedFee,
			Long suspendFee, Long ppyFee, Long primalFee, Long unpayFee,
			Long freezePpy, Long prepayAvailable, Byte sts, Date stsDate,
			Long payFee, Integer orgId, String firstPrintMon, Date minBeginDate, Date cycleEndDate) {
		this.acctId = acctId;
		this.custId = custId;
		this.billCycle = billCycle;
		this.firstUnpayMon = firstUnpayMon;
		this.credit = credit;
		this.point = point;
		this.countyCode = countyCode;
		this.createTime = createTime;
		this.delayLateFee = delayLateFee;
		this.discountFee = discountFee;
		this.deratedFee = deratedFee;
		this.adjustedFee = adjustedFee;
		this.refusedFee = refusedFee;
		this.suspendFee = suspendFee;
		this.ppyFee = ppyFee;
		this.primalFee = primalFee;
		this.unpayFee = unpayFee;
		this.freezePpy = freezePpy;
		this.prepayAvailable = prepayAvailable;
		this.sts = sts;
		this.stsDate = stsDate;
		this.payFee = payFee;
		this.orgId = orgId;
		this.firstPrintMon = firstPrintMon;
		this.minBeginDate = minBeginDate;
		this.cycleEndDate = cycleEndDate;
	}

	// Property accessors
	@Id
	@Column(name = "ACCT_ID", unique = true, nullable = false, precision = 14, scale = 0)
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

	@Column(name = "BILL_CYCLE", nullable = false, length = 6)
	public String getBillCycle() {
		return this.billCycle;
	}

	public void setBillCycle(String billCycle) {
		this.billCycle = billCycle;
	}

	@Column(name = "FIRST_UNPAY_MON", nullable = false, length = 6)
	public String getFirstUnpayMon() {
		return this.firstUnpayMon;
	}

	public void setFirstUnpayMon(String firstUnpayMon) {
		this.firstUnpayMon = firstUnpayMon;
	}

	@Column(name = "CREDIT", nullable = false, precision = 12, scale = 0)
	public Long getCredit() {
		return this.credit;
	}

	public void setCredit(Long credit) {
		this.credit = credit;
	}

	@Column(name = "POINT", nullable = false, precision = 12, scale = 0)
	public Long getPoint() {
		return this.point;
	}

	public void setPoint(Long point) {
		this.point = point;
	}

	@Column(name = "COUNTY_CODE", nullable = false, precision = 4, scale = 0)
	public Short getCountyCode() {
		return this.countyCode;
	}

	public void setCountyCode(Short countyCode) {
		this.countyCode = countyCode;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_TIME", nullable = false, length = 7)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "DELAY_LATE_FEE", nullable = false, precision = 12, scale = 0)
	public Long getDelayLateFee() {
		return this.delayLateFee;
	}

	public void setDelayLateFee(Long delayLateFee) {
		this.delayLateFee = delayLateFee;
	}

	@Column(name = "DISCOUNT_FEE", nullable = false, precision = 12, scale = 0)
	public Long getDiscountFee() {
		return this.discountFee;
	}

	public void setDiscountFee(Long discountFee) {
		this.discountFee = discountFee;
	}

	@Column(name = "DERATED_FEE", nullable = false, precision = 12, scale = 0)
	public Long getDeratedFee() {
		return this.deratedFee;
	}

	public void setDeratedFee(Long deratedFee) {
		this.deratedFee = deratedFee;
	}

	@Column(name = "ADJUSTED_FEE", nullable = false, precision = 12, scale = 0)
	public Long getAdjustedFee() {
		return this.adjustedFee;
	}

	public void setAdjustedFee(Long adjustedFee) {
		this.adjustedFee = adjustedFee;
	}

	@Column(name = "REFUSED_FEE", nullable = false, precision = 12, scale = 0)
	public Long getRefusedFee() {
		return this.refusedFee;
	}

	public void setRefusedFee(Long refusedFee) {
		this.refusedFee = refusedFee;
	}

	@Column(name = "SUSPEND_FEE", nullable = false, precision = 12, scale = 0)
	public Long getSuspendFee() {
		return this.suspendFee;
	}

	public void setSuspendFee(Long suspendFee) {
		this.suspendFee = suspendFee;
	}

	@Column(name = "PPY_FEE", nullable = false, precision = 12, scale = 0)
	public Long getPpyFee() {
		return this.ppyFee;
	}

	public void setPpyFee(Long ppyFee) {
		this.ppyFee = ppyFee;
	}

	@Column(name = "PRIMAL_FEE", nullable = false, precision = 12, scale = 0)
	public Long getPrimalFee() {
		return this.primalFee;
	}

	public void setPrimalFee(Long primalFee) {
		this.primalFee = primalFee;
	}

	@Column(name = "UNPAY_FEE", nullable = false, precision = 12, scale = 0)
	public Long getUnpayFee() {
		return this.unpayFee;
	}

	public void setUnpayFee(Long unpayFee) {
		this.unpayFee = unpayFee;
	}

	@Column(name = "FREEZE_PPY", nullable = false, precision = 12, scale = 0)
	public Long getFreezePpy() {
		return this.freezePpy;
	}

	public void setFreezePpy(Long freezePpy) {
		this.freezePpy = freezePpy;
	}

	@Column(name = "PREPAY_AVAILABLE", nullable = false, precision = 12, scale = 0)
	public Long getPrepayAvailable() {
		return this.prepayAvailable;
	}

	public void setPrepayAvailable(Long prepayAvailable) {
		this.prepayAvailable = prepayAvailable;
	}

	@Column(name = "STS", nullable = false, precision = 2, scale = 0)
	public Byte getSts() {
		return this.sts;
	}

	public void setSts(Byte sts) {
		this.sts = sts;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STS_DATE", length = 7)
	public Date getStsDate() {
		return this.stsDate;
	}

	public void setStsDate(Date stsDate) {
		this.stsDate = stsDate;
	}

	@Column(name = "PAY_FEE", nullable = false, precision = 12, scale = 0)
	public Long getPayFee() {
		return this.payFee;
	}

	public void setPayFee(Long payFee) {
		this.payFee = payFee;
	}

	@Column(name = "ORG_ID", precision = 8, scale = 0)
	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	@Column(name = "FIRST_PRINT_MON", nullable = false, length = 6)
	public String getFirstPrintMon() {
		return this.firstPrintMon;
	}

	public void setFirstPrintMon(String firstPrintMon) {
		this.firstPrintMon = firstPrintMon;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MIN_BEGIN_DATE", length = 7)
	public Date getMinBeginDate() {
		return minBeginDate;
	}

	public void setMinBeginDate(Date minBeginDate) {
		this.minBeginDate = minBeginDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CYCLE_END_DATE", length = 7)
	public Date getCycleEndDate() {
		return cycleEndDate;
	}

	public void setCycleEndDate(Date cycleEndDate) {
		this.cycleEndDate = cycleEndDate;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
		.append("billCycle",getBillCycle())
		.append("custId",getCustId())
		.append("deratedFee",getDeratedFee())
		.append("prepayAvailable",getPrepayAvailable())
		.append("sts",getSts())
		.append("orgId",getOrgId())
		.append("firstUnpayMon",getFirstUnpayMon())
		.append("ppyFee",getPpyFee())
		.append("payFee",getPayFee())
		.append("refusedFee",getRefusedFee())
		.append("createTime",getCreateTime())
		.append("freezePpy",getFreezePpy())
		.append("stsDate",getStsDate())
		.append("adjustedFee",getAdjustedFee())
		.append("point",getPoint())
		.append("primalFee",getPrimalFee())
		.append("acctId",getAcctId())
		.append("delayLateFee",getDelayLateFee())
		.append("unpayFee",getUnpayFee())
		.append("discountFee",getDiscountFee())
		.append("firstPrintMon",getFirstPrintMon())
		.append("suspendFee",getSuspendFee())
		.append("credit",getCredit())
		.append("countyCode",getCountyCode())
		.append("minBeginDate",getMinBeginDate())
		.append("cycleEndDate",getCycleEndDate())
		.toString();
	}
}