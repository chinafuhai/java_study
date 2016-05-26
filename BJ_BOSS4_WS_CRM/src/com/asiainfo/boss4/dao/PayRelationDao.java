package com.asiainfo.boss4.dao;

import com.asiainfo.boss4.domain.IUserPayRelation;

public interface PayRelationDao extends BusinessDao {
	/**
	 * 根据产品ID返回分账公式ID
	 * @param prodId
	 * @return
	 */
	Integer getFormulaIdByProduct(Long prodId);
	
	/**
	 * 根据用户ID和产品ID获取分账信息
	 * @param servId
	 * @param prodId
	 * @return
	 */
	IUserPayRelation queryPayRelationInfoByProdId(Long prodId);
}
