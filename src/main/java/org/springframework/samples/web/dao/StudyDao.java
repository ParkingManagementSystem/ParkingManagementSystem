package org.springframework.samples.web.dao;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.dao.mapper.ImageMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StudyDao {
	@Autowired
	private ImageMapper imageMapper;
	
	public void saveImage(Map<String, Object> hmap) throws SQLException {
		imageMapper.saveImage(hmap);
	}
}
