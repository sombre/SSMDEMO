package com.ssm.service;

import com.ssm.model.User;

/**
 * 功能概要：UserService接口类
 *
 * @author linbingwen
 * @since  2015年9月28日
 */
public interface UserService {
    public User selectUserById(long userId);
}
