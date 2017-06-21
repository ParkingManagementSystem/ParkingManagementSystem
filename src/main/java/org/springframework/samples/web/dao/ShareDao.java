package org.springframework.samples.web.dao;

import java.util.List;
import java.util.Map;

import org.springframework.samples.web.command.ApplyCommand;
import org.springframework.samples.web.command.ShareParkingCommand;
import org.springframework.samples.web.domain.Apply;
import org.springframework.samples.web.domain.Reply;
import org.springframework.samples.web.domain.ShareParking;
import org.springframework.samples.web.domain.Time;

public interface ShareDao {
	
	void insertShareParking(ShareParking shareParking);
	
	ShareParkingCommand getShareParkingCommand(String share_parking_code);
	
	List<ShareParking> getShareParkingList();
	
	List<Apply> getApplyList(String share_parking_code);
	
	List<Time> getTimeList(String share_parking_id);
	
	List<Reply> getReplyList(String share_parking_code);
	
	void insertShareApply(Apply apply);
	
	void updateApply(String applyCode);
	
	Apply getApply(String shareParkingCode, String applierCode);
	
	void insertShareTime(Time time);
	
	List<ApplyCommand> getApplyCommandList(String shareParkingCode);
	
	int isEvaluate(String id);
	
	void insertEvaluate(String id);
	
	int isAccepted(String code, String id);
	
	
	public List<ShareParking> getShareParkingListByWriter(String writer_id);
	
	String getShareParkingCode();
	
	void saveImage(Map<String, Object> hmap);
	
	int isApplied(String code, String id);
}
