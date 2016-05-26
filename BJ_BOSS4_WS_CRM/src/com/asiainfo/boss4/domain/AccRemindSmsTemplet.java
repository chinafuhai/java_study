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
import org.apache.commons.lang.builder.ToStringBuilder;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;

@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate = true)
@Table(name = "ACC_REMIND_SMS_TEMPLET", schema = "INTER")
@IdClass(AccRemindSmsTemplet.AccRemindSmsTempletId.class)
@CommonDao(fieldOfSelectConditions = { "templetId", "segmentSeq", "priority", "validDate" }, fieldOfDBSelectConditions = { "templet_Id","segment_Seq", "priority", "valid_Date" }, isAlertWhenExist = true, dataStoreMode = DataStoreMode.DIRECT_UPDATE)
public class AccRemindSmsTemplet extends BaseEntity implements java.io.Serializable {

	// Fields
	private Long templetId;
	private Long segmentSeq;
	private String expression;
	private String smsContent;
	private String remark;
	private String allowModify;
	private String modifyDesc;
	private Integer priority;
	private Date validDate;
	private Date expireDate;
	private Long opId;
	private Date opTime;

    private String brands;
    private String labels;
    private String tag4g;
	
	// Constructors
	/** default constructor */
	public AccRemindSmsTemplet() {
	}

	public AccRemindSmsTemplet(Long templetId, Long segmentSeq,
			String expression, String smsContent, String remark,
			String allowModify, String modifyDesc, Integer priority,
			Date validDate, Date expireDate, Long opId, Date opTime) {
		this.templetId = templetId;
		this.segmentSeq = segmentSeq;
		this.expression = expression;
		this.smsContent = smsContent;
		this.remark = remark;
		this.allowModify = allowModify;
		this.modifyDesc = modifyDesc;
		this.priority = priority;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.opId = opId;
		this.opTime = opTime;
	}

	// Property accessors
	@Id
	public Long getTempletId() {
		return templetId;
	}

	public void setTempletId(Long templetId) {
		this.templetId = templetId;
	}

	@Id
	public Long getSegmentSeq() {
		return segmentSeq;
	}

	public void setSegmentSeq(Long segmentSeq) {
		this.segmentSeq = segmentSeq;
	}

	@Column(name = "EXPRESSION", length = 512)
	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	@Column(name = "SMS_CONTENT")
	public String getSmsContent() {
		return smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "ALLOW_MODIFY")
	public String getAllowModify() {
		return allowModify;
	}

	public void setAllowModify(String allowModify) {
		this.allowModify = allowModify;
	}

	@Column(name = "MODIFY_DESC")
	public String getModifyDesc() {
		return modifyDesc;
	}

	public void setModifyDesc(String modifyDesc) {
		this.modifyDesc = modifyDesc;
	}

	@Id
	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@Id
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

	@Column(name = "OP_ID")
	public Long getOpId() {
		return opId;
	}

	public void setOpId(Long opId) {
		this.opId = opId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "OP_TIME", nullable = false, length = 7)
	public Date getOpTime() {
		return this.opTime;
	}

	public void setOpTime(Date opTime) {
		this.opTime = opTime;
	}

    @Transient
    public String getBrands() {
        return brands;
    }

    public void setBrands(String brands) {
        this.brands = brands;
    }

