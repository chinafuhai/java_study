package com.asiainfo.boss4.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.asiainfo.boss4.domain.CcPlanInstanceRelation;
import com.asiainfo.boss4.domain.CrmAccount;
import com.asiainfo.boss4.domain.CrmCustomer;
import com.asiainfo.boss4.domain.CrmUser;
import com.asiainfo.boss4.domain.CrmUserOther;
import com.asiainfo.boss4.domain.IAccount;
import com.asiainfo.boss4.domain.ICustomer;
import com.asiainfo.boss4.domain.ISpromParam;
import com.asiainfo.boss4.domain.ISpromParamRb;
import com.asiainfo.boss4.domain.IUser;
import com.asiainfo.boss4.domain.IUserAll;
import com.asiainfo.boss4.domain.IUserPbx;
import com.asiainfo.boss4.domain.IUserSprom;
import com.asiainfo.boss4.domain.IUserSpromRb;
import com.asiainfo.boss4.domain.OweMonitorSpecQuota;
import com.asiainfo.boss4.domain.OweMonitorSpecQuotaH;
import com.asiainfo.boss4.domain.SmsJfMap;
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.BrandType;
import com.asiainfo.boss4.support.Constance;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.OperateType;
import com.asiainfo.boss4.support.StringHelper;
import com.asiainfo.boss4.support.UserType;
import com.asiainfo.boss4.support.annotation.AddOnly;
import com.asiainfo.boss4.support.annotation.AllowUpdateMultiRow;
import com.asiainfo.boss4.support.annotation.AllowUpdateZeroRow;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.Change;
import com.asiainfo.boss4.support.annotation.CommonDao;

/**
 * 业务流程通用dao实现
 * @author caohui, wenjiang
 *
 */
public class BusinessDaoImpl implements BusinessDao {
	private static Log logger = LogFactory.getLog(BusinessDaoImpl.class);

	protected BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	public void add(Object entity) {
		// 如果实体类配置了@Change(type = Change.Type.UPDATE)，则根据Change.PrimaryKey查找记录，如存在，则直接更新
		if (entity.getClass().isAnnotationPresent(Change.class)) {
			Change changeAnno = entity.getClass().getAnnotation(Change.class);
			if (changeAnno.type().equals(Change.Type.UPDATE)) {
				if (Change.PrimaryKey.NONE.equals(changeAnno.primaryKey())) {
					logger.error("@Change配置了UPDATE方式，则需要制定具体的PrimaryKey，不能为NONE");
					throw new BossException(StatusCode.INSIDE_ERROR);
				}
				if (this.getEntity(entity, changeAnno.primaryKey().propertyName()) != null) {
					this.change(entity, changeAnno.primaryKey().propertyName());
					return;
				}
			}
		}
		
		try {
			baseDao.insert(entity);
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

	
	public Object addToSuffix(Object originEntity, String suffix, Boolean isReversed) {
		if (suffix == null || "".endsWith(suffix)) {
			logger.error("指定后缀为空");
			throw new BossException(StatusCode.INSIDE_ERROR);
		}
		
		if (isReversed == null) isReversed = false;
		
		// 计算备份实体的类名
		String backupEntityClassName = EntityPartitionHelper.getOriginalClassForPartition(originEntity).getName();
		if (!isReversed) {
			backupEntityClassName += StringUtils.capitalize(suffix.toLowerCase());
		} else {
			backupEntityClassName = backupEntityClassName.replaceAll(StringUtils.capitalize(suffix.toLowerCase()), "");
		}
		
		Object backupEntity = BeanCopyHelper.newInstance(backupEntityClassName);
		
		// 复制数据至目标对象
		BeanCopyHelper.copyProperties(backupEntity, originEntity);
		
		// 插入目标数据
		try {
			this.baseDao.insert(backupEntity);
			return backupEntity;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List cloneToSuffix(Object entity, String[] constraints, String suffix, Boolean isReversed, Boolean allowMany, Boolean allowZero) {
		if (constraints == null || constraints.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR);
		}
		
//		this.flush();
		
		if (isReversed == null) isReversed = false;
		if (allowMany == null) allowMany = false;
		if (allowZero == null) allowZero = false;
		
		Backup.CopyToSuffix backupSuffixAnno = null;
		Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
		// 如果目标实体类配置了@Backup.CopyToSuffix(isIgnore = true)，则表示不需要进行备份，直接返回
		if (entityClass.isAnnotationPresent(Backup.CopyToSuffix.class)) {
			backupSuffixAnno = (Backup.CopyToSuffix) entityClass.getAnnotation(Backup.CopyToSuffix.class);
			if (backupSuffixAnno.isIgnore()) return null;
		}
		// suffix为空，则尝试从实体类的配置中读取备份类的后缀
		String[] suffixes = null;
		if (suffix == null || "".endsWith(suffix)) {
			logger.debug(">> suffix is null.");
			if (backupSuffixAnno != null) {
				suffixes = backupSuffixAnno.suffixes();
			} else {
				suffixes = new String[]{"rb"};
				logger.warn("备份"+entityClass.getSimpleName()+"实体时没有指定后缀，采用RB作为默认后缀");
			}
		} else {
			suffixes = new String[]{suffix};
		}
		
		
		// 查询需要备份的原数据
		List originEntitys = queryEntityList(entity, constraints);
		if (!allowMany && originEntitys.size() > 1) {
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, "查询实体"+entity.getClass().getSimpleName()+"需要备份的记录时，返回数据库记录不唯一");
		}
		if (!allowZero && originEntitys.size() == 0) {
			throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR, "查询实体"+entity.getClass().getSimpleName()+"需要备份的记录时，没有找到数据，结果为空");
		}
		
		// 向不同的后缀表做备份操作
		for (String suff : suffixes) {
			// 备份所有查询出的实体
			for (Object originEntity : originEntitys) {
				
				// 计算备份实体的类名
				String backupEntityClassName = EntityPartitionHelper.getOriginalClassForPartition(originEntity).getName();
				if (!isReversed) {
					backupEntityClassName += StringUtils.capitalize(suff.toLowerCase());
				} else {
					backupEntityClassName = backupEntityClassName.replaceAll(StringUtils.capitalize(suff.toLowerCase()), "");
				}
				
				// 构造备份的目标对象
				Object backupEntity = BeanCopyHelper.newInstance(backupEntityClassName);
				
				// 复制数据至目标对象
				BeanCopyHelper.copyProperties(backupEntity, originEntity);
				
				if (backupEntity.getClass().isAnnotationPresent(Backup.class)) {
					Backup backupAnno = backupEntity.getClass().getAnnotation(Backup.class);
					// 取原记录的soNbr
					Object originalSoNbr = BeanCopyHelper.getProperty(originEntity, backupAnno.processedField().fieldName());
					// 取本次请求的soNbr
					Object rollbackSoNbr = BeanCopyHelper.getProperty(entity, backupAnno.processedField().fieldName());
					// 备份原记录的soNbr
					BeanCopyHelper.setProperty(backupEntity, backupAnno.processedField().originalBackupName(), originalSoNbr);
					// 备份本次请求的soNbr，以便撤单之用
					BeanCopyHelper.setProperty(backupEntity, backupAnno.processedField().rollbackBackupName(), rollbackSoNbr);
				}
				StringBuffer strMessage = new StringBuffer();
				if (EntityPartitionHelper.existField(originEntity.getClass(), "servId"))
				{
					Object servId = BeanCopyHelper.getProperty(originEntity, "servId");
					if (servId != null)
						strMessage.append("servId=").append(servId.toString()).append(",");
				}
				if (EntityPartitionHelper.existField(originEntity.getClass(), "spromId"))
				{
					Object spromId = BeanCopyHelper.getProperty(originEntity, "spromId");
					if (spromId != null)
						strMessage.append("spromId=").append(spromId.toString()).append(",");
				}
				if (EntityPartitionHelper.existField(originEntity.getClass(), "soId"))
				{
					Object soId = BeanCopyHelper.getProperty(originEntity, "soId");
					if (soId != null)
						strMessage.append("soId=").append(soId.toString()).append(",");
				}
				if (EntityPartitionHelper.existField(originEntity.getClass(), "productId"))
				{
					Object productId = BeanCopyHelper.getProperty(originEntity, "productId");
					if (productId != null)
						strMessage.append("productId=").append(productId.toString()).append(",");
				}
				if (EntityPartitionHelper.existField(originEntity.getClass(), "payIndex"))
				{
					Object payIndex = BeanCopyHelper.getProperty(originEntity, "payIndex");
					if (payIndex != null)
						strMessage.append("payIndex=").append(payIndex.toString()).append(",");
				}
				strMessage.append(backupEntityClassName);
				// 插入回滚数据
				try {
					this.baseDao.insert(backupEntity);
				} catch (Exception e) {
					logger.error("数据库操作异常");
					throw new BossException(StatusCode.DB_OPERATION_ERROR,strMessage.toString()+e.getMessage()+e.getCause());
				}
			}
			
		}
		
		
		return originEntitys;
		
	}

	public Object backupCrm(Object entity,String[] constraints) {
		return cloneToSuffix(entity, constraints, "his", null, null, null).get(0);
	}
	
	public void changeCrm(Object entity, String[] constraints, String[] updateFieldNames) {
		changeCrm(entity, constraints, updateFieldNames, null, null);
	}
	
	public void changeCrm(Object entity, String[] constraints, String[] updateFieldNames, Boolean allowMany, Boolean allowZero) {
		if (constraints == null || constraints.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR);
		}
		if (updateFieldNames == null || updateFieldNames.length == 0) {
			logger.error("未配置实体更新的目标字段");
			throw new BossException(StatusCode.NO_UPDATE_DESTINATION_ERROR);
		}
		
		if (allowMany == null) allowMany = false;
		if (allowZero == null) allowZero = false;
		
		StringBuffer sb = new StringBuffer();
		sb.append("update ").append(entity.getClass().getSimpleName()).append(" set ");
		
		// 更新updateFieldNames：如果传入的postAddr为空，则把postAddr从更新字段列表中去除掉，防止非户主转户业务不更新postAddr时报错
		List<String> notNullUpdateFieldNames = new ArrayList<String>();
		for (int i = 0; i < updateFieldNames.length; i++) {
			String propName = updateFieldNames[i];
			Object obj = BeanCopyHelper.getProperty(entity, propName);
			if ("postAddr".equals(propName) && obj == null) continue;
			notNullUpdateFieldNames.add(updateFieldNames[i]);
		}
		updateFieldNames = notNullUpdateFieldNames.toArray(new String[notNullUpdateFieldNames.size()]);
		
		for (int i = 0; i < updateFieldNames.length; i++) {
			sb.append(updateFieldNames[i]).append(" = :").append(updateFieldNames[i]);
			if (i != updateFieldNames.length - 1) {
				sb.append(", ");
			} else {
				sb.append(" where ");
			}
		}
		
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

			for (int i = 0; i < updateFieldNames.length; i++) {
				String propName = updateFieldNames[i];
				
				Object obj = BeanCopyHelper.getProperty(entity, propName);
//				if (obj == null) throw new Exception("目标字段"+propName+"欲更新的值为空");

				query.setParameter(propName, obj);
			}

			for (int i = 0; i < constraints.length; i++) {
				String propName = constraints[i];
				
				if ("expireDate".equals(propName)) continue;
				
				Object obj = BeanCopyHelper.getProperty(entity, propName);
//				if (obj == null) throw new Exception("约束条件（EAI传入"+propName+"节点）为空");
				logger.warn("更新"+entity.getClass().getSimpleName()+"."+propName+"属性为空");
				
				query.setParameter(propName, obj);
			}
			
			int updatedEntities = query.executeUpdate();
			StringBuffer strMessage = new StringBuffer();
			if (EntityPartitionHelper.existField(entity.getClass(), "servId"))
			{
				Object servId = BeanCopyHelper.getProperty(entity, "servId");
				if (servId != null)
					strMessage.append("servId=").append(servId.toString()).append(",");
			}
			if (EntityPartitionHelper.existField(entity.getClass(), "spromId"))
			{
				Object spromId = BeanCopyHelper.getProperty(entity, "spromId");
				if (spromId != null)
					strMessage.append("spromId=").append(spromId.toString()).append(",");
			}
			if (EntityPartitionHelper.existField(entity.getClass(), "soId"))
			{
				Object soId = BeanCopyHelper.getProperty(entity, "soId");
				if (soId != null)
					strMessage.append("soId=").append(soId.toString()).append(",");
			}
			if (EntityPartitionHelper.existField(entity.getClass(), "productId"))
			{
				Object productId = BeanCopyHelper.getProperty(entity, "productId");
				if (productId != null)
					strMessage.append("productId=").append(productId.toString()).append(",");
			}
			if (EntityPartitionHelper.existField(entity.getClass(), "payIndex"))
			{
				Object payIndex = BeanCopyHelper.getProperty(entity, "payIndex");
				if (payIndex != null)
					strMessage.append("payIndex=").append(payIndex.toString()).append(",");
			}
			strMessage.append(entity.getClass().getName());
			if (updatedEntities == 0 && !allowZero) {
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR,strMessage.toString()+StatusCode.QUERY_ENTITY_NONE_ERROR.getDescription());
			}
			if (updatedEntities > 1 && !allowMany) {
				throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR,strMessage.toString()+StatusCode.QUERY_ENTITY_MANY_ERROR.getDescription());
			}
			
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
	}
	
	public void remove(Object entity) {
		try {
			this.baseDao.delete(entity);
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	public int remove(Object entity, String[] constraints) {
		if (constraints == null || constraints.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR);
		}
		Long soId = null;
		try{
			soId = (Long)BeanCopyHelper.getProperty(entity, "soId");
		}catch (Exception e){
			;
		}
		StringBuffer sb = new StringBuffer();
		sb.append("delete ").append(
				StringHelper.getClassName(entity.getClass())).append(" where ");
		for (int i = 0; i < constraints.length; i++) {
			String propName = constraints[i];
			if ("expireDate".equalsIgnoreCase(propName)) {
				sb.append("expireDate > sysdate and ");
			} else if ("soId".equals(propName) && soId == null)
				continue;
			else if ("soId".equals(propName) && entity instanceof com.asiainfo.boss4.domain.ISpromParam)
				sb.append("substr(").append(propName).append(",2) = :").append(propName).append(" and ");
			else if ("soId".equals(propName) && soId.longValue()<120000000000000l)
				sb.append("substr(").append(propName).append(",12) = :").append(propName).append(" and ");
			else if ("soId".equals(propName))
				sb.append("substr(").append(propName).append(",2) = :").append(propName).append(" and ");
			else {
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

				if ("soId".equals(propName) && soId == null) 
				{ 
					continue; 
				}
				else if ("soId".equals(propName) && entity instanceof com.asiainfo.boss4.domain.ISpromParam)
					query.setParameter(propName, soId.toString().substring(soId.toString().length()-14));
				else if ("soId".equals(propName) && soId.longValue()<120000000000000l)
				{
					query.setParameter(propName, soId.toString().substring(soId.toString().length()-4));
				}
				else if ("soId".equals(propName))
				{
					query.setParameter(propName, soId.toString().substring(soId.toString().length()-14));
				}
				else
					query.setParameter(propName, obj);
			}

			int updatedEntities = query.executeUpdate();
			StringBuffer strMessage = new StringBuffer();
			if (EntityPartitionHelper.existField(entity.getClass(), "servId"))
			{
				Object servId = BeanCopyHelper.getProperty(entity, "servId");
				if (servId != null)
					strMessage.append("servId=").append(servId.toString()).append(",");
			}
			if (EntityPartitionHelper.existField(entity.getClass(), "spromId"))
			{
				Object spromId = BeanCopyHelper.getProperty(entity, "spromId");
				if (spromId != null)
					strMessage.append("spromId=").append(spromId.toString()).append(",");
			}
			if (soId != null)
					strMessage.append("soId=").append(soId.toString()).append(",");
			
			if (EntityPartitionHelper.existField(entity.getClass(), "productId"))
			{
				Object productId = BeanCopyHelper.getProperty(entity, "productId");
				if (productId != null)
					strMessage.append("productId=").append(productId.toString()).append(",");
			}
			if (EntityPartitionHelper.existField(entity.getClass(), "payIndex"))
			{
				Object payIndex = BeanCopyHelper.getProperty(entity, "payIndex");
				if (payIndex != null)
					strMessage.append("payIndex=").append(payIndex.toString()).append(",");
			}
			strMessage.append(entity.getClass().getName());
			if (updatedEntities != 1) {
				logger.warn("删除实体记录 " + updatedEntities + "条，建议检查约束条件");
				if (updatedEntities == 0 && !EntityPartitionHelper.getOriginalClassForPartition(entity).isAnnotationPresent(AllowUpdateZeroRow.class) ) {
					throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR,strMessage.toString()+StatusCode.QUERY_ENTITY_NONE_ERROR.getDescription());
				}
				if (updatedEntities > 1 && !EntityPartitionHelper.getOriginalClassForPartition(entity).isAnnotationPresent(AllowUpdateMultiRow.class)) {
					throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR,strMessage.toString()+StatusCode.QUERY_ENTITY_MANY_ERROR.getDescription());
				}
			}
			
			return updatedEntities;
			
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
	}

	public void cancel(Object entity, String[] constraints) {
		if (constraints == null || constraints.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR);
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append("update ").append(entity.getClass().getSimpleName());
		sb.append(" set expireDate = :expireDate");
		
		Object soNbr = null;
		if (BeanCopyHelper.existField(entity.getClass(), "soNbr")) {
			soNbr = BeanCopyHelper.getProperty(entity, "soNbr");	
			sb.append(", soNbr = :soNbr ");
		}
		
//		Object sid = null;
//		if (BeanCopyHelper.existField(entity.getClass(), "sid") 
//				&& ! (entity instanceof com.asiainfo.boss4.domain.IUserStatus)
//				&& ! (entity instanceof com.asiainfo.boss4.domain.IAccount)
//				&& ! (entity instanceof com.asiainfo.boss4.domain.ICustomer)) {
//			sid = BeanCopyHelper.getProperty(entity, "sid");	
//			sb.append(", sid = :sid ");
//		}

		sb.append(" where ");
		Long soId = null;
		try{
			soId = (Long)BeanCopyHelper.getProperty(entity, "soId");
		}catch (Exception e){
			;
		}
		for (int i = 0; i < constraints.length; i++) {
			String propName = constraints[i];
			if ("expireDate".equalsIgnoreCase(propName)) {
				sb.append("expireDate > sysdate and expireDate > validDate and ");
			}else if ("soId".equals(propName) && soId == null)
				continue;
			else if ("soId".equals(propName) && entity instanceof com.asiainfo.boss4.domain.ISpromParam)
				sb.append("substr(").append(propName).append(",2) = :").append(propName).append(" and ");
			else if ("soId".equals(propName) && soId.longValue()<120000000000000l)
				sb.append("substr(").append(propName).append(",12) = :").append(propName).append(" and ");
			else if ("soId".equals(propName))
				sb.append("substr(").append(propName).append(",2) = :").append(propName).append(" and ");
			else {
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
				
				if ("soId".equals(propName) && soId == null) 
				{ 
					continue; 
				}
				else if ("soId".equals(propName) && entity instanceof com.asiainfo.boss4.domain.ISpromParam)
					query.setParameter(propName, soId.toString().substring(soId.toString().length()-14));
				else if ("soId".equals(propName) && soId.longValue()<120000000000000l)
				{
					query.setParameter(propName, soId.toString().substring(soId.toString().length()-4));
				}
				else if ("soId".equals(propName))
				{
					query.setParameter(propName, soId.toString().substring(soId.toString().length()-14));
				}
				else
					query.setParameter(propName, obj);
			}
			
			Object expireDate = BeanCopyHelper.getProperty(entity, "expireDate");
			
			//if (expireDate == null || soNbr == null) throw new Exception("传入的expireDate或soNbr属性为空值");
			//SO_NBR在某些表中不存在
			if (expireDate == null) throw new Exception("传入的expireDate属性为空值");
			query.setParameter("expireDate", expireDate);
			if (soNbr != null)
				query.setParameter("soNbr", soNbr);

//			if (sid != null)
//				query.setParameter("sid", sid);
			
			int updatedEntities = query.executeUpdate();
			StringBuffer strMessage = new StringBuffer();
			if (EntityPartitionHelper.existField(entity.getClass(), "servId"))
			{
				Object servId = BeanCopyHelper.getProperty(entity, "servId");
				if (servId != null)
					strMessage.append("servId=").append(servId.toString()).append(",");
			}
			if (EntityPartitionHelper.existField(entity.getClass(), "spromId"))
			{
				Object spromId = BeanCopyHelper.getProperty(entity, "spromId");
				if (spromId != null)
					strMessage.append("spromId=").append(spromId.toString()).append(",");
			}
			if (soId != null)
					strMessage.append("soId=").append(soId.toString()).append(",");
			
			if (EntityPartitionHelper.existField(entity.getClass(), "productId"))
			{
				Object productId = BeanCopyHelper.getProperty(entity, "productId");
				if (productId != null)
					strMessage.append("productId=").append(productId.toString()).append(",");
			}
			if (EntityPartitionHelper.existField(entity.getClass(), "payIndex"))
			{
				Object payIndex = BeanCopyHelper.getProperty(entity, "payIndex");
				if (payIndex != null)
					strMessage.append("payIndex=").append(payIndex.toString()).append(",");
			}
			strMessage.append(entity.getClass().getName());
			if (updatedEntities != 1) {
				logger.warn("删除实体记录 " + entity.getClass().getSimpleName() + " " + updatedEntities + "条，建议检查约束条件");
				if (updatedEntities == 0 && !EntityPartitionHelper.getOriginalClassForPartition(entity).isAnnotationPresent(AllowUpdateZeroRow.class) ) {
					throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR,strMessage.toString()+StatusCode.QUERY_ENTITY_NONE_ERROR.getDescription());
				}
				if (updatedEntities > 1 && !EntityPartitionHelper.getOriginalClassForPartition(entity).isAnnotationPresent(AllowUpdateMultiRow.class)) {
					throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR,strMessage.toString()+StatusCode.QUERY_ENTITY_MANY_ERROR.getDescription());
				}
			}
			
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
	}
	
	public void cancel(Object entity, String[] constraints, boolean isRightNow, Date currentDate) {
		Date expireDate = null;
		if (isRightNow) {
			if (currentDate == null) {
				logger.error("传入当前数据库时间currentDate为空");
				throw new BossException(StatusCode.ENTITY_BUILD_ERROR);
			}
			if (EntityPartitionHelper.existField(entity.getClass(), "expireDate")) {
				expireDate = (Date) BeanCopyHelper.getProperty(entity, "expireDate");
				// 设置数据的失效时间为当前数据库时间
				BeanCopyHelper.setProperty(entity, "expireDate", currentDate);
			}
		}
		
		this.cancel(entity, constraints);
		// 恢复entity的状态，以免继续操作时出现数据问题
		try {
			if (EntityPartitionHelper.existField(entity.getClass(), "expireDate")) {
				BeanUtils.copyProperty(entity, "expireDate", expireDate);
			}
		} catch (Exception e) {
			logger.error("无法赋值实体对象"+StringHelper.getClassName(entity.getClass())+"中的expireDate属性");
			throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
		}
	}
	
	public void change(Object entity, String[] constraints) {
		if (constraints == null || constraints.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR);
		}
		
		try {
			// 查询原数据
			Object persistentEntity = queryEntity(entity, constraints);
			// 复制新数据并保存
			BeanCopyHelper.copyBeanNotNullProperty(persistentEntity, entity);
			baseDao.update(persistentEntity);
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	public void change(Object entity, String[] constraints, String[] updateFieldNames) {
		if (constraints == null || constraints.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR);
		}
		
		try {
			// 查询原数据
			Object persistentEntity = queryEntity(entity, constraints);
			// 复制新数据并保存
			for (String updateFieldName : updateFieldNames) {
				BeanCopyHelper.setProperty(persistentEntity, updateFieldName, BeanCopyHelper.getProperty(entity, updateFieldName));
			}
//			BeanCopyHelper.copyBeanNotNullProperty(persistentEntity, entity);
			baseDao.update(persistentEntity);
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	public void changeWithMerge(Object entity, String[] constraints, String[] updateFieldNames,
			Date currentDate) {
		if (constraints == null || constraints.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR);
		}
		if (updateFieldNames == null || updateFieldNames.length == 0) {
			logger.error("未配置实体更新的目标字段");
			throw new BossException(StatusCode.NO_UPDATE_DESTINATION_ERROR);
		}
		// 如果实体类配置了@Change(type = Change.Type.UPDATE)，则直接更新记录
		if (entity.getClass().isAnnotationPresent(Change.class)
				|| EntityPartitionHelper.getOriginalClassForPartition(entity).isAnnotationPresent(Change.class)) {
			Change changeAnno = entity.getClass().getAnnotation(Change.class);
			if (changeAnno == null) {
				changeAnno = (Change) EntityPartitionHelper.getOriginalClassForPartition(entity).getAnnotation(Change.class);
			}
			if (changeAnno.type().equals(Change.Type.UPDATE)) {
				change(entity, constraints, updateFieldNames);
				return;
			}
		}
		
		try {
			flush();
			// 查询原数据
			Object origiEntity = queryEntity(entity, constraints);
			
			// 失效原数据的数据库记录
			cancel(entity, constraints, true, currentDate);
			flush();
			
			// 用EAI传入数据覆盖原数据指定的字段
			Object obj = Class.forName(origiEntity.getClass().getName()).newInstance();
			BeanCopyHelper.copyBeanNotNullProperty(obj, origiEntity);
			for (int i = 0; i < updateFieldNames.length; i++) {
				String propName = updateFieldNames[i];
				
				Object prop = null;
				try {
					prop = PropertyUtils.getProperty(entity, propName);
					if (prop == null) throw new Exception("目标字段欲更新的值为空");
				} catch (Exception e) {
					throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e, "无法取出实体对象"+entity.getClass().getSimpleName()+"中指定的属性"+propName+"的值");
				}
				
				try {
					PropertyUtils.setProperty(obj, propName, prop);
				} catch (Exception e) {
					throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, "无法将EAI传入的数据加载至实体对象"+StringHelper.getClassName(entity.getClass())+"的"+propName+"属性中");
				}
			}
			
			// 更新原数据的生效时间
			try {
				PropertyUtils.setProperty(obj, "validDate", currentDate);
			} catch (Exception e) {
				throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, "无法将EAI传入的数据加载至实体对象"+StringHelper.getClassName(entity.getClass())+"的validDate属性中");
			}
			
			// 新数据使用新生成的sid
			try {
				
				PropertyUtils.setProperty(obj, "sid", PropertyUtils.getProperty(entity, "sid"));
			} catch (Exception e) {
				logger.error("无法为实体对象"+StringHelper.getClassName(entity.getClass())+"设置sid属性");
				throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
			}
			
			// 插入更新后的原数据
			add(obj);
			flush();
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
	}
	
