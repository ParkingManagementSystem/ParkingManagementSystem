package org.springframework.samples.web.dao;

import java.util.ArrayList;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.web.domain.Reply;

public interface ReplyDao {
		
	// 댓글 저장
	public void insertReply(Reply reply)throws DataAccessException;
		
	// 댓글 조회
	public ArrayList<Reply> PublicListReply(String code)throws DataAccessException;
	
	//댓글 카운트
	public String selectReplyCount(String code)throws DataAccessException;
	
	//댓글 삭제
	public void deleteReply(String code)throws DataAccessException;
}
