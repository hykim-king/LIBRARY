package com.pcwk.ehr.member;

import com.pcwk.ehr.cmn.DTO;

public class SearchDTO extends DTO {
	//검색조건
	//"  ":전체
	//10:이름
	//20:email
	//30:핸드폰
	
	private String searchDiv;//검색조건
	private String searchWord;//검색어
	
	public SearchDTO () {
		
	}

	public SearchDTO(String searchDiv, String searchWord) {
		super();
		this.searchDiv = searchDiv;
		this.searchWord = searchWord;
	}

	public String getSearchDiv() {
		return searchDiv;
	}

	public void setSearchDiv(String searchDiv) {
		this.searchDiv = searchDiv;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	@Override
	public String toString() {
		return "SearchDTO [searchDiv=" + searchDiv + ", searchWord=" + searchWord + "]";
	}
}
