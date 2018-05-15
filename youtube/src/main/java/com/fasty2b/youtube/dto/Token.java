package com.fasty2b.youtube.dto;

import java.io.Serializable;

public class Token implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String accessToken;
	private String tokenType;
	private Long expiresInSeconds;
	private String refreshToken;
	
	
	

	public Token() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Token(String accessToken, String tokenType, Long expiresInSeconds, String refreshToken) {
		super();
		this.accessToken = accessToken;
		this.tokenType = tokenType;
		this.expiresInSeconds = expiresInSeconds;
		this.refreshToken = refreshToken;
	}



	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public Long getExpiresInSeconds() {
		return expiresInSeconds;
	}

	public void setExpiresInSeconds(Long expiresInSeconds) {
		this.expiresInSeconds = expiresInSeconds;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	@Override
	public String toString() {
		return "TokenResponse [accessToken=" + accessToken + ", tokenType=" + tokenType + ", expiresInSeconds="
				+ expiresInSeconds + ", refreshToken=" + refreshToken + "]";
	}

}
