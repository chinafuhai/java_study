package com.asiainfo.boss4.domain;

import java.text.DecimalFormat;
import java.util.Date;
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

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.dao.ChangeComboDao;
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.UpFieldUtil;
import com.asiainfo.boss4.support.annotation.AllowUpdateMultiRow;
import com.asiainfo.boss4.support.annotation.AllowUpdateZeroRow;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable;


/**
 * ISpromParam entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
//@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_SPROM_PARAM", schema = "ZG")
@IdClass(ISpromParam.ISpromParamId.class)
@PartitionNameForTable
@PartitionNameForTable.RegionCode
@AllowUpdateZeroRow
@AllowUpdateMultiRow
@Backup.CopyToSuffix
@CommonDao(fieldOfSelectConditions = { "servId", "keyId", "soId","expireDate","spromPara" },fieldOfDBSelectConditions={"serv_id","key_id","so_id","expire_date","sprom_para"})
public class ISpromParam extends BaseEntity implements java.io.Serializable {

	// Fields

	private Long servId;
	private Integer keyId;
	private Date validDate;
	private Long soId;
	private Short regionCode;
	private String spromPara;
	private Date expireDate;
	private Long sid;
	private Long soNbr;
	private String remark;
	
	/**
	 * spromPara扩展字段，用于保存国家折扣，不映射到表字段
	 */
	private String spromParaExt1;
	/**
	 * 扩展字段，用于判断年费参数属否需要拆解
	 */
	private Long spromId;
	private String memberMsisdn;		//分机号码
	private Long acctId;
	private Long custId;
	
	// Constructors

	/** default constructor */
	public ISpromParam() {
	}

	/** minimal constructor */
	public ISpromParam(Long servId,	Date validDate, Long soId, Date expireDate, Long sid,
			Long soNbr) {
		this.servId = servId;
		this.validDate = validDate;
		this.soId = soId;
		this.expireDate = expireDate;
		this.soNbr = soNbr;
	}

	/** full constructor */
	public ISpromParam(Long servId, Integer keyId,
			Date validDate, Long soId, Integer serviceId, Short regionCode,
			String spromPara, Date expireDate, Long sid, Long soNbr,	String remark, String spromParaExt1) {
		this.servId = servId;
		this.keyId = keyId;
		this.validDate = validDate;
		this.soId = soId;
		this.regionCode = regionCode;
		this.spromPara = spromPara;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
		this.remark = remark;
		this.spromParaExt1 = spromParaExt1;
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
	public Integer getKeyId() {
		return this.keyId;
	}

	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
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

	@Column(name = "REGION_CODE", precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "SPROM_PARA", length = 32)
	public String getSpromPara() {
		return this.spromPara;
	}

	public void setSpromPara(String spromPara) {
		this.spromPara = spromPara;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRE_DATE", nullable = false, length = 7)
	public Date getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Id
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

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Transient
	public String getSpromParaExt1() {
		return spromParaExt1;
	}

	public void setSpromParaExt1(String spromParaExt1) {
		this.spromParaExt1 = spromParaExt1;
	}

	@Transient
	public Long getSpromId() {
		return spromId;
	}

	public void setSpromId(Long spromId) {
		this.spromId = spromId;
	}

	@Transient
	public String getMemberMsisdn() {
		return memberMsisdn;
	}

	public void setMemberMsisdn(String memberMsisdn) {
		this.memberMsisdn = memberMsisdn;
	}
	
	@Transient
	public Long getAcctId() {
		return acctId;
	}

	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}

	@Transient
	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	@Override
	public String toString() {
        return new ToStringBuilder(this)
            .append("servId", getServId())
            .append("keyId", getKeyId())
            .append("validDate", getValidDate())
            .append("regionCode",getRegionCode())
            .append("spromPara",getSpromPara())
            .append("expireDate",getExpireDate())
            .append("sid",getSid())
            .append("soNbr",getSoNbr())
            .append("remark",getRemark())
            .append("spromParaExt1",getSpromParaExt1())
            .append("soId",getSoId())
            .append("memberMsisdn",getMemberMsisdn())
            .toString();
    }
	
	public static class ISpromParamId implements java.io.Serializable {

		// Fields

		private Long servId;
		private Integer keyId;
		private Date validDate;
		private Long soId;
		private Long sid;

		// Constructors

		/** default constructor */
		public ISpromParamId() {
		}

		/** full constructor */
		public ISpromParamId(Long servId, Integer keyId, Date validDate,
				Long soId) {
			this.servId = servId;
			this.keyId = keyId;
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
		
		@Column(name = "KEY_ID", precision = 8, scale = 0)
		public Integer getKeyId() {
			return this.keyId;
		}

		public void setKeyId(Integer keyId) {
			this.keyId = keyId;
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
		
		@Column(name = "SID", nullable = false, precision = 12, scale = 0)
		public Long getSid() {
			return this.sid;
		}

		public void setSid(Long sid) {
			this.sid = sid;
		}

		@Override
		public boolean equals(Object other) {
	        if ( !(other instanceof ISpromParamId) ) return false;
	        ISpromParamId castOther = (ISpromParamId) other;
	        return new EqualsBuilder()
	            .append(this.getServId(), castOther.getServId())
	            .append(this.getKeyId(), castOther.getKeyId())
	            .append(this.getSoId(), castOther.getSoId())
	            .append(this.getValidDate(), castOther.getValidDate())
	            .append(this.getSid(), castOther.getSid())
	            .isEquals();
	    }
		
		@Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getServId())
	            .append(getKeyId())
	            .append(getSoId())
	            .append(getValidDate())
	            .append(getSid())
	            .toHashCode();
	    }

	}
	
	@Override
	public BaseEntity add(ServiceContext context) {
		BusinessDao dao = (BusinessDao) context.getBeanFactory().getBean("businessDao");
		String sid = dao.querySid().toString();
		this.setSid(Long.parseLong(sid));
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
					this.setServId(user.getServId());
					this.setRegionCode(user.getRegionCode());
					this.setAcctId(user.getAcctId());
					this.setCustId(user.getCustId());
				}
				else
					throw new BossException(StatusCode.NOT_EXIST_USER_ERROR,"固移通成员MemberMsisdn"+this.getMemberMsisdn().trim()+"不存在");
			}
			else
				throw new BossException(StatusCode.ILLEGAL_INPUT_PROPERTY_ERROR,"固移通订购参数必须送MemberMsisdn");	
		}

		if (this.getSpromId()!=null)
		{
			try {
				IUserSprom userSprom = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + this.getRegionCode().toString()).newInstance();
				userSprom.setServId(this.getServId());
				userSprom.setSpromId(Integer.valueOf(this.getSpromId().intValue()));
				userSprom.setSoId(this.getSoId());
				userSprom = (IUserSprom)dao.getEntity(userSprom, new String[]{"servId","spromId","soId","expireDate"});
				if (userSprom != null)
					this.setSoId(userSprom.getSoId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		if (this.getKeyId().intValue() == 890022 )
		{
			if (this.getSpromId()!= null && this.getSpromId().toString().startsWith("8713"))
			{
				//计算实际承诺消费
				String spromPara = getActualSpromPara(context,this.getSpromId(),Double.valueOf(this.getSpromPara()));
				this.setKeyId(790022);
				this.setSpromPara(spromPara);
			}
			else if (this.getSpromId()== null)
				throw new BossException(StatusCode.ENTITY_PARSE_ERROR, "ISpromParam未传入spromId值");
			else
				return this;
		}
		if (context.getTranCode().getTranCode().equals(TranCode.CRM_FIXED_BUG.getTranCode()))
		{
			if (this.getMemberMsisdn()!=null&&!"".equals(this.getMemberMsisdn().trim()))
			{
				try{
					ISpromParam spromParam = (ISpromParam)Class.forName("com.asiainfo.boss4.domain.partition.ISpromParam0" + this.getRegionCode().toString()).newInstance();
					BeanCopyHelper.copyBeanNotNullProperty(spromParam, this);
					dao.commonAdd(spromParam);
					
					//需要上发
					ISaleOper memberSaleOper = (ISaleOper) BeanCopyHelper.newInstance(
							"com.asiainfo.boss4.domain.partition.ISaleOper0"+this.getRegionCode().toString());
					BeanCopyHelper.copyProperties(memberSaleOper, spromParam);
					memberSaleOper.setAcctId(this.getAcctId());
					memberSaleOper.setCustId(this.getCustId());
					memberSaleOper.setBusiCode(0);
					memberSaleOper.setCommitDate(context.getSoDate());
					memberSaleOper.setCountyCode((short)1000);
					memberSaleOper.setOrgId(0);
					memberSaleOper.setGroupId(0l);
					//上发iSpromParam表
					memberSaleOper.setUpField(UpFieldUtil.getUpField(spromParam, UpFieldUtil.EMPTY_UPFIELD));
					dao.add(memberSaleOper);
					
					return spromParam;
				}catch (Exception e) {
					throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
							"构造实体对象com.asiainfo.boss4.domain.partition.ISpromParam0" + this.getRegionCode().toString() + "出错");
				}
			}
		}
		else
			dao.add(this);
		return this;
	}
	
	@Override
	public BaseEntity cancel(ServiceContext context) {
		BusinessDao dao = (BusinessDao) context.getBeanFactory().getBean("businessDao");
		if (this.getExpireDate() == null)
			this.setExpireDate(dao.queryCurrentDate());
		String sid = dao.querySid().toString();
		this.setSid(Long.parseLong(sid));
		
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
					this.setServId(user.getServId());
					this.setRegionCode(user.getRegionCode());
					this.setAcctId(user.getAcctId());
					this.setCustId(user.getCustId());
				}
				else
					throw new BossException(StatusCode.NOT_EXIST_USER_ERROR,"固移通成员MemberMsisdn"+this.getMemberMsisdn().trim()+"不存在");
			}
			else
				throw new BossException(StatusCode.ILLEGAL_INPUT_PROPERTY_ERROR,"固移通订购参数必须送MemberMsisdn");	
		}
		
		if (this.getSpromId()!=null)
		{
			try {
				IUserSprom userSprom = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + this.getRegionCode().toString()).newInstance();
				userSprom.setServId(this.getServId());
				userSprom.setSpromId(Integer.valueOf(this.getSpromId().intValue()));
				userSprom.setSoId(this.getSoId());
				userSprom = (IUserSprom)dao.getEntity(userSprom, new String[]{"servId","spromId","soId","expireDate"});
				if (userSprom != null)
					this.setSoId(userSprom.getSoId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		if (this.getKeyId().intValue() == 890022 )
		{
			if (this.getSpromId()!= null && this.getSpromId().toString().startsWith("8713"))
			{
				this.setKeyId(790022);
				ISpromParam param = (ISpromParam)dao.getEntity(this, new String[]{"servId","soId","expireDate","keyId"});
				if (param != null)
					this.setSpromPara(param.getSpromPara());
			}
			else if (this.getSpromId()== null)
				throw new BossException(StatusCode.ENTITY_PARSE_ERROR, "ISpromParam未传入spromId值");
			else
				return this;
		}
		CommonDao cd = (CommonDao) getAnnotation(EntityPartitionHelper.getOriginalClassForPartition(this), CommonDao.class);
		if (context.getTranCode().getTranCode().equals(TranCode.CRM_FIXED_BUG.getTranCode()))
		{
			if (this.getMemberMsisdn()!=null&&!"".equals(this.getMemberMsisdn().trim()))
			{
				try{
					ISpromParam spromParam = (ISpromParam)Class.forName("com.asiainfo.boss4.domain.partition.ISpromParam0" + this.getRegionCode().toString()).newInstance();
					BeanCopyHelper.copyBeanNotNullProperty(spromParam, this);
					dao.commonCancel(spromParam);
					
					//需要上发
					ISaleOper memberSaleOper = (ISaleOper) BeanCopyHelper.newInstance(
							"com.asiainfo.boss4.domain.partition.ISaleOper0"+this.getRegionCode().toString());
					BeanCopyHelper.copyProperties(memberSaleOper, spromParam);
					memberSaleOper.setAcctId(this.getAcctId());
					memberSaleOper.setCustId(this.getCustId());
					memberSaleOper.setBusiCode(0);
					memberSaleOper.setCommitDate(context.getSoDate());
					memberSaleOper.setCountyCode((short)1000);
					memberSaleOper.setOrgId(0);
					memberSaleOper.setGroupId(0l);
					//上发iSpromParam表
					memberSaleOper.setUpField(UpFieldUtil.getUpField(spromParam, UpFieldUtil.EMPTY_UPFIELD));
					dao.add(memberSaleOper);
					
					return spromParam;
				}catch (Exception e) {
					throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
							"构造实体对象com.asiainfo.boss4.domain.partition.ISpromParam0" + this.getRegionCode().toString() + "出错");
				}
			}
		}
		else
			dao.cancel(this, cd.fieldOfSelectConditions(), false, null);
		return this;
	}
	
	@Override
	public BaseEntity modifyExpireDate(ServiceContext context) {
		BusinessDao dao = (BusinessDao) context.getBeanFactory().getBean("businessDao");
		String sid = dao.querySid().toString();
		this.setSid(Long.parseLong(sid));
		
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
					this.setServId(user.getServId());
					this.setRegionCode(user.getRegionCode());
					this.setAcctId(user.getAcctId());
					this.setCustId(user.getCustId());
				}
				else
					throw new BossException(StatusCode.NOT_EXIST_USER_ERROR,"固移通成员MemberMsisdn"+this.getMemberMsisdn().trim()+"不存在");
			}
			else
				throw new BossException(StatusCode.ILLEGAL_INPUT_PROPERTY_ERROR,"固移通订购参数必须送MemberMsisdn");	
		}
		
		if (this.getSpromId()!=null)
		{
			try {
				IUserSprom userSprom = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + this.getRegionCode().toString()).newInstance();
				userSprom.setServId(this.getServId());
				userSprom.setSpromId(Integer.valueOf(this.getSpromId().intValue()));
				userSprom.setSoId(this.getSoId());
				userSprom = (IUserSprom)dao.getEntity(userSprom, new String[]{"servId","spromId","soId","expireDate"});
				if (userSprom != null)
					this.setSoId(userSprom.getSoId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		if (this.getKeyId().intValue() == 890022 )
		{
			if (this.getSpromId()!= null && this.getSpromId().toString().startsWith("8713"))
			{
				this.setKeyId(790022);
				ISpromParam param = (ISpromParam)dao.getEntity(this, new String[]{"servId","soId","expireDate","keyId"});
				if (param != null)
					this.setSpromPara(param.getSpromPara());
			}
			else if (this.getSpromId()== null)
				throw new BossException(StatusCode.ENTITY_PARSE_ERROR, "ISpromParam未传入spromId值");
			else
				return this;
		}
		if (context.getTranCode().getTranCode().equals(TranCode.CRM_FIXED_BUG.getTranCode()))
		{
			if (this.getMemberMsisdn()!=null&&!"".equals(this.getMemberMsisdn().trim()))
			{
				try{
					ISpromParam spromParam = (ISpromParam)Class.forName("com.asiainfo.boss4.domain.partition.ISpromParam0" + this.getRegionCode().toString()).newInstance();
					BeanCopyHelper.copyBeanNotNullProperty(spromParam, this);
					dao.commonModifyExpireDate(spromParam);
					
					
					//需要上发
					ISaleOper memberSaleOper = (ISaleOper) BeanCopyHelper.newInstance(
							"com.asiainfo.boss4.domain.partition.ISaleOper0"+this.getRegionCode().toString());
					BeanCopyHelper.copyProperties(memberSaleOper, spromParam);
					memberSaleOper.setAcctId(this.getAcctId());
					memberSaleOper.setCustId(this.getCustId());
					memberSaleOper.setBusiCode(0);
					memberSaleOper.setCommitDate(context.getSoDate());
					memberSaleOper.setCountyCode((short)1000);
					memberSaleOper.setOrgId(0);
					memberSaleOper.setGroupId(0l);
					//上发iSpromParam表
					memberSaleOper.setUpField(UpFieldUtil.getUpField(spromParam, UpFieldUtil.EMPTY_UPFIELD));
					dao.add(memberSaleOper);
					return spromParam;
				}catch (Exception e) {
					throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
							"构造实体对象com.asiainfo.boss4.domain.partition.ISpromParam0" + this.getRegionCode().toString() + "出错");
				}
			}
		}
		else
			super.modifyExpireDate(context);
		return this;
	}
	
	@Override
	public BaseEntity rollBack(ServiceContext context) {
		if (context.getTranCode().getTranCode().equals(TranCode.CRM_CENTREX_REFERENCE.getTranCode()))
			throw new BossException(StatusCode.ROLLBACK_ENTITY_ERROR, "Centrex统一号显业务"+StatusCode.ROLLBACK_ENTITY_ERROR.getDescription());
		BusinessDao dao = (BusinessDao) context.getBeanFactory().getBean("businessDao");
		if (this.getExpireDate() == null)
			this.setExpireDate(dao.queryCurrentDate());
		String sid = dao.querySid().toString();
		this.setSid(Long.parseLong(sid));
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
					this.setServId(user.getServId());
					this.setRegionCode(user.getRegionCode());
					this.setAcctId(user.getAcctId());
					this.setCustId(user.getCustId());
				}
				else
					throw new BossException(StatusCode.NOT_EXIST_USER_ERROR,"固移通成员MemberMsisdn"+this.getMemberMsisdn().trim()+"不存在");
			}
			else
				throw new BossException(StatusCode.ILLEGAL_INPUT_PROPERTY_ERROR,"固移通订购参数必须送MemberMsisdn");	
		}
		
		if (this.getSpromId()!=null)
		{
			try {
				IUserSprom userSprom = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + this.getRegionCode().toString()).newInstance();
				userSprom.setServId(this.getServId());
				userSprom.setSpromId(Integer.valueOf(this.getSpromId().intValue()));
				userSprom.setSoId(this.getSoId());
				userSprom = (IUserSprom)dao.getEntity(userSprom, new String[]{"servId","spromId","soId","expireDate"});
				if (userSprom != null)
					this.setSoId(userSprom.getSoId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		if (this.getKeyId().intValue() == 890022 )
		{
			if (this.getSpromId()!= null && this.getSpromId().toString().startsWith("8713"))
			{
				this.setKeyId(790022);
				Long soNbr = this.getSoNbr();
				setSoNbr(getRollBackSoNbr());
				ISpromParam param = (ISpromParam)dao.getEntity(this, new String[]{"servId","soId","soNbr","keyId"});
				setSoNbr(soNbr);
				if (param != null)
					this.setSpromPara(param.getSpromPara());
			}
			else if (this.getSpromId()== null)
				throw new BossException(StatusCode.ENTITY_PARSE_ERROR, "ISpromParam未传入spromId值");
			else
				return this;
		}
		if (context.getTranCode().getTranCode().equals(TranCode.CRM_FIXED_BUG.getTranCode()))
		{
			if (this.getMemberMsisdn()!=null&&!"".equals(this.getMemberMsisdn().trim()))
			{
				try{
					ISpromParam spromParam = (ISpromParam)Class.forName("com.asiainfo.boss4.domain.partition.ISpromParam0" + this.getRegionCode().toString()).newInstance();
					BeanCopyHelper.copyBeanNotNullProperty(spromParam, this);
					dao.commonRollBack(spromParam);
					
					
					//需要上发
					ISaleOper memberSaleOper = (ISaleOper) BeanCopyHelper.newInstance(
							"com.asiainfo.boss4.domain.partition.ISaleOper0"+this.getRegionCode().toString());
					BeanCopyHelper.copyProperties(memberSaleOper, spromParam);
					memberSaleOper.setAcctId(this.getAcctId());
					memberSaleOper.setCustId(this.getCustId());
					memberSaleOper.setBusiCode(0);
					memberSaleOper.setCommitDate(context.getSoDate());
					memberSaleOper.setCountyCode((short)1000);
					memberSaleOper.setOrgId(0);
					memberSaleOper.setGroupId(0l);
					//上发iSpromParam表
					memberSaleOper.setUpField(UpFieldUtil.getUpField(spromParam, UpFieldUtil.EMPTY_UPFIELD));
					dao.add(memberSaleOper);
					return spromParam;
				}catch (Exception e) {
					throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
							"构造实体对象com.asiainfo.boss4.domain.partition.ISpromParam0" + this.getRegionCode().toString() + "出错");
				}
			}
		}
		else
			dao.commonRollBack(this);
		return this;
	}
	
	/**
	 * 计算实际年承诺消费
	 * 单位为分，如有小数舍去
	 * @return
	 */
	String getActualSpromPara(ServiceContext context,Long spromId, Double spromPara) {
		ChangeComboDao changeComboDao = (ChangeComboDao) context.getBeanFactory().getBean("changeComboDao");
		Map map = null;
		double actualFee = 0;
		try {
			map = changeComboDao.querySpmprodCfg(spromId);
			
			double fee = Double.valueOf((String) map.get("1"));
			int month = Integer.valueOf((String) map.get("2"));
			actualFee = fee-spromPara*(month-1)/month;
		} catch (Exception e) {
			//logger.error("查询年承诺消费配置出错 ");
			throw new BossException(StatusCode.GET_ACTUAL_FEE_ERROR, "查询年承诺消费配置出错");
		}
		
		if (actualFee<0) {
			//logger.error("实际年承诺消费为负值 ");
			throw new BossException(StatusCode.GET_ACTUAL_FEE_ERROR, "实际年承诺消费为负值");
		}
		DecimalFormat df = new DecimalFormat("0");
		return df.format(actualFee);
	}
	
}