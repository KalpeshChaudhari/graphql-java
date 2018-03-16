package com.amit;

import javax.servlet.annotation.WebServlet;

import com.coxautodev.graphql.tools.SchemaParser;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;

/**
 * GraphQL Endpoint
 *
 * @author amit
 */
@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

    private static final UserRepository userRepository;
    static {
        //Change to `new MongoClient("mongodb://<host>:<port>/hackernews")`
        //if you don't have Mongo running locally on port 27017
        MongoDatabase mongo = new MongoClient().getDatabase("hackernews");
        userRepository = new UserRepository(mongo.getCollection("users"));
       /* User user = new User("Prashant 1", 240, 8, new Ranking(22, 5), new LearnPath(2, 5, 3));
        User user1 = new User("Prashant 1", 240, 8, new Ranking(22, 5), new LearnPath(2, 5, 3));
        User user2= new User("Prashant 1", 240, 8, new Ranking(22, 5), new LearnPath(2, 5, 3));
        userRepository.saveUser(user);
        userRepository.saveUser(user1);
        userRepository.saveUser(user2);*/
    }

    public GraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(new Query(userRepository), new Mutation(userRepository))
                .build().makeExecutableSchema();
    }
}
