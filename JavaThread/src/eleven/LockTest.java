package eleven;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 殷鑫 on 2017/2/7.
 */

public class LockTest {


    public static void main(String[] args) {
        new LockTest().init();
    }

    private void init(){
        final Outputer outputer = new Outputer();
        new Thread(new Runnable(){
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    outputer.output("LION");
                }

            }
        }).start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    outputer.output("Tiger");
                }

            }
        }).start();

    }

    static class Outputer{
       Lock lock = new ReentrantLock();
        public void output(String name){
            int len = name.length();
            lock.lock();
            try{
                for(int i=0;i<len;i++){
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }finally{
                lock.unlock();
            }
        }

        public synchronized void output2(String name){
            int len = name.length();
            for(int i=0;i<len;i++){
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }

        public static synchronized void output3(String name){
            int len = name.length();
            for(int i=0;i<len;i++){
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }
}
