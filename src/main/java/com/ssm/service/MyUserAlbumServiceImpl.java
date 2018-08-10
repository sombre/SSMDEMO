package com.ssm.service;

import com.ssm.dao.UserAlbumMapper;
import com.ssm.model.UserAlbum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyUserAlbumServiceImpl implements MyUserAlbumService {
    private UserAlbumMapper userAlbumMapper;

    public UserAlbumMapper getUserAlbumMapper() {
        return userAlbumMapper;
    }

    @Autowired
    public void setUserAlbumMapper(UserAlbumMapper userAlbumMapper) {
        this.userAlbumMapper = userAlbumMapper;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 3)
    public int addUserAlbum(UserAlbum userAlbum) throws Exception {
        return userAlbumMapper.insert(userAlbum);
    }
    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 3)
    public boolean removeUserAlbum(UserAlbum userAlbum) throws Exception {
        return false;
    }
}
