package com.amit;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

public class UserRepository {

    private final MongoCollection<Document> users;

    public UserRepository(MongoCollection<Document> users) {
        this.users = users;
    }

    public User findById(String id) {
        Document doc = users.find(eq("_id", new ObjectId(id))).first();
        return user(doc);
    }

    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        for (Document doc : users.find()) {
            allUsers.add(user(doc));
        }
        return allUsers;
    }
    
    public User getUser(String id) {
        List<User> allUsers = new ArrayList<>();
        for (Document doc : users.find()) {
            allUsers.add(user(doc));
        }
        Optional<User> user = allUsers.stream().filter( u ->
            u.getId().equals(id)).findFirst();
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    public User getUserByName(String name) {
        List<User> allUsers = new ArrayList<>();
        for (Document doc : users.find()) {
            allUsers.add(user(doc));
        }
        Optional<User> user = allUsers.stream().filter( u ->
            u.getName().equalsIgnoreCase(name)).findFirst();
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }
    
    public void saveUser(User user) {
        Document doc = new Document();
        doc.append("name", user.getName());
        doc.append("level", user.getLevel());
        doc.append("score", user.getScore());
        doc.append("ranking", user.getRanking());
        doc.append("learnPath", user.getLearnPath());
        users.insertOne(doc);
    }

    private User user(Document doc) {
        Ranking ranking = (Ranking) doc.get("ranking");
        LearnPath learnPath = (LearnPath) doc.get("learnPath");
        return new User(
                doc.get("_id").toString(),
                doc.getString("name"),
                doc.getInteger("score"),
                doc.getInteger("level"),
                ranking,
                learnPath);
    }
}
