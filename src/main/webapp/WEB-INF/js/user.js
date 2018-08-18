$().ready(function () {
    waterfall();
    var tabMenuLi = $(".space-tabs li");
    var userId = $(".userspace-card").text();
    //初始化选项卡
    initTab(userId);
    //绑定选项卡点击事件
    tabMenuLi.click(function () {
        //通过 .index()方法获取元素下标，从0开始，赋值给index变量
        var _index = $(this).index();
        //图片选项卡,读取用户图片
        if (_index === 0) {
            getPictureData(userId, appendItemToWaterFall);
        }
        //专辑选项卡,读取用户专辑
        if (_index === 1) {
            getAlbumData(userId, appendItemToAlbum);
        }
        //设置选项卡,读取用户资料,可以修改
        if (_index === 2) {

        }
        //让内容框的第 _index 个显示出来，其他的被隐藏
        $(".space-content>div").eq(_index).show().siblings().hide();
        //改变选中时候的选项框的样式，移除其他几个选项的样式
        $(this).addClass("change").siblings().removeClass("change");

        // ===============瀑布流==============
        waterfall();
    });

    waterfall();

    dialog();
    //根据url的不同,显示不同的选项卡
    var tabBox = $(".space-content");
    var location = window.location.pathname;
    displayByUrl(tabMenuLi, tabBox, location);
});


function initTab(userId) {
    $(".space-tabs li:first-child ").addClass("change");
}


//获取当前用户空间的图片资料
function getPictureData(userId, callBack) {
    var items = $("#waterfall").find("div.item").length;
    var pageSize = 10;
    var page = Math.ceil(parseInt(items) / pageSize) + 1;
    $.ajax({
        method: "POST",
        url: "user/" + userId + "/picture/" + page,
        data: {
            "pageSize": pageSize
        },
        dataType: "json",
        async: true,
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
    user = $.parseJSON(user);
    var string_timestamp = picture.uploadAt;// String时间戳
    var time = new Date(parseInt(string_timestamp));
    time = time.format("yyyy-MM-dd");
    var itemHtml = '            <div class="item">\n' +
        '                                <div class="pic">\n' +
        '                                    <a href="picture/' + picture.picId + '"><img src="' + picture.url + '"></a>\n' +
        '                                </div>\n' +
        '                                <div class="hover-info">\n' +
        '                                    <span class="mask"></span>\n' +
        '                                    <a href="javascript:void(0);" class="collect">收藏 ' + picture.collectedNum + '</a>\n' +
        '                                    <a href="javascript:void(0);" class="like white-btn"></a>\n' +
        '                                    <a href="javascript:void(0);" class="comment white-btn"></a>\n' +
        '                                </div>\n' +
        '                                <div class="waterfall-info">\n' +
        '                                    <p class="title">' + picture.picTitle + '</p>\n' +
        '                                    <p class="icon">\n' +
        '                                        <span class="icon-star">' + picture.collectedNum + '</span>\n' +
        '                                        <span class="icon-like">' + picture.thumbNum + '</span>\n' +
        '                                    </p>\n' +
        '                                </div>\n' +
        '                                <div class="collect-info">\n' +
        '                                    <a href="#" class="headImg">' +
        '                                           <img src="' + user.avatar + '">' +
        '                                   </a>\n' +
        '                                    <p class="title"><a href="user/' + picture.uploaderId + '/picture">' + user.name + ' </a></p>\n' +
        '                                    <p class="to">发表于 <a href="">' + time + '</a></p>\n' +
        '                                </div>\n' +
        '                            </div>';
    return $(itemHtml);
}

//将瀑布流item更新到waterfall
function appendItemToWaterFall(data) {
    var spaceOwner = data.spaceOwner;
    var pictureDataList = data.pictureDataList;
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
    $.each(pictureDataList, function (i) {
        $.each(pictureDataList[i], function (j) {
            var item = createPictureItem(j, pictureDataList[i][j]);
            waterFall.append(item).masonry("appended", item);
        })
    });

    waterfall();
}


function getAlbumData(userId, callBack,offset) {
    var items = $("div.album-item").length;
    var pageSize = 10;
    var page = Math.ceil(parseInt(items) / pageSize) + 1;

    $.ajax({
        method: "POST",
        url: "user/" + userId + "/album/" + page,
        dataType: "json",
        async: true,
        data: {
            "page": page,
            "pageSize": pageSize
        },
        content: "application/x-www-form-urlencoded",
        success: function (data) {
            callBack(data);
        },
        error: function (data) {
            console.log(data);
        }
    });
}


function appendItemToAlbum(data) {
    var user, album;
    var albumBox = $(".album-box");
    for (var i in data) {
        for (var j in data[i]) {
            user = j;
            album = data[i][j];
            var albumItem = createAlbumItem(user, album);
            albumBox.append(albumItem);
        }
    }


}

function createAlbumItem(user, album) {
    var albumItem = ' <div class="album-item">\n' +
        '                        <div class="album-avatar">\n' +
        '                            <div>\n' +
        '                                <a href=' + 'album/' + album.albumId + '>\n' +
        '                                    <img src="upload/1.jpg" class="album-profile">\n' +
        '                                </a>\n' +
        '                            </div>\n' +
        '                        </div>\n' +
        '                        <div class="album-info">\n' +
        '                            <h3>' + album.albumTitle + '</h3>\n' +
        '                            <p>224图片 · 4319收藏</p>\n' +
        '                        </div>\n' +
        '                    </div>';

    return $(albumItem);

}


function displayByUrl(tabMenuLi, tabBox, location) {
    if ((-1) !== location.search(/picture/)) {
        tabBox.find(".user-image").show().siblings().hide();
        var userId = $(".userspace-card").text();
        getPictureData(userId, appendItemToWaterFall);
        tabMenuLi.eq(0).addClass("change").siblings().removeClass("change");
    }
    if ((-1) !== location.search(/album/)) {
        tabBox.find(".album-box").show().siblings().hide();
        userId = $(".userspace-card").text();
        getAlbumData(userId, appendItemToAlbum);
        tabMenuLi.eq(1).addClass("change").siblings().removeClass("change");
    }
}


function createAlbum() {
    var title = $(".title-text");
    var desc = $(".desc-text");
    var userId = $(".userspace-card");
    $.ajax({
        method: "post",
        url: "album/createAlbum",
        dataType: "json",
        data: {
            "userId": userId.text(),
            "albumTitle": title.val(),
            "albumDesc": desc.val()
        },
        success: function (data) {
            hideMask();
            var albumData = createAlbumItem(userId, data.album);
            $(".album-box").append(albumData);
            console.log(data);
        },
        error: function (data) {
            console.log(data);
        }
    });
}


/**
 * When scrolled all the way to the bottom, add more tiles
 */
function onUserPageScroll() {
    var clientHeight = $(this).height();
    var scrollTop = Math.ceil($(this).scrollTop());
    var scrollHeight = $(document).height();
    if(scrollTop + clientHeight === scrollHeight){
        // Get the first then items from the grid, clone them, and add them to the bottom of the grid
        var $container = $("#waterfall");
        var $items = $('div.item', $container);
        var $itemCount = $items.length;
        if ($itemCount < 100) {
            var userId = parseInt($(".userspace-card").text());
            getPictureData(userId,appendItemToWaterFall);
        }
    }
}

function dialog() {
    //显示专辑模态框
    $(".create-album").on("click", showMask);
    $(".submit").on("click", createAlbum);
    $(".cancel").on("click", hideMask);

    $(window).scroll(onUserPageScroll);

}















