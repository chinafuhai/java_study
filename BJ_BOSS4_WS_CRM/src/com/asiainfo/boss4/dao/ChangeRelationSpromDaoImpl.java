package com.asiainfo.boss4.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;

import com.asiainfo.boss4.domain.IUserRelation;
import com.asiainfo.boss4.domain.IUserSprom;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.StringHelper;

public class ChangeRelationSpromDaoImpl extends BusinessDaoImpl implements ChangeRelationSpromDao{
	
	private static Log logger = LogFactory.getLog(ChangeRelationSpromDaoImpl.class);
	
	public int insertRelationSprom(Object entity, String rservId) {
		flush();
		Integer spromId = null;
		try {
			spromId = (Integer) PropertyUtils.getProperty(entity, "spromId");
			if (spromId == null) throw new Exception("传入spromId为空");
		} catch (Exception e) {
			logger.error("取实体" + StringHelper.getClassName(entity.getClass()) + "的属性spromId出错");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		//设置soId
//		Long soidSeq = this.getSoidSequence();
//		Long soId = (Long) BeanCopyHelper.getProperty(entity, "soId");
//		Long newSoId = soidSeq*10000+soId;
//		BeanCopyHelper.setProperty(entity, "soId", soidSeq*10000+soId);
		
		Long newSoId = (Long) BeanCopyHelper.getProperty(entity, "soId");
		
		if (spromId.equals(AppConstant.GENERAL_RELATION_SPROM_ID)) {//普通亲情号码的促销数据
			Long servId = null;
			try {
				servId = (Long) PropertyUtils.getProperty(entity, "servId");
				if (servId == null) throw new Exception("传入servId为空");
			} catch (Exception e) {
				logger.error("取实体" + StringHelper.getClassName(entity.getClass()) + "的属性servId出错");
				throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
			}
			
			StringBuffer hql = new StringBuffer().append("from ").append(StringHelper.getClassName(entity.getClass()));
			hql.append(" where spromId = :spromId and servId = :servId and expireDate>validDate and expireDate>sysdate");
			
			List list = null;
			try {
				Query query = this.baseDao.createQuery(hql.toString()).setParameter("spromId", spromId).setParameter("servId", servId);
				list = query.list();
			} catch (Exception e) {
				logger.error("数据库操作异常");
				throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
			}
			if (list.size()>=1) {//已有普通亲情号码的促销数据
				if (rservId!=null) {
					newSoId = ((IUserSprom)list.get(0)).getSoId();
					updateRelationSoid(entity, rservId, newSoId);
					return 1;
				}
				return 0;
			}
			else {
				this.add(entity);
				if (rservId!=null) {
					updateRelationSoid(entity, rservId, newSoId);
				}
				return 1;
			}
		}
		else {//其它亲情号码的促销数据
			this.add(entity);
			if (rservId!=null) {
				updateRelationSoid(entity, rservId, newSoId);
			}
			return 1;
		}
		
		
	}
	
	private void updateRelationSoid(Object entity, String rservId, Long soId){
		Long servId = (Long) BeanCopyHelper.getProperty(entity, "servId");
		Class iUserRelationClass = EntityPartitionHelper.getClassForPartition(IUserRelation.class, servId);
		String updateSoidHql = "update "+iUserRelationClass.getSimpleName()+" t set t.soId="+soId
			+" where t.servId="+servId
			+" and t.rservId="+rservId+" and mod(t.soId,10000)="+(soId%10000)
			+" and t.expireDate>sysdate and t.expireDate>t.validDate";
		this.baseDao.createQuery(updateSoidHql.toString()).executeUpdate();
	}
	
	/* (non-Javadoc)
	 * @see com.asiainfo.boss4.dao.ChangeRelationSpromDao#cancelRelationSprom(java.lang.Object, java.lang.String[])
	 */
	public int cancelRelationSprom(Object entity, String[] conditions) {
		flush();
		Integer spromId = null;
		try {
			spromId = (Integer) PropertyUtils.getProperty(entity, "spromId");
			if (spromId == null) throw new Exception("传入spromId为空");
		} catch (Exception e) {
			logger.error("取实体" + StringHelper.getClassName(entity.getClass()) + "的属性spromId出错");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		
		if (spromId.equals(AppConstant.GENERAL_RELATION_SPROM_ID)) {//普通亲情号码的促销数据
			modifyRelationSprom(entity, spromId, null);
			return 1;

		}
		else {//其它亲情号码的促销数据
			super.backup(entity, conditions);
			super.cancel(entity, conditions);
			return 1;
		}
	}
	
	public Object rollbackRelationSprom(Object entity, String[] conditions, Set updateSoIdSQL) {
		flush();
		Integer spromId = null;
		try {
			spromId = (Integer) PropertyUtils.getProperty(entity, "spromId");
			if (spromId == null || spromId.equals("")) {
				logger.error("取出实体" + StringHelper.getClassName(entity.getClass()) + "的spromId属性为空");
				throw new BossException(StatusCode.ENTITY_PARSE_ERROR);
			}
		}catch (Exception e) {
			logger.error("无法取出实体" + StringHelper.getClassName(entity.getClass()) + "的spromId属性");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		if (spromId.equals(AppConstant.GENERAL_RELATION_SPROM_ID)) {//普通亲情号码的促销数据
			//修改普通号码套餐的失效时间为号码的最晚失效时间，并返回修改的对象
			Object o = modifyRelationSprom(entity, spromId, "rollback");
			//更新soId
			updateSoId(entity, o, updateSoIdSQL);
			String spromType = null;
			try {
				spromType = PropertyUtils.getProperty(o, "spromType").toString();
			}catch (Exception e) {
				logger.error("无法取出实体" + StringHelper.getClassName(o.getClass()) + "的spromType属性");
				throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
			}
			return spromType;//返回促销类型
		}
		else {//其它亲情号码的促销数据
			Object o = super.rollback(entity);
			//更新soId
			updateSoId(entity, o, updateSoIdSQL);
			String spromType = null;
			try {
				spromType = PropertyUtils.getProperty(o, "spromType").toString();
			}catch (Exception e) {
				logger.error("无法取出实体" + StringHelper.getClassName(o.getClass()) + "的spromType属性");
				throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
			}
			return spromType;//返回促销类型
		}
	}
	
	public Object modifyRelationSprom(Object entity, Integer spromId, String operation) {
		flush();
		Long servId = null;
		try {
			servId = (Long) PropertyUtils.getProperty(entity, "servId");
		}catch (Exception e) {
			logger.error("无法取出实体" + StringHelper.getClassName(entity.getClass()) + "的servId属性");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		
		//查询普通号码的最晚失效日期
		StringBuffer hql = new StringBuffer();
		hql.append("select max(r.expireDate) from ").append(entity.getClass().getSimpleName())
			.append(" s, ").append(EntityPartitionHelper.getClassForPartition(IUserRelation.class, servId).getSimpleName())
			.append(" r where r.servId = s.servId and r.soId = s.soId and s.servId = :servId and s.spromId = :spromId");
		
		Date expireDate = null;
		
		try {
			Query query = this.baseDao.createQuery(hql.toString()).setParameter("spromId", spromId).setParameter("servId", servId);
			expireDate = (Date) query.uniqueResult();
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
		if (expireDate == null) {
			logger.error("无法找到普通号码的最晚失效日期");
//			expireDate = new Date();使用数据库时间
			expireDate = queryCurrentDate();
		}
		
		//查询失效日期最晚的有效套餐
		StringBuffer sb = new StringBuffer();
		sb.append("from ").append(entity.getClass().getSimpleName()).append(" where servId =:servId and spromId ='")
			.append(spromId).append("' and expireDate>=validDate order by soNbr desc");
		Object object = null;
		try {
			Query query = this.baseDao.createQuery(sb.toString()).setParameter("servId", servId);
			object = query.list().get(0);
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
		//准备更新语句（更新失效时间，需要的话更新soId）
		StringBuffer updateHql = new StringBuffer();
		updateHql.append("update ").append(entity.getClass().getSimpleName()).append(" set expireDate=:expireDate ");
		
		/*
		 * 判断是否是新增的撤单，如果是，并且没有普通号码在用此促销（即这个撤单操作后没有普通号码的有效促销），
		 * 则将这条促销数据的soId改成sid，避免再次新增时因soId一样造成主键冲突
		 * 
		 * soId改造为11位序列号+4位原soId后，此段代码无用
		 */
		/*
		if (operation!=null&&"rollback".equals(operation)) {//判断操作类型是否是撤单
			Byte operType = null;
			try {
				operType = (Byte) PropertyUtils.getProperty(entity, "operType");
			}catch (Exception e) {
				logger.error("无法取出实体" + StringHelper.getClassName(entity.getClass()) + "的operType属性");
				throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
			}
			
			if (operType==1) {//判断是否是新增的撤单
//				StringBuffer countHql = new StringBuffer().append("select 1 from ").append(StringHelper.getClassName(entity.getClass()));
//				countHql.append(" where spromId = :spromId and servId = :servId and expireDate>validDate and expireDate>sysdate");
				StringBuffer countHql = new StringBuffer().append("select 1 from  ").append(entity.getClass().getSimpleName())
					.append(" s, ").append(EntityPartitionHelper.getClassForPartition(IUserRelation.class, servId).getSimpleName())
					.append(" r where r.servId = s.servId and r.soId = s.soId and s.servId = :servId and s.spromId = :spromId")
					.append(" and r.expireDate>r.validDate and r.expireDate>sysdate")
					.append(" and s.expireDate>s.validDate and s.expireDate>sysdate");
				
				List list = null;
				try {
					Query query = this.baseDao.createQuery(countHql.toString()).setParameter("spromId", spromId).setParameter("servId", servId);
					list = query.list();
				} catch (Exception e) {
					logger.error("数据库操作异常");
					throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
				}
				if (list.size()==0) {//还有有效的普通亲情号码
					updateHql.append(",soId=sid");//更新语句中修改掉其soId值
				}				
			}
		}
		*/
		
		Long soId = null;
		try {
			soId = (Long) PropertyUtils.getProperty(object, "soId");
		} catch (Exception e) {
			logger.error("无法取出实体属性");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		//更新语句的其它条件
		updateHql.append(" where servId=:servId and spromId = :spromId and soId=:soId");
		
		Query update = this.baseDao.createQuery(updateHql.toString());
		update.setParameter("expireDate", expireDate);
		update.setParameter("servId", servId);
		update.setParameter("spromId", spromId);
//		update.setParameter("validDate", validDate);
		update.setParameter("soId", soId);
		
		int updatedEntities = update.executeUpdate();
		if (updatedEntities == 0) {
			throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
		}
		if (updatedEntities > 1) {
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR);
		}
		return object;
	}
	
	/**
	 * 更新soId
	 * @param entity 报文的实体对象
	 * @param o 撤单操作后返回的实体对象，即撤单操作的对象
	 */
	public void updateSoId(Object entity, Object o, Set updateSoIdSQL) {
		flush();
		String soIdStr = null;
		Long soNbr = null;
		Integer spromId = null;
		Long oldSoId = null;
		try {
			//从remark取newSoId
			soIdStr = (String) PropertyUtils.getProperty(entity, "remark");
			//从撤单后的实体对象中取soNbr
			soNbr = (Long) PropertyUtils.getProperty(o, "soNbr");
			//从撤单后的实体对象中取spromId
			spromId = (Integer) PropertyUtils.getProperty(o, "spromId");
		} catch (Exception e) {
			logger.error("无法取出实体" + StringHelper.getClassName(entity.getClass()) + "属性");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		oldSoId = (Long) BeanCopyHelper.getProperty(o, "soId");
		if (soIdStr!=null&&!"".equals(soIdStr)) {
			String[] soIdStrs = soIdStr.split(":");
			if (soIdStrs.length != 2) return;
			
			//EAI传的4位原soId
			String soId = soIdStrs[0];
			//spromId+原soId（应该与数据库中相同）
//			String soIdWithPrefix = spromId+soId;
			
			String[] newSoIds = soIdStrs[1].split(",");
			for (int i = 0; i < newSoIds.length; i++) {
				String[] soIdGroups = newSoIds[i].split("\\|");
				if (soIdGroups.length != 2) continue;
				if (soId.equals(soIdGroups[1])) {
					String newSoId = soIdGroups[0];
					
					//spromId+newSoId
//					String newSoIdWithPrefix = spromId+newSoId;
					Long newSoIdWithPrefix = oldSoId/10000*10000+Long.valueOf(newSoId);
					
					StringBuffer sb = new StringBuffer();
					if (spromId.equals(AppConstant.GENERAL_RELATION_SPROM_ID)){//普通号码套餐的撤单
						Long servId = null;
						try {
							servId = (Long) PropertyUtils.getProperty(o, "servId");
						} catch (Exception e) {
							logger.error("无法取出实体" + StringHelper.getClassName(entity.getClass()) + "属性");
							throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
						}
						sb.append("update ").append(o.getClass().getSimpleName()).append(" set soId = '").append(newSoIdWithPrefix)
							.append("' where servId = '").append(servId.toString())
							.append("' and spromId = '").append(spromId.toString())
							.append("' and soId = '").append(oldSoId).append("'");
					}
					else {//其它促销数据的撤单
						sb.append("update ").append(o.getClass().getSimpleName()).append(" set soId = '").append(newSoIdWithPrefix)
							.append("' where soNbr = '").append(soNbr.toString())
							.append("' and soId = '").append(oldSoId).append("'");
					}
					updateSoIdSQL.add(sb.toString());
					break;
				}
			}
		}
	}
}
