package com.unicom.service.impl;

import com.unicom.mapper.UserMapper;
import com.unicom.model.User;
import com.unicom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String loginName, String password) {
        return userMapper.login(loginName,password);
    }
}
