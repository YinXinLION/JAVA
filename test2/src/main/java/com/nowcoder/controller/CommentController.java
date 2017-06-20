package com.nowcoder.controller;

import com.nowcoder.dao.QuestionDAO;
import com.nowcoder.model.Comment;
import com.nowcoder.model.EntityType;
import com.nowcoder.model.HostHolder;
import com.nowcoder.model.Question;
import com.nowcoder.service.CommentService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * Created by 殷鑫 on 2017/2/2.
 */
@Controller
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    CommentService commentService;
    @Autowired
    HostHolder hostHolder;
    @Autowired
    QuestionDAO questionDAO;

    @RequestMapping(path = {"/addComment"},method = {RequestMethod.POST})
    public String addComment(@RequestParam("questionId") int questionId,
                             @RequestParam("content") String content){
        try {
            Comment comment = new Comment();
            if (hostHolder.getUser() == null){
                return "redirect:/relogin";
            }else {
                comment.setUserId(hostHolder.getUser().getId());
            }
            comment.setEntityId(questionId);
            comment.setEntityType(EntityType.ENEITY_COMMENT);
            comment.setCreatedDate(new Date());
            comment.setContent(content);
            commentService.addComment(comment);
            questionDAO.updateQuestionCount(comment.getEntityId(),commentService.getCommentCount(comment.getEntityId(),comment.getEntityType()));
        }catch (Exception e){
            logger.error("增加评论失败"+e.getMessage());
        }
        return "redirect:/question/" + questionId;
    }
}
