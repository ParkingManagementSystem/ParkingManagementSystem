package org.springframework.parking.web.domain;

public class ShareParking {
	
	private String shareParkingCode;
	private String writerId;
	private String parkingName;
	private String address;
	private String gu;
	private Double altitude;
	private Double longitude;
	private String phone;
	private String carType;
	private int cost;
	private boolean blackList;
	private String title;
	private String content;
	private String image;
	
	public ShareParking(String shareParkingCode, String writerId, String parkingName, String address, String gu,
			Double altitude, Double longitude, String phone, String carType, int cost, boolean blackList, String title,
			String content, String image) {
		super();
		this.shareParkingCode = shareParkingCode;
		this.writerId = writerId;
		this.parkingName = parkingName;
		this.address = address;
		this.gu = gu;
		this.altitude = altitude;
		this.longitude = longitude;
		this.phone = phone;
		this.carType = carType;
		this.cost = cost;
		this.blackList = blackList;
		this.title = title;
		this.content = content;
		this.image = image;
	}
	
	public ShareParking(){
	}
	
	public String getShareParkingCode() {
		return shareParkingCode;
	}
	public void setShareParkingCode(String shareParkingCode) {
		this.shareParkingCode = shareParkingCode;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getParkingName() {
		return parkingName;
	}
	public void setParkingName(String parkingName) {
		this.parkingName = parkingName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGu() {
		return gu;
	}
	public void setGu(String gu) {
		this.gu = gu;
	}
	public Double getAltitude() {
		return altitude;
	}
	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public boolean isBlackList() {
		return blackList;
	}
	public void setBlackList(boolean blackList) {
		this.blackList = blackList;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

}
