package com.ssm.action;


import com.github.pagehelper.PageHelper;
import com.ssm.model.*;
import com.ssm.service.*;
import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AlbumAction {

    private MyAlbumService myAlbumService;

    private MyUserService myUserService;

    private MyPictureService myPictureService;

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

    public MyPictureService getMyPictureService() {
        return myPictureService;
    }
    @Autowired
    public void setMyPictureService(MyPictureService myPictureService) {
        this.myPictureService = myPictureService;
    }

    @RequestMapping(value = "album")
    public String goToAlumb(){
        return "album";
    }


    @RequestMapping(value = "album/{albumId}")
    public ModelAndView getAlumPictures(@PathVariable(value = "albumId") Long albumId) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<Map<Object,Object>> albumPictureList = new ArrayList<Map<Object, Object>>();
        if(null!=albumId){
            List<AlbumPicture> albumPictures = myAlbumService.getAlbumPicturesByAlbumId(albumId,1,10);
            for(AlbumPicture albumPicture:albumPictures){
                HashMap<Object,Object> map = new HashMap<Object, Object>();
                Picture picture = myPictureService.getPictureById(albumPicture.getPictureId());
                User user = myUserService.selectUserById(picture.getUploaderId());
                if(null!=picture && null!=user){
                    map.put(user,picture);
                    albumPictureList.add(map);
                }
            }
            Album album = myAlbumService.getAlbumDataByAlbumId(albumId);
            User author = myUserService.selectUserById(album.getAuthorId());
            modelAndView.addObject("albumPictureList",albumPictureList);
            modelAndView.addObject("album",album);
            modelAndView.addObject("author",author);
        }
        modelAndView.setViewName("album");
        return  modelAndView;
    }

    @RequiresAuthentication
    @RequestMapping(value = "album/createAlbum")
    @ResponseBody
    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 300,rollbackFor = {Exception.class})
    public Map<Object,Object> createAlbum(Long userId,String albumTitle,String albumDesc) throws Exception{
        Map<Object,Object> map = new HashMap<Object,Object>();
        if(null!=userId && null!=albumTitle && null!=albumDesc){
            Album album = new Album();
            album.setAuthorId(userId);
            album.setAlbumTitle(albumTitle);
            album.setAlbumDesc(albumDesc);
            int affected = myAlbumService.createAlbum(album);
            if(0!=affected){
                UserAlbum userAlbum = new UserAlbum();
                userAlbum.setAlbumId(album.getAlbumId());
                userAlbum.setUserId(userId);
                affected = myAlbumService.collectedAlbum(userAlbum);
                if(0!=affected){
                    map.put("album",album);
                    map.put("message","添加专辑成功!");
                    return map;
                }
            }
        }
        return  null;
    }


    @RequiresAuthentication
    @RequestMapping(value = "album/deleteAlbum")
    @ResponseBody
    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 300,rollbackFor = {Exception.class})
    public Map<Object,Object> deleteAlbum(Long albumId,Long userId) throws Exception{
        Map<Object,Object> map = new HashMap<Object,Object>();
        Album album = myAlbumService.getAlbumDataByAlbumId(albumId);
        if(null!=album){
            int affected = myAlbumService.deleteAlbum(album);
            if(0!=affected){
                UserAlbum userAlbum = new UserAlbum();
                userAlbum.setUserId(userId);
                userAlbum.setAlbumId(albumId);
                affected = myAlbumService.removeCollectedAlbum(userAlbum);
                if(0!=affected){
                    myAlbumService.removeAlbumAllPicture(albumId);
                    map.put("message","成功删除专辑!");
                    return map;
                }
            }
        }
        return  null;
    }



    @RequiresAuthentication
    @RequestMapping(value = "album/updateAlbum")
    @ResponseBody
    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 300,rollbackFor = {Exception.class})
    public Map<Object,Object> updateAlbum(Long albumId,String albumTitle,String albumDesc) throws Exception{
        Map<Object,Object> map = new HashMap<Object,Object>();
        if(null!=albumId){
            Album album = myAlbumService.getAlbumDataByAlbumId(albumId);
            if(null!=album){
                if(null!=albumTitle && null!=albumDesc){
                    album.setAlbumTitle(albumTitle);
                    album.setAlbumDesc(albumDesc);
                    int affected = myAlbumService.updateAlbum(album);
                    if(0!=affected){
                        map.put("album",album);
                        map.put("message","修改成功!");
                        return map;
                    }
                }
            }
        }
        return null;
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
    public List<Map<User,Album>> getUserCollectedAlbumByUid(@PathVariable("uid") Long uid,@PathVariable("page") int page,int pageSize) throws Exception{
        List<Album> albumList = myAlbumService.getUserCollectedAlbum(uid,page,pageSize);
        List<Map<User,Album>> mapList = new ArrayList<Map<User,Album>>();
        if(null!=albumList && 0!=albumList.size()){
            for(Album album : albumList){
                User user = myUserService.selectUserById(album.getAuthorId());
                if(null!=user){
                    Map<User,Album> userAlbumMap = new HashMap<User, Album>();
                    userAlbumMap.put(user,album);
                    mapList.add(userAlbumMap);
                }
            }
            return mapList;
        }
        return null;
    }

}
