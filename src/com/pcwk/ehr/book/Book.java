package com.pcwk.ehr.book;

import com.pcwk.ehr.cmn.DTO;

public class Book extends DTO {
    private String title;
    private String author;
    private boolean isAvailable;

    

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

	public Book(String title, String author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Book [Á¦¸ñ=" + title + ", author=" + author + ", isAvailable=" + isAvailable + "]";
    }
}