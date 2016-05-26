package com.asiainfo.boss4.dao;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;

import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.EntityPartitionHelper;

public class RepealChangeComboDaoImpl extends BusinessDaoImpl implements
		RepealChangeComboDao {

	private static Log logger = LogFactory.getLog(RepealChangeComboDaoImpl.class);

	public Object repealChangeCombo(Object entity) {
		Long soNbr = null;
		try {
			soNbr = (Long) PropertyUtils.getProperty(entity, "soNbr");
		}catch (Exception e) {
			logger.error("无法取出实体" + entity.getClass().getSimpleName() + "的soNbr属性");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		//原表数据查询语句
		StringBuffer queryHql1 = new StringBuffer();
		queryHql1.append("from ").append(EntityPartitionHelper.getClassForPartition(entity).getSimpleName())
		.append(" where soNbr=").append(soNbr);
		
		//回滚表数据查询语句
		StringBuffer queryHql2 = new StringBuffer();
		queryHql2.append("from ").append(EntityPartitionHelper.getOriginalClassForPartitionWithSuffix(entity, "RB").getSimpleName())
		.append(" where rollbackSoNbr=").append(soNbr);
		
		Query query1 = (Query) baseDao.createQuery(queryHql1.toString());
		
		Query query2 = null;
		
		Object object1 = query1.uniqueResult();
		Object object2 = null;
		
		if (object1 != null) {//原表数据存在
			Integer operType = null;
			try {
				operType = Integer.parseInt(BeanUtils.getProperty(object1, "operType"));
			} catch (Exception e) {
				logger.error("取实体的operType失败");
				throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
			}
			if (operType == 3){//取消套餐的撤单
				query2 = (Query) baseDao.createQuery(queryHql2.toString());
				object2 = query2.uniqueResult();
				if (object2 == null) {
					logger.error("无法找到匹配的记录");
					throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
				}
				Object tempObj = null;
				try {
					tempObj = Class.forName(entity.getClass().getName()).newInstance();
					PropertyUtils.copyProperties(tempObj, object2);
//					PropertyUtils.setProperty(tempObj, "sid", PropertyUtils.getProperty(entity, "sid"));//更新sid
				}
				catch (Exception e) {
					logger.error("复制对象属性失败");
					throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
				}
				//i_user_sprom表中oper_type是主键，这里修改oper_type的值，不能复制object2到object1后用baseDao.update()方法更新
				//先删除object1，后插入复制了object2属性的临时数据
				baseDao.delete(object1);
				baseDao.insert(tempObj);
				baseDao.delete(object2);
				Object spromType = null;
				try {
					spromType = BeanUtils.getProperty(tempObj, "spromType");
				}
				catch (NoSuchMethodException e) {
					spromType = null;
				}
				catch (Exception e) {
					logger.error("获取spromType属性失败");
					throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
				}
				return spromType;
			}
			else if (operType == 1) {//新增套餐的撤单
				try {
//					Date currentDate = queryCurrentDate();
//					PropertyUtils.setProperty(object1, "sid", PropertyUtils.getProperty(entity, "sid"));//更新sid
					PropertyUtils.setProperty(object1, "expireDate", PropertyUtils.getProperty(object1, "validDate"));//置失效时间为生效时间
				}
				catch (Exception e) {
					logger.error("复制对象属性失败");
					throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
				}
				baseDao.update(object1);
				Object spromType = null;
				try {
					spromType = BeanUtils.getProperty(object1, "spromType");
				} 
				catch (NoSuchMethodException e) {
					spromType = null;
				}
				catch (Exception e) {
					logger.error("获取spromType属性失败");
					throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
				}
				return spromType;
			}
		}
		else {//原表数据不存在
			logger.error("找不到要被撤单的记录");
			throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
		}
		return null;
	}
}
