package com.fasty2b.youtube.dto;

import java.io.Serializable;

public class SearchVideoSetting implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int minResults;
	
	private int maxResults;
	
	private String order;
	
	private int publishedAfter;
	
	private String videoDuration;	
	
	private String videoDefinition;
	
	private String eventType;
	
	private String videoType;
	
	public SearchVideoSetting() {
		// TODO Auto-generated constructor stub
	}

	public int getMinResults() {
		return minResults;
	}

	public void setMinResults(int minResults) {
		this.minResults = minResults;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	

	

	public int getPublishedAfter() {
		return publishedAfter;
	}

	public void setPublishedAfter(int publishedAfter) {
		this.publishedAfter = publishedAfter;
	}

	public String getVideoDuration() {
		return videoDuration;
	}

	public void setVideoDuration(String videoDuration) {
		this.videoDuration = videoDuration;
	}

	public String getVideoDefinition() {
		return videoDefinition;
	}

	public void setVideoDefinition(String videoDefinition) {
		this.videoDefinition = videoDefinition;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getVideoType() {
		return videoType;
	}

	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}

	@Override
	public String toString() {
		return "SearchVideoSetting [minResults=" + minResults + ", maxResults=" + maxResults + ", order=" + order
				+ ", publishedAfter=" + publishedAfter + ", videoDuration=" + videoDuration + ", videoDefinition="
				+ videoDefinition + ", eventType=" + eventType + ", videoType=" + videoType + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	

}
