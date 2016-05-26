package com.asiainfo.boss4.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.domain.ISaleOper;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.OperateType;
import com.asiainfo.boss4.support.UpFieldUtil;

/**
 * 回滚操作服务类
 */
public class BusinessRepealServiceImpl implements BusinessService {
	private static Log logger = LogFactory.getLog(BusinessRepealServiceImpl.class);
	private BusinessDao businessDao;
	
	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}

	public String process(LazyDynaMap vo, Map requestStatus) {
		// 取交易代码
		String tranCode = (String) vo.get("tranCode");
		
		// 取此交易需要操作的实体类
		OneOpreateConfig config = OperateConfiguration.getConfigByTranCode(tranCode);
		//设置UpField标志串
		UpFieldUtil.setUpField(vo);
		// 设置消息编号，一个交易(item)拥有同一个消息编号
		Object sid = businessDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses());
		
		for (int i = 0; i < entityList.size(); i++) {
			Object entity = entityList.get(i);
			Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
			if (ISaleOper.class.equals(entityClass)) {
				businessDao.add(entity);
				continue;
			}
			if (OperateType.REMOVE.getTypeCode().equals(config.getOperateType(entityClass.getName()))) {
				String[] conditions = config.getConditionCols(entityClass.getName());
				businessDao.remove(entity, conditions);
			} else {
				businessDao.rollback(entity);
			}
		}
		return null;
	}
	

}
