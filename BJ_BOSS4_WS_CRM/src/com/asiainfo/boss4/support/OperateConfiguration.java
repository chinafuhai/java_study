package com.asiainfo.boss4.support;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.asiainfo.boss4.domain.IUser;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
/**
 * 加载OperateConfiguration配置文件的service类
 * @author xiaopeng
 *
 */
public class OperateConfiguration {
	private static Log logger = LogFactory.getLog(OperateConfiguration.class);
	
	private final static String OPERATE_CONFIG_FILE = "OperateConfiguration.xml";
	
	private static Map<String, OneOpreateConfig> configMap = new HashMap<String, OneOpreateConfig>();
	
	private final static String TABLE_NAME_PREX = IUser.class.getPackage().getName().concat(".");
	
	public static Map<String, OneOpreateConfig> getConfigMap() {
		return configMap;
	}

	/**
	 * 加载OperateConfiguration配置文件
	 */
	public static void loadConfiguration(){
		logger.debug("Loading OperateConfiguration.xml");
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(OPERATE_CONFIG_FILE); 
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(in);
			Element root = document.getRootElement();
			//遍历交易item
			for (Iterator i = root.elementIterator(); i.hasNext(); ) {
				Element itemElement = (Element) i.next();
				String tranCode = itemElement.elementTextTrim("tran_code");
				String resetRegionCode = itemElement.elementTextTrim("reset_region_code");
				// 取<backup>元素值
				boolean isBackup = "true".equalsIgnoreCase(itemElement.elementTextTrim("backup")) ? true : false;
				HashMap<String, TableConfig> tableMap = new LinkedHashMap<String, TableConfig>();
				
				for (Iterator k = itemElement.elementIterator(); k.hasNext();) {
					Element tableElement = (Element) k.next();
					if ("table".equals(tableElement.getName())) {
						TableConfig tableConfig = new TableConfig();

						String tableName = tableElement.elementTextTrim("table_name");
						
						//表的映射类
						Class tableClass = Class.forName(TABLE_NAME_PREX+tableName); 
						
						//条件列
						String colsString = tableElement.elementTextTrim("cols");
						String[] cols = null;
						if (colsString!=null) {
							cols = colsString.split(",");
						}
						
						String operateType = tableElement.elementTextTrim("operate_type");
						
						//更新字段
						String updateFieldsString = tableElement.elementTextTrim("updateFields");
						String[] updateFields = null;
						if (updateFieldsString!=null) {
							updateFields = updateFieldsString.split(",");
						}
						
						//更新字段
						String precondition = tableElement.elementTextTrim("precondition");
						if (precondition != null) {
							String[] pairs =  precondition.split(",");
							for (String pair : pairs) {
								String[] pairItem = pair.split(":");
								if (pairItem.length != 2) {
									throw new BossException(StatusCode.LOADING_CONFIG_ERROR, "表操作的前提条件配置出错，配置格式为key1:value1,key2:value2");
								}
								tableConfig.getPrecondition().put(pairItem[0], pairItem[1]);
							}
						}
						
						tableConfig.setClazz(tableClass);
						tableConfig.setCols(cols);
						tableConfig.setOperateType(operateType);
						tableConfig.setUpdateFields(updateFields);
						
						tableMap.put(tableClass.getName(), tableConfig);
					}
				}
				configMap.put(tranCode, new OneOpreateConfig(tranCode, resetRegionCode, isBackup, tableMap));
				
			}
		} catch (DocumentException e) {
			logger.error("加载OperateConfiguration配置文件出错", e);
		} catch (ClassNotFoundException e) {
			logger.error("找不到类", e);
		} catch (Exception e) {
			logger.error("加载配置出错", e);
		}
		finally{
			try {
				in.close();
			} catch (IOException e) {
				logger.error("关闭读OperateConfiguration.xml配置文件流时出错", e);
			}
		}
	}
	
	/**
	 * 根据交易代码获取该交易对应的配置
	 * @param tranCode
	 * @return
	 */
	public static OneOpreateConfig getConfigByTranCode(String tranCode){
		//判断传入的交易代码是否在配置中存在
		if (!configMap.containsKey(tranCode)) {
			logger.warn("无此交易代码:"+tranCode);
			throw new BossException(StatusCode.NOT_EXIST_TRANCODE_ERROR);
		}
		return (OneOpreateConfig) configMap.get(tranCode);
	}
}
