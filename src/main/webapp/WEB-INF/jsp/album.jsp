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
    <link rel="stylesheet" href="css/myAlert.css">
    <script type="text/javascript" src="js/myAlert.js"></script>
    <script type="text/javascript" src="js/imagesloaded.js"></script>
    <script type="text/javascript" src="js/masonry.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="js/waterfall.js"></script>
    <script type="text/javascript" src="js/album.js"></script>
    <title>图片本身</title>
</head>

<body>

<div class="wrapper-box">
    <div class="cards">
        <div class="album-card">
            ${album.albumId}
        </div>
    </div>

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
            <shiro:authenticated>
                <c:if test="${sessionScope.get('user').uid ==author.uid}">
                    <div class="tabs">
                        <a href="javascript:void (0);" class="tab edit-album">编辑</a>
                        <a href="javascript:void(0);" class="tab remove-album">删除</a>
                    </div>
                </c:if>

            </shiro:authenticated>
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
                        <a href="javascript:void(0);" class="collect">${map.value.collectedNum}</a>
                        <a href="javascript:void(0);" class="like white-btn"></a>
                        <a href="javascript:void(0);" class="comment white-btn"></a>
                    </div>
                    <div class="waterfall-info">
                        <p class="title">${map.value.picTitle}</p>
                        <p class="icon">
                            <span class="icon-star">${map.value.collectedNum}</span>
                            <span class="icon-like">${map.value.thumbNum}</span>
                        </p>
                    </div>
                    <div class="collect-info">
                        <a href="#" class="headImg"><img src="${map.key.avatar}"></a>
                        <p class="title"><a href="user/${author.uid}/picture">${author.name} </a></p>
                        <p class="to">发表于:
                            <a href="javascript:void(0);">
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

<div class="mask">
</div>
<div class="mask-inner">
    <h3 class="mask-title">编辑专辑:</h3>
    <form action="#" method="post">
        <div class="album-div">
            <div class="mask-head">
                <div class="mask-albumTitle">
                    <p>
                        专辑名:
                    </p>
                    <input type="text" name="albumTitle" class="title-text"  placeholder="${album.albumTitle}">
                </div>
                <div class="mask-albumDesc">
                    <p>
                        专辑描述:
                    </p>
                    <textarea name="albumDesc" id="albumDesc" class="desc-text" cols="50" rows="10" placeholder="${album.albumDesc}"></textarea>
                </div>
            </div>
        </div>
        <div class="btn-div">
            <a  href="javascript:void(0);" class="submit" >确定</a>
            <a  href="javascript:void(0);" class="cancel" >取消</a>
        </div>
    </form>
</div>






</body>
</html>