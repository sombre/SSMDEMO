package com.ssm.test;

import com.ssm.dao.UserMapper;
import com.ssm.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class) //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration({"classpath:spring-myBatis.xml"})
public class UserDaoTest {

    @Autowired
    private UserMapper dao;


    private Logger logger = LogManager.getLogger(UserDaoTest.class.getName());

    @Test
    public void testSelectUser() throws Exception {
        int id = 1;
        User user = dao.selectByPrimaryKey(id);
        System.out.println(user.getUserName());
        System.out.println(user.getUserEmail());
        logger.debug("hello world!");
        logger.info(user.toString());
    }

}