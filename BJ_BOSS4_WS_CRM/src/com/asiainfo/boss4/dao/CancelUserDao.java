package com.asiainfo.boss4.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.asiainfo.boss4.domain.AccCcNoPressStop;
import com.asiainfo.boss4.domain.IAccBusiCredit;

/**
 * 销户Dao接口
 * @author xiaopeng, caohui
 */
public interface CancelUserDao extends BusinessDao{

	/**
	 * 通过原生SQL直接更新i_acc_busi_credit
	 * @param entity
	 */
	public void changeIAccBusiCredit(IAccBusiCredit entity);
	/**
	 * 查询免催免停数据
	 * @param entity
	 * @return
	 */
	public AccCcNoPressStop queryAccCcNoPressStop(AccCcNoPressStop entity);
	/**
	 * 取消流程，会复制一条新的数据，但生效和失效时间均为当前时间
	 * @param entity
	 * @param constraints 指定update的约束字段
	 */
	public void cancelWithCopyNewData(Object entity, String[] constraints, Date currentDate);
	
	/**
	 * 查询指定的实体，返回实体List
	 * @param entity 
	 * @param params 查询条件 key为字段名称字符串，value为字段值对象
	 * @return
	 */
	public List queryEntitysToList(Class entity, Map<String, Object> params);

	/**
	 * 备份多条数据
	 * @param entity
	 * @param conditions
	 */
	public void backupMuti(Object entity, String[] conditions);
	
	/**
	 * 备份要删除的数据
	 * （原数据直接删除，原表可以没有soNbr字段，历史表写rollbackSoNbr）
	 * @param entity
	 * @param constraints
	 * @param soNbr
	 */
	public void backupDeletedRecord(Object entity, String[] constraints, Long soNbr);
}
