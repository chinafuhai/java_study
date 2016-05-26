package com.asiainfo.boss4.dao;


import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SQLQuery;

import com.asiainfo.boss4.domain.CrmUserMonitor;
import com.asiainfo.boss4.domain.CrmUserMonitorHis;
import com.asiainfo.boss4.domain.IUser;
import com.asiainfo.boss4.domain.IUserMonitor;
import com.asiainfo.boss4.domain.IUserVpmn;

import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.OperateType;

public class UserMonitorDaoImpl extends BusinessDaoImpl implements UserMonitorDao {
	private Log logger = LogFactory.getLog(UserMonitorDaoImpl.class);
	public CrmUserMonitor queryCrmUserMonitorEntity(Object entity) {
		// TODO Auto-generated method stub
		Long servId = ((IUserMonitor)entity).getServId();
		String hql = "from  CrmUserMonitor where servId=:servId and monitorFlag=50001";
		return (CrmUserMonitor)this.baseDao.createQuery(hql)
			.setParameter("servId", servId).uniqueResult();
	}

	public IUserMonitor queryIUserMonitorEntity(Object entity) {
		// TODO Auto-generated method stub
		Long servId = ((IUserMonitor)entity).getServId();
		String hql = "from "+entity.getClass().getSimpleName()+"  where servId=:servId and expireDate>validDate and expireDate>sysdate and monitorFlag=50001";
		return (IUserMonitor)this.baseDao.createQuery(hql)
			.setParameter("servId", servId).uniqueResult();
	}

	public CrmUserMonitorHis queryCrmUserMonitorHisEntity(Object entity) {
		// TODO Auto-generated method stub
		Long servId = ((IUserMonitor)entity).getServId();
		String hql = "from  CrmUserMonitorHis where servId=:servId and stsDate=(select max(stsDate) from CrmUserMonitorHis  where servId=:servId)";
		return (CrmUserMonitorHis)this.baseDao.createQuery(hql)
			.setParameter("servId", servId).uniqueResult();
	}

	public void saveOrUpdate(IUserVpmn vpmn){
		IUserVpmn vpmnVo = (IUserVpmn)baseDao.createSQLQuery("select serv_id,so_nbr,oper_type,so_date,valid_date,expire_date,remark from inter.i_user_vpmn_"+DateHelper.Date2String(vpmn.getSoDate(), "yyyyMMdd")+" where serv_id=:servId ")
									.addEntity(IUserVpmn.class)
									.setLong("servId", vpmn.getServId())
									.uniqueResult();
		if (vpmnVo == null)
		{
			StringBuffer sql = new StringBuffer();
			sql.append("insert into inter.i_user_vpmn_"+DateHelper.Date2String(vpmn.getSoDate(), "yyyyMMdd"));
			sql.append(" (serv_id,oper_type,so_nbr,so_date,valid_date,expire_date) ");
			sql.append(" values (:servId,:operType,:soNbr,:soDate,:validDate,:expireDate)");
			SQLQuery query = baseDao.createSQLQuery(sql.toString());
			query.setLong("servId", vpmn.getServId());
			query.setString("operType",vpmn.getOperType());
			query.setString("soNbr", vpmn.getSoNbr());
			query.setTimestamp("soDate", vpmn.getSoDate());
			query.setTimestamp("validDate", vpmn.getValidDate());
			query.setTimestamp("expireDate", vpmn.getExpireDate());
			query.executeUpdate();
		}else if (vpmnVo != null  && !vpmn.getOperType().equals(OperateType.ADD.getTypeCode()))
		{
			StringBuffer sql = new StringBuffer();
			sql.append("update inter.i_user_vpmn_"+DateHelper.Date2String(vpmn.getSoDate(), "yyyyMMdd"));
			sql.append(" set expire_date=:expireDate,so_nbr=:soNbr,oper_type=:operType,remark='");
			if (vpmnVo.getRemark()!=null)
			{
				if (vpmnVo.getRemark().length()>=1800)
					sql.append(vpmnVo.getRemark().substring(0, 1800)+";");
				else
					sql.append(vpmnVo.getRemark()+";");
			}
			sql.append(vpmnVo.getSoNbr());
			sql.append(","+vpmnVo.getOperType());
			sql.append("'");
			sql.append(" where serv_id=:servId");
			SQLQuery query = baseDao.createSQLQuery(sql.toString());
			query.setLong("servId", vpmn.getServId());
			query.setString("operType",vpmn.getOperType());
			query.setString("soNbr", vpmn.getSoNbr());
			query.setTimestamp("expireDate", vpmn.getExpireDate());
			query.executeUpdate();
		}else{
			StringBuffer sql = new StringBuffer();
			sql.append("update inter.i_user_vpmn_"+DateHelper.Date2String(vpmn.getSoDate(), "yyyyMMdd"));
			sql.append(" set valid_date=:validDate,expire_date=:expireDate,so_nbr=:soNbr,oper_type=:operType,remark='");
			if (vpmnVo.getRemark()!=null)
			{
				if (vpmnVo.getRemark().length()>=1800)
					sql.append(vpmnVo.getRemark().substring(0, 1800)+";");
				else
					sql.append(vpmnVo.getRemark()+";");
			}
			sql.append(vpmnVo.getSoNbr());
			sql.append(","+vpmnVo.getOperType());
			sql.append("'");
			sql.append(" where serv_id=:servId");
			SQLQuery query = baseDao.createSQLQuery(sql.toString());
			query.setLong("servId", vpmn.getServId());
			query.setString("operType",vpmn.getOperType());
			query.setString("soNbr", vpmn.getSoNbr());
			query.setTimestamp("expireDate", vpmn.getExpireDate());
			query.setTimestamp("validDate", vpmn.getValidDate());
			query.executeUpdate();
		}
	}
	
