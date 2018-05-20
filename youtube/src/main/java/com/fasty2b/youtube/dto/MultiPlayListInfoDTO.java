package com.fasty2b.youtube.dto;

import java.io.Serializable;
import java.util.List;;

public class MultiPlayListInfoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private List<String> names;
	private String chanel;
	
	private SearchVideoSetting searchVideoSetting;
	
	private TitleSetting titleSetting;
	
	private DescriptionSetting descriptionSetting;
	
	private GeneralSetting generalSetting;	
	
	private InsertVideoSetting insertVideoSetting;
	
	
	public MultiPlayListInfoDTO() {
		//super();
	}

	public MultiPlayListInfoDTO(String id, List<String> names, 
			String chanel) {
		super();
		this.id = id;
		this.names = names;		
		this.chanel = chanel;		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
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
		return "MultiPlayListInfoEntity [id=" + id + ", names=" + names + ", chanel=" + chanel + ", searchVideoSetting="
				+ searchVideoSetting + ", titleSetting=" + titleSetting + ", descriptionSetting=" + descriptionSetting
				+ ", generalSetting=" + generalSetting + ", insertVideoSetting=" + insertVideoSetting + "]";
	}

	
	
	

	

	

	

	
	
	

	
	
	
	
	
}
