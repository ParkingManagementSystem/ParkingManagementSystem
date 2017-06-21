package org.springframework.samples.web.command;

import org.springframework.samples.web.domain.Time;

public class ApplyCommand {

	private String applyCode;
	private String shareParkingCode;
	private int approval;
	private String applierCode;
	private String writerCode;
	private Time time;
	
	
	public ApplyCommand(String applyCode, String shareParkingCode, int approval, String applierCode, String writerCode,
			Time time) {
		super();
		this.applyCode = applyCode;
		this.shareParkingCode = shareParkingCode;
		this.approval = approval;
		this.applierCode = applierCode;
		this.writerCode = writerCode;
		this.time = time;
	}
	
	public ApplyCommand(){
		
	}
	
	public String getApplyCode() {
		return applyCode;
	}
	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}
	public String getShareParkingCode() {
		return shareParkingCode;
	}
	public void setShareParkingCode(String shareParkingCode) {
		this.shareParkingCode = shareParkingCode;
	}
	public int getApproval() {
		return approval;
	}
	public void setApproval(int approval) {
		this.approval = approval;
	}
	public String getApplierCode() {
		return applierCode;
	}
	public void setApplierCode(String applierCode) {
		this.applierCode = applierCode;
	}
	public String getWriterCode() {
		return writerCode;
	}
	public void setWriterCode(String writerCode) {
		this.writerCode = writerCode;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	
	
}
