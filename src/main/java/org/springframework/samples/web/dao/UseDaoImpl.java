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
	public void likeShareParking(String parkingCode) throws DataAccessException {
		useMapper.likeShareParking(parkingCode);
	}

	@Override
	public void dislikeShareParking(String parkingCode) throws DataAccessException {
		useMapper.dislikeShareParking(parkingCode);
	}

}
