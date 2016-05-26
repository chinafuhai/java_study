package com.asiainfo.boss4.dao;

import com.asiainfo.boss4.domain.IAccBusiCredit;
import com.asiainfo.boss4.support.ServiceContext;

public interface IAccBusiCreditDao extends BusinessDao {
	/**
	 * 如果acctId下仅存在一条creditLevel=101的i_acc_busi_credit_01xx记录，
	 * 即仅存在一对creditLevel=101,102的个人后付费信用度记录，
	 * 则将多条i_acc_busi_credit_01xx（101,102）合并为单条i_acc_busi_credit_01xx（100）
	 * @deprecated
	 * @param entity
	 * @return 
	 */
	public void mergeToOneIAccBusiCredit(IAccBusiCredit entity);
	/**
	 * 如果acctId下仅存在一条creditLevel=101的i_acc_busi_credit_01xx记录，
	 * 即仅存在一对creditLevel=101,102的个人后付费信用度记录，
	 * 则将多条i_acc_busi_credit_01xx（101,102）合并为单条i_acc_busi_credit_01xx（100）
	 * @param entity
	 * @param context
	 */
	public void mergeToOneIAccBusiCredit(IAccBusiCredit entity, ServiceContext context);
	/**
	 * 如果acctId下存在多条creditLevel=100的i_acc_busi_credit_01xx记录
	 * （creditLevel=100即品牌为个人后付费记录，存在多条记录，即acctId下有多个servId），
	 * 则将这些记录分解为creditLevel=101和creditLevel=102的两条记录
	 * @deprecated
	 * @param entity
	 * @return 
	 */
	public void detachToMultiIAccBusiCredit(IAccBusiCredit entity);
	/**
	 * 如果acctId下存在多条creditLevel=100的i_acc_busi_credit_01xx记录
	 * （creditLevel=100即品牌为个人后付费记录，存在多条记录，即acctId下有多个servId），
	 * 则将这些记录分解为creditLevel=101和creditLevel=102的两条记录
	 * @param entity
	 * @param context
	 */
	public void detachToMultiIAccBusiCredit(IAccBusiCredit entity, ServiceContext context);
	/**
	 * 更新i_acc_busi_credit_01xx的creditLevel
	 * @param entity : update creditLevel,soNbr where acctId,servId
	 */
	public void changeCreditLevelOfIAccBusiCredit(IAccBusiCredit entity);
	/**
	 * 根据acctId, servId查询信用度记录，如果存在多条记录，
	 * 把两条i_acc_busi_credit_01xx（101,102）合并为一条i_acc_busi_credit_01xx（100），
	 * 并更新为目标creditLevel值
	 * @param entity
	 */
	public void mergeTwoToOne(IAccBusiCredit entity);
	/**
	 * 返回一个账户下拥有的用户数量
	 * @deprecated
	 * @param acctId
	 * @return
	 */
	public int existedIUserByAcctId(Long acctId);
	/**
	 * 多条i_acc_busi_credit_01xx（101,102）合并为一条i_acc_busi_credit_01xx（100）
	 * @deprecated
	 * @param entity
	 * @param isAddWhenNoRecord 当查询无记录时是否新插入一条记录
	 */
	public void mergeToOneIAccBusiCredit(IAccBusiCredit entity, boolean isAddWhenNoRecord);

}
