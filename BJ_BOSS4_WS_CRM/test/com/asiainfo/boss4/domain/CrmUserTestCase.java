package com.asiainfo.boss4.domain;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringBlockJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.asiainfo.boss4.dao.BusinessDaoImpl;
import com.asiainfo.boss4.support.ServiceContext;

@RunWith(SpringBlockJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-service.xml","classpath:test-hibernate.xml", "classpath:test-hibernate-jf.xml", "classpath:test-onboss4.xml" })
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = false)
public class CrmUserTestCase {

	@Autowired
	@Qualifier("businessDao")
	private BusinessDaoImpl businessDao;
	
	private ServiceContext context;
	
	@Before
	public void setContext() {
		context = new ServiceContext(null,null);
		context.setBusinessDao(businessDao);
	}
	
	@Test
	public void testQueryByPhoneId() {
		CrmUser load = CrmUser.queryByPhoneId(context, "13910550640");
		System.out.println(load);
		Assert.assertEquals(new Long(61343478), load.getCustId());
	}
	
}
