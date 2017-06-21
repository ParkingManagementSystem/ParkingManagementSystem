package org.springframework.samples.web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.web.dao.mapper.UseMapper;
import org.springframework.samples.web.domain.Use;
import org.springframework.stereotype.Repository;

@Repository
public class UseDaoImpl implements UseDao {

	@Autowired
	UseMapper useMapper;
	
	@Override
	public List<Use> getUseList(String id) throws DataAccessException {
		return useMapper.selectUseList(id);
	}

	@Override
	public int getShareParkingRating(String useCode) throws DataAccessException {
		return useMapper.getShareParkingRating(useCode);
	}
	
	@Override
	public void likeShareParking(String useCode) throws DataAccessException {
		useMapper.likeShareParking(useCode);
	}

	@Override
	public void dislikeShareParking(String useCode) throws DataAccessException {
		useMapper.dislikeShareParking(useCode);
	}

	@Override
	public void cancelLikeShareParking(String useCode) throws DataAccessException {
		useMapper.cancelLikeShareParking(useCode);
	}

	@Override
	public void insertShareUse(Use use) {
		useMapper.insertShareUse(use);
		
	}

	@Override
	public void insertPublicParkingRating(Use use) throws DataAccessException {
		// TODO Auto-generated method stub
		useMapper.insertPublicParkingRating(use);
	}

	

}
