/*
 * Copyright (c) 2014, ShiXiaoyong. All rights reserved.
 */
package com.ssm.util;

import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 描述：GetMethodEncodingFilter
 *     针对GET方式提交的表单，进行编码转换
 * <pre>
 * HISTORY
 * ****************************************************************
 *  ID   DATE           PERSON          REASON
 *	1	 2015-3-6		Shixy			Create
 * ****************************************************************
 * </pre>
 *
 * @author Shixy
 * @since 1.0
 */
public class GetMethodEncodingFilter implements Filter {

    private String charset = "utf-8";


    public void destroy() {
    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)request;

        req = new GetHttpServletRequestWrapper(req,charset);
        filterChain.doFilter(req, response);
    }


    public void init(FilterConfig filterConfig) throws ServletException {
    }
}
