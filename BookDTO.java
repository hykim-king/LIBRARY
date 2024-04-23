package com.pcwk.ehr.book;

public class BookDTO extends DTO {

	private String bookName; //책 이름
	private String author;   //책 저자
	private String publisher;//출판사
	
	public BookDTO() {}

	public BookDTO(String bookName, String author, String publisher) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "BookDTO [bookName=" + bookName + ", author=" + author + ", publisher=" + publisher + "]";
	}
	
	
	
}
