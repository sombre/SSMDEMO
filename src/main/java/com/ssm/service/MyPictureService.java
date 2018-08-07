package com.ssm.service;

import com.ssm.model.Picture;

import java.util.List;

public interface MyPictureService {

    int addPicture(Picture picture) throws Exception;
    Picture getPictureById(long pictureId) throws Exception;
    List<Picture> getUserCollectedPicturesByUid(long userId) throws Exception;
    boolean updatePicture(Picture picture) throws Exception;
}
