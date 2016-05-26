package com.asiainfo.openPlatform.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.asiainfo.openPlatform.dao.openPlatDao;
import com.asiainfo.openPlatform.domain.BwoIntf;
import com.asiainfo.openPlatform.domain.BwoIntfHis;
import com.asiainfo.openPlatform.domain.PoIntf;
import com.asiainfo.openPlatform.exception.OpenPlatException;
import com.asiainfo.openPlatform.exception.OpenPlatStatusCode;
import com.asiainfo.openPlatform.support.OpenPlatConstant;
import com.asiainfo.openPlatform.support.PoComparator;

public class openPlatServiceImpl implements openPlatService,ApplicationContextAware {

	
	private ApplicationContext applicationContext;
	
	private static Log logger = LogFactory.getLog(openPlatServiceImpl.class);
	
	private openPlatDao openPlatDao ;
	
	private long timeout;
	
	public openPlatDao getOpenPlatDao() {
		return openPlatDao;
	}

	public void setOpenPlatDao(openPlatDao openPlatDao) {
		this.openPlatDao = openPlatDao;
	}

	/**
	 * 异步开通接口服务层
	 */
	@SuppressWarnings("unchecked")
	public BwoIntf openPlatAsynService(Map map) throws Exception{
		StringBuffer outXml =null;
		String retFlag = (String)map.get("retFlag");
		String taskNo = (String)map.get("taskNo");
		String orderId = (String)map.get("orderId");
		String IMSI = (String)map.get("IMSI");
		String MSISDN =(String)map.get("MSISDN");
		BwoIntf  bwoIntf = null;		
		if(retFlag!=null&&"true".equals(retFlag)){
			bwoIntf =(BwoIntf) map.get("BWO");
		}
		
		//过滤poList 排序
		List<PoIntf> poList = (List<PoIntf>)map.get("poList");
		
		Date execStartTime = new Date();
		
		if(poList!=null&&poList.size()>0){
			Collections.sort(poList, new PoComparator());
			
			try {
				boolean vgopFlag =false;
				List<String> bossTranslist = new ArrayList<String>();
				
				//保存
				for(PoIntf poIntf : poList){
					String id = queryPoIdSequence(); 
					poIntf.setPoId(Long.parseLong(id));
					
					if("VGOP_BATCH".equals(poIntf.getPoType())){
						String param = poIntf.getParam();
						String transactionId = String.valueOf(openPlatDao.getVgopTransactionId());
						param = param.replace("&transId", transactionId);
						poIntf.setParam(param);
						
						bossTranslist.add(transactionId);
						vgopFlag = true;
					}
					
					openPlatDao.save(poIntf);
				}
				if(vgopFlag){
					String crmId = (String)map.get("transId");
					for(String bossTransId:bossTranslist){
						String sql = "insert into KT.VGOP_TRANSID_MAP(CRM_TRANSID,BOSS_TRANSID,BUSI_DATE) values('"+crmId+"','"+bossTransId+"',sysdate)";
						openPlatDao.createSQLQuery(sql);
					}
					
				}
				if(bwoIntf!=null){
					openPlatDao.save(bwoIntf);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new OpenPlatException(OpenPlatStatusCode.DB_OPERATION_ERROR);
			}
			
			
		}else{
			logger.info("PoList为空!");
		}
		
		return bwoIntf;
	}
	
	public String AsynExecReturn(BwoIntf bwoIntf,String taskNo,String orderId,boolean retFlag){
		StringBuffer outXml = null;
		//根据是否需要回执标识 决定是否等待处理结果
		if(retFlag){
			if(bwoIntf!=null){
				//扫描表获取结果组织报文返回
				timeout = new Date().getTime();
				BwoIntfHis bwoHis = new BwoIntfHis();
				
				BwoIntf rsBwoIntf = queryPollingBwoIntf(bwoIntf.getTradeId());
				
				if(rsBwoIntf==null){//等待超时
					
					bwoHis = copyBwoIntfToHis(bwoHis, bwoIntf, null);
					openPlatDao.save(bwoHis);
					
					outXml = new StringBuffer();
					outXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
					outXml.append("<Response>\n");
					outXml.append("<TaskNo>"+bwoIntf.getTradeId()+"</TaskNo>\n");
					outXml.append("<ErrorCode>99999</ErrorCode>\n");
					outXml.append("<ErrorMsg>No return the results,Time out</ErrorMsg>\n");
					outXml.append("<OrderNo>"+orderId+"</OrderNo>\n");
					outXml.append("</Response>");
					
					
				}else{
					//正常返回报文
					bwoHis = copyBwoIntfToHis(bwoHis, rsBwoIntf, "success");
					openPlatDao.save(bwoHis);
					
					int status = rsBwoIntf.getStatus();
					String errorCode = "";
					String errorDesc = "";
					
					if(status==9){
						errorCode="0";
						errorDesc = "成功";
					}else{
						errorCode = rsBwoIntf.getErrCode();
						if("0".equals(errorCode)){
							errorCode ="-1";
							errorDesc = rsBwoIntf.getErrDesc()==null?"":rsBwoIntf.getErrDesc().replaceAll("<", "").replaceAll(">", "");
						}else{
							errorCode = rsBwoIntf.getErrCode()==null?"-1":rsBwoIntf.getErrCode();
							errorDesc = rsBwoIntf.getErrDesc()==null?"":rsBwoIntf.getErrDesc().replaceAll("<", "").replaceAll(">", "");
						}
					}
					
					outXml = new StringBuffer();
					outXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
					outXml.append("<Response>\n");
					outXml.append("<TaskNo>"+bwoIntf.getTradeId()+"</TaskNo>\n");
					outXml.append("<ErrorCode>"+errorCode+"</ErrorCode>\n");
					outXml.append("<ErrorMsg>"+errorDesc+"</ErrorMsg>\n");
					
					boolean retInfoFlag = false;
					StringBuffer buffer = new StringBuffer("<ParamSeq>\n");
					if(rsBwoIntf.getRetInfo()!=null&&!"".equals(rsBwoIntf.getRetInfo())){
						String retInfo = rsBwoIntf.getRetInfo();
						String[] params = retInfo.split(";");
						
						//需要返回的字段名称 通过配置文件获取
						ResourceBundle rb = ResourceBundle.getBundle("QueryPo_INFO");
					    String paramTypes = rb.getString("RetParam");
					    
					    String[] paraArray = paramTypes.split(",");
						
						if(params!=null&&params.length>0){
							for(String temp:params){
								if(temp.indexOf("=")!=-1){
									String[] temps = temp.split("=");
									
									if(paraArray!=null&&paraArray.length>0){
										for(String parmconfig:paraArray){
											if(parmconfig.equals(temps[0])){
												buffer.append("<item>\n");
												buffer.append("<Name>@NEW@"+temps[0]+"</Name>\n");
												buffer.append("<Value>"+temps[1]+"</Value>\n");
												buffer.append("</item>\n");
												retInfoFlag = true;
											}
										}
									}
									/*if("TRADETIME".equals(temps[0])){
										buffer.append("<item>\n");
										buffer.append("<Name>@NEW@"+temps[0]+"</Name>\n");
										buffer.append("<Value>"+temps[1]+"</Value>\n");
										buffer.append("</item>\n");
										retInfoFlag = true;
									}
									if("FLAG".equals(temps[0])){
										buffer.append("<item>\n");
										buffer.append("<Name>@NEW@"+temps[0]+"</Name>\n");
										buffer.append("<Value>"+temps[1]+"</Value>\n");
										buffer.append("</item>\n");
										retInfoFlag = true;
									}*/
								}
							}
						}
						buffer.append("</ParamSeq>\n");
					}
					/*else if("-1".equals(errorCode)){
						*//**
						 * 特殊处理需要返回值的失败情况  在retInfo中没有
						 * 需要从errorMsg中解析
						 * {SUB PROV PS_ID:[88474112]FAIL REASON:{RETN=1005, DESC="用户不是有效期状态";  }};
						 *//*
						if(!"".equals(errorDesc)){
							String retn = "";
							String desc = "";
							//TODO: 解析返回值
						}
						
					}*/
					if(retInfoFlag){
						outXml.append(buffer);
					}
					outXml.append("<OrderNo>"+orderId+"</OrderNo>\n");
					outXml.append("</Response>");
					openPlatDao.deleteObject(rsBwoIntf);
				}
			}else{
				outXml = new StringBuffer();
				outXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
				outXml.append("<Response>\n");
				outXml.append("<TaskNo>"+taskNo+"</TaskNo>\n");
				outXml.append("<ErrorCode>99995</ErrorCode>\n");
				outXml.append("<ErrorMsg>报文中不包含PO参数</ErrorMsg>\n");
				outXml.append("<OrderNo>"+orderId+"</OrderNo>\n");
				outXml.append("</Response>");
			}
		}else{
			outXml = new StringBuffer();
			outXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			outXml.append("<Response>\n");
			outXml.append("<TaskNo>"+bwoIntf.getTradeId()+"</TaskNo>\n");
			outXml.append("<ErrorCode>0</ErrorCode>\n");
			outXml.append("<ErrorMsg>成功</ErrorMsg>\n");
			outXml.append("<OrderNo>"+orderId+"</OrderNo>\n");
			outXml.append("</Response>");
		}
		
		String res = outXml.toString();
		
		return res.replace("&", "|");
	}
	
	
	public String queryPoIdSequence(){
		return openPlatDao.queryPoIdSequence();
	}
	
	/**
	 * 轮询Bwo表 判断同步开通订单是否完成
	 * 如果20秒还未返回成功结果 向前台返回超时
	 * @param tradeId
	 * @return  BwoIntf==null 继续轮询  BwoIntf!=null 轮询结束返回结果 
	 */
	public BwoIntf queryPollingBwoIntf(Long tradeId ){
		Long now = new Date().getTime();
		logger.info("时间差:="+(now-timeout));
		BwoIntf bf =null;
		if(now-timeout<OpenPlatConstant.KT_Synchronize_Timeout){
			bf = openPlatDao.queryBwoIntfById(tradeId);
			 if(bf==null){
				try {
					 Thread thread = Thread.currentThread();
					 thread.sleep(500);
					 bf=queryPollingBwoIntf(tradeId);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 }else{
				 return bf;
			 }
		}
		return bf;
	}
	
	public BwoIntfHis copyBwoIntfToHis(BwoIntfHis dest,BwoIntf orig,String flag){
		dest.setTradeId(orig.getTradeId());
		dest.setfNum(orig.getfNum());
		dest.setPoNum(orig.getPoNum());
		dest.setsNum(orig.getsNum());
		dest.setCreateDate(orig.getCreateDate());
		dest.setRetInfo(orig.getRetInfo());
		
		if("success".equals(flag)){
			dest.setStatus(orig.getStatus());
			dest.setErrCode(orig.getErrCode());
			dest.setErrDesc(orig.getErrDesc());
			dest.setUpdateDate(orig.getUpdateDate());
		}else{
			dest.setStatus(orig.getStatus());
			dest.setErrCode("-100");
			dest.setErrDesc("No return the results,Time out");
			dest.setUpdateDate(new Date());
		}
		return dest;
	}
	
	
	/**
	 * 同步开通接口服务层
	 */
	public String openPlatSynService(Map map) throws Exception{
		
		List<String> reqList = (List<String>)map.get("reqList");
		//String socketMessage = (String)map.get("reqString");
		//String result = "";
		StringBuffer outXml = null;
		
		Socket socket  = this.getRandomHost();
		
		List<String> responseList = new ArrayList<String>();
		
			if(socket!=null){
				try {
					
					for(String socketMessage:reqList){
					
						PrintWriter out = new PrintWriter(socket.getOutputStream(),true); 
						
						InputStream inputStream = socket.getInputStream();
						
						out.print(socketMessage);
						out.flush();
						System.out.println("Length = "+socketMessage.length());
						
						byte[] bytes = new byte[8];
						inputStream.read(bytes);
						
						String tempString = new String(bytes);
						int size = Integer.valueOf(tempString);
						System.out.println("size="+size);
						
						byte[] resultByte= new byte[size-8];
						
						inputStream.read(resultByte);
						String result = new String(resultByte,"GBK");
						logger.info("Result.size="+result.length());
						
						responseList.add(result);
						
					}	
						socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else{
				logger.info("同步连接开通平台失败！");
				throw new OpenPlatException(OpenPlatStatusCode.CONNECT_KT_ERROR);
			}
		
		
		//解析返回结果	
		if(responseList!=null&&responseList.size()>0){
			
			StringBuffer headBuff = new StringBuffer();
			StringBuffer paramBuffer = new StringBuffer();
			boolean paramFlag = false;
			Map<String,Map<String,String>> responseStatusMap = new HashMap<String,Map<String,String>>();
			
			for(int resIndex=0;resIndex<responseList.size();resIndex++){
				//****************************
				String result = responseList.get(resIndex);
				logger.info("KT平台返回result==>>\n"+result);
				
				if(result!=null&&!"".equals(result)){
					
					result = result.replaceAll("\n", "");
					result = result.substring(4,result.length());
					
					String[] details = result.split(";");
					
					for(int index=0;index<details.length;index++){
						String temp = details[index];
						
						if(temp!=null&&!"".equals(temp)&&temp.indexOf("=")!=-1){
							String[] tempArray = temp.split("=");
							String name= tempArray[0].trim();
							String value = "";
							if(tempArray.length!=1){
								value=tempArray[1].trim();
							}
							if("TRADE_ID".equals(name)){
								if(resIndex==0) headBuff.append("<TaskNo>"+value+"</TaskNo>\n");
							}else if("ERR_CODE".equals(name)){
									String code = value;
									if("9".equals(code)){
										code="0";
									}
									Map<String, String> codeMap = new HashMap<String, String>();
									String errorCodeString  = "<ErrorCode>"+code+"</ErrorCode>";
									codeMap.put(code, errorCodeString);
									responseStatusMap.put(String.valueOf(resIndex), codeMap);
							}else if("ERR_DESC".equals(name)){
							    String errorMsg = "<ErrorMsg>"+value+"</ErrorMsg>";
							    if(responseStatusMap.containsKey(String.valueOf(resIndex))){
							    	Map<String, String> msgMap =responseStatusMap.get(String.valueOf(resIndex));
							    	msgMap.put("ErrorMsg", errorMsg);
							    }else{
							    	Map<String, String> msgMap = new HashMap<String, String>();
								    msgMap.put("ErrorMsg", errorMsg);
								    responseStatusMap.put(String.valueOf(resIndex), msgMap);
							    }
							    
							}else if("ORDER_ID".equals(name)){
								if(resIndex==0) headBuff.append("<OrderNo>"+value+"</OrderNo>\n");
							}else if(!"".equals(name)){
								paramBuffer.append("<item>\n");
								paramBuffer.append("<Name>@NEW@"+name+"</Name>\n");
								paramBuffer.append("<Value>"+value+"</Value>\n");
								paramBuffer.append("</item>\n");
								
								paramFlag = true;
							}
						}
					}
					
					
				}else{
					throw new OpenPlatException(OpenPlatStatusCode.RETURE_XML_ERROR);
				}
			}
			
			//组装返回结果xml
			outXml = new StringBuffer();
			outXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			outXml.append("<Response>\n");	
			outXml.append(headBuff);
			
			Set keySet = responseStatusMap.keySet();
			boolean statusFlag =false;
			for(Iterator iterator = keySet.iterator();iterator.hasNext();){
				String key = (String)iterator.next();
				Map<String, String> statusMap = responseStatusMap.get(key);
				if(statusMap.containsKey("0")&&statusFlag==false){//包含查询成功的状态
					outXml.append(statusMap.get("0")+"\n");
					outXml.append(statusMap.get("ErrorMsg")+"\n");
					statusFlag =true;
				}
			}
			
			if(statusFlag==false){
				outXml.append("<ErrorCode>-1</ErrorCode>\n");
				outXml.append(responseStatusMap.get("0").get("ErrorMsg")+"\n");
			}
			
			
			if(paramFlag){
				StringBuffer param = new StringBuffer("<ParamSeq>\n");
				param.append(paramBuffer).append("</ParamSeq>\n");
				outXml.append(param);
			}
			
			outXml.append("</Response>");
		}
        logger.info("ResponseXml=>>\n"+outXml.toString());
        String res = outXml.toString();
        return res.replace("&", "|");
	}
	
	/**
	 * 记录开通同步接口和异步接口日志
	 * @param paramMap
	 */
	public void inKtBusiLogRecode(Map<String, String> paramMap){
		openPlatDao.recordKtBusiLog(paramMap);
	}
	
	/**
	 * 随机获取Socket主机端口信息创建Socket
	 * @return
	 */
	private Socket getRandomHost(){
		Socket socket = new Socket();
		
		List<String> hostList = (List<String>)applicationContext.getBean(OpenPlatConstant.kT_Synchronize_hosts);
		
		List<Integer> tempList = new ArrayList<Integer>();
		
		if(hostList!=null&&hostList.size()>0){
			for(int i = 0;i<hostList.size()-tempList.size();i++){
				
				Random random = new Random();
				int redIndex = random.nextInt(100);
				
				int hostIndex = redIndex%hostList.size();
				
				if(tempList.contains(hostIndex)){ 
					i=i-1;
				}else{
					String hostString = hostList.get(hostIndex);
					String[] hostArray = hostString.split(":");
					try {
						SocketAddress remoteAddr = new InetSocketAddress(hostArray[0],Integer.parseInt(hostArray[1]));
						socket.connect(remoteAddr);
						
						return socket;
					} catch (Exception e) {
						logger.info("========================================================================");
			            logger.info("Address:"+hostArray[0]+" Port:"+hostArray[1]+" Connect failed!");
			            logger.info("Failed Message="+e.getMessage());
			            logger.info("========================================================================");
			            tempList.add(hostIndex);
			            i=i-1;
					}
				}
			}
		}
		return null;
	}

	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		this.applicationContext = arg0;
		
	}
	
	
	
	public static void main(String[] args){
	}   

}
