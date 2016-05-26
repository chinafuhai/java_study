package com.asiainfo.boss4.domain;

public class TranBill {
	String phoneId;                                         //用户电话号码
	Long oldAcctId;                                       	//过户前老账户 
	Long newAcctId;                                    		//过户后新账户
	Integer oldAcctRegionCode;             					//老账户的regionCode
	Integer newAcctRegionCode;           					//新账户的regionCode
	Integer bookItemId;                           			//帐本科目ID,82018 实时话费
	Short invcType;                                       	//发票类型 发票类型 1 话费发票 2  实时话费发票 3  代收费发票 4    托收凭证 5  预存发票 6  押金发票 7  转讫发票 8  业务发票 9  坏帐发票
	Short busiType;                                   		//业务类型,4118 过户资金转移       
	Integer isReal;                                         //是否查询实时和月结欠费 0 不查询 1：查询实时和月结欠费,2:查询月结欠费 如果是别的值就当0处理，目前对资金转移有效。
	Long soNbr;                                             //流水号
	Integer opId;
	Integer orgId;
	
	public TranBill(){
		
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

	public Integer getBookItemId() {
		return bookItemId;
	}

	public void setBookItemId(Integer bookItemId) {
		this.bookItemId = bookItemId;
	}

	public Short getInvcType() {
		return invcType;
	}

	public void setInvcType(Short invcType) {
		this.invcType = invcType;
	}

	public Short getBusiType() {
		return busiType;
	}

	public void setBusiType(Short busiType) {
		this.busiType = busiType;
	}

	public Integer getIsReal() {
		return isReal;
	}

	public void setIsReal(Integer isReal) {
		this.isReal = isReal;
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
