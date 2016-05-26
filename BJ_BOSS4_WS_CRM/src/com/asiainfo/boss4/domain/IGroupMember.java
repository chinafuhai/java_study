package com.asiainfo.boss4.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable;

/**
 * IGroupMember entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
//@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_GROUP_MEMBER", schema = "ZG")
@IdClass(IGroupMember.IGroupMemberId.class)
@PartitionNameForTable
@PartitionNameForTable.RegionCode
@Backup.CopyToSuffix(isIgnore = true)
@CommonDao(fieldOfSelectConditions = { "servId", "groupId","expireDate" },fieldOfDBSelectConditions={"serv_id","group_id","expire_date"})
public class IGroupMember extends BaseEntity  implements java.io.Serializable {
	private static Log logger = LogFactory.getLog(IGroupMember.class);
	
	// Fields

	private Long servId;
	private Long groupId;
	private Date validDate;
	private Byte groupType;
	private String property;
	private Short regionCode;
	private Date beginDate;
	private Date expireDate;
	private Long sid;
	private Long soNbr;
	private String remark;
	private Short priority;

	// Constructors

	/** default constructor */
	public IGroupMember() {
	}

	/** minimal constructor */
	public IGroupMember(Long servId, Long groupId, Date validDate, Byte groupType, Short regionCode,
			Date beginDate, Date expireDate, Long sid, Long soNbr) {
		this.servId = servId;
		this.groupId = groupId;
		this.validDate = validDate;
		this.groupType = groupType;
		this.regionCode = regionCode;
		this.beginDate = beginDate;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
	}

	/** full constructor */
	public IGroupMember(Long servId, Long groupId, Date validDate, Byte groupType, String property,
			Short regionCode, Date beginDate, Date expireDate, Long sid,
			Long soNbr, String remark, Short priority) {
		this.servId = servId;
		this.groupId = groupId;
		this.validDate = validDate;
		this.groupType = groupType;
		this.property = property;
		this.regionCode = regionCode;
		this.beginDate = beginDate;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
		this.remark = remark;
		this.priority = priority;
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
	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	@Id
	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Column(name = "GROUP_TYPE", nullable = false, precision = 2, scale = 0)
	public Byte getGroupType() {
		return this.groupType;
	}

	public void setGroupType(Byte groupType) {
		this.groupType = groupType;
	}

	@Column(name = "PROPERTY", length = 20)
	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	@Column(name = "REGION_CODE", nullable = false, precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
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

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "PRIORITY", precision = 4, scale = 0)
	public Short getPriority() {
		return this.priority;
	}

	public void setPriority(Short priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("servId",getServId())
			.append("beginDate",getBeginDate())
			.append("sid",getSid())
			.append("property",getProperty())
			.append("soNbr",getSoNbr())
			.append("expireDate",getExpireDate())
			.append("remark",getRemark())
			.append("validDate",getValidDate())
			.append("groupId",getGroupId())
			.append("groupType",getGroupType())
			.append("priority",getPriority())
			.append("regionCode",getRegionCode())
			.toString();
	}

	public static class IGroupMemberId implements java.io.Serializable {

		// Fields

		private Long servId;
		private Long groupId;
		private Date validDate;

		// Constructors

		/** default constructor */
		public IGroupMemberId() {
		}

		/** full constructor */
		public IGroupMemberId(Long servId, Long groupId, Date validDate) {
			this.servId = servId;
			this.groupId = groupId;
			this.validDate = validDate;
		}

		// Property accessors

		@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
		public Long getServId() {
			return this.servId;
		}

		public void setServId(Long servId) {
			this.servId = servId;
		}

		@Column(name = "GROUP_ID", nullable = false, precision = 12, scale = 0)
		public Long getGroupId() {
			return this.groupId;
		}

		public void setGroupId(Long groupId) {
			this.groupId = groupId;
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
			if ( !(other instanceof IGroupMemberId) ) return false;
			IGroupMemberId castOther = (IGroupMemberId) other;
			return new EqualsBuilder()
				.append(this.getValidDate(), castOther.getValidDate())
				.append(this.getServId(), castOther.getServId())
				.append(this.getGroupId(), castOther.getGroupId())
				.isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder()
				.append(getValidDate())
				.append(getServId())
				.append(getGroupId())
				.toHashCode();
		}
	}
	
	@Override
	public BaseEntity add(ServiceContext context) {
		IGroupMember groupMember = (IGroupMember)context.getBusinessDao().getEntity(this, new String[]{"servId", "groupId", "validDate"});
		if (groupMember == null)
			return super.add(context);
		else if (groupMember.getExpireDate().compareTo(this.getValidDate()) == 0
				||groupMember.getValidDate().compareTo(this.getValidDate()) == 0)
		{
			BeanCopyHelper.copyBeanNotNullPropertyCrm(groupMember, this);
			groupMember.setExpireDate(this.getExpireDate());
			context.getBusinessDao().update(groupMember);
		}
		else
			return super.add(context);
		return groupMember;
	}
	
	public void addWithISaleOper(ServiceContext context) {
		ISaleOper oper = ISaleOper.newInstanceByServId(context, this.getServId());
		
		this.setSid(oper.getSid());
		this.setSoNbr(oper.getSid());
		this.add(context);
		
		oper.setGroupId(this.getGroupId());
		oper.updateUpField(this);
		oper.add(context);
	}
	
	
	public static final String MASTER_OF_GROUP = "2000";
	public static final String VICE_OF_GROUP = "1000";
	
	public boolean isMasterOfGroup() {
		return MASTER_OF_GROUP.equals(getProperty());
	}
	
	public boolean isViceOfGroup() {
		return VICE_OF_GROUP.equals(getProperty());
	}
	
	public static List<IGroupMember> queryByServIdAndGroupType(ServiceContext context, Long servId, Byte groupType) {
		Class<?> realClass = EntityPartitionHelper.getClassForPartition(IGroupMember.class, servId);
		Criteria crit = context.getBusinessDao().getSess().createCriteria(realClass);
		try {
			@SuppressWarnings("unchecked")
			List<IGroupMember> list = (List<IGroupMember>) crit.add(Restrictions.eq("servId", servId))
				.add(Restrictions.eq("groupType", groupType))
				.add(Restrictions.sqlRestriction("expire_date > sysdate"))
				.list();
			 return list;
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	public static List<IGroupMember> queryAllMemberInGroup(ServiceContext context, Long groupId) {
		String sql = "select SERV_ID as servId from INTER.I_GROUP_MEMBER_ALL t where t.GROUP_ID = :groupId and t.EXPIRE_DATE > sysdate and t.EXPIRE_DATE > t.VALID_DATE";
		@SuppressWarnings("unchecked")
		List<Long> servIds = context.getBusinessDao().getSess().createSQLQuery(sql)
								.addScalar("servId", Hibernate.LONG)
								.setLong("groupId", groupId)
								.list();
		context.getBusinessDao().flushAndClear();
		List<IGroupMember> result = new ArrayList<IGroupMember>(servIds.size());
		for (Long servId : servIds) {
			@SuppressWarnings("unchecked")
			Class<? extends IGroupMember> realClass = EntityPartitionHelper.getClassForPartition(IGroupMember.class, servId);
			IGroupMember member = BeanCopyHelper.newInstance(realClass);
			member.setServId(servId);
			member.setGroupId(groupId);
			IGroupMember memberPersistent = member.<IGroupMember>load(context);
			if (memberPersistent == null) {
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR, StatusCode.QUERY_ENTITY_NONE_ERROR.getDescription() + ": " + member);
			}
			result.add(memberPersistent);
		}
		context.getBusinessDao().flushAndClear();
		return result;
	}
	
	public void cancelWithISaleOper(ServiceContext context) {
		ISaleOper oper = ISaleOper.newInstanceByServId(context, this.getServId());

		this.setSoNbr(oper.getSid());
		this.setExpireDate(oper.getCommitDate());
		this.cancel(context);
		context.getBusinessDao().flushAndClear();
		
		oper.setGroupId(this.getGroupId());
		oper.updateUpField(this);
		oper.add(context);
		context.getBusinessDao().flushAndClear();
	}

	public static void removeAllMemberByGroupId(ServiceContext context, Long groupId) {
		
		List<IGroupMember> members = queryAllMemberInGroup(context, groupId);
		
		for (IGroupMember member : members) {
			member.cancelWithISaleOper(context);
		}
		
		context.getBusinessDao().flushAndClear();
	}
}