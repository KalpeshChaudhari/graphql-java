/* ***************************************************************************
 * Copyright 2018 Mindstix, Inc.  All rights reserved.
 * -- Mindstix Confidential
 * ***************************************************************************/

package com.elc.learn.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.elc.learn.model.Author;
import com.elc.learn.model.Book;
import com.elc.learn.model.User;
import com.elc.learn.repository.AuthorRepository;
import com.elc.learn.repository.BookRepository;
import com.elc.learn.repository.UserRepository;

public class Query implements GraphQLQueryResolver {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;
    
    @Autowired
    private UserRepository userRepository;

    public Query(AuthorRepository authorRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }
    
    public Author findAuthorById(String id) {
        return authorRepository.findOne(id);
    }

    public Long countBooks() {
        return bookRepository.count();
    }

    public Long countAuthors() {
        return authorRepository.count();
    }
    
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    
    public Long countUsers() {
        return userRepository.count();
    }

    public User findUserById(String id) {
        return userRepository.findOne(id);
    }
}
