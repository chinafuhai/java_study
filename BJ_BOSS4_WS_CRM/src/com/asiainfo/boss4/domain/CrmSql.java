package com.asiainfo.boss4.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;

@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "CRM_SQL", schema = "INTER")
@Backup.CopyToSuffix(isIgnore = true)
@CommonDao(fieldOfSelectConditions = { "ca", "ba" }, dataStoreMode = DataStoreMode.DIRECT_UPDATE)

public class CrmSql  extends BaseEntity implements java.io.Serializable {

	// Fields
	private String ca;
	private String ba;
	private String name;
	private String xAddr;
	private Integer xZipCode;
	private String ouTypeCd;
	
	// Constructors

	/** default constructor */
	public CrmSql() {
	}
	
	public CrmSql(String ca,String ba,String name,String xAddr,Integer xZipCode,String ouTypeCd){
		this.ca = ca;
		this.ba = ba;
		this.name = name;
		this.xAddr = xAddr;
		this.xZipCode = xZipCode;
		this.ouTypeCd = ouTypeCd;
	}

	// Property accessors
	@Column(name = "CA", nullable = false, length = 50)
	public String getCa() {
		return ca;
	}

	public void setCa(String ca) {
		this.ca = ca;
	}

	@Id
	@Column(name = "BA", nullable = false, length = 50)
	public String getBa() {
		return ba;
	}

	public void setBa(String ba) {
		this.ba = ba;
	}

	@Column(name = "NAME", nullable = false, length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "X_ADDR", nullable = false, length = 50)
	public String getxAddr() {
		return xAddr;
	}

	public void setxAddr(String xAddr) {
		this.xAddr = xAddr;
	}

	@Column(name = "X_ZIP_CODE", nullable = false, precision = 6, scale = 0)
	public Integer getxZipCode() {
		return xZipCode;
	}

	public void setxZipCode(Integer xZipCode) {
		this.xZipCode = xZipCode;
	}

	@Column(name = "OU_TYPE_CD", nullable = false, length = 50)
	public String getOuTypeCd() {
		return ouTypeCd;
	}

	public void setOuTypeCd(String ouTypeCd) {
		this.ouTypeCd = ouTypeCd;
	}
	
}
