package In;

/**
 * Created by yinxin on 17-7-25.
 */
public class Outer {
    //静态内部类只能访问外部类的类变量和类方法
    private static int shared = 100;
    public static class StaticInner{
        public void innerMethod(){
            System.out.println("inner "+shared);
            hello();
        }
    }
    public static void hello(){
        System.out.println("hello");
    }

    public void test(){
        StaticInner si = new StaticInner();
        si.innerMethod();
        Outer.StaticInner staticInner = new Outer.StaticInner();
        staticInner.innerMethod();
    }

    public static void main(String[] args) {
        new Outer().test();
    }
}
