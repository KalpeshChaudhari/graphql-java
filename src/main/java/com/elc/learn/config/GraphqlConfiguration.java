/* ***************************************************************************
 * Copyright 2018 Mindstix, Inc.  All rights reserved.
 * -- Mindstix Confidential
 * ***************************************************************************/

package com.elc.learn.config;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.elc.learn.exception.GraphQLErrorAdapter;
import com.elc.learn.repository.AuthorRepository;
import com.elc.learn.repository.BookRepository;
import com.elc.learn.repository.LearnPathRepository;
import com.elc.learn.repository.RankingRepository;
import com.elc.learn.repository.UserRepository;
import com.elc.learn.resolver.BookResolver;
import com.elc.learn.resolver.Mutation;
import com.elc.learn.resolver.Query;
import com.elc.learn.resolver.RankingResolver;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;

@Configuration
public class GraphqlConfiguration {


    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private UserRepository userRepository;
    private RankingRepository rankingRepository;
    private LearnPathRepository learnPathRepository;

    @Bean
    public GraphQLErrorHandler errorHandler() {
        return new GraphQLErrorHandler() {
            @Override
            public List<GraphQLError> processErrors(List<GraphQLError> errors) {
                List<GraphQLError> clientErrors = errors.stream()
                        .filter(this::isClientError)
                        .collect(Collectors.toList());

                List<GraphQLError> serverErrors = errors.stream()
                        .filter(e -> !isClientError(e))
                        .map(GraphQLErrorAdapter::new)
                        .collect(Collectors.toList());

                List<GraphQLError> e = new ArrayList<>();
                e.addAll(clientErrors);
                e.addAll(serverErrors);
                return e;
            }

            protected boolean isClientError(GraphQLError error) {
                return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
            }
        };
    }

    @Bean
    public BookResolver bookResolver(AuthorRepository authorRepository) {
        return new BookResolver(authorRepository);
    }

    @Bean
    public RankingResolver rankingResolver(UserRepository userRepository) {
        return new RankingResolver(userRepository);
    }
    
    @Bean
    public Query query(AuthorRepository authorRepository, BookRepository bookRepository, UserRepository userRepository, RankingRepository rankingRepository, LearnPathRepository learnPathRepository) {
        return new Query(authorRepository, bookRepository, userRepository, rankingRepository, learnPathRepository);
    }

    @Bean
    public Mutation mutation(AuthorRepository authorRepository, BookRepository bookRepository, UserRepository userRepository, RankingRepository rankingRepository, LearnPathRepository learnPathRepository) {
        return new Mutation(authorRepository, bookRepository, userRepository, rankingRepository, learnPathRepository);
    }

}
