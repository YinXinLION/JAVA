package fourth;

/**
 * Created by 殷鑫 on 2017/1/31.
 */
public class TraditionalThreadCommunication {
    public static void main(String[] args) throws InterruptedException {
        Business business = new Business();
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int j = 1; j < 50; j++) {
                            try {
                                business.sub();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        ).start();

        for (int j = 1; j <= 50; j++) {
            business.main();
        }

    }
}

class Business{
    private boolean flag = true;
    public synchronized void sub() throws InterruptedException {
        if (flag){
           this.wait();
        }
        for (int i = 1; i <= 10; i++) {
            System.out.println("sub 10");
        }
        flag = true;
        this.notify();

    }
    public synchronized  void main() throws InterruptedException {
        if (!flag){    //while相同 更好 ，能再次判断flag
           this.wait();
        }
        for (int i = 1; i <= 100; i++) {
            System.out.println("main 100");
        }
        flag = false;
        this.notify();
    }
}