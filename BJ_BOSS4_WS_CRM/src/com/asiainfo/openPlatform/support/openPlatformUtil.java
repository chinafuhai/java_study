package com.asiainfo.openPlatform.support;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

import com.asiainfo.openPlatform.domain.BwoIntf;
import com.asiainfo.openPlatform.domain.PoIntf;

public class openPlatformUtil {
   
	/**
	 *  开通平台工具类 包含xml解析  
	 */
	
	private static Log logger = LogFactory.getLog(openPlatformUtil.class);

	
	/**
	 *  同步开通请求xml解析 返回String[] 包含TCP协议包头和包体
	 */
	public static Map<String,Object> SynRequestParse(String inputXML){
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> reqList = new ArrayList<String>();
		String resultString ="";
		try {
			//读取XML从中抽取信息
			Document document = DocumentHelper.parseText(inputXML);
			
			StringBuffer packageBody= new StringBuffer();
			Element root = document.getRootElement();
			//为查询类多PO进行特殊处理 将PO内容先存放在List中，然后对报文处理
			List<String> poList = new ArrayList<String>();
			String IMSI = "";
			String MSISDN="";
			boolean imsiFlag=true;
			boolean msisdnFlag=true;
			
			for(Iterator i = root.elementIterator(); i.hasNext();){
				
				
				Element item = (Element)i.next();
				if("TradeID".equals(item.getName())){
					packageBody.append("TRADE_ID="+item.getTextTrim()+";");
					map.put("taskNo", item.getTextTrim());
				}
				if("OperCode".equals(item.getName())){
					packageBody.append("OperCode="+item.getTextTrim()+";");
				}
				if("IMSI".equals(item.getName())){
					if(item.getTextTrim()==null||"".equals(item.getTextTrim())){
						imsiFlag = false;
					}else{
						packageBody.append("IMSI="+item.getTextTrim()+";");
						map.put("IMSI", item.getTextTrim());
					}
				}
				if("MSISDN".equals(item.getName())){
					if(item.getTextTrim()==null||"".equals(item.getTextTrim())){
						msisdnFlag = false;
					}else{
						packageBody.append("MSISDN="+item.getTextTrim()+";");
						map.put("MSISDN", item.getTextTrim());
					}
				}
				if("ReqTime".equals(item.getName())){
					//请求发送时间
					map.put("ReqTime", item.getTextTrim());
				}
				if("AccOrderTime".equals(item.getName())){
					//EAI接收请求时间
					map.put("AccOrderTime", item.getTextTrim());
				}
				if("CreateTime".equals(item.getName())){
					//EAI工单创建时间
					map.put("CreateTime", item.getTextTrim());
				}
				if("OrderId".equals(item.getName())){
					packageBody.append("OrderId="+item.getTextTrim()+";");
					map.put("OrderId", item.getTextTrim());
				}
				if("POSeq".equals(item.getName())){
					
					List<Node> nodeList = item.selectNodes("./POITEM");
					for(int m=0;m<nodeList.size();m++){
						Node node = nodeList.get(m);
						StringBuffer poBuffer = new StringBuffer();
						
						Node poType = node.selectSingleNode("./POType");
						Node reqType = node.selectSingleNode("./ReqType");
						Node retFlag = node.selectSingleNode("./RetFlag");
						Node BWOType = node.selectSingleNode("./BWOType");
						Node NEType = node.selectSingleNode("./NEType");
						Node ServiceEffDate = node.selectSingleNode("./ServiceEffDate");
						List<Node> paraList = node.selectNodes("./ParamSeq/item");
						
						/**
						 * 根据PoType情况定义三个编码
						 *  PO|开头的 reqType按照报文取
						 *  DISP_TYPE|开头的 ,POTYPE 前缀上DISP_,reqType字段赋值4
						 *  ACTION|开头的 POTYPE 前缀上DISP_
						 */
						
						
						if(poType!=null&&poType.getText().startsWith("PO|")){
							String  str = poType.getText().trim();
							if(!"PO|TRANS_IUSER_BJBOSS".equals(str)){
								if(str.startsWith("PO|DISP_")){
									poBuffer.append("PO_TYPE="+str.substring(3,str.length())+";");
									poBuffer.append("REQ_TYPE="+reqType.getText().trim()+";");
								}else{
									poBuffer.append("PO_TYPE=DISP_"+str.substring(3,str.length())+";");
									poBuffer.append("REQ_TYPE="+reqType.getText().trim()+";");
								}
							}else{
								poBuffer.append("PO_TYPE="+str.substring(3,str.length())+";");
								poBuffer.append("REQ_TYPE="+reqType.getText().trim()+";");
							}
							
						}
						if(poType!=null&&poType.getText().startsWith("DISP_TYPE|")){
							String  pTypestr = poType.getText().trim();
							if(pTypestr.startsWith("DISP_TYPE|DISP_")){
								poBuffer.append("PO_TYPE="+pTypestr.substring(10,pTypestr.length())+";");
								poBuffer.append("REQ_TYPE="+reqType.getText().trim()+";");
							}else{
								poBuffer.append("PO_TYPE=DISP_"+pTypestr.substring(10,pTypestr.length())+";");
								poBuffer.append("REQ_TYPE="+reqType.getText().trim()+";");
							}
						}
						if(poType!=null&&poType.getText().startsWith("ACTION|")){
							String  pTypestr = poType.getText().trim();
							poBuffer.append("PO_TYPE=DISP_"+pTypestr.substring(7,pTypestr.length())+";");
							poBuffer.append("REQ_TYPE="+reqType.getText().trim()+";");
						}
						if(retFlag!=null){
							poBuffer.append("RetFlag="+retFlag.getText().trim()+";");
						}
						if(NEType!=null){
							poBuffer.append("NEType="+NEType.getText().trim()+";");
						}
						if(ServiceEffDate!=null){
							poBuffer.append("ServiceEffDate="+ServiceEffDate.getText().trim()+";");
						}
						
						String paraString="";
						
						for(Node para:paraList){
							Node name = para.selectSingleNode("./Name");
							Node value= para.selectSingleNode("./Value");
							String tempParaStr = "";
							
							String IMSI1 ="";
							String MSISDN1="";
							if(name!=null){
								tempParaStr = name.getText().trim()+"="+value.getText().trim();
							}
							
							if("".equals(paraString)){
								paraString = paraString+tempParaStr;
							}else{
								paraString=paraString+";"+tempParaStr;
							}
							
							if("IMSI1".equals(name.getText())){
								IMSI1 = value.getText();
								if(!imsiFlag){
									packageBody.append("MSISDN="+IMSI1+";");
									map.put("MSISDN", IMSI1);
								}
							}
							if("MSISDN1".equals(name.getText())){
								MSISDN1 = value.getText();
								if(!msisdnFlag){
									packageBody.append("MSISDN="+MSISDN1+";");
									map.put("MSISDN", MSISDN1);
								}
							}
						}
						
						if(!"".equals(paraString)){
							poBuffer.append(paraString+";");
						}
						
						poList.add(packageBody.toString()+poBuffer.toString());
						
					}
				}
			}
			
			for(String poRequest:poList){
				String packageTemp = "";
				int length = poRequest.toString().length()+12;
				packageTemp = String.valueOf(length);
				while(packageTemp.length()<8){
					packageTemp = "0"+packageTemp;
				}
				packageTemp = packageTemp+"REQ:";
				packageTemp = packageTemp+poRequest;
				
				reqList.add(packageTemp);
				
				//日志用
				if("".equals(resultString)){
					resultString += packageTemp;
				}else{
					resultString = resultString+"||"+packageTemp;
				}
			}
			
			map.put("reqString", resultString);
			map.put("reqList", reqList);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		logger.info(resultString);
		
		return map;
	}
	
	/**
	 *  异步开通请求xml解析 返回Map集合
	 */
	public static Map AsynRequestParse(String xml,String retEAIFlag){
		Map map = new HashMap();
		BwoIntf bwoIntf = new BwoIntf();
		
		List<PoIntf> poList = new ArrayList<PoIntf>();
		String loggerString = retEAIFlag==null?"AsynKt(YB) Operation":"SynKt(TB) Operation is BusiType,deal with AsynKt(YB)";
		
		logger.info("AsynKt(YB) interface info="+loggerString);
		
		try {
			Document document = DocumentHelper.parseText(xml);
			
			String tradeId = document.selectSingleNode("/Request/TradeID").getText().trim();
			String operCode = document.selectSingleNode("/Request/OperCode").getText().trim();
			String IMSI = document.selectSingleNode("/Request/IMSI").getText().trim();
			String MSISDN = document.selectSingleNode("/Request/MSISDN").getText().trim();
			String orderId = document.selectSingleNode("/Request/OrderId").getText().trim();
			String reqTime = document.selectSingleNode("/Request/ReqTime").getText().trim();
			
			//VGOP批量报文处理
			List<Node> vgopBatchList = document.selectNodes("/Request/POSeq/POITEM/ParamSeq/item");
			String pType = document.selectSingleNode("/Request/POSeq/POITEM/POType").getText().trim();
			boolean vgopFlag = false;
			if("PO|VGOP".equals(pType)&&vgopBatchList!=null&&vgopBatchList.size()>0){
				for(Node node:vgopBatchList){
					if("BATCH_FLAG".equals(node.selectSingleNode("./Name").getText())){
						vgopFlag =true;
					}
				}
			}
			
			/**
			 * vgopFlag = true  此业务属于vgop批量业务 特殊处理报文
			 * vgopFlag = false  此业务不属于vgop批量业务 正常处理报文
			 */
			if(vgopFlag){
				/* begin 批量VGOP解析*/
				List<Node> nodeList = document.selectNodes("/Request/POSeq/POITEM");
				ResourceBundle rb = ResourceBundle.getBundle("QueryPo_INFO");
			    int batchsize = Integer.valueOf(rb.getString("VGOPBATCH"));
				
				if(nodeList!=null&&nodeList.size()>0){
					for(int i=0;i<nodeList.size();i++){
						
						Node node = nodeList.get(i);
						
						String reqType = node.selectSingleNode("./ReqType").getText().trim();
						
						Date vaildDate = null;
						Node dateNode = node.selectSingleNode("./ServiceEffDate");
						if(dateNode!=null){
							String serviceEffDate = dateNode.getText().trim();
							try {
								SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
								vaildDate = format.parse(serviceEffDate);
							} catch (ParseException e) {
							}
						}
						
						List<Node> paramList = node.selectNodes("./ParamSeq/item");
						
						Map<Integer, List<String>> paramMap = new HashMap<Integer, List<String>>();
						
						String batch_flag = "";
						String transactionId = "";
						String accessMode ="";
						String feeType = "";
						String actionReasonId = "";
						String oprTime = "";
						String feeTime = "";
						String expireTime = "";
						
						if(paramList!=null&&paramList.size()>0){
							for(Node tempNode:paramList){
								String name = tempNode.selectSingleNode("./Name").getText().trim();
								String value = tempNode.selectSingleNode("./Value").getText().trim();
								
								if("BATCH_FLAG".equals(name)){
									batch_flag = value;
								}else if("TRANSACTIONID".equals(name)){
									transactionId = value;
								}else if("REQNUM".equals(name)){
									//transactionId = value;
								}
								else if(name.startsWith("ACCESSMODE")){
									accessMode = value;
								}
								else if(name.startsWith("FEETYPE")){
									feeType = value;
								}
								else if(name.startsWith("ACTIONREASONID")){
									actionReasonId = value;
								}
								else if(name.startsWith("OPRTIME")){
									oprTime = value;
								}
								else if(name.startsWith("EFFTIME")){
									feeTime = value;
								}else if(name.startsWith("EXPIRETIME")){
									expireTime = value;
								}else{
									int lastIndex = 0;
									String param = "";
									if(name.startsWith("PARA_NAME")||name.startsWith("PARA_VALUE")){
										String[] array = name.split("_");
										lastIndex = Integer.parseInt(array[2]);
										param = array[0]+"_"+array[1]+array[2]+"_"+array[3]+"="+value+";";
										
										if(lastIndex%batchsize==0){
											param = array[0]+"_"+array[1]+batchsize+"_"+array[3]+"="+value+";";
										}else{
											param = array[0]+"_"+array[1]+array[2]+"_"+array[3]+"="+value+";";
										}
										
									}else{
										lastIndex = Integer.parseInt(name.substring(name.lastIndexOf("_")+1, name.length()));
										String paramPrefix = name.substring(0, name.lastIndexOf("_"));
										String paramSuffix="";
										if(lastIndex%batchsize==0){
											paramSuffix = String.valueOf(batchsize);
										}else{
											paramSuffix = String.valueOf(Integer.parseInt(name.substring(name.lastIndexOf("_")+1,name.length()))%batchsize);
										}
										
										param =  paramPrefix+paramSuffix+"="+value+";";
									}
									
									if(paramMap.containsKey(lastIndex)){
										List<String> list = paramMap.get(lastIndex);
										list.add(param);
									}else{
										List<String> list = new ArrayList<String>();
										list.add(param);
										paramMap.put(lastIndex, list);
									}
								}
							}
						}
						
						if(paramMap!=null&&paramMap.keySet().size()>0){
							Object[] set = paramMap.keySet().toArray();
							Arrays.sort(set);
							int paraCount = 0;
							int poIdCount = 1;
							int subReqNum = 0;
							StringBuffer buffer = new StringBuffer();
							
							for(int j=0;j<set.length;j++){
								int keyStr = (Integer)set[j];
								subReqNum ++;
								List<String> subParm = paramMap.get(keyStr);
								
								for(String tmp:subParm){
									buffer.append(tmp);
								}
								
								paraCount++;
								if(paraCount%batchsize==0||paraCount==set.length){
									//插入一条PO
									PoIntf poIntf = new PoIntf();
									poIntf.setTradeId(Long.parseLong(tradeId));
									poIntf.setOperCode(operCode);
									poIntf.setMSISDN(MSISDN);
									poIntf.setOrderId(orderId);
									poIntf.setBatFlag(1);//批量工单
									poIntf.setPoId(Long.parseLong(String.valueOf(poIdCount)));
									
									
									poIdCount++;
									poIntf.setPoType("VGOP_BATCH");
									poIntf.setReqType(Integer.parseInt(reqType));
									poIntf.setPriLvl(OpenPlatConstant.KT_Asyn_Priority_level);//优先级 --稍后
									poIntf.setRetFlag(0);//不回执
									poIntf.setCreateDate(new Date());
									poIntf.setValidDate(vaildDate);
									
									StringBuffer paramBuffer = new StringBuffer();
									
									
									
									paramBuffer.append("BATCH_FLAG="+batch_flag+";").append("REQNUM="+subReqNum+";").
											 	append("TRANSACTIONID=&transId;").append("ACCESSMODE="+accessMode+";").
											 	append("FEETYPE="+feeType+";").append("ACTIONREASONID="+actionReasonId+";").
											 	append("OPRTIME="+oprTime+";").append("EFFTIME="+feeTime+";").
											 	append("EXPIRETIME="+expireTime+";").append(buffer);
									buffer = new StringBuffer();
									subReqNum=0;
									
									poIntf.setParam(paramBuffer.toString());
									poList.add(poIntf);
								}
							}
						}
						map.put("transId",transactionId);
						map.put("poList", poList);
						map.put("taskNo", tradeId);
						map.put("orderId", orderId);
						map.put("IMSI", IMSI);
						map.put("MSISDN", MSISDN);
						map.put("inputXML", xml);
						map.put("ReqTime", reqTime);
					}	
				}
				/* end 批量VGOP解析*/
			}else{
				/* begin 正常解析*/
				String IMSI1 = "";
				String MSISDN1="";
				boolean imsiFlag=true;
				boolean msisdnFlag=true;
				if(IMSI==null||"".equals(IMSI)){
					imsiFlag = false;
				}
				if(MSISDN==null||"".equals(MSISDN)){
					msisdnFlag = false;
				}
				
				List<Node> nodeList = document.selectNodes("/Request/POSeq/POITEM");
				boolean returnFlag = false;
				
				int tempIndex=1;
				if(nodeList!=null&&nodeList.size()>0){
					for(int i=0;i<nodeList.size();i++){
						
						Node node = nodeList.get(i);
						
						PoIntf poIntf = new PoIntf();
						poIntf.setTradeId(Long.parseLong(tradeId));
						poIntf.setOperCode(operCode);
						poIntf.setIMSI(IMSI);
						poIntf.setMSISDN(MSISDN);
						poIntf.setOrderId(orderId);
						
						String poType = node.selectSingleNode("./POType").getText().trim();
						String reqType = node.selectSingleNode("./ReqType").getText().trim();
						Node pIndexNode = node.selectSingleNode("@ORDER");
						String poIndex ="";
						if(pIndexNode==null){
							poIndex = String.valueOf(tempIndex);
							tempIndex=tempIndex+1;
						}else{
							poIndex = pIndexNode.getText();
						}
						
						poIntf.setBatFlag(0);
						poIntf.setPoId(Long.parseLong(poIndex));//暂时使用这个字段
						String[] poStr = poType.trim().split("\\|");
						poIntf.setPoType(poStr[1]);
						poIntf.setReqType(Integer.parseInt(reqType));
						
						if(OpenPlatConstant.KT_Synchronize_Busi.equals(retEAIFlag)){
							returnFlag = true;
							poIntf.setPriLvl(OpenPlatConstant.KT_Syn_Priority_level);//优先级-- 优先
							poIntf.setRetFlag(1);//回执
						}else{
							poIntf.setPriLvl(OpenPlatConstant.KT_Asyn_Priority_level);//优先级 --稍后
							poIntf.setRetFlag(0);//不回执
						}
						
						poIntf.setCreateDate(new Date());
						Date vaildDate = null;
						Node dateNode = node.selectSingleNode("./ServiceEffDate");
						if(dateNode!=null){
							String serviceEffDate = dateNode.getText().trim();
							try {
								SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
								vaildDate = format.parse(serviceEffDate);
							} catch (ParseException e) {
							}
						}
						
						poIntf.setValidDate(vaildDate);
						
						List<Node> paramList = node.selectNodes("./ParamSeq/item");
						StringBuffer paramString = new StringBuffer();
						if(paramList!=null&&paramList.size()>0){
							for(int j=0;j<paramList.size();j++){
								Node paramNode = paramList.get(j);
								String nameString = paramNode.selectSingleNode("./Name").getText().trim();
								String valueString = paramNode.selectSingleNode("./Value").getText().trim();
								if(paramString.toString().length()==0){
									paramString.append(nameString).append("=").append(valueString);
								}else{
									paramString.append(";").append(nameString).append("=").append(valueString);
								}
								
								if("IMSI1".equals(nameString)){
									IMSI1 = valueString;
									if(!imsiFlag){
										poIntf.setIMSI(IMSI1);
										map.put("IMSI", IMSI1);
									}
								}
								if("MSISDN1".equals(nameString)){
									MSISDN1 = valueString;
									if(!msisdnFlag){
										poIntf.setMSISDN(MSISDN1);
										map.put("MSISDN", MSISDN1);
									}
								}
								
							}
							poIntf.setParam(paramString.toString());
						}
						
						//解除后付费用户黑名单 业务对号码特殊处理
						if("RELEASEUCBLACK".equals(poIntf.getPoType())){
							String msisdn = poIntf.getMSISDN();
							if(msisdn!=null){
								int num = msisdn.indexOf("&");
								if(num!=-1){
									String fristNum = msisdn.substring(0, num);
									String lastNum = msisdn.substring(num+1,msisdn.length());
									poIntf.setMSISDN(fristNum);
									if(paramString.toString().length()==0){
										paramString.append("RELEASEUCBLACK_LIST").append("=").append(lastNum);
									}else{
										paramString.append(";").append("RELEASEUCBLACK_LIST").append("=").append(lastNum);
									}
									poIntf.setParam(paramString.toString());
								}else{
									if(paramString.toString().length()==0){
										paramString.append("RELEASEUCBLACK_LIST").append("=").append(msisdn);
									}else{
										paramString.append(";").append("RELEASEUCBLACK_LIST").append("=").append(msisdn);
									}
									poIntf.setParam(paramString.toString());
								}
							}
						}
						
						
						poList.add(poIntf);
						
						
					}
				}
				
				map.put("poList", poList);
				map.put("taskNo", tradeId);
				map.put("orderId", orderId);
				if(imsiFlag) map.put("IMSI", IMSI);
				if(msisdnFlag) map.put("MSISDN", MSISDN);
				map.put("inputXML", xml);
				map.put("ReqTime", reqTime);
				
				if(returnFlag){
					bwoIntf.setTradeId(Long.parseLong(tradeId));
					bwoIntf.setPoNum(nodeList.size());
					bwoIntf.setStatus(0);
					bwoIntf.setfNum(0);
					bwoIntf.setsNum(0);
					
					map.put("BWO", bwoIntf);
					map.put("retFlag", "true");
				}
			}
			/* end 正常解析*/
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 判断同步接口是否是查询服务
	 * @param xml
	 * @return  查询服务 返回0 业务办理 返回1
	 */
	public static String isQuery(String xml){
	    ResourceBundle rb = ResourceBundle.getBundle("QueryPo_INFO");
	    String poTypes = rb.getString("PoType");
	    
	    String[] poTypeTmp = poTypes.split(",");
	    
	    List<String> poList = new ArrayList<String>();
	    for(String str:poTypeTmp){
	    	poList.add(str);
	    }
	    
		try {
			Document document = DocumentHelper.parseText(xml);
			List<Node> nodeList = document.selectNodes("/Request/POSeq/POITEM");
			boolean isQuery = false;
			
			for(Node node : nodeList){
				String poType = node.selectSingleNode("./POType").getText().trim();
				String reqType = node.selectSingleNode("./ReqType").getText().trim();
				if(poList.contains(poType)&&"4".equals(reqType)&&poType.startsWith("PO|")){
					isQuery = true;
				}else if(poList.contains(poType)&&"4".equals(reqType)&&poType.startsWith("DISP_TYPE|")){
					isQuery = true;
				}else if(poList.contains(poType)&&"4".equals(reqType)&&poType.startsWith("ACTION|")){
					isQuery = true;
				}else if(poList.contains(poType)&&"PO|TRANS_IUSER_BJBOSS".equals(poType)){
					isQuery = true;
				}
			}
			//如果Po类型属于查询类 返回0 否则返回1
			if(isQuery){
				return OpenPlatConstant.KT_Synchronize_Query;
			}else {
				return OpenPlatConstant.KT_Synchronize_Busi;
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args){
		for(int i=1;i<=50;i++)
		{
			if(i%25==0){
				System.out.println(25);
			}else{
				System.out.println(i%25);
			}
			
		}  
		
	}
		

		/*String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Request>"+
    "<TradeID>4344718</TradeID>"+
    "<OperCode>crmcrm</OperCode>"+
    "<IMSI/>"+
    "<MSISDN>13718032744</MSISDN>"+
    "<ReqTime>20110922173726</ReqTime>"+
    "<AccOrderTime>20110922173726</AccOrderTime>"+
    "<ServiceEffTime/>"+
    "<CreateTime/>"+
    "<OrderId/>"+
	"</Request>";
		
		try {
			Document document = DocumentHelper.parseText(xml);
			
			String tradeId = document.selectSingleNode("/Request/TradeID").getText();
			String operCode = document.selectSingleNode("/Request/OperCode").getText();
			String IMSI = document.selectSingleNode("/Request/IMSI").getText();
			String MSISDN = document.selectSingleNode("/Request/MSISDN").getText();
			String orderId = document.selectSingleNode("/Request/OrderId").getText();
			String reqTime = document.selectSingleNode("/Request/ReqTime1").getText();
			
			System.out.println("--------");
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	
}
