package com.asiainfo.boss4.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.asiainfo.boss4.dao.UserSpromDao;
import com.asiainfo.boss4.domain.IUserSprom;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.DateHelper;

/**
 * 查询用户套餐服务类
 * @author weihf
 */
public class QueryUserSpromServiceImpl extends BusinessServiceImpl implements BusinessService{

	private static Log logger = LogFactory.getLog(QueryUserSpromServiceImpl.class);
	
	private UserSpromDao userSpromDao;
	
	public UserSpromDao getUserSpromDao() {
		return userSpromDao;
	}

	public void setUserSpromDao(UserSpromDao userSpromDao) {
		this.userSpromDao = userSpromDao;
	}

	public String process(LazyDynaMap vo) {

		// 取交易代码
		String tranCode = (String) vo.get("tranCode");
		
		if (tranCode == null) {
			logger.error("未指定交易代码");
			throw new BossException(StatusCode.NO_INPUT_TRANCODE_ERROR);
		}
		
		// 根据值对象构造所需的实体对象
		Object entity = BeanCopyHelper.copyToEntity(vo, IUserSprom.class);
		String spromType = (String) vo.get("queryType");
		BeanCopyHelper.setProperty(entity, "spromPara", spromType);
		//查询该用户套餐列表
		List list = userSpromDao.querySpromEntity(entity);
		long queryResult=0;
		StringBuffer prodId = new StringBuffer();
		StringBuffer prodName = new StringBuffer();
		if (list.size()==0) {//该套餐不存在
			queryResult = 0;
		}
		else {//存在多条数据
			for (int i=0;i<list.size();i++)
			{
				IUserSprom iUserSprom = (IUserSprom) list.get(i);
				if (iUserSprom.getValidDate().before(DateHelper.getNextMonthFirstDay(new Date())))
				{
					queryResult = 1;
				}
				else if (queryResult == 0)
					queryResult = 2;
				prodId.append(iUserSprom.getSpromId()).append(":");
				prodName.append(iUserSprom.getRemark()).append(":");
			}
		}
		
		StringBuffer result = new StringBuffer();
		result.append("queryResult=").append(queryResult).append(",");
		if (prodId.length()>0)
			result.append("prodId=").append((prodId.toString()).substring(0, prodId.length()-1)).append(",");
		if (prodName.length()>0)
			result.append("prodName=").append((prodName.toString()).substring(0, prodName.length()-1));
		
		return result.toString();
		
	}

}
