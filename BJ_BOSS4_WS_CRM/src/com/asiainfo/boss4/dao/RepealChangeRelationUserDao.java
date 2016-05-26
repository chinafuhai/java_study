package com.asiainfo.boss4.dao;

import java.util.Set;

public interface RepealChangeRelationUserDao extends BusinessDao{

	public void rollbackRelation(Object entity, Set updateSoIdSQL);
}
