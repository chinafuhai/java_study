package com.asiainfo.boss4.dao;


import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;

/**
 * 国际漫游、长途、语音服务（开通）Dao实现
 * @deprecated
 * @author xiaopeng
 */
public class GlobalRoamingDaoImpl extends BusinessDaoImpl implements GlobalRoamingDao{
	private static Log logger = LogFactory.getLog(RepealChangeBrandDaoImpl.class);

	public void insertGlobalRoaming(Object entity) {

		try {
			PropertyUtils.setProperty(entity, "soId", PropertyUtils.getProperty(entity, "soNbr"));
		} catch (Exception e) {
			logger.debug("从实体取soNbr向soId赋值失败");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		//调用businessDao的add()方法
		super.add(entity);
		
	}
}
