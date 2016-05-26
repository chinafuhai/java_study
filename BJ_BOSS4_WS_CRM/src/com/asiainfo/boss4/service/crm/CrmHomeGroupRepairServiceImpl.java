package com.asiainfo.boss4.service.crm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.domain.IGroupMember;
import com.asiainfo.boss4.domain.ISaleOper;
import com.asiainfo.boss4.domain.IUser;
import com.asiainfo.boss4.domain.IUserBillCycle;
import com.asiainfo.boss4.domain.IUserPlan;
import com.asiainfo.boss4.domain.IUserSprom;
import com.asiainfo.boss4.domain.IUserStatus;
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.ServiceContext;

/**
 * 家庭网迁移 修复接口服务
 * @author caohui
 *
 */
public class CrmHomeGroupRepairServiceImpl implements CrmCommonService {
	private Log logger = LogFactory.getLog(CrmHomeGroupRepairServiceImpl.class);

	public String process(ServiceContext context) {
		//移除所有ISaleOper节点，以消除领域逻辑中对原有ISaleOper的依赖，修复程序使用自己生成的ISaleOper
		List<BaseEntity> entitiesOfISaleOper = context.getEntities(ISaleOper.class);
		context.getEntities().removeAll(entitiesOfISaleOper);
		
		IUser user = (IUser) context.getEntity(IUser.class);
		//虚用户的servId
		Long virtualServId = user.getServId();
		Date sysdate = context.getSysdate();
		
		//IUser IUserPlan IUserStatus IUserBillCycle
		List<Class<?>> classes = new ArrayList<Class<?>>();
		classes.add(IUser.class);
		classes.add(IUserPlan.class);
		classes.add(IUserStatus.class);
		classes.add(IUserBillCycle.class);
		
		ISaleOper oper = ISaleOper.newInstanceByIUser(context, user);
		//已经存在则先失效再新增
		for (Class<?> origClass : classes) {
			BaseEntity entity = context.getEntity(origClass);
			Long servId = (Long) BeanCopyHelper.getProperty(entity, "servId");
			
			List<? extends BaseEntity> persistents = BaseEntity.queryByServId(context, entity.getClass(), servId);
			context.getBusinessDao().flushAndClear();
			
			for (BaseEntity persistent : persistents) {
				BeanCopyHelper.setProperty(persistent, "expireDate", sysdate);
				BeanCopyHelper.setProperty(persistent, "soNbr", oper.getSoNbr());
				persistent.cancel(context);
				
				BeanCopyHelper.setProperty(entity, "validDate", sysdate);
				BeanCopyHelper.setProperty(entity, "soNbr", oper.getSoNbr());
			}
			
			context.getBusinessDao().flushAndClear();
			entity.add(context);
			oper.updateUpField(entity);
		}
		oper.add(context);
		context.getBusinessDao().flushAndClear();
		
		//IUserSprom
		List<BaseEntity> sproms = context.getEntities(IUserSprom.class);
		for (BaseEntity baseEntity : sproms) {
			IUserSprom sprom = (IUserSprom) baseEntity;
			//虚用户的下的计费优惠产品
			if (sprom.getServId().equals(virtualServId)) {
				IUserSprom.removeAllByServId(context, sprom.getServId());
				
				ISaleOper operForSprom = ISaleOper.newInstanceByIUser(context, user);

				IUserSprom persistent = sprom.getByPk(context);
				if (persistent != null) {
					BeanCopyHelper.copyBeanNotNullProperty(persistent, sprom);
					persistent.setSoNbr(operForSprom.getSoNbr());
					operForSprom.updateUpField(persistent);
				}
				else {
					sprom.setSoNbr(operForSprom.getSoNbr());
					sprom.add(context);
					operForSprom.updateUpField(sprom);
				}
				
				operForSprom.add(context);
			}
			//主卡下的账务产品
			else {
				//按智能网逻辑，不做修复
			}
		}
		context.getBusinessDao().flushAndClear();
		
		//IGroupMember
		//移除CRM传入的groupId下的所有成员
		IGroupMember.removeAllMemberByGroupId(context, virtualServId);
		List<BaseEntity> members = context.getEntities(IGroupMember.class);
		
		for (BaseEntity baseEntity : members) {
			IGroupMember member = (IGroupMember) baseEntity;
			//加载BOSS侧已经存在的成员关系（仅剩下groupId不一致的记录）
			List<IGroupMember> persistentMembers = IGroupMember.queryByServIdAndGroupType(context, member.getServId(), member.getGroupType());
			context.getBusinessDao().flushAndClear();
			
			for (IGroupMember persistent : persistentMembers) {
				if (persistent.getGroupId() != virtualServId) {//BOSS侧的groupId不一致
					//主卡则需要对不一致的groupId进行拆网
					if (persistent.isMasterOfGroup()) {
						this.dismissGroup(context, persistent.getGroupId());
					}
					//非主卡则仅失效成员关系
					else {
						persistent.cancelWithISaleOper(context);
					}
				}
			}
			
			member.addWithISaleOper(context);
		}
		
		return null;
	}
	
