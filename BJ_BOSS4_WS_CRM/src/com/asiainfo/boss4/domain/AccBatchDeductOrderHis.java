package com.asiainfo.boss4.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Entity;

import com.asiainfo.boss4.domain.base.BaseEntity;



@SuppressWarnings("serial")
@Entity
@Table(name = "ACC_BATCH_DEDUCT_ORDER_HIS", schema = "ZG")
public class AccBatchDeductOrderHis extends BaseEntity implements
		java.io.Serializable {

	// Fields

	private String msisdn;
	private Date effDate;
	private Date expDate;
	private String bankSeq;
	private Byte signStatus;
	private String signBankName;
	private Date createDate;
	private String opId;
	private Long deductAmount;
	private String remark;
	
	private Long thresholdLimit; 
	private Long acctId;
	private Date optDate;
	
	// Constructors

	/** default constructor */
	public AccBatchDeductOrderHis() {
	}

	public AccBatchDeductOrderHis(String msisdn,Date effDate,Date expDate,
			String bankSeq, Byte signStatus, String signBankName, Date createDate,
			String opId) {
		this.msisdn = msisdn;
		this.effDate = effDate;
		this.expDate = expDate;
		this.bankSeq = bankSeq;
		this.signStatus = signStatus;
		this.signBankName = signBankName;
		this.createDate = createDate;
		this.opId = opId;
	}
	
	/** full constructor */
	public AccBatchDeductOrderHis(String msisdn,Date effDate,Date expDate,
			String bankSeq, Byte signStatus, String signBankName, Date createDate,
			String opId,Long deductAmount,String remark, Long thresholdLimit) {
		this.msisdn = msisdn;
		this.effDate = effDate;
		this.expDate = expDate;
		this.bankSeq = bankSeq;
		this.signStatus = signStatus;
		this.signBankName = signBankName;
		this.createDate = createDate;
		this.opId = opId;
		this.deductAmount = deductAmount;
		this.remark = remark;
		this.thresholdLimit = thresholdLimit;
	}
	@Id
	@Column(name = "BANK_SEQ", length = 100)
	public String getBankSeq() {
		return this.bankSeq;
	}

	public void setBankSeq(String bankSeq) {
		this.bankSeq = bankSeq;
	}

	@Column(name = "SIGN_STATUS", precision = 2, scale = 0)
	public Byte getSignStatus() {
		return this.signStatus;
	}

	public void setSignStatus(Byte signStatus) {
		this.signStatus = signStatus;
	}

	@Column(name = "SIGN_BANK_NAME", length = 8)
	public String getSignBankName() {
		return this.signBankName;
	}

	public void setSignBankName(String signBankName) {
		this.signBankName = signBankName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Create_Date", length = 7)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "OP_ID", length = 100)
	public String getOpId() {
		return this.opId;
	}

	public void setOpId(String opId) {
		this.opId = opId;
	}
	
	@Column(name = "MSISDN", nullable = false, length = 20)
	public String getMsisdn() {
		return this.msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EFF_DATE", nullable = false, length = 7)
	public Date getEffDate() {
		return this.effDate;
	}

	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXP_DATE", nullable = false, length = 7)
	public Date getExpDate() {
		return this.expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	@Column(name = "DEDUCT_AMOUNT", nullable = true, length = 15)
	public Long getDeductAmount() {
		return deductAmount;
	}

	public void setDeductAmount(Long deductAmount) {
		this.deductAmount = deductAmount;
	}
	
	@Column(name = "REMARK", nullable = true, length = 200)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "Threshold_Limit", nullable = true, length = 15)
	public Long getThresholdLimit() {
		return thresholdLimit;
	}

	public void setThresholdLimit(Long thresholdLimit) {
		this.thresholdLimit = thresholdLimit;
	}
	
	@Column(name = "ACCT_ID",  length = 14)
	public Long getAcctId() {
		return acctId;
	}

	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "OPT_DATE", nullable = false, length = 7)
	public Date getOptDate() {
		return optDate;
	}

	public void setOptDate(Date optDate) {
		this.optDate = optDate;
	}
}