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
    <jsp:include page="header.jsp"/>
    <link rel="stylesheet" href="css/user.css">
    <link rel="stylesheet" href="css/waterfall.css">
    <link rel="stylesheet" href="css/signup.css">
    <script type="text/javascript" src="js/imagesloaded.js"></script>
    <script type="text/javascript" src="js/masonry.js"></script>
    <script type="text/javascript" src="js/waterfall.js"></script>
    <script type="text/javascript" src="js/pageNav.js"></script>
    <title>个人主页</title>
</head>
<script>
    $().ready(function(){
        waterfall();
        $(".tab-menu li:first-child ").addClass("change");
        $(".tab-menu li").click(function(){
            //通过 .index()方法获取元素下标，从0开始，赋值给某个变量
            var _index = $(this).index();
            //让内容框的第 _index 个显示出来，其他的被隐藏
            $(".tab-box>div").eq(_index).show().siblings().hide();
            //改变选中时候的选项框的样式，移除其他几个选项的样式
            $(this).addClass("change").siblings().removeClass("change");
            // ===============瀑布流==============
            waterfall();
        });
    });
</script>


<body>

<div class="user-box">
    <div class="tab">
        <div class="tab-menu clearfix">
            <ul>
                <li><a href="javascript:void (0);"><span>图片</span></a></li>
                <li><a href="javascript:void (0);"><span>专辑</span></a></li>
                <li><a href="javascript:void (0);"><span>设置</span></a></li>
            </ul>
        </div>
        <div class="tab-box">

            <div class="user-image">
                <div class="image-scan clearfix">
                    <%--<ul>--%>
                        <%--<li>--%>
                            <%--<div class="image-item">--%>
                                <%--<div class="image-inner">--%>
                                    <%--<img src="upload/1.jpg" class="collected-image">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<div class="image-item">--%>
                                <%--<div class="image-inner">--%>
                                    <%--<img src="upload/1.jpg" class="collected-image">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<div class="image-item">--%>
                                <%--<div class="image-inner">--%>
                                    <%--<img src="upload/1.jpg" class="collected-image">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<div class="image-item">--%>
                                <%--<div class="image-inner">--%>
                                    <%--<img src="upload/1.jpg" class="collected-image">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</li>--%>
                    <%--</ul>--%>
                    <div class="main-waterfall">
                        <div class="main-inner-title">
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
            <div class="album-box clearfix">
                <div class="album-item">
                        <div class="album-avatar">
                            <div>
                                <a href="javascript:void(0);">
                                    <img src="upload/1.jpg" class="album-profile">
                                </a>
                            </div>

                        </div>
                        <div class="album-info">
                            <h3>专辑名字</h3>
                            <p>224图片 · 4319收藏</p>
                        </div>
                    </div>
                <div class="album-item">
                    <div class="album-avatar">
                        <div>
                            <a href="javascript:void(0);">
                                <img src="upload/1.jpg" class="album-profile">
                            </a>
                        </div>

                    </div>
                    <div class="album-info">
                        <h3>专辑名字</h3>
                        <p>224图片 · 4319收藏</p>
                    </div>
                </div>
                <div class="album-item">
                    <div class="album-avatar">
                        <div>
                            <a href="javascript:void(0);">
                                <img src="upload/1.jpg" class="album-profile">
                            </a>
                        </div>

                    </div>
                    <div class="album-info">
                        <h3>专辑名字</h3>
                        <p>224图片 · 4319收藏</p>
                    </div>
                </div>
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



            <div>789</div>


        </div>
    </div>
</div>



</body>
</html>