package com.asiainfo.boss4.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * InBusiBatchDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "IN_BUSI_BATCH_DETAIL", schema = "INTER")
public class InBusiBatchDetail implements java.io.Serializable {

	// Fields

	private String amdocscustomerno;
	private String mobilenumber;
	private String stoplevel;
	private String vipcardtype;
	private String amdocsaccountid;
	private String voicelinemsisdn;
	private String simcardnumber;
	private String imsi;
	private String modeltype;
	private String primarypcnid;
	private String rcpcnid;
	private String ocpcnid;
	private String priceplanofferinstance;
	private String amdocssubscriber;
	private String grpsrctype;
	private String apnrctype;
	private String apnname;
	private String ismaskpublicapn;
	private String grpsinstancein;
	private String apninstance;
	private String apnprerctype;
	private String apnprename;
	private String grpsprerctype;
	private String grpsinstance;
	private String state;
	private String batchid;
	private String busitype;
	private String tradeid;
	private Long id;
	private Date createDate;
	private String batchType;
	private String limitsms;

	// Constructors

	/** default constructor */
	public InBusiBatchDetail() {
	}

	/** minimal constructor */
	public InBusiBatchDetail(Long id, Date createDate, String batchType) {
		this.id = id;
		this.createDate = createDate;
		this.batchType = batchType;
	}

	/** full constructor */
	public InBusiBatchDetail(String amdocscustomerno, String mobilenumber,
			String stoplevel, String vipcardtype, String amdocsaccountid,
			String voicelinemsisdn, String simcardnumber, String imsi,
			String modeltype, String primarypcnid, String rcpcnid,
			String ocpcnid, String priceplanofferinstance,
			String amdocssubscriber, String grpsrctype, String apnrctype,
			String apnname, String ismaskpublicapn, String grpsinstancein,
			String apninstance, String apnprerctype, String apnprename,
			String grpsprerctype, String grpsinstance, String state,
			String batchid, String busitype, String tradeid, Long id,
			Date createDate, String batchType, String limitsms) {
		this.amdocscustomerno = amdocscustomerno;
		this.mobilenumber = mobilenumber;
		this.stoplevel = stoplevel;
		this.vipcardtype = vipcardtype;
		this.amdocsaccountid = amdocsaccountid;
		this.voicelinemsisdn = voicelinemsisdn;
		this.simcardnumber = simcardnumber;
		this.imsi = imsi;
		this.modeltype = modeltype;
		this.primarypcnid = primarypcnid;
		this.rcpcnid = rcpcnid;
		this.ocpcnid = ocpcnid;
		this.priceplanofferinstance = priceplanofferinstance;
		this.amdocssubscriber = amdocssubscriber;
		this.grpsrctype = grpsrctype;
		this.apnrctype = apnrctype;
		this.apnname = apnname;
		this.ismaskpublicapn = ismaskpublicapn;
		this.grpsinstancein = grpsinstancein;
		this.apninstance = apninstance;
		this.apnprerctype = apnprerctype;
		this.apnprename = apnprename;
		this.grpsprerctype = grpsprerctype;
		this.grpsinstance = grpsinstance;
		this.state = state;
		this.batchid = batchid;
		this.busitype = busitype;
		this.tradeid = tradeid;
		this.id = id;
		this.createDate = createDate;
		this.batchType = batchType;
		this.limitsms = limitsms;
	}

	// Property accessors

	@Column(name = "AMDOCSCUSTOMERNO", length = 20)
	public String getAmdocscustomerno() {
		return this.amdocscustomerno;
	}

	public void setAmdocscustomerno(String amdocscustomerno) {
		this.amdocscustomerno = amdocscustomerno;
	}

