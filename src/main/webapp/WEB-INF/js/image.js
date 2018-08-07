

$(function () {
    // 改变心形的样式
    var doit = document.getElementsByClassName("like")[0];
    doit.addEventListener("click",changeHeart);
    console.log(doit);

    //绑定添加评论回复框
    addReplyBox();

    $(".add-album").on("click",showMask);
    $(".cancel").on("click",hideMask);
})


// 收藏图片改变心形的样式
function changeHeart(){
    var hh= document.getElementsByClassName("blank_heart")[0];
    if(hh!=null && hh!=undefined){
        hh.setAttribute("class","full_heart");
    }
    else{
        hh = document.getElementsByClassName("full_heart")[0];
        if(hh!=null && hh!=undefined){
            hh.setAttribute("class","blank_heart");
        }
    }
    console.log(hh);
}



function addReplyBox() {
    var t =$(".show-editor");
    t.on("click",function () {
        //被回复人名字
        var authorName = $(this).parents().find(".author-name").text()
        //添加回复框
        $(this).parents(".comment-item").append("                <div class=\"edit-box\">\n" +
            "                    <p>回复:"+authorName+"</p>\n" +
            "                    <div>\n" +
            "                        <textarea name=\"edit-area\" id=\"\" cols=\"90\" rows=\"10\"></textarea>\n" +
            "                    </div>\n" +
            "                    <div class=\"btn-box\">\n" +
            "                        <a href=\"javascript:void(0);\" class=\"reply-btn\">回复</a>\n" +
            "                        <a href=\"javascript:void (0);\" class=\"cancel-btn\">取消</a>\n" +
            "                    </div>\n" +
            "                </div>");
        $(".cancel-btn").on("click",function(){
            // $(".edit-box").slideUp();
            $(this).parents(".edit-box").slideUp();
        })
    });
}





/* 显示遮罩层 */
function showMask() {
    //让遮罩层铺满整个body
    $(".mask").height(pageHeight()).width(pageWidth());
    //对话框定位到页面中间
    adjust(".mask-inner");
    $(".mask-inner").show();
    // fadeTo第一个参数为速度，第二个为透明度
    // 多重方式控制透明度，保证兼容性，但也带来修改麻烦的问题
    $(".mask").fadeIn(200);
}

/* 隐藏覆盖层 */
function hideMask() {
    $(".mask-inner").fadeOut(200);
    $(".mask").fadeOut(200);
}

/* 当前页面高度 */
function pageHeight() {
    return document.body.scrollHeight;
}

/* 当前页面宽度 */
function pageWidth() {
    return document.body.scrollWidth;
}



/* 定位到页面中心 */
function adjust(id) {
    var w = $(id).width();
    var h = $(id).height();

    var t = scrollY() + (windowHeight()/2) - (h/2);
    if(t < 0) t = 0;

    var l = scrollX() + (windowWidth()/2) - (w/2);
    if(l < 0) l = 0;

    $(id).css({left: l+'px', top: t+'px'});
}

//浏览器视口的高度
function windowHeight() {
    var de = document.documentElement;

    return self.innerHeight || (de && de.clientHeight) || document.body.clientHeight;
}

//浏览器视口的宽度
function windowWidth() {
    var de = document.documentElement;

    return self.innerWidth || (de && de.clientWidth) || document.body.clientWidth
}

/* 浏览器垂直滚动位置 */
function scrollY() {
    var de = document.documentElement;

    return self.pageYOffset || (de && de.scrollTop) || document.body.scrollTop;
}

/* 浏览器水平滚动位置 */
function scrollX() {
    var de = document.documentElement;

    return self.pageXOffset || (de && de.scrollLeft) || document.body.scrollLeft;
}






