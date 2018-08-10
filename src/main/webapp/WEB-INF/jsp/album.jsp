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
                <div class="board-name">慢慢生活</div>
                <div class="board-tag">
                    <span>所属分类: </span>
                    <a href="javascript:void(0);">仿佛听见说爱你</a>
                </div>
            </div>
            <div class="board-description">
                你Y倒是说话啊!
            </div>
        </div>
        <div class="board-bar">
            <a href="javascript:void(0);" class="user-unit">
                <img src="upload/1.jpg" alt="">
                <span class="name">潇潇呀</span>
            </a>
            <div class="tabs">
                <a href="javascript:void (0);" class="tab">编辑</a>
                <a href="javascript:void(0);" class="tab">删除</a>
            </div>
        </div>
    </div>

    <div id="waterfall" class="waterfall clearfix">
        <div class="item">
            <div class="pic">
                <a href="#"><img src="upload/1.jpg"></a>
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
                <p class="title"><a href="#">大魔王梦梦呀 </a></p>
                <p class="to">发表于 <a href="">2018-1-1</a></p>
            </div>
        </div>
        <div class="item">
            <div class="pic">
                <a href="#"><img src="upload/2.jpg"></a>
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
                <p class="title"><a href="#">大魔王梦梦呀 </a></p>
                <p class="to">发表于 <a href="">2018-1-1</a></p>
            </div>
        </div>
        <div class="item">
            <div class="pic">
                <a href="#"><img src="upload/3.jpg"></a>
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
                <p class="title"><a href="#">大魔王梦梦呀 </a></p>
                <p class="to">发表于 <a href="">2018-1-1</a></p>
            </div>
        </div>
        <div class="item">
            <div class="pic">
                <a href="#"><img src="upload/4.jpg"></a>
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
                <p class="title"><a href="#">大魔王梦梦呀 </a></p>
                <p class="to">发表于 <a href="">2018-1-1</a></p>
            </div>
        </div>
        <div class="item">
            <div class="pic">
                <a href="#"><img src="upload/5.jpg"></a>
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
                <p class="title"><a href="#">大魔王梦梦呀 </a></p>
                <p class="to">发表于 <a href="">2018-1-1</a></p>
            </div>
        </div>
        <div class="item">
            <div class="pic">
                <a href="#"><img src="upload/6.jpg"></a>
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
                <p class="title"><a href="#">大魔王梦梦呀 </a></p>
                <p class="to">发表于 <a href="">2018-1-1</a></p>
            </div>
        </div>
        <div class="item">
            <div class="pic">
                <a href="#"><img src="upload/7.jpg"></a>
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
                <p class="title"><a href="#">大魔王梦梦呀 </a></p>
                <p class="to">发表于 <a href="">2018-1-1</a></p>
            </div>
        </div>
        <div class="item">
            <div class="pic">
                <a href="#"><img src="upload/8.jpg"></a>
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
                <p class="title"><a href="#">大魔王梦梦呀 </a></p>
                <p class="to">发表于 <a href="">2018-1-1</a></p>
            </div>
        </div>
        <div class="item">
            <div class="pic">
                <a href="#"><img src="upload/9.jpg"></a>
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
                <p class="title"><a href="#">大魔王梦梦呀 </a></p>
                <p class="to">发表于 <a href="">2018-1-1</a></p>
            </div>
        </div>
        <div class="item">
            <div class="pic">
                <a href="#"><img src="upload/10.jpg"></a>
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
                <p class="title"><a href="#">大魔王梦梦呀 </a></p>
                <p class="to">发表于 <a href="">2018-1-1</a></p>
            </div>
        </div>
        <div class="item">
            <div class="pic">
                <a href="#"><img src="upload/11.jpg"></a>
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
                <p class="title"><a href="#">大魔王梦梦呀 </a></p>
                <p class="to">发表于 <a href="">2018-1-1</a></p>
            </div>
        </div>
        <div class="item">
            <div class="pic">
                <a href="#"><img src="upload/12.jpg"></a>
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
                <p class="title"><a href="#">大魔王梦梦呀 </a></p>
                <p class="to">发表于 <a href="">2018-1-1</a></p>
            </div>
        </div>
        <div class="item">
            <div class="pic">
                <a href="#"><img src="upload/13.jpg"></a>
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
                <p class="title"><a href="#">大魔王梦梦呀 </a></p>
                <p class="to">发表于 <a href="">2018-1-1</a></p>
            </div>
        </div>
        <div class="item">
            <div class="pic">
                <a href="#"><img src="upload/14.jpg"></a>
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
                <p class="title"><a href="#">大魔王梦梦呀 </a></p>
                <p class="to">发表于 <a href="">2018-1-1</a></p>
            </div>
        </div>
        <div class="item">
            <div class="pic">
                <a href="#"><img src="upload/15.jpg"></a>
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
                <p class="title"><a href="#">大魔王梦梦呀 </a></p>
                <p class="to">发表于 <a href="">2018-1-1</a></p>
            </div>
        </div>
    </div>




</div>


</body>
</html>