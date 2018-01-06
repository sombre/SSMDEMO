package com.ssm.service;

import com.ssm.dao.CommentMapper;
import com.ssm.dao.ServiceMapper;
import com.ssm.dao.TopicMapper;
import com.ssm.dao.UserMapper;
import com.ssm.model.Comment;
import com.ssm.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TopicServiceImpl implements ITopicService{

    private ServiceMapper serviceMapper;

    private CommentMapper commentMapper;

    private UserMapper userMapper;

    private TopicMapper topicMapper;

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

    public TopicMapper getTopicMapper() {
        return topicMapper;
    }
    @Autowired
    public void setTopicMapper(TopicMapper topicMapper) {
        this.topicMapper = topicMapper;
    }

    public ServiceMapper getServiceMapper() {
        return serviceMapper;
    }
    @Autowired
    public void setServiceMapper(ServiceMapper serviceMapper) {
        this.serviceMapper = serviceMapper;
    }

    public List<HashMap<String,Object>> showPostAndComment() throws Exception {
        List<HashMap<String,Object>> result = this.serviceMapper.showTopicAndComment();
        List<Topic> topics = this.topicMapper.selectAll();
        Map<Topic,List<Comment>> map = new HashMap<Topic, List<Comment>>();
        for(Topic topic : topics){
            List<Comment> tmp = this.serviceMapper.selectTopicComment(topic.getTid());
            if(!tmp.isEmpty()) map.put(topic,tmp);
            else map.put(topic,null);
        }

        return result;
    }
}
