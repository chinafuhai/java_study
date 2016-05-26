package com.asiainfo.boss4.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.domain.InBusiBatch;
import com.asiainfo.boss4.domain.InBusiBatchDetail;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;

public class InBusiBatchServiceImpl implements InBusiBatchService {
	
	private static Log logger = LogFactory.getLog(InBusiBatchServiceImpl.class);
	
	BusinessDao businessDao;

	public BusinessDao getBusinessDao() {
		return businessDao;
	}

	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}

	public void saveBatchData(Map map) {
		try {
			InBusiBatch inBusiBatch = (InBusiBatch) map.get("inBusiBatch");
			List detailList = (List) map.get("detailList");
			Date createDate = new Date();
			for (Object object : detailList) {
				InBusiBatchDetail inBusiBatchDetail = (InBusiBatchDetail) object;
				inBusiBatchDetail.setCreateDate(createDate);
				businessDao.add(inBusiBatchDetail);
				businessDao.flush();
			}
			inBusiBatch.setCreateDate(createDate);
			businessDao.add(inBusiBatch);
			businessDao.flush();
		} catch (Exception e) {
			logger.debug("保存批量业务数据失败");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

}
