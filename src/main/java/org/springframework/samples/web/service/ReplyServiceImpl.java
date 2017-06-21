package org.springframework.samples.web.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.dao.ReplyDao;
import org.springframework.samples.web.domain.Reply;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDao replyDao;
	
	@Override
	public void insertReply(Reply reply) {
		// TODO Auto-generated method stub
		replyDao.insertReply(reply);
	}

	@Override
	public ArrayList<Reply> publicListReply(String code) {
		// TODO Auto-generated method stub
		return replyDao.PublicListReply(code);
	}

	@Override
	public String selectReplyCount(String code) {
		// TODO Auto-generated method stub
		return replyDao.selectReplyCount(code);
	}

	@Override
	public void deleteReply(String code) {
		// TODO Auto-generated method stub
		replyDao.deleteReply(code);
	}

}
