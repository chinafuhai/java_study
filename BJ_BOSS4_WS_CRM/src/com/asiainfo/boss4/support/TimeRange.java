package com.asiainfo.boss4.support;

import java.util.Date;

import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;

public class TimeRange {
	private Date startTime;
	private Date endTime;
	
	public TimeRange(Date startTime, Date endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Date getEndTime() {
		return endTime;
	}
	
	/**
	 * 返回两个时间范围的合集
	 * @param other
	 * @return
	 * @throws BossException 如果两个时间范围之间没有交集，则无法合并
	 */
	public TimeRange union(TimeRange other) throws BossException {
		if (! this.isIntersecting(other)) {
			throw new BossException(StatusCode.INSIDE_ERROR, this+" CAN'T UNION "+other+"");
		}
		
		Date startTime = this.getStartTime().before(other.getStartTime()) 
							? this.getStartTime() : other.getStartTime();
		Date endTime = this.getEndTime().after(other.getEndTime())
							? this.getEndTime() : other.getEndTime();
		return new TimeRange(startTime, endTime);
	}
	
	/**
	 * 判断两个时间范围之间是否有交集
	 * @param other
	 * @return
	 */
	public boolean isIntersecting(TimeRange other) {
		boolean result = true;
		
		if (this.getStartTime().before(other.getStartTime()) && this.getEndTime().before(other.getStartTime())) {
			result = false;
		}
		
		if (this.getStartTime().after(other.getEndTime()) && this.getEndTime().after(other.getEndTime())) {
			result = false;
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		return new StringBuilder("TimeRange")
				.append("[startTime=").append(DateHelper.Date2String(getStartTime())).append(", ")
				.append("endTime=").append(DateHelper.Date2String(getEndTime())).append("]")
				.toString();
	}
}
