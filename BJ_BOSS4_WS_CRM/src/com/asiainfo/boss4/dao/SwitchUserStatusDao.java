package com.asiainfo.boss4.dao;

import com.asiainfo.boss4.domain.CrmUser;

public interface SwitchUserStatusDao {
	/**
	 * 根据servID修改CrmUser中的状态
	 */
	public void updateCrmUser(CrmUser user,String[] constraints,String operSts);
	/**
	 * 查看是否存在停机记录
	 * @param servId
	 * @return
	 */
	public boolean isExistStatusRec(Long servId);
	public boolean isExistStatusRecByMgntSts(Long servId, Byte mgntSts);
	public void deleteStatusRecByMgntSts(Long servId, Byte mgntSts);
}
