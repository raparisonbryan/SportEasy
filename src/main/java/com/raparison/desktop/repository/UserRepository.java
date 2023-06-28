package com.raparison.desktop.repository;

import com.raparison.desktop.model.User;

import java.util.List;

public interface UserRepository {
    String save(User user);

    List<User> getAll();
}
