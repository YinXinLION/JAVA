package com.nowcoder.model;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * Created by 殷鑫 on 2017/2/11.
 */
@Component
public class Queue implements InitializingBean{
    private JedisPool pool;

    public long lpush(String key, String value){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.lpush(key,value);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            if (jedis!=null){
                jedis.close();
            }
        }
        return 0;
    }
    public List<String> brpop(int timeout ,String key){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.brpop(timeout , key);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            if (jedis!=null){
                jedis.close();
            }
        }
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        pool = new JedisPool("redis://localhost:6379/9");
    }
}
