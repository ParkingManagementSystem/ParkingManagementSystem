package org.springframework.samples.web.domain;

import java.util.Date;

public class Reply {

	private String replyCode;
	private String shareParkingCode;
	private String postWriterId;
	private String ReplyWriterId;
	private String content;
	private Date startedAt;
	private boolean secret;
	
	public Reply(){}

	public Reply(String replyCode, String shareParkingCode, String postWriterId, String replyWriterId, String content,
			Date startedAt, boolean secret) {
		super();
		this.replyCode = replyCode;
		this.shareParkingCode = shareParkingCode;
		this.postWriterId = postWriterId;
		ReplyWriterId = replyWriterId;
		this.content = content;
		this.startedAt = startedAt;
		this.secret = secret;
	}

	public String getReplyCode() {
		return replyCode;
	}

	public void setReplyCode(String replyCode) {
		this.replyCode = replyCode;
	}

	public String getShareParkingCode() {
		return shareParkingCode;
	}

	public void setShareParkingCode(String shareParkingCode) {
		this.shareParkingCode = shareParkingCode;
	}

	public String getPostWriterId() {
		return postWriterId;
	}

	public void setPostWriterId(String postWriterId) {
		this.postWriterId = postWriterId;
	}

	public String getReplyWriterId() {
		return ReplyWriterId;
	}

	public void setReplyWriterId(String replyWriterId) {
		ReplyWriterId = replyWriterId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(Date startedAt) {
		this.startedAt = startedAt;
	}

	public boolean isSecret() {
		return secret;
	}

	public void setSecret(boolean secret) {
		this.secret = secret;
	}
}
