package com.asiainfo.boss4.domain.query;

public class UserCell {
	// Fields

	private String servId;
	private String validDate;
	private String expireDate;
	private String cellCode;
	private String soId;
	
	// Constructors

	/** default constructor */
	public UserCell() {
	}

	public UserCell(String servId, String validDate, String expireDate,
			String cellCode, String soId) {
		super();
		this.servId = servId;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.cellCode = cellCode;
		this.soId = soId;
	}

	public String getServId() {
		return servId;
	}

	public void setServId(String servId) {
		this.servId = servId;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getCellCode() {
		return cellCode;
	}

	public void setCellCode(String cellCode) {
		this.cellCode = cellCode;
	}

	public String getSoId() {
		return soId;
	}

	public void setSoId(String soId) {
		this.soId = soId;
	}

}
