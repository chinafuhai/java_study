package com.asiainfo.openPlatform.support;

/**
 * 开通接口常量
 * @author zhangql
 *
 */
public class OpenPlatConstant {
	/**同步接口 --查询类业务*/
    public static String KT_Synchronize_Query = "0";
    
    /**同步接口 --订单业务办理类*/
    public static String KT_Synchronize_Busi = "1";
    
    /**同步接口--查询类Socket地址和端口获取Bean*/
    public static String kT_Synchronize_hosts = "SynSocketHosts";
    
    /**同步类订单 超时时间*/
    public static int KT_Synchronize_Timeout =60000;
    
    /**日志参数--接口类型  0 同步接口调用  */
    public static String KT_LogInterType_Syn="0";
    
    /**日志参数--接口类型  1 异步接口调用*/
    public static String KT_LogInterType_Asyn="1";
    
    /**异步订单 ---优先级*/
    public static int KT_Asyn_Priority_level = 0;

    /**同步订单类 --优先级*/
    public static int KT_Syn_Priority_level = 99;
    
}
