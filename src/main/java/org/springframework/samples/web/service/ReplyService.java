package org.springframework.samples.web.service;

import java.util.ArrayList;

import org.springframework.samples.web.domain.Reply;

public interface ReplyService {
	
	public void insertReply(Reply reply);

	public ArrayList<Reply> publicListReply(String code);
	
	public String selectReplyCount(String code);
	
	public void deleteReply(String code);

}
