package com.ssm.dao;

import com.ssm.model.Comment;

import java.util.HashMap;
import java.util.List;

public interface ServiceMapper {

    public List<HashMap<String,Object>> showPostAndComment();

    List<Comment> selectPostComment(int postId);

}
