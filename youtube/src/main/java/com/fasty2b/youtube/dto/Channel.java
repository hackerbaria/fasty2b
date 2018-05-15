package com.fasty2b.youtube.dto;

import java.io.Serializable;

public class Channel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private Snippet snippet;
	
	public Channel() {		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Snippet getSnippet() {
		return snippet;
	}

	public void setSnippet(Snippet snippet) {
		this.snippet = snippet;
	}

	@Override
	public String toString() {
		return "Channel [id=" + id + ", snippet=" + snippet + "]";
	}

	
	

}
