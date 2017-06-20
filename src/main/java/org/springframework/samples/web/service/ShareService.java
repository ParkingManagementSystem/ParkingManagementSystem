package org.springframework.samples.web.service;

import java.util.List;

import org.springframework.samples.web.command.ShareParkingCommand;
import org.springframework.samples.web.domain.Apply;
import org.springframework.samples.web.domain.ShareParking;

public interface ShareService {

	public void insertShareParking(ShareParkingCommand shareCommand);
	
	public void updateShareParking(ShareParkingCommand shareCommand);
	
	public void deleteShareParking(String shareParkingCode);
	
	public ShareParkingCommand getShareParking(String shareParkingCode);
	
	public List<ShareParking> getShareParkingList();
	
	public void insertShareApply(Apply apply);
	
	public List<Apply> getApplyList(String shareParkingCode);
	
	public Apply getApply(String shareParkingCode, String applierCode);
	
	public List<ShareParking> getShareParkingListByWriter(String writer_id);
}
