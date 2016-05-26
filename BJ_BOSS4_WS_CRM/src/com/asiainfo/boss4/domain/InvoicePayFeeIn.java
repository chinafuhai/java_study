package com.asiainfo.boss4.domain;

import java.util.Date;

public class InvoicePayFeeIn {
	private String chargeId;       //缴费标志(手机号码、帐户编号)
	private Short  idType;         //缴费标志类型 1 手机号码按帐户缴费，2,帐户编号
	private String phoneId;        //用户来缴费的时候提供的电话号码
	private Long   bankId;         //银行编号
	private String bankAcct;       //银行帐号,或银行卡卡号
	private Integer opId;           //操作员工号
	private Integer soOrgId;        //局向(营业厅编号)
	private String otherNbr;       //外部流水号,记录第三方流水号,如银行代收流水号
	private Short  busiType;       //业务类型  !!重要,需要增加新的业务类型
	private String cardNbr;        //缴费卡卡号
	private String cbossArea;      //CBOSS受理地区
	private String checkNbr;       //支票号码
	private Long   checkAmount;    //支票金额
	private Short  invoiceMode;    //发票打印模式 比如： 1 转讫发票 0 不打印发票
	private Long   paidAmount;     //实收金额,缴费卡时为缴费卡面值
	private String remarks;        //备注
	private Short  smsFlag;        //是否发送短信 2 不发短信， 其他0、1、null维持默认发
	private Date   tradeDate;      //(外部接口)交易时间                                                                                                                                  
	private Short  payMode;        //缴月帐、实时费用标志

	//查欠方式相关参数
	private String monList;        //月份列表 要缴费的帐单月份，默认0为全部欠费月
	private Integer billFormatId;   //帐单格式ID 缺省为1
	private Short  calcLateFee;    //是否计算滞纳金 0:不计算滞纳金 1:计算滞纳金
	private Long   lateFeeCut;     //减免滞纳金
	private Short  phoneIdSts;     //0:正常用户,1:销号用户,2:(正常用户+销号用户),3:(正常用户+一卡付费子号码),4:(正常用户+销号用户+一卡付费子号码)(只有用服务号码查询时才用填写),6:默认帐户
	private Short  billSts;        //帐单状态 0:正常1:呆帐2:坏帐3:呆帐+坏帐4:正常+呆帐+坏帐 (与查欠保持一致)
	//end of 查欠参数                                                                                                                                                                  

	private Short  processMode;    //处理模式 按位取值,未使用的位置0,不设置时,所有位全0
	                               //目前使用低2位
	                               //xxxxxxba 其中最低位a    复位0 同步处理   置位1 异步处理
	                               //             倒数第2位b 复位0 不强制预存 置位1 强制预存
	private Long   change;         //转下月零头
	private Short  userBrand;      //用户品牌 0 未知 1 后付费 4 预付费
	private String paymentMethod;  //付费方式 CA现金 CC信用卡 CQ支票 POS pos机 GLXX 总账..

	public InvoicePayFeeIn(){
		
	}
	public String getChargeId() {
		return chargeId;
	}
	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}
	public Short getIdType() {
		return idType;
	}
	public void setIdType(Short idType) {
		this.idType = idType;
	}
	public String getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(String phoneId) {
		this.phoneId = phoneId;
	}
	public Long getBankId() {
		return bankId;
	}
	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}
	public String getBankAcct() {
		return bankAcct;
	}
	public void setBankAcct(String bankAcct) {
		this.bankAcct = bankAcct;
	}
	public Integer getOpId() {
		return opId;
	}
	public void setOpId(Integer opId) {
		this.opId = opId;
	}
	public Integer getSoOrgId() {
		return soOrgId;
	}
	public void setSoOrgId(Integer soOrgId) {
		this.soOrgId = soOrgId;
	}
	public String getOtherNbr() {
		return otherNbr;
	}
	public void setOtherNbr(String otherNbr) {
		this.otherNbr = otherNbr;
	}
	public Short getBusiType() {
		return busiType;
	}
	public void setBusiType(Short busiType) {
		this.busiType = busiType;
	}
	public String getCardNbr() {
		return cardNbr;
	}
	public void setCardNbr(String cardNbr) {
		this.cardNbr = cardNbr;
	}
	public String getCbossArea() {
		return cbossArea;
	}
	public void setCbossArea(String cbossArea) {
		this.cbossArea = cbossArea;
	}
	public String getCheckNbr() {
		return checkNbr;
	}
	public void setCheckNbr(String checkNbr) {
		this.checkNbr = checkNbr;
	}
	public Long getCheckAmount() {
		return checkAmount;
	}
	public void setCheckAmount(Long checkAmount) {
		this.checkAmount = checkAmount;
	}
	public Short getInvoiceMode() {
		return invoiceMode;
	}
	public void setInvoiceMode(Short invoiceMode) {
		this.invoiceMode = invoiceMode;
	}
	public Long getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(Long paidAmount) {
		this.paidAmount = paidAmount;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Short getSmsFlag() {
		return smsFlag;
	}
	public void setSmsFlag(Short smsFlag) {
		this.smsFlag = smsFlag;
	}
	public Date getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}
	public Short getPayMode() {
		return payMode;
	}
	public void setPayMode(Short payMode) {
		this.payMode = payMode;
	}
	public String getMonList() {
		return monList;
	}
	public void setMonList(String monList) {
		this.monList = monList;
	}
	public Integer getBillFormatId() {
		return billFormatId;
	}
	public void setBillFormatId(Integer billFormatId) {
		this.billFormatId = billFormatId;
	}
	public Short getCalcLateFee() {
		return calcLateFee;
	}
	public void setCalcLateFee(Short calcLateFee) {
		this.calcLateFee = calcLateFee;
	}
	public Long getLateFeeCut() {
		return lateFeeCut;
	}
	public void setLateFeeCut(Long lateFeeCut) {
		this.lateFeeCut = lateFeeCut;
	}
	public Short getPhoneIdSts() {
		return phoneIdSts;
	}
	public void setPhoneIdSts(Short phoneIdSts) {
		this.phoneIdSts = phoneIdSts;
	}
	public Short getBillSts() {
		return billSts;
	}
	public void setBillSts(Short billSts) {
		this.billSts = billSts;
	}
	public Short getProcessMode() {
		return processMode;
	}
	public void setProcessMode(Short processMode) {
		this.processMode = processMode;
	}
	public Long getChange() {
		return change;
	}
	public void setChange(Long change) {
		this.change = change;
	}
	public Short getUserBrand() {
		return userBrand;
	}
	public void setUserBrand(Short userBrand) {
		this.userBrand = userBrand;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

}
