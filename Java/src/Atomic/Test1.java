package Atomic;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by 殷鑫 on 2017/6/4.
 */
public class Test1 {
    public AtomicInteger total;

    public static void main(String[] args) throws Exception {
        Test1 test = new Test1();
        test.total = new AtomicInteger(0);

        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 5_000; i++) {
                    test.total.incrementAndGet();
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                for (int i = 0; i < 5_000; i++) {
                    test.total.incrementAndGet();
                }
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(test.total.get());
        AtomicReference
    }
}
