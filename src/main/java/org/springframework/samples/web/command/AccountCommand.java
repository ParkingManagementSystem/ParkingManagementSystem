package org.springframework.samples.web.command;

import java.util.Date;

import org.springframework.samples.web.domain.Account;

public class AccountCommand {
	private String id;
	private String pwd;
	private String name;
	private String gender;
	private String phone;
	private Date birthday;
	public AccountCommand() {
		
	}
	public AccountCommand(Account account) {
		this.id = account.getId();
		this.pwd = account.getPwd();
		this.name = account.getName();
		this.gender = account.getGender();
		this.phone = account.getPhone();
		this.birthday = account.getBirthday();
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "AccountCommand [id=" + id + ", pwd=" + pwd + ", name=" + name + ", gender=" + gender + ", phone="
				+ phone + ", birthday=" + birthday + "]";
	}
	
	
}
