package com.asiainfo.boss4.dao;

import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.asiainfo.boss4.domain.AccRemindSmsTemplet;
import com.asiainfo.boss4.domain.CrmAccount;
import com.asiainfo.boss4.domain.CrmCustomer;
import com.asiainfo.boss4.domain.CrmUser;
import com.asiainfo.boss4.domain.CrmUserOther;
import com.asiainfo.boss4.domain.IAccount;
import com.asiainfo.boss4.domain.ICustomer;
import com.asiainfo.boss4.domain.IUser;
import com.asiainfo.boss4.domain.IUserPbx;
import com.asiainfo.boss4.domain.SmsJfMap;
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.BrandType;

/**
 * 业务流程通用dao接口
 * @author caohui
 *
 */
public interface BusinessDao {
	/**
	 * 通用的实体新增流程
	 * 如果实体已经存在，则判断实体注释@CommonDao(isOverwriteWhenAdd)，true则更新实体，false则直接返回。
	 * @param entity 返回操作后的实体数据
	 * @return
	 */
	public Object commonAdd(BaseEntity entity);
	
	/**
	 * 通用的实体取消流程
	 * @param entity
	 * @return
	 */
	public Object commonCancel(BaseEntity entity);
	
	/**
	 * 通用的实体更新流程
	 * @param entity
	 * @return
	 */
	public Object commonModify(BaseEntity entity);
	
	/**
	 * 通用更新失效时间
	 * @param entity
	 * @return
	 */
	public Object commonModifyExpireDate(BaseEntity entity);
	
	public Object commonRollBack(BaseEntity entity);
	
	/**
	 * 新增一个实体
	 * @param entity
	 */
	public void add(Object entity);
	
	/**
	 * 更新
	 * @param entity
	 */
	public void update(Object entity);
	
	/**
	 * 新增一个实体记录到指定后缀的对应表中
	 * @param originEntity
	 * @param suffix
	 * @param isReversed true则从原表名中去除指定后缀名，false或null则在原表名后追加后缀名
	 * @return
	 */
	public Object addToSuffix(Object originEntity, String suffix, Boolean isReversed);


	/**
	 * 删除一个实体
	 * @param entity
	 * @param constraints 实体的属性名组成的数组
	 * @return 删除记录数量
	 */
	public int remove(Object entity, String[] constraints);
	
	/**
	 * 删除实体
	 * @param entity
	 * @return
	 */
	public void remove(Object entity);
	
	/**
	 * 备份一个实体至RB表，以备撤单之用
	 * @param entity
	 * @param constraints
	 */
	public void backup(Object entity, String[] constraints);
	
	/**
	 * 备份一个实体至指定的后缀表
	 * @param entity
	 * @param constraints
	 * @param suffix
	 */
	public void backup(Object entity, String[] constraints, String suffix);
	
	/**
	 * 备份多个实体至指定的后缀表
	 * @param entity
	 * @param constraints
	 * @param suffix
	 */
	public void backupMany(Object entity, String[] constraints, String suffix);
	
	/**
	 * 备份实体（根据注释配置自动识别备份表后缀，支持多条备份和零备份）
	 * @param entity
	 * @param constraints
	 */
	public void backupAutoSuffix(Object entity, String[] constraints);
	
	/**
	 * 移动数据至指定的后缀表
	 * @param entity
	 * @param constraints
	 * @param suffix
	 */
	public void move(Object entity, String[] constraints, String suffix);

	/**
	 * 备份一个实体至指定的后缀表
	 * @param entity
	 * @param constraints
	 * @param suffix
	 * @param isAppendSuffix
	 */
	public void backup(Object entity, String[] constraints, String suffix, boolean isAppendSuffix);
	
	/**
	 * CRM表备份操作，备份数据至HIS后缀表
	 */
	public Object backupCrm(Object entity,String[] constraints);
	
	/**
	 * 复制一个实体至带指定的后缀实体表
	 * @param entity
	 * @param constraints
	 * @param suffix 指定后缀名
	 * @param isReversed 是否反转复制方向：true为反向，false为正向(如果为null的话，也被认为是false)。
	 * 如果是true(即反向)，则流程变为复制一个带指定后缀的实体至去除后缀的实体表
	 * @param allowMany 是否允许备份多条记录
	 * @param allowZero 是否允许备份零条记录
	 * @return
	 */
	public List cloneToSuffix(Object entity, String[] constraints, String suffix, Boolean isReversed, Boolean allowMany, Boolean allowZero);
	
	/**
	 * 撤单流程
	 * @param entity
	 * @param constraints
	 */
	public Object rollback(Object entity);
	
	/**
	 * 取消的撤单流程
	 * @param entity
	 * @param constraints
	 * @param deleteOriginalEntity 是否删除原表记录
	 * @return 返回回滚的数据，没有操作实体则返回null
	 */
	public List<Object> rollbackCancel(Object entity, boolean deleteOriginalEntity);
	
