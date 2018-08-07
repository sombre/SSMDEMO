package com.ssm.service;

import com.ssm.model.Comment;
import com.ssm.model.User;
import com.ssm.model.shiro.CommGroup;

import java.util.HashMap;
import java.util.List;

public interface MyCommentService {

    HashMap<User,Comment> getCommentsByPictureId(Long pictureId) throws Exception;
    boolean addComment(Long pId, Comment comment) throws Exception;

}
