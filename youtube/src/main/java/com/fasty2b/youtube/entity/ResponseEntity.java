package com.fasty2b.youtube.entity;

public class ResponseEntity<T> {
	private int code = 0;
	private String message = "";
	private T data;
	
	public ResponseEntity(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public ResponseEntity(int code, String message, T data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
