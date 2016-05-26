package com.asiainfo.boss4.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.QueryBusinessDao;
import com.asiainfo.boss4.domain.AccRemindUserLabel;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.FileCache;
import com.asiainfo.boss4.support.TranCode;

public class QueryAccRemindUserLabelImpl  implements QueryBusinessService{
	private static Log logger = LogFactory.getLog(QueryZcRentServcieImpl.class);
	
	private QueryBusinessDao queryBusinessDao;
	
	public void setQueryBusinessDao(QueryBusinessDao queryBusinessDao) {
		this.queryBusinessDao = queryBusinessDao;
	}

	public String process(LazyDynaMap vo) {
		TranCode tranCode = TranCode.getInstance((String) vo.get("tranCode"));
		String responseTemplate = FileCache.getXMLFile(tranCode.getTranCode());
		Map<String, Map<String,Object>> result = new HashMap();
		List<AccRemindUserLabel> resultlist = null;
		
		try{
			Long labelId = Long.parseLong((String)vo.get("labelId"));
			String labelName = (String) vo.get("labelName");
			
			AccRemindUserLabel  accRemindUserLabel= new AccRemindUserLabel();
			if(labelId>0){
				accRemindUserLabel.setLabelId(labelId);
				resultlist=(List<AccRemindUserLabel>)queryBusinessDao.getEntityList(accRemindUserLabel, new String[]{"labelId", "expireDate"});
			}else if(labelId==0){
				if(labelName == null || "".equals(labelName)){
					resultlist=(List<AccRemindUserLabel>)queryBusinessDao.getEntityList(accRemindUserLabel, new String[]{"expireDate"});
				}else{
					accRemindUserLabel.setLabelName(labelName);
					resultlist=(List<AccRemindUserLabel>)queryBusinessDao.getEntityList(accRemindUserLabel, new String[]{"labelName","expireDate"});
				}
			}else{
				throw new BossException(StatusCode.ILLEGAL_INPUT_PROPERTY_ERROR, "labelId不能为空");
			} 
			
			StringBuffer retXml = new StringBuffer();
			retXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
					.append("<boss4Result>")
					.append("<item>")
					.append("<tranCode>").append(vo.get("tranCode")).append("</tranCode>")
					.append("<SID>").append(vo.get("soNbr")).append("</SID>")
					.append("<retCode>").append(StatusCode.SUCCESS.getCode()).append("</retCode>")
					.append("<retInfo>").append(StatusCode.SUCCESS.getDescription()).append("</retInfo>");
			
			if (resultlist.size() == 0){
				retXml.append("<AccRemindUserLabel>")
				.append("<labelID/>")
				.append("<labelName/>")
				.append("<labelDesc/>")
				.append("<createDate/>")
				.append("<validDate/>")
				.append("<expireDate/>")
				.append("</AccRemindUserLabel>");
			}
			for (int i=0;i<resultlist.size();i++){
				accRemindUserLabel = (AccRemindUserLabel)resultlist.get(i);
				retXml.append("<AccRemindUserLabel>")
				.append("<labelID>").append(accRemindUserLabel.getLabelId()).append("</labelID>")
				.append("<labelName>").append(accRemindUserLabel.getLabelName()).append("</labelName>")
				.append("<labelDesc>").append(accRemindUserLabel.getLabelDesc()).append("</labelDesc>")
				.append("<createDate>").append(accRemindUserLabel.getCreateDate()).append("</createDate>")
				.append("<validDate>").append(accRemindUserLabel.getValidDate()).append("</validDate>")
				.append("<expireDate>").append(accRemindUserLabel.getExpireDate()).append("</expireDate>")
				.append("</AccRemindUserLabel>");
			}		
			retXml.append("</item>")
			.append("</boss4Result>");
			return retXml.toString();
			
		}
		catch (BossException e)
		{
			e.printStackTrace();
			return buildQueryOutputXML(e.getStatusCode(), e.getMessage(), responseTemplate);

		}
		catch (Exception e)
		{
			e.printStackTrace();
			return buildQueryOutputXML(StatusCode.INSIDE_ERROR.getCode(), e.getMessage(), responseTemplate);

		}
	}

	private String buildQueryOutputXML(String code, String desc, String responseTemplate) {
		String outputXML = responseTemplate.replaceAll("\\$\\{_CODE\\}", code).replaceAll("\\$\\{_DESC\\}", desc);
		return outputXML.replaceAll("\\$\\{\\w*\\}", "");
	}
}