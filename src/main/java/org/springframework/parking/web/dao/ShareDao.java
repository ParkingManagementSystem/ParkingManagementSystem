package org.springframework.parking.web.dao;

import java.sql.Time;
import java.util.List;

import org.springframework.parking.web.domain.Apply;
import org.springframework.parking.web.domain.Reply;
import org.springframework.parking.web.domain.ShareParking;

public interface ShareDao {
	
	void registerShareParking(ShareParking shareParking);
	
	List<ShareParking> getShareParking(String share_parking_code);
	
	List<Apply> getApplyList(String share_parking_code);
	
	List<Time> getTimeList(String share_parking_id);
	
	List<Reply> getReplyList(String share_parking_code);
	
}
