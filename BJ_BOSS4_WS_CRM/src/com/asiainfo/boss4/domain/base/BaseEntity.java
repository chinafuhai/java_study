package com.asiainfo.boss4.domain.base;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.OperateType;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.annotation.CommonDao;

public abstract class BaseEntity {
	private static Log logger = LogFactory.getLog(BaseEntity.class);
	
	private OperateType theOperateType;
	private Long rollBackSoNbr;

	public Long getRollBackSoNbr() {
		return rollBackSoNbr;
	}

	public void setRollBackSoNbr(Long rollBackSoNbr) {
		this.rollBackSoNbr = rollBackSoNbr;
	}

	public OperateType getTheOperateType() {
		return theOperateType;
	}

	public void setTheOperateType(OperateType theOperateType) {
		this.theOperateType = theOperateType;
	}

	public <E extends BaseEntity> E add(ServiceContext context) {
		@SuppressWarnings("unchecked")
		E result = (E) context.getBusinessDao().commonAdd(this);
		context.getBusinessDao().flush();
		return result;
	}
	
	public BaseEntity cancel(ServiceContext context) {
		return (BaseEntity) context.getBusinessDao().commonCancel(this);
	}
	
	public BaseEntity modify(ServiceContext context) {
		return (BaseEntity) context.getBusinessDao().commonModify(this);
	}
	
	public BaseEntity modifyExpireDate(ServiceContext context) {
		return (BaseEntity) context.getBusinessDao().commonModifyExpireDate(this);
	}
	
	public BaseEntity rollBack(ServiceContext context) {
		return (BaseEntity) context.getBusinessDao().commonRollBack(this);
	}
	
	public <E extends BaseEntity> E load(ServiceContext context) {
		@SuppressWarnings("unchecked")
		E result = (E) context.getBusinessDao().getEntity(this, this.getFieldOfSelectConditionsOnCommonDaoAnnotation());
		return result;
	}
	
	public void remove(ServiceContext context) {
		try {
			context.getBusinessDao().getSess().refresh(this);
			context.getBusinessDao().remove(this);
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR);
		}
	}
	
	public static <E extends BaseEntity> List<E> queryByServId(ServiceContext context, Class<E> partitionClass, Long servId) {
		if (!BeanCopyHelper.existField(partitionClass, "servId")) throw new BossException(StatusCode.INSIDE_ERROR, partitionClass+"不存在servId属性");
		
		Criteria crit = context.getBusinessDao().getSess().createCriteria(partitionClass);

		try {
			@SuppressWarnings("unchecked")
			List<E> list = crit.add(Restrictions.eq("servId", servId)).add(Restrictions.sqlRestriction("expire_date > sysdate")).list();
			
			return list;
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object getAnnotation(Class aClass, Class annotation) {
		if (!aClass.isAnnotationPresent(annotation)) {
			throw new BossException(StatusCode.INSIDE_ERROR, "The @CommonDao does not exist on class "+aClass.getSimpleName());
		}
		
		return aClass.getAnnotation(annotation);
	}
	
	protected CommonDao getCommonDaoAnnotation() {
		return (CommonDao) getAnnotation(EntityPartitionHelper.getOriginalClassForPartition(this), CommonDao.class);
	}
	
	public String[] getFieldOfSelectConditionsOnCommonDaoAnnotation() {
		CommonDao cd = getCommonDaoAnnotation();
		if (cd.fieldOfSelectConditions() == null) {
			throw new BossException(StatusCode.INSIDE_ERROR,
					"The @CommonDao(fieldOfSelectConditions) does not annotate on class "
							+ this.getClass().getSimpleName());
		}
		return cd.fieldOfSelectConditions();
	}
	
	public CommonDao.DataStoreMode getDataStoreModeOnCommonDaoAnnotation() {
		return getCommonDaoAnnotation().dataStoreMode();
	}
	
	/**
	 * 返回DAO
	 * @deprecated
	 * @param context
	 * @return
	 */
	public BusinessDao getDao(ServiceContext context) {
		return context.getBusinessDao();
	}
	
	/**
	 * 从当前线程中获取本次WS请求的ServiceContext对象
	 * <br/>使用此方法请确保ServiceContext.INSTANCE_IN_THREAD已经被初始化
	 * @return
	 */
	protected static ServiceContext getServiceContext() {
		ServiceContext result = ServiceContext.INSTANCE_IN_THREAD.get();
		if (result == null) throw new BossException(StatusCode.INSIDE_ERROR, "ServiceContext is uninitialized");
		return result;
	}
	
	/**
	 * 从本次WS请求的ServiceContext对象获取BusinessDao
	 * <br/>使用此方法请确保ServiceContext.INSTANCE_IN_THREAD已经被初始化
	 * @return
	 */
	protected static BusinessDao getBusinessDao() {
		return getServiceContext().getBusinessDao();
	}
}
