package com.asiainfo.boss4.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

import com.asiainfo.boss4.dao.BusinessDao;

public class DaoAdvice {
	private Log logger = LogFactory.getLog(DaoAdvice.class);
	
	private BusinessDao businessDao;

	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}
	
	/**
	 * 每次交易（item）处理结束时进行Session刷出,同步数据状态到JDBC连接
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	public Object flushOnService(ProceedingJoinPoint pjp) throws Throwable {
		Object retVal = pjp.proceed();
		businessDao.flush();
		logger.debug("Session刷出完成");
		return retVal;
	}
}
