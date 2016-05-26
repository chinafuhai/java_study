package com.asiainfo.boss4.dao;

import java.util.List;

import com.asiainfo.boss4.domain.CrmUserHis;

/**
 * 开户撤单Dao接口
 * @author xiaopeng
 */
public interface OpenAccountRepealDao extends BusinessDao{

	/**
	 * 查询备份数据
	 * @param entity
	 * @return
	 */
	public Object queryBackup(Object entity);

	/**
	 * 查询历史表中是否有psonbr为soNbr的记录
	 * @param soNbr
	 * @return
	 */
	public CrmUserHis queryCrmUserHisByPsoNbr(Long soNbr);

	/**
	 * 从历史表回滚到CrmUserOther表
	 * @param entity
	 */
	public void rollbackToOther(CrmUserHis crmUserHis);

	/**
	 * 按soNbr删除新增的数据
	 * @param entity
	 */
	public void removeBySoNbr(Object entity);

	/**
	 * 检查是否有其他用户使用被撤单账户
	 * @param servId
	 * @param entity
	 * @return
	 */
	public boolean checkOtherUser(Long servId, Object entity);

	/**
	 * crmAccount数据撤销
	 * @param entity
	 */
	public void rollbackCrmAccount(Object entity);

	/**
	 * 根据soNbr查询要撤单的数据
	 * @param entity
	 * @return
	 */
	public List queryBySoNbr(Object entity);

	/**
	 * 回滚 没有历史表只有新增操作 的数据
	 * @param entity
	 * @param addFlag
	 */
	public void rollback(Object entity, boolean addFlag);

}
