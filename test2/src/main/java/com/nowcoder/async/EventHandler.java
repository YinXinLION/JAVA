package com.nowcoder.async;

import java.util.List;

/**
 * Created by 殷鑫 on 2017/2/12.
 */
public interface EventHandler {
    void doHandle(EventModel model);//对指定类型处理
    List<EventType> getSupportEventTypes();//需要的类型
}
