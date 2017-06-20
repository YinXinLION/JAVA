package com.nowcoder.controller;

import com.nowcoder.async.EventModel;
import com.nowcoder.async.EventProducer;
import com.nowcoder.async.EventType;
import com.nowcoder.model.Comment;
import com.nowcoder.model.EntityType;
import com.nowcoder.model.HostHolder;
import com.nowcoder.service.CommentService;
import com.nowcoder.service.LikeService;
import com.nowcoder.util.WendaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 殷鑫 on 2017/2/8.
 */
@Controller
public class LikeController {
    @Autowired
    LikeService likeService;
    @Autowired
    HostHolder hostHolder;
    @Autowired
    CommentService commentService;
    @Autowired
    EventProducer eventProducer;


    @RequestMapping(path = {"/like"},method = {RequestMethod.POST})
    @ResponseBody
    public String Like(@RequestParam("commentId") int commentId){

        if (hostHolder.getUser() == null){
            return WendaUtil.getJSONString(999,"未登录");
        }

        long likeCount = likeService.like(hostHolder.getUser().getId(),EntityType.ENEITY_COMMENT,commentId );
        Comment comment = commentService.selectById(commentId);


        eventProducer.fireEvent(new EventModel().setActorId(hostHolder.getUser().getId())
        .setEntityOwnerId(comment.getUserId())
        .setEntityType(EntityType.ENEITY_COMMENT)
        .setEntityId(commentId)
        .setExt("questionId",String.valueOf(comment.getEntityId()))
        .setType(EventType.LIKE));
        return WendaUtil.getJSONString(0,String.valueOf(likeCount));
    }

    @RequestMapping(path = {"/dislike"},method = {RequestMethod.POST})
    @ResponseBody
    public String disLike(@RequestParam("commentId") int commentId){
        if (hostHolder.getUser() == null){
            return WendaUtil.getJSONString(999,"未登录");
        }

        long likeCount = likeService.dislike(hostHolder.getUser().getId(), EntityType.ENEITY_COMMENT,commentId);
        return WendaUtil.getJSONString(0,String.valueOf(likeCount));
    }
}
