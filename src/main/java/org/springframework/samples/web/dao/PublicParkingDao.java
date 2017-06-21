package org.springframework.samples.web.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.web.domain.PublicParking;
import org.springframework.samples.web.domain.RatingHistory;


public interface PublicParkingDao {
	
	void insertPublicParking(PublicParking publicParking) throws DataAccessException;
	
	String selectAddr(String addr) throws DataAccessException;
	
	String selectId(String id) throws DataAccessException;
	
	double selectAvgRate(String id) throws DataAccessException;
	
	void insertPublicRating(RatingHistory ratingHistory) throws DataAccessException;

}
