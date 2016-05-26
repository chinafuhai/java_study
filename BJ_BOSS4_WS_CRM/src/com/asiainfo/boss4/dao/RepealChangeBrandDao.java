package com.asiainfo.boss4.dao;

import java.util.Set;

/**
 * 全网携号转品牌撤单Dao接口
 * @author xiaopeng
 */
public interface RepealChangeBrandDao extends BusinessDao{
	
	/**
	 * 全网携号转品牌撤单操作
	 * 根据servId将expireDate更新为remark中的日期，remark字段置空
	 * @param entity
	 * @param spromStypeSet 
	 * @param conditions
	 */
	public void repealChangeBrand(Object entity, String[] constraints, Set spromStypeSet);


}
