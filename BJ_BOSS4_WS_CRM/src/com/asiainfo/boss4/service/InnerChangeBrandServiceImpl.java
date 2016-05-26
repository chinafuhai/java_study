package com.asiainfo.boss4.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.BaseDao;
import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.domain.ISaleOper;
import com.asiainfo.boss4.domain.IUserSmsOrder;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.StringHelper;
import com.asiainfo.boss4.support.UpFieldUtil;

/**
 * 全网携号转品牌-内部互转Service实现类
 * @author xiaopeng
 */
public class InnerChangeBrandServiceImpl implements BusinessService{
	
	private static Log logger = LogFactory.getLog(InnerChangeBrandServiceImpl.class);
	private BusinessDao businessDao;

	public String process(LazyDynaMap vo, Map requestStatus) {
		// 取交易代码
		String tranCode = (String) vo.get("tranCode");
		
		// 取此交易需要操作的实体类
		OneOpreateConfig config =  OperateConfiguration.getConfigByTranCode(tranCode);
		//更新标志串  UP_FIELD 
		UpFieldUtil.setUpField(vo);
		// 设置消息编号，一个交易(item)拥有同一个消息编号
		Object sid = businessDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		
		// 取数据库当前时间
		Date currentDate = businessDao.queryCurrentDate();
		//取当前时间的当月1号零时零时零秒
		Date date = DateHelper.getCurrentMonthFirstDay(currentDate);
		
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses());
		
		for (int i = 0; i < entityList.size(); i++) {
			this.businessDao.flush();
			Object entity = entityList.get(i);
			if (ISaleOper.class.equals(entity.getClass())) {
				businessDao.add(entity);
				continue;
			}
			String[] conditions = config.getConditionCols(entity.getClass().getName());
			String[] updateFields = config.getUpdateFields(entity.getClass().getName());
			
			if (!StringHelper.isClassWithCrmPrefix(entity.getClass())) {//非CRM表
				/*
				 * 更新旧数据指定字段，用当月1号零时的时间失效旧数据，
				 * 复制并插入一条新数据，新数据生效时间为当月1号零时
				 */
				businessDao.changeWithMerge(entity, conditions, updateFields, date);
			}
			else {//CRM表
				//备份数据
				businessDao.backupCrm(entity, conditions);
				//更新数据的指定字段
				businessDao.changeCrm(entity, conditions, updateFields);
			}
			
		}
		return null;
	}

	public BusinessDao getBusinessDao() {
		return businessDao;
	}

	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}
}
