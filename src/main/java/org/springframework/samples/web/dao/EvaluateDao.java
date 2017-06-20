package org.springframework.samples.web.dao;

public interface EvaluateDao {
	public void updateAvgCount(String id);
	
	public void updateLikeCount(String id);
	
	public void cancelLikeCount(String id);
	
	public void updateDislikeCount(String id);
	
	public void cancelDislikeCount(String id);
}
