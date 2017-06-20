package org.springframework.samples.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.command.ShareParkingCommand;
import org.springframework.samples.web.dao.ShareDao;
import org.springframework.samples.web.domain.Apply;
import org.springframework.samples.web.domain.ShareParking;
import org.springframework.stereotype.Service;

@Service
public class ShareServiceImpl implements ShareService{

	@Autowired
	private ShareDao shareDao;
	
	@Override
	public void insertShareParking(ShareParkingCommand shareCommand) {
		// TODO Auto-generated method stub
		
		ShareParking share = new ShareParking();
		share.setCommand(shareCommand);
		
		shareDao.insertShareParking(share);
		
	}

	@Override
	public void updateShareParking(ShareParkingCommand shareCommand) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteShareParking(String shareParkingCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ShareParkingCommand getShareParking(String shareParkingCode) {
		// TODO Auto-generated method stub
		ShareParkingCommand info = new ShareParkingCommand();
		info = shareDao.getShareParkingCommand(shareParkingCode);
		return info;
	}

	@Override
	public List<ShareParking> getShareParkingList() {
		// TODO Auto-generated method stub
		List<ShareParking> shareList = new ArrayList<ShareParking>();
		shareList = shareDao.getShareParkingList();
		return shareList;
	}

	@Override
	public void insertShareApply(Apply apply) {
		// TODO Auto-generated method stub
		shareDao.insertShareApply(apply);
	}

	@Override
	public List<Apply> getApplyList(String shareParkingCode) {
		// TODO Auto-generated method stub
		List<Apply> applyList = new ArrayList<Apply>();
		applyList = shareDao.getApplyList(shareParkingCode);
		return applyList;
	}

	@Override
	public Apply getApply(String shareParkingCode, String applierCode) {
		
		Apply apply = new Apply();
		apply = shareDao.getApply(shareParkingCode, applierCode);
		return apply;
	}

	@Override
	public List<ShareParking> getShareParkingListByWriter(String writer_id) {
		return shareDao.getShareParkingListByWriter(writer_id);
	}
	

	
}
