package org.springframework.samples.web.command;

public class PasswordCommand {
	private String id;
	private String pwd;
	private String pwdCurrent;
	private String pwdNew;
	private String pwdNewConfirm;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPwdCurrent() {
		return pwdCurrent;
	}
	public void setPwdCurrent(String pwdCurrent) {
		this.pwdCurrent = pwdCurrent;
	}
	public String getPwdNew() {
		return pwdNew;
	}
	public void setPwdNew(String pwdNew) {
		this.pwdNew = pwdNew;
	}
	public String getPwdNewConfirm() {
		return pwdNewConfirm;
	}
	public void setPwdNewConfirm(String pwdNewConfirm) {
		this.pwdNewConfirm = pwdNewConfirm;
	}
	
}
