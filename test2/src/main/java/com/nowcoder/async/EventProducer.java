package com.nowcoder.async;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.nowcoder.model.Queue;
import com.nowcoder.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 殷鑫 on 2017/2/11.
 */
@Service
public class EventProducer {
    @Autowired
    Queue queue;
    public boolean fireEvent(EventModel eventModel){
        try {
            String json = JSONObject.toJSONString(eventModel);

            EventModel ev = JSON.parseObject(json,EventModel.class);
            String key = RedisKeyUtil.getEventQueueKey();
            queue.lpush(key,json);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
