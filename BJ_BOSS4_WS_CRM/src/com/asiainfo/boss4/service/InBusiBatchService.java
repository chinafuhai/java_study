package com.asiainfo.boss4.service;

import java.util.Map;

import com.asiainfo.boss4.exception.BossException;

public interface InBusiBatchService {
	
	/**
	 * 保存批量业务数据
	 * @param map
	 */
	void saveBatchData(Map map);

}
