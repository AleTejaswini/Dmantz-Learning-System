package com.learningsystem.Dmantz.model;

import java.time.LocalDateTime;

public class ErrorResponse {

	private LocalDateTime timestamp;
	private String errormessage;
	private String errordetails;
	private String errorcode;

	public ErrorResponse(String errormessage, String errordetails, String errorcode) {
		super();
		this.timestamp = LocalDateTime.now();
		this.errordetails = errordetails;
		this.errormessage = errormessage;
		this.errorcode = errorcode;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getErrordetails() {
		return errordetails;
	}

	public String getErrormessage() {
		return errormessage;
	}

	public String getErrorcode() {
		return errorcode;
	}

}
