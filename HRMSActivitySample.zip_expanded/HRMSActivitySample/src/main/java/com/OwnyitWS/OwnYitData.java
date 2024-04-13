package com.OwnyitWS;

public class OwnYitData {
	
	private int status = 1;
	
	private int error_code = 0;
	
	private long response_time = 0;
	
	private String error_msg = "NA";
	
	private String data = null;
	
	public OwnYitData(){}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getErrorCode() {
		return this.error_code;
	}

	public void setErrorCode(int error_code) {
		this.error_code = error_code;
	}

	public String getErrorMsg() {
		return this.error_msg;
	}

	public void setErrorMsg(String error_msg) {
		this.error_msg = error_msg;
	}

	public String getData() {
		return data;
	}

	public void setData(int value) {
		this.data = String.valueOf(value);
	}
	
	public void setData(long value) {
		this.data = String.valueOf(value);
	}
	
	public void setData(String data) {
		this.data = data;
	}

	public long getResponseTime() {
		return this.response_time;
	}

	public void setResponseTime(long response_time) {
		this.response_time = response_time;
	}
	
	
}

