package Test_i;

/**
 * Created by yinxin on 17-7-24.
 */
public class JavaSynchronized {
    public static int i = 0;
    static synchronized void incre(){
        ++i;
    }
    public static void main(String args[]) throws InterruptedException {
        class NewThread extends Thread{
            public void run(){
                for(int j = 0; j < 1000000; ++j){
                    incre();
                }
            }
        }
        double start = System.currentTimeMillis();
        NewThread nt1 = new NewThread();
        NewThread nt2 = new NewThread();
        NewThread nt3 = new NewThread();
        nt1.start();
        nt2.start();
        nt3.start();
        nt1.join();
        nt2.join();
        nt3.join();
        double end = System.currentTimeMillis();
        System.out.println(i);
        System.out.println(end-start);
    }
}
