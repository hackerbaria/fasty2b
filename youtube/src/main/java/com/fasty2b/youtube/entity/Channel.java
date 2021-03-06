package com.fasty2b.youtube.entity;
// Generated May 20, 2018 2:51:41 PM by Hibernate Tools 5.2.8.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Channel generated by hbm2java
 */
@Entity
@Table(name = "channel", catalog = "youtube_db")
public class Channel implements java.io.Serializable {

	private Integer id;
	private User user;
	private String channelId;
	private String channelName;

	public Channel() {
	}

	public Channel(String channelId) {
		this.channelId = channelId;
	}

	public Channel(User user, String channelId, String channelName) {
		this.user = user;
		this.channelId = channelId;
		this.channelName = channelName;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "CHANNEL_ID", nullable = false, length = 45)
	public String getChannelId() {
		return this.channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	@Column(name = "CHANNEL_NAME", length = 200)
	public String getChannelName() {
		return this.channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

}
