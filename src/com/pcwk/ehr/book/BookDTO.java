package com.pcwk.ehr.book;

import com.pcwk.ehr.cmn.DTO;

public class BookDTO extends DTO {

	private String bookName; //å �̸�
	private String author;   //å ����
	
	public BookDTO() {}

	public BookDTO(String bookName, String author) {
		super();
		this.bookName = bookName;
		this.author = author;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "BookDTO [bookName=" + bookName + ", author=" + author + "]";
	}
}