	/**
	 * 拆网
	 * 包括删除虚用户IUser,IUserPlan,IUserStatus,IUserBillCycle,
	 * 删除主卡下的产品IUserSprom
	 * 删除虚用户下的产品IUserSprom
	 * 群组关系IGroupMember
	 * @param groupId
	 */
	public void dismissGroup(ServiceContext context, Long groupId) {
		logger.debug("开始拆网动作 groupId=" + groupId);
		//失效虚用户IUser,IUserPlan,IUserStatus,IUserBillCycle
		ISaleOper oper = ISaleOper.newInstanceByServId(context, groupId);
		
		List<Class<?>> classes = new ArrayList<Class<?>>();
		classes.add(IUser.class);
		classes.add(IUserPlan.class);
		classes.add(IUserStatus.class);
		classes.add(IUserBillCycle.class);
		
		for (Class<?> origClass : classes) {
			@SuppressWarnings("unchecked")
			Class<? extends BaseEntity> partitionClass = EntityPartitionHelper.getClassForPartition(origClass, groupId);
			
			List<? extends BaseEntity> persistents = BaseEntity.queryByServId(context, partitionClass, groupId);
			context.getBusinessDao().flushAndClear();
			
			for (BaseEntity persistent : persistents) {
				BeanCopyHelper.setProperty(persistent, "expireDate", oper.getCommitDate());
				BeanCopyHelper.setProperty(persistent, "soNbr", oper.getSoNbr());
				persistent.cancel(context);
				
				oper.updateUpField(persistent);
			}
			context.getBusinessDao().flushAndClear();
		}
		oper.add(context);
		context.getBusinessDao().flushAndClear();
		
		//失效主卡下账务产品
		List<IGroupMember> members = IGroupMember.queryAllMemberInGroup(context, groupId);
		for (IGroupMember m : members) {
			if (m.isMasterOfGroup()) {
				
				if (logger.isDebugEnabled()) {
					StringBuilder sb = new StringBuilder("拆网>>开始失效主卡下账务产品 ");
					sb.append("servId=").append(m.getServId());
					logger.debug(sb.toString());
				}
				
				IUserSprom.removeByServIdAndSpromId(context, m.getServId(), new Integer[]{80010261, 80010298, 80010421, 80020298});
			}
		}
		
		//失效虚用户下的计费产品
		logger.debug("拆网>>开始失效虚用户下的计费产品 groupId=" + groupId);
		IUserSprom.removeAllByServId(context, groupId);
		
		//失效所有成员关系
		logger.debug("拆网>>开始失效所有成员关系 groupId=" + groupId);
		IGroupMember.removeAllMemberByGroupId(context, groupId);
	}

}
