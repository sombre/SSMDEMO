package com.ssm.service;

import com.ssm.model.AlbumPicture;

import java.util.List;

public interface MyAlbumPictureService {

    List<AlbumPicture> getAlbumPicturesByAlbumId(Long albumId) throws Exception;


}
