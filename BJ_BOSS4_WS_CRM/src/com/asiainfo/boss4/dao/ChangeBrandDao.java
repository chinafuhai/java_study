package com.asiainfo.boss4.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 全网携号转品牌Dao接口
 * @author xiaopeng
 */
public interface ChangeBrandDao extends BusinessDao{

	/**
	 * 全网携号转品牌操作
	 * 根据servId和expireDate>下月1号0点的条件更新expireDate为下月1号0点，
	 * 并把原expireDate值写到remark字段
	 * @param entity
	 * @param conditions
	 */
	public List changeBrand(Object entity, String[] constraints, Date currentDate, Set spromTypeSet);

}
