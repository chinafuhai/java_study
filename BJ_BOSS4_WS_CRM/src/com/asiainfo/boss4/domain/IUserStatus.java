package com.asiainfo.boss4.domain;

import java.util.Date;
import java.util.List;

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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.Constance;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.UpFieldUtil;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable;

/**
 * IUserStatus entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
//@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_STATUS", schema = "ZG")
@IdClass(IUserStatus.IUserStatusId.class)
@PartitionNameForTable
@PartitionNameForTable.RegionCode
@Backup.CopyToSuffix
@CommonDao(fieldOfSelectConditions = { "servId", "userType", "expireDate" },fieldOfDBSelectConditions={"serv_id","user_Type","expire_date"}, isOverwriteWhenAdd = true)
public class IUserStatus extends BaseEntity implements java.io.Serializable {
	private Log logger = LogFactory.getLog(IUserStatus.class);
	// Fields

	private Long servId;
	private Long sid;
	private Long soNbr;
	private Byte userSts;
	private Byte operSts;
	private Byte acctSts;
	private Byte mgntSts;
	private Short userType;
	private Short brand;
	private Integer planId;
	private Short regionCode;
	private Short countyCode;
	private String countyCodeBak;
	private Integer orgId;
	private Date beginDate;
	private Date validDate;
	private Date expireDate;
	private String remark;

	private Long virtualServId;
	private String strGroupSprom;
	// Constructors

	/** default constructor */
	public IUserStatus() {
	}

	/** minimal constructor */
	public IUserStatus(Long servId, Long sid, Long soNbr, Byte userSts, Short userType,
			Short brand, Integer planId, Short regionCode, Short countyCode,
			Integer orgId, Date beginDate, Date validDate, Date expireDate) {
		this.servId = servId;
		this.sid = sid;
		this.soNbr = soNbr;
		this.userSts = userSts;
		this.userType = userType;
		this.brand = brand;
		this.planId = planId;
		this.regionCode = regionCode;
		this.countyCode = countyCode;
		this.orgId = orgId;
		this.beginDate = beginDate;
		this.validDate = validDate;
		this.expireDate = expireDate;
	}

	/** full constructor */
	public IUserStatus(Long servId, Long sid, Long soNbr, Byte userSts, Byte operSts,
			Byte acctSts, Byte mgntSts, Short userType, Short brand,
			Integer planId, Short regionCode, Short countyCode,
			String countyCodeBak, Integer orgId, Date beginDate,
			Date validDate, Date expireDate, String remark) {
		this.servId = servId;
		this.sid = sid;
		this.soNbr = soNbr;
		this.userSts = userSts;
		this.operSts = operSts;
		this.acctSts = acctSts;
		this.mgntSts = mgntSts;
		this.userType = userType;
		this.brand = brand;
		this.planId = planId;
		this.regionCode = regionCode;
		this.countyCode = countyCode;
		this.countyCodeBak = countyCodeBak;
		this.orgId = orgId;
		this.beginDate = beginDate;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.remark = remark;
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
	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	@Id
	public Long getSoNbr() {
		return soNbr;
	}

	public void setSoNbr(Long soNbr) {
		this.soNbr = soNbr;
	}

	@Column(name = "USER_STS", nullable = false, precision = 2, scale = 0)
	public Byte getUserSts() {
		return this.userSts;
	}

	public void setUserSts(Byte userSts) {
		this.userSts = userSts;
	}

	@Column(name = "OPER_STS", precision = 2, scale = 0)
	public Byte getOperSts() {
		return this.operSts;
	}

	public void setOperSts(Byte operSts) {
		this.operSts = operSts;
	}

	@Column(name = "ACCT_STS", precision = 2, scale = 0)
	public Byte getAcctSts() {
		return this.acctSts;
	}

	public void setAcctSts(Byte acctSts) {
		this.acctSts = acctSts;
	}

	@Column(name = "MGNT_STS", precision = 2, scale = 0)
	public Byte getMgntSts() {
		return this.mgntSts;
	}

	public void setMgntSts(Byte mgntSts) {
		this.mgntSts = mgntSts;
	}

	@Column(name = "USER_TYPE", nullable = false, precision = 4, scale = 0)
	public Short getUserType() {
		return this.userType;
	}

	public void setUserType(Short userType) {
		this.userType = userType;
	}

	@Column(name = "BRAND", nullable = false, precision = 4, scale = 0)
	public Short getBrand() {
		return this.brand;
	}

	public void setBrand(Short brand) {
		this.brand = brand;
	}

	@Column(name = "PLAN_ID", nullable = false, precision = 8, scale = 0)
	public Integer getPlanId() {
		return this.planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	@Column(name = "REGION_CODE", nullable = false, precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "COUNTY_CODE", nullable = false, precision = 4, scale = 0)
	public Short getCountyCode() {
		return this.countyCode;
	}

	public void setCountyCode(Short countyCode) {
		this.countyCode = countyCode;
	}

	@Column(name = "COUNTY_CODE_BAK", length = 8)
	public String getCountyCodeBak() {
		return this.countyCodeBak;
	}

	public void setCountyCodeBak(String countyCodeBak) {
		this.countyCodeBak = countyCodeBak;
	}

	@Column(name = "ORG_ID", nullable = false, precision = 8, scale = 0)
	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
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

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Transient
	public Long getVirtualServId() {
		return virtualServId;
	}

	public void setVirtualServId(Long virtualServId) {
		this.virtualServId = virtualServId;
	}

	@Transient
	public String getStrGroupSprom() {
		return strGroupSprom;
	}

	public void setStrGroupSprom(String strGroupSprom) {
		this.strGroupSprom = strGroupSprom;
	}

	@Override
	public String toString() {
        return new ToStringBuilder(this)
            .append("servId", getServId())
            .append("sid", getSid())
            .append("soNbr", getSoNbr())
            .append("userSts",getUserSts())
            .append("operSts",getOperSts())
            .append("acctSts",getAcctSts())
            .append("mgntSts",getMgntSts())
            .append("userType",getUserType())
            .append("brand",getBrand())
            .append("planId",getPlanId())
            .append("regionCode",getRegionCode())
            .append("countyCode",getCountyCode())
            .append("countyCodeBak",getCountyCodeBak())
            .append("orgId",getOrgId())
            .append("beginDate",getBeginDate())
            .append("validDate",getValidDate())
            .append("expireDate",getExpireDate())
            .append("remark",getRemark())
            .toString();
    }
	
	public static class IUserStatusId implements java.io.Serializable {

		// Fields

		private Long servId;
		private Long sid;
		private Long soNbr;

		// Constructors

		/** default constructor */
		public IUserStatusId() {
		}

		/** full constructor */
		public IUserStatusId(Long servId, Long sid, Long soNbr) {
			this.servId = servId;
			this.sid = sid;
			this.soNbr = soNbr;
		}

		// Property accessors

		@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
		public Long getServId() {
			return this.servId;
		}

		public void setServId(Long servId) {
			this.servId = servId;
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

		@Override
		public boolean equals(Object other) {
			if ( !(other instanceof IUserStatusId) ) return false;
			IUserStatusId castOther = (IUserStatusId) other;
	        return new EqualsBuilder()
	            .append(this.getServId(), castOther.getServId())
	            .append(this.getSid(), castOther.getSid())
	            .append(this.getSoNbr(), castOther.getSoNbr())
	            .isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder()
	        .append(getServId())
	        .append(getSid())
	        .append(getSoNbr())
	        .toHashCode();
		}

	}
	
	public static List<IUserStatus> queryHis(ServiceContext context, Long servId) {
		Criteria crit = context.getBusinessDao().getSess().createCriteria(
				EntityPartitionHelper.getClassForPartition(IUserStatus.class, servId));
		@SuppressWarnings("unchecked")
		List<IUserStatus> list = 	crit.add(Restrictions.eq("servId", servId))
										.add(Restrictions.sqlRestriction("expire_date < sysdate"))
										.addOrder(Order.desc("validDate"))
										.addOrder(Order.desc("sid"))
										.list();
		return list;
	}
	
	@Override
	public BaseEntity modify(ServiceContext context) {
		BusinessDao dao = (BusinessDao)context.getBeanFactory().getBean("businessDao");
		//家庭计划停开机00007
		if (context.getTranCode().getTranCode().equals(TranCode.CRM_HOME_STOP_RESUME.getTranCode())){

			boolean hasVirtualServId = false ;
			boolean hasStrGroupSprom = false ;
			
			//家庭计划停开机[CRM报文值VirtualServId]
			if (this.getVirtualServId()!=null && this.getVirtualServId().longValue() >0){
				boolean isStop = false;  //true停机   false开机
				
				//取虚似用户: VirtualServId为虚似用户号码
				IUserAll userAll = new IUserAll();
				userAll.setServId(this.getVirtualServId());
				IUser user = (IUser)dao.getEntity(userAll, new String[]{"servId","expireDate"});
				if (user == null){
					throw new BossException(StatusCode.QUERY_ENTITY_ERROR,"家庭计划停开机servId="+this.getVirtualServId()+"虚用户数据不存在");
				}
					
				//取实体用户数据库中IUserStatus数据
				IUserStatus userStatus= (IUserStatus)dao.getEntity(this, this.getFieldOfSelectConditionsOnCommonDaoAnnotation());
				if (userStatus == null){
					throw new BossException(StatusCode.QUERY_ENTITY_ERROR,"家庭计划停开机servId="+this.getServId()+"用户状态数据不存在");
				}
				
				//实体用户数据库状态与entity状态比较
				if (userStatus.getUserSts() != null && userStatus.getUserSts().shortValue() == this.getUserSts().shortValue() 
						&& userStatus.getAcctSts() != null && userStatus.getAcctSts().shortValue() == this.getAcctSts().shortValue()
						&& userStatus.getMgntSts() != null && userStatus.getMgntSts().shortValue() == this.getMgntSts().shortValue()
						&& userStatus.getOperSts() != null && userStatus.getOperSts().shortValue() == this.getOperSts().shortValue()){
					
					//用户状态未变动，不需要变动虚用户的订购
					logger.warn("用户"+this.getServId()+"状态未变动，不需要变动虚用户的订购");
				}else if ((userStatus.getUserSts() != null && userStatus.getUserSts().shortValue() != this.getUserSts().shortValue())
						||(userStatus.getAcctSts() != null && userStatus.getAcctSts().shortValue() != this.getAcctSts().shortValue())
						||(userStatus.getMgntSts() != null && userStatus.getMgntSts().shortValue() != this.getMgntSts().shortValue())
						||(userStatus.getOperSts() != null && userStatus.getOperSts().shortValue() != this.getOperSts().shortValue())){
					
					//取虚拟用户数据库中最后一条订购
					Criteria crit = context.getBusinessDao().getSess().createCriteria(
							EntityPartitionHelper.getClassForPartition(IUserSprom.class, this.getVirtualServId()));
					@SuppressWarnings("unchecked")
					List<IUserSprom> list = 	crit.add(Restrictions.eq("servId", this.getVirtualServId()))
													.addOrder(Order.desc("validDate"))
													.addOrder(Order.desc("sid"))
													.list();
					if (list == null || list.size() <=0){
						throw new BossException(StatusCode.QUERY_ENTITY_ERROR,"家庭计划停开机servId="+this.getVirtualServId()+"虚用户订购数据不存在");
					}
					IUserSprom userSprom = list.get(0);
					
					//实体用户比较停开机状态
					if (userStatus.getUserSts() != null && userStatus.getUserSts().shortValue() != this.getUserSts().shortValue()){
						if (this.getUserSts().shortValue() != 1) isStop = true; 
					}
					else if (userStatus.getAcctSts() != null && userStatus.getAcctSts().shortValue() != this.getAcctSts().shortValue()){
						if (this.getAcctSts().shortValue() != 0) isStop = true;
					}
					else if (userStatus.getMgntSts() != null && userStatus.getMgntSts().shortValue() != this.getMgntSts().shortValue()){
						if (this.getMgntSts().shortValue() != 0) isStop = true;
					}
					else if (userStatus.getOperSts() != null && userStatus.getOperSts().shortValue() != this.getOperSts().shortValue()){
						if (this.getOperSts().shortValue() != 0) isStop = true;
					}
					Long sid = Long.valueOf(dao.querySid().toString());
					
					if (isStop){//停机
						userSprom.setRemark(DateHelper.Date2String(userSprom.getExpireDate()));
						userSprom.setExpireDate(context.getSoDate());
						userSprom.setSid(sid);
						userSprom.setSoNbr(this.getSoNbr());
						dao.update(userSprom);
					}else{//开机
						if (userSprom.getExpireDate().before(context.getSoDate())){
							try{
								IUserSprom newUserSprom = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + userSprom.getRegionCode().toString()).newInstance();
								BeanCopyHelper.copyBeanNotNullProperty(newUserSprom, userSprom);
								newUserSprom.setBeginDate(context.getSoDate());
								newUserSprom.setValidDate(context.getSoDate());
								if (userSprom.getRemark() != null && !"".equals(userSprom.getRemark()))
									newUserSprom.setExpireDate(DateHelper.String2Date(userSprom.getRemark()));
								else
									newUserSprom.setExpireDate(DateHelper.String2Date(Constance.DEFAULTEXPIREDATE));
								newUserSprom.setSid(sid);
								newUserSprom.setSoNbr(this.getSoNbr());
								dao.add(newUserSprom);
							}catch (Exception e) {
								throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
									"构造实体对象com.asiainfo.boss4.domain.partition.IUserSprom0" + userSprom.getRegionCode().toString() + "出错");
							}
						}else{
							//如果套餐已经恢复,则不再添加
							logger.warn("servId="+userSprom.getServId()+",spromId="+userSprom.getSpromId()+"套餐已经恢复，不需要再次恢复");		
						}
					}
					//为虚用户上发
					ISaleOper memberSaleOper = (ISaleOper) BeanCopyHelper.newInstance(
							"com.asiainfo.boss4.domain.partition.ISaleOper0"+userSprom.getRegionCode().toString());
					BeanCopyHelper.copyProperties(memberSaleOper, userSprom);
					memberSaleOper.setAcctId(user.getAcctId());
					memberSaleOper.setCustId(user.getCustId());
					memberSaleOper.setBusiCode(0);
					memberSaleOper.setCommitDate(context.getSoDate());
					memberSaleOper.setCountyCode((short)1000);
					memberSaleOper.setOrgId(0);
					memberSaleOper.setGroupId(0l);
					memberSaleOper.setSid(sid);
					//上发iUserSprom表
					memberSaleOper.setUpField(UpFieldUtil.getUpField(userSprom, UpFieldUtil.EMPTY_UPFIELD));
					dao.add(memberSaleOper);	
				}
			}
			else{
				hasVirtualServId = true ;
			}
            
			//业务代码1000爱家套餐停开机[CRM报文值StrGroupSprom]
			//业务代码1001多终端共享停开机[CRM报文值StrGroupSprom]
			if (this.getStrGroupSprom()!=null && !"".equals(this.getStrGroupSprom().trim())){
				boolean isStop2 = false; //true停机   false开机
				Long sid;
				
				//业务代码|虚用户ID|套餐1:套餐2:......,业务代码|虚用户ID|套餐1:套餐2:......
				String[] groupSproms = this.getStrGroupSprom().trim().split(",");
				for (int i=0;i<groupSproms.length;i++){
					String [] groupSprom = groupSproms[i].split("\\|");
					if (groupSprom.length != 3  
						|| (groupSprom[0] == null || "".equals(groupSprom[0].trim()) 
						|| groupSprom[1] == null || "".equals(groupSprom[1].trim())
						|| groupSprom[2] == null || "".equals(groupSprom[2].trim())))
						throw new BossException(StatusCode.ILLEGAL_INPUT_PROPERTY_ERROR,"strGroupSprom格式错误,servId="+this.getServId()+",strGroupSprom="+this.getStrGroupSprom());
					
					String[] spromList = groupSprom[2].split("\\:");
					for (int j=0;j<spromList.length;j++){
						String sprom = spromList[j];
						sid = Long.valueOf(dao.querySid().toString());
						
						//业务代码=1000爱家套餐
						if ("1000".equals(groupSprom[0].trim())){
							isStop2 = false; 
							
							//取虚似用户: groupId为虚似用户号码
							IUserAll userAll = new IUserAll();
							userAll.setServId(Long.valueOf(groupSprom[1].trim()));
							IUser user = (IUser)dao.getEntity(userAll, new String[]{"servId","expireDate"});
							if (user == null){
								throw new BossException(StatusCode.QUERY_ENTITY_ERROR,"爱家套餐停开机servId="+groupSprom[1]+"虚用户数据不存在");	
							}
							
							//取实体用户数据库中IUserStatus数据
							IUserStatus userStatus= (IUserStatus)dao.getEntity(this, this.getFieldOfSelectConditionsOnCommonDaoAnnotation());
							if (userStatus == null){
								throw new BossException(StatusCode.QUERY_ENTITY_ERROR,"爱家套餐停开机servId="+this.getServId()+"用户状态数据不存在");
							}
							
							//实体用户数据库状态与entity状态比较
							if (userStatus.getUserSts() != null && userStatus.getUserSts().shortValue() == this.getUserSts().shortValue() 
								&& userStatus.getAcctSts() != null && userStatus.getAcctSts().shortValue() == this.getAcctSts().shortValue()
								&& userStatus.getMgntSts() != null && userStatus.getMgntSts().shortValue() == this.getMgntSts().shortValue()
								&& userStatus.getOperSts() != null && userStatus.getOperSts().shortValue() == this.getOperSts().shortValue()){
								
								//用户状态未变动，不需要变动虚用户的订购
								logger.warn("用户"+this.getServId()+"状态未变动，不需要变动虚用户的订购");
							}else if ((userStatus.getUserSts() != null && userStatus.getUserSts().shortValue() != this.getUserSts().shortValue())
									||(userStatus.getAcctSts() != null && userStatus.getAcctSts().shortValue() != this.getAcctSts().shortValue())
									||(userStatus.getMgntSts() != null && userStatus.getMgntSts().shortValue() != this.getMgntSts().shortValue())
									||(userStatus.getOperSts() != null && userStatus.getOperSts().shortValue() != this.getOperSts().shortValue())){
	
							    //取数据库中虚拟用户最后一条订购
							    Criteria crit = context.getBusinessDao().getSess().createCriteria(
									EntityPartitionHelper.getClassForPartition(IUserSprom.class, user.getServId()));
							    @SuppressWarnings("unchecked")
							    List<IUserSprom> list = crit.add(Restrictions.eq("servId", user.getServId()))
															.add(Restrictions.eq("spromId", Integer.valueOf(sprom)))
															.addOrder(Order.desc("validDate"))
															.addOrder(Order.desc("sid"))
															.list();
							    if (list == null || list.size() <=0){
								     throw new BossException(StatusCode.QUERY_ENTITY_ERROR,"爱家套餐停开机servId="+userAll.getServId()+"虚用户订购数据"+sprom+"不存在");
							    }
							    IUserSprom userSprom = list.get(0);
							    
								//实体用户比较停开机状态
								if (userStatus.getUserSts() != null && userStatus.getUserSts().shortValue() != this.getUserSts().shortValue()){
									if (this.getUserSts().shortValue() != 1) isStop2 = true; 
								}
								else if (userStatus.getAcctSts() != null && userStatus.getAcctSts().shortValue() != this.getAcctSts().shortValue()){
									if (this.getAcctSts().shortValue() != 0) isStop2 = true;
								}
								else if (userStatus.getMgntSts() != null && userStatus.getMgntSts().shortValue() != this.getMgntSts().shortValue()){
									if (this.getMgntSts().shortValue() != 0) isStop2 = true;
								}
								else if (userStatus.getOperSts() != null && userStatus.getOperSts().shortValue() != this.getOperSts().shortValue()){
									if (this.getOperSts().shortValue() != 0) isStop2 = true;
								}
                                
							    if (isStop2){ //停机
								   userSprom.setRemark(DateHelper.Date2String(userSprom.getExpireDate()));
								   userSprom.setExpireDate(context.getSoDate());
								   userSprom.setSid(sid);
								   userSprom.setSoNbr(this.getSoNbr());
								   dao.update(userSprom);
							    }else{ //开机
								    if (userSprom.getExpireDate().before(context.getSoDate())){
									   logger.warn("servId="+userSprom.getServId()+",spromId="+userSprom.getSpromId()+"正在恢复,expireDate="+DateHelper.Date2String(userSprom.getExpireDate()));
									   if (userSprom.getRemark() != null && !"".equals(userSprom.getRemark()))
										    userSprom.setExpireDate(DateHelper.String2Date(userSprom.getRemark()));
									   else
										    userSprom.setExpireDate(DateHelper.String2Date(Constance.DEFAULTEXPIREDATE));
									   userSprom.setSid(sid);
									   userSprom.setSoNbr(this.getSoNbr());
								       dao.update(userSprom);
								    }else{
									   //如果套餐已经恢复,则不再恢复
									   logger.warn("servId="+userSprom.getServId()+",spromId="+userSprom.getSpromId()+"套餐已经恢复，不需要再次恢复");
								    }
							    }
							    //为虚用户上发
							    ISaleOper memberSaleOper = (ISaleOper) BeanCopyHelper.newInstance(
									"com.asiainfo.boss4.domain.partition.ISaleOper0"+userSprom.getRegionCode().toString());
							    BeanCopyHelper.copyProperties(memberSaleOper, userSprom);
							    memberSaleOper.setAcctId(user.getAcctId());
							    memberSaleOper.setCustId(user.getCustId());
							    memberSaleOper.setBusiCode(0);
							    memberSaleOper.setCommitDate(context.getSoDate());
							    memberSaleOper.setCountyCode((short)1000);
							    memberSaleOper.setOrgId(0);
							    memberSaleOper.setGroupId(0l);
							    memberSaleOper.setSid(sid);
							    //上发iUserSprom表
							    memberSaleOper.setUpField(UpFieldUtil.getUpField(userSprom, UpFieldUtil.EMPTY_UPFIELD));
							    dao.add(memberSaleOper);
						    }
						}
						//业务代码=1001多终端共享：置多终端共享业务关系表为i_user_share_sprom_01XX的失效时间,IUser表没有虚拟用户
						else if ("1001".equals(groupSprom[0].trim())){
							isStop2 = false; 
							
							//取主卡即实体用户[groupId为虚似用户号码,即副卡,IUser没有虚拟用户]
							IUserAll userAll = new IUserAll();
							userAll.setServId(this.getServId());
							IUser user = (IUser)dao.getEntity(userAll, new String[]{"servId","expireDate"});
							if (user == null){
								throw new BossException(StatusCode.QUERY_ENTITY_ERROR,"多终端共享停开机servId="+this.getServId()+"用户数据不存在");	
							}
							
							//取实体用户数据库中IUserStatus数据
							IUserStatus userStatus= (IUserStatus)dao.getEntity(this, this.getFieldOfSelectConditionsOnCommonDaoAnnotation());
							if (userStatus == null){
								throw new BossException(StatusCode.QUERY_ENTITY_ERROR,"多终端共享停开机servId="+this.getServId()+"用户状态数据不存在");
							}
							
							//数据库状态与entity状态比较
							if (userStatus.getUserSts() != null && userStatus.getUserSts().shortValue() == this.getUserSts().shortValue() 
								&& userStatus.getAcctSts() != null && userStatus.getAcctSts().shortValue() == this.getAcctSts().shortValue()
								&& userStatus.getMgntSts() != null && userStatus.getMgntSts().shortValue() == this.getMgntSts().shortValue()
								&& userStatus.getOperSts() != null && userStatus.getOperSts().shortValue() == this.getOperSts().shortValue()){
								
								//用户状态未变动，不需要变动虚用户的订购
								logger.warn("用户"+this.getServId()+"状态未变动，不需要变动虚用户的订购");
							}else if ((userStatus.getUserSts() != null && userStatus.getUserSts().shortValue() != this.getUserSts().shortValue())
									||(userStatus.getAcctSts() != null && userStatus.getAcctSts().shortValue() != this.getAcctSts().shortValue())
									||(userStatus.getMgntSts() != null && userStatus.getMgntSts().shortValue() != this.getMgntSts().shortValue())
									||(userStatus.getOperSts() != null && userStatus.getOperSts().shortValue() != this.getOperSts().shortValue())){
	                             
							    //取数据库中虚拟用户最后一条订购
							    Criteria crit = context.getBusinessDao().getSess().createCriteria(
									EntityPartitionHelper.getClassForPartition(IUserShareSprom.class, user.getServId()));
							    @SuppressWarnings("unchecked")
							    List<IUserShareSprom> list = crit.add(Restrictions.eq("servId", user.getServId()))
							                                     .add(Restrictions.eq("groupId", Long.valueOf(groupSprom[1].trim())))
							                                     .add(Restrictions.eq("spromId", Integer.valueOf(sprom)))
															     .addOrder(Order.desc("validDate"))
															     .list();
							    if (list == null || list.size() <=0){
								    throw new BossException(StatusCode.QUERY_ENTITY_ERROR,"多终端共享停开机servId="+userAll.getServId()+"虚用户订购数据"+sprom+"不存在");
							    }
							    //IUserShareSprom userShareSprom = list.get(0);
							    
								//比较停开机状态
								if (userStatus.getUserSts() != null && userStatus.getUserSts().shortValue() != this.getUserSts().shortValue()){
									if (this.getUserSts().shortValue() != 1) isStop2 = true; 
								}
								else if (userStatus.getAcctSts() != null && userStatus.getAcctSts().shortValue() != this.getAcctSts().shortValue()){
									if (this.getAcctSts().shortValue() != 0) isStop2 = true;
								}
								else if (userStatus.getMgntSts() != null && userStatus.getMgntSts().shortValue() != this.getMgntSts().shortValue()){
									if (this.getMgntSts().shortValue() != 0) isStop2 = true;
								}
								else if (userStatus.getOperSts() != null && userStatus.getOperSts().shortValue() != this.getOperSts().shortValue()){
									if (this.getOperSts().shortValue() != 0) isStop2 = true;
								}
                                
								for (IUserShareSprom userShareSprom : list){
									if (isStop2){//停机
									    userShareSprom.setExpireDate(context.getSoDate());
									    userShareSprom.setSoNbr(this.getSoNbr());
										dao.update(userShareSprom);
									}else{//开机
										if (userShareSprom.getExpireDate().before(context.getSoDate())){
											logger.warn("servId="+userShareSprom.getServId()+",spromId="+userShareSprom.getGroupId()+"正在恢复,expireDate="+DateHelper.Date2String(userShareSprom.getExpireDate()));
											userShareSprom.setExpireDate(DateHelper.String2Date(Constance.DEFAULTEXPIREDATE));
											userShareSprom.setSoNbr(this.getSoNbr());
										    dao.update(userShareSprom);
										}else{
										   //如果套餐已经恢复,则不再恢复
										   logger.warn("servId="+userShareSprom.getServId()+",spromId="+userShareSprom.getGroupId()+"已经恢复，不需要再次恢复");
										}
									}
								}
								
								IUserShareSprom userShareSprom2 = list.get(0);
								//为虚用户上发
								ISaleOper memberSaleOper = (ISaleOper) BeanCopyHelper.newInstance(
										"com.asiainfo.boss4.domain.partition.ISaleOper0"+userShareSprom2.getRegionCode().toString());
								BeanCopyHelper.copyProperties(memberSaleOper, userShareSprom2);
								memberSaleOper.setAcctId(user.getAcctId());
								memberSaleOper.setCustId(user.getCustId());
								memberSaleOper.setBusiCode(0);
								memberSaleOper.setCommitDate(context.getSoDate());
								memberSaleOper.setCountyCode((short)1000);
								memberSaleOper.setOrgId(0);
								memberSaleOper.setGroupId(0l);
								memberSaleOper.setSid(sid);
								//上发iUserStartSprom表
								memberSaleOper.setUpField(UpFieldUtil.getUpField(userShareSprom2, UpFieldUtil.EMPTY_UPFIELD));
								dao.add(memberSaleOper);
						    }
					    }
					}
				}
			}else{
				hasStrGroupSprom = true ;
			}
			
			if(hasVirtualServId && hasStrGroupSprom){
			   throw new BossException(StatusCode.ILLEGAL_INPUT_PROPERTY_ERROR,"停开机必须送virtualServId or StrGroupSprom,servId="+this.getServId());
			}
		}
		
		return (BaseEntity)dao.commonModify(this);
	}
}