package first;

/**
 * Created by 殷鑫 on 2017/1/30.
 */
public class TradionalThread {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(this.getName());
                }
            }
        };
        thread.start();//运行
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread1.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable ----的run方法");
            }
        }){
            @Override
            public void run() {
                System.out.println("thread ----的run方法");//执行这个
            }
        }.start();
    }
}
