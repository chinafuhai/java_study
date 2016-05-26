package com.asiainfo.boss4.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.GlobalRoamingDao;
import com.asiainfo.boss4.domain.ISaleOper;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;

/**
 * 国际漫游、长途、语音服务（开通）服务类
 * @deprecated
 * @author xiaopeng
 */
public class GlobalRoamingServiceImpl implements BusinessService {
	
	private static Log logger = LogFactory.getLog(ChangeComboServiceImpl.class);

	private GlobalRoamingDao globalRoamingDao;

	public GlobalRoamingDao getGlobalRoamingDao() {
		return globalRoamingDao;
	}

	public void setGlobalRoamingDao(GlobalRoamingDao globalRoamingDao) {
		this.globalRoamingDao = globalRoamingDao;
	}

	public String process(LazyDynaMap vo, Map requestStatus) {
		// 取业务操作类型（新增，取消，变更）
		String operType = null;
		try {
			operType = (String) vo.get("operType");
			if (operType == null) {
				throw new Exception("交易代码为空");
			}
		} catch (Exception e1) {
			logger.error("未指定交易的操作类型");
			throw new BossException(StatusCode.NO_INPUT_OPERTYPE_ERROR, e1);
		}
		
		// 取交易代码
		String tranCode = (String) vo.get("tranCode");
		if (tranCode == null) {
			logger.error("未指定交易代码");
			throw new BossException(StatusCode.NO_INPUT_TRANCODE_ERROR);
		}
		
		// 取此交易需要操作的实体类
		OneOpreateConfig config =  OperateConfiguration.getConfigByTranCode(tranCode);


		// 设置消息编号，一个交易(item)拥有同一个消息编号
		Object sid = globalRoamingDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses());
		
		for (int i = 0; i < entityList.size(); i++) {
			Object entity = entityList.get(i);
			if (ISaleOper.class.equals(entity.getClass())) {
				continue;
			}
			globalRoamingDao.insertGlobalRoaming(entity);
		}
		return null;
	}

}
