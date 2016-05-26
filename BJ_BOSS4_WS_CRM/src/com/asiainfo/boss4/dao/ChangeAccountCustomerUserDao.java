package com.asiainfo.boss4.dao;

import com.asiainfo.boss4.domain.IMsisdnVsCust;

public interface ChangeAccountCustomerUserDao extends BusinessDao{
	
	
	/**
	 * 查询sid最大的一条数据，不一定是有效数据
	 * @param entity
	 * @return
	 */
	public IMsisdnVsCust queryIMsisdnVsCust(Object entity);

}
