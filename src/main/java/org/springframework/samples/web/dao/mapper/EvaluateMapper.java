package org.springframework.samples.web.dao.mapper;

import org.apache.ibatis.annotations.Update;

public interface EvaluateMapper {
	// Update Average likeCount - hateCount
	@Update("UPDATE evaluate_history SET avgCount = likeCount - hateCount WHERE id = #{id}")
	void updateAvgCount(String id);

	// likeCount + 1
	@Update("UPDATE evaluate_history SET likeCount = likeCount + 1 WHERE id = #{id}")
	void updateLikeCount(String id);

	// likeCount - 1
	@Update("UPDATE evaluate_history SET likeCount = likeCount - 1 WHERE id = #{id}")
	void cancelLikeCount(String id);

	// hateCount + 1
	@Update("UPDATE evaluate_history set hateCount = hateCount + 1 WHERE id = #{id}")
	void updateDislikeCount(String id);

	// hateCount - 1
	@Update("UPDATE evaluate_history set hateCount = hateCount - 1 WHERE id = #{id}")
	void cancelDislikeCount(String id);
}
