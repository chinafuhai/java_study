package com.asiainfo.boss4.dao;

import com.asiainfo.boss4.domain.CrmBossIdtypeMap;
/**
 * 查询Boss映射Id流程 dao接口
 * 
 * @author caohui
 *
 */
public interface QueryBoss4IdDao extends BusinessDao {
	
	/**
	 * 查询ID映射
	 * @param idType ID类型
	 * @param crmId crm端ID的值
	 * @return
	 */
	public CrmBossIdtypeMap query(String idType, String crmId);
	
	/**
	 * 生成ID映射
	 * @param idType ID类型
	 * @param crmId crm端ID的值
	 * @return
	 */
	public CrmBossIdtypeMap add(String idType, String crmId);
}
