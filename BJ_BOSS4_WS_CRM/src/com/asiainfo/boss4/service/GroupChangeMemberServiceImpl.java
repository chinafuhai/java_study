package com.asiainfo.boss4.service;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.domain.IGroupMember;
import com.asiainfo.boss4.domain.ISaleOper;
import com.asiainfo.boss4.domain.IUser;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.DataValiditionHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;

/**
 * 集团群组类业务成员订购服务
 * @author caohui
 *
 */
public class GroupChangeMemberServiceImpl extends BusinessServiceImpl
		implements BusinessService {

	private static Log logger = LogFactory.getLog(GroupChangeMemberServiceImpl.class);

	/**
	 * 个性化构造实体
	 * @param entity
	 * @param vo
	 */
	private void buildEntitys(Object entity, DynaBean vo) {
		DataValiditionHelper.checkInputVo(vo, "groupId");
		String phoneNbr = (String) vo.get("groupId");
		IUser user = businessDao.queryIUserAllByPhoneNumber(phoneNbr);
		if (user == null) {
			throw new BossException(StatusCode.NOT_EXIST_USER_ERROR, "手机号为"+phoneNbr+"的用户不存在");
		}
		// 根据手机号反查servId，置入groupId字段
		Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
		if (entityClass.equals(IGroupMember.class)) {
			IGroupMember member = (IGroupMember) entity;
			member.setGroupId(user.getServId());
		}
		// 上发表groupId保证0即可
		if (entityClass.equals(ISaleOper.class)) {
			ISaleOper oper = (ISaleOper) entity;
			oper.setGroupId(0L);
		}

	}
	
	@Override
	protected void addEntitys(Object entity, DynaBean vo, OneOpreateConfig config) {
		buildEntitys(entity, vo);
		super.addEntitys(entity, vo, config);
	}

	@Override
	protected void cancelEntitys(Object entity, DynaBean vo, OneOpreateConfig config) {
		buildEntitys(entity, vo);
		super.cancelEntitys(entity, vo, config);
	}
	
}
