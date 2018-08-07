package com.ssm.service;

import com.ssm.model.User;

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
    User verifyUser(User user) throws Exception;
    boolean signUpUser(User user) throws Exception;
}
