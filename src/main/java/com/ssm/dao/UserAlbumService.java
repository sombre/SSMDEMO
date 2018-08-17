package com.ssm.dao;

import com.ssm.model.Album;

import java.util.List;

public interface UserAlbumService {

    int deleteUserAlbumByIds(Long userId,Long albumId);
}
