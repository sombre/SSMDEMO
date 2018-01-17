package com.ssm.dao;

import com.ssm.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    User selectUserByEmail(String email);

}
