package test;

/**
 * Created by 殷鑫 on 2017/2/25.
 */
public class test {
    public static void main(String[] args) {
        Size size = Size.LARGE;
        System.out.println(size.toString());
        System.out.println(size.equals(Size.LARGE));
        System.out.println(size.name());
        System.out.println(size.ordinal());
        System.out.println(Size.valueOf("LARGE"));
    }
}
