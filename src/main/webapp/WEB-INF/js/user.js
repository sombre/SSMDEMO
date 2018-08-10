
$().ready(function(){
    waterfall();
    var tabMenuLi = $(".tab-menu li");
    var userId=$(".userspace-card").text();
    //初始化选项卡
    initTab(userId);

    //绑定选项卡点击事件
    tabMenuLi.click(function(){
        //通过 .index()方法获取元素下标，从0开始，赋值给index变量
        var _index = $(this).index();
        //图片选项卡,读取用户图片
        if(_index===0){
            console.log(userId);
            getPictureData(userId,appendItemToWaterFall);
        }
        //专辑选项卡,读取用户专辑
        if(_index===1){

        }
        //设置选项卡,读取用户资料,可以修改
        if(_index===2){

        }
        //让内容框的第 _index 个显示出来，其他的被隐藏
        $(".tab-box>div").eq(_index).show().siblings().hide();
        //改变选中时候的选项框的样式，移除其他几个选项的样式
        $(this).addClass("change").siblings().removeClass("change");
        // ===============瀑布流==============
        waterfall();
    });

    //根据url的不同,显示不同的选项卡
    waterfall();
    var tabBox = $(".tab-box");
    var location = window.location.pathname;
    displayByUrl(tabMenuLi,tabBox,location);


});


function initTab(userId) {
    $(".tab-menu li:first-child ").addClass("change");
    getPictureData(userId,appendItemToWaterFall);
}





//获取当前用户空间的图片资料
function getPictureData(userId,callBack) {
    var items = $("#waterfall").find("div.item");
    var page = Math.floor(items.length/10)+1;
    $.ajax({
        method: "POST",
        url: "user/" + userId + "/picture/" + page,
        dataType: "json",
        async:true,
        content: "application/x-www-form-urlencoded",
        success: function (data) {
            console.log(data);
            callBack(data);
        },
        error: function (data) {
            alert("error");
            console.log(data);
        }
    });
}



//创建瀑布流item
function createPictureItem(user, picture) {
    var string_timestamp = picture.uploadAt;// String时间戳
    var time = new Date(parseInt(string_timestamp));
    time = time.Format("yyyy-MM-dd");
    var itemHtml = '            <div class="item">\n' +
        '                                <div class="pic">\n' +
        '                                    <a href="picture/'+picture.picId+'"><img src="'+picture.url+'"></a>\n' +
        '                                </div>\n' +
        '                                <div class="hover-info">\n' +
        '                                    <span class="mask"></span>\n' +
        '                                    <a href="#" class="collect">收藏 10</a>\n' +
        '                                    <a href="#" class="like white-btn"></a>\n' +
        '                                    <a href="#" class="comment white-btn"></a>\n' +
        '                                </div>\n' +
        '                                <div class="waterfall-info">\n' +
        '                                    <p class="title">'+ picture.picTitle+'</p>\n' +
        '                                    <p class="icon">\n' +
        '                                        <span class="icon-star">88</span>\n' +
        '                                        <span class="icon-like">10</span>\n' +
        '                                    </p>\n' +
        '                                </div>\n' +
        '                                <div class="collect-info">\n' +
        '                                    <a href="#" class="headImg">' +
        '                                           <img src="'+picture.url+'">' +
        '                                   </a>\n' +
        '                                    <p class="title"><a href="#">'+user.name+' </a></p>\n' +
        '                                    <p class="to">发表于 <a href="">'+time+'</a></p>\n' +
        '                                </div>\n' +
        '                            </div>' ;
    return $(itemHtml);
}

//将瀑布流item更新到waterfall
function appendItemToWaterFall(data) {
    var user,pictures;
    for(var i in data){
        user = $.parseJSON(i);
        pictures = data[i];
    }
    var waterFall = $("#waterfall");
    waterFall.masonry({
        itemSelector: '.item',
        columnWidth: 0,
        gutter: 0,
        transitionDuration: 0,
        isAnimated: true,
        flowWidth: true,//自定义参数
        //假如这个参数为真,容器container的宽度为100,列宽度为30,则列数应该为100/30=3.333
        //四舍五入,3.33取3.假如列宽度为28,则列数为100/28=3.57...,这个时候列数会取为4,即四舍五入.
    });
    for(i=0;i<pictures.length;i++){
        var item = createPictureItem(user,pictures[i]);
        waterFall.append(item).masonry("appended",item);
    }
    waterfall();
}




function getAlbumData(userId,callBack) {
    var items = $("#waterfall").find("div.item");
    var page = Math.floor(items.length/10)+1;
    $.ajax({
        method: "POST",
        url: "user/" + userId + "/album/" + page,
        dataType: "json",
        async:true,
        content: "application/x-www-form-urlencoded",
        success: function (data) {
            callBack(data);
        },
        error: function (data) {
            console.log(data);
        }
    });
}




function displayByUrl(tabMenuLi,tabBox,location) {
    if((-1) !== location.search(/picture/)){
        tabBox.find(".user-image").show().siblings().hide();
        var userId = $(".userspace-card").text();
        getPictureData(userId,appendItemToWaterFall);
        tabMenuLi.eq(0).addClass("change").siblings().removeClass("change");
    }
    if((-1)!==location.search(/album/)){
        tabBox.find(".album-box").show().siblings().hide();
        userId = getCookie("user");
        // data = getAlbumData(userId);
        tabMenuLi.eq(1).addClass("change").siblings().removeClass("change");
    }

}


















/**
 * When scrolled all the way to the bottom, add more tiles
 */
function onUserPageScroll(pageNum) {
    // Check if we're within 100 pixels of the bottom edge of the broser window.
    var winHeight = window.innerHeight ? window.innerHeight : $window.height(), // iphone fix
        closeToBottom = ($window.scrollTop() + winHeight > $document.height() - 100);
    if (closeToBottom) {
        // Get the first then items from the grid, clone them, and add them to the bottom of the grid
        var $container = $("#waterfall");
        var $items = $('div.item', $container),
            $firstTen = $items.slice(0, 14).clone().css('opacity', 0);
        var $itemCount = $items.length;
        if ($itemCount < 50) {
            $container.masonry({
                itemSelector: '.item',
                columnWidth: 0,
                gutter: 0,
                transitionDuration: 0,
                isAnimated: true,
                flowWidth: true //自定义参数
                //假如这个参数为真,容器container的宽度为100,列宽度为30,则列数应该为100/30=3.333
                //四舍五入,3.33取3.假如列宽度为28,则列数为100/28=3.57...,这个时候列数会取为4,即四舍五入.
            });
            // var userId = getCookie("user");
            // $.ajax({
            //     type:"POST",
            //     contentType: "application/x-www-form-urlencoded",
            //     url:"/picture/" + userId+"/picture/"+pageNum,
            //     dataType: "json",
            //     success: function (data) {
            //         alert(data);
            //     },
            //     error:function (data) {
            //         alert(data);
            //     }
            // });
            $container.append($firstTen).masonry('appended', $firstTen);
        }
    }
}






function dialog() {
    //显示专辑模态框
    $(".add-album").on("click", showMask);
    $(".cancel").on("click", hideMask);
}







