package com.ssm.action;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssm.model.User;
import com.ssm.service.IUserService;
import com.ssm.util.AES;
import com.ssm.util.CookieUtil;
import com.ssm.util.Md5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;



@Controller
@RequestMapping("/user")
public class UserAction {
    private IUserService IUserService;

    @Autowired
    public UserAction(IUserService IUserService) {
        this.IUserService = IUserService;
    }

    @RequestMapping(value = "/showUser", method = RequestMethod.GET)
    public ModelAndView selectUser(HttpServletRequest request, HttpServletResponse response, @RequestParam int uid) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        User user = this.IUserService.selectUserById(uid);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/showUserList", method = RequestMethod.GET)
    @ResponseBody
    public List selectUserList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String suid = request.getParameter("uid");
        int uid = Integer.parseInt(request.getParameter("uid").toString());
        User user = this.IUserService.selectUserById(uid);
        List<User> users = new ArrayList<User>();
        users.add(user);
        ObjectMapper objectMapper = new ObjectMapper();
        String usersJson = objectMapper.writeValueAsString(users);
        return users;
    }

    @RequestMapping("/signup")
    public String prepareSignUp() throws Exception {
        return "signup";
    }


    @RequestMapping(value = "/signupuser", method = RequestMethod.POST)
    public ModelAndView signUpUser(HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
        ModelAndView mv = new ModelAndView();
        if (this.IUserService.signUpUser(user)) {
            mv.setViewName("index");
            return mv;
        }
        mv.setViewName("error");
        return mv;
    }

    public String login() {

        return "user";
    }

//
//    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String, Object> ajaxLogin(HttpSession session, HttpServletResponse response, User user, boolean checked) throws Exception {
//        User tmpUser = this.IUserService.verifyUser(user);
//        ObjectMapper objectMapper = new ObjectMapper();
//        HashMap<String, Object> dataMap = new HashMap<String, Object>();
//        if (null != tmpUser) {
//            dataMap.put("user", tmpUser);
//            //session存储登录资料
//            session.setAttribute("user",tmpUser);
//            //如果选中自动登陆,更新Cookie
//            if (true == checked) {
//                String userJason = objectMapper.writeValueAsString(dataMap);
//                System.out.print(userJason);
//                this.refreshCookie(response, tmpUser.getUid().toString());
//            }
//            return dataMap;
//        } else {
//            dataMap.put("error", "用户名或者密码错误!");
//            String message = objectMapper.writeValueAsString(dataMap);
//            return dataMap;
//        }
//    }


    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> ajaxShiroLogin(HttpSession session, HttpServletResponse response, User user, boolean checked)  {
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Object> dataMap = new HashMap<String, Object>();
        Subject currentUser = SecurityUtils.getSubject();
        if(!currentUser.isAuthenticated()){
            UsernamePasswordToken up = new UsernamePasswordToken();
            up.setUsername(user.getEmail());
            up.setPassword(user.getPassword().toCharArray());
            try{
                currentUser.login(up);
                User tmpUser = this.IUserService.selectUserByEmail(user.getEmail());
                if(null!=tmpUser)
                dataMap.put("user", tmpUser);
                //session存储登录资料
                session.setAttribute("user",tmpUser);
                //如果选中自动登陆,更新Cookie
                if (true == checked) {
                    String userJason = objectMapper.writeValueAsString(dataMap);
                    System.out.print(userJason);
                    this.refreshCookie(response, tmpUser.getUid().toString());
                }
            }
            catch (Exception e){
                dataMap.put("error","用户名密码错误!");
            }
        }
        return dataMap;
    }





    public boolean refreshCookie(HttpServletResponse response, String uid) {
        String salt = Md5.getRandomSalt();
        uid = AES.AESEncode(salt, uid);
        String token = AES.AESEncode(AES.PUBLIC_KEY, salt);
        CookieUtil.addCookie(response, "user", uid, CookieUtil.defMaxAge);
        CookieUtil.addCookie(response, "token", token, CookieUtil.defMaxAge);
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
            int realUid = Integer.parseInt(uid);
            User tmpUser = this.IUserService.selectUserById(realUid);
            if (null != tmpUser) {
                this.refreshCookie(response, uid);
            }
        }
        dataMap.put("error", "无法自动登陆");
        String message = objectMapper.writeValueAsString(objectMapper);
        return message;
    }


    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        CookieUtil.removeCookie(request, response, "user");
        CookieUtil.removeCookie(request, response, "token");
        Subject curUser = SecurityUtils.getSubject();
        if(curUser.isAuthenticated()) curUser.logout();
        return "index";
    }


}
