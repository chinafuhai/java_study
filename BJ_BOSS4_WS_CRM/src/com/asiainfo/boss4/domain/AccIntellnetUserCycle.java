package com.asiainfo.boss4.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;

/**
 * AccIntellnetUserCycle entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "ACC_INTELLNET_USER_CYCLE", schema = "ZG")
@Backup.CopyToSuffix(isIgnore = true)
@CommonDao(fieldOfSelectConditions = {"acctId"}, dataStoreMode = DataStoreMode.DIRECT_UPDATE)
public class AccIntellnetUserCycle extends BaseEntity implements java.io.Serializable {

	// Fields

	private Long acctId;
	private Date validDate;
	private Date expireDate;
	private Byte sts;
	private Date promptDate;
	private Date transDepositDate;
	private Date balanceExpireDate;

	// Constructors

	/** default constructor */
	public AccIntellnetUserCycle() {
	}

	/** minimal constructor */
	public AccIntellnetUserCycle(Long acctId, Date validDate, Date expireDate,
			Byte sts) {
		this.acctId = acctId;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.sts = sts;
	}

	/** full constructor */
	public AccIntellnetUserCycle(Long acctId, Date validDate, Date expireDate,
			Byte sts, Date promptDate, Date transDepositDate,
			Date balanceExpireDate) {
		this.acctId = acctId;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.sts = sts;
		this.promptDate = promptDate;
		this.transDepositDate = transDepositDate;
		this.balanceExpireDate = balanceExpireDate;
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

	@Column(name = "STS", nullable = false, precision = 2, scale = 0)
	public Byte getSts() {
		return this.sts;
	}

	public void setSts(Byte sts) {
		this.sts = sts;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PROMPT_DATE", length = 7)
	public Date getPromptDate() {
		return this.promptDate;
	}

	public void setPromptDate(Date promptDate) {
		this.promptDate = promptDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TRANS_DEPOSIT_DATE", length = 7)
	public Date getTransDepositDate() {
		return this.transDepositDate;
	}

	public void setTransDepositDate(Date transDepositDate) {
		this.transDepositDate = transDepositDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BALANCE_EXPIRE_DATE", length = 7)
	public Date getBalanceExpireDate() {
		return this.balanceExpireDate;
	}

	public void setBalanceExpireDate(Date balanceExpireDate) {
		this.balanceExpireDate = balanceExpireDate;
	}

}