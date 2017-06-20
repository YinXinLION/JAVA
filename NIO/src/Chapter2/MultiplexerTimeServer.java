package Chapter2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/**
 * Created by 殷鑫 on 2017/5/13.
 */
public class MultiplexerTimeServer implements  Runnable{
    private Selector selector;//扫描器
    private ServerSocketChannel servChannel;//通道
    private volatile boolean stop;
    //初始化多路复用器，绑定监听端口
    public MultiplexerTimeServer(int port) {
        try {
            selector = Selector.open();
            servChannel = ServerSocketChannel.open();//监听客户端的连接，所有客户端连接的父管道
            servChannel.configureBlocking(false);//设置连接非阻塞
            servChannel.socket().bind(new InetSocketAddress(port), 1024);//绑定监听端口
            servChannel.register(selector, SelectionKey.OP_ACCEPT);//注册到Selector上，监听Accept事件
            System.out.println("The time server is start in port : "+ port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    public void stop(){
        this.stop = true;
    }

    @Override
    public void run() {
        while (!stop){
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key = null;
                while (it.hasNext()){
                    key = it.next();
                    it.remove();
                    try {
                        handleInput(key);
                    }catch (Exception e){
                        if (key != null){
                            key.cancel();
                            if (key.channel() != null){
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //stop = ture selector关闭
        //注册在上面的Channel和Pipe等资源自动注册并关闭，所以不需要重复释放资源
        if (selector != null){
            try {
                selector.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    //处理请求
    private void handleInput(SelectionKey key) throws IOException{
        if (key.isValid()){
            //如果有效处理新接入的请求信息
            if (key.isAcceptable()){
                ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);//非阻塞
                sc.register(selector,SelectionKey.OP_READ);
            }
            if (key.isReadable()){
                SocketChannel sc = (SocketChannel)key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(readBuffer);
                if (readBytes > 0){
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    System.out.println("The time server receive order : " + body);
                    String currentTime = "QUERY TIME ORDER"
                            .equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString()
                            : "BAD ORDER";
                    doWrite(sc, currentTime);
                }else if(readBytes < 0){
                    //对端链路关闭
                    key.channel();
                    sc.close();
                }else ;


            }

        }

    }

    private void doWrite(SocketChannel channel,String response) throws IOException {
        if (response != null && response.trim().length() > 0){
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);
        }
    }

}
