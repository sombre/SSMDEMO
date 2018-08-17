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
<html>
<head>
    <jsp:include page="header.jsp"/>
    <link rel="stylesheet" href="css/user.css">
    <link rel="stylesheet" href="css/waterfall.css">
    <link rel="stylesheet" href="css/signup.css">
    <script type="text/javascript" src="js/imagesloaded.js"></script>
    <script type="text/javascript" src="js/masonry.js"></script>
    <script type="text/javascript" src="js/waterfall.js"></script>
    <script type="text/javascript" src="js/pageNav.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="js/user.js"></script>
    <title>个人主页</title>
</head>

<body>


<div class="container">


    <div class="user-card">
        <div class="inner">
            <div class="inner-content">
                <div class="avatar-unit">
                    <div class="img">
                        <img src="upload/1.jpg" class="current-avatar">
                    </div>
                </div>
                <div class="head-line">
                    <div class="name">
                        ${space.name}
                    </div>
                </div>
                <div class="introduction">
                    我的天啊,这个世界真是好玩
                </div>
            </div>
            <div class="user-tabs">
                <shiro:authenticated>
                    <a href="javascript:void(0);" class="which-tab create-album">新建专辑</a>
                </shiro:authenticated>
            </div>
        </div>




        <div class="cards">
            <span class="userspace-card">${userSpaceId}</span>
        </div>
    </div>

    <div class="space-wrapper">

        <div class="space-inner">

            <div class="space-tabs clearfix">
                <ul>
                    <li><a href="javascript:void (0);" class="pic-item"><span>图片</span></a></li>
                    <li><a href="javascript:void (0);" class="album-item"><span>专辑</span></a></li>
                    <shiro:authenticated>
                        <li><a href="javascript:void (0);" class="setting-item"><span>设置</span></a></li>
                    </shiro:authenticated>
                </ul>
            </div>


            <div class="space-content">

                <div class="user-image">
                    <div class="image-scan clearfix">
                        <div class="main-waterfall">
                            <div class="main-inner-title">
                            </div>
                            <div id="waterfall" class="waterfall clearfix">
                            </div>
                        </div>

                        <div class="page-nav">
                            <div class="page-list">
                                <ul>
                                    <li><a href="#" class="pre-page">上一页</a></li>
                                    <li><a href="#" class="first-page">1</a></li>
                                    <li class="dot">...</li>
                                    <li><a href="#">4</a></li>
                                    <li><a href="#">5</a></li>
                                    <li class="cur-page">6</li>
                                    <li><a href="#">7</a></li>
                                    <li><a href="#">8</a></li>
                                    <li class="dot">...</li>
                                    <li><a href="#" class="last-page">30</a></li>
                                    <li><a href="#" class="next-page">下一页</a></li>
                                    <li><input type="text" class="go"></li>
                                    <li><a href="#" class="go-btn">Go</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="album-box clearfix">
                </div>

                <div class="user-setting">
                    <div class="setting-box">
                        <div class="setting-title"><span>修改信息</span></div>
                        <div class="modify-box">
                            <form action="http://localhost:8080/ssm/user/signupuser" method="post">
                                <div class="item clearfix">
                                    <span >用户名: </span>
                                    <input type="text"  name="Name">
                                </div>
                                <div class="item clearfix">
                                    <span>邮箱: </span>
                                    <input type="text" name="Email">
                                </div>
                                <div class="item clearfix">
                                    <span>密码: </span>
                                    <input type="password" name="Password">
                                </div >
                                <div class="item clearfix">
                                    <span>性别: </span>
                                    <input type="text" name="Gender">
                                </div>
                                <div class="item btn-box">
                                    <a href="javascript:void(0);" class="modify-btn">保存</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>

</div>


<div class="mask">
</div>
<div class="mask-inner">
    <h3 class="mask-title">新建专辑:</h3>
    <form action="#" method="post">
        <div class="album-div">
            <div class="mask-head">
                <div class="mask-albumTitle">
                    <p>
                        专辑名:
                    </p>
                    <input type="text" name="albumTitle" class="title-text"  placeholder="专辑名">
                </div>
                <div class="mask-albumDesc">
                    <p>
                        专辑描述:
                    </p>
                    <textarea name="albumDesc" id="albumDesc" class="desc-text" cols="50" rows="10" placeholder="专辑描述"></textarea>
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