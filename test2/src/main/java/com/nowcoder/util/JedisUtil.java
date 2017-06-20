package com.nowcoder.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.Set;

/**
 * Created by 殷鑫 on 2017/2/17.
 */
@Component
public class JedisUtil implements InitializingBean{
    private JedisPool pool;

    public Jedis getJedis(){
        try {
            return  pool.getResource();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public  List<Object> exec(Transaction transaction, Jedis jedis){
        try {
            return  transaction.exec();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            if (transaction != null){
                try{
                    transaction.close();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
            if (jedis != null){
                jedis.close();
            }
        }
        return null;
    }

    public Transaction multi(Jedis jedis){
        return jedis.multi();
    }
    //添加
    public Long zadd(String key, double score, String value){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.zadd(key, score, value);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }


    public Set<String> zrevrange(String key, int start ,int end){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.zrange(key,0,end);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public long zcard(String key){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.zcard(key);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
    public Double zscore(String key, String userId){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.zscore(key,userId);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        pool = new JedisPool("redis://localhost:6379/9");
    }
}
