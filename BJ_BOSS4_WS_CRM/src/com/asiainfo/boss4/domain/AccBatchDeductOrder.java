package com.asiainfo.boss4.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.OperateType;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;



@SuppressWarnings("serial")
@Entity
@Table(name = "ACC_BATCH_DEDUCT_ORDER", schema = "ZG")
@IdClass(AccBatchDeductOrder.AccBatchDeductOrderId.class)
@Backup.CopyToSuffix(suffixes = {Backup.CopyToSuffix.HIS})
@CommonDao(fieldOfSelectConditions = { "msisdn"}, isAlertWhenExist = true, dataStoreMode = DataStoreMode.DIRECT_UPDATE)
public class AccBatchDeductOrder extends BaseEntity implements
		java.io.Serializable {

	// Fields

	private String msisdn;
	private Date effDate;
	private Date expDate;
	private String bankSeq;
	private Byte signStatus;
	private String signBankName;
	private Date createDate;
	private Date optDate;
	private String opId;
	private Long deductAmount;
	private String remark;
	
	private Long thresholdLimit; 
	private Long acctId;
	
	// Constructors

	/** default constructor */
	public AccBatchDeductOrder() {
	}

	public AccBatchDeductOrder(String msisdn,Date effDate,Date expDate,
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
	public AccBatchDeductOrder(String msisdn,Date effDate,Date expDate,
			String bankSeq, Byte signStatus, String signBankName, Date createDate,
			String opId,Long deductAmount,String remark, Long thresholdLimit, Long acctId) {
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
		this.acctId = acctId;
	}

	@Column(name = "BANK_SEQ",nullable = false, length = 100)
	public String getBankSeq() {
		return this.bankSeq;
	}

	public void setBankSeq(String bankSeq) {
		this.bankSeq = bankSeq;
	}

	@Column(name = "SIGN_STATUS", nullable = false,precision = 2, scale = 0)
	public Byte getSignStatus() {
		return this.signStatus;
	}

	public void setSignStatus(Byte signStatus) {
		this.signStatus = signStatus;
	}
	@Id
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
	@Id
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

	@Column(name = "Threshold_Limit",  length = 15)
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

	public static class AccBatchDeductOrderId implements java.io.Serializable {

		// Fields

		private String msisdn;
		private String signBankName;
		
		// Constructors

		/** default constructor */
		public AccBatchDeductOrderId() {
		}

		/** full constructor */
		public AccBatchDeductOrderId(String msisdn, String signBankName) {
			this.msisdn = msisdn;
			this.signBankName = signBankName;
		}

		// Property accessors
		@Column(name = "SIGN_BANK_NAME", length = 8)
		public String getSignBankName() {
			return this.signBankName;
		}

		public void setSignBankName(String signBankName) {
			this.signBankName = signBankName;
		}

		@Column(name = "MSISDN", nullable = false, length = 20)
		public String getMsisdn() {
			return this.msisdn;
		}

		public void setMsisdn(String msisdn) {
			this.msisdn = msisdn;
		}
		
		@Override
		public boolean equals(Object other) {
	        if ( !(other instanceof AccBatchDeductOrderId) ) return false;
	        AccBatchDeductOrderId castOther = (AccBatchDeductOrderId) other;
	        return new EqualsBuilder()
	            .append(this.getMsisdn(), castOther.getMsisdn())
	            .append(this.getSignBankName(), castOther.getSignBankName())
	            .isEquals();
	    }

		@Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getMsisdn())
	            .append(getSignBankName())
	            .toHashCode();
	    }
	}
	
	@Override
	public BaseEntity add(ServiceContext context) {
		if (!this.getTheOperateType().equals(OperateType.ROLLBACKCANCEL))
			this.setCreateDate(context.getSoDate());
		else
			this.setRemark(DateHelper.Date2String(context.getSoDate(), "yyyyMMdd")+"解约回退");
		this.setSignStatus(Byte.valueOf("1"));
		IUser user = context.getBusinessDao().queryIUserAllByPhoneNumber(this.getMsisdn());
		if (user == null)
		{
			throw new BossException(StatusCode.IUSER_ISNULL_ERROR);
		}
		
		//判断是否和个人缴费通互斥 (根据zg.crm_account 表中t.pay_type（21为托收，22为个人缴费通，集团充值助理23）)
		CrmAccount account = context.getBusinessDao().queryCrmAccountByAcctId(user.getAcctId());
		if (account == null)
		{
			throw new BossException(StatusCode.CRMACCOUNT_ISNULL_ERROR);
		}
		
		if (this.getAcctId()!= null && account.getAcctId().longValue() != this.getAcctId().longValue())
		{
			throw new BossException(StatusCode.ACCTID_NOT_MATCH_ERROR);
		}
		
		if (account.getPayType()!= null && account.getPayType().shortValue() == 21)
		{
			throw new BossException(StatusCode.SIGN_CONTRACT_EXIST_ERROR,"用户已经托收");
			
		}else if (account.getPayType()!= null && account.getPayType().shortValue() == 22)
		{
			throw new BossException(StatusCode.SIGN_CONTRACT_EXIST_ERROR,"用户已经办理个人缴费通");
			
		}else if (account.getPayType()!= null && account.getPayType().shortValue() == 23)
		{
			throw new BossException(StatusCode.SIGN_CONTRACT_EXIST_ERROR,"用户已经办理集团充值助理");
		}
		List signList = context.getBusinessDao().queryAccUserPaymentList(user.getServId());
		if (signList.size()>0)
			throw new BossException(StatusCode.SIGN_CONTRACT_EXIST_ERROR);
		
		signList = context.getBusinessDao().getEntityList(this, new String[]{"msisdn"});
		if (signList.size()>0)
			throw new BossException(StatusCode.SIGN_CONTRACT_EXIST_ERROR);
		
		return super.add(context);
	}

	@Override
	public BaseEntity modify(ServiceContext context) {
		this.setCreateDate(context.getSoDate());
		this.setSignStatus(Byte.valueOf("1"));
		AccBatchDeductOrder accBatchDeductOrder = (AccBatchDeductOrder)context.getBusinessDao().getEntity(this, new String[]{"msisdn","signBankName"});
		if (accBatchDeductOrder == null)
			throw new BossException(StatusCode.SIGN_CONTRACT_NOT_EXIST_ERROR);
		
		IUser user = context.getBusinessDao().queryIUserAllByPhoneNumber(this.getMsisdn());
		if (user == null)
		{
			throw new BossException(StatusCode.IUSER_ISNULL_ERROR);
		}
		
		//判断是否和个人缴费通互斥 (根据zg.crm_account 表中t.pay_type（21为托收，22为个人缴费通，集团充值助理23）)
		CrmAccount account = context.getBusinessDao().queryCrmAccountByAcctId(user.getAcctId());
		if (account == null)
		{
			throw new BossException(StatusCode.CRMACCOUNT_ISNULL_ERROR);
		}
		
		if (this.getAcctId()!= null && account.getAcctId().longValue() != this.getAcctId().longValue())
		{
			throw new BossException(StatusCode.ACCTID_NOT_MATCH_ERROR);
		}
		
		AccBatchDeductOrderHis accBatchDeductOrderHis = new AccBatchDeductOrderHis();
		BeanCopyHelper.copyBeanNotNullProperty(accBatchDeductOrderHis, accBatchDeductOrder);
		BeanCopyHelper.copyBeanNotNullPropertyCrm(accBatchDeductOrder, this);
		context.getBusinessDao().add(accBatchDeductOrderHis);
		context.getBusinessDao().update(accBatchDeductOrder);
		return this;
	}
	
	@Override
	public BaseEntity cancel(ServiceContext context) {
		AccBatchDeductOrder accBatchDeductOrder = (AccBatchDeductOrder)context.getBusinessDao().getEntity(this, new String[]{"msisdn","signBankName"});
		if (accBatchDeductOrder == null)
			throw new BossException(StatusCode.SIGN_CONTRACT_NOT_EXIST_ERROR);
		accBatchDeductOrder.setBankSeq(this.getBankSeq());
		accBatchDeductOrder.setRemark(DateHelper.Date2String(context.getSoDate(), "yyyyMMdd")+"解约");
		accBatchDeductOrder.setSignStatus(Byte.valueOf("0"));
		context.getBusinessDao().update(accBatchDeductOrder);
		context.getBusinessDao().backupAutoSuffix(this,new String[]{"msisdn","signBankName"});
		context.getBusinessDao().remove(this,new String[]{"msisdn","signBankName"});
		return this;
	}
	
	@Override
	public BaseEntity rollBack(ServiceContext context) {
		if (this.getTheOperateType().equals(OperateType.ROLLBACKCANCEL))
		{
			AccBatchDeductOrderHis accBatchDeductOrderHis = new AccBatchDeductOrderHis();
			BeanCopyHelper.copyBeanNotNullProperty(accBatchDeductOrderHis, this);
			accBatchDeductOrderHis = (AccBatchDeductOrderHis)context.getBusinessDao().getEntity(accBatchDeductOrderHis, new String[]{"bankSeq"});
			
			BeanCopyHelper.copyBeanNotNullPropertyCrm(this, accBatchDeductOrderHis);
			context.getBusinessDao().remove(accBatchDeductOrderHis);
			return this;
		}
		else
			throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
		
	}
	
}