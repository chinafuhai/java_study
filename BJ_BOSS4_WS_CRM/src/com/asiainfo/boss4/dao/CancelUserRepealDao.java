package com.asiainfo.boss4.dao;

import com.asiainfo.boss4.domain.CrmUserOther;
import com.asiainfo.boss4.domain.IUser;

public interface CancelUserRepealDao extends BusinessDao{
	
	/**
	 * 从HIS表回滚crm表数据
	 * @param entity
	 * @return
	 */
	public Object rollbackCrm(Object entity);
	
	/**
	 * 从RB表回滚多条数据
	 * @param entity
	 * @return
	 */
//	public Object rollbackMuti(Object entity);

	/**
	 * 按soNbr从RB表中恢复删除的数据
	 * @param soNbr
	 */
	public void rollbackDeleteRecords(Long soNbr, Class entity);

	/**
	 * 将Other表中的一条指定数据移回原表
	 * @param userOther
	 */
	public void moveBackFromOther(CrmUserOther userOther);

	/**
	 * 根据soNbr从IUserAll中查询用户
	 * （动感地带退网及撤单都未传servId）
	 * @param soNbr
	 * @return
	 */
	public IUser queryServIdBySoNbr(Long soNbr);

}
