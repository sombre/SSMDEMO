package com.ssm.service;

import com.ssm.dao.CommentMapper;
import com.ssm.dao.PostMapper;
import com.ssm.dao.PostService;
import com.ssm.dao.UserMapper;
import com.ssm.model.Comment;
import com.ssm.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class IPostServiceImpl implements IPostService{

    private PostService postService;

    private CommentMapper commentMapper;

    private UserMapper userMapper;

    private PostMapper postMapper;

    public CommentMapper getCommentMapper() {
        return commentMapper;
    }
    @Autowired
    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }
    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public PostMapper getPostMapper() {
        return postMapper;
    }
    @Autowired
    public void setPostMapper(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    public PostService getPostService() {
        return postService;
    }
    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public List<HashMap> showPostAndComment() throws Exception {
        List<HashMap> result = this.postService.showPostAndComment();
        List<Post> posts = this.postMapper.selectAll();
        HashMap em = new HashMap();
        List<HashMap> postandcomment = new ArrayList<HashMap>();
        HashMap<Object,Object> map = new HashMap<Object, Object>();
        for (Post post:posts) {
            List<Comment> tmp = this.postService.selectPostComment(post.getPid());
            map.put(post,tmp);
        }
        postandcomment.add(map);
        return postandcomment;
    }
}
