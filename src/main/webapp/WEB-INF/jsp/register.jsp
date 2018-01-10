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
    <title>注册</title>
</head>
<body>
<jsp:include page="top.jsp"/>
<form action="http://localhost:8080/ssm/user/addUser" method="post">
    UserName: <input type="text" name="username">
    Email:<input type="text" name="email">
    PassWord: <input type="password" name="password">
    Gender: <input type="text" name="gender">
    <input type="submit" value="submit">
</form>

</body>
</html>
