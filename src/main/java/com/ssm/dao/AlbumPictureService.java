package com.ssm.dao;

import com.ssm.model.AlbumPicture;

import java.util.List;

public interface AlbumPictureService {

    List<AlbumPicture> getAlbumPictures(Long albumId) throws Exception;

    int deleteAlbumPictureByIds(Long albumId,Long pictureId) throws Exception;

    int deleteAlbumPictureByAlbumId(Long albumId) throws Exception;

    AlbumPicture getAlbumPictureByIds(Long albumId,Long pictureId) throws Exception;


}
