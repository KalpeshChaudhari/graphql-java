/* ***************************************************************************
 * Copyright 2018 Mindstix, Inc.  All rights reserved.
 * -- Mindstix Confidential
 * ***************************************************************************/

package com.elc.learn.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.elc.learn.model.Book;
import com.elc.learn.model.BookFilter;

public interface BookRepository extends MongoRepository<Book, String>{

	
	public default List<Book> getAllBooks(BookFilter filter, List<Book> books) {
		List<Book> bookss = new ArrayList<>();
		for (Book book : books) {
			if(book.getIsbn().equals(filter.getIsbn_contains()) || book.getPageCount() == filter.getPageCount_equals() || book.getTitle().equals(filter.getTitle_contains())) {
				bookss.add(book);
			}
		}
		return bookss;
	}
	
	public default List<Book> getfirstBooks(int first, List<Book> books) {
		List<Book> bookss = new ArrayList<>();
		for (int i = 0; i < first; i++) {
			bookss.add(books.get(i));
		}
		return bookss;
	}
}
