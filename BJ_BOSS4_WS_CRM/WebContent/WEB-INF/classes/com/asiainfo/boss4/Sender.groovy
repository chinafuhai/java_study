package com.asiainfo.boss4

import org.apache.commons.collections.functors.WhileClosure;

import groovy.sql.Sql;

sql = Sql.newInstance("jdbc:oracle:thin:@10.7.5.132:1521:ng1tst02", "zg", "ngboss123", "oracle.jdbc.driver.OracleDriver")

def tables = [
//	"i_user_0101",
//	"crm_user",
//	"i_account_0101",
//	"crm_account",
//	"i_customer_0101",
//	"crm_customer",
//	"i_user_status_0101",
//	"i_user_plan_0101",
//	"i_acc_busi_credit_0101",
//	"i_sale_oper_0101",
//	"acc_book_chg_notify_0101",
//	"acc_balance_0101",
//	"i_user_relation_0101",
//	"i_user_sprom_0101",
//	"i_sprom_param_0101",
//	"i_user_bill_cycle_0101",
//	"i_acct_bill_cycle_0101",
//	"i_user_pay_relation",
//	"crm_user_sms_order",
//	"i_user_sms_order",
//	"I_USER_ENTERPRISE_0101",
//	"I_USER_PBX_0101",
//	"I_USER_ROAM_RENT_0101",
//	"i_free_res_rule_0101",
//	"CRM_GROUP_MEMBER_0101",
//	"I_GROUP_MEMBER_0101",
//	"OWE_MONITOR_SPEC_QUOTA",
//	"CC_PLAN_INSTANCE_RELATION_0101",
//	"acc_busi_sms",
//	"crm_group_member",
//	"i_user_cell_0101",
//	"i_user_pay_relation_0101",
	"ACC_CC_NO_PRESS_STOP",
	"ACC_INTELLNET_USER_CYCLE"]
tables.each { printColumn(it) }

def printColumn(table_name) {
	sql.eachRow("select t.COLUMN_NAME,  t.DATA_TYPE, t.DATA_LENGTH, DATA_PRECISION, t.NULLABLE from cols t WHERE t.TABLE_name = upper(?) order by t.COLUMN_ID", [table_name]) {
		def data_size
		if (it.data_precision != null) {
			data_size = it.data_precision
		} else {
			data_size = it.data_length
		}
		println getCamelStyle(trunc_suffix(table_name),true)+","+getCamelStyle(it.column_name, false)+",${it.column_name},${it.data_type},${data_size},${it.nullable}"
	}
}

def trunc_suffix(table_name) {
	def result = table_name
	def matcher = (result =~ '\\_\\d{4}')
	for(def i=0; i< matcher.size(); i++){
		result = result.replace(matcher[i], '')
	}
	return result
}

def getCamelStyle(str, isFisrtCharUp) {
	def result = str.toLowerCase()
	def matcher = (result =~ '\\_.')
	for(def i=0; i< matcher.size(); i++){
		result = result.replace(matcher[i], matcher[i].substring(1).toUpperCase())
	}
	if(isFisrtCharUp) {
		result = result.substring(0,1).toUpperCase() + result.substring(1)
	}
	return result
}