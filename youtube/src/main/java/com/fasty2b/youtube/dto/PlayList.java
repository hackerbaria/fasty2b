package com.fasty2b.youtube.dto;

import java.io.Serializable;

public class PlayList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String title;
	
	private String description;
	
	private com.google.api.client.util.DateTime publishedAt;
	
	private int videoNumber;
	
	
	public PlayList() {
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public com.google.api.client.util.DateTime getPublishedAt() {
		return publishedAt;
	}


	public void setPublishedAt(com.google.api.client.util.DateTime publishedAt) {
		this.publishedAt = publishedAt;
	}


	public int getVideoNumber() {
		return videoNumber;
	}


	public void setVideoNumber(int videoNumber) {
		this.videoNumber = videoNumber;
	}


	@Override
	public String toString() {
		return "PlayList [id=" + id + ", title=" + title + ", description=" + description + ", publishedAt="
				+ publishedAt + ", videoNumber=" + videoNumber + "]";
	}
	
	
	
	
	

}
