package com.elc.learn.resolver;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.elc.learn.model.User;
import com.elc.learn.repository.AuthorRepository;

public class UserResolver implements GraphQLResolver<User> {
    @Autowired
    private AuthorRepository authorRepository;

    public UserResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
}
