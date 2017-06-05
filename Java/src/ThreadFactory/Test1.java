package ThreadFactory;

/**
 * Created by 殷鑫 on 2017/6/5.
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadFactory myThreadFactory = new MyThreadFactory();
        Thread thread = myThreadFactory.newThread(new Runnable() {
            @Override
            public void run() {

                    for (int i = 0; i < 10000; i++){
                        System.out.println(i);
                    }
            }
        });
        thread.sleep(10000000);
        thread.start();
    }
}
