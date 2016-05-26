package com.asiainfo.boss4.service;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.domain.IUserEnterprise;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.UpFieldUtil;

/**
 * 集团业务订购服务
 * @author caohui
 *
 */
public class GroupChangeBusinessServiceImpl extends BusinessServiceImpl
		implements BusinessService {

	private static Log logger = LogFactory.getLog(GroupChangeBusinessServiceImpl.class);

	@Override
	protected void addEntitys(Object entity, DynaBean vo, OneOpreateConfig config) {
		//判断是否已经存在成功订购的IUserEnterprise，如存在则直接返回成功
		Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
		if (entityClass.equals(IUserEnterprise.class)) {
			//取配置的查询条件
			String[] conditions = config.getConditionCols(entityClass.getName());
			//已经存在成功订购的IUserEnterprise
			if (this.businessDao.getEntity(entity, conditions) != null) {
				logger.debug("IUserEnterprise已经存在，返回成功");
				UpFieldUtil.setLiveCanceledUpfield(vo, entity);
				return;
			}
		}
		
		super.addEntitys(entity, vo, config);
	}

	@Override
	protected void cancelEntitys(Object entity, DynaBean vo, OneOpreateConfig config) {
		//取消订购时，不操作IUserEnterprise
		Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
		if (entityClass.equals(IUserEnterprise.class)) {
			UpFieldUtil.setLiveCanceledUpfield(vo, entity);
			return;
		}
		super.cancelEntitys(entity, vo, config);
	}
	
}
