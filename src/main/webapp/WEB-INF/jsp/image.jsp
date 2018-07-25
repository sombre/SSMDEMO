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
    <link rel="stylesheet" href="css/image.css">
    <script type="text/javascript" src="js/image.js"></script>
    <title>图片本身</title>
</head>


<style>

</style>
<script>
//function changeHeart(){
//    var hh= document.getElementsByClassName("blank_heart")[0];
//    if(hh!=null && hh!=undefined){
//        hh.setAttribute("class","full_heart");
//    }
//    else{
//        hh = document.getElementsByClassName("full_heart")[0];
//        if(hh!=null && hh!=undefined){
//            hh.setAttribute("class","blank_heart");
//        }
//    }
//
//    console.log(hh);
//}
//$(function () {
//    var doit = document.getElementsByClassName("like")[0];
//    doit.addEventListener("click",changeHeart);
//    console.log(doit);
//})
</script>


<body>
<div class="image-box">
    <div class="image-inner">
        <div class="image-header">
            <div class="user-box">
                <div class="profile-box"><a href="#"><img src="upload/album/1.jpg" class="profile"></a></div>
                <div class="user-name"><a href="#">我就是我</a></div>
                <div class="post-time">2018年5月25日 14:43:25</div>
                <div class="heart">
                    <a href="javascript:void(0);" class="like">
                        <span class="blank_heart"></span>
                    </a>
                    <a href="javascript:void(0);" class="add-album">加入专辑</a>
                </div>
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
                        <shiro:authenticated>
                            <span class="reply"><a href="javascript:void(0);" class="show-editor">回复</a></span>
                        </shiro:authenticated>
                    </div>
                    <div class="content">
                        <p>时代之音，没说的
                                到底是为什么呢哈哈哈
                            我就是这么帅,你有什么办法吗
                            有种来打我啊,我就是这么吊
                            哈哈哈哈哈,我就是狂霸酷吊炫的代表
                            你要来不要,要来就干
                            不来就滚
                            我就是这么有个性啊
                            16461.135434156454
                            154313496874643203.
                            6046046764643203
                            54345614678941.32465456
                            21443464946312
                            241654631631</p>
                    </div>
                </div>
                <%--<div class="edit-box">--%>
                    <%--<p>回复:西游洞府</p>--%>
                    <%--<div>--%>
                        <%--<textarea name="edit-area" id="" cols="90" rows="10"></textarea>--%>
                    <%--</div>--%>
                    <%--<div class="btn-box">--%>
                        <%--<a href="javascript:void(0);" class="reply-btn">回复</a>--%>
                        <%--<a href="javascript:void (0);" class="cancel-btn">取消</a>--%>
                    <%--</div>--%>
                <%--</div>--%>
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