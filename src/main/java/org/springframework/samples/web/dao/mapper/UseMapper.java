package org.springframework.samples.web.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.samples.web.domain.Use;

public interface UseMapper {
	@Select("SELECT use_code useCode, parking_name parkingName, cost, "
			+ "public_rating publicRating, sharing_rating sharingRating, image, "
			+ "public_parking_code publicParkingCode, share_parking_code shareParkingCode, id "
			+ "FROM USE_HISTORY WHERE id = #{id}")
	List<Use> selectUseList(String id);
	
	@Update("UPDATE use_history SET share_rating = 1 WHERE share_parking_code = #{parkingCode}")
	void likeShareParking(String parkingCode);
	
	@Update("UPDATE use_history SET share_rating = -1 WHERE share_parking_code = #{parkingCode}")
	void dislikeShareParking(String parkingCode);
}
