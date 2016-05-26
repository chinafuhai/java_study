package com.asiainfo.openPlatform.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author zhangql
 *
 */
public class BwoIntf implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long tradeId;    //CRM流水号
    private int poNum;      //该工单包含的PO个数
    private int status;     //工单状态 0 初始  9 成功 -1 失败
    private String errCode;    //错误编码
    private String errDesc; //错误描述
    private int sNum;       //成功的个数
    private int fNum;       //失败的个数
    private Date createDate;//工单创建时间
    private Date updateDate;//更新时间 即最后处理完成时间
    private String notes;   //备注
    private String retInfo; //返回信息
    
    
	public BwoIntf() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BwoIntf(Long tradeId, int poNum, int status, String errCode,
			String errDesc, int sNum, int fNum, Date createDate,
			Date updateDate,String notes,String retInfo) {
		super();
		this.tradeId = tradeId;
		this.poNum = poNum;
		this.status = status;
		this.errCode = errCode;
		this.errDesc = errDesc;
		this.sNum = sNum;
		this.fNum = fNum;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.notes = notes;
		this.retInfo = retInfo;
	}


	public Long getTradeId() {
		return tradeId;
	}


	public void setTradeId(Long tradeId) {
		this.tradeId = tradeId;
	}


	public int getPoNum() {
		return poNum;
	}


	public void setPoNum(int poNum) {
		this.poNum = poNum;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getErrCode() {
		return errCode;
	}


	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}


	public String getErrDesc() {
		return errDesc;
	}


	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}


	public int getsNum() {
		return sNum;
	}


	public void setsNum(int sNum) {
		this.sNum = sNum;
	}


	public int getfNum() {
		return fNum;
	}


	public void setfNum(int fNum) {
		this.fNum = fNum;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Date getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public String getRetInfo() {
		return retInfo;
	}


	public void setRetInfo(String retInfo) {
		this.retInfo = retInfo;
	}
	
    
}
