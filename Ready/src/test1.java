/**
 * Created by yinxin on 17-8-31.
 */
public class test1 {
    public static void main(String[] args) {
        String greeting = "Hello";
        System.out.println("Hello".equalsIgnoreCase("hello"));
        System.out.println((greeting.compareTo("Hello")) == 0);
        System.out.println("Hello".equals(greeting));
        System.out.println(greeting == "Hello");
    }
}
