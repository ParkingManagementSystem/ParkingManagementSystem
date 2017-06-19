package org.springframework.samples.web.service;

import java.util.List;

import org.springframework.samples.web.domain.Use;

public interface UseService {
	public List<Use> showUseList(String id);
	
}
