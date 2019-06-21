package com.example.ol.service;

import com.example.ol.entity.User;

public interface UserService {

    boolean addUser(User user);

    User findUserByUsername(String username);

    User findUserById(Integer id);

}
