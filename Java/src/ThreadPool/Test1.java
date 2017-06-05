package ThreadPool;

import com.sun.javafx.tk.Toolkit;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by 殷鑫 on 2017/6/5.
 */
public class Test1 {
    public static void main(String[] args) {
        AtomicInteger total = new AtomicInteger(0);
        CountDownLatch latch = new CountDownLatch(1000);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,100,10000, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(10));
        Task task = new Task(total,latch);
        for (int i = 0; i < 1000;i++){
            executor.execute(task);
        }
        try {
            latch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(total.get()+"--");
    }
}

class Task implements Runnable{
    AtomicInteger cnt;
    CountDownLatch latch;
    public Task(AtomicInteger cnt , CountDownLatch latch){
        this.cnt = cnt;
        this.latch = latch;
    }

    @Override
    public void run() {
        cnt.incrementAndGet();
        latch.countDown();
    }
}
