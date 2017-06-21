package org.springframework.samples.web.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.samples.web.domain.PublicParking;
import org.springframework.samples.web.domain.RatingHistory;

public interface PublicParkingMapper {
	@Insert("INSERT INTO PUBLIC_PARKING VALUES (#{code}, #{title}, #{addr}, 0, 0)")
	void insertPublicParking(PublicParking publicparking);
	
	@Select("SELECT PUBLIC_PARKING_CODE FROM PUBLIC_PARKING WHERE PUBLIC_PARKING_CODE = #{id}")
	String selectId(String id);
	
	@Select("SELECT addr FROM PUBLIC_PARKING WHERE addr = #{addr}")
	String selectAddr(String addr);
	
	@Select("SELECT AVG_RATING FROM PUBLIC_PARKING WHERE PUBLIC_PARKING_CODE = #{id}")
	double selectAvgRate(String id);
	
	@Insert("INSERT INTO rating_history (RATING_CODE, RATING, ID, PUBLIC_PARKING_CODE) VALUES (RATING_SEQ.NEXTVAL, #{rating}, #{id}, #{publicparkingcode})")
	void insertPublicRating(RatingHistory ratingHistory);

}
