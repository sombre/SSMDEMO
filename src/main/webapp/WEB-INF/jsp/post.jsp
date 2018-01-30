<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2017/12/30
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="top.jsp"/>
    <title>话题</title>
</head>

<p>发表主题:</p>
<form method="post" name="post" action="post/addpost">
    帖子主题:<input type="text" name="title">
    帖子内容:<textarea rows="" cols="" name="content"></textarea>
    <input type="submit" value="发表">
</form>

<br>
<br>

<c:out value="${collections}"></c:out>
<br>

<c:forEach var="item" items="${collections}">
    <c:forEach var="map" items="${item}">
        <c:out value="${map.key}"></c:out> : <c:out value="${map.value}"></c:out>
        <%--<c:out value="${map.key.title}"></c:out>--%>
        <br>
        <br>
    </c:forEach>
</c:forEach>
</body>
</html>
