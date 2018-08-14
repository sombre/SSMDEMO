<%@ page import="java.util.Date" %>
<%@ page import="com.ssm.model.Picture" %><%--
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
    <link rel="stylesheet" href="css/image.css">
    <script type="text/javascript" src="js/image.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <title>图片本身</title>
</head>

<body>

<div class="image-box">
    <div class="cards">
        <span class="picture-card">${picture.picId}</span>
        <span class="author-card">${picture.uploaderId}</span>
        <span class="current-card">${sessionScope.user.uid}</span>
    </div>
    <div class="image-inner">
        <div class="image-header">
            <div class="space-wrapper">
                <div class="profile-box">
                    <a href="#">
                        <img src="${author.avatar}" class="profile">
                    </a>
                </div>
                <div class="user-name">
                    <a href="#">
                        ${author.name}
                    </a>
                </div>
                <div class="post-time">
                    <fmt:formatDate var="reTime" value="${Date(picture.uploadAt)}" pattern="yyyy-MM-dd"/>
                    ${reTime}
                </div>
                <shiro:authenticated>
                    <div class="heart">
                        <a href="javascript:void(0);" class="like">
                            <span class="blank_heart"></span>
                        </a>
                        <a href="javascript:void(0);" class="add-album">加入专辑</a>
                    </div>
                </shiro:authenticated>
            </div>
        </div>
        <div class="image-desc">
            <p>${picture.picDesc}</p>
        </div>
        <div class="image-content">
            <div class="img">
                <img src="${picture.url}" class="adapted">
            </div>
        </div>

        <div class="comment-box">
            <c:forEach var="commentMap" items="${userCommentList}">
                <c:forEach var="map" items="${commentMap}">
                <div class="comment-item">
                <div class="avatar">
                    <img src="${map.key.avatar}" class="profile">
                </div>
                <div class="comment-info">
                    <div class="nav">
                        <span><a href="#" class="author-name">${map.key.name}</a></span>
                        <input name="replyTo-card" style="display:none" value="${map.key.uid}"/>
                        <input name="picture-card" style="display:none"  value="${picture.picId}"/>
                        <input name="user-card" style="display:none"  value="${sessionScope.user.uid}"/>
                        <span class="post-time">发表于:
                            <fmt:formatDate var="creatTime" value="${Date(map.value.createAt)}" pattern="yyyy-MM-dd"/>
                                ${creatTime}
                        </span>
                        <shiro:authenticated>
                            <span class="reply"><a href="javascript:void(0);" class="show-editor">回复</a></span>
                        </shiro:authenticated>
                    </div>
                    <div class="content">
                            ${map.value.content}
                    </div>
                </div>
            </div>
                </c:forEach>
            </c:forEach>


            <shiro:authenticated>
            <div class="to-post">
                <span>我来说两句</span>
            </div>
            <div class="post-box">
                <form method="post" class="clearfix">
                    <div class="avatar">
                        <img src="${sessionScope.user.avatar}" class="profile">
                    </div>
                    <div class="post-content">
                        <textarea name="content" id="content" cols="90" rows="10"></textarea>
                    </div>
                    <div>
                        <input name="author-card" style="display:none" value="${sessionScope.user.uid}"/>
                        <input name="picture-card" style="display:none"  value="${picture.picId}"/>
                    </div>
                    <div>
                        <span><a href="javascript:void (0);" class="post-btn">发表评论</a></span>
                    </div>
                </form>
            </div>
            </shiro:authenticated>

            <shiro:notAuthenticated>
                <div class="unlogined">
                    评论?请<a href="login">登录</a>或者<a href="user/signup">注册</a>
                </div>
            </shiro:notAuthenticated>

        </div>





        <div class="mask">
        </div>
        <div class="mask-inner">
            <h3 class="mask-title">添加到专辑:</h3>
            <form action="#" method="post">
                <div class="album-div">
                    <table>
                        <tr>
                            <td>专辑名：</td>
                            <td class="zhezhao_value">
                                <input type="checkbox" name="album" value="Bike"> 夏天在静静地流淌
                                <br>
                                <input type="checkbox" name="album" value="Car"> I have a car
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="btn-div">
                    <input type="submit" class="submit" value="确定" />
                    <input type="button" class="concel" value="取消" onclick="hideMask()" />
                    <input type="reset" class="reset" value="清空"  />
                </div>
            </form>
        </div>



    </div>
</div>


</body>
</html>