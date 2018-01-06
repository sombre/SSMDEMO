package com.ssm.action;

import com.ssm.model.Comment;
import com.ssm.model.Topic;
import com.ssm.service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/topic")
public class TopicAction {


    private ITopicService topicService;

    public ITopicService getTopicService() {
        return topicService;
    }
    @Autowired
    public void setTopicService(ITopicService topicService) {
        this.topicService = topicService;
    }
    @RequestMapping("/showTopic")
    public ModelAndView showTopicAndComment () throws Exception{
        ModelAndView mv = new ModelAndView();
        List<HashMap<String,Object>> resultCollection = this.topicService.showPostAndComment();
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
