package com.asiainfo.boss4.support;

import java.util.EnumSet;

public enum RateType {

	RATE1(901654L, "YZFHM2M", "元/两月"), 
	RATE2(901654L, "YZFHM3M", "元/季度"), 
	RATE3(901654L, "YZFHMBN", "元/半年"), 
	RATE4(901654L, "YZFHMN", "元/年"), 
	RATE5(901654L, "YZFHM2N", "元/两年")
	;

	private Long spCode;
	private String operatorCode;
	private String description;

	private RateType(Long spCode, String operatorCode, String description) {
		this.spCode = spCode;
		this.operatorCode = operatorCode;
		this.description = description;
	}
	
	public void setSpCode(Long spCode){
		this.spCode=spCode;
	}
	
    public Long getSpCode() {
        return this.spCode;
    }
    
    public void setOperatorCode(String operatorCode) {
        this.operatorCode=operatorCode;
    }
    
    public String getOperatorCode() {
        return this.operatorCode;
    }
    
    public void setDescription(String description) {
        this.description=description;
    }
    
    public String getDescription() {
        return this.description;
    }
    
	public static String getRateDescription(Long spCode, String operatorCode) {
		EnumSet<RateType> rates = EnumSet.allOf(RateType.class);
        for (RateType rate : rates) {
            if (rate.spCode.equals(spCode) && rate.operatorCode.equals(operatorCode)) {
                  return rate.description;
            }
         }
		return "元/月";
	}

}
