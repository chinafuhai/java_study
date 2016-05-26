package com.asiainfo.boss4.support;

public class Constance {
	public interface OpType{
		public static final String SIGNCONTRACT							= "01";			//签约
		public static final String UNSIGNCONTRACT						= "02";			//解约 
	}
	
	public interface SignStatus{
		public static final String SIGNCONTRACT							= "1";			//签约
		public static final String UNSIGNCONTRACT						= "0";			//解约 
	}
	
	public interface HandleStatus{
		public static final String UNDEAL								= "0";			//未处理
		public static final String BOTHSIGNCONTRACT						= "1";			//BOSS和浦发银行都是签约
		public static final String BOTHUNSIGNCONTRACT					= "2";			//BOSS和浦发银行都是解约
		public static final String SIGNCONTRACTNOTINBOSS				= "3";			//浦发银行签约,BOSS没有签约
		public static final String UNSIGNCONTRACTNOTINBOSS				= "4";			//浦发银行解约,BOSS没有解约
		public static final String DATANOTINSPDB						= "5";			//BOSS有数据，浦发没有数据
	}
	
	public static String DEFAULTEXPIREDATE								= "20300101"; 
	
	public static long PRODINSID                                        = 20000000000000l;
	public static String CRMHAPPYPRODUCT								= "50001418";
	public static String  UNUSEDUSERSTS									= "12";
	public static String  PREACTIVEUSERSTS								= "11";
	public static short CENTREXUSERTYPE									= 204;
}
