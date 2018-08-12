package com.ssm.service;

import com.ssm.dao.AlbumPictureService;
import com.ssm.dao.AlbumService;
import com.ssm.model.AlbumPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class MyAlbumPictureServiceImpl implements MyAlbumPictureService {
    private AlbumService albumService;
    private AlbumPictureService albumPictureService;
    public AlbumService getAlbumService() {
        return albumService;
    }
    @Autowired
    public void setAlbumService(AlbumService albumService) {
        this.albumService = albumService;
    }

    public AlbumPictureService getAlbumPictureService() {
        return albumPictureService;
    }
    @Autowired
    public void setAlbumPictureService(AlbumPictureService albumPictureService) {
        this.albumPictureService = albumPictureService;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 3)
    public List<AlbumPicture> getAlbumPicturesByAlbumId(Long albumId) throws Exception {
        return albumPictureService.getAlbumPictures(albumId);
    }

}
