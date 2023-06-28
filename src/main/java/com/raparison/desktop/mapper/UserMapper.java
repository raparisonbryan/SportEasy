package com.raparison.desktop.mapper;

import com.raparison.desktop.model.User;
import org.bson.Document;

import java.util.Date;

public class UserMapper {
    public static Document userToDocument(User user) {
        Document document = new Document()
                .append("name", user.getName())
                .append("lastName", user.getLastName())
                .append("birthDate", user.getBirthDate())
                .append("sexe", user.getSexe())
                ;
        return document;
    }

    public static User documentToUser(Document document) {
        User user = new User(
                (String) document.get("name"),
                (String) document.get("lastName"),
                (Date) document.get("birthDate"),
                (String) document.get("sexe")
        );
        return user;
    }
}
