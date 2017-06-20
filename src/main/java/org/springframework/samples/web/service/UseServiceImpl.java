package org.springframework.samples.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.dao.EvaluateDao;
import org.springframework.samples.web.dao.UseDao;
import org.springframework.samples.web.domain.Use;
import org.springframework.stereotype.Service;

@Service
public class UseServiceImpl implements UseService {

	@Autowired UseDao useDao;
	@Autowired EvaluateDao evaluateDao;
	
	@Override
	public List<Use> showUseList(String id) {
		return useDao.getUseList(id);
	}
	
	@Override
	public void likeShareParking(String useCode, String lender) {
		if(useDao.getShareParkingRating(useCode) == 1) {
			useDao.cancelLikeShareParking(useCode);
			evaluateDao.cancelLikeCount(lender);
			return;
		}
		if(useDao.getShareParkingRating(useCode) == -1) {
			evaluateDao.cancelDislikeCount(lender);
		}
		useDao.likeShareParking(useCode);
		evaluateDao.updateLikeCount(lender);
		System.out.println(useDao.getShareParkingRating(useCode) + lender);
	}

//	@Transactional
	@Override
	public void dislikeShareParking(String useCode, String lender) {
		if(useDao.getShareParkingRating(useCode) == -1) { //비추천 했을 경우. 또 비추천을 누르면
			useDao.cancelLikeShareParking(useCode);
			evaluateDao.cancelDislikeCount(lender);
			return ;
		}
		if(useDao.getShareParkingRating(useCode) == 1) {
			evaluateDao.cancelLikeCount(lender);
		}
		useDao.dislikeShareParking(useCode);
		evaluateDao.updateDislikeCount(lender);
		System.out.println(useDao.getShareParkingRating(useCode) + lender);
	}

}
