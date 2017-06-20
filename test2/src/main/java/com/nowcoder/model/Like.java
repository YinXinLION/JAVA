package com.nowcoder.model;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by 殷鑫 on 2017/2/8.
 */
@Component
public class Like implements InitializingBean{
    private JedisPool pool;

    public long sadd(String key, String value){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.sadd(key,value);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            if (jedis!=null){
                jedis.close();
            }
        }
        return 0;
    }

    public long scard(String key){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.scard(key);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            if (jedis!=null){
                jedis.close();
            }
        }
        return 0;
    }

    public long srem(String key, String value){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.srem(key,value);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            if (jedis!=null){
                jedis.close();
            }
        }
        return 0;
    }

    public boolean sismemeber(String key, String value){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.sismember(key,value);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            if (jedis!=null){
                jedis.close();
            }
        }
        return false;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        pool = new JedisPool("redis://localhost:6379/9");
    }


}
