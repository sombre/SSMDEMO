package com.ssm.service;


import com.ssm.dao.UserMapper;
import com.ssm.dao.UserService;
import com.ssm.model.User;
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



    public User selectUserByEmail(String email) throws Exception {
        User user = new User();
        if(!"".equals(email) && null!=email) {
            user=this.userserivce.selectUserByEmail(email);
        }
        if(null!=user && !"".equals(user)) {
            return user;
        }
        return null;
    }

    public void isEmailExist(String email){

    }

    public User verifyUser(User user) throws Exception {
        User tmpUser = this.selectUserByEmail(user.getUserEmail());
        if(tmpUser!=null && tmpUser.getUid()!=null && tmpUser.getUserEmail()!=null){
            if(tmpUser.getUserEmail().equals(user.getUserEmail()))
            {
                String salt = tmpUser.getUserSalt();
                String password = Md5.encryptPassword(user.getUserPassword(),salt);
                if(password.equals(tmpUser.getUserPassword()))
                {
                    return tmpUser;
                }
            }
        }
        return null;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 3)
    public boolean registerUser(User user) throws Exception{
        String email = user.getUserEmail();
        User tmpUser = selectUserByEmail(email);
        if(tmpUser.getUid()!=null && tmpUser.getUserEmail()!=null){

        }
        String password = user.getUserPassword();
        String salt = Md5.getRandomSalt();
        password = Md5.encryptPassword(password,salt);
        user.setUserPassword(password);
        user.setUserSalt(salt);
        int i=this.userMapper.insert(user);
        if(i!=0)
            return true;
        return false;
    }
}