	/**
	 * 
	 *取消的撤单流程
	 * @param entity
	 * @param constraints
	 * @param deleteOriginalEntity 是否删除原表记录
	 * @param additionRequirement 附加查询条件（用来删除原表和查询备份表）
	 * @return 返回回滚的数据，没有操作实体则返回null
	 */
	public List<Object> rollbackCancel(Object entity, boolean deleteOriginalEntity, String[] additionRequirement);
	
	/**
	 * 撤单操作回滚多条数据
	 * @param entity
	 * @return
	 */
	public List<Object> rollbackMuti(Object entity);
	
	/**
	 * 取消流程
	 * @param entity
	 * @param constraints 指定update的约束字段
	 */
	public void cancel(Object entity, String[] constraints);

	/**
	 * 取消流程 (可选择是否立即失效数据，立即失效需要传当前数据库时间currentDate)
	 * @param entity
	 * @param constraints 指定update的约束字段
	 * @param isRightNow 是否立即失效数据
	 * @param currentDate
	 */
	public void cancel(Object entity, String[] constraints, boolean isRightNow, Date currentDate);
	
	/**
	 * 变更流程
	 * 用EAI传入数据直接覆盖旧数据
	 * @param entity
	 * @param constraints 指定update的约束字段
	 */
	public void change(Object entity, String[] constraints);
	
	/**
	 * I表变更流程
	 * 失效旧数据，插入新数据
	 * 插入的新数据是用EAI传入的数据覆盖旧数据产生
	 * @param entity
	 * @param constraints 指定update的约束字段
	 * @param currentDate
	 */
	public void changeWithMerge(Object entity, String[] constraints, Date currentDate);
	
	/**
	 * 变更操作(用EAI传入数据覆盖旧数据指定的字段)
	 * @param entity
	 * @param constraints 指定update的约束字段
	 * @param updateFieldNames 指定希望update的字段名称
	 * @param currentDate
	 */
	public void changeWithMerge(Object entity, String[] constraints, String[] updateFieldNames,
			Date currentDate);
	
	/**
	 * CRM表变更操作
	 * 首先备份数据至HIS表，然后用EAI传入数据直接覆盖旧数据
	 * @param entity
	 * @param constraints 指定update的约束字段
	 * @param currentDate
	 */
	public void changeWithMergeCrm(Object entity, String[] constraints, Date currentDate);
	
	/**
	 * 获取消息编号
	 * @return
	 */
	public Long querySid();
	
	/**
	 * 获取数据库当前时间
	 * @return
	 */
	public Date queryCurrentDate();
	
	/**
	 * 从数据库获取实体数据
	 * @param entity
	 * @param constraints
	 * @return 找不到数据则返回null
	 */
	public Object getEntity(Object entity, String[] constraints);
	
	/**
	 * 从数据库获取实体数据
	 * @param entity
	 * @param constraints
	 * @param selectCondition
	 * @return
	 */
	public Object getEntityByCond(Object entity, String[] constraints,String selectCondition);
	
	/**
	 * 从数据库获取实体数据
	 * @param entity
	 * @param constraints
	 * @return 找不到数据则抛出BossException
	 */
	public Object queryEntity(Object entity, String[] constraints);
	
	
	/**
	 * 查询多条记录
	 * @param entity
	 * @param constraints
	 * @return
	 */
	public List queryEntityList(Object entity, String[] constraints);
	
	/**
	 * 通过手机号码查询用户信息，手机号码不存在则返回null
	 * 查找INTER.I_USER_ALL
	 * @param phoneNumber 手机号码
	 * @return
	 */
	public IUser queryIUserByPhoneNumber(String phoneNumber);
	
	/**
	 * 通过手机号码查询用户信息，手机号码不存在则返回null
	 * 查找INTER.I_USER_ALL视图
	 * @param phoneNumber 手机号码
	 * @return
	 */
	public IUser queryIUserAllByPhoneNumber(String phoneNumber);
	
	/**
	 * 通过集团手机号返回集团用户
	 * @param phoneId
	 * @return
	 */
	public CrmUser queryGroupCrmUserByPhoneId(String phoneId);
	
	/**
	 * 通过servId查询用户信息
	 * @param servId
	 * @return
	 */
	public IUser queryIUserByServId(Long servId);
	
	/**
	 * 通过ServId查询该用户是否存在
	 * @param servId
	 * @param userType 用户类型
	 * @return
	 */
	public IUser existedIUser(String servId, String userType);
	
	/**
	 * 通过ServId查询该用户(i_user_all)是否存在
	 * @param servId
	 * @return
	 */
	public boolean isExistIUser(String servId);
	
