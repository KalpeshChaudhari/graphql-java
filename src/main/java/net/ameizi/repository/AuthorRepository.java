package net.ameizi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import net.ameizi.model.Author;

public interface AuthorRepository extends MongoRepository<Author, String>{

}
