package com.ssm.service;

import com.ssm.model.UserPicture;

public interface MyUserPictureService {

    int addUserPicture(UserPicture userPicture) throws Exception;
    boolean removeUserPicture(UserPicture userPicture) throws Exception;
    UserPicture getUserPictureByIds(Long userId,Long pictureId) throws Exception;

}
