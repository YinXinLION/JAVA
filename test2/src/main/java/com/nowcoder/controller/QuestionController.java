package com.nowcoder.controller;

import com.nowcoder.model.*;
import com.nowcoder.service.CommentService;
import com.nowcoder.service.LikeService;
import com.nowcoder.service.QuestionService;
import com.nowcoder.service.UserService;
import com.nowcoder.util.WendaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 殷鑫 on 2017/1/31.
 */
@Controller
public class QuestionController {
    private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
    @Autowired
    QuestionService questionService;
    @Autowired
    HostHolder hostHolder;
    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;
    @Autowired
    LikeService likeService;
    @RequestMapping(value = {"/question/add"},method = {RequestMethod.POST})
    @ResponseBody
    public String addQuestion(@RequestParam("title") String title,
                              @RequestParam("content") String content){
        try {
            Question question = new Question();
            question.setContent(content);
            question.setTitle(title);
            question.setCreatedDate(new Date());
            question.setCommentCount(0);
            if (hostHolder.getUser() == null){
                return WendaUtil.getJSONString(999);
            }else {
                question.setUserId(hostHolder.getUser().getId());
            }
            if(questionService.addQuestion(question) > 0){
                return WendaUtil.getJSONString(0);
            }
        }catch (Exception e){
            logger.error("增加提问失败"+e.getMessage());
        }
        return WendaUtil.getJSONString(1,"失败");
    }

    //问题详情
    @RequestMapping(path = {"/question/{id}"})
    public String QuestionDeatil(
            Model model,
            @PathVariable("id") int id){
    //        System.out.println("asd");
        Question question = questionService.findQuestion(id);
        model.addAttribute("question",question);

        List<Comment> commentList = commentService.getCommentByEntity(id,EntityType.ENEITY_COMMENT);
        List<ViewObject> comments = new ArrayList<ViewObject>();
        for (Comment comment : commentList){
            ViewObject vo = new ViewObject();
            vo.set("comment",comment);
            int status = 0; //设置状态
            if (hostHolder.getUser() == null){
                vo.set("liked",0);

            }else {
                //当前用户点赞状态
                vo.set("liked",likeService.getStatus(hostHolder.getUser().getId(),EntityType.ENEITY_COMMENT,comment.getId()));


            }
            vo.set("likedCount",likeService.getLikeCount(EntityType.ENEITY_COMMENT,comment.getId()));



            vo.set("user",userService.getUser(comment.getUserId()));
            comments.add(vo);
        }
        model.addAttribute("comments",comments);
        return "detail";
    }
}
