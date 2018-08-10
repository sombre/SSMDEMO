package com.ssm.dao;

import com.ssm.model.Picture;

import java.util.List;

public interface PictureService {

    List<Picture> getUserCollectedPicture(Long uid);
}
