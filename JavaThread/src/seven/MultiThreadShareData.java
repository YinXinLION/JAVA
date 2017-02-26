package seven;

/**
 * Created by 殷鑫 on 2017/2/4.
 */
public class MultiThreadShareData {
    public static void main(String[] args) {
        ShareData1 shareData1 = new ShareData1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                shareData1.decrement();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                shareData1.increment();
            }
        }).start();


    }
}

class one implements Runnable{
    ShareData1 share;
    public one(ShareData1 share){
        this.share = share;
    }
    public void run(){

    }
}

class ShareData1 /*implements Runnable*/{
    private int j = 0;
    private int count = 100;
    public synchronized void increment(){
        j++;
    }
    public synchronized void decrement(){
        j--;
    }
}
