package com.asiainfo.boss4.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.annotation.Backup;

@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "ACC_POS_HALL_RELATION_HIS", schema = "Inter")
public class AccPosHallRelationHis extends BaseEntity implements java.io.Serializable{
	// Fields
	private String bankCode;
	private String posNo;
	private String hallNo;
	
	
	public AccPosHallRelationHis() {
		
	}


	public AccPosHallRelationHis(String bankCode, String posNo,
			String hallNo) {
		this.bankCode = bankCode;
		this.posNo = posNo;
		this.hallNo = hallNo;
	}

	@Column(name = "BANK_CODE", nullable = false, length = 10)
	public String getBankCode() {
		return bankCode;
	}


	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	@Id
	@Column(name = "POS_NO", nullable = false, length = 20)
	public String getPosNo() {
		return posNo;
	}


	public void setPosNo(String posNo) {
		this.posNo = posNo;
	}

	@Column(name = "HALL_NO", nullable = false, length = 10)
	public String getHallNo() {
		return hallNo;
	}


	public void setHallNo(String hallNo) {
		this.hallNo = hallNo;
	}
	
}
