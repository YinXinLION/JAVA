package com.nowcoder.async;

/**
 * Created by 殷鑫 on 2017/2/11.
 */
public enum EventType {
    LIKE(0),
    COMMENT(1),
    LOGIN(2),
    MAIL(3),
    FOLLOW(4),
    UNFOLLOW(5);
    private int value;
    EventType(int value) {
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
