package DirectBuffer;

import java.nio.ByteBuffer;

/**
 * Created by yinxin on 17-7-17.
 */
public class Test1 {
    public static void main(String[] args) {
        ByteBuffer buf = ByteBuffer.allocateDirect(1024);
    }
}
