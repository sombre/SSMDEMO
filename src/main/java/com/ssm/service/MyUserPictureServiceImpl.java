package com.ssm.service;

import com.ssm.dao.UserPictureMapper;
import com.ssm.dao.UserPictureService;
import com.ssm.model.UserPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyUserPictureServiceImpl implements MyUserPictureService {
    private UserPictureMapper userPictureMapper;
    private UserPictureService userPictureService;

    public UserPictureMapper getUserPictureMapper() {
        return userPictureMapper;
    }
    @Autowired
    public void setUserPictureMapper(UserPictureMapper userPictureMapper) {
        this.userPictureMapper = userPictureMapper;
    }

    public UserPictureService getUserPictureService() {
        return userPictureService;
    }
    @Autowired
    public void setUserPictureService(UserPictureService userPictureService) {
        this.userPictureService = userPictureService;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 3)
    public int addUserPicture(UserPicture userPicture) throws Exception {
        return userPictureMapper.insert(userPicture);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 3)
    public boolean removeUserPicture(UserPicture userPicture) throws Exception {
        int affected = userPictureMapper.deleteByPrimaryKey(userPicture.getUserPicId());
        if(0!=affected) return true;
        return false;
    }

    public UserPicture getUserPictureByIds(Long userId, Long pictureId) throws Exception {
        UserPicture userPicture=userPictureService.getUserPictureByIds(userId,pictureId);
        if(null!=userPicture) return userPicture;
        return null;
    }
}
