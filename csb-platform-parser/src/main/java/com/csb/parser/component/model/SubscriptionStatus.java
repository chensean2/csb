package com.csb.parser.component.model;

public class SubscriptionStatus {
	//INPROGRESS,SUCCESS,FAILED
	private String status;
	
	private String externalAccountId;
	
	private String raw;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getExternalAccountId() {
		return externalAccountId;
	}

	public void setExternalAccountId(String externalAccountId) {
		this.externalAccountId = externalAccountId;
	}

	public String getRaw() {
		return raw;
	}

	public void setRaw(String raw) {
		this.raw = raw;
	}
	
	
}
