package com.ssm.service;

import com.github.pagehelper.PageHelper;
import com.ssm.dao.CommentMapper;
import com.ssm.dao.CommentService;
import com.ssm.model.Comment;
import com.ssm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class MyCommentServiceImpl implements MyCommentService{

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

    public List<Map<User, Comment>> getCommentsByPictureId(Long pictureId,int page,int pageSize) throws Exception{
        List<Map<User,Comment>> userCommentList= new LinkedList<Map<User, Comment>>();
        PageHelper.startPage(page, pageSize);
        List<Comment> commentList = commentService.getPictureComments(pictureId);
        if(null!=commentList && 0!=commentList.size()){
            for ( Comment comment : commentList ){
                User user = myUserService.selectUserById(comment.getAuthorid());
                if(null!=user){
                    HashMap<User,Comment> userCommentHashMap = new HashMap<User, Comment>();
                    userCommentHashMap.put(user,comment);
                    userCommentList.add(userCommentHashMap);
                }
            }
            return userCommentList;
        }
        return null;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 300)
    public int addComment(Comment comment) throws Exception {
        return commentMapper.insert(comment);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 300)
    public int addReply(Comment comment) throws Exception {
        return commentMapper.insert(comment);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 300)
    public int removeCommentById(Long commentId) throws Exception {
        return commentMapper.deleteByPrimaryKey(commentId);
    }

}
