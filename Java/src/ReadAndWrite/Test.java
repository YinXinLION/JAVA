package ReadAndWrite;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by 殷鑫 on 2017/6/5.
 */
public class Test {
    int reader_max = 3;
    int writer_max = 2;
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private Lock read = rwl.readLock();

    public static void main(String[] args) {
        new Test().rwl.writeLock();
    }
}
