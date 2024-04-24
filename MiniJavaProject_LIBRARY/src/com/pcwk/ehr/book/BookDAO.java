package com.pcwk.ehr.book;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pcwk.ehr.book.WorkDiv;

public class BookDAO implements WorkDiv<BookDTO>{
	
	private final String BOOK_URL = "https://search.daum.net/search?w=tot&DA=YZR&t__nil_searchbox=btn&q=%EB%8F%84%EC%84%9C";
	private final String FILE_NAME = "booklist.json";
	
	private List<BookDTO> list;
	@Override
	public List<BookDTO> doRetrieve(DTO list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int doSave(BookDTO param) {
		int flag = 0;
		
		 {
			
		}
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
		int count  = 0;
		//PrettyPrinting된 Json생성
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (FileWriter fw = new FileWriter(FILE_NAME)) {
			
			gson.toJson(list, fw);
			
			count = list.size();
			
		} catch (IOException e) {
			LOG.debug("IOException: "+ e.getMessage());
			count  = 0;
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int doReadFile() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
