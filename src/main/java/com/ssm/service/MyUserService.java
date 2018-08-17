package com.ssm.service;

import com.ssm.model.Album;
import com.ssm.model.User;
import com.ssm.model.UserAlbum;

/**
 * 功能概要：UserService接口类
 *
 * @author Jack
 * @since  2017年8月1日
 */
public interface MyUserService {
    User selectUserById(long userId) throws Exception;
    User selectUserByIdNotAllData(long userId) throws Exception;
    User selectUserByEmail(String email);
    //验证用户密码
    User verifyUser(User user) throws Exception;
    boolean signUpUser(User user) throws Exception;
    int updateUser(User user) throws Exception;
}
