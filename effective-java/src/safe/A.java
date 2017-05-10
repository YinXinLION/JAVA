package safe;

import java.io.Serializable;

/**
 * Created by 殷鑫 on 2017/3/16.
 */
public class A implements Serializable {
    private final int num;
    public A(int num) {
        System.out.println("Hello Mum");
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}