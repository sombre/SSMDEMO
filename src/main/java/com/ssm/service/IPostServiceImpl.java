package com.ssm.service;

import com.ssm.dao.CommentMapper;
import com.ssm.dao.PostMapper;
import com.ssm.dao.ServiceMapper;
import com.ssm.dao.UserMapper;
import com.ssm.model.Comment;
import com.ssm.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class IPostServiceImpl implements IPostService{

    private ServiceMapper serviceMapper;

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

    public ServiceMapper getServiceMapper() {
        return serviceMapper;
    }
    @Autowired
    public void setServiceMapper(ServiceMapper serviceMapper) {
        this.serviceMapper = serviceMapper;
    }

    public List<HashMap<String,Object>> showPostAndComment() throws Exception {
        List<HashMap<String,Object>> result = this.serviceMapper.showPostAndComment();
        List<Post> posts = this.postMapper.selectAll();
        Map<Post,List<Comment>> map = new HashMap<Post, List<Comment>>();
        for(Post post : posts){
            List<Comment> tmp = this.serviceMapper.selectPostComment(post.getPid());
            if(!tmp.isEmpty()) map.put(post,tmp);
            else map.put(post,null);
        }

        return result;
    }
}
