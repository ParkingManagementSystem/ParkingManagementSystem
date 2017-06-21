package org.springframework.samples.web.domain;

public class Reply {

	private String replyCode;
	private String content;
	private String time;
	private int secret;
	private String postwriterid;
	private String replywriterid;
	private String shareParkingCode;
	private String publicParkingCode;
	private String count;
	
	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public Reply() {}
	
	public Reply(String replyCode, String content, String time, int secret, String postwriterid, String replywriterid,
			String shareParkingCode, String publicParkingCode) {
		super();
		this.replyCode = replyCode;
		this.content = content;
		this.time = time;
		this.secret = secret;
		this.postwriterid = postwriterid;
		this.replywriterid = replywriterid;
		this.shareParkingCode = shareParkingCode;
		this.publicParkingCode = publicParkingCode;
	}
	
	public String getReplyCode() {
		return replyCode;
	}
	public void setReplyCode(String replyCode) {
		this.replyCode = replyCode;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getSecret() {
		return secret;
	}
	public void setSecret(int secret) {
		this.secret = secret;
	}
	public String getPostwriterid() {
		return postwriterid;
	}
	public void setPostwriterid(String postwriterid) {
		this.postwriterid = postwriterid;
	}
	public String getReplywriterid() {
		return replywriterid;
	}
	public void setReplywriterid(String replywriterid) {
		this.replywriterid = replywriterid;
	}
	public String getShareParkingCode() {
		return shareParkingCode;
	}
	public void setShareParkingCode(String shareParkingCode) {
		this.shareParkingCode = shareParkingCode;
	}
	public String getPublicParkingCode() {
		return publicParkingCode;
	}
	public void setPublicParkingCode(String publicParkingCode) {
		this.publicParkingCode = publicParkingCode;
	}
	
	}
