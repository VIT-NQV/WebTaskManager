package com.example.webtaskmanager.service;

import com.example.webtaskmanager.model.User;

public interface UserService {

    User saveUser(User user);

    Integer addUserMybatis(User user);
}
