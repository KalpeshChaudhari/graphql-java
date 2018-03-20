/* ***************************************************************************
 * Copyright 2018 Mindstix, Inc.  All rights reserved.
 * -- Mindstix Confidential
 * ***************************************************************************/

package com.elc.learn.resolver;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.elc.learn.model.Author;
import com.elc.learn.model.Book;
import com.elc.learn.repository.AuthorRepository;

public class BookResolver implements GraphQLResolver<Book> {

    @Autowired
    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    
    public Author getAuthor(Book book) {
        return authorRepository.findOne(book.getAuthor().getId());
    }
}