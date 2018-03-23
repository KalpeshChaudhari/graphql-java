package com.elc.learn.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.elc.learn.model.Ranking;

public interface RankingRepository extends MongoRepository<Ranking, String>{

}
