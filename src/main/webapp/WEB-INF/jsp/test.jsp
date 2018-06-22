<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta name="content-type" content="text/html; charset=UTF-8">
    <%--<link href="css/bootstrap.css" rel="stylesheet">--%>
    <%--<link href="css/bootstrap.min.css" rel="stylesheet">--%>
    <%--<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">--%>
    <%--<link rel="stylesheet" href="style.css">--%>
    <%--<link href="css/header.css" rel="stylesheet">--%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <%--<script src="https://www.imooc.com/static/lib/jquery/1.9.1/jquery.js"></script>--%>
    <%--<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>--%>
    <script type="text/javascript" src="js/first.js"></script>
    <style>
        .grid {
            display: flex;
        }

        .grid-cell {
            flex: 1;
            border: red solid 1px;
        }

        .cell-full {
            flex: 0 0 100%;
        }

        .cell-1of2 {
            flex: 0 0 50%;
        }

        .cell-1of3 {
            flex: 0 0 33.3333%;
        }

        .cell-1of4 {
            flex: 0 0 25%;
        }


    </style>
</head>
<body>


    <ul class="nav nav-tabs">
        <li><a href="##">Home</a></li>
        <li><a href="##">CSS3</a></li>
        <li><a href="##">javaScript</a></li>
        <li><a href="##">jQuery</a></li>
        <li><a href="##">responsive</a></li>
    </ul>


    <ul class="nav nav-tabs">
        <li><a href="##">Home</a></li>
        <li><a href="##">CSS3</a></li>
        <li><a href="##">Sass</a></li>
        <li><a href="##">jQuery</a></li>
        <li><a href="##">Responsive</a></li>
    </ul>


    <div class="grid">
        <div class="grid-cell cell-1of2">dsfdsf</div>
        <div class="grid-cell">dsfsdf</div>
        <div class="grid-cell">sdfsdf</div>
    </div>


    <div class="grid">
        <div class="grid-cell cell-1of3">dsfdsf</div>
        <div class="grid-cell">dsfsdf</div>
        <div class="grid-cell">sdfsdf</div>
    </div>

    <div class="grid">
        <div class="grid-cell cell-1of4">dsfdsf</div>
        <div class="grid-cell">dsfsdf</div>
        <div class="grid-cell">sdfsdf</div>
    </div>


</body>

</html>