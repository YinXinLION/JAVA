package org.mlinge.s02;

/**
 * Created by 殷鑫 on 2017/3/13.
 */
public class MySingleton {
    private static MySingleton instance = null;

    private MySingleton(){}

    public synchronized static MySingleton getInstance() {
        try {
            if(instance != null){//懒汉式

            }else{
                //创建实例之前可能会有一些准备性的耗时工作
                Thread.sleep(300);
                instance = new MySingleton();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return instance;
    }
}