	@Column(name = "MOBILENUMBER", length = 20)
	public String getMobilenumber() {
		return this.mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	@Column(name = "STOPLEVEL", length = 20)
	public String getStoplevel() {
		return this.stoplevel;
	}

	public void setStoplevel(String stoplevel) {
		this.stoplevel = stoplevel;
	}

	@Column(name = "VIPCARDTYPE", length = 20)
	public String getVipcardtype() {
		return this.vipcardtype;
	}

	public void setVipcardtype(String vipcardtype) {
		this.vipcardtype = vipcardtype;
	}

	@Column(name = "AMDOCSACCOUNTID", length = 20)
	public String getAmdocsaccountid() {
		return this.amdocsaccountid;
	}

	public void setAmdocsaccountid(String amdocsaccountid) {
		this.amdocsaccountid = amdocsaccountid;
	}

	@Column(name = "VOICELINEMSISDN", length = 20)
	public String getVoicelinemsisdn() {
		return this.voicelinemsisdn;
	}

	public void setVoicelinemsisdn(String voicelinemsisdn) {
		this.voicelinemsisdn = voicelinemsisdn;
	}

	@Column(name = "SIMCARDNUMBER", length = 20)
	public String getSimcardnumber() {
		return this.simcardnumber;
	}

	public void setSimcardnumber(String simcardnumber) {
		this.simcardnumber = simcardnumber;
	}

	@Column(name = "IMSI", length = 20)
	public String getImsi() {
		return this.imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	@Column(name = "MODELTYPE", length = 20)
	public String getModeltype() {
		return this.modeltype;
	}

	public void setModeltype(String modeltype) {
		this.modeltype = modeltype;
	}

	@Column(name = "PRIMARYPCNID", length = 20)
	public String getPrimarypcnid() {
		return this.primarypcnid;
	}

	public void setPrimarypcnid(String primarypcnid) {
		this.primarypcnid = primarypcnid;
	}

	@Column(name = "RCPCNID", length = 20)
	public String getRcpcnid() {
		return this.rcpcnid;
	}

	public void setRcpcnid(String rcpcnid) {
		this.rcpcnid = rcpcnid;
	}

	@Column(name = "OCPCNID", length = 20)
	public String getOcpcnid() {
		return this.ocpcnid;
	}

	public void setOcpcnid(String ocpcnid) {
		this.ocpcnid = ocpcnid;
	}

	@Column(name = "PRICEPLANOFFERINSTANCE", length = 20)
	public String getPriceplanofferinstance() {
		return this.priceplanofferinstance;
	}

	public void setPriceplanofferinstance(String priceplanofferinstance) {
		this.priceplanofferinstance = priceplanofferinstance;
	}

	@Column(name = "AMDOCSSUBSCRIBER", length = 20)
	public String getAmdocssubscriber() {
		return this.amdocssubscriber;
	}

	public void setAmdocssubscriber(String amdocssubscriber) {
		this.amdocssubscriber = amdocssubscriber;
	}

	@Column(name = "GRPSRCTYPE", length = 20)
	public String getGrpsrctype() {
		return this.grpsrctype;
	}

	public void setGrpsrctype(String grpsrctype) {
		this.grpsrctype = grpsrctype;
	}

	@Column(name = "APNRCTYPE", length = 20)
	public String getApnrctype() {
		return this.apnrctype;
	}

	public void setApnrctype(String apnrctype) {
		this.apnrctype = apnrctype;
	}

	@Column(name = "APNNAME", length = 20)
	public String getApnname() {
		return this.apnname;
	}

	public void setApnname(String apnname) {
		this.apnname = apnname;
	}

	@Column(name = "ISMASKPUBLICAPN", length = 20)
	public String getIsmaskpublicapn() {
		return this.ismaskpublicapn;
	}

	public void setIsmaskpublicapn(String ismaskpublicapn) {
		this.ismaskpublicapn = ismaskpublicapn;
	}

	@Column(name = "GRPSINSTANCEIN", length = 20)
	public String getGrpsinstancein() {
		return this.grpsinstancein;
	}

	public void setGrpsinstancein(String grpsinstancein) {
		this.grpsinstancein = grpsinstancein;
	}

	@Column(name = "APNINSTANCE", length = 20)
	public String getApninstance() {
		return this.apninstance;
	}

	public void setApninstance(String apninstance) {
		this.apninstance = apninstance;
	}

	@Column(name = "APNPRERCTYPE", length = 20)
	public String getApnprerctype() {
		return this.apnprerctype;
	}

	public void setApnprerctype(String apnprerctype) {
		this.apnprerctype = apnprerctype;
	}

	@Column(name = "APNPRENAME", length = 20)
	public String getApnprename() {
		return this.apnprename;
	}

	public void setApnprename(String apnprename) {
		this.apnprename = apnprename;
	}

	@Column(name = "GRPSPRERCTYPE", length = 20)
	public String getGrpsprerctype() {
		return this.grpsprerctype;
	}

	public void setGrpsprerctype(String grpsprerctype) {
		this.grpsprerctype = grpsprerctype;
	}

	@Column(name = "GRPSINSTANCE", length = 20)
	public String getGrpsinstance() {
		return this.grpsinstance;
	}

	public void setGrpsinstance(String grpsinstance) {
		this.grpsinstance = grpsinstance;
	}

	@Column(name = "STATE", length = 2)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "BATCHID", length = 20)
	public String getBatchid() {
		return this.batchid;
	}

	public void setBatchid(String batchid) {
		this.batchid = batchid;
	}

	@Column(name = "BUSITYPE", length = 20)
	public String getBusitype() {
		return this.busitype;
	}

	public void setBusitype(String busitype) {
		this.busitype = busitype;
	}

	@Column(name = "TRADEID", length = 20)
	public String getTradeid() {
		return this.tradeid;
	}

	public void setTradeid(String tradeid) {
		this.tradeid = tradeid;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false, precision = 20, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATE", nullable = false, length = 7)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "BATCH_TYPE", nullable = false, length = 1)
	public String getBatchType() {
		return this.batchType;
	}

	public void setBatchType(String batchType) {
		this.batchType = batchType;
	}

	@Column(name = "LIMITSMS", length = 1)
	public String getLimitsms() {
		return this.limitsms;
	}

	public void setLimitsms(String limitsms) {
		this.limitsms = limitsms;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof InBusiBatchDetail))
			return false;
		InBusiBatchDetail castOther = (InBusiBatchDetail) other;

		return ((this.getAmdocscustomerno() == castOther.getAmdocscustomerno()) || (this
				.getAmdocscustomerno() != null
				&& castOther.getAmdocscustomerno() != null && this
				.getAmdocscustomerno().equals(castOther.getAmdocscustomerno())))
				&& ((this.getMobilenumber() == castOther.getMobilenumber()) || (this
						.getMobilenumber() != null
						&& castOther.getMobilenumber() != null && this
						.getMobilenumber().equals(castOther.getMobilenumber())))
				&& ((this.getStoplevel() == castOther.getStoplevel()) || (this
						.getStoplevel() != null
						&& castOther.getStoplevel() != null && this
						.getStoplevel().equals(castOther.getStoplevel())))
				&& ((this.getVipcardtype() == castOther.getVipcardtype()) || (this
						.getVipcardtype() != null
						&& castOther.getVipcardtype() != null && this
						.getVipcardtype().equals(castOther.getVipcardtype())))
				&& ((this.getAmdocsaccountid() == castOther
						.getAmdocsaccountid()) || (this.getAmdocsaccountid() != null
						&& castOther.getAmdocsaccountid() != null && this
						.getAmdocsaccountid().equals(
								castOther.getAmdocsaccountid())))
				&& ((this.getVoicelinemsisdn() == castOther
						.getVoicelinemsisdn()) || (this.getVoicelinemsisdn() != null
						&& castOther.getVoicelinemsisdn() != null && this
						.getVoicelinemsisdn().equals(
								castOther.getVoicelinemsisdn())))
				&& ((this.getSimcardnumber() == castOther.getSimcardnumber()) || (this
						.getSimcardnumber() != null
						&& castOther.getSimcardnumber() != null && this
						.getSimcardnumber()
						.equals(castOther.getSimcardnumber())))
				&& ((this.getImsi() == castOther.getImsi()) || (this.getImsi() != null
						&& castOther.getImsi() != null && this.getImsi()
						.equals(castOther.getImsi())))
				&& ((this.getModeltype() == castOther.getModeltype()) || (this
						.getModeltype() != null
						&& castOther.getModeltype() != null && this
						.getModeltype().equals(castOther.getModeltype())))
				&& ((this.getPrimarypcnid() == castOther.getPrimarypcnid()) || (this
						.getPrimarypcnid() != null
						&& castOther.getPrimarypcnid() != null && this
						.getPrimarypcnid().equals(castOther.getPrimarypcnid())))
				&& ((this.getRcpcnid() == castOther.getRcpcnid()) || (this
						.getRcpcnid() != null
						&& castOther.getRcpcnid() != null && this.getRcpcnid()
						.equals(castOther.getRcpcnid())))
				&& ((this.getOcpcnid() == castOther.getOcpcnid()) || (this
						.getOcpcnid() != null
						&& castOther.getOcpcnid() != null && this.getOcpcnid()
						.equals(castOther.getOcpcnid())))
				&& ((this.getPriceplanofferinstance() == castOther
						.getPriceplanofferinstance()) || (this
						.getPriceplanofferinstance() != null
						&& castOther.getPriceplanofferinstance() != null && this
						.getPriceplanofferinstance().equals(
								castOther.getPriceplanofferinstance())))
				&& ((this.getAmdocssubscriber() == castOther
						.getAmdocssubscriber()) || (this.getAmdocssubscriber() != null
						&& castOther.getAmdocssubscriber() != null && this
						.getAmdocssubscriber().equals(
								castOther.getAmdocssubscriber())))
				&& ((this.getGrpsrctype() == castOther.getGrpsrctype()) || (this
						.getGrpsrctype() != null
						&& castOther.getGrpsrctype() != null && this
						.getGrpsrctype().equals(castOther.getGrpsrctype())))
				&& ((this.getApnrctype() == castOther.getApnrctype()) || (this
						.getApnrctype() != null
						&& castOther.getApnrctype() != null && this
						.getApnrctype().equals(castOther.getApnrctype())))
				&& ((this.getApnname() == castOther.getApnname()) || (this
						.getApnname() != null
						&& castOther.getApnname() != null && this.getApnname()
						.equals(castOther.getApnname())))
				&& ((this.getIsmaskpublicapn() == castOther
						.getIsmaskpublicapn()) || (this.getIsmaskpublicapn() != null
						&& castOther.getIsmaskpublicapn() != null && this
						.getIsmaskpublicapn().equals(
								castOther.getIsmaskpublicapn())))
				&& ((this.getGrpsinstancein() == castOther.getGrpsinstancein()) || (this
						.getGrpsinstancein() != null
						&& castOther.getGrpsinstancein() != null && this
						.getGrpsinstancein().equals(
								castOther.getGrpsinstancein())))
				&& ((this.getApninstance() == castOther.getApninstance()) || (this
						.getApninstance() != null
						&& castOther.getApninstance() != null && this
						.getApninstance().equals(castOther.getApninstance())))
				&& ((this.getApnprerctype() == castOther.getApnprerctype()) || (this
						.getApnprerctype() != null
						&& castOther.getApnprerctype() != null && this
						.getApnprerctype().equals(castOther.getApnprerctype())))
				&& ((this.getApnprename() == castOther.getApnprename()) || (this
						.getApnprename() != null
						&& castOther.getApnprename() != null && this
						.getApnprename().equals(castOther.getApnprename())))
				&& ((this.getGrpsprerctype() == castOther.getGrpsprerctype()) || (this
						.getGrpsprerctype() != null
						&& castOther.getGrpsprerctype() != null && this
						.getGrpsprerctype()
						.equals(castOther.getGrpsprerctype())))
				&& ((this.getGrpsinstance() == castOther.getGrpsinstance()) || (this
						.getGrpsinstance() != null
						&& castOther.getGrpsinstance() != null && this
						.getGrpsinstance().equals(castOther.getGrpsinstance())))
				&& ((this.getState() == castOther.getState()) || (this
						.getState() != null
						&& castOther.getState() != null && this.getState()
						.equals(castOther.getState())))
				&& ((this.getBatchid() == castOther.getBatchid()) || (this
						.getBatchid() != null
						&& castOther.getBatchid() != null && this.getBatchid()
						.equals(castOther.getBatchid())))
				&& ((this.getBusitype() == castOther.getBusitype()) || (this
						.getBusitype() != null
						&& castOther.getBusitype() != null && this
						.getBusitype().equals(castOther.getBusitype())))
				&& ((this.getTradeid() == castOther.getTradeid()) || (this
						.getTradeid() != null
						&& castOther.getTradeid() != null && this.getTradeid()
						.equals(castOther.getTradeid())))
				&& ((this.getId() == castOther.getId()) || (this.getId() != null
						&& castOther.getId() != null && this.getId().equals(
						castOther.getId())))
				&& ((this.getCreateDate() == castOther.getCreateDate()) || (this
						.getCreateDate() != null
						&& castOther.getCreateDate() != null && this
						.getCreateDate().equals(castOther.getCreateDate())))
				&& ((this.getBatchType() == castOther.getBatchType()) || (this
						.getBatchType() != null
						&& castOther.getBatchType() != null && this
						.getBatchType().equals(castOther.getBatchType())))
				&& ((this.getLimitsms() == castOther.getLimitsms()) || (this
						.getLimitsms() != null
						&& castOther.getLimitsms() != null && this
						.getLimitsms().equals(castOther.getLimitsms())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getAmdocscustomerno() == null ? 0 : this
						.getAmdocscustomerno().hashCode());
		result = 37
				* result
				+ (getMobilenumber() == null ? 0 : this.getMobilenumber()
						.hashCode());
		result = 37 * result
				+ (getStoplevel() == null ? 0 : this.getStoplevel().hashCode());
		result = 37
				* result
				+ (getVipcardtype() == null ? 0 : this.getVipcardtype()
						.hashCode());
		result = 37
				* result
				+ (getAmdocsaccountid() == null ? 0 : this.getAmdocsaccountid()
						.hashCode());
		result = 37
				* result
				+ (getVoicelinemsisdn() == null ? 0 : this.getVoicelinemsisdn()
						.hashCode());
		result = 37
				* result
				+ (getSimcardnumber() == null ? 0 : this.getSimcardnumber()
						.hashCode());
		result = 37 * result
				+ (getImsi() == null ? 0 : this.getImsi().hashCode());
		result = 37 * result
				+ (getModeltype() == null ? 0 : this.getModeltype().hashCode());
		result = 37
				* result
				+ (getPrimarypcnid() == null ? 0 : this.getPrimarypcnid()
						.hashCode());
		result = 37 * result
				+ (getRcpcnid() == null ? 0 : this.getRcpcnid().hashCode());
		result = 37 * result
				+ (getOcpcnid() == null ? 0 : this.getOcpcnid().hashCode());
		result = 37
				* result
				+ (getPriceplanofferinstance() == null ? 0 : this
						.getPriceplanofferinstance().hashCode());
		result = 37
				* result
				+ (getAmdocssubscriber() == null ? 0 : this
						.getAmdocssubscriber().hashCode());
		result = 37
				* result
				+ (getGrpsrctype() == null ? 0 : this.getGrpsrctype()
						.hashCode());
		result = 37 * result
				+ (getApnrctype() == null ? 0 : this.getApnrctype().hashCode());
		result = 37 * result
				+ (getApnname() == null ? 0 : this.getApnname().hashCode());
		result = 37
				* result
				+ (getIsmaskpublicapn() == null ? 0 : this.getIsmaskpublicapn()
						.hashCode());
		result = 37
				* result
				+ (getGrpsinstancein() == null ? 0 : this.getGrpsinstancein()
						.hashCode());
		result = 37
				* result
				+ (getApninstance() == null ? 0 : this.getApninstance()
						.hashCode());
		result = 37
				* result
				+ (getApnprerctype() == null ? 0 : this.getApnprerctype()
						.hashCode());
		result = 37
				* result
				+ (getApnprename() == null ? 0 : this.getApnprename()
						.hashCode());
		result = 37
				* result
				+ (getGrpsprerctype() == null ? 0 : this.getGrpsprerctype()
						.hashCode());
		result = 37
				* result
				+ (getGrpsinstance() == null ? 0 : this.getGrpsinstance()
						.hashCode());
		result = 37 * result
				+ (getState() == null ? 0 : this.getState().hashCode());
		result = 37 * result
				+ (getBatchid() == null ? 0 : this.getBatchid().hashCode());
		result = 37 * result
				+ (getBusitype() == null ? 0 : this.getBusitype().hashCode());
		result = 37 * result
				+ (getTradeid() == null ? 0 : this.getTradeid().hashCode());
		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37
				* result
				+ (getCreateDate() == null ? 0 : this.getCreateDate()
						.hashCode());
		result = 37 * result
				+ (getBatchType() == null ? 0 : this.getBatchType().hashCode());
		result = 37 * result
				+ (getLimitsms() == null ? 0 : this.getLimitsms().hashCode());
		return result;
	}

}