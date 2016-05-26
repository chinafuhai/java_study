package com.asiainfo.boss4.support;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;

/**
 * 一个交易代码对应的配置
 * @author xiaopeng, caohui
 */
public class OneOpreateConfig {
	
	private static Log logger = LogFactory.getLog(OneOpreateConfig.class);

	private String tranCode;
	private String resetRegionCode;
	private boolean backup = false;
	private Map<String, TableConfig> tableMap;
	
	public OneOpreateConfig() {
	}
	
	public OneOpreateConfig(String tranCode, String resetRegionCode, boolean backup, Map<String, TableConfig> tableMap) {
		super();
		this.tranCode = tranCode;
		this.resetRegionCode = resetRegionCode;
		this.backup = backup;
		this.tableMap = tableMap;
	}
	
	public String getTranCode() {
		return tranCode;
	}

	public void setTranCode(String tranCode) {
		this.tranCode = tranCode;
	}
	
	public String getResetRegionCode() {
		return resetRegionCode;
	}

	public void setResetRegionCode(String resetRegionCode) {
		this.resetRegionCode = resetRegionCode;
	}
	
	public boolean isBackup() {
		return backup;
	}

	public void setBackup(boolean backup) {
		this.backup = backup;
	}

	public Map<String, TableConfig> getTableMap() {
		return tableMap;
	}

	public void setTableMap(Map<String, TableConfig> tableMap) {
		this.tableMap = tableMap;
	}

	/**
	 * 获取交易代码对应的操作表
	 * @param tranType
	 * @return
	 */
	public Class[] getClasses(){
		if (tableMap.size() == 0) {//交易代码无对应的操作表
			throw new BossException(StatusCode.NO_OPER_TABLE_ERROR);
		}
		Class[] classes = new Class[tableMap.size()];
//		Set set =  map.keySet();
		int j=0;
		for (Iterator i = tableMap.values().iterator(); i.hasNext(); ) {
			classes[j] = ((TableConfig) i.next()).getClazz();
			j++;
		}
		return classes;
	}
	
	/**
	 * 获取交易代码对应的操作表(只获取满足前提条件的操作表)
	 * @param vo
	 * @return
	 */
	public Class[] getClasses(LazyDynaMap vo){
		if (tableMap.size() == 0) {//交易代码无对应的操作表
			throw new BossException(StatusCode.NO_OPER_TABLE_ERROR);
		}
		
		List<Class> entityClasses = new ArrayList<Class>();
		for (TableConfig table : tableMap.values()) {
			Map<String, String> precondition = table.getPrecondition();
			if (precondition.size() == 0) {
				entityClasses.add(table.getClazz());
				continue;
			}
			boolean passed = true;
			for (Map.Entry<String, String> entry : precondition.entrySet()) {
				if ("null".equals(entry.getValue()) && vo.get(entry.getKey()) == null) {
					continue;
				}
				if ("non-null".equals(entry.getValue()) && vo.get(entry.getKey()) != null) {
					continue;
				}
				if ( !entry.getValue().equals( vo.get(entry.getKey()) ) ){
					passed  = false;
					break;
				}
			}
			if (passed) {
				entityClasses.add(table.getClazz());
			}
		}
		
//		Class[] classes = new Class[tableMap.size()];
//		int j=0;
//		for (Iterator i = tableMap.values().iterator(); i.hasNext(); ) {
//			classes[j] = ((TableConfig) i.next()).getClazz();
//			j++;
//		}
		
		return entityClasses.toArray(new Class[entityClasses.size()]);
	}
	
	/**
	 * 获取表更改需要的条件字段
	 * @param clazzName
	 * @return
	 */
	public String[] getConditionCols(String clazzName){
		String[] cols = null;
		try {
			cols = ((TableConfig) tableMap.get(clazzName)).getCols();
		} catch (Exception e) {
			logger.error("无法获取表" + clazzName + "更改需要的条件字段");
			throw new BossException(StatusCode.TABLE_CONFIG_ERROR);
		}
		return cols;
	}
	
	/**
	 * 获取表的操作类型
	 * @param clazzName
	 * @return
	 */
	public String getOperateType(String clazzName){
		return ((TableConfig) tableMap.get(clazzName)).getOperateType();
	}
	
	/**
	 * 获取表指定更改的字段
	 * @param clazzName
	 * @return
	 */
	public String[] getUpdateFields(String clazzName){
		return ((TableConfig) tableMap.get(clazzName)).getUpdateFields();
	}
	
	/**
	 * 是否需要更新RegionCode
	 * @param clazzName
	 * @return
	 */
	public boolean isResetRegionCode(){
		if (resetRegionCode == null || "true".equalsIgnoreCase(resetRegionCode.trim())) {
			return true;
		}
		return false;
	}

}
