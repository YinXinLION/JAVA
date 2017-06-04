package JavaSocket;

import java.io.*;
import java.net.Socket;

/**
 * Created by 殷鑫 on 2017/6/1.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket conn = new Socket("127.0.0.1",8080);
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
        bw.write("hello\n");
        bw.flush();
        String s = br.readLine();
        System.out.println();

        bw.write("world\n");
        bw.flush();
        s = br.readLine();
        System.out.println(s);

        br.close();
        bw.close();
        conn.close();
    }
}
