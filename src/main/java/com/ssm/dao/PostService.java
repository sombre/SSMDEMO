package com.ssm.dao;

import com.ssm.model.Comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PostService {

    List<HashMap> showPostAndComment();

    List<Comment> selectPostComment(int postId);

}
