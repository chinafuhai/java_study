package com.asiainfo.boss4;

import java.io.File;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;

import com.asiainfo.boss4.webservice.OnBoss4Service;

public class WSClient {
	private static Log logger = LogFactory.getLog(WSClient.class);
	
	private static String httpUrl = Configuration.getHttpUrl();
	private static String httpTimeOut = Configuration.getHttpTimeOut();
	private static String messageDir = Configuration.getMessageDir();
	private static String messageHistoryDir = Configuration.getMessageHistoryDir();
	private static String[] messageSuffixes = Configuration.getMessageSuffix();
	
	public static void main(String[] args) {
		
		String serviceURL = httpUrl;
		serviceURL = "http://localhost:8089/BJ_BOSS4_WS/services/OnBoss4Service";
//		serviceURL = "http://10.7.6.140:8089/BJ_BOSS4_WS/services/OnBoss4Service";
//		serviceURL = "http://10.6.89.182:12100/BJ_BOSS4_WS/services/OnBoss4Service";
//		serviceURL = "http://10.7.6.70:12910/BJ_BOSS4_WS/services/OnBoss4Service";
//		serviceURL = "http://10.7.6.124:12900/BJ_BOSS4_WS/services/OnBoss4Service";
//		serviceURL = "http://10.7.5.133:12104/BJ_BOSS4_WS/services/OnBoss4Service";
//		serviceURL = "http://10.7.5.132:12105/BJ_BOSS4_WS/services/OnBoss4Service";
//		serviceURL = "http://10.7.5.132:12102/BJ_BOSS4_WS/services/OnBoss4Service";//ws3
//		serviceURL = "http://10.7.5.165:13101/BJ_BOSS4_WS/services/OnBoss4Service";//ws1
		
		Service serviceModel = new ObjectServiceFactory().create(OnBoss4Service.class, null,
				"http://boss4.asiainfo.com/OnBoss4Service", null);

		XFireProxyFactory serviceFactory = new XFireProxyFactory();

		try {
			OnBoss4Service service = (OnBoss4Service) serviceFactory.create(serviceModel, serviceURL);
			Client client = Client.getInstance(service);
//			client.addOutHandler(new OutHeaderHandler());

			client.setProperty(CommonsHttpMessageSender.HTTP_TIMEOUT, httpTimeOut);
			
			@SuppressWarnings("unchecked")
			Collection<File> files = FileUtils.listFiles(new File(messageDir), messageSuffixes, false);
			for (File file  : files) {
				String inputXml = FileUtils.readFileToString(file);
				System.out.println(inputXml);
				Date start = new Date();
//				String resultXml = service.onCpcOrder(inputXml);
//				String resultXml = service.onBoss4(inputXml);
				String resultXml = service.onBoss4Crm(inputXml);
//				String resultXml = service.queryCrm(inputXml);
				Date end = new Date();
				
				logger.info("filename => " + file.getName());
				logger.info("result xml => " + resultXml);
				
				long millisecond = end.getTime() - start.getTime();
				logger.info("duration => " + millisecond);
//				FileUtils.moveToDirectory(file, new File(messageHistoryDir), false);
			}
			
//			START~~~~~~~~~~~~~~~~~
//			String inputXml = FileUtils.readFileToString(new File("D:/template/testCpc.xml"));
//			
//			String xml = inputXml;
//			String resultXml;
//			
//			xml = xml.replaceAll("\\#\\{OprNumb\\}", "900001061820");
//			xml = xml.replaceAll("\\#\\{SPID\\}", "801401");
//			xml = xml.replaceAll("\\#\\{SPBizCode\\}", "110285");
//			xml = xml.replaceAll("\\#\\{Opr\\}", "05");
////			xml = xml.replaceAll("\\#\\{EfftT\\}", "2012-09-30 23:59:59");
////			xml = xml.replaceAll("\\#\\{EfftT\\}", "2012-10-01 00:00:00");
//			xml = xml.replaceAll("\\#\\{EfftT\\}", "2012-09-27 18:40:00");
//			resultXml = service.onBoss4Crm(xml);
//			logger.info("result xml => " + resultXml);
//			
////			xml = inputXml;
////			xml = xml.replaceAll("\\#\\{OprNumb\\}", "300001061808");
////			xml = xml.replaceAll("\\#\\{SPID\\}", "901452");
////			xml = xml.replaceAll("\\#\\{SPBizCode\\}", "+MAILBZ");
////			xml = xml.replaceAll("\\#\\{Opr\\}", "07");
//////			xml = xml.replaceAll("\\#\\{EfftT\\}", "2012-09-30 23:59:59");
////			xml = xml.replaceAll("\\#\\{EfftT\\}", "2012-10-01 00:00:00");
//////			xml = xml.replaceAll("\\#\\{EfftT\\}", "2012-09-30 23:59:59");
////			resultXml = service.onBoss4Crm(xml);
////			logger.info("result xml => " + resultXml);
//			END~~~~~~~~~~~~~~~~~~
			
			client.close();

		} catch (Exception e) {
			logger.error(e);
		}
	}

}
