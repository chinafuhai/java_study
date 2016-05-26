package com.asiainfo.boss4.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.KindnessProvinceDao;
import com.asiainfo.boss4.domain.ISaleOper;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.StringHelper;
import com.asiainfo.boss4.support.UpFieldUtil;

public class KindnessProvinceRepealServiceImpl implements BusinessService{
	
	Log logger = LogFactory.getLog(KindnessProvinceRepealServiceImpl.class);
	
	private KindnessProvinceDao kindnessProvinceDao;

	public String process(LazyDynaMap vo, Map requestStatus) {
		// 取交易代码
		String tranCode = (String) vo.get("tranCode");
		if (tranCode == null) {
			logger.error("未指定交易代码");
			throw new BossException(StatusCode.NO_INPUT_TRANCODE_ERROR);
		}
		
		// 取此交易需要操作的实体类
		OneOpreateConfig config =  OperateConfiguration.getConfigByTranCode(tranCode);
		// 设置消息编号，一个交易(item)拥有同一个消息编号
		Object sid = kindnessProvinceDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses());
		
		for (int i = 0; i < entityList.size(); i++) {
			Object entity = entityList.get(i);
			if (ISaleOper.class.equals(entity.getClass())) {
				continue;//下面根据撤单后返回对象的spromType更新标志串  UP_FIELD
			}
			Object o = kindnessProvinceDao.rollback(entity);
			String spromType = null;
			try {
				spromType = PropertyUtils.getProperty(o, "spromType").toString();
			}catch (Exception e) {
				logger.error("无法取出实体" + StringHelper.getClassName(o.getClass()) + "的spromType属性");
				throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
			}
			if (o != null) {
				vo.set("spromType", spromType);
			}
		}
	
		for (int i = 0; i < entityList.size(); i++) {
			Object entity = entityList.get(i);
			if (ISaleOper.class.equals(entity.getClass())) {
				StringBuffer upfield = new StringBuffer(UpFieldUtil.EMPTY_UPFIELD);
				UpFieldUtil.modifyUpFieldBySpromType(upfield, (String) vo.get("spromType"));
				BeanCopyHelper.setProperty(entity, "upField", upfield.toString());
				kindnessProvinceDao.add(entity);
			}
		}
		return null;
	}

	public KindnessProvinceDao getKindnessProvinceDao() {
		return kindnessProvinceDao;
	}

	public void setKindnessProvinceDao(KindnessProvinceDao kindnessProvinceDao) {
		this.kindnessProvinceDao = kindnessProvinceDao;
	}


}
