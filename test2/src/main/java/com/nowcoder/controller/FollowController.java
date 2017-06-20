package com.nowcoder.controller;

import com.nowcoder.async.EventModel;
import com.nowcoder.async.EventProducer;
import com.nowcoder.async.EventType;
import com.nowcoder.model.*;
import com.nowcoder.service.CommentService;
import com.nowcoder.service.FollowService;
import com.nowcoder.service.QuestionService;
import com.nowcoder.util.WendaUtil;
import org.apache.commons.collections.map.HashedMap;
import org.apache.velocity.app.VelocityEngine;
import org.jaxen.util.FollowingSiblingAxisIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.EventPublicationInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 殷鑫 on 2017/2/19.
 */
@Controller
public class FollowController {
    @Autowired
    FollowService followService;
    @Autowired
    CommentService commentService;
    @Autowired
    HostHolder hostHolder;
    @Autowired
    EventProducer eventProducer;
    @Autowired
    QuestionService questionService;

    @RequestMapping(path = {"/followUser"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String followUser(@RequestParam("userId") int userId) {
        if (hostHolder.getUser() != null) {
            return WendaUtil.getJSONString(999);
        }
        //关注 人
        boolean status = followService.follow(hostHolder.getUser().getId(), EntityType.ENEITY_USER, userId);

        eventProducer.fireEvent(new EventModel(EventType.FOLLOW)
                .setActorId(hostHolder.getUser().getId())
                .setEntityId(userId)
                .setEntityType(EntityType.ENEITY_USER)
                .setEntityOwnerId(userId));
        //返回关注人数
        return WendaUtil.getJSONString(status ? 0 : 1, String.valueOf(followService.getFolloweeCount(hostHolder.getUser().getId(), EntityType.ENEITY_USER)));
    }

    @RequestMapping(path = {"/unfollowUser"}, method = {RequestMethod.POST})
    @ResponseBody
    public String unfollowUser(@RequestParam("userId") int userId) {
        if (hostHolder.getUser() != null) {
            return WendaUtil.getJSONString(999);
        }

        boolean status = followService.unfollow(hostHolder.getUser().getId(), EntityType.ENEITY_USER, userId);
        eventProducer.fireEvent(new EventModel(EventType.UNFOLLOW)
                .setActorId(hostHolder.getUser().getId())
                .setEntityOwnerId(userId)
                .setEntityId(userId)
        );
        return WendaUtil.getJSONString(status ? 0 : 1, String.valueOf(followService.getFolloweeCount(hostHolder.getUser().getId(), EntityType.ENEITY_USER)));
    }

    @RequestMapping(path = {"/followQuestion"}, method = {RequestMethod.POST})
    @ResponseBody
    public String followQuestion(@RequestParam("questionId") int questionId) {
        if (hostHolder.getUser() != null) {
            return WendaUtil.getJSONString(999);
        }
        Question q = questionService.findQuestion(questionId);
        if (q == null) {
            return WendaUtil.getJSONString(1, "问题不存在");
        }

        boolean status = followService.follow(hostHolder.getUser().getId(), EntityType.ENTITY_QUESTION, questionId);
        //加入事件
        eventProducer.fireEvent(new EventModel(EventType.FOLLOW)
                .setEntityId(questionId)
                .setActorId(hostHolder.getUser().getId())
                .setEntityType(EntityType.ENTITY_QUESTION)
                .setEntityOwnerId(q.getUserId()));
        //
        Map<String, Object> info = new HashMap<>();
        info.put("headUrl", hostHolder.getUser().getHeadUrl());
        info.put("name", hostHolder.getUser().getName());
        info.put("id", hostHolder.getUser().getId());
        info.put("count", followService.getFollowerCount(EntityType.ENTITY_QUESTION, q.getId()));
        return WendaUtil.getJSONString(status ? 0 : 1, info);
    }

    @RequestMapping(path = {"/unfollowQuestion"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String unfollowQuestion(@RequestParam("questionId") int questionId) {
        if (hostHolder.getUser() != null) {
            return WendaUtil.getJSONString(999);
        }

        Question q = questionService.findQuestion(questionId);
        if (q == null) {
            return WendaUtil.getJSONString(1, "问题不存在");
        }
        boolean status = followService.unfollow(hostHolder.getUser().getId(), EntityType.ENTITY_QUESTION, q.getId());

        eventProducer.fireEvent(new EventModel(EventType.UNFOLLOW)
                .setEntityId(questionId)
                .setActorId(hostHolder.getUser().getId())
                .setEntityOwnerId(q.getUserId())
                .setEntityType(EntityType.ENTITY_QUESTION));

        Map<String, Object> info = new HashMap<>();
        info.put("id", hostHolder.getUser().getId());
        info.put("count", followService.getFollowerCount(EntityType.ENTITY_QUESTION, questionId));
        return WendaUtil.getJSONString(status ? 0 : 1, info);
    }

    @RequestMapping(path = {"user/{uid}/followers"}, method = {RequestMethod.GET})
    public String followers(Model model, @PathVariable("uid") int userId) {
        //找到最新的10个
        List<Integer> followerIds = followService.getFollowers(EntityType.ENEITY_USER, userId, 0, 10);
//        if (hostHolder.getUser() != null){
//            model.addAttribute("followers",);
//        }
        return  " ";
    }


    private List<ViewObject> getUserInfo(int localUserId, List<Integer> userIds) {
        List<ViewObject> userInfos = new ArrayList<ViewObject>();
        return userInfos;
    }
}
