package com.asiainfo.boss4

import groovy.sql.Sql
/**
 * Usage: groovy -cp ojdbc5.jar ProductConfig.groovy
 * @author caohui
 *
 */
class ProductConfig {
//	static sql = Sql.newInstance("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=10.7.6.30)(PORT=1521))(ADDRESS=(PROTOCOL=TCP)(HOST=10.7.6.31)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=srv_zw1)))",
//				"ng3upd", "boss4,dml", "oracle.jdbc.driver.OracleDriver")
//	static sql = Sql.newInstance("jdbc:oracle:thin:@10.7.5.133:1521:ng2tst02", "zg", "ngboss123", "oracle.jdbc.driver.OracleDriver")
	static sql = Sql.newInstance("jdbc:oracle:thin:@10.7.5.164:1521:ngtst02", "zg", "ngboss4,123", "oracle.jdbc.driver.OracleDriver")
	
	static existedProduct(prod_id) {
		def existed = false
		sql.eachRow("select * from INTER.BS_GRT_PRODUCT t where t.prod_id = ? and t.expire_date > sysdate", [prod_id]) {
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
		def prod_conf = new File('D:/workspace/ai_project/BJ_CMCC_BOSS/doc/需求梳理/20130711PROD.txt');
		def prods = parse_conf(prod_conf)
		def distinct = []
//		def sysdate = " to_date('2012-05-22 00:00:00','yyyy-mm-dd hh24:mi:ss') ";
		def sysdate = " sysdate ";
		println "SET DEFINE OFF;"
		println ""
		prods.each {
			def prod_id = it[0]
			def prod_desc = it[1]
			def bill_desc = it[1]
			def bill_desc_eng = ''
			if(it.size() >= 3) bill_desc = it[2]
			if(it.size() >= 4) bill_desc_eng = it[3]
			if(!existedProduct(prod_id)) {//不存在的产品直接新增
				if (!distinct.contains(prod_id)) {
					distinct << prod_id
				} else {
					print "--"//文件中的PROD_ID重复的需要剔重
				}
				println "insert into INTER.BS_GRT_PRODUCT (PROD_ID, PROD_DESC, BILL_DESC, BILL_DESC_ENG, VALID_DATE, EXPIRE_DATE, PROD_FLAG) values ($prod_id, '$prod_desc', '$bill_desc', '$bill_desc_eng', trunc($sysdate), to_date('2030-01-01 23:59:59','yyyy-mm-dd hh24:mi:ss'), 1);"
			} else {//已经存在的产品需要更新
				println "update INTER.BS_GRT_PRODUCT set EXPIRE_DATE = trunc($sysdate+1)-1/24/60/60 WHERE PROD_ID = $prod_id AND EXPIRE_DATE > SYSDATE;"
				println "insert into INTER.BS_GRT_PRODUCT (PROD_ID, PROD_DESC, BILL_DESC, BILL_DESC_ENG, VALID_DATE, EXPIRE_DATE, PROD_FLAG, OFFER_DESC) values ($prod_id, '$prod_desc', '$bill_desc', '$bill_desc_eng', trunc($sysdate+1), to_date('2030-01-01 23:59:59','yyyy-mm-dd hh24:mi:ss'), 1, 'U');"
				
			}
			
		}
		println ""
		println "COMMIT;"
	}

}