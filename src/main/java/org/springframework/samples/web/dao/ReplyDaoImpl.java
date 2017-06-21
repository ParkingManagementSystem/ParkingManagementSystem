package org.springframework.samples.web.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.web.dao.mapper.ReplyMapper;
import org.springframework.samples.web.domain.Reply;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDaoImpl implements ReplyDao {

	@Autowired
	private ReplyMapper replyMapper;
	
	@Override
	public void insertReply(Reply reply) throws DataAccessException {
		// TODO Auto-generated method stub
		replyMapper.insertReply(reply);
	}

	@Override
	public ArrayList<Reply> PublicListReply(String code) throws DataAccessException {
		// TODO Auto-generated method stub
		return replyMapper.PublicListReply(code);
	}

	@Override
	public String selectReplyCount(String code) throws DataAccessException {
		// TODO Auto-generated method stub
		return replyMapper.selectReplyCount(code);
	}

	@Override
	public void deleteReply(String code) throws DataAccessException {
		// TODO Auto-generated method stub
		replyMapper.deleteReply(code);
	}




}
