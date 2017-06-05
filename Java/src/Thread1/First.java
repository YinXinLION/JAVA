package Thread1;

/**
 * Created by 殷鑫 on 2017/6/4.
 */
public class First {
    public int count = 0;

    public synchronized void incTotal() {
        count += 1;
    }

    public static void main(String[] args) throws Exception{
        First test = new First();

        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 5_000; i++) {
                    test.incTotal();
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                for (int i = 0; i < 5_000; i++) {
                    test.incTotal();
                }
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(test.count);
    }
}
