package com.pcwk.ehr.book;

import java.util.List;

import com.pcwk.ehr.book.WorkDiv;

public class BookDAO implements WorkDiv<BookDTO>{
	
	private final String BOOK_URL = "https://search.daum.net/search?w=tot&DA=YZR&t__nil_searchbox=btn&q=%EB%8F%84%EC%84%9C";

	@Override
	public List<BookDTO> doRetrieve(DTO list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int doSave(BookDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doUpdate(BookDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doDelete(BookDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BookDTO doSelectOne(BookDTO param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int doRental(BookDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doReturn(BookDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doSaveFile() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doReadFile() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
