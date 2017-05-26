package org.springframework.samples.web.dao;

import java.sql.Time;
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
		// TODO Auto-generated method stub
		shareMapper.insertShareParking(shareParking);
		
	}

	@Override
	public ShareParkingCommand getShareParkingCommand(String share_parking_code) {
		// TODO Auto-generated method stub
		ShareParkingCommand info = new ShareParkingCommand();
		info = shareMapper.getShareParkingCommand(share_parking_code);
		return info;
	}

	@Override
	public List<Apply> getApplyList(String share_parking_code) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}
}