	public void saveSaleOper(IUser user, Long sid,Long soNbr) {
		
		com.asiainfo.boss4.domain.ISaleOper saleOper = null;
		try {
			if (user.getServId().longValue()%10 == 0)
				saleOper = new com.asiainfo.boss4.domain.partition.ISaleOper0101();
			else if (user.getServId().longValue()%10 == 1)
				saleOper = new com.asiainfo.boss4.domain.partition.ISaleOper0102();
			else if (user.getServId().longValue()%10 == 2)
				saleOper = new com.asiainfo.boss4.domain.partition.ISaleOper0103();
			else if (user.getServId().longValue()%10 == 3)
				saleOper = new com.asiainfo.boss4.domain.partition.ISaleOper0104();
			else if (user.getServId().longValue()%10 == 4)
				saleOper = new com.asiainfo.boss4.domain.partition.ISaleOper0105();
			else if (user.getServId().longValue()%10 == 5)
				saleOper = new com.asiainfo.boss4.domain.partition.ISaleOper0106();
			else if (user.getServId().longValue()%10 == 6)
				saleOper = new com.asiainfo.boss4.domain.partition.ISaleOper0107();
			else if (user.getServId().longValue()%10 == 7)
				saleOper = new com.asiainfo.boss4.domain.partition.ISaleOper0108();
			else if (user.getServId().longValue()%10 == 8)
				saleOper = new com.asiainfo.boss4.domain.partition.ISaleOper0109();
			else
				saleOper = new com.asiainfo.boss4.domain.partition.ISaleOper0110();
			
		} 
		catch (Exception e) {
			logger.error("构建");
		}
	
		Long servId = user.getServId();
	
		Date dateTime = queryCurrentDate();
		saleOper.setAcctId(user.getAcctId());
		saleOper.setBusiCode(new Integer(1));
		saleOper.setCommitDate(dateTime);
		saleOper.setCountyCode(user.getCountyCode());
		saleOper.setCustId(user.getCustId());
		saleOper.setGroupId(new Long(0));
		saleOper.setOrgId(new Integer(0));
		saleOper.setRegionCode(user.getRegionCode());
		saleOper.setRemark(null);
		saleOper.setServId(servId);
		saleOper.setSid(sid.longValue());
		saleOper.setSoNbr(user.getSoNbr());
		saleOper.setUpDate(null);
	
		saleOper.setUpField("0000000000000000000000000100000000000000000000000000000000000000");
		add(saleOper);
	}
}
