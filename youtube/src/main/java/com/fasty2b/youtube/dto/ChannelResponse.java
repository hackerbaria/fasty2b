package com.fasty2b.youtube.dto;

import java.io.Serializable;


import com.google.api.services.youtube.model.PageInfo;

public class ChannelResponse implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private java.lang.String kind;

	private java.lang.String etag;

	private PageInfo pageInfo;

	private java.util.List<Channel> items;
	
	public ChannelResponse() {
		
	}

	public java.lang.String getKind() {
		return kind;
	}

	public void setKind(java.lang.String kind) {
		this.kind = kind;
	}

	public java.lang.String getEtag() {
		return etag;
	}

	public void setEtag(java.lang.String etag) {
		this.etag = etag;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public java.util.List<Channel> getItems() {
		return items;
	}

	public void setItems(java.util.List<Channel> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "ChannelResponse [kind=" + kind + ", etag=" + etag + ", pageInfo=" + pageInfo + ", items=" + items + "]";
	}
	
	
	
	

}
