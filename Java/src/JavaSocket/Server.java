package JavaSocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 殷鑫 on 2017/6/1.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss =new ServerSocket(8080);//服务端在8080端口开启
        Socket conn = ss.accept();
        //从网上读取数据
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        //从网上 写数据
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
        String s = br.readLine();
        while (s != null){
            System.out.println(s);
            bw.write(s.toUpperCase() + "\n");
            bw.flush();
            s = br.readLine();
        }
        br.close();
        bw.close();
        conn.close();

    }
}
