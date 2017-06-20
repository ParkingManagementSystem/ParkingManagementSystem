package org.springframework.samples.web.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.samples.web.domain.Use;

public interface UseMapper {
	@Select("SELECT use_code useCode, parking_name parkingName, cost, "
			+ "public_rating publicRating, sharing_rating sharingRating, image, "
			+ "public_parking_code publicParkingCode, share_parking_code shareParkingCode, renter, lender "
			+ "FROM USE_HISTORY WHERE renter = #{id}")
	List<Use> selectUseList(String id);
	
	@Select("SELECT sharing_rating sharingRating FROM USE_HISTORY WHERE use_code = #{useCode}")
	int getShareParkingRating(String useCode);
	
	@Update("UPDATE use_history SET sharing_rating = 1 WHERE use_code = #{useCode}")
	void likeShareParking(String useCode);
	
	@Update("UPDATE use_history SET sharing_rating = -1 WHERE use_code = #{useCode}")
	void dislikeShareParking(String useCode);
	
	@Update("UPDATE use_history SET sharing_rating = 0 WHERE use_code = #{useCode}")
	void cancelLikeShareParking(String useCode);
	
}
