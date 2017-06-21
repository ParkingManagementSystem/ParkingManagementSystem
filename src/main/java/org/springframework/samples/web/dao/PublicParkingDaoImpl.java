package org.springframework.samples.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.web.dao.mapper.PublicParkingMapper;
import org.springframework.samples.web.domain.PublicParking;
import org.springframework.samples.web.domain.RatingHistory;
import org.springframework.stereotype.Repository;

@Repository
public class PublicParkingDaoImpl implements PublicParkingDao {

	@Autowired
	private PublicParkingMapper publicParkingMapper;
	
	@Override
	public void insertPublicParking(PublicParking publicParking) throws DataAccessException {
		// TODO Auto-generated method stub
		publicParkingMapper.insertPublicParking(publicParking);

	}
	
	@Override
	public String selectAddr(String addr) throws DataAccessException {
		return publicParkingMapper.selectAddr(addr);
	}
	
	@Override
	public String selectId(String id) throws DataAccessException {
		return publicParkingMapper.selectId(id);
	}

	@Override
	public double selectAvgRate(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		return publicParkingMapper.selectAvgRate(id);
	}

	@Override
	public void insertPublicRating(RatingHistory ratingHistory) throws DataAccessException {
		// TODO Auto-generated method stub
		publicParkingMapper.insertPublicRating(ratingHistory);
	}

}
