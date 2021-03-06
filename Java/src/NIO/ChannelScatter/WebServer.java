package NIO.ChannelScatter;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by yinxin on 17-6-21.
 */
public class WebServer {
    public static void main(String[] args) {
        try {
            //通过静态工厂方法创建一个ServerSocketChannel
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //绑定使用 socket.bind
            serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1",8000));
            SocketChannel socketChannel = serverSocketChannel.accept();
            //分配
            ByteBuffer readBuffer = ByteBuffer.allocate(3);
            ByteBuffer buffer2 = ByteBuffer.allocate(100);
            ByteBuffer[] byteBuffers = {readBuffer,buffer2};
            socketChannel.read(byteBuffers);

            readBuffer.flip();//开始读
            buffer2.flip();
            while (readBuffer.hasRemaining()){
//                System.out.println("~~");
                System.out.println((char)readBuffer.get());
            }
            while (buffer2.hasRemaining()){
                System.out.println("~~"+(char)buffer2.get());
            }
            socketChannel.close();
            serverSocketChannel.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
