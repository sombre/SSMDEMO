package com.ssm.service;

import com.ssm.model.User;

/**
 * 功能概要：UserService接口类
 *
 * @author linbingwen
 * @since  2015年9月28日
 */
public interface IUserService {
    User selectUserById(int userId) throws Exception;
    boolean registerUser(User user) throws Exception;
}
