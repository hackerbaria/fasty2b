package com.fasty2b.youtube.dto;

import java.io.Serializable;

public class DescriptionSetting implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	// Tu Dong them vai tieu de video tim thay vao mo ta
	private Boolean isAddRandomVideoTitle;
	
	// Tu Dong them mo ta PLL
	private Boolean isAutoAddDescription;
	
	
	// nhap mo ta PLL thu cong
	private String description;
	
	public DescriptionSetting() {		
	}

	public Boolean getIsAddRandomVideoTitle() {
		return isAddRandomVideoTitle;
	}

	public void setIsAddRandomVideoTitle(Boolean isAddRandomVideoTitle) {
		this.isAddRandomVideoTitle = isAddRandomVideoTitle;
	}

	public Boolean getIsAutoAddDescription() {
		return isAutoAddDescription;
	}

	public void setIsAutoAddDescription(Boolean isAutoAddDescription) {
		this.isAutoAddDescription = isAutoAddDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "DescriptionSetting [isAddRandomVideoTitle=" + isAddRandomVideoTitle + ", isAutoAddDescription="
				+ isAutoAddDescription + ", description=" + description + "]";
	}

	
	
	
	
	
	
	

}
