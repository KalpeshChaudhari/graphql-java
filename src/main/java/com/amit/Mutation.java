package com.amit;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

public class Mutation implements GraphQLRootResolver {

    private final UserRepository userRepository;

    public Mutation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name, Integer score, Integer level) {
        User newUser = new User(name, score, level);
        userRepository.saveUser(newUser);
        return newUser;
    }
}
