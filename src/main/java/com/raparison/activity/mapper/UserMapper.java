package com.raparison.activity.mapper;

import com.raparison.activity.model.User;
import org.bson.Document;

import java.util.Date;

public class UserMapper {
    public static Document userToDocument(User user) {
        Document document = new Document()
                .append("name", user.getName())
                .append("lastName", user.getLastName())
                .append("birthDate", user.getBirthDate())
                .append("sexe", user.isSexe())
                ;
        return document;
    }

    public static User documentToUser(Document document) {
        User user = new User(
                (String) document.get("name"),
                (String) document.get("lastName"),
                (Date) document.get("birthDate"),
                (boolean) document.get("sexe")
        );
        return user;
    }
}
