package com.asiainfo.boss4.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;

@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "ACC_POS_HALL_RELATION", schema = "ZG")
@Backup.CopyToSuffix(suffixes = {Backup.CopyToSuffix.HIS})
@CommonDao(fieldOfSelectConditions = { "hallNo", "posNo"},fieldOfDBSelectConditions={"hall_no", "pos_no"}, dataStoreMode = DataStoreMode.DIRECT_UPDATE)
public class AccPosHallRelation extends BaseEntity implements java.io.Serializable{
	// Fields
	private Byte operType;
	private String bankCode;
	private String posNo;
	private String hallNo;
	
	
	public AccPosHallRelation() {
		
	}


	public AccPosHallRelation(Byte operType, String bankCode, String posNo,
			String hallNo) {
		this.operType = operType;
		this.bankCode = bankCode;
		this.posNo = posNo;
		this.hallNo = hallNo;
	}


	@Transient
	public Byte getOperType() {
		return operType;
	}


	public void setOperType(Byte operType) {
		this.operType = operType;
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
