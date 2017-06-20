package com.nowcoder.service;

import com.nowcoder.util.JedisAdapter;
import com.nowcoder.util.JedisUtil;
import com.nowcoder.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by 殷鑫 on 2017/2/17.
 */
@Service
public class FollowService {
    @Autowired
    JedisUtil jedisUtil;
    //关注
    public boolean follow(int userId, int entityType, int entityId){
        String followerKey = RedisKeyUtil.getFollowerKey(entityType,entityId); //关注人中被关注对象集合
        String followeeKey = RedisKeyUtil.getFolloweeKey(userId,entityType);//关注人，关注的集合
        Date date = new Date();
        Jedis jedis = jedisUtil.getJedis();
        Transaction transaction =  jedisUtil.multi(jedis);
        transaction.zadd(followerKey, date.getTime(), String.valueOf(userId));
        transaction.zadd(followeeKey, date.getTime(), String.valueOf(entityId));
        List<Object> ret = jedisUtil.exec(transaction, jedis);
        return ret.size() == 2 && (Long) ret.get(0) > 0 && (Long)ret.get(1) > 0;
    }
    //取消关注
    public boolean unfollow(int userId, int entityType, int entityId){
        String followerKey = RedisKeyUtil.getFollowerKey(entityType,entityId);
        String followeeKey = RedisKeyUtil.getFolloweeKey(userId,entityType);
        Date date = new Date();
        Jedis jedis = jedisUtil.getJedis();
        Transaction transaction =  jedisUtil.multi(jedis);
        transaction.zrem(followerKey,String.valueOf(userId));
        transaction.zrem(followeeKey,String.valueOf(entityId));
        List<Object> ret = jedisUtil.exec(transaction, jedis);
        return ret.size() == 2 && (Long) ret.get(0) > 0 && (Long)ret.get(1) > 0;
    }
    //set转list
    public List<Integer> getIdsFromSet(Set<String> idset) {
        List<Integer> ids = new ArrayList<>();
        for (String id : idset) {
            ids.add(Integer.parseInt(id));
        }
        return ids;
    }

    //获取关注对象的人
    public List<Integer> getFollowers(int entityType, int entityId, int count){
        String followerKey = RedisKeyUtil.getFollowerKey(entityType,entityId);
        return getIdsFromSet(jedisUtil.zrevrange(followerKey,0,count));
    }
    public List<Integer> getFollowers(int entityType, int entityId, int offset, int count){
        String followerKey = RedisKeyUtil.getFollowerKey(entityType,entityId);
        return getIdsFromSet(jedisUtil.zrevrange(followerKey,offset,count));
    }
    //获取用户关注所有问题
    public List<Integer> getFollowees(int userId, int entityId, int count){
        String followeeKey = RedisKeyUtil.getFolloweeKey(userId,entityId);
        return getIdsFromSet(jedisUtil.zrevrange(followeeKey,0,count));
    }
    public List<Integer> getFollowees(int userId, int entityId, int offset, int count){
        String followeeKey = RedisKeyUtil.getFolloweeKey(userId,entityId);
        return getIdsFromSet(jedisUtil.zrevrange(followeeKey,offset,count));
    }

    public long getFollowerCount(int entityType, int entityId){
        String followerKey = RedisKeyUtil.getFollowerKey(entityType, entityId);
        return jedisUtil.zcard(followerKey);
    }

    public long getFolloweeCount(int userId,int entityType){
        String followeeKey = RedisKeyUtil.getFolloweeKey(userId, entityType);
        return jedisUtil.zcard(followeeKey);
    }

    public boolean isFollower(int userId, int entityType, int entityId){
        String followerKey = RedisKeyUtil.getFollowerKey(entityType, entityId);
        return jedisUtil.zscore(followerKey,String.valueOf(userId)) != null;
    }


}
