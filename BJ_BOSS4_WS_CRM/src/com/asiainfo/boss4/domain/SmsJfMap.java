package com.asiainfo.boss4.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.annotation.Backup;
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "SMS_JF_MAP", schema = "INTER")
@IdClass(SmsJfMap.SmsJfMapId.class)
@Backup.CopyToSuffix(isIgnore = true)
public class SmsJfMap extends BaseEntity implements java.io.Serializable{
	// Fields

	private Short remindType;
	private Short denominator;
	private Short numerator; 
	private Short remindFlow;
	private Short regionCode;
	private Short smsOrderType;
	private Integer freebieId;
	private Integer prodId;
	private Integer alarmId;
	private Long remindResCount;
	private Date validDate;
	private Date expireDate;
	private String remindContent;
	private String prodName;
	private String remindEnd;
	private String templetId;
	private String templeName;
	
	private Byte operType;
	
	public SmsJfMap() {
	}

	public SmsJfMap(Short remindType, Short denominator, Short numerator,
			Short remindFlow, Short regionCode, Short smsOrderType, Integer freebieId,
			Integer prodId, Integer alarmId, Long remindResCount,
			Date validDate, Date expireDate, String remindContent,
			String prodName, String remindEnd, String templetId,
			String templeName) {
		this.remindType = remindType;
		this.denominator = denominator;
		this.numerator = numerator;
		this.remindFlow = remindFlow;
		this.regionCode = regionCode;
		this.freebieId = freebieId;
		this.prodId = prodId;
		this.alarmId = alarmId;
		this.remindResCount = remindResCount;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.remindContent = remindContent;
		this.prodName = prodName;
		this.remindEnd = remindEnd;
		this.templetId = templetId;
		this.templeName = templeName;
		this.smsOrderType = smsOrderType;
	}

	@Column(name = "SMS_ORDER_TYPE", precision = 2, scale = 0)
	public Short getSmsOrderType() {
		return smsOrderType;
	}

	public void setSmsOrderType(Short smsOrderType) {
		this.smsOrderType = smsOrderType;
	}
	
	@Column(name = "REMIND_TYPE", precision = 1, scale = 0)
	public Short getRemindType() {
		return remindType;
	}

	public void setRemindType(Short remindType) {
		this.remindType = remindType;
	}

	@Column(name = "DENOMINATOR", precision = 4, scale = 0)
	public Short getDenominator() {
		return denominator;
	}

	public void setDenominator(Short denominator) {
		this.denominator = denominator;
	}

	@Column(name = "NUMERATOR", precision = 4, scale = 0)
	public Short getNumerator() {
		return numerator;
	}

	public void setNumerator(Short numerator) {
		this.numerator = numerator;
	}

	@Column(name = "REMIND_FLOW", precision = 2, scale = 0)
	public Short getRemindFlow() {
		return remindFlow;
	}

	public void setRemindFlow(Short remindFlow) {
		this.remindFlow = remindFlow;
	}

	@Column(name = "REGION_CODE", precision = 4, scale = 0)
	public Short getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Id
	public Integer getFreebieId() {
		return freebieId;
	}

	public void setFreebieId(Integer freebieId) {
		this.freebieId = freebieId;
	}

	@Column(name = "PROD_ID", nullable = false, precision = 8, scale = 0)
	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	@Column(name = "ALARM_ID", nullable = false, precision = 8, scale = 0)
	public Integer getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(Integer alarmId) {
		this.alarmId = alarmId;
	}

	@Id
	public Long getRemindResCount() {
		return remindResCount;
	}

