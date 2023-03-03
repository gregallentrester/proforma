package net.greg.examples.salient.proforma.exception;

import java.util.Date;


public class ErrorDetails {

	private Date timestamp;
	private String message;
	private String details;


	public ErrorDetails(Date tstamp, String msg, String det) {

		super();

		timestamp = tstamp;
		message = msg;
		details = det;
	}

	public Date getTimestamp() { return timestamp; }
	public String getMessage() { return message; }
	public String getDetails() { return details; }
}
