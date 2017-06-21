package org.springframework.samples.web.domain;

public class Rating {

	String startday;
	String endday;
	int starttimeHour;
	int starttimeMin;
	int endtimeHour;
	int endtimeMin;
	String chk_info;
	int star;
	String title;
	String code;
	int payment;
	
	public int getStarttimeMin() {
		return starttimeMin;
	}
	public void setStarttimeMin(int starttimeMin) {
		this.starttimeMin = starttimeMin;
	}
	public int getEndtimeMin() {
		return endtimeMin;
	}
	public void setEndtimeMin(int endtimeMin) {
		this.endtimeMin = endtimeMin;
	}
	
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStartday() {
		return startday;
	}
	public void setStartday(String startday) {
		this.startday = startday;
	}
	public String getEndday() {
		return endday;
	}
	public void setEndday(String endday) {
		this.endday = endday;
	}
	public int getStarttimeHour() {
		return starttimeHour;
	}
	public void setStarttimeHour(int starttimeHour) {
		this.starttimeHour = starttimeHour;
	}
	public int getEndtimeHour() {
		return endtimeHour;
	}
	public void setEndtimeHour(int endtimeHour) {
		this.endtimeHour = endtimeHour;
	}
	public String getChk_info() {
		return chk_info;
	}
	public void setChk_info(String chk_info) {
		this.chk_info = chk_info;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
}