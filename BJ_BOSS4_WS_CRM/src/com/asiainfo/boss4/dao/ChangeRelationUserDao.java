package com.asiainfo.boss4.dao;

import com.asiainfo.boss4.domain.IUserRelation;

public interface ChangeRelationUserDao extends BusinessDao {

	/**
	 * 查询亲情号码
	 * @param queryIUserRelation
	 * @return
	 */
	IUserRelation queryRelationUser(IUserRelation queryIUserRelation);
	
}
