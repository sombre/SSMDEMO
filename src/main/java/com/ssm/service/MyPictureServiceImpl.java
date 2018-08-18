package com.ssm.service;

import com.github.pagehelper.PageHelper;
import com.ssm.dao.PictureMapper;
import com.ssm.dao.PictureService;
import com.ssm.dao.UserPictureMapper;
import com.ssm.dao.UserPictureService;
import com.ssm.model.Picture;
import com.ssm.model.UserPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class MyPictureServiceImpl implements MyPictureService {
    //图片相关
    protected PictureMapper pictureMapper;
    protected PictureService pictureService;
    //用户与图片
    protected UserPictureMapper userPictureMapper;
    protected UserPictureService userPictureService;


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


    public UserPictureMapper getUserPictureMapper() {
        return userPictureMapper;
    }
    @Autowired
    public void setUserPictureMapper(UserPictureMapper userPictureMapper) {
        this.userPictureMapper = userPictureMapper;
    }

    public UserPictureService getUserPictureService() {
        return userPictureService;
    }
    @Autowired
    public void setUserPictureService(UserPictureService userPictureService) {
        this.userPictureService = userPictureService;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 3)
    public int addPicture(Picture picture) throws Exception{
        return pictureMapper.insert(picture);
    }

    public Picture getPictureById(long pictureId) throws Exception{
        return pictureMapper.selectByPrimaryKey(pictureId);
    }

    public List<Picture> getUserCollectedPicturesByUid(long userId,int page,int pageSize) throws Exception{
        PageHelper.startPage(page, pageSize);
        return pictureService.getUserCollectedPicture(userId);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 3)
    public int updatePicture(Picture picture) throws Exception{
        return pictureMapper.updateByPrimaryKey(picture);
    }


    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 3)
    public int addUserPicture(UserPicture userPicture) throws Exception {
        return userPictureMapper.insert(userPicture);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 3)
    public boolean removeUserPicture(UserPicture userPicture) throws Exception {
        int affected = userPictureMapper.deleteByPrimaryKey(userPicture.getUserPicId());
        if(0!=affected) return true;
        return false;
    }

    public UserPicture getUserPictureByIds(Long userId, Long pictureId) throws Exception {
        UserPicture userPicture=userPictureService.getUserPictureByIds(userId,pictureId);
        if(null!=userPicture) return userPicture;
        return null;
    }

    public List<Picture> getSliderPicture(int pageSize) throws Exception {
        return pictureService.getSliderPicture(pageSize);
    }

    public List<Picture> getIndexPicture(int page,int pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        return pictureService.getIndexPicture();
    }


}
