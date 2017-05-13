package Chapter2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
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

        }
    }

}
