package com.asiainfo.boss4.domain;

import java.util.Date;

/**
 * 最低消费金额查询
 * 
 * @author Administrator
 *
 */
public class MinConAmount {
	/** 实例编号 */
	private String soId;
	/** 最低消费金额 */
	private Long minAmount;
	/** 生效时间 */
	private Date validDate;
	/** 失效时间 */
	private Date expireDate;
	/**当数据库里的prom_type为7，返回1，如果为11，返回0*/
	private String promType;

	/** 实例编号 */
	public String getSoId() {
		return soId;
	}

	/** 实例编号 */
	public void setSoId(String soId) {
		this.soId = soId;
	}

	/** 最低消费金额 */
	public Long getMinAmount() {
		return minAmount;
	}

	/** 最低消费金额 */
	public void setMinAmount(Long minAmount) {
		this.minAmount = minAmount;
	}

	/** 生效时间 */
	public Date getValidDate() {
		return validDate;
	}

	/** 生效时间 */
	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	/** 失效时间 */
	public Date getExpireDate() {
		return expireDate;
	}

	/** 失效时间 */
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	/**当数据库里的prom_type为7，返回1，如果为11，返回0*/
	public String getPromType() {
		return promType;
	}
	/**当数据库里的prom_type为7，返回1，如果为11，返回0*/
	public void setPromType(String promType) {
		this.promType = promType;
	}
	
	

}