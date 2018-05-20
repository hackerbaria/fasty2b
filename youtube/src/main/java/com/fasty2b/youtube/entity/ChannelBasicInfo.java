package com.fasty2b.youtube.entity;
// Generated May 20, 2018 2:51:41 PM by Hibernate Tools 5.2.8.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ChannelBasicInfo generated by hbm2java
 */
@Entity
@Table(name = "channel_basic_info", catalog = "youtube_db")
public class ChannelBasicInfo implements java.io.Serializable {

	private String channelId;
	private User user;
	private String channelName;

	public ChannelBasicInfo() {
	}

	public ChannelBasicInfo(String channelId) {
		this.channelId = channelId;
	}

	public ChannelBasicInfo(String channelId, User user, String channelName) {
		this.channelId = channelId;
		this.user = user;
		this.channelName = channelName;
	}

	@Id

	@Column(name = "channel_id", unique = true, nullable = false, length = 45)
	public String getChannelId() {
		return this.channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "channel_name", length = 200)
	public String getChannelName() {
		return this.channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

}
