package com.raparison.desktop.controller;

import com.raparison.desktop.model.User;
import com.raparison.desktop.repository.UserRepository;

import java.util.List;

public class UserControllerImpl implements UserController{
    UserRepository userRepository;

    public UserControllerImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public String saveUser(User user) {
        return this.userRepository.save(user);
    }

    public List<User> getAllUser() {
        return userRepository.getAll();
    }
}