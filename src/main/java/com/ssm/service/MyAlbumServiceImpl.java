package com.ssm.service;

import com.github.pagehelper.PageHelper;
import com.ssm.dao.AlbumPictureService;
import com.ssm.dao.AlbumService;
import com.ssm.dao.UserPictureMapper;
import com.ssm.dao.UserPictureService;
import com.ssm.model.Album;
import com.ssm.model.AlbumPicture;
import com.ssm.model.UserPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MyAlbumServiceImpl implements MyAlbumService {

    private AlbumService albumService;

    private UserPictureMapper userPictureMapper;
    private UserPictureService userPictureService;

    private AlbumPictureService albumPictureService;


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

    public AlbumPictureService getAlbumPictureService() {
        return albumPictureService;
    }
    @Autowired
    public void setAlbumPictureService(AlbumPictureService albumPictureService) {
        this.albumPictureService = albumPictureService;
    }

    public AlbumService getAlbumService() {
        return albumService;
    }
    @Autowired
    public void setAlbumService(AlbumService albumService) {
        this.albumService = albumService;
    }




    public List<Album> getUserCollectedAlbum(Long userId,int page,int pageSize) throws Exception{
        PageHelper.startPage(1,10);
        return albumService.getUserCollectedAlbum(userId);
    }



    public List<Album> getUserCreatedAlbum(Long userId,int page,int pageSize) throws Exception {
//        PageHelper.startPage(page, pageSize);
        return albumService.getUserCreatedAlbum(userId);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 3)
    public List<AlbumPicture> getAlbumPicturesByAlbumId(Long albumId) throws Exception {
        return albumPictureService.getAlbumPictures(albumId);
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

    public UserPicture getUserPictureByIds(Long userId, Long pictureId,int page,int pageSize) throws Exception {
        PageHelper.startPage(page, pageSize);
        UserPicture userPicture=userPictureService.getUserPictureByIds(userId,pictureId);
        if(null!=userPicture) return userPicture;
        return null;
    }




}
