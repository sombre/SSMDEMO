package com.ssm.dao;

import com.ssm.model.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getPictureComments(Long pid) throws Exception;
}
