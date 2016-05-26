package com.asiainfo.boss4.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;
/**
 * CrmUserCoinOrder entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "CRM_USER_COIN_ORDER", schema = "ZG")
@Backup.CopyToSuffix(isIgnore = true)
@CommonDao(fieldOfSelectConditions = { "servId", "coinOrderType","expireDate" },fieldOfDBSelectConditions={"serv_id","coin_order_type","expire_date"},dataStoreMode = DataStoreMode.DIRECT_UPDATE)
public class CrmUserCoinOrder extends BaseEntity  implements java.io.Serializable {

	// Fields

	private Long servId;
	private String phoneId;
	private Byte coinOrderType;
	private Date soDate;
	private Date validDate;
	private Date expireDate;
	private Date sendDate;

	// Constructors

	/** default constructor */
	public CrmUserCoinOrder() {
	}

	/** minimal constructor */
	public CrmUserCoinOrder(Long servId, String phoneId, Byte coinOrderType,
			Date validDate, Date expireDate) {
		this.servId = servId;
		this.phoneId = phoneId;
		this.coinOrderType = coinOrderType;
		this.validDate = validDate;
		this.expireDate = expireDate;
	}

	/** full constructor */
	public CrmUserCoinOrder(Long servId, String phoneId, Byte coinOrderType,
			Date soDate, Date validDate, Date expireDate, Date sendDate) {
		this.servId = servId;
		this.phoneId = phoneId;
		this.coinOrderType = coinOrderType;
		this.soDate = soDate;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.sendDate = sendDate;
	}

	// Property accessors
	@Id
	@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
	public Long getServId() {
		return this.servId;
	}

	public void setServId(Long servId) {
		this.servId = servId;
	}

	@Column(name = "PHONE_ID", nullable = false, length = 15)
	public String getPhoneId() {
		return this.phoneId;
	}

	public void setPhoneId(String phoneId) {
		this.phoneId = phoneId;
	}

	@Column(name = "COIN_ORDER_TYPE", precision = 2, scale = 0)
	public Byte getCoinOrderType() {
		return this.coinOrderType;
	}

	public void setCoinOrderType(Byte coinOrderType) {
		this.coinOrderType = coinOrderType;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SO_DATE", length = 7)
	public Date getSoDate() {
		return this.soDate;
	}

	public void setSoDate(Date soDate) {
		this.soDate = soDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VALID_DATE", nullable = false, length = 7)
	public Date getValidDate() {
		return this.validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRE_DATE", nullable = false, length = 7)
	public Date getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SEND_DATE", length = 7)
	public Date getSendDate() {
		return this.sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CrmUserCoinOrder))
			return false;
		CrmUserCoinOrder castOther = (CrmUserCoinOrder) other;

		return ((this.getServId() == castOther.getServId()) || (this
				.getServId() != null
				&& castOther.getServId() != null && this.getServId().equals(
				castOther.getServId())))
				&& ((this.getPhoneId() == castOther.getPhoneId()) || (this
						.getPhoneId() != null
						&& castOther.getPhoneId() != null && this.getPhoneId()
						.equals(castOther.getPhoneId())))
				&& ((this.getCoinOrderType() == castOther.getCoinOrderType()) || (this
						.getCoinOrderType() != null
						&& castOther.getCoinOrderType() != null && this
						.getCoinOrderType()
						.equals(castOther.getCoinOrderType())))
				&& ((this.getSoDate() == castOther.getSoDate()) || (this
						.getSoDate() != null
						&& castOther.getSoDate() != null && this.getSoDate()
						.equals(castOther.getSoDate())))
				&& ((this.getValidDate() == castOther.getValidDate()) || (this
						.getValidDate() != null
						&& castOther.getValidDate() != null && this
						.getValidDate().equals(castOther.getValidDate())))
				&& ((this.getExpireDate() == castOther.getExpireDate()) || (this
						.getExpireDate() != null
						&& castOther.getExpireDate() != null && this
						.getExpireDate().equals(castOther.getExpireDate())))
				&& ((this.getSendDate() == castOther.getSendDate()) || (this
						.getSendDate() != null
						&& castOther.getSendDate() != null && this
						.getSendDate().equals(castOther.getSendDate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getServId() == null ? 0 : this.getServId().hashCode());
		result = 37 * result
				+ (getPhoneId() == null ? 0 : this.getPhoneId().hashCode());
		result = 37
				* result
				+ (getCoinOrderType() == null ? 0 : this.getCoinOrderType()
						.hashCode());
		result = 37 * result
				+ (getSoDate() == null ? 0 : this.getSoDate().hashCode());
		result = 37 * result
				+ (getValidDate() == null ? 0 : this.getValidDate().hashCode());
		result = 37
				* result
				+ (getExpireDate() == null ? 0 : this.getExpireDate()
						.hashCode());
		result = 37 * result
				+ (getSendDate() == null ? 0 : this.getSendDate().hashCode());
		return result;
	}

}