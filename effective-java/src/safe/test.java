package safe;

import sun.misc.Unsafe;

import static sun.misc.Unsafe.getUnsafe;

/**
 * Created by 殷鑫 on 2017/3/16.
 */
public class test {
    public static void main(String[] args) throws InstantiationException {
        Unsafe unsafe = getUnsafe();
        Class aClass = A.class;
        A a = (A) unsafe.allocateInstance(aClass);
    }


}
