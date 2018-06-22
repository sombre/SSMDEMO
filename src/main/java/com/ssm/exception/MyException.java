package com.ssm.exception;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class MyException implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse, Object o, Exception ex) {
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("ex",ex);
        Logger logger = LogManager.getLogger(MyException.class);
        logger.debug(ex.getMessage());
        logger.debug(ex.getStackTrace());
        return new ModelAndView("error",model);
    }


}
