package com.asiainfo.boss4.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;

import com.asiainfo.boss4.domain.CpcTransRule;
import com.asiainfo.boss4.domain.IUserOrder;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.StringHelper;

@SuppressWarnings("unchecked")
public class CpcOrderDaoImpl extends BusinessDaoImpl implements CpcOrderDao {

	private static Log logger = LogFactory.getLog(CpcOrderDaoImpl.class);
	
	public CpcTransRule getCpcTransRule(String spId, String spBizCode) {
		try {
			CpcTransRule rule;
				rule = (CpcTransRule) this.baseDao.getSess()
				.createSQLQuery("SELECT * FROM INTER.CPC_TRANS_RULE where SP_ID = :spId AND SP_BIZ_CODE = :spBizCode")
				.addEntity(CpcTransRule.class)
				.setString("spId", spId).setString("spBizCode", spBizCode)
				.uniqueResult();
			if (rule == null) {
				rule = new CpcTransRule();
				rule.setSpId(spId);
				rule.setSpBizCode(spBizCode);
				rule.setExpireDate("FOREVER");
			}
			return rule;
		} catch (NonUniqueResultException e) {
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e, "Row of INTER.CPC_TRANS_RULE is not unique.(by SPID:"+spId+", SPBizCode:"+spBizCode+")");
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

	@Deprecated
	public Long getServIdFromEnterprise(String serviceCode) {
		try {
			Long servId;
			servId = (Long) this.baseDao.getSess()
				.createSQLQuery("SELECT SERV_ID FROM INTER.I_USER_ENTERPRISE_ALL where SERVICE_CODE = :serviceCode AND EXPIRE_DATE > sysdate and rownum=1")
				.addScalar("SERV_ID", Hibernate.LONG)
				.setString("serviceCode", serviceCode)
				.uniqueResult();
			if (servId == null) {
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR, "Row of INTER.I_USER_ENTERPRISE_ALL is not exist.(by serviceCode:"+serviceCode+")");
			}
			return servId;
		} catch (NonUniqueResultException e) {
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e, "Row of INTER.I_USER_ENTERPRISE_ALL is not unique.(by serviceCode:"+serviceCode+")");
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

	@Deprecated
	public Long getServIdFromPbx(String inTrunk) {
		try {
			Long servId;
			servId = (Long) this.baseDao.getSess()
				.createSQLQuery("SELECT SERV_ID FROM INTER.I_USER_PBX_ALL where IN_TRUNK = :inTrunk AND EXPIRE_DATE > sysdate and rownum=1")
				.addScalar("SERV_ID", Hibernate.LONG)
				.setString("inTrunk", inTrunk)
				.uniqueResult();
			if (servId == null) {
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR, "Row of INTER.I_USER_PBX_ALL is not exist.(by inTrunk:"+inTrunk+")");
			}
			return servId;
		} catch (NonUniqueResultException e) {
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e, "Row of INTER.I_USER_PBX_ALL is not unique.(by inTrunk:"+inTrunk+")");
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	public Map<String,Object> getLastIUserOrder(IUserOrder order) {
		return this.getLastIUserOrder(order, null);
	}

	public Map<String,Object> getLastIUserOrder(IUserOrder order, Byte orderSts) {
		String tableName = EntityPartitionHelper.getTableName(order);
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("select n.SID,n.ORDER_STS,n.HIS_FIRST_ORDER_TIME, n.FIRST_ORDER_TIME, n.LAST_ORDER_TIME, n.CHANGE_TIME, n.EXPIRE_DATE from ( ")
				.append("select t.* from ZG.").append(tableName)
				.append(" t where t.serv_id = :servId and t.serv_type = :servType ")
				.append("and t.sp_code = :spCode and t.operator_code = :operatorCode and t.third_msisdn = :thirdMsisdn");
			if (orderSts != null) {
				sql.append(" and t.order_sts = :orderSts ");
			}
			sql.append(" order by t.change_time desc ")
				.append(") n where rownum = 1");
			
			Query query = this.baseDao.getSess()
				.createSQLQuery(sql.toString())
				.addScalar("SID", Hibernate.LONG)
				.addScalar("ORDER_STS", Hibernate.STRING)
				.addScalar("HIS_FIRST_ORDER_TIME", Hibernate.TIMESTAMP)
				.addScalar("FIRST_ORDER_TIME", Hibernate.TIMESTAMP)
				.addScalar("LAST_ORDER_TIME", Hibernate.TIMESTAMP)
				.addScalar("CHANGE_TIME", Hibernate.TIMESTAMP)
				.addScalar("EXPIRE_DATE", Hibernate.TIMESTAMP)
				.setLong("servId", order.getServId())
				.setInteger("servType", order.getServType())
				.setString("spCode", order.getSpCode())
				.setString("operatorCode", order.getOperatorCode())
				.setString("thirdMsisdn", order.getThirdMsisdn());
			if (orderSts != null) {
				query = query.setByte("orderSts", orderSts);
			}
			
			return (Map<String,Object>) query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).uniqueResult();
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

	
	public void cancelIUserOrder(IUserOrder order) {
		this.cancelIUserOrder(order, null);
	}
	
	public void cancelIUserOrder(IUserOrder order, Long sid) {
		StringBuffer hql = new StringBuffer();
		hql.append("update ").append(order.getClass().getSimpleName())
		.append(" set expireDate = :expireDate, soNbr = :soNbr ");
		if (sid != null) {
			hql.append(", sid = :sid ");
		}
		hql.append(" where expireDate > sysdate and expireDate > validDate and servId = :servId ")
		.append("and spCode = :spCode and operatorCode = :operatorCode and thirdMsisdn = :thirdMsisdn");
		
		try {
			Query query = baseDao.createQuery(hql.toString());
			query.setTimestamp("expireDate", order.getExpireDate())
			.setLong("soNbr", order.getSoNbr())
			.setLong("servId", order.getServId())
			.setString("spCode", order.getSpCode())
			.setString("operatorCode", order.getOperatorCode())
			.setString("thirdMsisdn", order.getThirdMsisdn());
			
			if (sid != null) {
				query.setLong("sid", sid);
			}
			
			int updateSum = query.executeUpdate();
			if (updateSum == 0) {
				logger.warn("No row of ZG.I_USER_ORDER_XXXX be updated.");
			}
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
	}
	
	/**
	 * 覆盖父类取消流程，支持失效0条或多条数据
	 */
	@Override
	@Deprecated
	public void cancel(Object entity, String[] constraints) {
		if (constraints == null || constraints.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR);
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append("update ").append(entity.getClass().getSimpleName())
			.append(" set expireDate = :expireDate, soNbr = :soNbr where ");
		for (int i = 0; i < constraints.length; i++) {
			String propName = constraints[i];
			if ("expireDate".equalsIgnoreCase(propName)) {
				sb.append("expireDate > sysdate and expireDate > validDate and ");
			} else {
				sb.append(propName).append(" = :").append(propName).append(" and ");
			}
		}
		
		String hql = sb.substring(0, sb.length() - 5);
		
		try {
			Query query = (Query) baseDao.createQuery(hql);
			
			for (int i = 0; i < constraints.length; i++) {
				String propName = constraints[i];
				
				if ("expireDate".equals(propName)) continue;
				
				Object obj = BeanCopyHelper.getProperty(entity, propName);
				if (obj == null) throw new Exception("约束条件（EAI传入"+propName+"节点）为空");
				
				query.setParameter(propName, obj);
			}
			
			Object expireDate = BeanCopyHelper.getProperty(entity, "expireDate");
			Object soNbr = BeanCopyHelper.getProperty(entity, "soNbr");
			if (expireDate == null || soNbr == null) throw new Exception("传入的expireDate或soNbr属性为空值");
			
			query.setParameter("expireDate", expireDate);
			query.setParameter("soNbr", soNbr);
			
			int updatedEntities = query.executeUpdate();
			
			if (updatedEntities != 1) {
				logger.warn(updatedEntities+ " row(s) of "+entity.getClass().getSimpleName()+" updated.");
			}
			
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
	}
	
	/**
	 * 查询出多条记录时仅取第一条，无记录返回null
	 */
	@Override
	@Deprecated
	public Object getEntity(Object entity, String[] constraints) {
		if (constraints == null || constraints.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR);
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append("from ").append(entity.getClass().getSimpleName()).append(" where ");
		for (int i = 0; i < constraints.length; i++) {
			String propName = constraints[i];
			if ("expireDate".equalsIgnoreCase(propName)) {
				sb.append("expireDate > sysdate and expireDate > validDate and ");
			} else {
				sb.append(propName).append(" = :").append(propName).append(" and ");
			}
		}
		
		String hql = sb.substring(0, sb.length() - 5);
		
		Object result = null;
		try {
			Query query = (Query) baseDao.createQuery(hql);
			
			for (int i = 0; i < constraints.length; i++) {
				String propName = constraints[i];
				
				if ("expireDate".equals(propName)) {
					continue;
				}
				
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
			List rs = query.list();
			
			if (rs.size() == 0) return null;
			//多条记录取第一条
			result = rs.get(0);
			logger.warn("Query result contains many rows of "+entity.getClass().getSimpleName()+", but just return the first row.");
		} catch (BossException e) {
			throw e;
		} catch (NonUniqueResultException e) {
			logger.error("返回数据库记录不唯一");
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e);
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return result;
	}
	
	@Deprecated
	public List<IUserOrder> queryIUserOrder(Object entity, String[] constraints, int[] orderSts) {
		List<IUserOrder> result = null;
		
		if (constraints == null || constraints.length == 0) {
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR, "未配置实体更新的约束条件");
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append("from ").append(entity.getClass().getSimpleName()).append(" where ");
		for (int i = 0; i < constraints.length; i++) {
			String propName = constraints[i];
			if ("expireDate".equalsIgnoreCase(propName)) {
				sb.append("expireDate > sysdate and expireDate > validDate and ");
				continue;
			}
			if ("orderSts".equalsIgnoreCase(propName) && orderSts != null) {
				if (orderSts.length == 1) {
					sb.append("orderSts = ").append(orderSts[0]).append(" and ");
				}
				if (orderSts.length > 1) {
					sb.append("orderSts in (");
					for (int j=0; j<orderSts.length; j++) {
						if (j != orderSts.length - 1) {
							sb.append(orderSts[j]).append(",");
						} else {
							sb.append(orderSts[j]);
						}
					}
					sb.append(") and ");
				}
				continue;
			}
			sb.append(propName).append(" = :").append(propName).append(" and ");
		}
		
		String hql = sb.substring(0, sb.length() - 5);
		
		
		try {
			Query query = (Query) baseDao.createQuery(hql);
			
			for (int i = 0; i < constraints.length; i++) {
				String propName = constraints[i];
				
				if ("expireDate".equals(propName)) {
					continue;
				}
				
				if ("orderSts".equals(propName)) {
					continue;
				}
				
				Object param = BeanCopyHelper.getProperty(entity, propName);
				if (param == null) throw new Exception("约束条件（EAI传入"+propName+"节点）为空");

				query.setParameter(propName, param);
			}
			
			result = query.list();
			
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return result;
	}
	
	public IUserOrder queryIUserOrder(IUserOrder entity) {
		
		StringBuffer hql = new StringBuffer("from ").append(entity.getClass().getName()).append(" t where ");
		hql.append("t.servId = :servId and t.spCode = :spCode and t.operatorCode = :operatorCode and t.thirdMsisdn = :thirdMsisdn and ");
		hql.append("expireDate > sysdate and expireDate > validDate");
		List<IUserOrder> orders = baseDao.createQuery(hql.toString())
			.setParameter("servId", entity.getServId())
			.setParameter("spCode", entity.getSpCode())
			.setParameter("operatorCode", entity.getOperatorCode())
			.setParameter("thirdMsisdn", entity.getThirdMsisdn())
			.list();
		
		if (orders.size() == 0) return null;
		if (orders.size() == 1) return orders.get(0);
		
		for (IUserOrder order : orders) {
			// 如果传入时间为月初一号零时，取下月生效记录
			if (DateHelper.isFirstDayInMonth(entity.getValidDate()) && order.getValidDate().getTime() == entity.getValidDate().getTime()) 
				return order;
			// 如果传入时间为当前时间(非月初一号零时)，取月底失效记录
			if (!DateHelper.isFirstDayInMonth(entity.getValidDate()) && order.getExpireDate().getTime() == DateHelper.getNextMonthFirstDay(entity.getValidDate()).getTime()) 
				return order;
			
		}
		throw new BossException(StatusCode.QUERY_ENTITY_VALUE_ERROR, "Query result size=> "+orders.size());
		
	}
	
	@Deprecated
	public void cancel(IUserOrder entity, String[] constraints, int[] orderSts) {
		if (constraints == null || constraints.length == 0) {
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR, "未配置实体更新的约束条件");
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append("update ").append(entity.getClass().getSimpleName())
			.append(" set expireDate = :expireDate, soNbr = :soNbr where ");
		for (int i = 0; i < constraints.length; i++) {
			String propName = constraints[i];
			if ("expireDate".equalsIgnoreCase(propName)) {
				sb.append("expireDate > sysdate and expireDate > validDate and ");
				continue;
			}
			if ("orderSts".equalsIgnoreCase(propName) && orderSts != null) {
				if (orderSts.length == 1) {
					sb.append("orderSts = ").append(orderSts[0]).append(" and ");
				}
				if (orderSts.length > 1) {
					sb.append("orderSts in (");
					for (int j=0; j<orderSts.length; j++) {
						if (j != orderSts.length - 1) {
							sb.append(orderSts[j]).append(",");
						} else {
							sb.append(orderSts[j]);
						}
					}
					sb.append(") and ");
				}
				continue;
			}
			sb.append(propName).append(" = :").append(propName).append(" and ");
		}
		
		String hql = sb.substring(0, sb.length() - 5);
		
		try {
			Query query = (Query) baseDao.createQuery(hql);
			
			for (int i = 0; i < constraints.length; i++) {
				String propName = constraints[i];
				
				if ("expireDate".equals(propName)) continue;
				if ("orderSts".equals(propName)) continue;
				
				Object obj = BeanCopyHelper.getProperty(entity, propName);
				if (obj == null) throw new Exception("约束条件（EAI传入"+propName+"节点）为空");
				
				query.setParameter(propName, obj);
			}
			
			Object expireDate = BeanCopyHelper.getProperty(entity, "expireDate");
			Object soNbr = BeanCopyHelper.getProperty(entity, "soNbr");
			if (expireDate == null || soNbr == null) throw new Exception("传入的expireDate或soNbr属性为空值");
			
			query.setParameter("expireDate", expireDate);
			query.setParameter("soNbr", soNbr);
			
			int updatedEntities = query.executeUpdate();
			
			if (updatedEntities != 1) {
				logger.warn(updatedEntities+ " row(s) of "+entity.getClass().getSimpleName()+" updated.");
			}
			
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
	}

	public void changeIUserOrder(IUserOrder existedOrder, IUserOrder expectedOrder, String[] updateFields) {
		if (updateFields == null || updateFields.length == 0) {
			throw new BossException(StatusCode.NO_UPDATE_DESTINATION_ERROR, "未配置实体更新的目标字段");
		}
		
		if (existedOrder == null) {
			throw new BossException(StatusCode.INSIDE_ERROR, new NullPointerException());
		}
		
		try {
			
			/*****************************用EAI传入数据覆盖原数据来构造新记录*****************************/
			// 用EAI传入数据覆盖原数据指定的字段
			Object newOrder = Class.forName(existedOrder.getClass().getName()).newInstance();
			BeanCopyHelper.copyBeanNotNullProperty(newOrder, existedOrder);
			for (String field : updateFields) {
				Object fieldValue = BeanCopyHelper.getProperty(expectedOrder, field);
				if (fieldValue == null) throw new Exception("实体对象"+expectedOrder.getClass().getSimpleName()+"中欲更新的属性"+field+"的值为空");
				BeanCopyHelper.setProperty(newOrder, field, fieldValue);
			}
			// 更新原数据的生效时间
			BeanCopyHelper.setProperty(newOrder, "validDate", expectedOrder.getValidDate());
			// 新数据使用新生成的sid
			BeanCopyHelper.setProperty(newOrder, "sid", BeanCopyHelper.getProperty(expectedOrder, "sid"));
			/*****************************用EAI传入数据覆盖原数据来构造新记录*****************************/
			
			//失效原记录
			baseDao.getSess().refresh(existedOrder);
			existedOrder.setExpireDate(expectedOrder.getValidDate());
			existedOrder.setSoNbr(expectedOrder.getSoNbr());
			flushAndClear();
			
			// 插入新数据
			add(newOrder);
			flushAndClear();
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
	}
}
