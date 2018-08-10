package com.ssm.action;

import com.ssm.model.Comment;
import com.ssm.model.User;
import com.ssm.service.MyCommentService;
import com.ssm.service.MyPictureService;
import com.ssm.service.MyUserService;
import com.ssm.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Comment addComment(@PathVariable("userId") Long userId, @PathVariable("pId") Long pId, Comment comment) throws Exception{
        comment.setAuthorid(userId);
        comment.setPid(pId);
        comment.setCreateAt(DateUtil.getCurrentTimeLong());
        int affected=myCommentService.addComment(comment);
        if(0!=affected){
            return comment;
        }
        return null;
    }

    @RequestMapping(value = "addReply/{userId}/{pId}")
    @ResponseBody
    public Comment addReply(@PathVariable("userId") Long userId,@PathVariable("pId") Long pId,Comment comment,Long replyTo) throws Exception{
        comment.setAuthorid(userId);
        comment.setPid(pId);
        comment.setCreateAt(DateUtil.getCurrentTimeLong());
        comment.setType("reply");
        comment.setReplyTo(replyTo);
        int affected = myCommentService.addReply(comment);
        if(0!=affected) return comment;
        return null;
    }
}
