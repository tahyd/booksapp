package com.e2e.bc.models;

public class ErrorModel {
	private String message;
	private String status;
	private String statusCode;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public ErrorModel(String message, String status, String statusCode) {
		super();
		this.message = message;
		this.status = status;
		this.statusCode = statusCode;
	}
	public ErrorModel() {
		super();
	}
	
	

}
