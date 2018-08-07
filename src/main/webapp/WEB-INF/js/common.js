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