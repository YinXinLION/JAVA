package NIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;

/**
 * Created by 殷鑫 on 2017/2/7.
 */
public class test {
    public static void main(String[] args) throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("1.txt","rw");
        FileChannel inChannel = aFile.getChannel();
        //先给buffer 分配内存，然后读到buffer，然后flip转换成read读完 clear
        //create buffer with capacity of 48 bytes
        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = inChannel.read(buf);//read into buffer
        while (bytesRead != -1){
            buf.flip(); //make buffer ready for read
            while (buf.hasRemaining()){
                System.out.print((char)buf.get());
            }
            buf.clear();//make buffer ready for writing
            bytesRead = inChannel.read(buf);
        }
        aFile.close();


    }
}
