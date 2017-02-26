package seven;



/**
 * Created by 殷鑫 on 2017/2/4.
 */
public class test1 {
    private int j = 0;

    public static void main(String[] args) {
        test1 te = new test1();
        A a = te.new A();
        B b = te.new B();
        for (int i = 0; i < 2; i++){
            new Thread(a).start();
            new Thread(b).start();
        }
    }

    private synchronized  void increment(){
        j++;

    }
    private synchronized  void decrement(){
        j--;
    }

    class A implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 100; i++){
                increment();
            }
        }
    }

    class B implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 100; i++){
                decrement();
            }
        }
    }
}
