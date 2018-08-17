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
    imageEventBanding();

});

function initHeart() {
    var pictureId = $(".picture-card").text();
    var userId = $(".current-card").text();
    if (null !== userId && undefined !== userId) {
        $.ajax({
            method: "post",
            url: "picture/getCollectedPicture",
            dataType: "json",
            data: {
                "pictureId": pictureId,
                "userId": userId
            },
            success: function (data) {
                if (data.userPicture !== undefined) {
                    $(".like span").attr("class", "full_heart");
                }
                console.log(data.userPicture);
            },
            error: function (data) {
                console.log(data);
            }
        });
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
                "userId": userId,
                "pictureId": pictureId
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
                    "userId": userId,
                    "pictureId": pictureId
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


//创建评论item
function createCommentItem(data) {
    var curUserId = parseInt(getCookie("user"));
    var time = new Date(parseInt(data.comment.createAt));
    time = time.format("yyyy-MM-dd");
    var avatar = "";
    if (data.author.avatar != null) {
        avatar = data.author.avatar;
    }
    console.log(data.author.avatar);
    var commentItem =
        '<div class="comment-item">\n' +
        '    <div class="avatar">\n' +
        '        <img src="' + avatar + '" class="profile">\n' +
        '    </div>\n' +
        '    <div class="comment-info">\n' +
        '        <div class="nav">\n' +
        '            <span><a href="user/' + data.author.uid + '/picture" class="author-name">' + data.author.name + '</a></span>\n' +
        '             <div class="cards">' +
        '            <input name="author-card"  value="' + data.comment.replyTo + '"/>\n' +
        '            <input name="picture-card"   value="' + data.comment.pid + '"/>\n' +
        '            <input name="user-card"  value="' + curUserId + '"/>\n' +
        '            <input name="comment-card" value="'+data.comment.cid+'"/>'+
        '            </div>'+
        '            <span class="post-time">发表于:\n' +
        '\n' + time +
        '                        </span>\n' +
        '            <shiro:authenticated>\n' +
        '                <span class="reply"><a href="javascript:void(0);" class="show-editor">回复</a></span>\n' +
        '            </shiro:authenticated>\n' +
        '        </div>\n' +
        '        <div class="content">\n' +
        '            \n' + data.comment.content +
        '        </div>\n' +
        '    </div>\n' +
        '</div>';
    return $(commentItem);
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
                var tmp = createCommentItem(data);
                $(".comment-inner").append(tmp);
                console.log(data);
            }
        })
    }
    else {
        alert("请输入评论内容!");
    }
}


//ajax回复评论
// function doReply() {
//         var content = $(this).parents(".edit-box").find("textarea[name='edit-area']").val();
//         var parents = $(this).parents("div.comment-item");
//         console.log(parents);
//         var pictureId = parents.find("input[name='picture-card']").val();
//         var replyTo = parents.find("input[name='author-card']").val();
//         var userId = parents.find("input[name='user-card']").val();
//         var authorName = parents.find(".author-name").text();
//         console.log(authorName);
//         var reply = "回复 " + authorName + ":  ";
//         content = reply + content;
//         console.log(content);
//         if (0 !== content.length) {
//             $.ajax({
//                 method: "post",
//                 dataType: "json",
//                 url: "addReply/" + userId + "/" + pictureId,
//                 data: {
//                     "pictureId": pictureId,
//                     "replyTo": replyTo,
//                     "content": content
//                 },
//                 success: function (data) {
//                     $(".comment-inner").append(createCommentItem(data));
//                     console.log(data);
//                 },
//                 error: function (data, status) {
//                     console.log(data);
//                 }
//             });
//         }
//         else {
//             alert("回复不能为空!");
//         }
// }


function addReplyBox() {
    var commentInner = $(".comment-inner");
    commentInner.on("click", ".show-editor", function () {
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
            "                </div>"
        );

        $(".reply-btn").on("click", function () {
            var content = $(this).parents(".edit-box").find("textarea[name='edit-area']").val();
            var parents = $(this).parents("div.comment-item");
            console.log(parents);
            var pictureId = parents.find("input[name='picture-card']").val();
            var replyTo = parents.find("input[name='author-card']").val();
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
                        $(".comment-inner").append(createCommentItem(data));
                        $(".edit-box").slideUp();
                        console.log(data);
                    },
                    error: function (data, status) {
                        console.log(data);
                    }
                });
            }
            else {
                alert("回复不能为空!");
            }
        });

        $(".cancel-btn").on("click", function () {
            // $(this).parents(".edit-box").slideUp();
            $(".edit-box").slideUp().remove();
        });
    });
}


