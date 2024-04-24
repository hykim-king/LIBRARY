package com.pcwk.ehr.book;
import java.util.*;
public class Book {
	private String title;
	private String author;
	private boolean isAvailable;
	public Book(String title, String author, boolean isAvailable) {
		 this.title = title.isEmpty() ? "Unknown" : title;
		 this.author = author.isEmpty() ? "Unknown" : author;
		 this.isAvailable = isAvailable;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	@Override
	public String toString() {
	    return String.format("%s | %s | %s",
	                         title != null ? title : "unknown",
	                         author != null ? author : "unknown",
	                         isAvailable ? "대출 가능" : "대출 불가");
	}
	
	
}