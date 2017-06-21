package NIO.Epoll;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by yinxin on 17-6-21.
 */
public class EpollServer {
    public static void main(String[] args) {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress("127.0.0.1",8000));
            ssc.configureBlocking(false);

            Selector selector = Selector.open();
            //注册 channel
            ssc.register(selector, SelectionKey.OP_ACCEPT);

            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            ByteBuffer writeBuffer = ByteBuffer.allocate(128);
            writeBuffer.put("received".getBytes());
            writeBuffer.flip();

            while (true){
                int nReady  = selector.select();//阻塞线程
                //得到channel集合
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();

                while (it.hasNext()){
                    SelectionKey  key = it.next();
                    it.remove();
                    //判断是否时连接请求
                    if (key.isAcceptable()) {
                        //创建新的连接，并把连接注册到selector上，而且
                        //声明这个channel只对读感兴趣
                        SocketChannel socketChannel = ssc.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    }else if (key.isReadable()){
                        SocketChannel socketChannel = (SocketChannel)key.channel();
                        readBuffer.clear();
                        socketChannel.read(readBuffer);

                        readBuffer.flip();
                        System.out.println("Server received,"+new String(readBuffer.array()));
                        key.interestOps(SelectionKey.OP_WRITE);
                    }else if (key.isWritable()){
                        writeBuffer.rewind();
                        SocketChannel socketChannel = (SocketChannel)key.channel();
                        socketChannel.write(writeBuffer);
                        key.interestOps(SelectionKey.OP_READ);
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
