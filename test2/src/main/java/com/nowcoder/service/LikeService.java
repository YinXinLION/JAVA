package com.nowcoder.service;

import com.nowcoder.model.Like;
import com.nowcoder.util.RedisKeyUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by 殷鑫 on 2017/2/8.
 */
//Use Redis
@Service
public class LikeService{
    @Autowired
    Like like;
    public long like(int userId,  int entityType,int entityId){
        String likeKey = RedisKeyUtil.getLikeKey(entityType,entityId);
        like.sadd(likeKey,String.valueOf(userId));

        String disLikeKey = RedisKeyUtil.getDisLikeKey(entityType,entityId);
        like.srem(disLikeKey,String.valueOf(userId));

        return like.scard(likeKey);
    }
    public long dislike(int userId, int entityType ,int entityId){

        String disLikeKey = RedisKeyUtil.getDisLikeKey(entityType,entityId);
        like.sadd(disLikeKey,String.valueOf(userId));

        String likeKey = RedisKeyUtil.getLikeKey(entityType,entityId);
        like.srem(likeKey,String.valueOf(userId));

        return like.scard(likeKey);
    }

    public int getStatus(int userId, int entityType,int entityId ){
        String key = RedisKeyUtil.getLikeKey(entityType,entityId);
        String value = String.valueOf(userId);

        if (like.sismemeber(key,value) == true){
            return 1;//如果是喜欢
        }
        key = RedisKeyUtil.getDisLikeKey(entityType,entityId);
        if (like.sismemeber(key,value)){
            return -1;//不喜欢
        }else {
            return 0;
        }
    }

    public int getLikeCount(int entityType, int entityId){
        String key = RedisKeyUtil.getLikeKey(entityType,entityId);
        return (int) like.scard(key);
    }

}
