package NIO.BlockSyn;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Random;

/**
 * Created by yinxin on 17-6-22.
 */
public class EpollClient {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1",8000));

            ByteBuffer writeBuffer = ByteBuffer.allocate(32);
            ByteBuffer readBuffer = ByteBuffer.allocate(32);
            byte[] buf = new byte[32];
            Random r = new Random();
            int d = 0;

            d = r.nextInt(1000);
            System.out.println(d);
            //发送随机数
            writeBuffer.put(String.valueOf(d).getBytes());
            writeBuffer.flip();
            socketChannel.write(writeBuffer);
            //阻塞等待读
            socketChannel.read(readBuffer);
            readBuffer.flip();
            System.out.println(new String(readBuffer.array()));

            //休眠
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            writeBuffer.clear();
            d = r.nextInt();
            System.out.println(d);
            writeBuffer.put(String.valueOf(d).getBytes());
            writeBuffer.flip();
            socketChannel.write(writeBuffer);

            readBuffer.clear();
            socketChannel.read(readBuffer);
            readBuffer.flip();
            readBuffer.get(buf, 0, readBuffer.remaining());
            System.out.println(new String(buf));

            socketChannel.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
