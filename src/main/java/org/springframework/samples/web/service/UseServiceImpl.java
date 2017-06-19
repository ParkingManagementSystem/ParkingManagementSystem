package org.springframework.samples.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.dao.UseDao;
import org.springframework.samples.web.domain.Use;
import org.springframework.stereotype.Service;

@Service
public class UseServiceImpl implements UseService {

	@Autowired UseDao useDao;
	
	@Override
	public List<Use> showUseList(String id) {
		return useDao.getUseList(id);
	}
}
