package com.ssm.action;

import com.ssm.model.Comment;
import com.ssm.model.User;
import com.ssm.service.MyCommentService;
import com.ssm.service.MyPictureService;
import com.ssm.service.MyUserService;
import com.ssm.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CommentAction {

    private MyCommentService myCommentService;
    private MyUserService myUserService;
    private MyPictureService myPictureService;

    public MyCommentService getMyCommentService() {
        return myCommentService;
    }
    @Autowired
    public void setMyCommentService(MyCommentService myCommentService) {
        this.myCommentService = myCommentService;
    }

    public MyUserService getMyUserService() {
        return myUserService;
    }
    @Autowired
    public void setMyUserService(MyUserService myUserService) {
        this.myUserService = myUserService;
    }

    public MyPictureService getMyPictureService() {
        return myPictureService;
    }
    @Autowired
    public void setMyPictureService(MyPictureService myPictureService) {
        this.myPictureService = myPictureService;
    }

    @RequestMapping("addComment/{userId}/{pId}")
    @ResponseBody
    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 300,rollbackFor = {Exception.class})
    public Map<Object,Object> addComment(@PathVariable("userId") Long userId, @PathVariable("pId") Long pId, Comment comment) throws Exception{
        comment.setAuthorid(userId);
        comment.setPid(pId);
        comment.setCreateAt(DateUtil.getCurrentTimeLong());
        int affected=myCommentService.addComment(comment);
        Map<Object,Object> map = new HashMap<Object,Object>();
        if(0!=affected){
            User author = myUserService.selectUserById(userId);
            if(null!=author){
                map.put("comment",comment);
                map.put("author",author);
                map.put("message","评论成功!");
                return map;
            }
        }
        return null;
    }

    @RequestMapping(value = "comment/removeComment")
    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 300,rollbackFor = {Exception.class})
    @ResponseBody
    public Map<Object,Object> removeComment(Long commentId) throws Exception{
        Map<Object,Object> map = new HashMap<Object,Object>();
        if(null!=commentId){
            int affected = myCommentService.removeCommentById(commentId);
            if(0!=affected){
                map.put("message","评论已删除!");
                return map;
            }
        }
        map.put("message","删除出错!");
        return map;
    }



    @RequestMapping(value = "addReply/{userId}/{pId}")
    @ResponseBody
    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 300,rollbackFor = {Exception.class})
    public Map<Object,Object> addReply(@PathVariable("userId") Long userId, @PathVariable("pId") Long pId, Comment comment, Long replyTo) throws Exception{
        comment.setAuthorid(userId);
        comment.setPid(pId);
        comment.setCreateAt(DateUtil.getCurrentTimeLong());
        comment.setType("reply");
        comment.setReplyTo(replyTo);
        int affected = myCommentService.addReply(comment);
        Map<Object,Object> map = new HashMap<Object,Object>();
        if(0!=affected){
            User user = myUserService.selectUserById(userId);
            if(null!=user){
                map.put("comment",comment);
                map.put("author",user);
                map.put("message","回复成功!");
                return map;
            }
        }
        return null;
    }
}
