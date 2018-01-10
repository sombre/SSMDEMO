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
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="http://localhost:8080/ssm/js/first.js"></script>
    <title>test</title>

</head>

<script>
    function selectUser() {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                document.getElementById("test").innerHTML = xmlhttp.responseText;
            }
        }
        xmlhttp.open("GET", "user/showUserList?uid=1", true);
        xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//        var formdata = new FormData();
//        formdata.append("uid",1);
        xmlhttp.send();
    }

</script>
<body>
<jsp:include page="top.jsp"/>
<br>
<br>
<p id="test">Hello World!</p>
<button type="button" onclick="selectUser()">onclick test</button>

<br>
<br>
<p>${user.username}</p>

</body>
</html>