function createCheckItem(album) {
    var checkItemHtml = ' <input type="checkbox" value="' + album.albumId + '" name="album"><label>' + album.albumTitle + '</label>\n' +
        '           <br>';
    return $(checkItemHtml);
}

function appendCheckAlbumItem(data) {
    var checkAlbums = $(".check-albums");
    checkAlbums.empty();
    for (var i in data) {
        var item = createCheckItem(data[i]);
        checkAlbums.append(item);
    }
}


function showCollectedAlbums() {
    var userId = parseInt(getCookie("user"));
    var page = 0;
    var pageSize = 10;
    $.ajax({
        method: "post",
        data: {
            "userId": userId,
            "page": page,
            "pageSize": pageSize
        },
        dataType: "json",
        url: "album/getUserCreatedAlbum",
        success: function (data) {
            appendCheckAlbumItem(data);
            console.log(data);
        },
        error: function (data) {
            console.log(data);
        }
    });

    //让遮罩层铺满整个body
    $(".mask").height(pageHeight()).width(pageWidth());
    //对话框定位到页面中间
    adjust(".mask-inner");
    $(".mask-inner").show();
    // fadeTo第一个参数为速度，第二个为透明度
    // 多重方式控制透明度，保证兼容性，但也带来修改麻烦的问题
    $(".mask").fadeIn(200);

}

function addPictureToAlbum() {
    var pictureId = $(".picture-card").text();
    var checkAlbumItems = $("input[name='album']");
    console.log(pictureId);
    var checkedValue = [];
    checkAlbumItems.each(function (i) {
        var tmp = $(checkAlbumItems[i]);
        if (tmp.is(":checked")) {
            checkedValue.push(parseInt(tmp.val()));
        }
    });
    if (checkedValue.length !== 0) {
        $.ajax({
            method: "post",
            dataType: "json",
            data: {
                "pictureId": pictureId,
                "albumIds": checkedValue.toString()
            },
            url: "album/CollectPicture",
            success: function (data) {
                alert("添加成功!");
                console.log(data);
                hideMask();
            },
            error: function (data) {
                console.log(data);
            }
        });
    }
    else alert("你没选择专辑!");
}



function settingUserAvatar() {
    $(".setting-avatar").on("click",function () {
        var btn = $(this);
        var pictureId = parseInt($(".picture-card").text());
        var userId = parseInt(getCookie("user"));
        console.log(userId,pictureId);
        $.myConfirm({
            title:"提示",
            message:"将这张图片设为头像吗?",
            callback:function () {
                $.ajax({
                   method:"post",
                   dataType:"json",
                   data:{
                       "pictureId":pictureId,
                       "userId":userId
                   },
                   url:"user/settingUserAvatar",
                   success:function (data) {
                       console.log(data);
                   },
                    error:function (data) {
                        console.log(data);
                    }
                });
            }
        })
    });
}





function removeComment() {
    $(".remove-confirm").on("click",function () {
        var confirmBtn = $(this);
        var commentId = parseInt(confirmBtn.parents(".nav").find("input[name='comment-card']").val());
        $.myConfirm({
            title:"提示",
            message:"删除评论?",
            callback:function () {
                $.ajax({
                    method:"post",
                    dataType:"json",
                    data:{
                        "commentId":commentId
                    },
                    url:"comment/removeComment",
                    success:function (data) {
                        confirmBtn.parents(".comment-item").remove();
                        console.log(data);
                    },
                    error:function (data) {
                        console.log(data);
                    }
                });
            }
        });
    });
}





function imageEventBanding() {

    //显示专辑模态框
    $(".add-album").on("click", showCollectedAlbums);
    //收录图片进专辑
    $(".submit").on("click", addPictureToAlbum);
    $(".cancel").on("click", hideMask);

    //删除评论
    removeComment();

    //设定头像
    settingUserAvatar();
}










