package com.ssm.dao;

import com.ssm.model.UserPicture;

public interface UserPictureService {
    UserPicture getUserPictureByIds(Long userId,Long pictureId);
}
