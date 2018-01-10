package com.ssm.action;

import com.ssm.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;


@Controller
@RequestMapping("/post")
public class PostAction {


    private IPostService postService;

    public IPostService getTopicService() {
        return postService;
    }
    @Autowired
    public void setTopicService(IPostService postService) {
        this.postService = postService;
    }
    @RequestMapping("/showpost")
    public ModelAndView showPostAndComment () throws Exception{
        ModelAndView mv = new ModelAndView();
        this.postService.showPostAndComment();
        List<HashMap<String,Object>> resultCollection = this.postService.showPostAndComment();
        mv.addObject("collections",resultCollection);
//        for(Map<String,Object> map : resultCollection){
//            for(Map.Entry<String,Object> m : map.entrySet())
//            {
//                System.out.print(m.getKey()+ " ");
//                System.out.print(m.getValue());
//            }
//        }
        mv.setViewName("topic");
        return mv;
    }

}
