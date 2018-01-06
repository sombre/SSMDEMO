<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2017/12/29
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>error</title>
</head>
<body>
    <h1>我们遇到了一个错误,请等待.该页面将在5秒后跳转......</h1>
    ${ex.message}
<% response.setHeader("refresh","5;URL=http://localhost:8080/ssm/");%>
</body>
</html>
