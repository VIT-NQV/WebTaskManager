package com.example.webtaskmanager.service.impl;

import com.example.webtaskmanager.mapper.UserMapper;
import com.example.webtaskmanager.model.User;
import com.example.webtaskmanager.repository.UserRepository;
import com.example.webtaskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public Integer addUserMybatis(User user) {
        return userMapper.addUserMybatis(user);
    }

}
