

$(function () {
    // 改变心形的样式
    var doit = document.getElementsByClassName("like")[0];
    doit.addEventListener("click",changeHeart);
    console.log(doit);

    
    
    $("post").on("click",function () {
        
    });
    
    
    //绑定添加评论回复框
    addReplyBox();

    $(".add-album").on("click",showMask);
    $(".cancel").on("click",hideMask);
});



function addComment() {

}


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
        var authorName = $(this).parents().find(".author-name").text();
        //添加回复框
        $(this).parents(".comment-item").append("                <div class=\"edit-box\">\n" +
            "                    <p id='replyTo'>回复:"+authorName+"</p>\n" +
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











