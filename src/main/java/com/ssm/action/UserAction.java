package com.ssm.action;

import com.ssm.model.User;
import com.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/user")
public class UserAction {
    private IUserService IUserService;
    @Autowired
    public UserAction(IUserService IUserService) {
        this.IUserService = IUserService;
    }
    @RequestMapping("/showUser")
    public ModelAndView selectUser(HttpServletRequest request, HttpServletResponse response, @RequestParam int uid) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        User user = this.IUserService.selectUserById(uid);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("index");
//        this.IUserService.addPlayer("male","John Smith","1000");
//        ObjectMapper mapper = new ObjectMapper();
//        response.getWriter().write(mapper.writeValueAsString(user));
//        response.getWriter().close();
//        request.setAttribute("user",user);
        return modelAndView;
    }

    @RequestMapping("/register")
    public String prepareRegister(){
        String tmp  = "hongasd";
        return "register";
    }


    @RequestMapping(value="/addUser",method = RequestMethod.POST)
    public ModelAndView registerUser(HttpServletRequest request,HttpServletResponse response,User user) throws Exception{

//        User user = new User();
        ModelAndView mv = new ModelAndView();
//        user.setUsername(userName);
//        user.setEmail(email);
//        user.setPassword(passWord);
//        user.setGender(gender);
//        HttpServletRequest request,HttpServletResponse response,
//                @RequestParam String userName,
//                @RequestParam String passWord,@RequestParam String email,@RequestParam String gender
        if(this.IUserService.registerUser(user))
        {
            mv.setViewName("index");
            return mv;
        }
        mv.setViewName("error");
        return mv;
    }




}
