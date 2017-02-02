package fifth;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by 殷鑫 on 2017/2/1.
 */
public class ThreadScopeShareData {
    private static int data = 0;
    private static Map<Thread,Integer> threadData = new HashMap<Thread,Integer>();
    public static void main(String[] args){
        for (int i = 0; i < 2; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    data =  data + 1;
                    System.out.println(Thread.currentThread().getName() + "has put data: " +data );
//                    threadData.put(Thread.currentThread(),data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }


    }

    static class A{
        public void get(){
//            data = threadData.get(Thread.currentThread());
            System.out.println("A from"+Thread.currentThread().getName() + "has get data: " +data );
        }
    }
    static class B{
        public void get(){
//            data = threadData.get(Thread.currentThread());
            System.out.println("B from"+Thread.currentThread().getName() + "has get data: " +data );
        }
    }
}
