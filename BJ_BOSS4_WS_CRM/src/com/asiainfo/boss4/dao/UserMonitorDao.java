package com.asiainfo.boss4.dao;

import com.asiainfo.boss4.domain.CrmUserMonitor;
import com.asiainfo.boss4.domain.CrmUserMonitorHis;
import com.asiainfo.boss4.domain.IUser;
import com.asiainfo.boss4.domain.IUserMonitor;
import com.asiainfo.boss4.domain.IUserVpmn;


public interface UserMonitorDao extends BusinessDao {
	/**
	 * 根据servId查询指定用户的有效欠控数据
	 * @param entity
	 * @return
	 */
	public IUserMonitor queryIUserMonitorEntity(Object entity);
	public CrmUserMonitor queryCrmUserMonitorEntity(Object entity);
	public CrmUserMonitorHis queryCrmUserMonitorHisEntity(Object entity);
	public void saveOrUpdate(IUserVpmn vpmn);
	public void saveSaleOper(IUser iuser, Long sid,Long soNbr);
}
