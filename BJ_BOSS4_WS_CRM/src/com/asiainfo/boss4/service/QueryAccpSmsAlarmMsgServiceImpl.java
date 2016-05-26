package com.asiainfo.boss4.service;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.QueryBusinessDao;
import com.asiainfo.boss4.domain.AccpSmsAlarmMsg;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.TranCode;

public class QueryAccpSmsAlarmMsgServiceImpl implements QueryBusinessService {
	private static Log logger = LogFactory.getLog(QueryAccpSmsAlarmMsgServiceImpl.class);
	
	private QueryBusinessDao queryBusinessDao;
	
	public void setQueryBusinessDao(QueryBusinessDao queryBusinessDao) {
		this.queryBusinessDao = queryBusinessDao;
	}
	public String process(LazyDynaMap vo) {
		// TODO Auto-generated method stub
		String msgId = (String) vo.get("msgId");
		if (msgId == null || "".equals(msgId))
		{
			StringBuffer retXml = new StringBuffer();
			retXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
					.append("<boss4Result>")
					.append("<item>")
					.append("<tranCode>").append(vo.get("tranCode")).append("</tranCode>")
					.append("<SID>").append(vo.get("soNbr")).append("</SID>")
					.append("<retCode>").append(StatusCode.NO_INPUT_PROPERTITY_ERROR.getCode()).append("</retCode>")
					.append("<retInfo>").append("没有输入msgId").append("</retInfo>")
					.append("<AccpSmsAlarmMsg>")
					.append("<priority></priority>")
					.append("<msgType></msgType>")
					.append("<msgId></msgId>")
					.append("<content></content>")
					.append("<remarks></remarks>")
					.append("</AccpSmsAlarmMsg>")
					.append("</item>")
					.append("</boss4Result>");

			return retXml.toString();
		}
		TranCode tranCode = TranCode.getInstance((String) vo.get("tranCode"));
		StringBuffer retXml = new StringBuffer();
		AccpSmsAlarmMsg accpSms = new AccpSmsAlarmMsg();
		accpSms.setMsgId(Long.valueOf(msgId));
		
		AccpSmsAlarmMsg accpSmsAlarmMsg =(AccpSmsAlarmMsg) queryBusinessDao.getEntity(accpSms, accpSms.getFieldOfSelectConditionsOnCommonDaoAnnotation());
		
		retXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
				.append("<boss4Result>")
				.append("<item>")
				.append("<tranCode>").append(tranCode.getTranCode()).append("</tranCode>")
				.append("<SID>").append(vo.get("soNbr")).append("</SID>")
				.append("<retCode>").append(StatusCode.SUCCESS.getCode()).append("</retCode>")
				.append("<retInfo>").append(StatusCode.SUCCESS.getDescription()).append("</retInfo>");
		if (accpSmsAlarmMsg == null)
		{
			retXml.append("<AccpSmsAlarmMsg>")
					.append("<priority></priority>")
					.append("<msgType></msgType>")
					.append("<msgId></msgId>")
					.append("<content></content>")
					.append("<remarks></remarks>")
					.append("</AccpSmsAlarmMsg>")
					.append("</item>")
					.append("</boss4Result>");
		}else
		{
			retXml.append("<AccpSmsAlarmMsg>");
			if (accpSmsAlarmMsg.getPriority() != null)
				retXml.append("<priority>").append(accpSmsAlarmMsg.getPriority()).append("</priority>");
			else
				retXml.append("<priority>").append("</priority>");
			retXml.append("<msgType>").append(accpSmsAlarmMsg.getMsgType()).append("</msgType>")
			.append("<msgId>").append(accpSmsAlarmMsg.getMsgId()).append("</msgId>")
			.append("<content>").append(accpSmsAlarmMsg.getContent()).append("</content>")
			.append("<remarks>").append(accpSmsAlarmMsg.getRemarks()).append("</remarks>")
			.append("</AccpSmsAlarmMsg>")
			.append("</item>")
			.append("</boss4Result>");
		}
				
		
		return retXml.toString();
	}

}
