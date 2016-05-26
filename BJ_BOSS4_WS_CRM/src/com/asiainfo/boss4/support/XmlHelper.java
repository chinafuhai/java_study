package com.asiainfo.boss4.support;

import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.security.Authentication;
import org.springframework.security.providers.UsernamePasswordAuthenticationToken;

import com.asiainfo.boss4.domain.AccSmsTempletDef;
import com.asiainfo.boss4.domain.InBusiBatch;
import com.asiainfo.boss4.domain.InBusiBatchDetail;
import com.asiainfo.boss4.domain.InvoicePayFeeIn;
import com.asiainfo.boss4.domain.AccSmsTempletDef.SysCont;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;

import freemarker.template.Template;

//add by weihf end
/**
 * XML相关工具类
 * @author caohui
 *
 */
public class XmlHelper {
	private static Log logger = LogFactory.getLog(XmlHelper.class);
	public final static String _CODE = "_CODE";
	public final static String _DESC = "_DESC";

	/**
	 * 取xml根节点的名字
	 * @param inputXml
	 * @return
	 */
	public static String parseRootElementName(String inputXml) {
		String result = null;
		
		try {
			Document document = DocumentHelper.parseText(inputXml);
			Element root = document.getRootElement();
			result = root.getName();
		} catch (Exception e) {
			logger.error("xml解析失败");
			throw new BossException(StatusCode.XML_PARSE_ERROR, e);
		}
		
		return result;
	}
	
	public static Authentication parseAuthInfo(String inputXml) {
		String username = null;
		String password = null;
		try {
			Document document = DocumentHelper.parseText(inputXml);
			Element root = document.getRootElement();
			Element elementName = (Element) root.selectNodes("./auth/username").get(0);
			Element elementPass = (Element) root.selectNodes("./auth/password").get(0);
			
			username = (String) elementName.getData();
			password = (String) elementPass.getData();
			
			logger.debug("认证信息: username=> " + username);
		} catch (Exception e) {
			logger.error("从xml解析用户验证信息失败");
			throw new BossException(StatusCode.XML_PARSE_ERROR, e);
		}
		
		if ("".endsWith(username) || "".endsWith(password)) {
			logger.error("xml中的用户验证信息不完整，用户名或密码为空");
			throw new BossException(StatusCode.INPUT_AUTH_IS_EMPTY_ERROR);
		}
		
		return new UsernamePasswordAuthenticationToken(username, password);
	}
	
	/**
	 * 解析xml为动态值对象
	 * @param inputXml
	 * @return
	 */
	public static List<LazyDynaMap> parseToVoList(String inputXml) {
		List<LazyDynaMap> voList = new ArrayList<LazyDynaMap>();
		try {
			Document document = DocumentHelper.parseText(inputXml);
			Element root = document.getRootElement();
			// 取item元素，每个item元素对应一个动态bean
			for (Iterator i = root.elementIterator(); i.hasNext(); ) {
				Element item = (Element) i.next();
				// 仅处理name以“item”结尾的节点(不区分大小写)
				if (item.getName().toLowerCase().endsWith("item")) {
					LazyDynaMap bean = new LazyDynaMap();
					// 遍历item的元素，为动态bean赋值
					for (Iterator it = item.elementIterator(); it.hasNext(); ) {
						Element element = (Element) it.next();
						if ("extendParams".equals(element.getName())) {
							/**
							 * 取扩展字段，结构如下
							 * <extendParams>
							 * 	<paramItem>
							 * 		<name>paramA</name>
							 * 		<value>0</value>
							 * 	</paramItem>
							 * 	<paramItem>
							 * 		<name>paramB</name>
							 * 		<value>1</value>
							 * 	</paramItem>
							 * 	<paramItem>
							 * 		<name>paramC</name>
							 * 		<value>2</value>
							 * 	</paramItem>
							 * </extendParams>
							 */
							if (!"".equals(element.getData())) {// <element></element> 或 <element /> 两种情况element.getData()均为""
								for (int j = 0; j < element.elements().size(); j++) {
									Element name = (Element)element.selectNodes("./paramItem/name").get(j);
									Element value = (Element)element.selectNodes("./paramItem/value").get(j);
									bean.set((String) name.getData(), (String) value.getData());
								}
							}
							continue;
						}
						if (!"".equals(element.getData())) { // <element></element> 或 <element /> 两种情况element.getData()均为""
							bean.set(element.getName(), element.getData());
						}
					}
					voList.add(bean);
				}
			}
		} catch (Exception e) {
			logger.error("xml解析失败");
			throw new BossException(StatusCode.XML_PARSE_ERROR, e);
		}
		
		if (voList.size() == 0) {
			logger.error("从xml中解析出的数据为空，请核对xml数据");
			throw new BossException(StatusCode.XML_PARSE_ERROR);
		}
		
		//对10600交易排序，确保取消操作在新增操作之前
		Collections.sort(voList, VoComparator.getInstance()); 
		
		logger.debug("XML数据解析完成");
		return voList;
	}
	
