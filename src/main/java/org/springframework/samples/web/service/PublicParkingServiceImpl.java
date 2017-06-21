package org.springframework.samples.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.dao.PublicParkingDao;
import org.springframework.samples.web.domain.PublicParking;
import org.springframework.samples.web.domain.RatingHistory;
import org.springframework.stereotype.Service;

@Service
public class PublicParkingServiceImpl implements PublicParkingService {

	@Autowired
	private PublicParkingDao publicParkingDao;
	
	@Override
	public void insertPublicParking(PublicParking publicParking) {
		// TODO Auto-generated method stub
		publicParkingDao.insertPublicParking(publicParking);

	}
	
	@Override
	public String selectAddr(String addr) {
		// TODO Auto-generated method stub
		return publicParkingDao.selectAddr(addr);
	}

	@Override
	public String selectId(String id) {
		// TODO Auto-generated method stub
		return publicParkingDao.selectId(id);
	}

	@Override
	public double selectAvgRate(String id) {
		// TODO Auto-generated method stub
		return publicParkingDao.selectAvgRate(id);
	}

	@Override
	public void insertPublicRating(RatingHistory ratingHistory) {
		// TODO Auto-generated method stub
		publicParkingDao.insertPublicRating(ratingHistory);
	}

}
