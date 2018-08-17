package com.ssm.service;

import com.ssm.model.Picture;
import com.ssm.model.UserPicture;

import java.util.List;

public interface MyPictureService {

    int addPicture(Picture picture) throws Exception;
    Picture getPictureById(long pictureId) throws Exception;
    List<Picture> getUserCollectedPicturesByUid(long userId,int page,int pageSize) throws Exception;
    int updatePicture(Picture picture) throws Exception;


    int addUserPicture(UserPicture userPicture) throws Exception;
    boolean removeUserPicture(UserPicture userPicture) throws Exception;
    UserPicture getUserPictureByIds(Long userId,Long pictureId) throws Exception;





}
