package com.ssm.action;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssm.model.User;
import com.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


@Controller
@RequestMapping("/user")
public class UserAction {
    private IUserService IUserService;
    @Autowired
    public UserAction(IUserService IUserService) {
        this.IUserService = IUserService;
    }

    @RequestMapping(value = "/showUser",method = RequestMethod.GET)
    public ModelAndView selectUser(HttpServletRequest request, HttpServletResponse response, @RequestParam int uid) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        User user = this.IUserService.selectUserById(uid);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/showUserList",method = RequestMethod.GET)
    @ResponseBody
    public List selectUserList(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String suid = request.getParameter("uid");
        int uid=Integer.parseInt(request.getParameter("uid").toString());
        User user = this.IUserService.selectUserById(uid);
        List<User> users = new ArrayList<User>();
        users.add(user);
        ObjectMapper objectMapper = new ObjectMapper();
        String usersJson = objectMapper.writeValueAsString(users);
        return users;
    }

    @RequestMapping("/register")
    public String prepareRegister() throws Exception{

        return "register";
    }


    @RequestMapping(value="/addUser",method = RequestMethod.POST)
    public ModelAndView registerUser(HttpServletRequest request,HttpServletResponse response,User user) throws Exception{
        ModelAndView mv = new ModelAndView();
        if(this.IUserService.registerUser(user))
        {
            mv.setViewName("index");
            return mv;
        }
        mv.setViewName("error");
        return mv;
    }


    @RequestMapping(value = "doLogin",method = RequestMethod.POST)
    @ResponseBody
    public HashMap login(HttpServletRequest request,HttpServletResponse response,User user) throws Exception{
        User tmpUser=this.IUserService.verifyUser(user);
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String,Object> dataMap= new HashMap<String, Object>();
        if(tmpUser==null){
            dataMap.put("error","用户名或者密码错误!");
            String message = objectMapper.writeValueAsString(dataMap);
            System.out.print("用户名或密码错误!");
//            response.getWriter().write(message);
//            return message;
            return dataMap;
        }
        else {
            dataMap.put("user",tmpUser);
            String userJason = objectMapper.writeValueAsString(dataMap);
            System.out.print(userJason);
//            response.getWriter().write(userJason.toString());
            return dataMap;
        }
    }




}
