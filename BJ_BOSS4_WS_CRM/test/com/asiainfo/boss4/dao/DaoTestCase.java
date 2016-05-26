package com.asiainfo.boss4.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.asiainfo.boss4.domain.CpcTransRule;
import com.asiainfo.boss4.domain.IUserOrder;
import com.asiainfo.boss4.domain.RailwayHead;
import com.asiainfo.boss4.domain.UserInfoExt;
import com.asiainfo.boss4.domain.partition.IAccBusiCredit0105;
import com.asiainfo.boss4.domain.partition.IUserOrder0105;
import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.ServiceContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-service.xml","classpath:test-hibernate.xml", "classpath:test-hibernate-jf.xml", "classpath:test-onboss4.xml" })
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = false)
public class DaoTestCase {
	private static Logger logger = Logger.getLogger(DaoTestCase.class.getSimpleName());
	
//	public static final String[] APP_CONTEXT_PATH = new String[] {
//			"/com/asiainfo/boss4/dao/applicationContext-dao.xml",
//			"/com/asiainfo/boss4/webservice/applicationContext-hibernate.xml" };
//	private static ApplicationContext applicationContext;
//
//	@BeforeClass
//	public static void setUp() throws Exception {
//		// Initialize the spring context for tests.
//		applicationContext = new ClassPathXmlApplicationContext(
//				APP_CONTEXT_PATH);
//	}
	@Autowired
	private CancelUserDao cancelUserDao;
	
	@Autowired
	private CpcOrderDao cpcOrderDao;
	
	@Autowired
	private IAccBusiCreditDao iAccBusiCreditDao;
	
	@Autowired
	private JfBusinessDao jfBusinessDao;
	
	private ServiceContext context;
	
	@Before
	public void setContext() {
		context = new ServiceContext(null,null);
		context.setBusinessDao(cpcOrderDao);
	}
	
	@Test
	public void testRailwayHead() {
		List<RailwayHead> list = RailwayHead.queryAll(context);
		for (RailwayHead head : list) {
			System.out.println(head);
		}
	}
	
