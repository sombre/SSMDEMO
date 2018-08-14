<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2017/12/25
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="header.jsp"/>
    <link rel="stylesheet" href="css/album.css">
    <link rel="stylesheet" href="css/waterfall.css">
    <script type="text/javascript" src="js/imagesloaded.js"></script>
    <script type="text/javascript" src="js/masonry.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="js/waterfall.js"></script>
    <script type="text/javascript" src="js/album.js"></script>
    <title>图片本身</title>
</head>

<body>

<div class="wrapper-box">

    <div class="board">
        <div class="board-inner">
            <div class="board-line">
                <div class="board-name">${album.albumTitle}</div>
                <div class="board-tag">
                    <span>所属分类: </span>
                    <a href="javascript:void(0);">仿佛听见说爱你</a>
                </div>
            </div>
            <div class="board-description">
                ${album.albumDesc}!
            </div>
        </div>
        <div class="board-bar">
            <a href="javascript:void(0);" class="user-unit">
                <img src="upload/1.jpg" alt="">
                <span class="name">${author.name}</span>
            </a>
            <div class="tabs">
                <a href="javascript:void (0);" class="tab">编辑</a>
                <a href="javascript:void(0);" class="tab">删除</a>
            </div>
        </div>
    </div>

    <div id="waterfall" class="waterfall clearfix">
        <c:forEach var="userPictureMap" items="${albumPictureList}">
            <c:forEach var="map" items="${userPictureMap}">
                <div class="item">
                    <div class="pic">
                        <a href="picture/${map.value.picId}">
                            <img src="${map.value.url}">
                        </a>
                    </div>
                    <div class="hover-info">
                        <span class="mask"></span>
                        <a href="#" class="collect">收藏 10</a>
                        <a href="#" class="like white-btn"></a>
                        <a href="#" class="comment white-btn"></a>
                    </div>
                    <div class="waterfall-info">
                        <p class="title">无论如何,我也不会认输的!</p>
                        <p class="icon">
                            <span class="icon-star">88</span>
                            <span class="icon-like">10</span>
                        </p>
                    </div>
                    <div class="collect-info">
                        <a href="#" class="headImg"><img src="img/cont/waterfall_headImg1.jpeg"></a>
                        <p class="title"><a href="#">${author.name} </a></p>
                        <p class="to">发表于:
                            <a href="">
                                <fmt:formatDate var="creatTime" value="${Date(map.value.uploadAt)}" pattern="yyyy-MM-dd"/>
                                    ${creatTime}
                            </a>
                        </p>
                    </div>
                </div>
            </c:forEach>

        </c:forEach>


    </div>




</div>


</body>
</html>