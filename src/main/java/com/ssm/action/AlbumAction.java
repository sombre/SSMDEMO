package com.ssm.action;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AlbumAction {

    @RequestMapping(value = "album")
    public String goToAlumb(){
        return "album";
    }


    @RequestMapping(value = "")
    public Map<Object,List> getUserCreatedAlbum() throws Exception{

        return null;
    }


    @RequestMapping(value = "/picture/getCollectedAlbum")
    @ResponseBody
    public Map<String,Object> getCollectedAlbum(Long userId,Long pictureId) throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();

        return map;
    }

    @RequestMapping(value = "user/{uid}/album/{page}")
    public Map<Object,List> getUserCollectedAlbumByUid(@PathVariable("uid") Long uid,@PathVariable("page") Long page) throws Exception{

        return null;
    }

}
