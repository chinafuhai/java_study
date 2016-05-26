package com.asiainfo.boss4

import groovy.sql.Sql
/**
 * Usage: groovy -cp ojdbc5.jar CpcTransRuleGenerator.groovy
 * @author caohui
 *
 */
class CpcTransRuleGenerator {
//	static sql = Sql.newInstance("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=10.7.6.30)(PORT=1521))(ADDRESS=(PROTOCOL=TCP)(HOST=10.7.6.31)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=srv_zw1)))",
//				"ng3upd", "boss4,dml", "oracle.jdbc.driver.OracleDriver")
//	static sql = Sql.newInstance("jdbc:oracle:thin:@10.7.5.133:1521:ng2tst02", "zg", "ngboss123", "oracle.jdbc.driver.OracleDriver")
	static sql = Sql.newInstance("jdbc:oracle:thin:@10.7.5.164:1521:ngtst02", "zg", "ngboss4,123", "oracle.jdbc.driver.OracleDriver")
	
	static existedCpcRule(sp_code, operator_code) {
		def existed = false
		sql.eachRow("select * from INTER.CPC_TRANS_RULE t where t.SP_ID = ? and t.SP_BIZ_CODE = ?", [sp_code, operator_code]) {
			existed = true
		}
		return existed
	}
	
	static parse_conf(prod_conf) {
		def prods = []
		prod_conf.eachLine {
			prods << it.split('\\|')
		}
	}
	
	static main(args) {
		def prod_conf = new File('D:/workspace/win_system/Desktop/Groovy_workspace/CPC.md');
		def prods = parse_conf(prod_conf)
		def distinct = []
//		def sysdate = " to_date('2012-05-22 00:00:00','yyyy-mm-dd hh24:mi:ss') ";
		def sysdate = " sysdate ";
		println "SET DEFINE OFF;"
		prods.each {
			def sp_code 		= 	it[0].trim()
			def operator_code 	= 	it[1].trim()
			def expire_date 	= 	''
			def remark 			= 	it[3].trim()
			def timelimit 		= 	''
			
			if (it[2].trim() == '12') expire_date = 'YEAR'
			if (it[2].trim() == '6') expire_date = 'HALFYEAR'
			if (it[2].trim() == '11') expire_date = 'YEAR1'
			if (it[2].trim() == '5') expire_date = 'HALFYEAR1'
			if (it[2].trim() == '2') expire_date = 'TWOMONTHS'
			if (it[2].trim() == '1') expire_date = 'NEXTMONTH'
			if (it[2].trim() == '1-1000') expire_date = 'NEXTMONTH1000'
			if (it[2].trim() == '24') expire_date = '2YEARS'
			
			if (it[4].trim() == '20') timelimit = 'TWENTIETH'
			if (it[4].trim() == 'null') timelimit = ''
			
			println "insert into INTER.CPC_TRANS_RULE (SP_ID, SP_BIZ_CODE, EXPIRE_DATE, REMARK, DAY_OF_LAST_MONTH) values ('$sp_code', '$operator_code', '$expire_date', '$remark', '$timelimit');"
			if(!existedCpcRule(sp_code, operator_code)) {
			} else {
//				println "--"+prods
			}
			
		}
		println "COMMIT;"
	}

}