package com.nowcoder.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.nowcoder.model.User;
import redis.clients.jedis.*;

/**
 * Created by 殷鑫 on 2017/2/5.
 */
public class JedisAdapter {
    public static void print(int index, Object object){
        System.out.println(String.format("%d ,%s",index,object.toString()));
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("\"redis://localhost:6379/9\"");
        jedis.flushDB();//清空数据库
        //jedis.flushAll();//清空所有数据库
        //get set 简单实用
        jedis.set("hello","world");
        print(1,jedis.get("hello"));
        jedis.rename("hello","newhello"); //改名
        print(1,jedis.get("newhello"));
        jedis.setex("lala",10,"bubu");//带过期时间


        jedis.set("pv","100");
        jedis.incr("pv");
        jedis.incrBy("pv",5);
        jedis.decrBy("pv",2);
        print(2,jedis.get("pv"));

        print(3,jedis.keys("*"));

        String listName = "list";
        jedis.del("list");
        for (int i = 0; i < 10; i++){
            jedis.lpush(listName,"a"+String.valueOf(i));
        }
        print(4,jedis.lrange(listName,0,12));
        print(4,jedis.lrange(listName,0,3));

        print(5,jedis.llen(listName));
        print(6,jedis.lpop(listName));
        print(7,jedis.llen(listName));
        print(8,jedis.lrange(listName,2,6));
        print(9,jedis.lindex(listName,3));

        print(10,jedis.linsert(listName, BinaryClient.LIST_POSITION.AFTER,"a4","xx"));
        print(10,jedis.linsert(listName, BinaryClient.LIST_POSITION.BEFORE,"a4","bb"));
        print(10,jedis.lrange(listName,0,10));


        //hash
        String userKey = "userxx";
        jedis.hset(userKey,"name","jim");
        jedis.hset(userKey,"age","12");
        jedis.hset(userKey,"phone","1821939131");
        print(12,jedis.hget(userKey,"name"));
        print(13,jedis.hgetAll(userKey));
        jedis.hdel(userKey,"phone");
        print(14,jedis.hgetAll(userKey));
        print(15,jedis.hexists(userKey,"email"));
        print(16,jedis.hexists(userKey,"age"));
        print(17,jedis.hkeys(userKey));
        print(18,jedis.hvals(userKey));
        jedis.hsetnx(userKey,"school","zju");
        jedis.hsetnx(userKey,"name","yxy");
        print(19,jedis.hgetAll(userKey));

        //set
        String likeKey1 = "commentLike1";
        String likeKey2 = "commentLike2";
        for (int i = 0; i < 10; i++){
            jedis.sadd(likeKey1,String.valueOf(i));
            jedis.sadd(likeKey2,String.valueOf(i*i));
        }
        print(20,jedis.smembers(likeKey1));
        print(21,jedis.smembers(likeKey2));
        print(22,jedis.sunion(likeKey1,likeKey2));//并集
        print(23,jedis.sdiff(likeKey1,likeKey2));//1有的2没有
        print(24,jedis.sinter(likeKey1,likeKey2));//交集
        print(25,jedis.sismember(likeKey1,"12"));
        print(26,jedis.sismember(likeKey2,"16"));
        jedis.srem(likeKey1,"5");
        print(27,jedis.smembers(likeKey1));
        jedis.smove(likeKey2,likeKey1,"25");
        print(28,jedis.smembers(likeKey1));
        print(28,jedis.smembers(likeKey2));
        print(29,jedis.scard(likeKey1));//成员数量

        //
        String rankKey = "rankKey";
        jedis.zadd(rankKey,15,"jim");
        jedis.zadd(rankKey,60,"Ben");
        jedis.zadd(rankKey,90,"Lee");
        jedis.zadd(rankKey,75,"Lucy");
        jedis.zadd(rankKey,80,"Mei");
        print(30,jedis.zcard(rankKey));
        print(31,jedis.zcount(rankKey,61,100));
        print(32,jedis.zscore(rankKey,"Lucy"));
        jedis.zincrby(rankKey,2,"Lucy");
        print(33,jedis.zscore(rankKey,"Lucy"));
        jedis.zincrby(rankKey,2,"Luc");
        print(35,jedis.zscore(rankKey,"Luc"));
        print(36,jedis.zrange(rankKey,0,100 ));
        print(37,jedis.zrange(rankKey,1,3));
        print(38,jedis.zrevrange(rankKey,0,3));

        for (Tuple tuple : jedis.zrangeByScoreWithScores(rankKey,"60","100")){
            print(37,tuple.getElement() + " : " + String.valueOf(tuple.getScore()));
        }

        print(38,jedis.zrank(rankKey,"Ben")); //查看Ben排名，从低到高
        print(39,jedis.zrevrank(rankKey,"Ben"));//从高到低排名

        String setKey = "zset";
        jedis.zadd(setKey,1,"a");
        jedis.zadd(setKey,1,"b");
        jedis.zadd(setKey,1,"c");
        jedis.zadd(setKey,1,"d");
        jedis.zadd(setKey,1,"e");
        jedis.zadd(setKey,1,"f");
        print(40,jedis.zlexcount(setKey,"-","+"));//一共有多少个成员  负无穷到正无穷
        print(41,jedis.zlexcount(setKey,"(b","[d")); //(b,d]
        print(42,jedis.zlexcount(setKey,"[b","[d"));//[b,d]
        jedis.zrem(setKey,"b");
        print(43,jedis.zrange(setKey,0,10));// 0-10位置元素
        jedis.zremrangeByLex(setKey,"(c","+"); //删除(c,+)
        print(44,jedis.zrange(setKey,0,2));

        //连接池
//        JedisPool pool = new JedisPool();
//        for (int i = 0; i < 100; i++){
//            Jedis j = pool.getResource();
//            j.get("pv");
//
//            j.close();
//        }

        User user = new User();
        user.setName("xx");
        user.setPassword("ppp");
        user.setHeadUrl("a.png");
        user.setSalt("salt");
        user.setId(1);
        print(46, JSONObject.toJSONString(user));
        jedis.set("user1",JSONObject.toJSONString(user)); //转换成json格式并set如redis
        String value = jedis.get("user1");
        User user2 = JSONObject.parseObject(value, User.class);
        System.out.println(user.getHeadUrl());

    }
}
