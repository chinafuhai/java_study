package com.asiainfo.boss4.dao;

import java.util.List;


/**
 * 套餐查询Dao接口
 * @author weihf
 */
public interface UserSpromDao extends BusinessDao{
	

	/**
	 * 根据servId、spromType查询指定用户指定套餐的有效数据
	 * @param entity
	 * @return
	 */
	public List querySpromEntity(Object entity);

}
