package com.ssm.util;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class CookieUtil {

    public static int defMaxAge = 24 * 3600 * 7;






    /**
     * 添加cookie
     *
     * @param response HttpServletResponse
     * @param name     String
     * @param value    String
     * @param maxAge   int 过期时间,单位为秒
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name.trim(), value.trim());
        cookie.setMaxAge(maxAge);// 设置为30min
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * Set cookie
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @param name     String
     * @param value    String
     * @param maxAge   int
     *                 注意一、修改、删除Cookie时，新建的Cookie除value、maxAge之外的所有属性，例如name、path、domain等，都要与原Cookie完全一样。
     *                 否则，浏览器将视为两个不同的Cookie不予覆盖，导致修改、删除失败。
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String name, String value, int maxAge) {
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    cookie.setValue(value);
                    cookie.setPath("/");
                    //设置过期时间,单位为秒
                    cookie.setMaxAge(maxAge);
                    response.addCookie(cookie);
                    break;
                }
            }
        }

    }

    /**
     * 读取所有cookie
     * 注意二、从客户端读取Cookie时，包括maxAge在内的其他属性都是不可读的，也不会被提交。浏览器提交Cookie时只会提交name与value属性。
     * maxAge属性只被浏览器用来判断Cookie是否过期
     *
     * @param request HttpServletRequest
     */
    public static void showCookies(HttpServletRequest request) {
        //获取cookie数组
        Cookie[] cookies = request.getCookies();
        if (null == cookies) {
            System.out.println("没有cookie=========");
        } else {
            for (Cookie cookie : cookies) {
                System.out.println("name:" + cookie.getName() + ",value:" + cookie.getValue());
            }
        }
    }


    /**
     * 删除cookie
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @param name     String
     */
    public static void removeCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        Map<String, Cookie> cookies = readCookieMap(request);
        Cookie cookie = cookies.get(name);
        if(null != cookie) {
            cookie.setValue(null);
            cookie.setMaxAge(0);// 立即销毁cookie
            cookie.setPath("/");
            response.addCookie(cookie);
        }

//        Cookie[] cookies = request.getCookies();
//        if (null != cookies) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals(name)) {
//                    cookie.setValue(null);
//                    cookie.setMaxAge(0);// 立即销毁cookie
//                    cookie.setPath("/");
//                    response.addCookie(cookie);
//                    break;
//                }
//            }
//        }
    }


    /**
     * 根据名字获取cookie
     *
     * @param request HttpServletResponse
     * @param name    cookie名字
     * @return Cookie
     */
    public static Cookie getCookieByName(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = readCookieMap(request);
        if (cookieMap.containsKey(name)) {
            return cookieMap.get(name);
        } else {
            return null;
        }
    }


    /**
     * 通常开发时先用以下的代码将获取的cookie进行封装
     * 将cookie封装到Map里面
     *
     * @param request HttpServletRequest
     * @return Map
     */
    private static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

}
