package second;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 殷鑫 on 2017/1/30.
 */
//定时器
public class TraditionalTimerTest {
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("bomb!!!");
//            }
//        },10000,3000);
        //10s 每3s炸一下


//        class MyTimerTask extends TimerTask{
//            @Override
//            public void run() {
//                System.out.println("bomb");
//                new Timer().schedule(new MyTimerTask(),2000);
//            }
//        }

        //2s炸一次 4s炸一次 2s炸一次 4s扎意思循环

        class MyTimerTask extends TimerTask{

            @Override
            public void run() {
                count = (count ) %2;
                count++;
                System.out.println("bomb");
                new Timer().schedule(new MyTimerTask(),2000*count);
            }
        }
        new Timer().schedule(new MyTimerTask(),2000);//连环炸弹


        while (true){
            System.out.println(new Date());
            Thread.sleep(1000);
        }
    }
}
