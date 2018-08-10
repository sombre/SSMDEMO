package com.ssm.service;

import com.ssm.dao.PictureMapper;
import com.ssm.dao.PictureService;
import com.ssm.model.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class MyPictureServiceimpl implements MyPictureService {
    public PictureMapper pictureMapper;

    public PictureService pictureService;

    public PictureService getPictureService() {
        return pictureService;
    }

    @Autowired
    public void setPictureService(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    public PictureMapper getPictureMapper() {
        return pictureMapper;
    }

    @Autowired
    public void setPictureMapper(PictureMapper pictureMapper) {
        this.pictureMapper = pictureMapper;
    }



    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 3)
    public int addPicture(Picture picture) throws Exception{
        return pictureMapper.insert(picture);
    }

    public Picture getPictureById(long pictureId) throws Exception{
        Picture pic = pictureMapper.selectByPrimaryKey(pictureId);
        return pic;
    }

    public List<Picture> getUserCollectedPicturesByUid(long userId) throws Exception{
          return pictureService.getUserCollectedPicture(userId);
    }

    public boolean updatePicture(Picture picture) throws Exception{
        return false;
    }
}
