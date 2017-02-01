package third;

/**
 * Created by 殷鑫 on 2017/1/30.
 */
public class TraditionalThreadSynchronized {
    public static void main(String[] args) {
       new TraditionalThreadSynchronized().init();
    }

    public void init(){
        Outputer outputer = new Outputer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.output("zhangxiaoxiang");
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.output("yinxin");
                }

            }
        }).start();
    }

    static class Outputer{
        public  void output(String name){
            int len = name.length();
            synchronized(Outputer.class){
                for (int i = 0; i < len; i++){
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }
        }

        public synchronized void output1(String name){  //这个synchronized用的是this对象
            int len = name.length();
                for (int i = 0; i < len; i++){
                    System.out.print(name.charAt(i));
                }
                System.out.println();
        }

        public static synchronized  void output2(String name){  //这个synchronized用的.class对象
            int len = name.length();
            for (int i = 0; i < len; i++){
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }
}

