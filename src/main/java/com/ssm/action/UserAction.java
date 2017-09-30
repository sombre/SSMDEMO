package com.ssm.action;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssm.model.User;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/user")
public class UserAction {

    @Autowired
    private UserService userService;

    @RequestMapping("/showUser")
    public String selectUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
//        System.out.println(Long.parseLong(request.getParameter("id")));
//        long userId = Long.parseLong(request.getParameter("id"));
//        long userId = Long.parseLong(request.getParameter("id"));
        User user = this.userService.selectUserById(1);
//        ObjectMapper mapper = new ObjectMapper();
//        response.getWriter().write(mapper.writeValueAsString(user));
//        response.getWriter().close();
        request.setAttribute("user",user);
        return "index";
    }
}
