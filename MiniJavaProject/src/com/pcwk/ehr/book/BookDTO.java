package com.pcwk.ehr.book;

public class BookDTO extends DTO {
	private String memberId;  //회원아이디
	private String name;	  //이름
	private String passwd;	  //비번
	private String email;	  //이메일
	private String cellphone; //핸드폰
	private String regDate;	  //등록일
	private String regId;	  //등록자ID
	private String bookName; //책 이름
	private String author;   //책 저자
	private String publisher;//출판사
	
	public BookDTO() {}

	public BookDTO(String bookName, String author, String publisher) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.memberId = memberId;
		this.name = name;
		this.passwd = passwd;
		this.email = email;
		this.cellphone = cellphone;
		this.regDate = regDate;
		this.regId = regId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "BookDTO [memberId=" + memberId + ", name=" + name + ", passwd=" + passwd + ", email=" + email
				+ ", cellphone=" + cellphone + ", regDate=" + regDate + ", regId=" + regId + ", bookName=" + bookName
				+ ", author=" + author + ", publisher=" + publisher + "]";
	}

	
	
	
}
