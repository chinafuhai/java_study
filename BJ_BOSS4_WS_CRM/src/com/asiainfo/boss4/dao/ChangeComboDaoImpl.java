package com.asiainfo.boss4.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;

import com.asiainfo.boss4.domain.ISpromParam;
import com.asiainfo.boss4.domain.IUserCell;
import com.asiainfo.boss4.domain.IUserSprom;
import com.asiainfo.boss4.domain.IUserSpromConfig;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.StringHelper;


/**
 * 套餐变更Dao实现类
 * @author xiaopeng
 */
public class ChangeComboDaoImpl extends BusinessDaoImpl implements ChangeComboDao{
	private static Log logger = LogFactory.getLog(ChangeComboDaoImpl.class);
	
	public void cancelCombo(Object entity, String[] constraints) {
		try{
			//更新原记录
			StringBuffer updateHql = new StringBuffer();
			updateHql.append("update ").append(entity.getClass().getName())
				.append(" set soNbr = :soNbr, operType = :operType, expireDate = :expireDate where expireDate>sysdate and expireDate>validDate and ");
			for (int i = 0; i < constraints.length; i++) {
				String propName = constraints[i];
				updateHql.append(propName).append(" = :").append(propName).append(" and ");
			}
			String hql = updateHql.substring(0, updateHql.length() - 5);
			
			Query query = this.baseDao.createQuery(hql);
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
//			query.setParameter("sid", PropertyUtils.getProperty(entity, "sid"));
			query.setParameter("soNbr", PropertyUtils.getProperty(entity, "soNbr"));
			query.setParameter("operType", PropertyUtils.getProperty(entity, "operType"));
			query.setParameter("expireDate", PropertyUtils.getProperty(entity, "expireDate"));
			int updatedEntities = query.executeUpdate();
			if (updatedEntities == 0) {
				logger.error("更新实体记录 " + updatedEntities + "条，建议检查约束条件");
				if (entity instanceof IUserSprom) {//取消套餐
					throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR,
							"soNbr="+PropertyUtils.getProperty(entity, "soNbr")+",spromId="+PropertyUtils.getProperty(entity, "spromId")+",");
				}
				else {//取消程控
					throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR,
							"soNbr="+PropertyUtils.getProperty(entity, "soNbr")+",prodId="+PropertyUtils.getProperty(entity, "prodId")+",");
				}
			}
			else if (updatedEntities > 1) {
				logger.error("更新实体记录 " + updatedEntities + "条，建议检查约束条件");
				if (entity instanceof IUserSprom) {//取消套餐
					throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR,
							"soNbr=_"+PropertyUtils.getProperty(entity, "soNbr")+",spromId="+PropertyUtils.getProperty(entity, "spromId")+",");
				}
				else {//取消程控
					throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR,
							"soNbr=_"+PropertyUtils.getProperty(entity, "soNbr")+",prodId="+PropertyUtils.getProperty(entity, "prodId")+",");
				}
			}
			
			flush();
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

	public Object queryMscEntity(Object entity, String[] constraints) {
		if (constraints == null || constraints.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR);
		}
		
		//查询sid最大的一条有效数据
		StringBuffer sb = new StringBuffer();
		sb.append("from ").append(StringHelper.getClassName(entity.getClass()))
			.append(" where servId=:servId")
			.append(" and prodId=:prodId")
			.append(" and expireDate>validDate")
			.append(" order by sid desc");
		
		Object resutl = null;
		try {
			Query query = (Query) baseDao.createQuery(sb.toString());
			
			try {
				query.setParameter("servId", PropertyUtils.getProperty(entity, "servId"));
				query.setParameter("prodId", PropertyUtils.getProperty(entity, "prodId"));
			} catch (Exception e) {
				logger.error("无法取出实体对象"+StringHelper.getClassName(entity.getClass())+"中指定的属性值");
				throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
			} 
			resutl = query.list().get(0);
			if (resutl == null) {
				logger.error("没有找到数据，结果为空");
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
			}
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return resutl;
	}
	

	public List queryMutex(Object entity){
		flush();
		Integer spromId = null;
		Long servId = null;
		Date validDate = null;
		Date expireDate = null;
		try {
			spromId = (Integer) PropertyUtils.getProperty(entity, "spromId");
			servId = (Long) PropertyUtils.getProperty(entity, "servId");
			validDate = (Date) PropertyUtils.getProperty(entity, "validDate");
			expireDate = (Date) PropertyUtils.getProperty(entity, "expireDate");
		}
		catch (Exception e) {
			logger.debug("从实体取spromId、servId、validDate值失败");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		
		String entityTableName = EntityPartitionHelper.getTableName(entity);
		
		StringBuffer sb = new StringBuffer();
//		sb.append("select * from ").append(StringHelper.getClassName(entity.getClass())).append(" s,")
//		sb.append("select s.serv_id,s.sprom_id,s.valid_date,s.so_id from ").append("zg.i_user_sprom s,")
//			.append(" (select r2.prod_id")
//			.append(" from inter.i_user_sprom_rule r1, inter.i_user_sprom_rule r2")
//			.append(" where r1.prod_id = '").append(spromId.toString()).append("' and r1.prod_id != r2.prod_id")
//			.append(" and r1.group_id = r2.group_id) r")
//			.append(" where s.expire_date > :validDate")
//			.append(" and s.valid_date < :expireDate")
//			.append(" and s.sprom_id = r.prod_id")
//			.append(" and s.expire_date > sysdate")
//			.append(" and s.serv_id = '").append(servId.toString()).append("'");
		
		sb.append("from ").append(entity.getClass().getSimpleName()).append(" s")
			.append(" where s.spromId in")
			.append(" (select r2.prodId")
			.append(" from IUserSpromRule r1, IUserSpromRule r2")
			.append(" where r1.prodId = '").append(spromId.toString()).append("' and r1.prodId != r2.prodId")
			.append(" and r1.groupId = r2.groupId)")
			.append(" and s.expireDate > :validDate")
			.append(" and s.validDate < :expireDate")
			.append(" and s.expireDate > sysdate")
			.append(" and s.servId = '").append(servId.toString()).append("'");
		
		Query query = this.baseDao.createQuery(sb.toString());
//		Query query = this.baseDao.createSQLQuery(sb.toString());
		query.setParameter("validDate", validDate);
		query.setParameter("expireDate", expireDate);
		List list = query.list();
		
		return list;
	}
	
	public boolean checkInterleaveSprom(Object entity){
		List list = this.queryInterleaveSprom(entity);
		if (list.size()>0) {
			return true;
		}
		return false;
	}
	
	public List queryInterleaveSprom(Object entity){
		Integer spromId = null;
		Long servId = null;
		Date validDate = null;
		Date expireDate = null;
		try {
			spromId = (Integer) PropertyUtils.getProperty(entity, "spromId");
			servId = (Long) PropertyUtils.getProperty(entity, "servId");
			validDate = (Date) PropertyUtils.getProperty(entity, "validDate");
			expireDate = (Date) PropertyUtils.getProperty(entity, "expireDate");
		}
		catch (Exception e) {
			logger.debug("从实体取spromId、servId、validDate赋值失败");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		StringBuffer sb = new StringBuffer();
		sb.append("from ").append(entity.getClass().getSimpleName()).
			append(" where expireDate>:validDate and validDate<:expireDate and expireDate>sysdate and spromId=:spromId and servId=:servId");
		Query query = this.baseDao.createQuery(sb.toString());
		query.setParameter("validDate", validDate);
		query.setParameter("expireDate", expireDate);
		query.setParameter("spromId", spromId);
		query.setParameter("servId", servId);
		return query.list();
	}
	
	public boolean checkInterleaveMsc(Object entity){
		Integer prodId = null;
		Long servId = null;
		Date validDate = null;
		Date expireDate = null;
		try {
			prodId = (Integer) PropertyUtils.getProperty(entity, "prodId");
			servId = (Long) PropertyUtils.getProperty(entity, "servId");
			validDate = (Date) PropertyUtils.getProperty(entity, "validDate");
			expireDate = (Date) PropertyUtils.getProperty(entity, "expireDate");
		}
		catch (Exception e) {
			logger.debug("从实体取prodId、servId、validDate赋值失败");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		StringBuffer sb = new StringBuffer();
		sb.append("from ").append(entity.getClass().getSimpleName()).
			append(" where expireDate>:validDate and validDate<:expireDate and expireDate>sysdate and prodId=:prodId and servId=:servId");
		Query query = this.baseDao.createQuery(sb.toString());
		query.setParameter("validDate", validDate);
		query.setParameter("expireDate", expireDate);
		query.setParameter("prodId", prodId);
		query.setParameter("servId", servId);
		if (query.list().size()>0) {
			return true;
		}
		return false;
	}

	public boolean checkCanBeInterleaving(Object entity) {
		Integer spromId = null;
		Long servId = null;
		try {
			spromId = (Integer) PropertyUtils.getProperty(entity, "spromId");
			servId = (Long) PropertyUtils.getProperty(entity, "servId");
		}
		catch (Exception e) {
			logger.debug("从实体取spromId或servId赋值失败");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append("select * from inter.i_user_sprom_rule r where r.prod_id = :prod_id and r.id_level = '9'");
		
//		Query query = this.baseDao.createQuery(sb.toString());
		Query query = this.baseDao.createSQLQuery(sb.toString()).setParameter("prod_id", spromId);
		List list = query.list();
		
		if (list.size()>0) {
			return true;
		}
		return false;
	}

	public List querySpromEntity(Object entity) {
		Integer spromId = null;
		Long servId = null;
		try {
			spromId = (Integer) PropertyUtils.getProperty(entity, "spromId");
			servId = (Long) PropertyUtils.getProperty(entity, "servId");
		}
		catch (Exception e) {
			logger.debug("从实体取spromId、servId、validDate赋值失败");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		StringBuffer sb = new StringBuffer();
		sb.append("from ").append(entity.getClass().getSimpleName()).
			append(" where expireDate>sysdate and expireDate>validDate and spromId=:spromId and servId=:servId order by sid desc");
		Query query = this.baseDao.createQuery(sb.toString());
		query.setParameter("spromId", spromId);
		query.setParameter("servId", servId);
		return query.list();
	}

	public List querySpromEntityList(Object entity) {
		Integer spromId = null;
		Long servId = null;
		Long soId = null;
		try {
			spromId = (Integer) PropertyUtils.getProperty(entity, "spromId");
			servId = (Long) PropertyUtils.getProperty(entity, "servId");
			soId = (Long) PropertyUtils.getProperty(entity, "soId");
		}
		catch (Exception e) {
			logger.debug("从实体取spromId、servId、validDate赋值失败");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		StringBuffer sb = new StringBuffer();
		sb.append("from ").append(entity.getClass().getSimpleName()).
			append(" where expireDate>sysdate and expireDate>validDate and spromId=:spromId and servId=:servId and mod(so_id,10000)=:soId");
		Query query = this.baseDao.createQuery(sb.toString());
		query.setParameter("spromId", spromId);
		query.setParameter("servId", servId);
		query.setLong("soId", soId); 
		return query.list();
	}
	

	public IUserSpromConfig querySpromConfig(IUserSprom iUserSprom) {
		String hql = "from IUserSpromConfig where crmSpromId = :spromId";
		Query query = this.baseDao.createQuery(hql);
		query.setParameter("spromId", iUserSprom.getSpromId());
		IUserSpromConfig iUserSpromConfig = (IUserSpromConfig) query.uniqueResult();
		if (iUserSpromConfig==null) {
			logger.error("查询不到套餐"+iUserSprom.getSpromId()+"的附加套餐配置");
			throw new BossException(StatusCode.SPROM_CONFIG_NOT_EXIST_ERROR, 
					StatusCode.SPROM_CONFIG_NOT_EXIST_ERROR.getDescription()+"，spromId="+iUserSprom.getSpromId().toString());
		}
		return iUserSpromConfig;
	}

	public IUserSprom queryAppendSprom(IUserSprom iUserSprom) {
		IUserSpromConfig iUserSpromConfig = this.querySpromConfig(iUserSprom);
		
		StringBuffer sb = new StringBuffer();
		sb.append("from ").append(iUserSprom.getClass().getSimpleName())
			.append(" where servId = :servId and spromId = :spromId and soId = :soId")
			.append(" and expireDate>validDate and expireDate>sysdate");
		Query query = this.baseDao.createQuery(sb.toString());
		query.setParameter("servId", iUserSprom.getServId());//servId相同
		query.setParameter("spromId", iUserSpromConfig.getBossSpromId());//配置的附加套餐
		query.setParameter("soId", iUserSprom.getSoId());//soId相同
		
		return (IUserSprom) query.uniqueResult();
	}
	
	public IUserSprom queryAppendSprom(IUserSprom iUserSprom, IUserSpromConfig iUserSpromConfig) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("from ").append(iUserSprom.getClass().getSimpleName())
			.append(" where servId = :servId and spromId = :spromId and soId = :soId")
			.append(" and expireDate>validDate and expireDate>sysdate");
		Query query = this.baseDao.createQuery(sb.toString());
		query.setParameter("servId", iUserSprom.getServId());//servId相同
		query.setParameter("spromId", iUserSpromConfig.getBossSpromId());//配置的附加套餐
		query.setParameter("soId", iUserSprom.getSoId());//soId相同
		
		return (IUserSprom) query.uniqueResult();
	}

	public IUserCell queryIUserCell(IUserSprom iUserSprom) {
		StringBuffer sb = new StringBuffer();
		
		Class iUserCellClass = EntityPartitionHelper.getClassForPartition(IUserCell.class, iUserSprom.getServId());
		sb.append("from ").append(iUserCellClass.getSimpleName())
			.append(" where servId = :servId and mod(soId,10000)=:soId")
			.append(" and expireDate>validDate and expireDate>sysdate");
		Query query = this.baseDao.createQuery(sb.toString());
		query.setParameter("servId", iUserSprom.getServId());//servId相同
		query.setLong("soId", iUserSprom.getSoId());//soId相同
		
		IUserCell iUserCell = (IUserCell) query.uniqueResult();
		if (iUserCell == null) {
			logger.error("没有找到数据，结果为空");
			throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
		}
		return iUserCell;
	}

	public ISpromParam queryISpromParam(ISpromParam entity, Integer spromId) {
		/*
		 * 1.移动400语音业务，传入的套餐87410081、87410082的soId相同，且都有keyId为790002的折扣，
		 * 因此需要先查询出套餐的准确soId，再用该soId查param数据
		 * 
		 * 2.单独变更过的param数据，存在多条soId相同，查询sid最大的那条
		 */
		Long servId = (Long) BeanCopyHelper.getProperty(entity, "servId");
		Integer keyId = (Integer) BeanCopyHelper.getProperty(entity, "keyId");
		Long soId = (Long) BeanCopyHelper.getProperty(entity, "soId");
		
		Class querySpromClass = EntityPartitionHelper.getClassForPartition(IUserSprom.class, servId);
		StringBuffer sb = new StringBuffer();
		sb.append("from ").append(querySpromClass.getSimpleName()).
			append(" where expireDate>sysdate and expireDate>validDate and spromId=:spromId and servId=:servId and mod(so_id,10000)=:soId");
		Query query = this.baseDao.createQuery(sb.toString());
		query.setParameter("spromId", spromId);
		query.setParameter("servId", servId);
		query.setLong("soId", soId);
		IUserSprom iUserSprom = null;
		try {
			iUserSprom = (IUserSprom) query.uniqueResult();
		}
		catch (NonUniqueResultException e) {
			logger.error("param对应的sprom不唯一");
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e);
		}
		if (iUserSprom == null) {
			logger.error("没有找到对应的sprom");
			throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
		}
		
		Long paramSoId = iUserSprom.getSoId();
		sb = new StringBuffer();
		sb.append("from ").append(entity.getClass().getSimpleName())
			.append(" where servId = :servId and keyId =:keyId and soId=:soId")
			.append(" and expireDate>validDate and expireDate>sysdate")
			.append(" order by sid desc");
		query = this.baseDao.createQuery(sb.toString());
		query.setParameter("servId", servId);
		query.setParameter("keyId", keyId);
		query.setLong("soId", paramSoId);
		List list = query.list();
		ISpromParam iSpromParam = null;
		if (list.size() == 0) {
			iSpromParam = (ISpromParam) BeanCopyHelper.newInstance(entity.getClass());
			iSpromParam.setSoId(paramSoId);
		}
		else {
			iSpromParam = (ISpromParam) list.get(0);
		}
		return iSpromParam;
	}

	public List queryNationalSpromParam(ISpromParam entity) {
		StringBuffer sb = new StringBuffer();
		sb.append("from ").append(entity.getClass().getSimpleName())
			.append(" where servId = ? and keyId = ? and spromPara like ?")
			.append(" and expireDate>validDate and expireDate>sysdate")
			.append(" order by sid desc");
		Query query = this.baseDao.createQuery(sb.toString());
		query.setLong(0, entity.getServId());
		query.setInteger(1, entity.getKeyId());
		query.setString(2, entity.getSpromPara()+'%');
		List list = query.list();
		if (list.size() == 0) {
			logger.error("没有找到指定的国家折扣数据");
			throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
		}
//		else if (list.size()>1) {
//			logger.error("查询到多条国家折扣数据");
//			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR);
//		}
		return list;
	}

	public List querySpecialNationalSpromParam(Long servId, Integer spromId, Long soId) {
		Class iSpromParamClass = EntityPartitionHelper.getClassForPartition(ISpromParam.class, servId);
		StringBuffer sb = new StringBuffer();
		sb.append("from ").append(iSpromParamClass.getSimpleName())
			.append(" where servId = ? and keyId = 810542")
			.append(" and expireDate>validDate and expireDate>sysdate");
		Query query = this.baseDao.createQuery(sb.toString());
		query.setLong(0, servId);
		return query.list();
	}
	
	public Map querySpmprodCfg(Long spromId) {
		StringBuffer querySql = new StringBuffer();
		querySql.append("select d.para_id,d.para_value").
			append(" from ZC.ACCP_SPMPROD_CFG c, ZC.ACCP_SPMPROD_CFG_DTL d")
			.append(" where c.para_grp_id = d.para_grp_id")
			.append(" and d.para_id in (1, 2)")
			.append(" and c.order_prod_id = :spromId");
		Query query = this.baseDao.createSQLQuery(querySql.toString()).setLong("spromId", spromId);
		List list = query.list();
		Map map = new HashMap();
		if (list.size()!=2) {
			logger.error("查询年承诺消费配置出错");
			throw new BossException(StatusCode.QUERY_ENTITY_VALUE_ERROR);
		}
		for (Object object : list) {
			System.out.println(object);
			Object[] o = (Object[]) object;
			map.put(o[0].toString(), o[1].toString());
		}
		return map;
	}
}
