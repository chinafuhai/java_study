package com.asiainfo.boss4.webservice;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-service.xml","classpath:test-hibernate.xml", "classpath:test-hibernate-jf.xml", "classpath:test-onboss4.xml" })
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = false)
@Transactional
public class OnBoss4TestCase {
	private static Logger logger = Logger.getLogger(OnBoss4TestCase.class.getSimpleName());
	
//	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
//			new String[] {"classpath:applicationContext-service.xml","classpath:test-hibernate.xml", "test-onboss4.xml"});

	@Autowired
	private OnBoss4ServiceImpl onBoss4ServiceImpl;

//	@BeforeClass
//	public static void setUp() throws Exception {
//		// Initialize the spring context for tests.
//		service = (OnBoss4ServiceImpl) applicationContext.getBean("onBoss4ServiceImpl");
//	}
	
	public static final String BASE_DIR = "D:/workspace/ai_project/BJ_CMCC_BOSS/tmp/template/";
	
	@Test
	public void test() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "test.xml"));
			onBoss4ServiceImpl.onBoss4Crm(inputXml);
//			onBoss4ServiceImpl.onBoss4(inputXml);
//			onBoss4ServiceImpl.onCpcOrder(inputXml);
//			onBoss4ServiceImpl.queryCrm(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCmTaxpayerInfo() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testCmTaxpayerInfo.xml"));
			onBoss4ServiceImpl.onBoss4Crm(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCmAndTaxContact() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testCmAndTaxContact.xml"));
			onBoss4ServiceImpl.onBoss4Crm(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testIUserShareSprom() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testIUserShareSprom.xml"));
			onBoss4ServiceImpl.onBoss4Crm(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOweMonitorSpecQuota() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testOweMonitorSpecQuota.xml"));
			onBoss4ServiceImpl.onBoss4Crm(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBadInfoCancelUser() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testBadInfoCancelUser.xml"));
			onBoss4ServiceImpl.onBoss4Crm(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBillCycle() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testBillCycle.xml"));
			onBoss4ServiceImpl.onBoss4Crm(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryCustAcctUserHis() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testQueryCustAcctUserHis.xml"));
			onBoss4ServiceImpl.queryCrm(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryAcctHis() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testQueryAcctHis.xml"));
			onBoss4ServiceImpl.queryCrm(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryAccountPost() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testQueryAccountPost.xml"));
			onBoss4ServiceImpl.queryCrm(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUserInfoExt() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testUserInfoExt_DEL.xml"));
			onBoss4ServiceImpl.onBoss4Crm(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testQueryRailwayHead() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testQueryRailwayHead.xml"));
			onBoss4ServiceImpl.queryCrm(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryCostOfPhoneGame() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testQueryCostOfPhoneGame.xml"));
			onBoss4ServiceImpl.queryCrm(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCpc() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testCpc.xml"));
			String xml = inputXml;
			xml = xml.replaceAll("\\#\\{OprNumb\\}", "300001061847");
			xml = xml.replaceAll("\\#\\{SPID\\}", "12345");
			xml = xml.replaceAll("\\#\\{SPBizCode\\}", "ABCDEF");
			xml = xml.replaceAll("\\#\\{Opr\\}", "07");
			xml = xml.replaceAll("\\#\\{phoneId\\}", "13800138123");
			xml = xml.replaceAll("\\#\\{EfftT\\}", "2013-04-30 23:59:59");
//			xml = xml.replaceAll("\\#\\{EfftT\\}", "2013-05-01 00:00:00");
//			xml = xml.replaceAll("\\#\\{EfftT\\}", "2013-04-12 16:55:00");
			onBoss4ServiceImpl.onBoss4Crm(xml);
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}
	
	@Test
	public void test139Mail() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "test139Mail.xml"));
			onBoss4ServiceImpl.onBoss4Crm(inputXml);
//			onBoss4ServiceImpl.onBoss4(inputXml);
//			onBoss4ServiceImpl.onCpcOrder(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTransBrand() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testTransBrand.xml"));
			onBoss4ServiceImpl.onBoss4Crm(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testIAccBusiCredit() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testIAccBusiCredit.xml"));
			onBoss4ServiceImpl.onBoss4Crm(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCrmAccount() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "newCrmAccount.xml"));
			onBoss4ServiceImpl.onBoss4Crm(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		OnBoss4TestCase testCase = new OnBoss4TestCase();
		try {
//			testCase.setUp();
			testCase.testChangeUserStatus();
		} catch (Exception e) {
			e.printStackTrace();
		}
		testCase.testOpenAccount();
	}
	
	@Test
	public void testQueryBossID() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testQueryBossID.xml"));
			String result = onBoss4ServiceImpl.onBoss4(inputXml);
//			System.out.println("result ================> " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryCrmID() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testQueryCrmId.xml"));
			String result = onBoss4ServiceImpl.queryCrmId(inputXml);
			System.out.println("result ================> " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSmsOrder() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testUserSmsOrder.xml"));
			String result = onBoss4ServiceImpl.onBoss4(inputXml);
//			System.out.println("result ================> " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAccBusiSms() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testAccBusiSms.xml"));
			String result = onBoss4ServiceImpl.onBoss4(inputXml);
//			System.out.println("result ================> " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQuerySuspendRecordInfo() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "QuerySuspendRecordInfo.xml"));
			String result = onBoss4ServiceImpl.onBoss4(inputXml);
//			System.out.println("result ================> " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryInfoByMSISDN() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "QueryInfoByMSISDN.xml"));
			String result = onBoss4ServiceImpl.onBoss4(inputXml);
//			System.out.println("result ================> " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOpenAccount() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testOpenAccount.xml"));
			onBoss4ServiceImpl.onBoss4(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOpenAccountForCRM() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testOpenAccount_CRM1.xml"));
			onBoss4ServiceImpl.onBoss4Crm(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOpenAccountGroup() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testOpenAccount_11600.xml"));
			onBoss4ServiceImpl.onBoss4(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOpenAccountAgent() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testOpenAccount_10013.xml"));
			onBoss4ServiceImpl.onBoss4(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTransferAccount() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testOpenAccount_10009.xml"));
			onBoss4ServiceImpl.onBoss4(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOpenOrCloseAccountGroup() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testOpenAccount.xml"));
			onBoss4ServiceImpl.onBoss4(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testNonMasterTransferAccount() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testOpenAccount_10003.xml"));
			onBoss4ServiceImpl.onBoss4(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testChangeUserStatus() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testChangeUserStatus_10305.xml"));
			onBoss4ServiceImpl.onBoss4(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSwitchUserStatus() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testSwitchUserStatus_10303.xml"));
			onBoss4ServiceImpl.onBoss4(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testChangeCustomer() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testChangeAccountCustomerUser_10902.xml"));
			onBoss4ServiceImpl.onBoss4(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testChangeAccount() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testChangeAccountCustomerUser_10905.xml"));
			onBoss4ServiceImpl.onBoss4(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testChangeUser() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testChangeAccountCustomerUser_10903.xml"));
			onBoss4ServiceImpl.onBoss4(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testChangeSim() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testChangeSim_10700_1.xml"));
			onBoss4ServiceImpl.onBoss4(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testChangeSprom() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testChangeSprom.xml"));
			onBoss4ServiceImpl.onBoss4(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEasyownGOpenAccount() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testEasyownGOpenAccount.xml"));
			onBoss4ServiceImpl.onBoss4(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEasyownGCancelUser() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testEasyownGCancelUser.xml"));
			onBoss4ServiceImpl.onBoss4(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCancelUser() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testCancelUser.xml"));
			onBoss4ServiceImpl.onBoss4(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCancelUser11100() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testCancelUser_11100.xml"));
			onBoss4ServiceImpl.onBoss4(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCancelUserBatch() {
		try {
			List<String> lines = FileUtils.readLines(new File("D:/workspace/桌面/Book2.csv"));
			int i = 1;
			for (String line : lines) {
				System.out.println(i+"=>"+line);
				String[] params = line.split(",");
				String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testCancelUser.xml"));
				inputXml = inputXml.replaceAll("<servId>9100003504</servId>", "<servId>"+params[0]+"</servId>");
				inputXml = inputXml.replaceAll("<acctId>9100003504</acctId>", "<acctId>"+params[1]+"</acctId>");
				inputXml = inputXml.replaceAll("<custId>9100003504</custId>", "<custId>"+params[2]+"</custId>");
				inputXml = inputXml.replaceAll("<msisdn>13800138000</msisdn>", "<msisdn>"+params[3]+"</msisdn>");
				inputXml = inputXml.replaceAll("<oldBrand>7</oldBrand>", "<oldBrand>"+params[4]+"</oldBrand>");
				inputXml = inputXml.replaceAll("<newBrand>4</newBrand>", "<newBrand>"+params[5]+"</newBrand>");
				String resultXml = onBoss4ServiceImpl.onBoss4(inputXml);
				if (resultXml.indexOf("<retCode>000000</retCode>") == -1) {
					System.out.println(resultXml);
					throw new RuntimeException();
				}
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCancelUser10800() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testCancelUser_10800.xml"));
			onBoss4ServiceImpl.onBoss4(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGroupMember() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testGroupMember.xml"));
			onBoss4ServiceImpl.onBoss4(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGroupMember_11613() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testGroupMember_11613.xml"));
			onBoss4ServiceImpl.onBoss4(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGroupBusi() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testGroupBusi_11602_1.xml"));
			onBoss4ServiceImpl.onBoss4(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPayRelation() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testPayRelation1.xml"));
			onBoss4ServiceImpl.onBoss4(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testChargeNotice() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testChargeNotice.xml"));
			onBoss4ServiceImpl.onBoss4(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCpcOrderReq() {
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "cpc_req.xml"));
			onBoss4ServiceImpl.onCpcOrder(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
