package com.pcwk.ehr.book;

import java.util.List;

import com.pcwk.ehr.cmn.PLog;

public class Main implements PLog{
	//test
	//test2
	BookDTO dto;

	
	BookDAO dao;
	
	public Main() {
		dto = new BookDTO();
		dao = new BookDAO();
		
		dao.setList(dao.readURL(dto));
		
	}
	
	public void dsp(List<BookDTO> list) {
		for(BookDTO dto :list) {
			System.out.println(dto);
		}
	}
	public static void main(String[] args) {

		Main m = new Main();
		
		List<BookDTO> list = m.dao.getList();
		m.dsp(list);
		System.out.println(m.dto.getBookName());
		m.dao.doSaveFile();
	}

}
