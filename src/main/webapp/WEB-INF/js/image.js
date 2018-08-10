$(function () {
    //初始化显示图片收藏状态
    initHeart();
    // 改变心形的样式
    var turnTo = document.getElementsByClassName("like")[0];
    turnTo.addEventListener("click", changeHeart);

    //添加评论
    $(".post-btn").on("click", addComment);
    //点击回复时,添加评论回复框
    addReplyBox();

    //模态框控制
    dialog();

});

function initHeart() {
    var pictureId = $(".picture-card").text();
    var userId = $(".current-card").text();
    if(null!==userId && undefined!==userId){
        $.ajax({
            method:"post",
            url:"picture/getCollectedPicture",
            dataType:"json",
            data:{
                "pictureId":pictureId,
                "userId":userId
            },
            success:function (data) {
                if(data.userPicture!==undefined){
                    $(".like span").attr("class","full_heart");
                }
                console.log(data.userPicture);
            },
            error:function (data) {
                console.log(data);
            }
        });
    }
}



function addComment() {
    var postBox = $(".post-box");
    postBox.find(".post-btn").attr("disabled", true);
    var content = postBox.find("textarea[name='content']").val();
    var userId = postBox.find("input[name='author-card']").val();
    var pictureId = postBox.find("input[name='picture-card']").val();
    if (0 !== content.length) {
        $.ajax({
            method: "post",
            data: {"content": content, "pictureId": pictureId},
            url: "addComment/" + userId + "/" + pictureId,
            success: function (data) {
                postBox.find(".post-btn").attr("disabled", false);
                $("#content").val("");
            }
        })
    }
    else {
        alert("请输入评论内容!");
    }

}


// 收藏图片改变心形的样式
function changeHeart() {
    var heart = document.getElementsByClassName("blank_heart")[0];
    var pictureId = $(".picture-card").text();
    var userId = $(".current-card").text();
    if (heart !== null && heart !== undefined) {
        $.ajax({
            method: "post",
            url: "picture/collectPicture",
            dataType: "json",
            data: {
                "userId":userId,
                "pictureId":pictureId
            },
            success: function (data) {
                heart.setAttribute("class", "full_heart");
                alert("收藏成功!");
            },
            error: function (data) {
                alert("收藏失败,请重试!");
            }
        });
    }
    else {
        heart = document.getElementsByClassName("full_heart")[0];
        if (heart !== null && heart !== undefined) {
            $.ajax({
                method: "post",
                url: "picture/removePicture",
                dataType: "json",
                data: {
                    "userId":userId,
                    "pictureId":pictureId
                },
                success: function (data) {
                    heart.setAttribute("class", "blank_heart");
                    alert("取消收藏!");
                },
                error: function (data) {
                    alert("收藏失败,请重试!");
                }
            });
        }
    }
}


function addReplyBox() {
    var t = $(".show-editor");
    t.on("click", function () {
        var parents = $(this).parents("div.comment-info");
        //被回复人名字
        var authorName = parents.find(".author-name").val();
        //添加回复框
        $(this).parents(".comment-item").append(
            "<div class=\"edit-box\">\n" +
            "                    <p id='replyTo'>回复:" + authorName + "</p>\n" +
            "                    <div>\n" +
            "                        <textarea name=\"edit-area\" id=\"\" cols=\"90\" rows=\"10\"></textarea>\n" +
            "                    </div>\n" +
            "                    <div class=\"btn-box\">\n" +
            "                        <a href=\"javascript:void(0);\" class=\"reply-btn\">回复</a>\n" +
            "                        <a href=\"javascript:void (0);\" class=\"cancel-btn\">取消</a>\n" +
            "                    </div>\n" +
            "                </div>");

        $(".reply-btn").on("click", function () {
            var content = $(this).parents(".edit-box").find("textarea[name='edit-area']").val();
            var parents = $(this).parents("div.comment-item");
            console.log(parents);
            var pictureId = parents.find("input[name='picture-card']").val();
            var replyTo = parents.find("input[name='replyTo-card']").val();
            var userId = parents.find("input[name='user-card']").val();
            var authorName = parents.find(".author-name").text();
            console.log(authorName);
            var reply = "回复 " + authorName + ":  ";
            content = reply + content;
            console.log(content);
            if (0 !== content.length) {
                $.ajax({
                    method: "post",
                    dataType: "json",
                    url: "addReply/" + userId + "/" + pictureId,
                    data: {
                        "pictureId": pictureId,
                        "replyTo": replyTo,
                        "content": content
                    },
                    success: function (data) {
                        console.log(data);
                    },
                    error: function (data, status) {
                        console.log(data);
                    }
                });
            }
            else {
                // alert("回复不能为空!");
            }

        });

        $(".cancel-btn").on("click", function () {
            $(this).parents(".edit-box").slideUp();
        })
    });
}



function dialog() {
    //显示专辑模态框
    $(".add-album").on("click", showMask);
    $(".cancel").on("click", hideMask);
}









