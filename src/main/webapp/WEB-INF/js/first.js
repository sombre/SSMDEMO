//设置cookie: cookie名，cookie值，天数
function setCookie(name, value, iDay) {
    var oDate = new Date();
    oDate.setDate(oDate.getDate() + iDay);
    document.cookie = name + '=' + value + '; expires = ' + oDate
}

//获取cookie
function getCookie(name) {
    var arr = document.cookie.split(";"); //将cookie切割成数组
    for (var i = 0; i < arr.length; i++) {
        var arr2 = arr[i].split('='); //数组元素以等号切割
        if (arr2[0] == name) {
            return arr2[1]; //获取cookie名对应的cookie值
        }
    }
    return ''; //如果没有获取到值，返回空字符串
}

//删除cookie
function removeCookie(name) {
    setCookie(name, 1, -1);
}


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


function login() {
    var form = $("#go");
    $.ajax({
        url: "http://localhost:8080/ssm/user/dologin",
        type: "post",
        data: form.serialize(),
        processData: false,
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        success: function (data, status) {
            var t = $("#test");
            if (data.error != undefined) {
                t.text(data.error);
            }
            else {
                var content = "user:  ";
                $.each(data.user, function (key, value) {
                    content = content + key + " : " + value + ' ';
                });
                t.text(content);
                // setCookie("user",content,1);
            }
            // console.log(getCookie("user"));
            // removeCookie("user");
            form.hide();
        },
        error: function (e, status) {
            alert(status);
        }
    });
}


function shirologin() {
    var form = $("#shiro");
    $.ajax({
        url: "http://localhost:8080/ssm/user/doAjaxLogin",
        type: "post",
        data: form.serialize(),
        processData: false,
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        success: function (data, status) {
            var t = $("#test");
            if (data.error != undefined) {
                t.text(data.error);
            }
            else {
                var content = "user:  ";
                $.each(data.user, function (key, value) {
                    content = content + key + " : " + value + ' ';
                });
                t.text(content);
                // setCookie("user",content,1);
            }
            // console.log(getCookie("user"));
            // removeCookie("user");
            form.hide();
            $("a[name='login']").hide();
            $("a[name='signup']").hide();
        },
        error: function (e, status) {
            console.log(e);
            console.log(status);
        }
    });
}



