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
    <script>
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
        fileTypeDesc : '只支持gif,jpg,png文件格式',
        fileTypeExts : '*.gif; *.jpg; *.png',
        height        : 30,
        formData: {title:"title",desc:"desc"},
        fileObjName:'pic',
        swf           : 'js/uploadify.swf',
        uploader      : 'doUpload',
        buttonClass : 'selected-btn',
        buttonText : '选择图片',
        cancelImage : 'img/uploadify-cancel.png',
        dataType: "json",
        width         : 120,
        'onUploadStart': function(file) {
            var title=$("input[name='title']").val();
            var desc=$("textarea[name='desc']").val();
            $("#file_upload").uploadify(
                "settings",
                "formData",
                {'title':title,'desc':desc});
        },
        'onSelectError' : function(file,errorCode,errorMsg) {
            alert('这个文件' + file.name + '不是一个有效的图片,图片格式只能是gif,jpg,png.');
        },
        'onClearQueue' : function(queueItemCount) {
            alert(queueItemCount + ' file(s) were removed from the queue');
        },
        'onUploadSuccess' : function(file, data) {
//            alert('The file ' + file.name + ' was successfully uploaded with a response of ' + response + ':' + data);
            var json = $.parseJSON(data);
            console.log(json.picId);
        }
    });
});


    </script>
    <title>上传图片</title>
</head>
<body>

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
