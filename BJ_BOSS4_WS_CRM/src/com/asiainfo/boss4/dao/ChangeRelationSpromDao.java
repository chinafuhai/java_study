package com.asiainfo.boss4.dao;

import java.util.Set;

public interface ChangeRelationSpromDao extends BusinessDao {
	
	/**
	 * 插入亲情号码的促销数据（如果已有普通亲情号码的促销数据，不写入）
	 * @param entity
	 * @param rservId 
	 * @return
	 */
	int insertRelationSprom(Object entity, String rservId);

	/**
	 * 取消亲情号码的促销数据
	 * 修改促销数据的失效时间为亲情号码的最晚失效时间
	 * @param entity
	 * @param conditions
	 * @return
	 */
	int cancelRelationSprom(Object entity, String[] conditions);
	
	/**
	 * 修改普通号码套餐的失效时间为号码的最晚失效时间
	 * @param entity
	 * @param spromId
	 * @return
	 */
	public Object modifyRelationSprom(Object entity, Integer spromId, String operation);
	
	
	/**
	 * 回滚亲情号码的促销数据（撤单）
	 * 对于普通号码的促销：同取消一样修改促销数据的失效时间为亲情号码的最晚失效时间
	 * 对于普通号码的促销：调用通用的撤单操作
	 * @param entity
	 * @param conditions
	 * @return
	 */
	Object rollbackRelationSprom(Object entity, String[] conditions, Set updateSoIdSQL);

}
