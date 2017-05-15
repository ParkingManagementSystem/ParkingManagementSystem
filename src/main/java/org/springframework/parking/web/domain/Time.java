package org.springframework.parking.web.domain;

import java.util.Date;

public class Time {

	private String timeCode;
	private String applyCode;
	private String parkingId;
	private Date createdAt;
	private int startHour;
	private int startMinute;
	private int endHour;
	private int endMinute;
	
	public Time(){}
	
	public Time(String timeCode, String applyCode, String parkingId, Date createdAt, int startHour, int startMinute,
			int endHour, int endMinute) {
		super();
		this.timeCode = timeCode;
		this.applyCode = applyCode;
		this.parkingId = parkingId;
		this.createdAt = createdAt;
		this.startHour = startHour;
		this.startMinute = startMinute;
		this.endHour = endHour;
		this.endMinute = endMinute;
	}

	public String getTimeCode() {
		return timeCode;
	}
	public void setTimeCode(String timeCode) {
		this.timeCode = timeCode;
	}
	public String getApplyCode() {
		return applyCode;
	}
	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}
	public String getParkingId() {
		return parkingId;
	}
	public void setParkingId(String parkingId) {
		this.parkingId = parkingId;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public int getStartHour() {
		return startHour;
	}
	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}
	public int getStartMinute() {
		return startMinute;
	}
	public void setStartMinute(int startMinute) {
		this.startMinute = startMinute;
	}
	public int getEndHour() {
		return endHour;
	}
	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}
	public int getEndMinute() {
		return endMinute;
	}
	public void setEndMinute(int endMinute) {
		this.endMinute = endMinute;
	}
	
}
