package com.fasty2b.youtube.dto;

import java.io.Serializable;

public class Snippet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private com.google.api.client.util.DateTime publishedAt;

	private java.lang.String title;

	private java.lang.String description;
	
	private String channelTitle;
	
	public Snippet() {
		// TODO Auto-generated constructor stub
	}

	public com.google.api.client.util.DateTime getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(com.google.api.client.util.DateTime publishedAt) {
		this.publishedAt = publishedAt;
	}

	public java.lang.String getTitle() {
		return title;
	}

	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	public String getChannelTitle() {
		return channelTitle;
	}

	public void setChannelTitle(String channelTitle) {
		this.channelTitle = channelTitle;
	}

	@Override
	public String toString() {
		return "Snippet [publishedAt=" + publishedAt + ", title=" + title + ", description=" + description
				+ ", channelTitle=" + channelTitle + "]";
	}

	
	

}
