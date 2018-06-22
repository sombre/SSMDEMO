<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2018/5/29
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    // 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath变量 
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <jsp:include page="header.jsp"/>
    <link rel="stylesheet" href="css/main.css">
    <script type="text/javascript" src="js/imagesloaded.js"></script>
    <script type="text/javascript" src="js/masonry.js"></script>
    <script type="text/javascript" src="js/jquery.skidder.js"></script>
    <script type="text/javascript" src="js/smartresize.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
    <title>main</title>

</head>
<body>


<div class="main">
    <div class="main-inner">
        <div class="banner clearfix">
            <div class="slide-part slide-body">
                <div class="slideshow" style="overflow: hidden;">
                    <div class="slide"><img src="./img/slider/img1.jpg"></div>
                    <div class="slide"><img src="./img/slider/img2.jpg"></div>
                    <div class="slide"><img src="./img/slider/img3.jpg"></div>
                    <div class="slide"><img src="./img/slider/img4.jpg"></div>
                    <div class="slide"><img src="./img/slider/img5.jpg"></div>

                </div>
            </div>

            <div class="banner-info banner-body">
                <div class="news">
                    <ul>
                        <li class="title">热门标签</li>
                        <li class="tags">
                            <a href="#">冬天</a>
                            <span></span>
                            <a href="#">时间煮雨</a>
                            <span></span>
                            <a href="#">早餐</a>
                            <span></span>
                            <a href="#">记下时间走过的路</a>
                            <span></span>
                            <a href="#">生活在别处</a>
                            <span></span>
                            <a href="#">花掩门扉</a>
                            <span></span>
                            <a href="#">穿搭</a>
                        </li>
                        <li class="title">推荐用户</li>
                        <li class="choose">
                            <ul>
                                <li><img src="upload/album/1.jpg" alt=""></li>
                                <li><img src="upload/album/2.jpg" alt=""></li>
                                <li><img src="upload/album/3.jpg" alt=""></li>
                                <li><img src="upload/album/4.jpg" alt=""></li>
                                <li><img src="upload/album/5.jpg" alt=""></li>
                            </ul>
                        </li>
                        <li class="title">新鲜事</li>
                        <li class="link">
                            <a href="#">『人气连衣裙精选』 大合集</a>
                            <span class="icon-text-pink">精选</span>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="main-album ">
            <div class="main-inner-title">
                <h3>专辑精选</h3>
                <a class="more" href="#">更多... ></a>
            </div>
            <div class="album-list clearfix">
                <ul>
                    <li>
                        <div class="item">
                            <div class="item-pic">
                                <a href="#"><img src="upload/album/1.jpg" alt=""></a>
                            </div>
                            <div class="desc">
                                <a href="#" class="title">你的书写工具需要一个庇护所</a>
                                <p>68张图片 · 2255人收藏</p>
                                <p>by <a href="#" class="author">Molloy</a>
                                </p>
                            </div>
                        </div>
                    </li>

                    <li>
                        <div class="item">
                            <div class="item-pic">
                                <a href="#"><img src="upload/album/2.jpg" alt=""></a>
                            </div>
                            <div class="desc">
                                <a href="#" class="title">你的书写工具需要一个庇护所</a>
                                <p>68张图片 · 2255人收藏</p>
                                <p>by <a href="#" class="author">Molloy</a>
                                </p>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="item">
                            <div class="item-pic">
                                <a href="#"><img src="upload/album/3.jpg" alt=""></a>
                            </div>
                            <div class="desc">
                                <a href="#" class="title">你的书写工具需要一个庇护所</a>
                                <p>68张图片 · 2255人收藏</p>
                                <p>by <a href="#" class="author">Molloy</a>
                                </p>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="item">
                            <div class="item-pic">
                                <a href="#"><img src="upload/album/4.jpg" alt=""></a>
                            </div>
                            <div class="desc">
                                <a href="#" class="title">你的书写工具需要一个庇护所</a>
                                <p>68张图片 · 2255人收藏</p>
                                <p>by <a href="#" class="author">Molloy</a>
                                </p>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="item">
                            <div class="item-pic">
                                <a href="#"><img src="upload/album/5.jpg" alt=""></a>
                            </div>
                            <div class="desc">
                                <a href="#" class="title">你的书写工具需要一个庇护所</a>
                                <p>68张图片 · 2255人收藏</p>
                                <p>by <a href="#" class="author">Molloy</a>
                                </p>
                            </div>
                        </div>
                    </li>


                </ul>
            </div>
        </div>

        <div class="main-user">
            <div class="main-inner-title">
                <h3>达人推荐</h3>
                <a href="#" class="more">更多达人></a>
            </div>
            <div class="user-list clearfix">
                <ul>
                    <li>
                        <div class="item">
                            <div class="item-pic">
                                <a href="#" class="user-background">
                                    <img src="img/cont/user_img1.jpg" alt="">
                                </a>
                                <a class="profile" href="#"><img src="img/cont/head_img1.jpg"></a>
                            </div>
                            <div class="info">
                                <a href="#" class="info-title">番茄酱</a>
                                <p><i class="icon-star"></i>1224</p>
                                <p>擅长领域: <b>建筑、设计</b></p>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="item">
                            <div class="item-pic">
                                <a href="#" class="user-background">
                                    <img src="img/cont/user_img2.jpg" alt="">
                                </a>
                                <a class="profile" href="#"><img src="img/cont/head_img2.jpg"></a>
                            </div>
                            <div class="info">
                                <a href="#" class="info-title">番茄酱</a>
                                <p><i class="icon-star"></i>1224</p>
                                <p>擅长领域: <b>建筑、设计</b></p>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="item">
                            <div class="item-pic">
                                <a href="#" class="user-background">
                                    <img src="img/cont/user_img3.jpg" alt="">
                                </a>
                                <a class="profile" href="#"><img src="img/cont/head_img3.jpg"></a>
                            </div>
                            <div class="info">
                                <a href="#" class="info-title">番茄酱</a>
                                <p><i class="icon-star"></i>1224</p>
                                <p>擅长领域: <b>建筑、设计</b></p>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="item">
                            <div class="item-pic">
                                <a href="#" class="user-background">
                                    <img src="img/cont/user_img4.jpg" alt="">
                                </a>
                                <a class="profile" href="#"><img src="img/cont/head_img4.jpg"></a>
                            </div>
                            <div class="info">
                                <a href="#" class="info-title">番茄酱</a>
                                <p><i class="icon-star"></i>1224</p>
                                <p>擅长领域: <b>建筑、设计</b></p>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="item">
                            <div class="item-pic">
                                <a href="#" class="user-background">
                                    <img src="img/cont/user_img5.jpg" alt="">
                                </a>
                                <a class="profile" href="#"><img src="img/cont/head_img5.jpg"></a>
                            </div>
                            <div class="info">
                                <a href="#" class="info-title">番茄酱</a>
                                <p><i class="icon-star"></i>1224</p>
                                <p>擅长领域: <b>建筑、设计</b></p>
                            </div>
                        </div>
                    </li>

                </ul>
            </div>

        </div>


        <div class="main-waterfall">
            <div class="main-inner-title">
                <h3>大家正在逛</h3>
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


</body>
</html>
