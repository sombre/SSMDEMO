package com.ssm.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyAjaxExceptionHandler {


//    @ExceptionHandler({UnauthenticatedException.class})
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        Map<String,Object> data = new HashMap<String, Object>();
        data.put("error","用户未登陆");
        data.put("message",e.getMessage());
        data.put("ex",e);
//        modelAndView.addObject("ex",e);
        modelAndView.addAllObjects(data);
        modelAndView.setViewName("exception");
        return modelAndView;
    }



    @ExceptionHandler({ UnauthorizedException.class})
    public ModelAndView doShow(HttpServletRequest request,HttpServletResponse response,AuthorizationException e){

        ModelAndView modelAndView = new ModelAndView();
        Map<String,Object> data = new HashMap<String, Object>();
        data.put("error","用户无权操作");
        data.put("message",e.getMessage());
        data.put("ex",e);
//        modelAndView.addObject("ex",e);
        modelAndView.addAllObjects(data);
        modelAndView.setViewName("exception");
        return modelAndView;
    }
}