	public void setRemindResCount(Long remindResCount) {
		this.remindResCount = remindResCount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VALID_DATE", nullable = false, length = 7)
	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRE_DATE", nullable = false, length = 7)
	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Column(name = "REMIND_CONTENT")
	public String getRemindContent() {
		return remindContent;
	}

	public void setRemindContent(String remindContent) {
		this.remindContent = remindContent;
	}

	@Column(name = "PROD_NAME")
	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	@Column(name = "REMIND_END")
	public String getRemindEnd() {
		return remindEnd;
	}

	public void setRemindEnd(String remindEnd) {
		this.remindEnd = remindEnd;
	}

	@Id
	public String getTempletId() {
		return templetId;
	}

	public void setTempletId(String templetId) {
		this.templetId = templetId;
	}

	@Column(name = "TEMPLET_NAME")
	public String getTempleName() {
		return templeName;
	}

	public void setTempleName(String templeName) {
		this.templeName = templeName;
	}
	
	@Transient
	public Byte getOperType() {
		return operType;
	}

	public void setOperType(Byte operType) {
		this.operType = operType;
	}

	public static class SmsJfMapId implements java.io.Serializable {

		// Fields
		private Integer freebieId;
		private Long remindResCount;
		private String templetId;
		
		
		public SmsJfMapId() {

		}
		
		public SmsJfMapId(Integer freebieId, Long remindResCount, String templetId) {

			this.templetId = templetId;
			this.freebieId = freebieId;
			this.remindResCount = remindResCount;
		}
		
		
		@Column(name = "FREEBIE_ID", nullable = false, precision = 8, scale = 0)
		public Integer getFreebieId() {
			return freebieId;
		}
		public void setFreebieId(Integer freebieId) {
			this.freebieId = freebieId;
		}
		
		
		@Column(name = "REMIND_RES_COUNT", nullable = false, precision = 14, scale = 0)
		public Long getRemindResCount() {
			return remindResCount;
		}
		public void setRemindResCount(Long remindResCount) {
			this.remindResCount = remindResCount;
		}
		
		@Column(name = "TEMPLET_ID")
		public String getTempletId() {
			return templetId;
		}

		public void setTempletId(String templetId) {
			this.templetId = templetId;
		}

		@Override
		public boolean equals(Object other) {
	        if ( !(other instanceof SmsJfMapId) ) return false;
	        SmsJfMapId castOther = (SmsJfMapId) other;
	        return new EqualsBuilder()
	            .append(this.getTempletId(), castOther.getTempletId())
	            .append(this.getFreebieId(), castOther.getFreebieId())
	            .append(this.getRemindResCount(), castOther.getRemindResCount())
	            .isEquals();
	    }
		
		@Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getTempletId())
	            .append(getFreebieId())
	            .append(getRemindResCount())
	            .toHashCode();
	    }
	}
	
	@Override
	public BaseEntity add(ServiceContext context) {
		BusinessDao dao = (BusinessDao) context.getBeanFactory().getBean("businessDao");
		if (this.getTempletId()!= null && !"".equals(this.getTempletId()))
		{
			if (this.getRemindContent() == null || "".equals(this.getRemindContent()))
				throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR,"添加数据流量提醒个性化配置必须提供RemindContent");
			if (this.getRemindEnd() == null || "".equals(this.getRemindEnd()))
				throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR,"添加数据流量提醒个性化配置必须提供RemindEnd");
			if (this.getProdName() == null || "".equals(this.getProdName()))
				throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR,"添加数据流量提醒个性化配置必须提供ProdName");
			if (this.getSmsOrderType() == null || "".equals(this.getSmsOrderType()))
				throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR,"添加数据流量提醒个性化配置必须提供SmsOrderType");
			
			if (this.getTempletId().startsWith("10") || this.getTempletId().startsWith("60"))
			{
				List<SmsJfMap> smsJfMapList = dao.getSmsJfMap(this.getTempletId().substring(0, 2));
				for (int i=0;i<smsJfMapList.size();i++)
				{
					SmsJfMap smsJfMap = (SmsJfMap)smsJfMapList.get(i);
					if (this.getTempletId().startsWith("10"))
					{
						PmFreebieRemindLevel freebieRemind = new PmFreebieRemindLevel();
						BeanCopyHelper.copyBeanNotNullProperty(freebieRemind, smsJfMap);
						freebieRemind.setRemindResCount(this.getRemindResCount());
						freebieRemind.setValidDate(this.getValidDate());
						freebieRemind.setExpireDate(this.getExpireDate());
						freebieRemind.setRemindContent(this.getRemindContent());
						freebieRemind.setRemindEnd(this.getRemindEnd());
						freebieRemind.setProdName(this.getProdName());
						dao.add(freebieRemind);
						
					}
					else if (this.getTempletId().startsWith("60"))
					{
						PmFreebieRemindLevelSyx freebieRemind = new PmFreebieRemindLevelSyx();
						BeanCopyHelper.copyBeanNotNullProperty(freebieRemind, smsJfMap);
						freebieRemind.setRemindResCount(this.getRemindResCount());
						freebieRemind.setValidDate(this.getValidDate());
						freebieRemind.setExpireDate(this.getExpireDate());
						freebieRemind.setRemindContent(this.getRemindContent());
						freebieRemind.setRemindEnd(this.getRemindEnd());
						freebieRemind.setProdName(this.getProdName());
						dao.add(freebieRemind);
					}
					SmsJfMap smsJfMapNew = new SmsJfMap();
					BeanCopyHelper.copyBeanNotNullProperty(smsJfMapNew, smsJfMap);
					smsJfMapNew.setTempletId(this.getTempletId());
					smsJfMapNew.setTempleName(this.getTempleName());
					smsJfMapNew.setValidDate(this.getValidDate());
					smsJfMapNew.setExpireDate(this.getExpireDate());
					smsJfMapNew.setRemindResCount(this.getRemindResCount());
					smsJfMapNew.setRemindContent(this.getRemindContent());
					smsJfMapNew.setRemindEnd(this.getRemindEnd());
					smsJfMapNew.setProdName(this.getProdName());
					dao.add(smsJfMapNew);
				}
				return this;
			}
			else
				throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR,"只能添加TempletId以10或60开头的数据流量提醒个性化配置");
		}
		else
			throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR,"添加数据流量提醒个性化配置必须提供TempletId");
		
	}
	
	@Override
	public BaseEntity modify(ServiceContext context) {
		BusinessDao dao = (BusinessDao) context.getBeanFactory().getBean("businessDao");
		if (this.getTempletId()!= null && !"".equals(this.getTempletId()))
		{		
			List<SmsJfMap> smsJfMapList = dao.getSmsJfMap(this.getTempletId());
			for (int i=0;i<smsJfMapList.size();i++)
			{
				SmsJfMap smsJfMap = (SmsJfMap)smsJfMapList.get(i);
				if (this.getTempletId().startsWith("1")||this.getTempletId().startsWith("2")||this.getTempletId().startsWith("3")||this.getTempletId().startsWith("4")||this.getTempletId().startsWith("5"))
				{
					PmFreebieRemindLevel freebieRemind = new PmFreebieRemindLevel();
					BeanCopyHelper.copyBeanNotNullProperty(freebieRemind, smsJfMap);
					freebieRemind.setRemindContent(this.getRemindContent());
					freebieRemind.setRemindEnd(this.getRemindEnd());
					freebieRemind.setProdName(this.getProdName());
					dao.update(freebieRemind);
						
				}
				else if (this.getTempletId().startsWith("6")||this.getTempletId().startsWith("7")||this.getTempletId().startsWith("8")||this.getTempletId().startsWith("9"))
				{
					PmFreebieRemindLevelSyx freebieRemind = new PmFreebieRemindLevelSyx();
					BeanCopyHelper.copyBeanNotNullProperty(freebieRemind, smsJfMap);
					freebieRemind.setRemindContent(this.getRemindContent());
					freebieRemind.setRemindEnd(this.getRemindEnd());
					freebieRemind.setProdName(this.getProdName());
					dao.update(freebieRemind);
						
				}
				
				smsJfMap.setRemindContent(this.getRemindContent());
				smsJfMap.setRemindEnd(this.getRemindEnd());
				smsJfMap.setProdName(this.getProdName());
				dao.update(smsJfMap);
				
			}
			if (smsJfMapList.size() == 0)
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR,"没有可修改数据流量提醒个性化配置.TempletId="+this.getTempletId());
			return this;
		}
		else
			throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR,"修改数据流量提醒个性化配置必须提供TempletId");
		
	}
	
	@Override
	public BaseEntity cancel(ServiceContext context) {
		throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR,"数据流量提醒个性化配置不能做删除");
	}
	
	@Override
	public BaseEntity rollBack(ServiceContext context) {
		throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR,"数据流量提醒个性化配置不能做回滚");
	}
}