	/**
	 * Session刷出,同步数据状态到JDBC连接
	 */
	public void flush();
	
	/**
	 * Session刷出,同步数据状态到JDBC连接，同时清除session中缓存的实体对象
	 */
	public void flushAndClear();
	
	/**
	 * CRM表更新操作
	 * @param entity 实体对象，用来同时保存更新至数据库的字段值和用来从数据库中查找实体的约束字段值
	 * @param constraints 用来从数据库中查找实体的约束字段名称
	 * @param updateFieldNames 希望更新至数据库的字段名称
	 */
	public void changeCrm(Object entity, String[] constraints, String[] updateFieldNames);
	
	/**
	 * CRM表更新操作
	 * @param entity 实体对象，用来同时保存更新至数据库的字段值和用来从数据库中查找实体的约束字段值
	 * @param constraints 用来从数据库中查找实体的约束字段名称
	 * @param updateFieldNames 希望更新至数据库的字段名称
	 * @param allowMany 允许更新多条记录
	 * @param allowZero 允许更新零条记录
	 */
	public void changeCrm(Object entity, String[] constraints, String[] updateFieldNames, Boolean allowMany, Boolean allowZero);
	
	/**
	 * 根据servId/custId/acctId查询该用户的品牌类型
	 * @param paramName "servId"|"custId"|"acctId"
	 * @param paramValue
	 * @return 品牌类型
	 */
	public EnumSet<BrandType> queryBrand(String paramName, String paramValue);
	
	/**
	 * 根据custId返回ICustomer客户数据
	 * @param custId
	 * @return
	 * @deprecated 建议调用getEntity
	 */
	public ICustomer queryICustomerByCustId(Long custId);
	
	/**
	 * 根据acctId返回IAccount账户数据
	 * @param acctId
	 * @return
	 * @deprecated 建议调用getEntity
	 */
	public IAccount queryIAccountByAcctId(Long acctId);
	
	/**
	 * 通过servId查询CrmUser用户信息
	 * @param servId
	 * @return
	 */
	public CrmUser queryCrmUserByServId(Long servId);
	
	/**
	 * 通过acctId查询用户信息
	 * @param servId
	 * @return
	 */
	public List<CrmUser> queryCrmUsersByAcctId(Long acctId);
	
	/**
	 * 通过servId查询CrmUserOther用户信息
	 * @param servId
	 * @return
	 */
	public CrmUserOther queryCrmUserOtherByServId(Long servId);
	
	/**
	 * 根据custId返回CrmCustomer客户数据
	 * @param custId
	 * @return
	 */
	public CrmCustomer queryCrmCustomerByCustId(Long custId);
	
	/**
	 * 根据acctId返回CrmAccount账户数据
	 * @param acctId
	 * @return
	 */
	public CrmAccount queryCrmAccountByAcctId(Long acctId);

	/**
	 * 获取so_id前辍序列
	 * @return
	 */
	public Long getSoidSequence();
	public Long getLableidSequence();
	/**
	 * 获取帐管SoNbr
	 * @return
	 */
	public Long getZgSoNbr(Date soDate);
	
	public CrmUser queryCrmUserByPhoneNumber(String phoneNumber);

	public Session getSess();
	
	public void removeAllSpromAndParamAndCpc(Long servId,Short regionCode,Long soNbr,Long sid,Date expireDate);
	
	public String getNewUpFieldByServ(Long servId,Short regionCode,String oldUpField,boolean isRollBack,Long soNbr);

	public void updateExpireDate(Object entity, Map selectConditions,Map updateFields,String suffix,String tableName);
	
	public List getEntityListBySoNbr(Object entity);
	
	public List insertOweMonitorSpecAndCcPlan(Long servId,Long newAcctId,Long oldAcctId);

	public void removeAccIntellnetUserCycle(Long acctId,Long soNbr);
	
	public List getEntityList(Object entity, String[] selectConditions);
	
	public boolean sidExist(IUserPbx userPbx);
	
	public void rollBackAllSpromAndParam(Long servId,Short regionCode,Long soNbr,Long sid);
	public void rollBackAccIntellnetUserCycle(Long acctId,Long soNbr);
	public void removeISaleOperAll(Short regionCode,Long soNbr,Long sid);
	public CrmUser queryCrmUserByPhoneId(String phoneId);
	public Date getMaxExpireDate(Object entity, String[] selectConditions);
	public int getCpcCountByServ(Long servId,Short regionCode);
	public void flushAndClearWithException();
	public List getCcPlanList(Long servId,Long oldAcctId);
	public List<SmsJfMap> getSmsJfMap(String templetId);
	public List queryAccUserPaymentList(Long servId);
	public List getEntityListExt(Object entity, String[] selectConditions);
	public List getEntityListSmsTemplet(Object entity);
}
