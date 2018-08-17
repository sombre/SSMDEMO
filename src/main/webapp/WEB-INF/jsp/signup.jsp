<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2017/12/25
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="header.jsp"/>
    <link href="css/signup.css" rel="stylesheet">
    <script type="text/javascript" src="js/signup.js"></script>
    <title>注册</title>
</head>
<body>

    <div class="signup">
        <div class="signup-title"><span>注册</span></div>
        <div class="sign-box">
            <form action="user/signupuser" method="post">
                <div class="item clearfix">
                    <span >用户名: </span>
                    <input type="text"  name="Name">
                </div>
                <div class="item clearfix">
                    <span>邮箱: </span>
                    <input type="text" name="Email">
                </div>
                <div class="item clearfix">
                    <span>密码: </span>
                    <input type="password" name="Password">
                </div >
                <div class="item clearfix">
                    <span>性别: </span>
                    <input type="text" name="Gender">
                </div>
                <div class="item btn-box">
                    <a href="javascript:void(0);" class="signup-btn">注册</a>
                </div>
            </form>
        </div>
    </div>






</body>
</html>
