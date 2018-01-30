//设置cookie: cookie名，cookie值，天数
function setCookie(name, value, iDay) {
    var oDate = new Date();
    oDate.setDate(oDate.getDate() + iDay);
    document.cookie = name + '=' + value + '; expires = ' + oDate
}

//获取cookie
function getCookie(name) {
    var arr = document.cookie.split(";"); //将cookie切割成数组
    for (var i = 0; i < arr.length; i++) {
        var arr2 = arr[i].split('='); //数组元素以等号切割
        if (arr2[0] == name) {
            return arr2[1]; //获取cookie名对应的cookie值
        }
    }
    return ''; //如果没有获取到值，返回空字符串
}

//删除cookie
function removeCookie(name) {
    setCookie(name, 1, -1);
}


function selectUser() {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById("gogo").innerHTML = xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET", "user/showUserList?uid=1", true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.send();
}

function addPost() {
    var form = $(".post");
    $.ajax({
        url: "http//localhost:8080/ssm/post/addPost",
        type: "post",
        data: form.serialize(),
        processData: false,
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        success:function (data,status){
            console.log(status);
            console.log(data);
        },
        error:function (e,status) {
            console.log(status);
            console.log(e);
        }
    });

}


function login() {
    var form = $("#go");
    $.ajax({
        url: "http://localhost:8080/ssm/user/dologin",
        type: "post",
        data: form.serialize(),
        processData: false,
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        success: function (data, status) {
            var t = $("#test");
            if (data.error != undefined) {
                t.text(data.error);
            }
            else {
                var content = "user:  ";
                $.each(data.user, function (key, value) {
                    content = content + key + " : " + value + ' ';
                });
                t.text(content);
                // setCookie("user",content,1);
            }
            // console.log(getCookie("user"));
            // removeCookie("user");
            form.hide();
        },
        error: function (e, status) {
            alert(status);
        }
    });

}
