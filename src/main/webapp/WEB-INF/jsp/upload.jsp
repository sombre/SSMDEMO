<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2017/12/25
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="header.jsp"/>
    <link rel="stylesheet" type="text/css" href="css/uploadify.css">
    <link rel="stylesheet" type="text/css" href="css/upload.css">
    <script src="js/jquery.uploadify.js" type="text/javascript"></script>

    <!-- 引用控制层插件样式 -->
    <%--<link rel="stylesheet" href="css/upload.css" type="text/css">--%>
    <!-- 引用核心层插件 -->
    <%--<script type="text/javascript" src="js/zyFile.js"></script>--%>
    <!-- 引用控制层插件 -->
    <%--<script type="text/javascript" src="js/zyUpload.js"></script>--%>
    <%--<script type="text/javascript" src="js/zyupload.tailor.js"></script>--%>

    <script>
//        $(function(){
//            // 初始化插件
//            $("#upload-box").zyUpload({
//                width            :   "650px",                 // 宽度
//                height           :   "400px",                 // 宽度
//                itemWidth        :   "140px",                 // 文件项的宽度
//                itemHeight       :   "115px",                 // 文件项的高度
//                url              :   "./up.php",              // 上传文件的路径
//                fileType         :   ["jpg","png"],// 上传文件的类型
//                fileSize         :   51200000,                // 上传文件的大小
//                multiple         :   false,                    // 是否可以多个文件上传
//                dragDrop         :   false,                    // 是否可以拖动上传文件
//                tailor           :   true,                    // 是否可以裁剪图片
//                del              :   true,                    // 是否可以删除文件
//                finishDel        :   false,  				  // 是否在上传文件完成后删除预览
//                /* 外部获得的回调接口 */
//                onSelect: function(selectFiles, allFiles){    // 选择文件的回调方法  selectFile:当前选中的文件  allFiles:还没上传的全部文件
//                    console.info("当前选择了以下文件：");
//                    console.info(selectFiles);
//                },
//                onDelete: function(file, files){              // 删除一个文件的回调方法 file:当前删除的文件  files:删除之后的文件
//                    console.info("当前删除了此文件：");
//                    console.info(file.name);
//                },
//                onSuccess: function(file, response){          // 文件上传成功的回调方法
//                    console.info("此文件上传成功：");
//                    console.info(file.name);
//                    console.info("此文件上传到服务器地址：");
//                    console.info(response);
//                    $("#uploadInf").append("<p>上传成功，文件地址是：" + response + "</p>");
//                },
//                onFailure: function(file, response){          // 文件上传失败的回调方法
//                    console.info("此文件上传失败：");
//                    console.info(file.name);
//                },
//                onComplete: function(response){           	  // 上传完成的回调方法
//                    console.info("文件上传完成");
//                    console.info(response);
//                }
//            });
//        });






//$(function() {
//    $("#file_upload").uploadify({
//        'queueID'  : 'queue',//上传进度展示
//        'buttonText': 'selectFile..',
//        'buttonImage':"",
//        'swf': 'js/uploadify.swf',
//        'formData': {
//            'pid' : 'portal',
//            'token': 'portal',
//            'filedesc':''
//        },
//        'method':'Post',
//        'scriptAccess' : 'always' ,
//        //'uploader' : 'http://10.18.23.122:8821/mgr/voice/file/v1/upload?var='+(new Date()).getTime(),
//        //'uploader' : 'http://202.100.72.139:8821/mgr/voice/file/v1/upload?var='+(new Date()).getTime(),
//        'uploader' : 'http://10.18.23.154:8821/mgr/voice/file/v1/upload',
//        'auto': true,
//        'onUploadStart' : function(file) {
//            alert('Starting to upload ' + file.name);
//        },
//        'onUploadSuccess' : function(file, data, response) {
//            alert('The file ' + file.name + ' was successfully uploaded with a response of ' + response + ':' + data);
//        },
//        'onUploadError' : function(file, errorCode, errorMsg, errorString) {
//            alert('The file ' + file.name + ' could not be uploaded: ' + errorString);
//        },
//        onComplete: function (evt, queueID, fileObj, response, data) {
//            alert(response);
//            //	$('<li></li>').appendTo('#fileContent'+id).html(response);
//        }
//    });
//});

$(function() {
    $("#file_upload").uploadify({
        auto : false,
        method : 'post',
        multi : false,
        'fileTypeDesc' : '只支持gif,jpg,png文件格式',
        'fileTypeExts' : '*.gif; *.jpg; *.png',
        height        : 30,
        swf           : 'js/uploadify.swf',
        uploader      : '',
        buttonClass : 'selected-btn',
        buttonText : '选择图片',
        cancelImage : 'img/uploadify-cancel.png',
        width         : 120,
        'onSelectError' : function(file,errorCode,errorMsg) {
            alert('这个文件' + file.name + '不是一个有效的图片,图片格式只能是gif,jpg,png.');
        },
        'onClearQueue' : function(queueItemCount) {
            alert(queueItemCount + ' file(s) were removed from the queue');
        }
    });
});


    </script>
    <title>上传图片</title>
</head>
<body>


<%--<div id="upload-box" class="upload-box"></div>--%>



<div class="upload-box">
    <div class="upload-inner">
        <div class="upload-title">
            <span>上传图片</span>
        </div>
        <div class="upload-detail">
            <div class="image-title">
                <span>图片标题: </span><input type="text" name="title" class="title">
            </div>
            <div><p>图片描述: </p></div>
            <div class="image-desc">
               <textarea name="desc" id="" cols="90" rows="10"></textarea>
            </div>
        </div>
        <div class="upload-form-box">
            <%--<form class="upload-form">--%>
                <%--<div id="queue"></div>--%>
                <input id="file_upload" name="file_upload" type="file" multiple="true">
            <%--</form>--%>
            <div class="upload-action">
                <a href="javascript:$('#file_upload').uploadify('upload');" class="upload-btn">上传</a>
                <a href="javascript:$('#file_upload').uploadify('cancel','*');" class="cancel-btn">取消</a>
            </div>
        </div>

    </div>
</div>


</body>
</html>
