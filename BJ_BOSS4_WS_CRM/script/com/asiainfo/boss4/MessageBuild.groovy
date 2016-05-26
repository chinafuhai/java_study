package com.asiainfo.boss4

import groovy.sql.Sql
import groovy.text.SimpleTemplateEngine

import java.io.File
import java.text.SimpleDateFormat

import org.apache.commons.io.FileUtils
import org.apache.log4j.Logger
import org.codehaus.xfire.client.Client
import org.codehaus.xfire.client.XFireProxyFactory
import org.codehaus.xfire.service.Service
import org.codehaus.xfire.service.binding.ObjectServiceFactory
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender

import com.asiainfo.boss4.webservice.OnBoss4Service

class MessageBuild {
	static Logger logger = Logger.getLogger("")
	
	static send(message, type = 'boss4') {
		if (message == null) return
//		def serviceURL = "http://10.7.6.70:12100/BJ_BOSS4_WS/services/OnBoss4Service";
//		def serviceURL = "http://10.7.6.70:12500/BJ_BOSS4_WS/services/OnBoss4Service";
//		def serviceURL = "http://10.7.5.133:12104/BJ_BOSS4_WS/services/OnBoss4Service";
//		def serviceURL = "http://10.7.5.132:12105/BJ_BOSS4_WS/services/OnBoss4Service";
//		def serviceURL = "http://10.7.6.70:17400/BJ_BOSS4_WS/services/OnBoss4Service";
		def serviceURL = "http://localhost:8089/BJ_BOSS4_WS/services/OnBoss4Service";
		
		Service serviceModel = new ObjectServiceFactory().create(OnBoss4Service.class, null,
			"http://boss4.asiainfo.com/OnBoss4Service", null);
		XFireProxyFactory serviceFactory = new XFireProxyFactory();
		
		OnBoss4Service service = (OnBoss4Service) serviceFactory.create(serviceModel, serviceURL);
		Client client = Client.getInstance(service);
		client.setProperty(CommonsHttpMessageSender.HTTP_TIMEOUT, "20000");
		if(type == 'cpcOrder'){
			return service.onCpcOrder(message);
		}
		return service.onBoss4(message);
	}
	
	static build_message(phone_id) {
		def date_format = new SimpleDateFormat('yyyy-MM-dd HH:mm:ss')
		def bind = ['sys_date':date_format.format(new Date()), 'phone_id':phone_id]
		def sql = Sql.newInstance("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=10.7.6.30)(PORT=1521))(ADDRESS=(PROTOCOL=TCP)(HOST=10.7.6.31)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=srv_zw1)))",
				"ng3upd", "boss4,dml", "oracle.jdbc.driver.OracleDriver")
//		def sql = Sql.newInstance("jdbc:oracle:thin:@10.7.5.133:1521:ng2tst02",
//			"zg", "ngboss123", "oracle.jdbc.driver.OracleDriver")
		
		
//		sql.eachRow("select zg.sid.nextval as so_nbr from dual") {
//			bind << ['so_nbr':it.so_nbr]
//		}
//		
//		sql.eachRow("select * from inter.i_user_all t where t.MSISDN = ? and t.EXPIRE_DATE > sysdate", [phone_id]) {
//			bind << ['serv_id':it.serv_id, 'acct_id':it.acct_id, 'cust_id':it.cust_id]
//		}
		
		sql.eachRow("select * from b4test.tmp_ch_undelete t where t.MSISDN = ?", [phone_id]) {
			bind << ['serv_id':it.serv_id, 'acct_id':it.acct_id, 'cust_id':it.cust_id, 'so_nbr':it.so_nbr]
		}
		
		println bind
		if (!bind.containsKey('serv_id')) {
			logger.info("$phone_id not existed")
			return
		}
		
		def msg = MessageBuild.class.getResource('10800_template.xml')
		def engine = new SimpleTemplateEngine()
		def template = engine.createTemplate(msg).make(bind)
		return template.toString()
	}
	
