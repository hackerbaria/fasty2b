package com.fasty2b.youtube.entity;

import java.io.Serializable;

import com.google.api.client.util.DateTime;;

public class PlayListInfoEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String title;
	private String privacy;
	private String description;
	private DateTime postedTime;
	private String chanel;
	private int videoNumber;
	
	public PlayListInfoEntity() {
		//super();
	}

	public PlayListInfoEntity(String id, String title, String privacy, String description, DateTime postedTime,
			String chanel) {
		super();
		this.id = id;
		this.title = title;
		this.privacy = privacy;
		this.description = description;
		this.postedTime = postedTime;
		this.chanel = chanel;		
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

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DateTime getPostedTime() {
		return postedTime;
	}

	public void setPostedTime(DateTime postedTime) {
		this.postedTime = postedTime;
	}

	public String getChanel() {
		return chanel;
	}

	public void setChanel(String chanel) {
		this.chanel = chanel;
	}
	
	

	public int getVideoNumber() {
		return videoNumber;
	}

	public void setVideoNumber(int videoNumber) {
		this.videoNumber = videoNumber;
	}

	@Override
	public String toString() {
		return "PlayListInfoEntity [id=" + id + ", title=" + title + ", privacy=" + privacy + ", description="
				+ description + ", postedTime=" + postedTime + ", chanel=" + chanel + ", videoNumber=" + videoNumber
				+ "]";
	}

	
	

	
	
	
	
	
}
