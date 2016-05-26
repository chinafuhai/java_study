package com.asiainfo.boss4.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.ChangeRelationSpromDao;
import com.asiainfo.boss4.domain.ISaleOper;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.UpFieldUtil;

/**
 * 亲情号码促销数据的撤单服务类
 * @author xiaopeng
 */
public class RepealChangeRelationSpromServiceImpl implements BusinessService{

	private static Log logger = LogFactory.getLog(RepealChangeRelationSpromServiceImpl.class);
	
	private ChangeRelationSpromDao changeRelationSpromDao;

	public ChangeRelationSpromDao getChangeRelationSpromDao() {
		return changeRelationSpromDao;
	}

	public void setChangeRelationSpromDao(
			ChangeRelationSpromDao changeRelationSpromDao) {
		this.changeRelationSpromDao = changeRelationSpromDao;
	}

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
		Object sid = changeRelationSpromDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses());
		
		// 设置散列表，用来放置更新soId的SQL
		Set updateSoIdSQL = null;
		if (requestStatus.get(AppConstant.REQUEST_STATUS_MAP_UPDATE_SOID) == null) {
			updateSoIdSQL =  new HashSet();
			requestStatus.put(AppConstant.REQUEST_STATUS_MAP_UPDATE_SOID, updateSoIdSQL);
		} else {
			updateSoIdSQL = (Set) requestStatus.get(AppConstant.REQUEST_STATUS_MAP_UPDATE_SOID);
		}
		
		for (int i = 0; i < entityList.size(); i++) {
			Object entity = entityList.get(i);
			if (ISaleOper.class.equals(EntityPartitionHelper.getOriginalClassForPartition(entity))) {
				continue;//下面根据查询后返回的spromType更新标志串  UP_FIELD
			}
			String[] conditions = config.getConditionCols(EntityPartitionHelper.getOriginalClassForPartition(entity).getName());
			Object o = changeRelationSpromDao.rollbackRelationSprom(entity, conditions, updateSoIdSQL);
			if (o != null) {
				vo.set("spromType", o);
			}
		}
	
		for (int i = 0; i < entityList.size(); i++) {
			Object entity = entityList.get(i);
			if (ISaleOper.class.equals(EntityPartitionHelper.getOriginalClassForPartition(entity))) {
				StringBuffer upfield = new StringBuffer(UpFieldUtil.EMPTY_UPFIELD);
				UpFieldUtil.modifyUpFieldBySpromType(upfield, (String) vo.get("spromType"));
				BeanCopyHelper.setProperty(entity, "upField", upfield.toString());
				changeRelationSpromDao.add(entity);
			}
		}
		return null;
	}

}
