package com.ssm.dao;

import com.ssm.model.AlbumPicture;

import java.util.List;

public interface AlbumPictureService {

    List<AlbumPicture> getAlbumPictures(Long albumId) throws Exception;


}
