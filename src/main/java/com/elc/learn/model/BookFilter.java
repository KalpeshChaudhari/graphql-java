package com.elc.learn.model;

public class BookFilter {
	
	private String title_contains;
	private String isbn_contains;
	private int pageCount_equals;
	private String author_id;
	
	public String getTitle_contains() {
		return title_contains;
	}
	public void setTitle_contains(String title_contains) {
		this.title_contains = title_contains;
	}
	public String getIsbn_contains() {
		return isbn_contains;
	}
	public void setIsbn_contains(String isbn_contains) {
		this.isbn_contains = isbn_contains;
	}
	public int getPageCount_equals() {
		return pageCount_equals;
	}
	public void setPageCount_equals(int pageCount_equals) {
		this.pageCount_equals = pageCount_equals;
	}
	public String getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}
	
	
}
