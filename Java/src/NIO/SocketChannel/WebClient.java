package NIO.SocketChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;

/**
 * Created by yinxin on 17-6-21.
 */
public class WebClient {
    public static void main(String[] args) {
        SocketChannel socketChannel = null;

        try {
            /*
            public static SocketChannel open() throws IOException {
                return SelectorProvider.provider().openSocketChannel();
            }
            */
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1",8000));
            ByteBuffer writeBuffer = ByteBuffer.allocate(128);
            writeBuffer.put("hello Lion".getBytes());

            writeBuffer.flip();
            socketChannel.write(writeBuffer);
            socketChannel.close();

        }catch (IOException e){

        }
    }
}
