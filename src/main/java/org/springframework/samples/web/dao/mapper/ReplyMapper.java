package org.springframework.samples.web.dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.samples.web.domain.Reply;

public interface ReplyMapper {
	
	@Insert("INSERT INTO REPLY (REPLYCODE, CONTENT, TIME, SECRET, REPLYWRITERID, PUBLIC_PARKING_CODE) VALUES (REPLY_SEQ.NEXTVAL, #{content}, #{time}, #{secret}, #{replywriterid}, #{publicParkingCode})")
	void insertReply(Reply reply);
	
	@Select("SELECT * FROM REPLY WHERE PUBLIC_PARKING_CODE=#{code} ORDER BY REPLYCODE")
	ArrayList<Reply> PublicListReply(String code);
	
	@Select("SELECT MAX(COUNT) FROM REPLY WHERE PUBLIC_PARKING_CODE=#{code}")
	String selectReplyCount(String code);
	
	@Delete("DELETE FROM REPLY WHERE REPLYCODE = #{code}")
	void deleteReply(String code);
	
}
