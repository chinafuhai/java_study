package com.asiainfo.boss4.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_SPROM_CONFIG", schema = "INTER")
public class IUserSpromConfig implements java.io.Serializable {

	// Fields

	private Integer crmSpromId;
	private Integer bossSpromId;
	private String validDate;
	private String expireDate;
	private String remark;
	private Boolean insertUserCell;

	// Constructors


	/** default constructor */
	public IUserSpromConfig() {
	}

	/** minimal constructor */
	public IUserSpromConfig(Integer crmSpromId, Integer bossSpromId) {
		this.crmSpromId = crmSpromId;
		this.bossSpromId = bossSpromId;
	}

	/** full constructor */
	public IUserSpromConfig(Integer crmSpromId, Integer bossSpromId, String validDate,
			String expireDate, String remark) {
		this.crmSpromId = crmSpromId;
		this.bossSpromId = bossSpromId;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.remark = remark;
	}

	// Property accessors
	
	@Id
	@Column(name = "CRM_SPROM_ID", unique = true, nullable = false, precision = 8, scale = 0)
	public Integer getCrmSpromId() {
		return crmSpromId;
	}

	public void setCrmSpromId(Integer crmSpromId) {
		this.crmSpromId = crmSpromId;
	}

	@Column(name = "BOSS_SPROM_ID", nullable = false, precision = 8, scale = 0)
	public Integer getBossSpromId() {
		return bossSpromId;
	}

	public void setBossSpromId(Integer bossSpromId) {
		this.bossSpromId = bossSpromId;
	}

	@Column(name = "VALID_DATE")
	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	@Column(name = "EXPIRE_DATE")
	public String getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	@Column(name = "INSERT_USER_CELL")
	public Boolean getInsertUserCell() {
		return insertUserCell;
	}
	
	public void setInsertUserCell(Boolean insertUserCell) {
		this.insertUserCell = insertUserCell;
	}
	
	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
        return new ToStringBuilder(this)
            .append("crmSpromId", getCrmSpromId())
            .append("bossSpromId", getBossSpromId())
            .append("validDate", getValidDate())
            .append("expireDate",getExpireDate())
            .append("remark",getRemark())
            .toString();
    }
}