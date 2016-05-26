package com.asiainfo.boss4.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.asiainfo.boss4.dao.UserMonitorDao;
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;

@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_VPMN", schema = "INTER")
@Backup.CopyToSuffix(isIgnore = true)
@CommonDao(fieldOfSelectConditions = { "servId","expireDate" },fieldOfDBSelectConditions={"serv_id","expire_date"})
public class IUserVpmn extends BaseEntity implements java.io.Serializable{
	private Long servId;
	private String soNbr;
	private String operType;
	private Date soDate;
	private Date validDate;
	private Date expireDate;
	private String remark;
	private String phoneId;
	private String tranCode;
	
	/** default constructor */
	public IUserVpmn() {
	}
	
	public IUserVpmn(Long servId,String soNbr,String operType,Date soDate,Date validDate,Date expireDate,String remark,String phoneId){
		this.servId = servId;
		this.soNbr = soNbr;
		this.operType = operType;
		this.soDate = soDate;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.remark = remark;
		this.phoneId = phoneId;
	}
	
	@Id
	@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
	public Long getServId() {
		return servId;
	}
	public void setServId(Long servId) {
		this.servId = servId;
	}
	@Column(name = "SO_NBR", nullable = false, precision = 50, scale = 0)
	public String getSoNbr() {
		return soNbr;
	}
	public void setSoNbr(String soNbr) {
		this.soNbr = soNbr;
	}
	@Column(name = "OPER_TYPE", nullable = false, precision = 2, scale = 0)
	public String getOperType() {
		return operType;
	}
	public void setOperType(String operType) {
		this.operType = operType;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SO_DATE", nullable = false, precision = 7)
	public Date getSoDate() {
		return soDate;
	}
	public void setSoDate(Date soDate) {
		this.soDate = soDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VALID_DATE", nullable = false, precision = 7)
	public Date getValidDate() {
		return validDate;
	}
	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRE_DATE", nullable = false, precision = 7)
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	@Column(name = "REMARK", nullable = true, precision = 4000, scale = 0)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Transient
	public String getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(String phoneId) {
		this.phoneId = phoneId;
	}
	@Transient
	public String getTranCode() {
		return tranCode;
	}

	public void setTranCode(String tranCode) {
		this.tranCode = tranCode;
	}

	@Override
	public BaseEntity add(ServiceContext context) {
		UserMonitorDao userMonitorDao = (UserMonitorDao)context.getBeanFactory().getBean("userMonitorDao");
		//将vpmn信息记录表中
		if (this.getPhoneId() != null && !this.getPhoneId().trim().equals(""))
		{
			CrmUser user = userMonitorDao.queryCrmUserByPhoneNumber(this.getPhoneId());
			if (user != null)
			{
				this.setServId(user.getServId());
			}
		}
		userMonitorDao.saveOrUpdate(this);
		Object sid = userMonitorDao.querySid();
		
		try{
			IUser user = userMonitorDao.queryIUserByServId(this.getServId());
			if (user != null)
			{
				this.setTranCode("11704");
				Object entity = BeanCopyHelper.copyToEntity(this, IUserMonitor.class);
				
				IUserMonitor userMonitor = userMonitorDao.queryIUserMonitorEntity(entity);
				if (userMonitor != null)
				{
					userMonitor.setExpireDate(this.getSoDate());
					userMonitor.setSid(Long.decode(sid.toString()));
					userMonitorDao.update(userMonitor);
					
					userMonitorDao.saveSaleOper(user,Long.decode(sid.toString()),Long.decode(this.getSoNbr()));
				}
				CrmUserMonitor crmUserMonitor = userMonitorDao.queryCrmUserMonitorEntity(entity);
				if (crmUserMonitor != null)
				{
					CrmUserMonitorHis crmUserMonitorHis =  userMonitorDao.queryCrmUserMonitorHisEntity(entity);
					CrmUserMonitorHis crmUserMonitorHisNew = new CrmUserMonitorHis();
					if (crmUserMonitorHis == null)
						crmUserMonitorHisNew = new CrmUserMonitorHis();
					BeanCopyHelper.copyBeanNotNullProperty(crmUserMonitorHisNew, crmUserMonitor);
					
					crmUserMonitorHisNew.setStsDate(this.getSoDate());
					userMonitorDao.remove(crmUserMonitor);
					userMonitorDao.add(crmUserMonitorHisNew);						
					
				}
				
			}
		}catch (Exception e){
			e.printStackTrace();
			throw new BossException(StatusCode.INSIDE_ERROR,e.getMessage().toString());
		}
		return this;
	}
	
	@Override
	public BaseEntity cancel(ServiceContext context) {
		UserMonitorDao userMonitorDao = (UserMonitorDao)context.getBeanFactory().getBean("userMonitorDao");
		//将vpmn信息记录表中
		if (this.getPhoneId() != null && !this.getPhoneId().trim().equals(""))
		{
			CrmUser user = userMonitorDao.queryCrmUserByPhoneNumber(this.getPhoneId());
			if (user != null)
			{
				this.setServId(user.getServId());
			}
		}
//		this.setExpireDate(new Date());使用数据库时间
		this.setExpireDate(userMonitorDao.queryCurrentDate());
		userMonitorDao.saveOrUpdate(this);
		return this;
	}
	
	@Override
	public BaseEntity modify(ServiceContext context) {
		UserMonitorDao userMonitorDao = (UserMonitorDao)context.getBeanFactory().getBean("userMonitorDao");
		//将vpmn信息记录表中
		if (this.getPhoneId() != null && !this.getPhoneId().trim().equals(""))
		{
			CrmUser user = userMonitorDao.queryCrmUserByPhoneNumber(this.getPhoneId());
			if (user != null)
			{
				this.setServId(user.getServId());
			}
		}
		userMonitorDao.saveOrUpdate(this);
		return this;
	}
	
	@Override
	public BaseEntity modifyExpireDate(ServiceContext context) {
		UserMonitorDao userMonitorDao = (UserMonitorDao)context.getBeanFactory().getBean("userMonitorDao");
		//将vpmn信息记录表中
		if (this.getPhoneId() != null && !this.getPhoneId().trim().equals(""))
		{
			CrmUser user = userMonitorDao.queryCrmUserByPhoneNumber(this.getPhoneId());
			if (user != null)
			{
				this.setServId(user.getServId());
			}
		}
		userMonitorDao.saveOrUpdate(this);
		return this;
	}
	
	@Override
	public BaseEntity rollBack(ServiceContext context) {
		return this;
	}
}
