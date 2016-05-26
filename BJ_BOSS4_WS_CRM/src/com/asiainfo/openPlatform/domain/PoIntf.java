package com.asiainfo.openPlatform.domain;

import java.io.Serializable;
import java.util.Date;

public class PoIntf implements Serializable{
    
	private static final long serialVersionUID = 1L;
	
	private Long  poId;        //Po流水号 插入时统一为sequence
    private Long  tradeId;     //CRM流水号
    private String orderId;   // 订单号
    private String operCode;  //  操作员编号
    private String MSISDN;    //    手机号码
    private String IMSI;      //   IMSI号码
    private int retFlag;      //回执标识
    private int batFlag;      //批量工单标志
    private String poType;    // PO类型
    private int reqType;      //业务操作类型
    private String param;     //参数key=value;key=value;方式
    private int priLvl;       //优先级别
    private Date validDate;   //工单生效时间
    private Date createDate;  //创建时间
    private String notes;     //备注
    
    
	public PoIntf() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PoIntf(Long poId, Long tradeId, String orderId, String operCode,
			String mSISDN, String iMSI, int batFlag,int retFlag,String poType, int reqType, String param, int priLvl,
			Date createDate,Date validDate,String notes) {
		super();
		this.poId = poId;
		this.tradeId = tradeId;
		this.orderId = orderId;
		this.operCode = operCode;
		MSISDN = mSISDN;
		IMSI = iMSI;
		this.batFlag = batFlag;
		this.poType = poType;
		this.reqType = reqType;
		this.param = param;
		this.priLvl = priLvl;
		this.createDate = createDate;
		this.retFlag = retFlag;
		this.validDate = validDate;
		this.notes = notes;
	}


	public Long getPoId() {
		return poId;
	}


	public void setPoId(Long poId) {
		this.poId = poId;
	}


	public Long getTradeId() {
		return tradeId;
	}


	public void setTradeId(Long tradeId) {
		this.tradeId = tradeId;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public String getOperCode() {
		return operCode;
	}


	public void setOperCode(String operCode) {
		this.operCode = operCode;
	}


	public String getMSISDN() {
		return MSISDN;
	}


	public void setMSISDN(String mSISDN) {
		MSISDN = mSISDN;
	}


	public String getIMSI() {
		return IMSI;
	}


	public void setIMSI(String iMSI) {
		IMSI = iMSI;
	}


	public int getBatFlag() {
		return batFlag;
	}


	public void setBatFlag(int batFlag) {
		this.batFlag = batFlag;
	}


	public String getPoType() {
		return poType;
	}


	public void setPoType(String poType) {
		this.poType = poType;
	}


	public int getReqType() {
		return reqType;
	}


	public void setReqType(int reqType) {
		this.reqType = reqType;
	}


	public String getParam() {
		return param;
	}


	public void setParam(String param) {
		this.param = param;
	}


	public int getPriLvl() {
		return priLvl;
	}


	public void setPriLvl(int priLvl) {
		this.priLvl = priLvl;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public int getRetFlag() {
		return retFlag;
	}


	public void setRetFlag(int retFlag) {
		this.retFlag = retFlag;
	}


	public Date getValidDate() {
		return validDate;
	}


	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}
}
