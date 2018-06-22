<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2017/12/25
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<head>
    <jsp:include page="main.jsp"/>
    <title>主页</title>
</head>
<body>
<br>
<br>
<p id="gogo">Hello World!</p>
<button type="button" onclick="selectUser()">onclick test</button>

<br>
<br>
<p>${user}</p>

</body>
</html>