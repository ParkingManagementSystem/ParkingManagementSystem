package org.springframework.samples.web.domain;

import java.util.Date;

public class UseHistory {
	
	private String useCode;
	private String publicParkingCode;
	private String sharParkingCode;
	private String parkingName;
	private String memberId;
	private int cost;
	private Date timeCode;
	private int parkingRate;
	private int shareRating;
	private String image;
	
	public UseHistory(){}
	
	public UseHistory(String useCode, String publicParkingCode, String sharParkingCode, String parkingName,
			String memberId, int cost, Date timeCode, int parkingRate, int shareRating, String image) {
		super();
		this.useCode = useCode;
		this.publicParkingCode = publicParkingCode;
		this.sharParkingCode = sharParkingCode;
		this.parkingName = parkingName;
		this.memberId = memberId;
		this.cost = cost;
		this.timeCode = timeCode;
		this.parkingRate = parkingRate;
		this.shareRating = shareRating;
		this.image = image;
	}

	public String getUseCode() {
		return useCode;
	}
	public void setUseCode(String useCode) {
		this.useCode = useCode;
	}
	public String getPublicParkingCode() {
		return publicParkingCode;
	}
	public void setPublicParkingCode(String publicParkingCode) {
		this.publicParkingCode = publicParkingCode;
	}
	public String getSharParkingCode() {
		return sharParkingCode;
	}
	public void setSharParkingCode(String sharParkingCode) {
		this.sharParkingCode = sharParkingCode;
	}
	public String getParkingName() {
		return parkingName;
	}
	public void setParkingName(String parkingName) {
		this.parkingName = parkingName;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public Date getTimeCode() {
		return timeCode;
	}
	public void setTimeCode(Date timeCode) {
		this.timeCode = timeCode;
	}
	public int getParkingRate() {
		return parkingRate;
	}
	public void setParkingRate(int parkingRate) {
		this.parkingRate = parkingRate;
	}
	public int getShareRating() {
		return shareRating;
	}
	public void setShareRating(int shareRating) {
		this.shareRating = shareRating;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

}
