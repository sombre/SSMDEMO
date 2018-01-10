package com.ssm.service;


import com.ssm.dao.UserMapper;
import com.ssm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IUserServiceImpl implements IUserService {

    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User selectUserById(int userId) throws Exception{

        return this.userMapper.selectByPrimaryKey(userId);
    }

    public boolean addPlayer(String gender,String name,String score) {

        return false;
    }
    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 3)
    public boolean registerUser(User user) throws Exception{
        int i=this.userMapper.insert(user);
        if(i!=0)
            return true;
        return false;
    }
}
