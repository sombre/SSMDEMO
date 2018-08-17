package com.ssm.service;

import com.ssm.model.Comment;
import com.ssm.model.User;
import com.ssm.model.shiro.CommGroup;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MyCommentService {

    List<Map<User,Comment>> getCommentsByPictureId(Long pictureId,int page,int pageSize) throws Exception;
    int addComment(Comment comment) throws Exception;
    int addReply(Comment comment) throws Exception;
    int removeCommentById(Long commentId) throws Exception;
}
