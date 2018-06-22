/********************* 图片轮播******************/
$(function () {
//     配置参数
//     Skidder旋转木马插件的配置参数如下：
//
// 参数	描述
//     slideClass	slide元素的class名称。默认为".slide"
//     animationType	该插件支持CSS动画和jQuery动画。可选值为： 'animate', 'css'。默认值为 'animate'
//     lazyLoad	懒加载，默认值为false
//     lazyLoadAutoInit	默认值为true
//     lazyLoadWindow	默认值为1
//     scaleSlides	是否根据maxWidth, maxHeight和scaleTo参数缩放slide为统一的值。默认为true。
//     scaleTo	定义缩放模式。有2种模式：最小模式和响应式模式。可选值为："smallest"和[x, y]。"smallest"表示高度最小的图片绝对幻灯片的高度。[x, y]表示使用一个数组中的两个数值来定义幻灯片的比例。默认为"smallest"模式。
//     maxWidth	现在幻灯片的最大宽度，0或"none"表示不限制。默认为800
//     maxHeight	现在幻灯片的最大高度，0或"none"表示不限制。默认为500
//     preservePortrait	在响应式模式中该参数有效。决定小于比例的图片的填充模式。true表示适应视口高度，水平方向上留空白。默认为false。
//     paging	设置为true时，插件会查找pagingElement元素的包裹元素pagingWrapper来设置padding。如果这两个元素不存在，插件会自动创建它们。默认为true。
//     pagingWrapper	分页圆点的包裹元素，默认为'.skidder-pager'
//     pagingElement	分页圆点元素，默认为'.skidder-pager-dot'
//     swiping	是否在移动触摸设备上允许swiping。默认为true
//     leftaligned	如果不希望幻灯片居中，设置为true，默认为false
//     cycle	是否循环显示，默认为true。
//     jumpback	在非循环模式时，最后一张幻灯片会显示'return to first slide'箭头。默认为false
//     speed	过渡动画的速度，默认为400
//     autoplay	是否总播放，默认为false
//     autoplayResume	是否在互动后恢复自动播放，默认为false
//     interval	自动播放的时间间隔，默认为4000
//     transition	过渡动画效果，'slide' 或 'fade'
//     directionClasses	在过渡动画结束后为slides添加 'left-from-active' 和 'right-from-active' class类。
//     afterSliding	旋转木马改变后的回调函数
//     afterInit	旋转木马初始化后的回调函数
//     afterResize	旋转木马尺寸改变时的回调函数
    $('.slideshow').each(function () {
        var $slideshow = $(this);
        $slideshow.imagesLoaded(function () {
            $slideshow.skidder({
                slideClass: '.slide',
                animationType: 'css',
                scaleSlides: true,
                // scaleTo: [2,1],
                maxWidth: 0,
                maxHeight: 0,
                paging: true,
                autoPaging: true,
                pagingWrapper: ".skidder-pager",
                pagingElement: ".skidder-pager-dot",
                swiping: true,
                leftaligned: false,
                cycle: true,
                jumpback: false,
                speed: 400,
                autoplay: true,
                autoplayResume: true,
                interval: 2000,
                transition: "slide",
                afterSliding: function () {
                },
                afterInit: function () {
                }
            });
        });
    });
    $(window).smartresize(function () {
        $('.slideshow').skidder('resize');
    });
})


// ===============瀑布流==============
$(function () {
    var $window = $(window),
        $document = $(document),
        $container = $('.waterfall');
    $container.imagesLoaded(function () {
        $container.masonry({
            itemSelector: '.item',
            columnWidth: 0,
            gutter: 0,
            transitionDuration: 0,
            isAnimated: true,
            flowWidth: true,//自定义参数
            //假如这个参数为真,容器container的宽度为100,列宽度为30,则列数应该为100/30=3.333
            //四舍五入,3.33取3.假如列宽度为28,则列数为100/28=3.57...,这个时候列数会取为4,即四舍五入.
        });
    });

    /**
     * When scrolled all the way to the bottom, add more tiles
     */
    function onScroll() {
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
                    flowWidth: true,//自定义参数
                    //假如这个参数为真,容器container的宽度为100,列宽度为30,则列数应该为100/30=3.333
                    //四舍五入,3.33取3.假如列宽度为28,则列数为100/28=3.57...,这个时候列数会取为4,即四舍五入.
                });
                $container.append($firstTen).masonry('appended', $firstTen);
            }

        }
    };
    var isScroll = true;
    if (isScroll) {
        // Capture scroll event.
        $window.bind('scroll.waterfall', onScroll);
    }

});








// (function ($) {
//     // Instantiate wookmark after all images have been loaded
//     // 初始化wookmark插件,
//     var wookmark,
//         // 瀑布流item的父容器ID
//         container = '#waterfall',
//         $container= $(container),
//         $window = $(window),
//         $document = $(document);
// // 利用imagesloaded插件,在图片都加载完成以后对item进行布局
//     imagesLoaded(container, function () {
//         //图片加载完毕,开始进行布局
//         wookmark = new Wookmark(container, {
//             offset: 20, // Optional, the distance between grid items
//             itemWidth: 224// Optional, the width of a grid item
//         });
//     });
//
//
//
//     /**
//      * When scrolled all the way to the bottom, add more tiles
//      * 当垂直滚动条滚到到接近底部的时候,加载更多图片
//      */
//     function onScroll() {
//         // Check if we're within 100 pixels of the bottom edge of the broser window.
//         // 计算窗口高度
//         var winHeight = window.innerHeight ? window.innerHeight : $window.height(), // iphone fix
//             //当垂直滚动条+窗口高度 > 整个文档高度-100px时,确定加载图片
//             closeToBottom = ($window.scrollTop() + winHeight > $document.height() - 100);
//
//         if (closeToBottom) {
//             // Get the first then items from the grid, clone them, and add them to the bottom of the grid
//             var $container = $("waterfall");
//             var $items = $('item', $container),
//                 $firstTen = $items.slice(0, 10).clone().css('opacity', 0);
//             $container.append($firstTen);
//             wookmark.initItems();
//             wookmark.layout(true, function () {
//                 // Fade in items after layout
//                 setTimeout(function () {
//                     $firstTen.css('opacity', 1);
//                 }, 300);
//             });
//         }
//     };
//
//     // Capture scroll event.
//     $window.bind('scroll.wookmark', onScroll);
// })(jQuery);