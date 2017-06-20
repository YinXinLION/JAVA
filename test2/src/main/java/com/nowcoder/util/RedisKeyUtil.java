package com.nowcoder.util;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * Created by 殷鑫 on 2017/2/8.
 */
public class RedisKeyUtil {
    private static String LIKE = "LIKE";
    private static String DISLIKE = "DISLIKE";
    private static String SPLIT = "-";
    private static String EVENTQUEUE = "EVENT_QUEUE";
    //粉丝
    private static String FOLLOWER = "FOLLOWER";
    //关注对象
    private static String FOLLOWEE = "FOLLOWEE";
    public static String getLikeKey(int entityType,int entityId){
        String key = LIKE + SPLIT + String.valueOf(entityType) + SPLIT+ String.valueOf(entityId);
        return key;
    }

    public static String getDisLikeKey(int entityType,int entityId){
        String key = DISLIKE + SPLIT + String.valueOf(entityType) + SPLIT+ String.valueOf(entityId);
        return key;
    }

    public static String getEventQueueKey(){
        return EVENTQUEUE;
    }

    public static String getFollowerKey(int entityType, int entityId){
        String key = FOLLOWER + SPLIT + String.valueOf(entityType) + SPLIT + String.valueOf(entityId);
        return key;
    }
    public static String getFolloweeKey(int userId, int entityType){
        String key = FOLLOWEE + SPLIT + String.valueOf(userId) + SPLIT + String .valueOf(entityType);
        return key;
    }
}