	/**
	 * 解析CPC报文为动态值对象
	 * @param inputXml
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<LazyDynaMap> parseCpcXmlToVoList(String inputXml) {
		List<LazyDynaMap> voList = new ArrayList<LazyDynaMap>();
		try {
			Document document = DocumentHelper.parseText(inputXml);
			Element root = document.getRootElement();
			Map<String, Object> beanCommon = new LinkedHashMap();
			
			// 遍历item的元素，为动态bean赋值
			for (Element element : (List<Element>)root.elements()) {
				//节点由SvcCont变更为UDR
				if (!"".equals(element.getData()) 
						&& !element.getName().toLowerCase().equals("item")
						&& !"SvcCont".equals(element.getName())) { // <element></element> 或 <element /> 两种情况element.getData()均为""
					
					// 解析订单公共信息
					beanCommon.put(element.getName(), element.getData());
				}else if (element.getName().toLowerCase().equals("item"))
				{
					for (Iterator ite = element.elementIterator(); ite.hasNext(); ) {
						Element item = (Element) ite.next();
						if ("UDR".equals(item.getName())) {
							List uds = item.selectNodes("UD");
							for (Element udElmt : (List<Element>)uds) {
								LazyDynaMap bean = new LazyDynaMap();
								for (Map.Entry<String, Object> entry : beanCommon.entrySet()) {
									if (entry.getKey().equals("soId")
											&&entry.getValue()!=null
											&&Long.parseLong(entry.getValue().toString())<Constance.PRODINSID)
										BeanUtils.copyProperty(bean, entry.getKey(), convert("10000000000"+entry.getValue().toString().substring(entry.getValue().toString().length()-4),"java.lang.Long"));
									else
									{
										if (entry.getKey().equals("soId"))
											BeanUtils.copyProperty(bean, entry.getKey(), convert("1"+entry.getValue().toString(),"java.lang.Long"));
										else		
											bean.set(entry.getKey(), entry.getValue());
									}
								}
								for (Element udSubElmt : (List<Element>)udElmt.elements()) {
									if (!"".equals(udSubElmt.getData())
											&& !"BizOrder".equals(udSubElmt.getName())
											&& !"OprInfo".equals(udSubElmt.getName())) { 
										bean.set(udSubElmt.getName(), udSubElmt.getData());
									}
								}
								Element spCode = (Element) udElmt.selectSingleNode("BizOrder/SPID");
								if(spCode != null) bean.set(spCode.getName(), spCode.getData());
								Element operatorCode = (Element) udElmt.selectSingleNode("BizOrder/SPBizCode");
								if(operatorCode != null) bean.set(operatorCode.getName(), operatorCode.getData());
								voList.add(bean);
							}
						}
					}
				}
				else if ("SvcCont".equals(element.getName())) {

					// 取出CDATA报文文本，解析订购信息
					Element udr = DocumentHelper.parseText((String)element.getData()).getRootElement();
					for (Element udrElmt : (List<Element>)udr) {
						if (!"".equals(udrElmt.getData()) && !"UD".equals(udrElmt.getName())) {
							beanCommon.put(udrElmt.getName(), udrElmt.getData());
						}
					}
					//取出用户数据，可能包含多组
					List<Element> uds = udr.selectNodes("./UD");
					for (Element udElmt : (List<Element>)uds) {
						LazyDynaMap bean = new LazyDynaMap();
						for (Map.Entry<String, Object> entry : beanCommon.entrySet()) {
							if (entry.getKey().equals("soId")
									&&entry.getValue()!=null
									&&Long.parseLong(entry.getValue().toString())<Constance.PRODINSID)
								BeanUtils.copyProperty(bean, entry.getKey(), convert("10000000000"+entry.getValue().toString().substring(entry.getValue().toString().length()-4),"java.lang.Long"));
							else
							{
								if (entry.getKey().equals("soId"))
									BeanUtils.copyProperty(bean, entry.getKey(), convert("1"+entry.getValue().toString(),"java.lang.Long"));
								else		
									bean.set(entry.getKey(), entry.getValue());
							}
						}
						for (Element udSubElmt : (List<Element>)udElmt.elements()) {
							if (!"".equals(udSubElmt.getData())
									&& !"BizOrder".equals(udSubElmt.getName())
									&& !"OprInfo".equals(udSubElmt.getName())) { 
								bean.set(udSubElmt.getName(), udSubElmt.getData());
							}
						}
						Element spCode = (Element) udElmt.selectSingleNode("BizOrder/SPID");
						if(spCode != null) bean.set(spCode.getName(), spCode.getData());
						Element operatorCode = (Element) udElmt.selectSingleNode("BizOrder/SPBizCode");
						if(operatorCode != null) bean.set(operatorCode.getName(), operatorCode.getData());
						voList.add(bean);
					}
				}
			}
		} catch (Exception e) {
			logger.error("xml解析失败");
			throw new BossException(StatusCode.XML_PARSE_ERROR, e);
		}
		
		if (voList.size() == 0) {
			logger.error("从xml中解析出的数据为空，请核对xml数据");
			throw new BossException(StatusCode.XML_PARSE_ERROR);
		}
		
		logger.debug("XML数据解析完成");
		return voList;
	}
	
	/**
	 * 解析查询CRMID的报文
	 * @param inputXml
	 * @return
	 */
	public static Map<String, String[]> parseBossIdToMap(String inputXml) {
		Map<String, String[]> crmIdMap = new HashMap<String, String[]>();
		try {
			Document document = DocumentHelper.parseText(inputXml);
			Element root = document.getRootElement();
			Element orgId = (Element) root.selectSingleNode("bossId/orgId");
			if (orgId != null) {
				String orgStr = (String) orgId.getData();
				crmIdMap.put("orgId", orgStr.trim().split(","));
			}
			Element operatorId = (Element) root.selectSingleNode("bossId/operatorId");
			if (operatorId != null) {
				String operStr = (String) operatorId.getData();
				crmIdMap.put("operatorId", operStr.trim().split(","));
			}
		} catch (Exception e) {
			throw new BossException(StatusCode.XML_PARSE_ERROR, e);
		}
		return crmIdMap;
	}
	
