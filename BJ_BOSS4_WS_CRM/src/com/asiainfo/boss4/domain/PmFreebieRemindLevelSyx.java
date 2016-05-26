package com.asiainfo.boss4.domain;

import java.util.Date;

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

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "PM_FREEBIE_REMIND_LEVEL_SYX", schema = "CP")
@IdClass(PmFreebieRemindLevelSyx.PmFreebieRemindLevelSyxId.class)
@Backup.CopyToSuffix(isIgnore = true)
@CommonDao(fieldOfSelectConditions = { "freebieId", "remindResCount", "prodId", "regionCode", "alarmId", "remindFlow", "expireDate" },fieldOfDBSelectConditions={"FREEBIE_ID", "REMIND_RES_COUNT", "PROD_ID", "REGION_CODE", "ALARM_ID", "remind_Flow", "EXPIRE_DATE"}, dataStoreMode = DataStoreMode.DIRECT_UPDATE)
public class PmFreebieRemindLevelSyx extends BaseEntity implements java.io.Serializable{

	// Fields

	private Short remindType;
	private Short denominator;
	private Short numerator; 
	private Short remindFlow;
	private Short regionCode;
	private Integer freebieId;
	private Integer prodId;
	private Integer alarmId;
	private Long remindResCount;
	private Date validDate;
	private Date expireDate;
	private String remindContent;
	private String prodName;
	private String remindEnd;
	
	private Byte operType;
	private String templetId;
	private String templeName;
	
		// Constructors

	/** default constructor */
	public PmFreebieRemindLevelSyx() {
	}

	public PmFreebieRemindLevelSyx(Short remindType, Short denominator, Short numerator,
			Short remindFlow, Short regionCode, Integer freebieId,
			Integer prodId, Integer alarmId, Long remindResCount, Date validDate,
			Date expireDate, String remindContent, String prodName,
			String remindEnd, Byte operType, String templetId, String templeName) {
		this.denominator = denominator;
		this.numerator = numerator;
		this.remindFlow = remindFlow;
		this.regionCode = regionCode;
		this.freebieId = freebieId;
		this.prodId = prodId;
		this.remindResCount = remindResCount;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.remindContent = remindContent;
		this.prodName = prodName;
		this.remindEnd = remindEnd;
		this.operType = operType;
		this.templetId = templetId;
		this.templeName = templeName;
		this.alarmId = alarmId;
		this.remindType = remindType;
	}

	// Property accessors
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

	@Id
	public Short getRemindFlow() {
		return remindFlow;
	}

	public void setRemindFlow(Short remindFlow) {
		this.remindFlow = remindFlow;
	}

	@Id
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

	@Id
	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
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

	@Transient
	public Byte getOperType() {
		return operType;
	}

	public void setOperType(Byte operType) {
		this.operType = operType;
	}

	@Transient
	public String getTempletId() {
		return templetId;
	}

	public void setTempletId(String templetId) {
		this.templetId = templetId;
	}

	@Transient
	public String getTempleName() {
		return templeName;
	}

	public void setTempleName(String templeName) {
		this.templeName = templeName;
	}

	@Id
	public Integer getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(Integer alarmId) {
		this.alarmId = alarmId;
	}

	@Column(name = "REMIND_TYPE", precision = 1, scale = 0)
	public Short getRemindType() {
		return remindType;
	}

	public void setRemindType(Short remindType) {
		this.remindType = remindType;
	}

	public static class PmFreebieRemindLevelSyxId implements java.io.Serializable {

		// Fields
		private Short regionCode;
		private Short remindFlow;
		private Integer freebieId;
		private Integer prodId;
		private Integer alarmId;
		private Long remindResCount;
		
		
		public PmFreebieRemindLevelSyxId() {

		}
		
		public PmFreebieRemindLevelSyxId(Short regionCode, Short remindFlow, Integer freebieId,
				Integer prodId, Integer alarmId, Long remindResCount) {

			this.regionCode = regionCode;
			this.remindFlow = remindFlow;
			this.freebieId = freebieId;
			this.prodId = prodId;
			this.alarmId = alarmId;
			this.remindResCount = remindResCount;
		}
		
		@Column(name = "REGION_CODE", precision = 4, scale = 0)
		public Short getRegionCode() {
			return regionCode;
		}
		public void setRegionCode(Short regionCode) {
			this.regionCode = regionCode;
		}
		
		@Column(name = "FREEBIE_ID", nullable = false, precision = 8, scale = 0)
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
		
		@Column(name = "REMIND_RES_COUNT", nullable = false, precision = 14, scale = 0)
		public Long getRemindResCount() {
			return remindResCount;
		}
		public void setRemindResCount(Long remindResCount) {
			this.remindResCount = remindResCount;
		}
		
		@Column(name = "REMIND_FLOW", precision = 2, scale = 0)
		public Short getRemindFlow() {
			return remindFlow;
		}

		public void setRemindFlow(Short remindFlow) {
			this.remindFlow = remindFlow;
		}
		
		@Override
		public boolean equals(Object other) {
	        if ( !(other instanceof PmFreebieRemindLevelSyxId) ) return false;
	        PmFreebieRemindLevelSyxId castOther = (PmFreebieRemindLevelSyxId) other;
	        return new EqualsBuilder()
	            .append(this.getRegionCode(), castOther.getRegionCode())
	            .append(this.getRemindFlow(), castOther.getRemindFlow())
	            .append(this.getFreebieId(), castOther.getFreebieId())
	            .append(this.getProdId(), castOther.getProdId())
	            .append(this.getAlarmId(), castOther.getAlarmId())
	            .append(this.getRemindResCount(), castOther.getRemindResCount())
	            .isEquals();
	    }
		
		@Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getRegionCode())
	            .append(getRemindFlow())
	            .append(getFreebieId())
	            .append(getProdId())
	            .append(getAlarmId())
	            .append(getRemindResCount())
	            .toHashCode();
	    }
	}
	
}
