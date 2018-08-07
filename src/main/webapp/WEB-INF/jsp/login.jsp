<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2018/1/10
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="header.jsp"/>
    <link href="css/login.css" rel="stylesheet">
    <script type="text/javascript" src="js/signup.js"></script>
    <title>登陆</title>
</head>
<body>

<div class="login">
    <div class="login-title"><span>登陆</span></div>
    <div class="login-box">
        <form method="post" id="shiro" action="user/doLogin">
            <div class="item">
                <span>邮箱: </span>
                <input name="email" type="text" autocomplete="你的用户名">
            </div>
            <div class="item">
                <span>密码: </span>
                <input name="password" type="password" autocomplete="你的密码">
            </div>
            <div class="item">
                <div class="check-box">
                    <input class="login-check"  type="checkbox" name="checked" value="true" >记住我
                </div>
            </div>
            <div class="item">
                <a href="user/doLogin" class="login-btn">登陆</a>
                <a href="index" class="forget-pwd">忘记密码?</a>
            </div>
        </form>
    </div>
</div>

</body>
</html>
