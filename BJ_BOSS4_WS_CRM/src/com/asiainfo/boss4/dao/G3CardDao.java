package com.asiainfo.boss4.dao;

import com.asiainfo.boss4.domain.IUser;

public interface G3CardDao extends BusinessDao {
	
//	/* 
//	 * 覆盖父类方法
//	 * 操作IUser表时不同时操作IUserUnion
//	 */
//	public Object rollback(Object entity);

	/**
	 * 按userType查询用户数据
	 * @param inputIUser
	 */
	public IUser queryIUser(IUser inputIUser);

	/**
	 * 更新主键中的soNbr
	 * @param iUser
	 */
	public void updateSoNbr(IUser iUser, Long newSoNbr);

	public void updateSidAndSoNbr(IUser iUser, Long sid, Long soNbr);
	
	public IUser queryIUserByMsisdn(IUser inputIUser);
	
	public boolean sidExist(IUser inputIUser);
	
	public void addOrRemoveRelation(IUser user,Short operType);
}