    @Transient
    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }
  
    @Transient
    public String getTag4g() {
        return tag4g;
    }

    public void setTag4g(String tag4g) {
          this.tag4g = tag4g;
    }
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("templetId", getTempletId())
				.append("segmentSeq", getSegmentSeq())
				.append("expression",getExpression())
				.append("smsContent", getSmsContent())
				.append("remark", getRemark())
				.append("allowModify",getAllowModify())
				.append("modifyDesc", getModifyDesc())
				.append("priority", getPriority())
				.append("validDate",getValidDate())
				.append("expireDate", getExpireDate())
				.append("opId", getOpId())
				.append("opTime", getOpTime())
				.toString();
	}

	public static class AccRemindSmsTempletId implements java.io.Serializable {

		private Long templetId;
		private Long segmentSeq;
		private Integer priority;
		private Date validDate;

		// Constructors

		/** default constructor */
		public AccRemindSmsTempletId() {
		}

		/** full constructor */
		public AccRemindSmsTempletId(Long templetId, Long segmentSeq,Integer priority, Date validDate) {
			this.templetId = templetId;
			this.segmentSeq = segmentSeq;
			this.priority = priority;
			this.validDate = validDate;
		}

		@Column(name = "TEMPLET_ID", nullable = false, precision = 8, scale = 0)
		public Long getTempletId() {
			return templetId;
		}

		public void setTempletId(Long templetId) {
			this.templetId = templetId;
		}

		@Column(name = "SEGMENT_SEQ", nullable = false, precision = 8, scale = 0)
		public Long getSegmentSeq() {
			return segmentSeq;
		}

		public void setSegmentSeq(Long segmentSeq) {
			this.segmentSeq = segmentSeq;
		}
		
		@Column(name = "PRIORITY", nullable = false, precision = 4, scale = 0)
		public Integer getPriority() {
			return priority;
		}

		public void setPriority(Integer priority) {
			this.priority = priority;
		}

		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "VALID_DATE", nullable = false, length = 7)
		public Date getValidDate() {
			return this.validDate;
		}

		public void setValidDate(Date validDate) {
			this.validDate = validDate;
		}

		@Override
		public boolean equals(Object other) {
			if (!(other instanceof AccRemindSmsTempletId))
				return false;
			AccRemindSmsTempletId castOther = (AccRemindSmsTempletId) other;
			return new EqualsBuilder().append(this.getTempletId(),castOther.getTempletId())
					.append(this.getSegmentSeq(), castOther.getSegmentSeq())
					.append(this.getPriority(), castOther.getPriority())
					.append(this.getValidDate(), castOther.getValidDate())
					.isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder().append(getTempletId()).append(getSegmentSeq()).append(getPriority()).append(getValidDate()).toHashCode();
		}
	}



    @Override
    public BaseEntity add(ServiceContext context) {
    	BusinessDao dao = (BusinessDao)context.getBeanFactory().getBean("businessDao");
    	
        String xmlbrands=this.getBrands();
        String xmllabels=this.getLabels();
        String xmltag4g=this.getTag4g();
        String brands = "";
        String labels = "";
        String tag4g = "";
        String newExpression = "";
            
        if(xmlbrands != null && !"".equals(xmlbrands)){
           brands="brand in ("+ xmlbrands +")";
        }
        if(xmllabels != null && !"".equals(xmllabels)){
           labels="user_label in ("+ xmllabels +")";
        } 
        if(xmltag4g != null && !"".equals(xmltag4g)){
           if ("1".equals(xmltag4g)){
                tag4g = "sms_order_type in (34)";
           }
           if ("0".equals(xmltag4g)){
                tag4g = "sms_order_type not in (34)";
           }
        }       
        
        StringBuffer sb= new StringBuffer();
        if(!"".equals(brands)){
        	sb.append(brands).append(" & ");
        }
        if(!"".equals(labels)){
        	sb.append(labels).append(" & ");
        }
        if(!"".equals(tag4g)){
        	sb.append(tag4g).append(" & ");
        }
        
        if(sb.length()>0){
        	newExpression = sb.replace(sb.length()-3,sb.length(), "").toString();
        }else{
        	newExpression = this.getExpression();
        }
        

        
        List smsTemplet=dao.getEntityListSmsTemplet(this);
    	if (smsTemplet.size() > 0){
     	    throw new BossException(StatusCode.MODIFY_ENTITY_SMS_TEMPLET_ERROR, "短信模板:"+StatusCode.MODIFY_ENTITY_SMS_TEMPLET_ERROR.getDescription());
     	}else{
            this.setExpression(newExpression);
     	    this.setAllowModify("YES");
     	    this.setRemark("");
            if(this.getSmsContent() == null){
            	this.setSmsContent(" ");
            }
     	    return super.add(context);
     	}
    }
    
    @Override
    public BaseEntity modify(ServiceContext context) {
        BusinessDao dao = (BusinessDao)context.getBeanFactory().getBean("businessDao");
        AccRemindSmsTemplet accRemindSmsTemplet = (AccRemindSmsTemplet)dao.getEntity(this, new String[]{"templetId","segmentSeq","priority","validDate"});
            
        String xmlbrands=this.getBrands();
        String xmllabels=this.getLabels();
        String xmltag4g=this.getTag4g();
        String brands = "";
        String labels = "";
        String tag4g = "";
        String newExpression = "";
            
        if(xmlbrands != null && !"".equals(xmlbrands)){
           brands="brand in ("+ xmlbrands +")";
        }
        if(xmllabels != null && !"".equals(xmllabels)){
           labels="user_label in ("+ xmllabels +")";
        } 
        if(xmltag4g != null && !"".equals(xmltag4g)){
           if ("1".equals(xmltag4g)){
                tag4g = "sms_order_type in (34)";
           }
           if ("0".equals(xmltag4g)){
                tag4g = "sms_order_type not in (34)";
           }
        } 
            
        StringBuffer sb= new StringBuffer();
        if(!"".equals(brands)){
        	sb.append(brands).append(" & ");
        }
        if(!"".equals(labels)){
        	sb.append(labels).append(" & ");
        }
        if(!"".equals(tag4g)){
        	sb.append(tag4g).append(" & ");
        }
        
        if(sb.length()>0){
        	newExpression = sb.replace(sb.length()-3,sb.length(), "").toString();
        }else{
        	newExpression = this.getExpression();
        }
                            
        if (accRemindSmsTemplet == null){
        	List smsTemplet=dao.getEntityListSmsTemplet(this);
        	
        	if (smsTemplet.size() > 0){
        	   throw new BossException(StatusCode.MODIFY_ENTITY_SMS_TEMPLET_ERROR, "短信模板:"+StatusCode.MODIFY_ENTITY_SMS_TEMPLET_ERROR.getDescription());
        	}else{
               this.setExpression(newExpression);
        	   this.setAllowModify("YES");
        	   this.setRemark("");
               if(this.getSmsContent() == null){
               	this.setSmsContent(" ");
               }
               dao.add(this);
               return this;
        	}
        }else{
            dao.backup(this, new String[]{"templetId","segmentSeq","priority","validDate"},"h");
            this.setExpression(newExpression);
            if(this.getSmsContent() == null){
               	this.setSmsContent(" ");
            }
            BeanCopyHelper.copyBeanNotNullPropertyCrm(accRemindSmsTemplet, this);
            dao.update(accRemindSmsTemplet);
            return accRemindSmsTemplet;
        }
    }
    
    @Override
    public BaseEntity cancel(ServiceContext context){
    	BusinessDao dao = (BusinessDao)context.getBeanFactory().getBean("businessDao");
    	try{
    		dao.backup(this, new String[]{"templetId","segmentSeq","priority","validDate"},"h");
    		dao.remove(this, new String[]{"templetId","segmentSeq","priority","validDate"});
    	}catch (Exception e){
    		;
    	} 
		return null;
    }
    
    
    @Override
    public BaseEntity modifyExpireDate(ServiceContext context) {
            throw new BossException(StatusCode.MODIFY_ENTITY_ERROR, "短信模板"+StatusCode.MODIFY_ENTITY_ERROR.getDescription());
    }
    
    @Override
    public BaseEntity rollBack(ServiceContext context) {
            throw new BossException(StatusCode.ROLLBACK_ENTITY_ERROR, "短信模板"+StatusCode.ROLLBACK_ENTITY_ERROR.getDescription());        
    }

}