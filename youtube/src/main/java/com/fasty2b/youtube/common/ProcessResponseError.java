package com.fasty2b.youtube.common;

import java.io.Serializable;

public class ProcessResponseError implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/** The error code. */
	private int errorCode;
	
	/** The message. */
	private String message;
	
	
	public ProcessResponseError() {		
	}

	/**
	 * Instantiates a new process response error.
	 *
	 * @param errorCode the error code
	 * @param message the message
	 */
	public ProcessResponseError(int errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}



	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public int getErrorCode() {
		return errorCode;
	}	

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}



	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}



	public void setMessage(String message) {
		this.message = message;
	}

}
