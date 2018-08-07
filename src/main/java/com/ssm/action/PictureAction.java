package com.ssm.action;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.ssm.model.Comment;
import com.ssm.model.Picture;
import com.ssm.model.User;
import com.ssm.service.MyCommentService;
import com.ssm.service.MyPictureService;
import com.ssm.service.MyUserService;
import com.ssm.util.DateUtil;
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



    @RequiresAuthentication
    @ResponseBody
    @RequestMapping(value = "/doUpload")
    public Picture uploadPicture(HttpSession session, HttpServletRequest request,
                                      @RequestParam(value = "pic",required = true)CommonsMultipartFile pic, String title, String desc) throws Exception{
        User curUser = (User)session.getAttribute("user");
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
                    return picture;
                }
            }
        }
        return null;
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
                HashMap<User,Comment> userCommentHashMap = myCommentService.getCommentsByPictureId(pid);
                if(null!=userCommentHashMap && 0!=userCommentHashMap.size()){
                    modelAndView.addObject("userCommentMap",userCommentHashMap);
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
    public Map<Object,List> getUserCollectedPictureByUid(@PathVariable("uid") Long uid,@PathVariable("page") int page) throws Exception{
        User tmpUser = myUserService.selectUserById(uid);
        if(tmpUser!=null){
            PageHelper.startPage(page, 10);
            List<Picture> pictureList = myPictureService.getUserCollectedPicturesByUid(uid);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(tmpUser);
            Map<Object,List> result = new HashMap<Object,List>();
            result.put(json,pictureList);
            return result;
        }
        return null;

    }





}
