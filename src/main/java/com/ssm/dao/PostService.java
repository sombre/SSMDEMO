package com.ssm.dao;

import com.ssm.model.Comment;
import com.ssm.model.Post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PostService {

    List<HashMap> showPostAndComment() throws Exception;

    List<Comment> selectPostComment(long postId) throws Exception;


}
