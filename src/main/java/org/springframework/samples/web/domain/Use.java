package org.springframework.samples.web.domain;

//사용 내역 DTO
public class Use {
	private String useCode;
	private String parkingName;
	private int cost;
	private int publicRating;
	private int sharingRating;
	private String image;
	private String publicParkingCode;
	private String shareParkingCode;
	private String renter;
	private String lender;
	public String getUseCode() {
		return useCode;
	}
	public void setUseCode(String useCode) {
		this.useCode = useCode;
	}
	public String getParkingName() {
		return parkingName;
	}
	public void setParkingName(String parkingName) {
		this.parkingName = parkingName;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getPublicRating() {
		return publicRating;
	}
	public void setPublicRating(int publicRating) {
		this.publicRating = publicRating;
	}
	public int getSharingRating() {
		return sharingRating;
	}
	public void setSharingRating(int sharingRating) {
		this.sharingRating = sharingRating;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPublicParkingCode() {
		return publicParkingCode;
	}
	public void setPublicParkingCode(String publicParkingCode) {
		this.publicParkingCode = publicParkingCode;
	}
	public String getShareParkingCode() {
		return shareParkingCode;
	}
	public void setShareParkingCode(String shareParkingCode) {
		this.shareParkingCode = shareParkingCode;
	}
	public String getRenter() {
		return renter;
	}
	public void setRenter(String renter) {
		this.renter = renter;
	}
	public String getLender() {
		return lender;
	}
	public void setLender(String lender) {
		this.lender = lender;
	}
	@Override
	public String toString() {
		return "Use [useCode=" + useCode + ", parkingName=" + parkingName + ", cost=" + cost + ", publicRating="
				+ publicRating + ", sharingRating=" + sharingRating + ", image=" + image + ", publicParkingCode="
				+ publicParkingCode + ", shareParkingCode=" + shareParkingCode + ", renter=" + renter + ", lender="
				+ lender + "]";
	}
	
}
