package com.asiainfo.boss4.dao;

import java.util.List;
import java.util.Map;

import com.asiainfo.boss4.domain.ISpromParam;
import com.asiainfo.boss4.domain.IUserCell;
import com.asiainfo.boss4.domain.IUserSprom;
import com.asiainfo.boss4.domain.IUserSpromConfig;

/**
 * 套餐变更Dao接口
 * @author xiaopeng
 */
public interface ChangeComboDao extends BusinessDao{
	
	/**
	 * 取消套餐，并保存到历史表
	 * @param entity
	 * @param constraints
	 */
	public void cancelCombo(Object entity, String[] constraints);
	
	/**
	 * 新增
	 * @param entity
	 */
	public void add(Object entity);
	
	/**
	 * 查询互斥套餐
	 * @param entity
	 * @return
	 */
	
	public List queryMutex(Object entity);
	
	/**
	 * 检查是否有有效时间重叠的促销数据(有效的)
	 * @param entity
	 */
	public boolean checkInterleaveSprom(Object entity);
	
	/**
	 * 查询有效时间重叠的促销数据(有效的)
	 * @param entity
	 */
	public List queryInterleaveSprom(Object entity);
	
	/**
	 * 检查是否有有效时间重叠的程控数据(有效的)
	 * @param entity
	 */
	public boolean checkInterleaveMsc(Object entity);

	
	/**
	 * 检查套餐是否是允许生效时间重叠
	 * @return
	 */
	public boolean checkCanBeInterleaving(Object entity);
	
	/**
	 * 查询sid最大的一条有效程控数据
	 * @param entity
	 * @param constraints
	 * @return
	 */
	public Object queryMscEntity(Object entity, String[] constraints);

	/**
	 * 根据servId、spromId查询指定用户指定套餐的有效数据
	 * @param entity
	 * @return
	 */
	public List querySpromEntity(Object entity);

	/**
	 * 根据（传入的）servId、spromId、soId查询指定套餐的有效数据
	 * @param entity
	 * @return
	 */
	public List querySpromEntityList(Object entity);
	
	/**
	 * 查询套餐的附加套餐配置
	 * @param entity
	 */
	public IUserSpromConfig querySpromConfig(IUserSprom entity);

	/**
	 * 查询套餐的生效附加套餐
	 * @param entity
	 * @return
	 */
	public IUserSprom queryAppendSprom(IUserSprom entity);

	/**
	 * 查询套餐的生效附加套餐
	 * @param iUserSprom
	 * @param iUserSpromConfig
	 * @return
	 */
	public IUserSprom queryAppendSprom(IUserSprom iUserSprom,
			IUserSpromConfig iUserSpromConfig);

	/**
	 * 查询小区表记录
	 * @param iUserSprom
	 * @return
	 */
	public IUserCell queryIUserCell(IUserSprom iUserSprom);

	/**
	 * 查询手写月租
	 * @param entity
	 * @param spromId 
	 * @return
	 */
	public ISpromParam queryISpromParam(ISpromParam entity, Integer spromId);

	/**
	 * 按servId、keyId、spromPara（国家代码）查询国家折扣
	 * @param entity
	 * @return
	 */
	public List queryNationalSpromParam(ISpromParam entity);

	/**
	 * 用户keyId=810542的国家折扣数据
	 * @param servId
	 * @param spromId
	 * @param soId
	 */
	public List querySpecialNationalSpromParam(Long servId, Integer spromId,
			Long soId);
	
	/**
	 * 查询承诺消费配置
	 * @return
	 */
	public Map querySpmprodCfg(Long spromId);
}
