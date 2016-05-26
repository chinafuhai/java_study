package com.asiainfo.boss4.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.RepealChangeBrandDao;
import com.asiainfo.boss4.domain.ISaleOper;
import com.asiainfo.boss4.domain.ISpromParam;
import com.asiainfo.boss4.domain.IUserCell;
import com.asiainfo.boss4.domain.IUserMsc;
import com.asiainfo.boss4.domain.IUserSprom;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.UpFieldUtil;

/**
 * 全网携号转品牌撤单服务类
 * @author xiaopeng
 *
 */
public class RepealChangeBrandServiceImpl implements BusinessService{
	private static Log logger = LogFactory.getLog(RepealChangeBrandServiceImpl.class);
	
	private RepealChangeBrandDao repealChangeBrandDao;

	public RepealChangeBrandDao getRepealChangeBrandDao() {
		return repealChangeBrandDao;
	}

	public void setRepealChangeBrandDao(RepealChangeBrandDao repealChangeBrandDao) {
		this.repealChangeBrandDao = repealChangeBrandDao;
	}

	public String process(LazyDynaMap vo, Map requestStatus) {
		// 取交易代码
		String tranCode = (String) vo.get("tranCode");
		
		// 取此交易需要操作的实体类
		OneOpreateConfig config =  OperateConfiguration.getConfigByTranCode(tranCode);
		//更新标志串  UP_FIELD 
		UpFieldUtil.setUpField(vo);
		// 设置消息编号，一个交易(item)拥有同一个消息编号
		Object sid = repealChangeBrandDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses());
		
		Set spromStypeSet = new HashSet();//更新的sprom表记录的spromType集合
		
		//设置空upField值
		String upFiled = UpFieldUtil.EMPTY_UPFIELD;
		
		for (int i = 0; i < entityList.size(); i++) {
			Object entity = entityList.get(i);
			Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
			if (ISaleOper.class.equals(entityClass)) {//先不写上发通知表
				continue;
			}
			String[] conditions = config.getConditionCols(entityClass.getName());
			
			if (IUserSprom.class.equals(entityClass) || IUserMsc.class.equals(entityClass)) {
				//IUserSprom和IUserMsc还调原来的方法，如果改动IUserSprom，把spromType放入集合
				repealChangeBrandDao.repealChangeBrand(entity, conditions, spromStypeSet);
			}
			else {
				//ISpromParam、IUserCell表调通用方法，撤销零条或多条数据
				List list = repealChangeBrandDao.rollbackMuti(entity);
				
				if ((IUserCell.class.equals(entityClass) || ISpromParam.class.equals(entityClass))
						&& list.size() > 0) {
					// 如果操作的是IUserCell或ISpromParam表并且操作的数据条数大于0，根据类设置upField相应位的值
					upFiled = UpFieldUtil.modifyUpFieldByClass(upFiled, entityClass);
				}
			}
		}
		
		StringBuffer upFiledSb = new StringBuffer(upFiled);
		for (Object entity : entityList) {
			if (ISaleOper.class.equals(EntityPartitionHelper.getOriginalClassForPartition(entity))) {
				ISaleOper iSaleOper = (ISaleOper) entity;
				for (Iterator i = spromStypeSet.iterator();i.hasNext(); ) {
					//根据更新记录的spromType更新标志串  UP_FIELD 
					UpFieldUtil.modifyUpFieldBySpromType(upFiledSb, ((Integer)i.next()).toString());
				}
				//如果upFiled不全是0，则写上发通知表
				if (upFiledSb.toString().contains("1")) {
					iSaleOper.setUpField(upFiledSb.toString());
					repealChangeBrandDao.add(entity);//写入上发通知表
				}
				break;
			}
		}
		
		return null;
	}

}
