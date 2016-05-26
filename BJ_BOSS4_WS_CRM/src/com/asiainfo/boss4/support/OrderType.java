package com.asiainfo.boss4.support;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public enum OrderType {
	ORDER1((short)27,"按天提醒"),
	ORDER2((short)28,"按周提醒"),
	ORDER3((short)29,"按月提醒"),
	ORDER4((short)42,"使用50%"),
	ORDER5((short)43,"剩余不足50M"),
	ORDER6((short)44,"剩余不足5M"),
	ORDER7((short)58,"用尽"),
	ORDER8((short)59,"使用90%"),
	ORDER9((short)61,"超量5元提醒"),
	ORDER10((short)62,"超量30元提醒"),
	ORDER11((short)63,"超量100元提醒"),
    ;
	
	private OrderType(Short orderType, String orderName) {
		this.orderType = orderType;
		this.orderName = orderName;
	}
	
	public Short orderType;
	public Short getOrderType() {
		return orderType;
	}
	
	private String orderName;
	
	public String getOrderName() {
		return orderName;
	}
	
	private static EnumSet<OrderType> needNoticeOrderType = null;
	
	private static EnumSet<OrderType> needNoticeOrderType() {
		if (needNoticeOrderType == null) {
			needNoticeOrderType = EnumSet.of(ORDER1, 
					ORDER2, 
					ORDER3,
					ORDER4, 
					ORDER5, 
					ORDER6, 
					ORDER7, 
					ORDER8, 
					ORDER9, 
					ORDER10, 
					ORDER11);
		}
		return needNoticeOrderType;
	}
	
	public static boolean isOrderType(Short orderTypeValue) {
		for (OrderType orderType : needNoticeOrderType()) {
			if (orderType.getOrderType().equals(orderTypeValue)) {
				return true;
			}
		}
		return false;
	}
	
	public static List<Short> needNoticeOrderTypeList() {
		List<Short> list=new ArrayList<Short>();
		for (OrderType orderType : needNoticeOrderType()) {
			list.add(orderType.getOrderType());
		}
		return list;
	}
}
