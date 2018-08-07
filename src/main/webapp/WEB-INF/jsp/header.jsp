<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2018/1/8
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <link href="css/common.css" rel="stylesheet">
    <link href="css/header.css" rel="stylesheet">
    <link href="css/myAlert.css" rel="stylesheet">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="js/header.js"></script>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/myAlert.js"></script>
    <script type="text/javascript" src="js/header.js"></script>
</head>
<body>


<div class="header wrap">

    <div class="wrapper clearfix">
        <div class="left-part clearfix">
            <div class="logo"><a href="index"><img src="img/logo1.png" alt=""></a></div>
            <div class="menu">
                <ul>
                    <li><a href="index">大虾</a></li>
                    <li><span class="vertical-divider"></span><a href="post/showpost">主题</a></li>
                    <li><span class="vertical-divider"></span><a href="login">发现</a></li>
                    <li><span class="vertical-divider"></span><a href="user/signup">最新</a></li>
                </ul>
            </div>
            <div class="search">
                <input class="search-text" type="text" placeholder="搜索图片、专辑...">
                <button type="button" class="search-btn"><span class="icon-search"></span></button>
            </div>
        </div>

        <div class="right-part clearfix">
            <div class="nav-usr">
                <ul>
                    <shiro:notAuthenticated>
                        <li><a href="login">登陆</a></li>
                        <li ><span class="vertical-divider"></span><a href="user/signup"  class="icon-text-pink">注册</a></li>
                    </shiro:notAuthenticated>
                    <shiro:authenticated>
                        <li><a href="#">${user.name}</a></li>
                        <li><span class="vertical-divider"></span><a href="upload">上传</a></li>
                        <li><span class="vertical-divider"></span><a href="user/${user.uid}/picture">图片</a></li>
                        <li><span class="vertical-divider"></span><a href="user/${user.uid}/album">专辑</a></li>
                        <li><span class="vertical-divider"></span><a href="user/logout">退出</a></li>
                    </shiro:authenticated>
                </ul>
            </div>
        </div>
    </div>


</div>

</body>
</html>
