package com.pcwk.ehr.book;

import com.pcwk.ehr.cmn.DTO;

public class BookDTO extends DTO {

	private String bookName; //책 이름
	private String author;   //책 저자
	
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
