package net.ameizi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import net.ameizi.model.Book;

public interface BookRepository extends MongoRepository<Book, String>{

}
