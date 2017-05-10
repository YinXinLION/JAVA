package sumBinary;

/**
 * Created by 殷鑫 on 2017/4/3.
 */
public class ShutDownHook extends Thread{
    public static void main(String[] args){
        Runtime.getRuntime().addShutdownHook(new ShutDownHook());
        for(int i=0;i<10;i++){
            System.out.println("i="+i);
            if(i==4){
                System.exit(0);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void run(){
        System.out.println("hook shutdown!");
    }

}
