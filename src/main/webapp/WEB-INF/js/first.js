function selectUser() {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById("gogo").innerHTML = xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET", "user/showUserList?uid=1", true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//        var formdata = new FormData();
//        formdata.append("uid",1);
    xmlhttp.send();
}


function login() {
    var form = $("#go");
        $.ajax({
            url: "http://localhost:8080/ssm/user/doLogin",
            type: "post",
            data: form.serialize(),
            processData: false,
            contentType: "application/x-www-form-urlencoded",
            dataType:"json",
            success: function (data,status) {
                var t = $("#test");
                if(data.error!=undefined){
                    t.text(data.error);
                }
                else{
                    var content ="user:  ";
                    $.each(data.user,function (key,value) {
                        content = content+key+" : "+value+' ';
                    });
                    t.text(content);
                }
                form.hide();
            },
            error: function (e,status) {
                alert(status);
            }
        });

}



function testforit() {


}