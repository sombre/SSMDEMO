package com.ssm.action;

import com.ssm.model.User;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/user")
public class UserAction {
    private UserService userService;
    @Autowired
    public UserAction(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/showUser")
    public ModelAndView selectUser(HttpServletRequest request, HttpServletResponse response, @RequestParam int uid) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        User user = this.userService.selectUserById(uid);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("index");
//        this.userService.addPlayer("male","John Smith","1000");
//        ObjectMapper mapper = new ObjectMapper();
//        response.getWriter().write(mapper.writeValueAsString(user));
//        response.getWriter().close();
//        request.setAttribute("user",user);
        return modelAndView;
    }


    public ModelAndView registerUser(int uid,String userName,String passWord,String email,String gender) throws Exception{
        User tmp = new User();
        ModelAndView mv = new ModelAndView();
        tmp.setUid(uid);
        tmp.setUsername(userName);
        tmp.setEmail(email);

        tmp.setPassword(passWord);
        tmp.setGender(gender);

        return mv;

    }




}
