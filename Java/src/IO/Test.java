package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by 殷鑫 on 2017/6/8.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("E:\\Git\\JAVA\\Java\\src\\JavaSocket\\Client.java"));
        byte buf[] = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(buf)) != -1){
//            System.out.println("asD");
            System.out.println(new String(buf,0,len));
        }
    }
}
