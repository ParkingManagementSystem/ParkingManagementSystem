package org.springframework.samples.web.domain;

public class Apply {

	private String applyCode;
	private String shareParkingCode;
	private boolean approval;
	private String applierCode;
	private String writerCode;
	
	public Apply(){}
	
	public Apply(String applyCode, String shareParkingCode, boolean approval, String applierCode,
			String writerCode) {
		super();
		this.applyCode = applyCode;
		this.shareParkingCode = shareParkingCode;
		this.approval = approval;
		this.applierCode = applierCode;
		this.writerCode = writerCode;
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
	public boolean isApproval() {
		return approval;
	}
	public void setApproval(boolean approval) {
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
}
