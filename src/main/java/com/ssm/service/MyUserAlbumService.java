package com.ssm.service;

import com.ssm.model.UserAlbum;

public interface MyUserAlbumService {

    int addUserAlbum(UserAlbum userAlbum) throws Exception;
    boolean removeUserAlbum(UserAlbum userAlbum) throws Exception;
}
