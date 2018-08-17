

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



//
// function login() {
//     var form = $("#go");
//     $.ajax({
//         url: "http://localhost:8080/ssm/user/dologin",
//         type: "post",
//         data: form.serialize(),
//         processData: false,
//         contentType: "application/x-www-form-urlencoded",
//         dataType: "json",
//         success: function (data, status) {
//             var t = $("#test");
//             if (data.error != undefined) {
//                 t.text(data.error);
//             }
//             else {
//                 var content = "user:  ";
//                 $.each(data.user, function (key, value) {
//                     content = content + key + " : " + value + ' ';
//                 });
//                 t.text(content);
//                 // setCookie("user",content,1);
//             }
//             // console.log(getCookie("user"));
//             // removeCookie("user");
//             form.hide();
//         },
//         error: function (e, status) {
//             alert(status);
//         }
//     });
// }
//
//
// function shirologin() {
//     var form = $("#shiro");
//     $.ajax({
//         url: "http://localhost:8080/ssm/user/doAjaxLogin",
//         type: "post",
//         data: form.serialize(),
//         processData: false,
//         contentType: "application/x-www-form-urlencoded",
//         dataType: "json",
//         success: function (data, status) {
//             var t = $("#test");
//             if (data.error != undefined) {
//                 t.text(data.error);
//             }
//             else {
//                 var content = "user:  ";
//                 $.each(data.user, function (key, value) {
//                     content = content + key + " : " + value + ' ';
//                 });
//                 t.text(content);
//                 // setCookie("user",content,1);
//             }
//             // console.log(getCookie("user"));
//             // removeCookie("user");
//             form.hide();
//             $("a[name='login']").hide();
//             $("a[name='signup']").hide();
//         },
//         error: function (e, status) {
//             console.log(e);
//             console.log(status);
//         }
//     });
// }


//   提交登陆表单
$(function(){
    $(".login-btn").click(function(){
        var href = $(this).attr("href");
        var email = $("input[name=email]").val()
        var password = $("input[name=password]").val();
        if(email.length!=0 && password.length!=0){
            $("#shiro").attr("action", href).submit();
        }
        else alert("用户名或密码为空");
        return false;
    });
});


// 校验注册表单,如果没问题,提交注册表单
$(function(){
    $(".signup-btn").click(function(){
        console.log("Hhhh");
        var href = "user/signupuser";
        var email = $("input[name=Email]").val();
        var password = $("input[name=Password]").val();
        var usrName = $("input[name=Name]");
        var gender  = $("input[name=Gender]");
        // console.log($(".sign-box form").attr("action",href));
        if(0!=email.length && 0!=password.length&& 0!=usrName.length && 0 != gender.length){
            $(".sign-box form").attr("action", href).submit();
        }
        else alert("用户名或密码为空");
        return false;
    });
});





