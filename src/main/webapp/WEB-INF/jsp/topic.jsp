<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2017/12/30
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>话题</title>
</head>
<body>
<%--<c:out value="${collections}"></c:out>--%>
<c:forEach var="item" items="${collections}">
    <c:forEach var="map" items="${item}">
        <c:out value="${map.key}"></c:out> : <c:out value="${map.value}"></c:out>
        <br>
    </c:forEach>
</c:forEach>
</body>
</html>
