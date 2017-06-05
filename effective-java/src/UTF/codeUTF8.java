package UTF;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Created by 殷鑫 on 2017/5/31.
 */
public class codeUTF8 {
    public static void main(String[] args) {
        byte[] b = {-26, -75, -73};
        ByteBuffer bb = ByteBuffer.allocate(3);//分配3字节
        bb.put(b,0,3);
        bb.flip();
        CharBuffer cb = UTF_8.decode(bb);
        char c = cb.charAt(0);
        System.out.println(c);
    }
}
