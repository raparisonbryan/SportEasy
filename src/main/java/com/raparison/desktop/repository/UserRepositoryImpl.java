package com.raparison.desktop.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import com.raparison.desktop.model.User;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.raparison.desktop.mapper.UserMapper.userToDocument;
import static com.raparison.desktop.mapper.UserMapper.documentToUser;

public class UserRepositoryImpl implements UserRepository{
    MongoCollection<Document> collection;
    public UserRepositoryImpl(MongoCollection<Document> collection){
        this.collection = collection;
    }
    @Override
    public String save(User user) {
        InsertOneResult result = this.collection.insertOne(userToDocument(user));
        return result.getInsertedId().toString();
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<User>();
        for (Document document : this.collection.find()) {
            users.add(documentToUser(document));
        }
        return users;
    }
}