package com.nowcoder.model;

import org.springframework.stereotype.Component;

/**
 * Created by 殷鑫 on 2017/1/29.
 */
@Component
public class HostHolder {
    public static ThreadLocal<User> userThreadLocal = new ThreadLocal<User>();
    public User getUser(){
        return userThreadLocal.get();
    }
    public void setUser(User user){
        userThreadLocal.set(user);
    }
    public void clean() {
        userThreadLocal.remove();
    }
}
