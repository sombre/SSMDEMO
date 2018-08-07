package com.ssm.service;

import com.ssm.dao.CommentMapper;
import com.ssm.dao.CommentService;
import com.ssm.model.Comment;
import com.ssm.model.User;
import com.ssm.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Service
public class MyCommentServiceimpl implements MyCommentService{

    private MyUserService myUserService;
    private CommentMapper commentMapper;
    private CommentService commentService;

    public MyUserService getMyUserService() {
        return myUserService;
    }

    @Autowired
    public void setMyUserService(MyUserService myUserService) {
        this.myUserService = myUserService;
    }

    public CommentMapper getCommentMapper() {
        return commentMapper;
    }
    @Autowired
    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public CommentService getCommentService() {
        return commentService;
    }
    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    public HashMap<User, Comment> getCommentsByPictureId(Long pictureId) throws Exception{
        List<Comment> commentList = commentService.getPictureComments(pictureId);
        HashMap<User,Comment> userCommentHashMap = new HashMap<User, Comment>();
        if(null!=commentList && 0!=commentList.size()){
            for ( Comment comment : commentList ){
                User user = myUserService.selectUserById(comment.getAuthorid());
                if(null!=user){
                    userCommentHashMap.put(user,comment);
                }
            }
            return userCommentHashMap;
        }
        return null;
    }



    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 3)
    public int addComment(Long userId, Long pId, Comment comment) throws Exception {
        comment.setCreateAt(DateUtil.getCurrentTimeLong());
        comment.setPid(pId);
        comment.setAuthorid(userId);
        return commentMapper.insert(comment);
    }

}
