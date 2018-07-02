<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2017/12/25
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<head>
    <jsp:include page="header.jsp"/>
    <link rel="stylesheet" href="css/image.css">
    <title>图片本身</title>
</head>
<body>

<div class="image-box">
    <div class="image-inner">
        <div class="image-header">
            <div class="user-box">
                <div class="profile-box"><a href="#"><img src="upload/album/1.jpg" class="profile"></a></div>
                <div class="user-name"><a href="#">我就是我</a></div>
                <div class="post-time">2018年5月25日 14:43:25</div>
            </div>
        </div>
        <div class="image-desc">
            <p>这到底是个啥</p>
        </div>
        <div class="image-content">
            <div class="img">
                <img src="upload/album/2.jpg" class="adapted">
            </div>
        </div>

        <div class="comment-box">
            <div class="comment-item">
                <div class="avatar">
                    <img src="upload/album/3.jpg" class="profile">
                </div>
                <div class="comment-info">
                    <div class="nav">
                        <span><a href="#" class="author-name">西游动物</a></span>
                        <span class="post-time">发表于:2018-9-10</span>
                        <span class="reply"><a href="#">回复</a></span>
                    </div>
                    <div class="content"><p>时代之音，没说的</p>
                    </div>
                </div>
            </div>

            <shiro:authenticated>
            <div class="to-post">
                <span>我来说两句</span>
            </div>
            <div class="post-box">
                <form method="post" class="clearfix">
                    <div class="avatar">
                        <img src="upload/album/4.jpg" class="profile">
                    </div>
                    <div class="post-content">
                        <textarea name="content" cols="90" rows="10"></textarea>
                    </div>
                    <div>
                        <span><a href="#" class="post-btn">发表评论</a></span>
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




    </div>
</div>


</body>
</html>