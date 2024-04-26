package com.pcwk.ehr.book;

import com.pcwk.ehr.cmn.DTO;

public class BookDTO extends DTO {

	private String bookName; //책 이름
	private String author;   //책 저자
	private boolean isAvailable; //책 대여 여부
	
	private String name;
    private String memberID;
    private String password;
    
    // 기본 생성자
    public BookDTO() {}

    // 회원 생성자
    public BookDTO(String name, String memberID, String password) {
        this.name = name;
        this.memberID = memberID;
        this.password = password;
    }

   
    public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberID;
    }

    public String getPassword() {
        return password;
    }

    // toString 메서드
    @Override
    public String toString() {
        return "LibMemDTO [name=" + name + ", memberID=" + memberID + ", password=" + password + "]";
    }

	

	public BookDTO(String bookName, String author) {
		super();
		this.bookName = bookName;
		this.author = author;
	}
	
	public BookDTO(String bookName, String author, boolean isAvailable) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.isAvailable = isAvailable;
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

	public String toString1() {
		return "BookDTO [bookName=" + bookName + ", author=" + author + "]";
	}
}