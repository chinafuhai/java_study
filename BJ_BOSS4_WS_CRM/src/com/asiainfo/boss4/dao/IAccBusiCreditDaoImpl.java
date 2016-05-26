package com.asiainfo.boss4.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.domain.AccBookChgNotify;
import com.asiainfo.boss4.domain.IAccBusiCredit;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.ServiceContext;

@SuppressWarnings("unchecked")
public class IAccBusiCreditDaoImpl extends BusinessDaoImpl implements
		IAccBusiCreditDao {
	private static Log logger = LogFactory.getLog(IAccBusiCreditDaoImpl.class);

	@Deprecated
	public int existedIUserByAcctId(Long acctId) {
		this.flush();
		String sql = "select 1 from INTER.I_USER_ALL t where t.ACCT_ID = :acctId and t.EXPIRE_DATE > sysdate";
		try {
			List users = baseDao.getSess().createSQLQuery(sql).setParameter("acctId", acctId).list();
			logger.debug("Account " + acctId + " has possess " + users.size() + " user(s).");
			return users.size();
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

	@Deprecated
	public void mergeToOneIAccBusiCredit(IAccBusiCredit entity,boolean isAddWhenNoRecord) {
		List<IAccBusiCredit> oldRow = this.queryIAccBusiCredit(entity);
		if (oldRow.size() != 0) {// 备份数据
			this.backupAutoSuffix(entity, new String[] { "acctId", "servId" });
		}
		if (oldRow.size() > 1) {// 大于1条，则删除多余记录至一条
			for (int i = 1; i < oldRow.size(); i++) {
				this.remove(oldRow.get(i));
			}
		}
		if (oldRow.size() != 0) {// 更新没有删除的唯一一条记录
			this.flush();
			this.changeCreditLevelOfIAccBusiCredit(entity);
		}
		if (oldRow.size() == 0 && isAddWhenNoRecord) {// 等于0条，取前台传入值对象，插入1条新记录
			this.add(entity);
		}
	}

	@Deprecated
	public void mergeToOneIAccBusiCredit(IAccBusiCredit entity) {
		mergeToOneIAccBusiCredit(entity, null);
	}

	@Deprecated
	public void detachToMultiIAccBusiCredit(IAccBusiCredit entity) {
		detachToMultiIAccBusiCredit(entity, null);
	}
	/**
	 * 上发AccBookChgNotify
	 */
	private void entityAsAddBookChgNotify(ServiceContext context,Long acctId,Long servId,Short regionCode){
		com.asiainfo.boss4.domain.AccBookChgNotify accBookChgNotifyadd
	     = (com.asiainfo.boss4.domain.AccBookChgNotify)BeanCopyHelper.newInstance(
			EntityPartitionHelper.getClassForPartition(com.asiainfo.boss4.domain.AccBookChgNotify.class, acctId));
	       //BeanCopyHelper.copyBeanNotNullProperty(accBookChgNotifyNew, user);
	       //accBookChgNotifyadd.setChangeFlag();
	       accBookChgNotifyadd.setSoNbr(getZgSoNbr(context.getSoDate()));
	       accBookChgNotifyadd.setAcctId(acctId);
	       accBookChgNotifyadd.setSts(Byte.decode("1"));
	       accBookChgNotifyadd.setSoRegionCode(regionCode);
	       accBookChgNotifyadd.setSoMonth(DateHelper.Date2String(context.getSoDate(), "yyyyMM"));
	       accBookChgNotifyadd.setCreateDate(context.getSoDate());
	       accBookChgNotifyadd.setMonitType(Byte.decode("0"));
	       accBookChgNotifyadd.setMonitSource(Byte.decode("0"));
	       accBookChgNotifyadd.setSrcDoneCode(0L);
	       accBookChgNotifyadd.setChangeType(Byte.decode("0"));
	       accBookChgNotifyadd.setBusiCode(0);
	       accBookChgNotifyadd.setPriority(Short.decode("0"));
	       accBookChgNotifyadd.setServId(servId);
	       //context.getBusinessDao().add(accBookChgNotifyadd);
	       accBookChgNotifyadd.add(context);
	}
	
	/**
	 * 更新credit_level,so_nbr
	 */
	public void changeCreditLevelOfIAccBusiCredit(IAccBusiCredit entity) {
		StringBuffer sql = new StringBuffer();
		String tableName = EntityPartitionHelper.getTableName(entity);
		sql.append("update ZG.").append(tableName)
		   .append(" set credit_level = :creditLevel, so_nbr = :soNbr where acct_id = :acctId and serv_id = :servId");
		try {
			int updateCount = baseDao.getSess().createSQLQuery(sql.toString())
			                 .setParameter("creditLevel", entity.getCreditLevel())
					         .setParameter("soNbr", entity.getSoNbr()).setParameter("acctId", entity.getAcctId()).setParameter("servId", entity.getServId()).executeUpdate();
			if (updateCount != 1) {
				logger.warn(updateCount + " rows of " + tableName + " updated.");
			}
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

	/**
	 * 信控拆分
	 */
	public void detachToMultiIAccBusiCredit(IAccBusiCredit entity,ServiceContext context) {
		List<IAccBusiCredit> rowsWith100List = this.queryIAccBusiCreditWithCreditLevel(entity, 100);
		
        // 首次分解102
		if (rowsWith100List.size() > 1) {
			for (IAccBusiCredit singleRow : rowsWith100List) {
		    	//如果是当前用户,拆分用户级信控102和帐户级信控101
		    	if(entity.getServId().equals(singleRow.getServId())){
		    		detachOneToTwo(singleRow);
					
		    		//101帐户级上发
		    		if(context != null){
		    			entityAsAddBookChgNotify(context,singleRow.getAcctId(),0L,singleRow.getRegionCode());
					}
		    	}else{//如果操作了acctId下的其他的用户servId,拆分用户级信控102
		    		singleRow.setSoNbr(entity.getSoNbr());
					detachOneToOne(singleRow);
					
					//102用户级上发
					if(context != null){
						entityAsAddBookChgNotify(context,singleRow.getAcctId(),singleRow.getServId(),singleRow.getRegionCode());
					}
		    	}
			}	
			return;
		}

		// 已经存在分解过的101,上发用户级信控102
		if (rowsWith100List.size() == 1) {
			long rowsWith101 = this.queryIAccBusiCreditCountAcc(entity, 101);
			if (rowsWith101 != 0) {
				detachOneToOne(rowsWith100List.get(0));
			}
		}

	}
	
	/**
	 * 信控合并
	 */
	public void mergeToOneIAccBusiCredit(IAccBusiCredit entity,ServiceContext context) {
		
		long rowsWith102 = this.queryIAccBusiCreditCountAcc(entity, 102);
		if (rowsWith102 == 1) {
			//处理102用户级信控
			List<IAccBusiCredit> rowsWith102List = this.queryIAccBusiCreditWithCreditLevel(entity, 102);
			this.flushAndClear();
			rowsWith102List.get(0).setCreditLevel(100);
			rowsWith102List.get(0).setSoNbr(entity.getSoNbr());
			mergeTwoToOne(rowsWith102List.get(0));
			
		    if(context != null){
			   //102用户级上发
		       context.needToReadjustChangeFlagOfAccBookChgNotify((byte)11);	
			   entityAsAddBookChgNotify(context,rowsWith102List.get(0).getAcctId(),rowsWith102List.get(0).getServId(),rowsWith102List.get(0).getRegionCode()); 
			}
		    
			//处理101帐户级信控
			long rowsWith101 = this.queryIAccBusiCreditCountAcc(entity, 101);
			if(rowsWith101==1){
				List<IAccBusiCredit> rowsWith101List = this.queryIAccBusiCreditWithCreditLevel(entity, 101);
				this.remove(rowsWith101List.get(0));
				
				//101帐户级上发
				if(context != null){
					context.needToReadjustChangeFlagOfAccBookChgNotify((byte)16);
					entityAsAddBookChgNotify(context,rowsWith101List.get(0).getAcctId(),0L,rowsWith101List.get(0).getRegionCode());
				}
			}
		}
		
		//如果只有一对101/102,对当前用户销户时,删除101记录
		if(rowsWith102==0){
			long rowsWith101 = this.queryIAccBusiCreditCountAcc(entity, 101);
			if(rowsWith101==1){
				List<IAccBusiCredit> rowsWith101List = this.queryIAccBusiCreditWithCreditLevel(entity, 101);
				this.remove(rowsWith101List.get(0));
				
				//101帐户级上发
				if(context != null){
					context.needToReadjustChangeFlagOfAccBookChgNotify((byte)16);
					entityAsAddBookChgNotify(context,rowsWith101List.get(0).getAcctId(),0L,rowsWith101List.get(0).getRegionCode());
				}
			}
		}
	}



	/**
	 * 查询acctId,servId下的i_acc_busi_credit_01xx记录
	 * @param entity
	 * @return
	 */
	public List<IAccBusiCredit> queryIAccBusiCredit(IAccBusiCredit entity) {
		return (List<IAccBusiCredit>) queryEntityList(entity, new String[] {"acctId", "servId" });
	}

	/**
	 * 查询acctId下指定creditLevel值的i_acc_busi_credit_01xx记录(每个servId应返回一条记录)
	 * @param entity
	 * @param isSpecificServId true 则仅查询指定的servId；false 则查询acctId下的所有servId
	 * @return
	 */
	private List<IAccBusiCredit> queryIAccBusiCreditWithCreditLevel(IAccBusiCredit entity, Integer creditLevel) {
		this.flushAndClear();
		Integer swap = entity.getCreditLevel();
		entity.setCreditLevel(creditLevel);
		List<IAccBusiCredit> result = (List<IAccBusiCredit>) queryEntityList(entity, new String[] { "acctId", "creditLevel" });
		entity.setCreditLevel(swap);
		return result;
	}

	private long queryIAccBusiCreditCountAcc(IAccBusiCredit entity,Integer creditLevel) {
		StringBuffer sb = new StringBuffer();
		long count = 0L;
		try {
			sb.append("select count(*) from ").append(entity.getClass().getSimpleName());
			sb.append(" where acct_Id = :acctId and credit_Level = :creditLevel and rownum<3");
			count = ((Long) this.baseDao.getSess().createQuery(sb.toString()).setString("acctId", entity.getAcctId().toString())
					.setString("creditLevel", creditLevel.toString()).iterate().next()).longValue();
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return count;
	}

	public void mergeTwoToOne(IAccBusiCredit entity) {
		List<IAccBusiCredit> rows = this.queryIAccBusiCredit(entity);
		if (rows.size() != 0) {// 备份数据
			this.backupAutoSuffix(entity, new String[] { "acctId", "servId" });
		}
		if (rows.size() > 1) {// 大于1条，则删除多余记录至一条
			for (int i = 1; i < rows.size(); i++) {
				this.remove(rows.get(i));
			}
		}
		if (rows.size() != 0) {// 更新没有删除的唯一一条记录
			this.flush();
			this.changeCreditLevelOfIAccBusiCredit(entity);
			this.flush();
		}
	}
	
	/**
	 * i_acc_busi_credit_01xx(100)更新成用户级信控102
	 * @param entity
	 */
	private void detachOneToOne(IAccBusiCredit entity) {
		this.flushAndClear();
		entity.setCreditLevel(102);
		changeCreditLevelOfIAccBusiCredit(entity);
		this.flush();
	}
	
	/**
	 * i_acc_busi_credit_01xx(100)更新成用户级信控102和帐户级信控101
	 * @param entity
	 */
	private void detachOneToTwo(IAccBusiCredit entity) {
		this.flushAndClear();
		entity.setCreditLevel(102);
		changeCreditLevelOfIAccBusiCredit(entity);
		this.flush();

		IAccBusiCredit copyEntity = (IAccBusiCredit) BeanCopyHelper.newInstance(entity.getClass());
		BeanCopyHelper.copyProperties(copyEntity, entity);
		copyEntity.setCreditLevel(101);
		copyEntity.setServId(0L);
		this.add(copyEntity);

		this.flush();
	}
	
	/**
	 * 把一条i_acc_busi_credit_01xx(100)分解为两条i_acc_busi_credit_01xx(101,102)
	 * @param entity
	 */
//	private void detachOneToTwo(IAccBusiCredit entity) {
//		this.flushAndClear();
//		entity.setCreditLevel(101);
//		changeCreditLevelOfIAccBusiCredit(entity);
//		this.flush();
//
//		IAccBusiCredit copyEntity = (IAccBusiCredit) BeanCopyHelper.newInstance(entity.getClass());
//		BeanCopyHelper.copyProperties(copyEntity, entity);
//		copyEntity.setCreditLevel(102);
//		this.add(copyEntity);
//
//		this.flush();
//	}
	
//	public void mergeTwoToOne(IAccBusiCredit entity) {
//	// 获取101记录
//	List<IAccBusiCredit>  entity101 = this.queryIAccBusiCreditWithCreditLevel(entity,101);
//	// 备份数据102记录
//	this.backupAutoSuffix(entity, new String[] { "acctId", "servId" });
//	
//	//删除101记录,修改102记录为100
//	this.remove(entity101.get(0));
//	this.flush();
//	this.changeCreditLevelOfIAccBusiCredit(entity);
//	this.flush();
//}
		
}