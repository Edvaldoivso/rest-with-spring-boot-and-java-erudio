package br.com.erudio.exeptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = -8856548213378448589L;

	private Date timestimp;
	private String message;
	private String details;

	public ExceptionResponse(Date timestimp, String message, String details) {

		this.timestimp = timestimp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestimp() {
		return timestimp;
	}

	public void setTimestimp(Date timestimp) {
		this.timestimp = timestimp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
}
