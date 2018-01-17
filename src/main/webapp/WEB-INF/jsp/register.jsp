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
    <jsp:include page="top.jsp"/>
    <title>注册</title>
</head>
<body>
<form action="http://localhost:8080/ssm/user/addUser" method="post">
    UserName: <input type="text" name="userName">
    Email:<input type="text" name="userEmail">
    PassWord: <input type="password" name="userPassword">
    Gender: <input type="text" name="userGender">
    <input type="submit" value="submit">
</form>

</body>
</html>
