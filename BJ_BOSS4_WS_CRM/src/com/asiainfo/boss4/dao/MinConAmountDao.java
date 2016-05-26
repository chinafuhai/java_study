package com.asiainfo.boss4.dao;

import java.util.List;

public interface MinConAmountDao {
	/**
	 * 根据servid查询低消金额（最低消费金额）
	 */
	public List<Object[]> queryMinConAmount(Long servId); 
}
