package com.ssm.action;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.ssm.model.*;
import com.ssm.service.*;
import com.ssm.util.DateUtil;
import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;


@Controller
public class PictureAction {

    private MyUserService myUserService;
    private MyPictureService myPictureService;
    private MyCommentService myCommentService;
    private MyUserPictureService myUserPictureService;


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
    public MyCommentService getMyCommentService() {
        return myCommentService;
    }
    @Autowired
    public void setMyCommentService(MyCommentService myCommentService) {
        this.myCommentService = myCommentService;
    }
    public MyUserPictureService getMyUserPictureService() {
        return myUserPictureService;
    }
    @Autowired
    public void setMyUserPictureService(MyUserPictureService myUserPictureService) {
        this.myUserPictureService = myUserPictureService;
    }

    @RequiresAuthentication
    @ResponseBody
    @RequestMapping(value = "/doUpload")
    public Map<Object,Object> uploadPicture(HttpSession session, HttpServletRequest request,
                                      @RequestParam(value = "pic",required = true)CommonsMultipartFile pic, String title, String desc) throws Exception{
        User curUser = (User)session.getAttribute("user");
        Map<Object,Object> map = new HashMap<Object,Object>();
        if(null!= curUser && null!=title && null!=desc){
            //取文件名
            String fileName = pic.getOriginalFilename();
            //从文件名里截取文件类型
            String fileType = fileName.split("[.]")[1];
            //为了避免文件名重复，在文件名前加UUID
            String uuid = UUID.randomUUID().toString();
            String uuidFileName = uuid + fileName;
            //系统路径分隔符
            final String  fileSeparator = System.getProperty("file.separator");
            String filePath ="C:\\IdeaProjects\\SSMDEMO\\src\\main\\webapp\\WEB-INF\\upload";
            filePath = request.getSession().getServletContext().getRealPath("");
            filePath = filePath  + fileSeparator +"WEB-INF" + fileSeparator +"upload";
            File targetFile = new File(filePath);
            //目录不存在，则创建目录
            if(!targetFile.exists()){
                targetFile.mkdirs();
            }
            //保存
            try {
                File writeFile = new File(filePath+fileSeparator+uuidFileName);
                pic.transferTo(writeFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String url = "upload/"+uuidFileName;
            Picture picture = new Picture();
            picture.setPicTitle(title);
            picture.setPicDesc(desc);
            picture.setUploaderId(curUser.getUid());
            picture.setUploadAt(DateUtil.getCurrentTimeLong());
            picture.setPath(filePath+fileSeparator+uuidFileName);
            picture.setUrl(url);
            int affected = myPictureService.addPicture(picture);
            Long pId = picture.getPicId();
            if(0!=affected){
                picture = myPictureService.getPictureById(pId);
                if(null!=picture){
                    UserPicture userPicture = new UserPicture();
                    userPicture.setPictureId(picture.getPicId());
                    userPicture.setUserId(curUser.getUid());
                    affected = myUserPictureService.addUserPicture(userPicture);
                    if(0!=affected){
                           map.put("picture",picture);
                           map.put("uploader",curUser);
                           map.put("message","上传成功!");
                           return map;
                    }
                }
            }
        }
        map.put("message","上传失败!");
        return map;
    }

    @RequestMapping(value = "picture/getSliderPicture")
    @ResponseBody
    public Map<Object,Object> getSliderPicture(int page,int pageSize) throws Exception{
        Map<Object,Object> map = new HashMap<Object,Object>();
        List<Picture> pictureList = myPictureService.getSliderPicture(pageSize);
        if(null!=pictureList && 0!=pictureList.size()){
            map.put("pictureList",pictureList);
            map.put("message","获取成功!");
            return map;
        }
        map.put("message","获取失败!");
        return map;
    }

    @RequestMapping(value = "picture/getIndexPicture")
    @ResponseBody
    public Map<Object,Object> getIndexPicture(int page,int pageSize) throws Exception{
        Map<Object,Object> map= new HashMap<Object,Object>();
        List<Picture> pictureList = myPictureService.getIndexPicture(page,pageSize);
        List<Object> pictureDataList = new ArrayList<Object>();
        if(null!=pictureList && 0!=pictureList.size()){
            for(Picture picture : pictureList){
                User user = myUserService.selectUserById(picture.getUploaderId());
                if(null!=user){
                    Map<Object,Object> pictureDataMap = new HashMap<Object,Object>();
                    ObjectMapper objectMapper = new ObjectMapper();
                    pictureDataMap.put(objectMapper.writeValueAsString(user),picture);
                    pictureDataList.add(pictureDataMap);
                }
            }
            map.put("pictureDataList",pictureDataList);
            map.put("message","获取主页图片成功!");
            return map;
        }
        map.put("message","获取主页图片失败!");
        return map;
    }




    @RequestMapping(value = "picture/{pId}")
    public ModelAndView getPicture(@PathVariable("pId") Long pid) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        if(null!=pid){
            Picture picture = myPictureService.getPictureById(pid);
            if(null!=picture){
                modelAndView.addObject("picture",picture);
                modelAndView.setViewName("image");
                //查询图片的所有评论
                List<Map<User,Comment>> userCommentList = myCommentService.getCommentsByPictureId(pid,1,10);
                if(null!=userCommentList && 0!=userCommentList.size()){
                    modelAndView.addObject("userCommentList",userCommentList);
                }
                //查询图片上传者资料
                User author = myUserService.selectUserById(picture.getUploaderId());
                if(null!=author){
                    modelAndView.addObject("author",author);
                }
                return modelAndView;
            }
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "user/{uid}/picture/{page}")
    public Map<Object,Object> getUserCollectedPictureByUid(@PathVariable("uid") Long uid,@PathVariable("page") int page,int pageSize) throws Exception{
        User spaceOwner = myUserService.selectUserById(uid);
        Map<Object,Object> map = new HashMap<Object,Object>();
        List<Object> pictureDataList = new ArrayList<Object>();
        if(spaceOwner!=null){
            List<Picture> pictureList = myPictureService.getUserCollectedPicturesByUid(uid,page,pageSize);
            if(null!=pictureList){
                for(Picture picture : pictureList){
                    Map<Object,Object> pictureDataMap = new HashMap<Object,Object>();
                    User uploader = myUserService.selectUserById(picture.getUploaderId());
                    ObjectMapper objectMapper = new ObjectMapper();
                    if(null!=uploader){
                        pictureDataMap.put(objectMapper.writeValueAsString(uploader),picture);
                        pictureDataList.add(pictureDataMap);
                    }
                }
                map.put("pictureDataList",pictureDataList);
                map.put("spaceOwner",spaceOwner);
                map.put("message","查询完毕");
            }
            return map;
        }
        map.put("message","查询用户收藏的图片失败!");
        return map;
    }





    @RequestMapping(value = "picture/addPictureThumbNum")
    @ResponseBody
    public Map<Object,Object> addPictureThumbNum(Long pictureId) throws Exception{
        Map<Object,Object> map = new HashMap<Object,Object>();
        Picture picture = myPictureService.getPictureById(pictureId);
        if(null!=picture){
            picture.setThumbNum(picture.getThumbNum()+1);
            int affected = myPictureService.updatePicture(picture);
            if(0!=affected){
                map.put("message","点赞成功!");
                return map;
            }
        }
        map.put("message","点赞失败!");
        return null;
    }


    @RequestMapping(value = "picture/removePictureThumbNum")
    @ResponseBody
    public Map<Object,Object> removePictureThumbNum(Long pictureId) throws Exception{
        Map<Object,Object> map = new HashMap<Object,Object>();
        Picture picture = myPictureService.getPictureById(pictureId);
        if(null!=picture){
            picture.setThumbNum(picture.getThumbNum()-1);
            int affected = myPictureService.updatePicture(picture);
            if(0!=affected){
                map.put("message","取消点赞成功!");
                return map;
            }
        }
        map.put("message","取消点赞失败!");
        return null;
    }





    @RequiresAuthentication
    @RequestMapping(value = "picture/collectPicture")
    @ResponseBody
    public Map<String, String> collectPicture(Long userId,Long pictureId) throws Exception{
        Map<String,String> map = new HashMap<String, String>();
        UserPicture userPicture = new UserPicture();
        userPicture.setUserId(userId);
        userPicture.setPictureId(pictureId);
        int affected = myPictureService.addUserPicture(userPicture);
        if(0!=affected){
            Picture picture = myPictureService.getPictureById(pictureId);
            if(null!=picture){
                picture.setCollectedNum(picture.getCollectedNum()+1);
                affected = myPictureService.updatePicture(picture);
                if(0!=affected){
                    map.put("message","收藏成功!");
                    return map;
                }
            }

        }
        map.put("message","收藏失败!");
        return map;
    }

    @RequiresAuthentication
    @RequestMapping(value = "picture/removePicture")
    @ResponseBody
    public Map<String,String> removeCollectedPicture(Long userId,Long pictureId) throws Exception{
        UserPicture userPicture = myPictureService.getUserPictureByIds(userId,pictureId);
        Map<String,String> map = new HashMap<String, String>();
        if(null!=userPicture)
        {
            if(myPictureService.removeUserPicture(userPicture)) {
                Picture picture = myPictureService.getPictureById(pictureId);
                if(null!=picture){
                    picture.setCollectedNum(picture.getCollectedNum()-1);
                    int affected = myPictureService.updatePicture(picture);
                    if(0!=affected){
                        map.put("message","取消收藏成功!");
                        return map;
                    }
                }
            }
        }
        map.put("message","取消失败!");
        return map;
    }



    @RequestMapping(value = "/picture/getCollectedPicture")
    @ResponseBody
    public Map<String,Object> getCollectedPicture(Long userId,Long pictureId) throws Exception{
        UserPicture userPicture = myPictureService.getUserPictureByIds(userId,pictureId);
        Map<String,Object> map = new HashMap<String, Object>();
        if(null!=userPicture)
        {
            map.put("userPicture",userPicture);
            return map;
        }
        map.put("message","获取图片失败!");
        return map;
    }






}
