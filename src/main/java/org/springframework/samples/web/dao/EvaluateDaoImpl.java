package org.springframework.samples.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.dao.mapper.EvaluateMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EvaluateDaoImpl implements EvaluateDao{

	@Autowired EvaluateMapper evaluateMapper;
	
	@Override
	public void updateAvgCount(String id) {
		evaluateMapper.updateAvgCount(id);
	}

	@Override
	public void updateLikeCount(String id) {
		evaluateMapper.updateLikeCount(id);
	}

	@Override
	public void cancelLikeCount(String id) {
		evaluateMapper.cancelLikeCount(id);
	}
	
	@Override
	public void updateDislikeCount(String id) {
		evaluateMapper.updateDislikeCount(id);
	}

	@Override
	public void cancelDislikeCount(String id) {
		evaluateMapper.cancelDislikeCount(id);
	}

}