// ==============分页==============
function Paging(currentPage, pageCount, perPageSize) {
    var totalPage= Math.ceil(parseInt(pageCount) / parseInt(perPageSize));
    var pageNav = document.getElementsByClassName('page-list');
    var pageNavUl = pageNav[0].children[0];
    var first = 1;
    var last = totalPage;
    pageNavUl.innerHTML = '';
    //=========当总页数大于0
    if (totalPage > 0 && currentPage<=totalPage) {
        //============上一页
        if (totalPage > 1 && currentPage > 1) {
            addPrePage(pageNavUl);
        }
        //=============当总页数小于6
        if (totalPage <6) {
            for (var i = 1; i <= totalPage; i++) {
                var li = document.createElement('li');
                if (i == currentPage) {
                    li.setAttribute('class', 'cur-page');
                    li.appendChild(document.createTextNode(i));
                    pageNavUl.appendChild(li);
                    continue;
                }
                var a = document.createElement('a');
                a.href = 'javascript:;';
                a.appendChild(document.createTextNode(i));
                a.setAttribute('class','normal-page');
                if(i == first) a.setAttribute('class','first-page');
                if(i == last) a.setAttribute('class','last-page');
                li.appendChild(a);
                pageNavUl.appendChild(li);
            }
        }
        //=============总页数大于等于6
        if(totalPage>=6){
            if(currentPage < 5){
                for (var i = 1; i <= 5; i++) {
                    var li = document.createElement('li');
                    if (i == currentPage) {
                        li.setAttribute('class', 'cur-page');
                        li.appendChild(document.createTextNode(i));
                        pageNavUl.appendChild(li);
                        continue;
                    }
                    var a = document.createElement('a');
                    a.href = 'javascript:;';
                    a.appendChild(document.createTextNode(i));
                    a.setAttribute('class','normal-page');
                    if(i == first) a.setAttribute('class','first-page');
                    li.appendChild(a);
                    pageNavUl.appendChild(li);
                }
                addDotbar(pageNavUl);
                //尾页
                var lastPage = document.createElement('li');
                var lastPageInner = document.createElement('a');
                lastPageInner.appendChild(document.createTextNode(last));
                lastPageInner.setAttribute('class','last-page');
                lastPageInner.setAttribute('href','javascript:;');
                lastPage.appendChild(lastPageInner);
                pageNavUl.appendChild(lastPage);
            }
            else{
                //首页
                var firstPage = document.createElement('li');
                var firstPageInner = document.createElement('a');
                firstPageInner.appendChild(document.createTextNode(first));
                firstPage.appendChild(firstPageInner);
                firstPageInner.setAttribute('class','first-page');
                firstPageInner.setAttribute('href','javascript:;');
                pageNavUl.appendChild(firstPage);
                addDotbar(pageNavUl);
                //当前页大于5,且不为最后三页时
                if(currentPage>=5 && currentPage< (totalPage-3) ){
                    for(i = (currentPage-2); i <(currentPage+3);i++){
                        var li = document.createElement('li');
                        if (i == currentPage) {
                            li.setAttribute('class', 'cur-page');
                            li.appendChild(document.createTextNode(i));
                            pageNavUl.appendChild(li);
                            continue;
                        }
                        var a = document.createElement('a');
                        a.href = 'javascript:;';
                        a.appendChild(document.createTextNode(i));
                        a.setAttribute('class','normal-page');
                        li.appendChild(a);
                        pageNavUl.appendChild(li);
                    }
                    addDotbar(pageNavUl);
                    //尾页
                    var lastPage = document.createElement('li');
                    var lastPageInner = document.createElement('a');
                    lastPageInner.appendChild(document.createTextNode(last));
                    lastPage.appendChild(lastPageInner);
                    lastPageInner.setAttribute('class','last-page');
                    lastPageInner.setAttribute('href','javascript:;');
                    pageNavUl.appendChild(lastPage);
                }
                //当前页为最后三页
                if(currentPage >= (totalPage-3) ){
                    for(i =(totalPage-4);i<=totalPage;i++){
                        var li = document.createElement('li');
                        if (i == currentPage) {
                            li.setAttribute('class', 'cur-page');
                            li.appendChild(document.createTextNode(i));
                            pageNavUl.appendChild(li);
                            continue;
                        }
                        var a = document.createElement('a');
                        a.href = 'javascript:;';
                        a.appendChild(document.createTextNode(i));
                        a.setAttribute('class','normal-page');
                        if(i == totalPage) a.setAttribute('class','last-page');
                        li.appendChild(a);
                        pageNavUl.appendChild(li);
                    }
                }
            }
        }
        if (totalPage > 1) {
            //下一页导航框和跳转框
            if(currentPage!=totalPage){
                addNextPage(pageNavUl);
            }
            addGoBar(pageNavUl);
        }
    }
    function addPrePage(pageNavUl) {
        var prePage = document.createElement('li');
        var prePageInner = document.createElement('a');
        prePageInner.setAttribute('class', 'pre-page');
        prePageInner.href = 'javascript:;';
        prePageInner.appendChild(document.createTextNode('上一页'));
        prePage.appendChild(prePageInner);
        pageNavUl.appendChild(prePage);
    }
    function addNextPage(pageNavUl) {
        var nextPage = document.createElement('li');
        var nextPageInner = document.createElement('a');
        nextPageInner.setAttribute('class', 'next-page');
        nextPageInner.href = 'javascript:;';
        nextPageInner.appendChild(document.createTextNode('下一页'));
        nextPage.appendChild(nextPageInner);
        pageNavUl.appendChild(nextPage);

    }
    function addGoBar(pageNavUl){
        var goLi = document.createElement('li');
        var goInner = document.createElement('input');
        goInner.setAttribute('class', 'go');
        goInner.setAttribute('type', 'text');
        goLi.appendChild(goInner);
        pageNavUl.appendChild(goLi);

        var goButtonLi = document.createElement('li');
        var goButtonInner = document.createElement('a');
        goButtonInner.appendChild(document.createTextNode('Go'));
        goButtonInner.href = 'javascript:;';
        goButtonInner.setAttribute('class','go-btn');
        goButtonLi.appendChild(goButtonInner);
        pageNavUl.appendChild(goButtonLi);
    }
    function addDotbar(pageNavUl) {
        var dotLi = document.createElement('li');
        dotLi.appendChild(document.createTextNode('...'));
        dotLi.setAttribute('class','dot');
        pageNavUl.appendChild(dotLi);
    }

    var pageNav = document.getElementsByClassName('page-list');
    var pageNavUl = pageNav[0].children[0];
    //点击普通按钮
    var norpage = pageNavUl.getElementsByClassName('normal-page');
    for(i=0;i<norpage.length;i++){
        (function  (i) {
            norpage[i].addEventListener('click',function (callBack) {
                var a =norpage[i].childNodes[0];
                var page = a.nodeValue;
                Paging(parseInt(page),pageCount,perPageSize);
            });
        })(i)
    }

    //当前页
    var currentPage = pageNavUl.getElementsByClassName('cur-page');
    currentPage = parseInt(currentPage[0].childNodes[0].nodeValue);

    //首页
    if(currentPage != first){
        var firstPage = pageNavUl.getElementsByClassName('first-page');
        firstPage = firstPage[0];
        var first = parseInt(firstPage.childNodes[0].nodeValue);
        firstPage.addEventListener('click',function(){
            Paging(first,pageCount,perPageSize);
        });
    }
    //尾页
    if(currentPage!=last){
        var lastPage = pageNavUl.getElementsByClassName('last-page');
        lastPage = lastPage[0];
        var last = parseInt(lastPage.childNodes[0].nodeValue);
        lastPage.addEventListener('click',function(){
            Paging(last,pageCount,perPageSize);
        })
    }

    //上一页
    var prePage = pageNavUl.getElementsByClassName('pre-page');
    prePage = prePage[0];
    if(currentPage!=first){
        prePage.addEventListener('click',function (callBack){
            Paging(currentPage-1,pageCount,perPageSize);
        });
    }
    //下一页
    var nextPage = pageNavUl.getElementsByClassName('next-page');
    nextPage = nextPage[0];
    if(currentPage != last){
        nextPage.addEventListener('click',function (callBack){
            Paging(currentPage+1,pageCount,perPageSize);
        });
    }
    //跳转
    var goInner = document.getElementsByClassName('go');
    goInner = goInner[0];
    goInner.addEventListener('keydown', function (e) {
        var goValue = parseInt(goInner.value);
        if (e.keyCode == 13 && goValue >= 0 && goValue <= totalPage) {
            console.log(goValue);
            Paging(goValue, pageCount, perPageSize);
        }
    });

}



$(function () {
    Paging(25, 100, 1);
})



