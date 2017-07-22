package JUC;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by yinxin on 17-7-22.
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N);
        for (int i = 0; i < N; i++) {
            new Player(cyclicBarrier).start();
        }

    }


}

class Player extends Thread {

    private CyclicBarrier cyclicBarrier;

    public Player(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long) (5000 * Math.random()));
            System.out.println(Thread.currentThread().getName() + "准备好了！");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 起跑！");//相对的起跑
    }
}
