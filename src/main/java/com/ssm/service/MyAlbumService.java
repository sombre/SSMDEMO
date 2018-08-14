package com.ssm.service;

import com.ssm.model.Album;
import com.ssm.model.AlbumPicture;
import com.ssm.model.UserPicture;

import java.util.List;

public interface MyAlbumService {

    Album getAlbumDataByAlbumId(Long albumId) throws Exception;
    //获取用户创建的专辑
    List<Album> getUserCreatedAlbum(Long userId,int page ,int pageSize) throws Exception;
    //获取用户收藏的专辑
    List<Album> getUserCollectedAlbum(Long userId,int page,int pageSize) throws Exception;
    //通过ID获取专辑信息
    List<AlbumPicture> getAlbumPicturesByAlbumId(Long albumId,int page,int pageSize) throws Exception;
    //用户收藏专辑
    int addUserPicture(UserPicture userPicture) throws Exception;
    //用户取消收藏专辑
    boolean removeUserPicture(UserPicture userPicture) throws Exception;
    //通过用户和图片ID,查找出该张专辑
    UserPicture getUserPictureByIds(Long userId,Long pictureId,int page,int pageSize) throws Exception;




}
