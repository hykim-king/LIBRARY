package com.pcwk.ehr.book;

import com.pcwk.ehr.cmn.DTO;

public class BookDTO extends DTO {

	private String bookName; //책 이름
	private String author;   //책 저자
	
	private String name;
    private String memberID;
    private String password;
    
    private String title;
    private boolean isAvailable;

    

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor1() {
		return author;
	}

	public void setAuthor1(String author) {
		this.author = author;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public BookDTO(String title, String author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public String toString11() {
        return "Book [제목=" + title + ", author=" + author + ", isAvailable=" + isAvailable + "]";
    }

    // 기본 생성자
    public BookDTO() {}

    // 생성자
    public BookDTO(String name, String memberID, String password) {
        this.name = name;
        this.memberID = memberID;
        this.password = password;
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