	public static Map parseToInBusiBatch(String inputXml, String batchType) {
		Document document = null;
		try {
			document = DocumentHelper.parseText(inputXml);
		} catch (DocumentException e) {
			logger.error("xml解析失败");
			throw new BossException(StatusCode.XML_PARSE_ERROR, e);
		}
		Element root = document.getRootElement();
		String batchId = ((Node) root.selectSingleNode("./Batchid")).getText();
		String busiType = ((Node) root.selectSingleNode("./BusiType")).getText();
		
		InBusiBatch inBusiBatch = new InBusiBatch();
		inBusiBatch.setBatchid(batchId);
		inBusiBatch.setState("0");
		
		Element lineItems = (Element) root.selectSingleNode("./LineItems");
		List<InBusiBatchDetail> detailList = new ArrayList<InBusiBatchDetail>();
		for (Iterator i = lineItems.elementIterator(); i.hasNext(); ) {
			InBusiBatchDetail inBusiBatchDetail = new InBusiBatchDetail();
			Element lineItemInfo = (Element) i.next();
			
			Node tradeId = lineItemInfo.selectSingleNode("./TradeId");
			inBusiBatchDetail.setTradeid(tradeId.getText());

			Node mobileNumber = lineItemInfo.selectSingleNode("./MobileNumber");
			inBusiBatchDetail.setMobilenumber(mobileNumber.getText());
			
			Node paraInfo = lineItemInfo.selectSingleNode("./ParaInfo");
			for (Iterator j = lineItemInfo.elementIterator(); j.hasNext(); ) {
				Element element = (Element) j.next();
				if ("ParaInfo".equals(element.getName())) {
					List nodeList = element.selectNodes("Para");
					for (Object object : nodeList) {
						Element para = (Element) object;
						String paraName = para.selectSingleNode("ParaName").getText();
						String paraValue = para.selectSingleNode("ParaValue").getText();
						System.out.println(paraName+" = "+paraValue);
						BeanCopyHelper.setProperty(inBusiBatchDetail, paraName.toLowerCase(), paraValue);
					}
				}
			}
			inBusiBatchDetail.setBatchid(batchId);
			inBusiBatchDetail.setBusitype(busiType);
			inBusiBatchDetail.setState("0");
			
			//批量受理业务类型:1：开通；2：计费套餐
			inBusiBatchDetail.setBatchType(batchType);
			detailList.add(inBusiBatchDetail);
		}
		inBusiBatch.setBatchnum(String.valueOf(detailList.size()));
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("inBusiBatch", inBusiBatch);
		map.put("detailList", detailList);
		map.put("busiType", busiType);
		return map;
		
	}

	/**
	 * 创建接口返回的xml信息
	 * @param retCode
	 * @param retInfo
	 * @return
	 */
	public static String buildOutputXml(String retCode, String retInfo) {
		StringBuffer outputXml = new StringBuffer();
		outputXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		outputXml.append("<boss4Result>");
		outputXml.append("<item>");
		outputXml.append("<tranCode />");
		outputXml.append("<SID />");
		outputXml.append("<retCode>").append(retCode).append("</retCode>");
		outputXml.append("<retInfo>").append(retInfo).append("</retInfo>");
		outputXml.append("</item>");
		outputXml.append("</boss4Result>");
		return outputXml.toString();
	}
	
	/**
	 * 创建接口返回的xml信息
	 * @param retCode
	 * @param retInfo
	 * @param tranCode
	 * @param sid
	 * @return
	 */
	public static String buildOutputXml(String retCode, String retInfo, String tranCode, String sid) {
		StringBuffer outputXml = new StringBuffer();
		outputXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		outputXml.append("<boss4Result>");
		outputXml.append("<item>");
		
		if (tranCode == null) {
			outputXml.append("<tranCode />");
		} else {
			outputXml.append("<tranCode>").append(tranCode).append("</tranCode>");
		}
		
		if (sid == null) {
			outputXml.append("<SID />");
		} else {
			outputXml.append("<SID>").append(sid).append("</SID>");
		}
		
		outputXml.append("<retCode>").append(retCode).append("</retCode>");
		outputXml.append("<retInfo>").append(retInfo).append("</retInfo>");
		outputXml.append("</item>");
		outputXml.append("</boss4Result>");
		return outputXml.toString();
	}
	
	/**
	 * 创建接口返回的xml信息 包含接口服务的响应信息
	 * @param retCode
	 * @param retInfo
	 * @return
	 */
	public static String buildOutputXmlWithResponse(String retCode, String retInfo, String response) {
		StringBuffer outputXml = new StringBuffer();
		outputXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		outputXml.append("<boss4Result>");
		outputXml.append("<item>");
		outputXml.append("<tranCode />");
		outputXml.append("<SID />");
		outputXml.append("<retCode>").append(retCode).append("</retCode>");
		outputXml.append("<retInfo>").append(retInfo).append("</retInfo>");
		outputXml.append("</item>");
		outputXml.append(response);
		outputXml.append("</boss4Result>");
		return outputXml.toString();
	}
	
	/**
	 * 创建一个服务响应的xml信息
	 * @param response
	 * @return
	 */
	public static String buildServiceResponse(Map response) {
		StringBuffer responseXml = new StringBuffer();
		responseXml.append("<item>\n");
		for (Iterator iterator = response.entrySet().iterator(); iterator.hasNext();) {
			Entry type = (Entry) iterator.next();
			responseXml.append("<").append(type.getKey().toString()).append(">");
			responseXml.append(type.getValue().toString());
			responseXml.append("</").append(type.getKey().toString()).append(">\n");
		}
		responseXml.append("</item>\n");
		return responseXml.toString();
	}
	
	public static String buildQueryOutputXML(String code, String desc, String responseTemplate, Map<String, Object> responseMap) {
		String outputXML = responseTemplate.replaceAll("\\$\\{_CODE\\}", code).replaceAll("\\$\\{_DESC\\}", desc);
		if (responseMap != null) {
			BeanCopyHelper.formatMapToString(responseMap);
			for (Map.Entry<String, Object> entry : responseMap.entrySet()) {
//				System.out.println("entry.getKey()"+entry.getKey());
//				System.out.println("(String) entry.getValue()"+(String) entry.getValue());
				outputXML = outputXML.replaceAll("\\$\\{"+ entry.getKey() +"\\}", (String) entry.getValue());
			}
		}
		return outputXML.replaceAll("\\$\\{\\w*\\}", "");
	}
	
