package com.asiainfo.boss4.domain;

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
@Table(name = "ACCP_SMS_ALARM_MSG", schema = "ZC")
@Backup.CopyToSuffix(isIgnore = true)
@CommonDao(fieldOfSelectConditions = { "msgId"},fieldOfDBSelectConditions={"msg_Id"}, dataStoreMode = DataStoreMode.DIRECT_UPDATE)
public class AccpSmsAlarmMsg extends BaseEntity implements java.io.Serializable {

	// Fields
	private Byte operType = Byte.valueOf(OperateType.MODIFY.getTypeCode());
	private Integer priority;
	private Integer msgType;
	private Long msgId;
	private String content;
	private String remarks;

	// Constructors

	/** default constructor */
	public AccpSmsAlarmMsg() {
	}

	public AccpSmsAlarmMsg(Integer priority, Integer msgType,
			Long msgId, String content, String remarks) {
		this.priority = priority;
		this.msgType = msgType;
		this.msgId = msgId;
		this.content = content;
		this.remarks = remarks;
	}
	
	// Property accessors
	@Transient
	public OperateType getTheOperateType() {
		return OperateType.MODIFY;
	}
	
	@Transient
	public Byte getOperType() {
		return operType;
	}

	public void setOperType(Byte operType) {
		this.operType = operType;
	}

	@Column(name = "PRIORITY")
	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@Column(name = "MSG_TYPE")
	public Integer getMsgType() {
		return msgType;
	}

	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}

	@Id
	@Column(name = "MSG_ID", nullable = false)
	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}
	
	@Column(name = "CONTENT")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "REMARK")
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
		AccpSmsAlarmMsg accpSms = (AccpSmsAlarmMsg)dao.getEntity(this, this.getFieldOfSelectConditionsOnCommonDaoAnnotation());
		if (accpSms != null)
		{
			if (this.getContent() != null && !this.getContent().equals(accpSms.getContent()))
			{
				accpSms.setContent(this.getContent());
			}
			dao.update(accpSms);
		}
		else
			throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
		return this;
	}
}
