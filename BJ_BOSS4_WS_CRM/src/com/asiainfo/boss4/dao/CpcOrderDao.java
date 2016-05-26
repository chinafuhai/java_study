package com.asiainfo.boss4.dao;

import java.util.Map;

import com.asiainfo.boss4.domain.CpcTransRule;
import com.asiainfo.boss4.domain.IUserOrder;

public interface CpcOrderDao extends BusinessDao {
	/**
	 * 取CPC映射配置
	 * @param spId
	 * @param spBizCode
	 * @return
	 */
	CpcTransRule getCpcTransRule(String spId, String spBizCode);
	/**
	 * 从zg.i_user_enterprise_xxxx表中取serv_id
	 * @deprecated
	 * @param serviceCode
	 * @return
	 */
	Long getServIdFromEnterprise(String serviceCode);
	/**
	 * 从zg.i_user_pbx_xxxx表中取serv_id
	 * @deprecated
	 * @param inTrunk
	 * @return
	 */
	Long getServIdFromPbx(String inTrunk);
	/**
	 * 查询最后一条订购记录的历史首次订购，首次订购，上次订购，本次订购时间
	 * Map.keySet(): ORDER_STS, HIS_FIRST_ORDER_TIME, FIRST_ORDER_TIME, LAST_ORDER_TIME, CHANGE_TIME
	 * @param order
	 * @return
	 */
	Map<String,Object> getLastIUserOrder(IUserOrder order);
	/**
	 * 查询order_sts为指定值的最后一条订购记录的历史首次订购，首次订购，上次订购，本次订购时间
	 * Map.keySet(): ORDER_STS, HIS_FIRST_ORDER_TIME, FIRST_ORDER_TIME, LAST_ORDER_TIME, CHANGE_TIME
	 * @param order
	 * @param orderSts 指定的order_sts
	 * @return
	 */
	Map<String,Object> getLastIUserOrder(IUserOrder order, Byte orderSts);
	/**
	 * 失效IUserOrder，不更新orderSts
	 * @param order
	 */
	void cancelIUserOrder(IUserOrder order);
	/**
	 * 失效IUserOrder，不更新orderSts
	 * 如果sid非空，则更新sid
	 * @param order
	 * @param sid
	 */
	void cancelIUserOrder(IUserOrder order, Long sid);
	/**
	 * 根据CRM传入值查询有效的IUserOrder<br/>
	 * 没有记录返回null<br/>
	 * 仅一条记录则直接返回<br/>
	 * 多条记录时需要判断：
	 * <li>如果传入时间为月初一号零时，取下月生效记录</li>
	 * <li>如果传入时间为当前时间(非月初一号零时)，取月底失效记录</li>
	 * <li>都不符合，则抛出StatusCode.QUERY_ENTITY_VALUE_ERROR异常</li>
	 * @param entity
	 * @return
	 */
	IUserOrder queryIUserOrder(IUserOrder entity);
	/**
	 * 更新IUserOrder，失效已经存在的订购状态，生效新的订购状态
	 * @param existedOrder 数据库中已经存在的订购
	 * @param expectedOrder CRM传入的新订购
	 * @param updateFields	需要更新的字段
	 */
	void changeIUserOrder(IUserOrder existedOrder, IUserOrder expectedOrder, String[] updateFields);

}
