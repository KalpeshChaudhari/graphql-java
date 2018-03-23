package com.elc.learn.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.elc.learn.model.LearnPath;

public interface LearnPathRepository extends MongoRepository<LearnPath, String>{

}
