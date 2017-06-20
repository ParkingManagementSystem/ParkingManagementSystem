package org.springframework.samples.web.dao;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.command.ShareParkingCommand;
import org.springframework.samples.web.dao.mapper.ShareMapper;
import org.springframework.samples.web.domain.Apply;
import org.springframework.samples.web.domain.Reply;
import org.springframework.samples.web.domain.ShareParking;
import org.springframework.stereotype.Repository;

@Repository
public class ShareDaoImpl implements ShareDao{

	@Autowired
	private ShareMapper shareMapper;

	@Override
	public void insertShareParking(ShareParking shareParking) {
		shareMapper.insertShareParking(shareParking);
		
	}

	@Override
	public ShareParkingCommand getShareParkingCommand(String share_parking_code) {
		ShareParkingCommand info = new ShareParkingCommand();
		info = shareMapper.getShareParkingCommand(share_parking_code);
		return info;
	}

	@Override
	public List<Apply> getApplyList(String share_parking_code) {
		List<Apply> applyList = new ArrayList<Apply>();
		applyList = shareMapper.getApplyList(share_parking_code);
		
		return applyList;
	}

	@Override
	public List<Time> getTimeList(String share_parking_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reply> getReplyList(String share_parking_code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShareParking> getShareParkingList() {
		List<ShareParking> shareList = new ArrayList<ShareParking>();
		shareList = shareMapper.getShareParkingList();
		return shareList;
	}

	//@Transactional //TODO 트랜잭션 처리 
	@Override
	public void insertShareApply(Apply apply) {
		// TODO Auto-generated method stub
		shareMapper.insertShareApply(apply);
	}

	@Override
	public Apply getApply(String shareParkingCode, String applierCode) {
		
		System.out.println("dao들어온값 " + shareParkingCode + "  "  + applierCode );
		
		Apply apply = new Apply();
		apply = shareMapper.getApply(shareParkingCode, applierCode);
		System.out.println("dao결과 " + apply.getShareParkingCode() + "  " + apply.getApplierCode() );
		return apply;
	}

	//
	@Override
	public List<ShareParking> getShareParkingListByWriter(String writer_id) {
		return shareMapper.getShareParkingListByWriter(writer_id);
	}
}
