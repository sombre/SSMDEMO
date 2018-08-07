package com.ssm.service;

import com.ssm.model.Comment;
import com.ssm.model.User;
import com.ssm.model.shiro.CommGroup;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

public interface MyCommentService {

    HashMap<User,Comment> getCommentsByPictureId(Long pictureId) throws Exception;
    int addComment(Long userId,Long pId, Comment comment) throws Exception;

}
