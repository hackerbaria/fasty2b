package com.fasty2b.youtube.dto;

import java.io.Serializable;

public class AccessTokenInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String issued_to;
	
	private String audience;
	
	private String scope;
	
	private long expires_in;
	
	private String access_type;
	
	
	public AccessTokenInfo() {
		// TODO Auto-generated constructor stub
	}


	public String getIssued_to() {
		return issued_to;
	}


	public void setIssued_to(String issued_to) {
		this.issued_to = issued_to;
	}


	public String getAudience() {
		return audience;
	}


	public void setAudience(String audience) {
		this.audience = audience;
	}


	public String getScope() {
		return scope;
	}


	public void setScope(String scope) {
		this.scope = scope;
	}


	public long getExpires_in() {
		return expires_in;
	}


	public void setExpires_in(long expires_in) {
		this.expires_in = expires_in;
	}


	public String getAccess_type() {
		return access_type;
	}


	public void setAccess_type(String access_type) {
		this.access_type = access_type;
	}


	@Override
	public String toString() {
		return "AccessTokenInfo [issued_to=" + issued_to + ", audience=" + audience + ", scope=" + scope
				+ ", expires_in=" + expires_in + ", access_type=" + access_type + "]";
	}
	
	
	
	

}
