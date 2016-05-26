package com.asiainfo.boss4.dao;

import java.util.ArrayList;
import java.util.List;


import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import com.asiainfo.boss4.domain.BsGrtProduct;
import com.asiainfo.boss4.domain.IUserSprom;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;



/**
 * 查询用户gprs套餐Dao实现类
 * @author weihf
 */
public class UserSpromDaoImpl extends BusinessDaoImpl implements UserSpromDao{
	private static Log logger = LogFactory.getLog(UserSpromDaoImpl.class);
	

	public List querySpromEntity(Object entity) {
		String spromType = null;
		Long servId = null;
		try {
			spromType = (String) PropertyUtils.getProperty(entity, "spromPara");
			servId = (Long) PropertyUtils.getProperty(entity, "servId");
		}
		catch (Exception e) {
			logger.debug("从实体取spromType、servId赋值失败");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("from BsGrtProduct").append(" where trim(remark) like '%'||:spromType||'%' and expireDate>sysdate and expireDate>validDate and validDate<=sysdate ");
		Query query = this.baseDao.createQuery(sqlBuffer.toString());
		query.setParameter("spromType", spromType.toUpperCase());
		List spromList = query.list();
		List list = new ArrayList();
		for (int i=0;i<spromList.size();i++)
		{
			BsGrtProduct obj = (BsGrtProduct)spromList.get(i);
			sqlBuffer = new StringBuffer();
			sqlBuffer.append("from ").append(entity.getClass().getSimpleName()).
				append(" where expireDate>sysdate and expireDate>validDate and spromId=:spromId and servId=:servId order by validDate");
			query = this.baseDao.createQuery(sqlBuffer.toString());
			query.setParameter("spromId", obj.getProdId());
			query.setParameter("servId", servId);
			
			List l = query.list();
			if (l.size()>0)
			{
				IUserSprom sprom = (IUserSprom)l.get(0);
				IUserSprom userSprom = new IUserSprom();
				BeanCopyHelper.copyBeanNotNullProperty(userSprom,sprom);
				userSprom.setRemark(obj.getProdDesc());
				list.add(userSprom);

			}
		}
		return list;
	}

}
