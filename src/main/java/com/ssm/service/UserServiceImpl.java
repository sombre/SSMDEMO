package com.ssm.service;


import com.ssm.dao.UserMapper;
import com.ssm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }
    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User selectUserById(int userId) {

        return this.userMapper.selectByPrimaryKey(userId);
    }

    public boolean addPlayer(String gender,String name,String score) {

        return false;
    }

}
