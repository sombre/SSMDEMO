package com.ssm.action;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssm.model.User;
import com.ssm.service.MyPictureService;
import com.ssm.service.MyUserService;
import com.ssm.util.AES;
import com.ssm.util.CookieUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;


@Controller
@RequestMapping("/user")
public class UserAction {

    private MyUserService myUserService;

    private MyPictureService myPictureService;

    @Autowired
    public UserAction(MyUserService MyUserService) {
        this.myUserService = MyUserService;
    }


    public MyPictureService getMyPictureService() {
        return myPictureService;
    }

    @Autowired
    public void setMyPictureService(MyPictureService myPictureService) {
        this.myPictureService = myPictureService;
    }

    @RequestMapping(value = "/showUser", method = RequestMethod.GET)
    public ModelAndView selectSingleUser(HttpServletRequest request, HttpServletResponse response, @RequestParam int uid) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        User user = this.myUserService.selectUserById(uid);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("index");
        return modelAndView;
    }


    @RequestMapping("/signup")
    public String prepareSignUp() throws Exception {
        return "signup";
    }


    @RequestMapping(value = "/signupuser", method = RequestMethod.POST)
    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 300,rollbackFor = {Exception.class})
    public ModelAndView signUpUser(HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
        ModelAndView mv = new ModelAndView();
        if (this.myUserService.signUpUser(user)) {
            mv.setViewName("index");
            return mv;
        }
        mv.setViewName("error");
        return mv;
    }

    public String login() {
        return "user";
    }


    @RequestMapping("/{uid}")
    public ModelAndView userSpace(HttpSession session, HttpServletResponse response,@PathVariable("uid") Long uid) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        if(null!=uid){
            modelAndView.setViewName("user");
            modelAndView.addObject("userSpaceId",uid);
            User user = myUserService.selectUserById(uid);
            if(null!=user){
                modelAndView.addObject("space",user);
            }
        }
        return modelAndView;
    }


    @RequestMapping("/{uid}/picture")
    public  ModelAndView userCollectedPictures(HttpSession session, HttpServletResponse response,@PathVariable("uid") Long uid) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        if(null!=uid){
            modelAndView.setViewName("user");
            modelAndView.addObject("userSpaceId",uid);
            User user = myUserService.selectUserById(uid);
            if(null!=user){
                modelAndView.addObject("space",user);
            }
        }
        return modelAndView;
    }


    @RequestMapping("/{uid}/album")
    public ModelAndView userCollectedAlbums(HttpSession session, HttpServletResponse response, @PathVariable("uid") Long uid) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        if(null!=uid){
            modelAndView.setViewName("user");
            modelAndView.addObject("userSpaceId",uid);
            User user = myUserService.selectUserById(uid);
            if(null!=user){
                modelAndView.addObject("space",user);
            }
        }
        return  modelAndView;
    }


    @RequestMapping("/doLogin")
    public ModelAndView Login(HttpSession session, HttpServletResponse response, User user, boolean checked) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //取Shiro中的User
        Subject currentUser = SecurityUtils.getSubject();
        if(!currentUser.isAuthenticated()) {
            UsernamePasswordToken up = new UsernamePasswordToken();
            up.setUsername(user.getEmail());
            up.setPassword(user.getPassword().toCharArray());
                currentUser.login(up);
                User tmpUser = this.myUserService.selectUserByEmail(user.getEmail());
                if (null != tmpUser) {
                    modelAndView.addObject("user", tmpUser);
                    //session存储登录资料
                    session.setAttribute("user", tmpUser);
                    session.setMaxInactiveInterval(3600*24*7);
                    //如果选中自动登陆,更新Cookie
                    if (checked) {
                        this.refreshCookie(response, tmpUser.getUid().toString());
                    }
                }
        }
        String url = "redirect:/index";
        modelAndView.setViewName(url);
        return modelAndView;
    }





    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        CookieUtil.removeCookie(request, response, "user");
        CookieUtil.removeCookie(request, response, "token");
        Subject curUser = SecurityUtils.getSubject();
        if (curUser.isAuthenticated()) curUser.logout();
        return "index";
    }









    public boolean refreshCookie(HttpServletResponse response, String uid) throws Exception{
//        String salt = Md5.getRandomSalt();
//        uid = AES.AESEncode(salt, uid);
//        String token = AES.AESEncode(AES.PUBLIC_KEY, salt);
        CookieUtil.addCookie(response, "user", uid, CookieUtil.defMaxAge);
//        CookieUtil.addCookie(response, "token", token, CookieUtil.defMaxAge);
        return true;
    }

    public void removeCookie(HttpServletRequest request, HttpServletResponse response, String uid, String token) {
        CookieUtil.removeCookie(request, response, uid);
        CookieUtil.removeCookie(request, response, token);
    }

    public String loginCookie(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        Cookie uidCookie = CookieUtil.getCookieByName(request, "user");
        Cookie tokenCookie = CookieUtil.getCookieByName(request, "token");
        HashMap<String, Object> dataMap = new HashMap<String, Object>();
        ObjectMapper objectMapper = new ObjectMapper();
        if (null != tokenCookie && null != uidCookie) {
            String uid = uidCookie.getValue();
            String token = tokenCookie.getValue();
            String salt = AES.AESDncode(AES.PUBLIC_KEY, token);
            uid = AES.AESDncode(salt, uid);
            Long realUid = Long.parseLong(uid);
            User tmpUser = this.myUserService.selectUserById(realUid);
            if (null != tmpUser) {
                this.refreshCookie(response, uid);
            }
        }
        dataMap.put("error", "无法自动登陆");
        return objectMapper.writeValueAsString(objectMapper);
    }




}
