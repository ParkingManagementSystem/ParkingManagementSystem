package org.springframework.samples.web.service;

import java.util.List;

import org.springframework.samples.web.command.ApplyCommand;
import org.springframework.samples.web.command.ShareParkingCommand;
import org.springframework.samples.web.domain.Apply;
import org.springframework.samples.web.domain.ShareParking;
import org.springframework.samples.web.domain.Time;

public interface ShareService {

	public void insertShareParking(ShareParkingCommand shareCommand);
	
	public void updateShareParking(ShareParkingCommand shareCommand);
	
	public void deleteShareParking(String shareParkingCode);
	
	public ShareParkingCommand getShareParking(String shareParkingCode);
	
	public List<ShareParking> getShareParkingList();
	
	public void insertShareApply(Apply apply);
	
	public List<Apply> getApplyList(String shareParkingCode);
	
	public void updateApply(String applyCode);
	
	public Apply getApply(String shareParkingCode, String applierCode);
	
	public void insertShareTime(Time time);
	
	public List<ApplyCommand> getApplyCommandList(String shareParkingCode);
	
	public int isEvaluate(String id);
	
	public void insertEvaluate(String id);
	
	public int isAccepted(String ShareParkingCode, String id);
	
	public List<ShareParking> getShareParkingListByWriter(String writer_id);
	
	public String getShareParkingCode();
	
	public int isApplied(String ShareParkingCode, String id);
	
//	public void saveImage(Map<String, Object> img, String shareParkingCode);
}