//	public void changeWithMerge(Object entity, String[] constraints, String[] updateFieldNames,
//			Date currentDate) {
//		if (constraints == null || constraints.length == 0) {
//			logger.error("未配置实体更新的约束条件");
//			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR);
//		}
//		if (updateFieldNames == null || updateFieldNames.length == 0) {
//			logger.error("未配置实体更新的目标字段");
//			throw new BossException(StatusCode.NO_UPDATE_DESTINATION_ERROR);
//		}
//		
//		try {
//			flush();
//			// 查询原数据
//			Object origiEntity = queryEntity(entity, constraints);
//			
////			Date expireDate = null;
////			try {
////				expireDate = (Date)PropertyUtils.getProperty(obj, "expireDate");
////				if (expireDate == null) throw new Exception("expireDate属性值为null");
////			} catch (Exception e) {
////				logger.error("取数据库中实体对象"+StringHelper.getClassName(obj.getClass())+"的expireDate属性值为null");
////				throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
////			}
//			
//			// 新数据使用新生成的sid
//			try {
//				
//				PropertyUtils.setProperty(origiEntity, "sid", PropertyUtils.getProperty(entity, "sid"));
//			} catch (Exception e) {
//				logger.error("无法为实体对象"+StringHelper.getClassName(entity.getClass())+"设置sid属性");
//				throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
//			}
//			
//			// 插入更新后的原数据
//			add(origiEntity);
//			flush();
//		} catch (BossException e) {
//			throw e;
//		} catch (Exception e) {
//			logger.error("数据库操作异常");
//			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
//		}
//		
//	}

	public void changeWithMerge(Object entity, String[] constraints, Date currentDate) {
		if (constraints == null || constraints.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR);
		}
		// 如果实体类配置了@Change(type = Change.Type.UPDATE)，则直接更新记录
		if (entity.getClass().isAnnotationPresent(Change.class)) {
			Change changeAnno = entity.getClass().getAnnotation(Change.class);
			if (changeAnno.type().equals(Change.Type.UPDATE)) {
				change(entity, constraints);
				return;
			}
		}
		
		try {
			flush();
			// 查询原数据
			Object oldObj = queryEntity(entity, constraints);
			
			// 失效原数据
			cancel(entity, constraints, true, currentDate);
			flush();
			
			// 复制新数据并保存
			Object obj = Class.forName(oldObj.getClass().getName()).newInstance();
			try {
				PropertyUtils.setProperty(entity, "validDate", currentDate);
				BeanCopyHelper.copyBeanNotNullProperty(obj, oldObj);
				BeanCopyHelper.copyBeanNotNullProperty(obj, entity);
			} catch (BossException e) {
				logger.error("无法将EAI传入的数据加载至实体对象" + entity.getClass().getSimpleName() + "的相关属性中");
				throw e;
			} catch (Exception e) {
				logger.error("无法将EAI传入的数据加载至实体对象" + entity.getClass().getSimpleName() + "的相关属性中");
				throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
			}
			add(obj);
			flush();
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
	}

	public Object getEntity(Object entity, String[] selectConditions) {
		if (selectConditions == null || selectConditions.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR,entity.getClass().getName()+StatusCode.NO_UPDATE_CONSTRAINT_ERROR.getDescription());
		}
		
		StringBuffer hql = new StringBuffer();
		hql.append("from ").append(entity.getClass().getSimpleName()).append(" where ");
		Long soId = null;
		try{
			soId = (Long)BeanCopyHelper.getProperty(entity, "soId");
		}catch (Exception e){
			;
		}
		for (int i = 0; i < selectConditions.length; i++) {
			String propName = selectConditions[i];
			if ("expireDate".equalsIgnoreCase(propName)) {
				hql.append("expireDate > sysdate and expireDate > validDate and ");
			}else if ("soId".equals(propName) && soId == null)
				continue;
			else if ("soId".equals(propName) && entity instanceof com.asiainfo.boss4.domain.ISpromParam)
				hql.append("substr(").append(propName).append(",2) = :").append(propName).append(" and ");
			else if ("soId".equals(propName) && soId.longValue()<120000000000000l)
				hql.append("substr(").append(propName).append(",12) = :").append(propName).append(" and ");
			else if ("soId".equals(propName))
				hql.append("substr(").append(propName).append(",2) = :").append(propName).append(" and ");
			else if ("expDate".equalsIgnoreCase(propName)) {
				hql.append("expDate > sysdate and expDate > effDate and ");
			}
			else if (propName != null && !propName.equals("")){
				hql.append(propName).append(" = :").append(propName).append(" and ");
			}
		}
		
		Object result = null;
		try {
			Query query = (Query) baseDao.createQuery(hql.substring(0, hql.length() - 5));
			
			for (int i = 0; i < selectConditions.length; i++) {
				String propName = selectConditions[i];
				if ("expireDate".equals(propName)) { continue; }
				if ("expDate".equalsIgnoreCase(propName)) { continue; }
				if ("soId".equals(propName) && soId == null) 
				{ 
					continue; 
				}
				else if ("soId".equals(propName) && entity instanceof com.asiainfo.boss4.domain.ISpromParam)
					query.setParameter(propName, soId.toString().substring(soId.toString().length()-14));
				else if ("soId".equals(propName) && soId.longValue()<120000000000000l)
				{
					query.setParameter(propName, soId.toString().substring(soId.toString().length()-4));
				}
				else if ("soId".equals(propName))
				{
					query.setParameter(propName, soId.toString().substring(soId.toString().length()-14));
				}
				else if (propName != null && !propName.equals(""))
					query.setParameter(propName, BeanCopyHelper.getProperty(entity, propName));
			}
			result = query.uniqueResult();

		} catch (BossException e) {
			throw e;
		} catch (NonUniqueResultException e) {
			StringBuffer strMessage = new StringBuffer();
			if (EntityPartitionHelper.existField(entity.getClass(), "servId"))
			{
				Object servId = BeanCopyHelper.getProperty(entity, "servId");
				if (servId != null)
					strMessage.append("servId=").append(servId.toString()).append(",");
			}
			if (EntityPartitionHelper.existField(entity.getClass(), "spromId"))
			{
				Object spromId = BeanCopyHelper.getProperty(entity, "spromId");
				if (spromId != null)
					strMessage.append("spromId=").append(spromId.toString()).append(",");
			}
			if (soId != null)
					strMessage.append("soId=").append(soId.toString()).append(",");
			
			if (EntityPartitionHelper.existField(entity.getClass(), "productId"))
			{
				Object productId = BeanCopyHelper.getProperty(entity, "productId");
				if (productId != null)
					strMessage.append("productId=").append(productId.toString()).append(",");
			}
			if (EntityPartitionHelper.existField(entity.getClass(), "payIndex"))
			{
				Object payIndex = BeanCopyHelper.getProperty(entity, "payIndex");
				if (payIndex != null)
					strMessage.append("payIndex=").append(payIndex.toString()).append(",");
			}
			logger.error("数据库操作异常:"+hql.toString());
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, strMessage.toString()+StatusCode.QUERY_ENTITY_MANY_ERROR.getDescription()+entity.toString());
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return result;
	}
	
	public Object getEntityByCond(Object entity, String[] selectConditions,String selectCondition) {
		if (selectConditions == null || selectConditions.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR,entity.getClass().getName()+StatusCode.NO_UPDATE_CONSTRAINT_ERROR.getDescription());
		}
		
		StringBuffer hql = new StringBuffer();
		hql.append("from ").append(entity.getClass().getSimpleName()).append(" where ");
		Long soId = null;
		try{
			soId = (Long)BeanCopyHelper.getProperty(entity, "soId");
		}catch (Exception e){
			;
		}
		for (int i = 0; i < selectConditions.length; i++) {
			String propName = selectConditions[i];
			if ("expireDate".equalsIgnoreCase(propName)) {
				hql.append("expireDate > sysdate and expireDate > validDate and ");
			}else if ("soId".equals(propName) && soId == null)
				continue;
			else if ("soId".equals(propName) && entity instanceof com.asiainfo.boss4.domain.ISpromParam)
				hql.append("substr(").append(propName).append(",2) = :").append(propName).append(" and ");
			else if ("soId".equals(propName) && soId.longValue()<120000000000000l)
				hql.append("substr(").append(propName).append(",12) = :").append(propName).append(" and ");
			else if ("soId".equals(propName))
				hql.append("substr(").append(propName).append(",2) = :").append(propName).append(" and ");
			else if ("expDate".equalsIgnoreCase(propName)) {
				hql.append("expDate > sysdate and expDate > effDate and ");
			}
			else if (propName != null && !propName.equals("")){
				hql.append(propName).append(" = :").append(propName).append(" and ");
			}
		}
		
		if (selectCondition != null && !"".equalsIgnoreCase(selectCondition)) {
		     hql.append(selectCondition).append(" and ");
		}
		
		Object result = null;
		try {
			Query query = (Query) baseDao.createQuery(hql.substring(0, hql.length() - 5));
			
			for (int i = 0; i < selectConditions.length; i++) {
				String propName = selectConditions[i];
				if ("expireDate".equals(propName)) { continue; }
				if ("expDate".equalsIgnoreCase(propName)) { continue; }
				if ("soId".equals(propName) && soId == null) 
				{ 
					continue; 
				}
				else if ("soId".equals(propName) && entity instanceof com.asiainfo.boss4.domain.ISpromParam)
					query.setParameter(propName, soId.toString().substring(soId.toString().length()-14));
				else if ("soId".equals(propName) && soId.longValue()<120000000000000l)
				{
					query.setParameter(propName, soId.toString().substring(soId.toString().length()-4));
				}
				else if ("soId".equals(propName))
				{
					query.setParameter(propName, soId.toString().substring(soId.toString().length()-14));
				}
				else if (propName != null && !propName.equals(""))
					query.setParameter(propName, BeanCopyHelper.getProperty(entity, propName));
			}
			result = query.uniqueResult();

		} catch (BossException e) {
			throw e;
		} catch (NonUniqueResultException e) {
			StringBuffer strMessage = new StringBuffer();
			if (EntityPartitionHelper.existField(entity.getClass(), "servId"))
			{
				Object servId = BeanCopyHelper.getProperty(entity, "servId");
				if (servId != null)
					strMessage.append("servId=").append(servId.toString()).append(",");
			}
			if (EntityPartitionHelper.existField(entity.getClass(), "spromId"))
			{
				Object spromId = BeanCopyHelper.getProperty(entity, "spromId");
				if (spromId != null)
					strMessage.append("spromId=").append(spromId.toString()).append(",");
			}
			if (soId != null)
					strMessage.append("soId=").append(soId.toString()).append(",");
			
			if (EntityPartitionHelper.existField(entity.getClass(), "productId"))
			{
				Object productId = BeanCopyHelper.getProperty(entity, "productId");
				if (productId != null)
					strMessage.append("productId=").append(productId.toString()).append(",");
			}
			if (EntityPartitionHelper.existField(entity.getClass(), "payIndex"))
			{
				Object payIndex = BeanCopyHelper.getProperty(entity, "payIndex");
				if (payIndex != null)
					strMessage.append("payIndex=").append(payIndex.toString()).append(",");
			}
			logger.error("数据库操作异常:"+hql.toString());
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, strMessage.toString()+StatusCode.QUERY_ENTITY_MANY_ERROR.getDescription()+entity.toString());
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return result;
	}
	
	public Object queryEntity(Object entity, String[] constraints) {
		Object result = getEntity(entity, constraints);
		
		if (result == null) {
			StringBuffer strMessage = new StringBuffer();
			if (EntityPartitionHelper.existField(entity.getClass(), "servId"))
			{
				Object servId = BeanCopyHelper.getProperty(entity, "servId");
				if (servId != null)
					strMessage.append("servId=").append(servId.toString()).append(",");
			}
			if (EntityPartitionHelper.existField(entity.getClass(), "spromId"))
			{
				Object spromId = BeanCopyHelper.getProperty(entity, "spromId");
				if (spromId != null)
					strMessage.append("spromId=").append(spromId.toString()).append(",");
			}
			if (EntityPartitionHelper.existField(entity.getClass(), "soId"))
			{
				Object soId = BeanCopyHelper.getProperty(entity, "soId");
				if (soId != null)
					strMessage.append("soId=").append(soId.toString()).append(",");
			}
			if (EntityPartitionHelper.existField(entity.getClass(), "productId"))
			{
				Object productId = BeanCopyHelper.getProperty(entity, "productId");
				if (productId != null)
					strMessage.append("productId=").append(productId.toString()).append(",");
			}
			if (EntityPartitionHelper.existField(entity.getClass(), "payIndex"))
			{
				Object payIndex = BeanCopyHelper.getProperty(entity, "payIndex");
				if (payIndex != null)
					strMessage.append("payIndex=").append(payIndex.toString()).append(",");
			}
			strMessage.append(entity.getClass().getName());
			throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR, strMessage.toString()+"The entity does not exist. "+entity.toString());
		}
		
		return result;
	}
	
	public List queryEntityList(Object entity, String[] constraints){
		if (constraints == null || constraints.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR,entity.getClass().getName()+StatusCode.NO_UPDATE_CONSTRAINT_ERROR.getDescription());
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
		
		List result = null;
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
			result = query.list();

		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return result;
	}

	public Date queryCurrentDate() {
		String date = null;
		try {
			date = (String)baseDao.createSQLQuery("select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') from dual").uniqueResult();
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return DateHelper.String2Date(date, "yyyy-MM-dd HH:mm:ss");
	}
	
	public Long querySid() {
		String sql = "select ZG.SID.NEXTVAL as sid from dual";
		try {
			return (Long) baseDao.getSess().createSQLQuery(sql).addScalar("sid", Hibernate.LONG).uniqueResult();
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	public void flush() {
		try {
			baseDao.getSess().flush();
			//baseDao.getSess().clear();
			logger.debug("flush operation of SQL");
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	public void flushAndClear() {
		try {
			baseDao.getSess().flush();
			baseDao.getSess().clear();
			logger.debug("flush operation of SQL, then clear all cached entities in the session"); 
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

	public void backup(Object entity, String[] constraints) {
		cloneToSuffix(entity, constraints, "rb", null, null, null);
	}

	public void backup(Object entity, String[] constraints, String suffix, boolean isAppendSuffix) {
		cloneToSuffix(entity, constraints, suffix, !isAppendSuffix, null, null);
	}
	
	public void backupMany(Object entity, String[] constraints, String suffix) {
		cloneToSuffix(entity, constraints, suffix, null, true, null);
	}
	
	public void backupAutoSuffix(Object entity, String[] constraints) {
		cloneToSuffix(entity, constraints, null, null, true, true);
	}

	public void backup(Object entity, String[] constraints, String suffix) {
		backup(entity, constraints, suffix, true);
	}
	
	@SuppressWarnings("unchecked")
	public Object rollback(Object entity) {
//		// 如果entity类型为IUserUnion，直接返回null。等操作IUser时，同时操作IUserUnion
//		if (IUserUnion.class.equals(entity.getClass())) return null;
		
		// 取需要回滚处理的soNbr
		Object rollbackSoNbr = BeanCopyHelper.getProperty(entity, "soNbr");
		
		// 取被回滚的数据(原表数据)
		String hql = new StringBuffer("from ")
			.append(entity.getClass().getSimpleName())
			.append(" where soNbr =").append(rollbackSoNbr)
			.toString();
		List originList = baseDao.createQuery(hql).list();
		
		// 取用来回滚的数据(回滚表数据)
		hql = new StringBuffer("from ")
			.append(EntityPartitionHelper.getOriginalClassForPartitionWithSuffix(entity, "Rb").getSimpleName())
			.append(" where rollbackSoNbr =").append(rollbackSoNbr)
			.toString();
		List rollbackList = baseDao.createQuery(hql).list();
		
//		// 若entity为IUser，则同时取出IUserUnion记录，以备撤单
//		Object origIUserUnion = null;
//		if (IUser.class.equals(EntityPartitionHelper.getOriginalClassForPartition(entity))) {
//			hql = new StringBuffer("from ")
//			.append(EntityPartitionHelper.getOriginalClassForPartitionWithSuffix(entity, "union").getSimpleName())
//			.append(" where soNbr =").append(rollbackSoNbr)
//			.toString();
//			try {
//				origIUserUnion = baseDao.createQuery(hql).uniqueResult();
//				if (origIUserUnion == null) {
//					logger.error("指定的IUserUnoin对象不存在");
//					throw new BossException(StatusCode.QUERY_ENTITY_ERROR);
//				}
//			} catch (BossException e) {
//				throw e;
//			} catch (NonUniqueResultException e) {
//				logger.error("返回数据库记录不唯一");
//				throw new BossException(StatusCode.QUERY_ENTITY_ERROR, e);
//			} catch (Exception e) {
//				logger.error("数据库操作异常");
//				throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
//			}
//		}
		
		if (originList.size() == 1 && rollbackList.size() == 0) {// 新增的撤单
			Object origObj = originList.get(0);
			
			Date validDate = (Date) BeanCopyHelper.getProperty(origObj, "validDate");
			// 置失效时间为生效时间
			BeanCopyHelper.setProperty(origObj, "expireDate", validDate);
			
			try {
				this.baseDao.update(origObj);
//				// IUserUnion撤单
//				if (IUser.class.equals(EntityPartitionHelper.getOriginalClassForPartition(entity))) {
//					baseDao.delete(origIUserUnion);
//				}
				
				return origObj;
			} catch (Exception e) {
				logger.error("数据库操作异常");
				throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
			}
			
		} else if (originList.size() == 1 && rollbackList.size() == 1) {// 取消的撤单
			Object origObj = originList.get(0);
			Object rbObj = rollbackList.get(0);
			Object newObj;
			
			try {
				newObj = Class.forName(entity.getClass().getName()).newInstance();
				PropertyUtils.copyProperties(newObj, rbObj);
			} catch (Exception e) {
				throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
			}
			
			try {
				this.baseDao.delete(origObj);
				this.baseDao.insert(newObj);
				this.baseDao.delete(rbObj);
//				// IUserUnion撤单
//				if (IUser.class.equals(EntityPartitionHelper.getOriginalClassForPartition(entity))) {
//					BeanCopyHelper.copyProperties(origIUserUnion, rbObj);
//					this.baseDao.update(origIUserUnion);
//				}
				
				return newObj;
			} catch (Exception e) {
				logger.error("数据库操作异常");
				throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
			}
			
		} else if (originList.size() == 2 && rollbackList.size() == 1) {// 变更的撤单
			
			Object origObj1 = originList.get(0);
			Object origObj2 = originList.get(1);
			Object rbObj = rollbackList.get(0);
			Object newObj;
			
			try {
				newObj = Class.forName(entity.getClass().getName()).newInstance();
				PropertyUtils.copyProperties(newObj, rbObj);
			} catch (Exception e) {
				throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
			}
			
			try {
				this.baseDao.delete(origObj1);
				this.baseDao.delete(origObj2);
				this.baseDao.insert(newObj);
				this.baseDao.delete(rbObj);
//				// IUserUnion撤单
//				if (IUser.class.equals(EntityPartitionHelper.getOriginalClassForPartition(entity))) {
//					BeanCopyHelper.copyProperties(origIUserUnion, rbObj);
//					this.baseDao.update(origIUserUnion);
//				}
				
				return newObj;
			} catch (Exception e) {
				logger.error("数据库操作异常");
				throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
			}
			
		} else if (originList.size() == 0 && rollbackList.size() == 1) {// 删除的撤单
			Object rbObj = rollbackList.get(0);
			Object newObj;
			
			try {
				newObj = Class.forName(entity.getClass().getName()).newInstance();
				PropertyUtils.copyProperties(newObj, rbObj);
			} catch (Exception e) {
				throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
			}
			
			try {
				this.baseDao.insert(newObj);
				this.baseDao.delete(rbObj);
				
				return newObj;
			} catch (Exception e) {
				logger.error("数据库操作异常");
				throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
			}
		} else {
			logger.error("无法判断撤单的类型，请检查数据");
			throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
		}
		
	}
	
	/**
	 * 构造备份表的实体对象
	 * 如果无需备份则返回null
	 * @param originEntity
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Object createBackupEntityInstance(Object originEntity) {
		Backup.CopyToSuffix backupSuffixAnno = null;
		// 如果目标实体类配置了@Backup.CopyToSuffix(isIgnore = true)，则表示不需要进行备份，直接返回
		Class originClass = EntityPartitionHelper.getOriginalClassForPartition(originEntity);
		
		if (originClass.isAnnotationPresent(Backup.CopyToSuffix.class)) {
			backupSuffixAnno = (Backup.CopyToSuffix) originClass.getAnnotation(Backup.CopyToSuffix.class);
			if (backupSuffixAnno == null || backupSuffixAnno.isIgnore()) {
				logger.warn(originClass+"没有配置注释@Backup.CopyToSuffix");
				return null;
			}
		} else {
			throw new BossException(StatusCode.INSIDE_ERROR, originClass.getSimpleName()+"实体的备份配置没有指定后缀，无法回滚");
		}
		
		String suffix = backupSuffixAnno.suffixes()[0];
		
		// 计算备份实体的类名
		String backupEntityClassName = originClass.getName() + StringUtils.capitalize(suffix.toLowerCase());

		
		// 构造备份的目标对象
		return BeanCopyHelper.newInstance(backupEntityClassName);
	}
	
	public List<Object> rollbackCancel(Object entity, boolean deleteOriginalEntity) {
		return rollbackCancel(entity, deleteOriginalEntity, new String[]{});
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> rollbackCancel(Object entity, boolean deleteOriginalEntity, String[] additionRequirement) {
		// 构造备份表的实体对象
		Object backup = createBackupEntityInstance(entity);
		if (backup == null || !backup.getClass().isAnnotationPresent(Backup.class)) {
			return null;
		}
		
		
		
		if (deleteOriginalEntity) {
			// 删除原表需要撤单的数据
			this.remove(entity, (String[]) ArrayUtils.add(additionRequirement, "soNbr"));
		}
		
		// 查询备份表记录需要恢复的原始记录
		Backup backupAnno = backup.getClass().getAnnotation(Backup.class);
		String rollbackSoNbrName = backupAnno.processedField().rollbackBackupName();
		BeanCopyHelper.copyProperties(backup, entity);
		BeanCopyHelper.setProperty(backup, rollbackSoNbrName, BeanCopyHelper.getProperty(entity, "soNbr"));
		List<Object> backupEntities = (List<Object>) this.queryEntityList(backup, (String[]) ArrayUtils.add(additionRequirement, rollbackSoNbrName));
		
		// 恢复原表记录原始记录
		for (Object backupEntity : backupEntities) {
			//构造原表实体，放入回滚数据
			Object addRollback = BeanCopyHelper.newInstance(entity.getClass());
			BeanCopyHelper.copyProperties(addRollback, backupEntity);
			// 取备份表记录的原始soNbr
			Object originalSoNbr = BeanCopyHelper.getProperty(backupEntity, backupAnno.processedField().originalBackupName());
			// 恢复原表记录为原始soNbr
			BeanCopyHelper.setProperty(addRollback, backupAnno.processedField().fieldName(), originalSoNbr);
			baseDao.insert(addRollback);
		}
		
		//删除备份表数据
		this.remove(backup, new String[]{rollbackSoNbrName});
		
		return backupEntities;
	}
	
	public List rollbackMuti(Object entity) {
		
		// 取需要回滚处理的soNbr
		Object rollbackSoNbr = BeanCopyHelper.getProperty(entity, "soNbr");
		
		Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
		
		// 取被回滚的数据(原表数据)
		StringBuffer hql = new StringBuffer("from ")
			.append(StringHelper.getClassName(entity.getClass()))
			.append(" where soNbr =").append(rollbackSoNbr);
		if (IUserSprom.class.equals(entityClass)) {
			hql.append(" order by soId,validDate");
		}
		else if (ISpromParam.class.equals(entityClass)) {
			hql.append(" order by keyId,soId,validDate");
		}
		List originList = baseDao.createQuery(hql.toString()).list();
		
		// 取用来回滚的数据(回滚表数据)
		hql = new StringBuffer("from ")
		.append(EntityPartitionHelper.getOriginalClassForPartitionWithSuffix(entity, "Rb").getSimpleName())
			.append(" where rollbackSoNbr =").append(rollbackSoNbr);
		if (IUserSprom.class.equals(entityClass)) {
			hql.append(" order by soId,validDate");
		}
		else if (ISpromParam.class.equals(entityClass)) {
			hql.append(" order by keyId,soId,validDate");
		}
		List rollbackList = baseDao.createQuery(hql.toString()).list();
		
		List<Object> objList = new ArrayList<Object>();
		if (originList.size() == rollbackList.size() && originList.size()>0) {//取消的撤单
			
			for (int i = 0; i < originList.size(); i++) {
				
				Object origObj = originList.get(i);
				Object rbObj = rollbackList.get(i);
				Object newObj;
				
				try {
					newObj = Class.forName(entity.getClass().getName()).newInstance();
				} catch (Exception e) {
					logger.error("构造对象实例失败："+entity.getClass().getSimpleName());
					throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
				}
				
				BeanCopyHelper.copyProperties(newObj, rbObj);
				
				try {
					this.baseDao.delete(origObj);
					this.baseDao.insert(newObj);
					this.baseDao.delete(rbObj);
					
				} catch (Exception e) {
					logger.error("数据库操作异常");
					throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
				}
				objList.add(newObj);
			}
		}
		else if (originList.size()>0 && rollbackList.size()==0) {//新增的撤单
			for (int i = 0; i < originList.size(); i++) {
				
				Object origObj = originList.get(i);
				
				BeanCopyHelper.setProperty(origObj, "expireDate", BeanCopyHelper.getProperty(origObj, "validDate"));//置失效时间为生效时间
				
				try {
					baseDao.update(origObj);
				} catch (Exception e) {
					logger.error("数据库操作异常");
					throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
				}
				objList.add(origObj);
			}
		}
		else if (originList.size()==0 & rollbackList.size()==0) {//销户的撤单，可能没有更新记录
			return objList;
		}
		else {
			logger.error("无法判断撤单的类型，请检查数据");
			throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
		}
		return objList;
	}

	public IUser queryIUserByPhoneNumber(String phoneNumber) {
//		String hql = "from IUserUnion user where user.msisdn = :msisdn and user.expireDate > sysdate";
//		IUser user = null;
//		try {
//			user = (IUser) baseDao.createQuery(hql).setParameter("msisdn", phoneNumber).uniqueResult();
//			
//		} catch (NonUniqueResultException e) {
//			logger.error("手机号码对应的用户不唯一，请检查i_user表");
//			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e);
//		} catch (Exception e) {
//			logger.error("数据库操作异常");
//			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
//		}
//		return user;
		return queryIUserAllByPhoneNumber(phoneNumber);
	}

	public CrmUser queryCrmUserByPhoneNumber(String phoneNumber) {
		//神州行下移后，crm_user和i_user_all的用户记录应该一致，由于开户时数据是在hibernate里，尚未提交，因此无法直接从视图中获得。
		//用户查询改为在crm_user中查
		//List list = baseDao.getListForHibernate("from CrmUser t where t.phoneId = '15801266474' ");
		String sql = "from CrmUser t where t.phoneId = :phoneNumber ";
		/*Query query = baseDao.getSess().createQuery(sql);
		query.setString("phoneNumber", phoneNumber);
		query.setCacheable(true);
		query.setReadOnly(true);*/
		try {
			return (CrmUser) baseDao.getSess().createQuery(sql).setString("phoneNumber", phoneNumber).uniqueResult();
		} catch (NonUniqueResultException e) {
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e, "手机号"+phoneNumber+"对应的用户不唯一，请检查zg.Crm_User");
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	public IUser queryIUserAllByPhoneNumber(String phoneNumber) {
		String sql = "select * from inter.i_user_all t where t.msisdn = :phoneNumber and t.user_type in (1, 201) and t.expire_date > sysdate and t.expire_date > valid_date";
		try {
			return (IUser) baseDao.createSQLQuery(sql).addEntity(IUserAll.class).setString("phoneNumber", phoneNumber).uniqueResult();
		} catch (NonUniqueResultException e) {
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e, "手机号"+phoneNumber+"对应的用户不唯一，请检查inter.i_user_all视图");
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

	public IUser queryIUserByServId(Long servId) {
		if (servId == null) {
			throw new BossException(StatusCode.INSIDE_ERROR, "参数servId为空");
		}
		
		String sql = "select * from inter.i_user_all t where t.serv_id = :servId and t.user_type in (1, 201) and t.expire_date > sysdate and t.expire_date > valid_date";
		try {
			return (IUser) baseDao.createSQLQuery(sql).addEntity(IUserAll.class).setLong("servId", servId).uniqueResult();
		} catch (NonUniqueResultException e) {
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e, "serv_id"+servId+"对应的用户不唯一，请检查inter.i_user_all视图");
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

	public IUser existedIUser(String servId, String userType) {
		IUser entity = new IUser();
		entity.setServId(new Long(servId));
		
		StringBuffer hql = new StringBuffer("from ").append(EntityPartitionHelper.getClassForPartition(entity).getSimpleName())
								.append(" user where user.servId = :servId and user.userType = :userType and user.expireDate > sysdate");
		try {
			return (IUser) baseDao.createQuery(hql.toString())
									.setParameter("servId", new Long(servId))
									.setParameter("userType", UserType.parseShort(userType))
									.uniqueResult();

		} catch (NonUniqueResultException e) {
			logger.error("servId对应的用户不唯一，请检查i_user表，servId:"+servId+", userType:"+userType);
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e);
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	public boolean isExistIUser(String servId) {
		
		try {
			Object result = queryIUserByServId(new Long(servId));
			if (result != null) {
				return true;
			} else {
				return false;
			}
		} catch (NonUniqueResultException e) {
			logger.error("返回数据不唯一");
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e);
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

	@SuppressWarnings("unchecked")
	@Deprecated
	public EnumSet<BrandType> queryBrand(String paramName, String paramValue) {
		if (!paramName.equals("servId") && !paramName.equals("custId") && !paramName.equals("acctId")) {
			logger.error("无效的paramName参数");
			throw new BossException(StatusCode.INSIDE_ERROR);
		}
		
		StringBuffer hql = new StringBuffer("from IUserAll u where u.")
							.append(paramName).append(" = :").append(paramName);
		
		List<IUser> users = null;
		try {
			users = baseDao.createQuery(hql.toString()).setParameter(paramName, new Long(paramValue)).list();
			if (users.size() == 0) {
				logger.error("用户不存在");
				throw new BossException(StatusCode.NOT_EXIST_USER_ERROR);
			}
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
		EnumSet<BrandType> brands = EnumSet.noneOf(BrandType.class);
		for (IUser user : users) {
			Integer barnd = user.getBrand();
			if (barnd == null) {
				logger.error("用户品牌信息为空");
				throw new BossException(StatusCode.ENTITY_PARSE_ERROR);
			}
			brands.add(BrandType.getBrandType(barnd.intValue()));
		}
		
		return brands;
	}

	public void changeWithMergeCrm(Object entity, String[] constraints,
			Date currentDate) {
		if (constraints == null || constraints.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR);
		}
		try {
			// 备份原数据
			backupCrm(entity, constraints);
			// 查询原数据
			Object persistentEntity = queryEntity(entity, constraints);
			// 复制新数据并保存
			BeanCopyHelper.copyBeanNotNullProperty(persistentEntity, entity);
			baseDao.update(persistentEntity);
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
	}

	public ICustomer queryICustomerByCustId(Long custId) {
		if (custId == null) {
			logger.error("参数custId为空");
			throw new BossException(StatusCode.INSIDE_ERROR);
		}
		
		ICustomer cust = null;
		try {
			cust = (ICustomer) baseDao.createQuery("from ICustomer c where c.custId = :custId and c.expireDate > sysdate")
						.setParameter("custId", custId)
						.uniqueResult();
		} catch (NonUniqueResultException e) {
			logger.error("客户不唯一");
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e);
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
		return cust;
	}

	public void move(Object entity, String[] constraints, String suffix) {
		backup(entity, constraints, suffix);
		remove(entity, constraints);
	}
	
	public IAccount queryIAccountByAcctId(Long acctId) {
		if (acctId == null) {
			logger.error("参数acctId为空");
			throw new BossException(StatusCode.INSIDE_ERROR);
		}
		
		IAccount acct = null;
		try {
			acct = (IAccount) baseDao.createQuery("from IAccount a where a.acctId = :acctId and a.expireDate > sysdate")
						.setParameter("acctId", acctId).uniqueResult();
		} catch (NonUniqueResultException e) {
			logger.error("账户不唯一");
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e);
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
		return acct;
	}

	public CrmAccount queryCrmAccountByAcctId(Long acctId) {
		if (acctId == null) {
			logger.error("参数acctId为空");
			throw new BossException(StatusCode.INSIDE_ERROR);
		}
		
		CrmAccount acct = null;
		try {
			acct = (CrmAccount) baseDao.createQuery("from CrmAccount a where a.acctId = :acctId")
						.setParameter("acctId", acctId).uniqueResult();
		} catch (NonUniqueResultException e) {
			logger.error("账户不唯一");
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e);
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
		return acct;
	}

	public CrmCustomer queryCrmCustomerByCustId(Long custId) {
		if (custId == null) {
			logger.error("参数custId为空");
			throw new BossException(StatusCode.INSIDE_ERROR);
		}
		
		CrmCustomer cust = null;
		try {
			cust = (CrmCustomer) baseDao.createQuery("from CrmCustomer c where c.custId = :custId and c.expireDate > sysdate")
						.setParameter("custId", custId)
						.uniqueResult();
		} catch (NonUniqueResultException e) {
			logger.error("客户不唯一");
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e);
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
		return cust;
	}

	public CrmUser queryCrmUserByServId(Long servId) {
		if (servId == null) {
			logger.error("参数servId为空");
			throw new BossException(StatusCode.INSIDE_ERROR);
		}
		
		CrmUser user = null;
		try {
			user = (CrmUser) baseDao.createQuery("from CrmUser u where u.servId = :servId and u.expireDate > sysdate")
						.setParameter("servId", servId).uniqueResult();
			
		} catch (NonUniqueResultException e) {
			logger.error("用户不唯一");
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e);
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return user;
	}
	
	public CrmUser queryGroupCrmUserByPhoneId(String phoneId) {
		if (phoneId == null || phoneId.trim().equals("")) {
			throw new BossException(StatusCode.INSIDE_ERROR, "The param 'phoneId' is null.");
		}
		
		CrmUser user = null;
		try {
			user = (CrmUser) baseDao.createQuery("from CrmUser u where u.phoneId = :phoneId and u.userType = :userType")
						.setString("phoneId", phoneId)
						.setShort("userType", (short) 201).uniqueResult();
			
		} catch (NonUniqueResultException e) {
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e, "用户不唯一");
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return user;
	}
	
	public CrmUserOther queryCrmUserOtherByServId(Long servId) {
		if (servId == null) {
			logger.error("参数servId为空");
			throw new BossException(StatusCode.INSIDE_ERROR);
		}
		
		CrmUserOther user = null;
		try {
			user = (CrmUserOther) baseDao.createQuery("from CrmUserOther u where u.servId = :servId and u.expireDate > sysdate")
						.setParameter("servId", servId).uniqueResult();
			
		} catch (NonUniqueResultException e) {
			logger.error("用户不唯一");
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e);
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<CrmUser> queryCrmUsersByAcctId(Long acctId) {
		if (acctId == null) {
			logger.error("参数servId为空");
			throw new BossException(StatusCode.INSIDE_ERROR);
		}
		
		List<CrmUser> users = null;
		try {
			users = (List<CrmUser>) baseDao.createQuery("from CrmUser u where u.acctId = :acctId and u.expireDate > sysdate")
					.setParameter("acctId", acctId).list();
			
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return users;
	}
	
	public void update(Object entity) {
		try {
			this.baseDao.update(entity);
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	public Long getSoidSequence() {
		String sql = "select INTER.SOID_SEQUENCE.NEXTVAL from dual";
		Long result = null;
		try {
			result = ((BigDecimal) baseDao.getSess().createSQLQuery(sql).uniqueResult()).longValue();
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return result;
	}
	
	public Long getZgSoNbr(Date soDate) {
		//获取soDate年份
		String soDateYear=DateHelper.Date2String(soDate, "yyyy");
		//获取soDate月份
		String soDateMonth=DateHelper.Date2String(soDate, "MM");
		
		//获取帐管配置
		String SoBasesql = "select param_value from xg.sys_para where param_code='SO_NBR_MONTH_BASE'";
		Long paramValue = null;
		try{
			paramValue=((Long)baseDao.getSess().createSQLQuery(SoBasesql).addScalar("param_value",Hibernate.LONG).uniqueResult()).longValue();
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
		StringBuffer seq=new StringBuffer();
		seq.append("select zk.seq_so_nbr_").append(soDateYear).append(".nextval from dual");
		Long seqSoNbr = null;
		try {
			seqSoNbr = ((BigDecimal) baseDao.getSess().createSQLQuery(seq.toString()).uniqueResult()).longValue();
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
		Long zgSoNbr = (paramValue * 10000 + Long.valueOf(soDateYear) % 100 * 100 + Long.valueOf(soDateMonth)) * 10000000000L + seqSoNbr; 
		return zgSoNbr;
	}
	
	public Long getLableidSequence() {
		String sql = "select INTER.LABELID_SEQUENCE.NEXTVAL from dual";
		Long result = null;
		try {
			result = ((BigDecimal) baseDao.getSess().createSQLQuery(sql).uniqueResult()).longValue();
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return result;
	}
	
	public Object commonAdd(BaseEntity entity) {
		Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
		
		if (entityClass.isAnnotationPresent(AddOnly.class)) {
			add(entity);
			return entity;
		}
		
		CommonDao cd = (CommonDao) entity.getAnnotation(entityClass, CommonDao.class);
		if (cd.fieldOfSelectConditions() == null) {
			throw new BossException(StatusCode.INSIDE_ERROR,
					"The @CommonDao(fieldOfSelectConditions) does not annotate on class "
							+ entity.getClass().getSimpleName());
		}
		
		Object entityExisted = getEntity(entity, cd.fieldOfSelectConditions());
		if (entityExisted != null) {
			if (!cd.isOverwriteWhenAdd()) {
				if (!cd.isAlertWhenExist())
				{
//					add(entity);
					return entityExisted;
				}
				else
					throw new BossException(StatusCode.QUERY_ENTITY_EXISTED_ERROR,
							"The  "+ entity.getClass().getSimpleName()+" already exist!");
			} else {
				commonModify(entity);
				return entity;
			}
		} else {
				if (entity instanceof com.asiainfo.boss4.domain.IGroupMember
						|| entity instanceof com.asiainfo.boss4.domain.IFreeResRule
						|| entity instanceof com.asiainfo.boss4.domain.CrmGroupMember
						|| entity instanceof com.asiainfo.boss4.domain.IUserPayRelation
						|| entity instanceof com.asiainfo.boss4.domain.IFreeResRule
						|| entity instanceof com.asiainfo.boss4.domain.CrmUserSmsOrder
						|| entity instanceof com.asiainfo.boss4.domain.IUserEnterprise
						|| entity instanceof com.asiainfo.boss4.domain.IUserPbx )
				{
					String[] selectEntityConditions = new String[cd.fieldOfSelectConditions().length];
					for (int i=0;i<cd.fieldOfSelectConditions().length;i++)
					{
						String condition = cd.fieldOfSelectConditions()[i];
						if (condition.equalsIgnoreCase("expDate"))
							selectEntityConditions[i] = "effDate";
						else if (condition.equalsIgnoreCase("expireDate"))
							selectEntityConditions[i] = "validDate";
						else if (condition.equalsIgnoreCase("sid"))
							continue;
						else
							selectEntityConditions[i] =condition; 
					}
					entityExisted = getEntity(entity, selectEntityConditions);
					if (entityExisted != null)
					{
						BeanCopyHelper.copyBeanNotNullPropertyCrm(entityExisted, entity);
						baseDao.update(entityExisted);
					}
					else
						add(entity);
				}
				else
					add(entity);

			return entity;
		}
	}

	public Object commonCancel(BaseEntity entity) {
		String[] fieldOfSelectConditions = entity.getFieldOfSelectConditionsOnCommonDaoAnnotation();
		CommonDao.DataStoreMode dataStoreMode = entity.getDataStoreModeOnCommonDaoAnnotation();
		
//		if (cd.isAlertWhenNotExist())
//		{	
//			Object entityExisted = getEntity(entity, fieldOfSelectConditions);
//			if (entityExisted==null)
//				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR,
//					"The  "+ entity.getClass().getSimpleName()+" isn't found!");
//		}
		
		if (CommonDao.DataStoreMode.INSERT_AFTER_UPDATE.equals(dataStoreMode)) {
//			if (entityExisted != null)
//			{
//				Date validDate = null;
//				Date expireDate = null;
//				if (EntityPartitionHelper.existField(entity.getClass(), "validDate"))
//					validDate = (Date)BeanCopyHelper.getProperty(entity, "validDate");
//				else if (EntityPartitionHelper.existField(entity.getClass(), "effDate"))
//					validDate = (Date)BeanCopyHelper.getProperty(entity, "effDate");
//				if (EntityPartitionHelper.existField(entity.getClass(), "expireDate"))
//					expireDate = (Date)BeanCopyHelper.getProperty(entity, "expireDate");
//				else if (EntityPartitionHelper.existField(entity.getClass(), "expDate"))
//					expireDate = (Date)BeanCopyHelper.getProperty(entity, "expDate");
//				
//				if (validDate != null && expireDate != null && validDate.equals(expireDate) && validDate.equals(DateHelper.getNextMonthFirstDay(new Date())))
//				{
//					remove(entity, fieldOfSelectConditions);
//				}
//				else
//					cancel(entity, fieldOfSelectConditions, false, null);
//				
//			}
//			else
				cancel(entity, fieldOfSelectConditions, false, null);
		}
		
		if (CommonDao.DataStoreMode.DIRECT_UPDATE.equals(dataStoreMode)) {
			backupAutoSuffix(entity, fieldOfSelectConditions);
			remove(entity, fieldOfSelectConditions);
		}
		
		return null;
	}

	public Object commonModify(BaseEntity entity) {
		CommonDao cd = (CommonDao) entity.getAnnotation(EntityPartitionHelper.getOriginalClassForPartition(entity), CommonDao.class);
		
		if (cd.fieldOfSelectConditions() == null) {
			throw new BossException(StatusCode.INSIDE_ERROR,
					"The @CommonDao(fieldOfSelectConditions) does not annotate on class "
							+ entity.getClass().getSimpleName());
		}
		
		if (cd.isAlertWhenNotExist())
		{	
			Object entityExisted = getEntity(entity, cd.fieldOfSelectConditions());
			if (entityExisted==null)
			{	
				StringBuffer strMessage = new StringBuffer();
				if (EntityPartitionHelper.existField(entity.getClass(), "servId"))
				{
					Object servId = BeanCopyHelper.getProperty(entity, "servId");
					if (servId != null)
						strMessage.append("servId=").append(servId.toString()).append(",");
				}
				if (EntityPartitionHelper.existField(entity.getClass(), "spromId"))
				{
					Object spromId = BeanCopyHelper.getProperty(entity, "spromId");
					if (spromId != null)
						strMessage.append("spromId=").append(spromId.toString()).append(",");
				}
				if (EntityPartitionHelper.existField(entity.getClass(), "soId"))
				{
					Object soId = BeanCopyHelper.getProperty(entity, "soId");
					if (soId != null)
						strMessage.append("soId=").append(soId.toString()).append(",");
				}
				if (EntityPartitionHelper.existField(entity.getClass(), "productId"))
				{
					Object productId = BeanCopyHelper.getProperty(entity, "productId");
					if (productId != null)
						strMessage.append("productId=").append(productId.toString()).append(",");
				}
				if (EntityPartitionHelper.existField(entity.getClass(), "payIndex"))
				{
					Object payIndex = BeanCopyHelper.getProperty(entity, "payIndex");
					if (payIndex != null)
						strMessage.append("payIndex=").append(payIndex.toString()).append(",");
				}
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR,
					strMessage.toString()+"The  "+ entity.getClass().getSimpleName()+" isn't found!");
			}
		}	

		if (CommonDao.DataStoreMode.INSERT_AFTER_UPDATE.equals(cd.dataStoreMode())) {
//			return modifyByInsertAfterUpdate(entity, cd.fieldOfSelectConditions(), new Date());使用数据库时间
			return modifyByInsertAfterUpdate(entity, cd.fieldOfSelectConditions(), queryCurrentDate());
		}
		
		if (CommonDao.DataStoreMode.DIRECT_UPDATE.equals(cd.dataStoreMode())) {
			backupAutoSuffix(entity, cd.fieldOfSelectConditions());
			return modifyByDirectUpdate(entity, cd.fieldOfSelectConditions());
		}

		return null;
	}
	
	public Object modifyByInsertAfterUpdate(Object entity, String[] selectConditions, Date updateDate) {
		try {
			flush();
			// 查询原数据
			Object entityExisted = queryEntity(entity, selectConditions);
			
			// 失效原数据
			cancel(entity, selectConditions, true, updateDate);
			flush();
			
			// 复制新数据并保存
			Object obj = Class.forName(entityExisted.getClass().getName()).newInstance();
			BeanCopyHelper.setProperty(entity, "validDate", updateDate);
			BeanCopyHelper.copyBeanNotNullProperty(obj, entityExisted);
			BeanCopyHelper.copyBeanNotNullProperty(obj, entity);
			
			add(obj);
			flush();
			
			return obj;
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	public Object modifyByDirectUpdate(Object entity, String[] selectConditions) {
		try {
			// 查询原数据
			Object entityExisted = queryEntity(entity, selectConditions);
			
			// 复制新数据并保存
			BeanCopyHelper.copyBeanNotNullPropertyCrm(entityExisted, entity);
			baseDao.update(entityExisted);
			flush();
			
			return entityExisted;
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	public Object commonModifyExpireDate(BaseEntity entity){
		CommonDao cd = (CommonDao) entity.getAnnotation(EntityPartitionHelper.getOriginalClassForPartition(entity), CommonDao.class);
		if (cd.fieldOfSelectConditions() == null) {
			throw new BossException(StatusCode.INSIDE_ERROR,
					"The @CommonDao(fieldOfSelectConditions) does not annotate on class "
							+ entity.getClass().getSimpleName());
			
		}
		if (cd.fieldOfDBSelectConditions() == null) {
			throw new BossException(StatusCode.INSIDE_ERROR,
					"The @CommonDao(fieldOfDBSelectConditions) does not annotate on class "
							+ entity.getClass().getSimpleName());
			
		}
		Object entityExisted = getEntity(entity, cd.fieldOfSelectConditions());
		if (entityExisted==null)
		{	
			StringBuffer strMessage = new StringBuffer();
			if (EntityPartitionHelper.existField(entity.getClass(), "servId"))
			{
				Object servId = BeanCopyHelper.getProperty(entity, "servId");
				if (servId != null)
					strMessage.append("servId=").append(servId.toString()).append(",");
			}
			if (EntityPartitionHelper.existField(entity.getClass(), "spromId"))
			{
				Object spromId = BeanCopyHelper.getProperty(entity, "spromId");
				if (spromId != null)
					strMessage.append("spromId=").append(spromId.toString()).append(",");
			}
			if (EntityPartitionHelper.existField(entity.getClass(), "soId"))
			{
				Object soId = BeanCopyHelper.getProperty(entity, "soId");
				if (soId != null)
					strMessage.append("soId=").append(soId.toString()).append(",");
			}
			if (EntityPartitionHelper.existField(entity.getClass(), "productId"))
			{
				Object productId = BeanCopyHelper.getProperty(entity, "productId");
				if (productId != null)
					strMessage.append("productId=").append(productId.toString()).append(",");
			}
			if (EntityPartitionHelper.existField(entity.getClass(), "payIndex"))
			{
				Object payIndex = BeanCopyHelper.getProperty(entity, "payIndex");
				if (payIndex != null)
					strMessage.append("payIndex=").append(payIndex.toString()).append(",");
			}
			throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR,
					strMessage.toString()+"The  "+ entity.getClass().getSimpleName()+" isn't found!");
		}
		Short regionCode = null; 
		try{
			regionCode= EntityPartitionHelper.getRegionCode(entityExisted);
		}catch (Exception e)
		{
			;
		}
		String tableName = "";
		javax.persistence.Table table =(javax.persistence.Table) entity.getAnnotation(EntityPartitionHelper.getOriginalClassForPartition(entity), javax.persistence.Table.class);
		if (table.schema()!=null && !table.schema().trim().equals(""))
			tableName = table.schema()+"."+table.name();
		else
			tableName = table.name();
		Map selectConditions = new HashMap();
		if (cd.fieldOfSelectConditions().length == cd.fieldOfDBSelectConditions().length)
		{
			for (int i=0;i<cd.fieldOfSelectConditions().length;i++)
			{
				List list = new ArrayList();
				String field = cd.fieldOfSelectConditions()[i];
				String dbField = cd.fieldOfDBSelectConditions()[i];
				list.add(field);
				list.add(dbField);
				selectConditions.put(field, list);
			}
		}
		Map selectDBConditions = new HashMap();
		try{
			Date expireDate = (Date) BeanCopyHelper.getProperty(entity, "expireDate");
			List list = new ArrayList();
			list.add("expireDate");
			list.add("expire_date");
			selectDBConditions.put("expireDate", list);
		}catch (Exception e){
			;
		}
		try{
			Date expireDate = (Date) BeanCopyHelper.getProperty(entity, "expDate");
			List list = new ArrayList();
			list.add("expDate");
			list.add("exp_date");
			selectDBConditions.put("expDate", list);
		}catch (Exception e){
			;
		}
		try{
			String soNbr = BeanCopyHelper.getProperty(entity, "soNbr").toString();
			List list = new ArrayList();
			list.add("soNbr");
			list.add("so_nbr");
			selectDBConditions.put("soNbr", list);
		}catch (Exception e){
			;
		}
		try{
			String sid = BeanCopyHelper.getProperty(entity, "sid").toString();
			List list = new ArrayList();
			list.add("sid");
			list.add("sid");
			selectDBConditions.put("sid", list);
		}catch (Exception e){
			;
		}
		backupAutoSuffix(entity, cd.fieldOfSelectConditions());
		if (regionCode != null && regionCode.shortValue() >= 101 && regionCode.shortValue()<=110 && !tableName.equalsIgnoreCase("ZG.ACC_USER_BILL_CYCLE"))
			updateExpireDate(entity,selectConditions,selectDBConditions,"0"+regionCode.toString(),tableName);
		else
			updateExpireDate(entity,selectConditions,selectDBConditions,null,tableName);
		flush();
		
		return null;
	}
	
	public Object commonRollBack(BaseEntity entity){
		CommonDao cd = (CommonDao) entity.getAnnotation(EntityPartitionHelper.getOriginalClassForPartition(entity), CommonDao.class);
		if (cd.fieldOfSelectConditions() == null) {
			throw new BossException(StatusCode.INSIDE_ERROR,
					"The @CommonDao(fieldOfSelectConditions) does not annotate on class "
							+ entity.getClass().getSimpleName());
			
		}
		String[] selectConditions = new String[cd.fieldOfSelectConditions().length+1];
		for (int i=0;i<cd.fieldOfSelectConditions().length;i++)
		{
			String condition = cd.fieldOfSelectConditions()[i];
			if (condition.equalsIgnoreCase("expDate")
					||condition.equalsIgnoreCase("effDate")
					||condition.equalsIgnoreCase("expireDate")
					||condition.equalsIgnoreCase("validDate")
					||condition.equalsIgnoreCase("sid"))
				continue;
			selectConditions[i] =condition; 
		}
		Long soNbr = null;
		if (EntityPartitionHelper.existField(entity.getClass(), "soNbr"))
		{
			selectConditions[cd.fieldOfSelectConditions().length] = "soNbr";
			soNbr = (Long)BeanCopyHelper.getProperty(entity, "soNbr");
			BeanCopyHelper.setPropertyCast(entity, "soNbr", entity.getRollBackSoNbr());
		}
		List entityList = this.getEntityList(entity, selectConditions);
//		Object entityExisted = getEntity(entity, selectConditions);
		if (entityList != null && entityList.size() >0)
		{
			for (int i=0;i<entityList.size();i++)
			{
				Object entityExisted = entityList.get(i);
				if (entityExisted.getClass().getSimpleName().startsWith("Crm") 
				||entityExisted.getClass().getSimpleName().startsWith("Acc") 
				||entityExisted.getClass().getSimpleName().startsWith("IUserSmsOrder")
				||entityExisted.getClass().getSimpleName().startsWith("IAccBusiCredit")
				||entityExisted.getClass().getSimpleName().startsWith("IAccBillCycle"))
				{
					baseDao.delete(entityExisted);
					return entityExisted;
				}
				
				Date validDate = null;
				if (EntityPartitionHelper.existField(entity.getClass(), "validDate"))
					validDate = (Date)BeanCopyHelper.getProperty(entity, "validDate");
				else if (EntityPartitionHelper.existField(entity.getClass(), "effDate"))
					validDate = (Date)BeanCopyHelper.getProperty(entity, "effDate");
				
				if (EntityPartitionHelper.existField(entity.getClass(), "expireDate"))
					BeanCopyHelper.setProperty(entityExisted, "expireDate",validDate);
				else if (EntityPartitionHelper.existField(entity.getClass(), "expDate"))
					BeanCopyHelper.setProperty(entityExisted, "expDate",validDate);
				
				if (EntityPartitionHelper.existField(entityExisted.getClass(), "soNbr"))
				{
					BeanCopyHelper.setProperty(entityExisted, "soNbr", soNbr);
				}
				if (entity.getTheOperateType().equals(OperateType.ROLLBACKADD))
					baseDao.update(entityExisted);
				else
					baseDao.delete(entityExisted);
			}
			
		}
			
		
		//如果历史表中有数据，则删除历史表
		Backup.CopyToSuffix backupSuffixAnno = null;
		Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
		// 如果目标实体类配置了@Backup.CopyToSuffix(isIgnore = true)，则表示不需要进行备份，直接返回
		if (entityClass.isAnnotationPresent(Backup.CopyToSuffix.class)) {
			backupSuffixAnno = (Backup.CopyToSuffix) entityClass.getAnnotation(Backup.CopyToSuffix.class);
			if (backupSuffixAnno.isIgnore()) return null;
		}
		// suffix为空，则尝试从实体类的配置中读取备份类的后缀
		String[] suffixes = null;
		if (backupSuffixAnno != null) {
			suffixes = backupSuffixAnno.suffixes();
		}
		// 向不同的后缀表做备份操作
		for (String suff : suffixes) {
			// 计算备份实体的类名
			String backupEntityClassName = EntityPartitionHelper.getOriginalClassForPartition(entity).getName();
			backupEntityClassName += StringUtils.capitalize(suff.toLowerCase());
			
			// 构造备份的目标对象
			Object backupEntity = BeanCopyHelper.newInstance(backupEntityClassName);
			
			// 复制数据至目标对象
			BeanCopyHelper.copyProperties(backupEntity, entity);
			Object entityExisted = getEntity(backupEntity, selectConditions);
			if (entityExisted != null)
				baseDao.delete(entityExisted);
		}	
		
		if (soNbr != null)
			BeanCopyHelper.setPropertyCast(entity, "soNbr", soNbr);
		return null;
	}
	public void updateExpireDate(Object entity, Map selectConditions,Map updateFields,String suffix,String tableName){
		if (selectConditions == null || selectConditions.size() == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR);
		}
		if (entity == null ||updateFields == null || updateFields.size() == 0
				||tableName == null || tableName.trim().equals(""))
		{
			return;
		}
		
		StringBuffer hql = new StringBuffer();
		hql.append("update ").append(tableName);
		if (suffix != null && !suffix.trim().equals(""))
			hql.append("_"+suffix);
		hql.append(" set ");
		Iterator it = updateFields.entrySet().iterator();
		int i=0;
		while(it.hasNext()) {
			List fieldName = (List)((Entry)it.next()).getValue();
			if (i>0)
				hql.append(",");
			hql.append(fieldName.get(1).toString()).append(" = :").append(fieldName.get(0).toString());
			i++;
		}
		Long soId = null;
		try{
			soId = (Long)BeanCopyHelper.getProperty(entity, "soId");
		}catch (Exception e){
			;
		}
		hql.append(" where ");
		it = selectConditions.entrySet().iterator();
		while(it.hasNext()) {
			List propName = (List)((Entry)it.next()).getValue();
			if ("expireDate".equalsIgnoreCase(propName.get(0).toString())) {
				hql.append("expire_Date > sysdate and expire_Date > valid_Date and ");
			}else if ("expDate".equalsIgnoreCase(propName.get(0).toString())) {
				hql.append("exp_Date > sysdate and exp_Date > eff_Date and ");
			} else if ("soId".equals(propName.get(0).toString()) && soId == null)
				continue;
			else if ("soId".equals(propName.get(0).toString()) && entity instanceof com.asiainfo.boss4.domain.ISpromParam)
				hql.append("substr(").append(propName.get(1).toString()).append(",2) = :").append(propName.get(0).toString()).append(" and ");
			else if ("soId".equals(propName.get(0).toString()) && soId.longValue()<120000000000000l)
				hql.append("substr(").append(propName.get(1).toString()).append(",12) = :").append(propName.get(0).toString()).append(" and ");
			else if ("soId".equals(propName.get(0).toString()))
				hql.append("substr(").append(propName.get(1).toString()).append(",2) = :").append(propName.get(0).toString()).append(" and ");
			else {
				hql.append(propName.get(1).toString()).append(" = :").append(propName.get(0).toString()).append(" and ");
			}
		}
		
		try {
			Query query = (Query) baseDao.createSQLQuery(hql.substring(0, hql.length() - 5));
			
			it = selectConditions.entrySet().iterator();
			while(it.hasNext()) {
				List propName = (List)((Entry)it.next()).getValue();
				if ("expireDate".equals(propName.get(0).toString())) { continue; }
				if ("expDate".equals(propName.get(0).toString())) { continue; }
				if ("soId".equals(propName.get(0).toString()) && soId == null)
					continue;
				else if ("soId".equals(propName.get(0).toString()) && entity instanceof com.asiainfo.boss4.domain.ISpromParam)
					query.setParameter(propName.get(0).toString(), soId.toString().substring(soId.toString().length()-14));
				else if ("soId".equals(propName.get(0).toString()) && soId.longValue()<120000000000000l)
				{
					query.setParameter(propName.get(0).toString(), soId.toString().substring(soId.toString().length()-4));
				}
				else if ("soId".equals(propName.get(0).toString()))
				{
					query.setParameter(propName.get(0).toString(), soId.toString().substring(soId.toString().length()-14));
				}
				else
					query.setParameter(propName.get(0).toString(), BeanCopyHelper.getProperty(entity, propName.get(0).toString()));
			}
			it = updateFields.entrySet().iterator();
			while(it.hasNext()) {
				List fieldName = (List)((Entry)it.next()).getValue();
				query.setParameter(fieldName.get(0).toString(), BeanCopyHelper.getProperty(entity, fieldName.get(0).toString()));
			}
			query.executeUpdate();

		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	private static Object getAnnotation(Class aClass, Class annotation) {
		if (!aClass.isAnnotationPresent(annotation)) {
			throw new BossException(StatusCode.INSIDE_ERROR, "The @CommonDao does not exist on class "+aClass.getSimpleName());
		}
		
		return aClass.getAnnotation(annotation);
	}
	
	public Session getSess(){
		return baseDao.getSess();
	}
	
	public void removeAllSpromAndParamAndCpc(Long servId,Short regionCode,Long soNbr,Long sid,Date expireDate){
		StringBuffer sb = new StringBuffer();
		sb.append(" from IUserSprom0");
		sb.append(regionCode.toString());
		sb.append(" where servId = :servId");
		sb.append(" and expireDate>sysdate and expireDate>validDate");
		try {
			
			Query query = (Query)this.baseDao.createQuery(sb.toString());
			query.setParameter("servId", servId);
			List spromList = query.list();
			for (int i=0;i<spromList.size();i++)
			{
				IUserSprom userSprom = (IUserSprom)spromList.get(i);
				CommonDao cd = (CommonDao) userSprom.getAnnotation(EntityPartitionHelper.getOriginalClassForPartition(userSprom), CommonDao.class);
				cloneToSuffix(userSprom, cd.fieldOfSelectConditions(), "rb", soNbr);
				
			}
			
			sb = new StringBuffer();
			sb.append("update zg.i_user_sprom_0");
			sb.append(regionCode.toString());
			if (expireDate != null)
				sb.append(" set expire_date = :expireDate");
			else
				sb.append(" set expire_date = sysdate");
			sb.append(",so_nbr = :soNbr");
			sb.append(",sid=:sid");
			sb.append(" where serv_id = :servId");
			sb.append(" and expire_date>sysdate and expire_date>valid_date");
			query = (Query)this.baseDao.createSQLQuery(sb.toString());
			query.setParameter("servId", servId);
			query.setParameter("soNbr", soNbr);
			query.setParameter("sid", sid);
			if (expireDate != null)
				query.setParameter("expireDate", expireDate);
			query.executeUpdate();
				
			sb = new StringBuffer();
			sb.append(" from ISpromParam0");
			sb.append(regionCode.toString());
			sb.append(" where servId = :servId");
			sb.append(" and expireDate>sysdate and expireDate>validDate");
			
			query = (Query)this.baseDao.createQuery(sb.toString());
			query.setParameter("servId", servId);
			List paramList = query.list();
			for (int i=0;i<paramList.size();i++)
			{
				ISpromParam spromParam = (ISpromParam)paramList.get(i);
				CommonDao cd = (CommonDao) spromParam.getAnnotation(EntityPartitionHelper.getOriginalClassForPartition(spromParam), CommonDao.class);
				cloneToSuffix(spromParam, cd.fieldOfSelectConditions(), "rb", soNbr);
			
				StringBuffer strBuff = new StringBuffer();
				strBuff.append("update zg.i_sprom_param_0");
				strBuff.append(regionCode.toString());
				if (expireDate != null)
					strBuff.append(" set expire_date = :expireDate");
				else
					strBuff.append(" set expire_date = sysdate");
				strBuff.append(",so_nbr = :soNbr");
				strBuff.append(",sid=:sid");
				strBuff.append(" where serv_id = :servId");
				strBuff.append(" and expire_date>sysdate and expire_date>valid_date");
				strBuff.append(" and so_id =:soId");
				strBuff.append(" and sid =:oldSid");
				strBuff.append(" and key_id =:keyId");
				strBuff.append(" and SPROM_PARA =:spromPara");
				Query subQuery = (Query)this.baseDao.createSQLQuery(strBuff.toString());
				subQuery.setParameter("servId", servId);
				subQuery.setParameter("soNbr", soNbr);
				subQuery.setParameter("sid", sid);
				subQuery.setParameter("soId", spromParam.getSoId());
				subQuery.setParameter("oldSid", spromParam.getSid());
				subQuery.setParameter("keyId", spromParam.getKeyId());
				subQuery.setParameter("spromPara", spromParam.getSpromPara());
				if (expireDate != null)
					subQuery.setParameter("expireDate", expireDate);
				
				subQuery.executeUpdate();
			}
			
			sb = new StringBuffer();
			sb.append("update zg.i_user_order_0");
			sb.append(regionCode.toString());
			if (expireDate != null)
				sb.append(" set expire_date = :expireDate");
			else
				sb.append(" set expire_date = sysdate");
//			sb.append(" ORDER_STS = 2");
			sb.append(",so_nbr = :sid");
			sb.append(",sid=:sid");
			sb.append(",remark=:soNbr");
			sb.append(" where serv_id = :servId");
			sb.append(" and expire_date>sysdate and expire_date>valid_date");
			
			query = (Query)this.baseDao.createSQLQuery(sb.toString());
			query.setParameter("servId", servId);
			query.setParameter("soNbr", soNbr.toString());
			query.setParameter("sid", sid);
			if (expireDate != null)
				query.setParameter("expireDate", expireDate);
			query.executeUpdate();
			
			sb = new StringBuffer();
			sb.append("update inter.I_USER_ORDER_DELAY_0");
			sb.append(regionCode.toString());
			if (expireDate != null)
				sb.append(" set expire_date = :expireDate");
			else
				sb.append(" set expire_date = sysdate");
//			sb.append(" ORDER_STS = 2");
			sb.append(",so_nbr = :sid");
			sb.append(",sid=:sid");
			sb.append(",remark=:soNbr");
			sb.append(" where serv_id = :servId");
			sb.append(" and expire_date>sysdate and expire_date>valid_date");
			
			query = (Query)this.baseDao.createSQLQuery(sb.toString());
			query.setParameter("servId", servId);
			query.setParameter("soNbr", soNbr.toString());
			query.setParameter("sid", sid);
			if (expireDate != null)
				query.setParameter("expireDate", expireDate);
			query.executeUpdate();
		} catch (Exception e) {
			logger.error("数据库操作异常"+sb.toString());
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	public String getNewUpFieldByServ(Long servId,Short regionCode,String oldUpField,boolean isRollBack,Long soNbr){
		String sql = "";
		if (isRollBack)
			sql = new StringBuffer("select sprom_type,count(*) from zg.i_user_sprom_0")
						.append(regionCode.toString())
						.append(" where serv_id =").append(servId)
						.append(" and so_nbr=").append(soNbr)
						.append(" group by sprom_type")
						.toString();
		else
			sql = new StringBuffer("select sprom_type,count(*) from zg.i_user_sprom_0")
						.append(regionCode.toString())
						.append(" where serv_id =").append(servId)
						.append(" and expire_date>sysdate and expire_date>valid_date")
						.append(" group by sprom_type")
						.toString();
		List list = baseDao.createSQLQuery(sql).list();
		String upField = oldUpField;
		for (int i=0;i<list.size();i++)
		{
			Object[] obj = (Object[])list.get(i);
			if ("0".equals(obj[0].toString())
					||"1".equals(obj[0].toString())
					||"3".equals(obj[0].toString()))
				upField = upField.substring(0, 1)+"1"+upField.substring(2);
			else if ("10".equals(obj[0].toString()))
				upField = upField.substring(0, 2)+"1"+upField.substring(3);
			else if ("6".equals(obj[0].toString()))
				upField = upField.substring(0, 23)+"1"+upField.substring(24);
			else if ("5".equals(obj[0].toString())
					||"7".equals(obj[0].toString())
					||"9".equals(obj[0].toString()))
				upField = upField.substring(0, 37)+"1"+upField.substring(38);
			else if ("4".equals(obj[0].toString())
					||"8".equals(obj[0].toString())
					||"11".equals(obj[0].toString()))
				upField = upField.substring(0, 38)+"1"+upField.substring(39);
		}
		
		//取I_SPROM_PARAM
		if (!isRollBack)
		{
			sql = new StringBuffer("select * from zg.I_SPROM_PARAM_0")
			.append(regionCode.toString())
			.append(" where serv_id =").append(servId)
			.append(" and expire_date>sysdate and expire_date>valid_date")
			.toString();
			if (baseDao.createSQLQuery(sql).list().size()>0)
				upField = upField.substring(0, 49)+"1"+upField.substring(50);
		}
		
		return upField;
	}
	
	public int getCpcCountByServ(Long servId,Short regionCode){
		String sql = "";
			
		//取I_USER_ORDER
		
		sql = new StringBuffer("select * from zg.i_user_order_0")
			.append(regionCode.toString())
			.append(" where serv_id =").append(servId)
			.append(" and expire_date>sysdate and expire_date>valid_date")
			.toString();
			
		return baseDao.createSQLQuery(sql).list().size();
	}
	
	public List getEntityListBySoNbr(Object entity)
	{
		StringBuffer hql = new StringBuffer();
		hql.append("from ").append(entity.getClass().getSimpleName()).append(" where soNbr=:soNbr and servId=:servId");
		Long soNbr = null;
		Long servId = null;
		try{
			soNbr = (Long)BeanCopyHelper.getProperty(entity, "soNbr");
			servId = (Long)BeanCopyHelper.getProperty(entity, "servId");
			return baseDao.getSess().createQuery(hql.toString()).setLong("servId", servId).setLong("soNbr", soNbr).list();
		}catch (Exception e){
			return new ArrayList();
		}
	}
	
	public List getEntityListSmsTemplet(Object entity)
	{
		StringBuffer hql = new StringBuffer();
		hql.append("from ").append(entity.getClass().getSimpleName()).append(" where templetId = :templetId and segmentSeq = :segmentSeq and priority = :priority")
		                                                             .append(" and floor(expireDate - :validDate)*floor(validDate - :expireDate) < 0 ");
		Long templetId = null;
		Long segmentSeq = null;
		Integer priority = null;
		Date validDate = null;
		Date expireDate = null;
		try{
			templetId = (Long)BeanCopyHelper.getProperty(entity, "templetId");
			segmentSeq = (Long)BeanCopyHelper.getProperty(entity, "segmentSeq");
			priority = (Integer)BeanCopyHelper.getProperty(entity, "priority");
			validDate = (Date)BeanCopyHelper.getProperty(entity, "validDate");
			expireDate = (Date)BeanCopyHelper.getProperty(entity, "expireDate");
			System.out.println(hql.toString());
			return baseDao.getSess().createQuery(hql.toString()).setLong("templetId", templetId)
			                                                    .setLong("segmentSeq", segmentSeq)
			                                                    .setInteger("priority", priority)
			                                                    .setDate("validDate", validDate)
			                                                    .setDate("expireDate", expireDate).list();

		}catch (Exception e){
			return new ArrayList();
		}
	}
	
	public List insertOweMonitorSpecAndCcPlan(Long servId,Long newAcctId,Long oldAcctId){
		//处理用户级的
		StringBuffer hql = new StringBuffer("from OweMonitorSpecQuota t ")
			.append("where t.expDate > sysdate ")
			.append("and t.acctId = :acctId ")
			.append("and t.servId = :servId ");
		List<OweMonitorSpecQuota> list = (List<OweMonitorSpecQuota>) baseDao
			.createQuery(hql.toString()).setLong("acctId", oldAcctId).setLong("servId", servId)
			.list();
		for (OweMonitorSpecQuota oweMonitorSpecQuota : list) {
			OweMonitorSpecQuotaH his = new OweMonitorSpecQuotaH();
			OweMonitorSpecQuota newOwe = new OweMonitorSpecQuota();
			BeanCopyHelper.copyBeanNotNullProperty(his, oweMonitorSpecQuota);
			BeanCopyHelper.copyBeanNotNullProperty(newOwe, oweMonitorSpecQuota);
			newOwe.setAcctId(newAcctId);
			try {
				baseDao.insert(his);
				baseDao.delete(oweMonitorSpecQuota);
				List oweList = this.getEntityList(newOwe, new String[]{"acctId","servId","quotaId"});
				if (oweList == null || oweList.size()==0)
					baseDao.insert(newOwe);
			} catch (Exception e) {
				throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
			}
		}
		
		//处理账户级的
		hql = new StringBuffer("from OweMonitorSpecQuota t ")
		.append("where t.expDate > sysdate ")
		.append("and t.acctId = :acctId ")
		.append("and t.servId = 0 ");
		list = (List<OweMonitorSpecQuota>) baseDao
			.createQuery(hql.toString()).setLong("acctId", oldAcctId).list();
		for (OweMonitorSpecQuota oweMonitorSpecQuota : list) {
			OweMonitorSpecQuota newOwe = new OweMonitorSpecQuota();
			BeanCopyHelper.copyBeanNotNullProperty(newOwe, oweMonitorSpecQuota);
			newOwe.setAcctId(newAcctId);
			try {
				List oweList = this.getEntityList(newOwe, new String[]{"acctId","servId","quotaId"});
				if (oweList == null || oweList.size()==0)
					baseDao.insert(newOwe);
			} catch (Exception e) {
				throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
			}
		}
		
		StringBuffer sql = new StringBuffer();
		sql.append("from  CcPlanInstanceRelation0"+(101+oldAcctId%10));
		sql.append(" where acct_id = :oldAcctId and instance_id = :servId");
		List<CcPlanInstanceRelation> ccplanList = (List<CcPlanInstanceRelation>) baseDao.createQuery(sql.toString()).setLong("servId", servId).setLong("oldAcctId", oldAcctId).list();
		for (CcPlanInstanceRelation ccplanInstanceRelation : ccplanList) {
			Class entityClass = EntityPartitionHelper.getClassForPartition(CcPlanInstanceRelation.class,newAcctId);
			CcPlanInstanceRelation newCcplan = (CcPlanInstanceRelation) BeanCopyHelper.newInstance(entityClass);
			BeanCopyHelper.copyBeanNotNullProperty(newCcplan, ccplanInstanceRelation);
			newCcplan.setAcctId(newAcctId);
			try {
				baseDao.delete(ccplanInstanceRelation);
				baseDao.insert(newCcplan);
			} catch (Exception e) {
				throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
			}
		}
		return ccplanList;
	}
	
	public void removeAccIntellnetUserCycle(Long acctId,Long soNbr){
		long suffix = acctId.longValue()%10+1;
		String remainder = "01";
		if (suffix >9)
			remainder += String.valueOf(suffix) ;
		else
			remainder += "0"+String.valueOf(suffix) ;
		String yearMonth = DateHelper.getYearMonth();
		StringBuffer insertUserCycleHisSql = new StringBuffer();
		insertUserCycleHisSql.append("insert into ZG.ACC_INTELLNET_REG_")
			.append(remainder).append(yearMonth)
			.append(" (SO_NBR, ACCT_ID, PVALID_DATE, PEXPIRE_DATE, NVALID_DATE, NEXPIRE_DATE) select ")
			.append(soNbr)
			.append(",c.acct_id,c.valid_date,c.EXPIRE_DATE,c.valid_date,sysdate from ZG.ACC_INTELLNET_USER_CYCLE c where c.acct_id =:acctId");
		String deleteUserCycleSql = "delete from ZG.ACC_INTELLNET_USER_CYCLE c where c.acct_id =:acctId";
		
		this.baseDao.createSQLQuery(insertUserCycleHisSql.toString()).setParameter("acctId", acctId).executeUpdate();
		this.baseDao.createSQLQuery(deleteUserCycleSql).setParameter("acctId", acctId).executeUpdate();

	}
	
	public List getEntityList(Object entity, String[] selectConditions) {
		if (selectConditions == null || selectConditions.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR);
		}
		
		StringBuffer hql = new StringBuffer();
		hql.append("from ").append(entity.getClass().getSimpleName()).append(" where ");
		Long soId = null;
		try{
			soId = (Long)BeanCopyHelper.getProperty(entity, "soId");
		}catch (Exception e){
			;
		}
		for (int i = 0; i < selectConditions.length; i++) {
			String propName = selectConditions[i];
			if ("expireDate".equalsIgnoreCase(propName)) {
				hql.append("expireDate > sysdate and expireDate > validDate and ");
			}else if ("soId".equals(propName) && soId == null)
				continue;
			else if ("soId".equals(propName) && entity instanceof com.asiainfo.boss4.domain.ISpromParam)
				hql.append("substr(").append(propName).append(",2) = :").append(propName).append(" and ");
			else if ("soId".equals(propName) && soId.longValue()<120000000000000l)
				hql.append("substr(").append(propName).append(",12) = :").append(propName).append(" and ");
			else if ("soId".equals(propName))
				hql.append("substr(").append(propName).append(",2) = :").append(propName).append(" and ");
			else if ("expDate".equalsIgnoreCase(propName)) {
				hql.append("expDate > sysdate and expDate > effDate and ");
			}
			else if (propName != null && !propName.equals("")){
				hql.append(propName).append(" = :").append(propName).append(" and ");
			}
		}
		
		List result = new ArrayList();
		try {
			Query query = (Query) baseDao.createQuery(hql.substring(0, hql.length() - 5));
			
			for (int i = 0; i < selectConditions.length; i++) {
				String propName = selectConditions[i];
				if ("expireDate".equals(propName)) { continue; }
				if ("expDate".equalsIgnoreCase(propName)) { continue; }
				if ("soId".equals(propName) && soId == null) 
				{ 
					continue; 
				}
				else if ("soId".equals(propName) && entity instanceof com.asiainfo.boss4.domain.ISpromParam)
					query.setParameter(propName, soId.toString().substring(soId.toString().length()-14));
				else if ("soId".equals(propName) && soId.longValue()<120000000000000l)
				{
					query.setParameter(propName, soId.toString().substring(soId.toString().length()-4));
				}
				else if ("soId".equals(propName))
				{
					query.setParameter(propName, soId.toString().substring(soId.toString().length()-14));
				}
				else  if (propName != null && !propName.equals(""))
					query.setParameter(propName, BeanCopyHelper.getProperty(entity, propName));
			}
			result = query.list();

		} catch (BossException e) {
			throw e;
		} catch (NonUniqueResultException e) {
			logger.error("数据库操作异常:"+hql.toString());
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e);
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return result;
	}
	
	public boolean sidExist(IUserPbx userPbx){
		Long servId = userPbx.getServId();
		Long sid = userPbx.getSid();
		StringBuffer queryHql = new StringBuffer();
		queryHql.append("from ").append(userPbx.getClass().getSimpleName())
			.append(" t where servId = :servId and t.sid = :sid")
			.append(" and trunc(t.expireDate)>=trunc(sysdate) and t.expireDate>t.validDate");
		IUserPbx result = null;
		Query query = this.baseDao.createQuery(queryHql.toString());
		query.setParameter("servId", servId);
		query.setParameter("sid", sid);
		try {
			result = (IUserPbx) query.uniqueResult();
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		if (result!=null)
			return true;
		else
			return false;
	}
	
	public void rollBackAccIntellnetUserCycle(Long acctId,Long soNbr){
		long suffix = acctId.longValue()%10+1;
		String remainder = "01";
		if (suffix >9)
			remainder += String.valueOf(suffix) ;
		else
			remainder += "0"+String.valueOf(suffix) ;
		String yearMonth = DateHelper.getYearMonth();
		StringBuffer insertUserCycleHisSql = new StringBuffer();
		insertUserCycleHisSql.append("insert into ZG.ACC_INTELLNET_USER_CYCLE ")
			.append(" (acct_id,valid_date,EXPIRE_DATE,sts,balance_expire_date) ")
			.append(" select ACCT_ID, PVALID_DATE, PEXPIRE_DATE,PEXPIRE_DATE  from ")
			.append(" ZG.ACC_INTELLNET_REG_"+remainder+yearMonth+" c where c.acct_id =:acctId and c.so_nbr = :soNbr");
		String deleteUserCycleSql = "delete from ZG.ACC_INTELLNET_REG_"+remainder+yearMonth+" c where c.acct_id =:acctId and c.so_nbr = :soNbr";
		
		this.baseDao.createSQLQuery(insertUserCycleHisSql.toString()).setParameter("acctId", acctId).setParameter("soNbr", soNbr).executeUpdate();
		this.baseDao.createSQLQuery(deleteUserCycleSql).setParameter("acctId", acctId).setParameter("soNbr", soNbr).executeUpdate();

	}
	
	public void rollBackAllSpromAndParam(Long servId,Short regionCode,Long soNbr,Long sid){
		StringBuffer sb = new StringBuffer();
		sb.append(" from IUserSprom0");
		sb.append(regionCode.toString());
		sb.append(" where servId = :servId");
		sb.append(" and soNbr = :soNbr");
		try {
			
			Query query = (Query)this.baseDao.createQuery(sb.toString());
			query.setParameter("servId", servId);
			query.setParameter("soNbr", soNbr);
			List spromList = query.list();
			for (int i=0;i<spromList.size();i++)
			{
				IUserSprom userSprom = (IUserSprom)spromList.get(i);
				
				sb = new StringBuffer();
				sb.append(" from IUserSpromRb");
				sb.append(" where servId = :servId");
				sb.append(" and rollbackSoNbr = :soNbr");
				sb.append(" and spromId = :spromId");
				sb.append(" and validDate = :validDate");
				sb.append(" and soId = :soId");
				sb.append(" and operType = :operType");
				
				IUserSpromRb spromRb =(IUserSpromRb)this.baseDao.createQuery(sb.toString())
													.setParameter("servId", servId)
													.setParameter("soNbr", soNbr)
													.setParameter("spromId", userSprom.getSpromId())
													.setParameter("validDate", userSprom.getValidDate())
													.setParameter("soId", userSprom.getSoId())
													.setParameter("operType", userSprom.getOperType())
													.uniqueResult();
				userSprom.setSid(Long.valueOf(sid.longValue()));
				userSprom.setExpireDate(DateHelper.String2Date(Constance.DEFAULTEXPIREDATE));
				if (spromRb != null)
				{
					userSprom.setExpireDate(spromRb.getExpireDate());
					userSprom.setSoNbr(spromRb.getSoNbr());
				}
				baseDao.update(userSprom);
				if (spromRb != null)
					baseDao.delete(spromRb);
			}
			
			sb = new StringBuffer();
			sb.append(" from ISpromParam0");
			sb.append(regionCode.toString());
			sb.append(" where servId = :servId");
			sb.append(" and soNbr = :soNbr");
			
			query = (Query)this.baseDao.createQuery(sb.toString());
			query.setParameter("servId", servId);
			query.setParameter("soNbr", soNbr);
			List paramList = query.list();
			for (int i=0;i<paramList.size();i++)
			{
				ISpromParam spromParam = (ISpromParam)paramList.get(i);
				sb = new StringBuffer();
				sb.append(" from ISpromParamRb");
				sb.append(" where servId = :servId");
				sb.append(" and rollbackSoNbr = :soNbr");
				sb.append(" and keyId = :keyId");
				sb.append(" and spromPara = :spromPara");
				sb.append(" and validDate = :validDate");
				sb.append(" and soId = :soId");
				
				ISpromParamRb spromParamRb =(ISpromParamRb)this.baseDao.createQuery(sb.toString())
													.setParameter("servId", servId)
													.setParameter("soNbr", soNbr)
													.setParameter("keyId", spromParam.getKeyId())
													.setParameter("spromPara", spromParam.getSpromPara())
													.setParameter("validDate", spromParam.getValidDate())
													.setParameter("soId", spromParam.getSoId())
													.uniqueResult();
				ISpromParam param = param = (ISpromParam)BeanCopyHelper.buildEntityInstanse(spromParam, spromParam.getClass());
				BeanCopyHelper.copyBeanNotNullProperty(param, spromParam);
				param.setSid(Long.valueOf(sid.longValue()));
				param.setExpireDate(DateHelper.String2Date(Constance.DEFAULTEXPIREDATE));
				if (spromParamRb != null)
				{
					param.setExpireDate(spromParamRb.getExpireDate());
					param.setSoNbr(spromParamRb.getSoNbr());
				}
				
				baseDao.delete(spromParam);
				baseDao.insert(param);
				if (spromParamRb != null)
					baseDao.delete(spromParamRb);
				
			}
			
//			sb = new StringBuffer();
//			sb.append("update zg.i_user_order_0");
//			sb.append(regionCode.toString());
//			sb.append(" set expire_date = sysdate");
//			sb.append(",so_nbr = :soNbr");
//			sb.append(",sid=:sid");
//			sb.append(" where serv_id = :servId");
//			sb.append(" and expire_date>sysdate and expire_date>valid_date");
//			
//			query = (Query)this.baseDao.createSQLQuery(sb.toString());
//			query.setParameter("servId", servId);
//			query.setParameter("soNbr", soNbr);
//			query.setParameter("sid", sid);
//			query.executeUpdate();
		} catch (Exception e) {
			logger.error("数据库操作异常"+sb.toString());
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	public void cloneToSuffix(Object entity, String[] constraints, String suffix, Long soNbr) {
		if (constraints == null || constraints.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR);
		}
		
		Backup.CopyToSuffix backupSuffixAnno = null;
		Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
		// suffix为空，则尝试从实体类的配置中读取备份类的后缀
		String[] suffixes = null;
		if (suffix == null || "".endsWith(suffix)) {
			logger.debug(">> suffix is null.");
			if (backupSuffixAnno != null) {
				suffixes = backupSuffixAnno.suffixes();
			} else {
				suffixes = new String[]{"rb"};
				logger.warn("备份"+entityClass.getSimpleName()+"实体时没有指定后缀，采用RB作为默认后缀");
			}
		} else {
			suffixes = new String[]{suffix};
		}
		
		// 向不同的后缀表做备份操作
		for (String suff : suffixes) {
				
				// 计算备份实体的类名
				String backupEntityClassName = EntityPartitionHelper.getOriginalClassForPartition(entity).getName();
				backupEntityClassName += StringUtils.capitalize(suff.toLowerCase());
				
				// 构造备份的目标对象
				Object backupEntity = BeanCopyHelper.newInstance(backupEntityClassName);
				
				// 复制数据至目标对象
				BeanCopyHelper.copyProperties(backupEntity, entity);
				
				if (backupEntity.getClass().isAnnotationPresent(Backup.class)) {
					Backup backupAnno = backupEntity.getClass().getAnnotation(Backup.class);
					// 取原记录的soNbr
					Object originalSoNbr = BeanCopyHelper.getProperty(entity, backupAnno.processedField().fieldName());
					// 取本次请求的soNbr
					Object rollbackSoNbr = soNbr;
					// 备份原记录的soNbr
					BeanCopyHelper.setProperty(backupEntity, backupAnno.processedField().originalBackupName(), originalSoNbr);
					// 备份本次请求的soNbr，以便撤单之用
					BeanCopyHelper.setProperty(backupEntity, backupAnno.processedField().rollbackBackupName(), rollbackSoNbr);
				}
				
				// 插入回滚数据
				try {
					this.baseDao.insert(backupEntity);
				} catch (Exception e) {
					logger.error("数据库操作异常");
					throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
				}
			
		}
		
	}
	
	public void removeISaleOperAll(Short regionCode,Long soNbr,Long sid){
		StringBuffer sb = new StringBuffer();
		sb.append("delete zg.i_sale_oper_0");
		sb.append(regionCode.toString());
		sb.append(" where so_nbr = :soNbr");
		sb.append(" and sid != :sid");
		
		this.baseDao.createSQLQuery(sb.toString()).setParameter("soNbr", soNbr).setParameter("sid", sid).executeUpdate();

		sb = new StringBuffer();
		sb.append("delete zg.i_sale_oper_0");
		sb.append(regionCode.toString());
		sb.append("_his");
		sb.append(" where so_nbr = :soNbr");
		sb.append(" and sid != :sid");
		
		this.baseDao.createSQLQuery(sb.toString()).setParameter("soNbr", soNbr).setParameter("sid", sid).executeUpdate();
		
		sb = new StringBuffer();
		sb.append("delete zg.i_sale_oper_0");
		sb.append(regionCode.toString());
		sb.append("_err");
		sb.append(" where so_nbr = :soNbr");
		sb.append(" and sid != :sid");
		
		this.baseDao.createSQLQuery(sb.toString()).setParameter("soNbr", soNbr).setParameter("sid", sid).executeUpdate();
	}
	
	public CrmUser queryCrmUserByPhoneId(String phoneId) {
		if (phoneId == null) {
			throw new BossException(StatusCode.INSIDE_ERROR, "参数phoneId为空");
		}
		
		CrmUser user = null;
		try {
			user = (CrmUser) baseDao.createQuery("from CrmUser u where u.phoneId = :phoneId and u.expireDate > sysdate")
						.setParameter("phoneId", phoneId).uniqueResult();
			
		} catch (NonUniqueResultException e) {
			logger.error("用户不唯一");
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e);
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return user;
	}
	
	public Date getMaxExpireDate(Object entity, String[] selectConditions) {
		Date result = null;
		List resultList = this.getEntityList(entity, selectConditions);
		for (int i=0;i<resultList.size();i++)
		{
			Object entityObj = resultList.get(i);
			Date expireDate = null;
			if (EntityPartitionHelper.existField(entityObj.getClass(), "expireDate"))
				expireDate = (Date)BeanCopyHelper.getProperty(entityObj, "expireDate");
			else if (EntityPartitionHelper.existField(entityObj.getClass(), "expDate"))
				expireDate = (Date)BeanCopyHelper.getProperty(entityObj, "expDate");
			if (expireDate != null && result == null)
				result = expireDate;
			else if (expireDate != null && result != null && expireDate.after(result))
				result = expireDate;
		}
		return result;
	}
	
	public void flushAndClearWithException() {
		baseDao.getSess().flush();
		baseDao.getSess().clear();
		logger.debug("flush operation of SQL, then clear all cached entities in the session"); 
		
	}
	
	public List getCcPlanList(Long servId,Long oldAcctId){
		
		StringBuffer sql = new StringBuffer();
		sql.append("from  CcPlanInstanceRelation0"+(101+oldAcctId%10));
		sql.append(" where acct_id = :oldAcctId and instance_id = :servId");
		List<CcPlanInstanceRelation> ccplanList = (List<CcPlanInstanceRelation>) baseDao.createQuery(sql.toString()).setLong("servId", servId).setLong("oldAcctId", oldAcctId).list();
		return ccplanList;
	}
	
	public List<SmsJfMap> getSmsJfMap(String templetId)
	{
		StringBuffer sql = new StringBuffer();
		sql.append("from SmsJfMap where  templetId = :templetId");
		if (templetId!= null && !"".equals(templetId))
		{
			if (templetId.length() == 4)
				return  (List<SmsJfMap>)baseDao.createQuery(sql.toString()).setString("templetId", templetId).list();
			else if (templetId.length() == 2)
				return  (List<SmsJfMap>)baseDao.createQuery(sql.toString()).setString("templetId", templetId+"01").list();
		}
		
		return  new ArrayList();
	}
	
	public List queryAccUserPaymentList(Long servId) {
		
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select a.* from  zg.acc_user_payment a where a.serv_id = :servId ");
		sqlBuffer.append(" and a.expire_Date>a.effective_Date and a.expire_Date>sysdate ");	
		return this.baseDao.createSQLQuery(sqlBuffer.toString()).setLong("servId", servId).list();
	}
	
	public List getEntityListExt(Object entity, String[] selectConditions) {
		if (selectConditions == null || selectConditions.length == 0) {
			StringBuffer hql = new StringBuffer();
			hql.append("from ").append(entity.getClass().getSimpleName());
			List result = new ArrayList();
			try {
				Query query = (Query) baseDao.createQuery(hql.toString());
				result = query.list();

			} catch (BossException e) {
				throw e;
			} catch (NonUniqueResultException e) {
				logger.error("数据库操作异常:"+hql.toString());
				throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e);
			} catch (Exception e) {
				throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
			}
			return result;
		}
		else
			return getEntityList(entity,selectConditions);
	}
}
