package com.asiainfo.boss4.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.SuperposeDao;
import com.asiainfo.boss4.domain.ISaleOper;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;

/**
 * 叠加包业务撤单service实现类
 * 叠加包撤单：
 * 1.根据soNbr查询新增的叠加包数据，修改其失效时间为生效时间（同普通新增的撤单）
 * 2.查询失效时间为叠加包生效时间的唯一一条数据（即原来被取消的数据），从历史表回滚
 * 3.查询生效时间为下月一号的有效数据（即新增的下月生效数据），修改其失效时间为生效时间（同普通新增的撤单）
 * @deprecated
 * @author xiaopeng
 */
public class SuperposeRepealServiceImpl implements BusinessService{
	
	private static Log logger = LogFactory.getLog(SuperposeRepealServiceImpl.class);
	
	private SuperposeDao superposeDao;

	public String process(LazyDynaMap vo, Map requestStatus) {
		// 取交易代码
		String tranCode = (String) vo.get("tranCode");
		if (tranCode == null) {
			logger.error("未指定交易代码");
			throw new BossException(StatusCode.NO_INPUT_TRANCODE_ERROR);
		}
		
		// 取此交易需要操作的实体类
		OneOpreateConfig config =  OperateConfiguration.getConfigByTranCode(tranCode);
		// 设置消息编号，一个交易(item)拥有同一个消息编号
		Object sid = superposeDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses());
		
		for (int i = 0; i < entityList.size(); i++) {
			Object entity = entityList.get(i);
			if (ISaleOper.class.equals(entity.getClass())) {
				superposeDao.add(entity);
				continue;
			}
			superposeDao.rollbackSuperpose(entity);
		}
		return null;
	}

	public SuperposeDao getSuperposeDao() {
		return superposeDao;
	}

	public void setSuperposeDao(SuperposeDao superposeDao) {
		this.superposeDao = superposeDao;
	}

}
