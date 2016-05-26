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
import com.asiainfo.boss4.support.OperateType;
import com.asiainfo.boss4.support.UpFieldUtil;

/**
 * 叠加包业务Service实现
 * @deprecated
 * @author xiaopeng
 */
public class SuperposeServiceImpl implements BusinessService{
	
	private static Log logger = LogFactory.getLog(SuperposeServiceImpl.class);
	
	private SuperposeDao superposeDao;

	public String process(LazyDynaMap vo, Map requestStatus) {
		// 取交易代码
		String tranCode = (String) vo.get("tranCode");
		if (tranCode == null) {
			logger.error("未指定交易代码");
			throw new BossException(StatusCode.NO_INPUT_TRANCODE_ERROR);
		}
		
		// 取业务操作类型（新增）
		String operType = null;
		try {
			operType = (String) vo.get("operType");
			if (operType == null) {
				throw new Exception("交易代码为空");
			}
		} catch (Exception e) {
			logger.error("未指定交易的操作类型");
			throw new BossException(StatusCode.NO_INPUT_OPERTYPE_ERROR, e);
		}
		
		// 取此交易需要操作的实体类
		OneOpreateConfig config =  OperateConfiguration.getConfigByTranCode(tranCode);
		//更新标志串  UP_FIELD 
		UpFieldUtil.setUpField(vo);
		// 设置消息编号，一个交易(item)拥有同一个消息编号
		Object sid = superposeDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses());
		
		if (OperateType.ADD.getTypeCode().equals(operType)) {
			for (int i = 0; i < entityList.size(); i++) {
				Object entity = entityList.get(i);
				if (ISaleOper.class.equals(entity.getClass())) {
					superposeDao.add(entity);
				}
				else {
					superposeDao.addSuperpose(entity);
				}
			}
		}
		else {
			logger.error("没有匹配的操作类型");
			throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
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
