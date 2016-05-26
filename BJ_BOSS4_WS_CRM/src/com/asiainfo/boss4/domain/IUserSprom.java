package com.asiainfo.boss4.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.Constance;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.UpFieldUtil;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable;

/**
 * IUserSprom entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
//@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_SPROM", schema = "ZG")
@IdClass(IUserSprom.IUserSpromId.class)
@PartitionNameForTable
@PartitionNameForTable.RegionCode
@Backup.CopyToSuffix(isIgnore = true)
@CommonDao(fieldOfSelectConditions = { "servId", "spromId", "soId","expireDate" },fieldOfDBSelectConditions={"serv_id","sprom_id","so_id","expire_date"},isAlertWhenExist = true,isAlertWhenNotExist = true)
public class IUserSprom extends BaseEntity implements java.io.Serializable {

	// Fields

	private Long servId;
	private Integer spromId;
	private Byte operType;
	private Date validDate;
	private Long soId;
	private Integer serviceId;
	private Short regionCode;
	private Integer spromType;
	private Integer busiType;
	private Byte spromPrior;
	private String spromPara;
	private Byte payMode;
	private String property;
	private Date beginDate;
	private Date expireDate;
	private Long sid;
	private Long soNbr;
	private Integer maxProm;
	private String remark;
	private Integer planId;
	private String referenceObject;
	private String resultObject;
	/**
	 * 不映射到表字段，仅用于保存报文中的提交时间
	 */
	private Date commitDate;
	private String memberMsisdn;		//分机号码
	private String centralMsisdn;		//总机号码

	// Constructors

	/** default constructor */
	public IUserSprom() {
	}

	/** minimal constructor */
	public IUserSprom(Long servId, Integer spromId, Byte operType,
			Date validDate, Long soId, Integer serviceId, Integer busiType,
			Byte spromPrior, Date beginDate, Date expireDate, Long sid,
			Long soNbr) {
		this.servId = servId;
		this.spromId = spromId;
		this.operType = operType;
		this.validDate = validDate;
		this.soId = soId;
		this.serviceId = serviceId;
		this.busiType = busiType;
		this.spromPrior = spromPrior;
		this.beginDate = beginDate;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
	}

	/** full constructor */
	public IUserSprom(Long servId, Integer spromId, Byte operType,
			Date validDate, Long soId, Integer serviceId, Short regionCode,
			Integer spromType, Integer busiType, Byte spromPrior,
			String spromPara, Byte payMode, String property, Date beginDate,
			Date expireDate, Long sid, Long soNbr, Integer maxProm,
			String remark, Integer planId, String referenceObject,
			String resultObject) {
		this.servId = servId;
		this.spromId = spromId;
		this.operType = operType;
		this.validDate = validDate;
		this.soId = soId;
		this.serviceId = serviceId;
		this.regionCode = regionCode;
		this.spromType = spromType;
		this.busiType = busiType;
		this.spromPrior = spromPrior;
		this.spromPara = spromPara;
		this.payMode = payMode;
		this.property = property;
		this.beginDate = beginDate;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
		this.maxProm = maxProm;
		this.remark = remark;
		this.planId = planId;
		this.referenceObject = referenceObject;
		this.resultObject = resultObject;
	}

	// Property accessors
	
	@Id
	public Long getServId() {
		return servId;
	}

	public void setServId(Long servId) {
		this.servId = servId;
	}

	@Id
	public Integer getSpromId() {
		return spromId;
	}

	public void setSpromId(Integer spromId) {
		this.spromId = spromId;
	}

	@Id
	public Byte getOperType() {
		return operType;
	}

	public void setOperType(Byte operType) {
		this.operType = operType;
	}

	@Id
	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Id
	public Long getSoId() {
		return soId;
	}

	public void setSoId(Long soId) {
		this.soId = soId;
	}

	@Column(name = "SERVICE_ID", nullable = false, precision = 8, scale = 0)
	public Integer getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	@Column(name = "REGION_CODE", precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "SPROM_TYPE", precision = 6, scale = 0)
	public Integer getSpromType() {
		return this.spromType;
	}

	public void setSpromType(Integer spromType) {
		this.spromType = spromType;
	}

	@Column(name = "BUSI_TYPE", nullable = false, precision = 6, scale = 0)
	public Integer getBusiType() {
		return this.busiType;
	}

	public void setBusiType(Integer busiType) {
		this.busiType = busiType;
	}

	@Column(name = "SPROM_PRIOR", nullable = false, precision = 2, scale = 0)
	public Byte getSpromPrior() {
		return this.spromPrior;
	}

	public void setSpromPrior(Byte spromPrior) {
		this.spromPrior = spromPrior;
	}

	@Column(name = "SPROM_PARA", length = 32)
	public String getSpromPara() {
		return this.spromPara;
	}

	public void setSpromPara(String spromPara) {
		this.spromPara = spromPara;
	}

	@Column(name = "PAY_MODE", precision = 1, scale = 0)
	public Byte getPayMode() {
		return this.payMode;
	}

	public void setPayMode(Byte payMode) {
		this.payMode = payMode;
	}

	@Column(name = "PROPERTY", length = 20)
	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BEGIN_DATE", nullable = false, length = 7)
	public Date getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRE_DATE", nullable = false, length = 7)
	public Date getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Column(name = "SID", nullable = false, precision = 12, scale = 0)
	public Long getSid() {
		return this.sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	@Column(name = "SO_NBR", nullable = false, precision = 15, scale = 0)
	public Long getSoNbr() {
		return this.soNbr;
	}

	public void setSoNbr(Long soNbr) {
		this.soNbr = soNbr;
	}

	@Column(name = "MAX_PROM", precision = 8, scale = 0)
	public Integer getMaxProm() {
		return this.maxProm;
	}

	public void setMaxProm(Integer maxProm) {
		this.maxProm = maxProm;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "PLAN_ID", precision = 8, scale = 0)
	public Integer getPlanId() {
		return this.planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	@Column(name = "REFERENCE_OBJECT")
	public String getReferenceObject() {
		return this.referenceObject;
	}

	public void setReferenceObject(String referenceObject) {
		this.referenceObject = referenceObject;
	}

	@Column(name = "RESULT_OBJECT")
	public String getResultObject() {
		return this.resultObject;
	}

	public void setResultObject(String resultObject) {
		this.resultObject = resultObject;
	}
	@Transient
    public Date getCommitDate() {
    	return commitDate;
    }
    
    public void setCommitDate(Date commitDate) {
    	this.commitDate = commitDate;
    }
    @Transient
	public String getMemberMsisdn() {
		return memberMsisdn;
	}

	public void setMemberMsisdn(String memberMsisdn) {
		this.memberMsisdn = memberMsisdn;
	}
	@Transient
	public String getCentralMsisdn() {
		return centralMsisdn;
	}

	public void setCentralMsisdn(String centralMsisdn) {
		this.centralMsisdn = centralMsisdn;
	}

	@Override
	public BaseEntity add(ServiceContext context) {
		BusinessDao dao = (BusinessDao)context.getBeanFactory().getBean("businessDao");
		boolean needAdd = true;
		if (context.getTranCode().getTranCode().equals(TranCode.CRM_CENTREX_REFERENCE.getTranCode()))
		{
			if (this.getCentralMsisdn()!=null&&!"".equals(this.getCentralMsisdn().trim()))
			{
				IUser user = dao.queryIUserByPhoneNumber(this.getCentralMsisdn().trim());
				if (user != null)
				{
					Long sid = Long.valueOf(dao.querySid().toString());
					ISaleOper memberSaleOper = (ISaleOper) BeanCopyHelper.newInstance(
							"com.asiainfo.boss4.domain.partition.ISaleOper0"+this.getRegionCode().toString());
					
					//订购一个分账产品：87700151（Centrex统一号显功能费集团分账产品），payItem= 88003011（Centrex统一号显号码转换功能费）由集团进行全额代付
					try{
						
						IUserPayRelation userPayRelation = (IUserPayRelation)Class.forName("com.asiainfo.boss4.domain.partition.IUserPayRelation0" + this.getRegionCode().toString()).newInstance();
						BeanCopyHelper.copyProperties(userPayRelation, this);
						userPayRelation.setPayItem(88003011);
						userPayRelation.setPayIndex(87700151);
						userPayRelation.setSid(sid);
						userPayRelation.setMainServId(0l);
						userPayRelation.setPriority(Short.valueOf("0"));
						userPayRelation.setStsDate(context.getSoDate());
						userPayRelation.setUseMode(Short.valueOf("0"));
						userPayRelation.setPaySts(Byte.valueOf("0"));
						userPayRelation.setPayType(Byte.valueOf("2"));
						userPayRelation.setPayMaxLim(0l);
						userPayRelation.setPayPercent(Short.valueOf("100"));
						userPayRelation.setTotalFee(0l);
						userPayRelation.setControlCycle(Short.valueOf("0"));
						userPayRelation.setPartPara(0);
						
						userPayRelation.setAcctId(user.getAcctId());
						
						dao.commonAdd(userPayRelation);
						
						//上发iPayRelation表
						BeanCopyHelper.copyProperties(memberSaleOper, this);
						memberSaleOper.setAcctId(user.getAcctId());
						memberSaleOper.setCustId(user.getCustId());
						memberSaleOper.setBusiCode(0);
						memberSaleOper.setCommitDate(context.getSoDate());
						memberSaleOper.setCountyCode((short)1000);
						memberSaleOper.setOrgId(0);
						memberSaleOper.setGroupId(0l);
						memberSaleOper.setUpField(UpFieldUtil.getUpField(userPayRelation,UpFieldUtil.EMPTY_UPFIELD));
						
						//CrmGroupMember
						CrmGroupMember groupMember = new CrmGroupMember();
						BeanCopyHelper.copyProperties(groupMember, userPayRelation);
						groupMember.setServId(user.getServId());
						groupMember.setSubType(Byte.valueOf("3"));
						groupMember.setPhoneId(this.getMemberMsisdn().trim());
						groupMember.setMemberType(Byte.valueOf("0"));
						groupMember.setRecStatus(Byte.valueOf("1"));
						groupMember.setProductId(87700151l);
						groupMember.setSubServId(this.getServId());
						groupMember.setGroupId(0l);
						groupMember.setOpId(0);
						groupMember.setOrgId(0);
						groupMember.setSoId(0l);
						groupMember.setUserSts(Byte.valueOf("0"));
						groupMember.setDoneDate(context.getSoDate());
						dao.commonAdd(groupMember);
						
					}catch (Exception e) {
						throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
								"构造实体对象com.asiainfo.boss4.domain.partition.IUserPayRelation0" + user.getRegionCode().toString() + "出错");
					}
									
					//需要上发
					dao.add(memberSaleOper);

				}
				else
				{
					throw new BossException(StatusCode.NOT_EXIST_USER_ERROR,"Centrex统一号显业务集团用户"+this.getCentralMsisdn().trim()+"不存在");
				}
			}
			else
				throw new BossException(StatusCode.ILLEGAL_INPUT_PROPERTY_ERROR,"Centrex统一号显业务必须送centralMsisdn ");	
		}
		if (context.getTranCode().getTranCode().equals(TranCode.CRM_FIXED_BUG.getTranCode()))
		{
			if (this.getMemberMsisdn()!=null&&!"".equals(this.getMemberMsisdn().trim()))
			{
				IUserAll user = new IUserAll();
				user.setMsisdn(this.getMemberMsisdn().trim());
				user.setUserType(Short.valueOf("202"));
				user = (IUserAll)dao.getEntity(user, new String[]{"msisdn","userType","expireDate"});
				if (user != null)
				{
					try{
						Long sid = Long.valueOf(dao.querySid().toString());
						
						IUserSprom userSprom = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString()).newInstance();
						BeanCopyHelper.copyBeanNotNullProperty(userSprom, this);
						userSprom.setServId(user.getServId());
						userSprom.setRegionCode(user.getRegionCode());
						userSprom.setSid(sid);
						
						dao.commonAdd(userSprom);
						
						//需要上发
						ISaleOper memberSaleOper = (ISaleOper) BeanCopyHelper.newInstance(
								"com.asiainfo.boss4.domain.partition.ISaleOper0"+user.getRegionCode().toString());
						BeanCopyHelper.copyProperties(memberSaleOper, userSprom);
						memberSaleOper.setAcctId(user.getAcctId());
						memberSaleOper.setCustId(user.getCustId());
						memberSaleOper.setBusiCode(0);
						memberSaleOper.setCommitDate(context.getSoDate());
						memberSaleOper.setCountyCode((short)1000);
						memberSaleOper.setOrgId(0);
						memberSaleOper.setGroupId(0l);
						//上发iUserSprom表
						memberSaleOper.setUpField(UpFieldUtil.getUpField(userSprom, UpFieldUtil.EMPTY_UPFIELD));
						dao.add(memberSaleOper);
						
						return userSprom;
					}catch (Exception e) {
						throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
								"构造实体对象com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString() + "出错");
					}
					
				}
				else
					throw new BossException(StatusCode.NOT_EXIST_USER_ERROR,"固移通成员MemberMsisdn"+this.getMemberMsisdn().trim()+"不存在");
			}
			else
				throw new BossException(StatusCode.ILLEGAL_INPUT_PROPERTY_ERROR,"固移通订购必须送MemberMsisdn");	
		}
		if (context.getTranCode().getTranCode().equals(TranCode.CRM_HAPPY_PRODUCT.getTranCode())
				&&this.getSpromId().intValue() == Integer.decode(Constance.CRMHAPPYPRODUCT).intValue())
		{
			IUserSprom userSprom = (IUserSprom)dao.getEntity(this, new String[]{"servId", "spromId", "expireDate"});
			if (userSprom != null)
			{
				try{
					IUserRelation userRelation = (IUserRelation)Class.forName("com.asiainfo.boss4.domain.partition.IUserRelation0" + userSprom.getRegionCode().toString()).newInstance();
					BeanCopyHelper.copyProperties(userRelation, userSprom);
					Date maxExpireDate = dao.getMaxExpireDate(userRelation, new String[]{"servId", "soId", "expireDate"});
					if (maxExpireDate != null && !maxExpireDate.equals(userSprom.getExpireDate()))
					{
						this.setExpireDate(maxExpireDate);
						this.setSoId(userSprom.getSoId());
						super.modifyExpireDate(context);
						return this;
					}
					else
						needAdd = false;
				} catch (Exception e) {
					throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
							"构造实体对象com.asiainfo.boss4.domain.partition.IUserRelation0" + userSprom.getRegionCode().toString() + "出错");
				}
			}
		}
		if (needAdd)
			dao.add(this);
		else
			return this;
		
		//成员
		if (this.getMemberMsisdn()!=null&&!"".equals(this.getMemberMsisdn().trim())
				&&this.getCentralMsisdn()!=null&&!"".equals(this.getCentralMsisdn().trim())
				&& context.getTranCode().getTranCode().equals(TranCode.CRM_CENTREX.getTranCode()))
		{
			IUser user = dao.queryIUserByPhoneNumber(this.getMemberMsisdn().trim());
			if (user != null)
			{
				// 实例化实体类
				try {
					//sid为主键，新生成一个，以避免成员servId最后一样与集团相同时同表主键冲突
					Long sid = Long.valueOf(dao.querySid().toString());
					IUserSprom userSprom = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString()).newInstance();
					BeanCopyHelper.copyProperties(userSprom, this);
					userSprom.setSpromId(Integer.valueOf(this.getSpromId().intValue() - 30000000));
					userSprom.setServId(user.getServId());
					userSprom.setRegionCode(user.getRegionCode());
					userSprom.setSid(sid);
					userSprom.setSoId(this.getSoId().longValue()+100000000000000l);
					dao.add(userSprom);
					
//					ISpromParam spromParam = (ISpromParam)Class.forName("com.asiainfo.boss4.domain.partition.ISpromParam0" + user.getRegionCode().toString()).newInstance();
//					BeanCopyHelper.copyProperties(spromParam, userSprom);
//					spromParam.setKeyId(790002);
//					spromParam.setSpromPara("100");
//					dao.add(spromParam);
					
					IUserSprom memberSprom = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString()).newInstance();
					BeanCopyHelper.copyProperties(memberSprom, userSprom);
					memberSprom.setSpromId(Integer.valueOf(50001426));
					memberSprom.setSpromType(3);
					memberSprom.setSoId(this.getSoId().longValue()+200000000000000l);
					dao.add(memberSprom);
					
					if (this.getCentralMsisdn()!=null)
					{
						String[] centralMsisdnList = this.getCentralMsisdn().split(",");
						for (int j=0;j<centralMsisdnList.length;j++){
							String centralMsisdn = centralMsisdnList[j];
							IUserRelation userRelation = (IUserRelation)Class.forName("com.asiainfo.boss4.domain.partition.IUserRelation0" + user.getRegionCode().toString()).newInstance();
							BeanCopyHelper.copyProperties(userRelation, memberSprom);
							userRelation.setRservId(centralMsisdn);
							userRelation.setRregionCode((short) 1000);
							dao.add(userRelation);
						}
					}
					
					ISaleOper memberSaleOper = (ISaleOper) BeanCopyHelper.newInstance(
							"com.asiainfo.boss4.domain.partition.ISaleOper0"+user.getRegionCode().toString());
					BeanCopyHelper.copyProperties(memberSaleOper, memberSprom);
					memberSaleOper.setAcctId(user.getAcctId());
					memberSaleOper.setCustId(user.getCustId());
					memberSaleOper.setBusiCode(0);
					memberSaleOper.setCommitDate(context.getSoDate());
					memberSaleOper.setCountyCode((short)1000);
					memberSaleOper.setOrgId(0);
					memberSaleOper.setGroupId(0l);
					//上发iUserSprom、iUserRelation表
					memberSaleOper.setUpField("0100000010000000000000000000000000000000000000000000000000000000");
					dao.add(memberSaleOper);
					
				} catch (Exception e) {
					throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
							"构造实体对象com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString() + "出错");
				}
			}
		}
		else if (this.getMemberMsisdn()!=null&&!"".equals(this.getMemberMsisdn().trim())
				&&this.getCentralMsisdn()!=null&&!"".equals(this.getCentralMsisdn().trim())
				&&!this.getMemberMsisdn().equals(this.getCentralMsisdn())
				&& context.getTranCode().getTranCode().equals(TranCode.CRM_V_PAYMENT.getTranCode()))
		{
			//减免个人月租
			IUser user = dao.queryIUserByPhoneNumber(this.getMemberMsisdn().trim());
			if (user != null)
			{
				// 实例化实体类
				try {
					//sid为主键，新生成一个
					Long sid = Long.valueOf(dao.querySid().toString());
					IUserSprom userSprom = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString()).newInstance();
					BeanCopyHelper.copyProperties(userSprom, this);
					userSprom.setSpromId(Integer.valueOf(83200017));
					userSprom.setServId(user.getServId());
					userSprom.setRegionCode(user.getRegionCode());
					userSprom.setSpromType(0);
					userSprom.setSid(sid);
					userSprom.setSoId(this.getSoId().longValue()+100000000000000l);
					dao.add(userSprom);
										
					ISaleOper memberSaleOper = (ISaleOper) BeanCopyHelper.newInstance(
							"com.asiainfo.boss4.domain.partition.ISaleOper0"+user.getRegionCode().toString());
					BeanCopyHelper.copyProperties(memberSaleOper, userSprom);
					memberSaleOper.setAcctId(user.getAcctId());
					memberSaleOper.setCustId(user.getCustId());
					memberSaleOper.setBusiCode(0);
					memberSaleOper.setCommitDate(context.getSoDate());
					memberSaleOper.setCountyCode((short)1000);
					memberSaleOper.setOrgId(0);
					memberSaleOper.setGroupId(0l);
					//上发iUserSprom
					memberSaleOper.setUpField("0100000000000000000000000000000000000000000000000000000000000000");
					dao.add(memberSaleOper);
				} catch (Exception e) {
					throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
							"构造实体对象com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString() + "出错");
				}
			}
			else
				throw new BossException(StatusCode.IUSER_ISNULL_ERROR,"用户"+getMemberMsisdn()+"不存在");
			
			//月租订购在集团上
			user = dao.queryIUserByPhoneNumber(this.getCentralMsisdn().trim());
			if (user != null)
			{
				// 实例化实体类
				try {
					//sid为主键，新生成一个
					Long sid = Long.valueOf(dao.querySid().toString());
					IUserSprom userSprom = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString()).newInstance();
					BeanCopyHelper.copyProperties(userSprom, this);
					userSprom.setSpromId(Integer.valueOf(80001400));
					userSprom.setServId(user.getServId());
					userSprom.setRegionCode(user.getRegionCode());
					userSprom.setSpromType(0);
					userSprom.setSid(sid);
					userSprom.setSoId(this.getSoId().longValue()+200000000000000l);
					dao.add(userSprom);
										
					ISaleOper memberSaleOper = (ISaleOper) BeanCopyHelper.newInstance(
							"com.asiainfo.boss4.domain.partition.ISaleOper0"+user.getRegionCode().toString());
					BeanCopyHelper.copyProperties(memberSaleOper, userSprom);
					memberSaleOper.setAcctId(user.getAcctId());
					memberSaleOper.setCustId(user.getCustId());
					memberSaleOper.setBusiCode(0);
					memberSaleOper.setCommitDate(context.getSoDate());
					memberSaleOper.setCountyCode((short)1000);
					memberSaleOper.setOrgId(0);
					memberSaleOper.setGroupId(0l);
					//上发iUserSprom
					memberSaleOper.setUpField("0100000000000000000000000000000000000000000000000000000000000000");
					dao.add(memberSaleOper);
				} catch (Exception e) {
					throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
							"构造实体对象com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString() + "出错");
				}
			}
			else
				throw new BossException(StatusCode.IUSER_ISNULL_ERROR,"用户"+getCentralMsisdn()+"不存在");
		}
		
		return this;
	}
	@Override
	public BaseEntity cancel(ServiceContext context) {
		BusinessDao dao = context.getBusinessDao();
		if (this.getExpireDate() == null)
			this.setExpireDate(dao.queryCurrentDate());
		if (context.getTranCode().getTranCode().equals(TranCode.CRM_CENTREX_REFERENCE.getTranCode()))
		{
			if (this.getCentralMsisdn()!=null&&!"".equals(this.getCentralMsisdn().trim()))
			{
				IUser user = dao.queryIUserByPhoneNumber(this.getCentralMsisdn().trim());
				if (user != null)
				{
					Long sid = Long.valueOf(dao.querySid().toString());
					ISaleOper memberSaleOper = (ISaleOper) BeanCopyHelper.newInstance(
							"com.asiainfo.boss4.domain.partition.ISaleOper0"+this.getRegionCode().toString());
					
					//订购一个分账产品：87700151（Centrex统一号显功能费集团分账产品），payItem= 88003011（Centrex统一号显号码转换功能费）由集团进行全额代付
					try{
						
						IUserPayRelation userPayRelation = (IUserPayRelation)Class.forName("com.asiainfo.boss4.domain.partition.IUserPayRelation0" + this.getRegionCode().toString()).newInstance();
						BeanCopyHelper.copyProperties(userPayRelation, this);
						userPayRelation.setPayItem(88003011);
						userPayRelation.setPayIndex(87700151);
						userPayRelation.setSid(sid);
						userPayRelation.setMainServId(0l);
						userPayRelation.setPayType(Byte.valueOf("2"));
						userPayRelation.setPayMaxLim(0l);
						userPayRelation.setPayPercent(Short.valueOf("100"));
						userPayRelation.setTotalFee(0l);
						userPayRelation.setControlCycle(Short.valueOf("0"));
						userPayRelation.setPartPara(0);
						
						userPayRelation.setAcctId(user.getAcctId());
						
						dao.commonCancel(userPayRelation);
						
						//上发iPayRelation表
						BeanCopyHelper.copyProperties(memberSaleOper, this);
						memberSaleOper.setAcctId(user.getAcctId());
						memberSaleOper.setCustId(user.getCustId());
						memberSaleOper.setBusiCode(0);
						memberSaleOper.setCommitDate(context.getSoDate());
						memberSaleOper.setCountyCode((short)1000);
						memberSaleOper.setOrgId(0);
						memberSaleOper.setGroupId(0l);
						memberSaleOper.setUpField(UpFieldUtil.getUpField(userPayRelation,UpFieldUtil.EMPTY_UPFIELD));
						
						
						//CrmGroupMember
						CrmGroupMember groupMember = new CrmGroupMember();
						BeanCopyHelper.copyProperties(groupMember, userPayRelation);
						groupMember.setServId(user.getServId());
						groupMember.setSubType(Byte.valueOf("3"));
						groupMember.setPhoneId(this.getMemberMsisdn().trim());
						groupMember.setMemberType(Byte.valueOf("0"));
						groupMember.setRecStatus(Byte.valueOf("1"));
						groupMember.setProductId(87700151l);
						groupMember.setSubServId(this.getServId());
						groupMember.setGroupId(0l);
						groupMember.setOpId(0);
						groupMember.setOrgId(0);
						groupMember.setSoId(0l);
						groupMember.setUserSts(Byte.valueOf("0"));
						groupMember.setDoneDate(context.getSoDate());
						dao.commonCancel(groupMember);
						
					}catch (Exception e) {
						throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
								"构造实体对象com.asiainfo.boss4.domain.partition.IUserPayRelation0" + user.getRegionCode().toString() + "出错");
					}
									
					//需要上发
					dao.add(memberSaleOper);
				}
				else
				{
					throw new BossException(StatusCode.NOT_EXIST_USER_ERROR,"Centrex统一号显业务集团用户"+this.getCentralMsisdn().trim()+"不存在");
				}
			}
			else
				throw new BossException(StatusCode.ILLEGAL_INPUT_PROPERTY_ERROR,"Centrex统一号显业务必须送centralMsisdn ");	
		}
		if (context.getTranCode().getTranCode().equals(TranCode.CRM_FIXED_BUG.getTranCode()))
		{
			if (this.getMemberMsisdn()!=null&&!"".equals(this.getMemberMsisdn().trim()))
			{
				IUserAll user = new IUserAll();
				user.setMsisdn(this.getMemberMsisdn().trim());
				user.setUserType(Short.valueOf("202"));
				user = (IUserAll)dao.getEntity(user, new String[]{"msisdn","userType","expireDate"});
				if (user != null)
				{
					try{
						Long sid = Long.valueOf(dao.querySid().toString());
						
						IUserSprom userSprom = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString()).newInstance();
						BeanCopyHelper.copyBeanNotNullProperty(userSprom, this);
						userSprom.setServId(user.getServId());
						userSprom.setRegionCode(user.getRegionCode());
						userSprom.setSid(sid);
						
						dao.commonCancel(userSprom);
						
						//需要上发
						ISaleOper memberSaleOper = (ISaleOper) BeanCopyHelper.newInstance(
								"com.asiainfo.boss4.domain.partition.ISaleOper0"+user.getRegionCode().toString());
						BeanCopyHelper.copyProperties(memberSaleOper, userSprom);
						memberSaleOper.setAcctId(user.getAcctId());
						memberSaleOper.setCustId(user.getCustId());
						memberSaleOper.setBusiCode(0);
						memberSaleOper.setCommitDate(context.getSoDate());
						memberSaleOper.setCountyCode((short)1000);
						memberSaleOper.setOrgId(0);
						memberSaleOper.setGroupId(0l);
						//上发iUserSprom表
						memberSaleOper.setUpField(UpFieldUtil.getUpField(userSprom, UpFieldUtil.EMPTY_UPFIELD));
						dao.add(memberSaleOper);
						
						return userSprom;
					}catch (Exception e) {
						throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
								"构造实体对象com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString() + "出错");
					}
					
				}
				else
					throw new BossException(StatusCode.NOT_EXIST_USER_ERROR,"固移通成员MemberMsisdn"+this.getMemberMsisdn().trim()+"不存在");
			}
			else
				throw new BossException(StatusCode.ILLEGAL_INPUT_PROPERTY_ERROR,"固移通订购必须送MemberMsisdn");	
		}
		
		if (context.getTranCode().getTranCode().equals(TranCode.CRM_HAPPY_PRODUCT.getTranCode())
				&&this.getSpromId().intValue() == Integer.decode(Constance.CRMHAPPYPRODUCT).intValue())
		{
			IUserSprom userSprom = (IUserSprom)dao.getEntity(this, new String[]{"servId", "spromId", "expireDate"});
			if (userSprom != null){
				try {
					IUserRelation relationEntity = (IUserRelation)Class.forName("com.asiainfo.boss4.domain.partition.IUserRelation0" + userSprom.getRegionCode().toString()).newInstance();
					BeanCopyHelper.copyProperties(relationEntity, userSprom);
					List list = dao.getEntityList(relationEntity, new String[]{"servId", "expireDate"});
					if (list == null || list.size()==0)
					{
						dao.cancel(this,new String[]{"servId", "spromId","expireDate"} );
					}
					else
					{
						Date maxExpireDate = dao.getMaxExpireDate(relationEntity, new String[]{"servId", "soId", "expireDate"});
						if (maxExpireDate != null && !maxExpireDate.equals(userSprom.getExpireDate()))
						{
							this.setExpireDate(maxExpireDate);
							this.setSoId(userSprom.getSoId());
							super.modifyExpireDate(context);
						}
					}
					return this;
				} catch (Exception e) {
					throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
							"构造实体对象com.asiainfo.boss4.domain.partition.IUserRelation0" + this.getRegionCode().toString() + "出错");
				}
			}
			
		}
		//成员
		if (this.getMemberMsisdn()!=null&&!"".equals(this.getMemberMsisdn().trim())
				&&this.getCentralMsisdn()!=null&&!"".equals(this.getCentralMsisdn().trim())
				&& context.getTranCode().getTranCode().equals(TranCode.CRM_CENTREX.getTranCode()))
		{
			IUser user = dao.queryIUserByPhoneNumber(this.getMemberMsisdn().trim());
			if (user != null)
			{
				// 实例化实体类
				try {
					//sid为主键，新生成一个，以避免成员servId最后一样与集团相同时同表主键冲突
					Long sid = Long.valueOf(dao.querySid().toString());
					IUserSprom entity = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString()).newInstance();
					BeanCopyHelper.copyProperties(entity, this);
					entity.setSpromId(Integer.valueOf(this.getSpromId().intValue() - 30000000));
					entity.setServId(user.getServId());
					entity.setRegionCode(user.getRegionCode());
					entity.setSoId(this.getSoId().longValue()+100000000000000l);
					//entity.setExpireDate(DateHelper.getNextSecond(DateHelper.String2Date(DateHelper.Date2String(new Date(), "yyyyMMdd")+"235959")));	
					entity.setSid(sid);
					
					Map selectDBConditions = new HashMap();
					List selectList = new ArrayList();
					selectList.add("expireDate");
					selectList.add("expire_date");
					selectDBConditions.put("expireDate", selectList);
					
					selectList = new ArrayList();
					selectList.add("sid");
					selectList.add("sid");
					selectDBConditions.put("sid", selectList);
					
					selectList = new ArrayList();
					selectList.add("soNbr");
					selectList.add("so_Nbr");
					selectDBConditions.put("soNbr", selectList);
					
					if (this.getCentralMsisdn()!=null)
					{
						String[] centralMsisdnList = this.getCentralMsisdn().split(",");
						for (int j=0;j<centralMsisdnList.length;j++){
							String centralMsisdn = centralMsisdnList[j];
							IUserRelation relationEntity = (IUserRelation)Class.forName("com.asiainfo.boss4.domain.partition.IUserRelation0" + user.getRegionCode().toString()).newInstance();
							BeanCopyHelper.copyProperties(relationEntity, entity);
							relationEntity.setRservId(centralMsisdn);
							relationEntity.setRregionCode((short) 1000);
							relationEntity.setSoId(this.getSoId().longValue()+200000000000000l);
							
							CommonDao cd = (CommonDao) getAnnotation(EntityPartitionHelper.getOriginalClassForPartition(relationEntity), CommonDao.class);
							
							if (cd.fieldOfSelectConditions() == null) {
								throw new BossException(StatusCode.INSIDE_ERROR,
										"The @CommonDao(fieldOfSelectConditions) does not annotate on class "
												+ relationEntity.getClass().getSimpleName());
							}
							Map selectConditions = new HashMap();
							if (cd.fieldOfSelectConditions().length == cd.fieldOfDBSelectConditions().length)
							{
								for (int i=0;i<cd.fieldOfSelectConditions().length;i++)
								{
									List list = new ArrayList();
									String field = cd.fieldOfSelectConditions()[i];
									String dbField = cd.fieldOfDBSelectConditions()[i];
									list.add(field);
									list.add(dbField);
									selectConditions.put(field, list);
								}
							}
							dao.updateExpireDate(relationEntity, selectConditions, selectDBConditions, "0"+user.getRegionCode().toString(), "zg.i_user_relation");

						}
					}
					
//					ISpromParam paramEntity = (ISpromParam)Class.forName("com.asiainfo.boss4.domain.partition.ISpromParam0" + user.getRegionCode().toString()).newInstance();
//					BeanCopyHelper.copyProperties(paramEntity, entity);
//					paramEntity.setKeyId(790002);
//					paramEntity.setSpromPara("100");										
//					
//					cd = (CommonDao) getAnnotation(EntityPartitionHelper.getOriginalClassForPartition(paramEntity), CommonDao.class);
//					
//					if (cd.fieldOfSelectConditions() == null) {
//						throw new BossException(StatusCode.INSIDE_ERROR,
//								"The @CommonDao(fieldOfSelectConditions) does not annotate on class "
//										+ paramEntity.getClass().getSimpleName());
//					}
//					selectConditions = new HashMap();
//					if (cd.fieldOfSelectConditions().length == cd.fieldOfDBSelectConditions().length)
//					{
//						for (int i=0;i<cd.fieldOfSelectConditions().length;i++)
//						{
//							List list = new ArrayList();
//							String field = cd.fieldOfSelectConditions()[i];
//							String dbField = cd.fieldOfDBSelectConditions()[i];
//							list.add(field);
//							list.add(dbField);
//							selectConditions.put(field, list);
//						}
//					}
//					dao.updateExpireDate(paramEntity, selectConditions, selectDBConditions, "0"+user.getRegionCode().toString(), "zg.i_sprom_param");

					CommonDao cd = (CommonDao) getAnnotation(EntityPartitionHelper.getOriginalClassForPartition(entity), CommonDao.class);
					
					if (cd.fieldOfSelectConditions() == null) {
						throw new BossException(StatusCode.INSIDE_ERROR,
								"The @CommonDao(fieldOfSelectConditions) does not annotate on class "
										+ entity.getClass().getSimpleName());
					}
					Map selectConditions = new HashMap();
					if (cd.fieldOfSelectConditions().length == cd.fieldOfDBSelectConditions().length)
					{
						for (int i=0;i<cd.fieldOfSelectConditions().length;i++)
						{
							List list = new ArrayList();
							String field = cd.fieldOfSelectConditions()[i];
							String dbField = cd.fieldOfDBSelectConditions()[i];
							list.add(field);
							list.add(dbField);
							selectConditions.put(field, list);
						}
					}
					
					dao.updateExpireDate(entity, selectConditions, selectDBConditions, "0"+user.getRegionCode().toString(), "zg.i_user_sprom");
					
					entity.setSpromId(Integer.valueOf(50001426));
					entity.setSoId(this.getSoId().longValue()+200000000000000l);
					dao.updateExpireDate(entity, selectConditions, selectDBConditions, "0"+user.getRegionCode().toString(), "zg.i_user_sprom");
					
					ISaleOper memberSaleOper = (ISaleOper) BeanCopyHelper.newInstance(
							"com.asiainfo.boss4.domain.partition.ISaleOper0"+user.getRegionCode().toString());
					BeanCopyHelper.copyProperties(memberSaleOper, entity);
					memberSaleOper.setAcctId(user.getAcctId());
					memberSaleOper.setCustId(user.getCustId());
					memberSaleOper.setBusiCode(0);
					memberSaleOper.setCommitDate(context.getSoDate());
					memberSaleOper.setCountyCode((short)1000);
					memberSaleOper.setOrgId(0);
					memberSaleOper.setGroupId(0l);
					//上发iUserSprom、iUserRelation表
					memberSaleOper.setUpField("0100000010000000000000000000000000000000000000000000000000000000");
					dao.add(memberSaleOper);
					
				} catch (Exception e) {
					throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
							"构造实体对象com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString() + "出错");
				}
			}
		}
		else if (this.getMemberMsisdn()!=null&&!"".equals(this.getMemberMsisdn().trim())
				&&this.getCentralMsisdn()!=null&&!"".equals(this.getCentralMsisdn().trim())
				&&!this.getMemberMsisdn().equals(this.getCentralMsisdn())
				&& context.getTranCode().getTranCode().equals(TranCode.CRM_V_PAYMENT.getTranCode()))
		{
			IUser user = dao.queryIUserByPhoneNumber(this.getMemberMsisdn().trim());
			if (user != null)
			{
				// 实例化实体类
				try {
					//sid为主键，新生成一个
					Long sid = Long.valueOf(dao.querySid().toString());
					IUserSprom entity = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString()).newInstance();
					BeanCopyHelper.copyProperties(entity, this);
					entity.setSpromId(Integer.valueOf(83200017));
					entity.setServId(user.getServId());
					entity.setRegionCode(user.getRegionCode());
					entity.setSpromType(0);
					entity.setSid(sid);
					entity.setSoId(this.getSoId().longValue()+100000000000000l);
					Map selectDBConditions = new HashMap();
					List selectList = new ArrayList();
					selectList.add("expireDate");
					selectList.add("expire_date");
					selectDBConditions.put("expireDate", selectList);
					
					selectList = new ArrayList();
					selectList.add("sid");
					selectList.add("sid");
					selectDBConditions.put("sid", selectList);
					
					selectList = new ArrayList();
					selectList.add("soNbr");
					selectList.add("so_Nbr");
					selectDBConditions.put("soNbr", selectList);
					
					CommonDao cd = (CommonDao) getAnnotation(EntityPartitionHelper.getOriginalClassForPartition(entity), CommonDao.class);
					
					if (cd.fieldOfSelectConditions() == null) {
						throw new BossException(StatusCode.INSIDE_ERROR,
								"The @CommonDao(fieldOfSelectConditions) does not annotate on class "
										+ entity.getClass().getSimpleName());
					}
					Map selectConditions = new HashMap();
					if (cd.fieldOfSelectConditions().length == cd.fieldOfDBSelectConditions().length)
					{
						for (int i=0;i<cd.fieldOfSelectConditions().length;i++)
						{
							List list = new ArrayList();
							String field = cd.fieldOfSelectConditions()[i];
							String dbField = cd.fieldOfDBSelectConditions()[i];
							list.add(field);
							list.add(dbField);
							selectConditions.put(field, list);
						}
					}
					
					dao.updateExpireDate(entity, selectConditions, selectDBConditions, "0"+user.getRegionCode().toString(), "zg.i_user_sprom");
					
					ISaleOper memberSaleOper = (ISaleOper) BeanCopyHelper.newInstance(
							"com.asiainfo.boss4.domain.partition.ISaleOper0"+user.getRegionCode().toString());
					BeanCopyHelper.copyProperties(memberSaleOper, entity);
					memberSaleOper.setAcctId(user.getAcctId());
					memberSaleOper.setCustId(user.getCustId());
					memberSaleOper.setBusiCode(0);
					memberSaleOper.setCommitDate(context.getSoDate());
					memberSaleOper.setCountyCode((short)1000);
					memberSaleOper.setOrgId(0);
					memberSaleOper.setGroupId(0l);
					//上发iUserSprom
					memberSaleOper.setUpField("0100000000000000000000000000000000000000000000000000000000000000");
					dao.add(memberSaleOper);
					
				} catch (Exception e) {
					throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
							"构造实体对象com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString() + "出错");
				}
			}
			else
				throw new BossException(StatusCode.IUSER_ISNULL_ERROR,"用户"+getMemberMsisdn()+"不存在");
			
			user = dao.queryIUserByPhoneNumber(this.getCentralMsisdn().trim());
			if (user != null)
			{
				// 实例化实体类
				try {
					//sid为主键，新生成一个
					Long sid = Long.valueOf(dao.querySid().toString());
					IUserSprom entity = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString()).newInstance();
					BeanCopyHelper.copyProperties(entity, this);
					entity.setSpromId(Integer.valueOf(80001400));
					entity.setServId(user.getServId());
					entity.setRegionCode(user.getRegionCode());
					entity.setSpromType(0);
					entity.setSid(sid);
					entity.setSoId(this.getSoId().longValue()+200000000000000l);
					
					Map selectDBConditions = new HashMap();
					List selectList = new ArrayList();
					selectList.add("expireDate");
					selectList.add("expire_date");
					selectDBConditions.put("expireDate", selectList);
					
					selectList = new ArrayList();
					selectList.add("sid");
					selectList.add("sid");
					selectDBConditions.put("sid", selectList);
					
					selectList = new ArrayList();
					selectList.add("soNbr");
					selectList.add("so_Nbr");
					selectDBConditions.put("soNbr", selectList);
					
					CommonDao cd = (CommonDao) getAnnotation(EntityPartitionHelper.getOriginalClassForPartition(entity), CommonDao.class);
					
					if (cd.fieldOfSelectConditions() == null) {
						throw new BossException(StatusCode.INSIDE_ERROR,
								"The @CommonDao(fieldOfSelectConditions) does not annotate on class "
										+ entity.getClass().getSimpleName());
					}
					Map selectConditions = new HashMap();
					if (cd.fieldOfSelectConditions().length == cd.fieldOfDBSelectConditions().length)
					{
						for (int i=0;i<cd.fieldOfSelectConditions().length;i++)
						{
							List list = new ArrayList();
							String field = cd.fieldOfSelectConditions()[i];
							String dbField = cd.fieldOfDBSelectConditions()[i];
							list.add(field);
							list.add(dbField);
							selectConditions.put(field, list);
						}
					}
					
					dao.updateExpireDate(entity, selectConditions, selectDBConditions, "0"+user.getRegionCode().toString(), "zg.i_user_sprom");
					
					ISaleOper memberSaleOper = (ISaleOper) BeanCopyHelper.newInstance(
							"com.asiainfo.boss4.domain.partition.ISaleOper0"+user.getRegionCode().toString());
					BeanCopyHelper.copyProperties(memberSaleOper, entity);
					memberSaleOper.setAcctId(user.getAcctId());
					memberSaleOper.setCustId(user.getCustId());
					memberSaleOper.setBusiCode(0);
					memberSaleOper.setCommitDate(context.getSoDate());
					memberSaleOper.setCountyCode((short)1000);
					memberSaleOper.setOrgId(0);
					memberSaleOper.setGroupId(0l);
					//上发iUserSprom
					memberSaleOper.setUpField("0100000000000000000000000000000000000000000000000000000000000000");
					dao.add(memberSaleOper);
					
				} catch (Exception e) {
					throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
							"构造实体对象com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString() + "出错");
				}
			}
			else
				throw new BossException(StatusCode.IUSER_ISNULL_ERROR,"用户"+getCentralMsisdn()+"不存在");
		}
		CommonDao cd = (CommonDao) getAnnotation(EntityPartitionHelper.getOriginalClassForPartition(this), CommonDao.class);
		dao.cancel(this, cd.fieldOfSelectConditions(), false, null);

		return this;
	}
	@Override
	public BaseEntity modifyExpireDate(ServiceContext context) {
		BusinessDao dao = (BusinessDao)context.getBeanFactory().getBean("businessDao");
		if (context.getTranCode().getTranCode().equals(TranCode.CRM_CENTREX_REFERENCE.getTranCode()))
		{
			if (this.getCentralMsisdn()!=null&&!"".equals(this.getCentralMsisdn().trim()))
			{
				IUser user = dao.queryIUserByPhoneNumber(this.getCentralMsisdn().trim());
				if (user != null)
				{
					Long sid = Long.valueOf(dao.querySid().toString());
					ISaleOper memberSaleOper = (ISaleOper) BeanCopyHelper.newInstance(
							"com.asiainfo.boss4.domain.partition.ISaleOper0"+this.getRegionCode().toString());												
					
					//订购一个分账产品：87700151（Centrex统一号显功能费集团分账产品），payItem= 88003011（Centrex统一号显号码转换功能费）由集团进行全额代付
					try{
						
						IUserPayRelation userPayRelation = (IUserPayRelation)Class.forName("com.asiainfo.boss4.domain.partition.IUserPayRelation0" + this.getRegionCode().toString()).newInstance();
						BeanCopyHelper.copyProperties(userPayRelation, this);
						userPayRelation.setPayItem(88003011);
						userPayRelation.setPayIndex(87700151);
						userPayRelation.setSid(sid);
						userPayRelation.setMainServId(0l);
						userPayRelation.setPayType(Byte.valueOf("2"));
						userPayRelation.setPayMaxLim(0l);
						userPayRelation.setPayPercent(Short.valueOf("100"));
						userPayRelation.setTotalFee(0l);
						userPayRelation.setControlCycle(Short.valueOf("0"));
						userPayRelation.setPartPara(0);
						
						userPayRelation.setAcctId(user.getAcctId());
						
						dao.commonModifyExpireDate(userPayRelation);
						
						//上发iPayRelation表
						BeanCopyHelper.copyProperties(memberSaleOper, this);
						memberSaleOper.setAcctId(user.getAcctId());
						memberSaleOper.setCustId(user.getCustId());
						memberSaleOper.setBusiCode(0);
						memberSaleOper.setCommitDate(context.getSoDate());
						memberSaleOper.setCountyCode((short)1000);
						memberSaleOper.setOrgId(0);
						memberSaleOper.setGroupId(0l);
						memberSaleOper.setUpField(UpFieldUtil.getUpField(userPayRelation, UpFieldUtil.EMPTY_UPFIELD));
						
						
						//CrmGroupMember
						CrmGroupMember groupMember = new CrmGroupMember();
						BeanCopyHelper.copyProperties(groupMember, userPayRelation);
						groupMember.setServId(user.getServId());
						groupMember.setSubType(Byte.valueOf("3"));
						groupMember.setPhoneId(this.getMemberMsisdn().trim());
						groupMember.setMemberType(Byte.valueOf("0"));
						groupMember.setRecStatus(Byte.valueOf("1"));
						groupMember.setProductId(87700151l);
						groupMember.setSubServId(this.getServId());
						groupMember.setGroupId(0l);
						groupMember.setOpId(0);
						groupMember.setOrgId(0);
						groupMember.setSoId(0l);
						groupMember.setUserSts(Byte.valueOf("0"));
						groupMember.setDoneDate(context.getSoDate());
						dao.commonModifyExpireDate(groupMember);
						
					}catch (Exception e) {
						throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
								"构造实体对象com.asiainfo.boss4.domain.partition.IUserPayRelation0" + user.getRegionCode().toString() + "出错");
					}
									
					//需要上发
					dao.add(memberSaleOper);

				}
				else
				{
					throw new BossException(StatusCode.NOT_EXIST_USER_ERROR,"Centrex统一号显业务集团用户"+this.getCentralMsisdn().trim()+"不存在");
				}
			}
			else
				throw new BossException(StatusCode.ILLEGAL_INPUT_PROPERTY_ERROR,"Centrex统一号显业务必须送centralMsisdn ");	
		}
		if (context.getTranCode().getTranCode().equals(TranCode.CRM_FIXED_BUG.getTranCode()))
		{
			if (this.getMemberMsisdn()!=null&&!"".equals(this.getMemberMsisdn().trim()))
			{
				IUserAll user = new IUserAll();
				user.setMsisdn(this.getMemberMsisdn().trim());
				user.setUserType(Short.valueOf("202"));
				user = (IUserAll)dao.getEntity(user, new String[]{"msisdn","userType","expireDate"});
				if (user != null)
				{
					try{
						Long sid = Long.valueOf(dao.querySid().toString());
						
						IUserSprom userSprom = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString()).newInstance();
						BeanCopyHelper.copyBeanNotNullProperty(userSprom, this);
						userSprom.setServId(user.getServId());
						userSprom.setRegionCode(user.getRegionCode());
						userSprom.setSid(sid);
						
						dao.commonModifyExpireDate(userSprom);
						
						if (this.getRegionCode().shortValue() != user.getRegionCode().shortValue())
						{
							//需要上发
							ISaleOper memberSaleOper = (ISaleOper) BeanCopyHelper.newInstance(
									"com.asiainfo.boss4.domain.partition.ISaleOper0"+user.getRegionCode().toString());
							BeanCopyHelper.copyProperties(memberSaleOper, userSprom);
							memberSaleOper.setAcctId(user.getAcctId());
							memberSaleOper.setCustId(user.getCustId());
							memberSaleOper.setBusiCode(0);
							memberSaleOper.setCommitDate(context.getSoDate());
							memberSaleOper.setCountyCode((short)1000);
							memberSaleOper.setOrgId(0);
							memberSaleOper.setGroupId(0l);
							//上发iUserSprom表
							memberSaleOper.setUpField(UpFieldUtil.getUpField(userSprom, UpFieldUtil.EMPTY_UPFIELD));
							dao.add(memberSaleOper);
						}
						return userSprom;
					}catch (Exception e) {
						throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
								"构造实体对象com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString() + "出错");
					}
				}
				else
					throw new BossException(StatusCode.NOT_EXIST_USER_ERROR,"固移通成员MemberMsisdn"+this.getMemberMsisdn().trim()+"不存在");
			}
			else
				throw new BossException(StatusCode.ILLEGAL_INPUT_PROPERTY_ERROR,"固移通订购必须送MemberMsisdn");	
		}
		
		if (context.getTranCode().getTranCode().equals(TranCode.CRM_HAPPY_PRODUCT.getTranCode())
				&&this.getSpromId().intValue() == Integer.decode(Constance.CRMHAPPYPRODUCT).intValue())
		{
			try {
				IUserSprom userSprom = (IUserSprom)dao.getEntity(this, new String[]{"servId", "spromId", "expireDate"});
				if (userSprom != null)
				{
					IUserRelation relationEntity = (IUserRelation)Class.forName("com.asiainfo.boss4.domain.partition.IUserRelation0" + userSprom.getRegionCode().toString()).newInstance();
					BeanCopyHelper.copyProperties(relationEntity, userSprom);
					List list = dao.getEntityList(relationEntity, new String[]{"servId", "expireDate"});
					
					if (list != null && list.size()>1)
					{
						Date maxExpireDate = dao.getMaxExpireDate(relationEntity, new String[]{"servId", "soId", "expireDate"});
						if (maxExpireDate != null && !maxExpireDate.equals(userSprom.getExpireDate()))
						{
							this.setExpireDate(maxExpireDate);
							this.setSoId(userSprom.getSoId());
						}
						else
							return this;
					}
					else
					{
						if (userSprom != null)
							this.setSoId(userSprom.getSoId());
						else
							return this;
					}
				}
				
			} catch (Exception e) {
				throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
						"构造实体对象com.asiainfo.boss4.domain.partition.IUserRelation0" + this.getRegionCode().toString() + "出错");
			}
			
		}
		super.modifyExpireDate(context);
		
		//成员
		if (this.getMemberMsisdn()!=null&&!"".equals(this.getMemberMsisdn().trim())
				&&this.getCentralMsisdn()!=null&&!"".equals(this.getCentralMsisdn().trim())
				&& context.getTranCode().getTranCode().equals(TranCode.CRM_CENTREX.getTranCode()))
		{
			IUser user = dao.queryIUserByPhoneNumber(this.getMemberMsisdn().trim());
			if (user != null)
			{
				// 实例化实体类
				try {
					//sid为主键，新生成一个，以避免成员servId最后一样与集团相同时同表主键冲突
					Long sid = Long.valueOf(dao.querySid().toString());
					IUserSprom entity = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString()).newInstance();
					BeanCopyHelper.copyProperties(entity, this);
					entity.setSpromId(Integer.valueOf(this.getSpromId().intValue() - 30000000));
					entity.setServId(user.getServId());
					entity.setRegionCode(user.getRegionCode());
					entity.setSid(sid);				
					entity.setSoId(this.getSoId().longValue()+100000000000000l);
					
					Map selectDBConditions = new HashMap();
					List selectList = new ArrayList();
					selectList.add("expireDate");
					selectList.add("expire_date");
					selectDBConditions.put("expireDate", selectList);
					
					selectList = new ArrayList();
					selectList.add("sid");
					selectList.add("sid");
					selectDBConditions.put("sid", selectList);
					
					selectList = new ArrayList();
					selectList.add("soNbr");
					selectList.add("so_Nbr");
					selectDBConditions.put("soNbr", selectList);
					
					if (this.getCentralMsisdn()!=null)
					{
						String[] centralMsisdnList = this.getCentralMsisdn().split(",");
						for (int j=0;j<centralMsisdnList.length;j++){
							String centralMsisdn = centralMsisdnList[j];
							IUserRelation relationEntity = (IUserRelation)Class.forName("com.asiainfo.boss4.domain.partition.IUserRelation0" + user.getRegionCode().toString()).newInstance();
							BeanCopyHelper.copyProperties(relationEntity, entity);
							relationEntity.setRservId(centralMsisdn);
							relationEntity.setRregionCode((short) 1000);
							relationEntity.setSoId(this.getSoId().longValue()+200000000000000l);
							
							CommonDao cd = (CommonDao) getAnnotation(EntityPartitionHelper.getOriginalClassForPartition(relationEntity), CommonDao.class);
							
							if (cd.fieldOfSelectConditions() == null) {
								throw new BossException(StatusCode.INSIDE_ERROR,
										"The @CommonDao(fieldOfSelectConditions) does not annotate on class "
												+ relationEntity.getClass().getSimpleName());
							}
							Map selectConditions = new HashMap();
							if (cd.fieldOfSelectConditions().length == cd.fieldOfDBSelectConditions().length)
							{
								for (int i=0;i<cd.fieldOfSelectConditions().length;i++)
								{
									List list = new ArrayList();
									String field = cd.fieldOfSelectConditions()[i];
									String dbField = cd.fieldOfDBSelectConditions()[i];
									list.add(field);
									list.add(dbField);
									selectConditions.put(field, list);
								}
							}
							dao.updateExpireDate(relationEntity, selectConditions, selectDBConditions, "0"+user.getRegionCode().toString(), "zg.i_user_relation");

						}
					}
					
//					ISpromParam paramEntity = (ISpromParam)Class.forName("com.asiainfo.boss4.domain.partition.ISpromParam0" + user.getRegionCode().toString()).newInstance();
//					BeanCopyHelper.copyProperties(paramEntity, entity);
//					paramEntity.setKeyId(790002);
//					paramEntity.setSpromPara("100");										
//
//					cd = (CommonDao) getAnnotation(EntityPartitionHelper.getOriginalClassForPartition(paramEntity), CommonDao.class);
//					
//					if (cd.fieldOfSelectConditions() == null) {
//						throw new BossException(StatusCode.INSIDE_ERROR,
//								"The @CommonDao(fieldOfSelectConditions) does not annotate on class "
//										+ paramEntity.getClass().getSimpleName());
//					}
//					selectConditions = new HashMap();
//					if (cd.fieldOfSelectConditions().length == cd.fieldOfDBSelectConditions().length)
//					{
//						for (int i=0;i<cd.fieldOfSelectConditions().length;i++)
//						{
//							List list = new ArrayList();
//							String field = cd.fieldOfSelectConditions()[i];
//							String dbField = cd.fieldOfDBSelectConditions()[i];
//							list.add(field);
//							list.add(dbField);
//							selectConditions.put(field, list);
//						}
//					}
//					dao.updateExpireDate(paramEntity, selectConditions, selectDBConditions, "0"+user.getRegionCode().toString(), "zg.i_sprom_param");

					CommonDao cd = (CommonDao) getAnnotation(EntityPartitionHelper.getOriginalClassForPartition(entity), CommonDao.class);
					
					if (cd.fieldOfSelectConditions() == null) {
						throw new BossException(StatusCode.INSIDE_ERROR,
								"The @CommonDao(fieldOfSelectConditions) does not annotate on class "
										+ entity.getClass().getSimpleName());
					}
					Map selectConditions = new HashMap();
					if (cd.fieldOfSelectConditions().length == cd.fieldOfDBSelectConditions().length)
					{
						for (int i=0;i<cd.fieldOfSelectConditions().length;i++)
						{
							List list = new ArrayList();
							String field = cd.fieldOfSelectConditions()[i];
							String dbField = cd.fieldOfDBSelectConditions()[i];
							list.add(field);
							list.add(dbField);
							selectConditions.put(field, list);
						}
					}
					
					dao.backupAutoSuffix(entity, cd.fieldOfSelectConditions());
					dao.updateExpireDate(entity, selectConditions, selectDBConditions, "0"+user.getRegionCode().toString(), "zg.i_user_sprom");
					
					entity.setSpromId(Integer.valueOf(50001426));
					entity.setSoId(this.getSoId().longValue()+200000000000000l);
					dao.backupAutoSuffix(entity, cd.fieldOfSelectConditions());
					dao.updateExpireDate(entity, selectConditions, selectDBConditions, "0"+user.getRegionCode().toString(), "zg.i_user_sprom");
					
										
					
					ISaleOper memberSaleOper = (ISaleOper) BeanCopyHelper.newInstance(
							"com.asiainfo.boss4.domain.partition.ISaleOper0"+user.getRegionCode().toString());
					BeanCopyHelper.copyProperties(memberSaleOper, entity);
					memberSaleOper.setAcctId(user.getAcctId());
					memberSaleOper.setCustId(user.getCustId());
					memberSaleOper.setBusiCode(0);
					memberSaleOper.setCommitDate(context.getSoDate());
					memberSaleOper.setCountyCode((short)1000);
					memberSaleOper.setOrgId(0);
					memberSaleOper.setGroupId(0l);
					//上发iUserSprom、iUserRelation表
					memberSaleOper.setUpField("0100000010000000000000000000000000000000000000000000000000000000");
//					//设置新的SID，防止主键冲突
//					memberSaleOper.setSid(Long.valueOf(dao.querySid().toString()));
					dao.add(memberSaleOper);
					
				} catch (Exception e) {
					throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
							"构造实体对象com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString() + "出错");
				}
			}
		}	
		else if (this.getMemberMsisdn()!=null&&!"".equals(this.getMemberMsisdn().trim())
				&&this.getCentralMsisdn()!=null&&!"".equals(this.getCentralMsisdn().trim())
				&&!this.getMemberMsisdn().equals(this.getCentralMsisdn())
				&& context.getTranCode().getTranCode().equals(TranCode.CRM_V_PAYMENT.getTranCode()))
		{
		
			IUser user = dao.queryIUserByPhoneNumber(this.getMemberMsisdn().trim());
			if (user != null)
			{
				// 实例化实体类
				try {
					//sid为主键，新生成一个
					Long sid = Long.valueOf(dao.querySid().toString());
					IUserSprom entity = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString()).newInstance();
					BeanCopyHelper.copyProperties(entity, this);
					entity.setSpromId(Integer.valueOf(83200017));
					entity.setServId(user.getServId());
					entity.setRegionCode(user.getRegionCode());
					entity.setSpromType(0);
					entity.setSid(sid);				
					entity.setSoId(this.getSoId().longValue()+100000000000000l);
					
					Map selectDBConditions = new HashMap();
					List selectList = new ArrayList();
					selectList.add("expireDate");
					selectList.add("expire_date");
					selectDBConditions.put("expireDate", selectList);
					
					selectList = new ArrayList();
					selectList.add("sid");
					selectList.add("sid");
					selectDBConditions.put("sid", selectList);
					
					selectList = new ArrayList();
					selectList.add("soNbr");
					selectList.add("so_Nbr");
					selectDBConditions.put("soNbr", selectList);
					
					CommonDao cd = (CommonDao) getAnnotation(EntityPartitionHelper.getOriginalClassForPartition(entity), CommonDao.class);
					
					if (cd.fieldOfSelectConditions() == null) {
						throw new BossException(StatusCode.INSIDE_ERROR,
								"The @CommonDao(fieldOfSelectConditions) does not annotate on class "
										+ entity.getClass().getSimpleName());
					}
					Map selectConditions = new HashMap();
					if (cd.fieldOfSelectConditions().length == cd.fieldOfDBSelectConditions().length)
					{
						for (int i=0;i<cd.fieldOfSelectConditions().length;i++)
						{
							List list = new ArrayList();
							String field = cd.fieldOfSelectConditions()[i];
							String dbField = cd.fieldOfDBSelectConditions()[i];
							list.add(field);
							list.add(dbField);
							selectConditions.put(field, list);
						}
					}
					
					dao.backupAutoSuffix(entity, cd.fieldOfSelectConditions());
					dao.updateExpireDate(entity, selectConditions, selectDBConditions, "0"+user.getRegionCode().toString(), "zg.i_user_sprom");
					
					ISaleOper memberSaleOper = (ISaleOper) BeanCopyHelper.newInstance(
							"com.asiainfo.boss4.domain.partition.ISaleOper0"+user.getRegionCode().toString());
					BeanCopyHelper.copyProperties(memberSaleOper, entity);
					memberSaleOper.setAcctId(user.getAcctId());
					memberSaleOper.setCustId(user.getCustId());
					memberSaleOper.setBusiCode(0);
					memberSaleOper.setCommitDate(context.getSoDate());
					memberSaleOper.setCountyCode((short)1000);
					memberSaleOper.setOrgId(0);
					memberSaleOper.setGroupId(0l);
					//上发iUserSprom
					memberSaleOper.setUpField("0100000000000000000000000000000000000000000000000000000000000000");
					dao.add(memberSaleOper);
					
				} catch (Exception e) {
					throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
							"构造实体对象com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString() + "出错");
				}
			}
			else
				throw new BossException(StatusCode.IUSER_ISNULL_ERROR,"用户"+getMemberMsisdn()+"不存在");
			
			user = dao.queryIUserByPhoneNumber(this.getCentralMsisdn().trim());
			if (user != null)
			{
				// 实例化实体类
				try {
					//sid为主键，新生成一个
					Long sid = Long.valueOf(dao.querySid().toString());
					IUserSprom entity = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString()).newInstance();
					BeanCopyHelper.copyProperties(entity, this);
					entity.setSpromId(Integer.valueOf(80001400));
					entity.setServId(user.getServId());
					entity.setRegionCode(user.getRegionCode());
					entity.setSpromType(0);
					entity.setSid(sid);				
					entity.setSoId(this.getSoId().longValue()+200000000000000l);
					
					Map selectDBConditions = new HashMap();
					List selectList = new ArrayList();
					selectList.add("expireDate");
					selectList.add("expire_date");
					selectDBConditions.put("expireDate", selectList);
					
					selectList = new ArrayList();
					selectList.add("sid");
					selectList.add("sid");
					selectDBConditions.put("sid", selectList);
					
					selectList = new ArrayList();
					selectList.add("soNbr");
					selectList.add("so_Nbr");
					selectDBConditions.put("soNbr", selectList);
					
					CommonDao cd = (CommonDao) getAnnotation(EntityPartitionHelper.getOriginalClassForPartition(entity), CommonDao.class);
					
					if (cd.fieldOfSelectConditions() == null) {
						throw new BossException(StatusCode.INSIDE_ERROR,
								"The @CommonDao(fieldOfSelectConditions) does not annotate on class "
										+ entity.getClass().getSimpleName());
					}
					Map selectConditions = new HashMap();
					if (cd.fieldOfSelectConditions().length == cd.fieldOfDBSelectConditions().length)
					{
						for (int i=0;i<cd.fieldOfSelectConditions().length;i++)
						{
							List list = new ArrayList();
							String field = cd.fieldOfSelectConditions()[i];
							String dbField = cd.fieldOfDBSelectConditions()[i];
							list.add(field);
							list.add(dbField);
							selectConditions.put(field, list);
						}
					}
					
					dao.backupAutoSuffix(entity, cd.fieldOfSelectConditions());
					dao.updateExpireDate(entity, selectConditions, selectDBConditions, "0"+user.getRegionCode().toString(), "zg.i_user_sprom");
					
					ISaleOper memberSaleOper = (ISaleOper) BeanCopyHelper.newInstance(
							"com.asiainfo.boss4.domain.partition.ISaleOper0"+user.getRegionCode().toString());
					BeanCopyHelper.copyProperties(memberSaleOper, entity);
					memberSaleOper.setAcctId(user.getAcctId());
					memberSaleOper.setCustId(user.getCustId());
					memberSaleOper.setBusiCode(0);
					memberSaleOper.setCommitDate(context.getSoDate());
					memberSaleOper.setCountyCode((short)1000);
					memberSaleOper.setOrgId(0);
					memberSaleOper.setGroupId(0l);
					//上发iUserSprom
					memberSaleOper.setUpField("0100000000000000000000000000000000000000000000000000000000000000");
					dao.add(memberSaleOper);
					
				} catch (Exception e) {
					throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
							"构造实体对象com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString() + "出错");
				}
			}
			else
				throw new BossException(StatusCode.IUSER_ISNULL_ERROR,"用户"+getCentralMsisdn()+"不存在");
			
		}
		return this;
	}
	
	@Override
	public BaseEntity rollBack(ServiceContext context) {
		BusinessDao dao = (BusinessDao)context.getBeanFactory().getBean("businessDao");
		
		if (context.getTranCode().getTranCode().equals(TranCode.CRM_FIXED_BUG.getTranCode()))
		{
			if (this.getMemberMsisdn()!=null&&!"".equals(this.getMemberMsisdn().trim()))
			{
				IUserAll user = new IUserAll();
				user.setMsisdn(this.getMemberMsisdn().trim());
				user.setUserType(Short.valueOf("202"));
				user = (IUserAll)dao.getEntity(user, new String[]{"msisdn","userType","expireDate"});
				if (user != null)
				{
					try{
						IUserSprom userSprom = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString()).newInstance();
						BeanCopyHelper.copyBeanNotNullProperty(userSprom, this);
						userSprom.setServId(user.getServId());
						userSprom.setRegionCode(user.getRegionCode());
						dao.commonRollBack(userSprom);
						
						if (this.getRegionCode().shortValue() != user.getRegionCode().shortValue())
						{
							//需要上发
							ISaleOper memberSaleOper = (ISaleOper) BeanCopyHelper.newInstance(
									"com.asiainfo.boss4.domain.partition.ISaleOper0"+user.getRegionCode().toString());
							BeanCopyHelper.copyProperties(memberSaleOper, userSprom);
							memberSaleOper.setAcctId(user.getAcctId());
							memberSaleOper.setCustId(user.getCustId());
							memberSaleOper.setBusiCode(0);
							memberSaleOper.setCommitDate(context.getSoDate());
							memberSaleOper.setCountyCode((short)1000);
							memberSaleOper.setOrgId(0);
							memberSaleOper.setGroupId(0l);
							//上发iUserSprom、iUserRelation表
							memberSaleOper.setUpField(UpFieldUtil.getUpField(userSprom, UpFieldUtil.EMPTY_UPFIELD));
							dao.add(memberSaleOper);
						}
						return userSprom;
					}catch (Exception e) {
						throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
								"构造实体对象com.asiainfo.boss4.domain.partition.IUserSprom0" + user.getRegionCode().toString() + "出错");
					}
				}
				else
					throw new BossException(StatusCode.NOT_EXIST_USER_ERROR,"固移通成员MemberMsisdn"+this.getMemberMsisdn().trim()+"不存在");
			}
			else
				throw new BossException(StatusCode.ILLEGAL_INPUT_PROPERTY_ERROR,"固移通订购必须送MemberMsisdn");	
		}
		if (context.getTranCode().getTranCode().equals(TranCode.CRM_CENTREX_REFERENCE.getTranCode()))
			throw new BossException(StatusCode.ROLLBACK_ENTITY_ERROR, "Centrex统一号显业务"+StatusCode.ROLLBACK_ENTITY_ERROR.getDescription());
		
		if (context.getTranCode().getTranCode().equals(TranCode.CRM_HAPPY_PRODUCT.getTranCode())
				&&this.getSpromId().intValue() == Integer.decode(Constance.CRMHAPPYPRODUCT).intValue())
		{
			throw new BossException(StatusCode.ROLLBACK_ENTITY_ERROR, "幸福套餐"+StatusCode.ROLLBACK_ENTITY_ERROR.getDescription());
		}
		if (this.getMemberMsisdn()!=null&&!"".equals(this.getMemberMsisdn().trim())
					&& context.getTranCode().getTranCode().equals(TranCode.CRM_CENTREX.getTranCode()))
				
		{
			throw new BossException(StatusCode.ROLLBACK_ENTITY_ERROR, "统一Centrex"+StatusCode.ROLLBACK_ENTITY_ERROR.getDescription());
		}
		
		if (context.getTranCode().getTranCode().equals(TranCode.CRM_V_PAYMENT.getTranCode()))
			throw new BossException(StatusCode.ROLLBACK_ENTITY_ERROR, "Centrex融合V网手机统付"+StatusCode.ROLLBACK_ENTITY_ERROR.getDescription());
			
		return (BaseEntity)dao.commonRollBack(this);
	}
	
	public static List<IUserSprom> removeAllByServId(ServiceContext context, Long servId) {
		return removeByServIdAndSpromId(context, servId, null);
	}
	
	public static List<IUserSprom> removeByServIdAndSpromId(ServiceContext context, Long servId, Integer[] spromIds) {
		Class<?> partitionClass = EntityPartitionHelper.getClassForPartition(IUserSprom.class, servId);
		Criteria crit = context.getBusinessDao().getSess().createCriteria(partitionClass);
		
		if (spromIds != null && spromIds.length != 0) {
			crit.add(Restrictions.in("spromId", spromIds));
		}
		
		@SuppressWarnings("unchecked")
		List<IUserSprom> sproms = (List<IUserSprom>) crit.add(Restrictions.eq("servId", servId))
			.add(Restrictions.sqlRestriction("expire_date > sysdate"))
			.list();
//		context.getBusinessDao().flushAndClear();
		
		ISaleOper oper = ISaleOper.newInstanceByServId(context, servId);
		for (IUserSprom sprom : sproms) {
			sprom.setExpireDate(oper.getCommitDate());
			sprom.setSoNbr(oper.getSid());
//			sprom.cancel(context);
			context.getBusinessDao().flush();
			
			oper.updateUpField(sprom);
		}
		
		oper.add(context);
		
		context.getBusinessDao().flushAndClear();
		
		return sproms;
	}
	
	public static IUserSprom queryRecentByServId(ServiceContext context, Long servId) {
		Class<?> partitionClass = EntityPartitionHelper.getClassForPartition(IUserSprom.class, servId);
		Criteria crit = context.getBusinessDao().getSess().createCriteria(partitionClass);
		
		try {
			return (IUserSprom) crit.add(Restrictions.eq("servId", servId))
										.addOrder(Order.desc("expireDate"))
										.addOrder(Order.desc("sid"))
										.setMaxResults(1)
										.uniqueResult();
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	public IUserSprom getByPk(ServiceContext context) {
		Criteria crit = context.getBusinessDao().getSess().createCriteria(this.getClass());
		
		try {
			return (IUserSprom) crit.add(Restrictions.eq("servId", getServId()))
									 .add(Restrictions.eq("spromId", getSpromId()))
									 .add(Restrictions.eq("operType", getOperType()))
									 .add(Restrictions.eq("validDate", getValidDate()))
									 .add(Restrictions.eq("soId", getSoId()))
									 .uniqueResult();
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	@Override
	public String toString() {
        return new ToStringBuilder(this)
            .append("servId", getServId())
            .append("spromId", getSpromId())
            .append("validDate", getValidDate())
            .append("operType", getOperType())
            .append("serviceId",getServiceId())
            .append("regionCode",getRegionCode())
            .append("spromType",getSpromType())
            .append("busiType",getBusiType())
            .append("spromPrior",getSpromPrior())
            .append("spromPara",getSpromPara())
            .append("payMode",getPayMode())
            .append("property",getProperty())
            .append("beginDate",getBeginDate())
            .append("expireDate",getExpireDate())
            .append("sid",getSid())
            .append("soNbr",getSoNbr())
            .append("maxProm",getMaxProm())
            .append("remark",getRemark())
            .append("planId",getPlanId())
            .append("referenceObject",getReferenceObject())
            .append("resultObject",getResultObject())
            .append("soId",getSoId())
            .toString();
    }
	
	public static class IUserSpromId implements java.io.Serializable {

		// Fields

		private Long servId;
		private Integer spromId;
		private Byte operType;
		private Date validDate;
		private Long soId;

		// Constructors

		/** default constructor */
		public IUserSpromId() {
		}

		/** full constructor */
		public IUserSpromId(Long servId, Integer spromId, Byte operType,
				Date validDate, Long soId) {
			this.servId = servId;
			this.spromId = spromId;
			this.operType = operType;
			this.validDate = validDate;
			this.soId = soId;
		}

		// Property accessors

		@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
		public Long getServId() {
			return this.servId;
		}

		public void setServId(Long servId) {
			this.servId = servId;
		}

		@Column(name = "SPROM_ID", nullable = false, precision = 8, scale = 0)
		public Integer getSpromId() {
			return this.spromId;
		}

		public void setSpromId(Integer spromId) {
			this.spromId = spromId;
		}

		@Column(name = "OPER_TYPE", nullable = false, precision = 2, scale = 0)
		public Byte getOperType() {
			return this.operType;
		}

		public void setOperType(Byte operType) {
			this.operType = operType;
		}

		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "VALID_DATE", nullable = false, length = 7)
		public Date getValidDate() {
			return this.validDate;
		}

		public void setValidDate(Date validDate) {
			this.validDate = validDate;
		}

		@Column(name = "SO_ID", nullable = false, precision = 15, scale = 0)
		public Long getSoId() {
			return this.soId;
		}

		public void setSoId(Long soId) {
			this.soId = soId;
		}

		@Override
		public boolean equals(Object other) {
	        if ( !(other instanceof IUserSpromId) ) return false;
	        IUserSpromId castOther = (IUserSpromId) other;
	        return new EqualsBuilder()
	            .append(this.getServId(), castOther.getServId())
	            .append(this.getSpromId(), castOther.getSpromId())
	            .append(this.getValidDate(), castOther.getValidDate())
	            .append(this.getOperType(), castOther.getOperType())
	            .isEquals();
	    }
		
		@Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getServId())
	            .append(getSpromId())
	            .append(getValidDate())
	            .append(getOperType())
	            .toHashCode();
	    }

	}
}