package com.ssm.service;

import com.ssm.dao.UserDao;
import com.ssm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User selectUserById(long userId) {

        return userDao.selectUserById(userId);
    }

}
