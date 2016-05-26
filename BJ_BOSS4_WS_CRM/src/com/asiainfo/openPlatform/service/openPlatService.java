package com.asiainfo.openPlatform.service;

import java.util.Map;

import com.asiainfo.openPlatform.domain.BwoIntf;
import com.asiainfo.openPlatform.exception.OpenPlatException;

public interface openPlatService {
     public String openPlatSynService(Map map) throws Exception;
     public BwoIntf openPlatAsynService(Map map) throws Exception;
     public void inKtBusiLogRecode(Map<String, String> paramMap);
     
     /**
 	 * 轮询Bwo表 判断同步开通订单是否完成
 	 * 如果20秒还未返回成功结果 向前台返回超时
 	 * @param tradeId
 	 * @return  BwoIntf==null 继续轮询  BwoIntf!=null 轮询结束返回结果 
 	 */
 	public BwoIntf queryPollingBwoIntf(Long tradeId );
 	
 	public String AsynExecReturn(BwoIntf bwoIntf,String taskNo,String orderId,boolean retFlag);
}
