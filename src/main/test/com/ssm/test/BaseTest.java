package com.ssm.test;


import com.ssm.service.shiro.MyShiroUtility;
import com.ssm.service.shiro.MyShiroUtilityImpl;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-beans.xml","classpath:spring-mvc.xml","classpath:spring-myBatis.xml"
,"classpath:spring-shiro.xml"})
@WebAppConfiguration
//@Transactional
public class BaseTest {
    @Autowired
    protected WebApplicationContext wac;
    protected MockMvc mockMvc;
    @Autowired
    protected MyShiroUtility myShiroUtility;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
}
