package com.ssm.service;

import com.ssm.dao.UserMapper;
import com.ssm.dao.UserService;
import com.ssm.model.User;
import com.ssm.util.DateUtil;
import com.ssm.util.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class IUserServiceImpl implements IUserService {

    private UserMapper userMapper;

    private UserService userserivce;

    public UserService getUserserivce() {
        return userserivce;
    }
    @Autowired
    public void setUserserivce(UserService userserivce) {
        this.userserivce = userserivce;
    }

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

    public User selectUserByIdNotAllData(int userId) throws Exception{
        return this.userserivce.selectUserByIdNotAllData(userId);
    }



    public User selectUserByEmail(String email) {
        if(!"".equals(email) && null!=email) {
            User user = this.userserivce.selectUserByEmail(email);
            if(user!=null) return user;
        }
        return null;
    }


    public User verifyUser(User user) throws Exception {
        User tmpUser = this.selectUserByEmail(user.getEmail());
        if(tmpUser!=null && tmpUser.getUid()!=null && tmpUser.getEmail()!=null){
            if(tmpUser.getEmail().equals(user.getEmail()))
            {
                String salt = tmpUser.getSalt();
                String password = Md5.encryptPassword(user.getPassword(),salt);
                if(password.equals(tmpUser.getPassword()))
                {
                    return tmpUser;
                }
            }
        }
        return null;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 3)
    public boolean signUpUser(User user) throws Exception{
        String email = user.getEmail();
        User tmpUser = selectUserByEmail(email);
        //确认该用户是否已经注册过
        if(null==tmpUser){
            String password = user.getPassword();
            String salt = Md5.getRandomSalt();
            password = Md5.encryptPassword(password,salt);
            user.setPassword(password);
            user.setSalt(salt);
            user.setSignupAt(DateUtil.getCurrentTimeLong());
            if(0!=this.userMapper.insert(user))
                return true;
        }
        return false;
    }
}
