// ===============瀑布流==============
var waterfall = function () {
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
};


