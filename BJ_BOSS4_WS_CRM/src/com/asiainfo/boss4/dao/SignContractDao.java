package com.asiainfo.boss4.dao;

import com.asiainfo.boss4.domain.AccBatchDeductOrder;


public interface SignContractDao  extends BusinessDao{
	/**
	 * 根据msisdn查询指定用户的有效签约数据
	 * @param entity
	 * @return
	 */
	public AccBatchDeductOrder queryAccBatchDeductOrderEntity(Object entity);
}