	/**
	 * 根据指定的tranCode加载模板，并用指定的responseMap数据填充模板，生成响应报文
	 * @param tranCode
	 * @param responseMap
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String buildQueryOutputXMLByTemplate(String tranCode, Map responseMap) {
		Template responseTemplate = FileCache.getXMLTemplate(tranCode);
		
		if (responseMap.get(_CODE) == null ) responseMap.put(_CODE, StatusCode.SUCCESS.getCode());
		if (responseMap.get(_DESC) == null ) responseMap.put(_DESC, StatusCode.SUCCESS.getDescription());
		
		try {
			StringWriter responseXml = new StringWriter();
			responseTemplate.process(responseMap, responseXml);
			return responseXml.toString();
		} catch (Exception e) {
			return buildQueryOutputXML(StatusCode.INSIDE_ERROR.getCode(), "A exception occurs during building response xml.",
										FileCache.getCommonXMLTemplate().toString(), responseMap);
		}
	}
	
	/**
	 * 根据捕获的异常构造查询类业务接口的响应报文
	 * @param e
	 * @return
	 */
	public static String buildQueryOutputXMLByTemplateWithException(String tranCode, Throwable e) {
		Map<String, String> responseMap = new HashMap<String, String>();
		if (tranCode == null || "".equals(tranCode)) tranCode = FileCache.TEMPLATE_COMMON_TRANCODE;
		
		if (!FileCache.isExistedMapping(tranCode)) {
			responseMap.put(_CODE, StatusCode.INSIDE_ERROR.getCode());
			responseMap.put(_DESC, new BossException(StatusCode.INSIDE_ERROR, "没有配置名为"+tranCode+"的模板文件").buildResponseDescription());
			return buildQueryOutputXMLByTemplate(FileCache.TEMPLATE_COMMON_TRANCODE, responseMap);
		}

		if (e.getClass() == BossException.class) {
			BossException be = (BossException) e;
			
			if (FileCache.isExistedXMLFile(tranCode)) 
				return buildQueryOutputXML(be.getStatus().getCode(), be.buildResponseDescription(), FileCache.getXMLFile(tranCode), be.getQueryResult());
			
			responseMap.put(_CODE, be.getStatus().getCode());
			responseMap.put(_DESC, be.buildResponseDescription());
			return buildQueryOutputXMLByTemplate(tranCode, responseMap);
		}
		
		if (FileCache.isExistedXMLFile(tranCode)) 
			return buildQueryOutputXML(StatusCode.INSIDE_ERROR.getCode(), StatusCode.INSIDE_ERROR.getDescription(), FileCache.getXMLFile(tranCode), null);
		
		responseMap.put(_CODE, StatusCode.INSIDE_ERROR.getCode());
		responseMap.put(_DESC, new BossException(StatusCode.INSIDE_ERROR, e).buildResponseDescription());
		return buildQueryOutputXMLByTemplate(tranCode, responseMap);
	}
	
