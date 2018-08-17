
$(function () {
   waterfall();
    bandingAlbumEvent();
});


function updateAlbum() {
    var albumDesc = $(".desc-text");
    var albumTitle = $(".title-text");
    var albumId = $(".album-card");
    var boardName = $(".board-name");
    var boardDesc= $(".board-description");
    $.ajax({
        method:"post",
        url:"album/updateAlbum",
        dataType:"json",
        data:{
            "albumId":albumId.text(),
            "albumTitle":albumTitle.val(),
            "albumDesc":albumDesc.val()
        },
        success:function (data) {
            boardName.empty().append(data.album.albumTitle);
            boardDesc.empty().append(data.album.albumDesc);
            alert(data.message);
            hideMask();
        },
        error:function (data) {
            console.log(data);
        }
    });
}



function deleteAlbum() {
    $.myConfirm({
        title:"注意",
        message:"确定要删除专辑吗?与专辑相关的其他资料也将被删除",
        callback:function () {
            var userId = parseInt(getCookie("user"));
            var albumId = parseInt($(".album-card").text());
            $.ajax({
                method:"post",
                dataType:"json",
                data:{
                    "userId":userId,
                    "albumId":albumId
                },
                url:"album/deleteAlbum",
                success:function (data) {
                    console.log(data.message);
                    window.location.href="user/"+userId +"/album";
                },
                error:function (data) {
                    console.log(data.message);
                }
            });
        }
    });
}



function bandingAlbumEvent() {

    //显示编辑模态框
    $(".edit-album").on("click", showMask);
    //绑定删除专辑
    $(".remove-album").on("click",deleteAlbum);

    //提交专辑更新
    $(".submit").on("click",updateAlbum);
    //绑定取消模态框
    $(".cancel").on("click", hideMask);



}






