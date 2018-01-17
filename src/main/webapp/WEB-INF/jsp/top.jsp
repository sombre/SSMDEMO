<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2018/1/8
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/first.js"></script>
</head>
<body>
<a href="index">主页</a>
<a href="post/showpost">主题</a>
<a href="login">登陆</a>
<a href="user/register">注册</a>

<p>居然不能显示中文,有毒啊</p>
</body>
</html>
