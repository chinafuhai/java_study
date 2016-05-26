package com.asiainfo.boss4.domain;

import java.util.Date;

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
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.Constance;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.annotation.AllowUpdateMultiRow;
import com.asiainfo.boss4.support.annotation.AllowUpdateZeroRow;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;

/**
 * IUserPbx entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
//@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_PBX", schema = "ZG")
@IdClass(IUserPbx.IUserPbxId.class)
@PartitionNameForTable
@PartitionNameForTable.RegionCode
@AllowUpdateZeroRow
@AllowUpdateMultiRow
@Backup.CopyToSuffix(isIgnore = true)
@CommonDao(fieldOfSelectConditions = {"servId","mscId","inTrunk","matchingAccessNumber","expireDate"},fieldOfDBSelectConditions={"serv_id","msc_Id","in_Trunk","matching_Access_Number","expire_date"})
public class IUserPbx extends BaseEntity implements java.io.Serializable {

	// Fields

	private Long servId;
	private Long mscId;
	private Date validDate;
	private Long soNbr;
	private Short regionCode;
	private Short areaCode;
	private String inTrunk;
	private String outTrunk;
	private String accessNumber;
	private Byte matchingAccessNumber;
	private Date expireDate;
	private String remark;
	private Long sid;
	
	private String inTrunkGroup;

	// Constructors

	/** default constructor */
	public IUserPbx() {
	}

	/** minimal constructor */
	public IUserPbx(Long servId, Long mscId, Date validDate, Long soNbr, Short regionCode, String inTrunk,
			String outTrunk, String accessNumber, Byte matchingAccessNumber,
			Date expireDate) {
		this.servId = servId;
		this.mscId = mscId;
		this.validDate = validDate;
		this.soNbr = soNbr;
		this.regionCode = regionCode;
		this.inTrunk = inTrunk;
		this.outTrunk = outTrunk;
		this.accessNumber = accessNumber;
		this.matchingAccessNumber = matchingAccessNumber;
		this.expireDate = expireDate;
	}

	/** full constructor */
	public IUserPbx(Long servId, Long mscId, Date validDate, Long soNbr, Short regionCode, Short areaCode,
			String inTrunk, String outTrunk, String accessNumber,
			Byte matchingAccessNumber, Date expireDate, String remark,
			Long sid) {
		this.servId = servId;
		this.mscId = mscId;
		this.validDate = validDate;
		this.soNbr = soNbr;
		this.regionCode = regionCode;
		this.areaCode = areaCode;
		this.inTrunk = inTrunk;
		this.outTrunk = outTrunk;
		this.accessNumber = accessNumber;
		this.matchingAccessNumber = matchingAccessNumber;
		this.expireDate = expireDate;
		this.remark = remark;
		this.sid = sid;
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
	public Long getMscId() {
		return mscId;
	}

	public void setMscId(Long mscId) {
		this.mscId = mscId;
	}

	@Id
	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Id
	public Long getSoNbr() {
		return soNbr;
	}

	public void setSoNbr(Long soNbr) {
		this.soNbr = soNbr;
	}

	@Column(name = "REGION_CODE", nullable = false, precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "AREA_CODE", precision = 4, scale = 0)
	public Short getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(Short areaCode) {
		this.areaCode = areaCode;
	}

	@Id
	public String getInTrunk() {
		return this.inTrunk;
	}

	public void setInTrunk(String inTrunk) {
		this.inTrunk = inTrunk;
	}

	@Column(name = "OUT_TRUNK", nullable = false, length = 16)
	public String getOutTrunk() {
		return this.outTrunk;
	}

	public void setOutTrunk(String outTrunk) {
		this.outTrunk = outTrunk;
	}

	@Column(name = "ACCESS_NUMBER", nullable = false, length = 32)
	public String getAccessNumber() {
		return this.accessNumber;
	}

	public void setAccessNumber(String accessNumber) {
		this.accessNumber = accessNumber;
	}

	@Column(name = "MATCHING_ACCESS_NUMBER", nullable = false, precision = 2, scale = 0)
	public Byte getMatchingAccessNumber() {
		return this.matchingAccessNumber;
	}

	public void setMatchingAccessNumber(Byte matchingAccessNumber) {
		this.matchingAccessNumber = matchingAccessNumber;
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

	@Column(name = "SID", precision = 12, scale = 0)
	public Long getSid() {
		return this.sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}
	
	@Transient
	public String getInTrunkGroup() {
		return inTrunkGroup;
	}

	public void setInTrunkGroup(String inTrunkGroup) {
		this.inTrunkGroup = inTrunkGroup;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("servId",getServId())
			.append("areaCode",getAreaCode())
			.append("accessNumber",getAccessNumber())
			.append("soNbr",getSoNbr())
			.append("expireDate",getExpireDate())
			.append("matchingAccessNumber",getMatchingAccessNumber())
			.append("mscId",getMscId())
			.append("remark",getRemark())
			.append("outTrunk",getOutTrunk())
			.append("validDate",getValidDate())
			.append("inTrunk",getInTrunk())
			.append("regionCode",getRegionCode())
			.append("sid",getSid())
			.toString();
	}

	public static class IUserPbxId implements java.io.Serializable {

		// Fields

		private Long servId;
		private Long mscId;
		private Date validDate;
		private Long soNbr;
		private String inTrunk;
		// Constructors

		/** default constructor */
		public IUserPbxId() {
		}

		/** full constructor */
		public IUserPbxId(Long servId, Long mscId, Date validDate, Long soNbr,String inTrunk) {
			this.servId = servId;
			this.mscId = mscId;
			this.validDate = validDate;
			this.soNbr = soNbr;
			this.inTrunk = inTrunk;
		}

		// Property accessors

		@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
		public Long getServId() {
			return this.servId;
		}

		public void setServId(Long servId) {
			this.servId = servId;
		}

		@Column(name = "MSC_ID", nullable = false, precision = 14, scale = 0)
		public Long getMscId() {
			return this.mscId;
		}

		public void setMscId(Long mscId) {
			this.mscId = mscId;
		}

		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "VALID_DATE", nullable = false, length = 7)
		public Date getValidDate() {
			return this.validDate;
		}

		public void setValidDate(Date validDate) {
			this.validDate = validDate;
		}

		@Column(name = "SO_NBR", nullable = false, precision = 15, scale = 0)
		public Long getSoNbr() {
			return soNbr;
		}
	
		public void setSoNbr(Long soNbr) {
			this.soNbr = soNbr;
		}

		@Column(name = "IN_TRUNK", nullable = false, length = 16)
		public String getInTrunk() {
			return this.inTrunk;
		}

		public void setInTrunk(String inTrunk) {
			this.inTrunk = inTrunk;
		}
		@Override
		public boolean equals(Object other) {
			if ( !(other instanceof IUserPbxId) ) return false;
			IUserPbxId castOther = (IUserPbxId) other;
			return new EqualsBuilder()
				.append(this.getValidDate(), castOther.getValidDate())
				.append(this.getServId(), castOther.getServId())
				.append(this.getSoNbr(), castOther.getSoNbr())
				.append(this.getMscId(), castOther.getMscId())
				.append(this.getInTrunk(), castOther.getInTrunk())
				.isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder()
				.append(getValidDate())
				.append(getServId())
				.append(getSoNbr())
				.append(getMscId())
				.append(getInTrunk())
				.toHashCode();
		}

	}

	@Override
	public BaseEntity add(ServiceContext context) {
		
		BusinessDao dao = (BusinessDao)context.getBeanFactory().getBean("businessDao");
		
		//20160126集团入网增加中继群组号：新增InTrunkGroup节点字段,如果该节点有值,则循环生成新实例对象,设置InTrunk节点值; 如果该节点为空,走下面原单个处理流程
		//此改造只适用于集团入网增加中继群组号[300个左右中继群组号],sid为自动生成,减少sid判断逻辑．减少库表存在记录的处理逻辑,直接新增
		if (this.getInTrunkGroup()!=null && !"".equals(this.getInTrunkGroup().trim())){
			String[] groupInTrunks = this.getInTrunkGroup().trim().split(",");
			
			for (int i=0;i<groupInTrunks.length;i++){
				String groupInTrunk = groupInTrunks[i];
				try{
					IUserPbx newUserPbx = (IUserPbx)Class.forName("com.asiainfo.boss4.domain.partition.IUserPbx0" + this.getRegionCode().toString()).newInstance();
					BeanCopyHelper.copyBeanNotNullProperty(newUserPbx, this);
					newUserPbx.setInTrunk(groupInTrunk);
					newUserPbx.setSid(Long.valueOf(dao.querySid().toString()));
					dao.add(newUserPbx);			
//					IUserPbx userPbx = (IUserPbx)context.getBusinessDao().getEntity(newUserPbx, new String[]{"servId","mscId","inTrunk","matchingAccessNumber", "validDate"});
//					if (userPbx == null){
//						dao.add(newUserPbx);
//					} else if (userPbx.getExpireDate().compareTo(newUserPbx.getValidDate()) == 0
//							||userPbx.getValidDate().compareTo(newUserPbx.getValidDate()) == 0) {
//						BeanCopyHelper.copyBeanNotNullPropertyCrm(userPbx, newUserPbx);
//						userPbx.setExpireDate(newUserPbx.getExpireDate());
//						dao.update(userPbx);
//					} else {
//						dao.add(newUserPbx);			
//					}
				}catch (Exception e) {
					throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
						"构造实体对象com.asiainfo.boss4.domain.partition.IUserPbx0" + this.getRegionCode().toString() + "出错");
				}	
			}
			return null;
		}
		
		//原处理流程
		if (dao.sidExist(this)){
			//sid为主键，新生成一个
			Long sid = Long.valueOf(dao.querySid().toString());
			this.setSid(sid);
		}
		
		IUserPbx userPbx = (IUserPbx)context.getBusinessDao().getEntity(this, new String[]{"servId","mscId","inTrunk","matchingAccessNumber", "validDate"});
		if (userPbx == null){
			return super.add(context);
		} else if (userPbx.getExpireDate().compareTo(this.getValidDate()) == 0
				||userPbx.getValidDate().compareTo(this.getValidDate()) == 0) {
			BeanCopyHelper.copyBeanNotNullPropertyCrm(userPbx, this);
			userPbx.setExpireDate(this.getExpireDate());
			context.getBusinessDao().update(userPbx);
		} else {
			return super.add(context);			
		}
		return userPbx;
	}
	
	@Override
	public BaseEntity cancel(ServiceContext context) {
		BusinessDao dao = (BusinessDao)context.getBeanFactory().getBean("businessDao");

		//20160126集团入网增加中继群组号：新增InTrunkGroup节点字段,如果该节点有值,则循环生成新实例对象,设置InTrunk节点值; 如果该节点为空,走下面原单个处理流程
		//此改造只适用于集团取消中继群组号[300个左右中继群组号],取消sid判断逻辑．
		if (this.getInTrunkGroup()!=null && !"".equals(this.getInTrunkGroup().trim())){
			String[] groupInTrunks = this.getInTrunkGroup().trim().split(",");
			
			for (int i=0;i<groupInTrunks.length;i++){
				String groupInTrunk = groupInTrunks[i];
				try{
					IUserPbx newUserPbx = (IUserPbx)Class.forName("com.asiainfo.boss4.domain.partition.IUserPbx0" + this.getRegionCode().toString()).newInstance();
					BeanCopyHelper.copyBeanNotNullProperty(newUserPbx, this);
					newUserPbx.setInTrunk(groupInTrunk);
					dao.commonCancel(newUserPbx);
				}catch (Exception e) {
					throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
						"构造实体对象com.asiainfo.boss4.domain.partition.IUserPbx0" + this.getRegionCode().toString() + "出错");
				}
			}
			return null;
		}			
		
		//原处理流程
		if (dao.sidExist(this))
		{
			//sid为主键，新生成一个
			Long sid = Long.valueOf(dao.querySid().toString());
			this.setSid(sid);
		}
		return super.cancel(context);
	}
	
	@Override
	public BaseEntity modifyExpireDate(ServiceContext context) {
		BusinessDao dao = (BusinessDao)context.getBeanFactory().getBean("businessDao");
		if (dao.sidExist(this))
		{
			//sid为主键，新生成一个
			Long sid = Long.valueOf(dao.querySid().toString());
			this.setSid(sid);
		}
		return super.modifyExpireDate(context);
	}
	
	@Override
	public BaseEntity modify(ServiceContext context) {
		BusinessDao dao = (BusinessDao)context.getBeanFactory().getBean("businessDao");
		if (dao.sidExist(this))
		{
			//sid为主键，新生成一个
			Long sid = Long.valueOf(dao.querySid().toString());
			this.setSid(sid);
		}
		return super.modify(context);
	}
}