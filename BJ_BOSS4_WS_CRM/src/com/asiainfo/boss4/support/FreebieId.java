package com.asiainfo.boss4.support;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum FreebieId {
	FREEBIE1(1,66771002,"本地4G数据流量"), 
	FREEBIE2(2,66771001, "本地3G数据流量"), 
	FREEBIE3(3,66771000, "本地数据流量"), 
	FREEBIE4(4,66661025, "本地闲时数据流量"), 
	FREEBIE5(5,66661030, "闲时数据流量"), 
	FREEBIE6(6,66661037,"3G数据流量"),
	FREEBIE7(7,66771003, "季包（卡）流量"), 
	FREEBIE8(8,66661048, "半年包（卡）流量"), 
	FREEBIE9(9,66661052,"年包（卡）流量"),
	;

	private FreebieId(int freebieTempletId,int freebieId,String freebieDesc) {
		this.freebieTempletId = freebieTempletId;
		this.freebieId = freebieId;
		this.freebieDesc = freebieDesc;
	}

	public int freebieTempletId;
	public int freebieId;
	private String freebieDesc;
	
	public int getFreebieTempletId() {
		return freebieTempletId;
	}
	public void setFreebieTempletId(int freebieTempletId) {
		this.freebieTempletId=freebieTempletId;
	}
	
	public int getFreebieId() {
		return freebieId;
	}
	public void setFreebieId(int freebieId) {
		this.freebieId=freebieId;
	}

	public String getTreebieDesc() {
		return freebieDesc;
	}
	public void setTreebieDesc(String freebieDesc) {
		this.freebieDesc=freebieDesc;
	}

	private static EnumSet<FreebieId> needNoticeFreebieId = null;

	private static EnumSet<FreebieId> needNoticeThreshold() {
		if (needNoticeFreebieId == null) {
			needNoticeFreebieId = EnumSet.of(
					FREEBIE1, 
					FREEBIE2, 
					FREEBIE3, 
					FREEBIE4,
					FREEBIE5, 
					FREEBIE6, 
					FREEBIE7,
					FREEBIE8, 
					FREEBIE9);
		}
		return needNoticeFreebieId;
	}

	public static Map<Integer, String> needNoticeFreebieIdMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (FreebieId freebieIdEnum : needNoticeThreshold()) {
			map.put(freebieIdEnum.getFreebieTempletId(), freebieIdEnum.getTreebieDesc());
		}
		return map;
	}
	
	public static int getFreebieId(int freebieTempletId) {
		FreebieId[] enums = FreebieId.values();
        for(FreebieId freebie: enums){
        	if(freebie.getFreebieTempletId()== freebieTempletId){
        	    return 	freebie.getFreebieId();
        	}
        }
        return 0;
	}	
}
