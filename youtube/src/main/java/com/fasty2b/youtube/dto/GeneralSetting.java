package com.fasty2b.youtube.dto;

import java.io.Serializable;

public class GeneralSetting implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String privacy;
	
	private String language;
	
	private int maxPlaylistNumberPerChannel;
	
	private Boolean useAllKeyword;
	
	private Boolean skipSensitiveKeyword;
	
	
	private Boolean autoChangeChannel;
	
	
	public GeneralSetting() {
		// TODO Auto-generated constructor stub
	}


	public String getPrivacy() {
		return privacy;
	}


	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public int getMaxPlaylistNumberPerChannel() {
		return maxPlaylistNumberPerChannel;
	}


	public void setMaxPlaylistNumberPerChannel(int maxPlaylistNumberPerChannel) {
		this.maxPlaylistNumberPerChannel = maxPlaylistNumberPerChannel;
	}


	public Boolean getUseAllKeyword() {
		return useAllKeyword;
	}


	public void setUseAllKeyword(Boolean useAllKeyword) {
		this.useAllKeyword = useAllKeyword;
	}


	public Boolean getSkipSensitiveKeyword() {
		return skipSensitiveKeyword;
	}


	public void setSkipSensitiveKeyword(Boolean skipSensitiveKeyword) {
		this.skipSensitiveKeyword = skipSensitiveKeyword;
	}


	public Boolean getAutoChangeChannel() {
		return autoChangeChannel;
	}


	public void setAutoChangeChannel(Boolean autoChangeChannel) {
		this.autoChangeChannel = autoChangeChannel;
	}


	@Override
	public String toString() {
		return "GeneralSetting [privacy=" + privacy + ", language=" + language + ", maxPlaylistNumberPerChannel="
				+ maxPlaylistNumberPerChannel + ", useAllKeyword=" + useAllKeyword + ", skipSensitiveKeyword="
				+ skipSensitiveKeyword + ", autoChangeChannel=" + autoChangeChannel + "]";
	}
	
	
	
	

}
