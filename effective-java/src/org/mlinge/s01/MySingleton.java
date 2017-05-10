package org.mlinge.s01;

/**
 * Created by 殷鑫 on 2017/3/13.
 */
public class MySingleton {
    private static MySingleton instance = new MySingleton();

    private MySingleton(){}

    public static MySingleton getInstance() {
        return instance;
    }
}
