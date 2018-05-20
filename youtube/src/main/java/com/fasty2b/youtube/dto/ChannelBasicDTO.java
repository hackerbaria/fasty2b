package com.fasty2b.youtube.dto;

import java.io.Serializable;

public class ChannelBasicDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String channelId;
	
	private String channelTitle;
	
	public ChannelBasicDTO() {
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getChannelTitle() {
		return channelTitle;
	}

	public void setChannelTitle(String channelTitle) {
		this.channelTitle = channelTitle;
	}

	@Override
	public String toString() {
		return "ChannelBasicDTO [channelId=" + channelId + ", channelTitle=" + channelTitle + "]";
	}
	
	

}
