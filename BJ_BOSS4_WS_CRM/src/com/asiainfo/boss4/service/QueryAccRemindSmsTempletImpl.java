package com.asiainfo.boss4.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.QueryBusinessDao;
import com.asiainfo.boss4.domain.AccRemindSmsTemplet;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.FileCache;
import com.asiainfo.boss4.support.FreebieId;
import com.asiainfo.boss4.support.TranCode;

public class QueryAccRemindSmsTempletImpl implements QueryBusinessService {
	private static Log logger = LogFactory.getLog(QueryAccRemindSmsTempletImpl.class);

	private QueryBusinessDao queryBusinessDao;

	public void setQueryBusinessDao(QueryBusinessDao queryBusinessDao) {
		this.queryBusinessDao = queryBusinessDao;
	}

	public String process(LazyDynaMap vo) {
		TranCode tranCode = TranCode.getInstance((String) vo.get("tranCode"));
		String responseTemplate = FileCache.getXMLFile(tranCode.getTranCode());
		AccRemindSmsTemplet accRemindSmsTemplet = new AccRemindSmsTemplet();
		List<AccRemindSmsTemplet> resultlist = null;

		try {
			String threshold = (String) vo.get("threshold");
			String freebieTempletId = (String) vo.get("freebieTempletId");
			if ((threshold == null || "".equals(threshold)) && (freebieTempletId == null || "".equals(freebieTempletId))) {
				throw new BossException(StatusCode.ILLEGAL_INPUT_PROPERTY_ERROR,"通用模板ID或专属模板ID不能为空");
			}

			// 获取通用模板templetId信息
			if ((threshold != null && !"".equals(threshold)) && (freebieTempletId == null || "".equals(freebieTempletId))){
				resultlist = queryBusinessDao.queryAccRemindSmsTemplet(Long.parseLong(threshold),"1");
			}
			// 获取专属模板templetId信息
			if((threshold == null || "".equals(threshold)) && (freebieTempletId != null && !"".equals(freebieTempletId))){
				int freebieId= FreebieId.getFreebieId(Integer.parseInt(freebieTempletId));
				resultlist = queryBusinessDao.queryAccRemindSmsTemplet((long)freebieId,"2");
			}
			
			StringBuffer retXml = new StringBuffer();
			retXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
			      .append("<boss4Result>")
			      .append("<item>")
			      .append("<tranCode>").append(vo.get("tranCode")).append("</tranCode>")
			      .append("<SID>").append(vo.get("soNbr")).append("</SID>")
				  .append("<retCode>").append(StatusCode.SUCCESS.getCode()).append("</retCode>")
				  .append("<retInfo>").append(StatusCode.SUCCESS.getDescription()).append("</retInfo>");

			if (resultlist.size() == 0) {
				retXml.append("<AccRemindSmsTemplet>")
				      .append("<templetId/>")
					  .append("<segmentSeq/>")
					  .append("<expression/>")
					  .append("<smsContent/>")
					  .append("<remark/>")
					  .append("<allowModify/>")
					  .append("<modifyDesc/>")
					  .append("<priority/>")
					  .append("<validDate/>")
					  .append("<expireDate/>")
					  .append("<opId/>")
					  .append("<opTime/>")
					  .append("</AccRemindSmsTemplet>");
			}
			for (int i = 0; i < resultlist.size(); i++) {
				accRemindSmsTemplet = resultlist.get(i);
				
				retXml.append("<AccRemindSmsTemplet>")
				      .append("<templetId>").append(accRemindSmsTemplet.getTempletId()).append("</templetId>")
					  .append("<segmentSeq>").append(accRemindSmsTemplet.getSegmentSeq()).append("</segmentSeq>");
			      
				//处理特殊xml
				String allowModify=accRemindSmsTemplet.getAllowModify();
				String strExpression = accRemindSmsTemplet.getExpression();
				StringBuffer expression = new StringBuffer();
				StringBuffer xmlExpression = new StringBuffer();
				
				if ("YES".equals(allowModify)) {
					if (strExpression == null || "".equals(strExpression)) {
						expression.append("");
					} else{
						String[] strGroup = strExpression.split("&");
						for (int j = 0; j < strGroup.length; j++) {
							String strTmp = strGroup[j].trim();
							
							//brand in
							if(strTmp.startsWith("brand in")){
								int brandBeginIndex = strTmp.indexOf("(");
								int brandEndIndex = strTmp.indexOf(")");
								String brandGroup = strTmp.substring(brandBeginIndex + 1, brandEndIndex);
                                
								/**
								 * <brands>
								 *   <brandId>1,2</brandId >
								 *   <brandName>全球通,随e行</brandName>
								 * </brands>
                                 */
								String[] brands = brandGroup.split(",");
								String brandId = "";
								String brandName = "";

								for (int k = 0; k < brands.length; k++) {
									String strbrand = brands[k].trim();
									if ("".equals(brandId) && "".equals(brandName)) {
										brandId = strbrand;
										brandName = queryBusinessDao.getBrandName(strbrand);
									}else{
										brandId += "," + strbrand + "";
										brandName += "," + queryBusinessDao.getBrandName(strbrand) + "";	
									}
								}
								xmlExpression.append("<brands>");
								xmlExpression.append("<brandId>").append(brandId).append("</brandId>");
								xmlExpression.append("<brandName>").append(brandName).append("</brandName>");
								xmlExpression.append("</brands>");
								expression.append("");
							//user_lable in 	
							}else if(strTmp.startsWith("user_label in")){
								int labelBeginIndex = strTmp.indexOf("(");
								int labelendIndex = strTmp.indexOf(")");
								String labelGroup = strTmp.substring(labelBeginIndex + 1, labelendIndex);
								
								/**
								 * <labels>
								 *   <labelId>1001,1002</brandId >
								 *   <labelName>APPLE高端用户,4G用户</brandName>
								 * </labels>
                                 */
								String[] labels = labelGroup.split(",");
								String labelId  = "";
								String labelName = "";
								
								for (int f = 0; f < labels.length; f++) {
									String strlabel = labels[f].trim();
									if ("".equals(labelId) && "".equals(labelName)) {
										labelId = strlabel;
										labelName = queryBusinessDao.getLabelName(strlabel);
									}else{
										labelId += "," + strlabel + "";
										labelName += "," + queryBusinessDao.getLabelName(strlabel) + "";	
									}
								}
								xmlExpression.append("<labels>");
								xmlExpression.append("<labelId>").append(labelId).append("</labelId>");
								xmlExpression.append("<labelName>").append(labelName).append("</labelName>");
								xmlExpression.append("</labels>");
								expression.append("");
							}else if(strTmp.startsWith("sms_order_type in (34)")){
								xmlExpression.append("<tag4g>1</tag4g>");
								expression.append("");
							}else if(strTmp.startsWith("sms_order_type not in (34)")){
								xmlExpression.append("<tag4g>0</tag4g>");
								expression.append("");
							}else{
								expression.append(strTmp);
							}
						}
					}	
				}else{
					expression.append("");
				}

		    retXml.append("<expression>").append(expression.toString()).append("</expression>")
		          .append("<smsContent>").append(accRemindSmsTemplet.getSmsContent()).append("</smsContent>")
		          .append("<remark>").append(accRemindSmsTemplet.getRemark()).append("</remark>")
		          .append("<allowModify>").append(accRemindSmsTemplet.getAllowModify()).append("</allowModify>")
		          .append("<modifyDesc>").append(accRemindSmsTemplet.getModifyDesc()).append("</modifyDesc>")
		          .append("<priority>").append(accRemindSmsTemplet.getPriority()).append("</priority>")
		          .append("<validDate>").append(accRemindSmsTemplet.getValidDate()).append("</validDate>")
		          .append("<expireDate>").append(accRemindSmsTemplet.getExpireDate()).append("</expireDate>")
		          .append("<opId>").append(accRemindSmsTemplet.getOpId()).append("</opId>")
		          .append("<opTime>").append(accRemindSmsTemplet.getOpTime()).append("</opTime>")
                  .append(xmlExpression.toString())
				  .append("</AccRemindSmsTemplet>");
			}
			retXml.append("</item>").append("</boss4Result>");
			return retXml.toString();

		} catch (BossException e) {
			e.printStackTrace();
			return buildQueryOutputXML(e.getStatusCode(), e.getMessage(),responseTemplate);
		} catch (Exception e) {
			e.printStackTrace();
			return buildQueryOutputXML(StatusCode.INSIDE_ERROR.getCode(), e.getMessage(), responseTemplate);
		}
	}

	private String buildQueryOutputXML(String code, String desc,String responseTemplate) {
		String outputXML = responseTemplate.replaceAll("\\$\\{_CODE\\}", code).replaceAll("\\$\\{_DESC\\}", desc);
		return outputXML.replaceAll("\\$\\{\\w*\\}", "");
	}
}