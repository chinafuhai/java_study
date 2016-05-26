package com.asiainfo.boss4.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringBlockJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.asiainfo.boss4.dao.CancelUserDao;
import com.asiainfo.boss4.domain.CrmUser;
import com.asiainfo.boss4.domain.IUserPlan;
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.domain.partition.IAccBusiCredit0105;
import com.asiainfo.boss4.domain.partition.IUser0105;
import com.asiainfo.boss4.domain.partition.IUserPlan0105;
import com.asiainfo.boss4.service.crm.CrmCommonService;
import com.asiainfo.boss4.support.OperateType;
import com.asiainfo.boss4.support.ServiceContext;

@RunWith(SpringBlockJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-service.xml","classpath:test-hibernate.xml", "classpath:test-onboss4.xml" })
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = true)
public class ServiceTestCase {

	private static ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		ServiceTestCase test = new ServiceTestCase();
		// Initialize the spring context for tests.
		applicationContext = new ClassPathXmlApplicationContext(new String[] {
				"classpath:applicationContext-service.xml",
				"classpath:test-hibernate.xml", "classpath:test-onboss4.xml" });
		test.crmCommonService = (CrmCommonService) applicationContext.getBean("crmCommonService");
		test.testCrmUser();
	}
	
	@Autowired
	private CancelUserDao businessDao;
	
	@Autowired
	public CrmCommonService crmCommonService;
	
	@Autowired
	public ContextHelper contextHelper;

	@Test
	public void testIUser() {
		IUser0105 user = new IUser0105();
		user.setServId(9100003514L);
		user.setUserType((short) 1);
		
		IUser0105 entity = (IUser0105) businessDao.getEntity(user, new String[]{"servId", "userType", "expireDate"});
		System.out.println(entity);
		businessDao.flush();
		
		entity.setImsi("1234567890");
		entity.setTheOperateType(OperateType.ADD);
		List<BaseEntity> entities = new ArrayList<BaseEntity>();
		entities.add(entity);
		crmCommonService.process(new ServiceContext(entities, contextHelper.getApplicationContext()) );
	}
	
	@Test
	public void testCrmUser() {
		
		CrmUser user = new CrmUser();
		user.setServId(9100003524L);
		
		CrmUser entity = (CrmUser) businessDao.getEntity(user, new String[]{"servId", "expireDate"});
		System.out.println(entity);
		businessDao.flush();
		
		entity.setServId(9100003514L);
		entity.setReserved4("");
		entity.setTheOperateType(OperateType.ADD);
		List<BaseEntity> entities = new ArrayList<BaseEntity>();
		entities.add(entity);
		
		crmCommonService.process(new ServiceContext(entities, contextHelper.getApplicationContext()) );
	}
	
	@Test
	public void testIAccBusiCredit() {
		
		IAccBusiCredit0105 credit = new IAccBusiCredit0105();
		credit.setAcctId(9100003514L);
		credit.setServId(9100003514L);
		BaseEntity entity = (BaseEntity) businessDao.getEntity(credit, new String[]{"acctId", "servId"});
		System.out.println(entity);
		businessDao.flush();
		
		entity.setTheOperateType(OperateType.ADD);
		List<BaseEntity> entities = new ArrayList<BaseEntity>();
		entities.add(entity);
		
		IUser0105 user = new IUser0105();
		user.setServId(9100003514L);
		user.setUserType((short) 1);
		entity = (IUser0105) businessDao.getEntity(user, new String[]{"servId", "userType", "expireDate"});
		System.out.println(entity);
		businessDao.flush();
		entities.add(entity);
		
		IUserPlan0105 plan = new IUserPlan0105();
		plan.setServId(9100003514L);
		entity = (IUserPlan) businessDao.getEntity(plan, new String[]{"servId", "expireDate"});
		System.out.println(entity);
		businessDao.flush();
		entities.add(entity);
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		crmCommonService.process(new ServiceContext(entities, contextHelper.getApplicationContext()) );
	}
	
}
