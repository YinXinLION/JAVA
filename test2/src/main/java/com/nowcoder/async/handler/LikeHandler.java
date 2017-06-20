package com.nowcoder.async.handler;

import com.nowcoder.async.EventHandler;
import com.nowcoder.async.EventModel;
import com.nowcoder.async.EventType;
import com.nowcoder.model.Message;
import com.nowcoder.model.User;
import com.nowcoder.service.MessageService;
import com.nowcoder.service.UserService;
import com.nowcoder.util.WendaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by 殷鑫 on 2017/2/13.
 */
@Service
public class LikeHandler implements EventHandler {
    @Autowired
    MessageService messageService;
    @Autowired
    UserService userService;

    @Override
    public void doHandle(EventModel model) {
        Message message = new Message();
        User user = userService.selectById(model.getActorId());
        message.setCreatedDate(new Date());
        message.setToId(model.getEntityOwnerId());
        message.setFromId(WendaUtil.SYSTEM_ADMIN);
        message.setContent("用户"+user.getName()+"给您在http://127.0.0.1/question/"+ model.getExt("questionId") + "的评论中点了赞");
        messageService.addMessage(message);

    }

    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.LIKE);
    }
}
