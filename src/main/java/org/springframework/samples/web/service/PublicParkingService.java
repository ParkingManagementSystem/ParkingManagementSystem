package org.springframework.samples.web.service;

import org.springframework.samples.web.domain.PublicParking;
import org.springframework.samples.web.domain.RatingHistory;

public interface PublicParkingService {
	
	public void insertPublicParking(PublicParking publicParking);
	
	public String selectAddr(String addr);
	
	public String selectId(String id);
	
	public double selectAvgRate(String id);
	
	public void insertPublicRating(RatingHistory ratingHistory);

}
