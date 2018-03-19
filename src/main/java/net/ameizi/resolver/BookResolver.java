package net.ameizi.resolver;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLResolver;
import net.ameizi.model.Author;
import net.ameizi.model.Book;
import net.ameizi.repository.AuthorRepository;

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