package org.springframework.samples.web.dao;

import java.sql.Time;
import java.util.List;

import org.springframework.samples.web.command.ShareParkingCommand;
import org.springframework.samples.web.domain.Apply;
import org.springframework.samples.web.domain.Reply;
import org.springframework.samples.web.domain.ShareParking;

public interface ShareDao {
	
	void insertShareParking(ShareParking shareParking);
	
	ShareParkingCommand getShareParkingCommand(String share_parking_code);
	
	List<ShareParking> getShareParkingList();
	
	List<Apply> getApplyList(String share_parking_code);
	
	List<Time> getTimeList(String share_parking_id);
	
	List<Reply> getReplyList(String share_parking_code);
	
	void insertShareApply(Apply apply);
	
	Apply getApply(String shareParkingCode, String applierCode);
	
}
