package com.ssm.dao;

import com.ssm.model.Album;

import java.util.List;

public interface AlbumService {

    List<Album> getUserCreatedAlbum(Long userId) throws Exception;
    List<Album> getUserCollectedAlbum(Long userId) throws Exception;


}
