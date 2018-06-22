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
    <title>注册</title>
</head>
<body>
<form action="http://localhost:8080/ssm/user/signupuser" method="post">
    UserName: <input type="text" name="Name">
    Email:<input type="text" name="Email">
    PassWord: <input type="password" name="Password">
    Gender: <input type="text" name="Gender">
    <input type="submit" value="submit">
</form>

</body>
</html>
