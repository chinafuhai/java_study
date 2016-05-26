package com.asiainfo.report.dao;

import java.io.Serializable;
import java.util.List;

public interface ReportBaseDao {
	List queryForList(String sql);
	
	List queryForList(String sql,List<String[]> param);

	List queryForHallStatisc(String sql,List<String[]> param);
	
	Object queryForObject(String sql);
	
	
	Serializable save(Object bean);

	Object querySysdate();
	
	String queryDaySeq();
	/**
	 * 财务营收日报 序号获取
	 */
	String queryMisSeq();
	
	public String querySid();
	
	void createSQLQuery(String sql);
	
	/**
	 * Boss4 ID 转换成CRM ID 
	 * @param id 
	 * @param type 1 营业厅编号转换  2 营业员转换
	 * @return
	 */
	public String BossToCrmConvert(String id,String type);
	/**
	 * CRMID 转BOSS ID
	 * @param id  type
	 * @param type 1 厅台  2 营业员
	 * @return
	 */
	public String CrmToBossConvert(String id,String type);
	/**
	 * Boss4 ID 与CRM厅台名称转换 
	 * 营业员日结算专用
	 * @param id  type
	 * @param type 1 厅台名ToBossId  2 BossId To 厅台名
	 * @return
	 */
	public String BossCrmNameConvert(String id,String type);
	/**
	 * 通过bossid查询crm与boss映射表中查询出crm对应的厅台号与名称
	 * @param bossid bossid
	 * @return
	 */
	public String[] hallInfoReturn(String bossid);
	
	public String[] queryPosFee(String hallNo,String dealDate);
	
	public String[] queryNetWorkFee(String hallNo,String dealDate);
	
	/**
	 * 批量插入更新方法 
	 * 适用于财务营收日报，财务稽核日报保存
	 * @param args
	 */
	public void prepareStatementInsertAndUpdate(final List<String[]> valueList,final String prepareSql,final int paramNum);
	
	public String queryMisItemSeq();
	
	public String queryTaxRate(String misGroupNo);
}
