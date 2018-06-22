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
    <title>登陆</title>
</head>
<body>
<p id="test">
    <c:out value="${message}"></c:out>
    gasodfjm
</p>


<form method="post" id="shiro" action="user/doLogin">
    邮箱: <input name="email" type="text" autocomplete="你的用户名">
    密码: <input name="password" type="password" autocomplete="你的密码">
    <input type="checkbox" name="checked" value="true">记住我
    <input type="submit" value="ajax提交" onclick="shirologin()"> <a href="index">忘记密码?</a>
    <input type="submit" value="直接提交">
</form>


<%--<button type="button" onclick="testforit()">onclick test</button>--%>

<br>
<br>
<br>



</body>
</html>
