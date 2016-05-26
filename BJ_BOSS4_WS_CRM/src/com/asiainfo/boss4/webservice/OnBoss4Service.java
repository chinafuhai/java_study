package com.asiainfo.boss4.webservice;
/**
 * Web Service 接口类
 * @author caohui
 *
 */
public interface OnBoss4Service {
	/**
	 * 订单类业务
	 * @param inputXml
	 * @return
	 */
	public String onBoss4(String inputXml);
	
	/**
	 * 批量业务（开通）
	 * @param inputXml
	 * @return
	 */
	public String onBoss4BatchKt(String inputXml);
	
	/**
	 * 批量业务（计费）
	 * @param inputXml
	 * @return
	 */
	public String onBoss4Batch(String inputXml);
	
	/**
	 * 批量业务
	 * @param inputXml
	 * @return
	 */
	public String onCpcOrder(String inputXml);
	
	/**
	 * 新CRM
	 * @param inputXml
	 * @return
	 */
	public String onBoss4Crm(String inputXml);
	
	/**
	 * 通过BOSSID反查CRMID
	 * @param inputXml
	 * @return
	 */
	public String queryCrmId(String inputXml);
	
	/**
	 * 新CRM查询接口
	 * @param inputXml
	 * @return
	 */
	public String queryCrm(String inputXml);
}
