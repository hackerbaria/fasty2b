package com.fasty2b.youtube.dto;

import java.io.Serializable;;

public class SinglePlayListInfoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String chanel;
	
	private SearchVideoSetting searchVideoSetting;
	
	private TitleSetting titleSetting;
	
	private DescriptionSetting descriptionSetting;
	
	private GeneralSetting generalSetting;	
	
	private InsertVideoSetting insertVideoSetting;
	
	
	public SinglePlayListInfoDTO() {
		//super();
	}
	
	


	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getChanel() {
		return chanel;
	}




	public void setChanel(String chanel) {
		this.chanel = chanel;
	}




	public SearchVideoSetting getSearchVideoSetting() {
		return searchVideoSetting;
	}




	public void setSearchVideoSetting(SearchVideoSetting searchVideoSetting) {
		this.searchVideoSetting = searchVideoSetting;
	}




	public TitleSetting getTitleSetting() {
		return titleSetting;
	}




	public void setTitleSetting(TitleSetting titleSetting) {
		this.titleSetting = titleSetting;
	}




	public DescriptionSetting getDescriptionSetting() {
		return descriptionSetting;
	}




	public void setDescriptionSetting(DescriptionSetting descriptionSetting) {
		this.descriptionSetting = descriptionSetting;
	}




	public GeneralSetting getGeneralSetting() {
		return generalSetting;
	}




	public void setGeneralSetting(GeneralSetting generalSetting) {
		this.generalSetting = generalSetting;
	}




	public InsertVideoSetting getInsertVideoSetting() {
		return insertVideoSetting;
	}




	public void setInsertVideoSetting(InsertVideoSetting insertVideoSetting) {
		this.insertVideoSetting = insertVideoSetting;
	}




	@Override
	public String toString() {
		return "SinglePlayListInfoEntity [id=" + id + ", name=" + name + ", chanel=" + chanel + ", searchVideoSetting="
				+ searchVideoSetting + ", titleSetting=" + titleSetting + ", descriptionSetting=" + descriptionSetting
				+ ", generalSetting=" + generalSetting + ", insertVideoSetting=" + insertVideoSetting + "]";
	}

	

	

	
	
	

	

	

	

	
	
	

	
	
	
	
	
}
