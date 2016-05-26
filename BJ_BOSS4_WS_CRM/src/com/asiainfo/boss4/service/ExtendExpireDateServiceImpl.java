package com.asiainfo.boss4.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.domain.ISaleOper;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.UpFieldUtil;
/**
 * 延长有效期服务实现
 * @deprecated
 * 
 * @author caohui
 *
 */
public class ExtendExpireDateServiceImpl implements BusinessService {
	private static Log logger = LogFactory.getLog(ExtendExpireDateServiceImpl.class);
	
	private BusinessDao businessDao;
	
	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}

	public String process(LazyDynaMap vo, Map requestStatus) {
		
		// 取此交易需要操作的实体类
		OneOpreateConfig config =  OperateConfiguration.getConfigByTranCode(vo.get("tranCode").toString());
		
		// 更新UP_FIELD标志串
		UpFieldUtil.setUpField(vo);
		
		// 设置消息编号，一个交易(item)拥有同一个消息编号
		Object sid = businessDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		
		// 取数据库当前时间
		Date currentDate = businessDao.queryCurrentDate();
		
		// 取需要延长有效期的天数
		String expireDateVO = (String)vo.get("expireDate");
		if (expireDateVO == null || "".equals(expireDateVO)) {
			logger.debug("无法获取传入的expireDate属性的值");
			throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR);
		}
		vo.remove("expireDate"); // 移除expireDate属性，防止生成实体时出错
		int extendAmount;
		try {
			extendAmount = Integer.parseInt(expireDateVO);
		} catch (NumberFormatException e) {
			logger.error("无法转换的数字类型，请检查输入");
			throw new BossException(StatusCode.CLASS_CAST_ERROR, e);
		}
		
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses());
		
		for (int i = 0; i < entityList.size(); i++) {
			Object entity = entityList.get(i);
			if (ISaleOper.class.equals(entity.getClass())) {
				businessDao.add(entity);
				continue;
			}
			String[] conditions = config.getConditionCols(entity.getClass().getName());
			
			// 从数据库中取实体记录，拿到原有失效日期
			Object entityPO = businessDao.queryEntity(entity, conditions);
			Date expireDatePO = null;
			try {
				expireDatePO = (Date)PropertyUtils.getProperty(entityPO, "expireDate");
				if (expireDatePO == null) {
					throw new Exception();
				}
			} catch (Exception e) {
				logger.error("无法获取实体的expireDate属性");
				throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
			}
			
			// 希望延长的日期
			Calendar expectedCalendar = Calendar.getInstance();
			expectedCalendar.setTime(expireDatePO);
			expectedCalendar.add(Calendar.DAY_OF_MONTH, extendAmount);
			// 最多可延长的日期（当前时间后延720天）
			Calendar maxCalendar = Calendar.getInstance();
			maxCalendar.setTime(currentDate);
			maxCalendar.add(Calendar.DAY_OF_MONTH, AppConstant.MAX_EXTEND_EXPIREDATE_AMOUNT);
			
			// 设置延长日期
			Date expireDate = null;
			if (expectedCalendar.compareTo(maxCalendar) < 0) { // 判断希望延长的日期是否在最多可延长的日期之前
				expireDate = expectedCalendar.getTime();
			} else {
				expireDate = maxCalendar.getTime();
			}
			
			try {
				BeanUtils.copyProperty(entity, "expireDate", expireDate);
			} catch (Exception e) {
				logger.error("无法为实体的expireDate属性赋值");
				throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
			}
			
			businessDao.changeWithMerge(entity, conditions, currentDate);
			
		}
		
		businessDao.flush();
		
		return null;
	}
}
