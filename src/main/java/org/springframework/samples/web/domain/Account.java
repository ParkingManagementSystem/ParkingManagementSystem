package org.springframework.samples.web.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.samples.web.command.AccountCommand;

public class Account {
	private String id;
	private String pwd;
	private String name;
	private String gender;
	private String phone;
	private Date birthday;
	int age;
	int blacklist;
	
	public Account() {
		
	}
	public Account(AccountCommand command) {
		this.id = command.getId();
		this.pwd = command.getPwd();
		this.name = command.getName();
		this.gender = command.getGender();
		this.phone = command.getPhone();
		this.birthday = command.getBirthday();
		Calendar birth = new GregorianCalendar();
		birth.setTime(command.getBirthday());
		this.age = Calendar.getInstance().get(Calendar.YEAR) - birth.get(Calendar.YEAR) + 1;
		this.blacklist = 0;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getBlacklist() {
		return blacklist;
	}
	public void setBlacklist(int blacklist) {
		this.blacklist = blacklist;
	}
	public void setCommand(AccountCommand command) {
		this.id = command.getId();
		this.pwd = command.getPwd();
		this.name = command.getName();
		this.gender = command.getGender();
		this.phone = command.getPhone();
		this.birthday = command.getBirthday();
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", pwd=" + pwd + ", name=" + name + ", gender=" + gender + ", phone=" + phone
				+ ", birthday=" + birthday + ", age=" + age + ", blacklist=" + blacklist + "]";
	}
	
}
