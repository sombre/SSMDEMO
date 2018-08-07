package com.ssm.action;

import com.ssm.model.Comment;
import com.ssm.service.MyCommentService;
import com.ssm.service.MyPictureService;
import com.ssm.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String addComment(@PathVariable("userId") Long userId, @PathVariable("pId") Long pId, Comment comment) throws Exception{
        int affected=myCommentService.addComment(userId,pId,comment);
        if(0!=affected){
            return "redirect: /picture/" + userId.toString();
        }
        return null;
    }
}