	@Test
	public void testUserInfoExtAdd() {
		try {
			UserInfoExt u = new UserInfoExt();
			u.setKeyId("123");
			u.setKeyType(1000L);
			u.setKeyValue("test");
			u.setSoNbr(111111L);
			u.setCreateDate(new Date());
			u.setValidDate(new Date());
			u.setExpireDate(DateHelper.String2Date("2030-01-01 00:00:00"));
			u.setRemark(null);
			
			u.add(context);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testUserInfoExtCancel() {
		try {
			UserInfoExt u = new UserInfoExt();
			u.setKeyId("123");
			u.setKeyType(1000L);
			u.setKeyValue("test");
			u.setSoNbr(111112L);
			
			u.cancel(context);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testUserInfoExtQuery() {
		try {
			UserInfoExt u = new UserInfoExt();
			u.setKeyId("123");
			u.setKeyType(1000L);
			u.setKeyValue("test");
			u.setSoNbr(111112L);
			
			List<UserInfoExt> list = u.query(context);
			for (UserInfoExt item : list) {
				System.out.println(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testQueryCostOfSP() {
		try {
			Long amount = jfBusinessDao.queryCostOfPhoneGameSP("13800138123", "20120608");
			System.out.println(amount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testChangeCreditLevelOfIAccBusiCredit() {
		try {
			IAccBusiCredit0105 entity = new IAccBusiCredit0105();
			entity.setAcctId(9100003514L);
			entity.setServId(9100003514L);
			entity.setCreditLevel(100);
			iAccBusiCreditDao.changeCreditLevelOfIAccBusiCredit(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetCpcTransRule() {
		try {
			System.out.println(cpcOrderDao.getCpcTransRule("801324a", "102434"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetCpcTransRule1() {
		try {
			ServiceContext.INSTANCE_IN_THREAD.set(context);
			System.out.println(CpcTransRule.queryCpcTransRule("801401", "110285").queryNumberOfMonthToExtending());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryHistoricalOrder() {
		try {
			ServiceContext.INSTANCE_IN_THREAD.set(context);
			IUserOrder0105 order = new IUserOrder0105();
			order.setServId(9100003514L);
			order.setSpCode("801401");
			order.setOperatorCode("135355");
			order.setThirdMsisdn("13800138123");
			System.out.println(new IUserOrder.IUserOrderDaoHandle(order).queryHistoricalOrder());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryIUserOrder() {
		try {
			IUserOrder order = new IUserOrder0105();
			order.setServId(9100003514L);
			order.setThirdMsisdn("13800138123");
			order.setSpCode("901452");
			order.setOperatorCode("+MAILVIP");
			order.setValidDate(DateHelper.String2Date("2012-08-02 00:00:00"));
			System.out.println(cpcOrderDao.queryIUserOrder(order));
			order.setValidDate(DateHelper.String2Date("2012-09-01 00:00:00"));
			System.out.println(cpcOrderDao.queryIUserOrder(order));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void testCancel() {
//		try {
//			IUserOrder order = new IUserOrder0105();
//			order.setServId(9100003514L);
//			order.setThirdMsisdn("13800138123");
//			order.setSpCode("901452");
//			order.setOperatorCode("+MAILVIP");
//			order.setValidDate(new Date());
//			order.setSoNbr(12345L);
//			cpcOrderDao.cancel(order, "servId,spCode,operatorCode,thirdMsisdn,expireDate,orderSts".split(","), new int[]{0});
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	
	@Test
	public void testGetServIdFromPbx() {
		try {
			System.out.println(cpcOrderDao.getServIdFromPbx("01052820282"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetDatesOfIUserOrder() {
		try {
			IUserOrder order  = new IUserOrder0105();
			order.setServId(9100003514L);
			order.setServType(0);
			order.setSpCode("801324");
			order.setOperatorCode("102434");
			order.setThirdMsisdn("10657100041326");
			Map<String,Object> dates = cpcOrderDao.getLastIUserOrder(order);
			for (Map.Entry<String, Object> date : dates.entrySet()) {
				System.out.println(date.getKey() + "|" + date.getValue());
			}
			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testcancelIUserOrder() {
		try {
			IUserOrder order  = new IUserOrder0105();
			order.setServId(9100003514L);
			order.setServType(0);
			order.setSpCode("801324");
			order.setOperatorCode("102434");
			order.setThirdMsisdn("13800138123");
			order.setOrderSts((byte)2);
			order.setSoNbr(0L);
			order.setExpireDate(DateHelper.String2Date("20111019120000", AppConstant.CPC_DATE_FORMAT));
			cpcOrderDao.cancelIUserOrder(order);

			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryGroupCrmUserByPhoneId() {
		try {
			System.out.println(cancelUserDao.queryGroupCrmUserByPhoneId("10657100041326"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	@Test
//	public void testIsExistStatusRec() {
//		SwitchUserStatusDao dao = (SwitchUserStatusDao) applicationContext.getBean("switchUserStatusDao");
//		try {
//			Assert.assertEquals(true, dao.isExistStatusRec(9100003504L));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testDeleteStatusRecByMgntSts() {
//		SwitchUserStatusDao dao = (SwitchUserStatusDao) applicationContext.getBean("switchUserStatusDao");
//		try {
//			dao.deleteStatusRecByMgntSts(9100003504L,Byte.valueOf("1"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testQueryCrmUser() {
//		QueryBusinessDao dao = (QueryBusinessDao) applicationContext.getBean("queryBusinessDao");
//		try {
//			Map<String, Object> result = dao.queryCrmUser("13716000161");
//			BeanCopyHelper.formatMapToString(result);
//			for (Map.Entry<String, Object> entry : result.entrySet()) {
//				System.out.println(entry.getKey() + "|" +entry.getValue());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testQueryUserStatus() {
//		QueryBusinessDao dao = (QueryBusinessDao) applicationContext.getBean("queryBusinessDao");
//		try {
//			Calendar startDate = Calendar.getInstance();
////			startDate.set(2009, 7, 1, 0, 0, 0);
//			startDate.setTime(new Date());
//			startDate.add(Calendar.MONTH, -24);
//			
//			List<Map<String, Object>> results = dao.queryUserStatus("13601298115", startDate.getTime());
//			for (Map<String, Object> result : results) {
//				BeanCopyHelper.formatMapToString(result);
//				for (Map.Entry<String, Object> entry : result.entrySet()) {
//					System.out.print(entry.getKey() + ":" +entry.getValue()+" | ");
//				}
//				System.out.println();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testQueryBusiLog() {
//		QueryBusinessDao dao = (QueryBusinessDao) applicationContext.getBean("queryBusinessDao");
//		try {
//			Calendar startDate = Calendar.getInstance();
//			Calendar endDate = Calendar.getInstance();
//			startDate.set(2010, 10, 1, 0, 0, 0);
//			endDate.set(2010, 11, 31, 23, 59, 58);
//			
//			List<Map<String, Object>> results = dao.queryBusiLog("13800138000", "10800", startDate.getTime(), endDate.getTime());
//			for (Map<String, Object> result : results) {
//				BeanCopyHelper.formatMapToString(result);
//				for (Map.Entry<String, Object> entry : result.entrySet()) {
//					System.out.print(entry.getKey() + ":" +entry.getValue()+" | ");
//				}
//				System.out.println();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testQueryIsExistFutureEffectiveOffer() {
//		QueryBusinessDao dao = (QueryBusinessDao) applicationContext.getBean("queryBusinessDao");
//		try {
//			Map<String, Object> result = dao.queryIsExistFutureEffectiveOffer("15901306109");
//			BeanCopyHelper.formatMapToString(result);
//			for (Map.Entry<String, Object> entry : result.entrySet()) {
//				System.out.println(entry.getKey() + "|" +entry.getValue());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testQuerySuspendRecordInfo() {
//		QueryBusinessDao dao = (QueryBusinessDao) applicationContext.getBean("queryBusinessDao");
//		try {
//			Map<String, Object> result = dao.querySuspendRecordInfo("13716000161");
//			BeanCopyHelper.formatMapToString(result);
//			for (Map.Entry<String, Object> entry : result.entrySet()) {
//				System.out.println(entry.getKey() + "|" +entry.getValue());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testQueryEntitysToList() {
//		CancelUserDao dao = (CancelUserDao) applicationContext.getBean("cancelUserDao");
//		try {
//			Map<String, Object> params = new HashMap<String, Object>(1);
//			params.put("servId", 9100003504L);
//			List<OweNoPressStop> smsList = dao.queryEntitysToList(OweNoPressStop.class, params);
//			
//			for (OweNoPressStop iUserSmsOrder : smsList) {
//				System.out.println(iUserSmsOrder);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testQueryServIdByPhoneNumber() {
//		BusinessDao dao = (BusinessDao) applicationContext.getBean("businessDao");
//		try {
//			IUser user = dao.queryIUserByPhoneNumber("15891652003");
//			Assert.assertEquals(new Long(9100003504L), user.getServId());
//			Assert.assertEquals("9100003504", user.getServId().toString());
//			
////			Long servId = dao.queryServIdByPhoneNumber("13301505810");
////			Assert.assertEquals(null, servId);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testIsUserExist() {
//		BusinessDao dao = (BusinessDao) applicationContext.getBean("businessDao");
//		try {
//			boolean result = dao.isExistIUser("9100003504");
//			Assert.assertEquals(true, result);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testQueryIUserAllByPhoneNumber() {
//		BusinessDao dao = (BusinessDao) applicationContext.getBean("businessDao");
//		try {
//			IUser user = dao.queryIUserAllByPhoneNumber("15010844617");
//			Assert.assertEquals(16507850L, user.getServId().longValue());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testChangeWithMergeCrm() {
//		BusinessDao dao = (BusinessDao) applicationContext.getBean("businessDao");
//		try {
//			CrmCustomer entity = new CrmCustomer();
//			entity.setCustId(9100003497L);
//			entity.setCustName("who?");
//			entity.setSoNbr(209120000990129L);
//			OneOpreateConfig config = OperateConfiguration.getConfigByTranCode(TranCode.CHANGE_CUSTOMER.getTranCode());
//			String[] conditions = config.getConditionCols(entity.getClass().getName());
//			dao.changeWithMergeCrm(entity, conditions, new Date());	
//
////			Assert.assertEquals(true, result);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testQueryBrand() {
//		BusinessDao dao = (BusinessDao) applicationContext.getBean("businessDao");
//		try {
//			EnumSet<BrandType> result = dao.queryBrand("servId", "9100003524");
//			for (BrandType brandType : result) {
//				System.out.println(brandType.code() + "|" + brandType.description());
//			}
////			Assert.assertEquals(true, result);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testChangeWithMerge() {
//		BusinessDao dao = (BusinessDao) applicationContext.getBean("businessDao");
//		Date currentDate = dao.queryCurrentDate();
//		try {
//			IUser entity = new IUser();
//			entity.setServId(1000508L);
//			entity.setSoNbr(900913L);
//			entity.setExpireDate(new Date(2099,1,1));
//			entity.setRemark("test1");
//			dao.changeWithMerge(entity, new String[]{"servId","expireDate"}, currentDate);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testAddIUser() {
//		BaseDao dao = (BaseDao) applicationContext.getBean("baseDao");
//		BusinessDao bDao = (BusinessDao) applicationContext.getBean("businessDao");
//		
//		IUser entity = new IUser();
//		entity.setServId(9000000L);
//		entity.setSoNbr(90000L);
//		entity.setValidDate(new Date(2010,1,6));
//		entity.setExpireDate(new Date(2099,1,1));
//		entity.setSid(90000);
//		entity.setRemark("test_add");
//		dao.insert(entity);
//	}
//	
//	@Test
//	public void testQueryICustomerByCustId() {
//		BusinessDao dao = (BusinessDao) applicationContext.getBean("businessDao");
//		try {
//			ICustomer cust = dao.queryICustomerByCustId(new Long("1000040"));
//			System.out.println(cust);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testQueryCrmCustomerByCustId() {
//		BusinessDao dao = (BusinessDao) applicationContext.getBean("businessDao");
//		try {
//			CrmCustomer cust = dao.queryCrmCustomerByCustId(new Long("1000040"));
//			System.out.println(cust);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testQueryCrmUserByServId() {
//		BusinessDao dao = (BusinessDao) applicationContext.getBean("businessDao");
//		try {
//			CrmUser user = dao.queryCrmUserByServId(new Long("800007594"));
//			System.out.println(user);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testQueryIUserByServId() {
//		BusinessDao dao = (BusinessDao) applicationContext.getBean("businessDao");
//		try {
//			IUser user = dao.queryIUserByServId(9100003504L);
//			System.out.println(user);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testQueryCrmAccountByAcctId() {
//		BusinessDao dao = (BusinessDao) applicationContext.getBean("businessDao");
//		try {
//			CrmAccount acct = dao.queryCrmAccountByAcctId(new Long("810000003"));
//			System.out.println(acct);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testQueryIAccountByAcctId() {
//		BusinessDao dao = (BusinessDao) applicationContext.getBean("businessDao");
//		try {
//			IAccount acct = dao.queryIAccountByAcctId(new Long("1000021"));
//			System.out.println(acct);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testBackup() {
//		BusinessDao dao = (BusinessDao) applicationContext.getBean("businessDao");
//		try {
//			CrmUser entity = new CrmUser();
//			entity.setServId(57331421677L);
//			
//			CrmUserOther userOther = dao.queryCrmUserOtherByServId( ((CrmUser)entity).getServId() );
//			dao.backup(userOther, new String[]{"servId", "expireDate"}, "Other", false);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
