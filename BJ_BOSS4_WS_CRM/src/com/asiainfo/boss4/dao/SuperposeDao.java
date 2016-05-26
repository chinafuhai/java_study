package com.asiainfo.boss4.dao;

/**
 * 叠加包业务Dao接口
 * @deprecated
 * @author xiaopeng
 */
public interface SuperposeDao extends BusinessDao{
	
	public void addSuperpose(Object entity);

	public void rollbackSuperpose(Object entity);
}
