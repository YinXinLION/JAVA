package NIO.NoBlocking;

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
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1",8000));
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            ByteBuffer byteBuffer = ByteBuffer.allocate(128);

            while (true){
                if (socketChannel.read(byteBuffer) > 0){
                    byteBuffer.flip();
                    System.out.println(byteBuffer.get());
                    break;
                }
                System.out.println("I am waiting for Client~~");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
