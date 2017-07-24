package Test_i;

/**
 * Created by yinxin on 17-7-24.
 */

import java.util.concurrent.atomic.LongAdder;
public class JavaLongAddr {
    public static void main(String args[]) throws InterruptedException {
        LongAdder la = new LongAdder();
        class CountThread extends Thread{
            public void run(){
                for(int i = 0; i < 1000000; ++i){
                    la.increment();
                }
            }
        }
        double start = System.currentTimeMillis();
        CountThread ct1 = new CountThread();
        CountThread ct2 = new CountThread();
        CountThread ct3 = new CountThread();
        ct1.start();
        ct2.start();
        ct3.start();
        ct1.join();
        ct2.join();
        ct3.join();
        double end = System.currentTimeMillis();
        System.out.println(la);
        System.out.println(end-start);
    }
}
