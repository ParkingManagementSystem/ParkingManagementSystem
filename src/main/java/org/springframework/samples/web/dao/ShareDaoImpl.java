package org.springframework.samples.web.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.command.ApplyCommand;
import org.springframework.samples.web.command.ShareParkingCommand;
import org.springframework.samples.web.dao.mapper.ShareMapper;
import org.springframework.samples.web.domain.Apply;
import org.springframework.samples.web.domain.Reply;
import org.springframework.samples.web.domain.ShareParking;
import org.springframework.samples.web.domain.Time;
import org.springframework.stereotype.Repository;

@Repository
public class ShareDaoImpl implements ShareDao{

	@Autowired
	private ShareMapper shareMapper;

	@Override
	public void insertShareParking(ShareParking shareParking) {
		
		System.out.println("dao" + shareParking.getImage());
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
		// TODO 이미 저장한 정보 있으면 안넣을거야 
		Apply test = new Apply();
		test = shareMapper.getApply(apply.getShareParkingCode(), apply.getApplierCode());
		if(test == null)
			shareMapper.insertShareApply(apply);
	}

	@Override
	public Apply getApply(String shareParkingCode, String applierCode) {
				
		Apply apply = new Apply();
		apply = shareMapper.getApply(shareParkingCode, applierCode);
		
		if(apply.getApplyCode().length()>2)
			return apply;
		else
			return null;
	}

	@Override
	public void insertShareTime(Time time) {
		
		shareMapper.insertShareTime(time);
		
	}

	@Override
	public List<ApplyCommand> getApplyCommandList(String shareParkingCode) {
		
		List<ApplyCommand> applyCommandList = new ArrayList<ApplyCommand>();
		applyCommandList = shareMapper.getApplyCommandList(shareParkingCode);
		return applyCommandList;
	}

	@Override
	public int isEvaluate(String id) {
		
		int isIn = shareMapper.isEvaluate(id);
		
		return isIn;
	}

	@Override
	public void insertEvaluate(String id) {
		
		shareMapper.insertEvaluate(id);
		
	}

	@Override
	public void updateApply(String applyCode) {
		
		shareMapper.updateApply(applyCode);
	}

	@Override
	public int isAccepted(String code, String id) {
		
		int n = shareMapper.isAccepted(code, id);
		return n;
	}
	
	//
	@Override
	public List<ShareParking> getShareParkingListByWriter(String writer_id) {
		return shareMapper.getShareParkingListByWriter(writer_id);
	}

	@Override
	public String getShareParkingCode() {
		return shareMapper.getShareParkingCode();
	}

	@Override
	public void saveImage(Map<String, Object> hmap) {
		shareMapper.saveImage(hmap);
	}

	@Override
	public int isApplied(String code, String id) {
		
		int n = shareMapper.isApplied(code, id);
		return n;
	}
	
}
