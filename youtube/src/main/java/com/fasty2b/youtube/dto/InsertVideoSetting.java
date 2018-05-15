package com.fasty2b.youtube.dto;

import java.io.Serializable;
import java.util.List;

public class InsertVideoSetting implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Boolean noInsertVideo;
	
	private Boolean yesInsertVideo;	
	
	private int videoNumber;
	
	private List<String> videos;	
	
	private Boolean autoChooseVideoID;
	
	private Boolean addPositionRandom;
	
	private Boolean insert1ID;
	
	public InsertVideoSetting() {
		// TODO Auto-generated constructor stub
	}

	public Boolean getNoInsertVideo() {
		return noInsertVideo;
	}

	public void setNoInsertVideo(Boolean noInsertVideo) {
		this.noInsertVideo = noInsertVideo;
	}

	public Boolean getYesInsertVideo() {
		return yesInsertVideo;
	}

	public void setYesInsertVideo(Boolean yesInsertVideo) {
		this.yesInsertVideo = yesInsertVideo;
	}

	public int getVideoNumber() {
		return videoNumber;
	}

	public void setVideoNumber(int videoNumber) {
		this.videoNumber = videoNumber;
	}

	public List<String> getVideos() {
		return videos;
	}

	public void setVideos(List<String> videos) {
		this.videos = videos;
	}

	public Boolean getAutoChooseVideoID() {
		return autoChooseVideoID;
	}

	public void setAutoChooseVideoID(Boolean autoChooseVideoID) {
		this.autoChooseVideoID = autoChooseVideoID;
	}

	public Boolean getAddPositionRandom() {
		return addPositionRandom;
	}

	public void setAddPositionRandom(Boolean addPositionRandom) {
		this.addPositionRandom = addPositionRandom;
	}

	public Boolean getInsert1ID() {
		return insert1ID;
	}

	public void setInsert1ID(Boolean insert1id) {
		insert1ID = insert1id;
	}

	@Override
	public String toString() {
		return "VideoInserting [noInsertVideo=" + noInsertVideo + ", yesInsertVideo=" + yesInsertVideo
				+ ", videoNumber=" + videoNumber + ", videos=" + videos + ", autoChooseVideoID=" + autoChooseVideoID
				+ ", addPositionRandom=" + addPositionRandom + ", insert1ID=" + insert1ID + "]";
	}
	
	
	
	
	
	

	
}
