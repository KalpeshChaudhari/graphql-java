package com.elc.learn.resolver;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.elc.learn.model.Ranking;
import com.elc.learn.model.User;
import com.elc.learn.repository.UserRepository;

public class RankingResolver implements GraphQLResolver<Ranking> {
    
	@Autowired
    private UserRepository userRepository;

    public RankingResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User getUser(Ranking ranking) {
        return userRepository.findOne(ranking.getUser().getId());
    }
}
