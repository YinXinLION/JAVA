package tweleve;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by 殷鑫 on 2017/2/26.
 */

//缓存系统
public class CacheDemo {
    Map<String,Object> map = new HashMap<>();
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public static void main(String[] args) {

    }
    public Object getData(String key){
        readWriteLock.readLock().lock();
        Object value = null;
        try {
            value=map.get(key);
            if (value==null){
                readWriteLock.readLock().unlock();//读锁释放的
                readWriteLock.writeLock().lock();
                try {
                    if (value==null){
                        value="asda";
                    }

                }finally {

                    readWriteLock.writeLock().unlock();
                }
                readWriteLock.readLock().lock();
            }
        }catch (Exception e){

        }finally {
            readWriteLock.readLock().unlock();
        }


        return value;
    }
}
