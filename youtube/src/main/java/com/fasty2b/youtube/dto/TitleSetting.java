package com.fasty2b.youtube.dto;

import java.io.Serializable;

public class TitleSetting implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	// Tu dong them tu khoa ngau nhien vao cuoi tieu de PLL
	private Boolean isAddRandomKeyWord;
	
	// tu dong them so ngau nhien vao cuoi tieu de
	private Boolean isAddRandomNumber;
	
	private int number;
	
	// chinh tieu de chong die cho moi tu khoa
	private Boolean  isNeverDie;
	
	private String concatKeyword;
	
	
	public TitleSetting() {
		// TODO Auto-generated constructor stub
	}


	public Boolean getIsAddRandomKeyWord() {
		return isAddRandomKeyWord;
	}


	public void setIsAddRandomKeyWord(Boolean isAddRandomKeyWord) {
		this.isAddRandomKeyWord = isAddRandomKeyWord;
	}


	public Boolean getIsAddRandomNumber() {
		return isAddRandomNumber;
	}


	public void setIsAddRandomNumber(Boolean isAddRandomNumber) {
		this.isAddRandomNumber = isAddRandomNumber;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public Boolean getIsNeverDie() {
		return isNeverDie;
	}


	public void setIsNeverDie(Boolean isNeverDie) {
		this.isNeverDie = isNeverDie;
	}


	public String getConcatKeyword() {
		return concatKeyword;
	}


	public void setConcatKeyword(String concatKeyword) {
		this.concatKeyword = concatKeyword;
	}


	@Override
	public String toString() {
		return "TitleSetting [isAddRandomKeyWord=" + isAddRandomKeyWord + ", isAddRandomNumber=" + isAddRandomNumber
				+ ", number=" + number + ", isNeverDie=" + isNeverDie + ", concatKeyword=" + concatKeyword + "]";
	}


	
	
	
	
	
	
	
	

}
