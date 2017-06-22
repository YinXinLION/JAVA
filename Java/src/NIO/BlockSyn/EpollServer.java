package NIO.BlockSyn;

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
 * Created by yinxin on 17-6-22.
 */
public class EpollServer {
    public static void main(String[] args) {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress("127.0.0.1",8000));
            ssc.configureBlocking(false);

            Selector selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);

            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            ByteBuffer writeBuffer = ByteBuffer.allocate(128);
            writeBuffer.put("received".getBytes());
            writeBuffer.flip();

            while (true){
                int nReady = selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();

                while (it.hasNext()){
                    SelectionKey key = it.next();
                    it.remove();
                    if (key.isAcceptable()){
                        SocketChannel socketChannel = ssc.accept();
                        socketChannel.configureBlocking(false);
                        SelectionKey connectionKey = socketChannel.register(selector,SelectionKey.OP_READ);
                        connectionKey.attach(new EpollTask(socketChannel, connectionKey));
                    }else if (key.isReadable()){
                        SocketChannel socketChannel = (SocketChannel)key.channel();
                        readBuffer.clear();

                        socketChannel.read(readBuffer);
                        readBuffer.flip();
                        EpollTask conn = (EpollTask)key.attachment();
                        conn.onRead(getInt(readBuffer));
                        key.interestOps(SelectionKey.OP_WRITE);
                    }else if (key.isWritable()){
                        writeBuffer.rewind();
                        SocketChannel socketChannel = (SocketChannel)key.channel();

                        EpollTask conn = (EpollTask)key.attachment();
                        key.interestOps(SelectionKey.OP_READ);
                        conn.onWrite();
                    }
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static int getInt(ByteBuffer buffer){
        int r = 0;
        while (buffer.hasRemaining()){
            r *= 10;
            r += buffer.get() - '0';

        }
        return r;
    }
}
