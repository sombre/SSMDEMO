package com.ssm.dao;

/**
 * 功能概要：User的DAO类
 *
 * @author linbingwen
 * @since 2015年9月28日
 */
public interface UserDao {
    /**
     *
     * @author linbingwen
     * @since 2015年9月28日
     * @param userId pk
     * @return com.ssm.model.User
     */
    public User selectUserById(long userId);

}

