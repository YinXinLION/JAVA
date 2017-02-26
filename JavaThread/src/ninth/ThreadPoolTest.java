package ninth;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by 殷鑫 on 2017/2/5.
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
//        ExecutorService threadpool = Executors.newFixedThreadPool(3);
//        ExecutorService threadpool = Executors.newCachedThreadPool();
        ExecutorService threadpool = Executors.newSingleThreadExecutor();
        for ( int i = 1; i <= 10; i++){
            final int task = i;
            threadpool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 1; j <= 10 ;j++){
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "loop of " + j + "for task of" + task);
                    }

                }
            });
        }
        System.out.println("all of 10 tasks have committed");
        threadpool.shutdown();

        Executors.newScheduledThreadPool(3).schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("bombing!");
            }
        },
        10,
                TimeUnit.SECONDS);
    }
}
