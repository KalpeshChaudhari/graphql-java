package com.amit;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

public class Query implements GraphQLRootResolver {

    private final UserRepository userRepository;
    
    public Query(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        return userRepository.getAllUsers();
    }
    
    public User user(String id) {
        return userRepository.getUser(id);
    }
    
    public User userByName(String name) {
        return userRepository.getUserByName(name);
    }
}
