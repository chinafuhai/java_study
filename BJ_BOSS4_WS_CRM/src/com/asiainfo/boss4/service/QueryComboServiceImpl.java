package com.asiainfo.boss4.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.asiainfo.boss4.dao.ChangeComboDao;
import com.asiainfo.boss4.domain.IUserSprom;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;

/**
 * 查询用户套餐服务类
 * @author xiaopeng
 */
public class QueryComboServiceImpl extends BusinessServiceImpl implements BusinessService{

	private static Log logger = LogFactory.getLog(QueryComboServiceImpl.class);
	
	private ChangeComboDao changeComboDao;
	
	public ChangeComboDao getChangeComboDao() {
		return changeComboDao;
	}

	public void setChangeComboDao(ChangeComboDao changeComboDao) {
		this.changeComboDao = changeComboDao;
	}

	public String process(LazyDynaMap vo, Map requestStatus) {
		
		// 取交易代码
		String tranCode = (String) vo.get("tranCode");
		if (tranCode == null) {
			logger.error("未指定交易代码");
			throw new BossException(StatusCode.NO_INPUT_TRANCODE_ERROR);
		}
		
		// 根据值对象构造所需的实体对象
		Object entity = BeanCopyHelper.copyToEntity(vo, IUserSprom.class);
		
		//查询该用户该套餐是否已存在
		List list = changeComboDao.querySpromEntity(entity);
		if (list.size()==0) {//该套餐不存在
			throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
		}
		else if (list.size()>1) {//存在多条数据
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR);
		}
		IUserSprom iUserSprom = (IUserSprom) list.get(0);
		
		long soId = iUserSprom.getSoId()%10000;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StringBuffer result = new StringBuffer();
		result.append("servId=").append(iUserSprom.getServId())
			.append(",").append("spromId=").append(iUserSprom.getSpromId())
			.append(",").append("soId=").append(soId)
			.append(",").append("validDate=").append(sdf.format(iUserSprom.getValidDate()))
			.append(",").append("expireDate=").append(sdf.format(iUserSprom.getExpireDate()));
		
		return result.toString();
	}

}
