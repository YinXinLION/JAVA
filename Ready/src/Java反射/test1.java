package Java反射;

/**
 * Created by yinxin on 17-8-20.
 */
public class test1 {
    public static void main(String[] args) {
        try {
            //只能在程序运行时进行检查，如果不存在就会抛出ClassNotFoundException异常。
            Class clazz = Class.forName("com.lion");
        } catch (ClassNotFoundException e) {
            System.out.println("捕获了");

        }
    }
}
