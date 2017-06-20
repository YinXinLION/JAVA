package com.nowcoder.async;

import com.alibaba.fastjson.JSON;
import com.nowcoder.model.Queue;
import com.nowcoder.util.RedisKeyUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * Created by 殷鑫 on 2017/2/12.
 */
@Service
public class EventConsumer implements InitializingBean,ApplicationContextAware{

    private Map<EventType , List<EventHandler>> config = new HashMap<EventType, List<EventHandler>>();
    private ApplicationContext applicationContext;
    @Autowired
    Queue queue;
    @Override
    public void afterPropertiesSet() throws Exception {

        Map<String, EventHandler> beans = applicationContext.getBeansOfType(EventHandler.class);
        if (beans != null){
            for (Map.Entry<String,EventHandler> entry : beans.entrySet()){  //获取map每一个实例
                List<EventType> entityTypes = entry.getValue().getSupportEventTypes();
                for (EventType type : entityTypes){

                    if (!config.containsKey(type)){
                         config.put(type,new ArrayList<EventHandler>()); //创建键值
                    }
                    config.get(type).add(entry.getValue());//放入 handler 对应的type
                }
            }
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    String key = RedisKeyUtil.getEventQueueKey();
                    List<String> events = queue.brpop(0,key); //从队列取出  第一个key 第二个eventType
                    for (String message : events){
                        if (message.equals(key)){   //如果取出是key 继续下一个
                            continue;
                        }

                        EventModel eventModel = JSON.parseObject(message,EventModel.class); //解析
                        if (!config.containsKey(eventModel.getType())){
                            continue;
                        }
                        for (EventHandler handler : config.get(eventModel.getType())){

                            handler.doHandle(eventModel);
                        }
                    }
                }
            }
        }).start();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