	public static String buildCpcOutputXml(String inputXml, String rspType, String rspCode, String rspDesc) {
		String outputXml = null;
		
		try {
			Document doc = DocumentHelper.parseText(inputXml);
			Element root = doc.getRootElement();
			Element svcCont = root.element("SvcCont");
			svcCont.clearContent();
			
			Element resp = root.addElement("Response");
			resp.addElement("RspType").setText(rspType);
			resp.addElement("RspCode").setText(rspCode);
			resp.addElement("RspDesc").setText(rspDesc);
			
			// 格式化输出xml
			StringWriter writer = new StringWriter();
			new XMLWriter(writer, OutputFormat.createPrettyPrint()).write(doc);
			
			outputXml = writer.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return outputXml;
	}
	
	public static String buildBatchBusiOutputXml(String batchId, String busiType, String errorCode, String errorMsg) {
		StringBuffer outputXml = new StringBuffer();
		outputXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		outputXml.append("<Root>\n");
		outputXml.append("<Batchid>").append(batchId).append("</Batchid>\n");
		outputXml.append("<BusiType>").append(busiType).append("</BusiType>\n");
		outputXml.append("<ReturnMsg>\n");
		outputXml.append("<ErrorCode>").append(errorCode).append("</ErrorCode>\n");
		outputXml.append("<ErrorMsg>").append(errorMsg).append("</ErrorMsg>\n");
		outputXml.append("</ReturnMsg>\n");
		outputXml.append("</Root>");
		return outputXml.toString();
	}
	/**
	 * 根据要求构建返回信息
	 * 
	 */
	public static String buildBusiOutputXml(String title,String head, String body, String rspCode, String rspDesc,List bodyList) {
		StringBuffer outputXml = new StringBuffer();
		outputXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		outputXml.append("<"+title+">\n");

		if (bodyList != null && bodyList.size()>0)
		{
			StringBuffer bodyXml = new StringBuffer();
			
			for (int i=0;i<bodyList.size();i++)
			{
				bodyXml.append("<"+body+">");
				Map<String, Object> responseMap = (Map<String, Object>)bodyList.get(i);
				if (responseMap != null) {
					BeanCopyHelper.formatMapToString(responseMap);
					for (Map.Entry<String, Object> entry : responseMap.entrySet()) {
	//					System.out.println("entry.getKey()"+entry.getKey());
	//					System.out.println("(String) entry.getValue()"+(String) entry.getValue());
						if (entry.getValue()!=null&&!entry.getValue().toString().equals(""))
						{
							bodyXml.append("<"+entry.getKey()+">");
							bodyXml.append((String) entry.getValue());
							bodyXml.append("</"+entry.getKey()+">");
						}
						else
							bodyXml.append("<"+entry.getKey()+"/>");
					}
				}
				bodyXml.append("</"+body+">");
			}
			outputXml.append(bodyXml.toString());
		}	
		else
			outputXml.append("<"+body+"/>");
		outputXml.append("<"+head+">");
		outputXml.append("<retCode>");
		outputXml.append(rspCode);
		outputXml.append("</retCode>");
		outputXml.append("<retInfo>");
		outputXml.append(rspDesc);
		outputXml.append("</retInfo>");
		outputXml.append("</"+head+">\n");
		outputXml.append("</"+title+">\n");
		return outputXml.toString();
	}

	public static String buildBusiOutputXmlExtr(String title,String head, String body, String rspCode, String rspDesc,List bodyList) {
		StringBuffer outputXml = new StringBuffer();
		outputXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		outputXml.append("<"+title+">\n");
		if (bodyList != null && bodyList.size()>0)
		{
			StringBuffer bodyXml = new StringBuffer();
			
			for (int i=0;i<bodyList.size();i++)
			{
				bodyXml.append("<"+body+">");
				Map<String, Object> responseMap = (Map<String, Object>)bodyList.get(i);
				if (responseMap != null) {
					BeanCopyHelper.formatMapToString(responseMap);
					for (Map.Entry<String, Object> entry : responseMap.entrySet()) {
						if (entry.getValue()!=null&&!entry.getValue().toString().equals(""))
						{
							bodyXml.append("<"+entry.getKey()+">");
							bodyXml.append((String) entry.getValue());
							bodyXml.append("</"+entry.getKey()+">");
						}
						else
							bodyXml.append("<"+entry.getKey()+"/>");
					}
				}
				bodyXml.append("</"+body+">");
			}
			outputXml.append(bodyXml.toString());
		}
		else
		{
			outputXml.append("<"+body+">");
			outputXml.append("<deductAmount/>");
			outputXml.append("<opId/>");
			outputXml.append("<remark/>");
			outputXml.append("<signStatus/>");
			outputXml.append("<optDate/>");
			outputXml.append("<effDate/>");
			outputXml.append("<expDate/>");
			outputXml.append("<signBankName/>");
			outputXml.append("</"+body+">");
		}
		outputXml.append("<"+head+">");
		outputXml.append("<retCode>");
		outputXml.append(rspCode);
		outputXml.append("</retCode>");
		outputXml.append("<retInfo>");
		outputXml.append(rspDesc);
		outputXml.append("</retInfo>");
		outputXml.append("</"+head+">\n");
		
		outputXml.append("</"+title+">\n");
		return outputXml.toString();
	}
	/**
	 * 根据xsd校验输入xml数据的正确性
	 * @param xml
	 * @param xsd
	 * @throws BossException 校验失败抛出此异常
	 */
	public static void validate(InputStream xmlStream, InputStream xsdStream) {
		try {

            SchemaFactory constraintFactory =  SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            Schema schema = constraintFactory.newSchema(new StreamSource(xsdStream));
            Validator validator = schema.newValidator();
            try {
                validator.validate(new StreamSource(xmlStream));
                logger.debug("XML校验成功");
            } catch (org.xml.sax.SAXException e) {
            	logger.error("XML校验失败");
            	throw new BossException(StatusCode.XML_VALIDATION_ERROR, e);
            }

        } catch (BossException e) {
            throw e;
        } catch (Exception e) {
            logger.error("XML解析过程中出错");
            throw new BossException(StatusCode.XML_PARSE_ERROR, e);
        }
	}
	
	/**
	 * 获取指定路径节点的值
	 * @param inputXml
	 * @return
	 */
	public static String getValue(String inputXml, String path){
		try {
			Document document = DocumentHelper.parseText(inputXml);
			Element e = (Element) document.selectObject(path);
			System.out.println(e.getText());
			return e.getText();
		} catch (Exception e) {
			logger.error("xml解析失败");
			throw new BossException(StatusCode.XML_PARSE_ERROR, e);
		}
	}
	
	/**
	 * 解析xml为动态值对象
	 * @param inputXml
	 * @return
	 */
	public static List<Object> parseToCrmList(String inputXml) {
		List<Object> listAll = new ArrayList<Object>();
		String strSoNbr = "";
		Long rollBackSoNbr = null;
		boolean isReplaceSoNbr = false;
		try {
			Document document = DocumentHelper.parseText(inputXml);
			Element root = document.getRootElement();
			// 取item元素
			for (Iterator itRoot = root.elementIterator(); itRoot.hasNext(); ) {
				Element itemElement = (Element) itRoot.next();
				List<Object> voList = new ArrayList<Object>();
				VoErrorData errorData = new VoErrorData();
				if (itemElement.getName().toLowerCase().equals("item")) {
					// 仅处理name以“item”结尾的节点(不区分大小写)				
					for (Iterator ite = itemElement.elementIterator(); ite.hasNext(); ) {
						Element item = (Element) ite.next();
						if (!item.getName().toLowerCase().equals("trancode") 
								&& !item.getName().toLowerCase().equals("sonbr")
								&& !item.getName().toLowerCase().equals("rollbacksonbr")
								&& !item.getName().toLowerCase().equals("udr")
								&& !item.getName().toLowerCase().equals("invoicepayfeein")
								&& !item.getName().toLowerCase().equals("onetimepayment")
								&& !item.getName().toLowerCase().equals("tranbill")
								&& !item.getName().toLowerCase().equals("pretran"))
						{
	
							//得到一个实例
							try{
								Object object = Class.forName("com.asiainfo.boss4.domain."+item.getName()).newInstance();
								PropertyDescriptor origDescriptors[] = PropertyUtils.getPropertyDescriptors(object);
								LazyDynaMap bean = new LazyDynaMap(); 
								for (Iterator it = item.elementIterator(); it.hasNext(); ) {
									Element element = (Element) it.next();
									// 遍历item的元素，为动态element赋值
									
									if (!"".equals(element.getData())) { // <element></element> 或 <element /> 两种情况element.getData()均为""
										boolean hasProperty = false;
										
										for (int i = 0; i < origDescriptors.length; i++) {
											String name = origDescriptors[i].getName();
											if (name.toUpperCase().equals(element.getName().toUpperCase())){
												ConvertUtils.register(new DateConvert(), Date.class);
												//CRM要求针对特定表不覆盖soNbr，因此将soNbr覆盖移到对象处理处
//												if (!"".equals(strSoNbr) && strSoNbr != null && !name.equals("soNbr"))
//												{
													if (name.equals("soId")
															&&element.getData()!=null
															&&Long.parseLong(element.getData().toString())<Constance.PRODINSID)
													{
														if (Long.parseLong(element.getData().toString())<1000)
															BeanUtils.copyProperty(object, name, convert(String.valueOf(100000000000000l+Long.parseLong(element.getData().toString())),origDescriptors[i].getPropertyType().getName()));
														else
															BeanUtils.copyProperty(object, name, convert("10000000000"+element.getData().toString().substring(element.getData().toString().length()-4),origDescriptors[i].getPropertyType().getName()));
													}
													else if (name.equals("sysCont"))
													{
														SysCont sysCont = new SysCont();
														PropertyDescriptor sysContDescriptors[] = PropertyUtils.getPropertyDescriptors(sysCont);
														for (Iterator it1 = element.elementIterator(); it1.hasNext(); ) {
															Element element1 = (Element) it1.next();
															// 遍历item的元素，为动态element赋值
															
															for (int j = 0; j < sysContDescriptors.length; j++) {
																String name1 = sysContDescriptors[j].getName();
																if (name1.equals(element1.getName())){
																	ConvertUtils.register(new DateConvert(), Date.class);
																	BeanUtils.copyProperty(sysCont, name1, convert(element1.getData().toString(),sysContDescriptors[j].getPropertyType().getName()));
																}
															}
														}
														if (((AccSmsTempletDef)object).getSysCont() == null)
															((AccSmsTempletDef)object).setSysCont(new ArrayList());
														((AccSmsTempletDef)object).getSysCont().add(sysCont);
													}
													else
													{
														if (name.equals("soId"))
															BeanUtils.copyProperty(object, name, convert("1"+element.getData().toString(),origDescriptors[i].getPropertyType().getName()));
														else
															BeanUtils.copyProperty(object, name, convert(element.getData().toString(),origDescriptors[i].getPropertyType().getName()));
													}
													
													
													//CRM要求针对特定表不覆盖soNbr，因此将soNbr覆盖移到对象处理处
//												}
//												else if (!"".equals(strSoNbr) && strSoNbr != null && name.equals("soNbr"))
//												{
//													BeanUtils.copyProperty(object, name, convert(strSoNbr,origDescriptors[i].getPropertyType().getName()));
//													isReplaceSoNbr = true;
//												}
												hasProperty = true;
											}
										}
										if (AppConstant.OPERTYPE.equals(element.getName()))
										{
											hasProperty = true;
											BeanUtils.copyProperty(object, AppConstant.OPERATETYPE,OperateType.getInstance(element.getData().toString()));
										}
										if (!hasProperty)
											bean.set(element.getName(), element.getData());
	
									}
									else if (element.getName().equals("SysCont"))
									{
										SysCont sysCont = new SysCont();
										PropertyDescriptor sysContDescriptors[] = PropertyUtils.getPropertyDescriptors(sysCont);
										for (Iterator it1 = element.elementIterator(); it1.hasNext(); ) {
											Element element1 = (Element) it1.next();
											// 遍历item的元素，为动态element赋值
											
											for (int j = 0; j < sysContDescriptors.length; j++) {
												String name1 = sysContDescriptors[j].getName();
												if (name1.equals(element1.getName())){
													ConvertUtils.register(new DateConvert(), Date.class);
													BeanUtils.copyProperty(sysCont, name1, convert(element1.getData().toString(),sysContDescriptors[j].getPropertyType().getName()));
												}
											}
										}
										if (((AccSmsTempletDef)object).getSysCont() == null)
											((AccSmsTempletDef)object).setSysCont(new ArrayList());
										((AccSmsTempletDef)object).getSysCont().add(sysCont);
									}
								
								}
								if (bean.getMap()!=null && bean.getMap().size()>0)
								{
									if (errorData != null){
										if (errorData.getErrorNode() == null)
											errorData.setErrorNode(AppConstant.ERRORNODENAME);
										if (errorData.getErrorValue() == null)
										{
											List list = new ArrayList();
											list.add(buildObjectResponse(item.getName(),bean.getMap()));
											errorData.setErrorValue(list);
										}
										else
											errorData.getErrorValue().add(buildObjectResponse(item.getName(),bean.getMap()));
									}
								}
								voList.add(object);
							}catch (Exception e){
								/*if (errorData != null){
									if (errorData.getErrorNode() == null)
										errorData.setErrorNode(AppConstant.ERRORNODENAME);
									if (errorData.getErrorValue() == null)
									{
										List list = new ArrayList();
										list.add(item.asXML());
										errorData.setErrorValue(list);
									}
									else
										errorData.getErrorValue().add(item.asXML());
								}*/
								logger.error("xml解析失败");
								throw new BossException(StatusCode.XML_PARSE_ERROR, e);
							}
						}	
						else {
							if (!"".equals(item.getData()))
							{
								if (item.getName().toLowerCase().equals("trancode"))
									voList.add(new VoTranCode(item.getData().toString()));
								else if (item.getName().toLowerCase().equals("sonbr"))
									strSoNbr = item.getData().toString();
								else if (item.getName().toLowerCase().equals("rollbacksonbr"))
									rollBackSoNbr = Long.decode(item.getData().toString());
							}	
								
							if (item.getName().toLowerCase().equals("invoicepayfeein"))
							{
								InvoicePayFeeIn payFeeIn = new InvoicePayFeeIn();
								PropertyDescriptor origDescriptors[] = PropertyUtils.getPropertyDescriptors(payFeeIn);
								LazyDynaMap bean = new LazyDynaMap(); 
								for (Iterator it = item.elementIterator(); it.hasNext(); ) {
									Element element = (Element) it.next();
									// 遍历item的元素，为动态element赋值
									
									for (int i = 0; i < origDescriptors.length; i++) {
										String name = origDescriptors[i].getName();
										if (name.equals(element.getName())){
											ConvertUtils.register(new DateConvert(), Date.class);
											BeanUtils.copyProperty(payFeeIn, name, convert(element.getData().toString(),origDescriptors[i].getPropertyType().getName()));
										}
									}
								}
								voList.add(payFeeIn);
							}
							if (item.getName().toLowerCase().equals("tranbill"))
							{
								com.asiainfo.boss4.domain.TranBill tranBillIn = new com.asiainfo.boss4.domain.TranBill();
								PropertyDescriptor origDescriptors[] = PropertyUtils.getPropertyDescriptors(tranBillIn);
								LazyDynaMap bean = new LazyDynaMap(); 
								for (Iterator it = item.elementIterator(); it.hasNext(); ) {
									Element element = (Element) it.next();
									// 遍历item的元素，为动态element赋值
									
									for (int i = 0; i < origDescriptors.length; i++) {
										String name = origDescriptors[i].getName();
										if (name.equals(element.getName())){
											ConvertUtils.register(new DateConvert(), Date.class);
											BeanUtils.copyProperty(tranBillIn, name, convert(element.getData().toString(),origDescriptors[i].getPropertyType().getName()));
										}
									}
								}
								voList.add(tranBillIn);
							}
							if (item.getName().toLowerCase().equals("pretran"))
							{
								com.asiainfo.boss4.domain.PreTran preTranBillIn = new com.asiainfo.boss4.domain.PreTran();
								PropertyDescriptor origDescriptors[] = PropertyUtils.getPropertyDescriptors(preTranBillIn);
								LazyDynaMap bean = new LazyDynaMap(); 
								for (Iterator it = item.elementIterator(); it.hasNext(); ) {
									Element element = (Element) it.next();
									// 遍历item的元素，为动态element赋值
									
									for (int i = 0; i < origDescriptors.length; i++) {
										String name = origDescriptors[i].getName();
										if (name.equals(element.getName())){
											ConvertUtils.register(new DateConvert(), Date.class);
											BeanUtils.copyProperty(preTranBillIn, name, convert(element.getData().toString(),origDescriptors[i].getPropertyType().getName()));
										}
									}
								}
								voList.add(preTranBillIn);
							}
							if (item.getName().toLowerCase().equals("onetimepayment"))
							{
								JAXBContext context;   
						        try {
									context = JAXBContext.newInstance(com.asiainfo.boss4.domain.ext.ObjectFactory.class);
									Unmarshaller marshaller = context.createUnmarshaller();   
									ByteArrayInputStream is = null;
									is = new ByteArrayInputStream(item.asXML().getBytes());
									com.asiainfo.boss4.domain.ext.OneTimePayment oneTimePayment = (com.asiainfo.boss4.domain.ext.OneTimePayment) marshaller.unmarshal(is);
									voList.add(oneTimePayment);					
									 						
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}
				}
				if (voList.size() == 0) {
					logger.error("从xml中解析出的数据为空，请核对xml数据");
					throw new BossException(StatusCode.XML_PARSE_ERROR);
				}
				
				if (errorData != null)
				{
					if (errorData.getErrorValue() == null)
						errorData.setErrorValue(new ArrayList());
					errorData.setStrOriginalXml(inputXml);
					voList.add(errorData);
				}
				if (!"".equals(strSoNbr) && strSoNbr != null)
				{
					//CRM要求针对特定表不覆盖soNbr，因此将soNbr覆盖移到对象处理处
//					if (!isReplaceSoNbr)
//					{
//						for (int i=0;i<voList.size();i++){
//							Object vo = (Object)voList.get(i);
//							try {
//								BeanUtils.copyProperty(vo, "soNbr", Long.valueOf(strSoNbr));
//							} catch (NumberFormatException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							} catch (IllegalAccessException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							} catch (InvocationTargetException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//						}
//					}
					voList.add(strSoNbr);
				}
				if (rollBackSoNbr != null)
					voList.add(rollBackSoNbr);
				listAll.add(voList);
			}
		} catch (Exception e) {
			logger.error("xml解析失败");
			throw new BossException(StatusCode.XML_PARSE_ERROR, e);
		}
		
		
		logger.debug("XML数据解析完成");
		return listAll;
	}

	/**
	 * 创建接口返回的xml信息
	 * @param retCode
	 * @param retInfo
	 * @return
	 */
	public static String buildCrmOutputXml(String retCode, String retInfo) {
		StringBuffer outputXml = new StringBuffer();
		outputXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		outputXml.append("<item>\n");
		outputXml.append("<tranCode />\n");
		outputXml.append("<retCode>").append(retCode).append("</retCode>\n");
		outputXml.append("<retInfo>").append(retInfo).append("</retInfo>\n");
		outputXml.append("</item>\n");
		return outputXml.toString();
	}
	
	/**
	 * 创建一个服务响应的xml信息
	 * @param response
	 * @return
	 */
	public static String buildObjectResponse(String objName,Map response) {
		StringBuffer responseXml = new StringBuffer();
		responseXml.append("<"+objName+">\n");
		for (Iterator iterator = response.entrySet().iterator(); iterator.hasNext();) {
			Entry type = (Entry) iterator.next();
			responseXml.append("<").append(type.getKey().toString()).append(">");
			responseXml.append(type.getValue().toString());
			responseXml.append("</").append(type.getKey().toString()).append(">\n");
		}
		responseXml.append("</"+objName+">\n");
		return responseXml.toString();
	}
	
	private static Object convert(String src,String type) throws IllegalAccessException{
		if(src == null || src.equals(""))
			return null;
		try{
			
			if("java.lang.String".equalsIgnoreCase(type))
				return src;
			if("java.lang.Integer".equalsIgnoreCase(type))
				return new Integer(src);
			if("java.lang.Long".equalsIgnoreCase(type))
				return new Long(src);
			if("java.lang.Double".equalsIgnoreCase(type))
				return new Double(src);
			if("java.lang.Float".equalsIgnoreCase(type))
				return new Float(src);
			if("java.lang.BigDecimal".equalsIgnoreCase(type))
				return new BigDecimal(src);
			if("java.lang.Byte".equalsIgnoreCase(type))
				return new Byte(src);
			if("java.lang.Short".equalsIgnoreCase(type))
				return new Short(src);
			if("java.lang.Character".equalsIgnoreCase(type)){
				if(src.toCharArray().length > 1)
					throw new IllegalAccessException();
				return new Character(src.charAt(0));
			}
			
		}
		catch(Exception e){
			logger.debug("convert :: The src String : " + src + " and type : " +type);
			throw new BossException(StatusCode.CLASS_CAST_ERROR, e);
		}
		return src;
	}
	
	public static short parseBusiType(String inputXml) {
		short busiType = 0;
		try {
			Document document = DocumentHelper.parseText(inputXml);
			Element root = document.getRootElement();
			// 取item、UDR元素
			for (Iterator itRoot = root.elementIterator(); itRoot.hasNext(); ) {
				Element itemElement = (Element) itRoot.next();
				if (itemElement.getName().toLowerCase().equals("item")) {
					if (itemElement.selectNodes("UDR").size()>0) {
						busiType = 1;
						break;
					}
				}
			}
		}catch (Exception e) {
			logger.error("xml解析失败");
			throw new BossException(StatusCode.XML_PARSE_ERROR, e);
		}
		return busiType;
	}
	
	public static String buildQueryListOutputXML(String code, String desc, String responseTemplate, Map<String, Map<String,Object>> responseMap, String nodeName) {
		String outputXML = responseTemplate.replaceAll("\\$\\{_CODE\\}", code).replaceAll("\\$\\{_DESC\\}", desc);
		StringBuffer outputXml = new StringBuffer(); 
		if (responseMap != null) {
			int i=0;
			for (Map.Entry<String, Map<String, Object>> entry : responseMap.entrySet()) {
				if (i == 0)
				{
					for (Map.Entry<String, Object> entity : entry.getValue().entrySet())
					{
						System.out.println("entry.getKey()"+entity.getKey());
						System.out.println("(String) entry.getValue()"+(String) entity.getValue());
						outputXML = outputXML.replaceAll("\\$\\{"+ entity.getKey() +"\\}", (String) entity.getValue());
					}
				}
				else
				{
					outputXml.append("</"+nodeName+">");
					outputXml.append("<"+nodeName+">");
					for (Map.Entry<String, Object> entity : entry.getValue().entrySet())
					{
						outputXml.append("<").append(entity.getKey()).append(">")
						.append((String) entity.getValue())
						.append("</").append(entity.getKey()).append(">");
					}
				}
				i++;
			}
		}
		outputXML = outputXML.substring(0, outputXML.indexOf("</"+nodeName+">"))+outputXml.toString()+outputXML.substring(outputXML.indexOf("</"+nodeName+">"));
		return outputXML.replaceAll("\\$\\{\\w*\\}", "");
	}
	
	public static String buildQueryOutputXMLWithTranCode(String tranCode, String soNbr, String code, String desc, String responseTemplate, Map<String, Object> responseMap) {
		String outputXML = responseTemplate.replaceAll("\\$\\{_CODE\\}", code)
										.replaceAll("\\$\\{_DESC\\}", desc);
		if (tranCode!=null && !"".equals(tranCode))
			outputXML = outputXML.replaceAll("\\$\\{_TRANCODE\\}", tranCode);
		if (soNbr != null && !"".equals(soNbr))
			outputXML = outputXML.replaceAll("\\$\\{_SID\\}", soNbr);
		if (responseMap != null) {
			BeanCopyHelper.formatMapToString(responseMap);
			for (Map.Entry<String, Object> entry : responseMap.entrySet()) {
//				System.out.println("entry.getKey()"+entry.getKey());
//				System.out.println("(String) entry.getValue()"+(String) entry.getValue());
				outputXML = outputXML.replaceAll("\\$\\{"+ entry.getKey() +"\\}", (String) entry.getValue());
			}
		}
		return outputXML.replaceAll("\\$\\{\\w*\\}", "");
	}
	
	public static String buildQueryListOutputXMLExt(String code, String desc, String responseTemplate, Map<String, List> responseMap, String nodeName) {
		String outputXML = responseTemplate.replaceAll("\\$\\{_CODE\\}", code).replaceAll("\\$\\{_DESC\\}", desc);
		StringBuffer outputXml = new StringBuffer(); 
		if (responseMap != null) {
			int i=0;
			for (Map.Entry<String, List> entry : responseMap.entrySet()) {
				if (i == 0)
				{
					for (int j=0;j<entry.getValue().size();j++)
					{
						String[] value = ((entry.getValue()).get(j)).toString().split("=");
						System.out.println("entry.getKey()"+value[0]);
						System.out.println("(String) entry.getValue()"+value[1]);
						outputXML = outputXML.replaceAll("\\$\\{"+ value[0] +"\\}", value[1]);
					}
				}
				else
				{
					outputXml.append("</"+nodeName+">");
					outputXml.append("<"+nodeName+">");
					for (int j=0;j<entry.getValue().size();j++)
					{
						String[] value = ((entry.getValue()).get(j)).toString().split("=");
						outputXml.append("<").append(value[0]).append(">")
						.append(value[1])
						.append("</").append(value[0]).append(">");
					}
				}
				i++;
			}
		}
		outputXML = outputXML.substring(0, outputXML.indexOf("</"+nodeName+">"))+outputXml.toString()+outputXML.substring(outputXML.indexOf("</"+nodeName+">"));
		return outputXML.replaceAll("\\$\\{\\w*\\}", "");
	}
}
