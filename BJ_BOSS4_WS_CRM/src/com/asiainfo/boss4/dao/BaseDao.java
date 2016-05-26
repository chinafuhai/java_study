package com.asiainfo.boss4.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
/**
 * 数据库基本操作dao接口
 * @author xiaopeng
 *
 */
public interface BaseDao {

	void delete(Object bean, Serializable pk);
	
	void delete(Object bean);

	List findAll(Class beanClass);

	Object findById(Class beanClass, Serializable id);

	Serializable insert(Object bean);

	void update(Object bean);

	List findByHql(String hql);

	int queryUpdate(String hql);

	int queryUpdate(String hql, Object[] arr);

	List queryForList(String hql, boolean isHQL);

	Object queryForObject(String sql);

	SQLQuery createSQLQuery(String sql);

	Query createQuery(String hql);

	Session getSess();

}
