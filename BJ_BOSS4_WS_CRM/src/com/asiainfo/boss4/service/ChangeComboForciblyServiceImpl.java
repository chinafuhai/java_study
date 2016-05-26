package com.asiainfo.boss4.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.BaseDao;
import com.asiainfo.boss4.dao.ChangeComboDao;
import com.asiainfo.boss4.domain.IUserSprom;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.OperateType;
import com.asiainfo.boss4.support.UpFieldUtil;

/**
 * 强制订购套餐服务类
 * @author xiaopeng
 */
public class ChangeComboForciblyServiceImpl extends BusinessServiceImpl implements BusinessService{

	private static Log logger = LogFactory.getLog(ChangeComboForciblyServiceImpl.class);
	
	private ChangeComboDao changeComboDao;
	
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public ChangeComboDao getChangeComboDao() {
		return changeComboDao;
	}

	public void setChangeComboDao(ChangeComboDao changeComboDao) {
		this.changeComboDao = changeComboDao;
	}

	public String process(LazyDynaMap vo, Map requestStatus) {
		
		// 取交易代码
		String tranCode = (String) vo.get("tranCode");
		if (tranCode == null) {
			logger.error("未指定交易代码");
			throw new BossException(StatusCode.NO_INPUT_TRANCODE_ERROR);
		}
		
		// 取业务操作类型（新增）
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
		
		// 取此交易需要操作的实体类
		OneOpreateConfig config =  OperateConfiguration.getConfigByTranCode(tranCode);
		//更新标志串  UP_FIELD 
		UpFieldUtil.setUpField(vo);
		// 设置消息编号，一个交易(item)拥有同一个消息编号
		Object sid = changeComboDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses());
		
		if (OperateType.ADD.getTypeCode().equals(operType)) {
			for (int i = 0; i < entityList.size(); i++) {
				Object entity = entityList.get(i);
				if (IUserSprom.class.equals(entity.getClass())) {
					
					IUserSprom iUserSprom = (IUserSprom) entity;
					
					/*
					 * 强制订购新套餐，以下月初零时失效其互斥套餐和生效时间重叠的套餐
					 */
					//查询互斥套餐
					List list =  changeComboDao.queryMutex(entity);
					if (list.size()>0) {
						Date currentDate = changeComboDao.queryCurrentDate();
						Date nextMonthFirstDay = DateHelper.getNextMonthFirstDay(currentDate);
						//以下月初零时失效互斥套餐
						for (Object object : list) {
							IUserSprom mutexSprom = (IUserSprom) object;
							mutexSprom.setExpireDate(nextMonthFirstDay);
							baseDao.update(mutexSprom);
						}
					}
					//如果不是订购标准套餐，查询生效时间重叠的套餐
					if (!iUserSprom.getSpromType().toString().startsWith(AppConstant.STANDARD_COMBO_PREFIX)){
						//查询生效时间重叠的套餐
						list = changeComboDao.queryInterleaveSprom(entity);
						if (list.size()>0) {
							Date currentDate = changeComboDao.queryCurrentDate();
							Date nextMonthFirstDay = DateHelper.getNextMonthFirstDay(currentDate);
							//以下月初零时失效重叠套餐
							for (Object object : list) {
								IUserSprom interleaveSprom = (IUserSprom) object;
								interleaveSprom.setExpireDate(nextMonthFirstDay);
								baseDao.update(interleaveSprom);
							}
						}
					}
					//如果订购的是GPRS标准套餐，不写入数据
					if (iUserSprom.getSpromType().toString().startsWith(AppConstant.STANDARD_COMBO_PREFIX)) {
						changeComboDao.add(entity);
					}
				}
				else {//其它表（上发表）
					changeComboDao.add(entity);
				}
			}
		} 
		else {
			logger.error("没有匹配的操作类型");
			throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
		}
		
		return null;
	}

}
