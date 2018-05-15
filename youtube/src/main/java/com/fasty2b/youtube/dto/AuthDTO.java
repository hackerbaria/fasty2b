package com.fasty2b.youtube.dto;

import java.io.Serializable;

public class AuthDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String authCode;
	
	public AuthDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	
	
	

}
