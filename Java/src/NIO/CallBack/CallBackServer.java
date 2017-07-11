package NIO.CallBack;

import JavaSocket.Server;
import org.omg.CORBA.COMM_FAILURE;

import javax.management.StringValueExp;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by yinxin on 17-7-11.
 */
public class CallBackServer {
    public void run() throws Exception{
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1",8000));

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            selector.select();
            Iterator ite = selector.selectedKeys().iterator();

            while (ite.hasNext()){
                SelectionKey key = (SelectionKey)ite.next();
                if (key.isAcceptable()){
                    ServerSocketChannel s = (ServerSocketChannel)key.channel();
                    SocketChannel clientSocket = s.accept();
                    System.out.println("Got a new Connection");

                    clientSocket.configureBlocking(false);
                    SelectionKey newKey = clientSocket.register(selector, SelectionKey.OP_WRITE);
                    CommonClient client = new CommonClient(clientSocket, newKey);
                    newKey.attach(client);
                    System.out.println("client waiting");
                }else if (key.isReadable()){
                    CommonClient client = (CommonClient)key.attachment();
                    client.onRead();
                }else if (key.isWritable()){
                    CommonClient client = (CommonClient)key.attachment();
                    client.onWrite();
                }
                ite.remove();
            }

        }
    }

}

interface Callback{
    public void onSucceed(int data);
}

class CommonClient {
    private SocketChannel clientSocket;
    private ByteBuffer recvBuffer;
    private SelectionKey key;
    private Callback callback;

    private String msg;
    public CommonClient(SocketChannel clientSocket,SelectionKey key){
        this.clientSocket = clientSocket;
        this.key = key;
        recvBuffer = ByteBuffer.allocate(8);
        try {
            this.clientSocket.configureBlocking(false);
            key.interestOps(SelectionKey.OP_WRITE);
        }catch (IOException e){

        }
    }

    public void close(){
        try {
            clientSocket.close();
            key.cancel();
        }catch (IOException e){

        }
    }

    //唤醒客户端发送number
    public void sendMessage(String msg, Callback cback){
        this.callback = cback;
        try {
            try {
                recvBuffer.clear();
                recvBuffer.put(msg.getBytes());
                recvBuffer.flip();
                clientSocket.write(recvBuffer);//发送number

                key.interestOps(SelectionKey.OP_READ);//变为READ状态
            }catch (IOException e){
                e.printStackTrace();
            }
        }catch (Exception e){

        }
    }

    //当key为write，
    public void onWrite(){
        sendMessage("divident", new Callback() {
            @Override
            public void onSucceed(int data) {
                int a = data;
                sendMessage("divisor", new Callback() {
                    @Override
                    public void onSucceed(int data) {
                        int b = data;
                        sendMessage(String.valueOf(a/b),null);
                    }
                });
            }
        });
    }

    public void onRead(){
        int res = 0;
        try {
            try {
                recvBuffer.clear();

                int n = clientSocket.read(recvBuffer);
                while (n == 0){
                    n = clientSocket.read(recvBuffer);
                }
                if (n == -1){
                    close();return;
                }
                System.out.println("received " + n + " bytes from client");
            }catch (IOException e){
                e.printStackTrace();
            }
            recvBuffer.flip();
            res = getInt(recvBuffer);
            key.interestOps(SelectionKey.OP_WRITE);
        }catch (Exception e){
        }

        this.callback.onSucceed(res);
    }

    public int getInt(ByteBuffer buf){
        int r = 0;
        while (buf.hasRemaining()){
            r *= 10;
            while (buf.hasRemaining()){
                r *= 10;
                r += buf.get() - '0';
            }
            return r;
        }
    }
}
