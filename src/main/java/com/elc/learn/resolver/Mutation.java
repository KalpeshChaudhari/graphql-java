/* ***************************************************************************
 * Copyright 2018 Mindstix, Inc.  All rights reserved.
 * -- Mindstix Confidential
 * ***************************************************************************/

package com.elc.learn.resolver;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.elc.learn.exception.BookNotFoundException;
import com.elc.learn.model.Author;
import com.elc.learn.model.Book;
import com.elc.learn.model.LearnPath;
import com.elc.learn.model.Ranking;
import com.elc.learn.model.User;
import com.elc.learn.repository.AuthorRepository;
import com.elc.learn.repository.BookRepository;
import com.elc.learn.repository.LearnPathRepository;
import com.elc.learn.repository.RankingRepository;
import com.elc.learn.repository.UserRepository;

public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private AuthorRepository authorRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RankingRepository rankingRepository;

    @Autowired
    private LearnPathRepository learnPathRepository;
    
    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository, UserRepository userRepository, RankingRepository rankingRepository, LearnPathRepository learnPathRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.rankingRepository = rankingRepository;
        this.learnPathRepository = learnPathRepository;
    }

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorRepository.save(author);
        return author;
    }

    public Book newBook(String title, String isbn, Integer pageCount, String authorId) {
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);
        bookRepository.save(book);
        return book;
    }

    public boolean deleteBook(String id) {
        bookRepository.delete(id);
        return true;
    }

    public Book updateBookPageCount(Integer pageCount, String id) {
        Book book = bookRepository.findOne(id);
        if(book == null) {
            throw new BookNotFoundException("The book to be updated was found", id);
        }
        book.setPageCount(pageCount);
        bookRepository.save(book);
        return book;
    }
    
    public User createUser(String name, int score, int level){
        User user=new User();
        user.setLevel(level);
        user.setName(name);
        user.setScore(score);
        userRepository.save(user);
        return user;
    }
    
    public Ranking createRanking(int eventsWon, int challengesWon, String userId) {
    	Ranking ranking = new Ranking();
    	ranking.setUser(new User(userId));
    	ranking.setEventsWon(eventsWon);
    	ranking.setChallengesWon(challengesWon);
    	rankingRepository.save(ranking);
    	return ranking;
    }
    
}