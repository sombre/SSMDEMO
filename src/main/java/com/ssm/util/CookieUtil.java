package com.ssm.util;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class CookieUtil {

    /**
     * 添加cookie
     *
     * @param response HttpServletResponse
     * @param name String
     * @param value String
     */

    public static void addCookie(HttpServletResponse response, String name, String value) {
        Cookie cookie = new Cookie(name.trim(), value.trim());
        cookie.setMaxAge(30 * 60);// 设置为30min
        cookie.setPath("/");
        System.out.println("已添加===============");
        response.addCookie(cookie);
    }

    /**
     * Set cookie
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param name String
     * @param value String
     *
     * 注意一、修改、删除Cookie时，新建的Cookie除value、maxAge之外的所有属性，例如name、path、domain等，都要与原Cookie完全一样。
     * 否则，浏览器将视为两个不同的Cookie不予覆盖，导致修改、删除失败。
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String name, String value) {
        Cookie[] cookies = request.getCookies();
        if (null == cookies) {
            return;
        } else {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    cookie.setValue(value);
                    cookie.setPath("/");
                    cookie.setMaxAge(30 * 60);// 设置为30min
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
     * @param response HttpServletResponse
     *
     */

    public void showCookies(HttpServletRequest request,HttpServletResponse response ){

        //获取cookie数组
        Cookie[] cookies = request.getCookies();
        if(null==cookies) {
            System.out.println("没有cookie=========");
        }else{
            for(Cookie cookie : cookies){
                System.out.println("name:"+cookie.getName()+",value:"+ cookie.getValue());
            }
        }
    }


        /**
         * 删除cookie
         *
         * @param response HttpServletResponse
         * @param name String
         * @param name String
         *
         */
    public void removeCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        Cookie[] cookies = request.getCookies();
        if (null == cookies) {
            return;
        } else {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    cookie.setValue(null);
                    cookie.setMaxAge(0);// 立即销毁cookie
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    break;
                }
            }
        }
    }


    /**
     * 根据名字获取cookie
     *
     * @param request HttpServletResponse
     * @param name    cookie名字
     * @return
     */
    public Cookie getCookieByName(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = ReadCookieMap(request);
        if (cookieMap.containsKey(name)) {
            Cookie cookie = cookieMap.get(name);
            return cookie;
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
    private Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
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
