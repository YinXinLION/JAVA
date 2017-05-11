package Chapter8;

import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by 殷鑫 on 2017/5/11.
 */
public class TestHarness {
    public static long timeTasks(int nThreads,final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);


        //首先通过startGate让所有线程等待
        //当启动好所有线程后，让startGate 变为0 即线程开始执行
        //endGate.await();让主线程处于等待 当从nThread 到 0 时，即可返回
        //也就是当一个线程执行完，则-1 直到减为0停止。
        for (int i = 0; i < nThreads; i++){
            Thread t= new Thread(){
                public void run(){
                    try {
                        startGate.await();
                        try {
                            task.run();
                        }finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }
        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        System.out.println(end-start);
        return end - start;
    }

    public static void main(String[] args) throws InterruptedException {
        timeTasks(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("");
            }
        });
    }

}
