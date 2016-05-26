package com.asiainfo.report.exception;

public class ReportStatusCode {
	public final static ReportStatusCode SUCCESS = new ReportStatusCode(
			"00000", "成功");
	
	public final static ReportStatusCode INPUT_HALLNO_NULL = new ReportStatusCode(
			"10114", "输入的营业厅编号为空");
	public final static ReportStatusCode INPUT_HALLNO_CONVERT_NULL = new ReportStatusCode(
			"10121", "营业厅编号对应的BOSSID不存在");
	public final static ReportStatusCode INPUT_STATISTICDATE_NULL = new ReportStatusCode(
			"10115", "输入的统计日期为空");
	public final static ReportStatusCode INPUT_OPERATOR_NULL = new ReportStatusCode(
			"10116", "输入的操作员为空");
	public final static ReportStatusCode INPUT_MIS_ERROR = new ReportStatusCode(
			"10117", "输入的MIS标志错误,必须为MIS或ADJ或SUM");
	public final static ReportStatusCode INPUT_MIS_NULL = new ReportStatusCode(
			"10118", "输入的MIS标志为空");
	public final static ReportStatusCode INPUT_AUDIT_NULL = new ReportStatusCode(
			"10119", "输入的AUDIT标志为空");
	public final static ReportStatusCode INPUT_AUDIT_ERROR = new ReportStatusCode(
			"10120", "输入的AUDIT标志错误,必须为AUD或MOD");
	public final static ReportStatusCode SPECIAL_OP_ID = new ReportStatusCode(
			"10121", "此工号为特殊工号 不能参与厅台日结");
	public final static ReportStatusCode INPUT_STARTDATE_ERROR = new ReportStatusCode(
			"10025", "输入的开始日期错误");
	public final static ReportStatusCode INPUT_ENDDATE_ERROR = new ReportStatusCode(
			"10026", "输入的结束日期错误");
	public final static ReportStatusCode INPUT_MIS_HALL_TYPE_NULL = new ReportStatusCode(
			"10127", "输入的HALLTYPE标志为空");
	public final static ReportStatusCode INPUT_MIS_HALL_TYPE_ERROR = new ReportStatusCode(
			"10128", "输入的HALLTYPE标志错误,必须为1(虚厅)或0(非虚厅)");
	public final static ReportStatusCode ARGUMENT_NULL = new ReportStatusCode(
			"10054", "参数错误-参数不能为空");
	public final static ReportStatusCode STARTDATE_GREATER_THAN_ENDDATE_ERROR = new ReportStatusCode(
			"10055", "参数错误-开始日期不能大于结束日期");
	public final static ReportStatusCode TIME_CONTAIN_TODAY_ERROR = new ReportStatusCode(
			"10056", "参数错误-时间段统计时不能包含当日的日期");
	public final static ReportStatusCode NOT_STATISTICS_COMPLETELY_ERROR = new ReportStatusCode(
			"10057", "指定查询日期范围内存在未做统计的天");
	public final static ReportStatusCode DB_QUERY_ERROR = new ReportStatusCode("10058","数据库查询错误");
	public final static ReportStatusCode DB_OPERATION_ERROR = new ReportStatusCode(
			"20004", "数据库错误");
	public final static ReportStatusCode RETURE_XML_ERROR = new ReportStatusCode(
			"99997", "返回XML错误");
	public static final ReportStatusCode INSIDE_ERROR = new ReportStatusCode(
			"99999", "系统内部错误");
	private String code;
	private String description;

	private ReportStatusCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return this.code;
	}

	public String getDescription() {
		return this.description;
	}
}