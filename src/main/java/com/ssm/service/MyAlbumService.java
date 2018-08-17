package com.ssm.service;

import com.ssm.model.Album;
import com.ssm.model.AlbumPicture;
import com.ssm.model.UserAlbum;
import com.ssm.model.UserPicture;

import java.util.List;

public interface MyAlbumService {

    //创建专辑
    int createAlbum(Album album) throws Exception;
    //删除专辑
    int deleteAlbum(Album album) throws Exception;
    //取消收藏专辑
    int removeCollectedAlbum(UserAlbum userAlbum) throws Exception;
    //获取专辑资料
    Album getAlbumDataByAlbumId(Long albumId) throws Exception;
    //获取用户创建的专辑
    List<Album> getUserCreatedAlbum(Long userId,int page ,int pageSize) throws Exception;
    //获取用户收藏的专辑
    List<Album> getUserCollectedAlbum(Long userId,int page,int pageSize) throws Exception;
    //通过ID获取专辑收录的图片
    List<AlbumPicture> getAlbumPicturesByAlbumId(Long albumId,int page,int pageSize) throws Exception;
    //用户收藏专辑
    int collectedAlbum(UserAlbum userAlbum) throws Exception;
    //通过用户和图片ID,查找出该张专辑
    UserPicture getUserPictureByIds(Long userId,Long pictureId,int page,int pageSize) throws Exception;
    //更新专辑信息
    int updateAlbum(Album album) throws Exception;
    //删除专辑收集的所有图片
    int removeAlbumAllPicture(Long albumId) throws Exception;
    //取消专辑收藏的图片
    int removeAlbumPicture(Long albumId,Long pictureId) throws Exception;
    //将图片加入专辑中
    int collectPictureToAlbum(AlbumPicture albumPicture) throws Exception;
    //通过ID获取用户收录的专辑图片
    AlbumPicture getAlbumPictureByIds(Long albumId,Long PictureId) throws Exception;




}
