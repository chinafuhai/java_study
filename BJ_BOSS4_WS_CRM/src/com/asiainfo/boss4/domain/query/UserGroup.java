package com.asiainfo.boss4.domain.query;

public class UserGroup {
	// Fields

	private String servId;
	private String validDate;
	private String expireDate;
	private String groupId;
	private String groupType;
	private String property;
	
	// Constructors

	/** default constructor */
	public UserGroup() {
	}

	public UserGroup(String servId, String validDate, String expireDate,
			String groupId, String groupType, String property) {
		super();
		this.servId = servId;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.groupId = groupId;
		this.groupType = groupType;
		this.property = property;
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

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

}
