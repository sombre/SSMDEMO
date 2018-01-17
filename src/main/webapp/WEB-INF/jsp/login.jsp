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
    <jsp:include page="top.jsp"/>
    <title>登陆</title>
</head>
<body>
<p id ="test">
    <c:out value="${message}"></c:out>
    gasodfjm
</p>
    <form method="post" id="go" onsubmit="return false;">
        邮箱:  <input name="userEmail" type="text" autocomplete="你的用户名">
        密码:    <input name="userPassword" type="password" autocomplete="你的密码">
        <input type="submit" value="提交" onclick="login()">   <a href="/index">忘记密码?</a>
    </form>


<%--<button type="button" onclick="testforit()">onclick test</button>--%>

<br>
<br>
<br>

<%--<form method="post" action="http://localhost:8080/ssm/user/doLogin" name="zhijie">--%>
    <%--邮箱:  <input name="userEmail" type="text">--%>
    <%--密码:    <input name="userPassword" type="password">--%>
    <%--<input type="submit" >       <a href="/index">忘记密码?</a>--%>
<%--</form>--%>


</body>
</html>
