package com.fasty2b.youtube.dto;

import java.io.Serializable;

public class AuthDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String authCode;
	
	private String userId;
	
	public AuthDTO() {		
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "AuthDTO [authCode=" + authCode + ", userId=" + userId + "]";
	}

	
	
	
	
	

}
