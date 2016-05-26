package com.asiainfo.boss4.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;

import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.StringHelper;

/**
 * 全网携号转品牌Dao实现类
 * @author xiaopeng
 */
public class ChangeBrandDaoImpl extends BusinessDaoImpl implements ChangeBrandDao{
	private static Log logger = LogFactory.getLog(ChangeBrandDaoImpl.class);

	public List changeBrand(Object entity, String[] constraints, Date currentDate, Set spromTypeSet) {
		if (constraints == null || constraints.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR);
		}
		try {

			//获取下月第一天（零时）
			Date nextMonthFirstDay = DateHelper.getNextMonthFirstDay(currentDate);
			
			//根据条件servId和expireDate>下月1号0时，查询要更新的记录
			StringBuffer sb = new StringBuffer();
			sb.append("from ").append(StringHelper.getClassName(entity.getClass()));
			sb.append(" where ");
			sb.append("expireDate > :nextMonthFirstDay and ");
			
			for (int i = 0; i < constraints.length; i++) {
				String propName = constraints[i];
				if ("expireDate".equals(propName)) {
					continue;
				} else {
					sb.append(propName).append(" = :").append(propName).append(" and ");
				}
			}
			
			String hql = sb.substring(0, sb.length() - 5);

			Query query = (Query) baseDao.createQuery(hql);
			for (int i = 0; i < constraints.length; i++) {
				String propName = constraints[i];
				Object obj = null;
				try {
					obj = PropertyUtils.getProperty(entity, propName);
					if (obj == null) throw new Exception("约束条件（EAI传入"+propName+"节点）为空");
				} catch (Exception e) {
					logger.error("无法取出实体对象"+StringHelper.getClassName(entity.getClass())+"中指定的属性"+propName+"的值");
					throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
				} 
				query.setParameter(propName, obj);
			}
			query.setParameter("nextMonthFirstDay", nextMonthFirstDay);
			
			List list = query.list();
			
			for (int i = 0; i < list.size(); i++) {
				Object oldObj = list.get(i);
				Object newObj = EntityPartitionHelper.getOriginalClassForPartitionWithSuffix(entity, "Rb").newInstance();//拷贝历史记录
				PropertyUtils.copyProperties(newObj, oldObj);
				PropertyUtils.setProperty(newObj, "rollbackSoNbr", PropertyUtils.getProperty(entity, "soNbr"));//设置历史数据rollbackSoNbr为此操作soNbr
				PropertyUtils.setProperty(oldObj, "soNbr", PropertyUtils.getProperty(entity, "soNbr"));//更新原数据soNbr
				BeanUtils.copyProperty(oldObj, "expireDate", nextMonthFirstDay);//更新原数据失效时间为下月一号
				
				//如果操作的是IUserSprom表，将记录的spromType放入set
				if (EntityPartitionHelper.getOriginalClassForPartition(entity).getSimpleName().equals("IUserSprom")) {
					spromTypeSet.add(PropertyUtils.getProperty(oldObj, "spromType"));
				}
				baseDao.update(oldObj);
				baseDao.insert(newObj);
			}
			return list;
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
}
