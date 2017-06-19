package org.springframework.samples.web.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.web.domain.Use;

public interface UseDao {
	public List<Use> getUseList(String id) throws DataAccessException;
	
	public void likeShareParking(String parkingCode) throws DataAccessException;
	
	public void dislikeShareParking(String parkingCode) throws DataAccessException;
}
