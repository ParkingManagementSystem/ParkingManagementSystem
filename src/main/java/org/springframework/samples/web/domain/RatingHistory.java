package org.springframework.samples.web.domain;

public class RatingHistory {
	private String rating_code;
	private int rating;
	private String use_code;
	private String id;
	private String publicparkingcode;
	
	public String getPublicparkingcode() {
		return publicparkingcode;
	}
	public void setPublicparkingcode(String publicparkingcode) {
		this.publicparkingcode = publicparkingcode;
	}
	public String getRating_code() {
		return rating_code;
	}
	public void setRating_code(String rating_code) {
		this.rating_code = rating_code;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getUse_code() {
		return use_code;
	}
	public void setUse_code(String use_code) {
		this.use_code = use_code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