	static build_message_by_text(line) {
		def items = line.split(',');
		def bind = ['order_id':items[0],
					'sts_date':items[1],
					'phone_id':items[2],
					'acct_id':items[3],
					'cust_id':items[4],
					'serv_id':items[5],
					'mgnt_sts':items[6]]
		
		if (bind['mgnt_sts'] == "") {
			bind << ['oper_sts':items[7]]
		} else {
			bind << ['oper_sts':""]
		}
		
		def sql = Sql.newInstance("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=10.7.6.30)(PORT=1521))(ADDRESS=(PROTOCOL=TCP)(HOST=10.7.6.31)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=srv_zw1)))",
						"ng3upd", "boss4,dml", "oracle.jdbc.driver.OracleDriver")
		sql.eachRow("select zg.sid.nextval as so_nbr from dual") {
			bind << ['so_nbr':it.so_nbr]
		}
		
		println bind
		
		def msg = MessageBuild.class.getResource('10303_template.xml')
		def engine = new SimpleTemplateEngine()
		def template = engine.createTemplate(msg).make(bind)
		return template.toString()
	}
	
	static build_cpc_order_message_by_line(line) {
		def bind = ['opr':'06', 'sp_id':'501456']
		
		def items = line.split(',');
		bind << [
			'idva':items[0],
			'idvb':items[1],
			'sp_biz_code':items[2],
			'chg_flg':items[3],
			'source':items[4],
			'efft_t':items[5]
		]
		
//		def date_format = new SimpleDateFormat('yyyyMMddHHmmss')
//		bind << ['efft_t': date_format.format(new Date())]
		
		println bind
		
		def msg = MessageBuild.class.getResource('cpc_order_template.xml')
		def engine = new SimpleTemplateEngine()
		def template = engine.createTemplate(msg).make(bind)
		return template.toString()
	}
	
	static build_10607_message_by_line(line, oper_type) {
		def date_format = new SimpleDateFormat('yyyy-MM-dd HH:mm:ss')
		def sysdate = date_format.format(new Date());
		def expire_date = '2030-01-01 00:00:00'
		if(oper_type == '3') expire_date = sysdate
		
		def bind = ['oper_type':oper_type, 'sysdate':sysdate, 'expire_date':expire_date, 'imsi':'0']
		
		def items = line.split(',');
		bind << [
			'serv_id':items[0],
			'msisdn':items[1],
			'user_type':items[2]
		]
		
		if (oper_type == '1') {
			bind << ['brand':items[3], 'acct_id':items[4], 'cust_id':items[5]]
		} else bind << ['brand':'', 'acct_id':'', 'cust_id':'']
		
		def sql = Sql.newInstance("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=10.7.6.30)(PORT=1521))(ADDRESS=(PROTOCOL=TCP)(HOST=10.7.6.31)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=srv_zw1)))",
						"ng3upd", "boss4,dml", "oracle.jdbc.driver.OracleDriver")
		sql.eachRow("select zg.sid.nextval as so_nbr from dual") {
			bind << ['so_nbr':it.so_nbr]
		}
		
		println bind
		
		def msg = MessageBuild.class.getResource('10607_template.xml')
		def engine = new SimpleTemplateEngine()
		def template = engine.createTemplate(msg).make(bind)
		return template.toString()
	}
	
	static main(args) {
		
		new File("d:/template/test.txt").eachLine {
			def line = it.trim()
			logger.info("line => $line")
			def message = build_10607_message_by_line(line,'1')
			if (message != null) logger.info(message)
			
			def response = send(message)
			if (response!= null) logger.info(response)
			logger.info("=================================================================================")
//			sleep(5000)
		}
		
//		def message = FileUtils.readFileToString(new File("d:/template/test.xml"));
//		println message
//		def response = send(message)
//		if (response!= null) logger.info(response)
	}
	
}
