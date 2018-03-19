package net.ameizi.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import net.ameizi.model.Author;
import net.ameizi.model.Book;
import net.ameizi.repository.AuthorRepository;
import net.ameizi.repository.BookRepository;

public class Query implements GraphQLQueryResolver {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
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
}
