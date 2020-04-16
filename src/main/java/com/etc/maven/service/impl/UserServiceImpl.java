package com.etc.maven.service.impl;

import com.etc.maven.dao.UserMapper;
import com.etc.maven.domain.User;
import com.etc.maven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String account) {
        return userMapper.login(account);
    }

    @Override
    public int signIn(String account, String password) {
        return userMapper.signIn(account,password);
    }

    @Override
    public User showMyAccount(Integer uid) {
        return userMapper.showMyAccount(uid);
    }

    @Override
    public int changeMyAccount(String newPassword, String account) {
        return userMapper.changeMyAccount(newPassword,account);
    }

    @Override
    public String isMe(String account) {
        return userMapper.isMe(account);
    }



}
