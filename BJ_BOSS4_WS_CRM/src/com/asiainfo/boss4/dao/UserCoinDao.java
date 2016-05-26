package com.asiainfo.boss4.dao;

import com.asiainfo.boss4.domain.CrmUserCoinOrder;

public interface UserCoinDao extends BusinessDao {
	/**
	 * 根据phoneId查询指定用户的有效积分数据
	 * @param entity
	 * @return
	 */
	public CrmUserCoinOrder queryCrmUserCoinOrderEntity(Object entity);
}
