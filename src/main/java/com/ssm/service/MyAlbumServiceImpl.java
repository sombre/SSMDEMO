package com.ssm.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssm.dao.*;
import com.ssm.model.Album;
import com.ssm.model.AlbumPicture;
import com.ssm.model.UserAlbum;
import com.ssm.model.UserPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MyAlbumServiceImpl implements MyAlbumService {

    private AlbumService albumService;
    private AlbumMapper albumMapper;

    private UserPictureMapper userPictureMapper;
    private UserPictureService userPictureService;

    private UserAlbumMapper userAlbumMapper;
    private UserAlbumService userAlbumService;

    private AlbumPictureMapper albumPictureMapper;
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

    public AlbumPictureMapper getAlbumPictureMapper() {
        return albumPictureMapper;
    }
    @Autowired
    public void setAlbumPictureMapper(AlbumPictureMapper albumPictureMapper) {
        this.albumPictureMapper = albumPictureMapper;
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

    public AlbumMapper getAlbumMapper() {
        return albumMapper;
    }
    @Autowired
    public void setAlbumMapper(AlbumMapper albumMapper) {
        this.albumMapper = albumMapper;
    }

    public UserAlbumMapper getUserAlbumMapper() {
        return userAlbumMapper;
    }
    @Autowired
    public void setUserAlbumMapper(UserAlbumMapper userAlbumMapper) {
        this.userAlbumMapper = userAlbumMapper;
    }


    public UserAlbumService getUserAlbumService() {
        return userAlbumService;
    }
    @Autowired
    public void setUserAlbumService(UserAlbumService userAlbumService) {
        this.userAlbumService = userAlbumService;
    }

    public List<Album> getUserCollectedAlbum(Long userId, int page, int pageSize) throws Exception{
        Page pageHelp =PageHelper.startPage(page,pageSize);
        List<Album> albumList =albumService.getUserCollectedAlbum(userId);
        return albumList;
    }


    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 300,rollbackFor = {Exception.class})
    public int  createAlbum(Album album) throws Exception {
        return albumMapper.insert(album);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 300,rollbackFor = {Exception.class})
    public int deleteAlbum(Album album) throws Exception {
         return albumMapper.deleteByPrimaryKey(album.getAlbumId());
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 300,rollbackFor = {Exception.class})
    public int removeCollectedAlbum(UserAlbum userAlbum) throws Exception {
        return userAlbumService.deleteUserAlbumByIds(userAlbum.getUserId(),userAlbum.getAlbumId());
    }

    public Album getAlbumDataByAlbumId(Long albumId) throws Exception {
        return albumMapper.selectByPrimaryKey(albumId);
    }

    public List<Album> getUserCreatedAlbum(Long userId, int page, int pageSize) throws Exception {
        PageHelper.startPage(page, pageSize);
        return albumService.getUserCreatedAlbum(userId);
    }

    public List<AlbumPicture> getAlbumPicturesByAlbumId(Long albumId,int page,int pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        return albumPictureService.getAlbumPictures(albumId);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 300,rollbackFor = {Exception.class})
    public int collectedAlbum(UserAlbum userAlbum) throws Exception {
        return userAlbumMapper.insert(userAlbum);
    }



    public UserPicture getUserPictureByIds(Long userId, Long pictureId,int page,int pageSize) throws Exception {
        Page pageHelp = PageHelper.startPage(page, pageSize);
        UserPicture userPicture=userPictureService.getUserPictureByIds(userId,pictureId);
        if(pageHelp.getPages()==page) return null;
        return userPicture;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 300,rollbackFor = {Exception.class})
    public int updateAlbum(Album album) throws Exception {
        return albumMapper.updateByPrimaryKey(album);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 300,rollbackFor = {Exception.class})
    public int removeAlbumAllPicture(Long albumId) throws Exception {
        return albumPictureService.deleteAlbumPictureByAlbumId(albumId);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 300,rollbackFor = {Exception.class})
    public int removeAlbumPicture(Long albumId, Long pictureId) throws Exception {
        return albumPictureService.deleteAlbumPictureByIds(albumId,pictureId);
    }


    public AlbumPicture getAlbumPictureByIds(Long albumId, Long pictureId) throws Exception {
        return albumPictureService.getAlbumPictureByIds(albumId,pictureId);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 300,rollbackFor = {Exception.class})
    public int collectPictureToAlbum(AlbumPicture albumPicture) throws Exception {
        return albumPictureMapper.insert(albumPicture);
    }


}
