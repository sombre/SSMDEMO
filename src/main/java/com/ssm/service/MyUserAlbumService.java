package com.ssm.service;

import com.ssm.model.Album;
import com.ssm.model.UserAlbum;

import java.util.List;

public interface MyUserAlbumService {

    int addUserAlbum(UserAlbum userAlbum) throws Exception;
    boolean removeUserAlbum(UserAlbum userAlbum) throws Exception;
}
