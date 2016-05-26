package com.asiainfo.boss4.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;

@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@IdClass(AccRemindUserLabel.AccRemindUserLabelId.class)
@Table(name = "ACC_REMIND_USER_LABEL", schema = "INTER")
@CommonDao(fieldOfSelectConditions = { "labelId","expireDate"},fieldOfDBSelectConditions={"label_id","expire_date"}, dataStoreMode = DataStoreMode.DIRECT_UPDATE)
@Backup.CopyToSuffix(isIgnore = true)
public class AccRemindUserLabel extends BaseEntity implements java.io.Serializable {

	// Fields
	private Long labelId;  
	private String labelName; 
	private String labelDesc; 
	private Date createDate;  
	private Date validDate;    
	private Date expireDate;  
	  
	// Constructors
	/** default constructor */
	public AccRemindUserLabel() {
	}

	public AccRemindUserLabel(Long labelId, String labelName, String labelDesc, Date createDate,Date validDate,Date expireDate) {
		this.labelId = labelId;
		this.labelName = labelName;
		this.labelDesc = labelDesc;
		this.createDate = createDate;
		this.validDate = validDate;
		this.expireDate = expireDate;
	}
	
	// Property accessors
	@Id
	public Long getLabelId() {
		return labelId;
	}
	
	public void setLabelId(Long labelId) {
		this.labelId = labelId;
	}
	
	@Column(name = "LABEL_NAME")
    public String getLabelName() {
		return labelName;
	}
	
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	
	@Column(name = "LABEL_DESC")
	public String getLabelDesc() {
		return labelDesc;
	}
	
	public void setLabelDesc(String labelDesc) {
		this.labelDesc = labelDesc;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", nullable = false, length = 7)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
		return this.expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
		
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("labelId",getLabelId())
			.append("labelName",getLabelName())
			.append("labelDesc",getLabelDesc())
			.append("createDate",getCreateDate())
			.append("validDate",getValidDate())
			.append("expireDate",getExpireDate())
			.toString();
	}
	
	public static class AccRemindUserLabelId implements java.io.Serializable {
		
		private Long labelId; 
		
		// Constructors

		/** default constructor */
		public AccRemindUserLabelId() {
		}

		/** full constructor */
		public AccRemindUserLabelId(Long labelId) {
			this.labelId = labelId;
		}

		@Column(name = "LABEL_ID", nullable = false, precision = 6, scale = 0)
	    public Long getLabelId() {
		   return labelId;
	    }
	
	    public void setLabelId(Long labelId) {
		   this.labelId = labelId;
	    }
	    
		@Override
		public boolean equals(Object other) {
			if ( !(other instanceof AccRemindUserLabelId) ) return false;
			AccRemindUserLabelId castOther = (AccRemindUserLabelId) other;
			return new EqualsBuilder()
				.append(this.getLabelId(), castOther.getLabelId())
				.isEquals();
		}
		
		@Override
		public int hashCode() {
			return new HashCodeBuilder()
			.append(getLabelId())
			.toHashCode();
		}
	}
	
	@Override
	public BaseEntity add(ServiceContext context) {
		BusinessDao dao = (BusinessDao)context.getBeanFactory().getBean("businessDao");
		Long label=dao.getLableidSequence();
		this.setLabelId(label);
		return super.add(context);
	}	

}