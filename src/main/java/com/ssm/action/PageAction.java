package com.ssm.action;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class PageAction {
    @RequestMapping("/index")
    public ModelAndView  indexCore(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }


    @RequestMapping("login")
    public String toLogin(){

        return "login";
    }

    @RequestMapping("test")
    public String test(){

        return "test";
    }
}
