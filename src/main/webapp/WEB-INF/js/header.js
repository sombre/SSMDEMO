

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
        success: function (data, status) {
            console.log(status);
            console.log(data);
        },
        error: function (e, status) {
            console.log(status);
            console.log(e);
        }
    });

}






