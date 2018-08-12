package com.ssm.action;


import com.github.pagehelper.PageHelper;
import com.ssm.model.Album;
import com.ssm.model.User;
import com.ssm.service.MyAlbumPictureService;
import com.ssm.service.MyAlbumService;
import com.ssm.service.MyUserAlbumService;
import com.ssm.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AlbumAction {

    private MyAlbumService myAlbumService;

    private MyUserService myUserService;

    public MyAlbumService getMyAlbumService() {
        return myAlbumService;
    }
    @Autowired
    public void setMyAlbumService(MyAlbumService myAlbumService) {
        this.myAlbumService = myAlbumService;
    }

    public MyUserService getMyUserService() {
        return myUserService;
    }
    @Autowired
    public void setMyUserService(MyUserService myUserService) {
        this.myUserService = myUserService;
    }

    @RequestMapping(value = "album")
    public String goToAlumb(){
        return "album";
    }


    @RequestMapping(value = "/album/getUserCreatedAlbum")
    @ResponseBody
    public List<Album> getUserCreatedAlbum(Long userId,int page,int pageSize) throws Exception{
        List<Album> albumList = myAlbumService.getUserCreatedAlbum(userId,page,pageSize);
        if(null!=albumList && 0!=albumList.size()){
            return  albumList;
        }
        return null;
    }


    @RequestMapping(value = "/album/getCollectedAlbum")
    @ResponseBody
    public Map<String,Object> getCollectedAlbum(Long userId,Long pictureId) throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();


        return map;
    }

    @RequestMapping(value = "user/{uid}/album/{page}")
    @ResponseBody
    public List<Map> getUserCollectedAlbumByUid(@PathVariable("uid") Long uid,@PathVariable("page") int page,int pageSize) throws Exception{
        List<Album> albumList = myAlbumService.getUserCollectedAlbum(uid,page,pageSize);
        List<Map> mapList = new ArrayList<Map>();
        if(null!=albumList && 0!=albumList.size()){
            for(Album album : albumList){
                User user = myUserService.selectUserById(album.getAuthorId());
                if(null!=user){
                    Map<User,Album> userAlbumMap = new HashMap<User, Album>();
                    userAlbumMap.put(user,album);
                    mapList.add(userAlbumMap);
                }
                return mapList;
            }
        }
        return null;
    }

}
