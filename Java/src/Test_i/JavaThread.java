package Test_i;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by yinxin on 17-7-24.
 */
public class JavaThread {
    public static void main(String args[]) throws InterruptedException {
        //AtomicInteger i = new AtomicInteger(0);
        AtomicLong i = new AtomicLong(0);
        class NewThread extends Thread{
            public void run(){
                for(int j = 0; j < 1000000; ++j) {
                    i.addAndGet(1);
                }
            }
        }
        double start = System.currentTimeMillis();
        NewThread nt1 = new NewThread();
        NewThread nt2 = new NewThread();
        NewThread nt3 = new NewThread();
        nt1.start();
        nt2.start();
        nt3.start();
        nt1.join();
        nt2.join();
        nt3.join();
        double end = System.currentTimeMillis();
        System.out.println(i.get());
        System.out.println(end-start);
    }
}
