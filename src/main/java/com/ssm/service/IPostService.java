package com.ssm.service;

import java.util.HashMap;
import java.util.List;

public interface IPostService {

    List<HashMap<String,Object>> showPostAndComment() throws Exception;
}
