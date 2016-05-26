package com.asiainfo.boss4.support;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Threshold {
	STATE1(112050, "使用50%提醒"), 
	STATE2(127090, "使用90%提醒"), 
	STATE3(108000, "用尽提醒"), 
	STATE4(166005, "超量5元提醒"), 
	STATE5(166030, "超量30元提醒"), 
	STATE6(166100,"超量100元提醒"),
	;

	private Threshold(int threshold, String thresholdDesc) {
		this.threshold = threshold;
		this.thresholdDesc = thresholdDesc;
	}

	public int threshold;

	public int getThreshold() {
		return threshold;
	}

	private String thresholdDesc;

	public String getThresholdDesc() {
		return thresholdDesc;
	}

	private static EnumSet<Threshold> needNoticeThreshold = null;

	private static EnumSet<Threshold> needNoticeThreshold() {
		if (needNoticeThreshold == null) {
			needNoticeThreshold = EnumSet.of(
					STATE1, 
					STATE2, 
					STATE3, 
					STATE4,
					STATE5, 
					STATE6);
		}
		return needNoticeThreshold;
	}

	public static Map<Integer, String> needNoticeThresholdMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (Threshold thresholdEnum : needNoticeThreshold()) {
			map.put(thresholdEnum.getThreshold(), thresholdEnum.getThresholdDesc());
		}
		return map;
	}
}