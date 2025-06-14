package org.example.eznote.service.impl;

import org.example.eznote.mapper.UserMapper;
import org.example.eznote.pojo.User;
import org.example.eznote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.selectByUsernameAndPassword(user);
    }
}
