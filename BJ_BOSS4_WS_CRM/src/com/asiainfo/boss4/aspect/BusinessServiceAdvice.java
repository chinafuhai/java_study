package com.asiainfo.boss4.aspect;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

import com.asiainfo.boss4.dao.CancelUserDao;
import com.asiainfo.boss4.domain.IUserSmsOrder;
import com.asiainfo.boss4.domain.OweNoPressStop;

/**
 * 针对Service实现类的业务逻辑切面
 * @deprecated
 * @author caohui
 * 
 */
public class BusinessServiceAdvice {
	private Log logger = LogFactory.getLog(BusinessServiceAdvice.class);

	private CancelUserDao cancelUserDao;

	public void setCancelUserDao(CancelUserDao cancelUserDao) {
		this.cancelUserDao = cancelUserDao;
	}
	
	/**
	 * 销户时清空短信提醒表
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	public Object clearIUserSmsOrderWhenCloseAccount(ProceedingJoinPoint pjp) throws Throwable {
		Object result = pjp.proceed();
		logger.debug("clearing IUserSmsOrder.");
		LazyDynaMap vo = (LazyDynaMap) pjp.getArgs()[0];
		
		// 查出指定serv_id下的所有短信提醒记录
		Map<String, Object> params = new HashMap<String, Object>(1);
		params.put("servId", new Long((String)vo.get("servId")));
		List<IUserSmsOrder> smsList = cancelUserDao.queryEntitysToList(IUserSmsOrder.class, params);
		
		String[] constraints = new String[]{"servId", "smsOrderType", "operType"};
		for (IUserSmsOrder entity : smsList) {
			cancelUserDao.backup(entity, constraints, "his"); // 备份记录至HIS表
			cancelUserDao.remove(entity, constraints); // 删除记录
			cancelUserDao.flush();
		}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public Object clearOweNoPressStopWhenCloseAccount(ProceedingJoinPoint pjp) throws Throwable {
		Object result = pjp.proceed();
		logger.debug("clearing OweNoPressStop.");
		LazyDynaMap vo = (LazyDynaMap) pjp.getArgs()[0];
		
		// 查出指定serv_id下的免催免停记录
		Map<String, Object> params = new HashMap<String, Object>(1);
		params.put("servId", new Long((String)vo.get("servId")));
		List<OweNoPressStop> smsList = cancelUserDao.queryEntitysToList(OweNoPressStop.class, params);
		
		String[] constraints = new String[]{"servId", "subbusiId", "custId","acctFlag", "acctId", "servFlag", "sortTypeCode"};
		for (OweNoPressStop entity : smsList) {
			cancelUserDao.backup(entity, constraints, "his"); // 备份记录至HIS表
			cancelUserDao.remove(entity, constraints); // 删除记录
			cancelUserDao.flush();
		}
		
		return result;
	}
}
