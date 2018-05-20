package com.fasty2b.youtube.dto;

import java.io.Serializable;
import java.util.List;

public class ChannelInfo implements Serializable {	
	
	private static final long serialVersionUID = 1L;

	private String channelId;
	
	private String channelTitle;
	
	private int playlistNumber;
	
	private List<PlayList> playList;
	
	public ChannelInfo() {		
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	

	public int getPlaylistNumber() {
		return playlistNumber;
	}

	public void setPlaylistNumber(int playlistNumber) {
		this.playlistNumber = playlistNumber;
	}

	public String getChannelTitle() {
		return channelTitle;
	}

	public void setChannelTitle(String channelTitle) {
		this.channelTitle = channelTitle;
	}

	public List<PlayList> getPlayList() {
		return playList;
	}

	public void setPlayList(List<PlayList> playList) {
		this.playList = playList;
	}
	
	

	
	
	
	
	
	
	
	

}
