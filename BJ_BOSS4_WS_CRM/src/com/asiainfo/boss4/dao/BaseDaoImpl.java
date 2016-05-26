package com.asiainfo.boss4.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/**
 * 数据库基本操作dao具体实现
 * @author xiaopeng
 *
 */
public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao{

	public void delete(Object bean, Serializable pk) {
		this.getHibernateTemplate().load(bean, pk);
		this.getHibernateTemplate().delete(bean);
	}
	
	public void delete(Object bean) {
		this.getHibernateTemplate().delete(bean);
	}

	public List findAll(Class beanClass) {
		String hql = "from " + beanClass.getName();
		return this.getSession().createQuery(hql).list();
	}
	
	public Object findById(Class beanClass, Serializable id) {
		return this.getSession().load(beanClass, id);
	}
	
	public Serializable insert(Object bean) {
		return this.getHibernateTemplate().save(bean);
//		return this.getSession().save(bean);
	}
	
	public void update(Object bean) {
		this.getHibernateTemplate().update(bean);
		this.getHibernateTemplate().flush();
	}
	
	public List findByHql(String hql) {
		List list = this.getSession().createQuery(hql).list();
		this.getSession().flush();
		return list;
	}
	
	public int queryUpdate(String hql){
		return this.getSession().createQuery(hql).executeUpdate();
	}
	
	public int queryUpdate(String hql, Object[] arr){
		Query q = this.getSession().createQuery(hql);
		
		for(int i=0; i<arr.length; i++){
			q.setParameter(i, arr[i]);
		}
		return this.getSession().createQuery(hql).executeUpdate();
	}
	
	public List queryForList(String hql, boolean isHQL){
		if(isHQL){
			return this.getSession().createQuery(hql).list();
		}else{
			return this.getSession().createSQLQuery(hql).list();
		}
	}
	
	public Object queryForObject(String sql){
		return this.getSession().createSQLQuery(sql).uniqueResult();
	}
	
	public SQLQuery createSQLQuery(String sql){
		return this.getSession().createSQLQuery(sql);
	}
	
	public Query createQuery(String hql){
		return this.getSession().createQuery(hql);
	}
	
	public Session getSess(){
		return this.getSession();
	}

}
