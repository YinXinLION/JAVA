package PIPE;

import org.omg.CORBA.PUBLIC_MEMBER;
import sun.dc.pr.PRError;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created by 殷鑫 on 2017/6/8.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();

        out.connect(in);
        Thread printThread = new Thread(new Print(in), "PrintThread");
        printThread.start();
        int receive = 0;
        while ((receive = System.in.read()) != -1){
            out.write(receive);
        }

        out.close();
    }
static class Print implements Runnable{
        private PipedReader in;
        public Print(PipedReader in){
            this.in = in;
        }

    @Override
    public void run() {
        int receive = 0;
        try {
            while ((receive = in.read())!= -1){
                System.out.println((char)receive);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

}
