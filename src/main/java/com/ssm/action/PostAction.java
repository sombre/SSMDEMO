package com.ssm.action;

import com.ssm.model.Post;
import com.ssm.model.User;
import com.ssm.service.IPostService;
import com.ssm.util.DateUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;


@Controller
@RequestMapping("/post")
public class PostAction {


    private IPostService IPostService;

    public IPostService getIPostService() {
        return IPostService;
    }
    @Autowired
    public void setIPostService(IPostService IPostService) {
        this.IPostService = IPostService;
    }




    @RequiresAuthentication
    @RequiresPermissions(value = "de:log",logical = Logical.OR)
//    @RequiresRoles(value = {"user","manager"},logical = Logical.OR)
    @RequestMapping(value = "/addpost",method = RequestMethod.POST)
    public String addPost(HttpSession session, HttpServletRequest request,Post post) throws Exception{
        Subject currUser = SecurityUtils.getSubject();
        currUser.isPermitted("post:create");
        User user = (User)session.getAttribute("user");
        if(null!=user && null!=post.getTitle()){
            post.setAuthorid(user.getUid());
            post.setCreatedBy(user.getName());
            post.setCreatedAt(DateUtil.getCurrentTimeLong());
            if(this.IPostService.addPost(post))
            {
                return "redirect:/post/showpost";
            }
        }
        return "index";
    }




    @RequestMapping("/showpost")
    public ModelAndView showPostAndComment () throws Exception{
        ModelAndView mv = new ModelAndView();
        this.IPostService.showPostAndComment();
        List<HashMap> resultCollection = this.IPostService.showPostAndComment();
        mv.addObject("collections",resultCollection);
//        for(Map<String,Object> map : resultCollection){
//            for(Map.Entry<String,Object> m : map.entrySet())
//            {
//                System.out.print(m.getKey()+ " ");
//                System.out.print(m.getValue());
//            }
//        }
        mv.setViewName("post");
        return mv;
    }

}
