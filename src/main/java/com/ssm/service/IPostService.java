package com.ssm.service;

import com.ssm.model.Post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IPostService {

    List<HashMap> showPostAndComment() throws Exception;

    boolean addPost(Post post) throws Exception;
}
