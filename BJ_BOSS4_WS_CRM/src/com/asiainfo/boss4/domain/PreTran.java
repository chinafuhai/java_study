package com.asiainfo.boss4.domain;

public class PreTran {
	String phoneId;                                         //用户电话号码
	Long oldAcctId;                                       	//过户前老账户 
	Long newAcctId;                                    		//过户后新账户
	Integer oldAcctRegionCode;             					//老账户的regionCode
	Integer newAcctRegionCode;           					//新账户的regionCode
	Short busiType;                                   		//业务类型,4118 过户资金转移       
	Long soNbr;                                             //流水号
	Integer opId;
	Integer orgId;
	
	public PreTran(){
		
	}

	public String getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(String phoneId) {
		this.phoneId = phoneId;
	}

	public Long getOldAcctId() {
		return oldAcctId;
	}

	public void setOldAcctId(Long oldAcctId) {
		this.oldAcctId = oldAcctId;
	}

	public Long getNewAcctId() {
		return newAcctId;
	}

	public void setNewAcctId(Long newAcctId) {
		this.newAcctId = newAcctId;
	}

	public Integer getOldAcctRegionCode() {
		return oldAcctRegionCode;
	}

	public void setOldAcctRegionCode(Integer oldAcctRegionCode) {
		this.oldAcctRegionCode = oldAcctRegionCode;
	}

	public Integer getNewAcctRegionCode() {
		return newAcctRegionCode;
	}

	public void setNewAcctRegionCode(Integer newAcctRegionCode) {
		this.newAcctRegionCode = newAcctRegionCode;
	}

	public Short getBusiType() {
		return busiType;
	}

	public void setBusiType(Short busiType) {
		this.busiType = busiType;
	}

	public Long getSoNbr() {
		return soNbr;
	}

	public void setSoNbr(Long soNbr) {
		this.soNbr = soNbr;
	}

	public Integer getOpId() {
		return opId;
	}

	public void setOpId(Integer opId) {
		this.opId = opId;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
}
