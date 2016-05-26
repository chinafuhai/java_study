package com.asiainfo.openPlatform.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.asiainfo.openPlatform.domain.BwoIntf;

public interface openPlatDao{

	public List queryForList(String sql);

	public Object queryForObject(String sql);
	
	public Serializable save(Object bean);
	
	public void createSQLQuery(String sql);
	
	public String queryPoIdSequence();
	
	public BwoIntf queryBwoIntfById(Long trardId);
	
	public void deleteObject(BwoIntf bean);
	
	public void recordKtBusiLog(Map<String, String> paramMap);
	
	public Long getVgopTransactionId();
	
	
}
