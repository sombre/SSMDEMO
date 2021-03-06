package com.ssm.action;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssm.model.User;
import com.ssm.service.MyUserService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/do")
public class DoNothing {


    @Autowired
    private MyUserService MyUserService;

    private Logger logger = LogManager.getLogger(DoNothing.class.getName());
    @RequestMapping("/ding")
    public void doNothing(HttpServletRequest request, HttpServletResponse response) throws Exception{
        User user = this.MyUserService.selectUserById(1);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
//        request.setCharacterEncoding("UTF-8");
        request.setAttribute("param",1);
        response.getWriter().write("什么鬼!");
//        logger.error("Did it again!");   //error级别的信息，参数就是你输出的信息
        logger.info("我是info信息");    //info级别的信息
        logger.debug("我是debug信息");
        logger.warn("我是warn信息");
        logger.fatal("我是fatal信息");
        logger.log(Level.DEBUG, "我是debug信息");   //这个就是制定Level类型的调用：谁闲着没事调用这个，也不一定哦！
        response.getWriter().write(mapper.writeValueAsString(user));
        response.getWriter().write("居然不行吗?!");
        response.getWriter().write("试试看");
        response.getWriter().close();
    }
}
