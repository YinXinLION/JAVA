package com.nowcoder.controller;

import com.nowcoder.model.HostHolder;
import com.nowcoder.model.Message;
import com.nowcoder.model.User;
import com.nowcoder.model.ViewObject;
import com.nowcoder.service.MessageService;
import com.nowcoder.service.UserService;
import com.nowcoder.util.WendaUtil;
import org.apache.ibatis.annotations.Select;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 殷鑫 on 2017/2/4.
 */
@Controller
public class MessageController {
    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
    @Autowired
    HostHolder hostHolder;
    @Autowired
    MessageService messageService;
    @Autowired
    UserService userService;

    @RequestMapping(path = {"/msg/addMessage"}, method = {RequestMethod.POST})
    @ResponseBody
    public String addMessage(@RequestParam("toName") String toName,
                             @RequestParam("content") String content) {
        try {
            if (hostHolder.getUser() == null) {
                return WendaUtil.getJSONString(999, "发送失败");
            }
            User user = userService.selectByName(toName);
            if (user == null) {
                return WendaUtil.getJSONString(1, "用户不存在");
            }
            Message message = new Message();
            message.setContent(content);
            message.setCreatedDate(new Date());
            message.setToId(user.getId());
            message.setFromId(hostHolder.getUser().getId());
            messageService.addMessage(message);
            return WendaUtil.getJSONString(0);
        } catch (Exception e) {
            logger.error("发送详细失败" + e.getMessage());
            return WendaUtil.getJSONString(999, "发送失败");
        }
    }

    @RequestMapping(path = {"msg/detail"},method = {RequestMethod.GET})
    public String getConversationDeatil(Model model,@RequestParam("conversationId")String conversationId){
        try {
            if (hostHolder.getUser() == null) {
                return "redirect:/relogin";
            }
            messageService.updateHasRead(hostHolder.getUser().getId(),conversationId);
            List<Message> messageList = messageService.getConversationDetail(conversationId,0,10);
            List<ViewObject> messages = new ArrayList<ViewObject>();
            for (Message message : messageList){
                ViewObject viewObject = new ViewObject();
                viewObject.set("message",message);
                viewObject.set("user",userService.getUser(message.getFromId()));
                messages.add(viewObject);
            }
            model.addAttribute("messages",messages);
        }catch (Exception e){
            logger.error("或许详情失败"+e.getMessage());
        }
        return "letterDetail";
    }
    @RequestMapping(path = {"msg/list"},method = {RequestMethod.GET})
    public String getConversationList(Model model){
        if (hostHolder.getUser() == null){
            return "redirect:/relogin";
        }
        int localUserId = hostHolder.getUser().getId();
        List<Message> messages = messageService.getConversationList(localUserId,0,10);
        List<ViewObject> conversations = new ArrayList<ViewObject>();
        for (Message message : messages){
            ViewObject viewObject = new ViewObject();
            viewObject.set("message",message);
            int targetId = 0;
            if (message.getFromId() == localUserId){
                targetId = message.getToId();
            }else {
                targetId = message.getFromId();
            }
            viewObject.set("user",userService.getUser(targetId));
            viewObject.set("unread",messageService.getNoReadMessageCount(localUserId,message.getConversationId()));
            conversations.add(viewObject);
        }
        model.addAttribute("conversations",conversations);
        return "letter";
    }
}
