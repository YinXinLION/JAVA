package sixth;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sun.security.krb5.internal.TGSRep;

import java.util.Random;

/**
 * Created by 殷鑫 on 2017/2/3.
 */
public class ThreadLocalTest {
    private static ThreadLocal<Integer> x = new ThreadLocal<Integer>();
    private static ThreadLocal<MyThreadScopeData> myThreadScopeDataThreadLocal = new ThreadLocal<MyThreadScopeData>();
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt(10);
                    System.out.println(Thread.currentThread().getName() + " has put data: "+data );
                    x.set(data);
//                    MyThreadScopeData myThreadScopeData = new MyThreadScopeData();
//                    myThreadScopeData.setName("name  "+data);
//                    myThreadScopeData.setAge(data);
                    MyThreadScopeData.getInstance().setName("name:" + data);
                    MyThreadScopeData.getInstance().setAge(data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }
    static class A{
        public void get(){
            int data = x.get();
            System.out.println("A from " + Thread.currentThread().getName() + " get data : " +data);
//            MyThreadScopeData myThreadScopeData = myThreadScopeDataThreadLocal.get();
//            System.out.println("-A-   "+myThreadScopeData.getName()+"  "+myThreadScopeData.getAge());
            MyThreadScopeData mydata = MyThreadScopeData.getInstance();
            System.out.println("A from " + Thread.currentThread().getName() + " getMyData: "+mydata.getName() + " , "+mydata.getAge());
        }
    }
    static class B{
        public void get(){
            int data = x.get();
            System.out.println("B from " + Thread.currentThread().getName() + " get data : " +data);
//            MyThreadScopeData myThreadScopeData = myThreadScopeDataThreadLocal.get();
//            System.out.println("-B-   "+myThreadScopeData.getName()+"  "+myThreadScopeData.getAge());
            MyThreadScopeData mydata = MyThreadScopeData.getInstance();
            System.out.println("B from " + Thread.currentThread().getName() + " getMyData: "+mydata.getName() + " , "+mydata.getAge());
        }
    }

}

//如何得到Thread结束时候的通知，注册回调
//ThreadDeathEvent

class MyThreadScopeData{
    private String name;
    private int age;
    private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<MyThreadScopeData>();
    private MyThreadScopeData() {
    }
    //线程各拿各的 不存在影响不用 synchronized
    public static /*synchronized*/ MyThreadScopeData getInstance(){
        MyThreadScopeData instance = map.get();
        if (instance == null){
            instance = new MyThreadScopeData();
            map.set(instance);
        }
        return instance;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}