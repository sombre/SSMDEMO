//设置cookie: cookie名，cookie值，天数
function setCookie(name, value, iDay) {
    var oDate = new Date();
    oDate.setDate(oDate.getDate() + iDay);
    document.cookie = name + '=' + value + '; expires = ' + oDate
}

//获取cookie
function getCookie(name) {
    var arr = document.cookie.split(";"); //将cookie切割成数组
    console.log(arr);
    for (var i = 0; i < arr.length; i++) {
        var arr2 = arr[i].split('='); //数组元素以等号切割
        console.log(arr2);
        if (arr2[0].toString() === name) {
            return arr2[1]; //获取cookie名对应的cookie值
        }
    }
    return ''; //如果没有获取到值，返回空字符串
}

//删除cookie
function removeCookie(name) {
    setCookie(name, 1, -1);
}


//格式化日期函数
Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};






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