package com.asiainfo.boss4.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.OperateType;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "ACC_SMS_TEMPLET_DEF", schema = "ZG")
@Backup.CopyToSuffix(isIgnore = true)
@CommonDao(fieldOfSelectConditions = { "templetId"},fieldOfDBSelectConditions={"templet_Id"}, dataStoreMode = DataStoreMode.DIRECT_UPDATE)
public class AccSmsTempletDef extends BaseEntity implements java.io.Serializable {
	// Fields
	private Byte operType = Byte.valueOf(OperateType.MODIFY.getTypeCode());
	private Short templetType;
	private Short regionCode;
	private Short smsType;
	private Short smsTmplType;
	private Short sortFlag;
	private Short sts;
	private String templetId;
	private String outerSmsCode;
	private String smsName;
	private String smsTemplet;
	private String remarks;
	private List<SysCont> sysCont;
	
	
	// Constructors

	/** default constructor */
	public AccSmsTempletDef() {
	}


	/** full constructor */
	public AccSmsTempletDef(String templetId, Short templetType,
			Short regionCode, String outerSmsCode, Short smsType,
			String smsName, Short smsTmplType, String smsTemplet,
			Short sortFlag, Short sts, String remarks,List<SysCont> sysCont) {
		this.templetId = templetId;
		this.templetType = templetType;
		this.regionCode = regionCode;
		this.outerSmsCode = outerSmsCode;
		this.smsType = smsType;
		this.smsName = smsName;
		this.smsTmplType = smsTmplType;
		this.smsTemplet = smsTemplet;
		this.sortFlag = sortFlag;
		this.sts = sts;
		this.remarks = remarks;
		this.sysCont = sysCont;
	}

	// Property accessors
	@Id
	@Column(name = "TEMPLET_ID", nullable = false, length = 32)
	public String getTempletId() {
		return templetId;
	}


	public void setTempletId(String templetId) {
		this.templetId = templetId;
	}

	@Column(name = "TEMPLET_TYPE", nullable = false, precision = 4, scale = 0)
	public Short getTempletType() {
		return templetType;
	}


	public void setTempletType(Short templetType) {
		this.templetType = templetType;
	}

	@Column(name = "REGION_CODE", nullable = false, precision = 4, scale = 0)
	public Short getRegionCode() {
		return regionCode;
	}


	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "OUTER_SMS_CODE", nullable = false, length = 32)
	public String getOuterSmsCode() {
		return outerSmsCode;
	}


	public void setOuterSmsCode(String outerSmsCode) {
		this.outerSmsCode = outerSmsCode;
	}

	@Column(name = "SMS_TYPE", nullable = false, precision = 4, scale = 0)
	public Short getSmsType() {
		return smsType;
	}


	public void setSmsType(Short smsType) {
		this.smsType = smsType;
	}

	@Column(name = "SMS_NAME", nullable = false, length = 64)
	public String getSmsName() {
		return smsName;
	}


	public void setSmsName(String smsName) {
		this.smsName = smsName;
	}

	@Column(name = "SMS_TMPL_TYPE", nullable = false, precision = 4, scale = 0)
	public Short getSmsTmplType() {
		return smsTmplType;
	}

	public void setSmsTmplType(Short smsTmplType) {
		this.smsTmplType = smsTmplType;
	}

	@Column(name = "SMS_TEMPLET", nullable = false, length = 4000)
	public String getSmsTemplet() {
		return smsTemplet;
	}


	public void setSmsTemplet(String smsTemplet) {
		this.smsTemplet = smsTemplet;
	}

	@Column(name = "SORT_FLAG", precision = 4, scale = 0)
	public Short getSortFlag() {
		return sortFlag;
	}


	public void setSortFlag(Short sortFlag) {
		this.sortFlag = sortFlag;
	}

	@Column(name = "STS", nullable = false, precision = 2, scale = 0)
	public Short getSts() {
		return sts;
	}


	public void setSts(Short sts) {
		this.sts = sts;
	}

	@Column(name = "REMARKS")
	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Transient
	public OperateType getTheOperateType() {
		return OperateType.MODIFY;
	}

	@Transient
	public Byte getOperType() {
		return operType;
	}
	
	@Transient
	public List<SysCont> getSysCont() {
		return sysCont;
	}


	public void setSysCont(List<SysCont> sysCont) {
		this.sysCont = sysCont;
	}

	public static class SysCont implements java.io.Serializable {

		// Fields

		String originalSms;
		String finalSms;
		
		public SysCont(){
			
		}
		
		public SysCont(String originalSms, String finalSms) {
			this.originalSms = originalSms;
			this.finalSms = finalSms;
		}


		@Transient
		public String getOriginalSms() {
			return originalSms;
		}


		public void setOriginalSms(String originalSms) {
			this.originalSms = originalSms;
		}

		@Transient
		public String getFinalSms() {
			return finalSms;
		}


		public void setFinalSms(String finalSms) {
			this.finalSms = finalSms;
		}
		
	}
	
	@Override
	public BaseEntity add(ServiceContext context) {
		throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
	}
	
	@Override
	public BaseEntity cancel(ServiceContext context) {
		throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
	}
	
	@Override
	public BaseEntity modify(ServiceContext context) {
		BusinessDao dao = (BusinessDao)context.getBeanFactory().getBean("businessDao");
		AccSmsTempletDef accSms = (AccSmsTempletDef)dao.getEntity(this, this.getFieldOfSelectConditionsOnCommonDaoAnnotation());
		if (accSms != null)
		{
			if (this.getSysCont() != null)
			{
				for (int i=0;i<this.getSysCont().size();i++)
				{
					SysCont sysCont = this.getSysCont().get(i);
					while(accSms.getSmsTemplet().indexOf(sysCont.getOriginalSms())>=0)
					{
						accSms.setSmsTemplet(accSms.getSmsTemplet().substring(0,accSms.getSmsTemplet().indexOf(sysCont.getOriginalSms()))+ sysCont.getFinalSms()+accSms.getSmsTemplet().substring(accSms.getSmsTemplet().indexOf(sysCont.getOriginalSms())+sysCont.getOriginalSms().length()));
					}
				}
			}
			dao.update(accSms);
		}
		else
			throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
		return this;
	}
}
